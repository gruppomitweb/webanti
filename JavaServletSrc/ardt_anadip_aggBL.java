import java.util.*;

public class ardt_anadip_aggBL extends ardt_anadip_aggWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public double w_ANNORIF;
    public double w_MESERIF;
    public java.sql.Date w_DATAINI;
    public java.sql.Date w_DATAFINE;
    public double w_ANOMAGE;
    public double w_SOSCLIENTI;
    public double w_SOSAGENZIA;
    public double opk_ANNORIF;
    public double opk_MESERIF;
    // Stato della riga (variata, nuova, non variata)
    public int m_nRowStatus;
    public String m_cOldRowCPCCCHK;
    public String[] work_children = new String[]{};
  }
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che indica se la testata e' stata variata
  public boolean m_bHeaderUpdated;
  public String m_cOldRowCPCCCHK;
  public int m_nRowStatus;
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
  public static final String i_EntityName = "ardt_anadip_agg";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_anadip_agg;
  public String m_cServer_anadip_agg;
  public CPPhTableWrInfo m_oWrInfo_anadip_agg;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_anadip_agg;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"anadip_agg"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CODDIPE':CODDIPE,'m_Detail':{'ANNORIF':ANNORIF,'MESERIF':MESERIF,'ANOMAGE':ANOMAGE,'SOSCLIENTI':SOSCLIENTI,'SOSAGENZIA':SOSAGENZIA"+FoundlingChildrenList("ardt_anadip_agg",true,true)+"}"+FoundlingChildrenList("ardt_anadip_agg",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'CODDIPE':CODDIPE,'m_Detail':{'ANNORIF':ANNORIF,'MESERIF':MESERIF,'DATAINI':DATAINI,'DATAFINE':DATAFINE,'ANOMAGE':ANOMAGE,'SOSCLIENTI':SOSCLIENTI,'SOSAGENZIA':SOSAGENZIA"+FoundlingChildrenList("ardt_anadip_agg",true,true)+"}"+FoundlingChildrenList("ardt_anadip_agg",true,false)+"}";
  public static final String i_ItemSequence = "CODDIPE,m_Detail[ ANNORIF MESERIF ANOMAGE SOSCLIENTI SOSAGENZIA"+FoundlingChildrenList("ardt_anadip_agg",false,true)+"]"+FoundlingChildrenList("ardt_anadip_agg",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("ardt_anadip_agg"),new String[][]{new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","key1","false","false"},new String[]{"ANNORIF","Anno di riferimento","N","4","0","campo","key1","true","false"},new String[]{"MESERIF","Mese di Riferimento","N","2","0","campo","key1","true","false"},new String[]{"ANOMAGE","Anomalie Agenzia","N","3","0","campo","nokey","true","false"},new String[]{"SOSCLIENTI","Sos sui clienti dell'agenzia","N","3","0","campo","nokey","true","false"},new String[]{"SOSAGENZIA","Sos sull'agente","N","3","0","campo","nokey","true","false"}});
  public static final String i_TrsKeys = ",ANNORIF,MESERIF";
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  /*  Variabili per i transitori: uno per le righe lette, modificate e/o inserite e
                              uno per le righe cancellate.
                            */
  public ArrayList<TrsRow> m_oTrs= new ArrayList<TrsRow>();
  public ArrayList<TrsRow> m_oDeletedRows= new ArrayList<TrsRow>();
  // Variabile che contiene il numero di riga corrente nel transitorio
  public int m_nCurrentRow;
  public ardt_anadip_aggBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_anadip_agg = p_ContextObject.GetPhName("anadip_agg",p_ContextObject.GetCompany(),false);
    m_cServer_anadip_agg = p_ContextObject.GetServer("anadip_agg");
    m_oWrInfo_anadip_agg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip_agg",p_ContextObject.GetCompany());
    m_cVirtName_anadip_agg = CPSql.ManipulateTablePhName("anadip_agg",m_cServer_anadip_agg);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("ardt_anadip_agg",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CODDIPE = "";
    w_ANNORIF = 0;
    w_MESERIF = 0;
    w_DATAINI = CPLib.NullDate();
    w_DATAFINE = CPLib.NullDate();
    w_ANOMAGE = 0;
    w_SOSCLIENTI = 0;
    w_SOSAGENZIA = 0;
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
  public boolean Set_ANNORIF(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ANNORIF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MESERIF(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_MESERIF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ANOMAGE(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ANOMAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSCLIENTI(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_SOSCLIENTI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSAGENZIA(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_SOSAGENZIA = p_workVariableValue;
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
    m_bHeaderUpdated = false;
    // Rimozione degli elementi dai transitori
    m_oTrs.clear();
    m_oDeletedRows.clear();
    m_nCurrentRow = 0;
    m_nRowStatus = 0;
    m_cOldRowCPCCCHK = "";
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"CODDIPE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("ardt_anadip_agg","anadip_agg",m_KeyColumns,m_Ctx);
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
    w_CODDIPE = "";
    w_ANNORIF = 0;
    w_MESERIF = 0;
    w_DATAINI = CPLib.NullDate();
    w_DATAFINE = CPLib.NullDate();
    w_ANOMAGE = 0;
    w_SOSCLIENTI = 0;
    w_SOSAGENZIA = 0;
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      int rows;
      int i;
      String Rows;
      Properties trs_p;
      trs_p = CPLib.GetProperties(CPLib.GetProperty(p, "m_oTrs", "", 0),new Properties());
      Properties p_ANNORIF;
      p_ANNORIF = CPLib.GetProperties(trs_p.getProperty("ANNORIF"),new Properties());
      Properties p_MESERIF;
      p_MESERIF = CPLib.GetProperties(trs_p.getProperty("MESERIF"),new Properties());
      Properties p_DATAINI;
      p_DATAINI = CPLib.GetProperties(trs_p.getProperty("DATAINI"),new Properties());
      Properties p_DATAFINE;
      p_DATAFINE = CPLib.GetProperties(trs_p.getProperty("DATAFINE"),new Properties());
      Properties p_ANOMAGE;
      p_ANOMAGE = CPLib.GetProperties(trs_p.getProperty("ANOMAGE"),new Properties());
      Properties p_SOSCLIENTI;
      p_SOSCLIENTI = CPLib.GetProperties(trs_p.getProperty("SOSCLIENTI"),new Properties());
      Properties p_SOSAGENZIA;
      p_SOSAGENZIA = CPLib.GetProperties(trs_p.getProperty("SOSAGENZIA"),new Properties());
      Properties p_opk_ANNORIF;
      p_opk_ANNORIF = CPLib.GetProperties(trs_p.getProperty("opk_ANNORIF"),new Properties());
      Properties p_opk_MESERIF;
      p_opk_MESERIF = CPLib.GetProperties(trs_p.getProperty("opk_MESERIF"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_ANNORIF = 0;
        w_ANNORIF = CPLib.GetProperty(p_ANNORIF,"",w_ANNORIF,i);
        w_MESERIF = 0;
        w_MESERIF = CPLib.GetProperty(p_MESERIF,"",w_MESERIF,i);
        w_DATAINI = CPLib.NullDate();
        w_DATAINI = CPLib.GetProperty(p_DATAINI,"",w_DATAINI,i);
        w_DATAFINE = CPLib.NullDate();
        w_DATAFINE = CPLib.GetProperty(p_DATAFINE,"",w_DATAFINE,i);
        w_ANOMAGE = 0;
        w_ANOMAGE = CPLib.GetProperty(p_ANOMAGE,"",w_ANOMAGE,i);
        w_SOSCLIENTI = 0;
        w_SOSCLIENTI = CPLib.GetProperty(p_SOSCLIENTI,"",w_SOSCLIENTI,i);
        w_SOSAGENZIA = 0;
        w_SOSAGENZIA = CPLib.GetProperty(p_SOSAGENZIA,"",w_SOSAGENZIA,i);
        opk_ANNORIF = CPLib.GetProperty(p_opk_ANNORIF,"",0,i);
        opk_MESERIF = CPLib.GetProperty(p_opk_MESERIF,"",0,i);
        work_children = CPLib.SetFromContextChildMNTs(trs_p,m_MNTs,true,i);
        m_nRowStatus = (int)CPLib.GetProperty(p_m_nRowStatus,"",0,i);
        if (CPLib.eq(m_nRowStatus,2)) {
          m_cOldRowCPCCCHK = CPLib.NewCPCCCHK();
        } else {
          m_cOldRowCPCCCHK = CPLib.GetProperty(p_m_cOldRowCPCCCHK,"","",i);
        }
        if (CPLib.ne(m_nRowStatus,3)) {
          AppendRow();
        } else {
          AddTrsDeletedRow();
        }
        i = i+1;
      }
      SetRow(0);
      CPLib.SetFromContextMNTs(p,m_MNTs);
      SPExtenderLib.SetExtendedFromContext(p,extendedFields);
      m_bLoaded = CPLib.GetProperty(p,"m_bLoaded",false,0);
      m_bUpdated = CPLib.GetProperty(p,"m_bUpdated",false,0);
      m_cOldCPCCCHK = CPLib.GetProperty(p,"m_cOldCPCCCHK","",0);
      m_cPreviousState = CPLib.GetProperty(p,"m_cPrvsStt","",0);
      m_cPassword = CPLib.GetProperty(p,"m_cPwd","",0);
      m_cOTP = CPLib.GetProperty(p,"m_cOTP","",0);
      m_lCtxLoaded = true;
      m_bHeaderUpdated = CPLib.GetProperty(p,"m_bHeaderUpdated",false,0);
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
    m_bHeaderUpdated = true;
  }
  public void SetUpdatedRow() {
    m_bUpdated = true;
    SetModified();
  }
  void SetUpdated(String p_cName) {
    if (CPLib.eq(p_cName,"CODDIPE")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"ANNORIF")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"MESERIF")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ANOMAGE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"SOSCLIENTI")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"SOSAGENZIA")) {
      SetUpdatedRow();
      return;
    }
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
    for(String child : CPLib.LoadableMNTs("ardt_anadip_agg",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_anadip_agg",child);
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
    for(String child : CPLib.LoadableMNTs("ardt_anadip_agg",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_anadip_agg",child);
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
    m_MNTs = CPLib.MNTChilds("ardt_anadip_agg",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = true;
    if ( ! (CPLib.Empty(w_ANNORIF))) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
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
      l_Keys = new String[]{"ardt_anadip_agg"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"ardt_anadip_agg\\"+p_cState};
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
  public boolean CanDeleteRow() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanDelete();
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
    int i;
    int trsrow;
    Properties trs_p;
    trs_p = new Properties();
    Properties p_ANNORIF;
    p_ANNORIF = new Properties();
    Properties p_MESERIF;
    p_MESERIF = new Properties();
    Properties p_DATAINI;
    p_DATAINI = new Properties();
    Properties p_DATAFINE;
    p_DATAFINE = new Properties();
    Properties p_ANOMAGE;
    p_ANOMAGE = new Properties();
    Properties p_SOSCLIENTI;
    p_SOSCLIENTI = new Properties();
    Properties p_SOSAGENZIA;
    p_SOSAGENZIA = new Properties();
    Properties p_opk_ANNORIF;
    p_opk_ANNORIF = new Properties();
    Properties p_opk_MESERIF;
    p_opk_MESERIF = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_ANNORIF,"",w_ANNORIF,trsrow);
      CPLib.PutProperty(p_MESERIF,"",w_MESERIF,trsrow);
      CPLib.PutProperty(p_DATAINI,"",w_DATAINI,trsrow);
      CPLib.PutProperty(p_DATAFINE,"",w_DATAFINE,trsrow);
      CPLib.PutProperty(p_ANOMAGE,"",w_ANOMAGE,trsrow);
      CPLib.PutProperty(p_SOSCLIENTI,"",w_SOSCLIENTI,trsrow);
      CPLib.PutProperty(p_SOSAGENZIA,"",w_SOSAGENZIA,trsrow);
      CPLib.PutProperty(p_opk_ANNORIF,"",opk_ANNORIF,trsrow);
      CPLib.PutProperty(p_opk_MESERIF,"",opk_MESERIF,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    i = 0;
    while (CPLib.lt(i,m_oDeletedRows.size())) {
      SetDeletedRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_ANNORIF,"",w_ANNORIF,trsrow);
      CPLib.PutProperty(p_MESERIF,"",w_MESERIF,trsrow);
      CPLib.PutProperty(p_DATAINI,"",w_DATAINI,trsrow);
      CPLib.PutProperty(p_DATAFINE,"",w_DATAFINE,trsrow);
      CPLib.PutProperty(p_ANOMAGE,"",w_ANOMAGE,trsrow);
      CPLib.PutProperty(p_SOSCLIENTI,"",w_SOSCLIENTI,trsrow);
      CPLib.PutProperty(p_SOSAGENZIA,"",w_SOSAGENZIA,trsrow);
      CPLib.PutProperty(p_opk_ANNORIF,"",opk_ANNORIF,trsrow);
      CPLib.PutProperty(p_opk_MESERIF,"",opk_MESERIF,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("ANNORIF",CPLib.ToProperties(p_ANNORIF));
    trs_p.setProperty("MESERIF",CPLib.ToProperties(p_MESERIF));
    trs_p.setProperty("DATAINI",CPLib.ToProperties(p_DATAINI));
    trs_p.setProperty("DATAFINE",CPLib.ToProperties(p_DATAFINE));
    trs_p.setProperty("ANOMAGE",CPLib.ToProperties(p_ANOMAGE));
    trs_p.setProperty("SOSCLIENTI",CPLib.ToProperties(p_SOSCLIENTI));
    trs_p.setProperty("SOSAGENZIA",CPLib.ToProperties(p_SOSAGENZIA));
    trs_p.setProperty("opk_ANNORIF",CPLib.ToProperties(p_opk_ANNORIF));
    trs_p.setProperty("opk_MESERIF",CPLib.ToProperties(p_opk_MESERIF));
    trs_p.setProperty("m_nRowStatus",CPLib.ToProperties(p_m_nRowStatus));
    trs_p.setProperty("m_cOldRowCPCCCHK",CPLib.ToProperties(p_m_cOldRowCPCCCHK));
    trs_p.setProperty("Rows",CPLib.ToProperties(trsrow));
    CPLib.PutProperty(p,"m_oTrs",trs_p);
    SPExtenderLib.PutExtendedProperies(p,extendedFields);
    CPLib.PutProperty(p,"m_bLoaded",m_bLoaded);
    CPLib.PutProperty(p,"m_bUpdated",m_bUpdated);
    CPLib.PutProperty(p,"m_cOldCPCCCHK",m_cOldCPCCCHK);
    CPLib.PutProperty(p,"m_cPrvsStt",m_cPreviousState);
    CPLib.PutProperty(p,"m_bHeaderUpdated",m_bHeaderUpdated);
  }
  public String i_PrimaryKey() {
    return PrimaryKey(this);
  }
  public static String PrimaryKey(Caller p_Caller) {
    return "anadip_agg"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CODDIPE","C",6,0));
  }
  public String RowPrimaryKey() {
    return "anadip_agg"+"\\"+CPLib.ToCPStr(w_ANNORIF)+"\\"+CPLib.ToCPStr(w_MESERIF);
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
  protected void TrsToWork() {
    w_ANNORIF= m_oTrs.get(m_nCurrentRow).w_ANNORIF;
    w_MESERIF= m_oTrs.get(m_nCurrentRow).w_MESERIF;
    w_DATAINI= m_oTrs.get(m_nCurrentRow).w_DATAINI;
    w_DATAFINE= m_oTrs.get(m_nCurrentRow).w_DATAFINE;
    w_ANOMAGE= m_oTrs.get(m_nCurrentRow).w_ANOMAGE;
    w_SOSCLIENTI= m_oTrs.get(m_nCurrentRow).w_SOSCLIENTI;
    w_SOSAGENZIA= m_oTrs.get(m_nCurrentRow).w_SOSAGENZIA;
    opk_ANNORIF= m_oTrs.get(m_nCurrentRow).opk_ANNORIF;
    opk_MESERIF= m_oTrs.get(m_nCurrentRow).opk_MESERIF;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_ANNORIF=w_ANNORIF;
    m_oTrs.get(m_nCurrentRow).w_MESERIF=w_MESERIF;
    m_oTrs.get(m_nCurrentRow).w_DATAINI=w_DATAINI;
    m_oTrs.get(m_nCurrentRow).w_DATAFINE=w_DATAFINE;
    m_oTrs.get(m_nCurrentRow).w_ANOMAGE=w_ANOMAGE;
    m_oTrs.get(m_nCurrentRow).w_SOSCLIENTI=w_SOSCLIENTI;
    m_oTrs.get(m_nCurrentRow).w_SOSAGENZIA=w_SOSAGENZIA;
    m_oTrs.get(m_nCurrentRow).opk_ANNORIF=opk_ANNORIF;
    m_oTrs.get(m_nCurrentRow).opk_MESERIF=opk_MESERIF;
    CPLib.WorkToTrsMNTs(m_MNTs,work_children);
    m_oTrs.get(m_nCurrentRow).work_children=CPLib.GetClone(work_children);
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
    m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public void AddRow() {
    /*  Inizializzazione di una nuova riga del transitorio.
                                Questo metodo pubblico viene chiamato quando c'è la richiesta dall'interfaccia
                                di aggiungere una riga nella movimentazione.
                              */
    m_nRowStatus = 2;
    m_nCurrentRow = Rows();
    boolean l_bTmpRes;
    // Inizializzazione delle variabili di work al loro valore di blank
    w_ANNORIF = 0;
    w_MESERIF = 0;
    w_DATAINI = CPLib.NullDate();
    w_DATAFINE = CPLib.NullDate();
    w_ANOMAGE = 0;
    w_SOSCLIENTI = 0;
    w_SOSAGENZIA = 0;
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    m_cOldRowCPCCCHK = "";
    // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
    SaveDependsOn();
    AppendRow();
  }
  public boolean SetRow(double p_nRowNumberToSet) {
    /*  Impostazione delle variabili di work ad una riga del transitorio.
                                Se la riga richiesta è nuova, viene chiamata una inizializzazione.
                                Se la riga richiesta è più grande della dimensione del transitorio + 1,
                                viene ritornato "False".
                                Questa procedura viene chiamata nella lettura di un record e in generale
                                quando si deve operare
                                nel transitorio non per caricare un nuovo dato, ma per leggere.
                                Negli altri casi si deve chiamare la "ChangeRow" che fa il check della riga
                                corrente e salva il transitorio.
                              */
    boolean l_bResult;
    l_bResult = true;
    if (CPLib.lt(p_nRowNumberToSet,Rows())) {
      m_nCurrentRow = (int)p_nRowNumberToSet;
      // Popolamento delle variabili di work
      TrsToWork();
    } else {
      // Si sta tentando di impostare una riga non valida
      l_bResult = false;
    }
    return l_bResult;
  }
  public void AppendRow() {
    CPLib.AppendToTrs(m_oTrs,new TrsRow());
    m_nCurrentRow = Rows()-1;
    // Salvataggio dei valori delle variabili di work nel transitorio
    WorkToTrs();
  }
  public void AddTrsDeletedRow() {
    // Aggiunta di una riga nel transitorio delle righe cancellate.
    int l_nRows;
    CPLib.AppendToTrs(m_oDeletedRows,new TrsRow());
    l_nRows = m_oDeletedRows.size()-1;
    m_oDeletedRows.get(l_nRows).w_ANNORIF=w_ANNORIF;
    m_oDeletedRows.get(l_nRows).w_MESERIF=w_MESERIF;
    m_oDeletedRows.get(l_nRows).w_DATAINI=w_DATAINI;
    m_oDeletedRows.get(l_nRows).w_DATAFINE=w_DATAFINE;
    m_oDeletedRows.get(l_nRows).w_ANOMAGE=w_ANOMAGE;
    m_oDeletedRows.get(l_nRows).w_SOSCLIENTI=w_SOSCLIENTI;
    m_oDeletedRows.get(l_nRows).w_SOSAGENZIA=w_SOSAGENZIA;
    m_oDeletedRows.get(l_nRows).opk_ANNORIF=opk_ANNORIF;
    m_oDeletedRows.get(l_nRows).opk_MESERIF=opk_MESERIF;
    m_oDeletedRows.get(l_nRows).work_children=CPLib.GetClone(work_children);
    m_oDeletedRows.get(l_nRows).m_nRowStatus=3;
    m_oDeletedRows.get(l_nRows).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public boolean SaveRow() {
    return CanSaveConditionallyRow(true);
  }
  boolean CanSaveConditionallyRow(boolean p_bSaveWork) {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
      if (l_bResult && p_bSaveWork) {
        // Salvataggio della riga corrente nel transitorio
        WorkToTrs();
      }
    }
    return l_bResult;
  }
  public void ChangeRow(int p_nRowNumberToSet) {
    /*  Cambia la riga corrente.
                                Se la riga richiesta non esiste ne viene inizializzata un'altra.
                              */
    boolean l_bResult;
    l_bResult = SetRow(p_nRowNumberToSet);
    if ( ! (l_bResult)) {
      // Inizializzazione di una nuova riga
      AddRow();
    }
  }
  public String RowStatus() {
    switch (m_nRowStatus) {
      case 2:
      return "A";
      case 0:
      return " ";
      case 1:
      return "U";
      case 3:
      return "D";
    }
    return "";
  }
  public boolean IsRowUpdated() {
    return CPLib.eq(m_nRowStatus,2) || CPLib.eq(m_nRowStatus,1) || CPLib.eq(m_nRowStatus,3);
  }
  public boolean IsRowNew() {
    return CPLib.eq(m_nRowStatus,2);
  }
  public int Rows() {
    /*  Restituisce il numero di righe del transitorio.
                              */
    return m_oTrs.size();
  }
  public int DeletedRows() {
    /*  Restituisce il numero di righe del transitorio.
                              */
    return m_oDeletedRows.size();
  }
  public boolean DeleteRow() {
    /*  Cancellazione nel transitorio di una riga. La riga cancellata
                                viene scritta nel transitorio delle righe cancellate.
                              */
    if ( ! (CanDeleteRow())) {
      return false;
    }
    SubtractTotals();
    // Le variabili di work vengono salvate nel transitorio delle righe cancellate
    if (CPLib.ne(m_nRowStatus,2)) {
      AddTrsDeletedRow();
    }
    // Cancellazione della riga corrente
    m_oTrs.remove(m_nCurrentRow);
    // Assegnazione della nuova riga valida
    m_nCurrentRow = Rows()-1;
    if (CPLib.eq(m_nCurrentRow,-1)) {
      m_nCurrentRow = 0;
    }
    m_bUpdated = true;
    // Esecuzione dei calcoli
    Calculate();
    return true;
  }
  void SubtractTotals() {
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_ANNORIF));
  }
  void SetModified() {
    /*  Segna la riga corrente del transitorio come modificata se non è una riga aggiunta
                              */
    int l_nStatus;
    if (CPLib.gt(Rows(),0)) {
      l_nStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
      if (CPLib.ne(l_nStatus,2)) {
        m_nRowStatus = 1;
      }
    } else {
      m_nRowStatus = 2;
    }
  }
  void SetDeletedRow(double p_nRowNumberToSet) {
    int l_RowNumberToSet;
    l_RowNumberToSet = (int)p_nRowNumberToSet;
    w_ANNORIF= m_oDeletedRows.get(l_RowNumberToSet).w_ANNORIF;
    w_MESERIF= m_oDeletedRows.get(l_RowNumberToSet).w_MESERIF;
    w_DATAINI= m_oDeletedRows.get(l_RowNumberToSet).w_DATAINI;
    w_DATAFINE= m_oDeletedRows.get(l_RowNumberToSet).w_DATAFINE;
    w_ANOMAGE= m_oDeletedRows.get(l_RowNumberToSet).w_ANOMAGE;
    w_SOSCLIENTI= m_oDeletedRows.get(l_RowNumberToSet).w_SOSCLIENTI;
    w_SOSAGENZIA= m_oDeletedRows.get(l_RowNumberToSet).w_SOSAGENZIA;
    opk_ANNORIF= m_oDeletedRows.get(l_RowNumberToSet).opk_ANNORIF;
    opk_MESERIF= m_oDeletedRows.get(l_RowNumberToSet).opk_MESERIF;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
