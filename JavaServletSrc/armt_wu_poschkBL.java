import java.util.*;

public class armt_wu_poschkBL extends armt_wu_poschkWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_wu_poschk";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wuposchk;
  public String m_cServer_wuposchk;
  public CPPhTableWrInfo m_oWrInfo_wuposchk;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wuposchk;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wuposchk"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CPCODMAG':CPCODMAG,'CPCODAJW':CPCODAJW,'CPRAGSOC':CPRAGSOC,'CPDOMICI':CPDOMICI,'CP_CITTA':CP_CITTA,'CPERR_01':CPERR_01,'CPERR_02':CPERR_02,'CPERR_03':CPERR_03,'CPERR_04':CPERR_04,'CPERR_05':CPERR_05,'CPERR_06':CPERR_06,'CPERR_07':CPERR_07,'CPERR_08':CPERR_08,'CPERR_09':CPERR_09,'CPERR_10':CPERR_10,'CPFLGCOR':CPFLGCOR,'CPFLGFOR':CPFLGFOR"+FoundlingChildrenList("armt_wu_poschk",true)+"}";
  public static final String i_CompleteStateStructure = "{'CPCODMAG':CPCODMAG,'CPCODAJW':CPCODAJW,'CPRAGSOC':CPRAGSOC,'CPDOMICI':CPDOMICI,'CP_CITTA':CP_CITTA,'CPERR_01':CPERR_01,'CPERR_02':CPERR_02,'CPERR_03':CPERR_03,'CPERR_04':CPERR_04,'CPERR_05':CPERR_05,'CPERR_06':CPERR_06,'CPERR_07':CPERR_07,'CPERR_08':CPERR_08,'CPERR_09':CPERR_09,'CPERR_10':CPERR_10,'CPFLGCOR':CPFLGCOR,'CPFLGFOR':CPFLGFOR"+FoundlingChildrenList("armt_wu_poschk",true)+"}";
  public static final String i_ItemSequence = "CPCODMAG,CPCODAJW,CPRAGSOC,CPDOMICI,CP_CITTA,CPERR_01,CPERR_02,CPERR_03,CPERR_04,CPERR_05,CPERR_06,CPERR_07,CPERR_08,CPERR_09,CPERR_10,CPFLGCOR,CPFLGFOR"+FoundlingChildrenList("armt_wu_poschk",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_wu_poschk"),new String[][]{new String[]{"CPCODMAG","Codice Macro Agente","C","5","0","campo","key1","false","false"},new String[]{"CPCODAJW","AJW Agenzia","C","9","0","campo","key1","false","false"},new String[]{"CPRAGSOC","Ragione Sociale","C","30","0","campo","key2","false","false"},new String[]{"CPDOMICI","Domicilio","C","40","0","campo","nokey","false","false"},new String[]{"CP_CITTA","Città","C","30","0","campo","nokey","false","false"},new String[]{"CPERR_01","Errore 1","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_02","Errore 2","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_03","Errore 3","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_04","Errore 4","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_05","Errore 5","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_06","Errore 6","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_07","Errore 7","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_08","Errore 8","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_09","Errore 9","C","60","0","campo","nokey","false","false"},new String[]{"CPERR_10","Errore 10","C","60","0","campo","nokey","false","false"},new String[]{"CPFLGCOR","Flag Corretta","C","1","0","campo","nokey","false","false"},new String[]{"CPFLGFOR","Flag Forzatura","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_wu_poschkBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wuposchk = p_ContextObject.GetPhName("wuposchk",p_ContextObject.GetCompany(),false);
    m_cServer_wuposchk = p_ContextObject.GetServer("wuposchk");
    m_oWrInfo_wuposchk = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wuposchk",p_ContextObject.GetCompany());
    m_cVirtName_wuposchk = CPSql.ManipulateTablePhName("wuposchk",m_cServer_wuposchk);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_wu_poschk",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CPCODMAG = "";
    w_CPCODAJW = "";
    w_CPRAGSOC = "";
    w_CPDOMICI = "";
    w_CP_CITTA = "";
    w_CPERR_01 = "";
    w_CPERR_02 = "";
    w_CPERR_03 = "";
    w_CPERR_04 = "";
    w_CPERR_05 = "";
    w_CPERR_06 = "";
    w_CPERR_07 = "";
    w_CPERR_08 = "";
    w_CPERR_09 = "";
    w_CPERR_10 = "";
    w_CPFLGCOR = "";
    w_CPFLGFOR = "";
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
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CPCODMAG(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPCODMAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPCODAJW(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPCODAJW = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPRAGSOC(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPRAGSOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPDOMICI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPDOMICI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CP_CITTA(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CP_CITTA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_01(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_01 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_02(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_02 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_03(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_03 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_04(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_04 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_05(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_05 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_06(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_06 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_07(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_07 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_08(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_08 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_09(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_09 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPERR_10(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPERR_10 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPFLGCOR(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPFLGCOR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPFLGFOR(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CPFLGFOR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
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
  public final static String[] m_KeyColumns = {"CPCODMAG","CPCODAJW"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_wu_poschk","wuposchk",m_KeyColumns,m_Ctx);
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
    w_CPCODMAG = "";
    w_CPCODAJW = "";
    w_CPRAGSOC = "";
    w_CPDOMICI = "";
    w_CP_CITTA = "";
    w_CPERR_01 = "";
    w_CPERR_02 = "";
    w_CPERR_03 = "";
    w_CPERR_04 = "";
    w_CPERR_05 = "";
    w_CPERR_06 = "";
    w_CPERR_07 = "";
    w_CPERR_08 = "";
    w_CPERR_09 = "";
    w_CPERR_10 = "";
    w_CPFLGCOR = "";
    w_CPFLGFOR = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CPCODMAG = CPLib.GetProperty(p,"CPCODMAG",w_CPCODMAG,0);
      w_CPCODAJW = CPLib.GetProperty(p,"CPCODAJW",w_CPCODAJW,0);
      w_CPRAGSOC = CPLib.GetProperty(p,"CPRAGSOC",w_CPRAGSOC,0);
      w_CPDOMICI = CPLib.GetProperty(p,"CPDOMICI",w_CPDOMICI,0);
      w_CP_CITTA = CPLib.GetProperty(p,"CP_CITTA",w_CP_CITTA,0);
      w_CPERR_01 = CPLib.GetProperty(p,"CPERR_01",w_CPERR_01,0);
      w_CPERR_02 = CPLib.GetProperty(p,"CPERR_02",w_CPERR_02,0);
      w_CPERR_03 = CPLib.GetProperty(p,"CPERR_03",w_CPERR_03,0);
      w_CPERR_04 = CPLib.GetProperty(p,"CPERR_04",w_CPERR_04,0);
      w_CPERR_05 = CPLib.GetProperty(p,"CPERR_05",w_CPERR_05,0);
      w_CPERR_06 = CPLib.GetProperty(p,"CPERR_06",w_CPERR_06,0);
      w_CPERR_07 = CPLib.GetProperty(p,"CPERR_07",w_CPERR_07,0);
      w_CPERR_08 = CPLib.GetProperty(p,"CPERR_08",w_CPERR_08,0);
      w_CPERR_09 = CPLib.GetProperty(p,"CPERR_09",w_CPERR_09,0);
      w_CPERR_10 = CPLib.GetProperty(p,"CPERR_10",w_CPERR_10,0);
      w_CPFLGCOR = CPLib.GetProperty(p,"CPFLGCOR",w_CPFLGCOR,0);
      w_CPFLGFOR = CPLib.GetProperty(p,"CPFLGFOR",w_CPFLGFOR,0);
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
    for(String child : CPLib.LoadableMNTs("armt_wu_poschk",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_wu_poschk",child);
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
    m_MNTs = CPLib.MNTChilds("armt_wu_poschk",m_Ctx);
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
      l_Keys = new String[]{"armt_wu_poschk"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_wu_poschk\\"+p_cState};
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
    CPLib.PutProperty(p,"CPCODMAG",w_CPCODMAG,0);
    CPLib.PutProperty(p,"CPCODAJW",w_CPCODAJW,0);
    CPLib.PutProperty(p,"CPRAGSOC",w_CPRAGSOC,0);
    CPLib.PutProperty(p,"CPDOMICI",w_CPDOMICI,0);
    CPLib.PutProperty(p,"CP_CITTA",w_CP_CITTA,0);
    CPLib.PutProperty(p,"CPERR_01",w_CPERR_01,0);
    CPLib.PutProperty(p,"CPERR_02",w_CPERR_02,0);
    CPLib.PutProperty(p,"CPERR_03",w_CPERR_03,0);
    CPLib.PutProperty(p,"CPERR_04",w_CPERR_04,0);
    CPLib.PutProperty(p,"CPERR_05",w_CPERR_05,0);
    CPLib.PutProperty(p,"CPERR_06",w_CPERR_06,0);
    CPLib.PutProperty(p,"CPERR_07",w_CPERR_07,0);
    CPLib.PutProperty(p,"CPERR_08",w_CPERR_08,0);
    CPLib.PutProperty(p,"CPERR_09",w_CPERR_09,0);
    CPLib.PutProperty(p,"CPERR_10",w_CPERR_10,0);
    CPLib.PutProperty(p,"CPFLGCOR",w_CPFLGCOR,0);
    CPLib.PutProperty(p,"CPFLGFOR",w_CPFLGFOR,0);
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
    return "wuposchk"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CPCODMAG","C",5,0))+"\\"+CPLib.ToCPStr(p_Caller.GetString("CPCODAJW","C",9,0));
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
