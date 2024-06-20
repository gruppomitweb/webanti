import java.util.*;

public class opemt_scarti_contanteBL extends opemt_scarti_contanteWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "opemt_scarti_contante";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_scarto_contante;
  public String m_cServer_scarto_contante;
  public CPPhTableWrInfo m_oWrInfo_scarto_contante;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_scarto_contante;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"scarto_contante"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'NUMPROG':NUMPROG,'TIPATT':TIPATT,'TIPOATTIV':TIPOATTIV,'CODICEGLN':CODICEGLN,'TOTBANKNOTE':TOTBANKNOTE,'TAGLIO':TAGLIO,'NBANCONOTE':NBANCONOTE,'ABIINTER':ABIINTER,'ABIPROPR':ABIPROPR,'GLNALTROSOG':GLNALTROSOG,'GLNALTRASC':GLNALTRASC,'CODCLICON':CODCLICON,'CODCOMCON':CODCOMCON,'ATECO_CON':ATECO_CON,'CODDIPE':CODDIPE,'IMPPROG':IMPPROG"+FoundlingChildrenList("opemt_scarti_contante",true)+"}";
  public static final String i_CompleteStateStructure = "{'NUMPROG':NUMPROG,'TIPATT':TIPATT,'TIPOATTIV':TIPOATTIV,'CODICEGLN':CODICEGLN,'TOTBANKNOTE':TOTBANKNOTE,'TAGLIO':TAGLIO,'NBANCONOTE':NBANCONOTE,'ABIINTER':ABIINTER,'ABIPROPR':ABIPROPR,'GLNALTROSOG':GLNALTROSOG,'GLNALTRASC':GLNALTRASC,'CODCLICON':CODCLICON,'CODCOMCON':CODCOMCON,'ATECO_CON':ATECO_CON,'CODDIPE':CODDIPE,'IMPPROG':IMPPROG"+FoundlingChildrenList("opemt_scarti_contante",true)+"}";
  public static final String i_ItemSequence = "NUMPROG,TIPATT,TIPOATTIV,CODICEGLN,TOTBANKNOTE,TAGLIO,NBANCONOTE,ABIINTER,ABIPROPR,GLNALTROSOG,GLNALTRASC,CODCLICON,CODCOMCON,ATECO_CON,CODDIPE,IMPPROG"+FoundlingChildrenList("opemt_scarti_contante",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("opemt_scarti_contante"),new String[][]{new String[]{"NUMPROG","Codice Collegamento Operazioni","C","11","0","campo","key1","false","false"},new String[]{"TIPATT","Tipo attività","C","3","0","campo","nokey","false","false"},new String[]{"TIPOATTIV","SPortello/CashDispenser","C","2","0","campo","nokey","false","false"},new String[]{"CODICEGLN","GLN Sala Conta","C","13","0","campo","nokey","false","false"},new String[]{"TOTBANKNOTE","Banconote Ritirate","N","10","0","campo","nokey","false","false"},new String[]{"TAGLIO","Taglio Banconota","N","4","0","campo","nokey","false","false"},new String[]{"NBANCONOTE","N. Banconote","N","10","0","campo","nokey","false","false"},new String[]{"ABIINTER","ABI Intermediario","C","5","0","campo","nokey","false","false"},new String[]{"ABIPROPR","ABI Proprietario","C","5","0","campo","nokey","false","false"},new String[]{"GLNALTROSOG","GLN Altro Soggetto","C","13","0","campo","nokey","false","false"},new String[]{"GLNALTRASC","GLN Sala Conta Altro Soggetto","C","13","0","campo","nokey","false","false"},new String[]{"CODCLICON","Codice Cliente Contante","C","20","0","campo","nokey","false","false"},new String[]{"CODCOMCON","Codice ISTAT Comune Cliente Contante","C","6","0","campo","nokey","false","false"},new String[]{"ATECO_CON","Codice Ateco Cliente Contante","C","10","0","campo","nokey","false","false"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"IMPPROG","Progressivo Import","C","13","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public opemt_scarti_contanteBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_scarto_contante = p_ContextObject.GetPhName("scarto_contante",p_ContextObject.GetCompany(),false);
    m_cServer_scarto_contante = p_ContextObject.GetServer("scarto_contante");
    m_oWrInfo_scarto_contante = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"scarto_contante",p_ContextObject.GetCompany());
    m_cVirtName_scarto_contante = CPSql.ManipulateTablePhName("scarto_contante",m_cServer_scarto_contante);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("opemt_scarti_contante",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_NUMPROG = "";
    w_TIPATT = "";
    w_TIPOATTIV = "";
    w_CODICEGLN = "";
    w_TOTBANKNOTE = 0;
    w_TAGLIO = 0;
    w_NBANCONOTE = 0;
    w_ABIINTER = "";
    w_ABIPROPR = "";
    w_GLNALTROSOG = "";
    w_GLNALTRASC = "";
    w_CODCLICON = "";
    w_CODCOMCON = "";
    w_ATECO_CON = "";
    w_CODDIPE = "";
    w_IMPPROG = "";
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
  public boolean Set_NUMPROG(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMPROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPATT(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPATT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOATTIV(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOATTIV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODICEGLN(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODICEGLN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TOTBANKNOTE(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TOTBANKNOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TAGLIO(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TAGLIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NBANCONOTE(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NBANCONOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ABIINTER(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ABIINTER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ABIPROPR(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ABIPROPR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_GLNALTROSOG(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_GLNALTROSOG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_GLNALTRASC(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_GLNALTRASC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODCLICON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODCLICON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODCOMCON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODCOMCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ATECO_CON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ATECO_CON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODDIPE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPPROG(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPPROG = p_workVariableValue;
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
  public final static String[] m_KeyColumns = {"NUMPROG"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("opemt_scarti_contante","scarto_contante",m_KeyColumns,m_Ctx);
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
    w_NUMPROG = "";
    w_TIPATT = "";
    w_TIPOATTIV = "";
    w_CODICEGLN = "";
    w_TOTBANKNOTE = 0;
    w_TAGLIO = 0;
    w_NBANCONOTE = 0;
    w_ABIINTER = "";
    w_ABIPROPR = "";
    w_GLNALTROSOG = "";
    w_GLNALTRASC = "";
    w_CODCLICON = "";
    w_CODCOMCON = "";
    w_ATECO_CON = "";
    w_CODDIPE = "";
    w_IMPPROG = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_TIPATT = CPLib.GetProperty(p,"TIPATT",w_TIPATT,0);
      w_TIPOATTIV = CPLib.GetProperty(p,"TIPOATTIV",w_TIPOATTIV,0);
      w_CODICEGLN = CPLib.GetProperty(p,"CODICEGLN",w_CODICEGLN,0);
      w_TOTBANKNOTE = CPLib.GetProperty(p,"TOTBANKNOTE",w_TOTBANKNOTE,0);
      w_TAGLIO = CPLib.GetProperty(p,"TAGLIO",w_TAGLIO,0);
      w_NBANCONOTE = CPLib.GetProperty(p,"NBANCONOTE",w_NBANCONOTE,0);
      w_ABIINTER = CPLib.GetProperty(p,"ABIINTER",w_ABIINTER,0);
      w_ABIPROPR = CPLib.GetProperty(p,"ABIPROPR",w_ABIPROPR,0);
      w_GLNALTROSOG = CPLib.GetProperty(p,"GLNALTROSOG",w_GLNALTROSOG,0);
      w_GLNALTRASC = CPLib.GetProperty(p,"GLNALTRASC",w_GLNALTRASC,0);
      w_CODCLICON = CPLib.GetProperty(p,"CODCLICON",w_CODCLICON,0);
      w_CODCOMCON = CPLib.GetProperty(p,"CODCOMCON",w_CODCOMCON,0);
      w_ATECO_CON = CPLib.GetProperty(p,"ATECO_CON",w_ATECO_CON,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_IMPPROG = CPLib.GetProperty(p,"IMPPROG",w_IMPPROG,0);
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
    for(String child : CPLib.LoadableMNTs("opemt_scarti_contante",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("opemt_scarti_contante",child);
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
    m_MNTs = CPLib.MNTChilds("opemt_scarti_contante",m_Ctx);
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
      l_Keys = new String[]{"opemt_scarti_contante"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"opemt_scarti_contante\\"+p_cState};
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
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"TIPATT",w_TIPATT,0);
    CPLib.PutProperty(p,"TIPOATTIV",w_TIPOATTIV,0);
    CPLib.PutProperty(p,"CODICEGLN",w_CODICEGLN,0);
    CPLib.PutProperty(p,"TOTBANKNOTE",w_TOTBANKNOTE,0);
    CPLib.PutProperty(p,"TAGLIO",w_TAGLIO,0);
    CPLib.PutProperty(p,"NBANCONOTE",w_NBANCONOTE,0);
    CPLib.PutProperty(p,"ABIINTER",w_ABIINTER,0);
    CPLib.PutProperty(p,"ABIPROPR",w_ABIPROPR,0);
    CPLib.PutProperty(p,"GLNALTROSOG",w_GLNALTROSOG,0);
    CPLib.PutProperty(p,"GLNALTRASC",w_GLNALTRASC,0);
    CPLib.PutProperty(p,"CODCLICON",w_CODCLICON,0);
    CPLib.PutProperty(p,"CODCOMCON",w_CODCOMCON,0);
    CPLib.PutProperty(p,"ATECO_CON",w_ATECO_CON,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"IMPPROG",w_IMPPROG,0);
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
    return "scarto_contante"+"\\"+CPLib.ToCPStr(p_Caller.GetString("NUMPROG","C",11,0));
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
