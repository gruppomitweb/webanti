import java.util.*;

public class arpg_importBL extends arpg_importWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
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
  public static final String i_EntityName = "arpg_import";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
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
  public static final String i_StateStructure = "{'nomefile':nomefile,'tipodest':tipodest,'opextc':opextc,'annorif':annorif,'chkaui':chkaui,'imperr':imperr,'flgscad':flgscad,'flgaggfam':flgaggfam}";
  public static final String i_CompleteStateStructure = "{'nomefile':nomefile,'tipodest':tipodest,'impzip':impzip,'errchk':errchk,'gTelepass':gTelepass,'gFlgCMod':gFlgCMod,'opextc':opextc,'xMADESCRI':xMADESCRI,'xMAFLGRAP':xMAFLGRAP,'xMAFLGBON':xMAFLGBON,'xMAFLGCKR':xMAFLGCKR,'xMAFLGASR':xMAFLGASR,'annorif':annorif,'chkaui':chkaui,'imperr':imperr,'gAzienda':gAzienda,'gPathApp':gPathApp,'fscarti':fscarti,'xMADIPSTD':xMADIPSTD,'flgscad':flgscad,'flgaggfam':flgaggfam}";
  public static final String i_ItemSequence = "nomefile,tipodest,opextc,annorif,chkaui,imperr,flgscad,flgaggfam";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"nomefile","","C","100","0","variabile","nokey","false","false"},new String[]{"tipodest","","C","1","0","variabile","nokey","false","false"},new String[]{"opextc","","C","1","0","variabile","nokey","false","false"},new String[]{"annorif","Anno di riferimento","N","4","0","variabile","nokey","false","false"},new String[]{"chkaui","","C","1","0","variabile","nokey","false","false"},new String[]{"imperr","","C","1","0","variabile","nokey","false","false"},new String[]{"flgscad","","C","1","0","variabile","nokey","false","false"},new String[]{"flgaggfam","","C","1","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_importBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_nomefile = "";
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gFlgCMod = m_Ctx.GetGlobalString("gFlgCMod");
    w_xMADESCRI = "";
    w_xMAFLGRAP = "";
    w_xMAFLGBON = "";
    w_xMAFLGCKR = "";
    w_xMAFLGASR = "";
    w_annorif = 0;
    w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
    w_gPathApp = m_Ctx.GetGlobalString("gPathApp");
    w_fscarti = 0;
    w_xMADIPSTD = "";
    w_tipodest = "P";
    w_impzip = 0;
    w_errchk = 0;
    w_opextc = "N";
    w_chkaui = "N";
    w_imperr = "N";
    w_flgscad = "S";
    w_flgaggfam = "N";
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
    o_nomefile = w_nomefile;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_IJLORSXQBU();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_nomefile(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_nomefile = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tipodest(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipodest = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_opextc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_opextc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_annorif(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_annorif = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_chkaui(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_chkaui = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_imperr(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_imperr = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgscad(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgscad = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgaggfam(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgaggfam = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_nomefile() {
    return false;
  }
  public boolean getWritable_opextc() {
    return CPLib.eq(w_tipodest,"D");
  }
  public boolean getVisible_opextc() {
    return CPLib.ne(w_gTelepass,"5");
  }
  public boolean getVisible_annorif() {
    return CPLib.ne(w_gFlgCMod,"S");
  }
  public boolean getVisible_flgscad() {
    return CPLib.ne(w_gTelepass,"5");
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
    if (CPLib.ne(o_nomefile,w_nomefile)) {
      Calculation_UGPCNPTDJO();
    }
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
  void Calculation_UGPCNPTDJO() {
    arrt_importR l_oRoutine_arrt_import;
    l_oRoutine_arrt_import = arrt_importR.Make(m_Ctx,this);
    l_oRoutine_arrt_import.w_rfile = w_nomefile;
    l_oRoutine_arrt_import.Run();
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_import","",m_KeyColumns,m_Ctx);
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
      w_nomefile = CPLib.GetProperty(p,"nomefile",w_nomefile,0);
      w_tipodest = CPLib.GetProperty(p,"tipodest",w_tipodest,0);
      w_impzip = CPLib.GetProperty(p,"impzip",w_impzip,0);
      w_errchk = CPLib.GetProperty(p,"errchk",w_errchk,0);
      w_gTelepass = CPLib.GetProperty(p,"gTelepass",w_gTelepass,0);
      w_gFlgCMod = CPLib.GetProperty(p,"gFlgCMod",w_gFlgCMod,0);
      w_opextc = CPLib.GetProperty(p,"opextc",w_opextc,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_xMAFLGRAP = CPLib.GetProperty(p,"xMAFLGRAP",w_xMAFLGRAP,0);
      w_xMAFLGBON = CPLib.GetProperty(p,"xMAFLGBON",w_xMAFLGBON,0);
      w_xMAFLGCKR = CPLib.GetProperty(p,"xMAFLGCKR",w_xMAFLGCKR,0);
      w_xMAFLGASR = CPLib.GetProperty(p,"xMAFLGASR",w_xMAFLGASR,0);
      w_annorif = CPLib.GetProperty(p,"annorif",w_annorif,0);
      w_chkaui = CPLib.GetProperty(p,"chkaui",w_chkaui,0);
      w_imperr = CPLib.GetProperty(p,"imperr",w_imperr,0);
      w_gAzienda = CPLib.GetProperty(p,"gAzienda",w_gAzienda,0);
      w_gPathApp = CPLib.GetProperty(p,"gPathApp",w_gPathApp,0);
      w_fscarti = CPLib.GetProperty(p,"fscarti",w_fscarti,0);
      w_xMADIPSTD = CPLib.GetProperty(p,"xMADIPSTD",w_xMADIPSTD,0);
      w_flgscad = CPLib.GetProperty(p,"flgscad",w_flgscad,0);
      w_flgaggfam = CPLib.GetProperty(p,"flgaggfam",w_flgaggfam,0);
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
