import java.util.*;

public class armt_wutrxchk_auaBL extends armt_wutrxchk_auaWV implements CPLib.QueryFilterFromProject {
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
  public static final String i_EntityName = "armt_wutrxchk_aua";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public CPPhTableWrInfo m_oWrInfo_wutrxchk;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wutrxchk;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_wuforcer;
  public String m_cServer_wuforcer;
  public CPPhTableWrInfo m_oWrInfo_wuforcer;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
  public CPPhTableWrInfo m_oWrInfo_tbluonas;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  public String m_cPhName_wutipdoc;
  public String m_cServer_wutipdoc;
  public CPPhTableWrInfo m_oWrInfo_wutipdoc;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wutrxchk"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TRXCODPRG':TRXCODPRG,'TRXCOGNOM':TRXCOGNOM,'TRXNOME':TRXNOME,'TRXFLGCF':TRXFLGCF,'TRXCODFIS':TRXCODFIS,'TRXLUONAS':TRXLUONAS,'TRXNUMDOC':TRXNUMDOC,'TRXDATSCA':TRXDATSCA,'TRXDATRIL':TRXDATRIL,'TRXTIPDOC':TRXTIPDOC,'TRXDATNAS':TRXDATNAS,'TRXSESSO':TRXSESSO,'TRXFLGFOR':TRXFLGFOR,'TRXFORCE':TRXFORCE,'FLGDATIOLD':FLGDATIOLD,'xtipdoc':xtipdoc,'xtnumdoc':xtnumdoc,'TRXTFINLAV':TRXTFINLAV,'TRDFINLAV':TRDFINLAV,'TRFLGINLAV':TRFLGINLAV,'TRXFLGAUA':TRXFLGAUA,'TRXESITO':TRXESITO,'finalized':finalized,'xluonas':xluonas"+FoundlingChildrenList("armt_wutrxchk_aua",true)+"}";
  public static final String i_CompleteStateStructure = "{'TRXCODPRG':TRXCODPRG,'TRXCOGNOM':TRXCOGNOM,'TRXNOME':TRXNOME,'TRXFLGCF':TRXFLGCF,'TRXCODFIS':TRXCODFIS,'TRXLUONAS':TRXLUONAS,'TRXNUMDOC':TRXNUMDOC,'TRXDATSCA':TRXDATSCA,'TRXDATRIL':TRXDATRIL,'TRXTIPDOC':TRXTIPDOC,'TRXMTCN':TRXMTCN,'TRXDATNAS':TRXDATNAS,'TRXDATOPE':TRXDATOPE,'TRXSESSO':TRXSESSO,'doctype':doctype,'sesso':sesso,'TRXNASSTATO':TRXNASSTATO,'TRXNASCOMUN':TRXNASCOMUN,'TRXFLGAUAQ1':TRXFLGAUAQ1,'TRXFLGAUAQ2':TRXFLGAUAQ2,'TRXFLGAUAQ3':TRXFLGAUAQ3,'TRXFLGAUAQ4':TRXFLGAUAQ4,'TRXFLGAUAQ5':TRXFLGAUAQ5,'TRXFLGAUA':TRXFLGAUA,'TRXFLGFOR':TRXFLGFOR,'TRXFORCE':TRXFORCE,'TRXDATRICERCA':TRXDATRICERCA,'xTRXPROVINCIA':xTRXPROVINCIA,'FLGDATIOLD':FLGDATIOLD,'xtipdoc':xtipdoc,'xtnumdoc':xtnumdoc,'TRXTFINLAV':TRXTFINLAV,'TRDFINLAV':TRDFINLAV,'TRFLGINLAV':TRFLGINLAV,'TRXESITO':TRXESITO,'TRXAUTRIL':TRXAUTRIL,'xDESCRIZ':xDESCRIZ,'TRXCODDIP':TRXCODDIP,'finalized':finalized,'TRXUTENTE':TRXUTENTE,'TRXTINILAV':TRXTINILAV,'TRXDINILAV':TRXDINILAV,'xluonas':xluonas,'TRXFLGCON':TRXFLGCON,'TRSSEGNO':TRSSEGNO,'TRXIMPORTO':TRXIMPORTO,'TRXCONTAN':TRXCONTAN,'TRXUNIQUE':TRXUNIQUE,'TRXCOGCON':TRXCOGCON,'TRXNOMCON':TRXNOMCON,'TRXDESTIN':TRXDESTIN,'TRXCODCAS':TRXCODCAS,'TRXRECTYPE':TRXRECTYPE,'TRXCODMAG':TRXCODMAG,'TRXCODUNI':TRXCODUNI,'xMADESCRI':xMADESCRI,'TRXNAZRES':TRXNAZRES,'TRXCITRES':TRXCITRES,'TRXDOMICI':TRXDOMICI"+FoundlingChildrenList("armt_wutrxchk_aua",true)+"}";
  public static final String i_ItemSequence = "TRXCODPRG,TRXCOGNOM,TRXNOME,TRXFLGCF,TRXCODFIS,TRXLUONAS,TRXNUMDOC,TRXDATSCA,TRXDATRIL,TRXTIPDOC,TRXDATNAS,TRXSESSO,TRXFLGFOR,TRXFORCE,FLGDATIOLD,xtipdoc,xtnumdoc,TRXTFINLAV,TRDFINLAV,TRFLGINLAV,TRXFLGAUA,TRXESITO,finalized,xluonas"+FoundlingChildrenList("armt_wutrxchk_aua",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_wutrxchk_aua"),new String[][]{new String[]{"TRXCODPRG","ID Transazione","N","15","0","campo","key1","false","false"},new String[]{"TRXCOGNOM","Cognome","C","50","0","campo","key2","false","false"},new String[]{"TRXNOME","Nome","C","50","0","campo","nokey","false","false"},new String[]{"TRXFLGCF","Flag Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"TRXCODFIS","Codice Ficale (reale)","C","16","0","campo","key4","false","false"},new String[]{"TRXLUONAS","Luogo di nascita","C","50","0","campo","nokey","false","false"},new String[]{"TRXNUMDOC","Numero Documento","C","30","0","campo","nokey","false","false"},new String[]{"TRXDATSCA","Data Scadenza Documento","D","8","0","campo","nokey","false","false"},new String[]{"TRXDATRIL","Data Rilascio Documento","D","8","0","campo","nokey","false","false"},new String[]{"TRXTIPDOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"TRXDATNAS","Data Di Nascita","D","8","0","campo","nokey","false","false"},new String[]{"TRXSESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"TRXFLGFOR","FORZATURA INSERIMENTO","C","1","0","campo","nokey","false","false"},new String[]{"TRXFORCE","Motivazione Forzatura","C","3","0","campo","nokey","false","true"},new String[]{"FLGDATIOLD","","C","1","0","variabile","nokey","false","false"},new String[]{"xtipdoc","","C","2","0","variabile","nokey","false","false"},new String[]{"xtnumdoc","","C","15","0","variabile","nokey","false","false"},new String[]{"TRXTFINLAV","Ora Fine Lavorazione","T","14","0","campo","nokey","false","false"},new String[]{"TRDFINLAV","Data Fine Lavorazione","D","8","0","campo","nokey","false","false"},new String[]{"TRFLGINLAV","IN lavorazione","C","1","0","campo","nokey","false","false"},new String[]{"TRXFLGAUA","OPERAZIONE CORRETTA AUA","C","1","0","campo","nokey","false","false"},new String[]{"TRXESITO","Tipo Esito","C","1","0","campo","nokey","false","false"},new String[]{"finalized","","C","1","0","variabile","nokey","false","false"},new String[]{"xluonas","","C","50","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_wutrxchk_auaBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk",p_ContextObject.GetCompany(),false);
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_oWrInfo_wutrxchk = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wutrxchk",p_ContextObject.GetCompany());
    m_cVirtName_wutrxchk = CPSql.ManipulateTablePhName("wutrxchk",m_cServer_wutrxchk);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_wuforcer = p_ContextObject.GetPhName("wuforcer");
    m_cServer_wuforcer = p_ContextObject.GetServer("wuforcer");
    m_oWrInfo_wuforcer = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wuforcer",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    m_oWrInfo_tbluonas = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbluonas",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    m_cPhName_wutipdoc = p_ContextObject.GetPhName("wutipdoc");
    m_cServer_wutipdoc = p_ContextObject.GetServer("wutipdoc");
    m_oWrInfo_wutipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wutipdoc",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_wutrxchk_aua",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_TRXCODPRG = 0;
    w_TRXCOGNOM = "";
    w_TRXNOME = "";
    w_TRXFLGCF = "";
    w_TRXCODFIS = "";
    w_TRXLUONAS = "";
    w_TRXNUMDOC = "";
    w_TRXDATSCA = CPLib.NullDate();
    w_TRXDATRIL = CPLib.NullDate();
    w_TRXTIPDOC = "";
    w_TRXMTCN = "";
    w_TRXDATNAS = CPLib.NullDate();
    w_TRXDATOPE = CPLib.NullDate();
    w_TRXSESSO = "";
    w_doctype = "";
    w_TRXNASSTATO = "";
    w_TRXNASCOMUN = "";
    w_TRXFLGAUAQ1 = "";
    w_TRXFLGAUAQ2 = "";
    w_TRXFLGAUAQ3 = "";
    w_TRXFLGAUAQ4 = "";
    w_TRXFLGAUAQ5 = "";
    w_TRXFORCE = "";
    w_TRXDATRICERCA = CPLib.NullDate();
    w_xTRXPROVINCIA = "";
    w_xtipdoc = "";
    w_xtnumdoc = "";
    w_TRXTFINLAV = CPLib.NullDateTime();
    w_TRDFINLAV = CPLib.NullDate();
    w_TRFLGINLAV = "";
    w_TRXFLGAUA = "";
    w_TRXESITO = "";
    w_TRXAUTRIL = "";
    w_xDESCRIZ = "";
    w_TRXCODDIP = "";
    w_TRXUTENTE = 0;
    w_TRFLGINLAV = "";
    w_TRXTINILAV = CPLib.NullDateTime();
    w_TRXDINILAV = CPLib.NullDate();
    w_xluonas = "";
    w_TRSSEGNO = "";
    w_TRXIMPORTO = 0;
    w_TRXCONTAN = 0;
    w_TRXUNIQUE = "";
    w_TRXCOGCON = "";
    w_TRXNOMCON = "";
    w_TRXDESTIN = "";
    w_TRXCODCAS = "";
    w_TRXRECTYPE = "";
    w_TRXCODMAG = "";
    w_TRXCODUNI = "";
    w_xMADESCRI = "";
    w_TRXNAZRES = "";
    w_TRXCITRES = "";
    w_TRXDOMICI = "";
    Link_CAICHGXWXW();
    Link_TTQTFXMWFO();
    w_sesso = "";
    w_sesso = (CPLib.eq(w_TRXSESSO,"M")?"1":(CPLib.eq(w_TRXSESSO,"F")?"2":""));
    w_TRXFLGAUA = "N";
    w_TRXFLGFOR = "N";
    w_FLGDATIOLD = "N";
    Link_HZPBCLSNRS();
    w_finalized = "N";
    w_TRXFLGCON = "N";
    Link_UTFQIBBLAF();
    Link_UUXGHAXWLH();
    Link_XSZDOLIZKJ();
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
    o_xtnumdoc = w_xtnumdoc;
    o_TRXCODDIP = w_TRXCODDIP;
    o_TRXCODMAG = w_TRXCODMAG;
    o_TRXNAZRES = w_TRXNAZRES;
    o_TRXCITRES = w_TRXCITRES;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_BVSAGKQXNV();
      Calculation_OIUROZTPFN();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_CAICHGXWXW() {
    return Link_CAICHGXWXW("Full");
  }
  protected boolean Link_CAICHGXWXW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXLUONAS))) {
      String l_OldValue = w_TRXLUONAS;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXLUONAS,"C",50,0),m_cServer_tbluonas,w_TRXLUONAS);
      if (m_Ctx.IsSharedTemp("tbluonas")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbluonas,"select DESCRI,PROVINCIA from "+m_cPhName_tbluonas+((m_cPhName_tbluonas).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TRXLUONAS = l_rsLink.GetString("DESCRI");
          w_xTRXPROVINCIA = l_rsLink.GetString("PROVINCIA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CAICHGXWXW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXLUONAS = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXLUONAS");
          }
          m_cLastWorkVarError = "TRXLUONAS";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CAICHGXWXW_blank();
    }
    return l_bResult;
  }
  void Link_CAICHGXWXW_blank() {
    w_TRXLUONAS = "";
    w_xTRXPROVINCIA = "";
  }
  protected boolean Link_TTQTFXMWFO() {
    return Link_TTQTFXMWFO("Full");
  }
  protected boolean Link_TTQTFXMWFO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXTIPDOC))) {
      String l_OldValue = w_TRXTIPDOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXTIPDOC,"C",2,0),m_cServer_wutipdoc,w_TRXTIPDOC);
      if (m_Ctx.IsSharedTemp("wutipdoc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_wutipdoc,"select WUTDCODICE,WUTDTIPDOC from "+m_cPhName_wutipdoc+((m_cPhName_wutipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"WUTDCODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TRXTIPDOC = l_rsLink.GetString("WUTDCODICE");
          w_doctype = l_rsLink.GetString("WUTDTIPDOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_TTQTFXMWFO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXTIPDOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXTIPDOC");
          }
          m_cLastWorkVarError = "TRXTIPDOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_TTQTFXMWFO_blank();
    }
    return l_bResult;
  }
  void Link_TTQTFXMWFO_blank() {
    w_TRXTIPDOC = "";
    w_doctype = "";
  }
  protected boolean Link_HZPBCLSNRS() {
    return Link_HZPBCLSNRS("Full");
  }
  protected boolean Link_HZPBCLSNRS(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXCODDIP))) {
      String l_OldValue = w_TRXCODDIP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODDIP,"C",10,0),m_cServer_anadip,w_TRXCODDIP);
      l_cWhere = l_cWhere+" and MACROAGENTE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODMAG,"C",5,0),m_cServer_anadip,w_TRXCODMAG);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select AGACCODE,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"AGACCODE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TRXCODDIP = l_rsLink.GetString("AGACCODE");
          w_xDESCRIZ = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HZPBCLSNRS_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXCODDIP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXCODDIP");
          }
          m_cLastWorkVarError = "TRXCODDIP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HZPBCLSNRS_blank();
    }
    return l_bResult;
  }
  void Link_HZPBCLSNRS_blank() {
    w_TRXCODDIP = "";
    w_xDESCRIZ = "";
  }
  protected boolean Link_UTFQIBBLAF() {
    return Link_UTFQIBBLAF("Full");
  }
  protected boolean Link_UTFQIBBLAF(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXCODMAG))) {
      String l_OldValue = w_TRXCODMAG;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODMAG,"C",5,0),m_cServer_tbmacage,w_TRXCODMAG);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MANAIDWU,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MANAIDWU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TRXCODMAG = l_rsLink.GetString("MANAIDWU");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UTFQIBBLAF_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXCODMAG = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXCODMAG");
          }
          m_cLastWorkVarError = "TRXCODMAG";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UTFQIBBLAF_blank();
    }
    return l_bResult;
  }
  void Link_UTFQIBBLAF_blank() {
    w_TRXCODMAG = "";
    w_xMADESCRI = "";
  }
  protected boolean Link_UUXGHAXWLH() {
    return Link_UUXGHAXWLH("Full");
  }
  protected boolean Link_UUXGHAXWLH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXNAZRES))) {
      String l_OldValue = w_TRXNAZRES;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXNAZRES,"C",50,0),m_cServer_tbstati,w_TRXNAZRES);
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
          w_TRXNAZRES = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UUXGHAXWLH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXNAZRES = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXNAZRES");
          }
          m_cLastWorkVarError = "TRXNAZRES";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UUXGHAXWLH_blank();
    }
    return l_bResult;
  }
  void Link_UUXGHAXWLH_blank() {
    w_TRXNAZRES = "";
  }
  protected boolean Link_XSZDOLIZKJ() {
    return Link_XSZDOLIZKJ("Full");
  }
  protected boolean Link_XSZDOLIZKJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TRXCITRES))) {
      String l_OldValue = w_TRXCITRES;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCITRES,"C",50,0),m_cServer_tbcitta,w_TRXCITRES);
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
          w_TRXCITRES = l_rsLink.GetString("CITTA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_XSZDOLIZKJ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TRXCITRES = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TRXCITRES");
          }
          m_cLastWorkVarError = "TRXCITRES";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XSZDOLIZKJ_blank();
    }
    return l_bResult;
  }
  void Link_XSZDOLIZKJ_blank() {
    w_TRXCITRES = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_TRXCODPRG(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODPRG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCOGNOM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCOGNOM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGCF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGCF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODFIS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODFIS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXLUONAS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXLUONAS = p_workVariableValue;
    l_bResult = Link_CAICHGXWXW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TRXLUONAS = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNUMDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNUMDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATSCA(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATSCA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATRIL(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATRIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXTIPDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXTIPDOC = p_workVariableValue;
    l_bResult = Link_TTQTFXMWFO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TRXTIPDOC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATNAS(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATNAS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXSESSO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXSESSO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGFOR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGFOR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFORCE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFORCE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TRXFORCE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean GYMTADSNZN_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_TRXFLGFOR,"S");
  }
  public boolean Set_FLGDATIOLD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGDATIOLD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_xtipdoc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_xtipdoc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_xtnumdoc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_xtnumdoc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXTFINLAV(java.sql.Timestamp p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXTFINLAV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRDFINLAV(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRDFINLAV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRFLGINLAV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRFLGINLAV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGAUA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGAUA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXESITO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXESITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_finalized(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_finalized = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_xluonas(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_xluonas = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_TRXFLGFOR() {
    return true;
  }
  public boolean getVisible_FLGDATIOLD() {
    return true;
  }
  public boolean getVisible_xtipdoc() {
    return true;
  }
  public boolean getVisible_xtnumdoc() {
    return true;
  }
  public boolean getVisible_TRXTFINLAV() {
    return true;
  }
  public boolean getVisible_TRDFINLAV() {
    return true;
  }
  public boolean getVisible_TRFLGINLAV() {
    return true;
  }
  public boolean getVisible_TRXFLGAUA() {
    return true;
  }
  public boolean getVisible_TRXESITO() {
    return true;
  }
  public boolean getVisible_finalized() {
    return true;
  }
  public boolean getVisible_xluonas() {
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
    w_sesso = (CPLib.eq(w_TRXSESSO,"M")?"1":(CPLib.eq(w_TRXSESSO,"F")?"2":""));
    if (CPLib.ne(o_xtnumdoc,w_xtnumdoc)) {
      Calculation_CCEVZSDPHQ();
    }
    if (CPLib.ne(o_TRXCODDIP,w_TRXCODDIP)) {
      l_bTmpRes = Link_HZPBCLSNRS();
    }
    if (CPLib.ne(o_TRXCODMAG,w_TRXCODMAG)) {
      l_bTmpRes = Link_UTFQIBBLAF();
    }
    if (CPLib.ne(o_TRXNAZRES,w_TRXNAZRES)) {
      l_bTmpRes = Link_UUXGHAXWLH();
    }
    if (CPLib.ne(o_TRXCITRES,w_TRXCITRES)) {
      l_bTmpRes = Link_XSZDOLIZKJ();
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
  void Calculation_CCEVZSDPHQ() {
    arrt_wutrxchk_upddataR l_oRoutine_arrt_wutrxchk_upddata;
    l_oRoutine_arrt_wutrxchk_upddata = arrt_wutrxchk_upddataR.Make(m_Ctx,this);
    l_oRoutine_arrt_wutrxchk_upddata.Run();
  }
  void Calculation_BVSAGKQXNV() {
    arrt_wu_autocorrectR l_oRoutine_arrt_wu_autocorrect;
    l_oRoutine_arrt_wu_autocorrect = arrt_wu_autocorrectR.Make(m_Ctx,this);
    l_oRoutine_arrt_wu_autocorrect.Run();
    arrt_wutrxchk_saveR l_oRoutine_arrt_wutrxchk_save;
    l_oRoutine_arrt_wutrxchk_save = arrt_wutrxchk_saveR.Make(m_Ctx,this);
    l_oRoutine_arrt_wutrxchk_save.Run();
  }
  void Calculation_OIUROZTPFN() {
    arrt_wutrxchk_aua_exitR l_oRoutine_arrt_wutrxchk_aua_exit;
    if (CPLib.eq(w_finalized,"N")) {
      l_oRoutine_arrt_wutrxchk_aua_exit = arrt_wutrxchk_aua_exitR.Make(m_Ctx,this);
      l_oRoutine_arrt_wutrxchk_aua_exit.pIDTrx = w_TRXCODPRG;
      l_oRoutine_arrt_wutrxchk_aua_exit.pTipo = "U";
      l_oRoutine_arrt_wutrxchk_aua_exit.Run();
    }
  }
  boolean Check_QFZMCGCOBP(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
      l_bResult =  ! ( ! (CPLib.Empty(w_xTRXPROVINCIA)) && CPLib.ne(w_xTRXPROVINCIA,"EE") && CPLib.Empty(w_TRXCODFIS));
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Impossibile salvare un soggetto nato in Italia senza codice fiscale";
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
  public final static String[] m_KeyColumns = {"TRXCODPRG"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ProjectAndApplicationQueryFilter("armt_wutrxchk_aua","wutrxchk",m_KeyColumns,"TRXFLGAUA='N' and TRXFLGAUI='S'",m_Ctx);
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
    w_TRXCODPRG = 0;
    w_TRXCOGNOM = "";
    w_TRXNOME = "";
    w_TRXFLGCF = "";
    w_TRXCODFIS = "";
    w_TRXLUONAS = "";
    w_TRXNUMDOC = "";
    w_TRXDATSCA = CPLib.NullDate();
    w_TRXDATRIL = CPLib.NullDate();
    w_TRXTIPDOC = "";
    w_TRXMTCN = "";
    w_TRXDATNAS = CPLib.NullDate();
    w_TRXDATOPE = CPLib.NullDate();
    w_TRXSESSO = "";
    w_doctype = "";
    w_sesso = "";
    w_TRXNASSTATO = "";
    w_TRXNASCOMUN = "";
    w_TRXFLGAUAQ1 = "";
    w_TRXFLGAUAQ2 = "";
    w_TRXFLGAUAQ3 = "";
    w_TRXFLGAUAQ4 = "";
    w_TRXFLGAUAQ5 = "";
    w_TRXFLGAUA = "";
    w_TRXFLGFOR = "";
    w_TRXFORCE = "";
    w_TRXDATRICERCA = CPLib.NullDate();
    w_xTRXPROVINCIA = "";
    w_FLGDATIOLD = "";
    w_xtipdoc = "";
    w_xtnumdoc = "";
    w_TRXTFINLAV = CPLib.NullDateTime();
    w_TRDFINLAV = CPLib.NullDate();
    w_TRFLGINLAV = "";
    w_TRXFLGAUA = "";
    w_TRXESITO = "";
    w_TRXAUTRIL = "";
    w_xDESCRIZ = "";
    w_TRXCODDIP = "";
    w_finalized = "";
    w_TRXUTENTE = 0;
    w_TRFLGINLAV = "";
    w_TRXTINILAV = CPLib.NullDateTime();
    w_TRXDINILAV = CPLib.NullDate();
    w_xluonas = "";
    w_TRXFLGCON = "";
    w_TRSSEGNO = "";
    w_TRXIMPORTO = 0;
    w_TRXCONTAN = 0;
    w_TRXUNIQUE = "";
    w_TRXCOGCON = "";
    w_TRXNOMCON = "";
    w_TRXDESTIN = "";
    w_TRXCODCAS = "";
    w_TRXRECTYPE = "";
    w_TRXCODMAG = "";
    w_TRXCODUNI = "";
    w_xMADESCRI = "";
    w_TRXNAZRES = "";
    w_TRXCITRES = "";
    w_TRXDOMICI = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_TRXCODPRG = CPLib.GetProperty(p,"TRXCODPRG",w_TRXCODPRG,0);
      op_TRXCODPRG = CPLib.GetProperty(p,"op_TRXCODPRG",0,0);
      w_TRXCOGNOM = CPLib.GetProperty(p,"TRXCOGNOM",w_TRXCOGNOM,0);
      w_TRXNOME = CPLib.GetProperty(p,"TRXNOME",w_TRXNOME,0);
      w_TRXFLGCF = CPLib.GetProperty(p,"TRXFLGCF",w_TRXFLGCF,0);
      w_TRXCODFIS = CPLib.GetProperty(p,"TRXCODFIS",w_TRXCODFIS,0);
      w_TRXLUONAS = CPLib.GetProperty(p,"TRXLUONAS",w_TRXLUONAS,0);
      w_TRXNUMDOC = CPLib.GetProperty(p,"TRXNUMDOC",w_TRXNUMDOC,0);
      w_TRXDATSCA = CPLib.GetProperty(p,"TRXDATSCA",w_TRXDATSCA,0);
      w_TRXDATRIL = CPLib.GetProperty(p,"TRXDATRIL",w_TRXDATRIL,0);
      w_TRXTIPDOC = CPLib.GetProperty(p,"TRXTIPDOC",w_TRXTIPDOC,0);
      w_TRXMTCN = CPLib.GetProperty(p,"TRXMTCN",w_TRXMTCN,0);
      w_TRXDATNAS = CPLib.GetProperty(p,"TRXDATNAS",w_TRXDATNAS,0);
      w_TRXDATOPE = CPLib.GetProperty(p,"TRXDATOPE",w_TRXDATOPE,0);
      w_TRXFLGCON = CPLib.GetProperty(p,"TRXFLGCON",w_TRXFLGCON,0);
      w_TRSSEGNO = CPLib.GetProperty(p,"TRSSEGNO",w_TRSSEGNO,0);
      w_TRXIMPORTO = CPLib.GetProperty(p,"TRXIMPORTO",w_TRXIMPORTO,0);
      w_TRXCONTAN = CPLib.GetProperty(p,"TRXCONTAN",w_TRXCONTAN,0);
      w_TRXUNIQUE = CPLib.GetProperty(p,"TRXUNIQUE",w_TRXUNIQUE,0);
      w_TRXCOGCON = CPLib.GetProperty(p,"TRXCOGCON",w_TRXCOGCON,0);
      w_TRXNOMCON = CPLib.GetProperty(p,"TRXNOMCON",w_TRXNOMCON,0);
      w_TRXDESTIN = CPLib.GetProperty(p,"TRXDESTIN",w_TRXDESTIN,0);
      w_TRXCODCAS = CPLib.GetProperty(p,"TRXCODCAS",w_TRXCODCAS,0);
      w_TRXRECTYPE = CPLib.GetProperty(p,"TRXRECTYPE",w_TRXRECTYPE,0);
      w_TRXCODMAG = CPLib.GetProperty(p,"TRXCODMAG",w_TRXCODMAG,0);
      w_TRXCODUNI = CPLib.GetProperty(p,"TRXCODUNI",w_TRXCODUNI,0);
      w_TRXSESSO = CPLib.GetProperty(p,"TRXSESSO",w_TRXSESSO,0);
      w_TRXNASSTATO = CPLib.GetProperty(p,"TRXNASSTATO",w_TRXNASSTATO,0);
      w_TRXNASCOMUN = CPLib.GetProperty(p,"TRXNASCOMUN",w_TRXNASCOMUN,0);
      w_TRXFLGAUAQ1 = CPLib.GetProperty(p,"TRXFLGAUAQ1",w_TRXFLGAUAQ1,0);
      w_TRXFLGAUAQ2 = CPLib.GetProperty(p,"TRXFLGAUAQ2",w_TRXFLGAUAQ2,0);
      w_TRXFLGAUAQ3 = CPLib.GetProperty(p,"TRXFLGAUAQ3",w_TRXFLGAUAQ3,0);
      w_TRXFLGAUAQ4 = CPLib.GetProperty(p,"TRXFLGAUAQ4",w_TRXFLGAUAQ4,0);
      w_TRXFLGAUAQ5 = CPLib.GetProperty(p,"TRXFLGAUAQ5",w_TRXFLGAUAQ5,0);
      w_TRXFLGAUA = CPLib.GetProperty(p,"TRXFLGAUA",w_TRXFLGAUA,0);
      w_TRXFLGFOR = CPLib.GetProperty(p,"TRXFLGFOR",w_TRXFLGFOR,0);
      w_TRXFORCE = CPLib.GetProperty(p,"TRXFORCE",w_TRXFORCE,0);
      w_TRXDATRICERCA = CPLib.GetProperty(p,"TRXDATRICERCA",w_TRXDATRICERCA,0);
      w_TRXNAZRES = CPLib.GetProperty(p,"TRXNAZRES",w_TRXNAZRES,0);
      w_TRXCITRES = CPLib.GetProperty(p,"TRXCITRES",w_TRXCITRES,0);
      w_TRXDOMICI = CPLib.GetProperty(p,"TRXDOMICI",w_TRXDOMICI,0);
      w_TRXTFINLAV = CPLib.GetProperty(p,"TRXTFINLAV",w_TRXTFINLAV,0);
      w_TRDFINLAV = CPLib.GetProperty(p,"TRDFINLAV",w_TRDFINLAV,0);
      w_TRFLGINLAV = CPLib.GetProperty(p,"TRFLGINLAV",w_TRFLGINLAV,0);
      w_TRXESITO = CPLib.GetProperty(p,"TRXESITO",w_TRXESITO,0);
      w_TRXAUTRIL = CPLib.GetProperty(p,"TRXAUTRIL",w_TRXAUTRIL,0);
      w_TRXCODDIP = CPLib.GetProperty(p,"TRXCODDIP",w_TRXCODDIP,0);
      w_TRXUTENTE = CPLib.GetProperty(p,"TRXUTENTE",w_TRXUTENTE,0);
      w_TRXTINILAV = CPLib.GetProperty(p,"TRXTINILAV",w_TRXTINILAV,0);
      w_TRXDINILAV = CPLib.GetProperty(p,"TRXDINILAV",w_TRXDINILAV,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_doctype = CPLib.GetProperty(p,"doctype",w_doctype,0);
      w_sesso = CPLib.GetProperty(p,"sesso",w_sesso,0);
      w_xTRXPROVINCIA = CPLib.GetProperty(p,"xTRXPROVINCIA",w_xTRXPROVINCIA,0);
      w_FLGDATIOLD = CPLib.GetProperty(p,"FLGDATIOLD",w_FLGDATIOLD,0);
      w_xtipdoc = CPLib.GetProperty(p,"xtipdoc",w_xtipdoc,0);
      w_xtnumdoc = CPLib.GetProperty(p,"xtnumdoc",w_xtnumdoc,0);
      w_xDESCRIZ = CPLib.GetProperty(p,"xDESCRIZ",w_xDESCRIZ,0);
      w_finalized = CPLib.GetProperty(p,"finalized",w_finalized,0);
      w_xluonas = CPLib.GetProperty(p,"xluonas",w_xluonas,0);
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
    items = tables.get("tbluonas");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbluonas",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"DESCRI","PROVINCIA"});
    map.put("rd_var",new String[]{"w_TRXLUONAS","w_xTRXPROVINCIA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Luogo di nascita\u0000Provincia Nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbluonas\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Luoghi di Nascita\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("wutipdoc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("wutipdoc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"WUTDCODICE","WUTDTIPDOC"});
    map.put("rd_var",new String[]{"w_TRXTIPDOC","w_doctype"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Documento\u0000Tipo Documento AUI",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("wutipdoc\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"AGACCODE","DESCRIZ"});
    map.put("rd_var",new String[]{"w_TRXCODDIP","w_xDESCRIZ"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Agenzia\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Agenzie\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"MANAIDWU","MADESCRI"});
    map.put("rd_var",new String[]{"w_TRXCODMAG","w_xMADESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice MacroAgente\u0000Denominazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Macro Agenti\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_TRXNAZRES"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Nazione di Residenza",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000armt_stati\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_TRXCITRES"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città Di residenza",-1));
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
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_wutrxchk_aua",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_wutrxchk_aua",child);
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
    m_MNTs = CPLib.MNTChilds("armt_wutrxchk_aua",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.Empty(w_TRXFORCE) && GYMTADSNZN_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TRXFORCE));
      String obblMsgError = m_Ctx.Translate("Motivazione Forzatura")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TRXFORCE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TRXFORCE";
      }
    } else if ( ! (Check_QFZMCGCOBP(true))) {
      l_bResult = false;
    }
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
      l_Keys = new String[]{"armt_wutrxchk_aua"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_wutrxchk_aua\\"+p_cState};
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
    l_bResult = false;
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Non è possibile cancellare una transazione";
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
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_TRXCODPRG = m_Ctx.AskTableProg(w_TRXCODPRG,15,op_TRXCODPRG,"PRGRTRA",m_cServer_wutrxchk);
    op_TRXCODPRG = w_TRXCODPRG;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_TRXCODPRG = 0;
    // Inizializzazione delle variabili per DependsOn
    o_xtnumdoc = "";
    o_TRXCODDIP = "";
    o_TRXCODMAG = "";
    o_TRXNAZRES = "";
    o_TRXCITRES = "";
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
    CPLib.PutProperty(p,"TRXCODPRG",w_TRXCODPRG,0);
    CPLib.PutProperty(p,"op_TRXCODPRG",op_TRXCODPRG,0);
    CPLib.PutProperty(p,"TRXCOGNOM",w_TRXCOGNOM,0);
    CPLib.PutProperty(p,"TRXNOME",w_TRXNOME,0);
    CPLib.PutProperty(p,"TRXFLGCF",w_TRXFLGCF,0);
    CPLib.PutProperty(p,"TRXCODFIS",w_TRXCODFIS,0);
    CPLib.PutProperty(p,"TRXLUONAS",w_TRXLUONAS,0);
    CPLib.PutProperty(p,"TRXNUMDOC",w_TRXNUMDOC,0);
    CPLib.PutProperty(p,"TRXDATSCA",w_TRXDATSCA,0);
    CPLib.PutProperty(p,"TRXDATRIL",w_TRXDATRIL,0);
    CPLib.PutProperty(p,"TRXTIPDOC",w_TRXTIPDOC,0);
    CPLib.PutProperty(p,"TRXMTCN",w_TRXMTCN,0);
    CPLib.PutProperty(p,"TRXDATNAS",w_TRXDATNAS,0);
    CPLib.PutProperty(p,"TRXDATOPE",w_TRXDATOPE,0);
    CPLib.PutProperty(p,"TRXFLGCON",w_TRXFLGCON,0);
    CPLib.PutProperty(p,"TRSSEGNO",w_TRSSEGNO,0);
    CPLib.PutProperty(p,"TRXIMPORTO",w_TRXIMPORTO,0);
    CPLib.PutProperty(p,"TRXCONTAN",w_TRXCONTAN,0);
    CPLib.PutProperty(p,"TRXUNIQUE",w_TRXUNIQUE,0);
    CPLib.PutProperty(p,"TRXCOGCON",w_TRXCOGCON,0);
    CPLib.PutProperty(p,"TRXNOMCON",w_TRXNOMCON,0);
    CPLib.PutProperty(p,"TRXDESTIN",w_TRXDESTIN,0);
    CPLib.PutProperty(p,"TRXCODCAS",w_TRXCODCAS,0);
    CPLib.PutProperty(p,"TRXRECTYPE",w_TRXRECTYPE,0);
    CPLib.PutProperty(p,"TRXCODMAG",w_TRXCODMAG,0);
    CPLib.PutProperty(p,"TRXCODUNI",w_TRXCODUNI,0);
    CPLib.PutProperty(p,"TRXSESSO",w_TRXSESSO,0);
    CPLib.PutProperty(p,"TRXNASSTATO",w_TRXNASSTATO,0);
    CPLib.PutProperty(p,"TRXNASCOMUN",w_TRXNASCOMUN,0);
    CPLib.PutProperty(p,"TRXFLGAUAQ1",w_TRXFLGAUAQ1,0);
    CPLib.PutProperty(p,"TRXFLGAUAQ2",w_TRXFLGAUAQ2,0);
    CPLib.PutProperty(p,"TRXFLGAUAQ3",w_TRXFLGAUAQ3,0);
    CPLib.PutProperty(p,"TRXFLGAUAQ4",w_TRXFLGAUAQ4,0);
    CPLib.PutProperty(p,"TRXFLGAUAQ5",w_TRXFLGAUAQ5,0);
    CPLib.PutProperty(p,"TRXFLGAUA",w_TRXFLGAUA,0);
    CPLib.PutProperty(p,"TRXFLGFOR",w_TRXFLGFOR,0);
    CPLib.PutProperty(p,"TRXFORCE",w_TRXFORCE,0);
    CPLib.PutProperty(p,"TRXDATRICERCA",w_TRXDATRICERCA,0);
    CPLib.PutProperty(p,"TRXNAZRES",w_TRXNAZRES,0);
    CPLib.PutProperty(p,"TRXCITRES",w_TRXCITRES,0);
    CPLib.PutProperty(p,"TRXDOMICI",w_TRXDOMICI,0);
    CPLib.PutProperty(p,"TRXTFINLAV",w_TRXTFINLAV,0);
    CPLib.PutProperty(p,"TRDFINLAV",w_TRDFINLAV,0);
    CPLib.PutProperty(p,"TRFLGINLAV",w_TRFLGINLAV,0);
    CPLib.PutProperty(p,"TRXESITO",w_TRXESITO,0);
    CPLib.PutProperty(p,"TRXAUTRIL",w_TRXAUTRIL,0);
    CPLib.PutProperty(p,"TRXCODDIP",w_TRXCODDIP,0);
    CPLib.PutProperty(p,"TRXUTENTE",w_TRXUTENTE,0);
    CPLib.PutProperty(p,"TRXTINILAV",w_TRXTINILAV,0);
    CPLib.PutProperty(p,"TRXDINILAV",w_TRXDINILAV,0);
    CPLib.PutProperty(p,"xMADESCRI",w_xMADESCRI,0);
    CPLib.PutProperty(p,"doctype",w_doctype,0);
    CPLib.PutProperty(p,"sesso",w_sesso,0);
    CPLib.PutProperty(p,"xTRXPROVINCIA",w_xTRXPROVINCIA,0);
    CPLib.PutProperty(p,"FLGDATIOLD",w_FLGDATIOLD,0);
    CPLib.PutProperty(p,"xtipdoc",w_xtipdoc,0);
    CPLib.PutProperty(p,"xtnumdoc",w_xtnumdoc,0);
    CPLib.PutProperty(p,"xDESCRIZ",w_xDESCRIZ,0);
    CPLib.PutProperty(p,"finalized",w_finalized,0);
    CPLib.PutProperty(p,"xluonas",w_xluonas,0);
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
    return "wutrxchk"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("TRXCODPRG","N",15,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("w_TRXCODPRG");
    oneAutoNum.add("PRGRTRA");
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
