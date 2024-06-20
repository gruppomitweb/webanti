import java.util.*;

public class armt_tbrappBL extends armt_tbrappWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_tbrapp";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_tbrapp;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"tbrapp"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IMP12022':IMP12022,'IMP22022':IMP22022,'IMP32022':IMP32022,'IMP42022':IMP42022,'IMP52022':IMP52022,'IMP62022':IMP62022,'IDBASE':IDBASE,'CODICE':CODICE,'DESCRI':DESCRI,'NOTE':NOTE,'IMP1':IMP1,'IMP2':IMP2,'IMP3':IMP3,'IMP4':IMP4,'IMP5':IMP5,'IMP6':IMP6"+FoundlingChildrenList("armt_tbrapp",true)+"}";
  public static final String i_CompleteStateStructure = "{'IMP12022':IMP12022,'IMP22022':IMP22022,'IMP32022':IMP32022,'IMP42022':IMP42022,'IMP52022':IMP52022,'IMP62022':IMP62022,'IDBASE':IDBASE,'CODICE':CODICE,'DESCRI':DESCRI,'NOTE':NOTE,'IMP1':IMP1,'IMP2':IMP2,'IMP3':IMP3,'IMP4':IMP4,'IMP5':IMP5,'IMP6':IMP6"+FoundlingChildrenList("armt_tbrapp",true)+"}";
  public static final String i_ItemSequence = "IMP12022,IMP22022,IMP32022,IMP42022,IMP52022,IMP62022,IDBASE,CODICE,DESCRI,NOTE,IMP1,IMP2,IMP3,IMP4,IMP5,IMP6"+FoundlingChildrenList("armt_tbrapp",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_tbrapp"),new String[][]{new String[]{"IMP12022","Importo 1","C","250","0","campo","nokey","false","false"},new String[]{"IMP22022","Importo 2","C","250","0","campo","nokey","false","false"},new String[]{"IMP32022","Importo 3","C","250","0","campo","nokey","false","false"},new String[]{"IMP42022","Importo 4","C","250","0","campo","nokey","false","false"},new String[]{"IMP52022","Altre Info.","C","250","0","campo","nokey","false","false"},new String[]{"IMP62022","Giacenza Media","C","250","0","campo","nokey","false","false"},new String[]{"IDBASE","ID","C","10","0","campo","key1","false","false"},new String[]{"CODICE","Codice","C","2","0","campo","key2","false","false"},new String[]{"DESCRI","Descrizione","C","150","0","campo","key3","false","false"},new String[]{"NOTE","Descrizione estesa","C","254","0","campo","nokey","false","false"},new String[]{"IMP1","Importo 1","C","250","0","campo","nokey","false","false"},new String[]{"IMP2","Importo 1","C","250","0","campo","nokey","false","false"},new String[]{"IMP3","Importo 3","C","250","0","campo","nokey","false","false"},new String[]{"IMP4","Importo 4","C","250","0","campo","nokey","false","false"},new String[]{"IMP5","Altre Info.","C","250","0","campo","nokey","false","false"},new String[]{"IMP6","Giacenza Media","C","250","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_tbrappBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp",p_ContextObject.GetCompany(),false);
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cVirtName_tbrapp = CPSql.ManipulateTablePhName("tbrapp",m_cServer_tbrapp);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_tbrapp",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IMP12022 = "";
    w_IMP22022 = "";
    w_IMP32022 = "";
    w_IMP42022 = "";
    w_IMP52022 = "";
    w_IMP62022 = "";
    w_IDBASE = "";
    w_CODICE = "";
    w_DESCRI = "";
    w_NOTE = "";
    w_IMP1 = "";
    w_IMP2 = "";
    w_IMP3 = "";
    w_IMP4 = "";
    w_IMP5 = "";
    w_IMP6 = "";
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
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_IMP12022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP12022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP22022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP22022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP32022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP32022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP42022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP42022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP52022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP52022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP62022(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP62022 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDBASE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDBASE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODICE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCRI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOTE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP4(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP4 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP5(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP5 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMP6(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMP6 = p_workVariableValue;
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
  public final static String[] m_KeyColumns = {"IDBASE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_tbrapp","tbrapp",m_KeyColumns,m_Ctx);
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
    w_IMP12022 = "";
    w_IMP22022 = "";
    w_IMP32022 = "";
    w_IMP42022 = "";
    w_IMP52022 = "";
    w_IMP62022 = "";
    w_IDBASE = "";
    w_CODICE = "";
    w_DESCRI = "";
    w_NOTE = "";
    w_IMP1 = "";
    w_IMP2 = "";
    w_IMP3 = "";
    w_IMP4 = "";
    w_IMP5 = "";
    w_IMP6 = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_IMP12022 = CPLib.GetProperty(p,"IMP12022",w_IMP12022,0);
      w_IMP22022 = CPLib.GetProperty(p,"IMP22022",w_IMP22022,0);
      w_IMP32022 = CPLib.GetProperty(p,"IMP32022",w_IMP32022,0);
      w_IMP42022 = CPLib.GetProperty(p,"IMP42022",w_IMP42022,0);
      w_IMP52022 = CPLib.GetProperty(p,"IMP52022",w_IMP52022,0);
      w_IMP62022 = CPLib.GetProperty(p,"IMP62022",w_IMP62022,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_CODICE = CPLib.GetProperty(p,"CODICE",w_CODICE,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_NOTE = CPLib.GetProperty(p,"NOTE",w_NOTE,0);
      w_IMP1 = CPLib.GetProperty(p,"IMP1",w_IMP1,0);
      w_IMP2 = CPLib.GetProperty(p,"IMP2",w_IMP2,0);
      w_IMP3 = CPLib.GetProperty(p,"IMP3",w_IMP3,0);
      w_IMP4 = CPLib.GetProperty(p,"IMP4",w_IMP4,0);
      w_IMP5 = CPLib.GetProperty(p,"IMP5",w_IMP5,0);
      w_IMP6 = CPLib.GetProperty(p,"IMP6",w_IMP6,0);
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
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_tbrapp",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_tbrapp",child);
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
    m_MNTs = CPLib.MNTChilds("armt_tbrapp",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
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
      l_Keys = new String[]{"armt_tbrapp"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_tbrapp\\"+p_cState};
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
    CPLib.PutProperty(p,"IMP12022",w_IMP12022,0);
    CPLib.PutProperty(p,"IMP22022",w_IMP22022,0);
    CPLib.PutProperty(p,"IMP32022",w_IMP32022,0);
    CPLib.PutProperty(p,"IMP42022",w_IMP42022,0);
    CPLib.PutProperty(p,"IMP52022",w_IMP52022,0);
    CPLib.PutProperty(p,"IMP62022",w_IMP62022,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"CODICE",w_CODICE,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"NOTE",w_NOTE,0);
    CPLib.PutProperty(p,"IMP1",w_IMP1,0);
    CPLib.PutProperty(p,"IMP2",w_IMP2,0);
    CPLib.PutProperty(p,"IMP3",w_IMP3,0);
    CPLib.PutProperty(p,"IMP4",w_IMP4,0);
    CPLib.PutProperty(p,"IMP5",w_IMP5,0);
    CPLib.PutProperty(p,"IMP6",w_IMP6,0);
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
    return "tbrapp"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
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
