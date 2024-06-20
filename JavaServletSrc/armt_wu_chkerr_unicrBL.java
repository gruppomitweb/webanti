import java.util.*;

public class armt_wu_chkerr_unicrBL extends armt_wu_chkerr_unicrWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_wu_chkerr_unicr";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wuchkunicr;
  public String m_cServer_wuchkunicr;
  public CPPhTableWrInfo m_oWrInfo_wuchkunicr;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wuchkunicr;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public CPPhTableWrInfo m_oWrInfo_wucodes;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wuchkunicr"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'WUCODICE':WUCODICE,'WUNCAPCLI':WUNCAPCLI,'WUNDATNAS':WUNDATNAS,'WUNRDOCCLI':WUNRDOCCLI,'WUNSDOCCLI':WUNSDOCCLI,'WUNTDOCCLI':WUNTDOCCLI,'WUNCODDIP':WUNCODDIP,'WUNCITCLI':WUNCITCLI,'WUNBSTACLI':WUNBSTACLI,'WUNBCITCLI':WUNBCITCLI,'WUFLGALL':WUFLGALL,'WUNCODFIS':WUNCODFIS,'WUNOTE':WUNOTE,'WUFLGFRC':WUFLGFRC,'WUNDATINI':WUNDATINI,'WUNDATFIN':WUNDATFIN,'WUNSEXCLI':WUNSEXCLI"+FoundlingChildrenList("armt_wu_chkerr_unicr",true)+"}";
  public static final String i_CompleteStateStructure = "{'WUNOMEFILE':WUNOMEFILE,'WUTIPOPE':WUTIPOPE,'WUCODDIP':WUCODDIP,'WUDATINI':WUDATINI,'WUTIPERR':WUTIPERR,'WUCODICE':WUCODICE,'WUNCAPCLI':WUNCAPCLI,'WUNDATNAS':WUNDATNAS,'WUNRDOCCLI':WUNRDOCCLI,'WUNSDOCCLI':WUNSDOCCLI,'WUNTDOCCLI':WUNTDOCCLI,'WUNCODDIP':WUNCODDIP,'WUNCITCLI':WUNCITCLI,'WUNBSTACLI':WUNBSTACLI,'WUNBCITCLI':WUNBCITCLI,'WUNOMCLI':WUNOMCLI,'WUCOGCLI':WUCOGCLI,'WUCITCLI':WUCITCLI,'WUCAPCLI':WUCAPCLI,'WUINDCLI':WUINDCLI,'WUBCITCLI':WUBCITCLI,'WUBSTACLI':WUBSTACLI,'WUDATNAS':WUDATNAS,'WUCODFIS':WUCODFIS,'WUNDOCCLI':WUNDOCCLI,'WUADOCRIL':WUADOCRIL,'WURDOCCLI':WURDOCCLI,'WUSDOCCLI':WUSDOCCLI,'WUSEXCLI':WUSEXCLI,'WUTDOCCLI':WUTDOCCLI,'WUFLGALL':WUFLGALL,'WUNCODFIS':WUNCODFIS,'WUCODMAGE':WUCODMAGE,'xMADESCRI':xMADESCRI,'xDESDIP':xDESDIP,'WUNOTE':WUNOTE,'WUFLGFRC':WUFLGFRC,'WUDATFIN':WUDATFIN,'WUCODRAP':WUCODRAP,'WUNDATINI':WUNDATINI,'WUNDATFIN':WUNDATFIN,'WUSTACLI':WUSTACLI,'WUNSEXCLI':WUNSEXCLI"+FoundlingChildrenList("armt_wu_chkerr_unicr",true)+"}";
  public static final String i_ItemSequence = "WUCODICE,WUNCAPCLI,WUNDATNAS,WUNRDOCCLI,WUNSDOCCLI,WUNTDOCCLI,WUNCODDIP,WUNCITCLI,WUNBSTACLI,WUNBCITCLI,WUFLGALL,WUNCODFIS,WUNOTE,WUFLGFRC,WUNDATINI,WUNDATFIN,WUNSEXCLI"+FoundlingChildrenList("armt_wu_chkerr_unicr",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_wu_chkerr_unicr"),new String[][]{new String[]{"WUCODICE","Progressivo","N","10","0","campo","key1","false","false"},new String[]{"WUNCAPCLI","Nuovo CAP Cliente","C","5","0","campo","nokey","false","false"},new String[]{"WUNDATNAS","Nuova Data Nascita Cliente","D","8","0","campo","nokey","false","false"},new String[]{"WUNRDOCCLI","Nuova Data Rilascio Documento","D","8","0","campo","nokey","false","false"},new String[]{"WUNSDOCCLI","Nuova Data Scadenza Documento","D","8","0","campo","nokey","false","false"},new String[]{"WUNTDOCCLI","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"WUNCODDIP","Nuovo Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"WUNCITCLI","Città Cliente","C","40","0","campo","nokey","false","false"},new String[]{"WUNBSTACLI","Nuovo Stato Nascita Cliente","C","40","0","campo","nokey","false","false"},new String[]{"WUNBCITCLI","Nuova Città Nascita Cliente","C","40","0","campo","nokey","false","false"},new String[]{"WUFLGALL","Completata","C","1","0","campo","nokey","false","false"},new String[]{"WUNCODFIS","Codice Fiscale","C","16","0","campo","nokey","false","false"},new String[]{"WUNOTE","Elenco Errori","M","10","0","campo","nokey","false","false"},new String[]{"WUFLGFRC","Forza caricamento movimento","C","1","0","campo","nokey","false","false"},new String[]{"WUNDATINI","Data Inizio Rapporto","D","8","0","campo","nokey","false","false"},new String[]{"WUNDATFIN","Data FIne Rapporto","D","8","0","campo","nokey","false","false"},new String[]{"WUNSEXCLI","Nuovo Sesso Cliente","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_wu_chkerr_unicrBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wuchkunicr = p_ContextObject.GetPhName("wuchkunicr",p_ContextObject.GetCompany(),false);
    m_cServer_wuchkunicr = p_ContextObject.GetServer("wuchkunicr");
    m_oWrInfo_wuchkunicr = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wuchkunicr",p_ContextObject.GetCompany());
    m_cVirtName_wuchkunicr = CPSql.ManipulateTablePhName("wuchkunicr",m_cServer_wuchkunicr);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_oWrInfo_wucodes = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wucodes",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_wu_chkerr_unicr",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_WUNOMEFILE = "";
    w_WUTIPOPE = "";
    w_WUCODDIP = "";
    w_WUDATINI = CPLib.NullDate();
    w_WUTIPERR = "";
    w_WUCODICE = 0;
    w_WUNCAPCLI = "";
    w_WUNDATNAS = CPLib.NullDate();
    w_WUNRDOCCLI = CPLib.NullDate();
    w_WUNSDOCCLI = CPLib.NullDate();
    w_WUNTDOCCLI = "";
    w_WUNCODDIP = "";
    w_WUNCITCLI = "";
    w_WUNBSTACLI = "";
    w_WUNBCITCLI = "";
    w_WUNOMCLI = "";
    w_WUCOGCLI = "";
    w_WUCITCLI = "";
    w_WUCAPCLI = "";
    w_WUINDCLI = "";
    w_WUBCITCLI = "";
    w_WUBSTACLI = "";
    w_WUDATNAS = "";
    w_WUCODFIS = "";
    w_WUNDOCCLI = "";
    w_WUADOCRIL = "";
    w_WURDOCCLI = "";
    w_WUSDOCCLI = "";
    w_WUSEXCLI = "";
    w_WUTDOCCLI = "";
    w_WUNCODFIS = "";
    w_WUCODMAGE = "";
    w_xMADESCRI = "";
    w_xDESDIP = "";
    w_WUNOTE = "";
    w_WUDATFIN = CPLib.NullDate();
    w_WUCODRAP = "";
    w_WUNDATINI = CPLib.NullDate();
    w_WUNDATFIN = CPLib.NullDate();
    w_WUSTACLI = "";
    w_WUNSEXCLI = "";
    Link_RPXEDSQTUE();
    Link_AZSYSFMRUL();
    Link_GPWUEBYSIT();
    Link_SQSTTNXNEF();
    w_WUFLGALL = "N";
    Link_FHWIGGJJLC();
    w_WUFLGFRC = "N";
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
    o_WUCODMAGE = w_WUCODMAGE;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_IFNSOSSMKP();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_RPXEDSQTUE() {
    return Link_RPXEDSQTUE("Full");
  }
  protected boolean Link_RPXEDSQTUE(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_WUNCODDIP))) {
      String l_OldValue = w_WUNCODDIP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUNCODDIP,"C",6,0),m_cServer_anadip,w_WUNCODDIP);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_WUNCODDIP = l_rsLink.GetString("CODDIP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RPXEDSQTUE_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_WUNCODDIP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","WUNCODDIP");
          }
          m_cLastWorkVarError = "WUNCODDIP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RPXEDSQTUE_blank();
    }
    return l_bResult;
  }
  void Link_RPXEDSQTUE_blank() {
    w_WUNCODDIP = "";
  }
  protected boolean Link_AZSYSFMRUL() {
    return Link_AZSYSFMRUL("Full");
  }
  protected boolean Link_AZSYSFMRUL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_WUNCITCLI))) {
      String l_OldValue = w_WUNCITCLI;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUNCITCLI,"C",40,0),m_cServer_tbcitta,w_WUNCITCLI);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_WUNCITCLI = l_rsLink.GetString("CITTA");
          w_WUNCAPCLI = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AZSYSFMRUL_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_WUNCITCLI = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","WUNCITCLI");
          }
          m_cLastWorkVarError = "WUNCITCLI";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AZSYSFMRUL_blank();
    }
    return l_bResult;
  }
  void Link_AZSYSFMRUL_blank() {
    w_WUNCITCLI = "";
    w_WUNCAPCLI = "";
  }
  protected boolean Link_GPWUEBYSIT() {
    return Link_GPWUEBYSIT("Full");
  }
  protected boolean Link_GPWUEBYSIT(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_WUNBSTACLI))) {
      String l_OldValue = w_WUNBSTACLI;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUNBSTACLI,"C",40,0),m_cServer_tbstati,w_WUNBSTACLI);
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
          w_WUNBSTACLI = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_GPWUEBYSIT_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_WUNBSTACLI = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","WUNBSTACLI");
          }
          m_cLastWorkVarError = "WUNBSTACLI";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_GPWUEBYSIT_blank();
    }
    return l_bResult;
  }
  void Link_GPWUEBYSIT_blank() {
    w_WUNBSTACLI = "";
  }
  protected boolean Link_SQSTTNXNEF() {
    return Link_SQSTTNXNEF("Full");
  }
  protected boolean Link_SQSTTNXNEF(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_WUNBCITCLI))) {
      String l_OldValue = w_WUNBCITCLI;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUNBCITCLI,"C",40,0),m_cServer_tbcitta,w_WUNBCITCLI);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_WUNBCITCLI = l_rsLink.GetString("CITTA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SQSTTNXNEF_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_WUNBCITCLI = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","WUNBCITCLI");
          }
          m_cLastWorkVarError = "WUNBCITCLI";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SQSTTNXNEF_blank();
    }
    return l_bResult;
  }
  void Link_SQSTTNXNEF_blank() {
    w_WUNBCITCLI = "";
  }
  protected boolean Link_FHWIGGJJLC() {
    return Link_FHWIGGJJLC("Full");
  }
  protected boolean Link_FHWIGGJJLC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_WUCODMAGE))) {
      String l_OldValue = w_WUCODMAGE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODMAGE,"C",5,0),m_cServer_tbmacage,w_WUCODMAGE);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_WUCODMAGE = l_rsLink.GetString("MACODICE");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_FHWIGGJJLC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_WUCODMAGE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","WUCODMAGE");
          }
          m_cLastWorkVarError = "WUCODMAGE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_FHWIGGJJLC_blank();
    }
    return l_bResult;
  }
  void Link_FHWIGGJJLC_blank() {
    w_WUCODMAGE = "";
    w_xMADESCRI = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_WUCODICE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUCODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNCAPCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNCAPCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNDATNAS(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNDATNAS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNRDOCCLI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNRDOCCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNSDOCCLI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNSDOCCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNTDOCCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNTDOCCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNCODDIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNCODDIP = p_workVariableValue;
    l_bResult = Link_RPXEDSQTUE();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_WUNCODDIP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNCITCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNCITCLI = p_workVariableValue;
    l_bResult = Link_AZSYSFMRUL();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_WUNCITCLI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNBSTACLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNBSTACLI = p_workVariableValue;
    l_bResult = Link_GPWUEBYSIT();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_WUNBSTACLI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNBCITCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNBCITCLI = p_workVariableValue;
    l_bResult = Link_SQSTTNXNEF();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_WUNBCITCLI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUFLGALL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUFLGALL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNCODFIS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNCODFIS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNOTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUFLGFRC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUFLGFRC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNDATINI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNDATINI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNDATFIN(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNDATFIN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUNSEXCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUNSEXCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_WUCODICE() {
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
    if (CPLib.ne(o_WUCODMAGE,w_WUCODMAGE)) {
      l_bTmpRes = Link_FHWIGGJJLC();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_IFNSOSSMKP() {
    arrt_wu_chkerr_unicr_saveR l_oRoutine_arrt_wu_chkerr_unicr_save;
    l_oRoutine_arrt_wu_chkerr_unicr_save = arrt_wu_chkerr_unicr_saveR.Make(m_Ctx,this);
    l_oRoutine_arrt_wu_chkerr_unicr_save.Run();
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
  public final static String[] m_KeyColumns = {"WUCODICE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_wu_chkerr_unicr","wuchkunicr",m_KeyColumns,m_Ctx);
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
    w_WUNOMEFILE = "";
    w_WUTIPOPE = "";
    w_WUCODDIP = "";
    w_WUDATINI = CPLib.NullDate();
    w_WUTIPERR = "";
    w_WUCODICE = 0;
    w_WUNCAPCLI = "";
    w_WUNDATNAS = CPLib.NullDate();
    w_WUNRDOCCLI = CPLib.NullDate();
    w_WUNSDOCCLI = CPLib.NullDate();
    w_WUNTDOCCLI = "";
    w_WUNCODDIP = "";
    w_WUNCITCLI = "";
    w_WUNBSTACLI = "";
    w_WUNBCITCLI = "";
    w_WUNOMCLI = "";
    w_WUCOGCLI = "";
    w_WUCITCLI = "";
    w_WUCAPCLI = "";
    w_WUINDCLI = "";
    w_WUBCITCLI = "";
    w_WUBSTACLI = "";
    w_WUDATNAS = "";
    w_WUCODFIS = "";
    w_WUNDOCCLI = "";
    w_WUADOCRIL = "";
    w_WURDOCCLI = "";
    w_WUSDOCCLI = "";
    w_WUSEXCLI = "";
    w_WUTDOCCLI = "";
    w_WUFLGALL = "";
    w_WUNCODFIS = "";
    w_WUCODMAGE = "";
    w_xMADESCRI = "";
    w_xDESDIP = "";
    w_WUNOTE = "";
    w_WUFLGFRC = "";
    w_WUDATFIN = CPLib.NullDate();
    w_WUCODRAP = "";
    w_WUNDATINI = CPLib.NullDate();
    w_WUNDATFIN = CPLib.NullDate();
    w_WUSTACLI = "";
    w_WUNSEXCLI = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_WUNOMEFILE = CPLib.GetProperty(p,"WUNOMEFILE",w_WUNOMEFILE,0);
      w_WUTIPOPE = CPLib.GetProperty(p,"WUTIPOPE",w_WUTIPOPE,0);
      w_WUCODDIP = CPLib.GetProperty(p,"WUCODDIP",w_WUCODDIP,0);
      w_WUDATINI = CPLib.GetProperty(p,"WUDATINI",w_WUDATINI,0);
      w_WUTIPERR = CPLib.GetProperty(p,"WUTIPERR",w_WUTIPERR,0);
      w_WUCODICE = CPLib.GetProperty(p,"WUCODICE",w_WUCODICE,0);
      w_WUNCAPCLI = CPLib.GetProperty(p,"WUNCAPCLI",w_WUNCAPCLI,0);
      w_WUNDATNAS = CPLib.GetProperty(p,"WUNDATNAS",w_WUNDATNAS,0);
      w_WUNRDOCCLI = CPLib.GetProperty(p,"WUNRDOCCLI",w_WUNRDOCCLI,0);
      w_WUNSDOCCLI = CPLib.GetProperty(p,"WUNSDOCCLI",w_WUNSDOCCLI,0);
      w_WUNTDOCCLI = CPLib.GetProperty(p,"WUNTDOCCLI",w_WUNTDOCCLI,0);
      w_WUNCODDIP = CPLib.GetProperty(p,"WUNCODDIP",w_WUNCODDIP,0);
      w_WUNCITCLI = CPLib.GetProperty(p,"WUNCITCLI",w_WUNCITCLI,0);
      w_WUNBSTACLI = CPLib.GetProperty(p,"WUNBSTACLI",w_WUNBSTACLI,0);
      w_WUNBCITCLI = CPLib.GetProperty(p,"WUNBCITCLI",w_WUNBCITCLI,0);
      w_WUNOMCLI = CPLib.GetProperty(p,"WUNOMCLI",w_WUNOMCLI,0);
      w_WUCOGCLI = CPLib.GetProperty(p,"WUCOGCLI",w_WUCOGCLI,0);
      w_WUCITCLI = CPLib.GetProperty(p,"WUCITCLI",w_WUCITCLI,0);
      w_WUCAPCLI = CPLib.GetProperty(p,"WUCAPCLI",w_WUCAPCLI,0);
      w_WUINDCLI = CPLib.GetProperty(p,"WUINDCLI",w_WUINDCLI,0);
      w_WUBCITCLI = CPLib.GetProperty(p,"WUBCITCLI",w_WUBCITCLI,0);
      w_WUBSTACLI = CPLib.GetProperty(p,"WUBSTACLI",w_WUBSTACLI,0);
      w_WUDATNAS = CPLib.GetProperty(p,"WUDATNAS",w_WUDATNAS,0);
      w_WUCODFIS = CPLib.GetProperty(p,"WUCODFIS",w_WUCODFIS,0);
      w_WUNDOCCLI = CPLib.GetProperty(p,"WUNDOCCLI",w_WUNDOCCLI,0);
      w_WUADOCRIL = CPLib.GetProperty(p,"WUADOCRIL",w_WUADOCRIL,0);
      w_WURDOCCLI = CPLib.GetProperty(p,"WURDOCCLI",w_WURDOCCLI,0);
      w_WUSDOCCLI = CPLib.GetProperty(p,"WUSDOCCLI",w_WUSDOCCLI,0);
      w_WUSEXCLI = CPLib.GetProperty(p,"WUSEXCLI",w_WUSEXCLI,0);
      w_WUTDOCCLI = CPLib.GetProperty(p,"WUTDOCCLI",w_WUTDOCCLI,0);
      w_WUFLGALL = CPLib.GetProperty(p,"WUFLGALL",w_WUFLGALL,0);
      w_WUNCODFIS = CPLib.GetProperty(p,"WUNCODFIS",w_WUNCODFIS,0);
      w_WUCODMAGE = CPLib.GetProperty(p,"WUCODMAGE",w_WUCODMAGE,0);
      w_WUNOTE = CPLib.GetProperty(p,"WUNOTE",w_WUNOTE,0);
      w_WUFLGFRC = CPLib.GetProperty(p,"WUFLGFRC",w_WUFLGFRC,0);
      w_WUDATFIN = CPLib.GetProperty(p,"WUDATFIN",w_WUDATFIN,0);
      w_WUCODRAP = CPLib.GetProperty(p,"WUCODRAP",w_WUCODRAP,0);
      w_WUNDATINI = CPLib.GetProperty(p,"WUNDATINI",w_WUNDATINI,0);
      w_WUNDATFIN = CPLib.GetProperty(p,"WUNDATFIN",w_WUNDATFIN,0);
      w_WUSTACLI = CPLib.GetProperty(p,"WUSTACLI",w_WUSTACLI,0);
      w_WUNSEXCLI = CPLib.GetProperty(p,"WUNSEXCLI",w_WUNSEXCLI,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_xDESDIP = CPLib.GetProperty(p,"xDESDIP",w_xDESDIP,0);
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
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP"});
    map.put("rd_var",new String[]{"w_WUNCODDIP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Nuovo Codice Dipendenza",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Dipendenze / Agenti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","CAP"});
    map.put("rd_var",new String[]{"w_WUNCITCLI","w_WUNCAPCLI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40\u00005",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città Cliente\u0000Nuovo CAP Cliente",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00001\u00000\u0000armt_citta\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_WUNBSTACLI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Nuovo Stato Nascita Cliente",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Stati / Nazioni\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA"});
    map.put("rd_var",new String[]{"w_WUNBCITCLI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Nuova Città Nascita Cliente",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbmacage");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbmacage",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"MACODICE","MADESCRI"});
    map.put("rd_var",new String[]{"w_WUCODMAGE","w_xMADESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("MacroAgente (Network)\u0000Denominazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00001\u00000\u0000armt_tbmacage\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_wu_chkerr_unicr",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_wu_chkerr_unicr",child);
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
    m_MNTs = CPLib.MNTChilds("armt_wu_chkerr_unicr",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
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
      l_Keys = new String[]{"armt_wu_chkerr_unicr"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_wu_chkerr_unicr\\"+p_cState};
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
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_WUCODMAGE = "";
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
    CPLib.PutProperty(p,"WUNOMEFILE",w_WUNOMEFILE,0);
    CPLib.PutProperty(p,"WUTIPOPE",w_WUTIPOPE,0);
    CPLib.PutProperty(p,"WUCODDIP",w_WUCODDIP,0);
    CPLib.PutProperty(p,"WUDATINI",w_WUDATINI,0);
    CPLib.PutProperty(p,"WUTIPERR",w_WUTIPERR,0);
    CPLib.PutProperty(p,"WUCODICE",w_WUCODICE,0);
    CPLib.PutProperty(p,"WUNCAPCLI",w_WUNCAPCLI,0);
    CPLib.PutProperty(p,"WUNDATNAS",w_WUNDATNAS,0);
    CPLib.PutProperty(p,"WUNRDOCCLI",w_WUNRDOCCLI,0);
    CPLib.PutProperty(p,"WUNSDOCCLI",w_WUNSDOCCLI,0);
    CPLib.PutProperty(p,"WUNTDOCCLI",w_WUNTDOCCLI,0);
    CPLib.PutProperty(p,"WUNCODDIP",w_WUNCODDIP,0);
    CPLib.PutProperty(p,"WUNCITCLI",w_WUNCITCLI,0);
    CPLib.PutProperty(p,"WUNBSTACLI",w_WUNBSTACLI,0);
    CPLib.PutProperty(p,"WUNBCITCLI",w_WUNBCITCLI,0);
    CPLib.PutProperty(p,"WUNOMCLI",w_WUNOMCLI,0);
    CPLib.PutProperty(p,"WUCOGCLI",w_WUCOGCLI,0);
    CPLib.PutProperty(p,"WUCITCLI",w_WUCITCLI,0);
    CPLib.PutProperty(p,"WUCAPCLI",w_WUCAPCLI,0);
    CPLib.PutProperty(p,"WUINDCLI",w_WUINDCLI,0);
    CPLib.PutProperty(p,"WUBCITCLI",w_WUBCITCLI,0);
    CPLib.PutProperty(p,"WUBSTACLI",w_WUBSTACLI,0);
    CPLib.PutProperty(p,"WUDATNAS",w_WUDATNAS,0);
    CPLib.PutProperty(p,"WUCODFIS",w_WUCODFIS,0);
    CPLib.PutProperty(p,"WUNDOCCLI",w_WUNDOCCLI,0);
    CPLib.PutProperty(p,"WUADOCRIL",w_WUADOCRIL,0);
    CPLib.PutProperty(p,"WURDOCCLI",w_WURDOCCLI,0);
    CPLib.PutProperty(p,"WUSDOCCLI",w_WUSDOCCLI,0);
    CPLib.PutProperty(p,"WUSEXCLI",w_WUSEXCLI,0);
    CPLib.PutProperty(p,"WUTDOCCLI",w_WUTDOCCLI,0);
    CPLib.PutProperty(p,"WUFLGALL",w_WUFLGALL,0);
    CPLib.PutProperty(p,"WUNCODFIS",w_WUNCODFIS,0);
    CPLib.PutProperty(p,"WUCODMAGE",w_WUCODMAGE,0);
    CPLib.PutProperty(p,"WUNOTE",w_WUNOTE,0);
    CPLib.PutProperty(p,"WUFLGFRC",w_WUFLGFRC,0);
    CPLib.PutProperty(p,"WUDATFIN",w_WUDATFIN,0);
    CPLib.PutProperty(p,"WUCODRAP",w_WUCODRAP,0);
    CPLib.PutProperty(p,"WUNDATINI",w_WUNDATINI,0);
    CPLib.PutProperty(p,"WUNDATFIN",w_WUNDATFIN,0);
    CPLib.PutProperty(p,"WUSTACLI",w_WUSTACLI,0);
    CPLib.PutProperty(p,"WUNSEXCLI",w_WUNSEXCLI,0);
    CPLib.PutProperty(p,"xMADESCRI",w_xMADESCRI,0);
    CPLib.PutProperty(p,"xDESDIP",w_xDESDIP,0);
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
    return "wuchkunicr"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("WUCODICE","N",10,0));
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
  CallerBRImpl GetChild(String p_cName) {
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
