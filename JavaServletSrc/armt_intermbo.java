import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({"Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"})
public class armt_intermbo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*bb651020*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "intermbo";
    }
    public String w_CODINTER;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CODINTER,context,"intermbo","CODINTER","C",11,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='CODINTER' type='hidden' value="+SPLib.ToHTMLValue(w_CODINTER,"C",11,0)+">" +
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
    armt_intermboBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_intermbo;
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
      status.w_CODINTER = BO.w_CODINTER;
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
    return "Intermediario";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_intermbo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1030;
    l_eg.m_nEntityHeight = 662;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"intermbo","tbtipint","tbcitta","tbstati","tbstgru","tbramgru","tbsetsin","tbtipdoc","anadip"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Intermediario","page"),new ZoneItem("page_2","Settaggi Applicativo","page"),new ZoneItem("page_3","Cambiavalute / Bil. Pagamenti / OAM","page"),new ZoneItem("page_4","CGO (1)","page"),new ZoneItem("page_5","CGO (2)","page"),new ZoneItem("page_6","CGO (3)","page"),new ZoneItem("DatiBase","DatiBase","horizontal_section"),new ZoneItem("box_BWMEEFCWMJ","",""),new ZoneItem("box_FJJCZFOQTA","",""),new ZoneItem("box_PRFPRMFSTZ","",""),new ZoneItem("upload","","layer"),new ZoneItem("scadenze","","layer"),new ZoneItem("ParamBase","Parametri di Base","horizontal_section"),new ZoneItem("PEP","Collegamento con Liste PEP","horizontal_section"),new ZoneItem("CGOEmail","Parametri Per EMAIL Alert","horizontal_section"),new ZoneItem("Import","Parametri Import Schedulato","horizontal_section"),new ZoneItem("Cambiavalute","Cambiavalute","horizontal_section"),new ZoneItem("Base9Cambia","Comunicazioni Oggettive","horizontal_section"),new ZoneItem("DestWarn","Destinatari Warning","horizontal_section"),new ZoneItem("OAM","OAM","horizontal_section"),new ZoneItem("CGO","CGO","horizontal_section"),new ZoneItem("Socket","Validazione Socket","horizontal_section"),new ZoneItem("RespAnti","Responsabili AntiRiciclaggio","horizontal_section"),new ZoneItem("CGOEmail","Parametri Per EMAIL Alert","horizontal_section"),new ZoneItem("GesDOC","Gestione Documentale","horizontal_section"),new ZoneItem("box_EOMKPJOLGE","Path Documenti Bacheca","horizontal_section"),new ZoneItem("E-Learning","E-Learning","horizontal_section"),new ZoneItem("Multiple","Default Multiple","horizontal_section"),new ZoneItem("ExtSO","Estrazione Scarico Offline","horizontal_section"),new ZoneItem("DestEmail","Destinatari Email 380 Schedulato","horizontal_section"),new ZoneItem("ImportVLT","Parametri per import VLT","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CODINTER"};
    l_eg.items = new SPItem[]{
                   new SPItem("TIPINTER","C",2,0, "edit","Tipo Intermediario"),
                   new SPItem("RAGSOC","C",70,0, "edit","Ragione Sociale"),
                   new SPItem("DESCCIT","C",30,0, "edit","Città"),
                   new SPItem("PROVINCIA","C",2,0, "edit","Provincia"),
                   new SPItem("CAP","C",9,0, "edit","CAP"),
                   new SPItem("CODCAB","C",6,0, "edit","CAB"),
                   new SPItem("DOMICILIO","C",35,0, "edit","Indirizzo"),
                   new SPItem("PAESE","C",3,0, "edit","Stato"),
                   new SPItem("CODFISC","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("PARTIVA","C",14,0, "edit","Partita IVA"),
                   new SPItem("DATANASC","D",8,0, "edit","Data Passaggio EURO"),
                   new SPItem("SOTGRUP","C",3,0, "edit","Sottogruppo Att. Ec."),
                   new SPItem("RAMOGRUP","C",3,0, "edit","Ramo Gruppo Att. Ec."),
                   new SPItem("SETTSINT","C",3,0, "edit","Settorizzazione UIC"),
                   new SPItem("TIPODOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("NUMDOCUM","C",15,0, "edit","Numero Documento"),
                   new SPItem("DATARILASC","D",8,0, "edit","Data Rilascio"),
                   new SPItem("AUTRILASC","C",30,0, "edit","Autorità Competente"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("CONNES","C",16,0, "hide","Codice Collegamento"),
                   new SPItem("NOTE","M",10,0, "edit","Annotazioni"),
                   new SPItem("CODORO","C",20,0, "edit","Cod. Segnalante ORO"),
                   new SPItem("CODINTER","C",11,0, "edit","Codice"),
                   new SPItem("TIPOPERS","C",1,0, "hide","Tipo Persona"),
                   new SPItem("IDCITTA","C",10,0, "hide","Codice Città"),
                   new SPItem("DESCRIsta","C",30,0, "hide","Descrizione"),
                   new SPItem("DESCSGRU","C",60,0, "hide","Descrizione"),
                   new SPItem("DESCRAMGRU","C",70,0, "hide","Descrizione"),
                   new SPItem("DESCUIC","C",60,0, "hide","Descrizione"),
                   new SPItem("descdip","C",30,0, "hide","Descrizione"),
                   new SPItem("tipsot","C",1,0, "hide","Tipo"),
                   new SPItem("xdescitdip","C",30,0, "hide","Città"),
                   new SPItem("xcabdip","C",6,0, "hide","CAB"),
                   new SPItem("DATAVALI","D",8,0, "edit","Data Rilascio"),
                   new SPItem("gUserCode","N",4,0, "hide","Codice Utente CP"),
                   new SPItem("CONTATORE","N",15,0, "hide","Contatore"),
                   new SPItem("ATTIV","C",10,0, "hide",""),
                   new SPItem("CFINVIO","C",16,0, "edit","Codice Fiscale Organo Invio File"),
                   new SPItem("CAFINVIO","C",5,0, "edit","Codice CAF Organo Invio"),
                   new SPItem("FILEINVIO","C",1,0, "edit","Tipo Preparazione FIle"),
                   new SPItem("DATAINVIO","D",8,0, "edit","Data Impegno"),
                   new SPItem("IDSID","C",8,0, "edit","Identificativo SID"),
                   new SPItem("SIDPASS","C",30,0, "edit","Password"),
                   new SPItem("PATHJAVA","C",250,0, "edit","Percorso Java VM (JRE)"),
                   new SPItem("TIPOINST","C",1,0, "edit","Tipo Installazione"),
                   new SPItem("FLGSIDAUTO","N",1,0, "edit",""),
                   new SPItem("gUrlApp","C",80,0, "hide","URL Applicazione"),
                   new SPItem("gAzienda","C",10,0, "hide","Azienda"),
                   new SPItem("appocert","C",10,0, "edit",""),
                   new SPItem("TIPOSV","C",3,0, "edit","Canale Distributivo (SV)"),
                   new SPItem("LIMITE20","D",8,0, "edit","Passaggio a \u20ac 5.000"),
                   new SPItem("CODVASP","C",10,0, "edit","VASP Registration Number"),
                   new SPItem("ART1","N",1,0, "edit","Controllo tetto \u20ac 5000"),
                   new SPItem("URLAPPL","C",80,0, "edit","URL Applicazione"),
                   new SPItem("FLGLOG","C",1,0, "edit","Attivazione Log Procedura"),
                   new SPItem("FLGAOS","C",1,0, "edit","Collegamento con AOS"),
                   new SPItem("FLGEAOS","C",1,0, "edit","Ereditarietà Fattori Rischio"),
                   new SPItem("FLGCDOC","C",1,0, "edit","Collegamento anagrafica documenti"),
                   new SPItem("FLGFRAZ","C",1,0, "edit","Aggerega solo frazionate"),
                   new SPItem("FLGAPERS","C",1,0, "edit","Campo Aggiuntivo In ARCHPERS"),
                   new SPItem("DTINIATT","D",8,0, "edit","Data Inizio Attività"),
                   new SPItem("FLGTIPIMP","C",1,0, "edit","Tipo Import per Scheduler"),
                   new SPItem("FLGSTPCON","C",1,0, "edit","Crea Stampa Controllo"),
                   new SPItem("FLGIMPAGE","C",1,0, "edit","Tipo Import Age"),
                   new SPItem("FLGWU","C",1,0, "edit","Gestione Western Union"),
                   new SPItem("IMPINTOPE","N",12,2, "edit","Importo per raggruppamento frazionate"),
                   new SPItem("FLGOPEXTR","C",1,0, "edit","Crea movimento modifica in anagrafe operazioni extraconto"),
                   new SPItem("FLGRAPCLI","C",1,0, "edit","Seleziona Automaticamente CLienti da rapport in import operazioni"),
                   new SPItem("FLGDATAIM","N",1,0, "hide","Forza Data Import = Data Sistema"),
                   new SPItem("FLGDATATP","N",1,0, "hide","Forza Data Trasferimento Provvisorio = Data Sistema"),
                   new SPItem("NOCODFISC","N",1,0, "edit","Non effettuare calcolo automatico codice fiscale in anagrafica persone"),
                   new SPItem("FLGCHK","C",1,0, "edit","Collegamento a WEBCHK"),
                   new SPItem("CODAGE","C",7,0, "hide","Identificativo Agenzia Entrate"),
                   new SPItem("PWDSER","C",10,0, "edit",""),
                   new SPItem("SOSPMAF","C",1,0, "edit","Passato EURO"),
                   new SPItem("FLGRITORNO","C",1,0, "edit","Creazione Inversa File di Import prima di passaggio a definitivo"),
                   new SPItem("FLGCREAAGE","C",1,0, "edit","Crea rettifiche/cancellazioni per Agenzia Entrate"),
                   new SPItem("DTTITAGE","D",8,0, "edit","Data da cui inviare i titolari effettivi"),
                   new SPItem("SCADSALDI","D",8,0, "edit","Data Scadenza Invio Saldi"),
                   new SPItem("FLGIPMT","C",1,0, "edit","IDP MoneyTransfer"),
                   new SPItem("LIMITEFRZ","N",10,2, "edit","Minimo Controllo Fraz."),
                   new SPItem("LIMITEFRZ","N",10,2, "hide","Minimo Controllo Fraz."),
                   new SPItem("DBPROT","C",100,0, "edit","Modello Ad. Verifica"),
                   new SPItem("OAMTPDOC","N",1,0, "edit","Gestione documenti per OAM"),
                   new SPItem("DAYSIMPORT","N",2,0, "edit","Giorni Differenza Import"),
                   new SPItem("DAYSIMPCMB","N",2,0, "edit","Giorni Import Cambiavalute"),
                   new SPItem("FLGAWUPOS","C",1,0, "edit","Attiva gestione WUPOS"),
                   new SPItem("WUGIOSCA","N",3,0, "edit","Giorni Scadenza Correzione Errori"),
                   new SPItem("WUGGALERT","N",3,0, "edit","Giorni Alert Scadenza"),
                   new SPItem("RICEVUTE","C",250,0, "edit","Path Documenti"),
                   new SPItem("OGGI3I4","C",1,0, "edit","Gestisce Causali I3/I4 in Comunicazioni Oggettive"),
                   new SPItem("CGOTGDEFMUL","C",3,0, "edit","Tipo Gioco Default Multiple"),
                   new SPItem("xDESCAN","C",50,0, "hide","Descrizione"),
                   new SPItem("AUTOSARA","C",1,0, "edit","Autocompletamento Intermediario Controparte SARA"),
                   new SPItem("FLGCGOOTP","C",1,0, "edit","Attiva Gestione OTP"),
                   new SPItem("ITFLGPEP","C",1,0, "edit","Collegamento Liste PEP"),
                   new SPItem("ITPWDPEP","C",50,0, "edit","Password per colloquio con liste pep"),
                   new SPItem("ITUSRPEP","C",50,0, "edit","Utente per colloquio liste PEP"),
                   new SPItem("FLGAGGFAM","C",1,0, "edit","Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici"),
                   new SPItem("ALTSRVMAIL","C",50,0, "edit","Server Invio Posta"),
                   new SPItem("ALTPRTMAIL","C",5,0, "edit","Porta"),
                   new SPItem("ALTEMLMAIL","C",50,0, "edit","Mail Invio"),
                   new SPItem("ALTUSRMAIL","C",50,0, "edit","Utente Invio"),
                   new SPItem("ALTPWDMAIL","C",80,0, "edit","Password"),
                   new SPItem("ALTSSLEMAIL","C",1,0, "edit","Usa SSL"),
                   new SPItem("PATHIMPORT","C",128,0, "edit","Path File Import"),
                   new SPItem("DESTEMAIL","C",80,0, "edit","Destinatario Email Import"),
                   new SPItem("COGNOME","C",30,0, "edit","Cognome"),
                   new SPItem("NOME","C",30,0, "edit","Nome"),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("DNASC","D",8,0, "edit","Nato il"),
                   new SPItem("DESCCIT","C",30,0, "edit","Domicilio"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia"),
                   new SPItem("CITTADINA","C",2,0, "edit","Cittadinanza"),
                   new SPItem("NASCOMUN","C",30,0, "edit","Comune di Nascita"),
                   new SPItem("NASSTATO","C",30,0, "edit",""),
                   new SPItem("PRNASC","C",2,0, "edit","Prov. Nasc."),
                   new SPItem("SOGCOM","C",1,0, "edit","Tipo Società"),
                   new SPItem("TIPODOC","C",2,0, "edit","Se Cambiavalute non è attività prvalente"),
                   new SPItem("BPCODPAT","C",12,0, "edit","Codice Partner"),
                   new SPItem("BPENTSEG","C",12,0, "edit","Codice Ente Segnalatore"),
                   new SPItem("BPCOGSEG","C",30,0, "edit","Cognome Segnalatore"),
                   new SPItem("BPNOMSEG","C",30,0, "edit","Nome"),
                   new SPItem("BPTELSEG","C",15,0, "edit","Telefono Segnalatore"),
                   new SPItem("BPEMLSEG","C",50,0, "edit","EMail"),
                   new SPItem("ABI","C",6,0, "edit","ABI"),
                   new SPItem("CAB","C",6,0, "edit","CAB"),
                   new SPItem("GGWARNPRV","N",3,0, "edit","Giorni Warning Provvisorio "),
                   new SPItem("GGWARNAUI","N",3,0, "edit","Giorni Warning AUI"),
                   new SPItem("SOGLIAMAX","N",12,2, "edit","Soglia Max Controllo Transazioni"),
                   new SPItem("CODVASP","C",10,0, "edit","VASP Registration Number"),
                   new SPItem("IDOAM","C",8,0, "edit","Identificativo OAM"),
                   new SPItem("IDOAMR","C",8,0, "edit","ID Soggetto rappresentato "),
                   new SPItem("SKT_SERVER","C",30,0, "edit","Socket Server"),
                   new SPItem("SKT_PORT","N",5,0, "edit","Porta Socket"),
                   new SPItem("SKT_PATHS","C",60,0, "edit","Socket Script Path"),
                   new SPItem("SKT_MODET","C",5,0, "edit","Modalità"),
                   new SPItem("RASPAUI","C",50,0, "edit","Responsabile Antiriciclaggio"),
                   new SPItem("RESPAUI","C",50,0, "edit","Responsabile"),
                   new SPItem("TESTIP","C",11,0, "edit","Tripletta per controllo ip interni"),
                   new SPItem("MINFRZSNAI","N",12,2, "edit","Minimo Telematico x Operazioni"),
                   new SPItem("FLGSCDFRZ","C",1,0, "edit","Abilita Schedulazione Raggruppamento Frazionate"),
                   new SPItem("GIORNIFRZ","N",3,0, "edit","Giorni per Consolidamento Frazionate"),
                   new SPItem("LIMITVLT","N",10,2, "edit","Limite Pagamento VLT"),
                   new SPItem("LIMITVNP","N",10,2, "edit","Limite Vincite Prenotate"),
                   new SPItem("FLGSTPDIR","C",1,0, "edit","Download stampa"),
                   new SPItem("FLGNODOC","C",1,0, "edit","Controlla scadenza documento in import"),
                   new SPItem("SNAISTOR","C",1,0, "hide","Snai Storico"),
                   new SPItem("LIMITEFRZ","N",10,2, "hide","Minimo Controllo Fraz."),
                   new SPItem("FRAZDEL","C",1,0, "edit","Cancella frazionate al termine del consolidamento"),
                   new SPItem("PATHAPP","C",80,0, "edit","Nome applicazione CGO"),
                   new SPItem("FLGDDOC","C",1,0, "hide","Flag Blooco Operazioni No Documenti"),
                   new SPItem("FLGLIGHT","C",1,0, "edit","Consenti Soggetti Senza Documento"),
                   new SPItem("pathmanuale","C",80,0, "edit",""),
                   new SPItem("FLGCGOPWD","C",1,0, "edit","Cambio Password CGO"),
                   new SPItem("PATHSID","C",250,0, "edit","Ultima versione Manuale"),
                   new SPItem("PATHCERT","C",250,0, "edit","Path Applicazione CGO"),
                   new SPItem("PATHFTP","C",128,0, "edit","Path FTP per Import"),
                   new SPItem("FLGUTEAGE","C",1,0, "edit","Crea Utente alla creazione dell'agenzia"),
                   new SPItem("PRGAEPATH","C",250,0, "edit","Email Destinatario SOS"),
                   new SPItem("NUMGIORN","N",3,0, "edit","GG  Provvisorio/Definitivo"),
                   new SPItem("FLGCGOOTP","C",1,0, "edit","Attiva Gestione OTP"),
                   new SPItem("FLGCGOQADV","C",1,0, "edit","Attiva QADV"),
                   new SPItem("BLOCCOUSER","N",3,0, "edit","GG Blocco utente non attivo"),
                   new SPItem("CGOFLGPROF","C",1,0, "edit","Flag Richiesta Professione"),
                   new SPItem("ALTSRVMAIL","C",50,0, "edit","Server Invio Posta"),
                   new SPItem("ALTPRTMAIL","C",5,0, "edit","Porta"),
                   new SPItem("ALTEMLMAIL","C",50,0, "edit","Mail Invio"),
                   new SPItem("ALTUSRMAIL","C",50,0, "edit","Utente Invio"),
                   new SPItem("ALTPWDMAIL","C",30,0, "edit","Password"),
                   new SPItem("FLGGESDOC","C",1,0, "edit","Gestione Documentale"),
                   new SPItem("USRGESDOC","C",30,0, "edit","Utente Ges. Doc."),
                   new SPItem("PWDGESDOC","C",30,0, "edit","Password Ges. Doc."),
                   new SPItem("URLDESDOC","C",80,0, "edit","URL Ges. Doc."),
                   new SPItem("EMAILDOC","C",80,0, "edit","EMail Comunicazioni"),
                   new SPItem("DATADOC","D",8,0, "edit","Data Blocco Operazioni Senza Documenti"),
                   new SPItem("PATHDOCBAC","C",128,0, "edit","Path Documenti Bacheca"),
                   new SPItem("IMPPATH","C",240,0, "edit","URL Sito E-Learning"),
                   new SPItem("CGOTGDEFMUL","C",3,0, "edit","Tipo Gioco Default Multiple"),
                   new SPItem("SONUMMESI","N",2,0, "edit","Numero Mesi da estrarre"),
                   new SPItem("SOMESIBACK","N",2,0, "edit","Numero mesi indietro"),
                   new SPItem("SOSHELLCMD","M",10,0, "edit","Comando Shell da Eseguire al termine"),
                   new SPItem("SOAMBIENTE","C",1,0, "edit","Ambiente Esecuzione Comando Shell"),
                   new SPItem("SOPATHIMPORT","M",10,0, "edit","Path file di import"),
                   new SPItem("SOORAIMPORT","N",2,0, "edit","Ora Max import VLT"),
                   new SPItem("QADV_SOGLIA","N",4,0, "edit","Soglia Alert QADV")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(6);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_intermboBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(6);
      org.json.JSONArray l_contextmenuPageItems;
      l_contextmenuPageItems = i_contextmenu.get(0);
      l_contextmenuPageItems.put(new org.json.JSONObject("{\"idItem\":\"COVTIKSDDS\",\"isImage\":false,\"menu\":\"\",\"migratedButtons\":[{\"alwaysEnabled\":false,\"caption\":\"Button\",\"id\":\"HNIRGTQRAE\",\"link\":\"HNIRGTQRAE_Click\"}],\"uid\":\"COVTIKSDDS_MENU\"}"));
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_contextmenu.size())) {
      return i_contextmenu.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10013527374",p_Context.Translate("Data da cui inviare i titolari effettivi")},
    {"10056338162",p_Context.Translate("URL Applicazione")},
    {"10084103810",p_Context.Translate("Forza Data Import = Data Sistema")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10119643152",p_Context.Translate("Crea Utente alla creazione dell'agenzia")},
    {"10149843394",p_Context.Translate("Stampe Documenti Originali")},
    {"10222585128",p_Context.Translate("Numero mesi indietro")},
    {"102290740",p_Context.Translate("Ora Max import VLT")},
    {"10252967626",p_Context.Translate("Path Documenti Bacheca")},
    {"10274446797",p_Context.Translate("Password Ges. Doc.")},
    {"10300990862",p_Context.Translate("Data Blocco Operazioni Senza Documenti")},
    {"10379074818",p_Context.Translate("Configurazione Manuale SID")},
    {"10387266406",p_Context.Translate("Campo Aggiuntivo In ARCHPERS")},
    {"10404199848",p_Context.Translate("Telefono Segnalatore")},
    {"10420604475",p_Context.Translate("Path File Import")},
    {"10471602801",p_Context.Translate("Consenti Soggetti Senza Documento")},
    {"10519994838",p_Context.Translate("Utente Ges. Doc.")},
    {"10539278829",p_Context.Translate("Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici")},
    {"1057101874",p_Context.Translate("Crea Stampa Controllo")},
    {"10580197773",p_Context.Translate("Tipo Import Age")},
    {"10585263250",p_Context.Translate("ID Soggetto rappresentato ")},
    {"10619854532",p_Context.Translate("Collegamento Liste PEP")},
    {"10629686554",p_Context.Translate("Numero Mesi da estrarre")},
    {"10655942087",p_Context.Translate("Aggrega le frazionate senza considerare le operazioni")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10663215684",p_Context.Translate("Collegamento anagrafica documenti")},
    {"10708787386",p_Context.Translate("Autocompletamento Intermediario Controparte SARA")},
    {"10745474684",p_Context.Translate("Autocompletamento Intermediario Controparte S.AR.A.")},
    {"10759744842",p_Context.Translate("Mail Invio")},
    {"10759885763",p_Context.Translate("Numero Documento")},
    {"10792439550",p_Context.Translate("Aggerega solo frazionate")},
    {"10821185899",p_Context.Translate("Giorni Import Cambiavalute")},
    {"10822553616",p_Context.Translate("Forza Data Import <> Data Sistema")},
    {"10832346659",p_Context.Translate("Collegamento a WEBCHK")},
    {"10834334563",p_Context.Translate("Eredità Fattori Rischio")},
    {"10840261571",p_Context.Translate("Giorni Warning AUI")},
    {"10862260321",p_Context.Translate("Nome applicazione CGO")},
    {"10863203227",p_Context.Translate("Ereditarietà Fattori Rischio")},
    {"10876070560",p_Context.Translate("Attiva Monitoraggio Applicazione")},
    {"10895800895",p_Context.Translate("Path Applicazione CGO")},
    {"10901840369",p_Context.Translate("Path FTP per Import")},
    {"10920017664",p_Context.Translate("Gestione Documentale Esterna")},
    {"10964521107",p_Context.Translate("VASP Registration Number")},
    {"10969052023",p_Context.Translate("Cancella frazionate al termine del consolidamento")},
    {"11017138898",p_Context.Translate("URL Sito E-Learning")},
    {"11069952590",p_Context.Translate("Destinatario Email Import")},
    {"11084261746",p_Context.Translate("Consenti Import Soggetti Senza Documenti se attivo LightCheck")},
    {"11087095564",p_Context.Translate("Responsabile Antiriciclaggio")},
    {"11107614036",p_Context.Translate("Minimo Controllo Fraz.")},
    {"11128798379",p_Context.Translate("Soglia Alert QADV")},
    {"11138315273",p_Context.Translate("Codice Utente CP")},
    {"11171811910",p_Context.Translate("Socket Script Path")},
    {"11183930016",p_Context.Translate("Password")},
    {"11202170429",p_Context.Translate("Flag Blooco Operazioni No Documenti")},
    {"11212325724",p_Context.Translate("Giorni Scadenza Correzione Errori")},
    {"11215522148",p_Context.Translate("Gestisce Causali I3/I4 in Comunicazioni Oggettive")},
    {"11227707037",p_Context.Translate("Utente Invio")},
    {"112851763",p_Context.Translate("Codice")},
    {"11312557983",p_Context.Translate("Identificativo Agenzia Entrate")},
    {"11318353074",p_Context.Translate("Importo per raggruppamento frazionate")},
    {"11345952953",p_Context.Translate("Giorni Alert Scadenza")},
    {"11372282520",p_Context.Translate("Tipo Import per Scheduler")},
    {"11386753202",p_Context.Translate("Controllo tetto \u20ac 5000")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11435351387",p_Context.Translate("Path Documenti")},
    {"11490314427",p_Context.Translate("Giorni per Consolidamento Frazionate")},
    {"11536826979",p_Context.Translate("Tipo Società")},
    {"11556190124",p_Context.Translate("Path file di import")},
    {"11572626824",p_Context.Translate("Collegamento TER")},
    {"1164993875",p_Context.Translate("Porta Socket")},
    {"11688003470",p_Context.Translate("Minimo Telematico x Operazioni")},
    {"1171331983",p_Context.Translate("Autorità Competente")},
    {"1173187617",p_Context.Translate("EMail Comunicazioni")},
    {"11749906472",p_Context.Translate("Confermi l'azzeramento del blocco SID?")},
    {"11767328360",p_Context.Translate("Contatore")},
    {"11780950272",p_Context.Translate("Percorso Java VM (JRE)")},
    {"11829318249",p_Context.Translate("Cambio Password CGO")},
    {"11843606227",p_Context.Translate("Limite Pagamento VLT")},
    {"11844098843",p_Context.Translate("Utilizza SSL")},
    {"11876010486",p_Context.Translate("Collegamento con Antiterrorismo")},
    {"11899629160",p_Context.Translate("Seleziona Automaticamente CLienti da rapport in import operazioni")},
    {"1191715360",p_Context.Translate("Cod. Segnalante ORO")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"11928289558",p_Context.Translate("Ambiente Esecuzione Comando Shell")},
    {"1193776028",p_Context.Translate("Controlla scadenza documento in import")},
    {"11949617228",p_Context.Translate("Codice Fiscale Organo Invio File")},
    {"1195502573",p_Context.Translate("Eredità fattori di rischio da dati anagrafici")},
    {"11973601132",p_Context.Translate("Responsabile")},
    {"11976701881",p_Context.Translate("Tipo Persona")},
    {"1199608503",p_Context.Translate("GG  Provvisorio/Definitivo")},
    {"12010235459",p_Context.Translate("IP MoneyTransfer")},
    {"12089975994",p_Context.Translate("Esegui i controlli del tetto dei \u20ac 5.000")},
    {"12098996044",p_Context.Translate("IDP MoneyTransfer")},
    {"12116205186",p_Context.Translate("Stampa moduli come download")},
    {"12119982584",p_Context.Translate("Creazione Inversa File di Import prima di passaggio a definitivo")},
    {"123124626",p_Context.Translate("Button")},
    {"1249813159",p_Context.Translate("Verifiche semplificate per S.AR.A.")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"129191708",p_Context.Translate("Crea rettifiche/cancellazioni per Agenzia Entrate")},
    {"1293397814",p_Context.Translate("Setto Sintetica UIC")},
    {"130605954",p_Context.Translate("ramgru")},
    {"1336888340",p_Context.Translate("Cittadinanza")},
    {"1367697541",p_Context.Translate("Usa SSL")},
    {"1370582634",p_Context.Translate("Attiva stampa con documenti originali")},
    {"1404231541",p_Context.Translate("Monitoraggio Applicazione")},
    {"1417173637",p_Context.Translate("Identificativo SID")},
    {"1418436627",p_Context.Translate("Giorni Warning Provvisorio ")},
    {"1443017286",p_Context.Translate("Richiesta Professione")},
    {"1445270903",p_Context.Translate("Data Scadenza Invio Saldi")},
    {"1455978204",p_Context.Translate("Codice Città")},
    {"1478813640",p_Context.Translate("Socket Server")},
    {"1506669781",p_Context.Translate("URL Ges. Doc.")},
    {"1509382340",p_Context.Translate("Forza Data Trasferimento Provvisorio = Data Sistema")},
    {"15186643",p_Context.Translate("Città")},
    {"1538539509",p_Context.Translate("Server Invio Posta")},
    {"1546244498",p_Context.Translate("Crea stampa controllo Import")},
    {"1561085726",p_Context.Translate("Aggrega solo frazionate")},
    {"156458968",p_Context.Translate("Comando Shell da Eseguire al termine")},
    {"1594022391",p_Context.Translate("Ultima versione Manuale")},
    {"1614154515",p_Context.Translate("Prov. Nasc.")},
    {"1629549292",p_Context.Translate("Ricordarsi di inserire la path del salvataggio dei documenti")},
    {"1739899105",p_Context.Translate("Azienda")},
    {"1756430089",p_Context.Translate("Partita IVA")},
    {"1767789109",p_Context.Translate("Snai Storico")},
    {"1769364585",p_Context.Translate("Elabora solo Agenti WUPOS")},
    {"18003",p_Context.Translate("CAB")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1838445422",p_Context.Translate("Non effettuare calcolo automatico codice fiscale in anagrafica persone")},
    {"1908272937",p_Context.Translate("Data Impegno")},
    {"1914144372",p_Context.Translate("Importazione Storico")},
    {"1924622942",p_Context.Translate("Nato il")},
    {"1937489975",p_Context.Translate("Carica Automaticamente Clienti in import operazioni se presente rapporto continuativo")},
    {"19809",p_Context.Translate("ABI")},
    {"1991110901",p_Context.Translate("Passato EURO")},
    {"2015453927",p_Context.Translate("Limite Vincite Prenotate")},
    {"2057215068",p_Context.Translate("Codice fiscale dell'intermediario che effettua la trasmissione")},
    {"2063760189",p_Context.Translate("Modalità")},
    {"2069243517",p_Context.Translate("Crea movimento modifica in anagrafe operazioni extraconto")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"2088685076",p_Context.Translate("Abilita Schedulazione Raggruppamento Frazionate")},
    {"2095911698",p_Context.Translate("Settorizzazione UIC")},
    {"2128701876",p_Context.Translate("Modello Ad. Verifica")},
    {"21587",p_Context.Translate("CAP")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"229480117",p_Context.Translate("Canale Distributivo (SV)")},
    {"233672885",p_Context.Translate("Canali Distributivi (SV)")},
    {"239631204",p_Context.Translate("Data Inizio Attività")},
    {"277599600",p_Context.Translate("Annotazioni")},
    {"282519940",p_Context.Translate("Download stampa")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"296951675",p_Context.Translate("Gestione Documentale")},
    {"298733899",p_Context.Translate("Password per colloquio con liste pep")},
    {"321149674",p_Context.Translate("Tripletta per controllo ip interni")},
    {"342820965",p_Context.Translate("Cognome Segnalatore")},
    {"343431949",p_Context.Translate("Identificativo OAM")},
    {"346962755",p_Context.Translate("Codice CAF Organo Invio")},
    {"376382717",p_Context.Translate("Comune di Nascita")},
    {"393905681",p_Context.Translate("Ricordarsi di caricare il nome dell'applicazione")},
    {"439891216",p_Context.Translate("Codice Collegamento")},
    {"443454",p_Context.Translate("Nome")},
    {"444014241",p_Context.Translate("Attivazione Log Procedura")},
    {"475960838",p_Context.Translate("Forza Data Trasferimento Provvisorio <> Data Sistema")},
    {"48458917",p_Context.Translate("Attiva Gestione OTP")},
    {"485092",p_Context.Translate("Tipo")},
    {"49939619",p_Context.Translate("Domicilio")},
    {"513536497",p_Context.Translate("Soglia Max Controllo Transazioni")},
    {"520592274",p_Context.Translate("Creazione Inversa File di Import")},
    {"535087343",p_Context.Translate("GG Blocco utente non attivo")},
    {"54222013",p_Context.Translate("Attiva gestione WUPOS")},
    {"547041811",p_Context.Translate("Tipo Gioco Default Multiple")},
    {"553185040",p_Context.Translate("Crea movimento modifica in anagrafe operazioni extraconto con import PERSNEW")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"572399938",p_Context.Translate("Ramo Gruppo Att. Ec.")},
    {"576677270",p_Context.Translate("Attiva Questionario Adeguata Verifica")},
    {"591215913",p_Context.Translate("Attivazione Gestione OTP")},
    {"603506633",p_Context.Translate("Tipo Preparazione FIle")},
    {"61024920",p_Context.Translate("Se Cambiavalute non è attività prvalente")},
    {"611154211",p_Context.Translate("Sottogruppo Att. Ec.")},
    {"614440993",p_Context.Translate("Email Destinatario SOS")},
    {"628897822",p_Context.Translate("Flag Richiesta Professione")},
    {"62890022",p_Context.Translate("Tipo Installazione")},
    {"629299095",p_Context.Translate("Gestione Western Union")},
    {"684715782",p_Context.Translate("Sottogruppi Att. Economiche")},
    {"6863168",p_Context.Translate("Porta")},
    {"6863571",p_Context.Translate("Citta")},
    {"691571468",p_Context.Translate("Gestione documenti per OAM")},
    {"7383187",p_Context.Translate("Stati")},
    {"7534101",p_Context.Translate("EMail")},
    {"776361652",p_Context.Translate("Codice Partner")},
    {"7776403",p_Context.Translate("Stato")},
    {"7776675",p_Context.Translate("Sesso")},
    {"784106725",p_Context.Translate("Data Rilascio")},
    {"791817119",p_Context.Translate("Utente per colloquio liste PEP")},
    {"821432322",p_Context.Translate("Codice Ente Segnalatore")},
    {"857291818",p_Context.Translate("Confermi il blocco dei documenti alla data indicata?")},
    {"859061417",p_Context.Translate("Confermi la creazione delle cartelle applicative?")},
    {"892694017",p_Context.Translate("Giorni Differenza Import")},
    {"898056191",p_Context.Translate("Passaggio a \u20ac 5.000")},
    {"915236354",p_Context.Translate("Attiva QADV")},
    {"974424382",p_Context.Translate("Collegamento Liste PEP/Crime")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(armt_intermboBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_intermbo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_intermboBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Intermediario"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Settaggi Applicativo"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Cambiavalute / Bil. Pagamenti / OAM"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("CGO (1)"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("CGO (2)"),"C",0,0)+"},{name:\"page_6\", element:\"page_6\", caption:"+SPLib.ToJSValue(status.context.Translate("CGO (3)"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_intermbo',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_intermbo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_upload_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_AIBXPWTSFP_Vars(armt_intermboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"dir","Tmp/");
    return inclusionVars;
  }
  // GetPortlet_scadenze_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_HUBBQEHTVM_Vars(armt_intermboBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(armt_intermboBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    WriteControls_p6(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,7);
  }
  void WriteControls_p1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:662px;width:1030px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_l0(BO,status);
    WriteControls_p1_l1(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Intermediario");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:792px;width:1030px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteControls_p2_b3(BO,status);
    WriteControls_p2_b4(BO,status);
    WriteControls_p2_b5(BO,status);
    WriteControls_p2_b6(BO,status);
    WriteControls_p2_b7(BO,status);
    WriteControls_p2_b8(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Settaggi Applicativo");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:463px;width:1030px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteControls_p3_b3(BO,status);
    WriteControls_p3_b4(BO,status);
    WriteControls_p3_b5(BO,status);
    WriteControls_p3_b6(BO,status);
    WriteControls_p3_b7(BO,status);
    WriteControls_p3_b8(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Cambiavalute / Bil. Pagamenti / OAM");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:586px;width:1030px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteControls_p4_b3(BO,status);
    WriteControls_p4_b4(BO,status);
    WriteControls_p4_b5(BO,status);
    WriteControls_p4_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"CGO (1)");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:686px;width:1030px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteControls_p5_b1(BO,status);
    WriteControls_p5_b2(BO,status);
    WriteControls_p5_b3(BO,status);
    WriteControls_p5_b4(BO,status);
    WriteControls_p5_b5(BO,status);
    WriteControls_p5_b6(BO,status);
    WriteControls_p5_b7(BO,status);
    WriteControls_p5_b8(BO,status);
    WriteControls_p5_b9(BO,status);
    WriteControls_p5_b10(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"CGO (2)");
    PrintSidebarContent(5,status,getSidebarItems(4),true);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_6' class='PageContainer' style='position:relative;height:534px;width:1030px;display:none'>" +
    "");
    WriteControls_p6_b0(BO,status);
    WriteControls_p6_b1(BO,status);
    WriteControls_p6_b2(BO,status);
    WriteControls_p6_b3(BO,status);
    WriteControls_p6_b4(BO,status);
    WriteControls_p6_b5(BO,status);
    WriteControls_p6_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,6,"CGO (3)");
    PrintSidebarContent(6,status,getSidebarItems(5),true);
    PrintContextMenu(6,status,getContextMenu(5),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_l0(armt_intermboBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='KAJTGMRBSU_DIV'>" +
     "<div id='KAJTGMRBSU' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"upload")) {
    } else {
      status.out.println(
       "<div id='AIBXPWTSFP'>" +
      "");
      // GetPortlet_upload_Vars()
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_AIBXPWTSFP;
      inclusionVars_AIBXPWTSFP = GetPortlet_AIBXPWTSFP_Vars(BO,status);
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_AIBXPWTSFP);
      String portletUID_AIBXPWTSFP = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
      com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
      com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_upload_doc_portlet.jsp?ForcedPortletUID="+ portletUID_AIBXPWTSFP+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_AIBXPWTSFP),true);
      status.out.println(
       "<script>" +
       "GetPortletInEntity.portlets.AIBXPWTSFP='"+portletUID_AIBXPWTSFP+"';" +
       "w_upload=ZtVWeb.getPortletById('"+portletUID_AIBXPWTSFP+"');" +
       "</script>" +
      "");
      status.out.println(
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('KAJTGMRBSU_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("upload"))) {
      status.out.println("ToggleLayerBox.portlets['KAJTGMRBSU_DIV']=[{'h':301,'uid':'AIBXPWTSFP','w':472}];");
      status.out.println("ToggleLayerBox.properties['KAJTGMRBSU_DIV']={'h':301,'name':'upload','w':472};");
    } else {
      status.out.println("Ctrl('KAJTGMRBSU').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_l1(armt_intermboBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='IXYGPGIHLH_DIV'>" +
     "<div id='IXYGPGIHLH' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"scadenze")) {
    } else {
      status.out.println(
       "<div id='HUBBQEHTVM'>" +
      "");
      // GetPortlet_scadenze_Vars()
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_HUBBQEHTVM;
      inclusionVars_HUBBQEHTVM = GetPortlet_HUBBQEHTVM_Vars(BO,status);
      com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_HUBBQEHTVM);
      String portletUID_HUBBQEHTVM = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
      com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
      com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_dati_certificati_portlet.jsp?ForcedPortletUID="+ portletUID_HUBBQEHTVM+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_HUBBQEHTVM),true);
      status.out.println(
       "<script>" +
       "GetPortletInEntity.portlets.HUBBQEHTVM='"+portletUID_HUBBQEHTVM+"';" +
       "w_scadenze=ZtVWeb.getPortletById('"+portletUID_HUBBQEHTVM+"');" +
       "</script>" +
      "");
      status.out.println(
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('IXYGPGIHLH_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("scadenze"))) {
      status.out.println("ToggleLayerBox.portlets['IXYGPGIHLH_DIV']=[{'h':408,'uid':'HUBBQEHTVM','w':469}];");
      status.out.println("ToggleLayerBox.properties['IXYGPGIHLH_DIV']={'h':408,'name':'scadenze','w':472};");
    } else {
      status.out.println("Ctrl('IXYGPGIHLH').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b0(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiBase' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YORQOIOBQN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YORQOIOBQN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("DatiBase")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YORQOIOBQN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YORQOIOBQN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YORQOIOBQN_HEADER&m_cBoxId=YORQOIOBQN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("DatiBase"))+"");
    }
    status.out.println(
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:637px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:637px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPINTER' id='JXOBOAXKRQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<div id='BWMEEFCWMJ_DIV' class='UntitledBox'>" +
       "<div id='BWMEEFCWMJ' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='FJJCZFOQTA_DIV' class='UntitledBox'>" +
       "<div id='FJJCZFOQTA' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAGSOC' id='HVIUTGJWGE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGSOC,"C",70,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='JCGROGAZTR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='JCGROGAZTR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JCGROGAZTR", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROVINCIA' id='UQKLCBCTLH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAP' id='BQSGHFQUHM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODCAB' id='IXWLDAOCFD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOMICILIO' id='SJHNBZJAKA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='IIXRREUEAM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='IIXRREUEAM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "IIXRREUEAM", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODFISC' id='SZWCLLEIQY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODFISC,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PARTIVA' id='OIWIANSIOG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PARTIVA,"C",14,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='14' size='14' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATANASC' id='TNUQTSSGFZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATANASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOTGRUP' id='LLYIGAMXRH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOTGRUP,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='LLYIGAMXRH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "LLYIGAMXRH", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAMOGRUP' id='RVNHQCXNEM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAMOGRUP,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='RVNHQCXNEM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RVNHQCXNEM", "tbramgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SETTSINT' id='ZGNLLSFQHC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SETTSINT,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='ZGNLLSFQHC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ZGNLLSFQHC", "tbsetsin", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPODOC' id='AYYXYNLAUC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SESSO' id='OREVCZVNVS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('OREVCZVNVS'),w_SESSO,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMDOCUM' id='XCNHFVDZMT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMDOCUM,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARILASC' id='ZYURNYDRPU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARILASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AUTRILASC' id='YYONLOLCBB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='PSZTLCSMPB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='PSZTLCSMPB_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "PSZTLCSMPB", "anadip", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='NOTE' id='COVTIKSDDS' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
       "<button id='COVTIKSDDS_MENU' type='button' class='MenuButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODORO' id='WSAOVXNTFO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODORO,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OINFLDOGXT_DIV'>" +
       "<label id='OINFLDOGXT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragione Sociale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JONRSBZIHE_DIV'>" +
       "<label id='JONRSBZIHE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RXTBTLMSHX_DIV'>" +
       "<label id='RXTBTLMSHX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XWWYBJUIHH_DIV'>" +
       "<label id='XWWYBJUIHH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OYUTQSFYLN_DIV'>" +
       "<label id='OYUTQSFYLN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Passaggio EURO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HJLXKBUTGL_DIV'>" +
       "<label id='HJLXKBUTGL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CPZJUXWKDU_DIV'>" +
       "<label id='CPZJUXWKDU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IVKVLQFAAC_DIV'>" +
       "<label id='IVKVLQFAAC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NSALRHXEBM_DIV'>" +
       "<label id='NSALRHXEBM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Aut. Competente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UZZIVDGXTK_DIV'>" +
       "<label id='UZZIVDGXTK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EOCHTUTBUF_DIV'>" +
       "<label id='EOCHTUTBUF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OPSDKLYWTJ_DIV'>" +
       "<label id='OPSDKLYWTJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NMZHNTXQTF_DIV'>" +
       "<label id='NMZHNTXQTF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODINTER' id='YPYQJILEQY' type='text' class='"+status.ObligatoryClass("Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PGYTWCFSTL_DIV'>" +
       "<label id='PGYTWCFSTL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CVRIOCDDYU_DIV'>" +
       "<label id='CVRIOCDDYU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SJBGPBDZHD_DIV'>" +
       "<label id='SJBGPBDZHD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YQOAAOOFNL_DIV'>" +
       "<label id='YQOAAOOFNL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Partita IVA:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SXFVWFHYFF_DIV'>" +
       "<label id='SXFVWFHYFF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Note"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RFSBVMUUQX_DIV'>" +
       "<label id='RFSBVMUUQX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MXPRRGVTSK_DIV'>" +
       "<label id='MXPRRGVTSK'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DESCRIsta)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZZDCRCKYFX_DIV'>" +
       "<label id='ZZDCRCKYFX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("S.A.E.:"))+"" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Settorizzazione UIC:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OCYWPELSQS_DIV'>" +
       "<label id='OCYWPELSQS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descdip)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HCAZKBKJGO_DIV'>" +
       "<label id='HCAZKBKJGO'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DESCSGRU)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FXLAZWVNMJ_DIV'>" +
       "<label id='FXLAZWVNMJ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DESCRAMGRU)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DOCORIFJEH_DIV'>" +
       "<label id='DOCORIFJEH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DESCUIC)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RBAUGZYNUB_DIV'>" +
       "<label id='RBAUGZYNUB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Solo persone fisiche"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CWLRHUCLYA_DIV'>" +
       "<label id='CWLRHUCLYA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ORWPADTZZT_DIV'>" +
       "<label id='ORWPADTZZT'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescitdip)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PPBRHNBLNO_DIV'>" +
       "<label id='PPBRHNBLNO'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xcabdip)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FMNNNQHJID_DIV'>" +
       "<label id='FMNNNQHJID'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAVALI' id='MXHAWWCAZX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAVALI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OPNSNKCGEE_DIV'>" +
       "<label id='OPNSNKCGEE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Fine Validità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CFINVIO' id='TFMCRMSOGY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CFINVIO,"C",16,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Codice fiscale dell'intermediario che effettua la trasmissione"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAFINVIO' id='YUCSUDKWNH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAFINVIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FILEINVIO' id='JSTXCUBOUH' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FILEINVIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Comunicazione predisposta da contribuente")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FILEINVIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Comunicazione predisposta da chi effettua la trasmissione")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('JSTXCUBOUH'),w_FILEINVIO,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OFRQJUQSPY_DIV'>" +
       "<label id='OFRQJUQSPY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Impegno Alla Presentazione Telematica"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WFJIAHYNWC_DIV'>" +
       "<label id='WFJIAHYNWC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FZHRVSFEMP_DIV'>" +
       "<label id='FZHRVSFEMP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° CAF:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VBUGEDJFHA_DIV'>" +
       "<label id='VBUGEDJFHA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAINVIO' id='YOVFWZCOBN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAINVIO,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NEDHUIILCP_DIV'>" +
       "<label id='NEDHUIILCP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Impegno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='PRFPRMFSTZ_DIV' class='UntitledBox'>" +
       "<div id='PRFPRMFSTZ' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ONFEVIMYAT_DIV'>" +
       "<label id='ONFEVIMYAT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Accesso SID"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDSID' id='QPIRUTKOVH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDSID,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OLANUOOFSZ_DIV'>" +
       "<label id='OLANUOOFSZ' for='QPIRUTKOVH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Identificativo SID:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SIDPASS' id='ULCBOSJURF' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_SIDPASS,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"readonly":"")+" maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QJJQEBOELV_DIV'>" +
       "<label id='QJJQEBOELV' for='ULCBOSJURF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHJAVA' id='KHHILRUMHZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHJAVA,"C",250,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='250' size='250' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RZHRRJTCMJ_DIV'>" +
       "<label id='RZHRRJTCMJ' for='KHHILRUMHZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Java VM (JRE):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOINST' id='ELBURHNYTV' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("W","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("W",CPLib.Trim(BO.w_TIPOINST))?"SELECTED":"")+">" +
       ""+status.context.Translate("Windows")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("L","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_TIPOINST))?"SELECTED":"")+">" +
       ""+status.context.Translate("Linux")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ELBURHNYTV'),w_TIPOINST,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UOUQMGWZYN_DIV'>" +
       "<label id='UOUQMGWZYN' for='ELBURHNYTV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Installazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='JYYHNLJDWT_DIV'>" +
       "<input name='FLGSIDAUTO' id='JYYHNLJDWT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGSIDAUTO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_FLGSIDAUTO)?"CHECKED":"")+">" +
       "<label id='JYYHNLJDWT_LBL' for='JYYHNLJDWT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Configurazione Manuale SID"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='LMKKKUVBBI' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Caricamento Certificati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BGMFJTDOCE_DIV'>" +
       "<label id='BGMFJTDOCE' for='WSAOVXNTFO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cod. Segnalante ORO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='DFVZKIFMYL' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Visualizza Certificati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='appocert' id='FLPFDBFHXV' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_appocert,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='LBMKPTTAXP' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Sblocco SID"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NRBJJRHEYL_DIV' style='display:none'>" +
       "<label id='NRBJJRHEYL'>" +
       ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EXFKQPWTSQ_DIV'>" +
       "<label id='EXFKQPWTSQ' for='LYZAJWZGAM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Canale Distributivo (SV):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOSV' id='LYZAJWZGAM' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LIMITE20' id='LAQADJFMRL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_LIMITE20,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='LAQADJFMRL_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZTVBLCEEKH_DIV' style='display:none'>" +
       "<label id='ZTVBLCEEKH' for='LAQADJFMRL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Passaggio a \u20ac 5.000:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TXEDKCGZGL_DIV' style='display:none'>" +
       "<label id='TXEDKCGZGL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provv.  B.I. del 24/03/2020  (se non viene indicato nulla il default è il 31-12-2020)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='ZYHCFDSBFP' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Estrazione UIF (Cancellazione)"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODVASP' id='FTETLDBHIY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODVASP,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HUPLKWHBHY_DIV'>" +
       "<label id='HUPLKWHBHY' for='FTETLDBHIY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("VASP Registration Number:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CWVJUDEVCT_DIV'>" +
       "<input name='ART1' id='CWVJUDEVCT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ART1,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_ART1)?"CHECKED":"")+">" +
       "<label id='CWVJUDEVCT_LBL' for='CWVJUDEVCT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Esegui i controlli del tetto dei \u20ac 5.000"))+"</label>" +
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
  void WriteControls_p1_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('YORQOIOBQN').style.height='auto';");
    } else {
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',637);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_2' style='position:relative;height:7px;display:block' page='2'>" +
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
  void WriteControls_p2_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='ParamBase' id='POUNPHSDYV_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='POUNPHSDYV_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='POUNPHSDYV_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Parametri di Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='POUNPHSDYV_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"POUNPHSDYV\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=POUNPHSDYV_HEADER&m_cBoxId=POUNPHSDYV&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Parametri di Base"))+"");
    }
    status.out.println(
     "<div id='POUNPHSDYV' class='SectionBody' style='position:relative;height:497px;display:block'>" +
    "");
    status.includeZoneAltInterface("ParamBase@BEGIN");
    if (status.includeZoneAltInterface("ParamBase")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ParamBase@BEGIN") || status.HasZoneAltInterface("ParamBase@END")) {
        status.out.println(
         "<div id='POUNPHSDYV_boxContent' style='position:relative;height:497px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='URLAPPL' id='FPFLFCPHAL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_URLAPPL,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PXCKUPWOFP_DIV'>" +
       "<label id='PXCKUPWOFP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome Applicazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Attiva Monitoraggio Applicazione"),"C",0,0)+" id='EOQVPQLKOP_DIV' style='display:none'>" +
       "<input name='FLGLOG' id='EOQVPQLKOP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGLOG,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGLOG))?"CHECKED":"")+">" +
       "<label id='EOQVPQLKOP_LBL' for='EOQVPQLKOP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Monitoraggio Applicazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Collegamento con Antiterrorismo"),"C",0,0)+" id='BLWLPTWCFV_DIV' style='display:none'>" +
       "<input name='FLGAOS' id='BLWLPTWCFV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGAOS,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGAOS))?"CHECKED":"")+">" +
       "<label id='BLWLPTWCFV_LBL' for='BLWLPTWCFV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Collegamento TER"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Eredità fattori di rischio da dati anagrafici"),"C",0,0)+" id='REBGPUSIPL_DIV'>" +
       "<input name='FLGEAOS' id='REBGPUSIPL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGEAOS,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGEAOS))?"CHECKED":"")+">" +
       "<label id='REBGPUSIPL_LBL' for='REBGPUSIPL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Eredità Fattori Rischio"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Attiva stampa con documenti originali"),"C",0,0)+" id='HKDCUQQHSU_DIV'>" +
       "<input name='FLGCDOC' id='HKDCUQQHSU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCDOC,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCDOC))?"CHECKED":"")+">" +
       "<label id='HKDCUQQHSU_LBL' for='HKDCUQQHSU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stampe Documenti Originali"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Aggrega le frazionate senza considerare le operazioni"),"C",0,0)+" id='CCBVEBVMNW_DIV'>" +
       "<input name='FLGFRAZ' id='CCBVEBVMNW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGFRAZ,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGFRAZ))?"CHECKED":"")+">" +
       "<label id='CCBVEBVMNW_LBL' for='CCBVEBVMNW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Aggrega solo frazionate"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLGAPERS' id='IDROHZZWYH' class='Combobox' title="+SPLib.ToHTMLValue(status.context.Translate("Aggrega le frazionate senza considerare le operazioni"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Standard")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Unico file Rapporti/Informazioni/Intestatari")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Campo Aggiuntivo ARCHPERS + Storico Autom.")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Import schedulato")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("5","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("5",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Import MT")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("6","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("6",CPLib.Trim(BO.w_FLGAPERS))?"SELECTED":"")+">" +
       ""+status.context.Translate("Import WUBS")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('IDROHZZWYH'),w_FLGAPERS,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OEFBKJVZGI_DIV'>" +
       "<label id='OEFBKJVZGI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DTINIATT' id='IQOQQQRZAK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DTINIATT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='IQOQQQRZAK_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AWSAENIKPZ_DIV'>" +
       "<label id='AWSAENIKPZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio Attività:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<div id='ZPSOMDIBXB_DIV'>" +
       "<span id='ZPSOMDIBXB_0_container'>" +
       "<input id='ZPSOMDIBXB_0' name='ZPSOMDIBXB' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_FLGTIPIMP))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='ZPSOMDIBXB_0'>"+status.context.Translate("Provvisorio")+"</label>" +
       "</span>" +
       "<span id='ZPSOMDIBXB_1_container'>" +
       "<input id='ZPSOMDIBXB_1' name='ZPSOMDIBXB' type='radio' value="+SPLib.ToHTMLValue("D","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_FLGTIPIMP))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='ZPSOMDIBXB_1'>"+status.context.Translate("Definitivo")+"</label>" +
       "</span>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MNXQLPZJTD_DIV'>" +
       "<label id='MNXQLPZJTD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Import Scheduler:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PIGFPYZMIR_DIV' style='display:none'>" +
       "<input name='FLGSTPCON' id='PIGFPYZMIR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGSTPCON,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGSTPCON))?"CHECKED":"")+">" +
       "<label id='PIGFPYZMIR_LBL' for='PIGFPYZMIR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea stampa controllo Import"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLGIMPAGE' id='DUFIQNBDKW' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLGIMPAGE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Ricostruzione Standard")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FLGIMPAGE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Ricostruzione con Base File Excel")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('DUFIQNBDKW'),w_FLGIMPAGE,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FRGSTKSWWS_DIV'>" +
       "<label id='FRGSTKSWWS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ripristino da file AgE:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LOYILZBSVI_DIV'>" +
       "<input name='FLGWU' id='LOYILZBSVI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGWU,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGWU))?"CHECKED":"")+">" +
       "<label id='LOYILZBSVI_LBL' for='LOYILZBSVI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Gestione Western Union"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPINTOPE' id='YJCSSLPJKG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPINTOPE,"N",12,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='13' size='12' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HGDWNYPDSM_DIV'>" +
       "<label id='HGDWNYPDSM' for='YJCSSLPJKG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo per consolidamento frazionate:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PXNLADGGBR_DIV'>" +
       "<input name='FLGOPEXTR' id='PXNLADGGBR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGOPEXTR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGOPEXTR))?"CHECKED":"")+">" +
       "<label id='PXNLADGGBR_LBL' for='PXNLADGGBR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea movimento modifica in anagrafe operazioni extraconto con import PERSNEW"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='OSHAMNPXFT_DIV'>" +
       "<input name='FLGRAPCLI' id='OSHAMNPXFT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGRAPCLI,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGRAPCLI))?"CHECKED":"")+">" +
       "<label id='OSHAMNPXFT_LBL' for='OSHAMNPXFT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Carica Automaticamente Clienti in import operazioni se presente rapporto continuativo"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='ZHYZMPHABC' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Cartelle di Sistema"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='UETNARUDOE_DIV'>" +
       "<input name='NOCODFISC' id='UETNARUDOE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOCODFISC,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOCODFISC)?"CHECKED":"")+">" +
       "<label id='UETNARUDOE_LBL' for='UETNARUDOE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non effettuare calcolo automatico codice fiscale in anagrafica persone"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Aggrega le frazionate senza considerare le operazioni"),"C",0,0)+" id='UHGVOKNSVL_DIV' style='display:none'>" +
       "<input name='FLGCHK' id='UHGVOKNSVL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCHK,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCHK))?"CHECKED":"")+">" +
       "<label id='UHGVOKNSVL_LBL' for='UHGVOKNSVL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Collegamento a WEBCHK"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PWDSER' id='NLUIAOSQKM' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_PWDSER,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSPMAF' id='XDDITMPJIZ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_SOSPMAF))?"SELECTED":"")+">" +
       ""+status.context.Translate("Segnala se DataReg. < Data Sistema")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_SOSPMAF))?"SELECTED":"")+">" +
       ""+status.context.Translate("Impedisce registrazioni se DataReg. < Data Sistema")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("U","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("U",CPLib.Trim(BO.w_SOSPMAF))?"SELECTED":"")+">" +
       ""+status.context.Translate("Impedisce registrazioni se DataReg. # Data Sistema")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_SOSPMAF))?"SELECTED":"")+">" +
       ""+status.context.Translate("Data Registrazione non controllata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("B","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("B",CPLib.Trim(BO.w_SOSPMAF))?"SELECTED":"")+">" +
       ""+status.context.Translate("Data Registrazione = Data Sistema")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('XDDITMPJIZ'),w_SOSPMAF,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='USUAFIVIAY_DIV' style='display:none'>" +
       "<label id='USUAFIVIAY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Controllo Data Registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='REOBNBRGTT_DIV' style='display:none'>" +
       "<label id='REOBNBRGTT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Servizio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LUPNVRRLHF_DIV'>" +
       "<input name='FLGRITORNO' id='LUPNVRRLHF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGRITORNO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGRITORNO))?"CHECKED":"")+">" +
       "<label id='LUPNVRRLHF_LBL' for='LUPNVRRLHF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Creazione Inversa File di Import"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='HFADCPKPNB_DIV'>" +
       "<input name='FLGCREAAGE' id='HFADCPKPNB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCREAAGE,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCREAAGE))?"CHECKED":"")+">" +
       "<label id='HFADCPKPNB_LBL' for='HFADCPKPNB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea rettifiche/cancellazioni per Agenzia Entrate"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DTTITAGE' id='ASIWFAENLM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DTTITAGE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='ASIWFAENLM_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LUCDNUTLOB_DIV'>" +
       "<label id='LUCDNUTLOB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data inizio rapporti da cui vogliamo che venga inviato il dato sul titolare effettivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SCADSALDI' id='IOYUNQJDKZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCADSALDI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='IOYUNQJDKZ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KVNARHOHUS_DIV' style='display:none'>" +
       "<label id='KVNARHOHUS' for='IOYUNQJDKZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza Invio Saldi:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LSBZHECNKO_DIV' style='display:none'>" +
       "<input name='FLGIPMT' id='LSBZHECNKO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGIPMT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGIPMT))?"CHECKED":"")+">" +
       "<label id='LSBZHECNKO_LBL' for='LSBZHECNKO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("IP MoneyTransfer"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LIMITEFRZ' id='FKIIMPSJSB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_LIMITEFRZ,"N",10,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OUASZKTMZL_DIV'>" +
       "<label id='OUASZKTMZL' for='FKIIMPSJSB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo Minimo Singola Frazionata per Consolidamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DBPROT' id='EQCSRKQZVC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DBPROT,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OWCRFMADTX_DIV'>" +
       "<label id='OWCRFMADTX' for='EQCSRKQZVC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modello Adeg. Verifica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='KFQWZVCJIW_DIV'>" +
       "<input name='OAMTPDOC' id='KFQWZVCJIW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_OAMTPDOC,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_OAMTPDOC)?"CHECKED":"")+">" +
       "<label id='KFQWZVCJIW_LBL' for='KFQWZVCJIW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Gestione documenti per OAM"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAYSIMPORT' id='LGZDRUUSXZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAYSIMPORT,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FLAGKQKWLF_DIV'>" +
       "<label id='FLAGKQKWLF' for='LGZDRUUSXZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Differenza Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAYSIMPCMB' id='FQKHRITNGP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAYSIMPCMB,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FNFPYHHCTJ_DIV'>" +
       "<label id='FNFPYHHCTJ' for='FQKHRITNGP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Differenza Import Cambiavalute:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='SIZHWNZUOT_DIV'>" +
       "<input name='FLGAWUPOS' id='SIZHWNZUOT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGAWUPOS,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGAWUPOS))?"CHECKED":"")+">" +
       "<label id='SIZHWNZUOT_LBL' for='SIZHWNZUOT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Elabora solo Agenti WUPOS"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUGIOSCA' id='QBHBPWJMOW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUGIOSCA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUGGALERT' id='HXPRRNXNJO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUGGALERT,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OIGTNGXRRH_DIV'>" +
       "<label id='OIGTNGXRRH' for='HXPRRNXNJO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Alert Scadenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JIDHZWEVMP_DIV'>" +
       "<label id='JIDHZWEVMP' for='QBHBPWJMOW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Scadenza Correzione Errori:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RICEVUTE' id='AAIARGXIIW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RICEVUTE,"C",250,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='250' size='250' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EKCSWYBUKQ_DIV'>" +
       "<label id='EKCSWYBUKQ' for='AAIARGXIIW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path Documenti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PLWDFUBDIP_DIV'>" +
       "<input name='OGGI3I4' id='PLWDFUBDIP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_OGGI3I4,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_OGGI3I4))?"CHECKED":"")+">" +
       "<label id='PLWDFUBDIP_LBL' for='PLWDFUBDIP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Gestisce Causali I3/I4 in Comunicazioni Oggettive"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PDLIXDKBWK_DIV'>" +
       "<input name='CGOTGDEFMUL' id='PDLIXDKBWK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CGOTGDEFMUL,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_CGOTGDEFMUL))?"CHECKED":"")+">" +
       "<label id='PDLIXDKBWK_LBL' for='PDLIXDKBWK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Verifiche semplificate per S.AR.A."))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PVOEPQLJPS_DIV'>" +
       "<input name='AUTOSARA' id='PVOEPQLJPS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_AUTOSARA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_AUTOSARA))?"CHECKED":"")+">" +
       "<label id='PVOEPQLJPS_LBL' for='PVOEPQLJPS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Autocompletamento Intermediario Controparte S.AR.A."))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='FCXDRDCINI_DIV'>" +
       "<input name='FLGCGOOTP' id='FCXDRDCINI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCGOOTP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCGOOTP))?"CHECKED":"")+">" +
       "<label id='FCXDRDCINI_LBL' for='FCXDRDCINI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Attivazione Gestione OTP"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XMAVZMPWRZ_DIV'>" +
       "<input name='FLGAGGFAM' id='XMAVZMPWRZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGAGGFAM,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGAGGFAM))?"CHECKED":"")+">" +
       "<label id='XMAVZMPWRZ_LBL' for='XMAVZMPWRZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("ParamBase@BEGIN") || status.HasZoneAltInterface("ParamBase@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ParamBase@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("ParamBase")) {
      status.out.println("Ctrl('POUNPHSDYV').style.height='auto';");
    } else {
      status.out.println("Ctrl('POUNPHSDYV').setAttribute('band_height',497);");
    }
    status.out.println("Ctrl('POUNPHSDYV').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_CCPBATRTRJ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_CCPBATRTRJ' style='position:relative;height:7px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_CCPBATRTRJ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_CCPBATRTRJ').style.height='auto';");
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
  void WriteControls_p2_b3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='PEP' id='CCPBATRTRJ_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='CCPBATRTRJ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='CCPBATRTRJ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Collegamento con Liste PEP")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='CCPBATRTRJ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"CCPBATRTRJ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=CCPBATRTRJ_HEADER&m_cBoxId=CCPBATRTRJ&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Collegamento con Liste PEP"))+"");
    }
    status.out.println(
     "<div id='CCPBATRTRJ' class='SectionBody' style='position:relative;height:77px;display:none'>" +
    "");
    status.includeZoneAltInterface("PEP@BEGIN");
    if (status.includeZoneAltInterface("PEP")) {
      WriteControls_p2_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PEP@BEGIN") || status.HasZoneAltInterface("PEP@END")) {
        status.out.println(
         "<div id='CCPBATRTRJ_boxContent' style='position:relative;height:77px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RBAZEQPPJI_DIV'>" +
       "<input name='ITFLGPEP' id='RBAZEQPPJI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ITFLGPEP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_ITFLGPEP))?"CHECKED":"")+">" +
       "<label id='RBAZEQPPJI_LBL' for='RBAZEQPPJI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Collegamento Liste PEP/Crime"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ITPWDPEP' id='VDJMSNZEEV' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_ITPWDPEP,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"readonly":"")+" maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ITUSRPEP' id='LNADTKDHIZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ITUSRPEP,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TROEZOSPBE_DIV'>" +
       "<label id='TROEZOSPBE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Utente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZYNRGRHMEV_DIV'>" +
       "<label id='ZYNRGRHMEV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("PEP@BEGIN") || status.HasZoneAltInterface("PEP@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b3_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("PEP@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("PEP")) {
      status.out.println("Ctrl('CCPBATRTRJ').style.height='auto';");
    } else {
      status.out.println("Ctrl('CCPBATRTRJ').setAttribute('band_height',77);");
    }
    status.out.println("Ctrl('CCPBATRTRJ').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b4(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_DQBIMZLTTE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_DQBIMZLTTE' style='position:relative;height:7px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_DQBIMZLTTE")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_DQBIMZLTTE').style.height='auto';");
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
  void WriteControls_p2_b5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='CGOEmail' id='DQBIMZLTTE_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='DQBIMZLTTE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='DQBIMZLTTE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Parametri Per EMAIL Alert")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='DQBIMZLTTE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"DQBIMZLTTE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=DQBIMZLTTE_HEADER&m_cBoxId=DQBIMZLTTE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Parametri Per EMAIL Alert"))+"");
    }
    status.out.println(
     "<div id='DQBIMZLTTE' class='SectionBody' style='position:relative;height:105px;display:block'>" +
    "");
    status.includeZoneAltInterface("CGOEmail@BEGIN");
    if (status.includeZoneAltInterface("CGOEmail")) {
      WriteControls_p2_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("CGOEmail@BEGIN") || status.HasZoneAltInterface("CGOEmail@END")) {
        status.out.println(
         "<div id='DQBIMZLTTE_boxContent' style='position:relative;height:105px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTSRVMAIL' id='BZARULYZUH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTSRVMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ICYIBIEJPT_DIV'>" +
       "<label id='ICYIBIEJPT' for='BZARULYZUH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Server Invio Posta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTPRTMAIL' id='CWFIJJMSTR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTPRTMAIL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ATTOCVUWED_DIV'>" +
       "<label id='ATTOCVUWED' for='CWFIJJMSTR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Porta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTEMLMAIL' id='YPHGLIUDNW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTEMLMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UPYNWKDWTI_DIV'>" +
       "<label id='UPYNWKDWTI' for='YPHGLIUDNW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mail Invio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTUSRMAIL' id='HSAOKMBAUY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTUSRMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RHFVPZJHSD_DIV'>" +
       "<label id='RHFVPZJHSD' for='HSAOKMBAUY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Utente Posta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTPWDMAIL' id='LGVTLPSUGS' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_ALTPWDMAIL,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"readonly":"")+" maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CAZHGSIXHK_DIV'>" +
       "<label id='CAZHGSIXHK' for='LGVTLPSUGS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='KPSLGRAIIO_DIV'>" +
       "<input name='ALTSSLEMAIL' id='KPSLGRAIIO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ALTSSLEMAIL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_ALTSSLEMAIL))?"CHECKED":"")+">" +
       "<label id='KPSLGRAIIO_LBL' for='KPSLGRAIIO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Utilizza SSL"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("CGOEmail@BEGIN") || status.HasZoneAltInterface("CGOEmail@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b5_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("CGOEmail@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("CGOEmail")) {
      status.out.println("Ctrl('DQBIMZLTTE').style.height='auto';");
    } else {
      status.out.println("Ctrl('DQBIMZLTTE').setAttribute('band_height',105);");
    }
    status.out.println("Ctrl('DQBIMZLTTE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b6(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_XFBWYNZQZN")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_XFBWYNZQZN' style='position:relative;height:7px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_XFBWYNZQZN")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_XFBWYNZQZN').style.height='auto';");
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
  void WriteControls_p2_b7(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Import' id='XFBWYNZQZN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XFBWYNZQZN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XFBWYNZQZN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Parametri Import Schedulato")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XFBWYNZQZN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XFBWYNZQZN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XFBWYNZQZN_HEADER&m_cBoxId=XFBWYNZQZN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Parametri Import Schedulato"))+"");
    }
    status.out.println(
     "<div id='XFBWYNZQZN' class='SectionBody' style='position:relative;height:77px;display:block'>" +
    "");
    status.includeZoneAltInterface("Import@BEGIN");
    if (status.includeZoneAltInterface("Import")) {
      WriteControls_p2_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Import@BEGIN") || status.HasZoneAltInterface("Import@END")) {
        status.out.println(
         "<div id='XFBWYNZQZN_boxContent' style='position:relative;height:77px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHIMPORT' id='YRAEGOUXRJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHIMPORT,"C",128,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='128' size='128' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AUPNFEOYCV_DIV'>" +
       "<label id='AUPNFEOYCV' for='YRAEGOUXRJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path File Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESTEMAIL' id='OHRBGBCDVG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESTEMAIL,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ISGMMWGAEC_DIV'>" +
       "<label id='ISGMMWGAEC' for='OHRBGBCDVG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Destinatario Email Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Import@BEGIN") || status.HasZoneAltInterface("Import@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b7_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Import@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Import")) {
      status.out.println("Ctrl('XFBWYNZQZN').style.height='auto';");
    } else {
      status.out.println("Ctrl('XFBWYNZQZN').setAttribute('band_height',77);");
    }
    status.out.println("Ctrl('XFBWYNZQZN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b8(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_3")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_3' style='position:relative;height:7px;display:block' page='3'>" +
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
  void WriteControls_p3_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Cambiavalute' id='CESCBNVXDE_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='CESCBNVXDE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='CESCBNVXDE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Cambiavalute")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='CESCBNVXDE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"CESCBNVXDE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=CESCBNVXDE_HEADER&m_cBoxId=CESCBNVXDE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Cambiavalute"))+"");
    }
    status.out.println(
     "<div id='CESCBNVXDE' class='SectionBody' style='position:relative;height:166px;display:block'>" +
    "");
    status.includeZoneAltInterface("Cambiavalute@BEGIN");
    if (status.includeZoneAltInterface("Cambiavalute")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Cambiavalute@BEGIN") || status.HasZoneAltInterface("Cambiavalute@END")) {
        status.out.println(
         "<div id='CESCBNVXDE_boxContent' style='position:relative;height:166px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='FIZGFLGSCA_DIV'>" +
       "<label id='FIZGFLGSCA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Persona Fisica/Ditta Individuale"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COGNOME' id='KDJLQEMEDV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COGNOME,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NOME' id='VTFLIHXHLG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NOME,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SESSO' id='SIJUUSKFLV' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('SIJUUSKFLV'),w_SESSO,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DNASC' id='XCZARGUGTG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DNASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XCZARGUGTG_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='PZGXGIZQWY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='PZGXGIZQWY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "PZGXGIZQWY", "tbcitta", "armt_citta", "")+"" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='MUWSLBTIOI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ROSZPLTXFI_DIV'>" +
       "<label id='ROSZPLTXFI' for='KDJLQEMEDV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KHSXGUNTRM_DIV'>" +
       "<label id='KHSXGUNTRM' for='VTFLIHXHLG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UPFDNQAQQN_DIV'>" +
       "<label id='UPFDNQAQQN' for='PZGXGIZQWY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Domicilio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JKODERXVSD_DIV'>" +
       "<label id='JKODERXVSD' for='MUWSLBTIOI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CITTADINA' id='WQWXGOLVXC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("01","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("01",CPLib.Trim(BO.w_CITTADINA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cittadinanzia Italiana")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("02","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("02",CPLib.Trim(BO.w_CITTADINA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cittadinanza Comunitaria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("03","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("03",CPLib.Trim(BO.w_CITTADINA))?"SELECTED":"")+">" +
       ""+status.context.Translate("Cittadinanza ExtraComunitaria")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('WQWXGOLVXC'),w_CITTADINA,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QEDFADZTLI_DIV'>" +
       "<label id='QEDFADZTLI' for='WQWXGOLVXC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NPSJWIVGOM_DIV'>" +
       "<label id='NPSJWIVGOM' for='SIJUUSKFLV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASCOMUN' id='DUROREWBNG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NASCOMUN,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='DUROREWBNG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DUROREWBNG", "tbcitta", "armt_citta", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RDSGVORAHH_DIV'>" +
       "<label id='RDSGVORAHH' for='DUROREWBNG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comune di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASSTATO' id='ZTUIXEONYI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NASSTATO,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='ZTUIXEONYI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ZTUIXEONYI", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FEFHMTGUWV_DIV'>" +
       "<label id='FEFHMTGUWV' for='ZTUIXEONYI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PRNASC' id='KSRCRPEMFT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PRNASC,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MMUGKFYZMW_DIV'>" +
       "<label id='MMUGKFYZMW' for='KSRCRPEMFT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MZKLEUIIGG_DIV'>" +
       "<label id='MZKLEUIIGG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Società"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOGCOM' id='IYKMLTUWXM' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_SOGCOM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Soggetto Italiano")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_SOGCOM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Soggetto comunitario (stabile organizzazione)")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('IYKMLTUWXM'),w_SOGCOM,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FTRVPLIAQI_DIV'>" +
       "<label id='FTRVPLIAQI' for='IYKMLTUWXM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Società:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPODOC' id='KYNLIGXUVC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("09","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("09",CPLib.Trim(BO.w_TIPODOC))?"SELECTED":"")+">" +
       ""+status.context.Translate("IP+Cambiavalute")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("10","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("10",CPLib.Trim(BO.w_TIPODOC))?"SELECTED":"")+">" +
       ""+status.context.Translate("Op. Prof. Oro+Cambiavalute")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("11","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("11",CPLib.Trim(BO.w_TIPODOC))?"SELECTED":"")+">" +
       ""+status.context.Translate("Altro+Cambiavalute")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('KYNLIGXUVC'),w_TIPODOC,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UFURNZFHIZ_DIV'>" +
       "<label id='UFURNZFHIZ' for='KYNLIGXUVC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Se Cambiavalute non è attività prevalente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHZGAVQLHJ_DIV'>" +
       "<label id='LHZGAVQLHJ' for='XCZARGUGTG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nato il:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Cambiavalute@BEGIN") || status.HasZoneAltInterface("Cambiavalute@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Cambiavalute@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Cambiavalute")) {
      status.out.println("Ctrl('CESCBNVXDE').style.height='auto';");
    } else {
      status.out.println("Ctrl('CESCBNVXDE').setAttribute('band_height',166);");
    }
    status.out.println("Ctrl('CESCBNVXDE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b2(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_XEDASKHZOQ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_XEDASKHZOQ' style='position:relative;height:2px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_XEDASKHZOQ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_XEDASKHZOQ').style.height='auto';");
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
  void WriteControls_p3_b3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Base9Cambia' id='XEDASKHZOQ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XEDASKHZOQ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XEDASKHZOQ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Comunicazioni Oggettive")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XEDASKHZOQ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XEDASKHZOQ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XEDASKHZOQ_HEADER&m_cBoxId=XEDASKHZOQ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Comunicazioni Oggettive"))+"");
    }
    status.out.println(
     "<div id='XEDASKHZOQ' class='SectionBody' style='position:relative;height:140px;display:block'>" +
    "");
    status.includeZoneAltInterface("Base9Cambia@BEGIN");
    if (status.includeZoneAltInterface("Base9Cambia")) {
      WriteControls_p3_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Base9Cambia@BEGIN") || status.HasZoneAltInterface("Base9Cambia@END")) {
        status.out.println(
         "<div id='XEDASKHZOQ_boxContent' style='position:relative;height:140px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPCODPAT' id='IAXBQWHGLM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPCODPAT,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HABRXIELKU_DIV'>" +
       "<label id='HABRXIELKU' for='IAXBQWHGLM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Partner:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPENTSEG' id='PBQXUDZUOZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPENTSEG,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IYWXEOHSIG_DIV'>" +
       "<label id='IYWXEOHSIG' for='PBQXUDZUOZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Ente Segnalatore:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPCOGSEG' id='UBNVJIYFWU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPCOGSEG,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AZWMLMXFTT_DIV'>" +
       "<label id='AZWMLMXFTT' for='UBNVJIYFWU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPNOMSEG' id='PELELICXZD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPNOMSEG,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QSZTRDTOHH_DIV'>" +
       "<label id='QSZTRDTOHH' for='PELELICXZD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPTELSEG' id='DZVDAZOPWP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPTELSEG,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GALIAYORFO_DIV'>" +
       "<label id='GALIAYORFO' for='DZVDAZOPWP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BPEMLSEG' id='HRZVDXDSOJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BPEMLSEG,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LQQXWNYQRB_DIV'>" +
       "<label id='LQQXWNYQRB' for='HRZVDXDSOJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("EMail:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ABI' id='TFDNMJLIWF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ABI,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QCYZGHORPG_DIV'>" +
       "<label id='QCYZGHORPG' for='TFDNMJLIWF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ABI:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAB' id='WRRSZRBPCI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='APGZAARWJB_DIV'>" +
       "<label id='APGZAARWJB' for='WRRSZRBPCI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Base9Cambia@BEGIN") || status.HasZoneAltInterface("Base9Cambia@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b3_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Base9Cambia@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Base9Cambia")) {
      status.out.println("Ctrl('XEDASKHZOQ').style.height='auto';");
    } else {
      status.out.println("Ctrl('XEDASKHZOQ').setAttribute('band_height',140);");
    }
    status.out.println("Ctrl('XEDASKHZOQ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b4(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HDNWLIPNPD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HDNWLIPNPD' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HDNWLIPNPD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HDNWLIPNPD').style.height='auto';");
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
  void WriteControls_p3_b5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DestWarn' id='HDNWLIPNPD_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HDNWLIPNPD_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HDNWLIPNPD_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Destinatari Warning")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HDNWLIPNPD_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"HDNWLIPNPD\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HDNWLIPNPD_HEADER&m_cBoxId=HDNWLIPNPD&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Destinatari Warning"))+"");
    }
    status.out.println(
     "<div id='HDNWLIPNPD' class='SectionBody' style='position:relative;height:224px;display:none'>" +
    "");
    status.includeZoneAltInterface("DestWarn@BEGIN");
    if (status.includeZoneAltInterface("DestWarn")) {
      WriteControls_p3_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DestWarn@BEGIN") || status.HasZoneAltInterface("DestWarn@END")) {
        status.out.println(
         "<div id='HDNWLIPNPD_boxContent' style='position:relative;height:224px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_destwarn' id='JBFAVRHYDR' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='GGWARNPRV' id='PUFIBBLEMQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_GGWARNPRV,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FBHJBOUZMO_DIV'>" +
       "<label id='FBHJBOUZMO' for='PUFIBBLEMQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Warning Provvisorio :"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='GGWARNAUI' id='MBMIGFSBXO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_GGWARNAUI,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HPOFGKJCFG_DIV'>" +
       "<label id='HPOFGKJCFG' for='MBMIGFSBXO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni Warning AUI:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOGLIAMAX' id='XUNVKFSSZL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOGLIAMAX,"N",12,2,"999,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='17' size='12' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MLGAKKSLBW_DIV'>" +
       "<label id='MLGAKKSLBW' for='XUNVKFSSZL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Soglia Max Controllo Transazioni:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DestWarn@BEGIN") || status.HasZoneAltInterface("DestWarn@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b5_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DestWarn@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DestWarn")) {
      status.out.println("Ctrl('HDNWLIPNPD').style.height='auto';");
    } else {
      status.out.println("Ctrl('HDNWLIPNPD').setAttribute('band_height',224);");
    }
    status.out.println("Ctrl('HDNWLIPNPD').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['HDNWLIPNPD']=['JBFAVRHYDR'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b6(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_TQULLVKAWF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_TQULLVKAWF' style='position:relative;height:7px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_TQULLVKAWF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_TQULLVKAWF').style.height='auto';");
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
  void WriteControls_p3_b7(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='OAM' id='TQULLVKAWF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='TQULLVKAWF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='TQULLVKAWF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("OAM")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='TQULLVKAWF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"TQULLVKAWF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=TQULLVKAWF_HEADER&m_cBoxId=TQULLVKAWF&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("OAM"))+"");
    }
    status.out.println(
     "<div id='TQULLVKAWF' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("OAM@BEGIN");
    if (status.includeZoneAltInterface("OAM")) {
      WriteControls_p3_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("OAM@BEGIN") || status.HasZoneAltInterface("OAM@END")) {
        status.out.println(
         "<div id='TQULLVKAWF_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODVASP' id='CMBYXKAJCS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODVASP,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SCMDDRTKOA_DIV'>" +
       "<label id='SCMDDRTKOA' for='CMBYXKAJCS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("VASP Registration Number:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDOAM' id='CNQFAHXNUY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDOAM,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IMVVZYFAKP_DIV'>" +
       "<label id='IMVVZYFAKP' for='CNQFAHXNUY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Identificativo OAM:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDOAMR' id='PUYJXGBDJI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDOAMR,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HQOSRSTJSV_DIV'>" +
       "<label id='HQOSRSTJSV' for='PUYJXGBDJI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Soggetto rappresentato :"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("OAM@BEGIN") || status.HasZoneAltInterface("OAM@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b7_CloseBand(armt_intermboBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('TQULLVKAWF').style.height='auto';");
    } else {
      status.out.println("Ctrl('TQULLVKAWF').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('TQULLVKAWF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b8(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p4_b0(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_4")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_4' style='position:relative;height:7px;display:block' page='4'>" +
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
  void WriteControls_p4_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='CGO' id='VSXUXPIOIH_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='VSXUXPIOIH_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='VSXUXPIOIH_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("CGO")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='VSXUXPIOIH_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"VSXUXPIOIH\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=VSXUXPIOIH_HEADER&m_cBoxId=VSXUXPIOIH&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("CGO"))+"");
    }
    status.out.println(
     "<div id='VSXUXPIOIH' class='SectionBody' style='position:relative;height:371px;display:block'>" +
    "");
    status.includeZoneAltInterface("CGO@BEGIN");
    if (status.includeZoneAltInterface("CGO")) {
      WriteControls_p4_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("CGO@BEGIN") || status.HasZoneAltInterface("CGO@END")) {
        status.out.println(
         "<div id='VSXUXPIOIH_boxContent' style='position:relative;height:371px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TESTIP' id='ZZSBUTEXWS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TESTIP,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MINFRZSNAI' id='XRGIDJXVCB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MINFRZSNAI,"N",12,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='13' size='12' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZINOLQOUB_DIV'>" +
       "<input name='FLGSCDFRZ' id='CZINOLQOUB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGSCDFRZ,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGSCDFRZ))?"CHECKED":"")+">" +
       "<label id='CZINOLQOUB_LBL' for='CZINOLQOUB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Abilita Schedulazione Raggruppamento Frazionate"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='GIORNIFRZ' id='BMMUPRLVUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_GIORNIFRZ,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RXEIJMGEQM_DIV'>" +
       "<label id='RXEIJMGEQM' for='ZZSBUTEXWS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prefisso per ip interni:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LIMITVLT' id='JFMMDZQFJC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_LIMITVLT,"N",10,2,"9,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RJCVXDREIV_DIV'>" +
       "<label id='RJCVXDREIV' for='JFMMDZQFJC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Limite Pagamento VLT:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LIMITVNP' id='OHKFECVWFV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_LIMITVNP,"N",10,2,"9,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RDFGAOKNTD_DIV'>" +
       "<label id='RDFGAOKNTD' for='OHKFECVWFV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Limite Pagamento Vincite Prenotate:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='OOAVIAADZS_DIV'>" +
       "<input name='FLGSTPDIR' id='OOAVIAADZS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGSTPDIR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGSTPDIR))?"CHECKED":"")+">" +
       "<label id='OOAVIAADZS_LBL' for='OOAVIAADZS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stampa moduli come download"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MRWHAAPELH_DIV'>" +
       "<input name='FLGNODOC' id='MRWHAAPELH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGNODOC,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGNODOC))?"CHECKED":"")+">" +
       "<label id='MRWHAAPELH_LBL' for='MRWHAAPELH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Controlla scadenza documento in import"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='HBTCFEMATT_DIV'>" +
       "<input name='FRAZDEL' id='HBTCFEMATT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FRAZDEL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FRAZDEL))?"CHECKED":"")+">" +
       "<label id='HBTCFEMATT_LBL' for='HBTCFEMATT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Cancella frazionate al termine del consolidamento"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHAPP' id='FOTKWJQFAL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHAPP,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JVKSSLUPHM_DIV'>" +
       "<label id='JVKSSLUPHM' for='FOTKWJQFAL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome applicazione CGO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='QMOTVZANBJ_DIV'>" +
       "<input name='FLGLIGHT' id='QMOTVZANBJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGLIGHT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGLIGHT))?"CHECKED":"")+">" +
       "<label id='QMOTVZANBJ_LBL' for='QMOTVZANBJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Consenti Import Soggetti Senza Documenti se attivo LightCheck"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='ROVOSMARIB' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Caricamento Manuale"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pathmanuale' id='JPABVPZDBZ' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_pathmanuale,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='80' size='80' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='VJPULIZVKG_DIV'>" +
       "<input name='FLGCGOPWD' id='VJPULIZVKG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCGOPWD,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCGOPWD))?"CHECKED":"")+">" +
       "<label id='VJPULIZVKG_LBL' for='VJPULIZVKG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Cambio Password CGO"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHSID' id='EMDHDDRUPP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHSID,"C",250,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='250' size='250' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PZUDQEMFCW_DIV'>" +
       "<label id='PZUDQEMFCW' for='EMDHDDRUPP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ultima versione Manuale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHCERT' id='WXRSSFBXYH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHCERT,"C",250,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='250' size='250' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QUNKJMETVO_DIV'>" +
       "<label id='QUNKJMETVO' for='WXRSSFBXYH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path Applicazione CGO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZNVCMRAKQV_DIV'>" +
       "<label id='ZNVCMRAKQV' for='XRGIDJXVCB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Limite Minimo Oper. Telematico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VXHBHRROHO_DIV'>" +
       "<label id='VXHBHRROHO' for='BMMUPRLVUU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Giorni per Consolidamento Frazionate:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHFTP' id='WPPFTLWEWX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHFTP,"C",128,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='128' size='128' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WNJNVATEHJ_DIV'>" +
       "<label id='WNJNVATEHJ' for='WPPFTLWEWX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path FTP per Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='KZJBLRRDWP_DIV'>" +
       "<input name='FLGUTEAGE' id='KZJBLRRDWP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGUTEAGE,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGUTEAGE))?"CHECKED":"")+">" +
       "<label id='KZJBLRRDWP_LBL' for='KZJBLRRDWP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea Utente alla creazione dell'agenzia"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PRGAEPATH' id='PUWCGJFLDF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PRGAEPATH,"C",250,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='250' size='250' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YGXQBBEZFG_DIV'>" +
       "<label id='YGXQBBEZFG' for='PUWCGJFLDF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Email Destinatario SOS:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMGIORN' id='NVZYOQAKDU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMGIORN,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RBGWMMIZHB_DIV'>" +
       "<label id='RBGWMMIZHB' for='NVZYOQAKDU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("GG  Provvisorio/Definitivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MHHQTFPDEN_DIV'>" +
       "<input name='FLGCGOOTP' id='MHHQTFPDEN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCGOOTP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCGOOTP))?"CHECKED":"")+">" +
       "<label id='MHHQTFPDEN_LBL' for='MHHQTFPDEN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Attivazione Gestione OTP"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='SSXDYZLCUX_DIV'>" +
       "<input name='FLGCGOQADV' id='SSXDYZLCUX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCGOQADV,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGCGOQADV))?"CHECKED":"")+">" +
       "<label id='SSXDYZLCUX_LBL' for='SSXDYZLCUX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Attiva Questionario Adeguata Verifica"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='BLOCCOUSER' id='XVGAGFPMXP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BLOCCOUSER,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NVZVLIUMGN_DIV'>" +
       "<label id='NVZVLIUMGN' for='XVGAGFPMXP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("GG Blocco utente non attivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ABGLJLFEYQ_DIV'>" +
       "<input name='CGOFLGPROF' id='ABGLJLFEYQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CGOFLGPROF,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_CGOFLGPROF))?"CHECKED":"")+">" +
       "<label id='ABGLJLFEYQ_LBL' for='ABGLJLFEYQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Richiesta Professione"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("CGO@BEGIN") || status.HasZoneAltInterface("CGO@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("CGO@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("CGO")) {
      status.out.println("Ctrl('VSXUXPIOIH').style.height='auto';");
    } else {
      status.out.println("Ctrl('VSXUXPIOIH').setAttribute('band_height',371);");
    }
    status.out.println("Ctrl('VSXUXPIOIH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b2(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_NGHUXVAVYG")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_NGHUXVAVYG' style='position:relative;height:7px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_NGHUXVAVYG")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_NGHUXVAVYG').style.height='auto';");
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
  void WriteControls_p4_b3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Socket' id='NGHUXVAVYG_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='NGHUXVAVYG_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='NGHUXVAVYG_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Validazione Socket")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='NGHUXVAVYG_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"NGHUXVAVYG\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=NGHUXVAVYG_HEADER&m_cBoxId=NGHUXVAVYG&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Validazione Socket"))+"");
    }
    status.out.println(
     "<div id='NGHUXVAVYG' class='SectionBody' style='position:relative;height:63px;display:block'>" +
    "");
    status.includeZoneAltInterface("Socket@BEGIN");
    if (status.includeZoneAltInterface("Socket")) {
      WriteControls_p4_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Socket@BEGIN") || status.HasZoneAltInterface("Socket@END")) {
        status.out.println(
         "<div id='NGHUXVAVYG_boxContent' style='position:relative;height:63px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SKT_SERVER' id='DNCMAAILTV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SKT_SERVER,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LBQAGEZTOQ_DIV'>" +
       "<label id='LBQAGEZTOQ' for='DNCMAAILTV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Socket Server:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SKT_PORT' id='UMEMYFCVBI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SKT_PORT,"N",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='5' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ALYRIEUNZA_DIV'>" +
       "<label id='ALYRIEUNZA' for='UMEMYFCVBI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Porta Socket:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SKT_PATHS' id='ZFUOSYKTGZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SKT_PATHS,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DVCWNGURJN_DIV'>" +
       "<label id='DVCWNGURJN' for='ZFUOSYKTGZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Socket Script Path:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SKT_MODET' id='ECARBEFMBC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("ssl","C",5,0,"", status.m_oRegSettings)+" "+(CPLib.eq("ssl",CPLib.Trim(BO.w_SKT_MODET))?"SELECTED":"")+">" +
       ""+status.context.Translate("SSL")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("http","C",5,0,"", status.m_oRegSettings)+" "+(CPLib.eq("http",CPLib.Trim(BO.w_SKT_MODET))?"SELECTED":"")+">" +
       ""+status.context.Translate("HTTP")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("https","C",5,0,"", status.m_oRegSettings)+" "+(CPLib.eq("https",CPLib.Trim(BO.w_SKT_MODET))?"SELECTED":"")+">" +
       ""+status.context.Translate("HTTPS")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ECARBEFMBC'),w_SKT_MODET,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JVXHUCMVZF_DIV'>" +
       "<label id='JVXHUCMVZF' for='ECARBEFMBC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Socket@BEGIN") || status.HasZoneAltInterface("Socket@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b3_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Socket@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Socket")) {
      status.out.println("Ctrl('NGHUXVAVYG').style.height='auto';");
    } else {
      status.out.println("Ctrl('NGHUXVAVYG').setAttribute('band_height',63);");
    }
    status.out.println("Ctrl('NGHUXVAVYG').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b4(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ENNTXFKBDB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ENNTXFKBDB' style='position:relative;height:7px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_ENNTXFKBDB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_ENNTXFKBDB').style.height='auto';");
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
  void WriteControls_p4_b5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='RespAnti' id='ENNTXFKBDB_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='ENNTXFKBDB_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='ENNTXFKBDB_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Responsabili AntiRiciclaggio")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='ENNTXFKBDB_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"ENNTXFKBDB\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=ENNTXFKBDB_HEADER&m_cBoxId=ENNTXFKBDB&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Responsabili AntiRiciclaggio"))+"");
    }
    status.out.println(
     "<div id='ENNTXFKBDB' class='SectionBody' style='position:relative;height:66px;display:block'>" +
    "");
    status.includeZoneAltInterface("RespAnti@BEGIN");
    if (status.includeZoneAltInterface("RespAnti")) {
      WriteControls_p4_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("RespAnti@BEGIN") || status.HasZoneAltInterface("RespAnti@END")) {
        status.out.println(
         "<div id='ENNTXFKBDB_boxContent' style='position:relative;height:66px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RASPAUI' id='DNNGPDMXQI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RASPAUI,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BCBTSVHELC_DIV'>" +
       "<label id='BCBTSVHELC' for='DNNGPDMXQI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Resp. Antiriciclaggio Gioco on line:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RESPAUI' id='WHJVJHBKYI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESPAUI,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NMLJUJKRDZ_DIV'>" +
       "<label id='NMLJUJKRDZ' for='WHJVJHBKYI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Resp. Antiriciclaggio Machine Gaming :"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("RespAnti@BEGIN") || status.HasZoneAltInterface("RespAnti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b5_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("RespAnti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("RespAnti")) {
      status.out.println("Ctrl('ENNTXFKBDB').style.height='auto';");
    } else {
      status.out.println("Ctrl('ENNTXFKBDB').setAttribute('band_height',66);");
    }
    status.out.println("Ctrl('ENNTXFKBDB').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b6(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p5_b0(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_5")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_5' style='position:relative;height:7px;display:block' page='5'>" +
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
  void WriteControls_p5_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='CGOEmail' id='AMSHYBLKWR_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='AMSHYBLKWR_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='AMSHYBLKWR_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Parametri Per EMAIL Alert")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='AMSHYBLKWR_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"AMSHYBLKWR\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=AMSHYBLKWR_HEADER&m_cBoxId=AMSHYBLKWR&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Parametri Per EMAIL Alert"))+"");
    }
    status.out.println(
     "<div id='AMSHYBLKWR' class='SectionBody' style='position:relative;height:89px;display:block'>" +
    "");
    status.includeZoneAltInterface("CGOEmail@BEGIN");
    if (status.includeZoneAltInterface("CGOEmail")) {
      WriteControls_p5_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("CGOEmail@BEGIN") || status.HasZoneAltInterface("CGOEmail@END")) {
        status.out.println(
         "<div id='AMSHYBLKWR_boxContent' style='position:relative;height:89px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTSRVMAIL' id='MLYQUOWFHN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTSRVMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EWRSHYJVWC_DIV'>" +
       "<label id='EWRSHYJVWC' for='MLYQUOWFHN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Server Invio Posta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTPRTMAIL' id='VRYHAZPGSR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTPRTMAIL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KRWHWQWWJO_DIV'>" +
       "<label id='KRWHWQWWJO' for='VRYHAZPGSR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Porta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTEMLMAIL' id='TYOXRXGXKJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTEMLMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NFXFLOJWRM_DIV'>" +
       "<label id='NFXFLOJWRM' for='TYOXRXGXKJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mail Invio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTUSRMAIL' id='OKEJPCYNVH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ALTUSRMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ROHUJGYBZU_DIV'>" +
       "<label id='ROHUJGYBZU' for='OKEJPCYNVH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Utente Posta:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ALTPWDMAIL' id='IIVBDSFKCC' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_ALTPWDMAIL,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"readonly":"")+" maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XWBWYCDSUH_DIV'>" +
       "<label id='XWBWYCDSUH' for='IIVBDSFKCC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("CGOEmail@BEGIN") || status.HasZoneAltInterface("CGOEmail@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("CGOEmail@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("CGOEmail")) {
      status.out.println("Ctrl('AMSHYBLKWR').style.height='auto';");
    } else {
      status.out.println("Ctrl('AMSHYBLKWR').setAttribute('band_height',89);");
    }
    status.out.println("Ctrl('AMSHYBLKWR').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b2(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_KNXWNOJPJB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_KNXWNOJPJB' style='position:relative;height:2px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_KNXWNOJPJB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_KNXWNOJPJB').style.height='auto';");
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
  void WriteControls_p5_b3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='GesDOC' id='KNXWNOJPJB_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='KNXWNOJPJB_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='KNXWNOJPJB_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Gestione Documentale")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='KNXWNOJPJB_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"KNXWNOJPJB\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=KNXWNOJPJB_HEADER&m_cBoxId=KNXWNOJPJB&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Gestione Documentale"))+"");
    }
    status.out.println(
     "<div id='KNXWNOJPJB' class='SectionBody' style='position:relative;height:315px;display:block'>" +
    "");
    status.includeZoneAltInterface("GesDOC@BEGIN");
    if (status.includeZoneAltInterface("GesDOC")) {
      WriteControls_p5_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("GesDOC@BEGIN") || status.HasZoneAltInterface("GesDOC@END")) {
        status.out.println(
         "<div id='KNXWNOJPJB_boxContent' style='position:relative;height:315px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='FYAHSLEGLP_DIV'>" +
       "<input name='FLGGESDOC' id='FYAHSLEGLP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGGESDOC,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGGESDOC))?"CHECKED":"")+">" +
       "<label id='FYAHSLEGLP_LBL' for='FYAHSLEGLP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Gestione Documentale Esterna"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='USRGESDOC' id='MUANKUGIIK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_USRGESDOC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QPIEEELYAP_DIV'>" +
       "<label id='QPIEEELYAP' for='MUANKUGIIK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Utente Ges. Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PWDGESDOC' id='HFVZAFILCA' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_PWDGESDOC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"readonly":"")+" maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GGIEQBUUGN_DIV'>" +
       "<label id='GGIEQBUUGN' for='HFVZAFILCA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password Ges. Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='URLDESDOC' id='RNIWEERJDP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_URLDESDOC,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='EMAILDOC' id='LZEBZLGWCH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_EMAILDOC,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ARQZPHKUOK_DIV'>" +
       "<label id='ARQZPHKUOK' for='RNIWEERJDP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("URL Ges. Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_cgo_tipall' id='TOSEVHXRVF' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YXBFOUJXZL_DIV'>" +
       "<label id='YXBFOUJXZL' for='LZEBZLGWCH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("EMail Comunicazioni:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATADOC' id='VOONRSAKSU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATADOC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
       "<button id='VOONRSAKSU_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MKAXCAIGIN_DIV' style='display:none'>" +
       "<label id='MKAXCAIGIN' for='VOONRSAKSU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Blocco Operazioni Senza Documenti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='DJJPJVNREQ' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Blocco Documenti"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_cgo_subnets' id='KDWFCOUSQZ' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("GesDOC@BEGIN") || status.HasZoneAltInterface("GesDOC@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b3_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("GesDOC@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("GesDOC")) {
      status.out.println("Ctrl('KNXWNOJPJB').style.height='auto';");
    } else {
      status.out.println("Ctrl('KNXWNOJPJB').setAttribute('band_height',315);");
    }
    status.out.println("Ctrl('KNXWNOJPJB').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['KNXWNOJPJB']=['KDWFCOUSQZ','TOSEVHXRVF'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b4(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_EOMKPJOLGE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_EOMKPJOLGE' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_EOMKPJOLGE")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_EOMKPJOLGE').style.height='auto';");
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
  void WriteControls_p5_b5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_EOMKPJOLGE' id='EOMKPJOLGE_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EOMKPJOLGE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EOMKPJOLGE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Path Documenti Bacheca")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EOMKPJOLGE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EOMKPJOLGE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EOMKPJOLGE_HEADER&m_cBoxId=EOMKPJOLGE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Path Documenti Bacheca"))+"");
    }
    status.out.println(
     "<div id='EOMKPJOLGE' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_EOMKPJOLGE@BEGIN");
    if (status.includeZoneAltInterface("box_EOMKPJOLGE")) {
      WriteControls_p5_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_EOMKPJOLGE@BEGIN") || status.HasZoneAltInterface("box_EOMKPJOLGE@END")) {
        status.out.println(
         "<div id='EOMKPJOLGE_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PATHDOCBAC' id='MRRDOEHYLX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PATHDOCBAC,"C",128,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='128' size='128' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SPTLVDHKHB_DIV'>" +
       "<label id='SPTLVDHKHB' for='MRRDOEHYLX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path Documenti Bacheca:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_EOMKPJOLGE@BEGIN") || status.HasZoneAltInterface("box_EOMKPJOLGE@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b5_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_EOMKPJOLGE@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_EOMKPJOLGE")) {
      status.out.println("Ctrl('EOMKPJOLGE').style.height='auto';");
    } else {
      status.out.println("Ctrl('EOMKPJOLGE').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('EOMKPJOLGE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b6(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MFFCPIVYZD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MFFCPIVYZD' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MFFCPIVYZD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MFFCPIVYZD').style.height='auto';");
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
  void WriteControls_p5_b7(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='E-Learning' id='MFFCPIVYZD_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MFFCPIVYZD_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MFFCPIVYZD_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("E-Learning")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MFFCPIVYZD_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MFFCPIVYZD\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MFFCPIVYZD_HEADER&m_cBoxId=MFFCPIVYZD&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("E-Learning"))+"");
    }
    status.out.println(
     "<div id='MFFCPIVYZD' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("E-Learning@BEGIN");
    if (status.includeZoneAltInterface("E-Learning")) {
      WriteControls_p5_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("E-Learning@BEGIN") || status.HasZoneAltInterface("E-Learning@END")) {
        status.out.println(
         "<div id='MFFCPIVYZD_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPPATH' id='ABFCWFBDMW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPPATH,"C",240,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='240' size='240' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SNAQIGBZKF_DIV'>" +
       "<label id='SNAQIGBZKF' for='ABFCWFBDMW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("URL Sito E-Learning:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("E-Learning@BEGIN") || status.HasZoneAltInterface("E-Learning@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b7_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("E-Learning@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("E-Learning")) {
      status.out.println("Ctrl('MFFCPIVYZD').style.height='auto';");
    } else {
      status.out.println("Ctrl('MFFCPIVYZD').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('MFFCPIVYZD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b8(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_UYDQCWOOEO")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_UYDQCWOOEO' style='position:relative;height:7px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_UYDQCWOOEO")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_UYDQCWOOEO').style.height='auto';");
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
  void WriteControls_p5_b9(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Multiple' id='UYDQCWOOEO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='UYDQCWOOEO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='UYDQCWOOEO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Default Multiple")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='UYDQCWOOEO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"UYDQCWOOEO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=UYDQCWOOEO_HEADER&m_cBoxId=UYDQCWOOEO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Default Multiple"))+"");
    }
    status.out.println(
     "<div id='UYDQCWOOEO' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("Multiple@BEGIN");
    if (status.includeZoneAltInterface("Multiple")) {
      WriteControls_p5_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Multiple@BEGIN") || status.HasZoneAltInterface("Multiple@END")) {
        status.out.println(
         "<div id='UYDQCWOOEO_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CGOTGDEFMUL' id='GORKFABVFF' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JXWDSHKCJJ_DIV'>" +
       "<label id='JXWDSHKCJJ' for='GORKFABVFF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Multiple@BEGIN") || status.HasZoneAltInterface("Multiple@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b9_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Multiple@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Multiple")) {
      status.out.println("Ctrl('UYDQCWOOEO').style.height='auto';");
    } else {
      status.out.println("Ctrl('UYDQCWOOEO').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('UYDQCWOOEO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b10(armt_intermboBO BO,ServletStatus status) {
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
  void WriteControls_p6_b0(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_6")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_6' style='position:relative;height:7px;display:block' page='6'>" +
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
  void WriteControls_p6_b1(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='ExtSO' id='QSIBTTRMLJ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='QSIBTTRMLJ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='QSIBTTRMLJ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Estrazione Scarico Offline")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='QSIBTTRMLJ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"QSIBTTRMLJ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=QSIBTTRMLJ_HEADER&m_cBoxId=QSIBTTRMLJ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Estrazione Scarico Offline"))+"");
    }
    status.out.println(
     "<div id='QSIBTTRMLJ' class='SectionBody' style='position:relative;height:126px;display:block'>" +
    "");
    status.includeZoneAltInterface("ExtSO@BEGIN");
    if (status.includeZoneAltInterface("ExtSO")) {
      WriteControls_p6_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ExtSO@BEGIN") || status.HasZoneAltInterface("ExtSO@END")) {
        status.out.println(
         "<div id='QSIBTTRMLJ_boxContent' style='position:relative;height:126px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SONUMMESI' id='HAPCMCIYJW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SONUMMESI,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OTANLZAUMP_DIV'>" +
       "<label id='OTANLZAUMP' for='HAPCMCIYJW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Mesi da estrarre:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOMESIBACK' id='OAAOYRQPRR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOMESIBACK,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IQSWXNMJHD_DIV'>" +
       "<label id='IQSWXNMJHD' for='OAAOYRQPRR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero mesi indietro:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='SOSHELLCMD' id='IDOPVICMXL' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JUWTXZPQPP_DIV'>" +
       "<label id='JUWTXZPQPP' for='IDOPVICMXL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comando Shell da \nEseguire al termine:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOAMBIENTE' id='ATYYTAXDZW' class='"+status.ObligatoryClass("Combobox",BO.ATYYTAXDZW_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("L","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_SOAMBIENTE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Linux")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("W","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("W",CPLib.Trim(BO.w_SOAMBIENTE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Windows")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ATYYTAXDZW'),w_SOAMBIENTE,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RQTPKYOXZT_DIV'>" +
       "<label id='RQTPKYOXZT' for='ATYYTAXDZW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ambiente Esecuzione Comando Shell:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("ExtSO@BEGIN") || status.HasZoneAltInterface("ExtSO@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b1_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ExtSO@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("ExtSO")) {
      status.out.println("Ctrl('QSIBTTRMLJ').style.height='auto';");
    } else {
      status.out.println("Ctrl('QSIBTTRMLJ').setAttribute('band_height',126);");
    }
    status.out.println("Ctrl('QSIBTTRMLJ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b2(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YAITYOPUEH")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YAITYOPUEH' style='position:relative;height:7px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YAITYOPUEH")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YAITYOPUEH').style.height='auto';");
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
  void WriteControls_p6_b3(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DestEmail' id='YAITYOPUEH_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YAITYOPUEH_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YAITYOPUEH_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Destinatari Email 380 Schedulato")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YAITYOPUEH_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YAITYOPUEH\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YAITYOPUEH_HEADER&m_cBoxId=YAITYOPUEH&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Destinatari Email 380 Schedulato"))+"");
    }
    status.out.println(
     "<div id='YAITYOPUEH' class='SectionBody' style='position:relative;height:189px;display:block'>" +
    "");
    status.includeZoneAltInterface("DestEmail@BEGIN");
    if (status.includeZoneAltInterface("DestEmail")) {
      WriteControls_p6_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DestEmail@BEGIN") || status.HasZoneAltInterface("DestEmail@END")) {
        status.out.println(
         "<div id='YAITYOPUEH_boxContent' style='position:relative;height:189px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_destemail' id='JWJORCKLGL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("DestEmail@BEGIN") || status.HasZoneAltInterface("DestEmail@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b3_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DestEmail@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DestEmail")) {
      status.out.println("Ctrl('YAITYOPUEH').style.height='auto';");
    } else {
      status.out.println("Ctrl('YAITYOPUEH').setAttribute('band_height',189);");
    }
    status.out.println("Ctrl('YAITYOPUEH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['YAITYOPUEH']=['JWJORCKLGL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b4(armt_intermboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MKILJOCTZW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MKILJOCTZW' style='position:relative;height:7px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MKILJOCTZW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MKILJOCTZW').style.height='auto';");
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
  void WriteControls_p6_b5(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='ImportVLT' id='MKILJOCTZW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MKILJOCTZW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MKILJOCTZW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Parametri per import VLT")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MKILJOCTZW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MKILJOCTZW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MKILJOCTZW_HEADER&m_cBoxId=MKILJOCTZW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Parametri per import VLT"))+"");
    }
    status.out.println(
     "<div id='MKILJOCTZW' class='SectionBody' style='position:relative;height:133px;display:block'>" +
    "");
    status.includeZoneAltInterface("ImportVLT@BEGIN");
    if (status.includeZoneAltInterface("ImportVLT")) {
      WriteControls_p6_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ImportVLT@BEGIN") || status.HasZoneAltInterface("ImportVLT@END")) {
        status.out.println(
         "<div id='MKILJOCTZW_boxContent' style='position:relative;height:133px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='SOPATHIMPORT' id='GHUASLAKBC' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MDAFYIMKHP_DIV'>" +
       "<label id='MDAFYIMKHP' for='GHUASLAKBC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Path file di import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOORAIMPORT' id='APTIWOKBUI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOORAIMPORT,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZWDTCOUNPV_DIV'>" +
       "<label id='ZWDTCOUNPV' for='APTIWOKBUI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ora Max import VLT:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='QADV_SOGLIA' id='HRSWOWLUUE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_QADV_SOGLIA,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AUWHLLTNOH_DIV'>" +
       "<label id='AUWHLLTNOH' for='HRSWOWLUUE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Soglia Alert QADV:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("ImportVLT@BEGIN") || status.HasZoneAltInterface("ImportVLT@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b5_CloseBand(armt_intermboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ImportVLT@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("ImportVLT")) {
      status.out.println("Ctrl('MKILJOCTZW').style.height='auto';");
    } else {
      status.out.println("Ctrl('MKILJOCTZW').setAttribute('band_height',133);");
    }
    status.out.println("Ctrl('MKILJOCTZW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b6(armt_intermboBO BO,ServletStatus status) {
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
  static void PrintState(armt_intermboBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_intermboBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_destwarn.IsUpdated()) {
      BO.m_cWv_ardt_destwarn = BO.ardt_destwarn.GetContext();
    }
    if (BO.ardt_cgo_tipall.IsUpdated()) {
      BO.m_cWv_ardt_cgo_tipall = BO.ardt_cgo_tipall.GetContext();
    }
    if (BO.ardt_cgo_subnets.IsUpdated()) {
      BO.m_cWv_ardt_cgo_subnets = BO.ardt_cgo_subnets.GetContext();
    }
    if (BO.ardt_destemail.IsUpdated()) {
      BO.m_cWv_ardt_destemail = BO.ardt_destemail.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_intermboBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TIPINTER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PARTIVA,"C",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATANASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOTGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAMOGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SETTSINT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPODOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMDOCUM,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTRILASC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOTE,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODORO,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDCITTA,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONTATORE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFINVIO,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAFINVIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FILEINVIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_URLAPPL,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGLOG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGAOS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGEAOS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCDOC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGAPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DTINIATT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGTIPIMP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGSTPCON,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGIMPAGE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINVIO,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPINTOPE,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGOPEXTR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGRAPCLI,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDATAIM,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDATATP,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOCODFISC,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCHK,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODAGE,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDSID,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SIDPASS,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHJAVA,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINST,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGSIDAUTO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSPMAF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGRITORNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCREAAGE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DTTITAGE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SCADSALDI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGIPMT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIMITEFRZ,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_DBPROT,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OAMTPDOC,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAYSIMPORT,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAYSIMPCMB,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOSV,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGAWUPOS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUGIOSCA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUGGALERT,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SKT_SERVER,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SKT_PORT,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SKT_PATHS,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SKT_MODET,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RASPAUI,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESPAUI,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TESTIP,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MINFRZSNAI,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGSCDFRZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_GIORNIFRZ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIMITVLT,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIMITVNP,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGSTPDIR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGNODOC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SNAISTOR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FRAZDEL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHAPP,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDDOC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGLIGHT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCGOPWD,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHSID,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHCERT,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHFTP,"C",128,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGUTEAGE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGAEPATH,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMGIORN,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COGNOME,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOME,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DNASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITTADINA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASCOMUN,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASSTATO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRNASC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOGCOM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTSRVMAIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTPRTMAIL,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTEMLMAIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTUSRMAIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTPWDMAIL,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGGESDOC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_USRGESDOC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PWDGESDOC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_URLDESDOC,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_EMAILDOC,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATADOC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHDOCBAC,"C",128,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPPATH,"C",240,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPCODPAT,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPENTSEG,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPCOGSEG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPNOMSEG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPTELSEG,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BPEMLSEG,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RICEVUTE,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ABI,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OGGI3I4,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOTGDEFMUL,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTOSARA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_GGWARNPRV,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_GGWARNAUI,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOGLIAMAX,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIMITE20,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SONUMMESI,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOMESIBACK,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSHELLCMD,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOAMBIENTE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOPATHIMPORT,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOORAIMPORT,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_SOGLIA,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCGOOTP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCGOQADV,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ITFLGPEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ITPWDPEP,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ITUSRPEP,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BLOCCOUSER,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGPROF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGAGGFAM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ALTSSLEMAIL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PATHIMPORT,"C",128,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESTEMAIL,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODVASP,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDOAM,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDOAMR,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ART1,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIsta,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCSGRU,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRAMGRU,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCUIC,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipsot,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescitdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcabdip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gUserCode,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ATTIV,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gUrlApp,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gAzienda,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PWDSER,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_appocert,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pathmanuale,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCAN,"C",50,0));
    if (CPLib.eq(BO.m_cWv_ardt_destwarn,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_destwarn");
    } else if (CPLib.eq(BO.m_cWv_ardt_destwarn,"_not_empty_")) {
      BO.m_cWv_ardt_destwarn = BO.ardt_destwarn.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_destwarn,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_destwarn,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_cgo_tipall,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_cgo_tipall");
    } else if (CPLib.eq(BO.m_cWv_ardt_cgo_tipall,"_not_empty_")) {
      BO.m_cWv_ardt_cgo_tipall = BO.ardt_cgo_tipall.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_tipall,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_tipall,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_cgo_subnets,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_cgo_subnets");
    } else if (CPLib.eq(BO.m_cWv_ardt_cgo_subnets,"_not_empty_")) {
      BO.m_cWv_ardt_cgo_subnets = BO.ardt_cgo_subnets.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_subnets,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_subnets,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_destemail,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_destemail");
    } else if (CPLib.eq(BO.m_cWv_ardt_destemail,"_not_empty_")) {
      BO.m_cWv_ardt_destemail = BO.ardt_destemail.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_destemail,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_destemail,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_MXPRRGVTSK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OCYWPELSQS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HCAZKBKJGO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FXLAZWVNMJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DOCORIFJEH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ORWPADTZZT = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PPBRHNBLNO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NRBJJRHEYL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(662,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1030,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_intermbo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'JXOBOAXKRQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JXOBOAXKRQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipint,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCGROGAZTR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JCGROGAZTR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'IIXRREUEAM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IIXRREUEAM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'LLYIGAMXRH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LLYIGAMXRH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'RVNHQCXNEM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RVNHQCXNEM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGNLLSFQHC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZGNLLSFQHC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'AYYXYNLAUC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AYYXYNLAUC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'PSZTLCSMPB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PSZTLCSMPB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'PZGXGIZQWY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PZGXGIZQWY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'DUROREWBNG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DUROREWBNG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZTUIXEONYI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZTUIXEONYI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'JXOBOAXKRQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipint,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCGROGAZTR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'IIXRREUEAM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'LLYIGAMXRH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'RVNHQCXNEM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGNLLSFQHC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'AYYXYNLAUC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'PSZTLCSMPB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'PZGXGIZQWY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'DUROREWBNG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZTUIXEONYI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_intermbo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_intermbo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_BWMEEFCWMJ"),"")) {
      status.quoteAndAppend("box_BWMEEFCWMJ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_FJJCZFOQTA"),"")) {
      status.quoteAndAppend("box_FJJCZFOQTA","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_PRFPRMFSTZ"),"")) {
      status.quoteAndAppend("box_PRFPRMFSTZ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("upload"),"")) {
      status.quoteAndAppend("upload","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("scadenze"),"")) {
      status.quoteAndAppend("scadenze","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ParamBase"),"")) {
      status.quoteAndAppend("ParamBase","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("PEP"),"")) {
      status.quoteAndAppend("PEP","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("CGOEmail"),"")) {
      status.quoteAndAppend("CGOEmail","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Import"),"")) {
      status.quoteAndAppend("Import","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Cambiavalute"),"")) {
      status.quoteAndAppend("Cambiavalute","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Base9Cambia"),"")) {
      status.quoteAndAppend("Base9Cambia","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DestWarn"),"")) {
      status.quoteAndAppend("DestWarn","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("OAM"),"")) {
      status.quoteAndAppend("OAM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("CGO"),"")) {
      status.quoteAndAppend("CGO","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Socket"),"")) {
      status.quoteAndAppend("Socket","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("RespAnti"),"")) {
      status.quoteAndAppend("RespAnti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("CGOEmail"),"")) {
      status.quoteAndAppend("CGOEmail","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("GesDOC"),"")) {
      status.quoteAndAppend("GesDOC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_EOMKPJOLGE"),"")) {
      status.quoteAndAppend("box_EOMKPJOLGE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("E-Learning"),"")) {
      status.quoteAndAppend("E-Learning","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Multiple"),"")) {
      status.quoteAndAppend("Multiple","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ExtSO"),"")) {
      status.quoteAndAppend("ExtSO","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DestEmail"),"")) {
      status.quoteAndAppend("DestEmail","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ImportVLT"),"")) {
      status.quoteAndAppend("ImportVLT","hide","box");
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
  void WriteMainFormScript(armt_intermboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_intermbo',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('JXOBOAXKRQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HVIUTGJWGE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCGROGAZTR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCGROGAZTR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UQKLCBCTLH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BQSGHFQUHM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IXWLDAOCFD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SJHNBZJAKA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IIXRREUEAM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IIXRREUEAM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SZWCLLEIQY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OIWIANSIOG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TNUQTSSGFZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LLYIGAMXRH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LLYIGAMXRH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVNHQCXNEM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVNHQCXNEM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGNLLSFQHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGNLLSFQHC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AYYXYNLAUC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OREVCZVNVS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCNHFVDZMT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZYURNYDRPU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YYONLOLCBB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PSZTLCSMPB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PSZTLCSMPB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('COVTIKSDDS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WSAOVXNTFO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPYQJILEQY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXHAWWCAZX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TFMCRMSOGY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YUCSUDKWNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JSTXCUBOUH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YOVFWZCOBN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QPIRUTKOVH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULCBOSJURF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KHHILRUMHZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ELBURHNYTV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JYYHNLJDWT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FLPFDBFHXV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LYZAJWZGAM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LAQADJFMRL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LAQADJFMRL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FTETLDBHIY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CWVJUDEVCT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FPFLFCPHAL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOQVPQLKOP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLWLPTWCFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('REBGPUSIPL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HKDCUQQHSU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCBVEBVMNW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IDROHZZWYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IQOQQQRZAK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IQOQQQRZAK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZPSOMDIBXB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PIGFPYZMIR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DUFIQNBDKW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LOYILZBSVI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YJCSSLPJKG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PXNLADGGBR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSHAMNPXFT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UETNARUDOE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UHGVOKNSVL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NLUIAOSQKM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XDDITMPJIZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LUPNVRRLHF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HFADCPKPNB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASIWFAENLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASIWFAENLM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOYUNQJDKZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOYUNQJDKZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LSBZHECNKO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FKIIMPSJSB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EQCSRKQZVC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KFQWZVCJIW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LGZDRUUSXZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FQKHRITNGP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SIZHWNZUOT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBHBPWJMOW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HXPRRNXNJO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AAIARGXIIW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PLWDFUBDIP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PDLIXDKBWK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PVOEPQLJPS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FCXDRDCINI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RBAZEQPPJI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VDJMSNZEEV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LNADTKDHIZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMAVZMPWRZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BZARULYZUH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CWFIJJMSTR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPHGLIUDNW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HSAOKMBAUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LGVTLPSUGS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KPSLGRAIIO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YRAEGOUXRJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OHRBGBCDVG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDJLQEMEDV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VTFLIHXHLG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SIJUUSKFLV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCZARGUGTG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCZARGUGTG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PZGXGIZQWY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PZGXGIZQWY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WQWXGOLVXC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DUROREWBNG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DUROREWBNG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZTUIXEONYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZTUIXEONYI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KSRCRPEMFT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IYKMLTUWXM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KYNLIGXUVC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IAXBQWHGLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PBQXUDZUOZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UBNVJIYFWU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PELELICXZD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DZVDAZOPWP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRZVDXDSOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TFDNMJLIWF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WRRSZRBPCI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUFIBBLEMQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MBMIGFSBXO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XUNVKFSSZL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CMBYXKAJCS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNQFAHXNUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUYJXGBDJI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DNCMAAILTV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMEMYFCVBI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZFUOSYKTGZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ECARBEFMBC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DNNGPDMXQI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WHJVJHBKYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZSBUTEXWS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XRGIDJXVCB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZINOLQOUB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BMMUPRLVUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JFMMDZQFJC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OHKFECVWFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OOAVIAADZS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MRWHAAPELH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HBTCFEMATT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FOTKWJQFAL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QMOTVZANBJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JPABVPZDBZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VJPULIZVKG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EMDHDDRUPP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WXRSSFBXYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WPPFTLWEWX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZJBLRRDWP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUWCGJFLDF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NVZYOQAKDU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MHHQTFPDEN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SSXDYZLCUX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XVGAGFPMXP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ABGLJLFEYQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MLYQUOWFHN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VRYHAZPGSR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TYOXRXGXKJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OKEJPCYNVH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IIVBDSFKCC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FYAHSLEGLP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUANKUGIIK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HFVZAFILCA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RNIWEERJDP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LZEBZLGWCH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VOONRSAKSU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VOONRSAKSU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MRRDOEHYLX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ABFCWFBDMW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GORKFABVFF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HAPCMCIYJW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OAAOYRQPRR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IDOPVICMXL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATYYTAXDZW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GHUASLAKBC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('APTIWOKBUI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRSWOWLUUE')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('JBFAVRHYDR')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('JBFAVRHYDR',linkpc_url('JBFAVRHYDR'));");
      status.out.println("}");
      status.out.println("if (Ctrl('TOSEVHXRVF')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('TOSEVHXRVF',linkpc_url('TOSEVHXRVF'));");
      status.out.println("}");
      status.out.println("if (Ctrl('KDWFCOUSQZ')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('KDWFCOUSQZ',linkpc_url('KDWFCOUSQZ'));");
      status.out.println("}");
      status.out.println("if (Ctrl('JWJORCKLGL')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('JWJORCKLGL',linkpc_url('JWJORCKLGL'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('YPYQJILEQY')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_destwarn')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_destwarn")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_cgo_tipall')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_cgo_tipall")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_cgo_subnets')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_cgo_subnets")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_destemail')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_destemail")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_intermbo");
    status.out.println("function CreaDIR() {");
    status.out.println("//  SetLocationHref(null,'arrt_creadir'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','')");
    status.out.println("  arrt_creadir([])");
    status.out.println("  alert('Creazione cartelle appicative completata');  ");
    status.out.println("}");
    status.out.println("");
    status.out.println("function AzzSemaforo() {");
    status.out.println("  arrt_azz_semaforo([])");
    status.out.println("  alert('Sblocco SID effettuato!');  ");
    status.out.println("}");
    status.out.println("");
    status.out.println("function Chiudi_Layer(_filename) {");
    status.out.println("arfn_upload_file_doc(Upper(_filename),'SID/CERTIFICATI','N')  ");
    status.out.println("LMKKKUVBBI_Click();");
    status.out.println("}  ");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_intermboBO getBO(ServletStatus status) {
    armt_intermboBO BO = new armt_intermboBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_intermboBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("intermbo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_intermboBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_intermboBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbtipint",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("TIPOINT");
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
    status.out.println("var JXOBOAXKRQ_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"","TIPDOC"));
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
    status.out.println("var AYYXYNLAUC_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbcandistr,CPSql.BuildSQLPhrase("CODICE,DESCRI",BO.m_cPhName_tbcandistr,"",""));
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
    status.out.println("var LYZAJWZGAM_Curs = "+l_cTmp+";");
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
    status.out.println("var GORKFABVFF_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_intermboBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_intermbo;
    String l_cPhName = BO.m_cPhName_intermbo;
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
      String l_cQueryFilter = armt_intermboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_intermbo+".CODINTER",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("intermbo");
    String l_cPhName = CPSql.ManipulateTablePhName("intermbo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CODINTER",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_intermboBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_intermboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_intermbo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_intermbo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_intermboBO BO) {
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
  void Edit(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
    BO.Load(status.w_CODINTER);
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
  void New(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_intermboBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CODINTER = "";
      } else {
        BO.w_CODINTER = l_rsKeys.GetString("CODINTER");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CODINTER = BO.w_CODINTER;
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
  void EditLoad(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CODINTER);
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
  void DeleteMessage(ServletStatus status,armt_intermboBO BO,SPParameterSource source) {
    BO.Load(status.w_CODINTER);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_intermboBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_intermboBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_intermboBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",642);
    item.put("w",1030);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Intermediario\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Settaggi Applicativo\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Cambiavalute \\/ Bil. Pagamenti \\/ OAM\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"CGO (1)\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"CGO (2)\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"CGO (3)\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Intermediario,Settaggi Applicativo,Cambiavalute / Bil. Pagamenti / OAM,CGO (1),CGO (2),CGO (3)");
    item.put("altInterfaceFor","armt_intermbo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"DatiBase\",\"h\":637,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"DatiBase\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Intermediario\",\"h\":20,\"maxlength\":2,\"name\":\"TIPINTER\",\"page\":1,\"spuid\":\"JXOBOAXKRQ\",\"tabindex\":2,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":848,\"x\":160,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CVRIOCDDYU\",\"page\":1,\"spuid\":\"CVRIOCDDYU\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Tipo Intermediario:\",\"w\":142,\"x\":16,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragione Sociale\",\"h\":20,\"maxlength\":70,\"name\":\"RAGSOC\",\"page\":1,\"spuid\":\"HVIUTGJWGE\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":160,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OINFLDOGXT\",\"page\":1,\"spuid\":\"OINFLDOGXT\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Ragione Sociale:\",\"w\":142,\"x\":16,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice\",\"h\":20,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":1,\"spuid\":\"YPYQJILEQY\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":760,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PGYTWCFSTL\",\"page\":1,\"spuid\":\"PGYTWCFSTL\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Codice:\",\"w\":160,\"x\":600,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":23,\"name\":\"button_ZYHCFDSBFP\",\"page\":1,\"picker\":true,\"spuid\":\"ZYHCFDSBFP\",\"tabindex\":112,\"type\":\"Button\",\"value\":\"Estrazione UIF (Cancellazione)\",\"w\":151,\"x\":856,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"JCGROGAZTR\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":246,\"x\":160,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UZZIVDGXTK\",\"page\":1,\"spuid\":\"UZZIVDGXTK\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":142,\"x\":16,\"y\":74,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"spuid\":\"UQKLCBCTLH\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":600,\"y\":70,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"spuid\":\"BQSGHFQUHM\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":672,\"y\":70,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"spuid\":\"IXWLDAOCFD\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":54,\"x\":794,\"y\":70,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JONRSBZIHE\",\"page\":1,\"spuid\":\"JONRSBZIHE\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":768,\"y\":74,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EOCHTUTBUF\",\"page\":1,\"spuid\":\"EOCHTUTBUF\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":77,\"x\":520,\"y\":74,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NMZHNTXQTF\",\"page\":1,\"spuid\":\"NMZHNTXQTF\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":27,\"x\":640,\"y\":74,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"SJHNBZJAKA\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":160,\"y\":98,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"IIXRREUEAM\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":472,\"y\":98,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RXTBTLMSHX\",\"page\":1,\"spuid\":\"RXTBTLMSHX\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":142,\"x\":16,\"y\":102,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OPSDKLYWTJ\",\"page\":1,\"spuid\":\"OPSDKLYWTJ\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Stato:\",\"w\":78,\"x\":392,\"y\":102,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MXPRRGVTSK\",\"page\":1,\"spuid\":\"MXPRRGVTSK\",\"tabindex\":50,\"type\":\"Label\",\"w\":312,\"x\":528,\"y\":102,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"spuid\":\"SZWCLLEIQY\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":160,\"y\":126,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Partita IVA\",\"h\":20,\"maxlength\":14,\"name\":\"PARTIVA\",\"page\":1,\"spuid\":\"OIWIANSIOG\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":400,\"y\":126,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Passaggio EURO\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"spuid\":\"TNUQTSSGFZ\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":640,\"y\":126,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XWWYBJUIHH\",\"page\":1,\"spuid\":\"XWWYBJUIHH\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":142,\"x\":16,\"y\":130,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OYUTQSFYLN\",\"page\":1,\"spuid\":\"OYUTQSFYLN\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Passaggio EURO:\",\"w\":134,\"x\":504,\"y\":130,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YQOAAOOFNL\",\"page\":1,\"spuid\":\"YQOAAOOFNL\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"Partita IVA:\",\"w\":106,\"x\":288,\"y\":130,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Sottogruppo Att. Ec.\",\"h\":20,\"maxlength\":3,\"name\":\"SOTGRUP\",\"page\":1,\"picker\":true,\"spuid\":\"LLYIGAMXRH\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":160,\"y\":154,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZZDCRCKYFX\",\"page\":1,\"spuid\":\"ZZDCRCKYFX\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"S.A.E.:\",\"w\":109,\"x\":49,\"y\":158,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HCAZKBKJGO\",\"page\":1,\"spuid\":\"HCAZKBKJGO\",\"tabindex\":60,\"type\":\"Label\",\"w\":504,\"x\":224,\"y\":158,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Ramo Gruppo Att. Ec.\",\"h\":20,\"maxlength\":3,\"name\":\"RAMOGRUP\",\"page\":1,\"picker\":true,\"spuid\":\"RVNHQCXNEM\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":160,\"y\":182,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QOLFDIWXXC\",\"page\":1,\"spuid\":\"QOLFDIWXXC\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Ramo Gruppo Att. Ec.:\",\"w\":142,\"x\":16,\"y\":186,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FXLAZWVNMJ\",\"page\":1,\"spuid\":\"FXLAZWVNMJ\",\"tabindex\":61,\"type\":\"Label\",\"w\":504,\"x\":224,\"y\":186,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Settorizzazione UIC\",\"h\":20,\"maxlength\":3,\"name\":\"SETTSINT\",\"page\":1,\"picker\":true,\"spuid\":\"ZGNLLSFQHC\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":160,\"y\":210,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHHLIWFNCK\",\"page\":1,\"spuid\":\"LHHLIWFNCK\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Settorizzazione UIC:\",\"w\":142,\"x\":16,\"y\":214,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DOCORIFJEH\",\"page\":1,\"spuid\":\"DOCORIFJEH\",\"tabindex\":62,\"type\":\"Label\",\"w\":504,\"x\":224,\"y\":214,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_BWMEEFCWMJ\",\"h\":63,\"name\":\"box_BWMEEFCWMJ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BWMEEFCWMJ\",\"tabindex\":3,\"type\":\"Box\",\"w\":992,\"x\":16,\"y\":238,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"spuid\":\"AYYXYNLAUC\",\"tabindex\":18,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":216,\"x\":160,\"y\":245,\"zone\":\"pag1_1_10_1\",\"zonepath\":\"[1,1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"spuid\":\"OREVCZVNVS\",\"tabindex\":19,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":84,\"x\":456,\"y\":245,\"zone\":\"pag1_1_10_1\",\"zonepath\":\"[1,1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HJLXKBUTGL\",\"page\":1,\"spuid\":\"HJLXKBUTGL\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":110,\"x\":48,\"y\":249,\"zone\":\"pag1_1_10_1\",\"zonepath\":\"[1,1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RFSBVMUUQX\",\"page\":1,\"spuid\":\"RFSBVMUUQX\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":39,\"x\":416,\"y\":249,\"zone\":\"pag1_1_10_1\",\"zonepath\":\"[1,1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_RBAUGZYNUB\",\"page\":1,\"spuid\":\"RBAUGZYNUB\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"Solo persone fisiche\",\"w\":128,\"x\":717,\"y\":241,\"zone\":\"pag1_1_10_2\",\"zonepath\":\"[1,1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Documento\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"spuid\":\"XCNHFVDZMT\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":160,\"y\":273,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"spuid\":\"ZYURNYDRPU\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":336,\"y\":273,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 Competente\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"spuid\":\"YYONLOLCBB\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":648,\"y\":273,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CPZJUXWKDU\",\"page\":1,\"spuid\":\"CPZJUXWKDU\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"N\\u00B0 Documento:\",\"w\":110,\"x\":48,\"y\":277,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVKVLQFAAC\",\"page\":1,\"spuid\":\"IVKVLQFAAC\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Data Rilascio:\",\"w\":69,\"x\":266,\"y\":277,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NSALRHXEBM\",\"page\":1,\"spuid\":\"NSALRHXEBM\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Aut. Competente:\",\"w\":87,\"x\":560,\"y\":277,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio\",\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"spuid\":\"MXHAWWCAZX\",\"tabindex\":70,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":476,\"y\":273,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OPNSNKCGEE\",\"page\":1,\"spuid\":\"OPNSNKCGEE\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Fine Validit\\u00E0:\",\"w\":61,\"x\":414,\"y\":277,\"zone\":\"pag1_1_10_3\",\"zonepath\":\"[1,1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":20,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"picker\":true,\"spuid\":\"PSZTLCSMPB\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":308,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SJBGPBDZHD\",\"page\":1,\"spuid\":\"SJBGPBDZHD\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Codice Dipendenza:\",\"w\":151,\"x\":8,\"y\":312,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OCYWPELSQS\",\"page\":1,\"spuid\":\"OCYWPELSQS\",\"tabindex\":58,\"type\":\"Label\",\"w\":232,\"x\":235,\"y\":312,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CWLRHUCLYA\",\"page\":1,\"spuid\":\"CWLRHUCLYA\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":28,\"x\":512,\"y\":308,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ORWPADTZZT\",\"page\":1,\"spuid\":\"ORWPADTZZT\",\"tabindex\":66,\"type\":\"Label\",\"w\":224,\"x\":544,\"y\":308,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PPBRHNBLNO\",\"page\":1,\"spuid\":\"PPBRHNBLNO\",\"tabindex\":68,\"type\":\"Label\",\"w\":72,\"x\":904,\"y\":308,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FMNNNQHJID\",\"page\":1,\"spuid\":\"FMNNNQHJID\",\"tabindex\":69,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":872,\"y\":308,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Annotazioni\",\"h\":56,\"name\":\"NOTE\",\"page\":1,\"scroll\":true,\"spuid\":\"COVTIKSDDS\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":688,\"x\":160,\"y\":336,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SXFVWFHYFF\",\"page\":1,\"spuid\":\"SXFVWFHYFF\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Note\",\"w\":110,\"x\":48,\"y\":336,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_HNIRGTQRAE\",\"page\":1,\"picker\":true,\"spuid\":\"HNIRGTQRAE\",\"tabindex\":115,\"type\":\"Button\",\"value\":\"Button\",\"w\":50,\"x\":856,\"y\":364,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cod. Segnalante ORO\",\"h\":20,\"maxlength\":20,\"name\":\"CODORO\",\"page\":1,\"spuid\":\"WSAOVXNTFO\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":160,\"y\":399,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGMFJTDOCE\",\"page\":1,\"spuid\":\"BGMFJTDOCE\",\"tabindex\":98,\"type\":\"Label\",\"value\":\"Cod. Segnalante ORO:\",\"w\":144,\"x\":16,\"y\":403,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EXFKQPWTSQ\",\"page\":1,\"spuid\":\"EXFKQPWTSQ\",\"tabindex\":103,\"type\":\"Label\",\"value\":\"Canale Distributivo (SV):\",\"w\":160,\"x\":352,\"y\":403,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Canale Distributivo (SV)\",\"h\":20,\"maxlength\":3,\"name\":\"TIPOSV\",\"page\":1,\"spuid\":\"LYZAJWZGAM\",\"tabindex\":104,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":336,\"x\":512,\"y\":399,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_FJJCZFOQTA\",\"h\":56,\"name\":\"box_FJJCZFOQTA\",\"page\":1,\"shrinkable\":true,\"spuid\":\"FJJCZFOQTA\",\"tabindex\":4,\"type\":\"Box\",\"w\":992,\"x\":16,\"y\":455,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale Organo Invio File\",\"h\":20,\"maxlength\":16,\"name\":\"CFINVIO\",\"page\":1,\"spuid\":\"TFMCRMSOGY\",\"tabindex\":75,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":160,\"y\":483,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice CAF Organo Invio\",\"h\":20,\"maxlength\":5,\"name\":\"CAFINVIO\",\"page\":1,\"spuid\":\"YUCSUDKWNH\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":344,\"y\":483,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Preparazione FIle\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FILEINVIO\",\"page\":1,\"spuid\":\"JSTXCUBOUH\",\"tabindex\":77,\"textlist\":\"Comunicazione predisposta da contribuente,Comunicazione predisposta da chi effettua la trasmissione\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":296,\"x\":456,\"y\":483,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OFRQJUQSPY\",\"page\":1,\"spuid\":\"OFRQJUQSPY\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"Impegno Alla Presentazione Telematica\",\"w\":225,\"x\":584,\"y\":462,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WFJIAHYNWC\",\"page\":1,\"spuid\":\"WFJIAHYNWC\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":136,\"x\":24,\"y\":487,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FZHRVSFEMP\",\"page\":1,\"spuid\":\"FZHRVSFEMP\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"N\\u00B0 CAF:\",\"w\":39,\"x\":303,\"y\":487,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VBUGEDJFHA\",\"page\":1,\"spuid\":\"VBUGEDJFHA\",\"tabindex\":81,\"type\":\"Label\",\"value\":\"Tipo:\",\"w\":38,\"x\":416,\"y\":487,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Impegno\",\"h\":20,\"maxlength\":10,\"name\":\"DATAINVIO\",\"page\":1,\"spuid\":\"YOVFWZCOBN\",\"tabindex\":82,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":839,\"y\":483,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NEDHUIILCP\",\"page\":1,\"spuid\":\"NEDHUIILCP\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"Data Impegno:\",\"w\":111,\"x\":728,\"y\":487,\"zone\":\"pag1_1_15_1\",\"zonepath\":\"[1,1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_PRFPRMFSTZ\",\"h\":105,\"name\":\"box_PRFPRMFSTZ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PRFPRMFSTZ\",\"tabindex\":84,\"type\":\"Box\",\"w\":992,\"x\":16,\"y\":518,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Identificativo SID\",\"h\":20,\"maxlength\":8,\"name\":\"IDSID\",\"page\":1,\"spuid\":\"QPIRUTKOVH\",\"tabindex\":86,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":168,\"y\":539,\"zone\":\"pag1_1_16_1\",\"zonepath\":\"[1,1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OLANUOOFSZ\",\"page\":1,\"spuid\":\"OLANUOOFSZ\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Identificativo SID:\",\"w\":120,\"x\":48,\"y\":543,\"zone\":\"pag1_1_16_1\",\"zonepath\":\"[1,1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password\",\"h\":20,\"maxlength\":30,\"name\":\"SIDPASS\",\"page\":1,\"spuid\":\"ULCBOSJURF\",\"tabindex\":88,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":368,\"y\":539,\"zone\":\"pag1_1_16_1\",\"zonepath\":\"[1,1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QJJQEBOELV\",\"page\":1,\"spuid\":\"QJJQEBOELV\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"Password:\",\"w\":104,\"x\":264,\"y\":543,\"zone\":\"pag1_1_16_1\",\"zonepath\":\"[1,1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Percorso Java VM (JRE)\",\"h\":20,\"maxlength\":250,\"name\":\"PATHJAVA\",\"page\":1,\"spuid\":\"KHHILRUMHZ\",\"tabindex\":90,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":680,\"x\":168,\"y\":567,\"zone\":\"pag1_1_16_2\",\"zonepath\":\"[1,1,16,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZHRRJTCMJ\",\"page\":1,\"spuid\":\"RZHRRJTCMJ\",\"tabindex\":91,\"type\":\"Label\",\"value\":\"Java VM (JRE):\",\"w\":120,\"x\":48,\"y\":571,\"zone\":\"pag1_1_16_2\",\"zonepath\":\"[1,1,16,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Installazione\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOINST\",\"page\":1,\"spuid\":\"ELBURHNYTV\",\"tabindex\":92,\"textlist\":\"Windows,Linux\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"W"+"'"+","+"'"+"L"+"'"+"\",\"w\":184,\"x\":168,\"y\":595,\"zone\":\"pag1_1_16_3\",\"zonepath\":\"[1,1,16,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UOUQMGWZYN\",\"page\":1,\"spuid\":\"UOUQMGWZYN\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"Tipo Installazione:\",\"w\":120,\"x\":48,\"y\":599,\"zone\":\"pag1_1_16_3\",\"zonepath\":\"[1,1,16,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":21,\"label_text\":\"Configurazione Manuale SID\",\"maxlength\":2,\"name\":\"FLGSIDAUTO\",\"page\":1,\"spuid\":\"JYYHNLJDWT\",\"tabindex\":94,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":304,\"x\":368,\"y\":595,\"zone\":\"pag1_1_16_3\",\"zonepath\":\"[1,1,16,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_LMKKKUVBBI\",\"page\":1,\"picker\":true,\"spuid\":\"LMKKKUVBBI\",\"tabindex\":96,\"type\":\"Button\",\"value\":\"Caricamento Certificati\",\"w\":158,\"x\":840,\"y\":595,\"zone\":\"pag1_1_16_3\",\"zonepath\":\"[1,1,16,3]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_DFVZKIFMYL\",\"page\":1,\"picker\":true,\"spuid\":\"DFVZKIFMYL\",\"tabindex\":99,\"type\":\"Button\",\"value\":\"Visualizza Certificati\",\"w\":138,\"x\":695,\"y\":595,\"zone\":\"pag1_1_16_3\",\"zonepath\":\"[1,1,16,3]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ONFEVIMYAT\",\"page\":1,\"spuid\":\"ONFEVIMYAT\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"Dati Accesso SID\",\"w\":225,\"x\":773,\"y\":525,\"zone\":\"pag1_1_16_4\",\"zonepath\":\"[1,1,16,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_LBMKPTTAXP\",\"page\":1,\"picker\":true,\"spuid\":\"LBMKPTTAXP\",\"tabindex\":101,\"type\":\"Button\",\"value\":\"Sblocco SID\",\"w\":158,\"x\":840,\"y\":540,\"zone\":\"pag1_1_16_4\",\"zonepath\":\"[1,1,16,4]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Passaggio a \\u20AC 5.000\",\"h\":20,\"maxlength\":10,\"name\":\"LIMITE20\",\"page\":1,\"picker\":true,\"spuid\":\"LAQADJFMRL\",\"tabindex\":107,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":160,\"y\":427,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZTVBLCEEKH\",\"page\":1,\"spuid\":\"ZTVBLCEEKH\",\"tabindex\":108,\"type\":\"Label\",\"value\":\"Passaggio a \\u20AC 5.000:\",\"w\":144,\"x\":16,\"y\":431,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_TXEDKCGZGL\",\"page\":1,\"spuid\":\"TXEDKCGZGL\",\"tabindex\":109,\"type\":\"Label\",\"value\":\"Provv.  B.I. del 24\\/03\\/2020  (se non viene indicato nulla il default \\u00E8 il 31-12-2020)\",\"w\":501,\"x\":260,\"y\":431,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Controllo tetto \\u20AC 5000\",\"h\":21,\"label_text\":\"Esegui i controlli del tetto dei \\u20AC 5.000\",\"maxlength\":2,\"name\":\"ART1\",\"page\":1,\"spuid\":\"CWVJUDEVCT\",\"tabindex\":116,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":232,\"x\":768,\"y\":426,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"VASP Registration Number\",\"h\":20,\"maxlength\":10,\"name\":\"CODVASP\",\"page\":1,\"spuid\":\"FTETLDBHIY\",\"tabindex\":113,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":912,\"y\":126,\"zone\":\"pag1_1_18\",\"zonepath\":\"[1,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HUPLKWHBHY\",\"page\":1,\"spuid\":\"HUPLKWHBHY\",\"tabindex\":114,\"type\":\"Label\",\"value\":\"VASP Registration Number:\",\"w\":143,\"x\":769,\"y\":130,\"zone\":\"pag1_1_18\",\"zonepath\":\"[1,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"scadenze\",\"box_type\":\"layer\",\"fixed\":true,\"h\":408,\"name\":\"scadenze\",\"page\":1,\"shrinkable\":true,\"spuid\":\"IXYGPGIHLH\",\"tabindex\":110,\"type\":\"Box\",\"w\":472,\"x\":1372,\"y\":14,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"container\":\"IXYGPGIHLH\",\"h\":408,\"name\":\"scadenze\",\"page\":1,\"spuid\":\"HUBBQEHTVM\",\"src\":\"\\/jsp\\/pg_dati_certificati_portlet.jsp?ForcedPortletUID=HUBBQEHTVM\",\"tabindex\":111,\"type\":\"Portlet\",\"w\":469,\"x\":1374,\"y\":14,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"upload\",\"box_type\":\"layer\",\"fixed\":true,\"h\":301,\"name\":\"upload\",\"page\":1,\"shrinkable\":true,\"spuid\":\"KAJTGMRBSU\",\"tabindex\":105,\"type\":\"Box\",\"w\":472,\"x\":1364,\"y\":483,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"container\":\"KAJTGMRBSU\",\"h\":301,\"name\":\"upload\",\"page\":1,\"spuid\":\"AIBXPWTSFP\",\"src\":\"\\/jsp\\/pg_upload_doc_portlet.jsp?ForcedPortletUID=AIBXPWTSFP\",\"tabindex\":106,\"type\":\"Portlet\",\"w\":472,\"x\":1365,\"y\":484,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ParamBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Parametri di Base\",\"h\":497,\"name\":\"ParamBase\",\"page\":2,\"shrinkable\":true,\"spuid\":\"POUNPHSDYV\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Parametri di Base\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":7,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"URL Applicazione\",\"h\":20,\"maxlength\":80,\"name\":\"URLAPPL\",\"page\":2,\"spuid\":\"FPFLFCPHAL\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":128,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXCKUPWOFP\",\"page\":2,\"spuid\":\"PXCKUPWOFP\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Nome Applicazione:\",\"w\":110,\"x\":16,\"y\":18,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_ZHYZMPHABC\",\"page\":2,\"picker\":true,\"spuid\":\"ZHYZMPHABC\",\"tabindex\":23,\"type\":\"Button\",\"value\":\"Crea Cartelle di Sistema\",\"w\":165,\"x\":648,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Attivazione Log Procedura\",\"h\":21,\"label_text\":\"Monitoraggio Applicazione\",\"maxlength\":1,\"name\":\"FLGLOG\",\"page\":2,\"spuid\":\"EOQVPQLKOP\",\"tabindex\":4,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":24,\"y\":63,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Collegamento anagrafica documenti\",\"h\":21,\"label_text\":\"Stampe Documenti Originali\",\"maxlength\":1,\"name\":\"FLGCDOC\",\"page\":2,\"spuid\":\"HKDCUQQHSU\",\"tabindex\":7,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":200,\"x\":208,\"y\":63,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Gestione Western Union\",\"h\":21,\"label_text\":\"Gestione Western Union\",\"maxlength\":1,\"name\":\"FLGWU\",\"page\":2,\"spuid\":\"LOYILZBSVI\",\"tabindex\":18,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":416,\"y\":62,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"IDP MoneyTransfer\",\"h\":21,\"label_text\":\"IP MoneyTransfer\",\"maxlength\":1,\"name\":\"FLGIPMT\",\"page\":2,\"spuid\":\"LSBZHECNKO\",\"tabindex\":39,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":600,\"y\":63,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Collegamento con AOS\",\"h\":21,\"label_text\":\"Collegamento TER\",\"maxlength\":1,\"name\":\"FLGAOS\",\"page\":2,\"spuid\":\"BLWLPTWCFV\",\"tabindex\":5,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":24,\"y\":42,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Ereditariet\\u00E0 Fattori Rischio\",\"h\":21,\"label_text\":\"Eredit\\u00E0 Fattori Rischio\",\"maxlength\":1,\"name\":\"FLGEAOS\",\"page\":2,\"spuid\":\"REBGPUSIPL\",\"tabindex\":6,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":200,\"x\":208,\"y\":42,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Aggerega solo frazionate\",\"h\":21,\"label_text\":\"Aggrega solo frazionate\",\"maxlength\":1,\"name\":\"FLGFRAZ\",\"page\":2,\"spuid\":\"CCBVEBVMNW\",\"tabindex\":8,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":416,\"y\":42,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Collegamento a WEBCHK\",\"h\":21,\"label_text\":\"Collegamento a WEBCHK\",\"maxlength\":1,\"name\":\"FLGCHK\",\"page\":2,\"spuid\":\"UHGVOKNSVL\",\"tabindex\":27,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":600,\"y\":42,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Campo Aggiuntivo In ARCHPERS\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLGAPERS\",\"page\":2,\"spuid\":\"IDROHZZWYH\",\"tabindex\":9,\"textlist\":\"Standard,Unico file Rapporti\\/Informazioni\\/Intestatari,Campo Aggiuntivo ARCHPERS + Storico Autom.,Import schedulato,Import MT,Import WUBS\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"4"+"'"+","+"'"+"5"+"'"+","+"'"+"6"+"'"+"\",\"w\":464,\"x\":128,\"y\":119,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OEFBKJVZGI\",\"page\":2,\"spuid\":\"OEFBKJVZGI\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Modalit\\u00E0 Import:\",\"w\":110,\"x\":16,\"y\":123,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Scadenza Correzione Errori\",\"h\":20,\"maxlength\":4,\"name\":\"WUGIOSCA\",\"page\":2,\"spuid\":\"QBHBPWJMOW\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":768,\"y\":119,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JIDHZWEVMP\",\"page\":2,\"spuid\":\"JIDHZWEVMP\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Giorni Scadenza Correzione Errori:\",\"w\":180,\"x\":588,\"y\":123,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio Attivit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DTINIATT\",\"page\":2,\"picker\":true,\"spuid\":\"IQOQQQRZAK\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":720,\"y\":175,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AWSAENIKPZ\",\"page\":2,\"spuid\":\"AWSAENIKPZ\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Inizio Attivit\\u00E0:\",\"w\":115,\"x\":600,\"y\":179,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Import per Scheduler\",\"h\":19,\"maxlength\":1,\"name\":\"FLGTIPIMP\",\"orientation\":\"horizontal\",\"page\":2,\"spuid\":\"ZPSOMDIBXB\",\"tabindex\":13,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":162,\"x\":128,\"y\":175,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MNXQLPZJTD\",\"page\":2,\"spuid\":\"MNXQLPZJTD\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Import Scheduler:\",\"w\":112,\"x\":14,\"y\":178,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Crea Stampa Controllo\",\"h\":21,\"label_text\":\"Crea stampa controllo Import\",\"maxlength\":1,\"name\":\"FLGSTPCON\",\"page\":2,\"spuid\":\"PIGFPYZMIR\",\"tabindex\":15,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":416,\"y\":175,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Differenza Import\",\"h\":20,\"maxlength\":3,\"name\":\"DAYSIMPORT\",\"page\":2,\"spuid\":\"LGZDRUUSXZ\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":24,\"x\":256,\"y\":147,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FLAGKQKWLF\",\"page\":2,\"spuid\":\"FLAGKQKWLF\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Giorni Differenza Import:\",\"w\":168,\"x\":88,\"y\":151,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Import Cambiavalute\",\"h\":20,\"maxlength\":3,\"name\":\"DAYSIMPCMB\",\"page\":2,\"spuid\":\"FQKHRITNGP\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":24,\"x\":512,\"y\":147,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FNFPYHHCTJ\",\"page\":2,\"spuid\":\"FNFPYHHCTJ\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Giorni Differenza Import Cambiavalute:\",\"w\":216,\"x\":296,\"y\":151,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Alert Scadenza\",\"h\":20,\"maxlength\":4,\"name\":\"WUGGALERT\",\"page\":2,\"spuid\":\"HXPRRNXNJO\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":768,\"y\":147,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OIGTNGXRRH\",\"page\":2,\"spuid\":\"OIGTNGXRRH\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Giorni Alert Scadenza:\",\"w\":152,\"x\":616,\"y\":151,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Import Age\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLGIMPAGE\",\"page\":2,\"spuid\":\"DUFIQNBDKW\",\"tabindex\":16,\"textlist\":\"Ricostruzione Standard,Ricostruzione con Base File Excel\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":464,\"x\":128,\"y\":224,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FRGSTKSWWS\",\"page\":2,\"spuid\":\"FRGSTKSWWS\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Ripristino da file AgE:\",\"w\":118,\"x\":8,\"y\":228,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo per raggruppamento frazionate\",\"h\":20,\"maxlength\":13,\"name\":\"IMPINTOPE\",\"page\":2,\"spuid\":\"YJCSSLPJKG\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":96,\"x\":720,\"y\":252,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HGDWNYPDSM\",\"page\":2,\"spuid\":\"HGDWNYPDSM\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Importo per consolidamento frazionate:\",\"w\":264,\"x\":456,\"y\":256,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Crea movimento modifica in anagrafe operazioni extraconto\",\"h\":21,\"label_text\":\"Crea movimento modifica in anagrafe operazioni extraconto con import PERSNEW\",\"maxlength\":1,\"name\":\"FLGOPEXTR\",\"page\":2,\"spuid\":\"PXNLADGGBR\",\"tabindex\":21,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":496,\"x\":128,\"y\":279,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Minimo Controllo Fraz.\",\"h\":20,\"maxlength\":11,\"name\":\"LIMITEFRZ\",\"page\":2,\"spuid\":\"FKIIMPSJSB\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":344,\"y\":252,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OUASZKTMZL\",\"page\":2,\"spuid\":\"OUASZKTMZL\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Importo Minimo Singola Frazionata per Consolidamento:\",\"w\":328,\"x\":16,\"y\":256,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Attiva Gestione OTP\",\"h\":21,\"label_text\":\"Attivazione Gestione OTP\",\"maxlength\":1,\"name\":\"FLGCGOOTP\",\"page\":2,\"spuid\":\"FCXDRDCINI\",\"tabindex\":61,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":184,\"x\":632,\"y\":280,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Seleziona Automaticamente CLienti da rapport in import operazioni\",\"h\":21,\"label_text\":\"Carica Automaticamente Clienti in import operazioni se presente rapporto continuativo\",\"maxlength\":1,\"name\":\"FLGRAPCLI\",\"page\":2,\"spuid\":\"OSHAMNPXFT\",\"tabindex\":22,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":568,\"x\":128,\"y\":301,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Non effettuare calcolo automatico codice fiscale in anagrafica persone\",\"h\":21,\"label_text\":\"Non effettuare calcolo automatico codice fiscale in anagrafica persone\",\"maxlength\":2,\"name\":\"NOCODFISC\",\"page\":2,\"spuid\":\"UETNARUDOE\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":392,\"x\":24,\"y\":84,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"h\":20,\"maxlength\":10,\"name\":\"PWDSER\",\"page\":2,\"spuid\":\"NLUIAOSQKM\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":80,\"x\":128,\"y\":371,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Passato EURO\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSPMAF\",\"page\":2,\"spuid\":\"XDDITMPJIZ\",\"tabindex\":30,\"textlist\":\"Segnala se DataReg. < Data Sistema,Impedisce registrazioni se DataReg. < Data Sistema,Impedisce registrazioni se DataReg. # Data Sistema,Data Registrazione non controllata,Data Registrazione = Data Sistema\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"I"+"'"+","+"'"+"U"+"'"+","+"'"+"N"+"'"+","+"'"+"B"+"'"+"\",\"w\":306,\"x\":512,\"y\":371,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_USUAFIVIAY\",\"page\":2,\"spuid\":\"USUAFIVIAY\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Controllo Data Registrazione:\",\"w\":198,\"x\":312,\"y\":375,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_REOBNBRGTT\",\"page\":2,\"spuid\":\"REOBNBRGTT\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Servizio:\",\"w\":110,\"x\":16,\"y\":375,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Creazione Inversa File di Import prima di passaggio a definitivo\",\"h\":21,\"label_text\":\"Creazione Inversa File di Import\",\"maxlength\":1,\"name\":\"FLGRITORNO\",\"page\":2,\"spuid\":\"LUPNVRRLHF\",\"tabindex\":33,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":600,\"y\":84,\"zone\":\"pag2_1_12\",\"zonepath\":\"[2,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Crea rettifiche\\/cancellazioni per Agenzia Entrate\",\"h\":21,\"label_text\":\"Crea rettifiche\\/cancellazioni per Agenzia Entrate\",\"maxlength\":1,\"name\":\"FLGCREAAGE\",\"page\":2,\"spuid\":\"HFADCPKPNB\",\"tabindex\":34,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":304,\"x\":128,\"y\":395,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Autocompletamento Intermediario Controparte SARA\",\"h\":21,\"label_text\":\"Autocompletamento Intermediario Controparte S.AR.A.\",\"maxlength\":1,\"name\":\"AUTOSARA\",\"page\":2,\"spuid\":\"PVOEPQLJPS\",\"tabindex\":60,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":376,\"x\":440,\"y\":395,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data da cui inviare i titolari effettivi\",\"h\":20,\"maxlength\":10,\"name\":\"DTTITAGE\",\"page\":2,\"picker\":true,\"spuid\":\"ASIWFAENLM\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":440,\"y\":420,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LUCDNUTLOB\",\"page\":2,\"spuid\":\"LUCDNUTLOB\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Data inizio rapporti da cui vogliamo che venga inviato il dato sul titolare effettivo:\",\"w\":426,\"x\":12,\"y\":424,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Modello Ad. Verifica\",\"h\":20,\"maxlength\":100,\"name\":\"DBPROT\",\"page\":2,\"spuid\":\"EQCSRKQZVC\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":128,\"y\":448,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OWCRFMADTX\",\"page\":2,\"spuid\":\"OWCRFMADTX\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Modello Adeg. Verifica:\",\"w\":128,\"x\":0,\"y\":452,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Gestione documenti per OAM\",\"h\":21,\"label_text\":\"Gestione documenti per OAM\",\"maxlength\":2,\"name\":\"OAMTPDOC\",\"page\":2,\"spuid\":\"KFQWZVCJIW\",\"tabindex\":45,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":216,\"x\":128,\"y\":196,\"zone\":\"pag2_1_16\",\"zonepath\":\"[2,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Attiva gestione WUPOS\",\"h\":21,\"label_text\":\"Elabora solo Agenti WUPOS\",\"maxlength\":1,\"name\":\"FLGAWUPOS\",\"page\":2,\"spuid\":\"SIZHWNZUOT\",\"tabindex\":50,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":416,\"y\":195,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path Documenti\",\"h\":20,\"maxlength\":250,\"name\":\"RICEVUTE\",\"page\":2,\"spuid\":\"AAIARGXIIW\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":688,\"x\":128,\"y\":476,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EKCSWYBUKQ\",\"page\":2,\"spuid\":\"EKCSWYBUKQ\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Path Documenti:\",\"w\":104,\"x\":24,\"y\":480,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Gestisce Causali I3\\/I4 in Comunicazioni Oggettive\",\"h\":21,\"label_text\":\"Gestisce Causali I3\\/I4 in Comunicazioni Oggettive\",\"maxlength\":1,\"name\":\"OGGI3I4\",\"page\":2,\"spuid\":\"PLWDFUBDIP\",\"tabindex\":57,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":368,\"x\":128,\"y\":345,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Tipo Gioco Default Multiple\",\"h\":21,\"label_text\":\"Verifiche semplificate per S.AR.A.\",\"maxlength\":3,\"name\":\"CGOTGDEFMUL\",\"page\":2,\"spuid\":\"PDLIXDKBWK\",\"tabindex\":58,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":304,\"x\":512,\"y\":345,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici\",\"h\":21,\"label_text\":\"Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici\",\"maxlength\":1,\"name\":\"FLGAGGFAM\",\"page\":2,\"spuid\":\"XMAVZMPWRZ\",\"tabindex\":68,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":680,\"x\":128,\"y\":323,\"zone\":\"pag2_1_20\",\"zonepath\":\"[2,1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PEP\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Collegamento con Liste PEP\",\"h\":77,\"name\":\"PEP\",\"page\":2,\"shrinkable\":true,\"spuid\":\"CCPBATRTRJ\",\"stretch\":true,\"tabindex\":67,\"title_caption\":\"Collegamento con Liste PEP\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":511,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Collegamento Liste PEP\",\"h\":21,\"label_text\":\"Collegamento Liste PEP\\/Crime\",\"maxlength\":1,\"name\":\"ITFLGPEP\",\"page\":2,\"spuid\":\"RBAZEQPPJI\",\"tabindex\":62,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":184,\"x\":32,\"y\":525,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Utente per colloquio liste PEP\",\"h\":20,\"maxlength\":50,\"name\":\"ITUSRPEP\",\"page\":2,\"spuid\":\"LNADTKDHIZ\",\"tabindex\":64,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":320,\"x\":288,\"y\":525,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TROEZOSPBE\",\"page\":2,\"spuid\":\"TROEZOSPBE\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"Utente:\",\"w\":77,\"x\":208,\"y\":529,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password per colloquio con liste pep\",\"h\":20,\"maxlength\":50,\"name\":\"ITPWDPEP\",\"page\":2,\"spuid\":\"VDJMSNZEEV\",\"tabindex\":63,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":320,\"x\":288,\"y\":553,\"zone\":\"pag2_2_2\",\"zonepath\":\"[2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZYNRGRHMEV\",\"page\":2,\"spuid\":\"ZYNRGRHMEV\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"Password:\",\"w\":85,\"x\":200,\"y\":557,\"zone\":\"pag2_2_2\",\"zonepath\":\"[2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"CGOEmail\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Parametri Per EMAIL Alert\",\"h\":105,\"name\":\"CGOEmail\",\"page\":2,\"shrinkable\":true,\"spuid\":\"DQBIMZLTTE\",\"stretch\":true,\"tabindex\":69,\"title_caption\":\"Parametri Per EMAIL Alert\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":595,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Server Invio Posta\",\"h\":20,\"maxlength\":50,\"name\":\"ALTSRVMAIL\",\"page\":2,\"spuid\":\"BZARULYZUH\",\"tabindex\":70,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":609,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ICYIBIEJPT\",\"page\":2,\"spuid\":\"ICYIBIEJPT\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Server Invio Posta:\",\"w\":112,\"x\":16,\"y\":613,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Porta\",\"h\":20,\"maxlength\":5,\"name\":\"ALTPRTMAIL\",\"page\":2,\"spuid\":\"CWFIJJMSTR\",\"tabindex\":72,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":520,\"y\":609,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ATTOCVUWED\",\"page\":2,\"spuid\":\"ATTOCVUWED\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"Porta:\",\"w\":80,\"x\":440,\"y\":613,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mail Invio\",\"h\":20,\"maxlength\":50,\"name\":\"ALTEMLMAIL\",\"page\":2,\"spuid\":\"YPHGLIUDNW\",\"tabindex\":74,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":637,\"zone\":\"pag2_3_2\",\"zonepath\":\"[2,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UPYNWKDWTI\",\"page\":2,\"spuid\":\"UPYNWKDWTI\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Mail Invio:\",\"w\":120,\"x\":8,\"y\":641,\"zone\":\"pag2_3_2\",\"zonepath\":\"[2,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Utente Invio\",\"h\":20,\"maxlength\":50,\"name\":\"ALTUSRMAIL\",\"page\":2,\"spuid\":\"HSAOKMBAUY\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":665,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RHFVPZJHSD\",\"page\":2,\"spuid\":\"RHFVPZJHSD\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"Utente Posta:\",\"w\":112,\"x\":16,\"y\":669,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password\",\"h\":20,\"maxlength\":80,\"name\":\"ALTPWDMAIL\",\"page\":2,\"spuid\":\"LGVTLPSUGS\",\"tabindex\":78,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":480,\"x\":520,\"y\":665,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CAZHGSIXHK\",\"page\":2,\"spuid\":\"CAZHGSIXHK\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"Password:\",\"w\":72,\"x\":448,\"y\":669,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Usa SSL\",\"h\":21,\"label_text\":\"Utilizza SSL\",\"maxlength\":1,\"name\":\"ALTSSLEMAIL\",\"page\":2,\"spuid\":\"KPSLGRAIIO\",\"tabindex\":80,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":120,\"x\":592,\"y\":609,\"zone\":\"pag2_3_4\",\"zonepath\":\"[2,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Import\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Parametri Import Schedulato\",\"h\":77,\"name\":\"Import\",\"page\":2,\"shrinkable\":true,\"spuid\":\"XFBWYNZQZN\",\"stretch\":true,\"tabindex\":81,\"title_caption\":\"Parametri Import Schedulato\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":707,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path File Import\",\"h\":20,\"maxlength\":128,\"name\":\"PATHIMPORT\",\"page\":2,\"spuid\":\"YRAEGOUXRJ\",\"tabindex\":82,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":780,\"x\":152,\"y\":721,\"zone\":\"pag2_4_1\",\"zonepath\":\"[2,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AUPNFEOYCV\",\"page\":2,\"spuid\":\"AUPNFEOYCV\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"Path File Import:\",\"w\":136,\"x\":16,\"y\":725,\"zone\":\"pag2_4_1\",\"zonepath\":\"[2,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Destinatario Email Import\",\"h\":20,\"maxlength\":80,\"name\":\"DESTEMAIL\",\"page\":2,\"spuid\":\"OHRBGBCDVG\",\"tabindex\":84,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":152,\"y\":749,\"zone\":\"pag2_4_2\",\"zonepath\":\"[2,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ISGMMWGAEC\",\"page\":2,\"spuid\":\"ISGMMWGAEC\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"Destinatario Email Import:\",\"w\":144,\"x\":8,\"y\":753,\"zone\":\"pag2_4_2\",\"zonepath\":\"[2,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Cambiavalute\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Cambiavalute\",\"h\":166,\"name\":\"Cambiavalute\",\"page\":3,\"shrinkable\":true,\"spuid\":\"CESCBNVXDE\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Cambiavalute\",\"titled\":true,\"type\":\"Box\",\"w\":944,\"x\":8,\"y\":7,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#FFFF00\",\"h\":19,\"name\":\"label_FIZGFLGSCA\",\"page\":3,\"spuid\":\"FIZGFLGSCA\",\"tabindex\":2,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"Persona Fisica\\/Ditta Individuale\",\"w\":814,\"x\":9,\"y\":9,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":30,\"name\":\"COGNOME\",\"page\":3,\"spuid\":\"KDJLQEMEDV\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":111,\"y\":34,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":30,\"name\":\"NOME\",\"page\":3,\"spuid\":\"VTFLIHXHLG\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":339,\"y\":34,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":3,\"spuid\":\"SIJUUSKFLV\",\"tabindex\":5,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":104,\"x\":573,\"y\":34,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nato il\",\"h\":20,\"maxlength\":10,\"name\":\"DNASC\",\"page\":3,\"picker\":true,\"spuid\":\"XCZARGUGTG\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":726,\"y\":35,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ROSZPLTXFI\",\"page\":3,\"spuid\":\"ROSZPLTXFI\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":87,\"x\":24,\"y\":38,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KHSXGUNTRM\",\"page\":3,\"spuid\":\"KHSXGUNTRM\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":34,\"x\":305,\"y\":38,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NPSJWIVGOM\",\"page\":3,\"spuid\":\"NPSJWIVGOM\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":45,\"x\":528,\"y\":38,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHZGAVQLHJ\",\"page\":3,\"spuid\":\"LHZGAVQLHJ\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Nato il:\",\"w\":54,\"x\":672,\"y\":39,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Domicilio\",\"h\":20,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":3,\"picker\":true,\"spuid\":\"PZGXGIZQWY\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":111,\"y\":62,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":3,\"readonly\":\"true\",\"spuid\":\"MUWSLBTIOI\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":407,\"y\":62,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UPFDNQAQQN\",\"page\":3,\"spuid\":\"UPFDNQAQQN\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Domicilio:\",\"w\":48,\"x\":63,\"y\":66,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JKODERXVSD\",\"page\":3,\"spuid\":\"JKODERXVSD\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":51,\"x\":356,\"y\":66,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cittadinanza\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"CITTADINA\",\"page\":3,\"spuid\":\"WQWXGOLVXC\",\"tabindex\":13,\"textlist\":\"Cittadinanzia Italiana,Cittadinanza Comunitaria,Cittadinanza ExtraComunitaria\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+"\",\"w\":240,\"x\":575,\"y\":62,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QEDFADZTLI\",\"page\":3,\"spuid\":\"QEDFADZTLI\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Cittadinanza:\",\"w\":119,\"x\":456,\"y\":66,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Comune di Nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":3,\"picker\":true,\"spuid\":\"DUROREWBNG\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":248,\"x\":111,\"y\":90,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RDSGVORAHH\",\"page\":3,\"spuid\":\"RDSGVORAHH\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Comune di Nascita:\",\"w\":101,\"x\":10,\"y\":94,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":3,\"picker\":true,\"spuid\":\"ZTUIXEONYI\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":479,\"y\":90,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FEFHMTGUWV\",\"page\":3,\"spuid\":\"FEFHMTGUWV\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":103,\"x\":376,\"y\":94,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prov. Nasc.\",\"h\":20,\"maxlength\":2,\"name\":\"PRNASC\",\"page\":3,\"spuid\":\"KSRCRPEMFT\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":791,\"y\":90,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MMUGKFYZMW\",\"page\":3,\"spuid\":\"MMUGKFYZMW\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":66,\"x\":725,\"y\":94,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#FFFF00\",\"h\":19,\"name\":\"label_MZKLEUIIGG\",\"page\":3,\"spuid\":\"MZKLEUIIGG\",\"tabindex\":22,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"Societ\\u00E0\",\"w\":814,\"x\":9,\"y\":119,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Societ\\u00E0\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOGCOM\",\"page\":3,\"spuid\":\"IYKMLTUWXM\",\"tabindex\":23,\"textlist\":\"Soggetto Italiano,Soggetto comunitario (stabile organizzazione)\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":304,\"x\":111,\"y\":146,\"zone\":\"pag3_1_6\",\"zonepath\":\"[3,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FTRVPLIAQI\",\"page\":3,\"spuid\":\"FTRVPLIAQI\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Tipo Societ\\u00E0:\",\"w\":95,\"x\":16,\"y\":150,\"zone\":\"pag3_1_6\",\"zonepath\":\"[3,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Se Cambiavalute non \\u00E8 attivit\\u00E0 prvalente\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":3,\"spuid\":\"KYNLIGXUVC\",\"tabindex\":25,\"textlist\":\"IP+Cambiavalute,Op. Prof. Oro+Cambiavalute,Altro+Cambiavalute\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+"\",\"w\":176,\"x\":639,\"y\":146,\"zone\":\"pag3_1_6\",\"zonepath\":\"[3,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UFURNZFHIZ\",\"page\":3,\"spuid\":\"UFURNZFHIZ\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Se Cambiavalute non \\u00E8 attivit\\u00E0 prevalente:\",\"w\":226,\"x\":413,\"y\":150,\"zone\":\"pag3_1_6\",\"zonepath\":\"[3,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Base9Cambia\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Comunicazioni Oggettive\",\"h\":140,\"name\":\"Base9Cambia\",\"page\":3,\"shrinkable\":true,\"spuid\":\"XEDASKHZOQ\",\"stretch\":true,\"tabindex\":28,\"title_caption\":\"Comunicazioni Oggettive\",\"titled\":true,\"type\":\"Box\",\"w\":944,\"x\":8,\"y\":175,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Partner\",\"h\":20,\"maxlength\":12,\"name\":\"BPCODPAT\",\"page\":3,\"spuid\":\"IAXBQWHGLM\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":84,\"x\":112,\"y\":196,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HABRXIELKU\",\"page\":3,\"spuid\":\"HABRXIELKU\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Codice Partner:\",\"w\":96,\"x\":16,\"y\":200,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Ente Segnalatore\",\"h\":20,\"maxlength\":12,\"name\":\"BPENTSEG\",\"page\":3,\"spuid\":\"PBQXUDZUOZ\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":84,\"x\":448,\"y\":196,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IYWXEOHSIG\",\"page\":3,\"spuid\":\"IYWXEOHSIG\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Codice Ente Segnalatore:\",\"w\":216,\"x\":232,\"y\":200,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome Segnalatore\",\"h\":20,\"maxlength\":30,\"name\":\"BPCOGSEG\",\"page\":3,\"spuid\":\"UBNVJIYFWU\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":112,\"y\":224,\"zone\":\"pag3_2_2\",\"zonepath\":\"[3,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AZWMLMXFTT\",\"page\":3,\"spuid\":\"AZWMLMXFTT\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":104,\"x\":8,\"y\":228,\"zone\":\"pag3_2_2\",\"zonepath\":\"[3,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":30,\"name\":\"BPNOMSEG\",\"page\":3,\"spuid\":\"PELELICXZD\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":448,\"y\":224,\"zone\":\"pag3_2_2\",\"zonepath\":\"[3,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QSZTRDTOHH\",\"page\":3,\"spuid\":\"QSZTRDTOHH\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":136,\"x\":312,\"y\":228,\"zone\":\"pag3_2_2\",\"zonepath\":\"[3,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Telefono Segnalatore\",\"h\":20,\"maxlength\":15,\"name\":\"BPTELSEG\",\"page\":3,\"spuid\":\"DZVDAZOPWP\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":112,\"y\":252,\"zone\":\"pag3_2_3\",\"zonepath\":\"[3,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GALIAYORFO\",\"page\":3,\"spuid\":\"GALIAYORFO\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Telefono:\",\"w\":96,\"x\":16,\"y\":256,\"zone\":\"pag3_2_3\",\"zonepath\":\"[3,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"EMail\",\"h\":20,\"maxlength\":50,\"name\":\"BPEMLSEG\",\"page\":3,\"spuid\":\"HRZVDXDSOJ\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":448,\"y\":252,\"zone\":\"pag3_2_3\",\"zonepath\":\"[3,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LQQXWNYQRB\",\"page\":3,\"spuid\":\"LQQXWNYQRB\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"EMail:\",\"w\":112,\"x\":336,\"y\":256,\"zone\":\"pag3_2_3\",\"zonepath\":\"[3,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ABI\",\"h\":20,\"maxlength\":6,\"name\":\"ABI\",\"page\":3,\"spuid\":\"TFDNMJLIWF\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":64,\"x\":112,\"y\":280,\"zone\":\"pag3_2_4\",\"zonepath\":\"[3,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QCYZGHORPG\",\"page\":3,\"spuid\":\"QCYZGHORPG\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"ABI:\",\"w\":88,\"x\":24,\"y\":284,\"zone\":\"pag3_2_4\",\"zonepath\":\"[3,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"h\":20,\"maxlength\":6,\"name\":\"CAB\",\"page\":3,\"spuid\":\"WRRSZRBPCI\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":64,\"x\":448,\"y\":280,\"zone\":\"pag3_2_4\",\"zonepath\":\"[3,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_APGZAARWJB\",\"page\":3,\"spuid\":\"APGZAARWJB\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":128,\"x\":320,\"y\":284,\"zone\":\"pag3_2_4\",\"zonepath\":\"[3,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DestWarn\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Destinatari Warning\",\"h\":224,\"name\":\"DestWarn\",\"page\":3,\"shrinkable\":true,\"spuid\":\"HDNWLIPNPD\",\"stretch\":true,\"tabindex\":46,\"title_caption\":\"Destinatari Warning\",\"titled\":true,\"type\":\"Box\",\"w\":944,\"x\":8,\"y\":322,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Warning Provvisorio \",\"h\":20,\"maxlength\":4,\"name\":\"GGWARNPRV\",\"page\":3,\"spuid\":\"PUFIBBLEMQ\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":232,\"y\":336,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FBHJBOUZMO\",\"page\":3,\"spuid\":\"FBHJBOUZMO\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Giorni Warning Provvisorio :\",\"w\":208,\"x\":24,\"y\":340,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni Warning AUI\",\"h\":20,\"maxlength\":4,\"name\":\"GGWARNAUI\",\"page\":3,\"spuid\":\"MBMIGFSBXO\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":424,\"y\":336,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HPOFGKJCFG\",\"page\":3,\"spuid\":\"HPOFGKJCFG\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Giorni Warning AUI:\",\"w\":144,\"x\":280,\"y\":340,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Soglia Max Controllo Transazioni\",\"h\":20,\"maxlength\":17,\"name\":\"SOGLIAMAX\",\"page\":3,\"spuid\":\"XUNVKFSSZL\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":84,\"x\":688,\"y\":336,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MLGAKKSLBW\",\"page\":3,\"spuid\":\"MLGAKKSLBW\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Soglia Max Controllo Transazioni:\",\"w\":240,\"x\":448,\"y\":340,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":164,\"name\":\"ardt_destwarn\",\"page\":3,\"spuid\":\"JBFAVRHYDR\",\"tabindex\":45,\"type\":\"Iframe\",\"w\":697,\"x\":80,\"y\":371,\"zone\":\"pag3_3_2\",\"zonepath\":\"[3,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"OAM\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"OAM\",\"h\":49,\"name\":\"OAM\",\"page\":3,\"shrinkable\":true,\"spuid\":\"TQULLVKAWF\",\"stretch\":true,\"tabindex\":53,\"title_caption\":\"OAM\",\"titled\":true,\"type\":\"Box\",\"w\":944,\"x\":8,\"y\":553,\"zone\":\"pag3_4\",\"zonepath\":\"[3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"VASP Registration Number\",\"h\":20,\"maxlength\":10,\"name\":\"CODVASP\",\"page\":3,\"spuid\":\"CMBYXKAJCS\",\"tabindex\":54,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":184,\"y\":567,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SCMDDRTKOA\",\"page\":3,\"spuid\":\"SCMDDRTKOA\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"VASP Registration Number:\",\"w\":168,\"x\":16,\"y\":571,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Identificativo OAM\",\"h\":20,\"maxlength\":8,\"name\":\"IDOAM\",\"page\":3,\"spuid\":\"CNQFAHXNUY\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":80,\"x\":472,\"y\":567,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IMVVZYFAKP\",\"page\":3,\"spuid\":\"IMVVZYFAKP\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Identificativo OAM:\",\"w\":128,\"x\":344,\"y\":571,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Soggetto rappresentato \",\"h\":20,\"maxlength\":8,\"name\":\"IDOAMR\",\"page\":3,\"spuid\":\"PUYJXGBDJI\",\"tabindex\":58,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":808,\"y\":567,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HQOSRSTJSV\",\"page\":3,\"spuid\":\"HQOSRSTJSV\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"ID Soggetto rappresentato :\",\"w\":150,\"x\":658,\"y\":571,\"zone\":\"pag3_4_1\",\"zonepath\":\"[3,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Socket\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Validazione Socket\",\"h\":63,\"name\":\"Socket\",\"page\":4,\"shrinkable\":true,\"spuid\":\"NGHUXVAVYG\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Validazione Socket\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":385,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Socket Server\",\"h\":20,\"maxlength\":30,\"name\":\"SKT_SERVER\",\"page\":4,\"spuid\":\"DNCMAAILTV\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":128,\"y\":392,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LBQAGEZTOQ\",\"page\":4,\"spuid\":\"LBQAGEZTOQ\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Socket Server:\",\"w\":112,\"x\":16,\"y\":396,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Porta Socket\",\"h\":20,\"maxlength\":6,\"name\":\"SKT_PORT\",\"page\":4,\"spuid\":\"UMEMYFCVBI\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":42,\"x\":720,\"y\":392,\"zone\":\"pag4_1_2\",\"zonepath\":\"[4,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ALYRIEUNZA\",\"page\":4,\"spuid\":\"ALYRIEUNZA\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Porta Socket:\",\"w\":128,\"x\":592,\"y\":396,\"zone\":\"pag4_1_2\",\"zonepath\":\"[4,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Socket Script Path\",\"h\":20,\"maxlength\":60,\"name\":\"SKT_PATHS\",\"page\":4,\"spuid\":\"ZFUOSYKTGZ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":128,\"y\":420,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DVCWNGURJN\",\"page\":4,\"spuid\":\"DVCWNGURJN\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Socket Script Path:\",\"w\":120,\"x\":8,\"y\":424,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Modalit\\u00E0\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"SKT_MODET\",\"page\":4,\"spuid\":\"ECARBEFMBC\",\"tabindex\":10,\"textlist\":\"SSL,HTTP,HTTPS\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"ssl"+"'"+","+"'"+"http"+"'"+","+"'"+"https"+"'"+"\",\"w\":96,\"x\":720,\"y\":419,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JVXHUCMVZF\",\"page\":4,\"spuid\":\"JVXHUCMVZF\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Modalit\\u00E0:\",\"w\":112,\"x\":608,\"y\":423,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"RespAnti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Responsabili AntiRiciclaggio\",\"h\":66,\"name\":\"RespAnti\",\"page\":4,\"shrinkable\":true,\"spuid\":\"ENNTXFKBDB\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Responsabili AntiRiciclaggio\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":455,\"zone\":\"pag4_2\",\"zonepath\":\"[4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Responsabile Antiriciclaggio\",\"h\":20,\"maxlength\":50,\"name\":\"RASPAUI\",\"page\":4,\"spuid\":\"DNNGPDMXQI\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":296,\"y\":462,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BCBTSVHELC\",\"page\":4,\"spuid\":\"BCBTSVHELC\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Resp. Antiriciclaggio Gioco on line:\",\"w\":232,\"x\":64,\"y\":466,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Responsabile\",\"h\":20,\"maxlength\":50,\"name\":\"RESPAUI\",\"page\":4,\"spuid\":\"WHJVJHBKYI\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":296,\"y\":490,\"zone\":\"pag4_2_2\",\"zonepath\":\"[4,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NMLJUJKRDZ\",\"page\":4,\"spuid\":\"NMLJUJKRDZ\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Resp. Antiriciclaggio Machine Gaming :\",\"w\":240,\"x\":56,\"y\":494,\"zone\":\"pag4_2_2\",\"zonepath\":\"[4,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"CGO\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"CGO\",\"h\":371,\"name\":\"CGO\",\"page\":4,\"shrinkable\":true,\"spuid\":\"VSXUXPIOIH\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"CGO\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":7,\"zone\":\"pag4_3\",\"zonepath\":\"[4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tripletta per controllo ip interni\",\"h\":20,\"maxlength\":11,\"name\":\"TESTIP\",\"page\":4,\"spuid\":\"ZZSBUTEXWS\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":160,\"y\":14,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RXEIJMGEQM\",\"page\":4,\"spuid\":\"RXEIJMGEQM\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Prefisso per ip interni:\",\"w\":136,\"x\":24,\"y\":18,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Minimo Telematico x Operazioni\",\"h\":20,\"maxlength\":13,\"name\":\"MINFRZSNAI\",\"page\":4,\"spuid\":\"XRGIDJXVCB\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":608,\"y\":14,\"zone\":\"pag4_3_2\",\"zonepath\":\"[4,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZNVCMRAKQV\",\"page\":4,\"spuid\":\"ZNVCMRAKQV\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Limite Minimo Oper. Telematico:\",\"w\":224,\"x\":384,\"y\":18,\"zone\":\"pag4_3_2\",\"zonepath\":\"[4,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Abilita Schedulazione Raggruppamento Frazionate\",\"h\":21,\"label_text\":\"Abilita Schedulazione Raggruppamento Frazionate\",\"maxlength\":1,\"name\":\"FLGSCDFRZ\",\"page\":4,\"spuid\":\"CZINOLQOUB\",\"tabindex\":18,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":336,\"x\":48,\"y\":42,\"zone\":\"pag4_3_3\",\"zonepath\":\"[4,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Giorni per Consolidamento Frazionate\",\"h\":20,\"maxlength\":4,\"name\":\"GIORNIFRZ\",\"page\":4,\"spuid\":\"BMMUPRLVUU\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":608,\"y\":42,\"zone\":\"pag4_3_3\",\"zonepath\":\"[4,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VXHBHRROHO\",\"page\":4,\"spuid\":\"VXHBHRROHO\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Giorni per Consolidamento Frazionate:\",\"w\":248,\"x\":360,\"y\":46,\"zone\":\"pag4_3_3\",\"zonepath\":\"[4,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Limite Pagamento VLT\",\"h\":20,\"maxlength\":15,\"name\":\"LIMITVLT\",\"page\":4,\"spuid\":\"JFMMDZQFJC\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":160,\"y\":70,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RJCVXDREIV\",\"page\":4,\"spuid\":\"RJCVXDREIV\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Limite Pagamento VLT:\",\"w\":152,\"x\":8,\"y\":74,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Limite Vincite Prenotate\",\"h\":20,\"maxlength\":15,\"name\":\"LIMITVNP\",\"page\":4,\"spuid\":\"OHKFECVWFV\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":424,\"y\":70,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RDFGAOKNTD\",\"page\":4,\"spuid\":\"RDFGAOKNTD\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Limite Pagamento Vincite Prenotate:\",\"w\":184,\"x\":240,\"y\":74,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Download stampa\",\"h\":21,\"label_text\":\"Stampa moduli come download\",\"maxlength\":1,\"name\":\"FLGSTPDIR\",\"page\":4,\"spuid\":\"OOAVIAADZS\",\"tabindex\":25,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":600,\"y\":98,\"zone\":\"pag4_3_5\",\"zonepath\":\"[4,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Cancella frazionate al termine del consolidamento\",\"h\":21,\"label_text\":\"Cancella frazionate al termine del consolidamento\",\"maxlength\":1,\"name\":\"FRAZDEL\",\"page\":4,\"spuid\":\"HBTCFEMATT\",\"tabindex\":29,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":336,\"x\":160,\"y\":124,\"zone\":\"pag4_3_6\",\"zonepath\":\"[4,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome applicazione CGO\",\"h\":20,\"maxlength\":80,\"name\":\"PATHAPP\",\"page\":4,\"spuid\":\"FOTKWJQFAL\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":231,\"zone\":\"pag4_3_7\",\"zonepath\":\"[4,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JVKSSLUPHM\",\"page\":4,\"spuid\":\"JVKSSLUPHM\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Nome applicazione CGO:\",\"w\":144,\"x\":16,\"y\":235,\"zone\":\"pag4_3_7\",\"zonepath\":\"[4,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"GG Blocco utente non attivo\",\"h\":20,\"maxlength\":4,\"name\":\"BLOCCOUSER\",\"page\":4,\"spuid\":\"XVGAGFPMXP\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":160,\"y\":203,\"zone\":\"pag4_3_7\",\"zonepath\":\"[4,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NVZVLIUMGN\",\"page\":4,\"spuid\":\"NVZVLIUMGN\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"GG Blocco utente non attivo:\",\"w\":151,\"x\":9,\"y\":207,\"zone\":\"pag4_3_7\",\"zonepath\":\"[4,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Consenti Soggetti Senza Documento\",\"h\":21,\"label_text\":\"Consenti Import Soggetti Senza Documenti se attivo LightCheck\",\"maxlength\":1,\"name\":\"FLGLIGHT\",\"page\":4,\"spuid\":\"QMOTVZANBJ\",\"tabindex\":33,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":392,\"x\":160,\"y\":97,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_ROVOSMARIB\",\"page\":4,\"picker\":true,\"spuid\":\"ROVOSMARIB\",\"tabindex\":34,\"type\":\"Button\",\"value\":\"Caricamento Manuale\",\"w\":158,\"x\":656,\"y\":283,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ultima versione Manuale\",\"h\":20,\"maxlength\":250,\"name\":\"PATHSID\",\"page\":4,\"spuid\":\"EMDHDDRUPP\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":285,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PZUDQEMFCW\",\"page\":4,\"spuid\":\"PZUDQEMFCW\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Ultima versione Manuale:\",\"w\":152,\"x\":8,\"y\":289,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path Applicazione CGO\",\"h\":20,\"maxlength\":250,\"name\":\"PATHCERT\",\"page\":4,\"spuid\":\"WXRSSFBXYH\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":257,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QUNKJMETVO\",\"page\":4,\"spuid\":\"QUNKJMETVO\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Path Applicazione CGO:\",\"w\":152,\"x\":8,\"y\":261,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Cambio Password CGO\",\"h\":21,\"label_text\":\"Cambio Password CGO\",\"maxlength\":1,\"name\":\"FLGCGOPWD\",\"page\":4,\"spuid\":\"VJPULIZVKG\",\"tabindex\":36,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":600,\"y\":70,\"zone\":\"pag4_3_10\",\"zonepath\":\"[4,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path FTP per Import\",\"h\":20,\"maxlength\":128,\"name\":\"PATHFTP\",\"page\":4,\"spuid\":\"WPPFTLWEWX\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":313,\"zone\":\"pag4_3_11\",\"zonepath\":\"[4,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WNJNVATEHJ\",\"page\":4,\"spuid\":\"WNJNVATEHJ\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Path FTP per Import:\",\"w\":152,\"x\":8,\"y\":317,\"zone\":\"pag4_3_11\",\"zonepath\":\"[4,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Crea Utente alla creazione dell"+"'"+"agenzia\",\"h\":21,\"label_text\":\"Crea Utente alla creazione dell"+"'"+"agenzia\",\"maxlength\":1,\"name\":\"FLGUTEAGE\",\"page\":4,\"spuid\":\"KZJBLRRDWP\",\"tabindex\":45,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":248,\"x\":160,\"y\":151,\"zone\":\"pag4_3_12\",\"zonepath\":\"[4,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Email Destinatario SOS\",\"h\":20,\"maxlength\":250,\"name\":\"PRGAEPATH\",\"page\":4,\"spuid\":\"PUWCGJFLDF\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":343,\"zone\":\"pag4_3_13\",\"zonepath\":\"[4,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YGXQBBEZFG\",\"page\":4,\"spuid\":\"YGXQBBEZFG\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Email Destinatario SOS:\",\"w\":152,\"x\":8,\"y\":347,\"zone\":\"pag4_3_13\",\"zonepath\":\"[4,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"GG  Provvisorio\\/Definitivo\",\"h\":20,\"maxlength\":4,\"name\":\"NUMGIORN\",\"page\":4,\"spuid\":\"NVZYOQAKDU\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":600,\"y\":152,\"zone\":\"pag4_3_14\",\"zonepath\":\"[4,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RBGWMMIZHB\",\"page\":4,\"spuid\":\"RBGWMMIZHB\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"GG  Provvisorio\\/Definitivo:\",\"w\":224,\"x\":376,\"y\":156,\"zone\":\"pag4_3_14\",\"zonepath\":\"[4,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Attiva Gestione OTP\",\"h\":21,\"label_text\":\"Attivazione Gestione OTP\",\"maxlength\":1,\"name\":\"FLGCGOOTP\",\"page\":4,\"spuid\":\"MHHQTFPDEN\",\"tabindex\":50,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":600,\"y\":175,\"zone\":\"pag4_3_15\",\"zonepath\":\"[4,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Attiva QADV\",\"h\":21,\"label_text\":\"Attiva Questionario Adeguata Verifica\",\"maxlength\":1,\"name\":\"FLGCGOQADV\",\"page\":4,\"spuid\":\"SSXDYZLCUX\",\"tabindex\":51,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":368,\"x\":160,\"y\":174,\"zone\":\"pag4_3_15\",\"zonepath\":\"[4,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag Richiesta Professione\",\"h\":21,\"label_text\":\"Richiesta Professione\",\"maxlength\":1,\"name\":\"CGOFLGPROF\",\"page\":4,\"spuid\":\"ABGLJLFEYQ\",\"tabindex\":54,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":600,\"y\":202,\"zone\":\"pag4_3_16\",\"zonepath\":\"[4,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Controlla scadenza documento in import\",\"h\":21,\"label_text\":\"Controlla scadenza documento in import\",\"maxlength\":1,\"name\":\"FLGNODOC\",\"page\":4,\"spuid\":\"MRWHAAPELH\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":232,\"x\":600,\"y\":126,\"zone\":\"pag4_4\",\"zonepath\":\"[4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"CGOEmail\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Parametri Per EMAIL Alert\",\"h\":89,\"name\":\"CGOEmail\",\"page\":5,\"shrinkable\":true,\"spuid\":\"AMSHYBLKWR\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Parametri Per EMAIL Alert\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":7,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Server Invio Posta\",\"h\":20,\"maxlength\":50,\"name\":\"ALTSRVMAIL\",\"page\":5,\"spuid\":\"MLYQUOWFHN\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":12,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EWRSHYJVWC\",\"page\":5,\"spuid\":\"EWRSHYJVWC\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Server Invio Posta:\",\"w\":112,\"x\":16,\"y\":16,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Porta\",\"h\":20,\"maxlength\":5,\"name\":\"ALTPRTMAIL\",\"page\":5,\"spuid\":\"VRYHAZPGSR\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":520,\"y\":12,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRWHWQWWJO\",\"page\":5,\"spuid\":\"KRWHWQWWJO\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Porta:\",\"w\":80,\"x\":440,\"y\":16,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mail Invio\",\"h\":20,\"maxlength\":50,\"name\":\"ALTEMLMAIL\",\"page\":5,\"spuid\":\"TYOXRXGXKJ\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":40,\"zone\":\"pag5_1_2\",\"zonepath\":\"[5,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NFXFLOJWRM\",\"page\":5,\"spuid\":\"NFXFLOJWRM\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Mail Invio:\",\"w\":120,\"x\":8,\"y\":44,\"zone\":\"pag5_1_2\",\"zonepath\":\"[5,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Utente Invio\",\"h\":20,\"maxlength\":50,\"name\":\"ALTUSRMAIL\",\"page\":5,\"spuid\":\"OKEJPCYNVH\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":128,\"y\":68,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ROHUJGYBZU\",\"page\":5,\"spuid\":\"ROHUJGYBZU\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Utente Posta:\",\"w\":112,\"x\":16,\"y\":72,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password\",\"h\":20,\"maxlength\":30,\"name\":\"ALTPWDMAIL\",\"page\":5,\"spuid\":\"IIVBDSFKCC\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":520,\"y\":68,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XWBWYCDSUH\",\"page\":5,\"spuid\":\"XWBWYCDSUH\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Password:\",\"w\":72,\"x\":448,\"y\":72,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"GesDOC\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Gestione Documentale\",\"h\":315,\"name\":\"GesDOC\",\"page\":5,\"shrinkable\":true,\"spuid\":\"KNXWNOJPJB\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Gestione Documentale\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":98,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Gestione Documentale\",\"h\":21,\"label_text\":\"Gestione Documentale Esterna\",\"maxlength\":1,\"name\":\"FLGGESDOC\",\"page\":5,\"spuid\":\"FYAHSLEGLP\",\"tabindex\":13,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":262,\"x\":42,\"y\":102,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Blocco Operazioni Senza Documenti\",\"h\":20,\"maxlength\":10,\"name\":\"DATADOC\",\"page\":5,\"picker\":true,\"spuid\":\"VOONRSAKSU\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":520,\"y\":103,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MKAXCAIGIN\",\"page\":5,\"spuid\":\"MKAXCAIGIN\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Data Blocco Operazioni Senza Documenti:\",\"w\":218,\"x\":302,\"y\":107,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_DJJPJVNREQ\",\"page\":5,\"picker\":true,\"spuid\":\"DJJPJVNREQ\",\"tabindex\":25,\"type\":\"Button\",\"value\":\"Blocco Documenti\",\"w\":165,\"x\":624,\"y\":103,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Utente Ges. Doc.\",\"h\":20,\"maxlength\":30,\"name\":\"USRGESDOC\",\"page\":5,\"spuid\":\"MUANKUGIIK\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":128,\"y\":131,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QPIEEELYAP\",\"page\":5,\"spuid\":\"QPIEEELYAP\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Utente Ges. Doc.:\",\"w\":120,\"x\":8,\"y\":135,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password Ges. Doc.\",\"h\":20,\"maxlength\":30,\"name\":\"PWDGESDOC\",\"page\":5,\"spuid\":\"HFVZAFILCA\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":520,\"y\":131,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GGIEQBUUGN\",\"page\":5,\"spuid\":\"GGIEQBUUGN\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Password Ges. Doc.:\",\"w\":168,\"x\":352,\"y\":135,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"URL Ges. Doc.\",\"h\":20,\"maxlength\":80,\"name\":\"URLDESDOC\",\"page\":5,\"spuid\":\"RNIWEERJDP\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":584,\"x\":128,\"y\":159,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ARQZPHKUOK\",\"page\":5,\"spuid\":\"ARQZPHKUOK\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"URL Ges. Doc.:\",\"w\":120,\"x\":8,\"y\":163,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"EMail Comunicazioni\",\"h\":20,\"maxlength\":80,\"name\":\"EMAILDOC\",\"page\":5,\"spuid\":\"LZEBZLGWCH\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":584,\"x\":128,\"y\":187,\"zone\":\"pag5_2_4\",\"zonepath\":\"[5,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXBFOUJXZL\",\"page\":5,\"spuid\":\"YXBFOUJXZL\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"EMail Comunicazioni:\",\"w\":120,\"x\":8,\"y\":191,\"zone\":\"pag5_2_4\",\"zonepath\":\"[5,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":183,\"name\":\"ardt_cgo_tipall\",\"page\":5,\"spuid\":\"TOSEVHXRVF\",\"tabindex\":21,\"type\":\"Iframe\",\"w\":488,\"x\":16,\"y\":217,\"zone\":\"pag5_2_5\",\"zonepath\":\"[5,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":176,\"name\":\"ardt_cgo_subnets\",\"page\":5,\"spuid\":\"KDWFCOUSQZ\",\"tabindex\":26,\"type\":\"Iframe\",\"w\":192,\"x\":600,\"y\":217,\"zone\":\"pag5_2_6\",\"zonepath\":\"[5,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EOMKPJOLGE\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Path Documenti Bacheca\",\"h\":49,\"name\":\"box_EOMKPJOLGE\",\"page\":5,\"shrinkable\":true,\"spuid\":\"EOMKPJOLGE\",\"stretch\":true,\"tabindex\":27,\"title_caption\":\"Path Documenti Bacheca\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":420,\"zone\":\"pag5_3\",\"zonepath\":\"[5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path Documenti Bacheca\",\"h\":20,\"maxlength\":128,\"name\":\"PATHDOCBAC\",\"page\":5,\"spuid\":\"MRRDOEHYLX\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":672,\"x\":144,\"y\":434,\"zone\":\"pag5_3_1\",\"zonepath\":\"[5,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SPTLVDHKHB\",\"page\":5,\"spuid\":\"SPTLVDHKHB\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Path Documenti Bacheca:\",\"w\":144,\"x\":0,\"y\":438,\"zone\":\"pag5_3_1\",\"zonepath\":\"[5,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"E-Learning\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"E-Learning\",\"h\":49,\"name\":\"E-Learning\",\"page\":5,\"shrinkable\":true,\"spuid\":\"MFFCPIVYZD\",\"stretch\":true,\"tabindex\":31,\"title_caption\":\"E-Learning\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":476,\"zone\":\"pag5_4\",\"zonepath\":\"[5,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"URL Sito E-Learning\",\"h\":20,\"maxlength\":240,\"name\":\"IMPPATH\",\"page\":5,\"spuid\":\"ABFCWFBDMW\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":672,\"x\":144,\"y\":490,\"zone\":\"pag5_4_1\",\"zonepath\":\"[5,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SNAQIGBZKF\",\"page\":5,\"spuid\":\"SNAQIGBZKF\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"URL Sito E-Learning:\",\"w\":136,\"x\":8,\"y\":494,\"zone\":\"pag5_4_1\",\"zonepath\":\"[5,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Multiple\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Default Multiple\",\"h\":49,\"name\":\"Multiple\",\"page\":5,\"shrinkable\":true,\"spuid\":\"UYDQCWOOEO\",\"stretch\":true,\"tabindex\":34,\"title_caption\":\"Default Multiple\",\"titled\":true,\"type\":\"Box\",\"w\":816,\"x\":8,\"y\":532,\"zone\":\"pag5_5\",\"zonepath\":\"[5,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Gioco Default Multiple\",\"h\":20,\"maxlength\":3,\"name\":\"CGOTGDEFMUL\",\"page\":5,\"spuid\":\"GORKFABVFF\",\"tabindex\":33,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":336,\"x\":144,\"y\":546,\"zone\":\"pag5_5_1\",\"zonepath\":\"[5,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JXWDSHKCJJ\",\"page\":5,\"spuid\":\"JXWDSHKCJJ\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":128,\"x\":16,\"y\":550,\"zone\":\"pag5_5_1\",\"zonepath\":\"[5,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ExtSO\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Estrazione Scarico Offline\",\"h\":126,\"name\":\"ExtSO\",\"page\":6,\"shrinkable\":true,\"spuid\":\"QSIBTTRMLJ\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Estrazione Scarico Offline\",\"titled\":true,\"type\":\"Box\",\"w\":1000,\"x\":8,\"y\":7,\"zone\":\"pag6_1\",\"zonepath\":\"[6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Mesi da estrarre\",\"h\":20,\"maxlength\":3,\"name\":\"SONUMMESI\",\"page\":6,\"spuid\":\"HAPCMCIYJW\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":32,\"x\":200,\"y\":21,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OTANLZAUMP\",\"page\":6,\"spuid\":\"OTANLZAUMP\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Numero Mesi da estrarre:\",\"w\":168,\"x\":32,\"y\":25,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero mesi indietro\",\"h\":20,\"maxlength\":3,\"name\":\"SOMESIBACK\",\"page\":6,\"spuid\":\"OAAOYRQPRR\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":32,\"x\":512,\"y\":21,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IQSWXNMJHD\",\"page\":6,\"spuid\":\"IQSWXNMJHD\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Numero mesi indietro:\",\"w\":152,\"x\":360,\"y\":25,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Comando Shell da Eseguire al termine\",\"h\":70,\"name\":\"SOSHELLCMD\",\"page\":6,\"scroll\":true,\"spuid\":\"IDOPVICMXL\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":672,\"x\":144,\"y\":49,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":42,\"name\":\"label_JUWTXZPQPP\",\"page\":6,\"spuid\":\"JUWTXZPQPP\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Comando Shell da \\nEseguire al termine:\",\"w\":128,\"x\":16,\"y\":49,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ambiente Esecuzione Comando Shell\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOAMBIENTE\",\"page\":6,\"spuid\":\"ATYYTAXDZW\",\"tabindex\":8,\"textlist\":\"Linux,Windows\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"W"+"'"+"\",\"w\":144,\"x\":848,\"y\":21,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RQTPKYOXZT\",\"page\":6,\"spuid\":\"RQTPKYOXZT\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Ambiente Esecuzione Comando Shell:\",\"w\":240,\"x\":600,\"y\":25,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DestEmail\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Destinatari Email 380 Schedulato\",\"h\":189,\"name\":\"DestEmail\",\"page\":6,\"shrinkable\":true,\"spuid\":\"YAITYOPUEH\",\"stretch\":true,\"tabindex\":10,\"title_caption\":\"Destinatari Email 380 Schedulato\",\"titled\":true,\"type\":\"Box\",\"w\":1000,\"x\":8,\"y\":140,\"zone\":\"pag6_2\",\"zonepath\":\"[6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":163,\"name\":\"ardt_destemail\",\"page\":6,\"spuid\":\"JWJORCKLGL\",\"tabindex\":11,\"type\":\"Iframe\",\"w\":969,\"x\":16,\"y\":154,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ImportVLT\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Parametri per import VLT\",\"h\":133,\"name\":\"ImportVLT\",\"page\":6,\"shrinkable\":true,\"spuid\":\"MKILJOCTZW\",\"stretch\":true,\"tabindex\":14,\"title_caption\":\"Parametri per import VLT\",\"titled\":true,\"type\":\"Box\",\"w\":1000,\"x\":8,\"y\":336,\"zone\":\"pag6_3\",\"zonepath\":\"[6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path file di import\",\"h\":77,\"name\":\"SOPATHIMPORT\",\"page\":6,\"scroll\":true,\"spuid\":\"GHUASLAKBC\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":672,\"x\":144,\"y\":350,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MDAFYIMKHP\",\"page\":6,\"spuid\":\"MDAFYIMKHP\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Path file di import:\",\"w\":120,\"x\":24,\"y\":350,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ora Max import VLT\",\"h\":20,\"maxlength\":3,\"name\":\"SOORAIMPORT\",\"page\":6,\"spuid\":\"APTIWOKBUI\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":144,\"y\":434,\"zone\":\"pag6_3_2\",\"zonepath\":\"[6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZWDTCOUNPV\",\"page\":6,\"spuid\":\"ZWDTCOUNPV\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Ora Max import VLT:\",\"w\":128,\"x\":16,\"y\":438,\"zone\":\"pag6_3_2\",\"zonepath\":\"[6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Soglia Alert QADV\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_SOGLIA\",\"page\":6,\"spuid\":\"HRSWOWLUUE\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":36,\"x\":780,\"y\":434,\"zone\":\"pag6_3_3\",\"zonepath\":\"[6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AUWHLLTNOH\",\"page\":6,\"spuid\":\"AUWHLLTNOH\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Soglia Alert QADV:\",\"w\":156,\"x\":624,\"y\":438,\"zone\":\"pag6_3_3\",\"zonepath\":\"[6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_intermboBO BO,ServletStatus status) {
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
     "<script src='armt_intermbo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_intermbo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_intermbo_edit.js'>" +
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
      status.out.println("w_TIPINTER=a[0];");
      status.out.println("w_RAGSOC=a[1];");
      status.out.println("w_DESCCIT=a[2];");
      status.out.println("w_PROVINCIA=a[3];");
      status.out.println("w_CAP=a[4];");
      status.out.println("w_CODCAB=a[5];");
      status.out.println("w_DOMICILIO=a[6];");
      status.out.println("w_PAESE=a[7];");
      status.out.println("w_CODFISC=a[8];");
      status.out.println("w_PARTIVA=a[9];");
      status.out.println("w_DATANASC=a[10];");
      status.out.println("w_SOTGRUP=a[11];");
      status.out.println("w_RAMOGRUP=a[12];");
      status.out.println("w_SETTSINT=a[13];");
      status.out.println("w_TIPODOC=a[14];");
      status.out.println("w_SESSO=a[15];");
      status.out.println("w_NUMDOCUM=a[16];");
      status.out.println("w_DATARILASC=a[17];");
      status.out.println("w_AUTRILASC=a[18];");
      status.out.println("w_CODDIPE=a[19];");
      status.out.println("w_CONNES=a[20];");
      status.out.println("w_NOTE=a[21];");
      status.out.println("w_CODORO=a[22];");
      status.out.println("w_CODINTER=a[23];");
      status.out.println("w_TIPOPERS=a[24];");
      status.out.println("w_IDCITTA=a[25];");
      status.out.println("w_DATAVALI=a[26];");
      status.out.println("w_CONTATORE=a[27];");
      status.out.println("w_CFINVIO=a[28];");
      status.out.println("w_CAFINVIO=a[29];");
      status.out.println("w_FILEINVIO=a[30];");
      status.out.println("w_URLAPPL=a[31];");
      status.out.println("w_FLGLOG=a[32];");
      status.out.println("w_FLGAOS=a[33];");
      status.out.println("w_FLGEAOS=a[34];");
      status.out.println("w_FLGCDOC=a[35];");
      status.out.println("w_FLGFRAZ=a[36];");
      status.out.println("w_FLGAPERS=a[37];");
      status.out.println("w_DTINIATT=a[38];");
      status.out.println("w_FLGTIPIMP=a[39];");
      status.out.println("w_FLGSTPCON=a[40];");
      status.out.println("w_FLGIMPAGE=a[41];");
      status.out.println("w_FLGWU=a[42];");
      status.out.println("w_DATAINVIO=a[43];");
      status.out.println("w_IMPINTOPE=a[44];");
      status.out.println("w_FLGOPEXTR=a[45];");
      status.out.println("w_FLGRAPCLI=a[46];");
      status.out.println("w_FLGDATAIM=a[47];");
      status.out.println("w_FLGDATATP=a[48];");
      status.out.println("w_NOCODFISC=a[49];");
      status.out.println("w_FLGCHK=a[50];");
      status.out.println("w_CODAGE=a[51];");
      status.out.println("w_IDSID=a[52];");
      status.out.println("w_SIDPASS=a[53];");
      status.out.println("w_PATHJAVA=a[54];");
      status.out.println("w_TIPOINST=a[55];");
      status.out.println("w_FLGSIDAUTO=a[56];");
      status.out.println("w_SOSPMAF=a[57];");
      status.out.println("w_FLGRITORNO=a[58];");
      status.out.println("w_FLGCREAAGE=a[59];");
      status.out.println("w_DTTITAGE=a[60];");
      status.out.println("w_SCADSALDI=a[61];");
      status.out.println("w_FLGIPMT=a[62];");
      status.out.println("w_LIMITEFRZ=a[63];");
      status.out.println("w_DBPROT=a[64];");
      status.out.println("w_OAMTPDOC=a[65];");
      status.out.println("w_DAYSIMPORT=a[66];");
      status.out.println("w_DAYSIMPCMB=a[67];");
      status.out.println("w_TIPOSV=a[68];");
      status.out.println("w_FLGAWUPOS=a[69];");
      status.out.println("w_WUGIOSCA=a[70];");
      status.out.println("w_WUGGALERT=a[71];");
      status.out.println("w_SKT_SERVER=a[72];");
      status.out.println("w_SKT_PORT=a[73];");
      status.out.println("w_SKT_PATHS=a[74];");
      status.out.println("w_SKT_MODET=a[75];");
      status.out.println("w_RASPAUI=a[76];");
      status.out.println("w_RESPAUI=a[77];");
      status.out.println("w_TESTIP=a[78];");
      status.out.println("w_MINFRZSNAI=a[79];");
      status.out.println("w_FLGSCDFRZ=a[80];");
      status.out.println("w_GIORNIFRZ=a[81];");
      status.out.println("w_LIMITVLT=a[82];");
      status.out.println("w_LIMITVNP=a[83];");
      status.out.println("w_FLGSTPDIR=a[84];");
      status.out.println("w_FLGNODOC=a[85];");
      status.out.println("w_SNAISTOR=a[86];");
      status.out.println("w_FRAZDEL=a[87];");
      status.out.println("w_PATHAPP=a[88];");
      status.out.println("w_FLGDDOC=a[89];");
      status.out.println("w_FLGLIGHT=a[90];");
      status.out.println("w_FLGCGOPWD=a[91];");
      status.out.println("w_PATHSID=a[92];");
      status.out.println("w_PATHCERT=a[93];");
      status.out.println("w_PATHFTP=a[94];");
      status.out.println("w_FLGUTEAGE=a[95];");
      status.out.println("w_PRGAEPATH=a[96];");
      status.out.println("w_NUMGIORN=a[97];");
      status.out.println("w_COGNOME=a[98];");
      status.out.println("w_NOME=a[99];");
      status.out.println("w_DNASC=a[100];");
      status.out.println("w_CITTADINA=a[101];");
      status.out.println("w_NASCOMUN=a[102];");
      status.out.println("w_NASSTATO=a[103];");
      status.out.println("w_PRNASC=a[104];");
      status.out.println("w_SOGCOM=a[105];");
      status.out.println("w_ALTSRVMAIL=a[106];");
      status.out.println("w_ALTPRTMAIL=a[107];");
      status.out.println("w_ALTEMLMAIL=a[108];");
      status.out.println("w_ALTUSRMAIL=a[109];");
      status.out.println("w_ALTPWDMAIL=a[110];");
      status.out.println("w_FLGGESDOC=a[111];");
      status.out.println("w_USRGESDOC=a[112];");
      status.out.println("w_PWDGESDOC=a[113];");
      status.out.println("w_URLDESDOC=a[114];");
      status.out.println("w_EMAILDOC=a[115];");
      status.out.println("w_DATADOC=a[116];");
      status.out.println("w_PATHDOCBAC=a[117];");
      status.out.println("w_IMPPATH=a[118];");
      status.out.println("w_BPCODPAT=a[119];");
      status.out.println("w_BPENTSEG=a[120];");
      status.out.println("w_BPCOGSEG=a[121];");
      status.out.println("w_BPNOMSEG=a[122];");
      status.out.println("w_BPTELSEG=a[123];");
      status.out.println("w_BPEMLSEG=a[124];");
      status.out.println("w_RICEVUTE=a[125];");
      status.out.println("w_ABI=a[126];");
      status.out.println("w_CAB=a[127];");
      status.out.println("w_OGGI3I4=a[128];");
      status.out.println("w_CGOTGDEFMUL=a[129];");
      status.out.println("w_AUTOSARA=a[130];");
      status.out.println("w_GGWARNPRV=a[131];");
      status.out.println("w_GGWARNAUI=a[132];");
      status.out.println("w_SOGLIAMAX=a[133];");
      status.out.println("w_LIMITE20=a[134];");
      status.out.println("w_SONUMMESI=a[135];");
      status.out.println("w_SOMESIBACK=a[136];");
      status.out.println("w_SOSHELLCMD=a[137];");
      status.out.println("w_SOAMBIENTE=a[138];");
      status.out.println("w_SOPATHIMPORT=a[139];");
      status.out.println("w_SOORAIMPORT=a[140];");
      status.out.println("w_QADV_SOGLIA=a[141];");
      status.out.println("w_FLGCGOOTP=a[142];");
      status.out.println("w_FLGCGOQADV=a[143];");
      status.out.println("w_ITFLGPEP=a[144];");
      status.out.println("w_ITPWDPEP=a[145];");
      status.out.println("w_ITUSRPEP=a[146];");
      status.out.println("w_BLOCCOUSER=a[147];");
      status.out.println("w_CGOFLGPROF=a[148];");
      status.out.println("w_FLGAGGFAM=a[149];;");
      status.out.println("w_ALTSSLEMAIL=a[150];");
      status.out.println("w_PATHIMPORT=a[151];");
      status.out.println("w_DESTEMAIL=a[152];");
      status.out.println("w_CODVASP=a[153];");
      status.out.println("w_IDOAM=a[154];");
      status.out.println("w_IDOAMR=a[155];");
      status.out.println("w_ART1=a[156];");
      status.out.println("w_DESCRIsta=a[157];");
      status.out.println("w_DESCSGRU=a[158];");
      status.out.println("w_DESCRAMGRU=a[159];");
      status.out.println("w_DESCUIC=a[160];");
      status.out.println("w_descdip=a[161];");
      status.out.println("w_tipsot=a[162];");
      status.out.println("w_xdescitdip=a[163];");
      status.out.println("w_xcabdip=a[164];");
      status.out.println("w_gUserCode=a[165];");
      status.out.println("w_ATTIV=a[166];");
      status.out.println("w_gUrlApp=a[167];");
      status.out.println("w_gAzienda=a[168];");
      status.out.println("w_PWDSER=a[169];");
      status.out.println("w_appocert=a[170];");
      status.out.println("w_pathmanuale=a[171];");
      status.out.println("w_xDESCAN=a[172];");
      status.out.println("o_CCPBATRTRJ_expand=null;");
      status.out.println("o_CCPBATRTRJ_collapse=null;");
      status.out.println("m_cWv_ardt_destwarn=a[173];");
      status.out.println("m_cWv_ardt_cgo_tipall=a[174];");
      status.out.println("m_cWv_ardt_cgo_subnets=a[175];");
      status.out.println("m_cWv_ardt_destemail=a[176];");
      status.out.println("if (Gt(a.length,177)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,177)) {");
      status.out.println("o_DESCCIT=w_DESCCIT;");
      status.out.println("o_SOTGRUP=w_SOTGRUP;");
      status.out.println("o_RAMOGRUP=w_RAMOGRUP;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CODINTER'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_intermbo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(662,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","intermbo");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CODINTER");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_intermboBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_intermboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_intermboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_intermboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_intermboBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CODINTER:"+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_intermboBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_intermboBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("arfn_upload_file_doc.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_azz_semaforo.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_creadir.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calcolasett.m_cEntityUid+"/arrt_calcolasett.js'>" +
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
      arrt_calcolasett.GetCallableNames(callable);
      arrt_cgo_blockope.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arfn_upload_file_doc");
      CPLib.AddToSet(callable,"arrt_azz_semaforo");
      CPLib.AddToSet(callable,"arrt_creadir");
      CPLib.AddToSet(callable,"ardt_destwarn");
      CPLib.AddToSet(callable,"ardt_cgo_tipall");
      CPLib.AddToSet(callable,"ardt_cgo_subnets");
      CPLib.AddToSet(callable,"ardt_destemail");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_intermboBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CODINTER),"C",11,0));
      }
      hCreator.AddValue(CPLib.ToSQL(BO.w_gUserCode,"N",4,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gUrlApp),"C",80,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gAzienda),"C",10,0));
    } else if (CPLib.eq(p_cUID,"JXOBOAXKRQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JCGROGAZTR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IIXRREUEAM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LLYIGAMXRH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RVNHQCXNEM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZGNLLSFQHC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AYYXYNLAUC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PSZTLCSMPB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PZGXGIZQWY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DUROREWBNG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZTUIXEONYI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_intermboBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_TIPINTER))) {
        a = GetCheckVars(status,BO,"JXOBOAXKRQ");
        b = status.m_CheckVars.optString("JXOBOAXKRQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PAESE))) {
        a = GetCheckVars(status,BO,"IIXRREUEAM");
        b = status.m_CheckVars.optString("IIXRREUEAM");
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
      if (result &&  ! (CPLib.Empty(BO.w_TIPODOC))) {
        a = GetCheckVars(status,BO,"AYYXYNLAUC");
        b = status.m_CheckVars.optString("AYYXYNLAUC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"PSZTLCSMPB");
        b = status.m_CheckVars.optString("PSZTLCSMPB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_NASCOMUN))) {
        a = GetCheckVars(status,BO,"DUROREWBNG");
        b = status.m_CheckVars.optString("DUROREWBNG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_NASSTATO))) {
        a = GetCheckVars(status,BO,"ZTUIXEONYI");
        b = status.m_CheckVars.optString("ZTUIXEONYI");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
