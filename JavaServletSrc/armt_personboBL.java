import java.util.*;

public class armt_personboBL extends armt_personboWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_personbo";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_personbo;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public CPPhTableWrInfo m_oWrInfo_tbstgru;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public CPPhTableWrInfo m_oWrInfo_tbramgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public CPPhTableWrInfo m_oWrInfo_tbsetsin;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbcondotta;
  public String m_cServer_tbcondotta;
  public CPPhTableWrInfo m_oWrInfo_tbcondotta;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_tbspecie;
  public String m_cServer_tbspecie;
  public CPPhTableWrInfo m_oWrInfo_tbspecie;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc;
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public CPPhTableWrInfo m_oWrInfo_inter2bo;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public CPPhTableWrInfo m_oWrInfo_tbstatna;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public CPPhTableWrInfo m_oWrInfo_tbcittna;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public CPPhTableWrInfo m_oWrInfo_personbo_agg;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbareegeog_p;
  public String m_cServer_tbareegeog_p;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog_p;
  public String m_cPhName_tbspecie_p;
  public String m_cServer_tbspecie_p;
  public CPPhTableWrInfo m_oWrInfo_tbspecie_p;
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
  public CPPhTableWrInfo m_oWrInfo_tbrisglob;
  public String m_cPhName_tbident;
  public String m_cServer_tbident;
  public CPPhTableWrInfo m_oWrInfo_tbident;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  public String m_cPhName_tbtipatt_p;
  public String m_cServer_tbtipatt_p;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt_p;
  public String m_cPhName_tbcondotta_p;
  public String m_cServer_tbcondotta_p;
  public CPPhTableWrInfo m_oWrInfo_tbcondotta_p;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public CPPhTableWrInfo m_oWrInfo_tbcauana;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"personbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'IDENT':IDENT,'IDNASCOMUN':IDNASCOMUN,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'IDNASSTATO':IDNASSTATO,'NASSTATO':NASSTATO,'SESSO':SESSO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'CONTO':CONTO,'SOTGRUP':SOTGRUP,'ATTIV':ATTIV,'SETTSINT':SETTSINT,'CONNES':CONNES,'NOSARA':NOSARA,'NOTIT':NOTIT,'flgaggfam':flgaggfam,'DATARETT':DATARETT,'DATAFINE':DATAFINE,'DATAINI':DATAINI,'DISATTIVO':DISATTIVO,'TIPOSOGGETTO':TIPOSOGGETTO,'RAPSEGNA':RAPSEGNA,'SOGAFFIDATARIO':SOGAFFIDATARIO,'CAUSALE':CAUSALE,'FATTURATO':FATTURATO,'FLGNOTRIM':FLGNOTRIM,'DATAIDENT':DATAIDENT,'COMPLETA':COMPLETA,'NOTE':NOTE,'CODLEGRAP':CODLEGRAP,'ardt_personbo_dip':ardt_personbo_dip,'armt_personbo_agg':armt_personbo_agg,'BANCABEN':BANCABEN,'DATASEGN':DATASEGN,'DATARAUT':DATARAUT,'ardt_soggope':ardt_soggope,'FATCA':FATCA,'TIN':TIN,'ODB':ODB,'ardt_fatca_ind':ardt_fatca_ind,'CITTADIN1':CITTADIN1,'CITTADIN2':CITTADIN2,'RESFISC':RESFISC,'AREAGEO':AREAGEO,'RAREA':RAREA,'PKTBSPECIE':PKTBSPECIE,'RNATGIU':RNATGIU,'ATTIVR':ATTIVR,'RATTIV':RATTIV,'COMPORT':COMPORT,'RCOMP':RCOMP,'RISGLOB':RISGLOB,'DATAPROF':DATAPROF,'PEP':PEP,'CRIME':CRIME,'MITIG':MITIG,'MITIGDOC':MITIGDOC,'ardt_patrimonio':ardt_patrimonio,'ardt_reddito':ardt_reddito,'VERIFICA':VERIFICA,'NOTERIS':NOTERIS,'status':status"+FoundlingChildrenList("armt_personbo",true)+"}";
  public static final String i_CompleteStateStructure = "{'gIntemediario':gIntemediario,'gFlgWU':gFlgWU,'gSeekAos':gSeekAos,'gDataVaria':gDataVaria,'gFlgDoc':gFlgDoc,'gTipInter':gTipInter,'gVerSim':gVerSim,'gCodDip':gCodDip,'dataoggi':dataoggi,'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'idcitta':idcitta,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'IDENT':IDENT,'IDNASCOMUN':IDNASCOMUN,'nascomunid':nascomunid,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'IDNASSTATO':IDNASSTATO,'nasstatoid':nasstatoid,'NASSTATO':NASSTATO,'SESSO':SESSO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'CONTO':CONTO,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'ATTIV':ATTIV,'SETTSINT':SETTSINT,'CONNES':CONNES,'NOSARA':NOSARA,'NOTIT':NOTIT,'flgaggfam':flgaggfam,'DATARETT':DATARETT,'STATOREG':STATOREG,'NUMPROG':NUMPROG,'PROGIMPORT':PROGIMPORT,'OLDSETSIN':OLDSETSIN,'CRIMEDATE':CRIMEDATE,'PEPDATE':PEPDATE,'tipsot':tipsot,'DESCSGRU':DESCSGRU,'DESCRAMGRU':DESCRAMGRU,'DESCUIC':DESCUIC,'dessta':dessta,'DESCRI':DESCRI,'xstatonas':xstatonas,'finesae':finesae,'finesint':finesint,'xFLGVALIDO':xFLGVALIDO,'xFLGANAVAL':xFLGANAVAL,'xDSETSIN':xDSETSIN,'xdesctipatt':xdesctipatt,'xdescareag':xdescareag,'xdescnatgiu':xdescnatgiu,'xdesccomp':xdesccomp,'xITFLGPEP':xITFLGPEP,'DATAFINE':DATAFINE,'DATAINI':DATAINI,'DISATTIVO':DISATTIVO,'TIPOSOGGETTO':TIPOSOGGETTO,'RAPSEGNA':RAPSEGNA,'SOGAFFIDATARIO':SOGAFFIDATARIO,'CAUSALE':CAUSALE,'FATTURATO':FATTURATO,'FLGNOTRIM':FLGNOTRIM,'DATAIDENT':DATAIDENT,'COMPLETA':COMPLETA,'CODINTER':CODINTER,'NUMIMP':NUMIMP,'CODDIPE':CODDIPE,'SOSPMAF':SOSPMAF,'OLDCONNES':OLDCONNES,'DATEXTRA':DATEXTRA,'ALLINEATO':ALLINEATO,'ALLINEATONOMECNOME':ALLINEATONOMECNOME,'RAGSOCOLD':RAGSOCOLD,'PROGIMP_C':PROGIMP_C,'IDFILE':IDFILE,'OLDCODFISC':OLDCODFISC,'MACROAGENTE':MACROAGENTE,'SPOTID':SPOTID,'DATAVARAGE':DATAVARAGE,'SETTSINT2':SETTSINT2,'TELEF':TELEF,'TIPOORO':TIPOORO,'CODORO':CODORO,'FLGVALIDO':FLGVALIDO,'DAC6':DAC6,'ALTRODOM':ALTRODOM,'ALTROCAP':ALTROCAP,'IMPORTOMAX':IMPORTOMAX,'FREQUENZA':FREQUENZA,'NUMOPERAZ':NUMOPERAZ,'DATASIGN':DATASIGN,'IDBASE':IDBASE,'FLAGDAC6':FLAGDAC6,'NOTE':NOTE,'CODLEGRAP':CODLEGRAP,'xRAGLEGRAP':xRAGLEGRAP,'xIDLEGRAP':xIDLEGRAP,'ragbanben':ragbanben,'ardt_personbo_dip':ardt_personbo_dip,'xDESDIPE':xDESDIPE,'armt_personbo_agg':armt_personbo_agg,'BANCABEN':BANCABEN,'DATASEGN':DATASEGN,'DATARAUT':DATARAUT,'ardt_soggope':ardt_soggope,'FATCA':FATCA,'xdesfatca':xdesfatca,'TIN':TIN,'ODB':ODB,'ardt_fatca_ind':ardt_fatca_ind,'CITTADIN1':CITTADIN1,'CITTADIN2':CITTADIN2,'RESFISC':RESFISC,'xDesCit1':xDesCit1,'xDesCit2':xDesCit2,'xResFis':xResFis,'AREAGEO':AREAGEO,'RAREA':RAREA,'PKTBSPECIE':PKTBSPECIE,'RNATGIU':RNATGIU,'ATTIVR':ATTIVR,'RATTIV':RATTIV,'COMPORT':COMPORT,'RCOMP':RCOMP,'DOCFILE':DOCFILE,'RISGLOB':RISGLOB,'DATAPROF':DATAPROF,'DATAREVPROF':DATAREVPROF,'PEP':PEP,'CRIME':CRIME,'MITIG':MITIG,'MITIGDOC':MITIGDOC,'ardt_patrimonio':ardt_patrimonio,'ardt_reddito':ardt_reddito,'VERIFICA':VERIFICA,'FLGALTO':FLGALTO,'NOTERIS':NOTERIS,'status':status"+FoundlingChildrenList("armt_personbo",true)+"}";
  public static final String i_ItemSequence = "TIPOPERS,COGNOME,NOME,CFESTERO,RAGSOC,PAESE,DESCCIT,PROVINCIA,CAP,CODCAB,DOMICILIO,IDENT,IDNASCOMUN,NASCOMUN,TIPINTER,IDNASSTATO,NASSTATO,SESSO,DATANASC,TIPODOC,NUMDOCUM,DATARILASC,DATAVALI,AUTRILASC,CODFISC,PARTIVA,CONTO,SOTGRUP,ATTIV,SETTSINT,CONNES,NOSARA,NOTIT,flgaggfam,DATARETT,DATAFINE,DATAINI,DISATTIVO,TIPOSOGGETTO,RAPSEGNA,SOGAFFIDATARIO,CAUSALE,FATTURATO,FLGNOTRIM,DATAIDENT,COMPLETA,NOTE,CODLEGRAP,ardt_personbo_dip,armt_personbo_agg,BANCABEN,DATASEGN,DATARAUT,ardt_soggope,FATCA,TIN,ODB,ardt_fatca_ind,CITTADIN1,CITTADIN2,RESFISC,AREAGEO,RAREA,PKTBSPECIE,RNATGIU,ATTIVR,RATTIV,COMPORT,RCOMP,RISGLOB,DATAPROF,PEP,CRIME,MITIG,MITIGDOC,ardt_patrimonio,ardt_reddito,VERIFICA,NOTERIS,status"+FoundlingChildrenList("armt_personbo",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_personbo"),new String[][]{new String[]{"TIPOPERS","Tipo Soggetto","C","1","0","campo","nokey","false","true"},new String[]{"COGNOME","Cognome","C","26","0","campo","nokey","false","false"},new String[]{"NOME","Nome","C","25","0","campo","nokey","false","false"},new String[]{"CFESTERO","Codice Fiscale Estero","N","1","0","campo","nokey","false","false"},new String[]{"RAGSOC","Ragione Sociale","C","70","0","campo","key2","false","false"},new String[]{"PAESE","Stato","C","3","0","campo","nokey","false","true"},new String[]{"DESCCIT","Città","C","30","0","campo","nokey","false","true"},new String[]{"PROVINCIA","Provincia","C","2","0","campo","nokey","false","true"},new String[]{"CAP","CAP","C","9","0","campo","nokey","false","true"},new String[]{"CODCAB","CAB","C","6","0","campo","nokey","false","true"},new String[]{"DOMICILIO","Indirizzo","C","35","0","campo","nokey","false","true"},new String[]{"IDENT","Identificazione","C","3","0","campo","nokey","false","false"},new String[]{"IDNASCOMUN","ID Comune Nascita","C","40","0","campo","key7","false","false"},new String[]{"NASCOMUN","Luogo di Nascita","C","30","0","campo","nokey","false","false"},new String[]{"TIPINTER","Prov.","C","2","0","campo","nokey","false","false"},new String[]{"IDNASSTATO","ID Stato Nascita","C","10","0","campo","key8","false","false"},new String[]{"NASSTATO","Stato di nascita","C","30","0","campo","nokey","false","false"},new String[]{"SESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"DATANASC","Data Nascita","D","8","0","campo","nokey","false","false"},new String[]{"TIPODOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"NUMDOCUM","Numero Doc.","C","15","0","campo","nokey","false","false"},new String[]{"DATARILASC","Data Rilascio Doc.","D","8","0","campo","nokey","false","false"},new String[]{"DATAVALI","","D","8","0","campo","nokey","false","false"},new String[]{"AUTRILASC","Autorità di rilascio","C","30","0","campo","nokey","false","false"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","nokey","false","false"},new String[]{"PARTIVA","Partita IVA","C","14","0","campo","nokey","false","false"},new String[]{"CONTO","Contro Corrente se controparte","C","25","0","campo","nokey","false","false"},new String[]{"SOTGRUP","Sottogruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"ATTIV","Codifica ATECO","C","10","0","campo","nokey","false","true"},new String[]{"SETTSINT","Settorizzazione UIC","C","3","0","campo","nokey","false","false"},new String[]{"CONNES","Codice Collegamento","C","16","0","campo","key1","false","true"},new String[]{"NOSARA","Escludi operazioni soggetto da SARA","C","1","0","campo","nokey","false","false"},new String[]{"NOTIT","Non inviare titolare AGE","N","1","0","campo","nokey","false","false"},new String[]{"flgaggfam","","C","1","0","variabile","nokey","false","false"},new String[]{"DATARETT","","D","8","0","variabile","nokey","false","false"},new String[]{"DATAFINE","Non più cliente Dal","D","8","0","campo","nokey","false","false"},new String[]{"DATAINI","Cliente dal","D","8","0","campo","nokey","false","false"},new String[]{"DISATTIVO","Non più attivo dal","D","8","0","campo","nokey","false","false"},new String[]{"TIPOSOGGETTO","Tipo Soggetto","C","1","0","campo","nokey","false","false"},new String[]{"RAPSEGNA","Tipo Rapporto","C","1","0","campo","nokey","false","true"},new String[]{"SOGAFFIDATARIO","Affidatario Incarico","C","80","0","campo","nokey","false","false"},new String[]{"CAUSALE","Causale Default","N","5","0","campo","nokey","false","false"},new String[]{"FATTURATO","Fatturato","N","12","2","campo","nokey","false","false"},new String[]{"FLGNOTRIM","","C","1","0","campo","nokey","false","false"},new String[]{"DATAIDENT","Data Identificazione","D","8","0","campo","nokey","false","false"},new String[]{"COMPLETA","","L","1","0","variabile","nokey","false","false"},new String[]{"NOTE","Note","M","10","0","campo","nokey","false","false"},new String[]{"CODLEGRAP","Legale Rappresentante","C","16","0","campo","nokey","false","false"},new String[]{"ardt_personbo_dip","LinkPC","","","","link_PC","","false",""},new String[]{"armt_personbo_agg","Dati_Agg","","","","link_PC","","false",""},new String[]{"BANCABEN","Codice Banca se Beneficiario","C","11","0","campo","nokey","false","false"},new String[]{"DATASEGN","Data Segnalazione a UIF/BankIT","D","8","0","campo","nokey","false","false"},new String[]{"DATARAUT","Data Richiesta Autorità","D","8","0","campo","nokey","false","false"},new String[]{"ardt_soggope","LinkPC","","","","link_PC","","false",""},new String[]{"FATCA","Stato Res. Legale FATCA","C","3","0","campo","nokey","false","false"},new String[]{"TIN","Codice FATCA","C","16","0","campo","nokey","false","false"},new String[]{"ODB","Ordine di Bonifico Permanente","N","1","0","campo","nokey","false","false"},new String[]{"ardt_fatca_ind","LinkPC","","","","link_PC","","false",""},new String[]{"CITTADIN1","Cittadinanza 1","C","3","0","campo","nokey","false","false"},new String[]{"CITTADIN2","","C","3","0","campo","nokey","false","false"},new String[]{"RESFISC","","C","3","0","campo","nokey","false","false"},new String[]{"AREAGEO","","C","3","0","campo","nokey","false","false"},new String[]{"RAREA","","N","3","0","campo","nokey","false","false"},new String[]{"PKTBSPECIE","","C","4","0","campo","nokey","false","false"},new String[]{"RNATGIU","","N","3","0","campo","nokey","false","false"},new String[]{"ATTIVR","Codifica ATECO","C","10","0","variabile","nokey","false","false"},new String[]{"RATTIV","","N","3","0","campo","nokey","false","false"},new String[]{"COMPORT","","C","5","0","campo","nokey","false","false"},new String[]{"RCOMP","","N","3","0","campo","nokey","false","false"},new String[]{"RISGLOB","Rischio Globale","C","3","0","campo","nokey","false","false"},new String[]{"DATAPROF","Data Profilatura","D","8","0","campo","nokey","false","false"},new String[]{"PEP","Persona Politicamente Esposta","C","1","0","campo","nokey","false","false"},new String[]{"CRIME","Presente in liste Crime","C","1","0","campo","nokey","false","false"},new String[]{"MITIG","Mitigazione (+/-)","N","4","0","campo","nokey","false","false"},new String[]{"MITIGDOC","Documentazione Mitigazione","C","100","0","campo","nokey","false","false"},new String[]{"ardt_patrimonio","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_reddito","LinkPC","","","","link_PC","","false",""},new String[]{"VERIFICA","Tipo Adeguata Verifica","C","1","0","campo","nokey","false","false"},new String[]{"NOTERIS","Note Rischio","M","10","0","campo","nokey","false","false"},new String[]{"status","","C","10","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_personboBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo",p_ContextObject.GetCompany(),false);
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cVirtName_personbo = CPSql.ManipulateTablePhName("personbo",m_cServer_personbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_oWrInfo_tbstgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstgru",p_ContextObject.GetCompany());
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_oWrInfo_tbramgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbramgru",p_ContextObject.GetCompany());
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_oWrInfo_tbsetsin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsetsin",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbcondotta = p_ContextObject.GetPhName("tbcondotta");
    m_cServer_tbcondotta = p_ContextObject.GetServer("tbcondotta");
    m_oWrInfo_tbcondotta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcondotta",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_tbspecie = p_ContextObject.GetPhName("tbspecie");
    m_cServer_tbspecie = p_ContextObject.GetServer("tbspecie");
    m_oWrInfo_tbspecie = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbspecie",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_oWrInfo_tbtiporisc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_oWrInfo_tbareegeog = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog",p_ContextObject.GetCompany());
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_oWrInfo_inter2bo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"inter2bo",p_ContextObject.GetCompany());
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_oWrInfo_tbstatna = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstatna",p_ContextObject.GetCompany());
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_oWrInfo_tbcittna = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcittna",p_ContextObject.GetCompany());
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_oWrInfo_personbo_agg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo_agg",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog_p = p_ContextObject.GetPhName("tbareegeog_p");
    m_cServer_tbareegeog_p = p_ContextObject.GetServer("tbareegeog_p");
    m_oWrInfo_tbareegeog_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog_p",p_ContextObject.GetCompany());
    m_cPhName_tbspecie_p = p_ContextObject.GetPhName("tbspecie_p");
    m_cServer_tbspecie_p = p_ContextObject.GetServer("tbspecie_p");
    m_oWrInfo_tbspecie_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbspecie_p",p_ContextObject.GetCompany());
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    m_oWrInfo_tbrisglob = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrisglob",p_ContextObject.GetCompany());
    m_cPhName_tbident = p_ContextObject.GetPhName("tbident");
    m_cServer_tbident = p_ContextObject.GetServer("tbident");
    m_oWrInfo_tbident = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbident",p_ContextObject.GetCompany());
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt_p = p_ContextObject.GetPhName("tbtipatt_p");
    m_cServer_tbtipatt_p = p_ContextObject.GetServer("tbtipatt_p");
    m_oWrInfo_tbtipatt_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt_p",p_ContextObject.GetCompany());
    m_cPhName_tbcondotta_p = p_ContextObject.GetPhName("tbcondotta_p");
    m_cServer_tbcondotta_p = p_ContextObject.GetServer("tbcondotta_p");
    m_oWrInfo_tbcondotta_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcondotta_p",p_ContextObject.GetCompany());
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_oWrInfo_tbcauana = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcauana",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_personbo_dip = new ardt_personbo_dipBO(p_ContextObject);
    armt_personbo_agg = new armt_personbo_aggBO(p_ContextObject);
    ardt_soggope = new ardt_soggopeBO(p_ContextObject);
    ardt_fatca_ind = new ardt_fatca_indBO(p_ContextObject);
    ardt_patrimonio = new ardt_patrimonioBO(p_ContextObject);
    ardt_reddito = new ardt_redditoBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_personbo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_COGNOME = "";
    w_NOME = "";
    w_RAGSOC = "";
    w_PAESE = "";
    w_DESCCIT = "";
    w_idcitta = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_IDENT = "";
    w_IDNASCOMUN = "";
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_IDNASSTATO = "";
    w_NASSTATO = "";
    w_SESSO = "";
    w_DATANASC = CPLib.NullDate();
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_CONTO = "";
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_ATTIV = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_DATARETT = CPLib.NullDate();
    w_STATOREG = "";
    w_NUMPROG = "";
    w_PROGIMPORT = 0;
    w_OLDSETSIN = "";
    w_CRIMEDATE = CPLib.NullDate();
    w_PEPDATE = CPLib.NullDate();
    w_tipsot = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_DESCRI = "";
    w_xstatonas = "";
    w_finesae = CPLib.NullDate();
    w_finesint = CPLib.NullDate();
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
    w_xDSETSIN = "";
    w_xdesctipatt = "";
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesccomp = "";
    w_xITFLGPEP = "";
    w_DATAFINE = CPLib.NullDate();
    w_DATAINI = CPLib.NullDate();
    w_DISATTIVO = CPLib.NullDate();
    w_TIPOSOGGETTO = "";
    w_RAPSEGNA = "";
    w_SOGAFFIDATARIO = "";
    w_CAUSALE = 0;
    w_FATTURATO = 0;
    w_DATAIDENT = CPLib.NullDate();
    w_CODINTER = "";
    w_NUMIMP = CPLib.NullDateTime();
    w_CODDIPE = "";
    w_SOSPMAF = "";
    w_OLDCONNES = "";
    w_DATEXTRA = CPLib.NullDate();
    w_ALLINEATO = 0;
    w_ALLINEATONOMECNOME = 0;
    w_RAGSOCOLD = "";
    w_PROGIMP_C = "";
    w_IDFILE = "";
    w_OLDCODFISC = "";
    w_MACROAGENTE = "";
    w_SPOTID = "";
    w_DATAVARAGE = CPLib.NullDate();
    w_SETTSINT2 = "";
    w_TELEF = "";
    w_TIPOORO = "";
    w_CODORO = "";
    w_FLGVALIDO = "";
    w_DAC6 = "";
    w_ALTRODOM = "";
    w_ALTROCAP = "";
    w_IMPORTOMAX = 0;
    w_FREQUENZA = "";
    w_NUMOPERAZ = 0;
    w_DATASIGN = CPLib.NullDate();
    w_IDBASE = "";
    w_FLAGDAC6 = 0;
    w_CONNES = "";
    w_NOTE = "";
    w_CODLEGRAP = "";
    w_xRAGLEGRAP = "";
    w_xIDLEGRAP = "";
    w_ragbanben = "";
    w_xDESDIPE = "";
    w_BANCABEN = "";
    w_DATASEGN = CPLib.NullDate();
    w_DATARAUT = CPLib.NullDate();
    w_FATCA = "";
    w_xdesfatca = "";
    w_TIN = "";
    w_CITTADIN1 = "";
    w_CITTADIN2 = "";
    w_RESFISC = "";
    w_xDesCit1 = "";
    w_xDesCit2 = "";
    w_xResFis = "";
    w_AREAGEO = "";
    w_AREAGEO = "";
    w_RAREA = 0;
    w_PKTBSPECIE = "";
    w_PKTBSPECIE = "";
    w_RNATGIU = 0;
    w_ATTIVR = "";
    w_ATTIV = "";
    w_RATTIV = 0;
    w_COMPORT = "";
    w_COMPORT = "";
    w_RCOMP = 0;
    w_DOCFILE = "";
    w_RISGLOB = "";
    w_DATAPROF = CPLib.NullDate();
    w_DATAREVPROF = CPLib.NullDate();
    w_MITIG = 0;
    w_MITIGDOC = "";
    w_VERIFICA = "";
    w_FLGALTO = 0;
    w_NOTERIS = "";
    w_status = "";
    Link_LDTVEYLAXJ();
    w_dataoggi = CPLib.NullDate();
    w_dataoggi = CPLib.Date();
    w_TIPOPERS = "P";
    w_CFESTERO = 0;
    Link_YVIKEGPYPM();
    Link_ODAYKSRECA();
    Link_TYEDHRZCMA();
    Link_BYPEBFEOAJ();
    w_nascomunid = "";
    w_nascomunid = w_IDNASCOMUN;
    Link_ZRIWLTGERM();
    Link_IOAMSFCCVV();
    w_nasstatoid = "";
    w_nasstatoid = w_IDNASSTATO;
    Link_AHFPACGVOQ();
    Link_MBGANUUHRA();
    Link_LLYIGAMXRH();
    Link_RVNHQCXNEM();
    Link_SAQTIHOALW();
    Link_ZGNLLSFQHC();
    w_NOSARA = "N";
    w_NOTIT = 0;
    w_flgaggfam = "N";
    w_FLGNOTRIM = "N";
    w_COMPLETA = true;
    Link_MQYKJYJENJ();
    Link_CKHRNQSKKQ();
    Link_DQZNJUSTLN();
    Link_RKHMYOIJDM();
    w_ODB = 0;
    Link_CJBEXKJOQO();
    Link_UNRQNVVFTK();
    Link_OSLBLDODHQ();
    Link_NXVXQSLAGM();
    Link_JHEJMIHGSH();
    Link_VHXDWWHVXF();
    Link_DRJTSDRPVN();
    Link_UQYOQYIUNM();
    Link_QFJRACGINU();
    Link_HLXRSSMBIW();
    Link_KYTSUTYBUR();
    w_PEP = "N";
    w_CRIME = "N";
    m_cWv_ardt_personbo_dip = "";
    m_cWv_armt_personbo_agg = "";
    m_cWv_ardt_soggope = "";
    m_cWv_ardt_fatca_ind = "";
    m_cWv_ardt_patrimonio = "";
    m_cWv_ardt_reddito = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_personbo_dip.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_personbo_dip);
    l_bResult = l_bResult || armt_personbo_agg.IsUpdated() || CPLib.IsUpdated(m_cWv_armt_personbo_agg);
    l_bResult = l_bResult || ardt_soggope.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_soggope);
    l_bResult = l_bResult || ardt_fatca_ind.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_fatca_ind);
    l_bResult = l_bResult || ardt_patrimonio.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_patrimonio);
    l_bResult = l_bResult || ardt_reddito.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_reddito);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_gIntemediario = w_gIntemediario;
    o_COGNOME = w_COGNOME;
    o_NOME = w_NOME;
    o_PAESE = w_PAESE;
    o_DESCCIT = w_DESCCIT;
    o_idcitta = w_idcitta;
    o_IDNASCOMUN = w_IDNASCOMUN;
    o_IDNASSTATO = w_IDNASSTATO;
    o_NASSTATO = w_NASSTATO;
    o_DATANASC = w_DATANASC;
    o_TIPODOC = w_TIPODOC;
    o_NUMDOCUM = w_NUMDOCUM;
    o_DATARILASC = w_DATARILASC;
    o_DATAVALI = w_DATAVALI;
    o_SOTGRUP = w_SOTGRUP;
    o_RAMOGRUP = w_RAMOGRUP;
    o_ATTIV = w_ATTIV;
    o_CONNES = w_CONNES;
    o_tipsot = w_tipsot;
    o_AREAGEO = w_AREAGEO;
    o_PKTBSPECIE = w_PKTBSPECIE;
    o_ATTIVR = w_ATTIVR;
    o_COMPORT = w_COMPORT;
    ardt_personbo_dip.SaveDependsOn();
    armt_personbo_agg.SaveDependsOn();
    ardt_soggope.SaveDependsOn();
    ardt_fatca_ind.SaveDependsOn();
    ardt_patrimonio.SaveDependsOn();
    ardt_reddito.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete end")) {
      Calculation_IIAFZWAADN();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_XBFAONNKOG();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_LDTVEYLAXJ() {
    return Link_LDTVEYLAXJ("Full");
  }
  protected boolean Link_LDTVEYLAXJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_gIntemediario))) {
      String l_OldValue = w_gIntemediario;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_gIntemediario,"C",11,0),m_cServer_intermbo,w_gIntemediario);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_intermbo,"select CODINTER,ITFLGPEP,FLGAGGFAM from "+m_cPhName_intermbo+((m_cPhName_intermbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_gIntemediario = l_rsLink.GetString("CODINTER");
          w_xITFLGPEP = l_rsLink.GetString("ITFLGPEP");
          w_flgaggfam = l_rsLink.GetString("FLGAGGFAM");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LDTVEYLAXJ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_gIntemediario = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","gIntemediario");
          }
          m_cLastWorkVarError = "gIntemediario";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LDTVEYLAXJ_blank();
    }
    return l_bResult;
  }
  void Link_LDTVEYLAXJ_blank() {
    w_gIntemediario = "";
    w_xITFLGPEP = "";
    w_flgaggfam = "";
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
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_YVIKEGPYPM_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PAESE");
          }
          m_cLastWorkVarError = "PAESE";
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
    Link_YVIKEGPYPM_blank("");
  }
  void Link_YVIKEGPYPM_blank(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",30,0),m_cServer_tbcitta,w_DESCCIT);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",40,0),m_cServer_tbcitta,w_DESCCIT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
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
  protected boolean Link_TYEDHRZCMA() {
    return Link_TYEDHRZCMA("Full");
  }
  protected boolean Link_TYEDHRZCMA(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idcitta,"C",40,0),m_cServer_tbcitta,w_idcitta);
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
          Link_TYEDHRZCMA_blank();
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
      Link_TYEDHRZCMA_blank();
    }
    return l_bResult;
  }
  void Link_TYEDHRZCMA_blank() {
    w_idcitta = "";
    w_CODCAB = "";
    w_PROVINCIA = "";
    w_CAP = "";
  }
  protected boolean Link_BYPEBFEOAJ() {
    return Link_BYPEBFEOAJ("Full");
  }
  protected boolean Link_BYPEBFEOAJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDNASCOMUN))) {
      String l_OldValue = w_IDNASCOMUN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDNASCOMUN,"C",40,0),m_cServer_tbcittna,w_IDNASCOMUN);
      if (m_Ctx.IsSharedTemp("tbcittna")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcittna,"select IDBASE from "+m_cPhName_tbcittna+((m_cPhName_tbcittna).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDNASCOMUN = l_rsLink.GetString("IDBASE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_BYPEBFEOAJ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDNASCOMUN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDNASCOMUN");
          }
          m_cLastWorkVarError = "IDNASCOMUN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_BYPEBFEOAJ_blank();
    }
    return l_bResult;
  }
  void Link_BYPEBFEOAJ_blank() {
    w_IDNASCOMUN = "";
  }
  protected boolean Link_ZRIWLTGERM() {
    return Link_ZRIWLTGERM("Full");
  }
  protected boolean Link_ZRIWLTGERM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_nascomunid))) {
      String l_OldValue = w_nascomunid;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nascomunid,"C",40,0),m_cServer_tbcittna,w_nascomunid);
      if (m_Ctx.IsSharedTemp("tbcittna")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcittna,"select IDBASE,CITTA,PROV from "+m_cPhName_tbcittna+((m_cPhName_tbcittna).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_nascomunid = l_rsLink.GetString("IDBASE");
          w_NASCOMUN = l_rsLink.GetString("CITTA");
          w_TIPINTER = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZRIWLTGERM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_nascomunid = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","nascomunid");
          }
          m_cLastWorkVarError = "nascomunid";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ZRIWLTGERM_blank();
    }
    return l_bResult;
  }
  void Link_ZRIWLTGERM_blank() {
    w_nascomunid = "";
    w_NASCOMUN = "";
    w_TIPINTER = "";
  }
  protected boolean Link_IOAMSFCCVV() {
    return Link_IOAMSFCCVV("Full");
  }
  protected boolean Link_IOAMSFCCVV(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDNASSTATO))) {
      String l_OldValue = w_IDNASSTATO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDNASSTATO,"C",10,0),m_cServer_tbstatna,w_IDNASSTATO);
      if (m_Ctx.IsSharedTemp("tbstatna")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstatna,"select IDBASE,DESCRI from "+m_cPhName_tbstatna+((m_cPhName_tbstatna).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDNASSTATO,"C",50,0),m_cServer_tbstatna,w_IDNASSTATO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstatna,"select IDBASE,DESCRI from "+m_cPhName_tbstatna+((m_cPhName_tbstatna).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDNASSTATO = l_rsLink.GetString("IDBASE");
          w_xstatonas = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_IOAMSFCCVV_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDNASSTATO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDNASSTATO");
          }
          m_cLastWorkVarError = "IDNASSTATO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_IOAMSFCCVV_blank();
    }
    return l_bResult;
  }
  void Link_IOAMSFCCVV_blank() {
    w_IDNASSTATO = "";
    w_xstatonas = "";
  }
  protected boolean Link_AHFPACGVOQ() {
    return Link_AHFPACGVOQ("Full");
  }
  protected boolean Link_AHFPACGVOQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_nasstatoid))) {
      String l_OldValue = w_nasstatoid;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nasstatoid,"C",10,0),m_cServer_tbstatna,w_nasstatoid);
      if (m_Ctx.IsSharedTemp("tbstatna")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstatna,"select IDBASE,DESCRI from "+m_cPhName_tbstatna+((m_cPhName_tbstatna).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_nasstatoid = l_rsLink.GetString("IDBASE");
          w_NASSTATO = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AHFPACGVOQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_nasstatoid = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","nasstatoid");
          }
          m_cLastWorkVarError = "nasstatoid";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AHFPACGVOQ_blank();
    }
    return l_bResult;
  }
  void Link_AHFPACGVOQ_blank() {
    w_nasstatoid = "";
    w_NASSTATO = "";
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPODOC,"C",2,0),m_cServer_tbtipdoc,w_TIPODOC);
      if (m_Ctx.IsSharedTemp("tbtipdoc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipdoc,"select TIPDOC,DESCRI from "+m_cPhName_tbtipdoc+((m_cPhName_tbtipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPDOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPODOC,"C",30,0),m_cServer_tbtipdoc,w_TIPODOC);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtipdoc,"select TIPDOC,DESCRI from "+m_cPhName_tbtipdoc+((m_cPhName_tbtipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
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
  protected boolean Link_LLYIGAMXRH() {
    return Link_LLYIGAMXRH("Full");
  }
  protected boolean Link_LLYIGAMXRH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOTGRUP))) {
      String l_OldValue = w_SOTGRUP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTGRUP,"C",3,0),m_cServer_tbstgru,w_SOTGRUP);
      if (m_Ctx.IsSharedTemp("tbstgru")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT,DATAFINE from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SOTGRU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTGRUP,"C",60,0),m_cServer_tbstgru,w_SOTGRUP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT,DATAFINE from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SOTGRUP = l_rsLink.GetString("SOTGRU");
          w_DESCSGRU = l_rsLink.GetString("DESCRI");
          w_tipsot = l_rsLink.GetString("TIPOSOT");
          w_finesae = l_rsLink.GetDate("DATAFINE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LLYIGAMXRH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOTGRUP = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = CPLib.ge(w_finesae,CPLib.Date()) || CPLib.Empty(w_finesae);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = "Non è possibile selezionare il Sottogruppo in quanto non più valido!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOTGRUP");
              }
              m_cLastWorkVarError = "SOTGRUP";
              w_SOTGRUP = "";
              Link_LLYIGAMXRH_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = "Non è possibile selezionare il Sottogruppo in quanto non più valido!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOTGRUP");
              }
              m_cLastWorkVarError = "SOTGRUP";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LLYIGAMXRH_blank();
    }
    return l_bResult;
  }
  void Link_LLYIGAMXRH_blank() {
    w_SOTGRUP = "";
    w_DESCSGRU = "";
    w_tipsot = "";
    w_finesae = CPLib.NullDate();
  }
  protected boolean Link_RVNHQCXNEM() {
    return Link_RVNHQCXNEM("Full");
  }
  protected boolean Link_RVNHQCXNEM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAMOGRUP))) {
      String l_OldValue = w_RAMOGRUP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAMOGRUP,"C",3,0),m_cServer_tbramgru,w_RAMOGRUP);
      if (m_Ctx.IsSharedTemp("tbramgru")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbramgru,"select RAMGRU,DESCRI from "+m_cPhName_tbramgru+((m_cPhName_tbramgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAMGRU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAMOGRUP = l_rsLink.GetString("RAMGRU");
          w_DESCRAMGRU = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RVNHQCXNEM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAMOGRUP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAMOGRUP");
          }
          m_cLastWorkVarError = "RAMOGRUP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RVNHQCXNEM_blank();
    }
    return l_bResult;
  }
  void Link_RVNHQCXNEM_blank() {
    w_RAMOGRUP = "";
    w_DESCRAMGRU = "";
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
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ATTIV,"C",250,0),m_cServer_tbtipatt,w_ATTIV);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE,DESCRI from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIV = l_rsLink.GetString("CODICE");
          w_xdesctipatt = l_rsLink.GetString("DESCRI");
          w_ATTIVR = l_rsLink.GetString("CODICE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_SAQTIHOALW_blank();
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = (w_COMPLETA?arfn_chkatecoR.Make(m_Ctx,this).Run(w_SOTGRUP,w_ATTIV) || CPLib.ne(w_tipsot,"1"):true);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = "Codice ATECO non valido per il SAE selezionato!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","ATTIV");
              }
              m_cLastWorkVarError = "ATTIV";
              w_ATTIV = "";
              Link_SAQTIHOALW_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = "Codice ATECO non valido per il SAE selezionato!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","ATTIV");
              }
              m_cLastWorkVarError = "ATTIV";
            }
          }
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
    Link_SAQTIHOALW_blank("");
  }
  void Link_SAQTIHOALW_blank(String p_cType) {
    w_xdesctipatt = "";
    w_ATTIVR = "";
  }
  protected boolean Link_ZGNLLSFQHC() {
    return Link_ZGNLLSFQHC("Full");
  }
  protected boolean Link_ZGNLLSFQHC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SETTSINT))) {
      String l_OldValue = w_SETTSINT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETTSINT,"C",3,0),m_cServer_tbsetsin,w_SETTSINT);
      if (m_Ctx.IsSharedTemp("tbsetsin")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DATAFINE,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SETSINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETTSINT,"C",8,0),m_cServer_tbsetsin,w_SETTSINT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DATAFINE,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DATAFINE"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SETTSINT = l_rsLink.GetString("SETSINT");
          w_finesint = l_rsLink.GetDate("DATAFINE");
          w_xDSETSIN = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZGNLLSFQHC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SETTSINT = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chksintR.Make(m_Ctx,this).Run(w_SETTSINT);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = "Non è possibile selezionare il Settore Sintetico in quanto non più valido!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SETTSINT");
              }
              m_cLastWorkVarError = "SETTSINT";
              w_SETTSINT = "";
              Link_ZGNLLSFQHC_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = "Non è possibile selezionare il Settore Sintetico in quanto non più valido!";
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SETTSINT");
              }
              m_cLastWorkVarError = "SETTSINT";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ZGNLLSFQHC_blank();
    }
    return l_bResult;
  }
  void Link_ZGNLLSFQHC_blank() {
    w_SETTSINT = "";
    w_finesint = CPLib.NullDate();
    w_xDSETSIN = "";
  }
  protected boolean Link_MQYKJYJENJ() {
    return Link_MQYKJYJENJ("Full");
  }
  protected boolean Link_MQYKJYJENJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNES))) {
      String l_OldValue = w_CONNES;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0),m_cServer_personbo_agg,w_CONNES);
      if (m_Ctx.IsSharedTemp("personbo_agg")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo_agg,"select CONNES,FLGVALIDO,FLGANAVAL from "+m_cPhName_personbo_agg+((m_cPhName_personbo_agg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNES = l_rsLink.GetString("CONNES");
          w_xFLGVALIDO = l_rsLink.GetString("FLGVALIDO");
          w_xFLGANAVAL = l_rsLink.GetString("FLGANAVAL");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_MQYKJYJENJ_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNES");
          }
          m_cLastWorkVarError = "CONNES";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MQYKJYJENJ_blank();
    }
    return l_bResult;
  }
  void Link_MQYKJYJENJ_blank() {
    Link_MQYKJYJENJ_blank("");
  }
  void Link_MQYKJYJENJ_blank(String p_cType) {
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
  }
  protected boolean Link_CKHRNQSKKQ() {
    return Link_CKHRNQSKKQ("Full");
  }
  protected boolean Link_CKHRNQSKKQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODLEGRAP))) {
      String l_OldValue = w_CODLEGRAP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODLEGRAP,"C",16,0),m_cServer_personbo,w_CODLEGRAP);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,IDBASE from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODLEGRAP,"C",70,0),m_cServer_personbo,w_CODLEGRAP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,IDBASE from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODLEGRAP,"C",10,0),m_cServer_personbo,w_CODLEGRAP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,IDBASE from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODLEGRAP = l_rsLink.GetString("CONNES");
          w_xRAGLEGRAP = l_rsLink.GetString("RAGSOC");
          w_xIDLEGRAP = l_rsLink.GetString("IDBASE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CKHRNQSKKQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODLEGRAP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODLEGRAP");
          }
          m_cLastWorkVarError = "CODLEGRAP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CKHRNQSKKQ_blank();
    }
    return l_bResult;
  }
  void Link_CKHRNQSKKQ_blank() {
    w_CODLEGRAP = "";
    w_xRAGLEGRAP = "";
    w_xIDLEGRAP = "";
  }
  protected boolean Link_DQZNJUSTLN() {
    return Link_DQZNJUSTLN("Full");
  }
  protected boolean Link_DQZNJUSTLN(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_BANCABEN))) {
      String l_OldValue = w_BANCABEN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_BANCABEN,"C",11,0),m_cServer_inter2bo,w_BANCABEN);
      if (m_Ctx.IsSharedTemp("inter2bo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_inter2bo,"select CODINTER,RAGSOC from "+m_cPhName_inter2bo+((m_cPhName_inter2bo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_BANCABEN = l_rsLink.GetString("CODINTER");
          w_ragbanben = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DQZNJUSTLN_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_BANCABEN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","BANCABEN");
          }
          m_cLastWorkVarError = "BANCABEN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DQZNJUSTLN_blank();
    }
    return l_bResult;
  }
  void Link_DQZNJUSTLN_blank() {
    w_BANCABEN = "";
    w_ragbanben = "";
  }
  protected boolean Link_RKHMYOIJDM() {
    return Link_RKHMYOIJDM("Full");
  }
  protected boolean Link_RKHMYOIJDM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_FATCA))) {
      String l_OldValue = w_FATCA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_FATCA,"C",3,0),m_cServer_tbstati,w_FATCA);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_FATCA,"C",40,0),m_cServer_tbstati,w_FATCA);
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
          w_FATCA = l_rsLink.GetString("CODSTA");
          w_xdesfatca = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RKHMYOIJDM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_FATCA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","FATCA");
          }
          m_cLastWorkVarError = "FATCA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RKHMYOIJDM_blank();
    }
    return l_bResult;
  }
  void Link_RKHMYOIJDM_blank() {
    w_FATCA = "";
    w_xdesfatca = "";
  }
  protected boolean Link_CJBEXKJOQO() {
    return Link_CJBEXKJOQO("Full");
  }
  protected boolean Link_CJBEXKJOQO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CITTADIN1))) {
      String l_OldValue = w_CITTADIN1;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CITTADIN1,"C",3,0),m_cServer_tbstati,w_CITTADIN1);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CITTADIN1 = l_rsLink.GetString("CODSTA");
          w_xDesCit1 = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CJBEXKJOQO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CITTADIN1 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CITTADIN1");
          }
          m_cLastWorkVarError = "CITTADIN1";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CJBEXKJOQO_blank();
    }
    return l_bResult;
  }
  void Link_CJBEXKJOQO_blank() {
    w_CITTADIN1 = "";
    w_xDesCit1 = "";
  }
  protected boolean Link_UNRQNVVFTK() {
    return Link_UNRQNVVFTK("Full");
  }
  protected boolean Link_UNRQNVVFTK(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CITTADIN2))) {
      String l_OldValue = w_CITTADIN2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CITTADIN2,"C",3,0),m_cServer_tbstati,w_CITTADIN2);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CITTADIN2 = l_rsLink.GetString("CODSTA");
          w_xDesCit2 = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UNRQNVVFTK_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CITTADIN2 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CITTADIN2");
          }
          m_cLastWorkVarError = "CITTADIN2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UNRQNVVFTK_blank();
    }
    return l_bResult;
  }
  void Link_UNRQNVVFTK_blank() {
    w_CITTADIN2 = "";
    w_xDesCit2 = "";
  }
  protected boolean Link_OSLBLDODHQ() {
    return Link_OSLBLDODHQ("Full");
  }
  protected boolean Link_OSLBLDODHQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RESFISC))) {
      String l_OldValue = w_RESFISC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RESFISC,"C",3,0),m_cServer_tbstati,w_RESFISC);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RESFISC = l_rsLink.GetString("CODSTA");
          w_xResFis = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_OSLBLDODHQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RESFISC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RESFISC");
          }
          m_cLastWorkVarError = "RESFISC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_OSLBLDODHQ_blank();
    }
    return l_bResult;
  }
  void Link_OSLBLDODHQ_blank() {
    w_RESFISC = "";
    w_xResFis = "";
  }
  protected boolean Link_NXVXQSLAGM() {
    return Link_NXVXQSLAGM("Full");
  }
  protected boolean Link_NXVXQSLAGM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AREAGEO))) {
      String l_OldValue = w_AREAGEO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",3,0),m_cServer_tbareegeog,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",50,0),m_cServer_tbareegeog,w_AREAGEO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_xdescareag = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NXVXQSLAGM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AREAGEO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AREAGEO");
          }
          m_cLastWorkVarError = "AREAGEO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NXVXQSLAGM_blank();
    }
    return l_bResult;
  }
  void Link_NXVXQSLAGM_blank() {
    w_AREAGEO = "";
    w_xdescareag = "";
  }
  protected boolean Link_JHEJMIHGSH() {
    return Link_JHEJMIHGSH("Full");
  }
  protected boolean Link_JHEJMIHGSH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AREAGEO))) {
      String l_OldValue = w_AREAGEO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",3,0),m_cServer_tbareegeog_p,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog_p,"select CODICE,RISCHIO from "+m_cPhName_tbareegeog_p+((m_cPhName_tbareegeog_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_RAREA = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_JHEJMIHGSH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AREAGEO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AREAGEO");
          }
          m_cLastWorkVarError = "AREAGEO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_JHEJMIHGSH_blank();
    }
    return l_bResult;
  }
  void Link_JHEJMIHGSH_blank() {
    w_AREAGEO = "";
    w_RAREA = 0;
  }
  protected boolean Link_VHXDWWHVXF() {
    return Link_VHXDWWHVXF("Full");
  }
  protected boolean Link_VHXDWWHVXF(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_PKTBSPECIE))) {
      String l_OldValue = w_PKTBSPECIE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PKTBSPECIE,"C",4,0),m_cServer_tbspecie,w_PKTBSPECIE);
      if (m_Ctx.IsSharedTemp("tbspecie")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbspecie,"select CODSPE,DESCRI from "+m_cPhName_tbspecie+((m_cPhName_tbspecie).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSPE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PKTBSPECIE,"C",60,0),m_cServer_tbspecie,w_PKTBSPECIE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbspecie,"select CODSPE,DESCRI from "+m_cPhName_tbspecie+((m_cPhName_tbspecie).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PKTBSPECIE = l_rsLink.GetString("CODSPE");
          w_xdescnatgiu = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_VHXDWWHVXF_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_PKTBSPECIE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PKTBSPECIE");
          }
          m_cLastWorkVarError = "PKTBSPECIE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_VHXDWWHVXF_blank();
    }
    return l_bResult;
  }
  void Link_VHXDWWHVXF_blank() {
    w_PKTBSPECIE = "";
    w_xdescnatgiu = "";
  }
  protected boolean Link_DRJTSDRPVN() {
    return Link_DRJTSDRPVN("Full");
  }
  protected boolean Link_DRJTSDRPVN(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_PKTBSPECIE))) {
      String l_OldValue = w_PKTBSPECIE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PKTBSPECIE,"C",4,0),m_cServer_tbspecie_p,w_PKTBSPECIE);
      if (m_Ctx.IsSharedTemp("tbspecie_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbspecie_p,"select CODSPE,RISCHIO from "+m_cPhName_tbspecie_p+((m_cPhName_tbspecie_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSPE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PKTBSPECIE = l_rsLink.GetString("CODSPE");
          w_RNATGIU = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DRJTSDRPVN_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_PKTBSPECIE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PKTBSPECIE");
          }
          m_cLastWorkVarError = "PKTBSPECIE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DRJTSDRPVN_blank();
    }
    return l_bResult;
  }
  void Link_DRJTSDRPVN_blank() {
    w_PKTBSPECIE = "";
    w_RNATGIU = 0;
  }
  protected boolean Link_UQYOQYIUNM() {
    return Link_UQYOQYIUNM("Full");
  }
  protected boolean Link_UQYOQYIUNM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_ATTIVR))) {
      String l_OldValue = w_ATTIVR;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ATTIVR,"C",10,0),m_cServer_tbtipatt,w_ATTIVR);
      if (m_Ctx.IsSharedTemp("tbtipatt")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIVR = l_rsLink.GetString("CODICE");
          w_ATTIV = l_rsLink.GetString("CODICE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_UQYOQYIUNM_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","ATTIVR");
          }
          m_cLastWorkVarError = "ATTIVR";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UQYOQYIUNM_blank();
    }
    return l_bResult;
  }
  void Link_UQYOQYIUNM_blank() {
    Link_UQYOQYIUNM_blank("");
  }
  void Link_UQYOQYIUNM_blank(String p_cType) {
    w_ATTIV = "";
  }
  protected boolean Link_QFJRACGINU() {
    return Link_QFJRACGINU("Full");
  }
  protected boolean Link_QFJRACGINU(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ATTIV,"C",10,0),m_cServer_tbtipatt_p,w_ATTIV);
      if (m_Ctx.IsSharedTemp("tbtipatt_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipatt_p,"select CODICE,RISCHIO,FLGALTO from "+m_cPhName_tbtipatt_p+((m_cPhName_tbtipatt_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIV = l_rsLink.GetString("CODICE");
          w_RATTIV = l_rsLink.GetDouble("RISCHIO");
          w_FLGALTO = l_rsLink.GetDouble("FLGALTO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_QFJRACGINU_blank();
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
      Link_QFJRACGINU_blank();
    }
    return l_bResult;
  }
  void Link_QFJRACGINU_blank() {
    Link_QFJRACGINU_blank("");
  }
  void Link_QFJRACGINU_blank(String p_cType) {
    w_RATTIV = 0;
    w_FLGALTO = 0;
  }
  protected boolean Link_HLXRSSMBIW() {
    return Link_HLXRSSMBIW("Full");
  }
  protected boolean Link_HLXRSSMBIW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_COMPORT))) {
      String l_OldValue = w_COMPORT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COMPORT,"C",5,0),m_cServer_tbcondotta,w_COMPORT);
      if (m_Ctx.IsSharedTemp("tbcondotta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcondotta,"select CODICE,DESCRI from "+m_cPhName_tbcondotta+((m_cPhName_tbcondotta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COMPORT,"C",200,0),m_cServer_tbcondotta,w_COMPORT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcondotta,"select CODICE,DESCRI from "+m_cPhName_tbcondotta+((m_cPhName_tbcondotta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_COMPORT = l_rsLink.GetString("CODICE");
          w_xdesccomp = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HLXRSSMBIW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_COMPORT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","COMPORT");
          }
          m_cLastWorkVarError = "COMPORT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HLXRSSMBIW_blank();
    }
    return l_bResult;
  }
  void Link_HLXRSSMBIW_blank() {
    w_COMPORT = "";
    w_xdesccomp = "";
  }
  protected boolean Link_KYTSUTYBUR() {
    return Link_KYTSUTYBUR("Full");
  }
  protected boolean Link_KYTSUTYBUR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_COMPORT))) {
      String l_OldValue = w_COMPORT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COMPORT,"C",5,0),m_cServer_tbcondotta_p,w_COMPORT);
      if (m_Ctx.IsSharedTemp("tbcondotta_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcondotta_p,"select CODICE,RISCHIO from "+m_cPhName_tbcondotta_p+((m_cPhName_tbcondotta_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_COMPORT = l_rsLink.GetString("CODICE");
          w_RCOMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_KYTSUTYBUR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_COMPORT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","COMPORT");
          }
          m_cLastWorkVarError = "COMPORT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_KYTSUTYBUR_blank();
    }
    return l_bResult;
  }
  void Link_KYTSUTYBUR_blank() {
    w_COMPORT = "";
    w_RCOMP = 0;
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_TIPOPERS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOPERS = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOPERS = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
  public boolean Set_RAGSOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAGSOC = p_workVariableValue;
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
    return (CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139")) && CPLib.eq(w_gVerSim,"N");
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
    return (CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139")) && CPLib.eq(w_gVerSim,"N");
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
    return (CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139")) && CPLib.eq(w_gVerSim,"N");
  }
  public boolean Set_CODCAB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODCAB = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODCAB = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean BOTAJBWHHY_isObligatory() {
    // Condizione di obbligatorietà
    return (w_COMPLETA?(CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139")):false);
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
    return (CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139")) && CPLib.eq(w_gVerSim,"N");
  }
  public boolean Set_IDENT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDENT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDNASCOMUN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDNASCOMUN = p_workVariableValue;
    l_bResult = Link_BYPEBFEOAJ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDNASCOMUN = "";
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDNASSTATO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDNASSTATO = p_workVariableValue;
    l_bResult = Link_IOAMSFCCVV();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDNASSTATO = "";
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AUTRILASC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AUTRILASC = p_workVariableValue;
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
    // 
    l_bResult = (w_COMPLETA?arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,w_PAESE,w_CFESTERO):true);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "Codice Fiscale Errato";
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
  public boolean Set_PARTIVA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PARTIVA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOTGRUP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOTGRUP = p_workVariableValue;
    l_bResult = Link_LLYIGAMXRH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if (l_bResult &&  ! (Check_JMNVEFUDOC(false))) {
      m_nLastError = 2;
      w_SOTGRUP = "";
      return false;
    }
    if (l_bResult &&  ! (Check_AJUVKUBCCO(false))) {
      m_nLastError = 2;
      w_SOTGRUP = "";
      return false;
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOTGRUP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ATTIV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ATTIV = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_SAQTIHOALW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ATTIV = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ATTIV = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean SAQTIHOALW_isObligatory() {
    // Condizione di obbligatorietà
    return (w_COMPLETA?CPLib.eq(w_tipsot,"1"):false);
  }
  public boolean Set_SETTSINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SETTSINT = p_workVariableValue;
    l_bResult = Link_ZGNLLSFQHC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SETTSINT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNES(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNES = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNES = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNES = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public String getDefault_CONNES() {
    // Gestione del default
    return w_CODFISC;
  }
  public boolean Set_NOSARA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOSARA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOTIT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOTIT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgaggfam(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgaggfam = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARETT(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATARETT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAFINE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAFINE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DISATTIVO(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DISATTIVO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOSOGGETTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOSOGGETTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAPSEGNA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPSEGNA = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_chk_tiporapportoR.Make(m_Ctx,this).Run(w_TIPOSOGGETTO,w_RAPSEGNA);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "Tipo rapporto non valido per il tipo soggetto selezionato!";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAPSEGNA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean JFJPGOWVYJ_isObligatory() {
    // Condizione di obbligatorietà
    return  ! (CPLib.Empty(w_TIPOSOGGETTO));
  }
  public boolean Set_SOGAFFIDATARIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOGAFFIDATARIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAUSALE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAUSALE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FATTURATO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FATTURATO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGNOTRIM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGNOTRIM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAIDENT(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAIDENT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COMPLETA(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COMPLETA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODLEGRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODLEGRAP = p_workVariableValue;
    l_bResult = Link_CKHRNQSKKQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODLEGRAP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BANCABEN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BANCABEN = p_workVariableValue;
    l_bResult = Link_DQZNJUSTLN();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_BANCABEN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATASEGN(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATASEGN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARAUT(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATARAUT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FATCA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FATCA = p_workVariableValue;
    l_bResult = Link_RKHMYOIJDM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_FATCA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ODB(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ODB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CITTADIN1(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CITTADIN1 = p_workVariableValue;
    l_bResult = Link_CJBEXKJOQO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CITTADIN1 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CITTADIN2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CITTADIN2 = p_workVariableValue;
    l_bResult = Link_UNRQNVVFTK();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CITTADIN2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RESFISC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RESFISC = p_workVariableValue;
    l_bResult = Link_OSLBLDODHQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RESFISC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AREAGEO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AREAGEO = p_workVariableValue;
    l_bResult = Link_NXVXQSLAGM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAREA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAREA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PKTBSPECIE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PKTBSPECIE = p_workVariableValue;
    l_bResult = Link_VHXDWWHVXF();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PKTBSPECIE = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PKTBSPECIE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RNATGIU(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RNATGIU = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ATTIVR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ATTIVR = p_workVariableValue;
    l_bResult = Link_UQYOQYIUNM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ATTIVR = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RATTIV(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RATTIV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COMPORT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COMPORT = p_workVariableValue;
    l_bResult = Link_HLXRSSMBIW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_COMPORT = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_COMPORT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RCOMP(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RCOMP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RISGLOB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RISGLOB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAPROF(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAPROF = p_workVariableValue;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CRIME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CRIME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MITIG(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MITIG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MITIGDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MITIGDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VERIFICA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VERIFICA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOTERIS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOTERIS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_status(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_status = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_COGNOME() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_NOME() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_RAGSOC() {
    return CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_IDNASCOMUN() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_NASCOMUN() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.Empty(CPLib.LRTrim(w_IDNASCOMUN)) && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_TIPINTER() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.Empty(CPLib.LRTrim(w_IDNASCOMUN)) && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_IDNASSTATO() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_NASSTATO() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.Empty(CPLib.LRTrim(w_IDNASSTATO)) && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_SESSO() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_DATANASC() {
    return CPLib.ne(w_TIPOPERS,"G") && CPLib.ne(w_xFLGANAVAL,"S");
  }
  public boolean getWritable_TIPODOC() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getWritable_NUMDOCUM() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getWritable_DATARILASC() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getWritable_DATAVALI() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getWritable_AUTRILASC() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getWritable_CODFISC() {
    return CPLib.ne(w_xFLGVALIDO,"S");
  }
  public boolean getWritable_PARTIVA() {
    return CPLib.ne(w_TIPOPERS,"P");
  }
  public boolean getWritable_RATTIV() {
    return CPLib.eq(w_FLGALTO,0);
  }
  public boolean getWritable_status() {
    return false;
  }
  public boolean getVisible_NOSARA() {
    return CPLib.ge(w_gTipInter,"30") && CPLib.le(w_gTipInter,"41");
  }
  public boolean getVisible_NOTIT() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getVisible_flgaggfam() {
    return CPLib.ge(w_gTipInter,"30") && CPLib.le(w_gTipInter,"41");
  }
  public boolean getVisible_DATARETT() {
    return true;
  }
  public boolean getVisible_DATAFINE() {
    return CPLib.Empty(w_DATAINI);
  }
  public boolean getVisible_DATAINI() {
    return CPLib.lt(w_gTipInter,"30") || CPLib.gt(w_gTipInter,"41");
  }
  public boolean getVisible_DISATTIVO() {
    return CPLib.lt(w_gTipInter,"30") || CPLib.gt(w_gTipInter,"41");
  }
  public boolean getVisible_COMPLETA() {
    return true;
  }
  public boolean getVisible_status() {
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
    if (CPLib.ne(o_gIntemediario,w_gIntemediario)) {
      l_bTmpRes = Link_LDTVEYLAXJ();
    }
    w_dataoggi = CPLib.Date();
    if (CPLib.ne(o_DESCCIT,w_DESCCIT) || CPLib.ne(o_idcitta,w_idcitta)) {
      l_bTmpRes = Link_YVIKEGPYPM();
    }
    if (CPLib.ne(o_idcitta,w_idcitta)) {
      l_bTmpRes = Link_TYEDHRZCMA();
    }
    if (CPLib.ne(o_IDNASCOMUN,w_IDNASCOMUN)) {
      w_nascomunid = w_IDNASCOMUN;
      l_bTmpRes = Link_ZRIWLTGERM();
    }
    if (CPLib.ne(o_IDNASSTATO,w_IDNASSTATO)) {
      w_nasstatoid = w_IDNASSTATO;
      l_bTmpRes = Link_AHFPACGVOQ();
    }
    if (CPLib.ne(o_RAMOGRUP,w_RAMOGRUP)) {
      l_bTmpRes = Link_RVNHQCXNEM();
    }
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP) || CPLib.ne(o_ATTIVR,w_ATTIVR) || CPLib.ne(o_tipsot,w_tipsot)) {
      l_bTmpRes = Link_SAQTIHOALW();
    }
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
      Calculation_DRKQLYFONU();
    }
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP) || CPLib.ne(o_ATTIVR,w_ATTIVR)) {
      Calculation_OIDLDZGYTQ();
    }
    if (CPLib.ne(o_DATANASC,w_DATANASC)) {
      Calculation_KCPGJNDBIS();
    }
    if (CPLib.ne(o_COGNOME,w_COGNOME) || CPLib.ne(o_NOME,w_NOME)) {
      Calculation_UEZIABOGNW();
    }
    if (CPLib.ne(o_NASSTATO,w_NASSTATO) || CPLib.ne(o_IDNASSTATO,w_IDNASSTATO)) {
      Calculation_DWHWPBJTAT();
    }
    if (CPLib.ne(o_DESCCIT,w_DESCCIT) || CPLib.ne(o_PAESE,w_PAESE)) {
      Calculation_VAVYJKHLRY();
    }
    if (CPLib.ne(o_CONNES,w_CONNES)) {
      l_bTmpRes = Link_MQYKJYJENJ();
    }
    if (CPLib.ne(o_AREAGEO,w_AREAGEO)) {
      l_bTmpRes = Link_JHEJMIHGSH();
    }
    if (CPLib.ne(o_PKTBSPECIE,w_PKTBSPECIE)) {
      l_bTmpRes = Link_DRJTSDRPVN();
    }
    if (CPLib.ne(o_ATTIV,w_ATTIV)) {
      l_bTmpRes = Link_QFJRACGINU();
    }
    if (CPLib.ne(o_COMPORT,w_COMPORT)) {
      l_bTmpRes = Link_KYTSUTYBUR();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_DRKQLYFONU() {
    w_ATTIV = (CPLib.eq(w_tipsot,"1")?w_ATTIV:CPLib.Space(10));
    Link_SAQTIHOALW();
  }
  void Calculation_OIDLDZGYTQ() {
    arrt_calcolasettR l_oRoutine_arrt_calcolasett;
    l_oRoutine_arrt_calcolasett = arrt_calcolasettR.Make(m_Ctx,this);
    l_oRoutine_arrt_calcolasett.Run();
  }
  void Calculation_XBFAONNKOG() {
    w_DATARETT = w_gDataVaria;
    arrt_storicopersR l_oRoutine_arrt_storicopers;
    l_oRoutine_arrt_storicopers = arrt_storicopersR.Make(m_Ctx,this);
    l_oRoutine_arrt_storicopers.pObj = this;
    l_oRoutine_arrt_storicopers.Run();
  }
  void Calculation_KCPGJNDBIS() {
    arrt_calccodfisR l_oRoutine_arrt_calccodfis;
    l_oRoutine_arrt_calccodfis = arrt_calccodfisR.Make(m_Ctx,this);
    l_oRoutine_arrt_calccodfis.Run();
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
    l_oRoutine_arrt_writelog.pTabella = "PERSONBO";
    l_oRoutine_arrt_writelog.pChiave = w_CONNES;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_KGBNFVNJHO() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "PERSONBO";
    l_oRoutine_arrt_writelog.pChiave = w_CONNES;
    l_oRoutine_arrt_writelog.Run();
    arrt_agg_famiglieR l_oRoutine_arrt_agg_famiglie;
    l_oRoutine_arrt_agg_famiglie = arrt_agg_famiglieR.Make(m_Ctx,this);
    l_oRoutine_arrt_agg_famiglie.Run();
    opert_imp_dati_soggettoR l_oRoutine_opert_imp_dati_soggetto;
    if (CPLib.eq(w_gTipInter,"31")) {
      l_oRoutine_opert_imp_dati_soggetto = opert_imp_dati_soggettoR.Make(m_Ctx,this);
      l_oRoutine_opert_imp_dati_soggetto.pIVA = w_PARTIVA;
      l_oRoutine_opert_imp_dati_soggetto.Run();
    }
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "PERSONBO";
    l_oRoutine_arrt_writelog.pChiave = w_CONNES;
    l_oRoutine_arrt_writelog.Run();
    arrt_crea_aggR l_oRoutine_arrt_crea_agg;
    l_oRoutine_arrt_crea_agg = arrt_crea_aggR.Make(m_Ctx,this);
    l_oRoutine_arrt_crea_agg.pCONNES = w_CONNES;
    l_oRoutine_arrt_crea_agg.Run();
  }
  void Calculation_DWHWPBJTAT() {
    w_TIPINTER = ( ! (CPLib.Empty(w_TIPINTER))?w_TIPINTER:( ! (CPLib.Empty(w_NASSTATO))?"EE":""));
  }
  void Calculation_VAVYJKHLRY() {
    w_PROVINCIA = (CPLib.eq(w_PAESE,"086")?w_PROVINCIA:"EE");
  }
  void Calculation_IIAFZWAADN() {
    arrt_delpersonboR l_oRoutine_arrt_delpersonbo;
    l_oRoutine_arrt_delpersonbo = arrt_delpersonboR.Make(m_Ctx,this);
    l_oRoutine_arrt_delpersonbo.w_CONNES = w_CONNES;
    l_oRoutine_arrt_delpersonbo.Run();
  }
  boolean Check_HBWSCTWHSU(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
    }
    return l_bResult;
  }
  boolean Check_IYNZUZHVVV(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_TIPODOC,w_TIPODOC) || CPLib.ne(o_PAESE,w_PAESE) || CPLib.ne(o_NUMDOCUM,w_NUMDOCUM) || CPLib.ne(o_DATARILASC,w_DATARILASC)) {
    }
    return l_bResult;
  }
  boolean Check_JMNVEFUDOC(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
    }
    return l_bResult;
  }
  boolean Check_AJUVKUBCCO(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
    }
    return l_bResult;
  }
  boolean Check_QKZODDNCJT(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_DATARILASC,w_DATARILASC) || CPLib.ne(o_DATAVALI,w_DATAVALI)) {
      l_bResult = ( ! (CPLib.Empty(w_DATAVALI)) &&  ! (CPLib.Empty(w_DATARILASC)) && CPLib.lt(w_DATAVALI,w_DATARILASC)?false:true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "La data di rilascio del documento deve essere inferiore alla data di fine validità";
      }
    }
    return l_bResult;
  }
  boolean Check_CGDEUUVXSN(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_DATARILASC,w_DATARILASC) || CPLib.ne(o_DATANASC,w_DATANASC)) {
      l_bResult = (w_COMPLETA?( ! (CPLib.Empty(w_DATARILASC)) &&  ! (CPLib.Empty(w_DATANASC)) && CPLib.gt(w_DATANASC,w_DATARILASC)?false:true):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "La data di rilascio del documento deve essere superiore alla data di nascita";
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
  public final static String[] m_KeyColumns = {"CONNES"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_personbo","personbo",m_KeyColumns,m_Ctx);
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
    op_codazi = m_Ctx.GetCompany();
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_dataoggi = CPLib.NullDate();
    w_TIPOPERS = "";
    w_COGNOME = "";
    w_NOME = "";
    w_CFESTERO = 0;
    w_RAGSOC = "";
    w_PAESE = "";
    w_DESCCIT = "";
    w_idcitta = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_IDENT = "";
    w_IDNASCOMUN = "";
    w_nascomunid = "";
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_IDNASSTATO = "";
    w_nasstatoid = "";
    w_NASSTATO = "";
    w_SESSO = "";
    w_DATANASC = CPLib.NullDate();
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_CONTO = "";
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_ATTIV = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_NOSARA = "";
    w_NOTIT = 0;
    w_flgaggfam = "";
    w_DATARETT = CPLib.NullDate();
    w_STATOREG = "";
    w_NUMPROG = "";
    w_PROGIMPORT = 0;
    w_OLDSETSIN = "";
    w_CRIMEDATE = CPLib.NullDate();
    w_PEPDATE = CPLib.NullDate();
    w_tipsot = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_DESCRI = "";
    w_xstatonas = "";
    w_finesae = CPLib.NullDate();
    w_finesint = CPLib.NullDate();
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
    w_xDSETSIN = "";
    w_xdesctipatt = "";
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesccomp = "";
    w_xITFLGPEP = "";
    w_DATAFINE = CPLib.NullDate();
    w_DATAINI = CPLib.NullDate();
    w_DISATTIVO = CPLib.NullDate();
    w_TIPOSOGGETTO = "";
    w_RAPSEGNA = "";
    w_SOGAFFIDATARIO = "";
    w_CAUSALE = 0;
    w_FATTURATO = 0;
    w_FLGNOTRIM = "";
    w_DATAIDENT = CPLib.NullDate();
    w_COMPLETA = false;
    w_CODINTER = "";
    w_NUMIMP = CPLib.NullDateTime();
    w_CODDIPE = "";
    w_SOSPMAF = "";
    w_OLDCONNES = "";
    w_DATEXTRA = CPLib.NullDate();
    w_ALLINEATO = 0;
    w_ALLINEATONOMECNOME = 0;
    w_RAGSOCOLD = "";
    w_PROGIMP_C = "";
    w_IDFILE = "";
    w_OLDCODFISC = "";
    w_MACROAGENTE = "";
    w_SPOTID = "";
    w_DATAVARAGE = CPLib.NullDate();
    w_SETTSINT2 = "";
    w_TELEF = "";
    w_TIPOORO = "";
    w_CODORO = "";
    w_FLGVALIDO = "";
    w_DAC6 = "";
    w_ALTRODOM = "";
    w_ALTROCAP = "";
    w_IMPORTOMAX = 0;
    w_FREQUENZA = "";
    w_NUMOPERAZ = 0;
    w_DATASIGN = CPLib.NullDate();
    w_IDBASE = "";
    w_FLAGDAC6 = 0;
    w_CONNES = "";
    w_NOTE = "";
    w_CODLEGRAP = "";
    w_xRAGLEGRAP = "";
    w_xIDLEGRAP = "";
    w_ragbanben = "";
    w_xDESDIPE = "";
    w_BANCABEN = "";
    w_DATASEGN = CPLib.NullDate();
    w_DATARAUT = CPLib.NullDate();
    w_FATCA = "";
    w_xdesfatca = "";
    w_TIN = "";
    w_ODB = 0;
    w_CITTADIN1 = "";
    w_CITTADIN2 = "";
    w_RESFISC = "";
    w_xDesCit1 = "";
    w_xDesCit2 = "";
    w_xResFis = "";
    w_AREAGEO = "";
    w_AREAGEO = "";
    w_RAREA = 0;
    w_PKTBSPECIE = "";
    w_PKTBSPECIE = "";
    w_RNATGIU = 0;
    w_ATTIVR = "";
    w_ATTIV = "";
    w_RATTIV = 0;
    w_COMPORT = "";
    w_COMPORT = "";
    w_RCOMP = 0;
    w_DOCFILE = "";
    w_RISGLOB = "";
    w_DATAPROF = CPLib.NullDate();
    w_DATAREVPROF = CPLib.NullDate();
    w_PEP = "";
    w_CRIME = "";
    w_MITIG = 0;
    w_MITIGDOC = "";
    w_VERIFICA = "";
    w_FLGALTO = 0;
    w_NOTERIS = "";
    w_status = "";
    m_cWv_ardt_personbo_dip = "";
    m_cWv_armt_personbo_agg = "";
    m_cWv_ardt_soggope = "";
    m_cWv_ardt_fatca_ind = "";
    m_cWv_ardt_patrimonio = "";
    m_cWv_ardt_reddito = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_TIPOPERS = CPLib.GetProperty(p,"TIPOPERS",w_TIPOPERS,0);
      w_COGNOME = CPLib.GetProperty(p,"COGNOME",w_COGNOME,0);
      w_NOME = CPLib.GetProperty(p,"NOME",w_NOME,0);
      w_CFESTERO = CPLib.GetProperty(p,"CFESTERO",w_CFESTERO,0);
      w_RAGSOC = CPLib.GetProperty(p,"RAGSOC",w_RAGSOC,0);
      w_PAESE = CPLib.GetProperty(p,"PAESE",w_PAESE,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_idcitta = CPLib.GetProperty(p,"idcitta",w_idcitta,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CAP = CPLib.GetProperty(p,"CAP",w_CAP,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_DOMICILIO = CPLib.GetProperty(p,"DOMICILIO",w_DOMICILIO,0);
      w_IDENT = CPLib.GetProperty(p,"IDENT",w_IDENT,0);
      w_IDNASCOMUN = CPLib.GetProperty(p,"IDNASCOMUN",w_IDNASCOMUN,0);
      w_NASCOMUN = CPLib.GetProperty(p,"NASCOMUN",w_NASCOMUN,0);
      w_TIPINTER = CPLib.GetProperty(p,"TIPINTER",w_TIPINTER,0);
      w_IDNASSTATO = CPLib.GetProperty(p,"IDNASSTATO",w_IDNASSTATO,0);
      w_NASSTATO = CPLib.GetProperty(p,"NASSTATO",w_NASSTATO,0);
      w_SESSO = CPLib.GetProperty(p,"SESSO",w_SESSO,0);
      w_DATANASC = CPLib.GetProperty(p,"DATANASC",w_DATANASC,0);
      w_TIPODOC = CPLib.GetProperty(p,"TIPODOC",w_TIPODOC,0);
      w_NUMDOCUM = CPLib.GetProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_AUTRILASC = CPLib.GetProperty(p,"AUTRILASC",w_AUTRILASC,0);
      w_CODFISC = CPLib.GetProperty(p,"CODFISC",w_CODFISC,0);
      w_PARTIVA = CPLib.GetProperty(p,"PARTIVA",w_PARTIVA,0);
      w_CONTO = CPLib.GetProperty(p,"CONTO",w_CONTO,0);
      w_SOTGRUP = CPLib.GetProperty(p,"SOTGRUP",w_SOTGRUP,0);
      w_RAMOGRUP = CPLib.GetProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
      w_ATTIV = CPLib.GetProperty(p,"ATTIV",w_ATTIV,0);
      w_SETTSINT = CPLib.GetProperty(p,"SETTSINT",w_SETTSINT,0);
      w_CONNES = CPLib.GetProperty(p,"CONNES",w_CONNES,0);
      w_NOSARA = CPLib.GetProperty(p,"NOSARA",w_NOSARA,0);
      w_NOTIT = CPLib.GetProperty(p,"NOTIT",w_NOTIT,0);
      w_PROGIMPORT = CPLib.GetProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
      op_PROGIMPORT = CPLib.GetProperty(p,"op_PROGIMPORT",0,0);
      w_OLDSETSIN = CPLib.GetProperty(p,"OLDSETSIN",w_OLDSETSIN,0);
      w_CRIMEDATE = CPLib.GetProperty(p,"CRIMEDATE",w_CRIMEDATE,0);
      w_PEPDATE = CPLib.GetProperty(p,"PEPDATE",w_PEPDATE,0);
      w_NOTE = CPLib.GetProperty(p,"NOTE",w_NOTE,0);
      w_CODLEGRAP = CPLib.GetProperty(p,"CODLEGRAP",w_CODLEGRAP,0);
      w_FATCA = CPLib.GetProperty(p,"FATCA",w_FATCA,0);
      w_TIN = CPLib.GetProperty(p,"TIN",w_TIN,0);
      w_ODB = CPLib.GetProperty(p,"ODB",w_ODB,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_PKTBSPECIE = CPLib.GetProperty(p,"PKTBSPECIE",w_PKTBSPECIE,0);
      w_RNATGIU = CPLib.GetProperty(p,"RNATGIU",w_RNATGIU,0);
      w_RATTIV = CPLib.GetProperty(p,"RATTIV",w_RATTIV,0);
      w_COMPORT = CPLib.GetProperty(p,"COMPORT",w_COMPORT,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_DOCFILE = CPLib.GetProperty(p,"DOCFILE",w_DOCFILE,0);
      w_RISGLOB = CPLib.GetProperty(p,"RISGLOB",w_RISGLOB,0);
      w_DATAPROF = CPLib.GetProperty(p,"DATAPROF",w_DATAPROF,0);
      w_DATAREVPROF = CPLib.GetProperty(p,"DATAREVPROF",w_DATAREVPROF,0);
      w_PEP = CPLib.GetProperty(p,"PEP",w_PEP,0);
      w_CRIME = CPLib.GetProperty(p,"CRIME",w_CRIME,0);
      w_MITIG = CPLib.GetProperty(p,"MITIG",w_MITIG,0);
      w_MITIGDOC = CPLib.GetProperty(p,"MITIGDOC",w_MITIGDOC,0);
      w_DATAFINE = CPLib.GetProperty(p,"DATAFINE",w_DATAFINE,0);
      w_DATAINI = CPLib.GetProperty(p,"DATAINI",w_DATAINI,0);
      w_DISATTIVO = CPLib.GetProperty(p,"DISATTIVO",w_DISATTIVO,0);
      w_TIPOSOGGETTO = CPLib.GetProperty(p,"TIPOSOGGETTO",w_TIPOSOGGETTO,0);
      w_RAPSEGNA = CPLib.GetProperty(p,"RAPSEGNA",w_RAPSEGNA,0);
      w_SOGAFFIDATARIO = CPLib.GetProperty(p,"SOGAFFIDATARIO",w_SOGAFFIDATARIO,0);
      w_CAUSALE = CPLib.GetProperty(p,"CAUSALE",w_CAUSALE,0);
      w_FATTURATO = CPLib.GetProperty(p,"FATTURATO",w_FATTURATO,0);
      w_FLGNOTRIM = CPLib.GetProperty(p,"FLGNOTRIM",w_FLGNOTRIM,0);
      w_DATAIDENT = CPLib.GetProperty(p,"DATAIDENT",w_DATAIDENT,0);
      w_CITTADIN1 = CPLib.GetProperty(p,"CITTADIN1",w_CITTADIN1,0);
      w_CITTADIN2 = CPLib.GetProperty(p,"CITTADIN2",w_CITTADIN2,0);
      w_RESFISC = CPLib.GetProperty(p,"RESFISC",w_RESFISC,0);
      w_BANCABEN = CPLib.GetProperty(p,"BANCABEN",w_BANCABEN,0);
      w_DATASEGN = CPLib.GetProperty(p,"DATASEGN",w_DATASEGN,0);
      w_DATARAUT = CPLib.GetProperty(p,"DATARAUT",w_DATARAUT,0);
      w_VERIFICA = CPLib.GetProperty(p,"VERIFICA",w_VERIFICA,0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_NUMIMP = CPLib.GetProperty(p,"NUMIMP",w_NUMIMP,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_SOSPMAF = CPLib.GetProperty(p,"SOSPMAF",w_SOSPMAF,0);
      w_OLDCONNES = CPLib.GetProperty(p,"OLDCONNES",w_OLDCONNES,0);
      w_DATEXTRA = CPLib.GetProperty(p,"DATEXTRA",w_DATEXTRA,0);
      w_ALLINEATO = CPLib.GetProperty(p,"ALLINEATO",w_ALLINEATO,0);
      w_ALLINEATONOMECNOME = CPLib.GetProperty(p,"ALLINEATONOMECNOME",w_ALLINEATONOMECNOME,0);
      w_RAGSOCOLD = CPLib.GetProperty(p,"RAGSOCOLD",w_RAGSOCOLD,0);
      w_PROGIMP_C = CPLib.GetProperty(p,"PROGIMP_C",w_PROGIMP_C,0);
      w_IDFILE = CPLib.GetProperty(p,"IDFILE",w_IDFILE,0);
      w_OLDCODFISC = CPLib.GetProperty(p,"OLDCODFISC",w_OLDCODFISC,0);
      w_MACROAGENTE = CPLib.GetProperty(p,"MACROAGENTE",w_MACROAGENTE,0);
      w_SPOTID = CPLib.GetProperty(p,"SPOTID",w_SPOTID,0);
      w_DATAVARAGE = CPLib.GetProperty(p,"DATAVARAGE",w_DATAVARAGE,0);
      w_SETTSINT2 = CPLib.GetProperty(p,"SETTSINT2",w_SETTSINT2,0);
      w_TELEF = CPLib.GetProperty(p,"TELEF",w_TELEF,0);
      w_TIPOORO = CPLib.GetProperty(p,"TIPOORO",w_TIPOORO,0);
      w_CODORO = CPLib.GetProperty(p,"CODORO",w_CODORO,0);
      w_FLGVALIDO = CPLib.GetProperty(p,"FLGVALIDO",w_FLGVALIDO,0);
      w_DAC6 = CPLib.GetProperty(p,"DAC6",w_DAC6,0);
      w_ALTRODOM = CPLib.GetProperty(p,"ALTRODOM",w_ALTRODOM,0);
      w_ALTROCAP = CPLib.GetProperty(p,"ALTROCAP",w_ALTROCAP,0);
      w_IMPORTOMAX = CPLib.GetProperty(p,"IMPORTOMAX",w_IMPORTOMAX,0);
      w_FREQUENZA = CPLib.GetProperty(p,"FREQUENZA",w_FREQUENZA,0);
      w_NUMOPERAZ = CPLib.GetProperty(p,"NUMOPERAZ",w_NUMOPERAZ,0);
      w_DATASIGN = CPLib.GetProperty(p,"DATASIGN",w_DATASIGN,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_FLAGDAC6 = CPLib.GetProperty(p,"FLAGDAC6",w_FLAGDAC6,0);
      w_NOTERIS = CPLib.GetProperty(p,"NOTERIS",w_NOTERIS,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_gSeekAos = CPLib.GetProperty(p,"gSeekAos",w_gSeekAos,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_gVerSim = CPLib.GetProperty(p,"gVerSim",w_gVerSim,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_dataoggi = CPLib.GetProperty(p,"dataoggi",w_dataoggi,0);
      w_nascomunid = CPLib.GetProperty(p,"nascomunid",w_nascomunid,0);
      w_nasstatoid = CPLib.GetProperty(p,"nasstatoid",w_nasstatoid,0);
      w_flgaggfam = CPLib.GetProperty(p,"flgaggfam",w_flgaggfam,0);
      w_DATARETT = CPLib.GetProperty(p,"DATARETT",w_DATARETT,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_tipsot = CPLib.GetProperty(p,"tipsot",w_tipsot,0);
      w_DESCSGRU = CPLib.GetProperty(p,"DESCSGRU",w_DESCSGRU,0);
      w_DESCRAMGRU = CPLib.GetProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
      w_DESCUIC = CPLib.GetProperty(p,"DESCUIC",w_DESCUIC,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_xstatonas = CPLib.GetProperty(p,"xstatonas",w_xstatonas,0);
      w_finesae = CPLib.GetProperty(p,"finesae",w_finesae,0);
      w_finesint = CPLib.GetProperty(p,"finesint",w_finesint,0);
      w_xFLGVALIDO = CPLib.GetProperty(p,"xFLGVALIDO",w_xFLGVALIDO,0);
      w_xFLGANAVAL = CPLib.GetProperty(p,"xFLGANAVAL",w_xFLGANAVAL,0);
      w_ragbanben = CPLib.GetProperty(p,"ragbanben",w_ragbanben,0);
      w_xdesfatca = CPLib.GetProperty(p,"xdesfatca",w_xdesfatca,0);
      w_ATTIVR = CPLib.GetProperty(p,"ATTIVR",w_ATTIVR,0);
      w_xDESDIPE = CPLib.GetProperty(p,"xDESDIPE",w_xDESDIPE,0);
      w_xDSETSIN = CPLib.GetProperty(p,"xDSETSIN",w_xDSETSIN,0);
      w_xdesctipatt = CPLib.GetProperty(p,"xdesctipatt",w_xdesctipatt,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescnatgiu = CPLib.GetProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
      w_xdesccomp = CPLib.GetProperty(p,"xdesccomp",w_xdesccomp,0);
      w_xITFLGPEP = CPLib.GetProperty(p,"xITFLGPEP",w_xITFLGPEP,0);
      w_xDesCit1 = CPLib.GetProperty(p,"xDesCit1",w_xDesCit1,0);
      w_xDesCit2 = CPLib.GetProperty(p,"xDesCit2",w_xDesCit2,0);
      w_xResFis = CPLib.GetProperty(p,"xResFis",w_xResFis,0);
      w_xRAGLEGRAP = CPLib.GetProperty(p,"xRAGLEGRAP",w_xRAGLEGRAP,0);
      w_xIDLEGRAP = CPLib.GetProperty(p,"xIDLEGRAP",w_xIDLEGRAP,0);
      w_FLGALTO = CPLib.GetProperty(p,"FLGALTO",w_FLGALTO,0);
      w_COMPLETA = CPLib.GetProperty(p,"COMPLETA",w_COMPLETA,0);
      w_status = CPLib.GetProperty(p,"status",w_status,0);
      m_cWv_ardt_personbo_dip = CPLib.GetProperty(p,"m_cWv_ardt_personbo_dip",m_cWv_ardt_personbo_dip,0);
      m_cWv_armt_personbo_agg = CPLib.GetProperty(p,"m_cWv_armt_personbo_agg",m_cWv_armt_personbo_agg,0);
      m_cWv_ardt_soggope = CPLib.GetProperty(p,"m_cWv_ardt_soggope",m_cWv_ardt_soggope,0);
      m_cWv_ardt_fatca_ind = CPLib.GetProperty(p,"m_cWv_ardt_fatca_ind",m_cWv_ardt_fatca_ind,0);
      m_cWv_ardt_patrimonio = CPLib.GetProperty(p,"m_cWv_ardt_patrimonio",m_cWv_ardt_patrimonio,0);
      m_cWv_ardt_reddito = CPLib.GetProperty(p,"m_cWv_ardt_reddito",m_cWv_ardt_reddito,0);
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
    items = tables.get("intermbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("intermbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","ITFLGPEP","FLGAGGFAM"});
    map.put("rd_var",new String[]{"w_gIntemediario","w_xITFLGPEP","w_flgaggfam"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u00001\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Intermediario\u0000Collegamento Liste PEP/Crime\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("intermbo\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcittna");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcittna",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","CITTA","PROV"});
    map.put("rd_var",new String[]{"w_nascomunid","w_NASCOMUN","w_TIPINTER"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40\u000030\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Luogo di Nascita\u0000Prov.",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcittna\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstatna");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstatna",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","DESCRI"});
    map.put("rd_var",new String[]{"w_nasstatoid","w_NASSTATO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Stato di nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstatna\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("personbo_agg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo_agg",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","FLGVALIDO","FLGANAVAL"});
    map.put("rd_var",new String[]{"w_CONNES","w_xFLGVALIDO","w_xFLGANAVAL"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u00001\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Collegamento\u0000Codice Fiscale Validato\u0000Dati Anagrafici Validati",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo_agg\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbareegeog_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbareegeog_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_AREAGEO","w_RAREA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbareegeog_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbspecie_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbspecie_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSPE","RISCHIO"});
    map.put("rd_var",new String[]{"w_PKTBSPECIE","w_RNATGIU"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbspecie_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CODICE","CODICE"});
    map.put("rd_var",new String[]{"w_ATTIVR","w_ATTIV"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000010",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codifica ATECO\u0000Codifica ATECO",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000iif(w_COMPLETA,w_tipsot = '1',False)",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipatt\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipatt_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipatt_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO","FLGALTO"});
    map.put("rd_var",new String[]{"w_ATTIV","w_RATTIV","w_FLGALTO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u00003\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codifica ATECO\u0000\u0000Attività ad alto rischio",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("iif(w_COMPLETA,w_tipsot = '1',False)\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipatt_p\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcondotta_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcondotta_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_COMPORT","w_RCOMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcondotta_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("personbo_dip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo_dip",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"CONNES"});
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
    map.put("property.value",zeroSplit.split("personbo_dip\u0000false\u0000false\u00001\u00000\u0000ardt_personbo_dip\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("personbo_agg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo_agg",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"CONNES"});
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
    map.put("property.value",zeroSplit.split("personbo_agg\u0000false\u0000false\u00001\u00000\u0000armt_personbo_agg\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("soggope");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("soggope",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"COLLEG"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"COLLEG"});
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
    map.put("property.value",zeroSplit.split("soggope\u0000false\u0000false\u00001\u00000\u0000ardt_soggope\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("fatca_ind");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("fatca_ind",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"CONNES"});
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
    map.put("property.value",zeroSplit.split("fatca_ind\u0000false\u0000false\u00001\u00000\u0000ardt_fatca_ind\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("patrimonio");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("patrimonio",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"CONNES"});
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
    map.put("property.value",zeroSplit.split("patrimonio\u0000false\u0000false\u00001\u00000\u0000ardt_patrimonio\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("reddito");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("reddito",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES"});
    map.put("rd_var",new String[]{"w_CONNES"});
    map.put("wr_var",new String[]{"w_CONNES"});
    map.put("wr_field",new String[]{"CONNES"});
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
    map.put("property.value",zeroSplit.split("reddito\u0000false\u0000false\u00001\u00000\u0000ardt_reddito\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","IDBASE"});
    map.put("rd_var",new String[]{"w_DESCCIT","w_idcitta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città\u0000Codice Città",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"IDBASE","CAB","PROV","CAP"});
    map.put("rd_var",new String[]{"w_idcitta","w_CODCAB","w_PROVINCIA","w_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40\u00006\u00002\u00009",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Città\u0000CAB\u0000Provincia\u0000CAP",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000iif(w_COMPLETA,(w_PAESE='086' or w_PAESE='139'),False)\u0000(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'\u0000(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Comuni\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcittna");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcittna",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE"});
    map.put("rd_var",new String[]{"w_IDNASCOMUN"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ID Comune Nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key7",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcittna\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstatna");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstatna",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","DESCRI"});
    map.put("rd_var",new String[]{"w_IDNASSTATO","w_xstatonas"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000050",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ID Stato Nascita\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key8\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstatna\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati di Nascita\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipdoc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipdoc",items);
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
    map.put("property.value",zeroSplit.split("tbtipdoc\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Documento\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstgru");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstgru",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SOTGRU","DESCRI","TIPOSOT","DATAFINE"});
    map.put("rd_var",new String[]{"w_SOTGRUP","w_DESCSGRU","w_tipsot","w_finesae"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000D",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000060\u00001\u00008",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Sottogruppo Att. Ec.\u0000Descrizione\u0000Tipo\u0000Data Fine Validità",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstgru\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Sottogruppi Att. Economiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbramgru");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbramgru",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAMGRU","DESCRI"});
    map.put("rd_var",new String[]{"w_RAMOGRUP","w_DESCRAMGRU"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Ramo Gruppo Att. Ec.\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbramgru\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000ramgru\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbsetsin");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbsetsin",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SETSINT","DATAFINE","DESCRI"});
    map.put("rd_var",new String[]{"w_SETTSINT","w_finesint","w_xDSETSIN"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000D\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u00008\u0000200",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Settorizzazione UIC\u0000Data Fine Validità\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsetsin\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Setto Sintetica UIC\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC","IDBASE"});
    map.put("rd_var",new String[]{"w_CODLEGRAP","w_xRAGLEGRAP","w_xIDLEGRAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u000010",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Legale Rappresentante\u0000Ragione Sociale\u0000Chiave Primaria",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00003\u00000\u0000opemt_personbo\u0000false\u0000false\u0000Elenco Soggetti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("inter2bo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("inter2bo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","RAGSOC"});
    map.put("rd_var",new String[]{"w_BANCABEN","w_ragbanben"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Banca se Beneficiario\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("inter2bo\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Banche / Intermediari \u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_FATCA","w_xdesfatca"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato Res. Legale FATCA\u0000Descrizione",-1));
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
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_CITTADIN1","w_xDesCit1"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Cittadinanza 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_CITTADIN2","w_xDesCit2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_RESFISC","w_xResFis"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_personbo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_personbo",child);
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
    // Prenota i progressivi
    InitAutonumber();
    op_codazi = m_Ctx.GetCompany();
    ardt_personbo_dip = new ardt_personbo_dipBO(m_Ctx);
    armt_personbo_agg = new armt_personbo_aggBO(m_Ctx);
    ardt_soggope = new ardt_soggopeBO(m_Ctx);
    ardt_fatca_ind = new ardt_fatca_indBO(m_Ctx);
    ardt_patrimonio = new ardt_patrimonioBO(m_Ctx);
    ardt_reddito = new ardt_redditoBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_personbo",m_Ctx);
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
    if (CPLib.Empty(w_TIPOPERS)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPOPERS));
      String obblMsgError = m_Ctx.Translate("Tipo Soggetto")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPOPERS = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPOPERS";
      }
    } else if (CPLib.Empty(w_PAESE)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PAESE));
      String obblMsgError = m_Ctx.Translate("Stato")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PAESE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PAESE";
      }
    } else if (CPLib.Empty(w_DESCCIT) && ODAYKSRECA_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DESCCIT));
      String obblMsgError = m_Ctx.Translate("Città")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DESCCIT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DESCCIT";
      }
    } else if (CPLib.Empty(w_PROVINCIA) && NOTZPDMYIA_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROVINCIA));
      String obblMsgError = m_Ctx.Translate("Provincia")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROVINCIA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROVINCIA";
      }
    } else if (CPLib.Empty(w_CAP) && RDAVOEETJG_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CAP));
      String obblMsgError = m_Ctx.Translate("CAP")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CAP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CAP";
      }
    } else if (CPLib.Empty(w_CODCAB) && BOTAJBWHHY_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODCAB));
      String obblMsgError = m_Ctx.Translate("CAB")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODCAB = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODCAB";
      }
    } else if (CPLib.Empty(w_DOMICILIO) && VYLHWTRQNX_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DOMICILIO));
      String obblMsgError = m_Ctx.Translate("Indirizzo")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DOMICILIO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DOMICILIO";
      }
    } else if ((CPLib.ne(w_xFLGVALIDO,"S")) && ( ! ((w_COMPLETA?arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,w_PAESE,w_CFESTERO):true)))) {
      m_cLastMsgError = m_Ctx.Translate("Codice Fiscale Errato");
      l_bNoCheck = false;
      l_bResult = false;
      w_CODFISC = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODFISC";
      }
    } else if ( ! (CPLib.Empty(w_SOTGRUP)) &&  ! (CPLib.ge(w_finesae,CPLib.Date()) || CPLib.Empty(w_finesae))) {
      m_cLastMsgError = m_Ctx.Translate("Non è possibile selezionare il Sottogruppo in quanto non più valido!");
      l_bNoCheck = false;
      l_bResult = false;
      w_SOTGRUP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOTGRUP";
      }
    } else if ((CPLib.Empty(w_ATTIV) && SAQTIHOALW_isObligatory()) || ( ! (CPLib.Empty(w_ATTIV)) &&  ! ((w_COMPLETA?arfn_chkatecoR.Make(m_Ctx,this).Run(w_SOTGRUP,w_ATTIV) || CPLib.ne(w_tipsot,"1"):true)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_ATTIV));
      String obblMsgError = m_Ctx.Translate("Codifica ATECO")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("Codice ATECO non valido per il SAE selezionato!");
      } else {
        m_cLastMsgError = m_Ctx.Translate("Codice ATECO non valido per il SAE selezionato!");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_ATTIV = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "ATTIV";
      }
    } else if ( ! (CPLib.Empty(w_SETTSINT)) &&  ! (arfn_chksintR.Make(m_Ctx,this).Run(w_SETTSINT))) {
      m_cLastMsgError = m_Ctx.Translate("Non è possibile selezionare il Settore Sintetico in quanto non più valido!");
      l_bNoCheck = false;
      l_bResult = false;
      w_SETTSINT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SETTSINT";
      }
    } else if (CPLib.Empty(w_CONNES)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CONNES));
      String obblMsgError = m_Ctx.Translate("Codice Collegamento")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CONNES = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CONNES";
      }
    } else if ((CPLib.Empty(w_RAPSEGNA) && JFJPGOWVYJ_isObligatory()) || ( ! (arfn_chk_tiporapportoR.Make(m_Ctx,this).Run(w_TIPOSOGGETTO,w_RAPSEGNA)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_RAPSEGNA));
      String obblMsgError = m_Ctx.Translate("Tipo Rapporto")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("Tipo rapporto non valido per il tipo soggetto selezionato!");
      } else {
        m_cLastMsgError = m_Ctx.Translate("Tipo rapporto non valido per il tipo soggetto selezionato!");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_RAPSEGNA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "RAPSEGNA";
      }
    } else if ( ! (Check_HBWSCTWHSU(true))) {
      l_bResult = false;
    } else if ( ! (Check_IYNZUZHVVV(true))) {
      l_bResult = false;
    } else if ( ! (Check_JMNVEFUDOC(true))) {
      l_bResult = false;
    } else if ( ! (Check_AJUVKUBCCO(true))) {
      l_bResult = false;
    } else if ( ! (Check_QKZODDNCJT(true))) {
      l_bResult = false;
    } else if ( ! (Check_CGDEUUVXSN(true))) {
      l_bResult = false;
    }
    if (l_bResult && (( ! (ardt_personbo_dip.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_personbo_dip)) || ( ! (ardt_personbo_dip.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_personbo_dip)))) {
      ardt_personbo_dip.SetFromContext(m_cWv_ardt_personbo_dip);
      m_cWv_ardt_personbo_dip = "_not_empty_";
    }
    if (l_bResult && (ardt_personbo_dip.m_bLoaded || ardt_personbo_dip.m_bUpdated)) {
      l_bResult = l_bResult && ardt_personbo_dip.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_personbo_dip.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (armt_personbo_agg.m_bLoaded) && CPLib.IsLoaded(m_cWv_armt_personbo_agg)) || ( ! (armt_personbo_agg.m_bUpdated) && CPLib.IsUpdated(m_cWv_armt_personbo_agg)))) {
      armt_personbo_agg.SetFromContext(m_cWv_armt_personbo_agg);
      m_cWv_armt_personbo_agg = "_not_empty_";
    }
    if (l_bResult && (armt_personbo_agg.m_bLoaded || armt_personbo_agg.m_bUpdated)) {
      l_bResult = l_bResult && armt_personbo_agg.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = armt_personbo_agg.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_soggope.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_soggope)) || ( ! (ardt_soggope.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_soggope)))) {
      ardt_soggope.SetFromContext(m_cWv_ardt_soggope);
      m_cWv_ardt_soggope = "_not_empty_";
    }
    if (l_bResult && (ardt_soggope.m_bLoaded || ardt_soggope.m_bUpdated)) {
      l_bResult = l_bResult && ardt_soggope.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_soggope.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_fatca_ind.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_fatca_ind)) || ( ! (ardt_fatca_ind.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_fatca_ind)))) {
      ardt_fatca_ind.SetFromContext(m_cWv_ardt_fatca_ind);
      m_cWv_ardt_fatca_ind = "_not_empty_";
    }
    if (l_bResult && (ardt_fatca_ind.m_bLoaded || ardt_fatca_ind.m_bUpdated)) {
      l_bResult = l_bResult && ardt_fatca_ind.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_fatca_ind.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_patrimonio.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_patrimonio)) || ( ! (ardt_patrimonio.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_patrimonio)))) {
      ardt_patrimonio.SetFromContext(m_cWv_ardt_patrimonio);
      m_cWv_ardt_patrimonio = "_not_empty_";
    }
    if (l_bResult && (ardt_patrimonio.m_bLoaded || ardt_patrimonio.m_bUpdated)) {
      l_bResult = l_bResult && ardt_patrimonio.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_patrimonio.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_reddito.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_reddito)) || ( ! (ardt_reddito.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_reddito)))) {
      ardt_reddito.SetFromContext(m_cWv_ardt_reddito);
      m_cWv_ardt_reddito = "_not_empty_";
    }
    if (l_bResult && (ardt_reddito.m_bLoaded || ardt_reddito.m_bUpdated)) {
      l_bResult = l_bResult && ardt_reddito.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_reddito.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_personbo"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_personbo\\"+p_cState};
    }
    return l_Keys;
  }
  public boolean CanView() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
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
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
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
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PROGIMPORT = m_Ctx.AskTableProg(w_PROGIMPORT,15,op_PROGIMPORT,"PRGIMPOCLI"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_personbo);
    op_codazi = m_Ctx.GetCompany();
    op_PROGIMPORT = w_PROGIMPORT;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PROGIMPORT = m_Ctx.AskTableProg(w_PROGIMPORT,15,op_PROGIMPORT,"PRGIMPOCLI"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_personbo);
      op_codazi = m_Ctx.GetCompany();
      op_PROGIMPORT = w_PROGIMPORT;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PROGIMPORT = 0;
    // Inizializzazione delle variabili per DependsOn
    o_gIntemediario = "";
    o_COGNOME = "";
    o_NOME = "";
    o_PAESE = "";
    o_DESCCIT = "";
    o_idcitta = "";
    o_IDNASCOMUN = "";
    o_IDNASSTATO = "";
    o_NASSTATO = "";
    o_DATANASC = CPLib.NullDate();
    o_TIPODOC = "";
    o_NUMDOCUM = "";
    o_DATARILASC = CPLib.NullDate();
    o_DATAVALI = CPLib.NullDate();
    o_SOTGRUP = "";
    o_RAMOGRUP = "";
    o_ATTIV = "";
    o_CONNES = "";
    o_tipsot = "";
    o_AREAGEO = "";
    o_PKTBSPECIE = "";
    o_ATTIVR = "";
    o_COMPORT = "";
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
    CPLib.PutProperty(p,"TIPOPERS",w_TIPOPERS,0);
    CPLib.PutProperty(p,"COGNOME",w_COGNOME,0);
    CPLib.PutProperty(p,"NOME",w_NOME,0);
    CPLib.PutProperty(p,"CFESTERO",w_CFESTERO,0);
    CPLib.PutProperty(p,"RAGSOC",w_RAGSOC,0);
    CPLib.PutProperty(p,"PAESE",w_PAESE,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"idcitta",w_idcitta,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CAP",w_CAP,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"DOMICILIO",w_DOMICILIO,0);
    CPLib.PutProperty(p,"IDENT",w_IDENT,0);
    CPLib.PutProperty(p,"IDNASCOMUN",w_IDNASCOMUN,0);
    CPLib.PutProperty(p,"NASCOMUN",w_NASCOMUN,0);
    CPLib.PutProperty(p,"TIPINTER",w_TIPINTER,0);
    CPLib.PutProperty(p,"IDNASSTATO",w_IDNASSTATO,0);
    CPLib.PutProperty(p,"NASSTATO",w_NASSTATO,0);
    CPLib.PutProperty(p,"SESSO",w_SESSO,0);
    CPLib.PutProperty(p,"DATANASC",w_DATANASC,0);
    CPLib.PutProperty(p,"TIPODOC",w_TIPODOC,0);
    CPLib.PutProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"AUTRILASC",w_AUTRILASC,0);
    CPLib.PutProperty(p,"CODFISC",w_CODFISC,0);
    CPLib.PutProperty(p,"PARTIVA",w_PARTIVA,0);
    CPLib.PutProperty(p,"CONTO",w_CONTO,0);
    CPLib.PutProperty(p,"SOTGRUP",w_SOTGRUP,0);
    CPLib.PutProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
    CPLib.PutProperty(p,"ATTIV",w_ATTIV,0);
    CPLib.PutProperty(p,"SETTSINT",w_SETTSINT,0);
    CPLib.PutProperty(p,"CONNES",w_CONNES,0);
    CPLib.PutProperty(p,"NOSARA",w_NOSARA,0);
    CPLib.PutProperty(p,"NOTIT",w_NOTIT,0);
    CPLib.PutProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
    CPLib.PutProperty(p,"op_PROGIMPORT",op_PROGIMPORT,0);
    CPLib.PutProperty(p,"OLDSETSIN",w_OLDSETSIN,0);
    CPLib.PutProperty(p,"CRIMEDATE",w_CRIMEDATE,0);
    CPLib.PutProperty(p,"PEPDATE",w_PEPDATE,0);
    CPLib.PutProperty(p,"NOTE",w_NOTE,0);
    CPLib.PutProperty(p,"CODLEGRAP",w_CODLEGRAP,0);
    CPLib.PutProperty(p,"FATCA",w_FATCA,0);
    CPLib.PutProperty(p,"TIN",w_TIN,0);
    CPLib.PutProperty(p,"ODB",w_ODB,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"PKTBSPECIE",w_PKTBSPECIE,0);
    CPLib.PutProperty(p,"RNATGIU",w_RNATGIU,0);
    CPLib.PutProperty(p,"RATTIV",w_RATTIV,0);
    CPLib.PutProperty(p,"COMPORT",w_COMPORT,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"DOCFILE",w_DOCFILE,0);
    CPLib.PutProperty(p,"RISGLOB",w_RISGLOB,0);
    CPLib.PutProperty(p,"DATAPROF",w_DATAPROF,0);
    CPLib.PutProperty(p,"DATAREVPROF",w_DATAREVPROF,0);
    CPLib.PutProperty(p,"PEP",w_PEP,0);
    CPLib.PutProperty(p,"CRIME",w_CRIME,0);
    CPLib.PutProperty(p,"MITIG",w_MITIG,0);
    CPLib.PutProperty(p,"MITIGDOC",w_MITIGDOC,0);
    CPLib.PutProperty(p,"DATAFINE",w_DATAFINE,0);
    CPLib.PutProperty(p,"DATAINI",w_DATAINI,0);
    CPLib.PutProperty(p,"DISATTIVO",w_DISATTIVO,0);
    CPLib.PutProperty(p,"TIPOSOGGETTO",w_TIPOSOGGETTO,0);
    CPLib.PutProperty(p,"RAPSEGNA",w_RAPSEGNA,0);
    CPLib.PutProperty(p,"SOGAFFIDATARIO",w_SOGAFFIDATARIO,0);
    CPLib.PutProperty(p,"CAUSALE",w_CAUSALE,0);
    CPLib.PutProperty(p,"FATTURATO",w_FATTURATO,0);
    CPLib.PutProperty(p,"FLGNOTRIM",w_FLGNOTRIM,0);
    CPLib.PutProperty(p,"DATAIDENT",w_DATAIDENT,0);
    CPLib.PutProperty(p,"CITTADIN1",w_CITTADIN1,0);
    CPLib.PutProperty(p,"CITTADIN2",w_CITTADIN2,0);
    CPLib.PutProperty(p,"RESFISC",w_RESFISC,0);
    CPLib.PutProperty(p,"BANCABEN",w_BANCABEN,0);
    CPLib.PutProperty(p,"DATASEGN",w_DATASEGN,0);
    CPLib.PutProperty(p,"DATARAUT",w_DATARAUT,0);
    CPLib.PutProperty(p,"VERIFICA",w_VERIFICA,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"NUMIMP",w_NUMIMP,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"SOSPMAF",w_SOSPMAF,0);
    CPLib.PutProperty(p,"OLDCONNES",w_OLDCONNES,0);
    CPLib.PutProperty(p,"DATEXTRA",w_DATEXTRA,0);
    CPLib.PutProperty(p,"ALLINEATO",w_ALLINEATO,0);
    CPLib.PutProperty(p,"ALLINEATONOMECNOME",w_ALLINEATONOMECNOME,0);
    CPLib.PutProperty(p,"RAGSOCOLD",w_RAGSOCOLD,0);
    CPLib.PutProperty(p,"PROGIMP_C",w_PROGIMP_C,0);
    CPLib.PutProperty(p,"IDFILE",w_IDFILE,0);
    CPLib.PutProperty(p,"OLDCODFISC",w_OLDCODFISC,0);
    CPLib.PutProperty(p,"MACROAGENTE",w_MACROAGENTE,0);
    CPLib.PutProperty(p,"SPOTID",w_SPOTID,0);
    CPLib.PutProperty(p,"DATAVARAGE",w_DATAVARAGE,0);
    CPLib.PutProperty(p,"SETTSINT2",w_SETTSINT2,0);
    CPLib.PutProperty(p,"TELEF",w_TELEF,0);
    CPLib.PutProperty(p,"TIPOORO",w_TIPOORO,0);
    CPLib.PutProperty(p,"CODORO",w_CODORO,0);
    CPLib.PutProperty(p,"FLGVALIDO",w_FLGVALIDO,0);
    CPLib.PutProperty(p,"DAC6",w_DAC6,0);
    CPLib.PutProperty(p,"ALTRODOM",w_ALTRODOM,0);
    CPLib.PutProperty(p,"ALTROCAP",w_ALTROCAP,0);
    CPLib.PutProperty(p,"IMPORTOMAX",w_IMPORTOMAX,0);
    CPLib.PutProperty(p,"FREQUENZA",w_FREQUENZA,0);
    CPLib.PutProperty(p,"NUMOPERAZ",w_NUMOPERAZ,0);
    CPLib.PutProperty(p,"DATASIGN",w_DATASIGN,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"FLAGDAC6",w_FLAGDAC6,0);
    CPLib.PutProperty(p,"NOTERIS",w_NOTERIS,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"gSeekAos",w_gSeekAos,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"gVerSim",w_gVerSim,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"dataoggi",w_dataoggi,0);
    CPLib.PutProperty(p,"nascomunid",w_nascomunid,0);
    CPLib.PutProperty(p,"nasstatoid",w_nasstatoid,0);
    CPLib.PutProperty(p,"flgaggfam",w_flgaggfam,0);
    CPLib.PutProperty(p,"DATARETT",w_DATARETT,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"tipsot",w_tipsot,0);
    CPLib.PutProperty(p,"DESCSGRU",w_DESCSGRU,0);
    CPLib.PutProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
    CPLib.PutProperty(p,"DESCUIC",w_DESCUIC,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"xstatonas",w_xstatonas,0);
    CPLib.PutProperty(p,"finesae",w_finesae,0);
    CPLib.PutProperty(p,"finesint",w_finesint,0);
    CPLib.PutProperty(p,"xFLGVALIDO",w_xFLGVALIDO,0);
    CPLib.PutProperty(p,"xFLGANAVAL",w_xFLGANAVAL,0);
    CPLib.PutProperty(p,"ragbanben",w_ragbanben,0);
    CPLib.PutProperty(p,"xdesfatca",w_xdesfatca,0);
    CPLib.PutProperty(p,"ATTIVR",w_ATTIVR,0);
    CPLib.PutProperty(p,"xDESDIPE",w_xDESDIPE,0);
    CPLib.PutProperty(p,"xDSETSIN",w_xDSETSIN,0);
    CPLib.PutProperty(p,"xdesctipatt",w_xdesctipatt,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
    CPLib.PutProperty(p,"xdesccomp",w_xdesccomp,0);
    CPLib.PutProperty(p,"xITFLGPEP",w_xITFLGPEP,0);
    CPLib.PutProperty(p,"xDesCit1",w_xDesCit1,0);
    CPLib.PutProperty(p,"xDesCit2",w_xDesCit2,0);
    CPLib.PutProperty(p,"xResFis",w_xResFis,0);
    CPLib.PutProperty(p,"xRAGLEGRAP",w_xRAGLEGRAP,0);
    CPLib.PutProperty(p,"xIDLEGRAP",w_xIDLEGRAP,0);
    CPLib.PutProperty(p,"FLGALTO",w_FLGALTO,0);
    CPLib.PutProperty(p,"COMPLETA",w_COMPLETA,0);
    CPLib.PutProperty(p,"status",w_status,0);
    if (p_bGetChildren) {
      if (ardt_personbo_dip.IsUpdated()) {
        m_cWv_ardt_personbo_dip = ardt_personbo_dip.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_personbo_dip",m_cWv_ardt_personbo_dip,0);
    }
    if (p_bGetChildren) {
      if (armt_personbo_agg.IsUpdated()) {
        m_cWv_armt_personbo_agg = armt_personbo_agg.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_armt_personbo_agg",m_cWv_armt_personbo_agg,0);
    }
    if (p_bGetChildren) {
      if (ardt_soggope.IsUpdated()) {
        m_cWv_ardt_soggope = ardt_soggope.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_soggope",m_cWv_ardt_soggope,0);
    }
    if (p_bGetChildren) {
      if (ardt_fatca_ind.IsUpdated()) {
        m_cWv_ardt_fatca_ind = ardt_fatca_ind.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_fatca_ind",m_cWv_ardt_fatca_ind,0);
    }
    if (p_bGetChildren) {
      if (ardt_patrimonio.IsUpdated()) {
        m_cWv_ardt_patrimonio = ardt_patrimonio.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_patrimonio",m_cWv_ardt_patrimonio,0);
    }
    if (p_bGetChildren) {
      if (ardt_reddito.IsUpdated()) {
        m_cWv_ardt_reddito = ardt_reddito.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_reddito",m_cWv_ardt_reddito,0);
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
    return "personbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CONNES","C",16,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PROGIMPORT");
    oneAutoNum.add("PRGIMPOCLI");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_personbo_dip() {
    if (ardt_personbo_dip.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_personbo_dip) || CPLib.IsLoaded(m_cWv_ardt_personbo_dip))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_personbo_dip.m_bLoaded)) {
      ardt_personbo_dip.Blank();
      ardt_personbo_dip.w_CONNES = w_CONNES;
      ardt_personbo_dip.Load();
    }
    return ardt_personbo_dip.m_bLoaded;
  }
  public void CtxLoad_ardt_personbo_dip() {
    if ( ! (ardt_personbo_dip.m_lCtxLoaded)) {
      ardt_personbo_dip.Blank();
    }
    ardt_personbo_dip.m_lCtxLoaded = true;
    if ( ! (ardt_personbo_dip.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_personbo_dip) || CPLib.IsLoaded(m_cWv_ardt_personbo_dip)) {
        ardt_personbo_dip.SetFromContext(m_cWv_ardt_personbo_dip);
        m_cWv_ardt_personbo_dip = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_personbo_dip.m_bLoaded)) {
          ardt_personbo_dip.Blank();
          ardt_personbo_dip.w_CONNES = w_CONNES;
          ardt_personbo_dip.Load();
          if ( ! (ardt_personbo_dip.m_bLoaded)) {
            ardt_personbo_dip.Initialize();
            ardt_personbo_dip.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_armt_personbo_agg() {
    if (armt_personbo_agg.IsUpdated() || (CPLib.IsUpdated(m_cWv_armt_personbo_agg) || CPLib.IsLoaded(m_cWv_armt_personbo_agg))) {
      return true;
    } else if (m_bLoaded &&  ! (armt_personbo_agg.m_bLoaded)) {
      armt_personbo_agg.Blank();
      armt_personbo_agg.w_CONNES = w_CONNES;
      armt_personbo_agg.Load();
    }
    return armt_personbo_agg.m_bLoaded;
  }
  public void CtxLoad_armt_personbo_agg() {
    if ( ! (armt_personbo_agg.m_lCtxLoaded)) {
      armt_personbo_agg.Blank();
    }
    armt_personbo_agg.m_lCtxLoaded = true;
    if ( ! (armt_personbo_agg.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_armt_personbo_agg) || CPLib.IsLoaded(m_cWv_armt_personbo_agg)) {
        armt_personbo_agg.SetFromContext(m_cWv_armt_personbo_agg);
        m_cWv_armt_personbo_agg = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (armt_personbo_agg.m_bLoaded)) {
          armt_personbo_agg.Blank();
          armt_personbo_agg.w_CONNES = w_CONNES;
          armt_personbo_agg.Load();
          if ( ! (armt_personbo_agg.m_bLoaded)) {
            armt_personbo_agg.Initialize();
            armt_personbo_agg.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_soggope() {
    if (ardt_soggope.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_soggope) || CPLib.IsLoaded(m_cWv_ardt_soggope))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_soggope.m_bLoaded)) {
      ardt_soggope.Blank();
      ardt_soggope.w_COLLEG = w_CONNES;
      ardt_soggope.Load();
    }
    return ardt_soggope.m_bLoaded;
  }
  public void CtxLoad_ardt_soggope() {
    if ( ! (ardt_soggope.m_lCtxLoaded)) {
      ardt_soggope.Blank();
    }
    ardt_soggope.m_lCtxLoaded = true;
    if ( ! (ardt_soggope.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_soggope) || CPLib.IsLoaded(m_cWv_ardt_soggope)) {
        ardt_soggope.SetFromContext(m_cWv_ardt_soggope);
        m_cWv_ardt_soggope = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_soggope.m_bLoaded)) {
          ardt_soggope.Blank();
          ardt_soggope.w_COLLEG = w_CONNES;
          ardt_soggope.Load();
          if ( ! (ardt_soggope.m_bLoaded)) {
            ardt_soggope.Initialize();
            ardt_soggope.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_fatca_ind() {
    if (ardt_fatca_ind.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_fatca_ind) || CPLib.IsLoaded(m_cWv_ardt_fatca_ind))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_fatca_ind.m_bLoaded)) {
      ardt_fatca_ind.Blank();
      ardt_fatca_ind.w_CONNES = w_CONNES;
      ardt_fatca_ind.Load();
    }
    return ardt_fatca_ind.m_bLoaded;
  }
  public void CtxLoad_ardt_fatca_ind() {
    if ( ! (ardt_fatca_ind.m_lCtxLoaded)) {
      ardt_fatca_ind.Blank();
    }
    ardt_fatca_ind.m_lCtxLoaded = true;
    if ( ! (ardt_fatca_ind.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_fatca_ind) || CPLib.IsLoaded(m_cWv_ardt_fatca_ind)) {
        ardt_fatca_ind.SetFromContext(m_cWv_ardt_fatca_ind);
        m_cWv_ardt_fatca_ind = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_fatca_ind.m_bLoaded)) {
          ardt_fatca_ind.Blank();
          ardt_fatca_ind.w_CONNES = w_CONNES;
          ardt_fatca_ind.Load();
          if ( ! (ardt_fatca_ind.m_bLoaded)) {
            ardt_fatca_ind.Initialize();
            ardt_fatca_ind.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_patrimonio() {
    if (ardt_patrimonio.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_patrimonio) || CPLib.IsLoaded(m_cWv_ardt_patrimonio))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_patrimonio.m_bLoaded)) {
      ardt_patrimonio.Blank();
      ardt_patrimonio.w_CONNES = w_CONNES;
      ardt_patrimonio.Load();
    }
    return ardt_patrimonio.m_bLoaded;
  }
  public void CtxLoad_ardt_patrimonio() {
    if ( ! (ardt_patrimonio.m_lCtxLoaded)) {
      ardt_patrimonio.Blank();
    }
    ardt_patrimonio.m_lCtxLoaded = true;
    if ( ! (ardt_patrimonio.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_patrimonio) || CPLib.IsLoaded(m_cWv_ardt_patrimonio)) {
        ardt_patrimonio.SetFromContext(m_cWv_ardt_patrimonio);
        m_cWv_ardt_patrimonio = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_patrimonio.m_bLoaded)) {
          ardt_patrimonio.Blank();
          ardt_patrimonio.w_CONNES = w_CONNES;
          ardt_patrimonio.Load();
          if ( ! (ardt_patrimonio.m_bLoaded)) {
            ardt_patrimonio.Initialize();
            ardt_patrimonio.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_reddito() {
    if (ardt_reddito.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_reddito) || CPLib.IsLoaded(m_cWv_ardt_reddito))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_reddito.m_bLoaded)) {
      ardt_reddito.Blank();
      ardt_reddito.w_CONNES = w_CONNES;
      ardt_reddito.Load();
    }
    return ardt_reddito.m_bLoaded;
  }
  public void CtxLoad_ardt_reddito() {
    if ( ! (ardt_reddito.m_lCtxLoaded)) {
      ardt_reddito.Blank();
    }
    ardt_reddito.m_lCtxLoaded = true;
    if ( ! (ardt_reddito.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_reddito) || CPLib.IsLoaded(m_cWv_ardt_reddito)) {
        ardt_reddito.SetFromContext(m_cWv_ardt_reddito);
        m_cWv_ardt_reddito = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_reddito.m_bLoaded)) {
          ardt_reddito.Blank();
          ardt_reddito.w_CONNES = w_CONNES;
          ardt_reddito.Load();
          if ( ! (ardt_reddito.m_bLoaded)) {
            ardt_reddito.Initialize();
            ardt_reddito.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_personbo_dip")) {
      CtxLoad_ardt_personbo_dip();
      return ardt_personbo_dip;
    }
    if (CPLib.eq(p_cName,"armt_personbo_agg")) {
      CtxLoad_armt_personbo_agg();
      return armt_personbo_agg;
    }
    if (CPLib.eq(p_cName,"ardt_soggope")) {
      CtxLoad_ardt_soggope();
      return ardt_soggope;
    }
    if (CPLib.eq(p_cName,"ardt_fatca_ind")) {
      CtxLoad_ardt_fatca_ind();
      return ardt_fatca_ind;
    }
    if (CPLib.eq(p_cName,"ardt_patrimonio")) {
      CtxLoad_ardt_patrimonio();
      return ardt_patrimonio;
    }
    if (CPLib.eq(p_cName,"ardt_reddito")) {
      CtxLoad_ardt_reddito();
      return ardt_reddito;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
