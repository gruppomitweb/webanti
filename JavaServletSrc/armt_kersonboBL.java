import java.util.*;

public class armt_kersonboBL extends armt_kersonboWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_kersonbo";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public CPPhTableWrInfo m_oWrInfo_kersonbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_kersonbo;
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
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"kersonbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'SESSO':SESSO,'NASSTATO':NASSTATO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'SETTSINT':SETTSINT,'CONNES':CONNES,'PEP':PEP,'ATTIV':ATTIV"+FoundlingChildrenList("armt_kersonbo",true)+"}";
  public static final String i_CompleteStateStructure = "{'TIPOPERS':TIPOPERS,'COGNOME':COGNOME,'NOME':NOME,'CFESTERO':CFESTERO,'RAGSOC':RAGSOC,'PAESE':PAESE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'idcitta':idcitta,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'NASCOMUN':NASCOMUN,'TIPINTER':TIPINTER,'SESSO':SESSO,'NASSTATO':NASSTATO,'DATANASC':DATANASC,'TIPODOC':TIPODOC,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'DATAVALI':DATAVALI,'AUTRILASC':AUTRILASC,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'SETTSINT':SETTSINT,'CONNES':CONNES,'DESCSGRU':DESCSGRU,'DESCRAMGRU':DESCRAMGRU,'DESCUIC':DESCUIC,'dessta':dessta,'tipsot':tipsot,'STATOREG':STATOREG,'IDBASE':IDBASE,'NUMPROG':NUMPROG,'DESCRI':DESCRI,'gSeekAos':gSeekAos,'PROGIMPORT':PROGIMPORT,'gDataVaria':gDataVaria,'gFlgDoc':gFlgDoc,'PEP':PEP,'AREAGEO':AREAGEO,'PKTBSPECIE':PKTBSPECIE,'ATTIV':ATTIV,'COMPORT':COMPORT,'RAREA':RAREA,'RNATGIU':RNATGIU,'RATTIV':RATTIV,'RCOMP':RCOMP,'gFlgWU':gFlgWU,'xdescareag':xdescareag,'xdescnatgiu':xdescnatgiu,'xdesctipatt':xdesctipatt,'xdesccomp':xdesccomp,'datamodi':datamodi"+FoundlingChildrenList("armt_kersonbo",true)+"}";
  public static final String i_ItemSequence = "TIPOPERS,COGNOME,NOME,CFESTERO,RAGSOC,PAESE,DESCCIT,PROVINCIA,CAP,CODCAB,DOMICILIO,NASCOMUN,TIPINTER,SESSO,NASSTATO,DATANASC,TIPODOC,NUMDOCUM,DATARILASC,DATAVALI,AUTRILASC,CODFISC,PARTIVA,SOTGRUP,RAMOGRUP,SETTSINT,CONNES,PEP,ATTIV"+FoundlingChildrenList("armt_kersonbo",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_kersonbo"),new String[][]{new String[]{"TIPOPERS","","C","1","0","campo","nokey","false","false"},new String[]{"COGNOME","Cognome","C","26","0","campo","nokey","false","false"},new String[]{"NOME","Nome","C","25","0","campo","nokey","false","false"},new String[]{"CFESTERO","Codice Fiscale Estero","N","1","0","campo","nokey","false","false"},new String[]{"RAGSOC","Ragione Sociale","C","70","0","campo","key3","false","false"},new String[]{"PAESE","Stato","C","3","0","campo","nokey","false","false"},new String[]{"DESCCIT","Città","C","40","0","campo","nokey","false","false"},new String[]{"PROVINCIA","Provincia","C","2","0","campo","nokey","false","false"},new String[]{"CAP","CAP","C","9","0","campo","nokey","false","false"},new String[]{"CODCAB","CAB","C","6","0","campo","nokey","false","false"},new String[]{"DOMICILIO","Indirizzo","C","35","0","campo","nokey","false","false"},new String[]{"NASCOMUN","Luogo di Nascita","C","30","0","campo","nokey","false","false"},new String[]{"TIPINTER","Prov.","C","2","0","campo","nokey","false","false"},new String[]{"SESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"NASSTATO","Stato di nascita","C","30","0","campo","nokey","false","false"},new String[]{"DATANASC","Data Nascita","D","8","0","campo","nokey","false","false"},new String[]{"TIPODOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"NUMDOCUM","Numero Doc.","C","15","0","campo","nokey","false","false"},new String[]{"DATARILASC","Data Rilascio Doc.","D","8","0","campo","nokey","false","false"},new String[]{"DATAVALI","","D","8","0","campo","nokey","false","false"},new String[]{"AUTRILASC","Autorità di rilascio","C","30","0","campo","nokey","false","false"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","key4","false","false"},new String[]{"PARTIVA","Partita IVA","C","14","0","campo","nokey","false","false"},new String[]{"SOTGRUP","Sottogruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"RAMOGRUP","Ramo Gruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"SETTSINT","Settorizzazione UIC","C","3","0","campo","nokey","false","false"},new String[]{"CONNES","Codice Collegamento","C","50","0","campo","key1","false","true"},new String[]{"PEP","Persona Politicamente Esposta","C","1","0","campo","nokey","false","false"},new String[]{"ATTIV","","C","10","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_kersonboBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo",p_ContextObject.GetCompany(),false);
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_oWrInfo_kersonbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"kersonbo",p_ContextObject.GetCompany());
    m_cVirtName_kersonbo = CPSql.ManipulateTablePhName("kersonbo",m_cServer_kersonbo);
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
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_kersonbo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
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
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_SESSO = "";
    w_NASSTATO = "";
    w_DATANASC = CPLib.NullDate();
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_tipsot = "";
    w_STATOREG = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_PROGIMPORT = 0;
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_AREAGEO = "";
    w_PKTBSPECIE = "";
    w_ATTIV = "";
    w_COMPORT = "";
    w_RAREA = 0;
    w_RNATGIU = 0;
    w_RATTIV = 0;
    w_RCOMP = 0;
    w_ATTIV = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesctipatt = "";
    w_xdesccomp = "";
    w_datamodi = CPLib.NullDate();
    w_TIPOPERS = "P";
    w_CFESTERO = 0;
    Link_YVIKEGPYPM();
    Link_ODAYKSRECA();
    Link_TYEDHRZCMA();
    Link_NEUBQNUEOJ();
    Link_HODZKKOSYW();
    Link_MBGANUUHRA();
    Link_LLYIGAMXRH();
    Link_RVNHQCXNEM();
    Link_ZGNLLSFQHC();
    w_PEP = "N";
    Link_QJSTZIPOQB();
    Link_SFFFOYOWNH();
    Link_NOBMPHKVTX();
    Link_DJOWYRMDDC();
    Link_SAQTIHOALW();
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
    o_DESCCIT = w_DESCCIT;
    o_idcitta = w_idcitta;
    o_SOTGRUP = w_SOTGRUP;
    o_AREAGEO = w_AREAGEO;
    o_PKTBSPECIE = w_PKTBSPECIE;
    o_ATTIV = w_ATTIV;
    o_COMPORT = w_COMPORT;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
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
      l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SOTGRU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTGRUP,"C",60,0),m_cServer_tbstgru,w_SOTGRUP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
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
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOTGRUP");
          }
          m_cLastWorkVarError = "SOTGRUP";
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
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAMOGRUP,"C",70,0),m_cServer_tbramgru,w_RAMOGRUP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbramgru,"select RAMGRU,DESCRI from "+m_cPhName_tbramgru+((m_cPhName_tbramgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
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
      l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SETSINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETTSINT,"C",60,0),m_cServer_tbsetsin,w_SETTSINT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SETTSINT = l_rsLink.GetString("SETSINT");
          w_DESCUIC = l_rsLink.GetString("DESCRI");
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
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SETTSINT");
          }
          m_cLastWorkVarError = "SETTSINT";
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
    w_DESCUIC = "";
  }
  protected boolean Link_QJSTZIPOQB() {
    return Link_QJSTZIPOQB("Full");
  }
  protected boolean Link_QJSTZIPOQB(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",5,0),m_cServer_tbareegeog,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_xdescareag = l_rsLink.GetString("DESCRI");
          w_RAREA = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QJSTZIPOQB_blank();
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
      Link_QJSTZIPOQB_blank();
    }
    return l_bResult;
  }
  void Link_QJSTZIPOQB_blank() {
    w_AREAGEO = "";
    w_xdescareag = "";
    w_RAREA = 0;
  }
  protected boolean Link_SFFFOYOWNH() {
    return Link_SFFFOYOWNH("Full");
  }
  protected boolean Link_SFFFOYOWNH(String p_cType) {
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
      l_rsLink = m_Sql.Query(m_cServer_tbspecie,"select CODSPE,DESCRI,RISCHIO from "+m_cPhName_tbspecie+((m_cPhName_tbspecie).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSPE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PKTBSPECIE = l_rsLink.GetString("CODSPE");
          w_xdescnatgiu = l_rsLink.GetString("DESCRI");
          w_RNATGIU = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SFFFOYOWNH_blank();
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
      Link_SFFFOYOWNH_blank();
    }
    return l_bResult;
  }
  void Link_SFFFOYOWNH_blank() {
    w_PKTBSPECIE = "";
    w_xdescnatgiu = "";
    w_RNATGIU = 0;
  }
  protected boolean Link_NOBMPHKVTX() {
    return Link_NOBMPHKVTX("Full");
  }
  protected boolean Link_NOBMPHKVTX(String p_cType) {
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
      l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIV = l_rsLink.GetString("CODICE");
          w_xdesctipatt = l_rsLink.GetString("DESCRI");
          w_RATTIV = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NOBMPHKVTX_blank();
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
      Link_NOBMPHKVTX_blank();
    }
    return l_bResult;
  }
  void Link_NOBMPHKVTX_blank() {
    w_ATTIV = "";
    w_xdesctipatt = "";
    w_RATTIV = 0;
  }
  protected boolean Link_DJOWYRMDDC() {
    return Link_DJOWYRMDDC("Full");
  }
  protected boolean Link_DJOWYRMDDC(String p_cType) {
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
      l_rsLink = m_Sql.Query(m_cServer_tbcondotta,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbcondotta+((m_cPhName_tbcondotta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_COMPORT = l_rsLink.GetString("CODICE");
          w_xdesccomp = l_rsLink.GetString("DESCRI");
          w_RCOMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DJOWYRMDDC_blank();
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
      Link_DJOWYRMDDC_blank();
    }
    return l_bResult;
  }
  void Link_DJOWYRMDDC_blank() {
    w_COMPORT = "";
    w_xdesccomp = "";
    w_RCOMP = 0;
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
      l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ATTIV,"C",250,0),m_cServer_tbtipatt,w_ATTIV);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtipatt,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtipatt+((m_cPhName_tbtipatt).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_ATTIV = l_rsLink.GetString("CODICE");
          w_xdesctipatt = l_rsLink.GetString("DESCRI");
          w_RATTIV = l_rsLink.GetDouble("RISCHIO");
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
    w_RATTIV = 0;
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
  public boolean Set_PROVINCIA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROVINCIA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
  public boolean Set_NASSTATO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NASSTATO = p_workVariableValue;
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOTGRUP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAMOGRUP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAMOGRUP = p_workVariableValue;
    l_bResult = Link_RVNHQCXNEM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAMOGRUP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
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
  public boolean Set_ATTIV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ATTIV = p_workVariableValue;
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ATTIV = "";
    }
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
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_COGNOME() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_NOME() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_NASCOMUN() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_TIPINTER() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_SESSO() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_NASSTATO() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_DATANASC() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_TIPODOC() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_NUMDOCUM() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_DATARILASC() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_DATAVALI() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_AUTRILASC() {
    return CPLib.eq(w_TIPOPERS,"P");
  }
  public boolean getWritable_PARTIVA() {
    return CPLib.eq(w_TIPOPERS,"G");
  }
  public boolean getWritable_RAMOGRUP() {
    return CPLib.ne(w_tipsot,"0") && CPLib.ne(w_tipsot,"2");
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
    if (CPLib.ne(o_DESCCIT,w_DESCCIT) || CPLib.ne(o_idcitta,w_idcitta)) {
      l_bTmpRes = Link_YVIKEGPYPM();
    }
    if (CPLib.ne(o_idcitta,w_idcitta)) {
      l_bTmpRes = Link_TYEDHRZCMA();
    }
    if (CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
      l_bTmpRes = Link_ZGNLLSFQHC();
    }
    if (CPLib.ne(o_AREAGEO,w_AREAGEO)) {
      l_bTmpRes = Link_QJSTZIPOQB();
    }
    if (CPLib.ne(o_PKTBSPECIE,w_PKTBSPECIE)) {
      l_bTmpRes = Link_SFFFOYOWNH();
    }
    if (CPLib.ne(o_ATTIV,w_ATTIV)) {
      l_bTmpRes = Link_NOBMPHKVTX();
    }
    if (CPLib.ne(o_COMPORT,w_COMPORT)) {
      l_bTmpRes = Link_DJOWYRMDDC();
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_kersonbo","kersonbo",m_KeyColumns,m_Ctx);
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
    w_NASCOMUN = "";
    w_TIPINTER = "";
    w_SESSO = "";
    w_NASSTATO = "";
    w_DATANASC = CPLib.NullDate();
    w_TIPODOC = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_DATAVALI = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_SETTSINT = "";
    w_CONNES = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_dessta = "";
    w_tipsot = "";
    w_STATOREG = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_DESCRI = "";
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_PROGIMPORT = 0;
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_PEP = "";
    w_AREAGEO = "";
    w_PKTBSPECIE = "";
    w_ATTIV = "";
    w_COMPORT = "";
    w_RAREA = 0;
    w_RNATGIU = 0;
    w_RATTIV = 0;
    w_RCOMP = 0;
    w_ATTIV = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_xdescareag = "";
    w_xdescnatgiu = "";
    w_xdesctipatt = "";
    w_xdesccomp = "";
    w_datamodi = CPLib.NullDate();
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
      w_NASCOMUN = CPLib.GetProperty(p,"NASCOMUN",w_NASCOMUN,0);
      w_TIPINTER = CPLib.GetProperty(p,"TIPINTER",w_TIPINTER,0);
      w_SESSO = CPLib.GetProperty(p,"SESSO",w_SESSO,0);
      w_NASSTATO = CPLib.GetProperty(p,"NASSTATO",w_NASSTATO,0);
      w_DATANASC = CPLib.GetProperty(p,"DATANASC",w_DATANASC,0);
      w_TIPODOC = CPLib.GetProperty(p,"TIPODOC",w_TIPODOC,0);
      w_NUMDOCUM = CPLib.GetProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_AUTRILASC = CPLib.GetProperty(p,"AUTRILASC",w_AUTRILASC,0);
      w_CODFISC = CPLib.GetProperty(p,"CODFISC",w_CODFISC,0);
      w_PARTIVA = CPLib.GetProperty(p,"PARTIVA",w_PARTIVA,0);
      w_SOTGRUP = CPLib.GetProperty(p,"SOTGRUP",w_SOTGRUP,0);
      w_RAMOGRUP = CPLib.GetProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
      w_SETTSINT = CPLib.GetProperty(p,"SETTSINT",w_SETTSINT,0);
      w_CONNES = CPLib.GetProperty(p,"CONNES",w_CONNES,0);
      w_PROGIMPORT = CPLib.GetProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
      op_PROGIMPORT = CPLib.GetProperty(p,"op_PROGIMPORT",0,0);
      w_PEP = CPLib.GetProperty(p,"PEP",w_PEP,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_PKTBSPECIE = CPLib.GetProperty(p,"PKTBSPECIE",w_PKTBSPECIE,0);
      w_ATTIV = CPLib.GetProperty(p,"ATTIV",w_ATTIV,0);
      w_COMPORT = CPLib.GetProperty(p,"COMPORT",w_COMPORT,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_RNATGIU = CPLib.GetProperty(p,"RNATGIU",w_RNATGIU,0);
      w_RATTIV = CPLib.GetProperty(p,"RATTIV",w_RATTIV,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_datamodi = CPLib.GetProperty(p,"datamodi",w_datamodi,0);
      w_DESCSGRU = CPLib.GetProperty(p,"DESCSGRU",w_DESCSGRU,0);
      w_DESCRAMGRU = CPLib.GetProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
      w_DESCUIC = CPLib.GetProperty(p,"DESCUIC",w_DESCUIC,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_tipsot = CPLib.GetProperty(p,"tipsot",w_tipsot,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_gSeekAos = CPLib.GetProperty(p,"gSeekAos",w_gSeekAos,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescnatgiu = CPLib.GetProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
      w_xdesctipatt = CPLib.GetProperty(p,"xdesctipatt",w_xdesctipatt,0);
      w_xdesccomp = CPLib.GetProperty(p,"xdesccomp",w_xdesccomp,0);
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
    map.put("rd_var.comment",zeroSplit.split("Città\u0000Codice Città",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Stato",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
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
    map.put("rd_var.len",zeroSplit.split("10\u00006\u00002\u00009",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Città\u0000CAB\u0000Provincia\u0000CAP",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Comuni\u0000\u0000\u0000false",-1));
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
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
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
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"SOTGRU","DESCRI","TIPOSOT"});
    map.put("rd_var",new String[]{"w_SOTGRUP","w_DESCSGRU","w_tipsot"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000060\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Sottogruppo Att. Ec.\u0000Descrizione\u0000Tipo",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
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
    map.put("rd_field",new String[]{"SETSINT","DESCRI"});
    map.put("rd_var",new String[]{"w_SETTSINT","w_DESCUIC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Settorizzazione UIC\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsetsin\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Setto Sintetica UIC\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbareegeog");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbareegeog",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_AREAGEO","w_xdescareag","w_RAREA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000050\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbareegeog\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Area Geografica\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbspecie");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbspecie",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSPE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_PKTBSPECIE","w_xdescnatgiu","w_RNATGIU"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u000060\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbspecie\u0000false\u0000false\u00002\u00000\u0000armt_tbspecie\u0000false\u0000false\u0000Modalità Svolgimento\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_ATTIV","w_xdesctipatt","w_RATTIV"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u0000250\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipatt\u0000false\u0000false\u00002\u00000\u0000armt_tbtipatt\u0000false\u0000false\u0000Prevalente Attività\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcondotta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcondotta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_COMPORT","w_xdesccomp","w_RCOMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcondotta\u0000false\u0000false\u00002\u00000\u0000armt_tbcondotta\u0000false\u0000false\u0000Tipologia Rischio\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_kersonbo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_kersonbo",child);
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
    m_MNTs = CPLib.MNTChilds("armt_kersonbo",m_Ctx);
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
    if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(w_CODFISC,w_PAESE,w_CFESTERO))) {
      m_cLastMsgError = m_Ctx.Translate("Codice Fiscale Errato");
      l_bNoCheck = false;
      l_bResult = false;
      w_CODFISC = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODFISC";
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
      l_Keys = new String[]{"armt_kersonbo","Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_kersonbo\\"+p_cState,"Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
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
    w_PROGIMPORT = m_Ctx.AskTableProg(w_PROGIMPORT,15,op_PROGIMPORT,"PRGIMPOCLI"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_kersonbo);
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
      w_PROGIMPORT = m_Ctx.AskTableProg(w_PROGIMPORT,15,op_PROGIMPORT,"PRGIMPOCLI"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_kersonbo);
      op_codazi = m_Ctx.GetCompany();
      op_PROGIMPORT = w_PROGIMPORT;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PROGIMPORT = 0;
    // Inizializzazione delle variabili per DependsOn
    o_DESCCIT = "";
    o_idcitta = "";
    o_SOTGRUP = "";
    o_AREAGEO = "";
    o_PKTBSPECIE = "";
    o_ATTIV = "";
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
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"idcitta",w_idcitta,0);
    CPLib.PutProperty(p,"CAP",w_CAP,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"DOMICILIO",w_DOMICILIO,0);
    CPLib.PutProperty(p,"NASCOMUN",w_NASCOMUN,0);
    CPLib.PutProperty(p,"TIPINTER",w_TIPINTER,0);
    CPLib.PutProperty(p,"SESSO",w_SESSO,0);
    CPLib.PutProperty(p,"NASSTATO",w_NASSTATO,0);
    CPLib.PutProperty(p,"DATANASC",w_DATANASC,0);
    CPLib.PutProperty(p,"TIPODOC",w_TIPODOC,0);
    CPLib.PutProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"AUTRILASC",w_AUTRILASC,0);
    CPLib.PutProperty(p,"CODFISC",w_CODFISC,0);
    CPLib.PutProperty(p,"PARTIVA",w_PARTIVA,0);
    CPLib.PutProperty(p,"SOTGRUP",w_SOTGRUP,0);
    CPLib.PutProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
    CPLib.PutProperty(p,"SETTSINT",w_SETTSINT,0);
    CPLib.PutProperty(p,"CONNES",w_CONNES,0);
    CPLib.PutProperty(p,"PROGIMPORT",w_PROGIMPORT,0);
    CPLib.PutProperty(p,"op_PROGIMPORT",op_PROGIMPORT,0);
    CPLib.PutProperty(p,"PEP",w_PEP,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"PKTBSPECIE",w_PKTBSPECIE,0);
    CPLib.PutProperty(p,"ATTIV",w_ATTIV,0);
    CPLib.PutProperty(p,"COMPORT",w_COMPORT,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"RNATGIU",w_RNATGIU,0);
    CPLib.PutProperty(p,"RATTIV",w_RATTIV,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"datamodi",w_datamodi,0);
    CPLib.PutProperty(p,"DESCSGRU",w_DESCSGRU,0);
    CPLib.PutProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
    CPLib.PutProperty(p,"DESCUIC",w_DESCUIC,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"tipsot",w_tipsot,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"gSeekAos",w_gSeekAos,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescnatgiu",w_xdescnatgiu,0);
    CPLib.PutProperty(p,"xdesctipatt",w_xdesctipatt,0);
    CPLib.PutProperty(p,"xdesccomp",w_xdesccomp,0);
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
    return "kersonbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CONNES","C",50,0));
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
