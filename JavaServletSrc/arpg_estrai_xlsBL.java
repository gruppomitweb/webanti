import java.util.*;

public class arpg_estrai_xlsBL extends arpg_estrai_xlsWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record � stato variato
  public boolean m_bUpdated;
  public int m_nRowStatus;
  // Variabile che mantiene il vecchio timestamp
  public String m_cOldCPCCCHK;
  public java.util.List<String> m_oParameters;
  protected String m_cPassword;
  protected String m_cOTP;
  //  Variabile che indica il tipo dell'ultimo
  //  errore, o messaggio da comunicare all'interfaccia,
  //  che si � verificato impostando una variabile di work.
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
  public static final String i_EntityName = "arpg_estrai_xls";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'connes':connes,'ragosc':ragosc,'cCODFISC':cCODFISC,'citnas':citnas,'stanas':stanas,'datnas':datnas,'ragben':ragben,'staben':staben,'dadata':dadata,'adata':adata,'flgmese':flgmese,'codmag':codmag,'cDIP':cDIP,'cMTCN':cMTCN,'tipofile':tipofile,'destfold':destfold,'opesel':opesel,'frzsel':frzsel,'attive':attive,'tipoout':tipoout,'nomefile':nomefile,'flgsto':flgsto,'flgncf':flgncf,'flgsegno':flgsegno}";
  public static final String i_CompleteStateStructure = "{'connes':connes,'ragosc':ragosc,'cCODFISC':cCODFISC,'citnas':citnas,'stanas':stanas,'datnas':datnas,'ragben':ragben,'staben':staben,'dadata':dadata,'adata':adata,'flgmese':flgmese,'codmag':codmag,'cDIP':cDIP,'cMTCN':cMTCN,'tipofile':tipofile,'destfold':destfold,'opesel':opesel,'frzsel':frzsel,'attive':attive,'tipoout':tipoout,'cdadata':cdadata,'c_adata':c_adata,'xdesdip':xdesdip,'nomefile':nomefile,'gUrlApp':gUrlApp,'gFileName':gFileName,'gFlgWU':gFlgWU,'xmadescri':xmadescri,'gAzienda':gAzienda,'flgsto':flgsto,'flgncf':flgncf,'flgsegno':flgsegno}";
  public static final String i_ItemSequence = "connes,ragosc,cCODFISC,citnas,stanas,datnas,ragben,staben,dadata,adata,flgmese,codmag,cDIP,cMTCN,tipofile,destfold,opesel,frzsel,attive,tipoout,nomefile,flgsto,flgncf,flgsegno";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"connes","NDG Intestatario","C","16","0","variabile","nokey","false","false"},new String[]{"ragosc","Nominativo","C","60","0","variabile","nokey","false","false"},new String[]{"cCODFISC","","C","16","0","variabile","nokey","false","false"},new String[]{"citnas","Citta di nascita","C","40","0","variabile","nokey","false","false"},new String[]{"stanas","Stato di nascita","C","40","0","variabile","nokey","false","false"},new String[]{"datnas","Data di nascita","D","8","0","variabile","nokey","false","false"},new String[]{"ragben","Nominativo","C","60","0","variabile","nokey","false","false"},new String[]{"staben","Stato di nascita","C","40","0","variabile","nokey","false","false"},new String[]{"dadata","","D","8","0","variabile","nokey","false","false"},new String[]{"adata","","D","8","0","variabile","nokey","false","false"},new String[]{"flgmese","","C","1","0","variabile","nokey","false","false"},new String[]{"codmag","MacroAgente","C","5","0","variabile","nokey","false","false"},new String[]{"cDIP","","C","6","0","variabile","nokey","false","false"},new String[]{"cMTCN","","C","10","0","variabile","nokey","false","false"},new String[]{"tipofile","Tipo File","C","1","0","variabile","nokey","false","false"},new String[]{"destfold","Cartella Destinazione","C","80","0","variabile","nokey","false","false"},new String[]{"opesel","","C","1","0","variabile","nokey","false","false"},new String[]{"frzsel","","C","1","0","variabile","nokey","false","false"},new String[]{"attive","","C","1","0","variabile","nokey","false","false"},new String[]{"tipoout","Tipo Output","C","1","0","variabile","nokey","false","false"},new String[]{"nomefile","File di Selezione","C","60","0","variabile","nokey","false","false"},new String[]{"flgsto","Dati Storici Soggetto","C","1","0","variabile","nokey","false","false"},new String[]{"flgncf","","C","1","0","variabile","nokey","false","false"},new String[]{"flgsegno","","C","1","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_estrai_xlsBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_connes = "";
    w_ragosc = "";
    w_cCODFISC = "";
    w_citnas = "";
    w_stanas = "";
    w_datnas = CPLib.NullDate();
    w_ragben = "";
    w_staben = "";
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    w_codmag = "";
    w_cDIP = "";
    w_cMTCN = "";
    w_tipofile = "";
    w_destfold = "";
    w_xdesdip = "";
    w_nomefile = "";
    w_gUrlApp = m_Ctx.GetGlobalString("gUrlApp");
    w_gFileName = m_Ctx.GetGlobalString("gFileName");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_xmadescri = "";
    w_nomefile = "";
    w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
    w_flgsto = "";
    Link_QEIVEBXKFW();
    Link_FKOHLGHPDQ();
    Link_CYKHQWZLSC();
    Link_FWTFXGQZAI();
    w_flgmese = "N";
    Link_DZAJHOZNZJ();
    Link_FBVBGICYQT();
    w_opesel = "S";
    w_frzsel = "S";
    w_attive = "N";
    w_tipoout = "E";
    w_cdadata = "";
    w_cdadata = (CPLib.Empty(w_dadata)?"":CPLib.DateToChar(w_dadata));
    w_c_adata = "";
    w_c_adata = (CPLib.Empty(w_adata)?"":CPLib.DateToChar(w_adata));
    w_flgncf = "N";
    w_flgsegno = "1";
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
  public void SaveDependsOn() {
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_IJLORSXQBU();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_QEIVEBXKFW() {
    return Link_QEIVEBXKFW("Full");
  }
  protected boolean Link_QEIVEBXKFW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_connes))) {
      String l_OldValue = w_connes;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"C",16,0),m_cServer_personbo,w_connes);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"C",60,0),m_cServer_personbo,w_connes);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_connes = l_rsLink.GetString("CONNES");
          w_ragosc = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QEIVEBXKFW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_connes = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","connes");
          }
          m_cLastWorkVarError = "connes";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QEIVEBXKFW_blank();
    }
    return l_bResult;
  }
  void Link_QEIVEBXKFW_blank() {
    w_connes = "";
    w_ragosc = "";
  }
  protected boolean Link_FKOHLGHPDQ() {
    return Link_FKOHLGHPDQ("Full");
  }
  protected boolean Link_FKOHLGHPDQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_citnas))) {
      String l_OldValue = w_citnas;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_citnas,"C",40,0),m_cServer_tbcitta,w_citnas);
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
          w_citnas = l_rsLink.GetString("CITTA");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_FKOHLGHPDQ_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","citnas");
          }
          m_cLastWorkVarError = "citnas";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_FKOHLGHPDQ_blank();
    }
    return l_bResult;
  }
  void Link_FKOHLGHPDQ_blank() {
    Link_FKOHLGHPDQ_blank("");
  }
  void Link_FKOHLGHPDQ_blank(String p_cType) {
  }
  protected boolean Link_CYKHQWZLSC() {
    return Link_CYKHQWZLSC("Full");
  }
  protected boolean Link_CYKHQWZLSC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_stanas))) {
      String l_OldValue = w_stanas;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stanas,"C",40,0),m_cServer_tbstati,w_stanas);
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
          w_stanas = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_CYKHQWZLSC_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","stanas");
          }
          m_cLastWorkVarError = "stanas";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CYKHQWZLSC_blank();
    }
    return l_bResult;
  }
  void Link_CYKHQWZLSC_blank() {
    Link_CYKHQWZLSC_blank("");
  }
  void Link_CYKHQWZLSC_blank(String p_cType) {
  }
  protected boolean Link_FWTFXGQZAI() {
    return Link_FWTFXGQZAI("Full");
  }
  protected boolean Link_FWTFXGQZAI(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_staben))) {
      String l_OldValue = w_staben;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_staben,"C",40,0),m_cServer_tbstati,w_staben);
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
          w_staben = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_FWTFXGQZAI_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","staben");
          }
          m_cLastWorkVarError = "staben";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_FWTFXGQZAI_blank();
    }
    return l_bResult;
  }
  void Link_FWTFXGQZAI_blank() {
    Link_FWTFXGQZAI_blank("");
  }
  void Link_FWTFXGQZAI_blank(String p_cType) {
  }
  protected boolean Link_DZAJHOZNZJ() {
    return Link_DZAJHOZNZJ("Full");
  }
  protected boolean Link_DZAJHOZNZJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_codmag))) {
      String l_OldValue = w_codmag;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmag,"C",5,0),m_cServer_tbmacage,w_codmag);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmag,"C",60,0),m_cServer_tbmacage,w_codmag);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MADESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_codmag = l_rsLink.GetString("MACODICE");
          w_xmadescri = l_rsLink.GetString("MADESCRI");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DZAJHOZNZJ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_codmag = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","codmag");
          }
          m_cLastWorkVarError = "codmag";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DZAJHOZNZJ_blank();
    }
    return l_bResult;
  }
  void Link_DZAJHOZNZJ_blank() {
    w_codmag = "";
    w_xmadescri = "";
  }
  protected boolean Link_FBVBGICYQT() {
    return Link_FBVBGICYQT("Full");
  }
  protected boolean Link_FBVBGICYQT(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_cDIP))) {
      String l_OldValue = w_cDIP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_cDIP,"C",6,0),m_cServer_anadip,w_cDIP);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_cDIP = l_rsLink.GetString("CODDIP");
          w_xdesdip = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_FBVBGICYQT_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_cDIP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","cDIP");
          }
          m_cLastWorkVarError = "cDIP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_FBVBGICYQT_blank();
    }
    return l_bResult;
  }
  void Link_FBVBGICYQT_blank() {
    w_cDIP = "";
    w_xdesdip = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_connes(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_connes = p_workVariableValue;
    l_bResult = Link_QEIVEBXKFW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_connes = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ragosc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ragosc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_cCODFISC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_cCODFISC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_citnas(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_citnas = p_workVariableValue;
    l_bResult = Link_FKOHLGHPDQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_citnas = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_stanas(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_stanas = p_workVariableValue;
    l_bResult = Link_CYKHQWZLSC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_stanas = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datnas(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datnas = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ragben(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ragben = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_staben(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_staben = p_workVariableValue;
    l_bResult = Link_FWTFXGQZAI();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_staben = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_dadata(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_dadata = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_adata(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_adata = p_workVariableValue;
    // 
    l_bResult = CPLib.ge(w_adata,w_dadata);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di fine periodo non deve essere minore di quella di inizio periodo!";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_adata = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgmese(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgmese = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_codmag(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_codmag = p_workVariableValue;
    l_bResult = Link_DZAJHOZNZJ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_codmag = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_cDIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_cDIP = p_workVariableValue;
    l_bResult = Link_FBVBGICYQT();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_cDIP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_cMTCN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_cMTCN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tipofile(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipofile = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_destfold(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_destfold = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_opesel(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_opesel = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_frzsel(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_frzsel = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_attive(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_attive = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tipoout(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipoout = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_nomefile(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_nomefile = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgsto(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgsto = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgncf(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgncf = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgsegno(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgsegno = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
                              abilitazione di un control.
                            */
  public boolean getWritable_nomefile() {
    return false;
  }
  public boolean getVisible_cCODFISC() {
    return CPLib.ne(w_gFlgWU,"S");
  }
  public boolean getVisible_cMTCN() {
    return CPLib.ne(w_gFlgWU,"S");
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
    w_cdadata = (CPLib.Empty(w_dadata)?"":CPLib.DateToChar(w_dadata));
    w_c_adata = (CPLib.Empty(w_adata)?"":CPLib.DateToChar(w_adata));
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_IJLORSXQBU() {
    azzera_messaggiR l_oRoutine_azzera_messaggi;
    l_oRoutine_azzera_messaggi = azzera_messaggiR.Make(m_Ctx,this);
    l_oRoutine_azzera_messaggi.Run();
  }
  protected void BlankStatusVariables() {
    m_bUpdated = false;
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_estrai_xls","",m_KeyColumns,m_Ctx);
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
    Blank();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_connes = CPLib.GetProperty(p,"connes",w_connes,0);
      w_ragosc = CPLib.GetProperty(p,"ragosc",w_ragosc,0);
      w_cCODFISC = CPLib.GetProperty(p,"cCODFISC",w_cCODFISC,0);
      w_citnas = CPLib.GetProperty(p,"citnas",w_citnas,0);
      w_stanas = CPLib.GetProperty(p,"stanas",w_stanas,0);
      w_datnas = CPLib.GetProperty(p,"datnas",w_datnas,0);
      w_ragben = CPLib.GetProperty(p,"ragben",w_ragben,0);
      w_staben = CPLib.GetProperty(p,"staben",w_staben,0);
      w_dadata = CPLib.GetProperty(p,"dadata",w_dadata,0);
      w_adata = CPLib.GetProperty(p,"adata",w_adata,0);
      w_flgmese = CPLib.GetProperty(p,"flgmese",w_flgmese,0);
      w_codmag = CPLib.GetProperty(p,"codmag",w_codmag,0);
      w_cDIP = CPLib.GetProperty(p,"cDIP",w_cDIP,0);
      w_cMTCN = CPLib.GetProperty(p,"cMTCN",w_cMTCN,0);
      w_tipofile = CPLib.GetProperty(p,"tipofile",w_tipofile,0);
      w_destfold = CPLib.GetProperty(p,"destfold",w_destfold,0);
      w_opesel = CPLib.GetProperty(p,"opesel",w_opesel,0);
      w_frzsel = CPLib.GetProperty(p,"frzsel",w_frzsel,0);
      w_attive = CPLib.GetProperty(p,"attive",w_attive,0);
      w_tipoout = CPLib.GetProperty(p,"tipoout",w_tipoout,0);
      w_cdadata = CPLib.GetProperty(p,"cdadata",w_cdadata,0);
      w_c_adata = CPLib.GetProperty(p,"c_adata",w_c_adata,0);
      w_xdesdip = CPLib.GetProperty(p,"xdesdip",w_xdesdip,0);
      w_nomefile = CPLib.GetProperty(p,"nomefile",w_nomefile,0);
      w_gUrlApp = CPLib.GetProperty(p,"gUrlApp",w_gUrlApp,0);
      w_gFileName = CPLib.GetProperty(p,"gFileName",w_gFileName,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_xmadescri = CPLib.GetProperty(p,"xmadescri",w_xmadescri,0);
      w_nomefile = CPLib.GetProperty(p,"nomefile",w_nomefile,0);
      w_gAzienda = CPLib.GetProperty(p,"gAzienda",w_gAzienda,0);
      w_flgsto = CPLib.GetProperty(p,"flgsto",w_flgsto,0);
      w_flgncf = CPLib.GetProperty(p,"flgncf",w_flgncf,0);
      w_flgsegno = CPLib.GetProperty(p,"flgsegno",w_flgsegno,0);
      SetUpdated();
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
  }
  public String EntityStatus() {
    return "D";
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
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_connes","w_ragosc"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("NDG Intestatario\u0000Nominativo",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_citnas"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Citta di nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Citt�\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_stanas"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
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
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
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
    map.put("rd_field",new String[]{"DESCRI"});
    map.put("rd_var",new String[]{"w_staben"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("40",-1));
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
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_codmag","w_xmadescri"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("MacroAgente\u0000Denominazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000MacroAgenti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ"});
    map.put("rd_var",new String[]{"w_cDIP","w_xdesdip"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030",-1));
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
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Dipendenze\u0000\u0000\u0000false",-1));
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
    return tables;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
