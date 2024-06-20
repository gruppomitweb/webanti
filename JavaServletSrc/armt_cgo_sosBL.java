import java.util.*;

public class armt_cgo_sosBL extends armt_cgo_sosWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_cgo_sos";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_sos;
  public String m_cServer_cgo_sos;
  public CPPhTableWrInfo m_oWrInfo_cgo_sos;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_sos;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
  public CPPhTableWrInfo m_oWrInfo_tbluonas;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public CPPhTableWrInfo m_oWrInfo_cgo_operazioni_storico;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
  public CPPhTableWrInfo m_oWrInfo_cgo_tipdoc;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_sos"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'SOSCODICE':SOSCODICE,'SOSCODDIP':SOSCODDIP,'SOSSEGNANT':SOSSEGNANT,'SOSSEGNAFAX':SOSSEGNAFAX,'SOSSEGNAEM':SOSSEGNAEM,'SOSSEGNACF':SOSSEGNACF,'SOSSEGNACOG':SOSSEGNACOG,'SOSSEGNANOM':SOSSEGNANOM,'SOSSEGNALN':SOSSEGNALN,'SOSSEGNADN':SOSSEGNADN,'SOSSEGNASX':SOSSEGNASX,'SOSSTATOOP':SOSSTATOOP,'IDBIGLIETTO':IDBIGLIETTO,'SOSDATAOP':SOSDATAOP,'SOSTIPOOP':SOSTIPOOP,'SOSIMPOPE':SOSIMPOPE,'SOSMEZPAG':SOSMEZPAG,'SOSNUMBON':SOSNUMBON,'SOSBANASS':SOSBANASS,'SOSNUMASS':SOSNUMASS,'SOSDESOPE':SOSDESOPE,'SOSMOTSOS':SOSMOTSOS,'SOSCLIECOG':SOSCLIECOG,'SOSCLIENOM':SOSCLIENOM,'SOSCLIELN':SOSCLIELN,'SOSCLIEDN':SOSCLIEDN,'SOSCLIESX':SOSCLIESX,'SOSCLIECF':SOSCLIECF,'SOSCLIEPAE':SOSCLIEPAE,'SOSCLIECR':SOSCLIECR,'SOSCLIEIND':SOSCLIEIND,'SOSCLIECAR':SOSCLIECAR,'SOSCLIETD':SOSCLIETD,'SOSCLIEND':SOSCLIEND,'SOSCLIEDRD':SOSCLIEDRD,'SOSCLIEDSD':SOSCLIEDSD,'SOSCLIEAUD':SOSCLIEAUD,'SOSCLIEPN':SOSCLIEPN,'SOSCLIEPR':SOSCLIEPR"+FoundlingChildrenList("armt_cgo_sos",true)+"}";
  public static final String i_CompleteStateStructure = "{'SOSCODICE':SOSCODICE,'gCodDip':gCodDip,'SOSCODDIP':SOSCODDIP,'SOSSEGNANT':SOSSEGNANT,'SOSSEGNAFAX':SOSSEGNAFAX,'SOSSEGNAEM':SOSSEGNAEM,'SOSSEGNACF':SOSSEGNACF,'SOSSEGNACOG':SOSSEGNACOG,'SOSSEGNANOM':SOSSEGNANOM,'SOSSEGNALN':SOSSEGNALN,'SOSSEGNADN':SOSSEGNADN,'SOSSEGNASX':SOSSEGNASX,'SOSSTATOOP':SOSSTATOOP,'IDBIGLIETTO':IDBIGLIETTO,'SOSDATAOP':SOSDATAOP,'SOSTIPOOP':SOSTIPOOP,'SOSIMPOPE':SOSIMPOPE,'SOSMEZPAG':SOSMEZPAG,'SOSNUMBON':SOSNUMBON,'SOSBANASS':SOSBANASS,'SOSNUMASS':SOSNUMASS,'SOSDESOPE':SOSDESOPE,'SOSMOTSOS':SOSMOTSOS,'SOSCLIECOG':SOSCLIECOG,'SOSCLIENOM':SOSCLIENOM,'SOSCLIELN':SOSCLIELN,'SOSCLIEDN':SOSCLIEDN,'SOSCLIESX':SOSCLIESX,'SOSCLIECF':SOSCLIECF,'SOSCLIEPAE':SOSCLIEPAE,'SOSCLIECR':SOSCLIECR,'SOSCLIEIND':SOSCLIEIND,'SOSCLIECAR':SOSCLIECAR,'SOSCLIETD':SOSCLIETD,'SOSCLIEND':SOSCLIEND,'SOSCLIEDRD':SOSCLIEDRD,'SOSCLIEDSD':SOSCLIEDSD,'SOSCLIEAUD':SOSCLIEAUD,'SOSSEGNAPN':SOSSEGNAPN,'SOSCLIEPN':SOSCLIEPN,'SOSCLIEPR':SOSCLIEPR,'xdesdip':xdesdip,'gUserCode':gUserCode,'SOSUTENTE':SOSUTENTE,'SOSDATSEG':SOSDATSEG,'xDESSTATO':xDESSTATO"+FoundlingChildrenList("armt_cgo_sos",true)+"}";
  public static final String i_ItemSequence = "SOSCODICE,SOSCODDIP,SOSSEGNANT,SOSSEGNAFAX,SOSSEGNAEM,SOSSEGNACF,SOSSEGNACOG,SOSSEGNANOM,SOSSEGNALN,SOSSEGNADN,SOSSEGNASX,SOSSTATOOP,IDBIGLIETTO,SOSDATAOP,SOSTIPOOP,SOSIMPOPE,SOSMEZPAG,SOSNUMBON,SOSBANASS,SOSNUMASS,SOSDESOPE,SOSMOTSOS,SOSCLIECOG,SOSCLIENOM,SOSCLIELN,SOSCLIEDN,SOSCLIESX,SOSCLIECF,SOSCLIEPAE,SOSCLIECR,SOSCLIEIND,SOSCLIECAR,SOSCLIETD,SOSCLIEND,SOSCLIEDRD,SOSCLIEDSD,SOSCLIEAUD,SOSCLIEPN,SOSCLIEPR"+FoundlingChildrenList("armt_cgo_sos",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_sos"),new String[][]{new String[]{"SOSCODICE","Numero Segnalazione","N","10","0","campo","key1","false","false"},new String[]{"SOSCODDIP","Agenzia di Riferimento","C","6","0","campo","key2","false","false"},new String[]{"SOSSEGNANT","N° Telefono","C","15","0","campo","nokey","false","true"},new String[]{"SOSSEGNAFAX","N° Fax","C","15","0","campo","nokey","false","true"},new String[]{"SOSSEGNAEM","EMail","C","40","0","campo","nokey","false","true"},new String[]{"SOSSEGNACF","Codice Fiscale Segnalante","C","16","0","campo","key3","false","true"},new String[]{"SOSSEGNACOG","Cognome","C","30","0","campo","key5","false","true"},new String[]{"SOSSEGNANOM","Nome","C","30","0","campo","nokey","false","true"},new String[]{"SOSSEGNALN","Luogo Nascita","C","50","0","campo","nokey","false","true"},new String[]{"SOSSEGNADN","Data di Nascita","D","8","0","campo","nokey","false","true"},new String[]{"SOSSEGNASX","Sesso","C","1","0","campo","nokey","false","true"},new String[]{"SOSSTATOOP","Stato Operazione","C","1","0","campo","nokey","false","false"},new String[]{"IDBIGLIETTO","ID Biglietto","C","28","0","variabile","nokey","false","false"},new String[]{"SOSDATAOP","Data Operazione","D","8","0","campo","nokey","false","false"},new String[]{"SOSTIPOOP","Tipo Operazione","C","1","0","campo","nokey","false","false"},new String[]{"SOSIMPOPE","Importo Operazione","N","15","2","campo","nokey","false","false"},new String[]{"SOSMEZPAG","Mezzo Pagamento","C","1","0","campo","nokey","false","false"},new String[]{"SOSNUMBON","N° Bonifico","C","30","0","campo","nokey","false","false"},new String[]{"SOSBANASS","Banca Assegno","C","50","0","campo","nokey","false","false"},new String[]{"SOSNUMASS","Numero Assegno","C","30","0","campo","nokey","false","false"},new String[]{"SOSDESOPE","Descrizione dell'operazione","M","10","0","campo","nokey","false","false"},new String[]{"SOSMOTSOS","Descrizione motivi del sospetto","M","10","0","campo","nokey","false","false"},new String[]{"SOSCLIECOG","Cognome Cliente","C","30","0","campo","key6","false","false"},new String[]{"SOSCLIENOM","Nome Cliente","C","30","0","campo","nokey","false","false"},new String[]{"SOSCLIELN","Luogo di nascita Cliente","C","50","0","campo","nokey","false","false"},new String[]{"SOSCLIEDN","Data di Nascita","D","8","0","campo","nokey","false","false"},new String[]{"SOSCLIESX","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"SOSCLIECF","Codice Fiscale Cliente","C","16","0","campo","key4","false","false"},new String[]{"SOSCLIEPAE","Paese di Residenza Cliente","C","3","0","campo","nokey","false","false"},new String[]{"SOSCLIECR","Comune","C","50","0","campo","nokey","false","false"},new String[]{"SOSCLIEIND","Indirizzo","C","50","0","campo","nokey","false","false"},new String[]{"SOSCLIECAR","CAP Residenza Cliente","C","5","0","campo","nokey","false","false"},new String[]{"SOSCLIETD","Tipo Documento Cliente","C","2","0","campo","nokey","false","false"},new String[]{"SOSCLIEND","N° Documento Cliente","C","15","0","campo","nokey","false","false"},new String[]{"SOSCLIEDRD","Data Rilascio","D","8","0","campo","nokey","false","false"},new String[]{"SOSCLIEDSD","Data Scadenza","D","8","0","campo","nokey","false","false"},new String[]{"SOSCLIEAUD","Autorità e Luogo Rilascio","C","50","0","campo","nokey","false","false"},new String[]{"SOSCLIEPN","Provicnia di Nascita Cliente","C","2","0","campo","nokey","false","false"},new String[]{"SOSCLIEPR","Provincia Residenza Cliente","C","2","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_sosBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_sos = p_ContextObject.GetPhName("cgo_sos",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_sos = p_ContextObject.GetServer("cgo_sos");
    m_oWrInfo_cgo_sos = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_sos",p_ContextObject.GetCompany());
    m_cVirtName_cgo_sos = CPSql.ManipulateTablePhName("cgo_sos",m_cServer_cgo_sos);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    m_oWrInfo_tbluonas = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbluonas",p_ContextObject.GetCompany());
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_oWrInfo_cgo_operazioni_storico = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_operazioni_storico",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
    m_oWrInfo_cgo_tipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tipdoc",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_cgo_sos",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_SOSCODICE = 0;
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_SOSSEGNANT = "";
    w_SOSSEGNAFAX = "";
    w_SOSSEGNAEM = "";
    w_SOSSEGNACF = "";
    w_SOSSEGNACOG = "";
    w_SOSSEGNANOM = "";
    w_SOSSEGNALN = "";
    w_SOSSEGNADN = CPLib.NullDate();
    w_SOSSEGNASX = "";
    w_SOSSTATOOP = "";
    w_IDBIGLIETTO = "";
    w_SOSDATAOP = CPLib.NullDate();
    w_SOSTIPOOP = "";
    w_SOSIMPOPE = 0;
    w_SOSMEZPAG = "";
    w_SOSNUMBON = "";
    w_SOSBANASS = "";
    w_SOSNUMASS = "";
    w_SOSDESOPE = "";
    w_SOSMOTSOS = "";
    w_SOSCLIECOG = "";
    w_SOSCLIENOM = "";
    w_SOSCLIELN = "";
    w_SOSCLIEDN = CPLib.NullDate();
    w_SOSCLIESX = "";
    w_SOSCLIECF = "";
    w_SOSCLIEPAE = "";
    w_SOSCLIECR = "";
    w_SOSCLIEIND = "";
    w_SOSCLIECAR = "";
    w_SOSCLIETD = "";
    w_SOSCLIEND = "";
    w_SOSCLIEDRD = CPLib.NullDate();
    w_SOSCLIEDSD = CPLib.NullDate();
    w_SOSCLIEAUD = "";
    w_SOSSEGNAPN = "";
    w_SOSCLIEPN = "";
    w_SOSCLIEPR = "";
    w_xdesdip = "";
    w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
    w_xDESSTATO = "";
    w_SOSCODDIP = "";
    w_SOSCODDIP = w_gCodDip;
    Link_DHBRXDCHIH();
    Link_NMTFLCHLGD();
    Link_UXJUHWBCMH();
    Link_EKWIYNRJCN();
    Link_CQREEAUGJZ();
    Link_RNXXROADTV();
    w_SOSUTENTE = 0;
    w_SOSUTENTE = w_gUserCode;
    w_SOSDATSEG = CPLib.NullDate();
    w_SOSDATSEG = CPLib.Date();
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
    o_SOSCODICE = w_SOSCODICE;
    o_IDBIGLIETTO = w_IDBIGLIETTO;
    o_SOSDATAOP = w_SOSDATAOP;
    o_SOSDESOPE = w_SOSDESOPE;
    o_SOSMOTSOS = w_SOSMOTSOS;
    o_SOSCLIEDRD = w_SOSCLIEDRD;
    o_SOSCLIEDSD = w_SOSCLIEDSD;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_DHBRXDCHIH() {
    return Link_DHBRXDCHIH("Full");
  }
  protected boolean Link_DHBRXDCHIH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOSCODDIP))) {
      String l_OldValue = w_SOSCODDIP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCODDIP,"C",6,0),m_cServer_anadip,w_SOSCODDIP);
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
          w_SOSCODDIP = l_rsLink.GetString("CODDIP");
          w_xdesdip = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DHBRXDCHIH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOSCODDIP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOSCODDIP");
          }
          m_cLastWorkVarError = "SOSCODDIP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DHBRXDCHIH_blank();
    }
    return l_bResult;
  }
  void Link_DHBRXDCHIH_blank() {
    w_SOSCODDIP = "";
    w_xdesdip = "";
  }
  protected boolean Link_NMTFLCHLGD() {
    return Link_NMTFLCHLGD("Full");
  }
  protected boolean Link_NMTFLCHLGD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOSSEGNALN))) {
      String l_OldValue = w_SOSSEGNALN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSSEGNALN,"C",50,0),m_cServer_tbluonas,w_SOSSEGNALN);
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
          w_SOSSEGNALN = l_rsLink.GetString("DESCRI");
          w_SOSSEGNAPN = l_rsLink.GetString("PROVINCIA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NMTFLCHLGD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOSSEGNALN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOSSEGNALN");
          }
          m_cLastWorkVarError = "SOSSEGNALN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NMTFLCHLGD_blank();
    }
    return l_bResult;
  }
  void Link_NMTFLCHLGD_blank() {
    w_SOSSEGNALN = "";
    w_SOSSEGNAPN = "";
  }
  protected boolean Link_UXJUHWBCMH() {
    return Link_UXJUHWBCMH("Full");
  }
  protected boolean Link_UXJUHWBCMH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDBIGLIETTO))) {
      String l_OldValue = w_IDBIGLIETTO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBIGLIETTO,"C",28,0),m_cServer_cgo_operazioni_storico,w_IDBIGLIETTO);
      l_cWhere = l_cWhere+" and CODDIPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_gCodDip,"C",6,0),m_cServer_cgo_operazioni_storico,w_gCodDip);
      if (m_Ctx.IsSharedTemp("cgo_operazioni_storico")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_operazioni_storico,"select CAIDBIGLIETTO from "+m_cPhName_cgo_operazioni_storico+((m_cPhName_cgo_operazioni_storico).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CAIDBIGLIETTO"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDBIGLIETTO = l_rsLink.GetString("CAIDBIGLIETTO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_UXJUHWBCMH_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDBIGLIETTO");
          }
          m_cLastWorkVarError = "IDBIGLIETTO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UXJUHWBCMH_blank();
    }
    return l_bResult;
  }
  void Link_UXJUHWBCMH_blank() {
    Link_UXJUHWBCMH_blank("");
  }
  void Link_UXJUHWBCMH_blank(String p_cType) {
  }
  protected boolean Link_EKWIYNRJCN() {
    return Link_EKWIYNRJCN("Full");
  }
  protected boolean Link_EKWIYNRJCN(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOSCLIELN))) {
      String l_OldValue = w_SOSCLIELN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCLIELN,"C",50,0),m_cServer_tbluonas,w_SOSCLIELN);
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
          w_SOSCLIELN = l_rsLink.GetString("DESCRI");
          w_SOSCLIEPN = l_rsLink.GetString("PROVINCIA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_EKWIYNRJCN_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOSCLIELN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOSCLIELN");
          }
          m_cLastWorkVarError = "SOSCLIELN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_EKWIYNRJCN_blank();
    }
    return l_bResult;
  }
  void Link_EKWIYNRJCN_blank() {
    w_SOSCLIELN = "";
    w_SOSCLIEPN = "";
  }
  protected boolean Link_CQREEAUGJZ() {
    return Link_CQREEAUGJZ("Full");
  }
  protected boolean Link_CQREEAUGJZ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOSCLIEPAE))) {
      String l_OldValue = w_SOSCLIEPAE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCLIEPAE,"C",3,0),m_cServer_tbstati,w_SOSCLIEPAE);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCLIEPAE,"C",40,0),m_cServer_tbstati,w_SOSCLIEPAE);
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
          w_SOSCLIEPAE = l_rsLink.GetString("CODSTA");
          w_xDESSTATO = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CQREEAUGJZ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOSCLIEPAE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOSCLIEPAE");
          }
          m_cLastWorkVarError = "SOSCLIEPAE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CQREEAUGJZ_blank();
    }
    return l_bResult;
  }
  void Link_CQREEAUGJZ_blank() {
    w_SOSCLIEPAE = "";
    w_xDESSTATO = "";
  }
  protected boolean Link_RNXXROADTV() {
    return Link_RNXXROADTV("Full");
  }
  protected boolean Link_RNXXROADTV(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOSCLIECR))) {
      String l_OldValue = w_SOSCLIECR;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCLIECR,"C",50,0),m_cServer_tbcitta,w_SOSCLIECR);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCLIECR,"C",2,0),m_cServer_tbcitta,w_SOSCLIECR);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"PROV"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SOSCLIECR = l_rsLink.GetString("CITTA");
          w_SOSCLIEPR = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_RNXXROADTV_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOSCLIECR");
          }
          m_cLastWorkVarError = "SOSCLIECR";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RNXXROADTV_blank();
    }
    return l_bResult;
  }
  void Link_RNXXROADTV_blank() {
    Link_RNXXROADTV_blank("");
  }
  void Link_RNXXROADTV_blank(String p_cType) {
    w_SOSCLIEPR = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_SOSCODICE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCODDIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCODDIP = p_workVariableValue;
    l_bResult = Link_DHBRXDCHIH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCODDIP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNANT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNANT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNANT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNAFAX(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNAFAX = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNAFAX = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNAEM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNAEM = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNAEM = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNACF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNACF = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNACF = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNACOG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNACOG = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNACOG = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNANOM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNANOM = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNANOM = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNALN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNALN = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_NMTFLCHLGD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNALN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNADN(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNADN = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNADN = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSEGNASX(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSEGNASX = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSSEGNASX = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSSTATOOP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSSTATOOP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDBIGLIETTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDBIGLIETTO = p_workVariableValue;
    l_bResult = Link_UXJUHWBCMH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDBIGLIETTO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSDATAOP(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSDATAOP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSTIPOOP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSTIPOOP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSIMPOPE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSIMPOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSMEZPAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSMEZPAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSNUMBON(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSNUMBON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSBANASS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSBANASS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSNUMASS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSNUMASS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSDESOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSDESOPE = p_workVariableValue;
    if ( ! (Check_OHCORUHEID(false))) {
      m_nLastError = 2;
      w_SOSDESOPE = "";
      return false;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSMOTSOS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSMOTSOS = p_workVariableValue;
    if ( ! (Check_GORGNKWJSO(false))) {
      m_nLastError = 2;
      w_SOSMOTSOS = "";
      return false;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIECOG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIECOG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIENOM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIENOM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIELN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIELN = p_workVariableValue;
    l_bResult = Link_EKWIYNRJCN();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCLIELN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEDN(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEDN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIESX(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIESX = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIECF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIECF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEPAE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEPAE = p_workVariableValue;
    l_bResult = Link_CQREEAUGJZ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCLIEPAE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIECR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIECR = p_workVariableValue;
    l_bResult = Link_RNXXROADTV();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCLIECR = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEIND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIECAR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIECAR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIETD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIETD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEDRD(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEDRD = p_workVariableValue;
    // 
    l_bResult = arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_SOSCLIEDRD,w_SOSCLIETD,"R",w_SOSDATAOP);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCLIEDRD = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEDSD(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEDSD = p_workVariableValue;
    // 
    l_bResult = arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_SOSCLIEDSD,w_SOSCLIETD,"S",w_SOSDATAOP);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOSCLIEDSD = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEAUD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEAUD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEPN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEPN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIEPR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSCLIEPR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_SOSCODDIP() {
    return false;
  }
  public boolean getWritable_SOSNUMBON() {
    return CPLib.gt(CPLib.At(w_SOSMEZPAG,"|I|P|E"),0);
  }
  public boolean getWritable_SOSBANASS() {
    return CPLib.gt(CPLib.At(w_SOSMEZPAG,"|C|B"),0);
  }
  public boolean getWritable_SOSNUMASS() {
    return CPLib.gt(CPLib.At(w_SOSMEZPAG,"|C|B"),0);
  }
  public boolean getWritable_SOSCLIEND() {
    return  ! (CPLib.Empty(w_SOSCLIETD));
  }
  public boolean getWritable_SOSCLIEDRD() {
    return  ! (CPLib.Empty(w_SOSCLIETD));
  }
  public boolean getWritable_SOSCLIEDSD() {
    return  ! (CPLib.Empty(w_SOSCLIETD));
  }
  public boolean getWritable_SOSCLIEAUD() {
    return  ! (CPLib.Empty(w_SOSCLIETD));
  }
  public boolean getVisible_IDBIGLIETTO() {
    return CPLib.ne(w_SOSSTATOOP,"E");
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
    if (CPLib.ne(o_SOSCODICE,w_SOSCODICE)) {
      w_SOSCODDIP = w_gCodDip;
      l_bTmpRes = Link_DHBRXDCHIH();
    }
    w_SOSUTENTE = w_gUserCode;
    w_SOSDATSEG = CPLib.Date();
    if (CPLib.ne(o_IDBIGLIETTO,w_IDBIGLIETTO)) {
      Calculation_WENWSAYLVY();
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
  void Calculation_WENWSAYLVY() {
    arrt_cgo_sos_bigliettoR l_oRoutine_arrt_cgo_sos_biglietto;
    l_oRoutine_arrt_cgo_sos_biglietto = arrt_cgo_sos_bigliettoR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_sos_biglietto.pObj = this;
    l_oRoutine_arrt_cgo_sos_biglietto.Run();
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "CGO_SOS";
    l_oRoutine_arrt_writelog.pChiave = CPLib.LRTrim(CPLib.Str(w_SOSCODICE,10,0));
    l_oRoutine_arrt_writelog.Run();
    arrt_cgo_sos_emailR l_oRoutine_arrt_cgo_sos_email;
    l_oRoutine_arrt_cgo_sos_email = arrt_cgo_sos_emailR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_sos_email.pCodice = w_SOSCODICE;
    l_oRoutine_arrt_cgo_sos_email.Run();
  }
  boolean Check_QNEKQYKSHZ(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOSCLIEDRD,w_SOSCLIEDRD) || CPLib.ne(o_SOSCLIEDSD,w_SOSCLIEDSD)) {
      l_bResult = ( ! (CPLib.Empty(w_SOSCLIEDSD)) &&  ! (CPLib.Empty(w_SOSCLIEDRD))?CPLib.le(w_SOSCLIEDRD,w_SOSCLIEDSD):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Data di rilascio superiore alla data fine validità. Verificare il corretto inserimento delle date.";
      }
    }
    return l_bResult;
  }
  boolean Check_YHNSLBLWFP(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOSCLIEDSD,w_SOSCLIEDSD) || CPLib.ne(o_SOSDATAOP,w_SOSDATAOP)) {
      l_bResult = ( ! (CPLib.Empty(w_SOSDATAOP)) &&  ! (CPLib.Empty(w_SOSCLIEDSD))?CPLib.le(w_SOSDATAOP,w_SOSCLIEDSD):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.";
      }
    }
    return l_bResult;
  }
  boolean Check_NXWIUCGNDI(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOSCLIEDRD,w_SOSCLIEDRD) || CPLib.ne(o_SOSDATAOP,w_SOSDATAOP)) {
      l_bResult = ( ! (CPLib.Empty(w_SOSDATAOP)) &&  ! (CPLib.Empty(w_SOSCLIEDRD))?CPLib.ge(w_SOSDATAOP,w_SOSCLIEDRD):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.";
      }
    }
    return l_bResult;
  }
  boolean Check_OHCORUHEID(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOSDESOPE,w_SOSDESOPE)) {
      l_bResult = CPLib.le(CPLib.Len(CPLib.LRTrim(w_SOSDESOPE)),350);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "(Descrizione Operazione) E' stato superato il limite massimo di 350 caratteri";
      }
    }
    return l_bResult;
  }
  boolean Check_GORGNKWJSO(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SOSMOTSOS,w_SOSMOTSOS)) {
      l_bResult = CPLib.le(CPLib.Len(CPLib.LRTrim(w_SOSMOTSOS)),350);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "(Motivo del sospetto) E' stato superato il limite massimo di 350 caratteri";
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
  public final static String[] m_KeyColumns = {"SOSCODICE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_sos","cgo_sos",m_KeyColumns,m_Ctx);
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
    w_SOSCODICE = 0;
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_SOSCODDIP = "";
    w_SOSSEGNANT = "";
    w_SOSSEGNAFAX = "";
    w_SOSSEGNAEM = "";
    w_SOSSEGNACF = "";
    w_SOSSEGNACOG = "";
    w_SOSSEGNANOM = "";
    w_SOSSEGNALN = "";
    w_SOSSEGNADN = CPLib.NullDate();
    w_SOSSEGNASX = "";
    w_SOSSTATOOP = "";
    w_IDBIGLIETTO = "";
    w_SOSDATAOP = CPLib.NullDate();
    w_SOSTIPOOP = "";
    w_SOSIMPOPE = 0;
    w_SOSMEZPAG = "";
    w_SOSNUMBON = "";
    w_SOSBANASS = "";
    w_SOSNUMASS = "";
    w_SOSDESOPE = "";
    w_SOSMOTSOS = "";
    w_SOSCLIECOG = "";
    w_SOSCLIENOM = "";
    w_SOSCLIELN = "";
    w_SOSCLIEDN = CPLib.NullDate();
    w_SOSCLIESX = "";
    w_SOSCLIECF = "";
    w_SOSCLIEPAE = "";
    w_SOSCLIECR = "";
    w_SOSCLIEIND = "";
    w_SOSCLIECAR = "";
    w_SOSCLIETD = "";
    w_SOSCLIEND = "";
    w_SOSCLIEDRD = CPLib.NullDate();
    w_SOSCLIEDSD = CPLib.NullDate();
    w_SOSCLIEAUD = "";
    w_SOSSEGNAPN = "";
    w_SOSCLIEPN = "";
    w_SOSCLIEPR = "";
    w_xdesdip = "";
    w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
    w_SOSUTENTE = 0;
    w_SOSDATSEG = CPLib.NullDate();
    w_xDESSTATO = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_SOSCODICE = CPLib.GetProperty(p,"SOSCODICE",w_SOSCODICE,0);
      op_SOSCODICE = CPLib.GetProperty(p,"op_SOSCODICE",0,0);
      w_SOSCODDIP = CPLib.GetProperty(p,"SOSCODDIP",w_SOSCODDIP,0);
      w_SOSSEGNANT = CPLib.GetProperty(p,"SOSSEGNANT",w_SOSSEGNANT,0);
      w_SOSSEGNAFAX = CPLib.GetProperty(p,"SOSSEGNAFAX",w_SOSSEGNAFAX,0);
      w_SOSSEGNAEM = CPLib.GetProperty(p,"SOSSEGNAEM",w_SOSSEGNAEM,0);
      w_SOSSEGNACF = CPLib.GetProperty(p,"SOSSEGNACF",w_SOSSEGNACF,0);
      w_SOSSEGNACOG = CPLib.GetProperty(p,"SOSSEGNACOG",w_SOSSEGNACOG,0);
      w_SOSSEGNANOM = CPLib.GetProperty(p,"SOSSEGNANOM",w_SOSSEGNANOM,0);
      w_SOSSEGNALN = CPLib.GetProperty(p,"SOSSEGNALN",w_SOSSEGNALN,0);
      w_SOSSEGNADN = CPLib.GetProperty(p,"SOSSEGNADN",w_SOSSEGNADN,0);
      w_SOSSEGNASX = CPLib.GetProperty(p,"SOSSEGNASX",w_SOSSEGNASX,0);
      w_SOSSTATOOP = CPLib.GetProperty(p,"SOSSTATOOP",w_SOSSTATOOP,0);
      w_SOSDATAOP = CPLib.GetProperty(p,"SOSDATAOP",w_SOSDATAOP,0);
      w_SOSTIPOOP = CPLib.GetProperty(p,"SOSTIPOOP",w_SOSTIPOOP,0);
      w_SOSIMPOPE = CPLib.GetProperty(p,"SOSIMPOPE",w_SOSIMPOPE,0);
      w_SOSMEZPAG = CPLib.GetProperty(p,"SOSMEZPAG",w_SOSMEZPAG,0);
      w_SOSNUMBON = CPLib.GetProperty(p,"SOSNUMBON",w_SOSNUMBON,0);
      w_SOSBANASS = CPLib.GetProperty(p,"SOSBANASS",w_SOSBANASS,0);
      w_SOSNUMASS = CPLib.GetProperty(p,"SOSNUMASS",w_SOSNUMASS,0);
      w_SOSDESOPE = CPLib.GetProperty(p,"SOSDESOPE",w_SOSDESOPE,0);
      w_SOSMOTSOS = CPLib.GetProperty(p,"SOSMOTSOS",w_SOSMOTSOS,0);
      w_SOSCLIECOG = CPLib.GetProperty(p,"SOSCLIECOG",w_SOSCLIECOG,0);
      w_SOSCLIENOM = CPLib.GetProperty(p,"SOSCLIENOM",w_SOSCLIENOM,0);
      w_SOSCLIELN = CPLib.GetProperty(p,"SOSCLIELN",w_SOSCLIELN,0);
      w_SOSCLIEDN = CPLib.GetProperty(p,"SOSCLIEDN",w_SOSCLIEDN,0);
      w_SOSCLIESX = CPLib.GetProperty(p,"SOSCLIESX",w_SOSCLIESX,0);
      w_SOSCLIECF = CPLib.GetProperty(p,"SOSCLIECF",w_SOSCLIECF,0);
      w_SOSCLIEPAE = CPLib.GetProperty(p,"SOSCLIEPAE",w_SOSCLIEPAE,0);
      w_SOSCLIECR = CPLib.GetProperty(p,"SOSCLIECR",w_SOSCLIECR,0);
      w_SOSCLIEIND = CPLib.GetProperty(p,"SOSCLIEIND",w_SOSCLIEIND,0);
      w_SOSCLIECAR = CPLib.GetProperty(p,"SOSCLIECAR",w_SOSCLIECAR,0);
      w_SOSCLIETD = CPLib.GetProperty(p,"SOSCLIETD",w_SOSCLIETD,0);
      w_SOSCLIEND = CPLib.GetProperty(p,"SOSCLIEND",w_SOSCLIEND,0);
      w_SOSCLIEDRD = CPLib.GetProperty(p,"SOSCLIEDRD",w_SOSCLIEDRD,0);
      w_SOSCLIEDSD = CPLib.GetProperty(p,"SOSCLIEDSD",w_SOSCLIEDSD,0);
      w_SOSCLIEAUD = CPLib.GetProperty(p,"SOSCLIEAUD",w_SOSCLIEAUD,0);
      w_SOSSEGNAPN = CPLib.GetProperty(p,"SOSSEGNAPN",w_SOSSEGNAPN,0);
      w_SOSCLIEPN = CPLib.GetProperty(p,"SOSCLIEPN",w_SOSCLIEPN,0);
      w_SOSCLIEPR = CPLib.GetProperty(p,"SOSCLIEPR",w_SOSCLIEPR,0);
      w_SOSUTENTE = CPLib.GetProperty(p,"SOSUTENTE",w_SOSUTENTE,0);
      w_SOSDATSEG = CPLib.GetProperty(p,"SOSDATSEG",w_SOSDATSEG,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_IDBIGLIETTO = CPLib.GetProperty(p,"IDBIGLIETTO",w_IDBIGLIETTO,0);
      w_xdesdip = CPLib.GetProperty(p,"xdesdip",w_xdesdip,0);
      w_gUserCode = CPLib.GetProperty(p,"gUserCode",w_gUserCode,0);
      w_xDESSTATO = CPLib.GetProperty(p,"xDESSTATO",w_xDESSTATO,0);
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
    items = tables.get("cgo_operazioni_storico");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_operazioni_storico",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CAIDBIGLIETTO"});
    map.put("rd_var",new String[]{"w_IDBIGLIETTO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("28",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ID Biglietto",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_operazioni_storico\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Storico Registrazioni\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_SOSCODDIP","w_xdesdip"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Agenzia di Riferimento\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key2\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00001\u00000\u0000armt_anadip\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
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
    map.put("rd_var",new String[]{"w_SOSSEGNALN","w_SOSSEGNAPN"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Luogo Nascita\u0000Provincia di Nascita",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbluonas\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Luoghi Nascita\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
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
    map.put("rd_var",new String[]{"w_SOSCLIELN","w_SOSCLIEPN"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Luogo di nascita Cliente\u0000Provicnia di Nascita Cliente",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbluonas\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Luogo Nascita\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_SOSCLIEPAE","w_xDESSTATO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Paese di Residenza Cliente\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Nazioni\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_SOSCLIECR","w_SOSCLIEPR"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Comune\u0000Provincia Residenza Cliente",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_cgo_sos",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_sos",child);
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
    m_MNTs = CPLib.MNTChilds("armt_cgo_sos",m_Ctx);
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
    if (CPLib.Empty(w_SOSSEGNANT)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNANT));
      String obblMsgError = m_Ctx.Translate("N° Telefono")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNANT = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNANT";
      }
    } else if (CPLib.Empty(w_SOSSEGNAFAX)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNAFAX));
      String obblMsgError = m_Ctx.Translate("N° Fax")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNAFAX = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNAFAX";
      }
    } else if (CPLib.Empty(w_SOSSEGNAEM)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNAEM));
      String obblMsgError = m_Ctx.Translate("EMail")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNAEM = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNAEM";
      }
    } else if (CPLib.Empty(w_SOSSEGNACF)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNACF));
      String obblMsgError = m_Ctx.Translate("Codice Fiscale Segnalante")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNACF = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNACF";
      }
    } else if (CPLib.Empty(w_SOSSEGNACOG)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNACOG));
      String obblMsgError = m_Ctx.Translate("Cognome")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNACOG = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNACOG";
      }
    } else if (CPLib.Empty(w_SOSSEGNANOM)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNANOM));
      String obblMsgError = m_Ctx.Translate("Nome")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNANOM = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNANOM";
      }
    } else if (CPLib.Empty(w_SOSSEGNALN)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNALN));
      String obblMsgError = m_Ctx.Translate("Luogo Nascita")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNALN = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNALN";
      }
    } else if (CPLib.Empty(w_SOSSEGNADN)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNADN));
      String obblMsgError = m_Ctx.Translate("Data di Nascita")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNADN = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNADN";
      }
    } else if (CPLib.Empty(w_SOSSEGNASX)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOSSEGNASX));
      String obblMsgError = m_Ctx.Translate("Sesso")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOSSEGNASX = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSSEGNASX";
      }
    } else if (( ! (CPLib.Empty(w_SOSCLIETD))) && ( ! (arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_SOSCLIEDRD,w_SOSCLIETD,"R",w_SOSDATAOP)))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = m_Ctx.Translate("Data Rilascio")+" : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_SOSCLIEDRD = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSCLIEDRD";
      }
    } else if (( ! (CPLib.Empty(w_SOSCLIETD))) && ( ! (arfn_cgo_chkdataR.Make(m_Ctx,this).Run(w_SOSCLIEDSD,w_SOSCLIETD,"S",w_SOSDATAOP)))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = m_Ctx.Translate("Data Scadenza")+" : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_SOSCLIEDSD = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOSCLIEDSD";
      }
    } else if ( ! (Check_QNEKQYKSHZ(true))) {
      l_bResult = false;
    } else if ( ! (Check_YHNSLBLWFP(true))) {
      l_bResult = false;
    } else if ( ! (Check_NXWIUCGNDI(true))) {
      l_bResult = false;
    } else if ( ! (Check_OHCORUHEID(true))) {
      l_bResult = false;
    } else if ( ! (Check_GORGNKWJSO(true))) {
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
      l_Keys = new String[]{"armt_cgo_sos"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_sos\\"+p_cState};
    }
    return l_Keys;
  }
  public boolean CanView() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = CPLib.eq(w_gCodDip,w_SOSCODDIP) || Utilities.Make(m_Ctx).IsInGroup(1) || Utilities.Make(m_Ctx).IsInGroup(9) || Utilities.Make(m_Ctx).IsInGroup(11) || Utilities.Make(m_Ctx).IsInGroup(12);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile visualizzare la segnalazione selezionata";
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
    l_bResult = CPLib.ne(p_cState,GetCurrentState()) || (false);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile modificare una segnalazione";
    }
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = false;
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile eliminare una segnalazione";
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
    w_SOSCODICE = m_Ctx.AskTableProg(w_SOSCODICE,10,op_SOSCODICE,"PRGSEGSOS"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_cgo_sos);
    op_codazi = m_Ctx.GetCompany();
    op_SOSCODICE = w_SOSCODICE;
    o_SOSCODICE = w_SOSCODICE;
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
      w_SOSCODICE = m_Ctx.AskTableProg(w_SOSCODICE,10,op_SOSCODICE,"PRGSEGSOS"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_cgo_sos);
      op_codazi = m_Ctx.GetCompany();
      op_SOSCODICE = w_SOSCODICE;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_SOSCODICE = 0;
    // Inizializzazione delle variabili per DependsOn
    o_SOSCODICE = 0;
    o_IDBIGLIETTO = "";
    o_SOSDATAOP = CPLib.NullDate();
    o_SOSDESOPE = "";
    o_SOSMOTSOS = "";
    o_SOSCLIEDRD = CPLib.NullDate();
    o_SOSCLIEDSD = CPLib.NullDate();
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
    CPLib.PutProperty(p,"SOSCODICE",w_SOSCODICE,0);
    CPLib.PutProperty(p,"op_SOSCODICE",op_SOSCODICE,0);
    CPLib.PutProperty(p,"SOSCODDIP",w_SOSCODDIP,0);
    CPLib.PutProperty(p,"SOSSEGNANT",w_SOSSEGNANT,0);
    CPLib.PutProperty(p,"SOSSEGNAFAX",w_SOSSEGNAFAX,0);
    CPLib.PutProperty(p,"SOSSEGNAEM",w_SOSSEGNAEM,0);
    CPLib.PutProperty(p,"SOSSEGNACF",w_SOSSEGNACF,0);
    CPLib.PutProperty(p,"SOSSEGNACOG",w_SOSSEGNACOG,0);
    CPLib.PutProperty(p,"SOSSEGNANOM",w_SOSSEGNANOM,0);
    CPLib.PutProperty(p,"SOSSEGNALN",w_SOSSEGNALN,0);
    CPLib.PutProperty(p,"SOSSEGNADN",w_SOSSEGNADN,0);
    CPLib.PutProperty(p,"SOSSEGNASX",w_SOSSEGNASX,0);
    CPLib.PutProperty(p,"SOSSTATOOP",w_SOSSTATOOP,0);
    CPLib.PutProperty(p,"SOSDATAOP",w_SOSDATAOP,0);
    CPLib.PutProperty(p,"SOSTIPOOP",w_SOSTIPOOP,0);
    CPLib.PutProperty(p,"SOSIMPOPE",w_SOSIMPOPE,0);
    CPLib.PutProperty(p,"SOSMEZPAG",w_SOSMEZPAG,0);
    CPLib.PutProperty(p,"SOSNUMBON",w_SOSNUMBON,0);
    CPLib.PutProperty(p,"SOSBANASS",w_SOSBANASS,0);
    CPLib.PutProperty(p,"SOSNUMASS",w_SOSNUMASS,0);
    CPLib.PutProperty(p,"SOSDESOPE",w_SOSDESOPE,0);
    CPLib.PutProperty(p,"SOSMOTSOS",w_SOSMOTSOS,0);
    CPLib.PutProperty(p,"SOSCLIECOG",w_SOSCLIECOG,0);
    CPLib.PutProperty(p,"SOSCLIENOM",w_SOSCLIENOM,0);
    CPLib.PutProperty(p,"SOSCLIELN",w_SOSCLIELN,0);
    CPLib.PutProperty(p,"SOSCLIEDN",w_SOSCLIEDN,0);
    CPLib.PutProperty(p,"SOSCLIESX",w_SOSCLIESX,0);
    CPLib.PutProperty(p,"SOSCLIECF",w_SOSCLIECF,0);
    CPLib.PutProperty(p,"SOSCLIEPAE",w_SOSCLIEPAE,0);
    CPLib.PutProperty(p,"SOSCLIECR",w_SOSCLIECR,0);
    CPLib.PutProperty(p,"SOSCLIEIND",w_SOSCLIEIND,0);
    CPLib.PutProperty(p,"SOSCLIECAR",w_SOSCLIECAR,0);
    CPLib.PutProperty(p,"SOSCLIETD",w_SOSCLIETD,0);
    CPLib.PutProperty(p,"SOSCLIEND",w_SOSCLIEND,0);
    CPLib.PutProperty(p,"SOSCLIEDRD",w_SOSCLIEDRD,0);
    CPLib.PutProperty(p,"SOSCLIEDSD",w_SOSCLIEDSD,0);
    CPLib.PutProperty(p,"SOSCLIEAUD",w_SOSCLIEAUD,0);
    CPLib.PutProperty(p,"SOSSEGNAPN",w_SOSSEGNAPN,0);
    CPLib.PutProperty(p,"SOSCLIEPN",w_SOSCLIEPN,0);
    CPLib.PutProperty(p,"SOSCLIEPR",w_SOSCLIEPR,0);
    CPLib.PutProperty(p,"SOSUTENTE",w_SOSUTENTE,0);
    CPLib.PutProperty(p,"SOSDATSEG",w_SOSDATSEG,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"IDBIGLIETTO",w_IDBIGLIETTO,0);
    CPLib.PutProperty(p,"xdesdip",w_xdesdip,0);
    CPLib.PutProperty(p,"gUserCode",w_gUserCode,0);
    CPLib.PutProperty(p,"xDESSTATO",w_xDESSTATO,0);
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
    return "cgo_sos"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("SOSCODICE","N",10,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_SOSCODICE");
    oneAutoNum.add("PRGSEGSOS");
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
