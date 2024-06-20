import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_personbo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*62673f01*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "personbo";
    }
    public String w_CONNES;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CONNES,context,"personbo","CONNES","C",16,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='CONNES' type='hidden' value="+SPLib.ToHTMLValue(w_CONNES,"C",16,0)+">" +
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
    armt_personboBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_personbo;
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
      status.w_CONNES = BO.w_CONNES;
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
    return "Persone Fisiche e Giuridiche";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_personbo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1109;
    l_eg.m_nEntityHeight = 827;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"personbo","intermbo","tbstati","tbcitta","tbcittna","tbstatna","tbtipdoc","tbstgru","tbramgru","tbtipatt","tbsetsin","personbo_agg","personbo","inter2bo","tbareegeog","tbareegeog_p","tbspecie","tbspecie_p","tbtipatt_p","tbcondotta","tbcondotta_p"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Base","page"),new ZoneItem("page_2","Operazioni ExtraConto","page"),new ZoneItem("page_3","A.U.I.","page"),new ZoneItem("page_4","Deleghe","page"),new ZoneItem("page_5","Provvisorie","page"),new ZoneItem("page_6","Titolarità","page"),new ZoneItem("page_7","Modifiche Anagrafiche","page"),new ZoneItem("page_8","Dati Supplementari","page"),new ZoneItem("page_9","FATCA/OCSE","page"),new ZoneItem("page_10","Dati Analisi Rischio","page"),new ZoneItem("page_11","Rilevazione Anomalie","page"),new ZoneItem("DatiBase","Dati Base + Residenza","horizontal_section"),new ZoneItem("PF","Solo Persona Fisica (Documento + Dati di Nascita)","horizontal_section"),new ZoneItem("AD","Altri Dati","horizontal_section"),new ZoneItem("GestoriContante","Gestori Contante","horizontal_section"),new ZoneItem("Operazioni","Operazioni","horizontal_section"),new ZoneItem("Frazionate","Frazionate","horizontal_section"),new ZoneItem("Rapporti","Rapporti","horizontal_section"),new ZoneItem("Rapporti","Rapporti","horizontal_section"),new ZoneItem("Operazioni","Operazioni","horizontal_section"),new ZoneItem("Frazionate","Frazionate","horizontal_section"),new ZoneItem("LegRap","Legale Rappresentante","horizontal_section"),new ZoneItem("DatiAgg","Dati Aggiuntivi","horizontal_section"),new ZoneItem("Dipendenza","Dipendenze Riferimento","horizontal_section"),new ZoneItem("SogCollegati","Soggetti Collegati","horizontal_section"),new ZoneItem("Fatc","Fatca/OCSE","horizontal_section"),new ZoneItem("CittaDiv","Cittadinanze e Residenza se diverse da Italia","horizontal_section"),new ZoneItem("ValRisk","Tipologia e Valutazione Rischio (III Direttiva)","horizontal_section"),new ZoneItem("MitRisk","Mitigazione Rischio","horizontal_section"),new ZoneItem("Patrimonio","Patrimonio","horizontal_section"),new ZoneItem("Reddito","Reddito","horizontal_section"),new ZoneItem("RilAnom","Rilevazione Anomalie","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CONNES"};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("gSeekAos","C",1,0, "hide","Collegamento con AOS"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("gFlgDoc","C",1,0, "hide","Collegamento con storico documenti"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("gVerSim","C",1,0, "hide","Verifica Semplificata"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("dataoggi","D",8,0, "hide",""),
                   new SPItem("TIPOPERS","C",1,0, "edit","Tipo Soggetto"),
                   new SPItem("COGNOME","C",26,0, "edit","Cognome"),
                   new SPItem("NOME","C",25,0, "edit","Nome"),
                   new SPItem("CFESTERO","N",1,0, "edit","Codice Fiscale Estero"),
                   new SPItem("RAGSOC","C",70,0, "edit","Ragione Sociale"),
                   new SPItem("PAESE","C",3,0, "edit","Stato"),
                   new SPItem("DESCCIT","C",30,0, "edit","Città"),
                   new SPItem("idcitta","C",40,0, "hide","Codice Città"),
                   new SPItem("PROVINCIA","C",2,0, "edit","Provincia"),
                   new SPItem("CAP","C",9,0, "edit","CAP"),
                   new SPItem("CODCAB","C",6,0, "edit","CAB"),
                   new SPItem("DOMICILIO","C",35,0, "edit","Indirizzo"),
                   new SPItem("IDENT","C",3,0, "edit","Identificazione"),
                   new SPItem("IDNASCOMUN","C",40,0, "edit","ID Comune Nascita"),
                   new SPItem("nascomunid","C",40,0, "hide",""),
                   new SPItem("NASCOMUN","C",30,0, "edit","Luogo di Nascita"),
                   new SPItem("TIPINTER","C",2,0, "edit","Prov."),
                   new SPItem("IDNASSTATO","C",10,0, "edit","ID Stato Nascita"),
                   new SPItem("nasstatoid","C",10,0, "hide",""),
                   new SPItem("NASSTATO","C",30,0, "edit","Stato di nascita"),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("DATANASC","D",8,0, "edit","Data Nascita"),
                   new SPItem("TIPODOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("NUMDOCUM","C",15,0, "edit","Numero Doc."),
                   new SPItem("DATARILASC","D",8,0, "edit","Data Rilascio Doc."),
                   new SPItem("DATAVALI","D",8,0, "edit",""),
                   new SPItem("AUTRILASC","C",30,0, "edit","Autorità di rilascio"),
                   new SPItem("CODFISC","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("PARTIVA","C",14,0, "edit","Partita IVA"),
                   new SPItem("CONTO","C",25,0, "edit","Contro Corrente se controparte"),
                   new SPItem("SOTGRUP","C",3,0, "edit","Sottogruppo Att. Ec."),
                   new SPItem("RAMOGRUP","C",3,0, "show","Ramo Gruppo Att. Ec."),
                   new SPItem("ATTIV","C",10,0, "edit","Codifica ATECO"),
                   new SPItem("SETTSINT","C",3,0, "edit","Settorizzazione UIC"),
                   new SPItem("CONNES","C",16,0, "edit","Codice Collegamento"),
                   new SPItem("NOSARA","C",1,0, "edit","Escludi operazioni soggetto da SARA"),
                   new SPItem("NOTIT","N",1,0, "edit","Non inviare titolare AGE"),
                   new SPItem("flgaggfam","C",1,0, "edit",""),
                   new SPItem("DATARETT","D",8,0, "edit",""),
                   new SPItem("STATOREG","C",1,0, "hide",""),
                   new SPItem("NUMPROG","C",7,0, "hide",""),
                   new SPItem("PROGIMPORT","N",15,0, "hide","Progressivo d'importazione"),
                   new SPItem("OLDSETSIN","C",3,0, "hide","Settore Sintetico su RAE"),
                   new SPItem("CRIMEDATE","D",8,0, "hide","Data Ultima Ricerca"),
                   new SPItem("PEPDATE","D",8,0, "hide","Ultime Ricerca PEP"),
                   new SPItem("tipsot","C",1,0, "hide","Tipo"),
                   new SPItem("DESCSGRU","C",60,0, "hide","Descrizione"),
                   new SPItem("DESCRAMGRU","C",70,0, "hide","Descrizione"),
                   new SPItem("DESCUIC","C",60,0, "hide","Descrizione"),
                   new SPItem("dessta","C",30,0, "hide","Descrizione"),
                   new SPItem("DESCRI","C",30,0, "hide","Descrizione"),
                   new SPItem("xstatonas","C",50,0, "hide",""),
                   new SPItem("finesae","D",8,0, "hide","Data Fine Validità"),
                   new SPItem("finesint","D",8,0, "hide","Data Fine Validità"),
                   new SPItem("xFLGVALIDO","C",1,0, "hide","Codice Fiscale Validato"),
                   new SPItem("xFLGANAVAL","C",1,0, "hide","Dati Anagrafici Validati"),
                   new SPItem("xDSETSIN","C",200,0, "hide","Descrizione"),
                   new SPItem("xdesctipatt","C",250,0, "hide","Descrizione"),
                   new SPItem("xdescareag","C",50,0, "hide","Descrizione"),
                   new SPItem("xdescnatgiu","C",60,0, "hide","Descrizione"),
                   new SPItem("xdesccomp","C",200,0, "hide","Descrizione"),
                   new SPItem("xITFLGPEP","C",1,0, "hide","Collegamento Liste PEP/Crime"),
                   new SPItem("DATAFINE","D",8,0, "edit","Non più cliente Dal"),
                   new SPItem("DATAINI","D",8,0, "edit","Cliente dal"),
                   new SPItem("DISATTIVO","D",8,0, "edit","Non più attivo dal"),
                   new SPItem("TIPOSOGGETTO","C",1,0, "edit","Tipo Soggetto"),
                   new SPItem("RAPSEGNA","C",1,0, "edit","Tipo Rapporto"),
                   new SPItem("SOGAFFIDATARIO","C",80,0, "edit","Affidatario Incarico"),
                   new SPItem("CAUSALE","N",5,0, "edit","Causale Default"),
                   new SPItem("FATTURATO","N",12,2, "edit","Fatturato"),
                   new SPItem("FLGNOTRIM","C",1,0, "edit",""),
                   new SPItem("DATAIDENT","D",8,0, "edit","Data Identificazione"),
                   new SPItem("COMPLETA","L",1,0, "edit",""),
                   new SPItem("CODINTER","C",11,0, "hide",""),
                   new SPItem("NUMIMP","T",14,0, "hide","Mark Importazione"),
                   new SPItem("CODDIPE","C",6,0, "hide",""),
                   new SPItem("SOSPMAF","C",1,0, "hide",""),
                   new SPItem("OLDCONNES","C",16,0, "hide",""),
                   new SPItem("DATEXTRA","D",8,0, "hide",""),
                   new SPItem("ALLINEATO","N",1,0, "hide","anagrafica allineata completa"),
                   new SPItem("ALLINEATONOMECNOME","N",1,0, "hide","Nome e cognome divisi correttamente"),
                   new SPItem("RAGSOCOLD","C",70,0, "hide","Vecchia Ragione Sociale"),
                   new SPItem("PROGIMP_C","C",15,0, "hide","Progressivo Import (Stringa)"),
                   new SPItem("IDFILE","C",60,0, "hide","Identificativo File"),
                   new SPItem("OLDCODFISC","C",20,0, "hide","Codice Fiscale Presente nel file"),
                   new SPItem("MACROAGENTE","C",5,0, "hide","Codice MacroAgente"),
                   new SPItem("SPOTID","C",16,0, "hide","SPOT ID (WUB)"),
                   new SPItem("DATAVARAGE","D",8,0, "hide","Data Variazione per Agenzia Entrate"),
                   new SPItem("SETTSINT2","C",3,0, "hide","Vecchio Settore Sintetico"),
                   new SPItem("TELEF","C",15,0, "hide","Soggetto è dichiarante di un'operazione canalizzata"),
                   new SPItem("TIPOORO","C",1,0, "hide","Tipo Intermediario"),
                   new SPItem("CODORO","C",11,0, "hide","Solo operatori in oro"),
                   new SPItem("FLGVALIDO","C",1,0, "hide",""),
                   new SPItem("DAC6","C",100,0, "hide",""),
                   new SPItem("ALTRODOM","C",35,0, "hide","Altro Domicilio"),
                   new SPItem("ALTROCAP","C",9,0, "hide","Altro CAP"),
                   new SPItem("IMPORTOMAX","N",12,2, "hide","Importo Massimale"),
                   new SPItem("FREQUENZA","C",1,0, "hide","Frequenza / Calendarizzazione"),
                   new SPItem("NUMOPERAZ","N",3,0, "hide","Numero Operazioni Attese"),
                   new SPItem("DATASIGN","D",8,0, "hide","Data Segnalazione a UIF"),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("FLAGDAC6","N",1,0, "hide",""),
                   new SPItem("CONNES","C",16,0, "hide",""),
                   new SPItem("NOTE","M",10,0, "edit","Note"),
                   new SPItem("CODLEGRAP","C",16,0, "edit","Legale Rappresentante"),
                   new SPItem("xRAGLEGRAP","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xIDLEGRAP","C",10,0, "hide","Chiave Primaria"),
                   new SPItem("ragbanben","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xDESDIPE","C",30,0, "hide","Descrizione"),
                   new SPItem("BANCABEN","C",11,0, "edit","Codice Banca se Beneficiario"),
                   new SPItem("DATASEGN","D",8,0, "edit","Data Segnalazione a UIF/BankIT"),
                   new SPItem("DATARAUT","D",8,0, "edit","Data Richiesta Autorità"),
                   new SPItem("FATCA","C",3,0, "edit","Stato Res. Legale FATCA"),
                   new SPItem("xdesfatca","C",40,0, "hide","Descrizione"),
                   new SPItem("TIN","C",16,0, "edit","Codice FATCA"),
                   new SPItem("ODB","N",1,0, "edit","Ordine di Bonifico Permanente"),
                   new SPItem("CITTADIN1","C",3,0, "edit","Cittadinanza 1"),
                   new SPItem("CITTADIN2","C",3,0, "edit",""),
                   new SPItem("RESFISC","C",3,0, "edit",""),
                   new SPItem("xDesCit1","C",40,0, "hide","Descrizione"),
                   new SPItem("xDesCit2","C",40,0, "hide","Descrizione"),
                   new SPItem("xResFis","C",40,0, "hide","Descrizione"),
                   new SPItem("AREAGEO","C",3,0, "edit",""),
                   new SPItem("AREAGEO","C",3,0, "show",""),
                   new SPItem("RAREA","N",3,0, "edit",""),
                   new SPItem("PKTBSPECIE","C",4,0, "edit",""),
                   new SPItem("PKTBSPECIE","C",4,0, "show",""),
                   new SPItem("RNATGIU","N",3,0, "edit",""),
                   new SPItem("ATTIVR","C",10,0, "edit","Codifica ATECO"),
                   new SPItem("ATTIV","C",10,0, "show",""),
                   new SPItem("RATTIV","N",3,0, "edit",""),
                   new SPItem("COMPORT","C",5,0, "edit",""),
                   new SPItem("COMPORT","C",5,0, "show",""),
                   new SPItem("RCOMP","N",3,0, "edit",""),
                   new SPItem("DOCFILE","C",100,0, "show",""),
                   new SPItem("RISGLOB","C",3,0, "edit","Rischio Globale"),
                   new SPItem("DATAPROF","D",8,0, "edit","Data Profilatura"),
                   new SPItem("DATAREVPROF","D",8,0, "show","Data Revisione Profilatura"),
                   new SPItem("PEP","C",1,0, "edit","Persona Politicamente Esposta"),
                   new SPItem("CRIME","C",1,0, "edit","Presente in liste Crime"),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITIGDOC","C",100,0, "edit","Documentazione Mitigazione"),
                   new SPItem("VERIFICA","C",1,0, "edit","Tipo Adeguata Verifica"),
                   new SPItem("FLGALTO","N",1,0, "hide","Attività ad alto rischio"),
                   new SPItem("NOTERIS","M",10,0, "edit","Note Rischio"),
                   new SPItem("status","C",10,0, "edit","")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(11);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_personboBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(11);
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
    l_translations=new String[][]{{"10001923009",p_Context.Translate("Premere il bottone per controllare il Soggetto")},
    {"10032163180",p_Context.Translate("Autorità di rilascio")},
    {"10034398626",p_Context.Translate("Codice Fiscale Errato")},
    {"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"10049460300",p_Context.Translate("Tipologia Rischio")},
    {"10061745855",p_Context.Translate("Dati Anagrafici Validati")},
    {"10079390723",p_Context.Translate("Confermi la modifica dei dati FATCA/OCSE ?")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10175904119",p_Context.Translate("ID Stato Nascita")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"10242518395",p_Context.Translate("Presente in liste Crime")},
    {"10252637878",p_Context.Translate("Data Profilatura")},
    {"10358848056",p_Context.Translate("Tipo rapporto non valido per il tipo soggetto selezionato!")},
    {"10390001687",p_Context.Translate("Ordine di Bonifico Permanente")},
    {"10412866585",p_Context.Translate("Causale Default")},
    {"10450770185",p_Context.Translate("Escludi operazioni soggetto da SARA")},
    {"10456253029",p_Context.Translate("Tipo Soggetto")},
    {"10500809751",p_Context.Translate("Rischio Globale")},
    {"10574890250",p_Context.Translate("Banche / Intermediari ")},
    {"10584469940",p_Context.Translate("Codice Fiscale Presente nel file")},
    {"10610113941",p_Context.Translate("La data di nascita deve essere inferiore della data odierna e superiore al 1900")},
    {"10642258888",p_Context.Translate("Data Variazione per Agenzia Entrate")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10700980442",p_Context.Translate("Nome e cognome divisi correttamente")},
    {"1081905483",p_Context.Translate("Vecchia Ragione Sociale")},
    {"10847120782",p_Context.Translate("Stampe Soggetto")},
    {"10937869104",p_Context.Translate("Stampa Scheda Adeguata Verifica")},
    {"10938145308",p_Context.Translate("Elenco Soggetti")},
    {"10943213487",p_Context.Translate("Mark Importazione")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"10985375045",p_Context.Translate("Cambio NDG Soggetto")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11067638693",p_Context.Translate("Data Identificazione")},
    {"11114044065",p_Context.Translate("%1-%2")},
    {"11132282623",p_Context.Translate("Data Richiesta Autorità")},
    {"1114794632",p_Context.Translate("Codice MacroAgente")},
    {"11148260655",p_Context.Translate("Data Revisione Profilatura")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11275255566",p_Context.Translate("E' necessario indicare l'NDG del soggetto")},
    {"11391158649",p_Context.Translate("Codice Banca se Beneficiario")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11401318146",p_Context.Translate("Altro Domicilio")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11466123579",p_Context.Translate("Fatturato")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11545837242",p_Context.Translate("Esenzione titolare effettivo ex art. 25 Dlgs. 231/2007")},
    {"11551158027",p_Context.Translate("Settore Sintetico su RAE")},
    {"11593637356",p_Context.Translate("Calcola la data di revisione della profilatura")},
    {"11627778853",p_Context.Translate("Importo Massimale")},
    {"11639044319",p_Context.Translate("Note Rischio")},
    {"11736469611",p_Context.Translate("Escludi da Estrazioni Trimestrali")},
    {"1176180209",p_Context.Translate("Attività ad alto rischio")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"117818419",p_Context.Translate("Comuni")},
    {"11788250491",p_Context.Translate("Presenza in liste CRIME")},
    {"11796047619",p_Context.Translate("Ricalcola il codice fiscale")},
    {"11806774252",p_Context.Translate("%1")},
    {"11815361151",p_Context.Translate("Legale Rappresentante")},
    {"11822582484",p_Context.Translate("Escludi le operazioni del soggetto da S.A.R.A.")},
    {"11837480615",p_Context.Translate("anagrafica allineata completa")},
    {"1185422679",p_Context.Translate("Progressivo d'importazione")},
    {"11875787422",p_Context.Translate("Sblocca modifica codice fiscale e dati anagrafici")},
    {"11898642491",p_Context.Translate("Chiave Primaria")},
    {"11909346815",p_Context.Translate("Codice ATECO non valido per il SAE selezionato!")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"11998370188",p_Context.Translate("Persone Fisiche e Giuridiche")},
    {"12034347084",p_Context.Translate("Codice FATCA")},
    {"12072460763",p_Context.Translate("Identificativo File")},
    {"12078005779",p_Context.Translate("Codice Fiscale Validato")},
    {"12084071743",p_Context.Translate("Ordine di bonifico permanente da/verso paese FATCA / OCSE")},
    {"12092824165",p_Context.Translate("Vecchio Settore Sintetico")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"12123678061",p_Context.Translate("Stati di Nascita")},
    {"1215993530",p_Context.Translate("%1")},
    {"1216938285",p_Context.Translate("Data Fine Validità")},
    {"1222840043",p_Context.Translate("SPOT ID (WUB)")},
    {"1225931194",p_Context.Translate("La data di rilascio del documento deve essere inferiore alla data di fine validità")},
    {"1251797647",p_Context.Translate("Verifica Semplificata")},
    {"1267255314",p_Context.Translate("Persona Esposta Politicamente")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1293397814",p_Context.Translate("Setto Sintetica UIC")},
    {"1296018956",p_Context.Translate("Codice Fiscale Assente per soggetto residente in ITALIA!")},
    {"1298954911",p_Context.Translate("Non è possibile selezionare il Settore Sintetico in quanto non più valido!")},
    {"130605954",p_Context.Translate("ramgru")},
    {"1390365716",p_Context.Translate("Cittadinanza 1")},
    {"1433836369",p_Context.Translate("Altro CAP")},
    {"1455978204",p_Context.Translate("Codice Città")},
    {"1513560829",p_Context.Translate("Persona Politicamente Esposta")},
    {"15186643",p_Context.Translate("Città")},
    {"1632660086",p_Context.Translate("Città Nascita")},
    {"1690077224",p_Context.Translate("Data Rilascio Doc.")},
    {"1715428852",p_Context.Translate("Contro Corrente se controparte")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"1729760413",p_Context.Translate("Tipo Adeguata Verifica")},
    {"1734932797",p_Context.Translate("Numero Doc.")},
    {"1735362560",p_Context.Translate("Non più attivo dal")},
    {"1756430089",p_Context.Translate("Partita IVA")},
    {"1767988220",p_Context.Translate("Identificazione")},
    {"1771998079",p_Context.Translate("Frequenza / Calendarizzazione")},
    {"18003",p_Context.Translate("CAB")},
    {"1801148975",p_Context.Translate("Data Ultima Ricerca")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1823814263",p_Context.Translate("Cliente dal")},
    {"1823975349",p_Context.Translate("Non più cliente Dal")},
    {"1832819699",p_Context.Translate("Ultime Ricerca PEP")},
    {"184789190",p_Context.Translate("Codice Fiscale non attribuito dall'Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attività in Italia)")},
    {"1893635209",p_Context.Translate("Data Segnalazione a UIF/BankIT")},
    {"1940073082",p_Context.Translate("Ricerca su Soggetti Segnalati")},
    {"200062287",p_Context.Translate("ID Comune Nascita")},
    {"2021305833",p_Context.Translate("Confermi il ricalcolo del settore sintetico?")},
    {"2029454149",p_Context.Translate("La data di inizio validità del documento deve essere inferiore o uguale alla data odierna e l'anno superiore al 1900")},
    {"2068738103",p_Context.Translate("Data Segnalazione a UIF")},
    {"2074500221",p_Context.Translate("Aggiornamento delle famiglie collegate")},
    {"2095911698",p_Context.Translate("Settorizzazione UIC")},
    {"210895516",p_Context.Translate("Documentazione Mitigazione")},
    {"2123849523",p_Context.Translate("Solo operatori in oro")},
    {"2134156131",p_Context.Translate("Codifica ATECO")},
    {"21587",p_Context.Translate("CAP")},
    {"225761093",p_Context.Translate("SAE non valido per soggetto non residente in Italia")},
    {"278277598",p_Context.Translate("La data di rilascio del documento deve essere superiore alla data di nascita")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"299426891",p_Context.Translate("Stato Res. Legale FATCA")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"327723579",p_Context.Translate("Non inviare titolare AGE")},
    {"3528304",p_Context.Translate("Prov.")},
    {"399857542",p_Context.Translate("SAE non valido per soggetto residente in Italia")},
    {"439891216",p_Context.Translate("Codice Collegamento")},
    {"443454",p_Context.Translate("Nome")},
    {"444398793",p_Context.Translate("Progressivo Import (Stringa)")},
    {"445246",p_Context.Translate("Note")},
    {"484567773",p_Context.Translate("Prevalente Attività")},
    {"485092",p_Context.Translate("Tipo")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"563275675",p_Context.Translate("%1-%2")},
    {"572399938",p_Context.Translate("Ramo Gruppo Att. Ec.")},
    {"611154211",p_Context.Translate("Sottogruppo Att. Ec.")},
    {"630057571",p_Context.Translate("Soggetto è dichiarante di un'operazione canalizzata")},
    {"640277248",p_Context.Translate("Confermi lo sblocco della modifica del Codice Fiscale e/o dei dati anagrafici?")},
    {"680687912",p_Context.Translate("Crea movimenti di variazione su Operazioni/Informazioni")},
    {"684715782",p_Context.Translate("Sottogruppi Att. Economiche")},
    {"7383187",p_Context.Translate("Stati")},
    {"7776403",p_Context.Translate("Stato")},
    {"7776675",p_Context.Translate("Sesso")},
    {"78498981",p_Context.Translate("Affidatario Incarico")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"927256775",p_Context.Translate("Numero Operazioni Attese")},
    {"967473515",p_Context.Translate("Ricalcola il settore sintetico")},
    {"974424382",p_Context.Translate("Collegamento Liste PEP/Crime")},
    {"984756930",p_Context.Translate("Tipo Intermediario")},
    {"989022526",p_Context.Translate("Non è possibile selezionare il Sottogruppo in quanto non più valido!")}};
    return l_translations;
  }
  void WriteStyles(armt_personboBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_personbo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_personboBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Operazioni ExtraConto"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("A.U.I."),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Deleghe"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Provvisorie"),"C",0,0)+"},{name:\"page_6\", element:\"page_6\", caption:"+SPLib.ToJSValue(status.context.Translate("Titolarità"),"C",0,0)+"},{name:\"page_7\", element:\"page_7\", caption:"+SPLib.ToJSValue(status.context.Translate("Modifiche Anagrafiche"),"C",0,0)+"},{name:\"page_8\", element:\"page_8\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Supplementari"),"C",0,0)+"},{name:\"page_9\", element:\"page_9\", caption:"+SPLib.ToJSValue(status.context.Translate("FATCA/OCSE"),"C",0,0)+"},{name:\"page_10\", element:\"page_10\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Analisi Rischio"),"C",0,0)+"},{name:\"page_11\", element:\"page_11\", caption:"+SPLib.ToJSValue(status.context.Translate("Rilevazione Anomalie"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_personbo',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_personbo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Opextrbo_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_SPRIZARLRS_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Rapporti_AUI_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_ITHLBNJDBB_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","D");
    return inclusionVars;
  }
  // GetPortlet_Operazioni_AUI_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_YGGYRKSULB_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","D");
    return inclusionVars;
  }
  // GetPortlet_Frazionate_AUI_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_TPNIPPCTXD_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","D");
    return inclusionVars;
  }
  // GetPortlet_Deleghe_AUI_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_NEBCWOJZLB_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_connes",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Deleghe_PRV_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_YCXLRKTFHB_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_connes",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Rapporti_Prv_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_YNCPFMWRMO_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","P");
    return inclusionVars;
  }
  // GetPortlet_Operazioni_Prv_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_PPJPQHWTQQ_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","P");
    return inclusionVars;
  }
  // GetPortlet_Frazionate_Prv_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_YWVSUWPJEY_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"fonte","P");
    return inclusionVars;
  }
  // GetPortlet_Titolari_AUI_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_FBHVHLBMPC_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Titolari_PRV_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_GTYEFDRRAU_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Storico_VAR_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_LSVOLXWIKA_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Storico_Ker_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_VXXDGFVFTG_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_CONNES",BO.w_CONNES);
    return inclusionVars;
  }
  // GetPortlet_Rilevazioni_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_VKUMQAHFDZ_Vars(armt_personboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"connes",BO.w_CONNES);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"status",BO.w_status);
    return inclusionVars;
  }
  void WriteControls(armt_personboBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    WriteControls_p6(BO,status);
    WriteControls_p7(BO,status);
    WriteControls_p8(BO,status);
    WriteControls_p9(BO,status);
    WriteControls_p10(BO,status);
    WriteControls_p11(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,12);
  }
  void WriteControls_p1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:827px;width:1109px;display:none'>" +
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
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Base");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:654px;width:1109px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Operazioni ExtraConto");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:716px;width:1109px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteControls_p3_b3(BO,status);
    WriteControls_p3_b4(BO,status);
    WriteControls_p3_b5(BO,status);
    WriteControls_p3_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"A.U.I.");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:649px;width:1109px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteControls_p4_b3(BO,status);
    WriteControls_p4_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Deleghe");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:716px;width:1109px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteControls_p5_b1(BO,status);
    WriteControls_p5_b2(BO,status);
    WriteControls_p5_b3(BO,status);
    WriteControls_p5_b4(BO,status);
    WriteControls_p5_b5(BO,status);
    WriteControls_p5_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Provvisorie");
    PrintSidebarContent(5,status,getSidebarItems(4),true);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_6' class='PageContainer' style='position:relative;height:737px;width:1109px;display:none'>" +
    "");
    WriteControls_p6_b0(BO,status);
    WriteControls_p6_b1(BO,status);
    WriteControls_p6_b2(BO,status);
    WriteControls_p6_b3(BO,status);
    WriteControls_p6_b4(BO,status);
    WriteControls_p6_b5(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,6,"Titolarità");
    PrintSidebarContent(6,status,getSidebarItems(5),true);
    PrintContextMenu(6,status,getContextMenu(5),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_7' class='PageContainer' style='position:relative;height:560px;width:1109px;display:none'>" +
    "");
    WriteControls_p7_b0(BO,status);
    WriteControls_p7_b1(BO,status);
    WriteControls_p7_b2(BO,status);
    WriteControls_p7_b3(BO,status);
    WriteControls_p7_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,7,"Modifiche Anagrafiche");
    PrintSidebarContent(7,status,getSidebarItems(6),true);
    PrintContextMenu(7,status,getContextMenu(6),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_8' class='PageContainer' style='position:relative;height:681px;width:1109px;display:none'>" +
    "");
    WriteControls_p8_b0(BO,status);
    WriteControls_p8_b1(BO,status);
    WriteControls_p8_b2(BO,status);
    WriteControls_p8_b3(BO,status);
    WriteControls_p8_b4(BO,status);
    WriteControls_p8_b5(BO,status);
    WriteControls_p8_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,8,"Dati Supplementari");
    PrintSidebarContent(8,status,getSidebarItems(7),true);
    PrintContextMenu(8,status,getContextMenu(7),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p9(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_9' class='PageContainer' style='position:relative;height:563px;width:1109px;display:none'>" +
    "");
    WriteControls_p9_b0(BO,status);
    WriteControls_p9_b1(BO,status);
    WriteControls_p9_b2(BO,status);
    WriteControls_p9_b3(BO,status);
    WriteControls_p9_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,9,"FATCA/OCSE");
    PrintSidebarContent(9,status,getSidebarItems(8),true);
    PrintContextMenu(9,status,getContextMenu(8),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p10(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_10' class='PageContainer' style='position:relative;height:465px;width:1109px;display:none'>" +
    "");
    WriteControls_p10_b0(BO,status);
    WriteControls_p10_b1(BO,status);
    WriteControls_p10_b2(BO,status);
    WriteControls_p10_b3(BO,status);
    WriteControls_p10_b4(BO,status);
    WriteControls_p10_b5(BO,status);
    WriteControls_p10_b6(BO,status);
    WriteControls_p10_b7(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,10,"Dati Analisi Rischio");
    PrintSidebarContent(10,status,getSidebarItems(9),true);
    PrintContextMenu(10,status,getContextMenu(9),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p11(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_11' class='PageContainer' style='position:relative;height:585px;width:1109px;display:none'>" +
    "");
    WriteControls_p11_b0(BO,status);
    WriteControls_p11_b1(BO,status);
    WriteControls_p11_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,11,"Rilevazione Anomalie");
    PrintSidebarContent(11,status,getSidebarItems(10),true);
    PrintContextMenu(11,status,getContextMenu(10),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiBase' id='AQSQVBKXAL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='AQSQVBKXAL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='AQSQVBKXAL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base + Residenza")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='AQSQVBKXAL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"AQSQVBKXAL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=AQSQVBKXAL_HEADER&m_cBoxId=AQSQVBKXAL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base + Residenza"))+"");
    }
    status.out.println(
     "<div id='AQSQVBKXAL' class='SectionBody' style='position:relative;height:238px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='AQSQVBKXAL_boxContent' style='position:relative;height:238px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<div class='"+status.ObligatoryClass("")+"' id='UYWIEUHCAL_DIV'>" +
       "<span id='UYWIEUHCAL_0_container'>" +
       "<input id='UYWIEUHCAL_0' name='UYWIEUHCAL' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_TIPOPERS))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='UYWIEUHCAL_0'>"+status.context.Translate("Persona Fisica")+"</label>" +
       "</span>" +
       "<span id='UYWIEUHCAL_1_container'>" +
       "<input id='UYWIEUHCAL_1' name='UYWIEUHCAL' type='radio' value="+SPLib.ToHTMLValue("G","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("G",CPLib.Trim(BO.w_TIPOPERS))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='UYWIEUHCAL_1'>"+status.context.Translate("Persona Giuridica")+"</label>" +
       "</span>" +
       "<span id='UYWIEUHCAL_2_container'>" +
       "<input id='UYWIEUHCAL_2' name='UYWIEUHCAL' type='radio' value="+SPLib.ToHTMLValue("I","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("I",CPLib.Trim(BO.w_TIPOPERS))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='UYWIEUHCAL_2'>"+status.context.Translate("Ditta Individuale")+"</label>" +
       "</span>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_HGVEMKOKYZ()' tabindex='"+status.m_nTabIndex+"' id='HGVEMKOKYZ_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='HGVEMKOKYZ' title="+SPLib.ToHTMLValue(status.context.Translate("Stampa Scheda Adeguata Verifica"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60166))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_BYFMKHYARA()' tabindex='"+status.m_nTabIndex+"' id='BYFMKHYARA_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='BYFMKHYARA' title="+SPLib.ToHTMLValue(status.context.Translate("Ricerca su Soggetti Segnalati"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60124))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_PAHSBQSDGU()' tabindex='"+status.m_nTabIndex+"' id='PAHSBQSDGU_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='PAHSBQSDGU' title="+SPLib.ToHTMLValue(status.context.Translate("Cambio NDG Soggetto"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59918))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_VVZBQJZQFF()' tabindex='"+status.m_nTabIndex+"' id='VVZBQJZQFF_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='VVZBQJZQFF' title="+SPLib.ToHTMLValue(status.context.Translate("Crea movimenti di variazione su Operazioni/Informazioni"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60289))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_GSYDJTTEZF()' tabindex='"+status.m_nTabIndex+"' id='GSYDJTTEZF_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='GSYDJTTEZF' title="+SPLib.ToHTMLValue(status.context.Translate("Sblocca modifica codice fiscale e dati anagrafici"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60321))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_VEHZFMLUPL()' tabindex='"+status.m_nTabIndex+"' id='VEHZFMLUPL_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='VEHZFMLUPL' title="+SPLib.ToHTMLValue(status.context.Translate("Stampe Soggetto"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60166))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COGNOME' id='TWTTDWKCRG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COGNOME,"C",26,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='26' size='26' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NOME' id='WWGIVGNUDW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NOME,"C",25,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZTHKEDVCO_DIV'>" +
       "<input name='CFESTERO' id='CZTHKEDVCO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CFESTERO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CFESTERO)?"CHECKED":"")+">" +
       "<label id='CZTHKEDVCO_LBL' for='CZTHKEDVCO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale non attribuito dall'Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attività in Italia)"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAGSOC' id='AWPNTOJIRR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGSOC,"C",70,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='YVIKEGPYPM' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YVIKEGPYPM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YVIKEGPYPM", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='ODAYKSRECA' type='text' class='"+status.ObligatoryClass("Field",BO.ODAYKSRECA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='ODAYKSRECA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ODAYKSRECA", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROVINCIA' id='NOTZPDMYIA' type='text' class='"+status.ObligatoryClass("Field",BO.NOTZPDMYIA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAP' id='RDAVOEETJG' type='text' class='"+status.ObligatoryClass("Field",BO.RDAVOEETJG_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODCAB' id='BOTAJBWHHY' type='text' class='"+status.ObligatoryClass("Field",BO.BOTAJBWHHY_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOMICILIO' id='VYLHWTRQNX' type='text' class='"+status.ObligatoryClass("Field",BO.VYLHWTRQNX_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='IDENT' id='IRLEJAUHCB' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='DFNZBCOVFH_DIV' style='display:none'>" +
       "<input name='flgaggfam' id='DFNZBCOVFH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgaggfam,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq("S",CPLib.Trim(BO.w_flgaggfam))?"CHECKED":"")+">" +
       "<label id='DFNZBCOVFH_LBL' for='DFNZBCOVFH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Aggiornamento delle famiglie collegate"))+"</label>" +
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
       "<span class='SPLabel' id='PFEQRACAUA_DIV'>" +
       "<label id='PFEQRACAUA'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.ne(BO.w_TIPOPERS,"G")?"Nominativo:":"Ragione Sociale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RZBLEGCFJJ_DIV'>" +
       "<label id='RZBLEGCFJJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato:"))+"" +
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
       "<span class='SPLabel' id='WHMXTGXWGC_DIV'>" +
       "<label id='WHMXTGXWGC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
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
       "<span class='SPLabel' id='ESVLUSNYWB_DIV'>" +
       "<label id='ESVLUSNYWB'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_dessta)+"" +
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
      status.out.println(
       "<span class='SPLabel' id='XYHCZSITMJ_DIV'>" +
       "<label id='XYHCZSITMJ' for='IRLEJAUHCB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Identificazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAIDENT' id='EVYVDDYVDZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAIDENT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='EVYVDDYVDZ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FPRDXPXSKH_DIV'>" +
       "<label id='FPRDXPXSKH' for='EVYVDDYVDZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Identificazione:"))+"" +
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
  void WriteControls_p1_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('AQSQVBKXAL').style.height='auto';");
    } else {
      status.out.println("Ctrl('AQSQVBKXAL').setAttribute('band_height',238);");
    }
    status.out.println("Ctrl('AQSQVBKXAL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_EWPTTWSBMT")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_EWPTTWSBMT' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_EWPTTWSBMT")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_EWPTTWSBMT').style.height='auto';");
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
  void WriteControls_p1_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='PF' id='EWPTTWSBMT_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EWPTTWSBMT_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EWPTTWSBMT_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Solo Persona Fisica (Documento + Dati di Nascita)")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EWPTTWSBMT_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EWPTTWSBMT\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EWPTTWSBMT_HEADER&m_cBoxId=EWPTTWSBMT&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Solo Persona Fisica (Documento + Dati di Nascita)"))+"");
    }
    status.out.println(
     "<div id='EWPTTWSBMT' class='SectionBody' style='position:relative;height:132px;display:block'>" +
    "");
    status.includeZoneAltInterface("PF@BEGIN");
    if (status.includeZoneAltInterface("PF")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PF@BEGIN") || status.HasZoneAltInterface("PF@END")) {
        status.out.println(
         "<div id='EWPTTWSBMT_boxContent' style='position:relative;height:132px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDNASCOMUN' id='BYPEBFEOAJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDNASCOMUN,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
       "<button id='BYPEBFEOAJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BYPEBFEOAJ", "tbcittna", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASCOMUN' id='NEUBQNUEOJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NASCOMUN,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TIPINTER' id='KPSCOABZLB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPINTER,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDNASSTATO' id='IOAMSFCCVV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDNASSTATO,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
       "<button id='IOAMSFCCVV_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "IOAMSFCCVV", "tbstatna", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASSTATO' id='HODZKKOSYW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NASSTATO,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SESSO' id='QPALJZMFCL' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_SESSO),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
       "<input name='DATANASC' id='XMGRWGFSFV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATANASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XMGRWGFSFV_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPODOC' id='MBGANUUHRA' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPODOC),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMDOCUM' id='HVEEMUJUUY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMDOCUM,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARILASC' id='XHWYGOPPUN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARILASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XHWYGOPPUN_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAVALI' id='BNWXBPSIDG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAVALI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='BNWXBPSIDG_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AUTRILASC' id='HRNCPADUFU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARETT' id='FROMUIZATY' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_DATARETT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='8' fieldtype='D' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVJSUIKYEY_DIV'>" +
       "<label id='WVJSUIKYEY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città di Nascita:"))+"" +
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
       "<span class='SPLabel' id='ZPQIEJPWJC_DIV'>" +
       "<label id='ZPQIEJPWJC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità di rilascio:"))+"" +
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
       "<span class='SPLabel' id='IVAWYVSUQI_DIV'>" +
       "<label id='IVAWYVSUQI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prov.:"))+"" +
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
       "<span class='SPLabel' id='ZBRDCBHLZC_DIV'>" +
       "<label id='ZBRDCBHLZC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("PF@BEGIN") || status.HasZoneAltInterface("PF@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("PF@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("PF")) {
      status.out.println("Ctrl('EWPTTWSBMT').style.height='auto';");
    } else {
      status.out.println("Ctrl('EWPTTWSBMT').setAttribute('band_height',132);");
    }
    status.out.println("Ctrl('EWPTTWSBMT').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_OQFTKYDCIW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_OQFTKYDCIW' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_OQFTKYDCIW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_OQFTKYDCIW').style.height='auto';");
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
  void WriteControls_p1_b5(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AD' id='OQFTKYDCIW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='OQFTKYDCIW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='OQFTKYDCIW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Altri Dati")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='OQFTKYDCIW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"OQFTKYDCIW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=OQFTKYDCIW_HEADER&m_cBoxId=OQFTKYDCIW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Altri Dati"))+"");
    }
    status.out.println(
     "<div id='OQFTKYDCIW' class='SectionBody' style='position:relative;height:208px;display:block'>" +
    "");
    status.includeZoneAltInterface("AD@BEGIN");
    if (status.includeZoneAltInterface("AD")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AD@BEGIN") || status.HasZoneAltInterface("AD@END")) {
        status.out.println(
         "<div id='OQFTKYDCIW_boxContent' style='position:relative;height:208px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODFISC' id='OJJHIUDPFY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODFISC,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_HCIJRBXGCX()' tabindex='"+status.m_nTabIndex+"' id='HCIJRBXGCX_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='HCIJRBXGCX' title="+SPLib.ToHTMLValue(status.context.Translate("Ricalcola il codice fiscale"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60231))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PARTIVA' id='FHXWUTBNKI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PARTIVA,"C",14,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='14' size='14' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONTO' id='JLTVZXPMKM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOTGRUP' id='LLYIGAMXRH' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1-%2",BO.w_SOTGRUP,BO.w_DESCSGRU),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<input name='RAMOGRUP' id='RVNHQCXNEM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_RAMOGRUP,"C",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ATTIV' id='SAQTIHOALW' type='text' class='"+status.ObligatoryClass("Field",BO.SAQTIHOALW_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_ATTIV,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Codifica ATECO"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
       "<button id='SAQTIHOALW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(status.context.Translate("Codifica ATECO"),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SAQTIHOALW", "tbtipatt", "armt_tbtipatt", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SETTSINT' id='ZGNLLSFQHC' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1-%2",BO.w_SETTSINT,BO.w_xDSETSIN),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_UQJBFPCIGV()' tabindex='"+status.m_nTabIndex+"' id='UQJBFPCIGV_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<span id='UQJBFPCIGV' title="+SPLib.ToHTMLValue(status.context.Translate("Ricalcola il settore sintetico"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59942))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNES' id='YTPWDRMFUS' type='text' class='"+status.ObligatoryClass("Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' value="+SPLib.ToHTMLValue(BO.w_CONNES,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XCYZDRXAMJ_DIV' style='display:none'>" +
       "<input name='NOSARA' id='XCYZDRXAMJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOSARA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_NOSARA))?"CHECKED":"")+">" +
       "<label id='XCYZDRXAMJ_LBL' for='XCYZDRXAMJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Escludi le operazioni del soggetto da S.A.R.A."))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RARXYHBSLM_DIV' style='display:none'>" +
       "<input name='NOTIT' id='RARXYHBSLM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOTIT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOTIT)?"CHECKED":"")+">" +
       "<label id='RARXYHBSLM_LBL' for='RARXYHBSLM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Esenzione titolare effettivo ex art. 25 Dlgs. 231/2007"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZZDCRCKYFX_DIV'>" +
       "<label id='ZZDCRCKYFX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo Att. Ec.:"))+"" +
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
       "<span class='SPLabel' id='QOLFDIWXXC_DIV'>" +
       "<label id='QOLFDIWXXC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ramo Gruppo Att. Ec.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHHLIWFNCK_DIV'>" +
       "<label id='LHHLIWFNCK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Settorizzazione UIF:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EKULYOXTJM_DIV'>" +
       "<label id='EKULYOXTJM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("NDG (Cod. Collegam.):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WRVDNZJCDE_DIV'>" +
       "<label id='WRVDNZJCDE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Partita IVA:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JCWRPFWYVW_DIV'>" +
       "<label id='JCWRPFWYVW'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DESCRAMGRU)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LRKNJREBPN_DIV'>" +
       "<label id='LRKNJREBPN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codifica ATECO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CPWCFGHBVH_DIV'>" +
       "<label id='CPWCFGHBVH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesctipatt)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHMWHZJZVJ_DIV'>" +
       "<label id='LHMWHZJZVJ' for='JLTVZXPMKM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Conto Corrente (IBAN) se controparte:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAFINE' id='YZOYIYAUUO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAFINE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='YZOYIYAUUO_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WWXBPXHXEU_DIV' style='display:none'>" +
       "<label id='WWXBPXHXEU' for='YZOYIYAUUO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Non più cliente Dal:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAINI' id='REJDXHTDMV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='REJDXHTDMV_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LOQXTBECEG_DIV' style='display:none'>" +
       "<label id='LOQXTBECEG' for='REJDXHTDMV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cliente Dal:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DISATTIVO' id='ODWJZUZDBK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DISATTIVO,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='ODWJZUZDBK_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PWDSDLHUNX_DIV' style='display:none'>" +
       "<label id='PWDSDLHUNX' for='ODWJZUZDBK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Non più attivo dal:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COMPLETA' id='BOHBZOSBVJ' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_COMPLETA,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='L' style='display:none'>" +
      "");
      if (status.HasZoneAltInterface("AD@BEGIN") || status.HasZoneAltInterface("AD@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AD@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("AD")) {
      status.out.println("Ctrl('OQFTKYDCIW').style.height='auto';");
    } else {
      status.out.println("Ctrl('OQFTKYDCIW').setAttribute('band_height',208);");
    }
    status.out.println("Ctrl('OQFTKYDCIW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_PUKLGLJKBW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_PUKLGLJKBW' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_PUKLGLJKBW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_PUKLGLJKBW').style.height='auto';");
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
  void WriteControls_p1_b7(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='GestoriContante' id='PUKLGLJKBW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='PUKLGLJKBW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='PUKLGLJKBW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Gestori Contante")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='PUKLGLJKBW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"PUKLGLJKBW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=PUKLGLJKBW_HEADER&m_cBoxId=PUKLGLJKBW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Gestori Contante"))+"");
    }
    status.out.println(
     "<div id='PUKLGLJKBW' class='SectionBody' style='position:relative;height:154px;display:block'>" +
    "");
    status.includeZoneAltInterface("GestoriContante@BEGIN");
    if (status.includeZoneAltInterface("GestoriContante")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("GestoriContante@BEGIN") || status.HasZoneAltInterface("GestoriContante@END")) {
        status.out.println(
         "<div id='PUKLGLJKBW_boxContent' style='position:relative;height:154px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='PKXIGUDYJJ_DIV'>" +
       "<label id='PKXIGUDYJJ' for='JJETXTUKNC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Soggetto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOSOGGETTO' id='JJETXTUKNC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("a","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("a",CPLib.Trim(BO.w_TIPOSOGGETTO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Dipendenze bancarie e postali")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("b","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("b",CPLib.Trim(BO.w_TIPOSOGGETTO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sale conta del medesimo operatore o di altri operatori")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("c","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("c",CPLib.Trim(BO.w_TIPOSOGGETTO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Punti serviti della \u201cgrande distribuzione organizzata\u201d (GDO)")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("d","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("d",CPLib.Trim(BO.w_TIPOSOGGETTO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Punti serviti di clienti non rientranti fra quelli individuati al punto precedente (altri)")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('JJETXTUKNC'),w_TIPOSOGGETTO,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MASICCONRV_DIV'>" +
       "<label id='MASICCONRV' for='JFJPGOWVYJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='RAPSEGNA' id='JFJPGOWVYJ' class='"+status.ObligatoryClass("Combobox",BO.JFJPGOWVYJ_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_RAPSEGNA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cliente Diretto")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_RAPSEGNA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cliente acquisito tramite un network CIT")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_RAPSEGNA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cliente acquisito tramite un network non CIT")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_RAPSEGNA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Soggetto Servito")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('JFJPGOWVYJ'),w_RAPSEGNA,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOGAFFIDATARIO' id='HKQDVAPIOQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOGAFFIDATARIO,"C",80,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CAUSALE' id='EMSGWJAYYK' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ULEYNEIGRT_DIV'>" +
       "<label id='ULEYNEIGRT' for='EMSGWJAYYK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Causale Default:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='FATTURATO' id='XOROAVXTCD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_FATTURATO,"N",12,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='13' size='12' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZBWPHEDKDN_DIV'>" +
       "<label id='ZBWPHEDKDN' for='XOROAVXTCD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Fatturato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EELMPIGUVH_DIV'>" +
       "<label id='EELMPIGUVH' for='HKQDVAPIOQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Affidatario Incarico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XERWNYQDBZ_DIV'>" +
       "<input name='FLGNOTRIM' id='XERWNYQDBZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGNOTRIM,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGNOTRIM))?"CHECKED":"")+">" +
       "<label id='XERWNYQDBZ_LBL' for='XERWNYQDBZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Escludi da Estrazioni Trimestrali"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("GestoriContante@BEGIN") || status.HasZoneAltInterface("GestoriContante@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("GestoriContante@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("GestoriContante")) {
      status.out.println("Ctrl('PUKLGLJKBW').style.height='auto';");
    } else {
      status.out.println("Ctrl('PUKLGLJKBW').setAttribute('band_height',154);");
    }
    status.out.println("Ctrl('PUKLGLJKBW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_0' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='SPRIZARLRS'>" +
    "");
    // GetPortlet_Opextrbo_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_SPRIZARLRS;
    inclusionVars_SPRIZARLRS = GetPortlet_SPRIZARLRS_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_SPRIZARLRS);
    String portletUID_SPRIZARLRS = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_opextrbo_portlet.jsp?ForcedPortletUID="+ portletUID_SPRIZARLRS+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_SPRIZARLRS),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.SPRIZARLRS='"+portletUID_SPRIZARLRS+"';" +
     "w_Opextrbo=ZtVWeb.getPortletById('"+portletUID_SPRIZARLRS+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_2' style='position:relative;height:144px;display:block' page='2'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='NOTE' id='UMKFMWBVUO' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GXTICCPRBI_DIV'>" +
       "<label id='GXTICCPRBI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Note:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p3_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_3_AUI_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='Rapporti' id='XDVUUVRZLV_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_3_AUI'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_3_AUI = new Z.Tabs({container:'tabs_3_AUI_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_3_AUI',tabs_3_AUI);");
    status.out.println("var l_nXDVUUVRZLVTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='XDVUUVRZLV' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Rapporti@BEGIN");
    if (status.includeZoneAltInterface("Rapporti")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Rapporti@BEGIN") || status.HasZoneAltInterface("Rapporti@END")) {
        status.out.println(
         "<div id='XDVUUVRZLV_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b1_b0(BO,status);
      WriteControls_p3_b1_b1(BO,status);
      WriteControls_p3_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['XDVUUVRZLV']=['band_3_0','band_3_14','band_3_623'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Rapporti@BEGIN") || status.HasZoneAltInterface("Rapporti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Rapporti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('XDVUUVRZLV').setAttribute('status','open');");
    status.out.println("tabs_3_AUI.AddTab({name:\"XDVUUVRZLV\", element:\"XDVUUVRZLV_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Rapporti"),"C",0,0)+",tabIndex: l_nXDVUUVRZLVTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('XDVUUVRZLV',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('XDVUUVRZLV',false,true,false)}});");
    status.out.println("if (tabs_3_AUI.CanCollapse()) {");
    status.out.println("tabs_3_AUI.Expand('XDVUUVRZLV');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_3',tabs_3_AUI.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b1_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_0' style='position:relative;height:14px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_14' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='ITHLBNJDBB'>" +
    "");
    // GetPortlet_Rapporti_AUI_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_ITHLBNJDBB;
    inclusionVars_ITHLBNJDBB = GetPortlet_ITHLBNJDBB_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_ITHLBNJDBB);
    String portletUID_ITHLBNJDBB = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_anarapbo_portlet.jsp?ForcedPortletUID="+ portletUID_ITHLBNJDBB+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_ITHLBNJDBB),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.ITHLBNJDBB='"+portletUID_ITHLBNJDBB+"';" +
     "w_Rapporti_AUI=ZtVWeb.getPortletById('"+portletUID_ITHLBNJDBB+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_623' style='position:relative;height:14px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_VECIWQFMOB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_VECIWQFMOB' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_VECIWQFMOB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_VECIWQFMOB').style.height='auto';");
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
  void WriteControls_p3_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Operazioni' id='VECIWQFMOB_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_3_AUI'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nVECIWQFMOBTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='VECIWQFMOB' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("Operazioni@BEGIN");
    if (status.includeZoneAltInterface("Operazioni")) {
      WriteControls_p3_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazioni@BEGIN") || status.HasZoneAltInterface("Operazioni@END")) {
        status.out.println(
         "<div id='VECIWQFMOB_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['VECIWQFMOB']=['band_3_644','band_3_651','band_3_1271'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Operazioni@BEGIN") || status.HasZoneAltInterface("Operazioni@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b3_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Operazioni@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('VECIWQFMOB').setAttribute('status','close');");
    status.out.println("tabs_3_AUI.AddTab({name:\"VECIWQFMOB\", element:\"VECIWQFMOB_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Operazioni"),"C",0,0)+",tabIndex: l_nVECIWQFMOBTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('VECIWQFMOB',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('VECIWQFMOB',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_3',tabs_3_AUI.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b3_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_644' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b3_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_651' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='YGGYRKSULB'>" +
    "");
    // GetPortlet_Operazioni_AUI_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_YGGYRKSULB;
    inclusionVars_YGGYRKSULB = GetPortlet_YGGYRKSULB_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_YGGYRKSULB);
    String portletUID_YGGYRKSULB = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_operazbo_portlet.jsp?ForcedPortletUID="+ portletUID_YGGYRKSULB+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_YGGYRKSULB),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.YGGYRKSULB='"+portletUID_YGGYRKSULB+"';" +
     "w_Operazioni_AUI=ZtVWeb.getPortletById('"+portletUID_YGGYRKSULB+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b3_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_1271' style='position:relative;height:10px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b4(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_WXIRJORZUM")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_WXIRJORZUM' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_WXIRJORZUM")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_WXIRJORZUM').style.height='auto';");
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
  void WriteControls_p3_b5(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Frazionate' id='WXIRJORZUM_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_3_AUI'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nWXIRJORZUMTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='WXIRJORZUM' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("Frazionate@BEGIN");
    if (status.includeZoneAltInterface("Frazionate")) {
      WriteControls_p3_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Frazionate@BEGIN") || status.HasZoneAltInterface("Frazionate@END")) {
        status.out.println(
         "<div id='WXIRJORZUM_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['WXIRJORZUM']=['band_3_1288','band_3_1295','band_3_1912'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Frazionate@BEGIN") || status.HasZoneAltInterface("Frazionate@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b5_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Frazionate@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('WXIRJORZUM').setAttribute('status','close');");
    status.out.println("tabs_3_AUI.AddTab({name:\"WXIRJORZUM\", element:\"WXIRJORZUM_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Frazionate"),"C",0,0)+",tabIndex: l_nWXIRJORZUMTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('WXIRJORZUM',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('WXIRJORZUM',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_3',tabs_3_AUI.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"AUI",3);
  }
  void WriteControls_p3_b5_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_1288' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b5_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_1295' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='TPNIPPCTXD'>" +
    "");
    // GetPortlet_Frazionate_AUI_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_TPNIPPCTXD;
    inclusionVars_TPNIPPCTXD = GetPortlet_TPNIPPCTXD_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_TPNIPPCTXD);
    String portletUID_TPNIPPCTXD = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_fraziobo_portlet.jsp?ForcedPortletUID="+ portletUID_TPNIPPCTXD+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_TPNIPPCTXD),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.TPNIPPCTXD='"+portletUID_TPNIPPCTXD+"';" +
     "w_Frazionate_AUI=ZtVWeb.getPortletById('"+portletUID_TPNIPPCTXD+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b5_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_1912' style='position:relative;height:13px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b6(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p4_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p4_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_0' style='position:relative;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='NEBCWOJZLB'>" +
    "");
    // GetPortlet_Deleghe_AUI_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_NEBCWOJZLB;
    inclusionVars_NEBCWOJZLB = GetPortlet_NEBCWOJZLB_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_NEBCWOJZLB);
    String portletUID_NEBCWOJZLB = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_connes_delegabo_portlet.jsp?ForcedPortletUID="+ portletUID_NEBCWOJZLB+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_NEBCWOJZLB),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.NEBCWOJZLB='"+portletUID_NEBCWOJZLB+"';" +
     "w_Deleghe_AUI=ZtVWeb.getPortletById('"+portletUID_NEBCWOJZLB+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YCXLRKTFHB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YCXLRKTFHB' style='position:relative;height:2px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YCXLRKTFHB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YCXLRKTFHB').style.height='auto';");
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
  void WriteControls_p4_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_303' style='position:relative;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='YCXLRKTFHB'>" +
    "");
    // GetPortlet_Deleghe_PRV_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_YCXLRKTFHB;
    inclusionVars_YCXLRKTFHB = GetPortlet_YCXLRKTFHB_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_YCXLRKTFHB);
    String portletUID_YCXLRKTFHB = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_connes_xelegabo_portlet.jsp?ForcedPortletUID="+ portletUID_YCXLRKTFHB+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_YCXLRKTFHB),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.YCXLRKTFHB='"+portletUID_YCXLRKTFHB+"';" +
     "w_Deleghe_PRV=ZtVWeb.getPortletById('"+portletUID_YCXLRKTFHB+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b4(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p5_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p5_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_5_Provvisorie_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='Rapporti' id='YVPVOYKMZA_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_5_Provvisorie'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_5_Provvisorie = new Z.Tabs({container:'tabs_5_Provvisorie_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_5_Provvisorie',tabs_5_Provvisorie);");
    status.out.println("var l_nYVPVOYKMZATabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='YVPVOYKMZA' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Rapporti@BEGIN");
    if (status.includeZoneAltInterface("Rapporti")) {
      WriteControls_p5_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Rapporti@BEGIN") || status.HasZoneAltInterface("Rapporti@END")) {
        status.out.println(
         "<div id='YVPVOYKMZA_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p5_b1_b0(BO,status);
      WriteControls_p5_b1_b1(BO,status);
      WriteControls_p5_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['YVPVOYKMZA']=['band_5_0','band_5_14','band_5_623'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Rapporti@BEGIN") || status.HasZoneAltInterface("Rapporti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Rapporti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('YVPVOYKMZA').setAttribute('status','open');");
    status.out.println("tabs_5_Provvisorie.AddTab({name:\"YVPVOYKMZA\", element:\"YVPVOYKMZA_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Rapporti"),"C",0,0)+",tabIndex: l_nYVPVOYKMZATabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('YVPVOYKMZA',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('YVPVOYKMZA',false,true,false)}});");
    status.out.println("if (tabs_5_Provvisorie.CanCollapse()) {");
    status.out.println("tabs_5_Provvisorie.Expand('YVPVOYKMZA');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_5',tabs_5_Provvisorie.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b1_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_0' style='position:relative;height:14px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b1_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_14' style='position:relative;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='YNCPFMWRMO'>" +
    "");
    // GetPortlet_Rapporti_Prv_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_YNCPFMWRMO;
    inclusionVars_YNCPFMWRMO = GetPortlet_YNCPFMWRMO_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_YNCPFMWRMO);
    String portletUID_YNCPFMWRMO = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_anarapbo_portlet.jsp?ForcedPortletUID="+ portletUID_YNCPFMWRMO+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_YNCPFMWRMO),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.YNCPFMWRMO='"+portletUID_YNCPFMWRMO+"';" +
     "w_Rapporti_Prv=ZtVWeb.getPortletById('"+portletUID_YNCPFMWRMO+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b1_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_623' style='position:relative;height:14px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MTHMFUOOBG")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MTHMFUOOBG' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MTHMFUOOBG")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MTHMFUOOBG').style.height='auto';");
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
  void WriteControls_p5_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Operazioni' id='MTHMFUOOBG_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_5_Provvisorie'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nMTHMFUOOBGTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='MTHMFUOOBG' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("Operazioni@BEGIN");
    if (status.includeZoneAltInterface("Operazioni")) {
      WriteControls_p5_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazioni@BEGIN") || status.HasZoneAltInterface("Operazioni@END")) {
        status.out.println(
         "<div id='MTHMFUOOBG_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['MTHMFUOOBG']=['band_5_644','band_5_651','band_5_1271'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Operazioni@BEGIN") || status.HasZoneAltInterface("Operazioni@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b3_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Operazioni@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('MTHMFUOOBG').setAttribute('status','close');");
    status.out.println("tabs_5_Provvisorie.AddTab({name:\"MTHMFUOOBG\", element:\"MTHMFUOOBG_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Operazioni"),"C",0,0)+",tabIndex: l_nMTHMFUOOBGTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('MTHMFUOOBG',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('MTHMFUOOBG',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_5',tabs_5_Provvisorie.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b3_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_644' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b3_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_651' style='position:relative;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='PPJPQHWTQQ'>" +
    "");
    // GetPortlet_Operazioni_Prv_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_PPJPQHWTQQ;
    inclusionVars_PPJPQHWTQQ = GetPortlet_PPJPQHWTQQ_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_PPJPQHWTQQ);
    String portletUID_PPJPQHWTQQ = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_operazbo_portlet.jsp?ForcedPortletUID="+ portletUID_PPJPQHWTQQ+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_PPJPQHWTQQ),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.PPJPQHWTQQ='"+portletUID_PPJPQHWTQQ+"';" +
     "w_Operazioni_Prv=ZtVWeb.getPortletById('"+portletUID_PPJPQHWTQQ+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b3_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_1271' style='position:relative;height:10px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b4(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_WVUNPTQGCF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_WVUNPTQGCF' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_WVUNPTQGCF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_WVUNPTQGCF').style.height='auto';");
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
  void WriteControls_p5_b5(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Frazionate' id='WVUNPTQGCF_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_5_Provvisorie'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nWVUNPTQGCFTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='WVUNPTQGCF' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("Frazionate@BEGIN");
    if (status.includeZoneAltInterface("Frazionate")) {
      WriteControls_p5_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Frazionate@BEGIN") || status.HasZoneAltInterface("Frazionate@END")) {
        status.out.println(
         "<div id='WVUNPTQGCF_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p5_b5_b0(BO,status);
      WriteControls_p5_b5_b1(BO,status);
      WriteControls_p5_b5_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['WVUNPTQGCF']=['band_5_1288','band_5_1295','band_5_1912'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Frazionate@BEGIN") || status.HasZoneAltInterface("Frazionate@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b5_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Frazionate@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('WVUNPTQGCF').setAttribute('status','close');");
    status.out.println("tabs_5_Provvisorie.AddTab({name:\"WVUNPTQGCF\", element:\"WVUNPTQGCF_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Frazionate"),"C",0,0)+",tabIndex: l_nWVUNPTQGCFTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('WVUNPTQGCF',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('WVUNPTQGCF',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_5',tabs_5_Provvisorie.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Provvisorie",5);
  }
  void WriteControls_p5_b5_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_1288' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b5_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_1295' style='position:relative;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='YWVSUWPJEY'>" +
    "");
    // GetPortlet_Frazionate_Prv_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_YWVSUWPJEY;
    inclusionVars_YWVSUWPJEY = GetPortlet_YWVSUWPJEY_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_YWVSUWPJEY);
    String portletUID_YWVSUWPJEY = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_fraziobo_portlet.jsp?ForcedPortletUID="+ portletUID_YWVSUWPJEY+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_YWVSUWPJEY),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.YWVSUWPJEY='"+portletUID_YWVSUWPJEY+"';" +
     "w_Frazionate_Prv=ZtVWeb.getPortletById('"+portletUID_YWVSUWPJEY+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b5_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_1912' style='position:relative;height:13px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b6(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p6_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p6_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='LegRap' id='HPGCEWAWGV_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HPGCEWAWGV_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HPGCEWAWGV_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Legale Rappresentante")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HPGCEWAWGV_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HPGCEWAWGV\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HPGCEWAWGV_HEADER&m_cBoxId=HPGCEWAWGV&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Legale Rappresentante"))+"");
    }
    status.out.println(
     "<div id='HPGCEWAWGV' class='SectionBody' style='position:relative;height:42px;display:block'>" +
    "");
    status.includeZoneAltInterface("LegRap@BEGIN");
    if (status.includeZoneAltInterface("LegRap")) {
      WriteControls_p6_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("LegRap@BEGIN") || status.HasZoneAltInterface("LegRap@END")) {
        status.out.println(
         "<div id='HPGCEWAWGV_boxContent' style='position:relative;height:42px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='LIYWMHOGYX_DIV'>" +
       "<label id='LIYWMHOGYX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xRAGLEGRAP)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODLEGRAP' id='CKHRNQSKKQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODLEGRAP,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='CKHRNQSKKQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CKHRNQSKKQ", "personbo", "opemt_personbo", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZAFNQMBDHV_DIV'>" +
       "<label id='ZAFNQMBDHV' for='CKHRNQSKKQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Legale Rappresentante:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("LegRap@BEGIN") || status.HasZoneAltInterface("LegRap@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("LegRap@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("LegRap")) {
      status.out.println("Ctrl('HPGCEWAWGV').style.height='auto';");
    } else {
      status.out.println("Ctrl('HPGCEWAWGV').setAttribute('band_height',42);");
    }
    status.out.println("Ctrl('HPGCEWAWGV').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_6_42' style='position:relative;display:block' page='6'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='FBHVHLBMPC'>" +
    "");
    // GetPortlet_Titolari_AUI_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_FBHVHLBMPC;
    inclusionVars_FBHVHLBMPC = GetPortlet_FBHVHLBMPC_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_FBHVHLBMPC);
    String portletUID_FBHVHLBMPC = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_rapotit_portlet.jsp?ForcedPortletUID="+ portletUID_FBHVHLBMPC+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_FBHVHLBMPC),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.FBHVHLBMPC='"+portletUID_FBHVHLBMPC+"';" +
     "w_Titolari_AUI=ZtVWeb.getPortletById('"+portletUID_FBHVHLBMPC+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6_b3(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GTYEFDRRAU")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GTYEFDRRAU' style='position:relative;height:2px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GTYEFDRRAU")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GTYEFDRRAU').style.height='auto';");
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
  void WriteControls_p6_b4(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_6_354' style='position:relative;display:block' page='6'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='GTYEFDRRAU'>" +
    "");
    // GetPortlet_Titolari_PRV_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_GTYEFDRRAU;
    inclusionVars_GTYEFDRRAU = GetPortlet_GTYEFDRRAU_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_GTYEFDRRAU);
    String portletUID_GTYEFDRRAU = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_xapotit_portlet.jsp?ForcedPortletUID="+ portletUID_GTYEFDRRAU+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_GTYEFDRRAU),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.GTYEFDRRAU='"+portletUID_GTYEFDRRAU+"';" +
     "w_Titolari_PRV=ZtVWeb.getPortletById('"+portletUID_GTYEFDRRAU+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6_b5(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p7_b0(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p7_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_7_0' style='position:relative;display:block' page='7'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='LSVOLXWIKA'>" +
    "");
    // GetPortlet_Storico_VAR_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_LSVOLXWIKA;
    inclusionVars_LSVOLXWIKA = GetPortlet_LSVOLXWIKA_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_LSVOLXWIKA);
    String portletUID_LSVOLXWIKA = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_wersonbo_portlet.jsp?ForcedPortletUID="+ portletUID_LSVOLXWIKA+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_LSVOLXWIKA),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.LSVOLXWIKA='"+portletUID_LSVOLXWIKA+"';" +
     "w_Storico_VAR=ZtVWeb.getPortletById('"+portletUID_LSVOLXWIKA+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_VXXDGFVFTG")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_VXXDGFVFTG' style='position:relative;height:3px;display:block' page='7'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_VXXDGFVFTG")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_VXXDGFVFTG').style.height='auto';");
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
  void WriteControls_p7_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_7_259' style='position:relative;display:block' page='7'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='VXXDGFVFTG'>" +
    "");
    // GetPortlet_Storico_Ker_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_VXXDGFVFTG;
    inclusionVars_VXXDGFVFTG = GetPortlet_VXXDGFVFTG_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_VXXDGFVFTG);
    String portletUID_VXXDGFVFTG = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_kersonbo_portlet.jsp?ForcedPortletUID="+ portletUID_VXXDGFVFTG+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_VXXDGFVFTG),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.VXXDGFVFTG='"+portletUID_VXXDGFVFTG+"';" +
     "w_Storico_Ker=ZtVWeb.getPortletById('"+portletUID_VXXDGFVFTG+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7_b4(armt_personboBO BO,ServletStatus status) {
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
  void WriteControls_p8_b0(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_8")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_8' style='position:relative;height:0px;display:none' page='8'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_8")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_8').style.height='auto';");
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
  void WriteControls_p8_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_8_Altri_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='DatiAgg' id='AYKUXGKLPO_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_8_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_8_Altri = new Z.Tabs({container:'tabs_8_Altri_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_8_Altri',tabs_8_Altri);");
    status.out.println("var l_nAYKUXGKLPOTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='AYKUXGKLPO' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiAgg@BEGIN");
    if (status.includeZoneAltInterface("DatiAgg")) {
      WriteControls_p8_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiAgg@BEGIN") || status.HasZoneAltInterface("DatiAgg@END")) {
        status.out.println(
         "<div id='AYKUXGKLPO_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p8_b1_b0(BO,status);
      WriteControls_p8_b1_b1(BO,status);
      WriteControls_p8_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['AYKUXGKLPO']=['band_8_0','band_8_7','band_8_511'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("DatiAgg@BEGIN") || status.HasZoneAltInterface("DatiAgg@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p8_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p8_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiAgg@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('AYKUXGKLPO').setAttribute('status','open');");
    status.out.println("tabs_8_Altri.AddTab({name:\"AYKUXGKLPO\", element:\"AYKUXGKLPO_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Aggiuntivi"),"C",0,0)+",tabIndex: l_nAYKUXGKLPOTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('AYKUXGKLPO',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('AYKUXGKLPO',false,true,false)}});");
    status.out.println("if (tabs_8_Altri.CanCollapse()) {");
    status.out.println("tabs_8_Altri.Expand('AYKUXGKLPO');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_8',tabs_8_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p8_b1_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_0' style='position:relative;height:7px;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8_b1_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_7' style='position:relative;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='armt_personbo_agg' id='OIREAEXNKZ' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_8_7']=['OIREAEXNKZ'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p8_b1_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_511' style='position:relative;height:88px;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='BANCABEN' id='DQZNJUSTLN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BANCABEN,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='DQZNJUSTLN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "DQZNJUSTLN", "inter2bo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VRPSNLYZFA_DIV'>" +
     "<label id='VRPSNLYZFA' for='DQZNJUSTLN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Banca se Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XHVCRZXJZF_DIV'>" +
     "<label id='XHVCRZXJZF'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_ragbanben)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATASEGN' id='ESODTMPIYO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATASEGN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='ESODTMPIYO_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KGAUNPQRUF_DIV'>" +
     "<label id='KGAUNPQRUF' for='ESODTMPIYO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Segnalazione a UIF/BankIT:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATARAUT' id='UNPDFRUOXO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARAUT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='UNPDFRUOXO_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WXAVWIXQLR_DIV'>" +
     "<label id='WXAVWIXQLR' for='UNPDFRUOXO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Richiesta Autorità:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ZETZWJBOFM")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ZETZWJBOFM' style='position:relative;height:10px;display:block' page='8'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_ZETZWJBOFM")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_ZETZWJBOFM').style.height='auto';");
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
  void WriteControls_p8_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Dipendenza' id='ZETZWJBOFM_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_8_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nZETZWJBOFMTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='ZETZWJBOFM' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("Dipendenza@BEGIN");
    if (status.includeZoneAltInterface("Dipendenza")) {
      WriteControls_p8_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Dipendenza@BEGIN") || status.HasZoneAltInterface("Dipendenza@END")) {
        status.out.println(
         "<div id='ZETZWJBOFM_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p8_b3_b0(BO,status);
      WriteControls_p8_b3_b1(BO,status);
      WriteControls_p8_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['ZETZWJBOFM']=['band_8_609','band_8_623','band_8_873'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Dipendenza@BEGIN") || status.HasZoneAltInterface("Dipendenza@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p8_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p8_b3_CloseBand(armt_personboBO BO,ServletStatus status) {
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
    status.out.println("Ctrl('ZETZWJBOFM').setAttribute('status','close');");
    status.out.println("tabs_8_Altri.AddTab({name:\"ZETZWJBOFM\", element:\"ZETZWJBOFM_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dipendenze Riferimento"),"C",0,0)+",tabIndex: l_nZETZWJBOFMTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('ZETZWJBOFM',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('ZETZWJBOFM',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_8',tabs_8_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p8_b3_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_609' style='position:relative;height:14px;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8_b3_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_623' style='position:relative;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_personbo_dip' id='BKKASVQSWO' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_8_623']=['BKKASVQSWO'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p8_b3_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_8_873' style='position:relative;height:16px;display:block' page='8'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8_b4(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_XDDGTPJDHN")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_XDDGTPJDHN' style='position:relative;height:7px;display:block' page='8'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_XDDGTPJDHN")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_XDDGTPJDHN').style.height='auto';");
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
  void WriteControls_p8_b5(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SogCollegati' id='XDDGTPJDHN_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_8_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nXDDGTPJDHNTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='XDDGTPJDHN' class='TabStripBoxBody' style='position:relative;height:212px;display:none'>" +
    "");
    status.includeZoneAltInterface("SogCollegati@BEGIN");
    if (status.includeZoneAltInterface("SogCollegati")) {
      WriteControls_p8_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SogCollegati@BEGIN") || status.HasZoneAltInterface("SogCollegati@END")) {
        status.out.println(
         "<div id='XDDGTPJDHN_boxContent' style='position:relative;height:212px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_soggope' id='RYYOFFRITV' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("SogCollegati@BEGIN") || status.HasZoneAltInterface("SogCollegati@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p8_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p8_b5_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SogCollegati@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("SogCollegati")) {
      status.out.println("Ctrl('XDDGTPJDHN').style.height='auto';");
    } else {
      status.out.println("Ctrl('XDDGTPJDHN').setAttribute('band_height',212);");
    }
    status.out.println("Ctrl('XDDGTPJDHN').setAttribute('status','close');");
    status.out.println("tabs_8_Altri.AddTab({name:\"XDDGTPJDHN\", element:\"XDDGTPJDHN_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Soggetti Collegati"),"C",0,0)+",tabIndex: l_nXDDGTPJDHNTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('XDDGTPJDHN',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('XDDGTPJDHN',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_8',tabs_8_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Altri",8);
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['XDDGTPJDHN']=['RYYOFFRITV'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p8_b6(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_8")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_8' style='position:relative;height:5px;display:block' page='8'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_8")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_8').style.height='auto';");
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
  void WriteControls_p9_b0(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_9")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_9' style='position:relative;height:7px;display:block' page='9'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_9")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_9').style.height='auto';");
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
  void WriteControls_p9_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Fatc' id='FIXFSIUKKN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='FIXFSIUKKN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='FIXFSIUKKN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Fatca/OCSE")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='FIXFSIUKKN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"FIXFSIUKKN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=FIXFSIUKKN_HEADER&m_cBoxId=FIXFSIUKKN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Fatca/OCSE"))+"");
    }
    status.out.println(
     "<div id='FIXFSIUKKN' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Fatc@BEGIN");
    if (status.includeZoneAltInterface("Fatc")) {
      WriteControls_p9_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Fatc@BEGIN") || status.HasZoneAltInterface("Fatc@END")) {
        status.out.println(
         "<div id='FIXFSIUKKN_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p9_b1_b0(BO,status);
      WriteControls_p9_b1_b1(BO,status);
      WriteControls_p9_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['FIXFSIUKKN']=['band_9_7','band_9_76','band_9_412'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Fatc@BEGIN") || status.HasZoneAltInterface("Fatc@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p9_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p9_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Fatc@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('FIXFSIUKKN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p9_b1_b0(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_9_7' style='position:relative;height:69px;display:block' page='9'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='FATCA' id='RKHMYOIJDM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_FATCA,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='RKHMYOIJDM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RKHMYOIJDM", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KSZOWVNAMH_DIV'>" +
     "<label id='KSZOWVNAMH' for='RKHMYOIJDM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Resid. Legale FATCA:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YJYXHNVCSS_DIV'>" +
     "<label id='YJYXHNVCSS'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesfatca)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TIN' id='HBSPPQBOJN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIN,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FAHIRFAJYI_DIV'>" +
     "<label id='FAHIRFAJYI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Identificat. fiscale rilasciato da paese FATCA / OCSE:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='EOYNWRHHMY_DIV'>" +
     "<input name='ODB' id='EOYNWRHHMY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ODB,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_ODB)?"CHECKED":"")+">" +
     "<label id='EOYNWRHHMY_LBL' for='EOYNWRHHMY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Ordine di bonifico permanente da/verso paese FATCA / OCSE"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p9_b1_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_9_76' style='position:relative;display:block' page='9'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_fatca_ind' id='FBAHOFZNEF' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='CYHJRUWRUL' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Modifica Dati Fatca"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_9_76']=['FBAHOFZNEF'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p9_b1_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_9_412' style='position:relative;height:8px;display:block' page='9'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p9_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_WEJOYIAYYL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_WEJOYIAYYL' style='position:relative;height:7px;display:block' page='9'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_WEJOYIAYYL")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_WEJOYIAYYL').style.height='auto';");
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
  void WriteControls_p9_b3(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='CittaDiv' id='WEJOYIAYYL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='WEJOYIAYYL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='WEJOYIAYYL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Cittadinanze e Residenza se diverse da Italia")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='WEJOYIAYYL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"WEJOYIAYYL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=WEJOYIAYYL_HEADER&m_cBoxId=WEJOYIAYYL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Cittadinanze e Residenza se diverse da Italia"))+"");
    }
    status.out.println(
     "<div id='WEJOYIAYYL' class='SectionBody' style='position:relative;height:91px;display:block'>" +
    "");
    status.includeZoneAltInterface("CittaDiv@BEGIN");
    if (status.includeZoneAltInterface("CittaDiv")) {
      WriteControls_p9_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("CittaDiv@BEGIN") || status.HasZoneAltInterface("CittaDiv@END")) {
        status.out.println(
         "<div id='WEJOYIAYYL_boxContent' style='position:relative;height:91px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CITTADIN1' id='CJBEXKJOQO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CITTADIN1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='CJBEXKJOQO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CJBEXKJOQO", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CITTADIN2' id='UNRQNVVFTK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CITTADIN2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='UNRQNVVFTK_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UNRQNVVFTK", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RESFISC' id='OSLBLDODHQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESFISC,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='OSLBLDODHQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "OSLBLDODHQ", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZZTJUXJOVM_DIV'>" +
       "<label id='ZZTJUXJOVM' for='CJBEXKJOQO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanza 1:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QNTJNWIUJE_DIV'>" +
       "<label id='QNTJNWIUJE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDesCit1)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PHQZJMYLYP_DIV'>" +
       "<label id='PHQZJMYLYP' for='UNRQNVVFTK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanza 2:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SBEGVLBNXL_DIV'>" +
       "<label id='SBEGVLBNXL'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDesCit2)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LENIFRRGPH_DIV'>" +
       "<label id='LENIFRRGPH' for='OSLBLDODHQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Residenza Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FLUVMIEXGY_DIV'>" +
       "<label id='FLUVMIEXGY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xResFis)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("CittaDiv@BEGIN") || status.HasZoneAltInterface("CittaDiv@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p9_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p9_b3_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("CittaDiv@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("CittaDiv")) {
      status.out.println("Ctrl('WEJOYIAYYL').style.height='auto';");
    } else {
      status.out.println("Ctrl('WEJOYIAYYL').setAttribute('band_height',91);");
    }
    status.out.println("Ctrl('WEJOYIAYYL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p9_b4(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_9")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_9' style='position:relative;height:5px;display:block' page='9'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_9")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_9').style.height='auto';");
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
  void WriteControls_p10_b0(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_10")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_10' style='position:relative;height:0px;display:none' page='10'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_10")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_10').style.height='auto';");
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
  void WriteControls_p10_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_10_Rischio_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='ValRisk' id='WJVOGIFRCK_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_10_Rischio'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_10_Rischio = new Z.Tabs({container:'tabs_10_Rischio_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_10_Rischio',tabs_10_Rischio);");
    status.out.println("var l_nWJVOGIFRCKTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='WJVOGIFRCK' class='TabStripBoxBody' style='position:relative;height:322px;display:block'>" +
    "");
    status.includeZoneAltInterface("ValRisk@BEGIN");
    if (status.includeZoneAltInterface("ValRisk")) {
      WriteControls_p10_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ValRisk@BEGIN") || status.HasZoneAltInterface("ValRisk@END")) {
        status.out.println(
         "<div id='WJVOGIFRCK_boxContent' style='position:relative;height:322px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AREAGEO' id='NXVXQSLAGM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='NXVXQSLAGM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NXVXQSLAGM", "tbareegeog", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAREA' id='PGYFWWGOTN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PKTBSPECIE' id='VHXDWWHVXF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PKTBSPECIE,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
       "<button id='VHXDWWHVXF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "VHXDWWHVXF", "tbspecie", "armt_tbspecie", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RNATGIU' id='AAQYBAEHUR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RNATGIU,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ATTIVR' id='UQYOQYIUNM' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_ATTIVR,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Codifica ATECO"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C'>" +
       "<button id='UQYOQYIUNM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(status.context.Translate("Codifica ATECO"),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UQYOQYIUNM", "tbtipatt", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RATTIV' id='BOECHNDAXS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RATTIV,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COMPORT' id='HLXRSSMBIW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COMPORT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='HLXRSSMBIW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HLXRSSMBIW", "tbcondotta", "armt_tbcondotta", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RCOMP' id='ISJKSRTDAC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YEWQBTSTTE_DIV'>" +
       "<label id='YEWQBTSTTE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JMXSJAUKOO_DIV'>" +
       "<label id='JMXSJAUKOO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura Giuridica.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HQMBYZTNNT_DIV'>" +
       "<label id='HQMBYZTNNT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prevalente Attività:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UEHIJUXEBZ_DIV'>" +
       "<label id='UEHIJUXEBZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comportamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OGZVCUPUAY_DIV'>" +
       "<label id='OGZVCUPUAY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescareag)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VTPWYANRQH_DIV'>" +
       "<label id='VTPWYANRQH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescnatgiu)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SCYSGLNMDS_DIV'>" +
       "<label id='SCYSGLNMDS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesctipatt)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GVJJFQWUGU_DIV'>" +
       "<label id='GVJJFQWUGU'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesccomp)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RSHHWFKCKZ_DIV'>" +
       "<label id='RSHHWFKCKZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA RISCHIO"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BUKQJFVQDD_DIV'>" +
       "<label id='BUKQJFVQDD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("VALUTAZIONE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='DOCFILE' id='CWIQJZFJRS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DOCFILE,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CUGDSJZWEC_DIV'>" +
       "<label id='CUGDSJZWEC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Supplementari:"))+"" +
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
      status.out.println(
       "<input name='DATAREVPROF' id='QLLLNEUVYW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATAREVPROF,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XFKXBQYUIU_DIV'>" +
       "<input name='PEP' id='XFKXBQYUIU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PEP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_PEP))?"CHECKED":"")+">" +
       "<label id='XFKXBQYUIU_LBL' for='XFKXBQYUIU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Persona Esposta Politicamente"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='"+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_BCZWUTGYEU()")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' id='BCZWUTGYEU' class='SPHorizontalAction' style='display:none'>" +
       "<span id='BCZWUTGYEU_img' title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per controllare il Soggetto"),"C",0,0)+" tabindex='-1'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59899))+"" +
       "</span>" +
       "<span class='SPLabel' id='BCZWUTGYEU_txt'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("P.E.P."))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RHCYCLTWOT_DIV'>" +
       "<input name='CRIME' id='RHCYCLTWOT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CRIME,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_CRIME))?"CHECKED":"")+">" +
       "<label id='RHCYCLTWOT_LBL' for='RHCYCLTWOT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Presenza in liste CRIME"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='"+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_ESBPIXCOCR()")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' id='ESBPIXCOCR' class='SPHorizontalAction' style='display:none'>" +
       "<span id='ESBPIXCOCR_img' title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per controllare il Soggetto"),"C",0,0)+" tabindex='-1'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59899))+"" +
       "</span>" +
       "<span class='SPLabel' id='ESBPIXCOCR_txt'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Crime"))+"" +
       "</span>" +
       "</a>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JKZZQYXAFS_DIV'>" +
       "<label id='JKZZQYXAFS' for='SMVVFHCEHA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Globale:"))+"" +
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
      status.out.println(
       "<span class='SPLabel' id='ROVJICRYAM_DIV'>" +
       "<label id='ROVJICRYAM' for='QLLLNEUVYW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Revisione Profilatura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VERIFICA' id='OXWRJNTXVJ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("O","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("O",CPLib.Trim(BO.w_VERIFICA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Ordinaria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VERIFICA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Semplificata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("R","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("R",CPLib.Trim(BO.w_VERIFICA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Rafforzata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_VERIFICA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Non Applicabile")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('OXWRJNTXVJ'),w_VERIFICA,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CPCPDBCTVR_DIV'>" +
       "<label id='CPCPDBCTVR' for='OXWRJNTXVJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Adeguata Verifica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='NOTERIS' id='FTYWOEFIPD' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JVQICCQATG_DIV'>" +
       "<label id='JVQICCQATG' for='FTYWOEFIPD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Note Rischio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("ValRisk@BEGIN") || status.HasZoneAltInterface("ValRisk@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p10_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p10_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ValRisk@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("ValRisk")) {
      status.out.println("Ctrl('WJVOGIFRCK').style.height='auto';");
    } else {
      status.out.println("Ctrl('WJVOGIFRCK').setAttribute('band_height',322);");
    }
    status.out.println("Ctrl('WJVOGIFRCK').setAttribute('status','open');");
    status.out.println("tabs_10_Rischio.AddTab({name:\"WJVOGIFRCK\", element:\"WJVOGIFRCK_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipologia e Valutazione Rischio (III Direttiva)"),"C",0,0)+",tabIndex: l_nWJVOGIFRCKTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('WJVOGIFRCK',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('WJVOGIFRCK',false,true,false)}});");
    status.out.println("if (tabs_10_Rischio.CanCollapse()) {");
    status.out.println("tabs_10_Rischio.Expand('WJVOGIFRCK');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_10',tabs_10_Rischio.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p10_b2(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='MitRisk' id='XTDFJTMZAQ_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_10_Rischio'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nXTDFJTMZAQTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='XTDFJTMZAQ' class='TabStripBoxBody' style='position:relative;height:51px;display:block'>" +
    "");
    status.includeZoneAltInterface("MitRisk@BEGIN");
    if (status.includeZoneAltInterface("MitRisk")) {
      WriteControls_p10_b2_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("MitRisk@BEGIN") || status.HasZoneAltInterface("MitRisk@END")) {
        status.out.println(
         "<div id='XTDFJTMZAQ_boxContent' style='position:relative;height:51px;display:block'>" +
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
       "<span class='SPLabel' id='NKPWKMDXUR_DIV'>" +
       "<label id='NKPWKMDXUR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("%"))+"" +
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
      if (status.HasZoneAltInterface("MitRisk@BEGIN") || status.HasZoneAltInterface("MitRisk@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p10_b2_CloseBand(BO,status);
    }
  }
  void WriteControls_p10_b2_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("MitRisk@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("MitRisk")) {
      status.out.println("Ctrl('XTDFJTMZAQ').style.height='auto';");
    } else {
      status.out.println("Ctrl('XTDFJTMZAQ').setAttribute('band_height',51);");
    }
    status.out.println("Ctrl('XTDFJTMZAQ').setAttribute('status','open');");
    status.out.println("tabs_10_Rischio.AddTab({name:\"XTDFJTMZAQ\", element:\"XTDFJTMZAQ_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Mitigazione Rischio"),"C",0,0)+",tabIndex: l_nXTDFJTMZAQTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('XTDFJTMZAQ',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('XTDFJTMZAQ',false,true,false)}});");
    status.out.println("if (tabs_10_Rischio.CanCollapse()) {");
    status.out.println("tabs_10_Rischio.Expand('XTDFJTMZAQ');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_10',tabs_10_Rischio.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p10_b3(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_TKKVDEVHBF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_TKKVDEVHBF' style='position:relative;height:6px;display:block' page='10'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_TKKVDEVHBF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_TKKVDEVHBF').style.height='auto';");
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
  void WriteControls_p10_b4(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Patrimonio' id='TKKVDEVHBF_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_10_Rischio'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nTKKVDEVHBFTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='TKKVDEVHBF' class='TabStripBoxBody' style='position:relative;height:224px;display:none'>" +
    "");
    status.includeZoneAltInterface("Patrimonio@BEGIN");
    if (status.includeZoneAltInterface("Patrimonio")) {
      WriteControls_p10_b4_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Patrimonio@BEGIN") || status.HasZoneAltInterface("Patrimonio@END")) {
        status.out.println(
         "<div id='TKKVDEVHBF_boxContent' style='position:relative;height:224px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_patrimonio' id='FFIYUAKUTX' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Patrimonio@BEGIN") || status.HasZoneAltInterface("Patrimonio@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p10_b4_CloseBand(BO,status);
    }
  }
  void WriteControls_p10_b4_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Patrimonio@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Patrimonio")) {
      status.out.println("Ctrl('TKKVDEVHBF').style.height='auto';");
    } else {
      status.out.println("Ctrl('TKKVDEVHBF').setAttribute('band_height',224);");
    }
    status.out.println("Ctrl('TKKVDEVHBF').setAttribute('status','close');");
    status.out.println("tabs_10_Rischio.AddTab({name:\"TKKVDEVHBF\", element:\"TKKVDEVHBF_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Patrimonio"),"C",0,0)+",tabIndex: l_nTKKVDEVHBFTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('TKKVDEVHBF',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('TKKVDEVHBF',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_10',tabs_10_Rischio.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['TKKVDEVHBF']=['FFIYUAKUTX'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p10_b5(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_STJESIOURE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_STJESIOURE' style='position:relative;height:1px;display:block' page='10'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_STJESIOURE")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_STJESIOURE').style.height='auto';");
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
  void WriteControls_p10_b6(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Reddito' id='STJESIOURE_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_10_Rischio'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nSTJESIOURETabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='STJESIOURE' class='TabStripBoxBody' style='position:relative;height:220px;display:none'>" +
    "");
    status.includeZoneAltInterface("Reddito@BEGIN");
    if (status.includeZoneAltInterface("Reddito")) {
      WriteControls_p10_b6_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Reddito@BEGIN") || status.HasZoneAltInterface("Reddito@END")) {
        status.out.println(
         "<div id='STJESIOURE_boxContent' style='position:relative;height:220px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_reddito' id='COWMRLCMMU' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Reddito@BEGIN") || status.HasZoneAltInterface("Reddito@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p10_b6_CloseBand(BO,status);
    }
  }
  void WriteControls_p10_b6_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Reddito@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Reddito")) {
      status.out.println("Ctrl('STJESIOURE').style.height='auto';");
    } else {
      status.out.println("Ctrl('STJESIOURE').setAttribute('band_height',220);");
    }
    status.out.println("Ctrl('STJESIOURE').setAttribute('status','close');");
    status.out.println("tabs_10_Rischio.AddTab({name:\"STJESIOURE\", element:\"STJESIOURE_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Reddito"),"C",0,0)+",tabIndex: l_nSTJESIOURETabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('STJESIOURE',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('STJESIOURE',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_10',tabs_10_Rischio.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Rischio",10);
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['STJESIOURE']=['COWMRLCMMU'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p10_b7(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_10")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_10' style='position:relative;height:5px;display:block' page='10'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_10")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_10').style.height='auto';");
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
  void WriteControls_p11_b0(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_11")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_11' style='position:relative;height:0px;display:none' page='11'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_11")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_11').style.height='auto';");
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
  void WriteControls_p11_b1(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_11_Rischio_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='RilAnom' id='SSIHDIOVZQ_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_11_Rischio'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_11_Rischio = new Z.Tabs({container:'tabs_11_Rischio_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_11_Rischio',tabs_11_Rischio);");
    status.out.println("var l_nSSIHDIOVZQTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='SSIHDIOVZQ' class='TabStripBoxBody' style='position:relative;height:560px;display:block'>" +
    "");
    status.includeZoneAltInterface("RilAnom@BEGIN");
    if (status.includeZoneAltInterface("RilAnom")) {
      WriteControls_p11_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("RilAnom@BEGIN") || status.HasZoneAltInterface("RilAnom@END")) {
        status.out.println(
         "<div id='SSIHDIOVZQ_boxContent' style='position:relative;height:560px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<div id='VKUMQAHFDZ'>" +
      "");
      // GetPortlet_Rilevazioni_Vars()
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_VKUMQAHFDZ;
      inclusionVars_VKUMQAHFDZ = GetPortlet_VKUMQAHFDZ_Vars(BO,status);
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_VKUMQAHFDZ);
      String portletUID_VKUMQAHFDZ = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
      com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
      com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_rilevazioni_anomalie_portlet.jsp?ForcedPortletUID="+ portletUID_VKUMQAHFDZ+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_VKUMQAHFDZ),true);
      status.out.println(
       "<script>" +
       "GetPortletInEntity.portlets.VKUMQAHFDZ='"+portletUID_VKUMQAHFDZ+"';" +
       "w_Rilevazioni=ZtVWeb.getPortletById('"+portletUID_VKUMQAHFDZ+"');" +
       "</script>" +
      "");
      status.out.println(
       "</div>" +
      "");
      if (status.HasZoneAltInterface("RilAnom@BEGIN") || status.HasZoneAltInterface("RilAnom@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p11_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p11_b1_CloseBand(armt_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("RilAnom@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("RilAnom")) {
      status.out.println("Ctrl('SSIHDIOVZQ').style.height='auto';");
    } else {
      status.out.println("Ctrl('SSIHDIOVZQ').setAttribute('band_height',560);");
    }
    status.out.println("Ctrl('SSIHDIOVZQ').setAttribute('status','open');");
    status.out.println("tabs_11_Rischio.AddTab({name:\"SSIHDIOVZQ\", element:\"SSIHDIOVZQ_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Rilevazione Anomalie"),"C",0,0)+",tabIndex: l_nSSIHDIOVZQTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('SSIHDIOVZQ',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('SSIHDIOVZQ',false,true,false)}});");
    status.out.println("if (tabs_11_Rischio.CanCollapse()) {");
    status.out.println("tabs_11_Rischio.Expand('SSIHDIOVZQ');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_11',tabs_11_Rischio.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Rischio",11);
  }
  void WriteControls_p11_b2(armt_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_11")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_11' style='position:relative;height:5px;display:block' page='11'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_11")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_11').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='status' id='YFBFKZZRWO' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_status,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(armt_personboBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_personboBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_personbo_dip.IsUpdated()) {
      BO.m_cWv_ardt_personbo_dip = BO.ardt_personbo_dip.GetContext();
    }
    if (BO.armt_personbo_agg.IsUpdated()) {
      BO.m_cWv_armt_personbo_agg = BO.armt_personbo_agg.GetContext();
    }
    if (BO.ardt_soggope.IsUpdated()) {
      BO.m_cWv_ardt_soggope = BO.ardt_soggope.GetContext();
    }
    if (BO.ardt_fatca_ind.IsUpdated()) {
      BO.m_cWv_ardt_fatca_ind = BO.ardt_fatca_ind.GetContext();
    }
    if (BO.ardt_patrimonio.IsUpdated()) {
      BO.m_cWv_ardt_patrimonio = BO.ardt_patrimonio.GetContext();
    }
    if (BO.ardt_reddito.IsUpdated()) {
      BO.m_cWv_ardt_reddito = BO.ardt_reddito.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_personboBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COGNOME,"C",26,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOME,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcitta,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDENT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDNASCOMUN,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASCOMUN,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPINTER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDNASSTATO,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASSTATO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATANASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPODOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMDOCUM,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTRILASC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PARTIVA,"C",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOTGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAMOGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ATTIV,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SETTSINT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOSARA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOTIT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGIMPORT,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PROGIMPORT:BO.w_PROGIMPORT,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OLDSETSIN,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CRIMEDATE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEPDATE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOTE,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODLEGRAP,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FATCA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIN,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ODB,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AREAGEO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PKTBSPECIE,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RNATGIU,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RATTIV,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COMPORT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOCFILE,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RISGLOB,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAPROF,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREVPROF,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CRIME,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIGDOC,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAFINE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DISATTIVO,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOSOGGETTO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPSEGNA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOGAFFIDATARIO,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAUSALE,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FATTURATO,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGNOTRIM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAIDENT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITTADIN1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITTADIN2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESFISC,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BANCABEN,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATASEGN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARAUT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VERIFICA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMIMP,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSPMAF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OLDCONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATEXTRA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALLINEATO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALLINEATONOMECNOME,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCOLD,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGIMP_C,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDFILE,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OLDCODFISC,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MACROAGENTE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SPOTID,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVARAGE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SETTSINT2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TELEF,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOORO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODORO,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGVALIDO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAC6,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTRODOM,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTROCAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPORTOMAX,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_FREQUENZA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMOPERAZ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATASIGN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGDAC6,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOTERIS,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSeekAos,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVerSim,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataoggi,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_nascomunid,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_nasstatoid,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgaggfam,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipsot,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCSGRU,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRAMGRU,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCUIC,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xstatonas,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_finesae,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_finesint,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGVALIDO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGANAVAL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ragbanben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesfatca,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ATTIVR,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESDIPE,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDSETSIN,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipatt,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescareag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescnatgiu,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesccomp,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xITFLGPEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesCit1,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesCit2,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xResFis,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRAGLEGRAP,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xIDLEGRAP,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGALTO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COMPLETA,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_status,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_personbo_dip,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_personbo_dip");
    } else if (CPLib.eq(BO.m_cWv_ardt_personbo_dip,"_not_empty_")) {
      BO.m_cWv_ardt_personbo_dip = BO.ardt_personbo_dip.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_personbo_dip,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_personbo_dip,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_armt_personbo_agg,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_armt_personbo_agg");
    } else if (CPLib.eq(BO.m_cWv_armt_personbo_agg,"_not_empty_")) {
      BO.m_cWv_armt_personbo_agg = BO.armt_personbo_agg.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_personbo_agg,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_personbo_agg,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_soggope,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_soggope");
    } else if (CPLib.eq(BO.m_cWv_ardt_soggope,"_not_empty_")) {
      BO.m_cWv_ardt_soggope = BO.ardt_soggope.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_soggope,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_soggope,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_fatca_ind,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_fatca_ind");
    } else if (CPLib.eq(BO.m_cWv_ardt_fatca_ind,"_not_empty_")) {
      BO.m_cWv_ardt_fatca_ind = BO.ardt_fatca_ind.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_fatca_ind,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_fatca_ind,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_patrimonio,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_patrimonio");
    } else if (CPLib.eq(BO.m_cWv_ardt_patrimonio,"_not_empty_")) {
      BO.m_cWv_ardt_patrimonio = BO.ardt_patrimonio.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_patrimonio,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_patrimonio,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_reddito,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_reddito");
    } else if (CPLib.eq(BO.m_cWv_ardt_reddito,"_not_empty_")) {
      BO.m_cWv_ardt_reddito = BO.ardt_reddito.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_reddito,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_reddito,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_PFEQRACAUA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JCWRPFWYVW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CPWCFGHBVH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LIYWMHOGYX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XHVCRZXJZF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YJYXHNVCSS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QNTJNWIUJE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SBEGVLBNXL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FLUVMIEXGY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OGZVCUPUAY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VTPWYANRQH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SCYSGLNMDS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GVJJFQWUGU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(827,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1109,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_personbo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'LDTVEYLAXJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LDTVEYLAXJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'TYEDHRZCMA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TYEDHRZCMA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BYPEBFEOAJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BYPEBFEOAJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZRIWLTGERM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZRIWLTGERM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'IOAMSFCCVV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IOAMSFCCVV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'AHFPACGVOQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AHFPACGVOQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MBGANUUHRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'LLYIGAMXRH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LLYIGAMXRH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+",'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_stgru",l_session)+"'"+"]");
      status.out.print(",'RVNHQCXNEM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RVNHQCXNEM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SAQTIHOALW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGNLLSFQHC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZGNLLSFQHC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'MQYKJYJENJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MQYKJYJENJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo_agg,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKHRNQSKKQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CKHRNQSKKQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'DQZNJUSTLN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DQZNJUSTLN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RKHMYOIJDM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RKHMYOIJDM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CJBEXKJOQO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CJBEXKJOQO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'UNRQNVVFTK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UNRQNVVFTK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OSLBLDODHQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OSLBLDODHQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NXVXQSLAGM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NXVXQSLAGM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'JHEJMIHGSH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JHEJMIHGSH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'VHXDWWHVXF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VHXDWWHVXF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie,"+"default",l_session)+"'"+"]");
      status.out.print(",'DRJTSDRPVN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DRJTSDRPVN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'UQYOQYIUNM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UQYOQYIUNM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'QFJRACGINU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QFJRACGINU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'HLXRSSMBIW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HLXRSSMBIW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta,"+"default",l_session)+"'"+"]");
      status.out.print(",'KYTSUTYBUR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KYTSUTYBUR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta_p,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'LDTVEYLAXJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'TYEDHRZCMA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BYPEBFEOAJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZRIWLTGERM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'IOAMSFCCVV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'AHFPACGVOQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'LLYIGAMXRH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'RVNHQCXNEM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGNLLSFQHC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'MQYKJYJENJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo_agg,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKHRNQSKKQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'DQZNJUSTLN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RKHMYOIJDM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CJBEXKJOQO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'UNRQNVVFTK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OSLBLDODHQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NXVXQSLAGM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'JHEJMIHGSH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'VHXDWWHVXF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie,"+"default",l_session)+"'"+"]");
      status.out.print(",'DRJTSDRPVN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'UQYOQYIUNM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'QFJRACGINU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'HLXRSSMBIW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta,"+"default",l_session)+"'"+"]");
      status.out.print(",'KYTSUTYBUR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta_p,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_personbo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_personbo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("PF"),"")) {
      status.quoteAndAppend("PF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AD"),"")) {
      status.quoteAndAppend("AD","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("GestoriContante"),"")) {
      status.quoteAndAppend("GestoriContante","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Operazioni"),"")) {
      status.quoteAndAppend("Operazioni","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Frazionate"),"")) {
      status.quoteAndAppend("Frazionate","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Rapporti"),"")) {
      status.quoteAndAppend("Rapporti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Rapporti"),"")) {
      status.quoteAndAppend("Rapporti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Operazioni"),"")) {
      status.quoteAndAppend("Operazioni","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Frazionate"),"")) {
      status.quoteAndAppend("Frazionate","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("LegRap"),"")) {
      status.quoteAndAppend("LegRap","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DatiAgg"),"")) {
      status.quoteAndAppend("DatiAgg","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Dipendenza"),"")) {
      status.quoteAndAppend("Dipendenza","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SogCollegati"),"")) {
      status.quoteAndAppend("SogCollegati","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Fatc"),"")) {
      status.quoteAndAppend("Fatc","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("CittaDiv"),"")) {
      status.quoteAndAppend("CittaDiv","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ValRisk"),"")) {
      status.quoteAndAppend("ValRisk","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("MitRisk"),"")) {
      status.quoteAndAppend("MitRisk","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Patrimonio"),"")) {
      status.quoteAndAppend("Patrimonio","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Reddito"),"")) {
      status.quoteAndAppend("Reddito","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("RilAnom"),"")) {
      status.quoteAndAppend("RilAnom","hide","box");
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
  void WriteMainFormScript(armt_personboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_personbo',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('UYWIEUHCAL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TWTTDWKCRG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WWGIVGNUDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZTHKEDVCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AWPNTOJIRR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOTZPDMYIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RDAVOEETJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOTAJBWHHY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYLHWTRQNX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IRLEJAUHCB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYPEBFEOAJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYPEBFEOAJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NEUBQNUEOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KPSCOABZLB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOAMSFCCVV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOAMSFCCVV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HODZKKOSYW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QPALJZMFCL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MBGANUUHRA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HVEEMUJUUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRNCPADUFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OJJHIUDPFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FHXWUTBNKI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JLTVZXPMKM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LLYIGAMXRH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SAQTIHOALW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SAQTIHOALW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGNLLSFQHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YTPWDRMFUS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCYZDRXAMJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RARXYHBSLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DFNZBCOVFH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FROMUIZATY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZOYIYAUUO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZOYIYAUUO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('REJDXHTDMV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('REJDXHTDMV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODWJZUZDBK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODWJZUZDBK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JJETXTUKNC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JFJPGOWVYJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HKQDVAPIOQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EMSGWJAYYK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XOROAVXTCD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XERWNYQDBZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVYVDDYVDZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVYVDDYVDZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOHBZOSBVJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMKFMWBVUO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKHRNQSKKQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKHRNQSKKQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DQZNJUSTLN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DQZNJUSTLN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESODTMPIYO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESODTMPIYO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UNPDFRUOXO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UNPDFRUOXO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RKHMYOIJDM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RKHMYOIJDM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HBSPPQBOJN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOYNWRHHMY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CJBEXKJOQO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CJBEXKJOQO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UNRQNVVFTK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UNRQNVVFTK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSLBLDODHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSLBLDODHQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NXVXQSLAGM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NXVXQSLAGM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PGYFWWGOTN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VHXDWWHVXF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VHXDWWHVXF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AAQYBAEHUR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UQYOQYIUNM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UQYOQYIUNM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOECHNDAXS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HLXRSSMBIW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HLXRSSMBIW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ISJKSRTDAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SMVVFHCEHA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXITFMGTNB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXITFMGTNB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFKXBQYUIU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RHCYCLTWOT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DOXBACRWUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXGBDTWKSX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXWRJNTXVJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FTYWOEFIPD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YFBFKZZRWO')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('BKKASVQSWO')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('BKKASVQSWO',linkpc_url('BKKASVQSWO'));");
      status.out.println("}");
      status.out.println("if (Ctrl('OIREAEXNKZ')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('OIREAEXNKZ',linkpc_url('OIREAEXNKZ'));");
      status.out.println("}");
      status.out.println("if (Ctrl('RYYOFFRITV')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('RYYOFFRITV',linkpc_url('RYYOFFRITV'));");
      status.out.println("}");
      status.out.println("if (Ctrl('FBAHOFZNEF')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('FBAHOFZNEF',linkpc_url('FBAHOFZNEF'));");
      status.out.println("}");
      status.out.println("if (Ctrl('FFIYUAKUTX')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('FFIYUAKUTX',linkpc_url('FFIYUAKUTX'));");
      status.out.println("}");
      status.out.println("if (Ctrl('COWMRLCMMU')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('COWMRLCMMU',linkpc_url('COWMRLCMMU'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('YTPWDRMFUS')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- armt_personbo");
    status.out.println("w_status=m_cFunction;");
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
    status.out.println("if (Eq(name,'ardt_personbo_dip')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_personbo_dip")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'armt_personbo_agg')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_personbo_agg")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_soggope')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_soggope")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_fatca_ind')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_fatca_ind")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_patrimonio')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_patrimonio")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_reddito')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_reddito")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PROGIMPORT') || Empty(p_uid)) {");
      status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PROGIMPORT','PRGIMPOCLI');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PROGIMPORT',w_PROGIMPORT,op_PROGIMPORT,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('personbo');");
      status.out.println("w_PROGIMPORT=AutonumberApplet().GetAutonumberDouble('PROGIMPORT');");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("op_codazi=m_cCompany;");
      status.out.println("op_PROGIMPORT=w_PROGIMPORT;");
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
  armt_personboBO getBO(ServletStatus status) {
    armt_personboBO BO = new armt_personboBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_PROGIMPORT = BO.w_PROGIMPORT;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_personboBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("personbo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_personboBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_personboBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbident",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
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
    status.out.println("var IRLEJAUHCB_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"","DESCRI"));
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
    l_VQRHolder = new VQRHolder("qbe_stgru",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("SOTGRU");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("SOTGRU"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var LLYIGAMXRH_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_setsin",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("SETSINT");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("SETSINT"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var ZGNLLSFQHC_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbcauana,CPSql.BuildSQLPhrase("CODCAU,DESCRI",BO.m_cPhName_tbcauana,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue(0,"N",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetDouble("CODCAU"),"N",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var EMSGWJAYYK_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbrisglob",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("CODICE");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
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
    status.out.println("var SMVVFHCEHA_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_personboBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_personbo;
    String l_cPhName = BO.m_cPhName_personbo;
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
      String l_cQueryFilter = armt_personboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_personbo+".CONNES",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("personbo");
    String l_cPhName = CPSql.ManipulateTablePhName("personbo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CONNES",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_personboBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_personboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_personbo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_personbo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_personboBO BO) {
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
  void Edit(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
    BO.Load(status.w_CONNES);
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
  void New(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_personboBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CONNES = "";
      } else {
        BO.w_CONNES = l_rsKeys.GetString("CONNES");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CONNES = BO.w_CONNES;
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
  void EditLoad(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CONNES);
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
  void DeleteMessage(ServletStatus status,armt_personboBO BO,SPParameterSource source) {
    BO.Load(status.w_CONNES);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_personboBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    double l_old_PROGIMPORT = 0;
    if (CPLib.ne(BO.w_PROGIMPORT,BO.op_PROGIMPORT)) {
      l_old_PROGIMPORT = BO.op_PROGIMPORT;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_PROGIMPORT))) {
        BO.op_PROGIMPORT = l_old_PROGIMPORT;
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
  void Discard(ServletStatus status,armt_personboBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_personboBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",747);
    item.put("w",1109);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Operazioni ExtraConto\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"A.U.I.\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Deleghe\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Provvisorie\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Titolarit\\u00E0\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Modifiche Anagrafiche\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Supplementari\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"FATCA\\/OCSE\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Analisi Rischio\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Rilevazione Anomalie\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Base,Operazioni ExtraConto,A.U.I.,Deleghe,Provvisorie,Titolarità,Modifiche Anagrafiche,Dati Supplementari,FATCA/OCSE,Dati Analisi Rischio,Rilevazione Anomalie");
    item.put("altInterfaceFor","armt_personbo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base + Residenza\",\"h\":238,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AQSQVBKXAL\",\"stretch\":true,\"tabindex\":10,\"title_caption\":\"Dati Base + Residenza\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Soggetto\",\"h\":19,\"maxlength\":1,\"name\":\"TIPOPERS\",\"orientation\":\"horizontal\",\"page\":1,\"spuid\":\"UYWIEUHCAL\",\"tabindex\":13,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":392,\"x\":128,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stampa Scheda Adeguata Verifica\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_HGVEMKOKYZ\",\"page\":1,\"spuid\":\"HGVEMKOKYZ\",\"src\":\"..\\/{\\\"Char\\\":\\\"60166\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":14,\"type\":\"Image\",\"w\":32,\"x\":776,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ricerca su Soggetti Segnalati\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_BYFMKHYARA\",\"page\":1,\"spuid\":\"BYFMKHYARA\",\"src\":\"..\\/{\\\"Char\\\":\\\"60124\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":15,\"type\":\"Image\",\"w\":32,\"x\":816,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cambio NDG Soggetto\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_PAHSBQSDGU\",\"page\":1,\"spuid\":\"PAHSBQSDGU\",\"src\":\"..\\/{\\\"Char\\\":\\\"59918\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":16,\"type\":\"Image\",\"w\":32,\"x\":856,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Crea movimenti di variazione su Operazioni\\/Informazioni\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_VVZBQJZQFF\",\"page\":1,\"spuid\":\"VVZBQJZQFF\",\"src\":\"..\\/{\\\"Char\\\":\\\"60289\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":17,\"type\":\"Image\",\"w\":32,\"x\":896,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sblocca modifica codice fiscale e dati anagrafici\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_GSYDJTTEZF\",\"page\":1,\"spuid\":\"GSYDJTTEZF\",\"src\":\"..\\/{\\\"Char\\\":\\\"60321\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":18,\"type\":\"Image\",\"w\":32,\"x\":936,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stampe Soggetto\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_VEHZFMLUPL\",\"page\":1,\"spuid\":\"VEHZFMLUPL\",\"src\":\"..\\/{\\\"Char\\\":\\\"60166\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":19,\"type\":\"Image\",\"w\":32,\"x\":976,\"y\":15,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":26,\"name\":\"COGNOME\",\"page\":1,\"spuid\":\"TWTTDWKCRG\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":128,\"y\":48,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":25,\"name\":\"NOME\",\"page\":1,\"spuid\":\"WWGIVGNUDW\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":352,\"y\":48,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TVSLWOCERI\",\"page\":1,\"spuid\":\"TVSLWOCERI\",\"tabindex\":96,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":120,\"x\":5,\"y\":52,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUPYKSUBXV\",\"page\":1,\"spuid\":\"KUPYKSUBXV\",\"tabindex\":97,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":35,\"x\":316,\"y\":52,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Codice Fiscale Estero\",\"h\":21,\"label_text\":\"Codice Fiscale non attribuito dall"+"'"+"Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attivit\\u00E0 in Italia)\",\"maxlength\":2,\"name\":\"CFESTERO\",\"page\":1,\"spuid\":\"CZTHKEDVCO\",\"tabindex\":22,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":575,\"x\":128,\"y\":71,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragione Sociale\",\"h\":20,\"maxlength\":70,\"name\":\"RAGSOC\",\"page\":1,\"spuid\":\"AWPNTOJIRR\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":128,\"y\":97,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PFEQRACAUA\",\"page\":1,\"spuid\":\"PFEQRACAUA\",\"tabindex\":76,\"type\":\"Label\",\"w\":120,\"x\":5,\"y\":101,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":128,\"y\":125,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"Stato:\",\"w\":120,\"x\":5,\"y\":129,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":92,\"type\":\"Label\",\"w\":323,\"x\":181,\"y\":129,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":128,\"y\":153,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":528,\"y\":153,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":600,\"y\":153,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"spuid\":\"BOTAJBWHHY\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":704,\"y\":153,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":52,\"x\":472,\"y\":157,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":30,\"x\":568,\"y\":157,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHMXTGXWGC\",\"page\":1,\"spuid\":\"WHMXTGXWGC\",\"tabindex\":81,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":676,\"y\":157,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":120,\"x\":5,\"y\":157,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":128,\"y\":181,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":120,\"x\":5,\"y\":185,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Identificazione\",\"h\":20,\"maxlength\":3,\"name\":\"IDENT\",\"page\":1,\"spuid\":\"IRLEJAUHCB\",\"tabindex\":31,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":656,\"x\":128,\"y\":209,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XYHCZSITMJ\",\"page\":1,\"spuid\":\"XYHCZSITMJ\",\"tabindex\":107,\"type\":\"Label\",\"value\":\"Identificazione:\",\"w\":120,\"x\":5,\"y\":213,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"h\":21,\"label_text\":\"Aggiornamento delle famiglie collegate\",\"maxlength\":1,\"name\":\"flgaggfam\",\"page\":1,\"spuid\":\"DFNZBCOVFH\",\"tabindex\":58,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":219,\"x\":784,\"y\":70,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Identificazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAIDENT\",\"page\":1,\"picker\":true,\"spuid\":\"EVYVDDYVDZ\",\"tabindex\":132,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":912,\"y\":209,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FPRDXPXSKH\",\"page\":1,\"spuid\":\"FPRDXPXSKH\",\"tabindex\":133,\"type\":\"Label\",\"value\":\"Data Identificazione:\",\"w\":168,\"x\":744,\"y\":213,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PF\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Solo Persona Fisica (Documento + Dati di Nascita)\",\"h\":132,\"name\":\"PF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"EWPTTWSBMT\",\"stretch\":true,\"tabindex\":11,\"title_caption\":\"Solo Persona Fisica (Documento + Dati di Nascita)\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":239,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ID Comune Nascita\",\"h\":20,\"maxlength\":40,\"name\":\"IDNASCOMUN\",\"page\":1,\"picker\":true,\"spuid\":\"BYPEBFEOAJ\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":128,\"y\":253,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Luogo di Nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":1,\"spuid\":\"NEUBQNUEOJ\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":257,\"x\":407,\"y\":253,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prov.\",\"h\":20,\"maxlength\":2,\"name\":\"TIPINTER\",\"page\":1,\"spuid\":\"KPSCOABZLB\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":710,\"y\":253,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVJSUIKYEY\",\"page\":1,\"spuid\":\"WVJSUIKYEY\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"Citt\\u00E0 di Nascita:\",\"w\":120,\"x\":5,\"y\":257,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVAWYVSUQI\",\"page\":1,\"spuid\":\"IVAWYVSUQI\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":32,\"x\":671,\"y\":257,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ID Stato Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"IDNASSTATO\",\"page\":1,\"picker\":true,\"spuid\":\"IOAMSFCCVV\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":80,\"x\":128,\"y\":281,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato di nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":1,\"spuid\":\"HODZKKOSYW\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":233,\"x\":236,\"y\":281,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"spuid\":\"QPALJZMFCL\",\"tabindex\":39,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":88,\"x\":575,\"y\":281,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRSCDPQZTQ\",\"page\":1,\"spuid\":\"KRSCDPQZTQ\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":39,\"x\":531,\"y\":285,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBRDCBHLZC\",\"page\":1,\"spuid\":\"ZBRDCBHLZC\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":120,\"x\":5,\"y\":285,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"picker\":true,\"spuid\":\"XMGRWGFSFV\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":128,\"y\":309,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"spuid\":\"MBGANUUHRA\",\"tabindex\":41,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":246,\"x\":336,\"y\":309,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Doc.\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"spuid\":\"HVEEMUJUUY\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":704,\"y\":309,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXFGMWZGNN\",\"page\":1,\"spuid\":\"YXFGMWZGNN\",\"tabindex\":69,\"type\":\"Label\",\"value\":\"Numero Doc.:\",\"w\":101,\"x\":600,\"y\":313,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HZYTDOZFPI\",\"page\":1,\"spuid\":\"HZYTDOZFPI\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"Data Nascita:\",\"w\":120,\"x\":5,\"y\":313,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YRARWMJPPV\",\"page\":1,\"spuid\":\"YRARWMJPPV\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":103,\"x\":232,\"y\":313,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio Doc.\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"picker\":true,\"spuid\":\"XHWYGOPPUN\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":128,\"y\":337,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"picker\":true,\"spuid\":\"BNWXBPSIDG\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":336,\"y\":337,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 di rilascio\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"spuid\":\"HRNCPADUFU\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":552,\"y\":337,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZPQIEJPWJC\",\"page\":1,\"spuid\":\"ZPQIEJPWJC\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 di rilascio:\",\"w\":100,\"x\":451,\"y\":341,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MLJVDLOITR\",\"page\":1,\"spuid\":\"MLJVDLOITR\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"Rilascio Doc.:\",\"w\":120,\"x\":5,\"y\":341,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UYGHJPRVKH\",\"page\":1,\"spuid\":\"UYGHJPRVKH\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"Data Fine Validit\\u00E0:\",\"w\":101,\"x\":232,\"y\":341,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AD\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Altri Dati\",\"h\":208,\"name\":\"AD\",\"page\":1,\"shrinkable\":true,\"spuid\":\"OQFTKYDCIW\",\"stretch\":true,\"tabindex\":12,\"title_caption\":\"Altri Dati\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":373,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"spuid\":\"OJJHIUDPFY\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":128,\"y\":385,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ricalcola il codice fiscale\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_HCIJRBXGCX\",\"page\":1,\"spuid\":\"HCIJRBXGCX\",\"src\":\"..\\/{\\\"Char\\\":\\\"60231\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"20\\\"}\",\"tabindex\":47,\"type\":\"Image\",\"w\":25,\"x\":258,\"y\":385,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Partita IVA\",\"h\":20,\"maxlength\":14,\"name\":\"PARTIVA\",\"page\":1,\"spuid\":\"FHXWUTBNKI\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":408,\"y\":385,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZDAFMDKJE\",\"page\":1,\"spuid\":\"WZDAFMDKJE\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":120,\"x\":5,\"y\":389,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WRVDNZJCDE\",\"page\":1,\"spuid\":\"WRVDNZJCDE\",\"tabindex\":82,\"type\":\"Label\",\"value\":\"Partita IVA:\",\"w\":58,\"x\":349,\"y\":389,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contro Corrente se controparte\",\"h\":20,\"maxlength\":25,\"name\":\"CONTO\",\"page\":1,\"spuid\":\"JLTVZXPMKM\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":824,\"y\":385,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHMWHZJZVJ\",\"page\":1,\"spuid\":\"LHMWHZJZVJ\",\"tabindex\":112,\"type\":\"Label\",\"value\":\"Conto Corrente (IBAN) se controparte:\",\"w\":206,\"x\":614,\"y\":389,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Sottogruppo Att. Ec.\",\"h\":20,\"maxlength\":3,\"name\":\"SOTGRUP\",\"page\":1,\"spuid\":\"LLYIGAMXRH\",\"tabindex\":50,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":880,\"x\":128,\"y\":413,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZZDCRCKYFX\",\"page\":1,\"spuid\":\"ZZDCRCKYFX\",\"tabindex\":68,\"type\":\"Label\",\"value\":\"Sottogruppo Att. Ec.:\",\"w\":120,\"x\":5,\"y\":417,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Ramo Gruppo Att. Ec.\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"RAMOGRUP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RVNHQCXNEM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":128,\"y\":441,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codifica ATECO\",\"h\":20,\"maxlength\":10,\"name\":\"ATTIV\",\"page\":1,\"picker\":true,\"spuid\":\"SAQTIHOALW\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":70,\"x\":128,\"y\":469,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QOLFDIWXXC\",\"page\":1,\"spuid\":\"QOLFDIWXXC\",\"tabindex\":72,\"type\":\"Label\",\"value\":\"Ramo Gruppo Att. Ec.:\",\"w\":120,\"x\":5,\"y\":445,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_JCWRPFWYVW\",\"page\":1,\"spuid\":\"JCWRPFWYVW\",\"tabindex\":93,\"type\":\"Label\",\"w\":504,\"x\":186,\"y\":445,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LRKNJREBPN\",\"page\":1,\"spuid\":\"LRKNJREBPN\",\"tabindex\":99,\"type\":\"Label\",\"value\":\"Codifica ATECO:\",\"w\":120,\"x\":5,\"y\":473,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CPWCFGHBVH\",\"page\":1,\"spuid\":\"CPWCFGHBVH\",\"tabindex\":100,\"type\":\"Label\",\"w\":448,\"x\":224,\"y\":473,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Settorizzazione UIC\",\"h\":20,\"maxlength\":3,\"name\":\"SETTSINT\",\"page\":1,\"spuid\":\"ZGNLLSFQHC\",\"tabindex\":53,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":848,\"x\":128,\"y\":497,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ricalcola il settore sintetico\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_UQJBFPCIGV\",\"page\":1,\"spuid\":\"UQJBFPCIGV\",\"src\":\"..\\/{\\\"Char\\\":\\\"59942\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"20\\\"}\",\"tabindex\":54,\"type\":\"Image\",\"w\":20,\"x\":987,\"y\":497,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHHLIWFNCK\",\"page\":1,\"spuid\":\"LHHLIWFNCK\",\"tabindex\":74,\"type\":\"Label\",\"value\":\"Settorizzazione UIF:\",\"w\":120,\"x\":5,\"y\":501,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Collegamento\",\"h\":20,\"maxlength\":16,\"name\":\"CONNES\",\"page\":1,\"spuid\":\"YTPWDRMFUS\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":128,\"y\":525,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Escludi operazioni soggetto da SARA\",\"h\":21,\"label_text\":\"Escludi le operazioni del soggetto da S.A.R.A.\",\"maxlength\":1,\"name\":\"NOSARA\",\"page\":1,\"spuid\":\"XCYZDRXAMJ\",\"tabindex\":56,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":288,\"x\":392,\"y\":525,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Non inviare titolare AGE\",\"h\":21,\"label_text\":\"Esenzione titolare effettivo ex art. 25 Dlgs. 231\\/2007\",\"maxlength\":2,\"name\":\"NOTIT\",\"page\":1,\"spuid\":\"RARXYHBSLM\",\"tabindex\":57,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":328,\"x\":680,\"y\":525,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EKULYOXTJM\",\"page\":1,\"spuid\":\"EKULYOXTJM\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"NDG (Cod. Collegam.):\",\"w\":120,\"x\":5,\"y\":529,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Non pi\\u00F9 cliente Dal\",\"h\":20,\"maxlength\":10,\"name\":\"DATAFINE\",\"page\":1,\"picker\":true,\"spuid\":\"YZOYIYAUUO\",\"tabindex\":114,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":688,\"y\":553,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WWXBPXHXEU\",\"page\":1,\"spuid\":\"WWXBPXHXEU\",\"tabindex\":115,\"type\":\"Label\",\"value\":\"Non pi\\u00F9 cliente Dal:\",\"w\":101,\"x\":584,\"y\":557,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cliente dal\",\"h\":20,\"maxlength\":10,\"name\":\"DATAINI\",\"page\":1,\"picker\":true,\"spuid\":\"REJDXHTDMV\",\"tabindex\":116,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":432,\"y\":553,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LOQXTBECEG\",\"page\":1,\"spuid\":\"LOQXTBECEG\",\"tabindex\":117,\"type\":\"Label\",\"value\":\"Cliente Dal:\",\"w\":101,\"x\":328,\"y\":557,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Non pi\\u00F9 attivo dal\",\"h\":20,\"maxlength\":10,\"name\":\"DISATTIVO\",\"page\":1,\"picker\":true,\"spuid\":\"ODWJZUZDBK\",\"tabindex\":118,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":128,\"y\":553,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PWDSDLHUNX\",\"page\":1,\"spuid\":\"PWDSDLHUNX\",\"tabindex\":119,\"type\":\"Label\",\"value\":\"Non pi\\u00F9 attivo dal:\",\"w\":131,\"x\":-8,\"y\":557,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"GestoriContante\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Gestori Contante\",\"h\":154,\"name\":\"GestoriContante\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PUKLGLJKBW\",\"stretch\":true,\"tabindex\":120,\"title_caption\":\"Gestori Contante\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":588,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKXIGUDYJJ\",\"page\":1,\"spuid\":\"PKXIGUDYJJ\",\"tabindex\":121,\"type\":\"Label\",\"value\":\"Tipo Soggetto:\",\"w\":131,\"x\":8,\"y\":605,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Soggetto\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOSOGGETTO\",\"page\":1,\"spuid\":\"JJETXTUKNC\",\"tabindex\":122,\"textlist\":\"Dipendenze bancarie e postali,Sale conta del medesimo operatore o di altri operatori,Punti serviti della \\u201Cgrande distribuzione organizzata\\u201D (GDO),Punti serviti di clienti non rientranti fra quelli individuati al punto precedente (altri)\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"a"+"'"+","+"'"+"b"+"'"+","+"'"+"c"+"'"+","+"'"+"d"+"'"+"\",\"w\":656,\"x\":144,\"y\":601,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MASICCONRV\",\"page\":1,\"spuid\":\"MASICCONRV\",\"tabindex\":123,\"type\":\"Label\",\"value\":\"Tipo Rapporto:\",\"w\":131,\"x\":8,\"y\":633,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Tipo Rapporto\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"RAPSEGNA\",\"page\":1,\"spuid\":\"JFJPGOWVYJ\",\"tabindex\":124,\"textlist\":\"Cliente Diretto,Cliente acquisito tramite un network CIT,Cliente acquisito tramite un network non CIT,Soggetto Servito\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":656,\"x\":144,\"y\":629,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Affidatario Incarico\",\"h\":20,\"maxlength\":80,\"name\":\"SOGAFFIDATARIO\",\"page\":1,\"spuid\":\"HKQDVAPIOQ\",\"tabindex\":125,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":144,\"y\":658,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EELMPIGUVH\",\"page\":1,\"spuid\":\"EELMPIGUVH\",\"tabindex\":130,\"type\":\"Label\",\"value\":\"Affidatario Incarico:\",\"w\":131,\"x\":8,\"y\":662,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Causale Default\",\"h\":20,\"maxlength\":6,\"name\":\"CAUSALE\",\"page\":1,\"spuid\":\"EMSGWJAYYK\",\"tabindex\":126,\"type\":\"Combobox\",\"typevar\":\"numeric\",\"w\":656,\"x\":144,\"y\":686,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ULEYNEIGRT\",\"page\":1,\"spuid\":\"ULEYNEIGRT\",\"tabindex\":127,\"type\":\"Label\",\"value\":\"Causale Default:\",\"w\":131,\"x\":8,\"y\":690,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Fatturato\",\"h\":20,\"maxlength\":13,\"name\":\"FATTURATO\",\"page\":1,\"spuid\":\"XOROAVXTCD\",\"tabindex\":128,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":84,\"x\":144,\"y\":715,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBWPHEDKDN\",\"page\":1,\"spuid\":\"ZBWPHEDKDN\",\"tabindex\":129,\"type\":\"Label\",\"value\":\"Fatturato:\",\"w\":131,\"x\":8,\"y\":719,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"h\":21,\"label_text\":\"Escludi da Estrazioni Trimestrali\",\"maxlength\":1,\"name\":\"FLGNOTRIM\",\"page\":1,\"spuid\":\"XERWNYQDBZ\",\"tabindex\":131,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":224,\"x\":576,\"y\":714,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":490,\"name\":\"Opextrbo\",\"page\":2,\"spuid\":\"SPRIZARLRS\",\"src\":\"\\/jsp\\/pg_opextrbo_portlet.jsp?ForcedPortletUID=SPRIZARLRS\",\"tabindex\":1,\"type\":\"Portlet\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Note\",\"h\":132,\"name\":\"NOTE\",\"page\":2,\"scroll\":true,\"spuid\":\"UMKFMWBVUO\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":944,\"x\":72,\"y\":497,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GXTICCPRBI\",\"page\":2,\"spuid\":\"GXTICCPRBI\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Note:\",\"w\":69,\"x\":0,\"y\":497,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Rapporti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Rapporti\",\"groupName\":\"AUI\",\"h\":637,\"name\":\"Rapporti\",\"page\":3,\"shrinkable\":true,\"spuid\":\"XDVUUVRZLV\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Rapporti\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":8,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":609,\"name\":\"Rapporti_AUI\",\"page\":3,\"spuid\":\"ITHLBNJDBB\",\"src\":\"\\/jsp\\/pg_anarapbo_portlet.jsp?ForcedPortletUID=ITHLBNJDBB\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1024,\"x\":16,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazioni\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Operazioni\",\"groupName\":\"AUI\",\"h\":637,\"name\":\"Operazioni\",\"page\":3,\"shrinkable\":true,\"spuid\":\"VECIWQFMOB\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Operazioni\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":8,\"y\":644,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":620,\"name\":\"Operazioni_AUI\",\"page\":3,\"spuid\":\"YGGYRKSULB\",\"src\":\"\\/jsp\\/pg_operazbo_portlet.jsp?ForcedPortletUID=YGGYRKSULB\",\"tabindex\":4,\"type\":\"Portlet\",\"w\":1024,\"x\":16,\"y\":651,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Frazionate\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Frazionate\",\"groupName\":\"AUI\",\"h\":637,\"name\":\"Frazionate\",\"page\":3,\"shrinkable\":true,\"spuid\":\"WXIRJORZUM\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Frazionate\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":8,\"y\":1288,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":617,\"name\":\"Frazionate_AUI\",\"page\":3,\"spuid\":\"TPNIPPCTXD\",\"src\":\"\\/jsp\\/pg_fraziobo_portlet.jsp?ForcedPortletUID=TPNIPPCTXD\",\"tabindex\":5,\"type\":\"Portlet\",\"w\":1024,\"x\":16,\"y\":1295,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":301,\"name\":\"Deleghe_AUI\",\"page\":4,\"spuid\":\"NEBCWOJZLB\",\"src\":\"\\/jsp\\/pg_connes_delegabo_portlet.jsp?ForcedPortletUID=NEBCWOJZLB\",\"tabindex\":1,\"type\":\"Portlet\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":301,\"name\":\"Deleghe_PRV\",\"page\":4,\"spuid\":\"YCXLRKTFHB\",\"src\":\"\\/jsp\\/pg_connes_xelegabo_portlet.jsp?ForcedPortletUID=YCXLRKTFHB\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":1016,\"x\":0,\"y\":303,\"zone\":\"pag4_2\",\"zonepath\":\"[4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Rapporti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Rapporti\",\"groupName\":\"Provvisorie\",\"h\":637,\"name\":\"Rapporti\",\"page\":5,\"shrinkable\":true,\"spuid\":\"YVPVOYKMZA\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Rapporti\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":0,\"y\":0,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":609,\"name\":\"Rapporti_Prv\",\"page\":5,\"spuid\":\"YNCPFMWRMO\",\"src\":\"\\/jsp\\/pg_anarapbo_portlet.jsp?ForcedPortletUID=YNCPFMWRMO\",\"tabindex\":1,\"type\":\"Portlet\",\"w\":1024,\"x\":8,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazioni\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Operazioni\",\"groupName\":\"Provvisorie\",\"h\":637,\"name\":\"Operazioni\",\"page\":5,\"shrinkable\":true,\"spuid\":\"MTHMFUOOBG\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Operazioni\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":0,\"y\":644,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":620,\"name\":\"Operazioni_Prv\",\"page\":5,\"spuid\":\"PPJPQHWTQQ\",\"src\":\"\\/jsp\\/pg_operazbo_portlet.jsp?ForcedPortletUID=PPJPQHWTQQ\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1024,\"x\":8,\"y\":651,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Frazionate\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Frazionate\",\"groupName\":\"Provvisorie\",\"h\":637,\"name\":\"Frazionate\",\"page\":5,\"shrinkable\":true,\"spuid\":\"WVUNPTQGCF\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Frazionate\",\"titled\":true,\"type\":\"Box\",\"w\":1040,\"x\":0,\"y\":1288,\"zone\":\"pag5_3\",\"zonepath\":\"[5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":617,\"name\":\"Frazionate_Prv\",\"page\":5,\"spuid\":\"YWVSUWPJEY\",\"src\":\"\\/jsp\\/pg_fraziobo_portlet.jsp?ForcedPortletUID=YWVSUWPJEY\",\"tabindex\":5,\"type\":\"Portlet\",\"w\":1024,\"x\":8,\"y\":1295,\"zone\":\"pag5_3_1\",\"zonepath\":\"[5,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"LegRap\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Legale Rappresentante\",\"h\":42,\"name\":\"LegRap\",\"page\":6,\"shrinkable\":true,\"spuid\":\"HPGCEWAWGV\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Legale Rappresentante\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":0,\"y\":0,\"zone\":\"pag6_1\",\"zonepath\":\"[6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LIYWMHOGYX\",\"page\":6,\"spuid\":\"LIYWMHOGYX\",\"tabindex\":1,\"type\":\"Label\",\"w\":432,\"x\":305,\"y\":15,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Legale Rappresentante\",\"h\":20,\"maxlength\":16,\"name\":\"CODLEGRAP\",\"page\":6,\"picker\":true,\"spuid\":\"CKHRNQSKKQ\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":11,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZAFNQMBDHV\",\"page\":6,\"spuid\":\"ZAFNQMBDHV\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Legale Rappresentante:\",\"w\":155,\"x\":8,\"y\":15,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":318,\"name\":\"Titolari_PRV\",\"page\":6,\"spuid\":\"GTYEFDRRAU\",\"src\":\"\\/jsp\\/pg_xapotit_portlet.jsp?ForcedPortletUID=GTYEFDRRAU\",\"tabindex\":5,\"type\":\"Portlet\",\"w\":1008,\"x\":0,\"y\":354,\"zone\":\"pag6_2\",\"zonepath\":\"[6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":310,\"name\":\"Titolari_AUI\",\"page\":6,\"spuid\":\"FBHVHLBMPC\",\"src\":\"\\/jsp\\/pg_rapotit_portlet.jsp?ForcedPortletUID=FBHVHLBMPC\",\"tabindex\":4,\"type\":\"Portlet\",\"w\":1008,\"x\":0,\"y\":42,\"zone\":\"pag6_3\",\"zonepath\":\"[6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":256,\"name\":\"Storico_VAR\",\"page\":7,\"spuid\":\"LSVOLXWIKA\",\"src\":\"\\/jsp\\/pg_wersonbo_portlet.jsp?ForcedPortletUID=LSVOLXWIKA\",\"tabindex\":1,\"type\":\"Portlet\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag7_1\",\"zonepath\":\"[7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":256,\"name\":\"Storico_Ker\",\"page\":7,\"spuid\":\"VXXDGFVFTG\",\"src\":\"\\/jsp\\/pg_kersonbo_portlet.jsp?ForcedPortletUID=VXXDGFVFTG\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":1016,\"x\":0,\"y\":259,\"zone\":\"pag7_2\",\"zonepath\":\"[7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiAgg\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Aggiuntivi\",\"groupName\":\"Altri\",\"h\":599,\"name\":\"DatiAgg\",\"page\":8,\"shrinkable\":true,\"spuid\":\"AYKUXGKLPO\",\"stretch\":true,\"tabindex\":5,\"title_caption\":\"Dati Aggiuntivi\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag8_1\",\"zonepath\":\"[8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Banca se Beneficiario\",\"h\":20,\"maxlength\":11,\"name\":\"BANCABEN\",\"page\":8,\"picker\":true,\"spuid\":\"DQZNJUSTLN\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":232,\"y\":518,\"zone\":\"pag8_1_1\",\"zonepath\":\"[8,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VRPSNLYZFA\",\"page\":8,\"spuid\":\"VRPSNLYZFA\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Codice Banca se Beneficiario:\",\"w\":151,\"x\":74,\"y\":522,\"zone\":\"pag8_1_1\",\"zonepath\":\"[8,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XHVCRZXJZF\",\"page\":8,\"spuid\":\"XHVCRZXJZF\",\"tabindex\":9,\"type\":\"Label\",\"w\":568,\"x\":331,\"y\":522,\"zone\":\"pag8_1_1\",\"zonepath\":\"[8,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Segnalazione a UIF\\/BankIT\",\"h\":20,\"maxlength\":10,\"name\":\"DATASEGN\",\"page\":8,\"picker\":true,\"spuid\":\"ESODTMPIYO\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":232,\"y\":546,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KGAUNPQRUF\",\"page\":8,\"spuid\":\"KGAUNPQRUF\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Data Segnalazione a UIF\\/BankIT:\",\"w\":208,\"x\":24,\"y\":550,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Richiesta Autorit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DATARAUT\",\"page\":8,\"picker\":true,\"spuid\":\"UNPDFRUOXO\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":568,\"y\":546,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WXAVWIXQLR\",\"page\":8,\"spuid\":\"WXAVWIXQLR\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Data Richiesta Autorit\\u00E0:\",\"w\":176,\"x\":392,\"y\":550,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":504,\"name\":\"armt_personbo_agg\",\"page\":8,\"spuid\":\"OIREAEXNKZ\",\"tabindex\":4,\"type\":\"Iframe\",\"w\":1045,\"x\":16,\"y\":7,\"zone\":\"pag8_2\",\"zonepath\":\"[8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Dipendenza\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dipendenze Riferimento\",\"groupName\":\"Altri\",\"h\":280,\"name\":\"Dipendenza\",\"page\":8,\"shrinkable\":true,\"spuid\":\"ZETZWJBOFM\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Dipendenze Riferimento\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":609,\"zone\":\"pag8_3\",\"zonepath\":\"[8,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":250,\"name\":\"ardt_personbo_dip\",\"page\":8,\"spuid\":\"BKKASVQSWO\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":329,\"x\":304,\"y\":623,\"zone\":\"pag8_3_1\",\"zonepath\":\"[8,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SogCollegati\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Soggetti Collegati\",\"groupName\":\"Altri\",\"h\":212,\"name\":\"SogCollegati\",\"page\":8,\"shrinkable\":true,\"spuid\":\"XDDGTPJDHN\",\"stretch\":true,\"tabindex\":14,\"title_caption\":\"Soggetti Collegati\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":896,\"zone\":\"pag8_4\",\"zonepath\":\"[8,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":182,\"name\":\"ardt_soggope\",\"page\":8,\"spuid\":\"RYYOFFRITV\",\"tabindex\":15,\"type\":\"Iframe\",\"w\":717,\"x\":96,\"y\":910,\"zone\":\"pag8_4_1\",\"zonepath\":\"[8,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Fatc\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Fatca\\/OCSE\",\"h\":413,\"name\":\"Fatc\",\"page\":9,\"shrinkable\":true,\"spuid\":\"FIXFSIUKKN\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Fatca\\/OCSE\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":7,\"zone\":\"pag9_1\",\"zonepath\":\"[9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato Res. Legale FATCA\",\"h\":20,\"maxlength\":3,\"name\":\"FATCA\",\"page\":9,\"picker\":true,\"spuid\":\"RKHMYOIJDM\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":296,\"y\":16,\"zone\":\"pag9_1_1\",\"zonepath\":\"[9,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KSZOWVNAMH\",\"page\":9,\"spuid\":\"KSZOWVNAMH\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Stato Resid. Legale FATCA:\",\"w\":272,\"x\":16,\"y\":20,\"zone\":\"pag9_1_1\",\"zonepath\":\"[9,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_YJYXHNVCSS\",\"page\":9,\"spuid\":\"YJYXHNVCSS\",\"tabindex\":5,\"type\":\"Label\",\"w\":448,\"x\":361,\"y\":20,\"zone\":\"pag9_1_1\",\"zonepath\":\"[9,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice FATCA\",\"h\":20,\"maxlength\":16,\"name\":\"TIN\",\"page\":9,\"spuid\":\"HBSPPQBOJN\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":296,\"y\":48,\"zone\":\"pag9_1_2\",\"zonepath\":\"[9,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FAHIRFAJYI\",\"page\":9,\"spuid\":\"FAHIRFAJYI\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Identificat. fiscale rilasciato da paese FATCA \\/ OCSE:\",\"w\":272,\"x\":16,\"y\":52,\"zone\":\"pag9_1_2\",\"zonepath\":\"[9,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Ordine di Bonifico Permanente\",\"h\":21,\"label_text\":\"Ordine di bonifico permanente da\\/verso paese FATCA \\/ OCSE\",\"maxlength\":2,\"name\":\"ODB\",\"page\":9,\"spuid\":\"EOYNWRHHMY\",\"tabindex\":8,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":352,\"x\":432,\"y\":48,\"zone\":\"pag9_1_2\",\"zonepath\":\"[9,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":336,\"name\":\"ardt_fatca_ind\",\"page\":9,\"spuid\":\"FBAHOFZNEF\",\"tabindex\":9,\"type\":\"Iframe\",\"w\":781,\"x\":140,\"y\":76,\"zone\":\"pag9_1_3\",\"zonepath\":\"[9,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_CYHJRUWRUL\",\"page\":9,\"picker\":true,\"spuid\":\"CYHJRUWRUL\",\"tabindex\":10,\"type\":\"Button\",\"value\":\"Modifica Dati Fatca\",\"w\":128,\"x\":784,\"y\":371,\"zone\":\"pag9_1_3_1\",\"zonepath\":\"[9,1,3,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"CittaDiv\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Cittadinanze e Residenza se diverse da Italia\",\"h\":91,\"name\":\"CittaDiv\",\"page\":9,\"shrinkable\":true,\"spuid\":\"WEJOYIAYYL\",\"stretch\":true,\"tabindex\":20,\"title_caption\":\"Cittadinanze e Residenza se diverse da Italia\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":427,\"zone\":\"pag9_2\",\"zonepath\":\"[9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Cittadinanza 1\",\"h\":20,\"maxlength\":3,\"name\":\"CITTADIN1\",\"page\":9,\"picker\":true,\"spuid\":\"CJBEXKJOQO\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":128,\"y\":437,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZZTJUXJOVM\",\"page\":9,\"spuid\":\"ZZTJUXJOVM\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Cittadinanza 1:\",\"w\":108,\"x\":16,\"y\":441,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QNTJNWIUJE\",\"page\":9,\"spuid\":\"QNTJNWIUJE\",\"tabindex\":15,\"type\":\"Label\",\"w\":448,\"x\":192,\"y\":441,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"CITTADIN2\",\"page\":9,\"picker\":true,\"spuid\":\"UNRQNVVFTK\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":128,\"y\":461,\"zone\":\"pag9_2_2\",\"zonepath\":\"[9,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PHQZJMYLYP\",\"page\":9,\"spuid\":\"PHQZJMYLYP\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Cittadinanza 2:\",\"w\":108,\"x\":16,\"y\":465,\"zone\":\"pag9_2_2\",\"zonepath\":\"[9,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SBEGVLBNXL\",\"page\":9,\"spuid\":\"SBEGVLBNXL\",\"tabindex\":17,\"type\":\"Label\",\"w\":448,\"x\":192,\"y\":465,\"zone\":\"pag9_2_2\",\"zonepath\":\"[9,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"RESFISC\",\"page\":9,\"picker\":true,\"spuid\":\"OSLBLDODHQ\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":128,\"y\":485,\"zone\":\"pag9_2_3\",\"zonepath\":\"[9,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LENIFRRGPH\",\"page\":9,\"spuid\":\"LENIFRRGPH\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Residenza Fiscale:\",\"w\":108,\"x\":16,\"y\":489,\"zone\":\"pag9_2_3\",\"zonepath\":\"[9,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FLUVMIEXGY\",\"page\":9,\"spuid\":\"FLUVMIEXGY\",\"tabindex\":19,\"type\":\"Label\",\"w\":448,\"x\":192,\"y\":489,\"zone\":\"pag9_2_3\",\"zonepath\":\"[9,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ValRisk\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Tipologia e Valutazione Rischio (III Direttiva)\",\"groupName\":\"Rischio\",\"h\":322,\"name\":\"ValRisk\",\"page\":10,\"shrinkable\":true,\"spuid\":\"WJVOGIFRCK\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Tipologia e Valutazione Rischio (III Direttiva)\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag10_1\",\"zonepath\":\"[10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"COMPORT\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"KYTSUTYBUR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1032,\"y\":103,\"zone\":\"pag10_1\",\"zonepath\":\"[10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"ATTIV\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"QFJRACGINU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1032,\"y\":79,\"zone\":\"pag10_1\",\"zonepath\":\"[10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"AREAGEO\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"JHEJMIHGSH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1032,\"y\":31,\"zone\":\"pag10_1\",\"zonepath\":\"[10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":4,\"name\":\"PKTBSPECIE\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"DRJTSDRPVN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1032,\"y\":55,\"zone\":\"pag10_1\",\"zonepath\":\"[10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YEWQBTSTTE\",\"page\":10,\"spuid\":\"YEWQBTSTTE\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":108,\"x\":8,\"y\":32,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RAREA\",\"page\":10,\"spuid\":\"PGYFWWGOTN\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":907,\"y\":28,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"AREAGEO\",\"page\":10,\"picker\":true,\"spuid\":\"NXVXQSLAGM\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":120,\"y\":28,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OGZVCUPUAY\",\"page\":10,\"spuid\":\"OGZVCUPUAY\",\"tabindex\":21,\"type\":\"Label\",\"w\":680,\"x\":216,\"y\":32,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_RSHHWFKCKZ\",\"page\":10,\"spuid\":\"RSHHWFKCKZ\",\"tabindex\":25,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":416,\"x\":8,\"y\":7,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BUKQJFVQDD\",\"page\":10,\"spuid\":\"BUKQJFVQDD\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"VALUTAZIONE\",\"w\":120,\"x\":827,\"y\":7,\"zone\":\"pag10_1_1\",\"zonepath\":\"[10,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_VTPWYANRQH\",\"page\":10,\"spuid\":\"VTPWYANRQH\",\"tabindex\":22,\"type\":\"Label\",\"w\":680,\"x\":216,\"y\":56,\"zone\":\"pag10_1_2\",\"zonepath\":\"[10,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RNATGIU\",\"page\":10,\"spuid\":\"AAQYBAEHUR\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":907,\"y\":52,\"zone\":\"pag10_1_2\",\"zonepath\":\"[10,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":4,\"name\":\"PKTBSPECIE\",\"page\":10,\"picker\":true,\"spuid\":\"VHXDWWHVXF\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":120,\"y\":52,\"zone\":\"pag10_1_2\",\"zonepath\":\"[10,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JMXSJAUKOO\",\"page\":10,\"spuid\":\"JMXSJAUKOO\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Natura Giuridica.:\",\"w\":108,\"x\":8,\"y\":56,\"zone\":\"pag10_1_2\",\"zonepath\":\"[10,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SCYSGLNMDS\",\"page\":10,\"spuid\":\"SCYSGLNMDS\",\"tabindex\":23,\"type\":\"Label\",\"w\":680,\"x\":216,\"y\":80,\"zone\":\"pag10_1_3\",\"zonepath\":\"[10,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RATTIV\",\"page\":10,\"spuid\":\"BOECHNDAXS\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":907,\"y\":76,\"zone\":\"pag10_1_3\",\"zonepath\":\"[10,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HQMBYZTNNT\",\"page\":10,\"spuid\":\"HQMBYZTNNT\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Prevalente Attivit\\u00E0:\",\"w\":108,\"x\":8,\"y\":80,\"zone\":\"pag10_1_3\",\"zonepath\":\"[10,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codifica ATECO\",\"h\":20,\"maxlength\":10,\"name\":\"ATTIVR\",\"page\":10,\"picker\":true,\"spuid\":\"UQYOQYIUNM\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":120,\"y\":76,\"zone\":\"pag10_1_3\",\"zonepath\":\"[10,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_GVJJFQWUGU\",\"page\":10,\"spuid\":\"GVJJFQWUGU\",\"tabindex\":24,\"type\":\"Label\",\"w\":680,\"x\":216,\"y\":104,\"zone\":\"pag10_1_4\",\"zonepath\":\"[10,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"COMPORT\",\"page\":10,\"picker\":true,\"spuid\":\"HLXRSSMBIW\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":120,\"y\":100,\"zone\":\"pag10_1_4\",\"zonepath\":\"[10,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UEHIJUXEBZ\",\"page\":10,\"spuid\":\"UEHIJUXEBZ\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Comportamento:\",\"w\":108,\"x\":8,\"y\":104,\"zone\":\"pag10_1_4\",\"zonepath\":\"[10,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RCOMP\",\"page\":10,\"spuid\":\"ISJKSRTDAC\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":907,\"y\":100,\"zone\":\"pag10_1_4\",\"zonepath\":\"[10,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JKZZQYXAFS\",\"page\":10,\"spuid\":\"JKZZQYXAFS\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Rischio Globale:\",\"w\":108,\"x\":8,\"y\":270,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ROVJICRYAM\",\"page\":10,\"spuid\":\"ROVJICRYAM\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Data Revisione Profilatura:\",\"w\":135,\"x\":728,\"y\":270,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TTZXYWANKG\",\"page\":10,\"spuid\":\"TTZXYWANKG\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"Data Profilatura:\",\"w\":86,\"x\":532,\"y\":270,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Revisione Profilatura\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREVPROF\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"QLLLNEUVYW\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":867,\"y\":266,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Profilatura\",\"h\":20,\"maxlength\":10,\"name\":\"DATAPROF\",\"page\":10,\"picker\":true,\"spuid\":\"MXITFMGTNB\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":622,\"y\":266,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Globale\",\"h\":20,\"maxlength\":3,\"name\":\"RISGLOB\",\"page\":10,\"spuid\":\"SMVVFHCEHA\",\"tabindex\":29,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":408,\"x\":120,\"y\":266,\"zone\":\"pag10_1_5\",\"zonepath\":\"[10,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":21,\"name\":\"button_ESBPIXCOCR\",\"page\":10,\"picker\":true,\"spuid\":\"ESBPIXCOCR\",\"tabindex\":36,\"type\":\"Button\",\"value\":\"Crime\",\"w\":83,\"x\":653,\"y\":290,\"zone\":\"pag10_1_6\",\"zonepath\":\"[10,1,6]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Presente in liste Crime\",\"h\":21,\"label_text\":\"Presenza in liste CRIME\",\"maxlength\":1,\"name\":\"CRIME\",\"page\":10,\"spuid\":\"RHCYCLTWOT\",\"tabindex\":35,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":206,\"x\":432,\"y\":290,\"zone\":\"pag10_1_6\",\"zonepath\":\"[10,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Persona Politicamente Esposta\",\"h\":21,\"label_text\":\"Persona Esposta Politicamente\",\"maxlength\":1,\"name\":\"PEP\",\"page\":10,\"spuid\":\"XFKXBQYUIU\",\"tabindex\":33,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":206,\"x\":120,\"y\":290,\"zone\":\"pag10_1_6\",\"zonepath\":\"[10,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":21,\"name\":\"button_BCZWUTGYEU\",\"page\":10,\"picker\":true,\"spuid\":\"BCZWUTGYEU\",\"tabindex\":34,\"type\":\"Button\",\"value\":\"P.E.P.\",\"w\":83,\"x\":341,\"y\":290,\"zone\":\"pag10_1_6\",\"zonepath\":\"[10,1,6]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CPCPDBCTVR\",\"page\":10,\"spuid\":\"CPCPDBCTVR\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Tipo Adeguata Verifica:\",\"w\":128,\"x\":735,\"y\":130,\"zone\":\"pag10_1_7\",\"zonepath\":\"[10,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CUGDSJZWEC\",\"page\":10,\"spuid\":\"CUGDSJZWEC\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Dati Supplementari:\",\"w\":108,\"x\":8,\"y\":128,\"zone\":\"pag10_1_7\",\"zonepath\":\"[10,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Adeguata Verifica\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VERIFICA\",\"page\":10,\"spuid\":\"OXWRJNTXVJ\",\"tabindex\":47,\"textlist\":\"Ordinaria,Semplificata,Rafforzata,Non Applicabile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"O"+"'"+","+"'"+"S"+"'"+","+"'"+"R"+"'"+","+"'"+"N"+"'"+"\",\"w\":141,\"x\":867,\"y\":126,\"zone\":\"pag10_1_7\",\"zonepath\":\"[10,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":100,\"name\":\"DOCFILE\",\"page\":10,\"readonly\":\"true\",\"spuid\":\"CWIQJZFJRS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":120,\"y\":124,\"zone\":\"pag10_1_7\",\"zonepath\":\"[10,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JVQICCQATG\",\"page\":10,\"spuid\":\"JVQICCQATG\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Note Rischio:\",\"w\":69,\"x\":51,\"y\":154,\"zone\":\"pag10_1_8\",\"zonepath\":\"[10,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Note Rischio\",\"h\":105,\"name\":\"NOTERIS\",\"page\":10,\"scroll\":true,\"spuid\":\"FTYWOEFIPD\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":888,\"x\":120,\"y\":154,\"zone\":\"pag10_1_8\",\"zonepath\":\"[10,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"button_ZFPXBMEPWE\",\"page\":10,\"picker\":true,\"spuid\":\"ZFPXBMEPWE\",\"tabindex\":32,\"type\":\"Button\",\"value\":\"Calcola\",\"w\":104,\"x\":952,\"y\":266,\"zone\":\"pag10_2\",\"zonepath\":\"[10,2]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"MitRisk\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Mitigazione Rischio\",\"groupName\":\"Rischio\",\"h\":51,\"name\":\"MitRisk\",\"page\":10,\"shrinkable\":true,\"spuid\":\"XTDFJTMZAQ\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Mitigazione Rischio\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":322,\"zone\":\"pag10_3\",\"zonepath\":\"[10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mitigazione (+\\/-)\",\"h\":20,\"maxlength\":5,\"name\":\"MITIG\",\"page\":10,\"spuid\":\"DOXBACRWUU\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":160,\"y\":327,\"zone\":\"pag10_3_1\",\"zonepath\":\"[10,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCBMHLXJMD\",\"page\":10,\"spuid\":\"VCBMHLXJMD\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":128,\"x\":30,\"y\":331,\"zone\":\"pag10_3_1\",\"zonepath\":\"[10,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NKPWKMDXUR\",\"page\":10,\"spuid\":\"NKPWKMDXUR\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"%\",\"w\":22,\"x\":203,\"y\":331,\"zone\":\"pag10_3_1\",\"zonepath\":\"[10,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Documentazione Mitigazione\",\"h\":20,\"maxlength\":100,\"name\":\"MITIGDOC\",\"page\":10,\"spuid\":\"OXGBDTWKSX\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":349,\"zone\":\"pag10_3_2\",\"zonepath\":\"[10,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKJNNGBWFM\",\"page\":10,\"spuid\":\"PKJNNGBWFM\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":148,\"x\":10,\"y\":353,\"zone\":\"pag10_3_2\",\"zonepath\":\"[10,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Patrimonio\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Patrimonio\",\"groupName\":\"Rischio\",\"h\":224,\"name\":\"Patrimonio\",\"page\":10,\"shrinkable\":true,\"spuid\":\"TKKVDEVHBF\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Patrimonio\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":379,\"zone\":\"pag10_4\",\"zonepath\":\"[10,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":210,\"name\":\"ardt_patrimonio\",\"page\":10,\"spuid\":\"FFIYUAKUTX\",\"tabindex\":39,\"type\":\"Iframe\",\"w\":706,\"x\":56,\"y\":385,\"zone\":\"pag10_4_1\",\"zonepath\":\"[10,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Reddito\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Reddito\",\"groupName\":\"Rischio\",\"h\":220,\"name\":\"Reddito\",\"page\":10,\"shrinkable\":true,\"spuid\":\"STJESIOURE\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Reddito\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":604,\"zone\":\"pag10_5\",\"zonepath\":\"[10,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":210,\"name\":\"ardt_reddito\",\"page\":10,\"spuid\":\"COWMRLCMMU\",\"tabindex\":40,\"type\":\"Iframe\",\"w\":726,\"x\":56,\"y\":609,\"zone\":\"pag10_5_1\",\"zonepath\":\"[10,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"RilAnom\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Rilevazione Anomalie\",\"groupName\":\"Rischio\",\"h\":560,\"name\":\"RilAnom\",\"page\":11,\"shrinkable\":true,\"spuid\":\"SSIHDIOVZQ\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Rilevazione Anomalie\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag11_1\",\"zonepath\":\"[11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":546,\"name\":\"Rilevazioni\",\"page\":11,\"spuid\":\"VKUMQAHFDZ\",\"src\":\"\\/jsp\\/pg_rilevazioni_anomalie_portlet.jsp?ForcedPortletUID=VKUMQAHFDZ\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":7,\"zone\":\"pag11_1_1\",\"zonepath\":\"[11,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_personboBO BO,ServletStatus status) {
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
     "<script src='armt_personbo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_edit.js'>" +
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
      status.out.println("w_TIPOPERS=a[0];");
      status.out.println("w_COGNOME=a[1];");
      status.out.println("w_NOME=a[2];");
      status.out.println("w_CFESTERO=a[3];");
      status.out.println("w_RAGSOC=a[4];");
      status.out.println("w_PAESE=a[5];");
      status.out.println("w_DESCCIT=a[6];");
      status.out.println("w_idcitta=a[7];");
      status.out.println("w_PROVINCIA=a[8];");
      status.out.println("w_CAP=a[9];");
      status.out.println("w_CODCAB=a[10];");
      status.out.println("w_DOMICILIO=a[11];");
      status.out.println("w_IDENT=a[12];");
      status.out.println("w_IDNASCOMUN=a[13];");
      status.out.println("w_NASCOMUN=a[14];");
      status.out.println("w_TIPINTER=a[15];");
      status.out.println("w_IDNASSTATO=a[16];");
      status.out.println("w_NASSTATO=a[17];");
      status.out.println("w_SESSO=a[18];");
      status.out.println("w_DATANASC=a[19];");
      status.out.println("w_TIPODOC=a[20];");
      status.out.println("w_NUMDOCUM=a[21];");
      status.out.println("w_DATARILASC=a[22];");
      status.out.println("w_DATAVALI=a[23];");
      status.out.println("w_AUTRILASC=a[24];");
      status.out.println("w_CODFISC=a[25];");
      status.out.println("w_PARTIVA=a[26];");
      status.out.println("w_CONTO=a[27];");
      status.out.println("w_SOTGRUP=a[28];");
      status.out.println("w_RAMOGRUP=a[29];");
      status.out.println("w_ATTIV=a[30];");
      status.out.println("w_SETTSINT=a[31];");
      status.out.println("w_CONNES=a[32];");
      status.out.println("w_NOSARA=a[33];");
      status.out.println("w_NOTIT=a[34];");
      status.out.println("w_PROGIMPORT=a[35];");
      status.out.println("op_PROGIMPORT=a[36];");
      status.out.println("w_OLDSETSIN=a[37];");
      status.out.println("w_CRIMEDATE=a[38];");
      status.out.println("w_PEPDATE=a[39];");
      status.out.println("w_NOTE=a[40];");
      status.out.println("w_CODLEGRAP=a[41];");
      status.out.println("w_FATCA=a[42];");
      status.out.println("w_TIN=a[43];");
      status.out.println("w_ODB=a[44];");
      status.out.println("w_AREAGEO=a[45];");
      status.out.println("w_RAREA=a[46];");
      status.out.println("w_PKTBSPECIE=a[47];");
      status.out.println("w_RNATGIU=a[48];");
      status.out.println("w_RATTIV=a[49];");
      status.out.println("w_COMPORT=a[50];");
      status.out.println("w_RCOMP=a[51];");
      status.out.println("w_DOCFILE=a[52];");
      status.out.println("w_RISGLOB=a[53];");
      status.out.println("w_DATAPROF=a[54];");
      status.out.println("w_DATAREVPROF=a[55];");
      status.out.println("w_PEP=a[56];");
      status.out.println("w_CRIME=a[57];");
      status.out.println("w_MITIG=a[58];");
      status.out.println("w_MITIGDOC=a[59];");
      status.out.println("w_DATAFINE=a[60];");
      status.out.println("w_DATAINI=a[61];");
      status.out.println("w_DISATTIVO=a[62];");
      status.out.println("w_TIPOSOGGETTO=a[63];");
      status.out.println("w_RAPSEGNA=a[64];");
      status.out.println("w_SOGAFFIDATARIO=a[65];");
      status.out.println("w_CAUSALE=a[66];");
      status.out.println("w_FATTURATO=a[67];");
      status.out.println("w_FLGNOTRIM=a[68];");
      status.out.println("w_DATAIDENT=a[69];");
      status.out.println("w_CITTADIN1=a[70];");
      status.out.println("w_CITTADIN2=a[71];");
      status.out.println("w_RESFISC=a[72];");
      status.out.println("w_BANCABEN=a[73];");
      status.out.println("w_DATASEGN=a[74];");
      status.out.println("w_DATARAUT=a[75];");
      status.out.println("w_VERIFICA=a[76];");
      status.out.println("w_CODINTER=a[77];");
      status.out.println("w_NUMIMP=a[78];");
      status.out.println("w_CODDIPE=a[79];");
      status.out.println("w_SOSPMAF=a[80];");
      status.out.println("w_OLDCONNES=a[81];");
      status.out.println("w_DATEXTRA=a[82];");
      status.out.println("w_ALLINEATO=a[83];");
      status.out.println("w_ALLINEATONOMECNOME=a[84];");
      status.out.println("w_RAGSOCOLD=a[85];");
      status.out.println("w_PROGIMP_C=a[86];");
      status.out.println("w_IDFILE=a[87];");
      status.out.println("w_OLDCODFISC=a[88];");
      status.out.println("w_MACROAGENTE=a[89];");
      status.out.println("w_SPOTID=a[90];");
      status.out.println("w_DATAVARAGE=a[91];");
      status.out.println("w_SETTSINT2=a[92];");
      status.out.println("w_TELEF=a[93];");
      status.out.println("w_TIPOORO=a[94];");
      status.out.println("w_CODORO=a[95];");
      status.out.println("w_FLGVALIDO=a[96];");
      status.out.println("w_DAC6=a[97];");
      status.out.println("w_ALTRODOM=a[98];");
      status.out.println("w_ALTROCAP=a[99];");
      status.out.println("w_IMPORTOMAX=a[100];");
      status.out.println("w_FREQUENZA=a[101];");
      status.out.println("w_NUMOPERAZ=a[102];");
      status.out.println("w_DATASIGN=a[103];");
      status.out.println("w_IDBASE=a[104];");
      status.out.println("w_FLAGDAC6=a[105];");
      status.out.println("w_NOTERIS=a[106];");
      status.out.println("w_gIntemediario=a[107];");
      status.out.println("w_gFlgWU=a[108];");
      status.out.println("w_gSeekAos=a[109];");
      status.out.println("w_gDataVaria=a[110];");
      status.out.println("w_gFlgDoc=a[111];");
      status.out.println("w_gTipInter=a[112];");
      status.out.println("w_gVerSim=a[113];");
      status.out.println("w_gCodDip=a[114];");
      status.out.println("w_dataoggi=a[115];");
      status.out.println("w_nascomunid=a[116];");
      status.out.println("w_nasstatoid=a[117];");
      status.out.println("w_flgaggfam=a[118];");
      status.out.println("w_DATARETT=a[119];");
      status.out.println("w_STATOREG=a[120];");
      status.out.println("w_NUMPROG=a[121];");
      status.out.println("w_tipsot=a[122];");
      status.out.println("w_DESCSGRU=a[123];");
      status.out.println("w_DESCRAMGRU=a[124];");
      status.out.println("w_DESCUIC=a[125];");
      status.out.println("w_dessta=a[126];");
      status.out.println("w_DESCRI=a[127];");
      status.out.println("w_xstatonas=a[128];");
      status.out.println("w_finesae=a[129];");
      status.out.println("w_finesint=a[130];");
      status.out.println("w_xFLGVALIDO=a[131];");
      status.out.println("w_xFLGANAVAL=a[132];");
      status.out.println("w_ragbanben=a[133];");
      status.out.println("w_xdesfatca=a[134];");
      status.out.println("w_ATTIVR=a[135];");
      status.out.println("w_xDESDIPE=a[136];");
      status.out.println("w_xDSETSIN=a[137];");
      status.out.println("w_xdesctipatt=a[138];");
      status.out.println("w_xdescareag=a[139];");
      status.out.println("w_xdescnatgiu=a[140];");
      status.out.println("w_xdesccomp=a[141];");
      status.out.println("w_xITFLGPEP=a[142];");
      status.out.println("w_xDesCit1=a[143];");
      status.out.println("w_xDesCit2=a[144];");
      status.out.println("w_xResFis=a[145];");
      status.out.println("w_xRAGLEGRAP=a[146];");
      status.out.println("w_xIDLEGRAP=a[147];");
      status.out.println("w_FLGALTO=a[148];");
      status.out.println("w_COMPLETA=a[149];;");
      status.out.println("w_status=a[150];");
      status.out.println("op_codazi=a[151];");
      status.out.println("m_cWv_ardt_personbo_dip=a[152];");
      status.out.println("m_cWv_armt_personbo_agg=a[153];");
      status.out.println("m_cWv_ardt_soggope=a[154];");
      status.out.println("m_cWv_ardt_fatca_ind=a[155];");
      status.out.println("m_cWv_ardt_patrimonio=a[156];");
      status.out.println("m_cWv_ardt_reddito=a[157];");
      status.out.println("if (Gt(a.length,158)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,158)) {");
      status.out.println("o_gIntemediario=w_gIntemediario;");
      status.out.println("o_COGNOME=w_COGNOME;");
      status.out.println("o_NOME=w_NOME;");
      status.out.println("o_PAESE=w_PAESE;");
      status.out.println("o_DESCCIT=w_DESCCIT;");
      status.out.println("o_idcitta=w_idcitta;");
      status.out.println("o_IDNASCOMUN=w_IDNASCOMUN;");
      status.out.println("o_IDNASSTATO=w_IDNASSTATO;");
      status.out.println("o_NASSTATO=w_NASSTATO;");
      status.out.println("o_DATANASC=w_DATANASC;");
      status.out.println("o_TIPODOC=w_TIPODOC;");
      status.out.println("o_NUMDOCUM=w_NUMDOCUM;");
      status.out.println("o_DATARILASC=w_DATARILASC;");
      status.out.println("o_DATAVALI=w_DATAVALI;");
      status.out.println("o_SOTGRUP=w_SOTGRUP;");
      status.out.println("o_RAMOGRUP=w_RAMOGRUP;");
      status.out.println("o_ATTIV=w_ATTIV;");
      status.out.println("o_CONNES=w_CONNES;");
      status.out.println("o_tipsot=w_tipsot;");
      status.out.println("o_AREAGEO=w_AREAGEO;");
      status.out.println("o_PKTBSPECIE=w_PKTBSPECIE;");
      status.out.println("o_ATTIVR=w_ATTIVR;");
      status.out.println("o_COMPORT=w_COMPORT;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CONNES'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(827,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","personbo");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CONNES");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_personboBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_personboBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_personboBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_personboBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arfn_agechar.m_cEntityUid+"/arfn_agechar.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chk_tiporapporto.m_cEntityUid+"/arfn_chk_tiporapporto.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkateco.m_cEntityUid+"/arfn_chkateco.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chklundoc.m_cEntityUid+"/arfn_chklundoc.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chksint.m_cEntityUid+"/arfn_chksint.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calccodfis.m_cEntityUid+"/arrt_calccodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calccodfis_obj.m_cEntityUid+"/arrt_calccodfis_obj.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calcola_datarevprof.m_cEntityUid+"/arrt_calcola_datarevprof.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calcolasett.m_cEntityUid+"/arrt_calcolasett.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_sblocco_modifica.m_cEntityUid+"/arrt_sblocco_modifica.js'>" +
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
      arfn_chk_tiporapporto.GetCallableNames(callable);
      arfn_chkateco.GetCallableNames(callable);
      arfn_chkcodfis.GetCallableNames(callable);
      arfn_chklundoc.GetCallableNames(callable);
      arfn_chksint.GetCallableNames(callable);
      arrt_calccodfis.GetCallableNames(callable);
      arrt_calccodfis_obj.GetCallableNames(callable);
      arrt_calcola_datarevprof.GetCallableNames(callable);
      arrt_calcolasett.GetCallableNames(callable);
      arrt_sblocco_modifica.GetCallableNames(callable);
      arrt_load_fatca.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"ardt_personbo_dip");
      CPLib.AddToSet(callable,"armt_personbo_agg");
      CPLib.AddToSet(callable,"ardt_soggope");
      CPLib.AddToSet(callable,"ardt_fatca_ind");
      CPLib.AddToSet(callable,"ardt_patrimonio");
      CPLib.AddToSet(callable,"ardt_reddito");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_personboBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CONNES),"C",16,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gIntemediario),"C",11,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSeekAos),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gVerSim),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
    } else if (CPLib.eq(p_cUID,"LDTVEYLAXJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TYEDHRZCMA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BYPEBFEOAJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZRIWLTGERM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IOAMSFCCVV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AHFPACGVOQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MBGANUUHRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LLYIGAMXRH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RVNHQCXNEM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SAQTIHOALW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZGNLLSFQHC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MQYKJYJENJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CKHRNQSKKQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DQZNJUSTLN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RKHMYOIJDM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CJBEXKJOQO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UNRQNVVFTK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OSLBLDODHQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NXVXQSLAGM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JHEJMIHGSH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VHXDWWHVXF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DRJTSDRPVN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UQYOQYIUNM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QFJRACGINU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HLXRSSMBIW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KYTSUTYBUR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_personboBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_gIntemediario))) {
        a = GetCheckVars(status,BO,"LDTVEYLAXJ");
        b = status.m_CheckVars.optString("LDTVEYLAXJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_idcitta))) {
        a = GetCheckVars(status,BO,"TYEDHRZCMA");
        b = status.m_CheckVars.optString("TYEDHRZCMA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_IDNASCOMUN))) {
        a = GetCheckVars(status,BO,"BYPEBFEOAJ");
        b = status.m_CheckVars.optString("BYPEBFEOAJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_nascomunid))) {
        a = GetCheckVars(status,BO,"ZRIWLTGERM");
        b = status.m_CheckVars.optString("ZRIWLTGERM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_IDNASSTATO))) {
        a = GetCheckVars(status,BO,"IOAMSFCCVV");
        b = status.m_CheckVars.optString("IOAMSFCCVV");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_nasstatoid))) {
        a = GetCheckVars(status,BO,"AHFPACGVOQ");
        b = status.m_CheckVars.optString("AHFPACGVOQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPODOC))) {
        a = GetCheckVars(status,BO,"MBGANUUHRA");
        b = status.m_CheckVars.optString("MBGANUUHRA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_SOTGRUP))) {
        a = GetCheckVars(status,BO,"LLYIGAMXRH");
        b = status.m_CheckVars.optString("LLYIGAMXRH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAMOGRUP))) {
        a = GetCheckVars(status,BO,"RVNHQCXNEM");
        b = status.m_CheckVars.optString("RVNHQCXNEM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_SETTSINT))) {
        a = GetCheckVars(status,BO,"ZGNLLSFQHC");
        b = status.m_CheckVars.optString("ZGNLLSFQHC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODLEGRAP))) {
        a = GetCheckVars(status,BO,"CKHRNQSKKQ");
        b = status.m_CheckVars.optString("CKHRNQSKKQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_BANCABEN))) {
        a = GetCheckVars(status,BO,"DQZNJUSTLN");
        b = status.m_CheckVars.optString("DQZNJUSTLN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_FATCA))) {
        a = GetCheckVars(status,BO,"RKHMYOIJDM");
        b = status.m_CheckVars.optString("RKHMYOIJDM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CITTADIN1))) {
        a = GetCheckVars(status,BO,"CJBEXKJOQO");
        b = status.m_CheckVars.optString("CJBEXKJOQO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CITTADIN2))) {
        a = GetCheckVars(status,BO,"UNRQNVVFTK");
        b = status.m_CheckVars.optString("UNRQNVVFTK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RESFISC))) {
        a = GetCheckVars(status,BO,"OSLBLDODHQ");
        b = status.m_CheckVars.optString("OSLBLDODHQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"NXVXQSLAGM");
        b = status.m_CheckVars.optString("NXVXQSLAGM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"JHEJMIHGSH");
        b = status.m_CheckVars.optString("JHEJMIHGSH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PKTBSPECIE))) {
        a = GetCheckVars(status,BO,"VHXDWWHVXF");
        b = status.m_CheckVars.optString("VHXDWWHVXF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PKTBSPECIE))) {
        a = GetCheckVars(status,BO,"DRJTSDRPVN");
        b = status.m_CheckVars.optString("DRJTSDRPVN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_COMPORT))) {
        a = GetCheckVars(status,BO,"HLXRSSMBIW");
        b = status.m_CheckVars.optString("HLXRSSMBIW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_COMPORT))) {
        a = GetCheckVars(status,BO,"KYTSUTYBUR");
        b = status.m_CheckVars.optString("KYTSUTYBUR");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
