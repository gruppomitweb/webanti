import java.util.*;

public class armt_cgo_infbachecaBL extends armt_cgo_infbachecaWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record � stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record � stato variato
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
  public static final String i_EntityName = "armt_cgo_infbacheca";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_infbacheca;
  public String m_cServer_cgo_infbacheca;
  public CPPhTableWrInfo m_oWrInfo_cgo_infbacheca;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_infbacheca;
  public String m_cPhName_cgo_catbacheca;
  public String m_cServer_cgo_catbacheca;
  public CPPhTableWrInfo m_oWrInfo_cgo_catbacheca;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_infbacheca"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IBCODICE':IBCODICE,'IBCODCAT':IBCODCAT,'IBINFATT':IBINFATT,'IBTITOLO':IBTITOLO,'IBDESCRI':IBDESCRI,'IBDATSCA':IBDATSCA,'ardt_cgo_infbacheca_doc':ardt_cgo_infbacheca_doc"+FoundlingChildrenList("armt_cgo_infbacheca",true)+"}";
  public static final String i_CompleteStateStructure = "{'IBCODICE':IBCODICE,'IBCODCAT':IBCODCAT,'IBINFATT':IBINFATT,'IBTITOLO':IBTITOLO,'IBDESCRI':IBDESCRI,'IBDATSCA':IBDATSCA,'ardt_cgo_infbacheca_doc':ardt_cgo_infbacheca_doc,'IBDATINS':IBDATINS"+FoundlingChildrenList("armt_cgo_infbacheca",true)+"}";
  public static final String i_ItemSequence = "IBCODICE,IBCODCAT,IBINFATT,IBTITOLO,IBDESCRI,IBDATSCA,ardt_cgo_infbacheca_doc"+FoundlingChildrenList("armt_cgo_infbacheca",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_infbacheca"),new String[][]{new String[]{"IBCODICE","Codice","N","10","0","campo","key1","false","false"},new String[]{"IBCODCAT","Categoria","C","5","0","campo","key2","false","false"},new String[]{"IBINFATT","Informazione Attiva","C","1","0","campo","nokey","false","false"},new String[]{"IBTITOLO","Titolo","C","60","0","campo","key3","false","false"},new String[]{"IBDESCRI","Descrizione","M","10","0","campo","nokey","false","false"},new String[]{"IBDATSCA","Data Scadenza","D","8","0","campo","nokey","false","false"},new String[]{"ardt_cgo_infbacheca_doc","Documenti Collegati Informazioni","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_infbachecaBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_infbacheca = p_ContextObject.GetPhName("cgo_infbacheca",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_infbacheca = p_ContextObject.GetServer("cgo_infbacheca");
    m_oWrInfo_cgo_infbacheca = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_infbacheca",p_ContextObject.GetCompany());
    m_cVirtName_cgo_infbacheca = CPSql.ManipulateTablePhName("cgo_infbacheca",m_cServer_cgo_infbacheca);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_cgo_catbacheca = p_ContextObject.GetPhName("cgo_catbacheca");
    m_cServer_cgo_catbacheca = p_ContextObject.GetServer("cgo_catbacheca");
    m_oWrInfo_cgo_catbacheca = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_catbacheca",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_cgo_infbacheca_doc = new ardt_cgo_infbacheca_docBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_cgo_infbacheca",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IBCODICE = 0;
    w_IBCODCAT = "";
    w_IBTITOLO = "";
    w_IBDESCRI = "";
    w_IBDATSCA = CPLib.NullDate();
    w_IBINFATT = "S";
    w_IBDATINS = CPLib.NullDate();
    w_IBDATINS = CPLib.Date();
    m_cWv_ardt_cgo_infbacheca_doc = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_cgo_infbacheca_doc.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_cgo_infbacheca_doc);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    ardt_cgo_infbacheca_doc.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_IBCODICE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBCODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IBCODCAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBCODCAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IBINFATT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBINFATT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IBTITOLO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBTITOLO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IBDESCRI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBDESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IBDATSCA(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBDATSCA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
                              abilitazione di un control.
                            */
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
    w_IBDATINS = CPLib.Date();
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
  public final static String[] m_KeyColumns = {"IBCODICE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_infbacheca","cgo_infbacheca",m_KeyColumns,m_Ctx);
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
    w_IBCODICE = 0;
    w_IBCODCAT = "";
    w_IBINFATT = "";
    w_IBTITOLO = "";
    w_IBDESCRI = "";
    w_IBDATSCA = CPLib.NullDate();
    w_IBDATINS = CPLib.NullDate();
    m_cWv_ardt_cgo_infbacheca_doc = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_IBCODICE = CPLib.GetProperty(p,"IBCODICE",w_IBCODICE,0);
      op_IBCODICE = CPLib.GetProperty(p,"op_IBCODICE",0,0);
      w_IBCODCAT = CPLib.GetProperty(p,"IBCODCAT",w_IBCODCAT,0);
      w_IBINFATT = CPLib.GetProperty(p,"IBINFATT",w_IBINFATT,0);
      w_IBTITOLO = CPLib.GetProperty(p,"IBTITOLO",w_IBTITOLO,0);
      w_IBDESCRI = CPLib.GetProperty(p,"IBDESCRI",w_IBDESCRI,0);
      w_IBDATSCA = CPLib.GetProperty(p,"IBDATSCA",w_IBDATSCA,0);
      w_IBDATINS = CPLib.GetProperty(p,"IBDATINS",w_IBDATINS,0);
      m_cWv_ardt_cgo_infbacheca_doc = CPLib.GetProperty(p,"m_cWv_ardt_cgo_infbacheca_doc",m_cWv_ardt_cgo_infbacheca_doc,0);
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
    items = tables.get("cgo_infbacheca_doc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_infbacheca_doc",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IBDCODICE"});
    map.put("rd_var",new String[]{"w_IBCODICE"});
    map.put("wr_var",new String[]{"w_IBCODICE"});
    map.put("wr_field",new String[]{"IBDCODICE"});
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
    map.put("property.value",zeroSplit.split("cgo_infbacheca_doc\u0000false\u0000false\u00001\u00000\u0000ardt_cgo_infbacheca_doc\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_cgo_infbacheca",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_infbacheca",child);
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
    ardt_cgo_infbacheca_doc = new ardt_cgo_infbacheca_docBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_cgo_infbacheca",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    if (l_bResult && (( ! (ardt_cgo_infbacheca_doc.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_cgo_infbacheca_doc)) || ( ! (ardt_cgo_infbacheca_doc.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_cgo_infbacheca_doc)))) {
      ardt_cgo_infbacheca_doc.SetFromContext(m_cWv_ardt_cgo_infbacheca_doc);
      m_cWv_ardt_cgo_infbacheca_doc = "_not_empty_";
    }
    if (l_bResult && (ardt_cgo_infbacheca_doc.m_bLoaded || ardt_cgo_infbacheca_doc.m_bUpdated)) {
      l_bResult = l_bResult && ardt_cgo_infbacheca_doc.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_cgo_infbacheca_doc.m_cLastMsgError;
      }
    }
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoCheck)) {
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
      l_Keys = new String[]{"armt_cgo_infbacheca"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_infbacheca\\"+p_cState};
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
    w_IBCODICE = m_Ctx.AskTableProg(w_IBCODICE,10,op_IBCODICE,"PRGINFBAC"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_cgo_infbacheca);
    op_codazi = m_Ctx.GetCompany();
    op_IBCODICE = w_IBCODICE;
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
      w_IBCODICE = m_Ctx.AskTableProg(w_IBCODICE,10,op_IBCODICE,"PRGINFBAC"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_cgo_infbacheca);
      op_codazi = m_Ctx.GetCompany();
      op_IBCODICE = w_IBCODICE;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_IBCODICE = 0;
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
    CPLib.PutProperty(p,"IBCODICE",w_IBCODICE,0);
    CPLib.PutProperty(p,"op_IBCODICE",op_IBCODICE,0);
    CPLib.PutProperty(p,"IBCODCAT",w_IBCODCAT,0);
    CPLib.PutProperty(p,"IBINFATT",w_IBINFATT,0);
    CPLib.PutProperty(p,"IBTITOLO",w_IBTITOLO,0);
    CPLib.PutProperty(p,"IBDESCRI",w_IBDESCRI,0);
    CPLib.PutProperty(p,"IBDATSCA",w_IBDATSCA,0);
    CPLib.PutProperty(p,"IBDATINS",w_IBDATINS,0);
    if (p_bGetChildren) {
      if (ardt_cgo_infbacheca_doc.IsUpdated()) {
        m_cWv_ardt_cgo_infbacheca_doc = ardt_cgo_infbacheca_doc.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_cgo_infbacheca_doc",m_cWv_ardt_cgo_infbacheca_doc,0);
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
    return "cgo_infbacheca"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("IBCODICE","N",10,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_IBCODICE");
    oneAutoNum.add("PRGINFBAC");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_cgo_infbacheca_doc() {
    if (ardt_cgo_infbacheca_doc.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_cgo_infbacheca_doc) || CPLib.IsLoaded(m_cWv_ardt_cgo_infbacheca_doc))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_cgo_infbacheca_doc.m_bLoaded)) {
      ardt_cgo_infbacheca_doc.Blank();
      ardt_cgo_infbacheca_doc.w_IBDCODICE = w_IBCODICE;
      ardt_cgo_infbacheca_doc.Load();
    }
    return ardt_cgo_infbacheca_doc.m_bLoaded;
  }
  public void CtxLoad_ardt_cgo_infbacheca_doc() {
    if ( ! (ardt_cgo_infbacheca_doc.m_lCtxLoaded)) {
      ardt_cgo_infbacheca_doc.Blank();
    }
    ardt_cgo_infbacheca_doc.m_lCtxLoaded = true;
    if ( ! (ardt_cgo_infbacheca_doc.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_cgo_infbacheca_doc) || CPLib.IsLoaded(m_cWv_ardt_cgo_infbacheca_doc)) {
        ardt_cgo_infbacheca_doc.SetFromContext(m_cWv_ardt_cgo_infbacheca_doc);
        m_cWv_ardt_cgo_infbacheca_doc = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_cgo_infbacheca_doc.m_bLoaded)) {
          ardt_cgo_infbacheca_doc.Blank();
          ardt_cgo_infbacheca_doc.w_IBDCODICE = w_IBCODICE;
          ardt_cgo_infbacheca_doc.Load();
          if ( ! (ardt_cgo_infbacheca_doc.m_bLoaded)) {
            ardt_cgo_infbacheca_doc.Initialize();
            ardt_cgo_infbacheca_doc.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_cgo_infbacheca_doc")) {
      CtxLoad_ardt_cgo_infbacheca_doc();
      return ardt_cgo_infbacheca_doc;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
