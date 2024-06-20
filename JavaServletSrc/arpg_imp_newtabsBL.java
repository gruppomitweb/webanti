import java.util.*;

public class arpg_imp_newtabsBL extends arpg_imp_newtabsWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "arpg_imp_newtabs";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'tbcitta':tbcitta,'tbsetsin':tbsetsin,'tbcauana':tbcauana,'inter2bo':inter2bo,'tbvalute':tbvalute,'tbtipreg':tbtipreg,'tbstati':tbstati,'tbtipint':tbtipint,'tbesitoage':tbesitoage,'tbrapp':tbrapp,'tbstgru':tbstgru,'tbramgru':tbramgru,'tbtipdoc':tbtipdoc,'tbtipleg':tbtipleg,'tbtipnat':tbtipnat,'tberrorisid':tberrorisid,'tberrsiddgn':tberrsiddgn,'tbricevutesid':tbricevutesid,'tbcittna':tbcittna,'tbstatna':tbstatna,'tberrdge':tberrdge,'tbprvreg':tbprvreg,'tbesielb':tbesielb,'convgio':convgio,'staticrs':staticrs,'tbcandistr':tbcandistr,'tbluonas':tbluonas,'tbprovsv':tbprovsv,'rapogg':rapogg}";
  public static final String i_CompleteStateStructure = "{'gFlgWU':gFlgWU,'tbcitta':tbcitta,'tbsetsin':tbsetsin,'tbcauana':tbcauana,'inter2bo':inter2bo,'tbvalute':tbvalute,'tbtipreg':tbtipreg,'tbstati':tbstati,'tbtipint':tbtipint,'tbesitoage':tbesitoage,'tbrapp':tbrapp,'tbstgru':tbstgru,'tbramgru':tbramgru,'tbtipdoc':tbtipdoc,'tbtipleg':tbtipleg,'tbtipnat':tbtipnat,'tberrorisid':tberrorisid,'tberrsiddgn':tberrsiddgn,'tbricevutesid':tbricevutesid,'tbcittna':tbcittna,'tbstatna':tbstatna,'tberrdge':tberrdge,'tbprvreg':tbprvreg,'tbesielb':tbesielb,'convgio':convgio,'staticrs':staticrs,'tbcandistr':tbcandistr,'tbluonas':tbluonas,'tbprovsv':tbprovsv,'rapogg':rapogg}";
  public static final String i_ItemSequence = "tbcitta,tbsetsin,tbcauana,inter2bo,tbvalute,tbtipreg,tbstati,tbtipint,tbesitoage,tbrapp,tbstgru,tbramgru,tbtipdoc,tbtipleg,tbtipnat,tberrorisid,tberrsiddgn,tbricevutesid,tbcittna,tbstatna,tberrdge,tbprvreg,tbesielb,convgio,staticrs,tbcandistr,tbluonas,tbprovsv,rapogg";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"tbcitta","","C","1","0","variabile","nokey","false","false"},new String[]{"tbsetsin","","C","1","0","variabile","nokey","false","false"},new String[]{"tbcauana","","C","1","0","variabile","nokey","false","false"},new String[]{"inter2bo","","C","1","0","variabile","nokey","false","false"},new String[]{"tbvalute","","C","1","0","variabile","nokey","false","false"},new String[]{"tbtipreg","","C","1","0","variabile","nokey","false","false"},new String[]{"tbstati","","C","1","0","variabile","nokey","false","false"},new String[]{"tbtipint","","C","1","0","variabile","nokey","false","false"},new String[]{"tbesitoage","","C","1","0","variabile","nokey","false","false"},new String[]{"tbrapp","","C","1","0","variabile","nokey","false","false"},new String[]{"tbstgru","","C","1","0","variabile","nokey","false","false"},new String[]{"tbramgru","","C","1","0","variabile","nokey","false","false"},new String[]{"tbtipdoc","","C","1","0","variabile","nokey","false","false"},new String[]{"tbtipleg","","C","1","0","variabile","nokey","false","false"},new String[]{"tbtipnat","","C","1","0","variabile","nokey","false","false"},new String[]{"tberrorisid","","C","1","0","variabile","nokey","false","false"},new String[]{"tberrsiddgn","","C","1","0","variabile","nokey","false","false"},new String[]{"tbricevutesid","","C","1","0","variabile","nokey","false","false"},new String[]{"tbcittna","","C","1","0","variabile","nokey","false","false"},new String[]{"tbstatna","","C","1","0","variabile","nokey","false","false"},new String[]{"tberrdge","","C","1","0","variabile","nokey","false","false"},new String[]{"tbprvreg","","C","1","0","variabile","nokey","false","false"},new String[]{"tbesielb","","C","1","0","variabile","nokey","false","false"},new String[]{"convgio","","C","1","0","variabile","nokey","false","false"},new String[]{"staticrs","","C","1","0","variabile","nokey","false","false"},new String[]{"tbcandistr","","C","1","0","variabile","nokey","false","false"},new String[]{"tbluonas","","C","1","0","variabile","nokey","false","false"},new String[]{"tbprovsv","","C","1","0","variabile","nokey","false","false"},new String[]{"rapogg","","C","1","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_imp_newtabsBL (CPContext p_ContextObject) {
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
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_tbcitta = "N";
    w_tbsetsin = "N";
    w_tbcauana = "N";
    w_inter2bo = "N";
    w_tbvalute = "N";
    w_tbtipreg = "N";
    w_tbstati = "N";
    w_tbtipint = "N";
    w_tbesitoage = "N";
    w_tbrapp = "N";
    w_tbstgru = "N";
    w_tbramgru = "N";
    w_tbtipdoc = "N";
    w_tbtipleg = "N";
    w_tbtipnat = "N";
    w_tberrorisid = "N";
    w_tberrsiddgn = "N";
    w_tbricevutesid = "N";
    w_tbcittna = "N";
    w_tbstatna = "N";
    w_tberrdge = "N";
    w_tbprvreg = "N";
    w_tbesielb = "N";
    w_convgio = "N";
    w_staticrs = "N";
    w_tbcandistr = "N";
    w_tbluonas = "N";
    w_tbprovsv = "N";
    w_rapogg = "N";
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
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_tbcitta(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbcitta = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbsetsin(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbsetsin = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbcauana(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbcauana = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_inter2bo(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_inter2bo = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbvalute(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbvalute = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbtipreg(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbtipreg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbstati(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbstati = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbtipint(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbtipint = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbesitoage(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbesitoage = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbrapp(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbrapp = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbstgru(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbstgru = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbramgru(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbramgru = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbtipdoc(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbtipdoc = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbtipleg(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbtipleg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbtipnat(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbtipnat = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tberrorisid(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tberrorisid = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tberrsiddgn(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tberrsiddgn = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbricevutesid(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbricevutesid = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbcittna(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbcittna = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbstatna(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbstatna = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tberrdge(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tberrdge = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbprvreg(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbprvreg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbesielb(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbesielb = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_convgio(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_convgio = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_staticrs(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_staticrs = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbcandistr(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbcandistr = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbluonas(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbluonas = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tbprovsv(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tbprovsv = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_rapogg(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_rapogg = p_workVariableValue;
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
    m_bCalculating = false;
    return l_bResult;
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_imp_newtabs","",m_KeyColumns,m_Ctx);
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
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_tbcitta = CPLib.GetProperty(p,"tbcitta",w_tbcitta,0);
      w_tbsetsin = CPLib.GetProperty(p,"tbsetsin",w_tbsetsin,0);
      w_tbcauana = CPLib.GetProperty(p,"tbcauana",w_tbcauana,0);
      w_inter2bo = CPLib.GetProperty(p,"inter2bo",w_inter2bo,0);
      w_tbvalute = CPLib.GetProperty(p,"tbvalute",w_tbvalute,0);
      w_tbtipreg = CPLib.GetProperty(p,"tbtipreg",w_tbtipreg,0);
      w_tbstati = CPLib.GetProperty(p,"tbstati",w_tbstati,0);
      w_tbtipint = CPLib.GetProperty(p,"tbtipint",w_tbtipint,0);
      w_tbesitoage = CPLib.GetProperty(p,"tbesitoage",w_tbesitoage,0);
      w_tbrapp = CPLib.GetProperty(p,"tbrapp",w_tbrapp,0);
      w_tbstgru = CPLib.GetProperty(p,"tbstgru",w_tbstgru,0);
      w_tbramgru = CPLib.GetProperty(p,"tbramgru",w_tbramgru,0);
      w_tbtipdoc = CPLib.GetProperty(p,"tbtipdoc",w_tbtipdoc,0);
      w_tbtipleg = CPLib.GetProperty(p,"tbtipleg",w_tbtipleg,0);
      w_tbtipnat = CPLib.GetProperty(p,"tbtipnat",w_tbtipnat,0);
      w_tberrorisid = CPLib.GetProperty(p,"tberrorisid",w_tberrorisid,0);
      w_tberrsiddgn = CPLib.GetProperty(p,"tberrsiddgn",w_tberrsiddgn,0);
      w_tbricevutesid = CPLib.GetProperty(p,"tbricevutesid",w_tbricevutesid,0);
      w_tbcittna = CPLib.GetProperty(p,"tbcittna",w_tbcittna,0);
      w_tbstatna = CPLib.GetProperty(p,"tbstatna",w_tbstatna,0);
      w_tberrdge = CPLib.GetProperty(p,"tberrdge",w_tberrdge,0);
      w_tbprvreg = CPLib.GetProperty(p,"tbprvreg",w_tbprvreg,0);
      w_tbesielb = CPLib.GetProperty(p,"tbesielb",w_tbesielb,0);
      w_convgio = CPLib.GetProperty(p,"convgio",w_convgio,0);
      w_staticrs = CPLib.GetProperty(p,"staticrs",w_staticrs,0);
      w_tbcandistr = CPLib.GetProperty(p,"tbcandistr",w_tbcandistr,0);
      w_tbluonas = CPLib.GetProperty(p,"tbluonas",w_tbluonas,0);
      w_tbprovsv = CPLib.GetProperty(p,"tbprovsv",w_tbprovsv,0);
      w_rapogg = CPLib.GetProperty(p,"rapogg",w_rapogg,0);
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
