import java.util.*;

public class armt_snai_operBL extends armt_snai_operWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  // Variabile che mantiene il vecchio timestamp
  public String m_cOldCPCCCHK;
  public java.util.List<String> m_oParameters;
  protected String m_cPassword;
  protected String m_cOTP;
  //  Variabile che indica il tipo dell'ultimo
  //  errore, o messaggio da comunicare all'interfaccia,
  //  che si è verificato impostando una variabile di work.
  //  I valori ammessi sono:
  //  - 1     : errore di campo obbligatorio
  //  - 2     : errore di check
  //  - 3     : valore non ammesso nel link
  //  - 4     : richiesta password
  //  - 5     : richiesto otp
  public int m_nLastError;
  public String m_cLastMsgError;
  public String m_cLastWorkVarError;
  // m_bCalculating==true la Calculate e' in esecuzione
  public boolean m_bCalculating = false;
  public static final String i_EntityName = "armt_snai_oper";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public CPPhTableWrInfo m_oWrInfo_cgo_operazioni;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_operazioni;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_cgo_causali;
  public String m_cServer_cgo_causali;
  public CPPhTableWrInfo m_oWrInfo_cgo_causali;
  public String m_cPhName_cgo_esiticon;
  public String m_cServer_cgo_esiticon;
  public CPPhTableWrInfo m_oWrInfo_cgo_esiticon;
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public CPPhTableWrInfo m_oWrInfo_cgo_tbtipgio;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public CPPhTableWrInfo m_oWrInfo_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public CPPhTableWrInfo m_oWrInfo_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public CPPhTableWrInfo m_oWrInfo_tbcausin;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public CPPhTableWrInfo m_oWrInfo_tbramgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public CPPhTableWrInfo m_oWrInfo_tbsetsin;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public CPPhTableWrInfo m_oWrInfo_tbstgru;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public CPPhTableWrInfo m_oWrInfo_tbtipreg;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  public String m_cPhName_cgo_autorita;
  public String m_cServer_cgo_autorita;
  public CPPhTableWrInfo m_oWrInfo_cgo_autorita;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
  public CPPhTableWrInfo m_oWrInfo_cgo_tipdoc;
  public String m_cPhName_cgo_vltplat;
  public String m_cServer_cgo_vltplat;
  public CPPhTableWrInfo m_oWrInfo_cgo_vltplat;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_operazioni"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TOTCONT':TOTCONT,'IMPWALLET':IMPWALLET,'CODWALLET':CODWALLET,'CODTRANSZ':CODTRANSZ,'CGOFLGVLT':CGOFLGVLT,'MEZPAGAM':MEZPAGAM,'FLGPAGAM':FLGPAGAM,'FILTROMP':FILTROMP,'CC4CIFRE':CC4CIFRE,'CCMESSCA':CCMESSCA,'CCANNSCA':CCANNSCA,'IBAN':IBAN,'ASSEGNO':ASSEGNO,'CFESTERO':CFESTERO,'PEP':PEP,'CODFISC':CODFISC,'COGNOME':COGNOME,'NOME':NOME,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'SESSO':SESSO,'NASSTATO':NASSTATO,'DATANASC':DATANASC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'DOMICILIO':DOMICILIO,'NUMTEL':NUMTEL,'SNAINUMOPE':SNAINUMOPE,'FLAGCONT':FLAGCONT,'FLAGWALLET':FLAGWALLET,'CONNESCLI':CONNESCLI,'CAIDBIGLIETTO':CAIDBIGLIETTO,'verifica':verifica,'NUMOPEDL':NUMOPEDL,'FLGDOCALL':FLGDOCALL,'DOC03':DOC03,'DOC04':DOC04,'tipop':tipop,'saveddoc':saveddoc,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'RDCODAUT':RDCODAUT,'RDLOCAUT':RDLOCAUT,'PEPDESCRI':PEPDESCRI,'PAESE2':PAESE2,'DESCCIT2':DESCCIT2,'PROVINCIA2':PROVINCIA2,'CAP2':CAP2,'DOMICILIO2':DOMICILIO2,'FLGDOM':FLGDOM,'FLGQADVFULL':FLGQADVFULL,'PROFESSIONE':PROFESSIONE,'CODDIPE':CODDIPE,'ANA_FOUND':ANA_FOUND,'CGONOTCON':CGONOTCON,'armt_cgo_qadv_operazioni':armt_cgo_qadv_operazioni"+FoundlingChildrenList("armt_snai_oper",true)+"}";
  public static final String i_CompleteStateStructure = "{'gIntemediario':gIntemediario,'TIPOGIOCO':TIPOGIOCO,'xSOGTPGIO':xSOGTPGIO,'xDEFTPGIO':xDEFTPGIO,'xEDTTPGIO':xEDTTPGIO,'xEDTSPGIO':xEDTSPGIO,'xDEFSPGIO':xDEFSPGIO,'TIPOPERS':TIPOPERS,'CGOFLGVNP':CGOFLGVNP,'TOTLIRE':TOTLIRE,'TOTCONT':TOTCONT,'IMPWALLET':IMPWALLET,'CODWALLET':CODWALLET,'CODTRANSZ':CODTRANSZ,'CGOFLGVLT':CGOFLGVLT,'MEZPAGAM':MEZPAGAM,'FLGPAGAM':FLGPAGAM,'FILTROMP':FILTROMP,'CC4CIFRE':CC4CIFRE,'CCMESSCA':CCMESSCA,'CCANNSCA':CCANNSCA,'IBAN':IBAN,'ASSEGNO':ASSEGNO,'CFESTERO':CFESTERO,'PEP':PEP,'CODFISC':CODFISC,'COGNOME':COGNOME,'NOME':NOME,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'SESSO':SESSO,'NASSTATO':NASSTATO,'DATANASC':DATANASC,'PAESE':PAESE,'RAGSOC':RAGSOC,'DESCCIT':DESCCIT,'idcitta':idcitta,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'NUMTEL':NUMTEL,'xARDESCRI':xARDESCRI,'ATTIV':ATTIV,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'SETTSINT':SETTSINT,'dessta':dessta,'tipsot':tipsot,'STATOREG':STATOREG,'IDBASE':IDBASE,'NUMPROG':NUMPROG,'DESCRI':DESCRI,'gSeekAos':gSeekAos,'gDataVaria':gDataVaria,'gFlgDoc':gFlgDoc,'SNAINUMOPE':SNAINUMOPE,'DATAOPE':DATAOPE,'DATAREG':DATAREG,'FLAGCONT':FLAGCONT,'FLAGWALLET':FLAGWALLET,'TIPOOPRAP':TIPOOPRAP,'CODANA':CODANA,'CODVOC':CODVOC,'VALUTA':VALUTA,'CAMBIO':CAMBIO,'CONNESCLI':CONNESCLI,'CONNESBEN':CONNESBEN,'C_RAG':C_RAG,'C_CTA':C_CTA,'C_PRV':C_PRV,'C_CAP':C_CAP,'C_CAB':C_CAB,'C_IND':C_IND,'C_STA':C_STA,'CODINTER':CODINTER,'SEGNO':SEGNO,'FLAGFRAZ':FLAGFRAZ,'COLLEG':COLLEG,'xDescDipe':xDescDipe,'datpaseuro':datpaseuro,'xdes1':xdes1,'desccauana':desccauana,'CITINT':CITINT,'CITDIP':CITDIP,'PROVDIP':PROVDIP,'CABDIP':CABDIP,'PROVINT':PROVINT,'CABINT':CABINT,'xdesccausin':xdesccausin,'gChkDate':gChkDate,'CACODICE':CACODICE,'CAIDBIGLIETTO':CAIDBIGLIETTO,'xdesctipatt':xdesctipatt,'gVLT':gVLT,'gVNP':gVNP,'CGOTIPOPE':CGOTIPOPE,'gCodDip':gCodDip,'verifica':verifica,'NUMOPEDL':NUMOPEDL,'gStpDwn':gStpDwn,'MIDBIGLIETTO':MIDBIGLIETTO,'MIDBIGLIETTO1':MIDBIGLIETTO1,'MIDBIGLIETTO2':MIDBIGLIETTO2,'MIDBIGLIETTO3':MIDBIGLIETTO3,'MIDBIGLIETTO4':MIDBIGLIETTO4,'CAFLGOPE':CAFLGOPE,'TELDIP':TELDIP,'CODLOC':CODLOC,'xFLGPLGIO':xFLGPLGIO,'IDDOCALL':IDDOCALL,'FLGDOCALL':FLGDOCALL,'VLTPLAT':VLTPLAT,'xVPFLGATT':xVPFLGATT,'DOC03':DOC03,'DOC04':DOC04,'tipop':tipop,'CCDATSCA':CCDATSCA,'gGesDoc':gGesDoc,'edtdoc':edtdoc,'saveddoc':saveddoc,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'RDCODAUT':RDCODAUT,'RDLOCAUT':RDLOCAUT,'AUTRILASC':AUTRILASC,'PEPDESCRI':PEPDESCRI,'PAESE2':PAESE2,'DESCCIT2':DESCCIT2,'idcitta2':idcitta2,'PROVINCIA2':PROVINCIA2,'CAP2':CAP2,'DOMICILIO2':DOMICILIO2,'FLGDOM':FLGDOM,'dessta2':dessta2,'FLGQADVFULL':FLGQADVFULL,'gQADV':gQADV,'xCGOFLGPROF':xCGOFLGPROF,'PROFESSIONE':PROFESSIONE,'CODCABDIP':CODCABDIP,'PROVINCIADIP':PROVINCIADIP,'DESCCITDIP':DESCCITDIP,'CODDIPE':CODDIPE,'ANA_FOUND':ANA_FOUND,'CGODATCON':CGODATCON,'CGOESICON':CGOESICON,'CGONOTCON':CGONOTCON,'armt_cgo_qadv_operazioni':armt_cgo_qadv_operazioni"+FoundlingChildrenList("armt_snai_oper",true)+"}";
  public static final String i_ItemSequence = "TOTCONT,IMPWALLET,CODWALLET,CODTRANSZ,CGOFLGVLT,MEZPAGAM,FLGPAGAM,FILTROMP,CC4CIFRE,CCMESSCA,CCANNSCA,IBAN,ASSEGNO,CFESTERO,PEP,CODFISC,COGNOME,NOME,NASCOMUN,TIPINTER,SESSO,NASSTATO,DATANASC,PAESE,DESCCIT,PROVINCIA,CAP,DOMICILIO,NUMTEL,SNAINUMOPE,FLAGCONT,FLAGWALLET,CONNESCLI,CAIDBIGLIETTO,verifica,NUMOPEDL,FLGDOCALL,DOC03,DOC04,tipop,saveddoc,TIPODOC,NUMDOCUM,DATARILASC,DATAVALI,RDCODAUT,RDLOCAUT,PEPDESCRI,PAESE2,DESCCIT2,PROVINCIA2,CAP2,DOMICILIO2,FLGDOM,FLGQADVFULL,PROFESSIONE,CODDIPE,ANA_FOUND,CGONOTCON,armt_cgo_qadv_operazioni"+FoundlingChildrenList("armt_snai_oper",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_snai_oper"),new String[][]{new String[]{"TOTCONT","di cui contanti","N","15","2","campo","nokey","false","true"},new String[]{"IMPWALLET","IMporto","N","12","2","campo","nokey","false","true"},new String[]{"CODWALLET","WALLET","C","20","0","campo","nokey","false","true"},new String[]{"CODTRANSZ","Transazione ID Wallet","C","50","0","campo","nokey","false","true"},new String[]{"CGOFLGVLT","Pagamento","C","1","0","campo","nokey","false","true"},new String[]{"MEZPAGAM","Mezzo Pagamento","C","1","0","campo","nokey","false","true"},new String[]{"FLGPAGAM","","C","1","0","variabile","nokey","false","false"},new String[]{"FILTROMP","","C","50","0","variabile","nokey","false","false"},new String[]{"CC4CIFRE","Ultime Cifre CC ()","C","4","0","campo","nokey","false","true"},new String[]{"CCMESSCA","Mese Scadenza","N","2","0","campo","nokey","false","true"},new String[]{"CCANNSCA","Carta Di Credito Scadenza","N","4","0","campo","nokey","false","true"},new String[]{"IBAN","IBAN per Bonifici","C","40","0","campo","nokey","false","true"},new String[]{"ASSEGNO","Assegno","C","25","0","campo","nokey","false","true"},new String[]{"CFESTERO","Codice Fiscale Estero","N","1","0","campo","nokey","false","false"},new String[]{"PEP","Persona Politicamente Esposta","C","1","0","campo","nokey","false","true"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","nokey","false","true"},new String[]{"COGNOME","Cognome","C","26","0","campo","nokey","false","true"},new String[]{"NOME","Nome","C","25","0","campo","nokey","false","true"},new String[]{"NASCOMUN","Luogo di Nascita","C","30","0","campo","nokey","false","true"},new String[]{"TIPINTER","Prov.","C","2","0","campo","nokey","false","true"},new String[]{"SESSO","Sesso","C","1","0","campo","nokey","false","true"},new String[]{"NASSTATO","Stato di nascita","C","30","0","campo","nokey","false","true"},new String[]{"DATANASC","Data Nascita","D","8","0","campo","nokey","false","true"},new String[]{"PAESE","Stato","C","3","0","campo","nokey","false","true"},new String[]{"DESCCIT","Città","C","40","0","campo","nokey","false","true"},new String[]{"PROVINCIA","Provincia","C","2","0","campo","nokey","false","true"},new String[]{"CAP","CAP","C","9","0","campo","nokey","false","true"},new String[]{"DOMICILIO","Indirizzo","C","35","0","campo","nokey","false","true"},new String[]{"NUMTEL","Numero Telefono","C","20","0","campo","nokey","false","false"},new String[]{"SNAINUMOPE","N° Operazione","C","15","0","campo","key1","false","false"},new String[]{"FLAGCONT","Contanti (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"FLAGWALLET","Flag Wallet","C","1","0","campo","nokey","false","true"},new String[]{"CONNESCLI","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"CAIDBIGLIETTO","ID BIGLIETTO","C","30","0","campo","nokey","false","false"},new String[]{"verifica","","C","1","0","variabile","nokey","false","false"},new String[]{"NUMOPEDL","Operazione da cancellare","C","15","0","campo","nokey","false","false"},new String[]{"FLGDOCALL","Flag Documentazione Completa","C","1","0","campo","nokey","false","false"},new String[]{"DOC03","","C","80","0","variabile","nokey","false","false"},new String[]{"DOC04","","C","80","0","variabile","nokey","false","false"},new String[]{"tipop","","C","1","0","variabile","nokey","false","false"},new String[]{"saveddoc","","C","1","0","variabile","nokey","false","false"},new String[]{"TIPODOC","Tipo Documento","C","2","0","campo","nokey","false","true"},new String[]{"NUMDOCUM","Numero Doc.","C","15","0","campo","nokey","false","true"},new String[]{"DATARILASC","Rilascio Doc.","D","8","0","campo","nokey","false","true"},new String[]{"DATAVALI","Data Fine Validità","D","8","0","campo","nokey","false","true"},new String[]{"RDCODAUT","Autorità Rilascio","C","2","0","campo","nokey","false","true"},new String[]{"RDLOCAUT","Luogo Autorità Rilascio","C","20","0","campo","nokey","false","true"},new String[]{"PEPDESCRI","Descrizione PEP","C","80","0","campo","nokey","false","true"},new String[]{"PAESE2","Stato Domicilio","C","3","0","campo","nokey","false","true"},new String[]{"DESCCIT2","Città Domicilio","C","40","0","campo","nokey","false","true"},new String[]{"PROVINCIA2","Provincia","C","2","0","campo","nokey","false","true"},new String[]{"CAP2","CAP","C","9","0","campo","nokey","false","true"},new String[]{"DOMICILIO2","Indirizzo Domicilio","C","35","0","campo","nokey","false","true"},new String[]{"FLGDOM","Domicilio diverso da residenza","C","1","0","campo","nokey","false","false"},new String[]{"FLGQADVFULL","","C","1","0","variabile","nokey","false","false"},new String[]{"PROFESSIONE","Professione","C","40","0","campo","nokey","false","true"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"ANA_FOUND","","C","1","0","variabile","nokey","false","false"},new String[]{"CGONOTCON","Note Contatto","M","10","0","campo","nokey","false","false"},new String[]{"armt_cgo_qadv_operazioni","LinkPC","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_snai_operBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_oWrInfo_cgo_operazioni = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_operazioni",p_ContextObject.GetCompany());
    m_cVirtName_cgo_operazioni = CPSql.ManipulateTablePhName("cgo_operazioni",m_cServer_cgo_operazioni);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali");
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
    m_oWrInfo_cgo_causali = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_causali",p_ContextObject.GetCompany());
    m_cPhName_cgo_esiticon = p_ContextObject.GetPhName("cgo_esiticon");
    m_cServer_cgo_esiticon = p_ContextObject.GetServer("cgo_esiticon");
    m_oWrInfo_cgo_esiticon = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_esiticon",p_ContextObject.GetCompany());
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_oWrInfo_cgo_tbtipgio = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tbtipgio",p_ContextObject.GetCompany());
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_oWrInfo_operazbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"operazbo",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_oWrInfo_tbcauana = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcauana",p_ContextObject.GetCompany());
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_oWrInfo_tbcausin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcausin",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_oWrInfo_tbramgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbramgru",p_ContextObject.GetCompany());
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_oWrInfo_tbsetsin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsetsin",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_oWrInfo_tbstgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstgru",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_oWrInfo_tbtipreg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipreg",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    m_cPhName_cgo_autorita = p_ContextObject.GetPhName("cgo_autorita");
    m_cServer_cgo_autorita = p_ContextObject.GetServer("cgo_autorita");
    m_oWrInfo_cgo_autorita = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_autorita",p_ContextObject.GetCompany());
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
    m_oWrInfo_cgo_tipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tipdoc",p_ContextObject.GetCompany());
    m_cPhName_cgo_vltplat = p_ContextObject.GetPhName("cgo_vltplat");
    m_cServer_cgo_vltplat = p_ContextObject.GetServer("cgo_vltplat");
    m_oWrInfo_cgo_vltplat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_vltplat",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    armt_cgo_qadv_operazioni = new armt_cgo_qadv_operazioniBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_snai_oper",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_TIPOGIOCO = "";
    w_xSOGTPGIO = 0;
    w_xDEFTPGIO = "";
    w_xEDTTPGIO = "";
    w_xEDTSPGIO = "";
    w_xDEFSPGIO = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_IMPWALLET = 0;
    w_CODWALLET = "";
    w_CODTRANSZ = "";
    w_MEZPAGAM = "";
    w_CC4CIFRE = "";
    w_CCMESSCA = 0;
    w_CCANNSCA = 0;
    w_IBAN = "";
    w_ASSEGNO = "";
    w_CODFISC = "";
    w_COGNOME = "";
    w_NOME = "";
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_SESSO = "";
    w_NASSTATO = "";
    w_DATANASC = CPLib.NullDate();
    w_PAESE = "";
    w_RAGSOC = "";
    w_DESCCIT = "";
    w_idcitta = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_NUMTEL = "";
    w_xARDESCRI = "";
    w_ATTIV = "";
    w_RAMOGRUP = "";
    w_dessta = "";
    w_tipsot = "";
    w_STATOREG = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_SNAINUMOPE = "";
    w_DATAOPE = CPLib.NullDate();
    w_DATAREG = CPLib.NullDate();
    w_CODANA = "";
    w_CODVOC = "";
    w_CONNESCLI = "";
    w_C_RAG = "";
    w_C_CTA = "";
    w_C_PRV = "";
    w_C_CAP = "";
    w_C_CAB = "";
    w_C_IND = "";
    w_C_STA = "";
    w_NUMPROG = "";
    w_SEGNO = "";
    w_COLLEG = "";
    w_xDescDipe = "";
    w_datpaseuro = CPLib.NullDate();
    w_xdes1 = "";
    w_desccauana = "";
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_CODVOC = "";
    w_xdesccausin = "";
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_CACODICE = 0;
    w_CAIDBIGLIETTO = "";
    w_xdesctipatt = "";
    w_gVLT = m_Ctx.GetGlobalNumber("gVLT");
    w_gVNP = m_Ctx.GetGlobalNumber("gVNP");
    w_CGOTIPOPE = "";
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_verifica = "";
    w_NUMOPEDL = "";
    w_gStpDwn = m_Ctx.GetGlobalString("gStpDwn");
    w_MIDBIGLIETTO = "";
    w_MIDBIGLIETTO1 = "";
    w_MIDBIGLIETTO2 = "";
    w_MIDBIGLIETTO3 = "";
    w_MIDBIGLIETTO4 = "";
    w_CAFLGOPE = "";
    w_TELDIP = "";
    w_CODLOC = "";
    w_xFLGPLGIO = "";
    w_IDDOCALL = "";
    w_FLGDOCALL = "";
    w_VLTPLAT = "";
    w_xVPFLGATT = "";
    w_DOC03 = "";
    w_DOC04 = "";
    w_tipop = "";
    w_CCDATSCA = "";
    w_gGesDoc = m_Ctx.GetGlobalString("gGesDoc");
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_RDCODAUT = "";
    w_RDLOCAUT = "";
    w_PEPDESCRI = "";
    w_PAESE2 = "";
    w_DESCCIT2 = "";
    w_idcitta2 = "";
    w_PROVINCIA2 = "";
    w_CAP2 = "";
    w_DOMICILIO2 = "";
    w_dessta2 = "";
    w_FLGQADVFULL = "";
    w_gQADV = m_Ctx.GetGlobalString("gQADV");
    w_xCGOFLGPROF = "";
    w_PROFESSIONE = "";
    w_CODCABDIP = "";
    w_PROVINCIADIP = "";
    w_DESCCITDIP = "";
    w_CODDIPE = "";
    w_ANA_FOUND = "";
    w_CGODATCON = CPLib.NullDate();
    w_CGOESICON = "";
    w_CGONOTCON = "";
    Link_QZTTRBWAQL();
    w_TIPOPERS = "";
    w_TIPOPERS = "P";
    w_CGOFLGVNP = "A";
    w_CGOFLGVLT = (CPLib.ge(w_TOTLIRE,w_xSOGTPGIO)?w_xDEFTPGIO:w_xDEFSPGIO);
    w_FLGPAGAM = "";
    w_FLGPAGAM = w_CGOFLGVLT;
    w_FILTROMP = "";
    w_FILTROMP = (CPLib.ne((w_TOTCONT+w_IMPWALLET),w_TOTLIRE)?"'I','E','P','B','C','V'":"'I','E','P','B','C','V','S','W'");
    w_CFESTERO = 0;
    w_PEP = "N";
    Link_NEUBQNUEOJ();
    Link_HODZKKOSYW();
    Link_YVIKEGPYPM();
    Link_ODAYKSRECA();
    Link_XPSJTIMTNR();
    Link_SAQTIHOALW();
    w_SOTGRUP = "";
    w_SOTGRUP = "600";
    w_SETTSINT = "";
    w_SETTSINT = "600";
    w_FLAGCONT = "0";
    w_FLAGWALLET = "0";
    w_TIPOOPRAP = "10";
    Link_UJRFWINIVQ();
    Link_SQVJLYRFKQ();
    Link_SRWWPHPCUB();
    w_VALUTA = "";
    w_VALUTA = "242";
    w_CAMBIO = 0;
    w_CAMBIO = 1;
    w_CONNESBEN = "";
    w_CONNESBEN = w_CODFISC;
    Link_ULVCBLFVEU();
    Link_KUPRRTVLKH();
    w_CODINTER = "";
    w_CODINTER = w_gIntemediario;
    Link_WJSVGWKSFC();
    w_FLAGFRAZ = "0";
    Link_MSGBKOOAOY();
    Link_LKEDJRUQJU();
    Link_WJQFIEBCQV();
    w_edtdoc = false;
    w_edtdoc = CPLib.Empty(w_IDDOCALL) || CPLib.Empty(w_TIPOGIOCO) || CPLib.le(w_TOTLIRE,0) || (CPLib.eq(w_FLAGCONT,"1") && CPLib.le(w_TOTCONT,0)) || (CPLib.eq(w_FLAGWALLET,"1") && CPLib.le(w_IMPWALLET,0));
    w_saveddoc = "N";
    Link_MBGANUUHRA();
    Link_YDUQCBNYFV();
    w_AUTRILASC = "";
    w_AUTRILASC = CPLib.Upper(CPLib.LRTrim(w_xARDESCRI)+" "+CPLib.LRTrim(w_RDLOCAUT));
    Link_UOOQYQWWNG();
    Link_BVEIQEJCLQ();
    Link_HNAYMCHXMY();
    w_FLGDOM = "N";
    Link_AVHTGZTOSZ();
    m_cWv_armt_cgo_qadv_operazioni = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || armt_cgo_qadv_operazioni.IsUpdated() || CPLib.IsUpdated(m_cWv_armt_cgo_qadv_operazioni);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_TIPOGIOCO = w_TIPOGIOCO;
    o_TOTLIRE = w_TOTLIRE;
    o_TOTCONT = w_TOTCONT;
    o_IMPWALLET = w_IMPWALLET;
    o_CGOFLGVLT = w_CGOFLGVLT;
    o_MEZPAGAM = w_MEZPAGAM;
    o_FLGPAGAM = w_FLGPAGAM;
    o_FILTROMP = w_FILTROMP;
    o_CODFISC = w_CODFISC;
    o_COGNOME = w_COGNOME;
    o_NOME = w_NOME;
    o_NASCOMUN = w_NASCOMUN;
    o_TIPINTER = w_TIPINTER;
    o_NASSTATO = w_NASSTATO;
    o_PAESE = w_PAESE;
    o_idcitta = w_idcitta;
    o_ATTIV = w_ATTIV;
    o_SOTGRUP = w_SOTGRUP;
    o_DATAOPE = w_DATAOPE;
    o_FLAGCONT = w_FLAGCONT;
    o_FLAGWALLET = w_FLAGWALLET;
    o_TIPOOPRAP = w_TIPOOPRAP;
    o_CODANA = w_CODANA;
    o_CODVOC = w_CODVOC;
    o_CONNESBEN = w_CONNESBEN;
    o_C_CTA = w_C_CTA;
    o_CODINTER = w_CODINTER;
    o_COLLEG = w_COLLEG;
    o_CACODICE = w_CACODICE;
    o_DATARILASC = w_DATARILASC;
    o_DATAVALI = w_DATAVALI;
    o_RDCODAUT = w_RDCODAUT;
    o_RDLOCAUT = w_RDLOCAUT;
    o_PAESE2 = w_PAESE2;
    o_idcitta2 = w_idcitta2;
    o_CODDIPE = w_CODDIPE;
    armt_cgo_qadv_operazioni.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Insert end")) {
      Calculation_YUKFFCZJLY();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_WKUMXNRIRT();
      Calculation_PSXKRMREMP();
    } else if (CPLib.eq(p_cEvent,"Load")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_PWXBRMMYBT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
    } else if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_YUKFFCZJLY();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_PSXKRMREMP();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_QZTTRBWAQL() {
    return Link_QZTTRBWAQL("Full");
  }
  protected boolean Link_QZTTRBWAQL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOGIOCO))) {
      String l_OldValue = w_TIPOGIOCO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOGIOCO,"C",3,0),m_cServer_cgo_tbtipgio,w_TIPOGIOCO);
      if (m_Ctx.IsSharedTemp("cgo_tbtipgio")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_tbtipgio,"select CODTPGIO,SOGTPGIO,DEFTPGIO,EDTTPGIO,EDTSPGIO,DEFSPGIO,FLGPLGIO from "+m_cPhName_cgo_tbtipgio+((m_cPhName_cgo_tbtipgio).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODTPGIO"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOGIOCO = l_rsLink.GetString("CODTPGIO");
          w_xSOGTPGIO = l_rsLink.GetDouble("SOGTPGIO");
          w_xDEFTPGIO = l_rsLink.GetString("DEFTPGIO");
          w_xEDTTPGIO = l_rsLink.GetString("EDTTPGIO");
          w_xEDTSPGIO = l_rsLink.GetString("EDTSPGIO");
          w_xDEFSPGIO = l_rsLink.GetString("DEFSPGIO");
          w_xFLGPLGIO = l_rsLink.GetString("FLGPLGIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QZTTRBWAQL_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOGIOCO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOGIOCO");
          }
          m_cLastWorkVarError = "TIPOGIOCO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QZTTRBWAQL_blank();
    }
    return l_bResult;
  }
  void Link_QZTTRBWAQL_blank() {
    w_TIPOGIOCO = "";
    w_xSOGTPGIO = 0;
    w_xDEFTPGIO = "";
    w_xEDTTPGIO = "";
    w_xEDTSPGIO = "";
    w_xDEFSPGIO = "";
    w_xFLGPLGIO = "";
  }
  protected boolean Link_NEUBQNUEOJ() {
    return Link_NEUBQNUEOJ("Full");
  }
  protected boolean Link_NEUBQNUEOJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_NASCOMUN))) {
      String l_OldValue = w_NASCOMUN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NASCOMUN,"C",30,0),m_cServer_tbcitta,w_NASCOMUN);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_NASCOMUN = l_rsLink.GetString("CITTA");
          w_TIPINTER = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_NEUBQNUEOJ_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","NASCOMUN");
          }
          m_cLastWorkVarError = "NASCOMUN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NEUBQNUEOJ_blank();
    }
    return l_bResult;
  }
  void Link_NEUBQNUEOJ_blank() {
    Link_NEUBQNUEOJ_blank("");
  }
  void Link_NEUBQNUEOJ_blank(String p_cType) {
    w_TIPINTER = "";
  }
  protected boolean Link_HODZKKOSYW() {
    return Link_HODZKKOSYW("Full");
  }
  protected boolean Link_HODZKKOSYW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_NASSTATO))) {
      String l_OldValue = w_NASSTATO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NASSTATO,"C",30,0),m_cServer_tbstati,w_NASSTATO);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_NASSTATO = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_HODZKKOSYW_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","NASSTATO");
          }
          m_cLastWorkVarError = "NASSTATO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HODZKKOSYW_blank();
    }
    return l_bResult;
  }
  void Link_HODZKKOSYW_blank() {
    Link_HODZKKOSYW_blank("");
  }
  void Link_HODZKKOSYW_blank(String p_cType) {
  }
  protected boolean Link_YVIKEGPYPM() {
    return Link_YVIKEGPYPM("Full");
  }
  protected boolean Link_YVIKEGPYPM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_PAESE))) {
      String l_OldValue = w_PAESE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",3,0),m_cServer_tbstati,w_PAESE);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",30,0),m_cServer_tbstati,w_PAESE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PAESE = l_rsLink.GetString("CODSTA");
          w_dessta = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_YVIKEGPYPM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_PAESE = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = (CPLib.eq(w_CFESTERO,1) && CPLib.eq(w_PAESE,"086")?false:(CPLib.eq(w_CFESTERO,0) && CPLib.ne(w_PAESE,"086")?false:true));
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = "Il paese di residenza deve essere congruente con il flag di soggetto estero!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PAESE");
              }
              m_cLastWorkVarError = "PAESE";
              w_PAESE = "";
              Link_YVIKEGPYPM_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = "Il paese di residenza deve essere congruente con il flag di soggetto estero!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PAESE");
              }
              m_cLastWorkVarError = "PAESE";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_YVIKEGPYPM_blank();
    }
    return l_bResult;
  }
  void Link_YVIKEGPYPM_blank() {
    w_PAESE = "";
    w_dessta = "";
  }
  protected boolean Link_ODAYKSRECA() {
    return Link_ODAYKSRECA("Full");
  }
  protected boolean Link_ODAYKSRECA(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      String l_OldValue = w_DESCCIT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",40,0),m_cServer_tbcitta,w_DESCCIT);
      l_cWhere = l_cWhere+" and PKTBSTATI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",3,0),m_cServer_tbcitta,w_PAESE);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select PKTBSTATI,CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",10,0),m_cServer_tbcitta,w_DESCCIT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select PKTBSTATI,CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DESCCIT = l_rsLink.GetString("CITTA");
          w_idcitta = l_rsLink.GetString("IDBASE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_ODAYKSRECA_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DESCCIT");
          }
          m_cLastWorkVarError = "DESCCIT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ODAYKSRECA_blank();
    }
    return l_bResult;
  }
  void Link_ODAYKSRECA_blank() {
    Link_ODAYKSRECA_blank("");
  }
  void Link_ODAYKSRECA_blank(String p_cType) {
    w_idcitta = "";
  }
  protected boolean Link_XPSJTIMTNR() {
    return Link_XPSJTIMTNR("Full");
  }
  protected boolean Link_XPSJTIMTNR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_idcitta))) {
      String l_OldValue = w_idcitta;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idcitta,"C",10,0),m_cServer_tbcitta,w_idcitta);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select IDBASE,CAB,PROV,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_idcitta = l_rsLink.GetString("IDBASE");
          w_CODCAB = l_rsLink.GetString("CAB");
          w_PROVINCIA = l_rsLink.GetString("PROV");
          w_CAP = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_XPSJTIMTNR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_idcitta = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","idcitta");
          }
          m_cLastWorkVarError = "idcitta";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XPSJTIMTNR_blank();
    }
    return l_bResult;
  }
  void Link_XPSJTIMTNR_blank() {
    w_idcitta = "";
    w_CODCAB = "";
    w_PROVINCIA = "";
    w_CAP = "";
  }
  protected boolean Link_SAQTIHOALW() {
    return Link_SAQTIHOALW("Full");
  }
  protected boolean Link_SAQTIHOALW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_ATTIV))) {
      String l_OldValue = w_ATTIV;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ATTIV,"C",10,0),m_cServer_tbtipatt,w_ATTIV);
      if (m_Ctx.IsSharedTemp("tbtipatt")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE,DESCRI from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIV = l_rsLink.GetString("CODICE");
          w_xdesctipatt = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SAQTIHOALW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_ATTIV = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","ATTIV");
          }
          m_cLastWorkVarError = "ATTIV";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SAQTIHOALW_blank();
    }
    return l_bResult;
  }
  void Link_SAQTIHOALW_blank() {
    w_ATTIV = "";
    w_xdesctipatt = "";
  }
  protected boolean Link_UJRFWINIVQ() {
    return Link_UJRFWINIVQ("Full");
  }
  protected boolean Link_UJRFWINIVQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOOPRAP))) {
      String l_OldValue = w_TIPOOPRAP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOOPRAP,"C",2,0),m_cServer_tbtipreg,w_TIPOOPRAP);
      if (m_Ctx.IsSharedTemp("tbtipreg")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipreg,"select CODICE,DES1 from "+m_cPhName_tbtipreg+((m_cPhName_tbtipreg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOOPRAP = l_rsLink.GetString("CODICE");
          w_xdes1 = l_rsLink.GetString("DES1");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UJRFWINIVQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOOPRAP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOOPRAP");
          }
          m_cLastWorkVarError = "TIPOOPRAP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UJRFWINIVQ_blank();
    }
    return l_bResult;
  }
  void Link_UJRFWINIVQ_blank() {
    w_TIPOOPRAP = "";
    w_xdes1 = "";
  }
  protected boolean Link_SQVJLYRFKQ() {
    return Link_SQVJLYRFKQ("Full");
  }
  protected boolean Link_SQVJLYRFKQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODANA))) {
      String l_OldValue = w_CODANA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODANA,"C",4,0),m_cServer_tbcauana,w_CODANA);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODCAU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODANA = l_rsLink.GetString("CODCAU");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SQVJLYRFKQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODANA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODANA");
          }
          m_cLastWorkVarError = "CODANA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SQVJLYRFKQ_blank();
    }
    return l_bResult;
  }
  void Link_SQVJLYRFKQ_blank() {
    w_CODANA = "";
  }
  protected boolean Link_SRWWPHPCUB() {
    return Link_SRWWPHPCUB("Full");
  }
  protected boolean Link_SRWWPHPCUB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODVOC))) {
      String l_OldValue = w_CODVOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODVOC,"C",2,0),m_cServer_tbcauana,w_CODVOC);
      l_cWhere = l_cWhere+" and CODCAU = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODANA,"C",4,0),m_cServer_tbcauana,w_CODANA);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU,CAUSINT,SEGNO,DESCRI from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CAUSINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODVOC = l_rsLink.GetString("CAUSINT");
          w_SEGNO = l_rsLink.GetString("SEGNO");
          w_desccauana = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SRWWPHPCUB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODVOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODVOC");
          }
          m_cLastWorkVarError = "CODVOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SRWWPHPCUB_blank();
    }
    return l_bResult;
  }
  void Link_SRWWPHPCUB_blank() {
    w_CODVOC = "";
    w_SEGNO = "";
    w_desccauana = "";
  }
  protected boolean Link_ULVCBLFVEU() {
    return Link_ULVCBLFVEU("Full");
  }
  protected boolean Link_ULVCBLFVEU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESBEN))) {
      String l_OldValue = w_CONNESBEN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"C",16,0),m_cServer_personbo,w_CONNESBEN);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,PAESE,CAP from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESBEN = l_rsLink.GetString("CONNES");
          w_C_RAG = l_rsLink.GetString("RAGSOC");
          w_C_IND = l_rsLink.GetString("DOMICILIO");
          w_C_CTA = l_rsLink.GetString("DESCCIT");
          w_C_PRV = l_rsLink.GetString("PROVINCIA");
          w_C_STA = l_rsLink.GetString("PAESE");
          w_C_CAP = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ULVCBLFVEU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESBEN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESBEN");
          }
          m_cLastWorkVarError = "CONNESBEN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ULVCBLFVEU_blank();
    }
    return l_bResult;
  }
  void Link_ULVCBLFVEU_blank() {
    w_CONNESBEN = "";
    w_C_RAG = "";
    w_C_IND = "";
    w_C_CTA = "";
    w_C_PRV = "";
    w_C_STA = "";
    w_C_CAP = "";
  }
  protected boolean Link_KUPRRTVLKH() {
    return Link_KUPRRTVLKH("Full");
  }
  protected boolean Link_KUPRRTVLKH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_C_CTA))) {
      String l_OldValue = w_C_CTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_C_CTA,"C",30,0),m_cServer_tbcitta,w_C_CTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAB,PROV,PKTBSTATI,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_C_CTA = l_rsLink.GetString("CITTA");
          w_C_CAB = l_rsLink.GetString("CAB");
          w_C_PRV = l_rsLink.GetString("PROV");
          w_C_STA = l_rsLink.GetString("PKTBSTATI");
          w_C_CAP = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_KUPRRTVLKH_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","C_CTA");
          }
          m_cLastWorkVarError = "C_CTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_KUPRRTVLKH_blank();
    }
    return l_bResult;
  }
  void Link_KUPRRTVLKH_blank() {
    Link_KUPRRTVLKH_blank("");
  }
  void Link_KUPRRTVLKH_blank(String p_cType) {
    w_C_CAB = "";
    w_C_PRV = "";
    w_C_STA = "";
    w_C_CAP = "";
  }
  protected boolean Link_WJSVGWKSFC() {
    return Link_WJSVGWKSFC("Full");
  }
  protected boolean Link_WJSVGWKSFC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODINTER))) {
      String l_OldValue = w_CODINTER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",11,0),m_cServer_intermbo,w_CODINTER);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_intermbo,"select CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT,CGOFLGPROF from "+m_cPhName_intermbo+((m_cPhName_intermbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODINTER = l_rsLink.GetString("CODINTER");
          w_datpaseuro = l_rsLink.GetDate("DATANASC");
          w_CABINT = l_rsLink.GetString("CODCAB");
          w_PROVINT = l_rsLink.GetString("PROVINCIA");
          w_CITINT = l_rsLink.GetString("DESCCIT");
          w_xCGOFLGPROF = l_rsLink.GetString("CGOFLGPROF");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_WJSVGWKSFC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODINTER = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINTER");
          }
          m_cLastWorkVarError = "CODINTER";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_WJSVGWKSFC_blank();
    }
    return l_bResult;
  }
  void Link_WJSVGWKSFC_blank() {
    w_CODINTER = "";
    w_datpaseuro = CPLib.NullDate();
    w_CABINT = "";
    w_PROVINT = "";
    w_CITINT = "";
    w_xCGOFLGPROF = "";
  }
  protected boolean Link_MSGBKOOAOY() {
    return Link_MSGBKOOAOY("Full");
  }
  protected boolean Link_MSGBKOOAOY(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_COLLEG))) {
      String l_OldValue = w_COLLEG;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COLLEG,"C",11,0),m_cServer_operazbo,w_COLLEG);
      if (m_Ctx.IsSharedTemp("operazbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_operazbo,"select NUMPROG from "+m_cPhName_operazbo+((m_cPhName_operazbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"NUMPROG"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_COLLEG = l_rsLink.GetString("NUMPROG");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MSGBKOOAOY_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_COLLEG = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","COLLEG");
          }
          m_cLastWorkVarError = "COLLEG";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MSGBKOOAOY_blank();
    }
    return l_bResult;
  }
  void Link_MSGBKOOAOY_blank() {
    w_COLLEG = "";
  }
  protected boolean Link_LKEDJRUQJU() {
    return Link_LKEDJRUQJU("Full");
  }
  protected boolean Link_LKEDJRUQJU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODVOC))) {
      String l_OldValue = w_CODVOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODVOC,"C",2,0),m_cServer_tbcausin,w_CODVOC);
      if (m_Ctx.IsSharedTemp("tbcausin")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcausin,"select CODVOC,DESCRIZ from "+m_cPhName_tbcausin+((m_cPhName_tbcausin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODVOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODVOC = l_rsLink.GetString("CODVOC");
          w_xdesccausin = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LKEDJRUQJU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODVOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODVOC");
          }
          m_cLastWorkVarError = "CODVOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LKEDJRUQJU_blank();
    }
    return l_bResult;
  }
  void Link_LKEDJRUQJU_blank() {
    w_CODVOC = "";
    w_xdesccausin = "";
  }
  protected boolean Link_WJQFIEBCQV() {
    return Link_WJQFIEBCQV("Full");
  }
  protected boolean Link_WJQFIEBCQV(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CACODICE))) {
      double l_OldValue = w_CACODICE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CACODICE,"N",5,0),m_cServer_cgo_causali,w_CACODICE);
      if (m_Ctx.IsSharedTemp("cgo_causali")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_causali,"select CACODICE,CAFLGOPE from "+m_cPhName_cgo_causali+((m_cPhName_cgo_causali).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CACODICE = l_rsLink.GetDouble("CACODICE");
          w_CAFLGOPE = l_rsLink.GetString("CAFLGOPE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_WJQFIEBCQV_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CACODICE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CACODICE");
          }
          m_cLastWorkVarError = "CACODICE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_WJQFIEBCQV_blank();
    }
    return l_bResult;
  }
  void Link_WJQFIEBCQV_blank() {
    w_CACODICE = 0;
    w_CAFLGOPE = "";
  }
  protected boolean Link_MBGANUUHRA() {
    return Link_MBGANUUHRA("Full");
  }
  protected boolean Link_MBGANUUHRA(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPODOC))) {
      String l_OldValue = w_TIPODOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPODOC,"C",2,0),m_cServer_cgo_tipdoc,w_TIPODOC);
      if (m_Ctx.IsSharedTemp("cgo_tipdoc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_tipdoc,"select TIPDOC,DESCRI from "+m_cPhName_cgo_tipdoc+((m_cPhName_cgo_tipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPDOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPODOC,"C",30,0),m_cServer_cgo_tipdoc,w_TIPODOC);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_cgo_tipdoc,"select TIPDOC,DESCRI from "+m_cPhName_cgo_tipdoc+((m_cPhName_cgo_tipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPODOC = l_rsLink.GetString("TIPDOC");
          w_DESCRI = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MBGANUUHRA_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPODOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPODOC");
          }
          m_cLastWorkVarError = "TIPODOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MBGANUUHRA_blank();
    }
    return l_bResult;
  }
  void Link_MBGANUUHRA_blank() {
    w_TIPODOC = "";
    w_DESCRI = "";
  }
  protected boolean Link_YDUQCBNYFV() {
    return Link_YDUQCBNYFV("Full");
  }
  protected boolean Link_YDUQCBNYFV(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RDCODAUT))) {
      String l_OldValue = w_RDCODAUT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RDCODAUT,"C",2,0),m_cServer_cgo_autorita,w_RDCODAUT);
      if (m_Ctx.IsSharedTemp("cgo_autorita")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_autorita,"select ARCODICE,ARDESCRI from "+m_cPhName_cgo_autorita+((m_cPhName_cgo_autorita).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"ARCODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RDCODAUT = l_rsLink.GetString("ARCODICE");
          w_xARDESCRI = l_rsLink.GetString("ARDESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_YDUQCBNYFV_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RDCODAUT = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chk_docautR.Make(m_Ctx,this).Run(w_RDCODAUT,w_TIPODOC);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = "Autorità non valida per il tipo documento selezionato";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RDCODAUT");
              }
              m_cLastWorkVarError = "RDCODAUT";
              w_RDCODAUT = "";
              Link_YDUQCBNYFV_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = "Autorità non valida per il tipo documento selezionato";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RDCODAUT");
              }
              m_cLastWorkVarError = "RDCODAUT";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_YDUQCBNYFV_blank();
    }
    return l_bResult;
  }
  void Link_YDUQCBNYFV_blank() {
    w_RDCODAUT = "";
    w_xARDESCRI = "";
  }
  protected boolean Link_UOOQYQWWNG() {
    return Link_UOOQYQWWNG("Full");
  }
  protected boolean Link_UOOQYQWWNG(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_PAESE2))) {
      String l_OldValue = w_PAESE2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE2,"C",3,0),m_cServer_tbstati,w_PAESE2);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE2,"C",40,0),m_cServer_tbstati,w_PAESE2);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PAESE2 = l_rsLink.GetString("CODSTA");
          w_dessta2 = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UOOQYQWWNG_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_PAESE2 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PAESE2");
          }
          m_cLastWorkVarError = "PAESE2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UOOQYQWWNG_blank();
    }
    return l_bResult;
  }
  void Link_UOOQYQWWNG_blank() {
    w_PAESE2 = "";
    w_dessta2 = "";
  }
  protected boolean Link_BVEIQEJCLQ() {
    return Link_BVEIQEJCLQ("Full");
  }
  protected boolean Link_BVEIQEJCLQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DESCCIT2))) {
      String l_OldValue = w_DESCCIT2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT2,"C",40,0),m_cServer_tbcitta,w_DESCCIT2);
      l_cWhere = l_cWhere+" and PKTBSTATI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",3,0),m_cServer_tbcitta,w_PAESE);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select PKTBSTATI,CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT2,"C",10,0),m_cServer_tbcitta,w_DESCCIT2);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select PKTBSTATI,CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DESCCIT2 = l_rsLink.GetString("CITTA");
          w_idcitta2 = l_rsLink.GetString("IDBASE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_BVEIQEJCLQ_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DESCCIT2");
          }
          m_cLastWorkVarError = "DESCCIT2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_BVEIQEJCLQ_blank();
    }
    return l_bResult;
  }
  void Link_BVEIQEJCLQ_blank() {
    Link_BVEIQEJCLQ_blank("");
  }
  void Link_BVEIQEJCLQ_blank(String p_cType) {
    w_idcitta2 = "";
  }
  protected boolean Link_HNAYMCHXMY() {
    return Link_HNAYMCHXMY("Full");
  }
  protected boolean Link_HNAYMCHXMY(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_idcitta2))) {
      String l_OldValue = w_idcitta2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idcitta2,"C",10,0),m_cServer_tbcitta,w_idcitta2);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select IDBASE,PROV,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_idcitta2 = l_rsLink.GetString("IDBASE");
          w_PROVINCIA2 = l_rsLink.GetString("PROV");
          w_CAP2 = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HNAYMCHXMY_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_idcitta2 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","idcitta2");
          }
          m_cLastWorkVarError = "idcitta2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HNAYMCHXMY_blank();
    }
    return l_bResult;
  }
  void Link_HNAYMCHXMY_blank() {
    w_idcitta2 = "";
    w_PROVINCIA2 = "";
    w_CAP2 = "";
  }
  protected boolean Link_AVHTGZTOSZ() {
    return Link_AVHTGZTOSZ("Full");
  }
  protected boolean Link_AVHTGZTOSZ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODDIPE))) {
      String l_OldValue = w_CODDIPE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",6,0),m_cServer_anadip,w_CODDIPE);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB,TELEFONO,CODLOC from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",30,0),m_cServer_anadip,w_CODDIPE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB,TELEFONO,CODLOC from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODDIPE = l_rsLink.GetString("CODDIP");
          w_xDescDipe = l_rsLink.GetString("DESCRIZ");
          w_CITDIP = l_rsLink.GetString("DESCCIT");
          w_PROVDIP = l_rsLink.GetString("PROVINCIA");
          w_CABDIP = l_rsLink.GetString("CAB");
          w_TELDIP = l_rsLink.GetString("TELEFONO");
          w_CODLOC = l_rsLink.GetString("CODLOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AVHTGZTOSZ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODDIPE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODDIPE");
          }
          m_cLastWorkVarError = "CODDIPE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AVHTGZTOSZ_blank();
    }
    return l_bResult;
  }
  void Link_AVHTGZTOSZ_blank() {
    w_CODDIPE = "";
    w_xDescDipe = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_TELDIP = "";
    w_CODLOC = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_TOTCONT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TOTCONT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_chktotalelire_contR.Make(m_Ctx,this).Run(w_DATAOPE,w_datpaseuro,w_TOTCONT,w_TOTLIRE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TOTCONT = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean HUDOCMLKKT_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLAGCONT,"1");
  }
  public boolean Set_IMPWALLET(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPWALLET = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = CPLib.le(w_IMPWALLET,(w_TOTLIRE-w_TOTCONT));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "L'importo non può superare la differenza tra importo totale e importo contanti";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IMPWALLET = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean BELMGUMGMW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLAGWALLET,"1");
  }
  public boolean Set_CODWALLET(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODWALLET = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODWALLET = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean LQVQUGYYJF_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLAGWALLET,"1");
  }
  public boolean Set_CODTRANSZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODTRANSZ = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODTRANSZ = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean YYELCZIDWS_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLAGWALLET,"1");
  }
  public boolean Set_CGOFLGVLT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CGOFLGVLT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CGOFLGVLT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MEZPAGAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MEZPAGAM = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MEZPAGAM = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean EOSKLIUGBC_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0);
  }
  public boolean Set_FLGPAGAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGPAGAM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FILTROMP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FILTROMP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CC4CIFRE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CC4CIFRE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_cgo_chkccR.Make(m_Ctx,this).Run(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,1,w_MEZPAGAM);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CC4CIFRE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean FKEAKFSYVU_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_MEZPAGAM,"V");
  }
  public boolean Set_CCMESSCA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CCMESSCA = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CCMESSCA = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean MFCMVHMGSB_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_MEZPAGAM,"V");
  }
  public boolean Set_CCANNSCA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CCANNSCA = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_cgo_chkccR.Make(m_Ctx,this).Run(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,2,w_MEZPAGAM);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CCANNSCA = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean YZHCHEDWZM_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_MEZPAGAM,"V");
  }
  public boolean Set_IBAN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBAN = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_chkibanR.Make(m_Ctx,this).Run(CPLib.Upper(w_IBAN),w_MEZPAGAM);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IBAN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean UTUCDPQJKK_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_MEZPAGAM,"I") || CPLib.eq(w_MEZPAGAM,"E") || CPLib.eq(w_MEZPAGAM,"P");
  }
  public boolean Set_ASSEGNO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ASSEGNO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ASSEGNO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean KZWBLPQNHU_isObligatory() {
    // Condizione di obbligatorietà
    return (CPLib.eq(w_MEZPAGAM,"C") || CPLib.eq(w_MEZPAGAM,"B")) && (CPLib.ne(w_CGOFLGVLT,"S"));
  }
  public boolean Set_CFESTERO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CFESTERO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PEP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PEP = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PEP = "N";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODFISC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODFISC = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,"086",w_CFESTERO);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "Codice Fiscale Errato nel formato";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODFISC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean OJJHIUDPFY_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_CFESTERO,0);
  }
  public boolean Set_COGNOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COGNOME = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_COGNOME = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOME = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NOME = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NASCOMUN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NASCOMUN = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_NEUBQNUEOJ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NASCOMUN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean NEUBQNUEOJ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.Empty(w_NASSTATO);
  }
  public boolean Set_TIPINTER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPINTER = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPINTER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SESSO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SESSO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SESSO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NASSTATO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NASSTATO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_HODZKKOSYW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NASSTATO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean HODZKKOSYW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.Empty(w_NASCOMUN);
  }
  public boolean Set_DATANASC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATANASC = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_maggiorenneR.Make(m_Ctx,this).Run(w_DATANASC,w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATANASC = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PAESE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PAESE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_YVIKEGPYPM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      l_bTmpRes = Link_ODAYKSRECA();
    }
    if ( ! (CPLib.Empty(w_DESCCIT2))) {
      l_bTmpRes = Link_BVEIQEJCLQ();
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PAESE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCCIT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCCIT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_ODAYKSRECA();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCCIT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean ODAYKSRECA_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean Set_PROVINCIA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROVINCIA = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PROVINCIA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean NOTZPDMYIA_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean Set_CAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAP = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CAP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean RDAVOEETJG_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean Set_DOMICILIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOMICILIO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DOMICILIO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean VYLHWTRQNX_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean Set_NUMTEL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMTEL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SNAINUMOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SNAINUMOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLAGCONT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGCONT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLAGWALLET(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGWALLET = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_FLAGWALLET = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAIDBIGLIETTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAIDBIGLIETTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_verifica(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_verifica = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMOPEDL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMOPEDL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGDOCALL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGDOCALL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DOC03(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOC03 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DOC04(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOC04 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tipop(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipop = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_saveddoc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_saveddoc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPODOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPODOC = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_MBGANUUHRA();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPODOC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMDOCUM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMDOCUM = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NUMDOCUM = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARILASC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATARILASC = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_DATARILASC,w_TIPODOC,"R",w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATARILASC = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAVALI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAVALI = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_DATAVALI,w_TIPODOC,"S",w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAVALI = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RDCODAUT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RDCODAUT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_YDUQCBNYFV();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RDCODAUT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RDLOCAUT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RDLOCAUT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RDLOCAUT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PEPDESCRI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PEPDESCRI = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PEPDESCRI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean DAEHHCRYAM_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PEP,"S");
  }
  public boolean Set_PAESE2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PAESE2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_UOOQYQWWNG();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PAESE2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean UOOQYQWWNG_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLGDOM,"S");
  }
  public boolean Set_DESCCIT2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCCIT2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_BVEIQEJCLQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCCIT2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean BVEIQEJCLQ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean Set_PROVINCIA2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROVINCIA2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PROVINCIA2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean NKJDWBKDWM_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean Set_CAP2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAP2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CAP2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean MDTHUZMSSI_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean Set_DOMICILIO2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOMICILIO2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DOMICILIO2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean CWOLOHZAQW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean Set_FLGDOM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGDOM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGQADVFULL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGQADVFULL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROFESSIONE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROFESSIONE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PROFESSIONE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean XFPPPEOSWP_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_xCGOFLGPROF,"S");
  }
  public boolean Set_CODDIPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIPE = p_workVariableValue;
    l_bResult = Link_AVHTGZTOSZ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODDIPE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ANA_FOUND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ANA_FOUND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CGONOTCON(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CGONOTCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_TOTCONT() {
    return CPLib.eq(w_FLAGCONT,"1") &&  ! (CPLib.Empty(w_DATAOPE));
  }
  public boolean getWritable_IMPWALLET() {
    return CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE));
  }
  public boolean getWritable_CODWALLET() {
    return CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE));
  }
  public boolean getWritable_CODTRANSZ() {
    return CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE));
  }
  public boolean getWritable_CGOFLGVLT() {
    return (CPLib.eq(w_xEDTTPGIO,"S") && CPLib.ge(w_TOTLIRE,w_xSOGTPGIO)) || (CPLib.eq(w_xEDTSPGIO,"S") && CPLib.lt(w_TOTLIRE,w_xSOGTPGIO));
  }
  public boolean getWritable_MEZPAGAM() {
    return CPLib.gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0);
  }
  public boolean getWritable_DESCCIT() {
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean getWritable_PROVINCIA() {
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean getWritable_CAP() {
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean getWritable_DOMICILIO() {
    return CPLib.eq(w_PAESE,"086");
  }
  public boolean getWritable_SNAINUMOPE() {
    return false;
  }
  public boolean getWritable_CAIDBIGLIETTO() {
    return false;
  }
  public boolean getWritable_PEPDESCRI() {
    return CPLib.eq(w_PEP,"S");
  }
  public boolean getWritable_PAESE2() {
    return CPLib.eq(w_FLGDOM,"S");
  }
  public boolean getWritable_DESCCIT2() {
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean getWritable_PROVINCIA2() {
    return CPLib.eq(w_PAESE,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean getWritable_CAP2() {
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean getWritable_DOMICILIO2() {
    return CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S");
  }
  public boolean getWritable_FLGQADVFULL() {
    return false;
  }
  public boolean getWritable_CODDIPE() {
    return false;
  }
  public boolean getWritable_CGONOTCON() {
    return false;
  }
  public boolean getVisible_MEZPAGAM() {
    return CPLib.eq(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0);
  }
  public boolean getVisible_FLGPAGAM() {
    return true;
  }
  public boolean getVisible_FILTROMP() {
    return true;
  }
  public boolean getVisible_CC4CIFRE() {
    return CPLib.ne(w_MEZPAGAM,"V");
  }
  public boolean getVisible_CCMESSCA() {
    return CPLib.ne(w_MEZPAGAM,"V");
  }
  public boolean getVisible_CCANNSCA() {
    return CPLib.ne(w_MEZPAGAM,"V");
  }
  public boolean getVisible_IBAN() {
    return CPLib.ne(w_MEZPAGAM,"I") && CPLib.ne(w_MEZPAGAM,"E") && CPLib.ne(w_MEZPAGAM,"P");
  }
  public boolean getVisible_ASSEGNO() {
    return (CPLib.ne(w_MEZPAGAM,"C") && CPLib.ne(w_MEZPAGAM,"B")) || (CPLib.eq(w_CGOFLGVLT,"S"));
  }
  public boolean getVisible_CONNESCLI() {
    return true;
  }
  public boolean getVisible_verifica() {
    return true;
  }
  public boolean getVisible_NUMOPEDL() {
    return true;
  }
  public boolean getVisible_FLGDOCALL() {
    return true;
  }
  public boolean getVisible_DOC03() {
    return true;
  }
  public boolean getVisible_DOC04() {
    return true;
  }
  public boolean getVisible_tipop() {
    return true;
  }
  public boolean getVisible_saveddoc() {
    return true;
  }
  public boolean getVisible_FLGQADVFULL() {
    return true;
  }
  public boolean getVisible_PROFESSIONE() {
    return CPLib.eq(w_xCGOFLGPROF,"N");
  }
  public boolean getVisible_ANA_FOUND() {
    return true;
  }
  public boolean Set_Password(String p_pwd) {
    m_cPassword = p_pwd;
    return true;
  }
  public boolean Set_OTP(String p_otp) {
    m_cOTP = p_otp;
    return true;
  }
  public boolean Calculate() {
    boolean l_bTmpRes;
    l_bTmpRes = true;
    boolean l_bResult;
    l_bResult = true;
    m_bCalculating = true;
    if (CPLib.ne(o_TIPOGIOCO,w_TIPOGIOCO)) {
      l_bTmpRes = Link_QZTTRBWAQL();
    }
    w_TIPOPERS = "P";
    if (CPLib.ne(o_CGOFLGVLT,w_CGOFLGVLT) || CPLib.ne(o_TOTLIRE,w_TOTLIRE) || CPLib.ne(o_TOTCONT,w_TOTCONT)) {
      w_FLGPAGAM = w_CGOFLGVLT;
    }
    if (CPLib.ne(o_TOTLIRE,w_TOTLIRE) || CPLib.ne(o_TOTCONT,w_TOTCONT)) {
      w_FILTROMP = (CPLib.ne((w_TOTCONT+w_IMPWALLET),w_TOTLIRE)?"'I','E','P','B','C','V'":"'I','E','P','B','C','V','S','W'");
    }
    if (CPLib.ne(o_idcitta,w_idcitta)) {
      l_bTmpRes = Link_XPSJTIMTNR();
    }
    if (CPLib.ne(o_ATTIV,w_ATTIV)) {
      l_bTmpRes = Link_SAQTIHOALW();
    }
    w_SOTGRUP = "600";
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
      w_SETTSINT = "600";
    }
    if (CPLib.ne(o_COGNOME,w_COGNOME) || CPLib.ne(o_NOME,w_NOME)) {
      Calculation_UEZIABOGNW();
    }
    if (CPLib.ne(o_NASSTATO,w_NASSTATO)) {
      Calculation_DWHWPBJTAT();
    }
    if (CPLib.ne(o_TIPOOPRAP,w_TIPOOPRAP)) {
      l_bTmpRes = Link_UJRFWINIVQ();
    }
    if (CPLib.ne(o_CODANA,w_CODANA)) {
      l_bTmpRes = Link_SQVJLYRFKQ();
    }
    if (CPLib.ne(o_CODANA,w_CODANA) || CPLib.ne(o_CODVOC,w_CODVOC)) {
      l_bTmpRes = Link_SRWWPHPCUB();
    }
    w_VALUTA = "242";
    w_CAMBIO = 1;
    w_CONNESBEN = w_CODFISC;
    l_bTmpRes = Link_ULVCBLFVEU();
    if (CPLib.ne(o_CONNESBEN,w_CONNESBEN) || CPLib.ne(o_C_CTA,w_C_CTA)) {
      l_bTmpRes = Link_KUPRRTVLKH();
    }
    w_CODINTER = w_gIntemediario;
    l_bTmpRes = Link_WJSVGWKSFC();
    if (CPLib.ne(o_COLLEG,w_COLLEG)) {
      l_bTmpRes = Link_MSGBKOOAOY();
    }
    if (CPLib.ne(o_CODINTER,w_CODINTER) || CPLib.ne(o_CODDIPE,w_CODDIPE)) {
      Calculation_WKUMXNRIRT();
    }
    if (CPLib.ne(o_CODVOC,w_CODVOC)) {
      l_bTmpRes = Link_LKEDJRUQJU();
    }
    if (CPLib.ne(o_NASCOMUN,w_NASCOMUN) || CPLib.ne(o_TIPINTER,w_TIPINTER)) {
      Calculation_QQIFZZEGJS();
    }
    if (CPLib.ne(o_CACODICE,w_CACODICE)) {
      l_bTmpRes = Link_WJQFIEBCQV();
    }
    if (CPLib.ne(o_PAESE,w_PAESE)) {
      Calculation_BUOAEINKPC();
    }
    if (CPLib.ne(o_MEZPAGAM,w_MEZPAGAM)) {
      Calculation_YQDKHNZKNZ();
    }
    if (CPLib.ne(o_FLAGCONT,w_FLAGCONT) || CPLib.ne(o_FLAGWALLET,w_FLAGWALLET)) {
      Calculation_JVLUWJLOKL();
    }
    if (CPLib.ne(o_CODFISC,w_CODFISC)) {
      Calculation_CMDOBQAJRA();
    }
    if (CPLib.ne(o_TOTLIRE,w_TOTLIRE) || CPLib.ne(o_TOTCONT,w_TOTCONT) || CPLib.ne(o_IMPWALLET,w_IMPWALLET)) {
      Calculation_OCENIGMBXJ();
    }
    w_edtdoc = CPLib.Empty(w_IDDOCALL) || CPLib.Empty(w_TIPOGIOCO) || CPLib.le(w_TOTLIRE,0) || (CPLib.eq(w_FLAGCONT,"1") && CPLib.le(w_TOTCONT,0)) || (CPLib.eq(w_FLAGWALLET,"1") && CPLib.le(w_IMPWALLET,0));
    w_AUTRILASC = CPLib.Upper(CPLib.LRTrim(w_xARDESCRI)+" "+CPLib.LRTrim(w_RDLOCAUT));
    if (CPLib.ne(o_idcitta2,w_idcitta2)) {
      l_bTmpRes = Link_HNAYMCHXMY();
    }
    if (CPLib.ne(o_PAESE2,w_PAESE2)) {
      Calculation_JOFLKSCHRI();
    }
    if (CPLib.ne(o_PAESE,w_PAESE)) {
      Calculation_GAIJOLNWVG();
    }
    if (CPLib.ne(o_PAESE2,w_PAESE2)) {
      Calculation_GHVEEQUKJN();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_UEZIABOGNW() {
    w_COGNOME = arfn_agecharR.Make(m_Ctx,this).Run(w_COGNOME," ");
    w_NOME = arfn_agecharR.Make(m_Ctx,this).Run(w_NOME," ");
    w_RAGSOC = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(w_COGNOME)+" "+CPLib.LRTrim(w_NOME)," ");
  }
  void Calculation_OEZVQSLBRM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "CGO_OPERAZIONI";
    l_oRoutine_arrt_writelog.pChiave = w_SNAINUMOPE;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_KGBNFVNJHO() {
    arrt_snai_oper_saveR l_oRoutine_arrt_snai_oper_save;
    l_oRoutine_arrt_snai_oper_save = arrt_snai_oper_saveR.Make(m_Ctx,this);
    l_oRoutine_arrt_snai_oper_save.pSNAINUMOPE = w_SNAINUMOPE;
    l_oRoutine_arrt_snai_oper_save.pTipo = w_tipop;
    l_oRoutine_arrt_snai_oper_save.pAzi = "";
    l_oRoutine_arrt_snai_oper_save.Run();
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "CGO_OPERAZIONI";
    l_oRoutine_arrt_writelog.pChiave = w_SNAINUMOPE;
    l_oRoutine_arrt_writelog.Run();
    arrt_cgo_qadv_mailR l_oRoutine_arrt_cgo_qadv_mail;
    l_oRoutine_arrt_cgo_qadv_mail = arrt_cgo_qadv_mailR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_qadv_mail.pSNAINUMOPE = w_SNAINUMOPE;
    l_oRoutine_arrt_cgo_qadv_mail.pTIPOGIOCO = w_TIPOGIOCO;
    l_oRoutine_arrt_cgo_qadv_mail.pORIGINE = "W";
    l_oRoutine_arrt_cgo_qadv_mail.Run();
  }
  void Calculation_DWHWPBJTAT() {
    w_TIPINTER = ( ! (CPLib.Empty(w_TIPINTER))?w_TIPINTER:( ! (CPLib.Empty(w_NASSTATO))?"EE":""));
  }
  void Calculation_WKUMXNRIRT() {
    w_DESCCITDIP = (CPLib.Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
    w_PROVINCIADIP = (CPLib.Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
    w_CODCABDIP = (CPLib.Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
  }
  void Calculation_QQIFZZEGJS() {
    w_NASSTATO = (CPLib.eq(w_TIPINTER,"EE")?w_NASSTATO:"ITALIA");
  }
  void Calculation_BUOAEINKPC() {
    w_PROVINCIA = ( ! (CPLib.Empty(w_PROVINCIA))?w_PROVINCIA:(CPLib.ne(w_PAESE,"086")?"EE":""));
  }
  void Calculation_YQDKHNZKNZ() {
    w_IBAN = ((CPLib.eq(w_MEZPAGAM,"I") || CPLib.eq(w_MEZPAGAM,"E") || CPLib.eq(w_MEZPAGAM,"P"))?w_IBAN:CPLib.Space(27));
  }
  void Calculation_JVLUWJLOKL() {
    w_TOTCONT = (CPLib.eq(w_FLAGCONT,"0")?0:w_TOTCONT);
    w_IMPWALLET = (CPLib.eq(w_FLAGWALLET,"0")?0:w_IMPWALLET);
  }
  void Calculation_CMDOBQAJRA() {
    arrt_cgo_read_flgopeR l_oRoutine_arrt_cgo_read_flgope;
    l_oRoutine_arrt_cgo_read_flgope = arrt_cgo_read_flgopeR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_read_flgope.Run();
  }
  void Calculation_PSXKRMREMP() {
    w_FLGDOCALL = arfn_cgo_chkdocsR.Make(m_Ctx,this).Run(w_IDDOCALL,w_TIPOGIOCO,w_TOTLIRE,w_TOTCONT,w_FLGDOCALL);
  }
  void Calculation_OCENIGMBXJ() {
    w_MEZPAGAM = (CPLib.eq(w_TOTLIRE,w_TOTCONT)?"S":(CPLib.eq(w_TOTLIRE,w_IMPWALLET)?"W":""));
  }
  void Calculation_YUKFFCZJLY() {
    arrt_cgo_confirm_docR l_oRoutine_arrt_cgo_confirm_doc;
    l_oRoutine_arrt_cgo_confirm_doc = arrt_cgo_confirm_docR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_confirm_doc.pIDDOC = w_IDDOCALL;
    l_oRoutine_arrt_cgo_confirm_doc.Run();
  }
  void Calculation_JOFLKSCHRI() {
    w_PROVINCIA2 = ( ! (CPLib.Empty(w_PROVINCIA2))?w_PROVINCIA2:(CPLib.ne(w_PAESE2,"086")?"EE":""));
  }
  void Calculation_GAIJOLNWVG() {
    w_DESCCIT = ( ! (CPLib.Empty(w_PAESE)) && CPLib.ne(w_PAESE,"086")?"":w_DESCCIT);
    w_CAP = ( ! (CPLib.Empty(w_PAESE)) && CPLib.ne(w_PAESE,"086")?"":w_CAP);
    w_DOMICILIO = ( ! (CPLib.Empty(w_PAESE)) && CPLib.ne(w_PAESE,"086")?"":w_DOMICILIO);
    w_CODCAB = ( ! (CPLib.Empty(w_PAESE)) && CPLib.ne(w_PAESE,"086")?"":w_CODCAB);
    w_PROVINCIA = ( ! (CPLib.Empty(w_PAESE)) && CPLib.ne(w_PAESE,"086")?"":w_PROVINCIA);
  }
  void Calculation_GHVEEQUKJN() {
    w_DESCCIT2 = ( ! (CPLib.Empty(w_PAESE2)) && CPLib.ne(w_PAESE2,"086")?"":w_DESCCIT2);
    w_CAP2 = ( ! (CPLib.Empty(w_PAESE2)) && CPLib.ne(w_PAESE2,"086")?"":w_CAP2);
    w_DOMICILIO2 = ( ! (CPLib.Empty(w_PAESE2)) && CPLib.ne(w_PAESE2,"086")?"":w_DOMICILIO2);
    w_PROVINCIA2 = ( ! (CPLib.Empty(w_PAESE2)) && CPLib.ne(w_PAESE2,"086")?"":w_PROVINCIA2);
  }
  void Calculation_PWXBRMMYBT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "CGO_OPERAZIONI";
    l_oRoutine_arrt_writelog.pChiave = w_SNAINUMOPE;
    l_oRoutine_arrt_writelog.Run();
    arrt_cgo_qadv_mailR l_oRoutine_arrt_cgo_qadv_mail;
    l_oRoutine_arrt_cgo_qadv_mail = arrt_cgo_qadv_mailR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_qadv_mail.pSNAINUMOPE = w_SNAINUMOPE;
    l_oRoutine_arrt_cgo_qadv_mail.pTIPOGIOCO = w_TIPOGIOCO;
    l_oRoutine_arrt_cgo_qadv_mail.pORIGINE = "W";
    l_oRoutine_arrt_cgo_qadv_mail.Run();
  }
  boolean Check_NXWIUCGNDI(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_DATARILASC,w_DATARILASC) || CPLib.ne(o_DATAOPE,w_DATAOPE)) {
      l_bResult = ( ! (CPLib.Empty(w_DATARILASC)) &&  ! (CPLib.Empty(w_DATAOPE))?CPLib.ge(w_DATAOPE,w_DATARILASC):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.";
      }
    }
    return l_bResult;
  }
  boolean Check_YHNSLBLWFP(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_DATAVALI,w_DATAVALI) || CPLib.ne(o_DATAOPE,w_DATAOPE)) {
      l_bResult = ( ! (CPLib.Empty(w_DATAVALI)) &&  ! (CPLib.Empty(w_DATAOPE))?CPLib.le(w_DATAOPE,w_DATAVALI):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.";
      }
    }
    return l_bResult;
  }
  boolean Check_QNEKQYKSHZ(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_DATARILASC,w_DATARILASC) || CPLib.ne(o_DATAVALI,w_DATAVALI)) {
      l_bResult = ( ! (CPLib.Empty(w_DATAVALI)) &&  ! (CPLib.Empty(w_DATARILASC))?CPLib.le(w_DATARILASC,w_DATAVALI):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Data di rilascio superiore alla data fine validità.Verificare il corretto inserimento delle date.";
      }
    }
    return l_bResult;
  }
  protected void BlankStatusVariables() {
    m_bLoaded = false;
    m_bUpdated = false;
    m_cPreviousState = CPSecurity.UNKNOWN_STATE;
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"SNAINUMOPE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_snai_oper","cgo_operazioni",m_KeyColumns,m_Ctx);
    return l_cFilter;
  }
  public void SetFromContext(String s) {
    SetFromContext(s,null);
  }
  public void SetFromContext(java.util.Properties p) {
    SetFromContext("_dummy_",p);
  }
  public void SetFromContext(String s,java.util.Properties p) {
    BlankStatusVariables();
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_TIPOGIOCO = "";
    w_xSOGTPGIO = 0;
    w_xDEFTPGIO = "";
    w_xEDTTPGIO = "";
    w_xEDTSPGIO = "";
    w_xDEFSPGIO = "";
    w_TIPOPERS = "";
    w_CGOFLGVNP = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_IMPWALLET = 0;
    w_CODWALLET = "";
    w_CODTRANSZ = "";
    w_CGOFLGVLT = "";
    w_MEZPAGAM = "";
    w_FLGPAGAM = "";
    w_FILTROMP = "";
    w_CC4CIFRE = "";
    w_CCMESSCA = 0;
    w_CCANNSCA = 0;
    w_IBAN = "";
    w_ASSEGNO = "";
    w_CFESTERO = 0;
    w_PEP = "";
    w_CODFISC = "";
    w_COGNOME = "";
    w_NOME = "";
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_SESSO = "";
    w_NASSTATO = "";
    w_DATANASC = CPLib.NullDate();
    w_PAESE = "";
    w_RAGSOC = "";
    w_DESCCIT = "";
    w_idcitta = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_NUMTEL = "";
    w_xARDESCRI = "";
    w_ATTIV = "";
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_SETTSINT = "";
    w_dessta = "";
    w_tipsot = "";
    w_STATOREG = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_SNAINUMOPE = "";
    w_DATAOPE = CPLib.NullDate();
    w_DATAREG = CPLib.NullDate();
    w_FLAGCONT = "";
    w_FLAGWALLET = "";
    w_TIPOOPRAP = "";
    w_CODANA = "";
    w_CODVOC = "";
    w_VALUTA = "";
    w_CAMBIO = 0;
    w_CONNESCLI = "";
    w_CONNESBEN = "";
    w_C_RAG = "";
    w_C_CTA = "";
    w_C_PRV = "";
    w_C_CAP = "";
    w_C_CAB = "";
    w_C_IND = "";
    w_C_STA = "";
    w_NUMPROG = "";
    w_CODINTER = "";
    w_SEGNO = "";
    w_FLAGFRAZ = "";
    w_COLLEG = "";
    w_xDescDipe = "";
    w_datpaseuro = CPLib.NullDate();
    w_xdes1 = "";
    w_desccauana = "";
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_CODVOC = "";
    w_xdesccausin = "";
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_CACODICE = 0;
    w_CAIDBIGLIETTO = "";
    w_xdesctipatt = "";
    w_gVLT = m_Ctx.GetGlobalNumber("gVLT");
    w_gVNP = m_Ctx.GetGlobalNumber("gVNP");
    w_CGOTIPOPE = "";
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_verifica = "";
    w_NUMOPEDL = "";
    w_gStpDwn = m_Ctx.GetGlobalString("gStpDwn");
    w_MIDBIGLIETTO = "";
    w_MIDBIGLIETTO1 = "";
    w_MIDBIGLIETTO2 = "";
    w_MIDBIGLIETTO3 = "";
    w_MIDBIGLIETTO4 = "";
    w_CAFLGOPE = "";
    w_TELDIP = "";
    w_CODLOC = "";
    w_xFLGPLGIO = "";
    w_IDDOCALL = "";
    w_FLGDOCALL = "";
    w_VLTPLAT = "";
    w_xVPFLGATT = "";
    w_DOC03 = "";
    w_DOC04 = "";
    w_tipop = "";
    w_CCDATSCA = "";
    w_gGesDoc = m_Ctx.GetGlobalString("gGesDoc");
    w_edtdoc = false;
    w_saveddoc = "";
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_RDCODAUT = "";
    w_RDLOCAUT = "";
    w_AUTRILASC = "";
    w_PEPDESCRI = "";
    w_PAESE2 = "";
    w_DESCCIT2 = "";
    w_idcitta2 = "";
    w_PROVINCIA2 = "";
    w_CAP2 = "";
    w_DOMICILIO2 = "";
    w_FLGDOM = "";
    w_dessta2 = "";
    w_FLGQADVFULL = "";
    w_gQADV = m_Ctx.GetGlobalString("gQADV");
    w_xCGOFLGPROF = "";
    w_PROFESSIONE = "";
    w_CODCABDIP = "";
    w_PROVINCIADIP = "";
    w_DESCCITDIP = "";
    w_CODDIPE = "";
    w_ANA_FOUND = "";
    w_CGODATCON = CPLib.NullDate();
    w_CGOESICON = "";
    w_CGONOTCON = "";
    m_cWv_armt_cgo_qadv_operazioni = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_TIPOGIOCO = CPLib.GetProperty(p,"TIPOGIOCO",w_TIPOGIOCO,0);
      w_TIPOPERS = CPLib.GetProperty(p,"TIPOPERS",w_TIPOPERS,0);
      w_CGOFLGVNP = CPLib.GetProperty(p,"CGOFLGVNP",w_CGOFLGVNP,0);
      w_TOTLIRE = CPLib.GetProperty(p,"TOTLIRE",w_TOTLIRE,0);
      w_TOTCONT = CPLib.GetProperty(p,"TOTCONT",w_TOTCONT,0);
      w_IMPWALLET = CPLib.GetProperty(p,"IMPWALLET",w_IMPWALLET,0);
      w_CODWALLET = CPLib.GetProperty(p,"CODWALLET",w_CODWALLET,0);
      w_CODTRANSZ = CPLib.GetProperty(p,"CODTRANSZ",w_CODTRANSZ,0);
      w_CGOFLGVLT = CPLib.GetProperty(p,"CGOFLGVLT",w_CGOFLGVLT,0);
      w_MEZPAGAM = CPLib.GetProperty(p,"MEZPAGAM",w_MEZPAGAM,0);
      w_CC4CIFRE = CPLib.GetProperty(p,"CC4CIFRE",w_CC4CIFRE,0);
      w_CCMESSCA = CPLib.GetProperty(p,"CCMESSCA",w_CCMESSCA,0);
      w_CCANNSCA = CPLib.GetProperty(p,"CCANNSCA",w_CCANNSCA,0);
      w_IBAN = CPLib.GetProperty(p,"IBAN",w_IBAN,0);
      w_ASSEGNO = CPLib.GetProperty(p,"ASSEGNO",w_ASSEGNO,0);
      w_CFESTERO = CPLib.GetProperty(p,"CFESTERO",w_CFESTERO,0);
      w_PEP = CPLib.GetProperty(p,"PEP",w_PEP,0);
      w_CODFISC = CPLib.GetProperty(p,"CODFISC",w_CODFISC,0);
      w_COGNOME = CPLib.GetProperty(p,"COGNOME",w_COGNOME,0);
      w_NOME = CPLib.GetProperty(p,"NOME",w_NOME,0);
      w_NASCOMUN = CPLib.GetProperty(p,"NASCOMUN",w_NASCOMUN,0);
      w_TIPINTER = CPLib.GetProperty(p,"TIPINTER",w_TIPINTER,0);
      w_SESSO = CPLib.GetProperty(p,"SESSO",w_SESSO,0);
      w_NASSTATO = CPLib.GetProperty(p,"NASSTATO",w_NASSTATO,0);
      w_DATANASC = CPLib.GetProperty(p,"DATANASC",w_DATANASC,0);
      w_PAESE = CPLib.GetProperty(p,"PAESE",w_PAESE,0);
      w_RAGSOC = CPLib.GetProperty(p,"RAGSOC",w_RAGSOC,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CAP = CPLib.GetProperty(p,"CAP",w_CAP,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_DOMICILIO = CPLib.GetProperty(p,"DOMICILIO",w_DOMICILIO,0);
      w_NUMTEL = CPLib.GetProperty(p,"NUMTEL",w_NUMTEL,0);
      w_ATTIV = CPLib.GetProperty(p,"ATTIV",w_ATTIV,0);
      w_SOTGRUP = CPLib.GetProperty(p,"SOTGRUP",w_SOTGRUP,0);
      w_RAMOGRUP = CPLib.GetProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
      w_SETTSINT = CPLib.GetProperty(p,"SETTSINT",w_SETTSINT,0);
      w_SNAINUMOPE = CPLib.GetProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
      w_DATAOPE = CPLib.GetProperty(p,"DATAOPE",w_DATAOPE,0);
      w_DATAREG = CPLib.GetProperty(p,"DATAREG",w_DATAREG,0);
      w_FLAGCONT = CPLib.GetProperty(p,"FLAGCONT",w_FLAGCONT,0);
      w_FLAGWALLET = CPLib.GetProperty(p,"FLAGWALLET",w_FLAGWALLET,0);
      w_TIPOOPRAP = CPLib.GetProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
      w_CODANA = CPLib.GetProperty(p,"CODANA",w_CODANA,0);
      w_CODVOC = CPLib.GetProperty(p,"CODVOC",w_CODVOC,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_CAMBIO = CPLib.GetProperty(p,"CAMBIO",w_CAMBIO,0);
      w_CONNESCLI = CPLib.GetProperty(p,"CONNESCLI",w_CONNESCLI,0);
      w_CONNESBEN = CPLib.GetProperty(p,"CONNESBEN",w_CONNESBEN,0);
      w_C_RAG = CPLib.GetProperty(p,"C_RAG",w_C_RAG,0);
      w_C_CTA = CPLib.GetProperty(p,"C_CTA",w_C_CTA,0);
      w_C_PRV = CPLib.GetProperty(p,"C_PRV",w_C_PRV,0);
      w_C_CAP = CPLib.GetProperty(p,"C_CAP",w_C_CAP,0);
      w_C_CAB = CPLib.GetProperty(p,"C_CAB",w_C_CAB,0);
      w_C_IND = CPLib.GetProperty(p,"C_IND",w_C_IND,0);
      w_C_STA = CPLib.GetProperty(p,"C_STA",w_C_STA,0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_SEGNO = CPLib.GetProperty(p,"SEGNO",w_SEGNO,0);
      w_FLAGFRAZ = CPLib.GetProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
      w_COLLEG = CPLib.GetProperty(p,"COLLEG",w_COLLEG,0);
      w_CACODICE = CPLib.GetProperty(p,"CACODICE",w_CACODICE,0);
      w_CAIDBIGLIETTO = CPLib.GetProperty(p,"CAIDBIGLIETTO",w_CAIDBIGLIETTO,0);
      w_CGOTIPOPE = CPLib.GetProperty(p,"CGOTIPOPE",w_CGOTIPOPE,0);
      w_NUMOPEDL = CPLib.GetProperty(p,"NUMOPEDL",w_NUMOPEDL,0);
      w_CAFLGOPE = CPLib.GetProperty(p,"CAFLGOPE",w_CAFLGOPE,0);
      w_CGODATCON = CPLib.GetProperty(p,"CGODATCON",w_CGODATCON,0);
      w_CGOESICON = CPLib.GetProperty(p,"CGOESICON",w_CGOESICON,0);
      w_CGONOTCON = CPLib.GetProperty(p,"CGONOTCON",w_CGONOTCON,0);
      w_IDDOCALL = CPLib.GetProperty(p,"IDDOCALL",w_IDDOCALL,0);
      w_FLGDOCALL = CPLib.GetProperty(p,"FLGDOCALL",w_FLGDOCALL,0);
      w_VLTPLAT = CPLib.GetProperty(p,"VLTPLAT",w_VLTPLAT,0);
      w_CCDATSCA = CPLib.GetProperty(p,"CCDATSCA",w_CCDATSCA,0);
      w_TIPODOC = CPLib.GetProperty(p,"TIPODOC",w_TIPODOC,0);
      w_NUMDOCUM = CPLib.GetProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_RDCODAUT = CPLib.GetProperty(p,"RDCODAUT",w_RDCODAUT,0);
      w_RDLOCAUT = CPLib.GetProperty(p,"RDLOCAUT",w_RDLOCAUT,0);
      w_AUTRILASC = CPLib.GetProperty(p,"AUTRILASC",w_AUTRILASC,0);
      w_PEPDESCRI = CPLib.GetProperty(p,"PEPDESCRI",w_PEPDESCRI,0);
      w_PAESE2 = CPLib.GetProperty(p,"PAESE2",w_PAESE2,0);
      w_DESCCIT2 = CPLib.GetProperty(p,"DESCCIT2",w_DESCCIT2,0);
      w_PROVINCIA2 = CPLib.GetProperty(p,"PROVINCIA2",w_PROVINCIA2,0);
      w_CAP2 = CPLib.GetProperty(p,"CAP2",w_CAP2,0);
      w_DOMICILIO2 = CPLib.GetProperty(p,"DOMICILIO2",w_DOMICILIO2,0);
      w_FLGDOM = CPLib.GetProperty(p,"FLGDOM",w_FLGDOM,0);
      w_PROFESSIONE = CPLib.GetProperty(p,"PROFESSIONE",w_PROFESSIONE,0);
      w_CODCABDIP = CPLib.GetProperty(p,"CODCABDIP",w_CODCABDIP,0);
      w_PROVINCIADIP = CPLib.GetProperty(p,"PROVINCIADIP",w_PROVINCIADIP,0);
      w_DESCCITDIP = CPLib.GetProperty(p,"DESCCITDIP",w_DESCCITDIP,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_xSOGTPGIO = CPLib.GetProperty(p,"xSOGTPGIO",w_xSOGTPGIO,0);
      w_xDEFTPGIO = CPLib.GetProperty(p,"xDEFTPGIO",w_xDEFTPGIO,0);
      w_xEDTTPGIO = CPLib.GetProperty(p,"xEDTTPGIO",w_xEDTTPGIO,0);
      w_xEDTSPGIO = CPLib.GetProperty(p,"xEDTSPGIO",w_xEDTSPGIO,0);
      w_xDEFSPGIO = CPLib.GetProperty(p,"xDEFSPGIO",w_xDEFSPGIO,0);
      w_FLGPAGAM = CPLib.GetProperty(p,"FLGPAGAM",w_FLGPAGAM,0);
      w_FILTROMP = CPLib.GetProperty(p,"FILTROMP",w_FILTROMP,0);
      w_idcitta = CPLib.GetProperty(p,"idcitta",w_idcitta,0);
      w_xARDESCRI = CPLib.GetProperty(p,"xARDESCRI",w_xARDESCRI,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_tipsot = CPLib.GetProperty(p,"tipsot",w_tipsot,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_gSeekAos = CPLib.GetProperty(p,"gSeekAos",w_gSeekAos,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_xDescDipe = CPLib.GetProperty(p,"xDescDipe",w_xDescDipe,0);
      w_datpaseuro = CPLib.GetProperty(p,"datpaseuro",w_datpaseuro,0);
      w_xdes1 = CPLib.GetProperty(p,"xdes1",w_xdes1,0);
      w_desccauana = CPLib.GetProperty(p,"desccauana",w_desccauana,0);
      w_CITINT = CPLib.GetProperty(p,"CITINT",w_CITINT,0);
      w_CITDIP = CPLib.GetProperty(p,"CITDIP",w_CITDIP,0);
      w_PROVDIP = CPLib.GetProperty(p,"PROVDIP",w_PROVDIP,0);
      w_CABDIP = CPLib.GetProperty(p,"CABDIP",w_CABDIP,0);
      w_PROVINT = CPLib.GetProperty(p,"PROVINT",w_PROVINT,0);
      w_CABINT = CPLib.GetProperty(p,"CABINT",w_CABINT,0);
      w_xdesccausin = CPLib.GetProperty(p,"xdesccausin",w_xdesccausin,0);
      w_gChkDate = CPLib.GetProperty(p,"gChkDate",w_gChkDate,0);
      w_xdesctipatt = CPLib.GetProperty(p,"xdesctipatt",w_xdesctipatt,0);
      w_gVLT = CPLib.GetProperty(p,"gVLT",w_gVLT,0);
      w_gVNP = CPLib.GetProperty(p,"gVNP",w_gVNP,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_verifica = CPLib.GetProperty(p,"verifica",w_verifica,0);
      w_gStpDwn = CPLib.GetProperty(p,"gStpDwn",w_gStpDwn,0);
      w_MIDBIGLIETTO = CPLib.GetProperty(p,"MIDBIGLIETTO",w_MIDBIGLIETTO,0);
      w_MIDBIGLIETTO1 = CPLib.GetProperty(p,"MIDBIGLIETTO1",w_MIDBIGLIETTO1,0);
      w_MIDBIGLIETTO2 = CPLib.GetProperty(p,"MIDBIGLIETTO2",w_MIDBIGLIETTO2,0);
      w_MIDBIGLIETTO3 = CPLib.GetProperty(p,"MIDBIGLIETTO3",w_MIDBIGLIETTO3,0);
      w_MIDBIGLIETTO4 = CPLib.GetProperty(p,"MIDBIGLIETTO4",w_MIDBIGLIETTO4,0);
      w_TELDIP = CPLib.GetProperty(p,"TELDIP",w_TELDIP,0);
      w_CODLOC = CPLib.GetProperty(p,"CODLOC",w_CODLOC,0);
      w_xFLGPLGIO = CPLib.GetProperty(p,"xFLGPLGIO",w_xFLGPLGIO,0);
      w_xVPFLGATT = CPLib.GetProperty(p,"xVPFLGATT",w_xVPFLGATT,0);
      w_DOC03 = CPLib.GetProperty(p,"DOC03",w_DOC03,0);
      w_DOC04 = CPLib.GetProperty(p,"DOC04",w_DOC04,0);
      w_tipop = CPLib.GetProperty(p,"tipop",w_tipop,0);
      w_gGesDoc = CPLib.GetProperty(p,"gGesDoc",w_gGesDoc,0);
      w_edtdoc = CPLib.GetProperty(p,"edtdoc",w_edtdoc,0);
      w_saveddoc = CPLib.GetProperty(p,"saveddoc",w_saveddoc,0);
      w_idcitta2 = CPLib.GetProperty(p,"idcitta2",w_idcitta2,0);
      w_dessta2 = CPLib.GetProperty(p,"dessta2",w_dessta2,0);
      w_FLGQADVFULL = CPLib.GetProperty(p,"FLGQADVFULL",w_FLGQADVFULL,0);
      w_gQADV = CPLib.GetProperty(p,"gQADV",w_gQADV,0);
      w_xCGOFLGPROF = CPLib.GetProperty(p,"xCGOFLGPROF",w_xCGOFLGPROF,0);
      w_ANA_FOUND = CPLib.GetProperty(p,"ANA_FOUND",w_ANA_FOUND,0);
      m_cWv_armt_cgo_qadv_operazioni = CPLib.GetProperty(p,"m_cWv_armt_cgo_qadv_operazioni",m_cWv_armt_cgo_qadv_operazioni,0);
      CPLib.SetFromContextMNTs(p,m_MNTs);
      SPExtenderLib.SetExtendedFromContext(p,extendedFields);
      m_bLoaded = CPLib.GetProperty(p,"m_bLoaded",false,0);
      m_bUpdated = CPLib.GetProperty(p,"m_bUpdated",false,0);
      m_cOldCPCCCHK = CPLib.GetProperty(p,"m_cOldCPCCCHK","",0);
      m_cPreviousState = CPLib.GetProperty(p,"m_cPrvsStt","",0);
      m_cPassword = CPLib.GetProperty(p,"m_cPwd","",0);
      m_cOTP = CPLib.GetProperty(p,"m_cOTP","",0);
      m_lCtxLoaded = true;
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
  }
  public String EntityStatus() {
    return (m_bLoaded?"E":"N");
  }
  public String LastErrorMessage() {
    return m_cLastMsgError;
  }
  static void GetLinkDef0(Map<String,List<Map<String,String[]>>> tables) {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","CAB","PROV","CAP"});
    map.put("rd_var",new String[]{"w_idcitta","w_CODCAB","w_PROVINCIA","w_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u00006\u00002\u00009",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice\u0000CAB\u0000Provincia\u0000CAP",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000w_PAESE='086' \u0000w_PAESE='086'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","PROV","CAP"});
    map.put("rd_var",new String[]{"w_idcitta2","w_PROVINCIA2","w_CAP2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u00002\u00009",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice\u0000Provincia\u0000CAP",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000w_PAESE='086' and w_FLGDOM='S'\u0000w_PAESE2='086' and w_FLGDOM='S'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_qadv_operazioni");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_qadv_operazioni",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SNAINUMOPE"});
    map.put("rd_var",new String[]{"w_SNAINUMOPE"});
    map.put("wr_var",new String[]{"w_SNAINUMOPE"});
    map.put("wr_field",new String[]{"SNAINUMOPE"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",new String[]{});
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",new String[]{});
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",new String[]{});
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",new String[]{});
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",new String[]{});
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",new String[]{});
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_qadv_operazioni\u0000false\u0000false\u00001\u00000\u0000armt_cgo_qadv_operazioni\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_tbtipgio");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_tbtipgio",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODTPGIO","SOGTPGIO","DEFTPGIO","EDTTPGIO","EDTSPGIO","DEFSPGIO","FLGPLGIO"});
    map.put("rd_var",new String[]{"w_TIPOGIOCO","w_xSOGTPGIO","w_xDEFTPGIO","w_xEDTTPGIO","w_xEDTSPGIO","w_xDEFSPGIO","w_xFLGPLGIO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000012\u00001\u00001\u00001\u00001\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00002\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo gioco\u0000Soglia pagamento Agenzia\u0000Default (A=Agenzia , S=SNAI)\u0000Abilita modifica Scelta\u0000Abilita Modifica Sotto Soglia\u0000Default Sotto Soglia\u0000Abilita Selezione Piattaforma",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_tbtipgio\u0000false\u0000false\u00001\u00000\u0000armt_cgo_tbtipgio\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CITTA","PROV"});
    map.put("rd_var",new String[]{"w_NASCOMUN","w_TIPINTER"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Luogo di Nascita\u0000Prov.",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("Empty(w_NASSTATO)\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"DESCRI"});
    map.put("rd_var",new String[]{"w_NASSTATO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato di nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("Empty(w_NASCOMUN)",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_PAESE","w_dessta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_PAESE"});
    map.put("rd_kfield",new String[]{"PKTBSTATI"});
    map.put("rd_field",new String[]{"CITTA","IDBASE"});
    map.put("rd_var",new String[]{"w_DESCCIT","w_idcitta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("40\u000010",-1));
    map.put("rd_kvar.len",zeroSplit.split("3",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Città\u0000Codice",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Stato",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("w_PAESE='086' \u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipatt");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipatt",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI"});
    map.put("rd_var",new String[]{"w_ATTIV","w_xdesctipatt"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u0000250",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Attività Prevalente\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipatt\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Prevalente Attività\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipreg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipreg",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DES1"});
    map.put("rd_var",new String[]{"w_TIPOOPRAP","w_xdes1"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000090",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Operazione Completa\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipreg\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Registrazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODCAU"});
    map.put("rd_var",new String[]{"w_CODANA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Analitica",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Analitiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_CODANA"});
    map.put("rd_kfield",new String[]{"CODCAU"});
    map.put("rd_field",new String[]{"CAUSINT","SEGNO","DESCRI"});
    map.put("rd_var",new String[]{"w_CODVOC","w_SEGNO","w_desccauana"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u00001\u0000165",-1));
    map.put("rd_kvar.len",zeroSplit.split("4",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Causale Sintetica\u0000Segno\u0000Descrizione",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Causale Analitica",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Sintetiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC","DOMICILIO","DESCCIT","PROVINCIA","PAESE","CAP"});
    map.put("rd_var",new String[]{"w_CONNESBEN","w_C_RAG","w_C_IND","w_C_CTA","w_C_PRV","w_C_STA","w_C_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u000035\u000030\u00002\u00003\u00005",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Cliente Occasionale\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Clienti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CITTA","CAB","PROV","PKTBSTATI","CAP"});
    map.put("rd_var",new String[]{"w_C_CTA","w_C_CAB","w_C_PRV","w_C_STA","w_C_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u00006\u00002\u00003\u00005",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("intermbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("intermbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","DATANASC","CODCAB","PROVINCIA","DESCCIT","CGOFLGPROF"});
    map.put("rd_var",new String[]{"w_CODINTER","w_datpaseuro","w_CABINT","w_PROVINT","w_CITINT","w_xCGOFLGPROF"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000D\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u00008\u00006\u00002\u000030\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Intermediario\u0000Data Passaggio EURO\u0000CAB\u0000Provincia\u0000Città\u0000Flag Richiesta Professione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("intermbo\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("operazbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("operazbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"NUMPROG"});
    map.put("rd_var",new String[]{"w_COLLEG"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Collegamento Operazione Multiple",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("operazbo\u0000false\u0000false\u00001\u00000\u0000armt_operazioni\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_causali");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_causali",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CACODICE","CAFLGOPE"});
    map.put("rd_var",new String[]{"w_CACODICE","w_CAFLGOPE"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("N\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale\u0000Tipo Registrazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_causali\u0000false\u0000false\u00001\u00000\u0000armt_cgo_causali\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_tipdoc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_tipdoc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TIPDOC","DESCRI"});
    map.put("rd_var",new String[]{"w_TIPODOC","w_DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Documento\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_tipdoc\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Documento\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_autorita");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_autorita",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"ARCODICE","ARDESCRI"});
    map.put("rd_var",new String[]{"w_RDCODAUT","w_xARDESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000015",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Autorità Rilascio\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_autorita\u0000false\u0000false\u00001\u00000\u0000armt_cgo_autorita\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_PAESE2","w_dessta2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato Domicilio\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("w_FLGDOM='S'\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_PAESE"});
    map.put("rd_kfield",new String[]{"PKTBSTATI"});
    map.put("rd_field",new String[]{"CITTA","IDBASE"});
    map.put("rd_var",new String[]{"w_DESCCIT2","w_idcitta2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("40\u000010",-1));
    map.put("rd_kvar.len",zeroSplit.split("3",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Città Domicilio\u0000Codice",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Stato",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("w_PAESE2='086' and w_FLGDOM='S'\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ","DESCCIT","PROVINCIA","CAB","TELEFONO","CODLOC"});
    map.put("rd_var",new String[]{"w_CODDIPE","w_xDescDipe","w_CITDIP","w_PROVDIP","w_CABDIP","w_TELDIP","w_CODLOC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030\u000030\u00002\u00006\u000015\u000025",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Dipendenza\u0000Descrizione\u0000Città\u0000Provincia\u0000CAB\u0000Telefono\u0000Codice Locale (CGO)",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Dipendenze\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_snai_oper",false)) {
      map = new HashMap<String,String[]>();
      items = tables.get(com.zucchetti.sitepainter.Library.getEntityTables(child)[0]);
      if (CPLib.IsNull(items)) {
        items = new ArrayList<Map<String,String[]>>();
        tables.put(com.zucchetti.sitepainter.Library.getEntityTables(child)[0],items);
      }
      map.put("link_PC",new String[]{});
      map.put("rd_kvar",new String[]{});
      map.put("rd_kfield",new String[]{});
      map.put("rd_field",new String[]{});
      map.put("rd_var",new String[]{});
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_snai_oper",child);
      // Informazione usata per risolvere la sintassi BO->tabella nelle VQR
      map.put("rd_var",definitions[0]);
      map.put("rd_field",definitions[1]);
      // Definizione delle coppie padre/figlio
      map.put("wr_var",definitions[0]);
      map.put("wr_field",definitions[1]);
      map.put("wr_op",new String[]{});
      map.put("rd_var.obj_type",new String[]{});
      map.put("rd_var.len",new String[]{});
      map.put("rd_var.dec",new String[]{});
      map.put("rd_var.comment",new String[]{});
      map.put("property.name",new String[]{"arch","foundling","","","","prg_zoom"});
      map.put("property.value",new String[]{com.zucchetti.sitepainter.Library.getEntityTables(child)[0],"true","","","",child});
      items.add(map);
    }
    return tables;
  }
  public void Initialize() {
    // Inizializzazione delle variabili di work
    Blank();
    // Inizializzazione delle variabili di progressivo e legate alle operazioni a saldo
    BlankAutonumberAndTransactionVars();
    armt_cgo_qadv_operazioni = new armt_cgo_qadv_operazioniBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_snai_oper",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.Empty(w_CGOFLGVNP)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CGOFLGVNP));
      String obblMsgError = m_Ctx.Translate("Pagamento Vincite prenotate")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CGOFLGVNP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CGOFLGVNP";
      }
    } else if ((CPLib.eq(w_FLAGCONT,"1") &&  ! (CPLib.Empty(w_DATAOPE))) && ((CPLib.Empty(w_TOTCONT) && HUDOCMLKKT_isObligatory()) || ( ! (arfn_chktotalelire_contR.Make(m_Ctx,this).Run(w_DATAOPE,w_datpaseuro,w_TOTCONT,w_TOTLIRE))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TOTCONT));
      String obblMsgError = m_Ctx.Translate("di cui contanti")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("di cui contanti")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_TOTCONT = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TOTCONT";
      }
    } else if ((CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE))) && ((CPLib.Empty(w_IMPWALLET) && BELMGUMGMW_isObligatory()) || ( ! (CPLib.le(w_IMPWALLET,(w_TOTLIRE-w_TOTCONT)))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_IMPWALLET));
      String obblMsgError = m_Ctx.Translate("IMporto")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("L'importo non può superare la differenza tra importo totale e importo contanti");
      } else {
        m_cLastMsgError = m_Ctx.Translate("L'importo non può superare la differenza tra importo totale e importo contanti");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_IMPWALLET = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "IMPWALLET";
      }
    } else if ((CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE))) && (CPLib.Empty(w_CODWALLET) && LQVQUGYYJF_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODWALLET));
      String obblMsgError = m_Ctx.Translate("WALLET")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODWALLET = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODWALLET";
      }
    } else if ((CPLib.eq(w_FLAGWALLET,"1") &&  ! (CPLib.Empty(w_DATAOPE))) && (CPLib.Empty(w_CODTRANSZ) && YYELCZIDWS_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODTRANSZ));
      String obblMsgError = m_Ctx.Translate("Transazione ID Wallet")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODTRANSZ = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODTRANSZ";
      }
    } else if (((CPLib.eq(w_xEDTTPGIO,"S") && CPLib.ge(w_TOTLIRE,w_xSOGTPGIO)) || (CPLib.eq(w_xEDTSPGIO,"S") && CPLib.lt(w_TOTLIRE,w_xSOGTPGIO))) && (CPLib.Empty(w_CGOFLGVLT))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CGOFLGVLT));
      String obblMsgError = m_Ctx.Translate("Pagamento")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CGOFLGVLT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CGOFLGVLT";
      }
    } else if ((CPLib.gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0)) && (CPLib.Empty(w_MEZPAGAM) && EOSKLIUGBC_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_MEZPAGAM));
      String obblMsgError = m_Ctx.Translate("Mezzo Pagamento")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_MEZPAGAM = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "MEZPAGAM";
      }
    } else if ((CPLib.Empty(w_CC4CIFRE) && FKEAKFSYVU_isObligatory()) || ( ! (arfn_cgo_chkccR.Make(m_Ctx,this).Run(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,1,w_MEZPAGAM)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CC4CIFRE));
      String obblMsgError = m_Ctx.Translate("Ultime Cifre CC ()")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("Ultime Cifre CC ()")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_CC4CIFRE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CC4CIFRE";
      }
    } else if (CPLib.Empty(w_CCMESSCA) && MFCMVHMGSB_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CCMESSCA));
      String obblMsgError = m_Ctx.Translate("Mese Scadenza")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CCMESSCA = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CCMESSCA";
      }
    } else if ((CPLib.Empty(w_CCANNSCA) && YZHCHEDWZM_isObligatory()) || ( ! (arfn_cgo_chkccR.Make(m_Ctx,this).Run(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,2,w_MEZPAGAM)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CCANNSCA));
      String obblMsgError = m_Ctx.Translate("Carta Di Credito Scadenza")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("Carta Di Credito Scadenza")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_CCANNSCA = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CCANNSCA";
      }
    } else if ((CPLib.Empty(w_IBAN) && UTUCDPQJKK_isObligatory()) || ( ! (arfn_chkibanR.Make(m_Ctx,this).Run(CPLib.Upper(w_IBAN),w_MEZPAGAM)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_IBAN));
      String obblMsgError = m_Ctx.Translate("IBAN per Bonifici")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("IBAN per Bonifici")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_IBAN = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "IBAN";
      }
    } else if (CPLib.Empty(w_ASSEGNO) && KZWBLPQNHU_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_ASSEGNO));
      String obblMsgError = m_Ctx.Translate("Assegno")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_ASSEGNO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "ASSEGNO";
      }
    } else if (CPLib.Empty(w_PEP)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PEP));
      String obblMsgError = m_Ctx.Translate("Persona Politicamente Esposta")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PEP = "N";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PEP";
      }
    } else if ((CPLib.Empty(w_CODFISC) && OJJHIUDPFY_isObligatory()) || ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,"086",w_CFESTERO)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODFISC));
      String obblMsgError = m_Ctx.Translate("Codice Fiscale")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("Codice Fiscale Errato nel formato");
      } else {
        m_cLastMsgError = m_Ctx.Translate("Codice Fiscale Errato nel formato");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_CODFISC = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODFISC";
      }
    } else if (CPLib.Empty(w_COGNOME)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_COGNOME));
      String obblMsgError = m_Ctx.Translate("Cognome")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_COGNOME = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "COGNOME";
      }
    } else if (CPLib.Empty(w_NOME)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_NOME));
      String obblMsgError = m_Ctx.Translate("Nome")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_NOME = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "NOME";
      }
    } else if (CPLib.Empty(w_NASCOMUN) && NEUBQNUEOJ_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_NASCOMUN));
      String obblMsgError = m_Ctx.Translate("Luogo di Nascita")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_NASCOMUN = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "NASCOMUN";
      }
    } else if (CPLib.Empty(w_TIPINTER)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPINTER));
      String obblMsgError = m_Ctx.Translate("Prov.")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPINTER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPINTER";
      }
    } else if (CPLib.Empty(w_SESSO)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SESSO));
      String obblMsgError = m_Ctx.Translate("Sesso")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SESSO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SESSO";
      }
    } else if (CPLib.Empty(w_NASSTATO) && HODZKKOSYW_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_NASSTATO));
      String obblMsgError = m_Ctx.Translate("Stato di nascita")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_NASSTATO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "NASSTATO";
      }
    } else if ((CPLib.Empty(w_DATANASC)) || ( ! (arfn_maggiorenneR.Make(m_Ctx,this).Run(w_DATANASC,w_DATAOPE)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATANASC));
      String obblMsgError = m_Ctx.Translate("Data Nascita")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("Data Nascita")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATANASC = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATANASC";
      }
    } else if ((CPLib.Empty(w_PAESE)) || ( ! (CPLib.Empty(w_PAESE)) &&  ! ((CPLib.eq(w_CFESTERO,1) && CPLib.eq(w_PAESE,"086")?false:(CPLib.eq(w_CFESTERO,0) && CPLib.ne(w_PAESE,"086")?false:true))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PAESE));
      String obblMsgError = m_Ctx.Translate("Stato")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("Il paese di residenza deve essere congruente con il flag di soggetto estero!");
      } else {
        m_cLastMsgError = m_Ctx.Translate("Il paese di residenza deve essere congruente con il flag di soggetto estero!");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_PAESE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PAESE";
      }
    } else if ((CPLib.eq(w_PAESE,"086")) && (CPLib.Empty(w_DESCCIT) && ODAYKSRECA_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DESCCIT));
      String obblMsgError = m_Ctx.Translate("Città")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DESCCIT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DESCCIT";
      }
    } else if ((CPLib.eq(w_PAESE,"086")) && (CPLib.Empty(w_PROVINCIA) && NOTZPDMYIA_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROVINCIA));
      String obblMsgError = m_Ctx.Translate("Provincia")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROVINCIA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROVINCIA";
      }
    } else if ((CPLib.eq(w_PAESE,"086")) && (CPLib.Empty(w_CAP) && RDAVOEETJG_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CAP));
      String obblMsgError = m_Ctx.Translate("CAP")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CAP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CAP";
      }
    } else if ((CPLib.eq(w_PAESE,"086")) && (CPLib.Empty(w_DOMICILIO) && VYLHWTRQNX_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DOMICILIO));
      String obblMsgError = m_Ctx.Translate("Indirizzo")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DOMICILIO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DOMICILIO";
      }
    } else if (CPLib.Empty(w_FLAGWALLET)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_FLAGWALLET));
      String obblMsgError = m_Ctx.Translate("Flag Wallet")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_FLAGWALLET = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "FLAGWALLET";
      }
    } else if (CPLib.Empty(w_TIPODOC)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPODOC));
      String obblMsgError = m_Ctx.Translate("Tipo Documento")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPODOC = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPODOC";
      }
    } else if (CPLib.Empty(w_NUMDOCUM)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_NUMDOCUM));
      String obblMsgError = m_Ctx.Translate("Numero Doc.")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_NUMDOCUM = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "NUMDOCUM";
      }
    } else if ((CPLib.Empty(w_DATARILASC)) || ( ! (arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_DATARILASC,w_TIPODOC,"R",w_DATAOPE)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATARILASC));
      String obblMsgError = m_Ctx.Translate("Rilascio Doc.")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("Rilascio Doc.")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATARILASC = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATARILASC";
      }
    } else if ((CPLib.Empty(w_DATAVALI)) || ( ! (arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_DATAVALI,w_TIPODOC,"S",w_DATAOPE)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAVALI));
      String obblMsgError = m_Ctx.Translate("Data Fine Validità")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("Data Fine Validità")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATAVALI = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAVALI";
      }
    } else if ((CPLib.Empty(w_RDCODAUT)) || ( ! (CPLib.Empty(w_RDCODAUT)) &&  ! (arfn_chk_docautR.Make(m_Ctx,this).Run(w_RDCODAUT,w_TIPODOC)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_RDCODAUT));
      String obblMsgError = m_Ctx.Translate("Autorità Rilascio")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("Autorità non valida per il tipo documento selezionato");
      } else {
        m_cLastMsgError = m_Ctx.Translate("Autorità non valida per il tipo documento selezionato");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_RDCODAUT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "RDCODAUT";
      }
    } else if (CPLib.Empty(w_RDLOCAUT)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_RDLOCAUT));
      String obblMsgError = m_Ctx.Translate("Luogo Autorità Rilascio")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_RDLOCAUT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "RDLOCAUT";
      }
    } else if (CPLib.Empty(w_AUTRILASC)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_AUTRILASC));
      String obblMsgError = m_Ctx.Translate("Autorità di rilascio")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_AUTRILASC = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "AUTRILASC";
      }
    } else if ((CPLib.eq(w_PEP,"S")) && (CPLib.Empty(w_PEPDESCRI) && DAEHHCRYAM_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PEPDESCRI));
      String obblMsgError = m_Ctx.Translate("Descrizione PEP")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PEPDESCRI = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PEPDESCRI";
      }
    } else if ((CPLib.eq(w_FLGDOM,"S")) && (CPLib.Empty(w_PAESE2) && UOOQYQWWNG_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PAESE2));
      String obblMsgError = m_Ctx.Translate("Stato Domicilio")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PAESE2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PAESE2";
      }
    } else if ((CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S")) && (CPLib.Empty(w_DESCCIT2) && BVEIQEJCLQ_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DESCCIT2));
      String obblMsgError = m_Ctx.Translate("Città Domicilio")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DESCCIT2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DESCCIT2";
      }
    } else if ((CPLib.eq(w_PAESE,"086") && CPLib.eq(w_FLGDOM,"S")) && (CPLib.Empty(w_PROVINCIA2) && NKJDWBKDWM_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROVINCIA2));
      String obblMsgError = m_Ctx.Translate("Provincia")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROVINCIA2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROVINCIA2";
      }
    } else if ((CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S")) && (CPLib.Empty(w_CAP2) && MDTHUZMSSI_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CAP2));
      String obblMsgError = m_Ctx.Translate("CAP")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CAP2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CAP2";
      }
    } else if ((CPLib.eq(w_PAESE2,"086") && CPLib.eq(w_FLGDOM,"S")) && (CPLib.Empty(w_DOMICILIO2) && CWOLOHZAQW_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DOMICILIO2));
      String obblMsgError = m_Ctx.Translate("Indirizzo Domicilio")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DOMICILIO2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DOMICILIO2";
      }
    } else if (CPLib.Empty(w_PROFESSIONE) && XFPPPEOSWP_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROFESSIONE));
      String obblMsgError = m_Ctx.Translate("Professione")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROFESSIONE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROFESSIONE";
      }
    } else if ( ! (Check_NXWIUCGNDI(true))) {
      l_bResult = false;
    } else if ( ! (Check_YHNSLBLWFP(true))) {
      l_bResult = false;
    } else if ( ! (Check_QNEKQYKSHZ(true))) {
      l_bResult = false;
    }
    if (l_bResult && (( ! (armt_cgo_qadv_operazioni.m_bLoaded) && CPLib.IsLoaded(m_cWv_armt_cgo_qadv_operazioni)) || ( ! (armt_cgo_qadv_operazioni.m_bUpdated) && CPLib.IsUpdated(m_cWv_armt_cgo_qadv_operazioni)))) {
      armt_cgo_qadv_operazioni.SetFromContext(m_cWv_armt_cgo_qadv_operazioni);
      m_cWv_armt_cgo_qadv_operazioni = "_not_empty_";
    }
    if (l_bResult && (armt_cgo_qadv_operazioni.m_bLoaded || armt_cgo_qadv_operazioni.m_bUpdated)) {
      l_bResult = l_bResult && armt_cgo_qadv_operazioni.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = armt_cgo_qadv_operazioni.m_cLastMsgError;
      }
    }
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
    } else if ( ! (l_bNoCheck)) {
      m_nLastError = 2;
    }
    return l_bResult;
  }
  void ResetErrorMessage() {
    m_nLastError = 0;
    m_cLastMsgError = "";
    m_cLastWorkVarError = "";
  }
  public String GetCurrentState() {
    String l_bResult;
    l_bResult = CPSecurity.UNKNOWN_STATE;
    return l_bResult;
  }
  /** @deprecated Will be removed in a future version **/
  @Deprecated
  public String GetStateSecurityKey(String p_cState) {
    return GetStateSecurityKeyRoles(p_cState)[0];
  }
  public String[] GetStateSecurityKeyRoles(String p_cState) {
    String[] l_Keys = {};
    if (CPLib.eq(p_cState,CPSecurity.UNKNOWN_STATE)) {
      l_Keys = new String[]{"armt_snai_oper"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_snai_oper\\"+p_cState};
    }
    return l_Keys;
  }
  public boolean CanView() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = CPLib.eq(w_gCodDip,w_CODDIPE);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile visualizzare una operazione di un'altra agenzia";
    }
    l_bResult = l_bResult && BRCanView();
    if ( ! (l_bResult)) {
      String o_cLastMsgError = m_cLastMsgError;
      Blank();
      // Evita che un errore segnalato alla Blank, ad esempio link fallito, sovrascriva l'errore di accesso bloccato
      m_cLastMsgError = o_cLastMsgError;
    }
    return l_bResult;
  }
  public boolean CanEdit() {
    return CanEdit(GetCurrentState());
  }
  public boolean CanEdit(String p_cState) {
    boolean l_bResult = true;
    ResetErrorMessage();
    l_bResult = CPLib.ne(p_cState,GetCurrentState()) || (CPLib.eq(w_gCodDip,w_CODDIPE));
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile modificare una operazione di un'altra agenzia";
    }
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = CPLib.eq(w_gCodDip,w_CODDIPE);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile cancellare una operazione di un'altra agenzia";
    }
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  public boolean CanAdd() {
    return CanAdd(GetCurrentState());
  }
  public boolean CanAdd(String p_cState) {
    boolean l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_TIPOGIOCO = "";
    o_TOTLIRE = 0;
    o_TOTCONT = 0;
    o_IMPWALLET = 0;
    o_CGOFLGVLT = "";
    o_MEZPAGAM = "";
    o_FLGPAGAM = "";
    o_FILTROMP = "";
    o_CODFISC = "";
    o_COGNOME = "";
    o_NOME = "";
    o_NASCOMUN = "";
    o_TIPINTER = "";
    o_NASSTATO = "";
    o_PAESE = "";
    o_idcitta = "";
    o_ATTIV = "";
    o_SOTGRUP = "";
    o_DATAOPE = CPLib.NullDate();
    o_FLAGCONT = "";
    o_FLAGWALLET = "";
    o_TIPOOPRAP = "";
    o_CODANA = "";
    o_CODVOC = "";
    o_CONNESBEN = "";
    o_C_CTA = "";
    o_CODINTER = "";
    o_COLLEG = "";
    o_CACODICE = 0;
    o_DATARILASC = CPLib.NullDate();
    o_DATAVALI = CPLib.NullDate();
    o_RDCODAUT = "";
    o_RDLOCAUT = "";
    o_PAESE2 = "";
    o_idcitta2 = "";
    o_CODDIPE = "";
    // Inizializzazione delle variabili per la gestione dello storno delle operazioni di saldo
  }
  public String GetContext() {
    return GetContext(true);
  }
  public String GetContext(boolean p_bGetChildren) {
    Properties p;
    p = new Properties();
    GetContext(p_bGetChildren,p);
    return CPLib.ToProperties(p);
  }
  public void GetContext(java.util.Properties p_oProperties) {
    GetContext(true,p_oProperties);
  }
  public void GetContext(boolean p_bGetChildren,java.util.Properties p) {
    CPLib.PutProperty(p,"TIPOGIOCO",w_TIPOGIOCO,0);
    CPLib.PutProperty(p,"TIPOPERS",w_TIPOPERS,0);
    CPLib.PutProperty(p,"CGOFLGVNP",w_CGOFLGVNP,0);
    CPLib.PutProperty(p,"TOTLIRE",w_TOTLIRE,0);
    CPLib.PutProperty(p,"TOTCONT",w_TOTCONT,0);
    CPLib.PutProperty(p,"IMPWALLET",w_IMPWALLET,0);
    CPLib.PutProperty(p,"CODWALLET",w_CODWALLET,0);
    CPLib.PutProperty(p,"CODTRANSZ",w_CODTRANSZ,0);
    CPLib.PutProperty(p,"CGOFLGVLT",w_CGOFLGVLT,0);
    CPLib.PutProperty(p,"MEZPAGAM",w_MEZPAGAM,0);
    CPLib.PutProperty(p,"CC4CIFRE",w_CC4CIFRE,0);
    CPLib.PutProperty(p,"CCMESSCA",w_CCMESSCA,0);
    CPLib.PutProperty(p,"CCANNSCA",w_CCANNSCA,0);
    CPLib.PutProperty(p,"IBAN",w_IBAN,0);
    CPLib.PutProperty(p,"ASSEGNO",w_ASSEGNO,0);
    CPLib.PutProperty(p,"CFESTERO",w_CFESTERO,0);
    CPLib.PutProperty(p,"PEP",w_PEP,0);
    CPLib.PutProperty(p,"CODFISC",w_CODFISC,0);
    CPLib.PutProperty(p,"COGNOME",w_COGNOME,0);
    CPLib.PutProperty(p,"NOME",w_NOME,0);
    CPLib.PutProperty(p,"NASCOMUN",w_NASCOMUN,0);
    CPLib.PutProperty(p,"TIPINTER",w_TIPINTER,0);
    CPLib.PutProperty(p,"SESSO",w_SESSO,0);
    CPLib.PutProperty(p,"NASSTATO",w_NASSTATO,0);
    CPLib.PutProperty(p,"DATANASC",w_DATANASC,0);
    CPLib.PutProperty(p,"PAESE",w_PAESE,0);
    CPLib.PutProperty(p,"RAGSOC",w_RAGSOC,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CAP",w_CAP,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"DOMICILIO",w_DOMICILIO,0);
    CPLib.PutProperty(p,"NUMTEL",w_NUMTEL,0);
    CPLib.PutProperty(p,"ATTIV",w_ATTIV,0);
    CPLib.PutProperty(p,"SOTGRUP",w_SOTGRUP,0);
    CPLib.PutProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
    CPLib.PutProperty(p,"SETTSINT",w_SETTSINT,0);
    CPLib.PutProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
    CPLib.PutProperty(p,"DATAOPE",w_DATAOPE,0);
    CPLib.PutProperty(p,"DATAREG",w_DATAREG,0);
    CPLib.PutProperty(p,"FLAGCONT",w_FLAGCONT,0);
    CPLib.PutProperty(p,"FLAGWALLET",w_FLAGWALLET,0);
    CPLib.PutProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
    CPLib.PutProperty(p,"CODANA",w_CODANA,0);
    CPLib.PutProperty(p,"CODVOC",w_CODVOC,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"CAMBIO",w_CAMBIO,0);
    CPLib.PutProperty(p,"CONNESCLI",w_CONNESCLI,0);
    CPLib.PutProperty(p,"CONNESBEN",w_CONNESBEN,0);
    CPLib.PutProperty(p,"C_RAG",w_C_RAG,0);
    CPLib.PutProperty(p,"C_CTA",w_C_CTA,0);
    CPLib.PutProperty(p,"C_PRV",w_C_PRV,0);
    CPLib.PutProperty(p,"C_CAP",w_C_CAP,0);
    CPLib.PutProperty(p,"C_CAB",w_C_CAB,0);
    CPLib.PutProperty(p,"C_IND",w_C_IND,0);
    CPLib.PutProperty(p,"C_STA",w_C_STA,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"SEGNO",w_SEGNO,0);
    CPLib.PutProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
    CPLib.PutProperty(p,"COLLEG",w_COLLEG,0);
    CPLib.PutProperty(p,"CACODICE",w_CACODICE,0);
    CPLib.PutProperty(p,"CAIDBIGLIETTO",w_CAIDBIGLIETTO,0);
    CPLib.PutProperty(p,"CGOTIPOPE",w_CGOTIPOPE,0);
    CPLib.PutProperty(p,"NUMOPEDL",w_NUMOPEDL,0);
    CPLib.PutProperty(p,"CAFLGOPE",w_CAFLGOPE,0);
    CPLib.PutProperty(p,"CGODATCON",w_CGODATCON,0);
    CPLib.PutProperty(p,"CGOESICON",w_CGOESICON,0);
    CPLib.PutProperty(p,"CGONOTCON",w_CGONOTCON,0);
    CPLib.PutProperty(p,"IDDOCALL",w_IDDOCALL,0);
    CPLib.PutProperty(p,"FLGDOCALL",w_FLGDOCALL,0);
    CPLib.PutProperty(p,"VLTPLAT",w_VLTPLAT,0);
    CPLib.PutProperty(p,"CCDATSCA",w_CCDATSCA,0);
    CPLib.PutProperty(p,"TIPODOC",w_TIPODOC,0);
    CPLib.PutProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"RDCODAUT",w_RDCODAUT,0);
    CPLib.PutProperty(p,"RDLOCAUT",w_RDLOCAUT,0);
    CPLib.PutProperty(p,"AUTRILASC",w_AUTRILASC,0);
    CPLib.PutProperty(p,"PEPDESCRI",w_PEPDESCRI,0);
    CPLib.PutProperty(p,"PAESE2",w_PAESE2,0);
    CPLib.PutProperty(p,"DESCCIT2",w_DESCCIT2,0);
    CPLib.PutProperty(p,"PROVINCIA2",w_PROVINCIA2,0);
    CPLib.PutProperty(p,"CAP2",w_CAP2,0);
    CPLib.PutProperty(p,"DOMICILIO2",w_DOMICILIO2,0);
    CPLib.PutProperty(p,"FLGDOM",w_FLGDOM,0);
    CPLib.PutProperty(p,"PROFESSIONE",w_PROFESSIONE,0);
    CPLib.PutProperty(p,"CODCABDIP",w_CODCABDIP,0);
    CPLib.PutProperty(p,"PROVINCIADIP",w_PROVINCIADIP,0);
    CPLib.PutProperty(p,"DESCCITDIP",w_DESCCITDIP,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"xSOGTPGIO",w_xSOGTPGIO,0);
    CPLib.PutProperty(p,"xDEFTPGIO",w_xDEFTPGIO,0);
    CPLib.PutProperty(p,"xEDTTPGIO",w_xEDTTPGIO,0);
    CPLib.PutProperty(p,"xEDTSPGIO",w_xEDTSPGIO,0);
    CPLib.PutProperty(p,"xDEFSPGIO",w_xDEFSPGIO,0);
    CPLib.PutProperty(p,"FLGPAGAM",w_FLGPAGAM,0);
    CPLib.PutProperty(p,"FILTROMP",w_FILTROMP,0);
    CPLib.PutProperty(p,"idcitta",w_idcitta,0);
    CPLib.PutProperty(p,"xARDESCRI",w_xARDESCRI,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"tipsot",w_tipsot,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"gSeekAos",w_gSeekAos,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"xDescDipe",w_xDescDipe,0);
    CPLib.PutProperty(p,"datpaseuro",w_datpaseuro,0);
    CPLib.PutProperty(p,"xdes1",w_xdes1,0);
    CPLib.PutProperty(p,"desccauana",w_desccauana,0);
    CPLib.PutProperty(p,"CITINT",w_CITINT,0);
    CPLib.PutProperty(p,"CITDIP",w_CITDIP,0);
    CPLib.PutProperty(p,"PROVDIP",w_PROVDIP,0);
    CPLib.PutProperty(p,"CABDIP",w_CABDIP,0);
    CPLib.PutProperty(p,"PROVINT",w_PROVINT,0);
    CPLib.PutProperty(p,"CABINT",w_CABINT,0);
    CPLib.PutProperty(p,"xdesccausin",w_xdesccausin,0);
    CPLib.PutProperty(p,"gChkDate",w_gChkDate,0);
    CPLib.PutProperty(p,"xdesctipatt",w_xdesctipatt,0);
    CPLib.PutProperty(p,"gVLT",w_gVLT,0);
    CPLib.PutProperty(p,"gVNP",w_gVNP,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"verifica",w_verifica,0);
    CPLib.PutProperty(p,"gStpDwn",w_gStpDwn,0);
    CPLib.PutProperty(p,"MIDBIGLIETTO",w_MIDBIGLIETTO,0);
    CPLib.PutProperty(p,"MIDBIGLIETTO1",w_MIDBIGLIETTO1,0);
    CPLib.PutProperty(p,"MIDBIGLIETTO2",w_MIDBIGLIETTO2,0);
    CPLib.PutProperty(p,"MIDBIGLIETTO3",w_MIDBIGLIETTO3,0);
    CPLib.PutProperty(p,"MIDBIGLIETTO4",w_MIDBIGLIETTO4,0);
    CPLib.PutProperty(p,"TELDIP",w_TELDIP,0);
    CPLib.PutProperty(p,"CODLOC",w_CODLOC,0);
    CPLib.PutProperty(p,"xFLGPLGIO",w_xFLGPLGIO,0);
    CPLib.PutProperty(p,"xVPFLGATT",w_xVPFLGATT,0);
    CPLib.PutProperty(p,"DOC03",w_DOC03,0);
    CPLib.PutProperty(p,"DOC04",w_DOC04,0);
    CPLib.PutProperty(p,"tipop",w_tipop,0);
    CPLib.PutProperty(p,"gGesDoc",w_gGesDoc,0);
    CPLib.PutProperty(p,"edtdoc",w_edtdoc,0);
    CPLib.PutProperty(p,"saveddoc",w_saveddoc,0);
    CPLib.PutProperty(p,"idcitta2",w_idcitta2,0);
    CPLib.PutProperty(p,"dessta2",w_dessta2,0);
    CPLib.PutProperty(p,"FLGQADVFULL",w_FLGQADVFULL,0);
    CPLib.PutProperty(p,"gQADV",w_gQADV,0);
    CPLib.PutProperty(p,"xCGOFLGPROF",w_xCGOFLGPROF,0);
    CPLib.PutProperty(p,"ANA_FOUND",w_ANA_FOUND,0);
    if (p_bGetChildren) {
      if (armt_cgo_qadv_operazioni.IsUpdated()) {
        m_cWv_armt_cgo_qadv_operazioni = armt_cgo_qadv_operazioni.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_armt_cgo_qadv_operazioni",m_cWv_armt_cgo_qadv_operazioni,0);
    }
    if (p_bGetChildren) {
      CPLib.PutProperty(p,m_MNTs);
    }
    SPExtenderLib.PutExtendedProperies(p,extendedFields);
    CPLib.PutProperty(p,"m_bLoaded",m_bLoaded);
    CPLib.PutProperty(p,"m_bUpdated",m_bUpdated);
    CPLib.PutProperty(p,"m_cOldCPCCCHK",m_cOldCPCCCHK);
    CPLib.PutProperty(p,"m_cPrvsStt",m_cPreviousState);
  }
  public String i_PrimaryKey() {
    return PrimaryKey(this);
  }
  public static String PrimaryKey(Caller p_Caller) {
    return "cgo_operazioni"+"\\"+CPLib.ToCPStr(p_Caller.GetString("SNAINUMOPE","C",15,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    return autonums;
  }
  public boolean ChildExists_armt_cgo_qadv_operazioni() {
    if (armt_cgo_qadv_operazioni.IsUpdated() || (CPLib.IsUpdated(m_cWv_armt_cgo_qadv_operazioni) || CPLib.IsLoaded(m_cWv_armt_cgo_qadv_operazioni))) {
      return true;
    } else if (m_bLoaded &&  ! (armt_cgo_qadv_operazioni.m_bLoaded)) {
      armt_cgo_qadv_operazioni.Blank();
      armt_cgo_qadv_operazioni.w_SNAINUMOPE = w_SNAINUMOPE;
      armt_cgo_qadv_operazioni.Load();
    }
    return armt_cgo_qadv_operazioni.m_bLoaded;
  }
  public void CtxLoad_armt_cgo_qadv_operazioni() {
    if ( ! (armt_cgo_qadv_operazioni.m_lCtxLoaded)) {
      armt_cgo_qadv_operazioni.Blank();
    }
    armt_cgo_qadv_operazioni.m_lCtxLoaded = true;
    if ( ! (armt_cgo_qadv_operazioni.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_armt_cgo_qadv_operazioni) || CPLib.IsLoaded(m_cWv_armt_cgo_qadv_operazioni)) {
        armt_cgo_qadv_operazioni.SetFromContext(m_cWv_armt_cgo_qadv_operazioni);
        m_cWv_armt_cgo_qadv_operazioni = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (armt_cgo_qadv_operazioni.m_bLoaded)) {
          armt_cgo_qadv_operazioni.Blank();
          armt_cgo_qadv_operazioni.w_SNAINUMOPE = w_SNAINUMOPE;
          armt_cgo_qadv_operazioni.Load();
          if ( ! (armt_cgo_qadv_operazioni.m_bLoaded)) {
            armt_cgo_qadv_operazioni.Initialize();
            armt_cgo_qadv_operazioni.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"armt_cgo_qadv_operazioni")) {
      CtxLoad_armt_cgo_qadv_operazioni();
      return armt_cgo_qadv_operazioni;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
