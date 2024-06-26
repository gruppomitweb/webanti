import java.util.*;

public class aosdt_ind_defBL extends aosdt_ind_defWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_IDIND;
    public String w_PROGIND;
    public String w_DESCRI;
    public boolean w_LOCKMIT;
    public boolean w_NOAPPLIC;
    public String w_DESCRI_layer;
    public boolean w_open_layer;
    public boolean w_write_layer;
    public String opk_IDIND;
    public String m_cWv_aosdt_sub_ind_def;
    public aosdt_sub_ind_defBO aosdt_sub_ind_def;
    // Stato della riga (variata, nuova, non variata)
    public int m_nRowStatus;
    public String m_cOldRowCPCCCHK;
    public String[] work_children = new String[]{};
  }
  // Variabile che indica se il record � stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record � stato variato
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
  public static final String i_EntityName = "aosdt_ind_def";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_ind_def;
  public String m_cServer_ind_def;
  public CPPhTableWrInfo m_oWrInfo_ind_def;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_ind_def;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"ind_def"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IDMOD':IDMOD,'show_noapplic':show_noapplic,'m_Detail':{'IDIND':IDIND,'PROGIND':PROGIND,'DESCRI':DESCRI,'LOCKMIT':LOCKMIT,'NOAPPLIC':NOAPPLIC,'aosdt_sub_ind_def':aosdt_sub_ind_def,'DESCRI_layer':DESCRI_layer"+FoundlingChildrenList("aosdt_ind_def",true,true)+"}"+FoundlingChildrenList("aosdt_ind_def",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'IDMOD':IDMOD,'show_noapplic':show_noapplic,'m_Detail':{'IDIND':IDIND,'PROGIND':PROGIND,'DESCRI':DESCRI,'LOCKMIT':LOCKMIT,'NOAPPLIC':NOAPPLIC,'aosdt_sub_ind_def':aosdt_sub_ind_def,'DESCRI_layer':DESCRI_layer,'open_layer':open_layer,'write_layer':write_layer"+FoundlingChildrenList("aosdt_ind_def",true,true)+"}"+FoundlingChildrenList("aosdt_ind_def",true,false)+"}";
  public static final String i_ItemSequence = "IDMOD,show_noapplic,m_Detail[ IDIND PROGIND DESCRI LOCKMIT NOAPPLIC aosdt_sub_ind_def DESCRI_layer"+FoundlingChildrenList("aosdt_ind_def",false,true)+"]"+FoundlingChildrenList("aosdt_ind_def",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("aosdt_ind_def"),new String[][]{new String[]{"IDMOD","ID del modello","C","10","0","campo","key1","false","false"},new String[]{"show_noapplic","Mostra i non applicabile","L","1","0","variabile","nokey","false","false"},new String[]{"IDIND","ID del indicatore","C","10","0","campo","key1","true","false"},new String[]{"PROGIND","Progressivo indicatore","C","10","0","campo","key2","true","false"},new String[]{"DESCRI","Descrizione del indicatore","M","10","0","campo","nokey","true","false"},new String[]{"LOCKMIT","Indicatore standard Immodificabile","L","1","0","campo","nokey","true","false"},new String[]{"NOAPPLIC","Indicatore non applicabile","L","1","0","campo","nokey","true","false"},new String[]{"aosdt_sub_ind_def","Sub Indicatori anomalia","","","","link_PC","","true",""},new String[]{"DESCRI_layer","Descrizione","M","10","0","variabile","nokey","true","false"}});
  public static final String i_TrsKeys = ",IDIND";
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
  public aosdt_ind_defBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_ind_def = p_ContextObject.GetPhName("ind_def",p_ContextObject.GetCompany(),false);
    m_cServer_ind_def = p_ContextObject.GetServer("ind_def");
    m_oWrInfo_ind_def = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"ind_def",p_ContextObject.GetCompany());
    m_cVirtName_ind_def = CPSql.ManipulateTablePhName("ind_def",m_cServer_ind_def);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    aosdt_sub_ind_def = new aosdt_sub_ind_defBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("aosdt_ind_def",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IDMOD = "";
    w_show_noapplic = false;
    w_PROGIND = "";
    w_DESCRI = "";
    w_LOCKMIT = false;
    w_IDIND = LibreriaMit.UniqueId();
    w_NOAPPLIC = false;
    w_DESCRI_layer = w_DESCRI;
    w_open_layer = false;
    w_write_layer = true;
    m_cWv_aosdt_sub_ind_def = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || aosdt_sub_ind_def.IsUpdated() || CPLib.IsUpdated(m_cWv_aosdt_sub_ind_def);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_show_noapplic = w_show_noapplic;
    aosdt_sub_ind_def.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_IDMOD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDMOD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_show_noapplic(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_show_noapplic = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDIND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_IDIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROGIND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_PROGIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCRI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_LOCKMIT(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_LOCKMIT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOAPPLIC(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_NOAPPLIC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCRI_layer(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DESCRI_layer = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
                              abilitazione di un control.
                            */
  public boolean getWritable_IDMOD() {
    return false;
  }
  public boolean getWritable_IDIND() {
    return false;
  }
  public boolean getWritable_PROGIND() {
    return  ! (w_LOCKMIT);
  }
  public boolean getWritable_DESCRI() {
    return false;
  }
  public boolean getWritable_LOCKMIT() {
    return false;
  }
  public boolean getWritable_NOAPPLIC() {
    return CPLib.eq(EntityStatus(),"N");
  }
  public boolean getWritable_DESCRI_layer() {
    return  ! (w_LOCKMIT) || w_write_layer;
  }
  public boolean getVisible_IDMOD() {
    return true;
  }
  public boolean getVisible_show_noapplic() {
    return true;
  }
  public boolean getVisible_IDIND() {
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
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    CopyWorkVar(this,aosdt_sub_ind_def,new String[]{"show_noapplic"},new String[]{"show_noapplic"},true);
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  boolean Check_VGASZRXNOJ(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
    }
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
  public final static String[] m_KeyColumns = {"IDMOD"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("aosdt_ind_def","ind_def",m_KeyColumns,m_Ctx);
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
    w_IDMOD = "";
    w_show_noapplic = false;
    w_IDIND = "";
    w_PROGIND = "";
    w_DESCRI = "";
    w_LOCKMIT = false;
    w_NOAPPLIC = false;
    w_DESCRI_layer = "";
    w_open_layer = false;
    w_write_layer = false;
    m_cWv_aosdt_sub_ind_def = "";
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
      Properties p_IDIND;
      p_IDIND = CPLib.GetProperties(trs_p.getProperty("IDIND"),new Properties());
      Properties p_PROGIND;
      p_PROGIND = CPLib.GetProperties(trs_p.getProperty("PROGIND"),new Properties());
      Properties p_DESCRI;
      p_DESCRI = CPLib.GetProperties(trs_p.getProperty("DESCRI"),new Properties());
      Properties p_LOCKMIT;
      p_LOCKMIT = CPLib.GetProperties(trs_p.getProperty("LOCKMIT"),new Properties());
      Properties p_NOAPPLIC;
      p_NOAPPLIC = CPLib.GetProperties(trs_p.getProperty("NOAPPLIC"),new Properties());
      Properties p_DESCRI_layer;
      p_DESCRI_layer = CPLib.GetProperties(trs_p.getProperty("DESCRI_layer"),new Properties());
      Properties p_open_layer;
      p_open_layer = CPLib.GetProperties(trs_p.getProperty("open_layer"),new Properties());
      Properties p_write_layer;
      p_write_layer = CPLib.GetProperties(trs_p.getProperty("write_layer"),new Properties());
      Properties p_m_cWv_aosdt_sub_ind_def;
      p_m_cWv_aosdt_sub_ind_def = CPLib.GetProperties(trs_p.getProperty("m_cWv_aosdt_sub_ind_def"),new Properties());
      Properties p_opk_IDIND;
      p_opk_IDIND = CPLib.GetProperties(trs_p.getProperty("opk_IDIND"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_IDMOD = CPLib.GetProperty(p,"IDMOD",w_IDMOD,0);
      w_show_noapplic = CPLib.GetProperty(p,"show_noapplic",w_show_noapplic,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_IDIND = "";
        w_IDIND = CPLib.GetProperty(p_IDIND,"",w_IDIND,i);
        w_PROGIND = "";
        w_PROGIND = CPLib.GetProperty(p_PROGIND,"",w_PROGIND,i);
        w_DESCRI = "";
        w_DESCRI = CPLib.GetProperty(p_DESCRI,"",w_DESCRI,i);
        w_LOCKMIT = false;
        w_LOCKMIT = CPLib.GetProperty(p_LOCKMIT,"",w_LOCKMIT,i);
        w_NOAPPLIC = false;
        w_NOAPPLIC = CPLib.GetProperty(p_NOAPPLIC,"",w_NOAPPLIC,i);
        w_DESCRI_layer = "";
        w_DESCRI_layer = CPLib.GetProperty(p_DESCRI_layer,"",w_DESCRI_layer,i);
        w_open_layer = false;
        w_open_layer = CPLib.GetProperty(p_open_layer,"",w_open_layer,i);
        w_write_layer = false;
        w_write_layer = CPLib.GetProperty(p_write_layer,"",w_write_layer,i);
        aosdt_sub_ind_def = new aosdt_sub_ind_defBO(m_Ctx);
        m_cWv_aosdt_sub_ind_def = "";
        m_cWv_aosdt_sub_ind_def = CPLib.GetProperty(p_m_cWv_aosdt_sub_ind_def,"",m_cWv_aosdt_sub_ind_def,i);
        opk_IDIND = CPLib.GetProperty(p_opk_IDIND,"","",i);
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
    if (CPLib.eq(p_cName,"IDMOD")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"show_noapplic")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"IDIND")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"PROGIND")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DESCRI")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"LOCKMIT")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"NOAPPLIC")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DESCRI_layer")) {
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
    map = new HashMap<String,String[]>();
    items = tables.get("sub_ind_def");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("sub_ind_def",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDMOD","IDIND"});
    map.put("rd_var",new String[]{"w_IDMOD","w_IDIND"});
    map.put("wr_var",new String[]{"w_IDMOD","w_IDIND"});
    map.put("wr_field",new String[]{"IDMOD","IDIND"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("L",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("1",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Mostra i non applicabile",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("sub_ind_def\u0000false\u0000false\u00001\u00000\u0000aosdt_sub_ind_def\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("aosdt_ind_def",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_ind_def",child);
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
    for(String child : CPLib.LoadableMNTs("aosdt_ind_def",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_ind_def",child);
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
    aosdt_sub_ind_def = new aosdt_sub_ind_defBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("aosdt_ind_def",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    if (( ! (Check_VGASZRXNOJ(true))) && FullRow()) {
      l_bResult = false;
    } else {
      l_bResult = true;
    }
    if ( ! (CPLib.Empty(w_IDIND))) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
    }
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
      l_Keys = new String[]{"aosdt_ind_def"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"aosdt_ind_def\\"+p_cState};
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
    l_bResult =  ! (w_LOCKMIT);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "'Impossibile cancellare un Indicatore standard'";
    }
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_show_noapplic = false;
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
    Properties p_IDIND;
    p_IDIND = new Properties();
    Properties p_PROGIND;
    p_PROGIND = new Properties();
    Properties p_DESCRI;
    p_DESCRI = new Properties();
    Properties p_LOCKMIT;
    p_LOCKMIT = new Properties();
    Properties p_NOAPPLIC;
    p_NOAPPLIC = new Properties();
    Properties p_DESCRI_layer;
    p_DESCRI_layer = new Properties();
    Properties p_open_layer;
    p_open_layer = new Properties();
    Properties p_write_layer;
    p_write_layer = new Properties();
    Properties p_m_cWv_aosdt_sub_ind_def;
    p_m_cWv_aosdt_sub_ind_def = new Properties();
    Properties p_opk_IDIND;
    p_opk_IDIND = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"IDMOD",w_IDMOD,0);
    CPLib.PutProperty(p,"show_noapplic",w_show_noapplic,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_IDIND,"",w_IDIND,trsrow);
      CPLib.PutProperty(p_PROGIND,"",w_PROGIND,trsrow);
      CPLib.PutProperty(p_DESCRI,"",w_DESCRI,trsrow);
      CPLib.PutProperty(p_LOCKMIT,"",w_LOCKMIT,trsrow);
      CPLib.PutProperty(p_NOAPPLIC,"",w_NOAPPLIC,trsrow);
      CPLib.PutProperty(p_DESCRI_layer,"",w_DESCRI_layer,trsrow);
      CPLib.PutProperty(p_open_layer,"",w_open_layer,trsrow);
      CPLib.PutProperty(p_write_layer,"",w_write_layer,trsrow);
      if (p_bGetChildren) {
        if (aosdt_sub_ind_def.IsUpdated()) {
          m_cWv_aosdt_sub_ind_def = aosdt_sub_ind_def.GetContext();
        }
        CPLib.PutProperty(p_m_cWv_aosdt_sub_ind_def,"",m_cWv_aosdt_sub_ind_def,trsrow);
      }
      CPLib.PutProperty(p_opk_IDIND,"",opk_IDIND,trsrow);
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
      CPLib.PutProperty(p_IDIND,"",w_IDIND,trsrow);
      CPLib.PutProperty(p_PROGIND,"",w_PROGIND,trsrow);
      CPLib.PutProperty(p_DESCRI,"",w_DESCRI,trsrow);
      CPLib.PutProperty(p_LOCKMIT,"",w_LOCKMIT,trsrow);
      CPLib.PutProperty(p_NOAPPLIC,"",w_NOAPPLIC,trsrow);
      CPLib.PutProperty(p_DESCRI_layer,"",w_DESCRI_layer,trsrow);
      CPLib.PutProperty(p_open_layer,"",w_open_layer,trsrow);
      CPLib.PutProperty(p_write_layer,"",w_write_layer,trsrow);
      if (p_bGetChildren) {
        if (aosdt_sub_ind_def.IsUpdated()) {
          m_cWv_aosdt_sub_ind_def = aosdt_sub_ind_def.GetContext();
        }
        CPLib.PutProperty(p_m_cWv_aosdt_sub_ind_def,"",m_cWv_aosdt_sub_ind_def,trsrow);
      }
      CPLib.PutProperty(p_opk_IDIND,"",opk_IDIND,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("m_cWv_aosdt_sub_ind_def",CPLib.ToProperties(p_m_cWv_aosdt_sub_ind_def));
    trs_p.setProperty("IDIND",CPLib.ToProperties(p_IDIND));
    trs_p.setProperty("PROGIND",CPLib.ToProperties(p_PROGIND));
    trs_p.setProperty("DESCRI",CPLib.ToProperties(p_DESCRI));
    trs_p.setProperty("LOCKMIT",CPLib.ToProperties(p_LOCKMIT));
    trs_p.setProperty("NOAPPLIC",CPLib.ToProperties(p_NOAPPLIC));
    trs_p.setProperty("DESCRI_layer",CPLib.ToProperties(p_DESCRI_layer));
    trs_p.setProperty("open_layer",CPLib.ToProperties(p_open_layer));
    trs_p.setProperty("write_layer",CPLib.ToProperties(p_write_layer));
    trs_p.setProperty("opk_IDIND",CPLib.ToProperties(p_opk_IDIND));
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
    return "ind_def"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDMOD","C",10,0));
  }
  public String RowPrimaryKey() {
    return "ind_def"+"\\"+CPLib.ToCPStr(w_IDIND);
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
  public boolean ChildExists_aosdt_sub_ind_def() {
    if (aosdt_sub_ind_def.IsUpdated() || (CPLib.IsUpdated(m_cWv_aosdt_sub_ind_def) || CPLib.IsLoaded(m_cWv_aosdt_sub_ind_def))) {
      return true;
    } else if (m_bLoaded &&  ! (aosdt_sub_ind_def.m_bLoaded)) {
      aosdt_sub_ind_def.Blank();
      aosdt_sub_ind_def.w_IDMOD = w_IDMOD;
      aosdt_sub_ind_def.w_IDIND = w_IDIND;
      if (CPLib.ne(RowStatus(),"A")) {
        aosdt_sub_ind_def.Load();
      }
    }
    return aosdt_sub_ind_def.m_bLoaded;
  }
  public void CtxLoad_aosdt_sub_ind_def() {
    if ( ! (aosdt_sub_ind_def.m_lCtxLoaded)) {
      aosdt_sub_ind_def.Blank();
    }
    aosdt_sub_ind_def.m_lCtxLoaded = true;
    if ( ! (aosdt_sub_ind_def.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_aosdt_sub_ind_def) || CPLib.IsLoaded(m_cWv_aosdt_sub_ind_def)) {
        aosdt_sub_ind_def.SetFromContext(m_cWv_aosdt_sub_ind_def);
        m_cWv_aosdt_sub_ind_def = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (aosdt_sub_ind_def.m_bLoaded)) {
          aosdt_sub_ind_def.Blank();
          aosdt_sub_ind_def.w_IDMOD = w_IDMOD;
          aosdt_sub_ind_def.w_IDIND = w_IDIND;
          if (CPLib.ne(RowStatus(),"A")) {
            aosdt_sub_ind_def.Load();
          }
          if ( ! (aosdt_sub_ind_def.m_bLoaded)) {
            aosdt_sub_ind_def.Initialize();
            aosdt_sub_ind_def.SetUpdated();
          }
          CopyWorkVar(this,aosdt_sub_ind_def,new String[]{"show_noapplic"},new String[]{"show_noapplic"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,aosdt_sub_ind_def,new String[]{"show_noapplic"},new String[]{"show_noapplic"},true);
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"aosdt_sub_ind_def")) {
      CtxLoad_aosdt_sub_ind_def();
      return aosdt_sub_ind_def;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  protected void TrsToWork() {
    w_IDIND= m_oTrs.get(m_nCurrentRow).w_IDIND;
    w_PROGIND= m_oTrs.get(m_nCurrentRow).w_PROGIND;
    w_DESCRI= m_oTrs.get(m_nCurrentRow).w_DESCRI;
    w_LOCKMIT= m_oTrs.get(m_nCurrentRow).w_LOCKMIT;
    w_NOAPPLIC= m_oTrs.get(m_nCurrentRow).w_NOAPPLIC;
    w_DESCRI_layer= m_oTrs.get(m_nCurrentRow).w_DESCRI_layer;
    w_open_layer= m_oTrs.get(m_nCurrentRow).w_open_layer;
    w_write_layer= m_oTrs.get(m_nCurrentRow).w_write_layer;
    opk_IDIND= m_oTrs.get(m_nCurrentRow).opk_IDIND;
    m_cWv_aosdt_sub_ind_def= m_oTrs.get(m_nCurrentRow).m_cWv_aosdt_sub_ind_def;
    aosdt_sub_ind_def= m_oTrs.get(m_nCurrentRow).aosdt_sub_ind_def;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_IDIND=w_IDIND;
    m_oTrs.get(m_nCurrentRow).w_PROGIND=w_PROGIND;
    m_oTrs.get(m_nCurrentRow).w_DESCRI=w_DESCRI;
    m_oTrs.get(m_nCurrentRow).w_LOCKMIT=w_LOCKMIT;
    m_oTrs.get(m_nCurrentRow).w_NOAPPLIC=w_NOAPPLIC;
    m_oTrs.get(m_nCurrentRow).w_DESCRI_layer=w_DESCRI_layer;
    m_oTrs.get(m_nCurrentRow).w_open_layer=w_open_layer;
    m_oTrs.get(m_nCurrentRow).w_write_layer=w_write_layer;
    m_oTrs.get(m_nCurrentRow).opk_IDIND=opk_IDIND;
    m_oTrs.get(m_nCurrentRow).m_cWv_aosdt_sub_ind_def=m_cWv_aosdt_sub_ind_def;
    m_oTrs.get(m_nCurrentRow).aosdt_sub_ind_def=aosdt_sub_ind_def;
    CPLib.WorkToTrsMNTs(m_MNTs,work_children);
    m_oTrs.get(m_nCurrentRow).work_children=CPLib.GetClone(work_children);
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
    m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public void AddRow() {
    /*  Inizializzazione di una nuova riga del transitorio.
                                Questo metodo pubblico viene chiamato quando c'� la richiesta dall'interfaccia
                                di aggiungere una riga nella movimentazione.
                              */
    m_nRowStatus = 2;
    m_nCurrentRow = Rows();
    boolean l_bTmpRes;
    // Inizializzazione delle variabili di work al loro valore di blank
    w_IDIND = "";
    w_PROGIND = "";
    w_DESCRI = "";
    w_LOCKMIT = false;
    w_NOAPPLIC = false;
    w_DESCRI_layer = "";
    w_open_layer = false;
    w_write_layer = false;
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    w_IDIND = LibreriaMit.UniqueId();
    w_NOAPPLIC = false;
    w_DESCRI_layer = w_DESCRI;
    w_open_layer = false;
    w_write_layer = true;
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    m_cOldRowCPCCCHK = "";
    // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
    if (CPLib.gt(Rows(),0)) {
      m_cWv_aosdt_sub_ind_def = "";
    }
    SaveDependsOn();
    AppendRow();
  }
  public boolean SetRow(double p_nRowNumberToSet) {
    /*  Impostazione delle variabili di work ad una riga del transitorio.
                                Se la riga richiesta � nuova, viene chiamata una inizializzazione.
                                Se la riga richiesta � pi� grande della dimensione del transitorio + 1,
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
    if (CPLib.gt(Rows(),0)) {
      aosdt_sub_ind_def = new aosdt_sub_ind_defBO(m_Ctx);
    }
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
    m_oDeletedRows.get(l_nRows).w_IDIND=w_IDIND;
    m_oDeletedRows.get(l_nRows).w_PROGIND=w_PROGIND;
    m_oDeletedRows.get(l_nRows).w_DESCRI=w_DESCRI;
    m_oDeletedRows.get(l_nRows).w_LOCKMIT=w_LOCKMIT;
    m_oDeletedRows.get(l_nRows).w_NOAPPLIC=w_NOAPPLIC;
    m_oDeletedRows.get(l_nRows).w_DESCRI_layer=w_DESCRI_layer;
    m_oDeletedRows.get(l_nRows).w_open_layer=w_open_layer;
    m_oDeletedRows.get(l_nRows).w_write_layer=w_write_layer;
    m_oDeletedRows.get(l_nRows).opk_IDIND=opk_IDIND;
    m_oDeletedRows.get(l_nRows).m_cWv_aosdt_sub_ind_def=m_cWv_aosdt_sub_ind_def;
    m_oDeletedRows.get(l_nRows).aosdt_sub_ind_def=aosdt_sub_ind_def;
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
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("Indicatore di anaomalia incompleto");
      l_bResult = false;
    } else {
      if (l_bResult && (( ! (aosdt_sub_ind_def.m_bLoaded) && CPLib.IsLoaded(m_cWv_aosdt_sub_ind_def)) || ( ! (aosdt_sub_ind_def.m_bUpdated) && CPLib.IsUpdated(m_cWv_aosdt_sub_ind_def)))) {
        aosdt_sub_ind_def.SetFromContext(m_cWv_aosdt_sub_ind_def);
        m_cWv_aosdt_sub_ind_def = "_not_empty_";
      }
      if (l_bResult && (aosdt_sub_ind_def.m_bLoaded || aosdt_sub_ind_def.m_bUpdated)) {
        l_bResult = l_bResult && aosdt_sub_ind_def.Check();
        l_bNoCheck = l_bResult;
        if ( ! (l_bNoCheck)) {
          m_cLastMsgError = aosdt_sub_ind_def.m_cLastMsgError;
        }
      }
      if ( ! (l_bNoCheck)) {
        m_nLastError = 2;
      }
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
      aosdt_sub_ind_def = new aosdt_sub_ind_defBO(m_Ctx);
      m_cWv_aosdt_sub_ind_def = "";
    }
    m_bUpdated = true;
    // Esecuzione dei calcoli
    Calculate();
    return true;
  }
  void SubtractTotals() {
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_IDIND));
  }
  void SetModified() {
    /*  Segna la riga corrente del transitorio come modificata se non � una riga aggiunta
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
    w_IDIND= m_oDeletedRows.get(l_RowNumberToSet).w_IDIND;
    w_PROGIND= m_oDeletedRows.get(l_RowNumberToSet).w_PROGIND;
    w_DESCRI= m_oDeletedRows.get(l_RowNumberToSet).w_DESCRI;
    w_LOCKMIT= m_oDeletedRows.get(l_RowNumberToSet).w_LOCKMIT;
    w_NOAPPLIC= m_oDeletedRows.get(l_RowNumberToSet).w_NOAPPLIC;
    w_DESCRI_layer= m_oDeletedRows.get(l_RowNumberToSet).w_DESCRI_layer;
    w_open_layer= m_oDeletedRows.get(l_RowNumberToSet).w_open_layer;
    w_write_layer= m_oDeletedRows.get(l_RowNumberToSet).w_write_layer;
    opk_IDIND= m_oDeletedRows.get(l_RowNumberToSet).opk_IDIND;
    m_cWv_aosdt_sub_ind_def= m_oDeletedRows.get(l_RowNumberToSet).m_cWv_aosdt_sub_ind_def;
    aosdt_sub_ind_def= m_oDeletedRows.get(l_RowNumberToSet).aosdt_sub_ind_def;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
