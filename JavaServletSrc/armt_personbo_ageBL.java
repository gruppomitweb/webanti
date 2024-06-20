import java.util.*;

public class armt_personbo_ageBL extends armt_personbo_ageWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_personbo_age";
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public CPPhTableWrInfo m_oWrInfo_tbcittna;
  public String m_cPhName_tbident;
  public String m_cServer_tbident;
  public CPPhTableWrInfo m_oWrInfo_tbident;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public CPPhTableWrInfo m_oWrInfo_tbramgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public CPPhTableWrInfo m_oWrInfo_tbsetsin;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public CPPhTableWrInfo m_oWrInfo_tbstatna;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public CPPhTableWrInfo m_oWrInfo_tbstgru;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public CPPhTableWrInfo m_oWrInfo_personbo_agg;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"personbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'IDENT':IDENT,'IDNASCOMUN':IDNASCOMUN,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'IDNASSTATO':IDNASSTATO,'NASSTATO':NASSTATO,'SESSO':SESSO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'CONTO':CONTO,'SOTGRUP':SOTGRUP,'ATTIV':ATTIV,'SETTSINT':SETTSINT,'CONNES':CONNES,'NOTIT':NOTIT,'PEP':PEP,'flgaggfam':flgaggfam,'CRIME':CRIME,'DATARETT':DATARETT,'NOTE':NOTE"+FoundlingChildrenList("armt_personbo_age",true)+"}";
  public static final String i_CompleteStateStructure = "{'gSeekAos':gSeekAos,'gDataVaria':gDataVaria,'gFlgDoc':gFlgDoc,'gTipInter':gTipInter,'gIntemediario':gIntemediario,'gVerSim':gVerSim,'gFlgWU':gFlgWU,'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'idcitta':idcitta,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'IDENT':IDENT,'IDNASCOMUN':IDNASCOMUN,'nascomunid':nascomunid,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'IDNASSTATO':IDNASSTATO,'nasstatoid':nasstatoid,'NASSTATO':NASSTATO,'SESSO':SESSO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'CONTO':CONTO,'dataoggi':dataoggi,'SOTGRUP':SOTGRUP,'tipsot':tipsot,'RAMOGRUP':RAMOGRUP,'ATTIV':ATTIV,'SETTSINT':SETTSINT,'CONNES':CONNES,'NOTIT':NOTIT,'PEP':PEP,'flgaggfam':flgaggfam,'CRIME':CRIME,'DESCSGRU':DESCSGRU,'DESCRAMGRU':DESCRAMGRU,'DESCUIC':DESCUIC,'dessta':dessta,'DATARETT':DATARETT,'STATOREG':STATOREG,'NUMPROG':NUMPROG,'DESCRI':DESCRI,'PROGIMPORT':PROGIMPORT,'OLDSETSIN':OLDSETSIN,'xstatonas':xstatonas,'finesae':finesae,'finesint':finesint,'xFLGVALIDO':xFLGVALIDO,'xFLGANAVAL':xFLGANAVAL,'CONADD':CONADD,'NOSARA':NOSARA,'xDSETSIN':xDSETSIN,'CRIMEDATE':CRIMEDATE,'PEPDATE':PEPDATE,'xITFLGPEP':xITFLGPEP,'xdescareag':xdescareag,'xdescnatgiu':xdescnatgiu,'xdesctipatt':xdesctipatt,'xdesccomp':xdesccomp,'NOTE':NOTE"+FoundlingChildrenList("armt_personbo_age",true)+"}";
  public static final String i_ItemSequence = "TIPOPERS,COGNOME,NOME,CFESTERO,RAGSOC,PAESE,DESCCIT,PROVINCIA,CAP,CODCAB,DOMICILIO,IDENT,IDNASCOMUN,NASCOMUN,TIPINTER,IDNASSTATO,NASSTATO,SESSO,DATANASC,TIPODOC,NUMDOCUM,DATARILASC,DATAVALI,AUTRILASC,CODFISC,PARTIVA,CONTO,SOTGRUP,ATTIV,SETTSINT,CONNES,NOTIT,PEP,flgaggfam,CRIME,DATARETT,NOTE"+FoundlingChildrenList("armt_personbo_age",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_personbo_age"),new String[][]{new String[]{"TIPOPERS","Tipo Soggetto","C","1","0","campo","nokey","false","true"},new String[]{"COGNOME","Cognome","C","26","0","campo","nokey","false","false"},new String[]{"NOME","Nome","C","25","0","campo","nokey","false","false"},new String[]{"CFESTERO","Codice Fiscale Estero","N","1","0","campo","nokey","false","false"},new String[]{"RAGSOC","Ragione Sociale","C","70","0","campo","key2","false","false"},new String[]{"PAESE","Stato","C","3","0","campo","nokey","false","true"},new String[]{"DESCCIT","Città","C","30","0","campo","nokey","false","true"},new String[]{"PROVINCIA","Provincia","C","2","0","campo","nokey","false","true"},new String[]{"CAP","CAP","C","9","0","campo","nokey","false","true"},new String[]{"CODCAB","CAB","C","6","0","campo","nokey","false","true"},new String[]{"DOMICILIO","Indirizzo","C","35","0","campo","nokey","false","true"},new String[]{"IDENT","Identificazione","C","3","0","campo","nokey","false","false"},new String[]{"IDNASCOMUN","ID Comune Nascita","C","40","0","campo","key7","false","false"},new String[]{"NASCOMUN","Luogo di Nascita","C","30","0","campo","nokey","false","false"},new String[]{"TIPINTER","Prov.","C","2","0","campo","nokey","false","false"},new String[]{"IDNASSTATO","ID Stato Nascita","C","10","0","campo","key8","false","false"},new String[]{"NASSTATO","Stato di nascita","C","30","0","campo","nokey","false","false"},new String[]{"SESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"DATANASC","Data Nascita","D","8","0","campo","nokey","false","false"},new String[]{"TIPODOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"NUMDOCUM","Numero Doc.","C","15","0","campo","nokey","false","false"},new String[]{"DATARILASC","Data Rilascio Doc.","D","8","0","campo","nokey","false","false"},new String[]{"DATAVALI","","D","8","0","campo","nokey","false","false"},new String[]{"AUTRILASC","Autorità di rilascio","C","30","0","campo","nokey","false","false"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","nokey","false","false"},new String[]{"PARTIVA","Partita IVA","C","14","0","campo","nokey","false","false"},new String[]{"CONTO","Contro Corrente se controparte","C","25","0","campo","nokey","false","false"},new String[]{"SOTGRUP","Sottogruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"ATTIV","Codifica ATECO","C","10","0","campo","nokey","false","true"},new String[]{"SETTSINT","Settorizzazione UIC","C","3","0","campo","nokey","false","false"},new String[]{"CONNES","Codice Collegamento","C","16","0","campo","key1","false","true"},new String[]{"NOTIT","Non inviare titolare AGE","N","1","0","campo","nokey","false","false"},new String[]{"PEP","Persona Politicamente Esposta","C","1","0","campo","nokey","false","false"},new String[]{"flgaggfam","","C","1","0","variabile","nokey","false","false"},new String[]{"CRIME","Presente in liste Crime","C","1","0","campo","nokey","false","false"},new String[]{"DATARETT","","D","8","0","variabile","nokey","false","false"},new String[]{"NOTE","Note","M","10","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_personbo_ageBL (CPContext p_ContextObject) {
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
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_oWrInfo_tbcittna = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcittna",p_ContextObject.GetCompany());
    m_cPhName_tbident = p_ContextObject.GetPhName("tbident");
    m_cServer_tbident = p_ContextObject.GetServer("tbident");
    m_oWrInfo_tbident = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbident",p_ContextObject.GetCompany());
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_oWrInfo_tbramgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbramgru",p_ContextObject.GetCompany());
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_oWrInfo_tbsetsin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsetsin",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_oWrInfo_tbstatna = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstatna",p_ContextObject.GetCompany());
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_oWrInfo_tbstgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstgru",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_oWrInfo_personbo_agg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo_agg",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_personbo_age",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_COGNOME = "";
    w_NOME = "";
    w_RAGSOC = "";
    w_PAESE = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_idcitta = "";
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
    w_tipsot = "";
    w_RAMOGRUP = "";
    w_ATTIV = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_DATARETT = CPLib.NullDate();
    w_STATOREG = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_PROGIMPORT = 0;
    w_OLDSETSIN = "";
    w_xstatonas = "";
    w_finesae = CPLib.NullDate();
    w_finesint = CPLib.NullDate();
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
    w_xDSETSIN = "";
    w_CRIMEDATE = CPLib.NullDate();
    w_PEPDATE = CPLib.NullDate();
    w_xITFLGPEP = "";
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesctipatt = "";
    w_xdesccomp = "";
    w_NOTE = "";
    Link_LDTVEYLAXJ();
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
    w_dataoggi = CPLib.NullDate();
    w_dataoggi = CPLib.Date();
    Link_LLYIGAMXRH();
    Link_RVNHQCXNEM();
    Link_SAQTIHOALW();
    Link_ZGNLLSFQHC();
    w_NOTIT = 0;
    w_PEP = "N";
    w_flgaggfam = "N";
    w_CRIME = "N";
    w_CONADD = "";
    w_CONADD = w_CONNES;
    Link_QHGWFLNQMV();
    w_NOSARA = "N";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",40,0),m_cServer_tbcitta,w_DESCCIT);
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nascomunid,"C",10,0),m_cServer_tbcittna,w_nascomunid);
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
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chkatecoR.Make(m_Ctx,this).Run(w_SOTGRUP,w_ATTIV) || CPLib.ne(w_tipsot,"1");
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
    w_ATTIV = "";
    w_xdesctipatt = "";
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
  protected boolean Link_QHGWFLNQMV() {
    return Link_QHGWFLNQMV("Full");
  }
  protected boolean Link_QHGWFLNQMV(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONADD))) {
      String l_OldValue = w_CONADD;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONADD,"C",16,0),m_cServer_personbo_agg,w_CONADD);
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
          w_CONADD = l_rsLink.GetString("CONNES");
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
            Link_QHGWFLNQMV_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONADD");
          }
          m_cLastWorkVarError = "CONADD";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QHGWFLNQMV_blank();
    }
    return l_bResult;
  }
  void Link_QHGWFLNQMV_blank() {
    Link_QHGWFLNQMV_blank("");
  }
  void Link_QHGWFLNQMV_blank(String p_cType) {
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
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
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      l_bTmpRes = Link_ODAYKSRECA();
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
    return CPLib.eq(w_PAESE,"086") || CPLib.eq(w_PAESE,"139");
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
    l_bResult = arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,w_PAESE,w_CFESTERO);
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean SAQTIHOALW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_tipsot,"1");
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public String getDefault_CONNES() {
    // Gestione del default
    return w_CODFISC;
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
  public boolean getVisible_NOTIT() {
    return CPLib.ne(w_TIPOPERS,"G");
  }
  public boolean getVisible_DATARETT() {
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
    w_dataoggi = CPLib.Date();
    if (CPLib.ne(o_RAMOGRUP,w_RAMOGRUP)) {
      l_bTmpRes = Link_RVNHQCXNEM();
    }
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP) || CPLib.ne(o_ATTIV,w_ATTIV)) {
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
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
      Calculation_DRKQLYFONU();
    }
    w_CONADD = w_CONNES;
    l_bTmpRes = Link_QHGWFLNQMV();
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
  void Calculation_OIDLDZGYTQ() {
    arrt_calcolasettR l_oRoutine_arrt_calcolasett;
    l_oRoutine_arrt_calcolasett = arrt_calcolasettR.Make(m_Ctx,this);
    l_oRoutine_arrt_calcolasett.Run();
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
  void Calculation_DRKQLYFONU() {
    w_ATTIV = (CPLib.eq(w_tipsot,"1")?w_ATTIV:CPLib.Space(10));
    Link_SAQTIHOALW();
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
      l_bResult = ( ! (CPLib.Empty(w_DATARILASC)) &&  ! (CPLib.Empty(w_DATANASC)) && CPLib.gt(w_DATANASC,w_DATARILASC)?false:true);
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_personbo_age","personbo",m_KeyColumns,m_Ctx);
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
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_TIPOPERS = "";
    w_COGNOME = "";
    w_NOME = "";
    w_CFESTERO = 0;
    w_RAGSOC = "";
    w_PAESE = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_idcitta = "";
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
    w_dataoggi = CPLib.NullDate();
    w_SOTGRUP = "";
    w_tipsot = "";
    w_RAMOGRUP = "";
    w_ATTIV = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_NOTIT = 0;
    w_PEP = "";
    w_flgaggfam = "";
    w_CRIME = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_DATARETT = CPLib.NullDate();
    w_STATOREG = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_PROGIMPORT = 0;
    w_OLDSETSIN = "";
    w_xstatonas = "";
    w_finesae = CPLib.NullDate();
    w_finesint = CPLib.NullDate();
    w_xFLGVALIDO = "";
    w_xFLGANAVAL = "";
    w_CONADD = "";
    w_NOSARA = "";
    w_xDSETSIN = "";
    w_CRIMEDATE = CPLib.NullDate();
    w_PEPDATE = CPLib.NullDate();
    w_xITFLGPEP = "";
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesctipatt = "";
    w_xdesccomp = "";
    w_NOTE = "";
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
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_idcitta = CPLib.GetProperty(p,"idcitta",w_idcitta,0);
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
      w_NOTIT = CPLib.GetProperty(p,"NOTIT",w_NOTIT,0);
      w_PEP = CPLib.GetProperty(p,"PEP",w_PEP,0);
      w_CRIME = CPLib.GetProperty(p,"CRIME",w_CRIME,0);
      w_PROGIMPORT = CPLib.GetProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
      op_PROGIMPORT = CPLib.GetProperty(p,"op_PROGIMPORT",0,0);
      w_NOTE = CPLib.GetProperty(p,"NOTE",w_NOTE,0);
      w_OLDSETSIN = CPLib.GetProperty(p,"OLDSETSIN",w_OLDSETSIN,0);
      w_NOSARA = CPLib.GetProperty(p,"NOSARA",w_NOSARA,0);
      w_CRIMEDATE = CPLib.GetProperty(p,"CRIMEDATE",w_CRIMEDATE,0);
      w_PEPDATE = CPLib.GetProperty(p,"PEPDATE",w_PEPDATE,0);
      w_gSeekAos = CPLib.GetProperty(p,"gSeekAos",w_gSeekAos,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_gVerSim = CPLib.GetProperty(p,"gVerSim",w_gVerSim,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_nascomunid = CPLib.GetProperty(p,"nascomunid",w_nascomunid,0);
      w_nasstatoid = CPLib.GetProperty(p,"nasstatoid",w_nasstatoid,0);
      w_dataoggi = CPLib.GetProperty(p,"dataoggi",w_dataoggi,0);
      w_tipsot = CPLib.GetProperty(p,"tipsot",w_tipsot,0);
      w_flgaggfam = CPLib.GetProperty(p,"flgaggfam",w_flgaggfam,0);
      w_DESCSGRU = CPLib.GetProperty(p,"DESCSGRU",w_DESCSGRU,0);
      w_DESCRAMGRU = CPLib.GetProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
      w_DESCUIC = CPLib.GetProperty(p,"DESCUIC",w_DESCUIC,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_DATARETT = CPLib.GetProperty(p,"DATARETT",w_DATARETT,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescnatgiu = CPLib.GetProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
      w_xdesctipatt = CPLib.GetProperty(p,"xdesctipatt",w_xdesctipatt,0);
      w_xdesccomp = CPLib.GetProperty(p,"xdesccomp",w_xdesccomp,0);
      w_xstatonas = CPLib.GetProperty(p,"xstatonas",w_xstatonas,0);
      w_finesae = CPLib.GetProperty(p,"finesae",w_finesae,0);
      w_finesint = CPLib.GetProperty(p,"finesint",w_finesint,0);
      w_xFLGVALIDO = CPLib.GetProperty(p,"xFLGVALIDO",w_xFLGVALIDO,0);
      w_xFLGANAVAL = CPLib.GetProperty(p,"xFLGANAVAL",w_xFLGANAVAL,0);
      w_CONADD = CPLib.GetProperty(p,"CONADD",w_CONADD,0);
      w_xDSETSIN = CPLib.GetProperty(p,"xDSETSIN",w_xDSETSIN,0);
      w_xITFLGPEP = CPLib.GetProperty(p,"xITFLGPEP",w_xITFLGPEP,0);
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
    map.put("rd_var.len",zeroSplit.split("10\u000030\u00002",-1));
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
    map.put("rd_var",new String[]{"w_CONADD","w_xFLGVALIDO","w_xFLGANAVAL"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u00001\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Codice Fiscale Validato\u0000Dati Anagrafici Validati",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo_agg\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_kvar",new String[]{"w_PAESE"});
    map.put("rd_kfield",new String[]{"PKTBSTATI"});
    map.put("rd_field",new String[]{"CITTA","IDBASE"});
    map.put("rd_var",new String[]{"w_DESCCIT","w_idcitta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("30\u000040",-1));
    map.put("rd_kvar.len",zeroSplit.split("3",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Città\u0000Codice Città",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Stato",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
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
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000w_PAESE='086' or w_PAESE='139'\u0000(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'\u0000(w_PAESE='086' or w_PAESE='139') and w_gVerSim='N'",-1));
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
    map.put("rd_var.comment",zeroSplit.split("Codifica ATECO\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("w_tipsot = '1'\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipatt\u0000false\u0000false\u00002\u00000\u0000armt_tbtipatt\u0000false\u0000false\u0000Prevalente Attività\u0000\u0000\u0000false",-1));
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
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_personbo_age",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_personbo_age",child);
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
    m_MNTs = CPLib.MNTChilds("armt_personbo_age",m_Ctx);
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
    } else if ((CPLib.ne(w_xFLGVALIDO,"S")) && ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,w_PAESE,w_CFESTERO)))) {
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
    } else if ((CPLib.Empty(w_ATTIV) && SAQTIHOALW_isObligatory()) || ( ! (CPLib.Empty(w_ATTIV)) &&  ! (arfn_chkatecoR.Make(m_Ctx,this).Run(w_SOTGRUP,w_ATTIV) || CPLib.ne(w_tipsot,"1")))) {
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
      l_Keys = new String[]{"armt_personbo_age","administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_personbo_age\\"+p_cState,"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
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
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"idcitta",w_idcitta,0);
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
    CPLib.PutProperty(p,"NOTIT",w_NOTIT,0);
    CPLib.PutProperty(p,"PEP",w_PEP,0);
    CPLib.PutProperty(p,"CRIME",w_CRIME,0);
    CPLib.PutProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
    CPLib.PutProperty(p,"op_PROGIMPORT",op_PROGIMPORT,0);
    CPLib.PutProperty(p,"NOTE",w_NOTE,0);
    CPLib.PutProperty(p,"OLDSETSIN",w_OLDSETSIN,0);
    CPLib.PutProperty(p,"NOSARA",w_NOSARA,0);
    CPLib.PutProperty(p,"CRIMEDATE",w_CRIMEDATE,0);
    CPLib.PutProperty(p,"PEPDATE",w_PEPDATE,0);
    CPLib.PutProperty(p,"gSeekAos",w_gSeekAos,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"gVerSim",w_gVerSim,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"nascomunid",w_nascomunid,0);
    CPLib.PutProperty(p,"nasstatoid",w_nasstatoid,0);
    CPLib.PutProperty(p,"dataoggi",w_dataoggi,0);
    CPLib.PutProperty(p,"tipsot",w_tipsot,0);
    CPLib.PutProperty(p,"flgaggfam",w_flgaggfam,0);
    CPLib.PutProperty(p,"DESCSGRU",w_DESCSGRU,0);
    CPLib.PutProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
    CPLib.PutProperty(p,"DESCUIC",w_DESCUIC,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"DATARETT",w_DATARETT,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
    CPLib.PutProperty(p,"xdesctipatt",w_xdesctipatt,0);
    CPLib.PutProperty(p,"xdesccomp",w_xdesccomp,0);
    CPLib.PutProperty(p,"xstatonas",w_xstatonas,0);
    CPLib.PutProperty(p,"finesae",w_finesae,0);
    CPLib.PutProperty(p,"finesint",w_finesint,0);
    CPLib.PutProperty(p,"xFLGVALIDO",w_xFLGVALIDO,0);
    CPLib.PutProperty(p,"xFLGANAVAL",w_xFLGANAVAL,0);
    CPLib.PutProperty(p,"CONADD",w_CONADD,0);
    CPLib.PutProperty(p,"xDSETSIN",w_xDSETSIN,0);
    CPLib.PutProperty(p,"xITFLGPEP",w_xITFLGPEP,0);
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
  CallerBRImpl GetChild(String p_cName) {
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
