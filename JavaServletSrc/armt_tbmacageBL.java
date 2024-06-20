import java.util.*;

public class armt_tbmacageBL extends armt_tbmacageWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_tbmacage";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_tbmacage;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"tbmacage"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'MACODICE':MACODICE,'MADESCRI':MADESCRI,'MAFLGRAP':MAFLGRAP,'MAFLGOPE':MAFLGOPE,'MAFLGBON':MAFLGBON,'MAFLGCKR':MAFLGCKR,'MAFLGASR':MAFLGASR,'MAFLGNOX':MAFLGNOX,'MADIPSTD':MADIPSTD,'MANAIDWU':MANAIDWU,'MAFLGCHKDAT':MAFLGCHKDAT,'MAFLGACT':MAFLGACT,'MARESSDEF':MARESSDEF,'MAFLGAUA':MAFLGAUA,'MATIPAGE':MATIPAGE,'MAFISGIU':MAFISGIU,'MADATINI':MADATINI,'MADATFIN':MADATFIN,'MADATMOD':MADATMOD,'MACODFIS':MACODFIS,'MACOGNOME':MACOGNOME,'MANOME':MANOME,'MARESPAESE':MARESPAESE,'MARESCITTA':MARESCITTA,'MARESCAP':MARESCAP,'MARESPRV':MARESPRV,'MARESIND':MARESIND,'MARESNCIV':MARESNCIV,'MADOMPAESE':MADOMPAESE,'MADOMCITTA':MADOMCITTA,'MADOMCAP':MADOMCAP,'MADOMPRV':MADOMPRV,'MADOMIND':MADOMIND,'MADOMNCIV':MADOMNCIV,'ardt_ageresleg':ardt_ageresleg,'MAFLGCOMPL':MAFLGCOMPL"+FoundlingChildrenList("armt_tbmacage",true)+"}";
  public static final String i_CompleteStateStructure = "{'gFlgWU':gFlgWU,'MACODICE':MACODICE,'MADESCRI':MADESCRI,'MAFLGRAP':MAFLGRAP,'MAFLGOPE':MAFLGOPE,'MAFLGBON':MAFLGBON,'MAFLGCKR':MAFLGCKR,'MAFLGASR':MAFLGASR,'MAFLGNOX':MAFLGNOX,'MADIPSTD':MADIPSTD,'xDESDIP':xDESDIP,'MANAIDWU':MANAIDWU,'MAFLGCHKDAT':MAFLGCHKDAT,'MAFLGACT':MAFLGACT,'MARESSDEF':MARESSDEF,'despaese':despaese,'MAFLGAUA':MAFLGAUA,'MATIPAGE':MATIPAGE,'MAFISGIU':MAFISGIU,'MADATINI':MADATINI,'MADATFIN':MADATFIN,'MADATMOD':MADATMOD,'MACODFIS':MACODFIS,'MACOGNOME':MACOGNOME,'MANOME':MANOME,'MARESPAESE':MARESPAESE,'MARESCITTA':MARESCITTA,'MARESCAP':MARESCAP,'MARESPRV':MARESPRV,'xDESSTARES':xDESSTARES,'MARESIND':MARESIND,'MARESNCIV':MARESNCIV,'MADOMPAESE':MADOMPAESE,'MADOMCITTA':MADOMCITTA,'MADOMCAP':MADOMCAP,'MADOMPRV':MADOMPRV,'MADOMIND':MADOMIND,'MADOMNCIV':MADOMNCIV,'xDESSTADOM':xDESSTADOM,'ardt_ageresleg':ardt_ageresleg,'MAFLGCOMPL':MAFLGCOMPL"+FoundlingChildrenList("armt_tbmacage",true)+"}";
  public static final String i_ItemSequence = "MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON,MAFLGCKR,MAFLGASR,MAFLGNOX,MADIPSTD,MANAIDWU,MAFLGCHKDAT,MAFLGACT,MARESSDEF,MAFLGAUA,MATIPAGE,MAFISGIU,MADATINI,MADATFIN,MADATMOD,MACODFIS,MACOGNOME,MANOME,MARESPAESE,MARESCITTA,MARESCAP,MARESPRV,MARESIND,MARESNCIV,MADOMPAESE,MADOMCITTA,MADOMCAP,MADOMPRV,MADOMIND,MADOMNCIV,ardt_ageresleg,MAFLGCOMPL"+FoundlingChildrenList("armt_tbmacage",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_tbmacage"),new String[][]{new String[]{"MACODICE","Codice","C","5","0","campo","key1","false","false"},new String[]{"MADESCRI","Denominazione","C","120","0","campo","key2","false","false"},new String[]{"MAFLGRAP","Generazione Rapporti da operazioni","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGOPE","Scrivi su Operazioni o Frazionate","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGBON","Scrive tipo operazione come bonifico","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGCKR","Controllo esistenza Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGASR","Associa Operazione a Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGNOX","Non creare Operazioni Extraconto","C","1","0","campo","nokey","false","false"},new String[]{"MADIPSTD","Dipendenza Standard","C","6","0","campo","nokey","false","false"},new String[]{"MANAIDWU","NAID","C","5","0","campo","key3","false","false"},new String[]{"MAFLGCHKDAT","Dati certi per Soggetti","C","1","0","campo","nokey","false","false"},new String[]{"MAFLGACT","Macrosgente operativo","C","1","0","campo","nokey","false","false"},new String[]{"MARESSDEF","Paese Res. Default","C","3","0","campo","nokey","false","false"},new String[]{"MAFLGAUA","Escludi Controlli AUA","C","1","0","campo","nokey","false","false"},new String[]{"MATIPAGE","Tipo Agente","C","1","0","campo","nokey","false","false"},new String[]{"MAFISGIU","Specie Giuridica","C","1","0","campo","nokey","false","false"},new String[]{"MADATINI","Data Inizio Rapporto","D","8","0","campo","nokey","false","false"},new String[]{"MADATFIN","Fine Rapporto","D","8","0","campo","nokey","false","true"},new String[]{"MADATMOD","Data Ultimo Aggiornamento","D","8","0","campo","nokey","false","false"},new String[]{"MACODFIS","Codice Fiscale/P.IVA","C","16","0","campo","nokey","false","false"},new String[]{"MACOGNOME","Cognome","C","50","0","campo","nokey","false","false"},new String[]{"MANOME","Nome","C","50","0","campo","nokey","false","false"},new String[]{"MARESPAESE","Paese Residenza","C","3","0","campo","nokey","false","false"},new String[]{"MARESCITTA","Città","C","60","0","campo","nokey","false","false"},new String[]{"MARESCAP","CAP","C","15","0","campo","nokey","false","false"},new String[]{"MARESPRV","Provincia","C","2","0","campo","nokey","false","false"},new String[]{"MARESIND","Indirizzo","C","50","0","campo","nokey","false","false"},new String[]{"MARESNCIV","N. Civico","C","15","0","campo","nokey","false","false"},new String[]{"MADOMPAESE","Paese Residenza","C","3","0","campo","nokey","false","false"},new String[]{"MADOMCITTA","Città","C","60","0","campo","nokey","false","false"},new String[]{"MADOMCAP","CAP","C","15","0","campo","nokey","false","false"},new String[]{"MADOMPRV","Provincia","C","2","0","campo","nokey","false","false"},new String[]{"MADOMIND","Indirizzo","C","50","0","campo","nokey","false","false"},new String[]{"MADOMNCIV","N. Civico","C","15","0","campo","nokey","false","false"},new String[]{"ardt_ageresleg","LinkPC","","","","link_PC","","false",""},new String[]{"MAFLGCOMPL","Chiusura per compliance","N","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_tbmacageBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage",p_ContextObject.GetCompany(),false);
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cVirtName_tbmacage = CPSql.ManipulateTablePhName("tbmacage",m_cServer_tbmacage);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_ageresleg = new ardt_agereslegBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_tbmacage",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_MACODICE = "";
    w_MADESCRI = "";
    w_MAFLGOPE = "";
    w_MADIPSTD = "";
    w_xDESDIP = "";
    w_MANAIDWU = "";
    w_MARESSDEF = "";
    w_despaese = "";
    w_MADATINI = CPLib.NullDate();
    w_MADATFIN = CPLib.NullDate();
    w_MADATMOD = CPLib.NullDate();
    w_MACODFIS = "";
    w_MACOGNOME = "";
    w_MANOME = "";
    w_MARESPAESE = "";
    w_MARESCITTA = "";
    w_MARESCAP = "";
    w_MARESPRV = "";
    w_xDESSTARES = "";
    w_MARESIND = "";
    w_MARESNCIV = "";
    w_MADOMPAESE = "";
    w_MADOMCITTA = "";
    w_MADOMCAP = "";
    w_MADOMPRV = "";
    w_MADOMIND = "";
    w_MADOMNCIV = "";
    w_xDESSTADOM = "";
    w_MARESPAESE = "";
    w_MARESCITTA = "";
    w_MARESIND = "";
    w_MARESNCIV = "";
    w_MARESCAP = "";
    w_MARESPRV = "";
    w_MAFLGRAP = "N";
    w_MAFLGBON = "N";
    w_MAFLGCKR = "N";
    w_MAFLGASR = "N";
    w_MAFLGNOX = "N";
    Link_LRWPVABXRO();
    w_MAFLGCHKDAT = "N";
    w_MAFLGACT = "S";
    Link_XDJMLPLVUM();
    w_MAFLGAUA = "N";
    w_MATIPAGE = "A";
    w_MAFISGIU = "G";
    Link_BFMOWHWVBP();
    Link_ODQOMCYUIH();
    Link_DJVPNMOUXM();
    Link_UUHMAJHIGT();
    Link_HSKILYGZSO();
    Link_NHXACJTYPN();
    w_MAFLGCOMPL = 0;
    m_cWv_ardt_ageresleg = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_ageresleg.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ageresleg);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    ardt_ageresleg.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_LRWPVABXRO() {
    return Link_LRWPVABXRO("Full");
  }
  protected boolean Link_LRWPVABXRO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MADIPSTD))) {
      String l_OldValue = w_MADIPSTD;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MADIPSTD,"C",6,0),m_cServer_anadip,w_MADIPSTD);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MADIPSTD,"C",30,0),m_cServer_anadip,w_MADIPSTD);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MADIPSTD = l_rsLink.GetString("CODDIP");
          w_xDESDIP = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LRWPVABXRO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MADIPSTD = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MADIPSTD");
          }
          m_cLastWorkVarError = "MADIPSTD";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LRWPVABXRO_blank();
    }
    return l_bResult;
  }
  void Link_LRWPVABXRO_blank() {
    w_MADIPSTD = "";
    w_xDESDIP = "";
  }
  protected boolean Link_XDJMLPLVUM() {
    return Link_XDJMLPLVUM("Full");
  }
  protected boolean Link_XDJMLPLVUM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MARESSDEF))) {
      String l_OldValue = w_MARESSDEF;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESSDEF,"C",3,0),m_cServer_tbstati,w_MARESSDEF);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESSDEF,"C",40,0),m_cServer_tbstati,w_MARESSDEF);
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
          w_MARESSDEF = l_rsLink.GetString("CODSTA");
          w_despaese = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_XDJMLPLVUM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MARESSDEF = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MARESSDEF");
          }
          m_cLastWorkVarError = "MARESSDEF";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XDJMLPLVUM_blank();
    }
    return l_bResult;
  }
  void Link_XDJMLPLVUM_blank() {
    w_MARESSDEF = "";
    w_despaese = "";
  }
  protected boolean Link_BFMOWHWVBP() {
    return Link_BFMOWHWVBP("Full");
  }
  protected boolean Link_BFMOWHWVBP(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MARESPAESE))) {
      String l_OldValue = w_MARESPAESE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESPAESE,"C",3,0),m_cServer_tbstati,w_MARESPAESE);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESPAESE,"C",40,0),m_cServer_tbstati,w_MARESPAESE);
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
          w_MARESPAESE = l_rsLink.GetString("CODSTA");
          w_xDESSTARES = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_BFMOWHWVBP_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MARESPAESE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MARESPAESE");
          }
          m_cLastWorkVarError = "MARESPAESE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_BFMOWHWVBP_blank();
    }
    return l_bResult;
  }
  void Link_BFMOWHWVBP_blank() {
    w_MARESPAESE = "";
    w_xDESSTARES = "";
  }
  protected boolean Link_ODQOMCYUIH() {
    return Link_ODQOMCYUIH("Full");
  }
  protected boolean Link_ODQOMCYUIH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MARESCITTA))) {
      String l_OldValue = w_MARESCITTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESCITTA,"C",60,0),m_cServer_tbcitta,w_MARESCITTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAP,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MARESCITTA = l_rsLink.GetString("CITTA");
          w_MARESCAP = l_rsLink.GetString("CAP");
          w_MARESPRV = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_ODQOMCYUIH_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MARESCITTA");
          }
          m_cLastWorkVarError = "MARESCITTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ODQOMCYUIH_blank();
    }
    return l_bResult;
  }
  void Link_ODQOMCYUIH_blank() {
    Link_ODQOMCYUIH_blank("");
  }
  void Link_ODQOMCYUIH_blank(String p_cType) {
    w_MARESCAP = "";
    w_MARESPRV = "";
  }
  protected boolean Link_DJVPNMOUXM() {
    return Link_DJVPNMOUXM("Full");
  }
  protected boolean Link_DJVPNMOUXM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MADOMPAESE))) {
      String l_OldValue = w_MADOMPAESE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MADOMPAESE,"C",3,0),m_cServer_tbstati,w_MADOMPAESE);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MADOMPAESE,"C",40,0),m_cServer_tbstati,w_MADOMPAESE);
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
          w_MADOMPAESE = l_rsLink.GetString("CODSTA");
          w_xDESSTADOM = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DJVPNMOUXM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MADOMPAESE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MADOMPAESE");
          }
          m_cLastWorkVarError = "MADOMPAESE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DJVPNMOUXM_blank();
    }
    return l_bResult;
  }
  void Link_DJVPNMOUXM_blank() {
    w_MADOMPAESE = "";
    w_xDESSTADOM = "";
  }
  protected boolean Link_UUHMAJHIGT() {
    return Link_UUHMAJHIGT("Full");
  }
  protected boolean Link_UUHMAJHIGT(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MADOMCITTA))) {
      String l_OldValue = w_MADOMCITTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MADOMCITTA,"C",60,0),m_cServer_tbcitta,w_MADOMCITTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAP,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MADOMCITTA = l_rsLink.GetString("CITTA");
          w_MADOMCAP = l_rsLink.GetString("CAP");
          w_MADOMPRV = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_UUHMAJHIGT_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MADOMCITTA");
          }
          m_cLastWorkVarError = "MADOMCITTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UUHMAJHIGT_blank();
    }
    return l_bResult;
  }
  void Link_UUHMAJHIGT_blank() {
    Link_UUHMAJHIGT_blank("");
  }
  void Link_UUHMAJHIGT_blank(String p_cType) {
    w_MADOMCAP = "";
    w_MADOMPRV = "";
  }
  protected boolean Link_HSKILYGZSO() {
    return Link_HSKILYGZSO("Full");
  }
  protected boolean Link_HSKILYGZSO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MARESPAESE))) {
      String l_OldValue = w_MARESPAESE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESPAESE,"C",3,0),m_cServer_tbstati,w_MARESPAESE);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESPAESE,"C",40,0),m_cServer_tbstati,w_MARESPAESE);
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
          w_MARESPAESE = l_rsLink.GetString("CODSTA");
          w_xDESSTARES = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HSKILYGZSO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MARESPAESE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MARESPAESE");
          }
          m_cLastWorkVarError = "MARESPAESE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HSKILYGZSO_blank();
    }
    return l_bResult;
  }
  void Link_HSKILYGZSO_blank() {
    w_MARESPAESE = "";
    w_xDESSTARES = "";
  }
  protected boolean Link_NHXACJTYPN() {
    return Link_NHXACJTYPN("Full");
  }
  protected boolean Link_NHXACJTYPN(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MARESCITTA))) {
      String l_OldValue = w_MARESCITTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MARESCITTA,"C",60,0),m_cServer_tbcitta,w_MARESCITTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAP,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MARESCITTA = l_rsLink.GetString("CITTA");
          w_MARESCAP = l_rsLink.GetString("CAP");
          w_MARESPRV = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_NHXACJTYPN_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MARESCITTA");
          }
          m_cLastWorkVarError = "MARESCITTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NHXACJTYPN_blank();
    }
    return l_bResult;
  }
  void Link_NHXACJTYPN_blank() {
    Link_NHXACJTYPN_blank("");
  }
  void Link_NHXACJTYPN_blank(String p_cType) {
    w_MARESCAP = "";
    w_MARESPRV = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_MACODICE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACODICE = p_workVariableValue;
    if ( ! (CPLib.Empty(w_MADIPSTD))) {
      l_bTmpRes = Link_LRWPVABXRO();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADESCRI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGRAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGBON(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGBON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGCKR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGCKR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGASR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGASR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGNOX(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGNOX = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADIPSTD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADIPSTD = p_workVariableValue;
    l_bResult = Link_LRWPVABXRO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MADIPSTD = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MANAIDWU(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MANAIDWU = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGCHKDAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGCHKDAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGACT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGACT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESSDEF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESSDEF = p_workVariableValue;
    l_bResult = Link_XDJMLPLVUM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MARESSDEF = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGAUA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGAUA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MATIPAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MATIPAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFISGIU(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFISGIU = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADATINI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADATINI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADATFIN(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADATFIN = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MADATFIN = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean UYKWSCJLEB_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_MAFLGCOMPL,1);
  }
  public boolean Set_MADATMOD(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADATMOD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MACODFIS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACODFIS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MACOGNOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACOGNOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MANOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MANOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESPAESE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESPAESE = p_workVariableValue;
    l_bResult = Link_BFMOWHWVBP();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MARESPAESE = "";
    }
    l_bResult = Link_HSKILYGZSO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MARESPAESE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESCITTA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESCITTA = p_workVariableValue;
    l_bResult = Link_ODQOMCYUIH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MARESCITTA = "";
    }
    l_bResult = Link_NHXACJTYPN();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MARESCITTA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESCAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESCAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESPRV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESPRV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESIND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MARESNCIV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MARESNCIV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMPAESE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMPAESE = p_workVariableValue;
    l_bResult = Link_DJVPNMOUXM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MADOMPAESE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMCITTA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMCITTA = p_workVariableValue;
    l_bResult = Link_UUHMAJHIGT();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MADOMCITTA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMCAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMCAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMPRV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMPRV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMIND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MADOMNCIV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MADOMNCIV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAFLGCOMPL(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAFLGCOMPL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_MARESPRV() {
    return CPLib.ne(w_MARESPAESE,"086");
  }
  public boolean getVisible_MADOMPRV() {
    return CPLib.ne(w_MADOMPAESE,"086");
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
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
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
  public final static String[] m_KeyColumns = {"MACODICE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_tbmacage","tbmacage",m_KeyColumns,m_Ctx);
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
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_MACODICE = "";
    w_MADESCRI = "";
    w_MAFLGRAP = "";
    w_MAFLGOPE = "";
    w_MAFLGBON = "";
    w_MAFLGCKR = "";
    w_MAFLGASR = "";
    w_MAFLGNOX = "";
    w_MADIPSTD = "";
    w_xDESDIP = "";
    w_MANAIDWU = "";
    w_MAFLGCHKDAT = "";
    w_MAFLGACT = "";
    w_MARESSDEF = "";
    w_despaese = "";
    w_MAFLGAUA = "";
    w_MATIPAGE = "";
    w_MAFISGIU = "";
    w_MADATINI = CPLib.NullDate();
    w_MADATFIN = CPLib.NullDate();
    w_MADATMOD = CPLib.NullDate();
    w_MACODFIS = "";
    w_MACOGNOME = "";
    w_MANOME = "";
    w_MARESPAESE = "";
    w_MARESCITTA = "";
    w_MARESCAP = "";
    w_MARESPRV = "";
    w_xDESSTARES = "";
    w_MARESIND = "";
    w_MARESNCIV = "";
    w_MADOMPAESE = "";
    w_MADOMCITTA = "";
    w_MADOMCAP = "";
    w_MADOMPRV = "";
    w_MADOMIND = "";
    w_MADOMNCIV = "";
    w_xDESSTADOM = "";
    w_MARESPAESE = "";
    w_MARESCITTA = "";
    w_MARESIND = "";
    w_MARESNCIV = "";
    w_MARESCAP = "";
    w_MARESPRV = "";
    w_MAFLGCOMPL = 0;
    m_cWv_ardt_ageresleg = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_MACODICE = CPLib.GetProperty(p,"MACODICE",w_MACODICE,0);
      w_MADESCRI = CPLib.GetProperty(p,"MADESCRI",w_MADESCRI,0);
      w_MAFLGRAP = CPLib.GetProperty(p,"MAFLGRAP",w_MAFLGRAP,0);
      w_MAFLGOPE = CPLib.GetProperty(p,"MAFLGOPE",w_MAFLGOPE,0);
      w_MAFLGBON = CPLib.GetProperty(p,"MAFLGBON",w_MAFLGBON,0);
      w_MAFLGCKR = CPLib.GetProperty(p,"MAFLGCKR",w_MAFLGCKR,0);
      w_MAFLGASR = CPLib.GetProperty(p,"MAFLGASR",w_MAFLGASR,0);
      w_MAFLGNOX = CPLib.GetProperty(p,"MAFLGNOX",w_MAFLGNOX,0);
      w_MADIPSTD = CPLib.GetProperty(p,"MADIPSTD",w_MADIPSTD,0);
      w_MANAIDWU = CPLib.GetProperty(p,"MANAIDWU",w_MANAIDWU,0);
      w_MAFLGCHKDAT = CPLib.GetProperty(p,"MAFLGCHKDAT",w_MAFLGCHKDAT,0);
      w_MAFLGACT = CPLib.GetProperty(p,"MAFLGACT",w_MAFLGACT,0);
      w_MARESSDEF = CPLib.GetProperty(p,"MARESSDEF",w_MARESSDEF,0);
      w_MAFLGAUA = CPLib.GetProperty(p,"MAFLGAUA",w_MAFLGAUA,0);
      w_MATIPAGE = CPLib.GetProperty(p,"MATIPAGE",w_MATIPAGE,0);
      w_MAFISGIU = CPLib.GetProperty(p,"MAFISGIU",w_MAFISGIU,0);
      w_MADATINI = CPLib.GetProperty(p,"MADATINI",w_MADATINI,0);
      w_MADATFIN = CPLib.GetProperty(p,"MADATFIN",w_MADATFIN,0);
      w_MADATMOD = CPLib.GetProperty(p,"MADATMOD",w_MADATMOD,0);
      w_MACODFIS = CPLib.GetProperty(p,"MACODFIS",w_MACODFIS,0);
      w_MACOGNOME = CPLib.GetProperty(p,"MACOGNOME",w_MACOGNOME,0);
      w_MANOME = CPLib.GetProperty(p,"MANOME",w_MANOME,0);
      w_MARESPAESE = CPLib.GetProperty(p,"MARESPAESE",w_MARESPAESE,0);
      w_MARESCITTA = CPLib.GetProperty(p,"MARESCITTA",w_MARESCITTA,0);
      w_MARESCAP = CPLib.GetProperty(p,"MARESCAP",w_MARESCAP,0);
      w_MARESPRV = CPLib.GetProperty(p,"MARESPRV",w_MARESPRV,0);
      w_MARESIND = CPLib.GetProperty(p,"MARESIND",w_MARESIND,0);
      w_MARESNCIV = CPLib.GetProperty(p,"MARESNCIV",w_MARESNCIV,0);
      w_MADOMPAESE = CPLib.GetProperty(p,"MADOMPAESE",w_MADOMPAESE,0);
      w_MADOMCITTA = CPLib.GetProperty(p,"MADOMCITTA",w_MADOMCITTA,0);
      w_MADOMCAP = CPLib.GetProperty(p,"MADOMCAP",w_MADOMCAP,0);
      w_MADOMPRV = CPLib.GetProperty(p,"MADOMPRV",w_MADOMPRV,0);
      w_MADOMIND = CPLib.GetProperty(p,"MADOMIND",w_MADOMIND,0);
      w_MADOMNCIV = CPLib.GetProperty(p,"MADOMNCIV",w_MADOMNCIV,0);
      w_MAFLGCOMPL = CPLib.GetProperty(p,"MAFLGCOMPL",w_MAFLGCOMPL,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_xDESDIP = CPLib.GetProperty(p,"xDESDIP",w_xDESDIP,0);
      w_despaese = CPLib.GetProperty(p,"despaese",w_despaese,0);
      w_xDESSTARES = CPLib.GetProperty(p,"xDESSTARES",w_xDESSTARES,0);
      w_xDESSTADOM = CPLib.GetProperty(p,"xDESSTADOM",w_xDESSTADOM,0);
      m_cWv_ardt_ageresleg = CPLib.GetProperty(p,"m_cWv_ardt_ageresleg",m_cWv_ardt_ageresleg,0);
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
    items = tables.get("ageresleg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("ageresleg",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODMAGE"});
    map.put("rd_var",new String[]{"w_MACODICE"});
    map.put("wr_var",new String[]{"w_MACODICE"});
    map.put("wr_field",new String[]{"CODMAGE"});
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
    map.put("property.value",zeroSplit.split("ageresleg\u0000false\u0000false\u00001\u00000\u0000ardt_ageresleg\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_MADIPSTD","w_xDESDIP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Dipendenza Standard\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Dipendenze / Agenzie\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_MARESSDEF","w_despaese"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Paese Res. Default\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_MARESPAESE","w_xDESSTARES"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Paese Residenza\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000armt_stati\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","CAP","PROV"});
    map.put("rd_var",new String[]{"w_MARESCITTA","w_MARESCAP","w_MARESPRV"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("60\u000015\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città\u0000CAP\u0000Provincia",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_MADOMPAESE","w_xDESSTADOM"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Paese Residenza\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000armt_stati\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","CAP","PROV"});
    map.put("rd_var",new String[]{"w_MADOMCITTA","w_MADOMCAP","w_MADOMPRV"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("60\u000015\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città\u0000CAP\u0000Provincia",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_tbmacage",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_tbmacage",child);
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
    ardt_ageresleg = new ardt_agereslegBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_tbmacage",m_Ctx);
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
    if (CPLib.Empty(w_MADATFIN) && UYKWSCJLEB_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_MADATFIN));
      String obblMsgError = m_Ctx.Translate("Fine Rapporto")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("Obbligatoria se chiusura per compliance");
      l_bResult = false;
      w_MADATFIN = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "MADATFIN";
      }
    }
    if (l_bResult && (( ! (ardt_ageresleg.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ageresleg)) || ( ! (ardt_ageresleg.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ageresleg)))) {
      ardt_ageresleg.SetFromContext(m_cWv_ardt_ageresleg);
      m_cWv_ardt_ageresleg = "_not_empty_";
    }
    if (l_bResult && (ardt_ageresleg.m_bLoaded || ardt_ageresleg.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ageresleg.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ageresleg.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_tbmacage"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_tbmacage\\"+p_cState};
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
    CPLib.PutProperty(p,"MACODICE",w_MACODICE,0);
    CPLib.PutProperty(p,"MADESCRI",w_MADESCRI,0);
    CPLib.PutProperty(p,"MAFLGRAP",w_MAFLGRAP,0);
    CPLib.PutProperty(p,"MAFLGOPE",w_MAFLGOPE,0);
    CPLib.PutProperty(p,"MAFLGBON",w_MAFLGBON,0);
    CPLib.PutProperty(p,"MAFLGCKR",w_MAFLGCKR,0);
    CPLib.PutProperty(p,"MAFLGASR",w_MAFLGASR,0);
    CPLib.PutProperty(p,"MAFLGNOX",w_MAFLGNOX,0);
    CPLib.PutProperty(p,"MADIPSTD",w_MADIPSTD,0);
    CPLib.PutProperty(p,"MANAIDWU",w_MANAIDWU,0);
    CPLib.PutProperty(p,"MAFLGCHKDAT",w_MAFLGCHKDAT,0);
    CPLib.PutProperty(p,"MAFLGACT",w_MAFLGACT,0);
    CPLib.PutProperty(p,"MARESSDEF",w_MARESSDEF,0);
    CPLib.PutProperty(p,"MAFLGAUA",w_MAFLGAUA,0);
    CPLib.PutProperty(p,"MATIPAGE",w_MATIPAGE,0);
    CPLib.PutProperty(p,"MAFISGIU",w_MAFISGIU,0);
    CPLib.PutProperty(p,"MADATINI",w_MADATINI,0);
    CPLib.PutProperty(p,"MADATFIN",w_MADATFIN,0);
    CPLib.PutProperty(p,"MADATMOD",w_MADATMOD,0);
    CPLib.PutProperty(p,"MACODFIS",w_MACODFIS,0);
    CPLib.PutProperty(p,"MACOGNOME",w_MACOGNOME,0);
    CPLib.PutProperty(p,"MANOME",w_MANOME,0);
    CPLib.PutProperty(p,"MARESPAESE",w_MARESPAESE,0);
    CPLib.PutProperty(p,"MARESCITTA",w_MARESCITTA,0);
    CPLib.PutProperty(p,"MARESCAP",w_MARESCAP,0);
    CPLib.PutProperty(p,"MARESPRV",w_MARESPRV,0);
    CPLib.PutProperty(p,"MARESIND",w_MARESIND,0);
    CPLib.PutProperty(p,"MARESNCIV",w_MARESNCIV,0);
    CPLib.PutProperty(p,"MADOMPAESE",w_MADOMPAESE,0);
    CPLib.PutProperty(p,"MADOMCITTA",w_MADOMCITTA,0);
    CPLib.PutProperty(p,"MADOMCAP",w_MADOMCAP,0);
    CPLib.PutProperty(p,"MADOMPRV",w_MADOMPRV,0);
    CPLib.PutProperty(p,"MADOMIND",w_MADOMIND,0);
    CPLib.PutProperty(p,"MADOMNCIV",w_MADOMNCIV,0);
    CPLib.PutProperty(p,"MAFLGCOMPL",w_MAFLGCOMPL,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"xDESDIP",w_xDESDIP,0);
    CPLib.PutProperty(p,"despaese",w_despaese,0);
    CPLib.PutProperty(p,"xDESSTARES",w_xDESSTARES,0);
    CPLib.PutProperty(p,"xDESSTADOM",w_xDESSTADOM,0);
    if (p_bGetChildren) {
      if (ardt_ageresleg.IsUpdated()) {
        m_cWv_ardt_ageresleg = ardt_ageresleg.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ageresleg",m_cWv_ardt_ageresleg,0);
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
    return "tbmacage"+"\\"+CPLib.ToCPStr(p_Caller.GetString("MACODICE","C",5,0));
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
  public boolean ChildExists_ardt_ageresleg() {
    if (ardt_ageresleg.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ageresleg) || CPLib.IsLoaded(m_cWv_ardt_ageresleg))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ageresleg.m_bLoaded)) {
      ardt_ageresleg.Blank();
      ardt_ageresleg.w_CODMAGE = w_MACODICE;
      ardt_ageresleg.Load();
    }
    return ardt_ageresleg.m_bLoaded;
  }
  public void CtxLoad_ardt_ageresleg() {
    if ( ! (ardt_ageresleg.m_lCtxLoaded)) {
      ardt_ageresleg.Blank();
    }
    ardt_ageresleg.m_lCtxLoaded = true;
    if ( ! (ardt_ageresleg.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ageresleg) || CPLib.IsLoaded(m_cWv_ardt_ageresleg)) {
        ardt_ageresleg.SetFromContext(m_cWv_ardt_ageresleg);
        m_cWv_ardt_ageresleg = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ageresleg.m_bLoaded)) {
          ardt_ageresleg.Blank();
          ardt_ageresleg.w_CODMAGE = w_MACODICE;
          ardt_ageresleg.Load();
          if ( ! (ardt_ageresleg.m_bLoaded)) {
            ardt_ageresleg.Initialize();
            ardt_ageresleg.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_ageresleg")) {
      CtxLoad_ardt_ageresleg();
      return ardt_ageresleg;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
