import java.util.*;

public class armt_cgo_qadv_operazioni_storicoBL extends armt_cgo_qadv_operazioni_storicoWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_cgo_qadv_operazioni_storico";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_qadv_operazioni_storico;
  public String m_cServer_cgo_qadv_operazioni_storico;
  public CPPhTableWrInfo m_oWrInfo_cgo_qadv_operazioni_storico;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_qadv_operazioni_storico;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_qadv_operazioni_storico"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'QADV_DOMANDA01':QADV_DOMANDA01,'QADV_DOMANDA02':QADV_DOMANDA02,'QADV_DOMANDA03':QADV_DOMANDA03,'QADV_DOMANDA03_1':QADV_DOMANDA03_1,'QADV_DOMANDA03_2':QADV_DOMANDA03_2,'QADV_DOMANDA03_3':QADV_DOMANDA03_3,'QADV_MOTIVO03':QADV_MOTIVO03,'QADV_DOMANDA04':QADV_DOMANDA04,'QADV_DOMANDA04_1':QADV_DOMANDA04_1,'QADV_DOMANDA04_2':QADV_DOMANDA04_2,'QADV_DOMANDA04_3':QADV_DOMANDA04_3,'QADV_DOMANDA04_4':QADV_DOMANDA04_4,'QADV_DOMANDA05':QADV_DOMANDA05,'QADV_MOTIVO05':QADV_MOTIVO05,'QADV_DOMANDA06':QADV_DOMANDA06,'QADV_DOMANDA07':QADV_DOMANDA07,'QADV_DOMANDA08':QADV_DOMANDA08,'QADV_DOMANDA09':QADV_DOMANDA09,'QADV_DOMANDA10':QADV_DOMANDA10,'QADV_DOMANDA11':QADV_DOMANDA11,'QADV_DOMANDA12':QADV_DOMANDA12,'SNAINUMOPE':SNAINUMOPE,'QADV_MOTIVO04':QADV_MOTIVO04,'QADV_FLGCOMPLETO':QADV_FLGCOMPLETO"+FoundlingChildrenList("armt_cgo_qadv_operazioni_storico",true)+"}";
  public static final String i_CompleteStateStructure = "{'QADV_DOMANDA01':QADV_DOMANDA01,'QADV_DOMANDA02':QADV_DOMANDA02,'QADV_DOMANDA03':QADV_DOMANDA03,'QADV_DOMANDA03_1':QADV_DOMANDA03_1,'QADV_DOMANDA03_2':QADV_DOMANDA03_2,'QADV_DOMANDA03_3':QADV_DOMANDA03_3,'QADV_MOTIVO03':QADV_MOTIVO03,'QADV_DOMANDA04':QADV_DOMANDA04,'QADV_DOMANDA04_1':QADV_DOMANDA04_1,'QADV_DOMANDA04_2':QADV_DOMANDA04_2,'QADV_DOMANDA04_3':QADV_DOMANDA04_3,'QADV_DOMANDA04_4':QADV_DOMANDA04_4,'QADV_DOMANDA05':QADV_DOMANDA05,'QADV_MOTIVO05':QADV_MOTIVO05,'QADV_DOMANDA06':QADV_DOMANDA06,'QADV_DOMANDA07':QADV_DOMANDA07,'QADV_DOMANDA08':QADV_DOMANDA08,'QADV_DOMANDA09':QADV_DOMANDA09,'QADV_DOMANDA10':QADV_DOMANDA10,'QADV_DOMANDA11':QADV_DOMANDA11,'QADV_DOMANDA12':QADV_DOMANDA12,'SNAINUMOPE':SNAINUMOPE,'QADV_PUNTEGGIO01':QADV_PUNTEGGIO01,'QADV_PUNTEGGIO02':QADV_PUNTEGGIO02,'QADV_PUNTEGGIO03':QADV_PUNTEGGIO03,'QADV_PUNTEGGIO04':QADV_PUNTEGGIO04,'QADV_MOTIVO04':QADV_MOTIVO04,'QADV_PUNTEGGIO05':QADV_PUNTEGGIO05,'QADV_PUNTEGGIO06':QADV_PUNTEGGIO06,'QADV_PUNTEGGIO07':QADV_PUNTEGGIO07,'QADV_PUNTEGGIO08':QADV_PUNTEGGIO08,'QADV_PUNTEGGIO09':QADV_PUNTEGGIO09,'QADV_PUNTEGGIO10':QADV_PUNTEGGIO10,'QADV_PUNTEGGIO11':QADV_PUNTEGGIO11,'QADV_PUNTEGGIO12':QADV_PUNTEGGIO12,'QADV_FLGCOMPLETO':QADV_FLGCOMPLETO,'QADV_TOTALE':QADV_TOTALE"+FoundlingChildrenList("armt_cgo_qadv_operazioni_storico",true)+"}";
  public static final String i_ItemSequence = "QADV_DOMANDA01,QADV_DOMANDA02,QADV_DOMANDA03,QADV_DOMANDA03_1,QADV_DOMANDA03_2,QADV_DOMANDA03_3,QADV_MOTIVO03,QADV_DOMANDA04,QADV_DOMANDA04_1,QADV_DOMANDA04_2,QADV_DOMANDA04_3,QADV_DOMANDA04_4,QADV_DOMANDA05,QADV_MOTIVO05,QADV_DOMANDA06,QADV_DOMANDA07,QADV_DOMANDA08,QADV_DOMANDA09,QADV_DOMANDA10,QADV_DOMANDA11,QADV_DOMANDA12,SNAINUMOPE,QADV_MOTIVO04,QADV_FLGCOMPLETO"+FoundlingChildrenList("armt_cgo_qadv_operazioni_storico",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_qadv_operazioni_storico"),new String[][]{new String[]{"QADV_DOMANDA01","Domanda 1","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA02","Domanda 2","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA03","Domanda 3","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA03_1","Motivo No 1","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA03_2","Motivo No 2","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA03_3","Motivo No 3","C","1","0","campo","nokey","false","false"},new String[]{"QADV_MOTIVO03","Motivo Risposta 3","M","10","0","campo","nokey","false","true"},new String[]{"QADV_DOMANDA04","Domanda 4","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA04_1","Motivo No 1","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA04_2","Motivo No2","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA04_3","Motivo No 3","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA04_4","Motivo No 4","C","1","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA05","Domanda 5","N","2","0","campo","nokey","false","false"},new String[]{"QADV_MOTIVO05","Motivo Risposta 4","M","10","0","campo","nokey","false","true"},new String[]{"QADV_DOMANDA06","Domanda 6","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA07","Domanda 7","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA08","Domanda 8","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA09","Domanda 9","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA10","Domanda 10","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA11","Domanda 11","N","2","0","campo","nokey","false","false"},new String[]{"QADV_DOMANDA12","Domanda 12","N","2","0","campo","nokey","false","false"},new String[]{"SNAINUMOPE","N. Operazione","C","15","0","campo","key1","false","false"},new String[]{"QADV_MOTIVO04","Motivo Risposta 4","M","10","0","campo","nokey","false","true"},new String[]{"QADV_FLGCOMPLETO","Questionario Completo","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_qadv_operazioni_storicoBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_qadv_operazioni_storico = p_ContextObject.GetPhName("cgo_qadv_operazioni_storico",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_qadv_operazioni_storico = p_ContextObject.GetServer("cgo_qadv_operazioni_storico");
    m_oWrInfo_cgo_qadv_operazioni_storico = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_qadv_operazioni_storico",p_ContextObject.GetCompany());
    m_cVirtName_cgo_qadv_operazioni_storico = CPSql.ManipulateTablePhName("cgo_qadv_operazioni_storico",m_cServer_cgo_qadv_operazioni_storico);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_cgo_qadv_operazioni_storico",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_QADV_DOMANDA01 = 0;
    w_QADV_DOMANDA02 = 0;
    w_QADV_DOMANDA03 = 0;
    w_QADV_MOTIVO03 = "";
    w_QADV_DOMANDA04 = 0;
    w_QADV_DOMANDA05 = 0;
    w_QADV_MOTIVO05 = "";
    w_QADV_DOMANDA06 = 0;
    w_QADV_DOMANDA07 = 0;
    w_QADV_DOMANDA08 = 0;
    w_QADV_DOMANDA09 = 0;
    w_QADV_DOMANDA10 = 0;
    w_QADV_DOMANDA11 = 0;
    w_QADV_DOMANDA12 = 0;
    w_SNAINUMOPE = "";
    w_QADV_PUNTEGGIO01 = 0;
    w_QADV_PUNTEGGIO02 = 0;
    w_QADV_PUNTEGGIO03 = 0;
    w_QADV_PUNTEGGIO04 = 0;
    w_QADV_MOTIVO04 = "";
    w_QADV_PUNTEGGIO05 = 0;
    w_QADV_PUNTEGGIO06 = 0;
    w_QADV_PUNTEGGIO07 = 0;
    w_QADV_PUNTEGGIO08 = 0;
    w_QADV_PUNTEGGIO09 = 0;
    w_QADV_PUNTEGGIO10 = 0;
    w_QADV_PUNTEGGIO11 = 0;
    w_QADV_PUNTEGGIO12 = 0;
    w_QADV_DOMANDA03_1 = "N";
    w_QADV_DOMANDA03_2 = "N";
    w_QADV_DOMANDA03_3 = "N";
    w_QADV_DOMANDA04_1 = "N";
    w_QADV_DOMANDA04_2 = "N";
    w_QADV_DOMANDA04_3 = "N";
    w_QADV_DOMANDA04_4 = "N";
    w_QADV_FLGCOMPLETO = "N";
    w_QADV_TOTALE = 0;
    w_QADV_TOTALE = w_QADV_PUNTEGGIO01+w_QADV_PUNTEGGIO02+w_QADV_PUNTEGGIO03+w_QADV_PUNTEGGIO04+w_QADV_PUNTEGGIO05+w_QADV_PUNTEGGIO06+w_QADV_PUNTEGGIO07+w_QADV_PUNTEGGIO08+w_QADV_PUNTEGGIO09+w_QADV_PUNTEGGIO10+w_QADV_PUNTEGGIO11+w_QADV_PUNTEGGIO12;
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
  public boolean Set_QADV_DOMANDA01(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA01 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA02(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA02 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA03(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA03 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA03_1(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA03_1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA03_2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA03_2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA03_3(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA03_3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_MOTIVO03(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_MOTIVO03 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_QADV_MOTIVO03 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean HOWAZKTGQK_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_QADV_DOMANDA03_3,"S");
  }
  public boolean Set_QADV_DOMANDA04(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA04 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA04_1(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA04_1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA04_2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA04_2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA04_3(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA04_3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA04_4(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA04_4 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA05(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA05 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_MOTIVO05(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_MOTIVO05 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_QADV_MOTIVO05 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean NAOHLRJFKW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_QADV_DOMANDA05,6);
  }
  public boolean Set_QADV_DOMANDA06(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA06 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA07(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA07 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA08(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA08 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA09(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA09 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA10(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA10 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA11(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA11 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_DOMANDA12(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_DOMANDA12 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SNAINUMOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SNAINUMOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_MOTIVO04(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_MOTIVO04 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_QADV_MOTIVO04 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean IPNCGLSXHQ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_QADV_DOMANDA04_4,"S");
  }
  public boolean Set_QADV_FLGCOMPLETO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_FLGCOMPLETO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_QADV_DOMANDA08() {
    return CPLib.eq(w_QADV_DOMANDA07,6);
  }
  public boolean getWritable_QADV_FLGCOMPLETO() {
    return false;
  }
  public boolean getVisible_QADV_DOMANDA03_1() {
    return CPLib.ne(w_QADV_DOMANDA03,2);
  }
  public boolean getVisible_QADV_DOMANDA03_2() {
    return CPLib.ne(w_QADV_DOMANDA03,2);
  }
  public boolean getVisible_QADV_DOMANDA03_3() {
    return CPLib.ne(w_QADV_DOMANDA03,2);
  }
  public boolean getVisible_QADV_MOTIVO03() {
    return CPLib.ne(w_QADV_DOMANDA03_3,"S");
  }
  public boolean getVisible_QADV_DOMANDA04_1() {
    return CPLib.ne(w_QADV_DOMANDA04,1);
  }
  public boolean getVisible_QADV_DOMANDA04_2() {
    return CPLib.ne(w_QADV_DOMANDA04,1);
  }
  public boolean getVisible_QADV_DOMANDA04_3() {
    return CPLib.ne(w_QADV_DOMANDA04,1);
  }
  public boolean getVisible_QADV_DOMANDA04_4() {
    return CPLib.ne(w_QADV_DOMANDA04,1);
  }
  public boolean getVisible_QADV_MOTIVO05() {
    return CPLib.ne(w_QADV_DOMANDA05,6);
  }
  public boolean getVisible_QADV_PUNTEGGIO01() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO02() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO03() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO04() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_MOTIVO04() {
    return CPLib.eq(w_QADV_DOMANDA04_4,"N");
  }
  public boolean getVisible_QADV_PUNTEGGIO05() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO06() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO07() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO08() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO09() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO10() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO11() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_PUNTEGGIO12() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
  }
  public boolean getVisible_QADV_TOTALE() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(11)) &&  ! (Utilities.Make(m_Ctx).IsInGroup(10));
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
    w_QADV_TOTALE = w_QADV_PUNTEGGIO01+w_QADV_PUNTEGGIO02+w_QADV_PUNTEGGIO03+w_QADV_PUNTEGGIO04+w_QADV_PUNTEGGIO05+w_QADV_PUNTEGGIO06+w_QADV_PUNTEGGIO07+w_QADV_PUNTEGGIO08+w_QADV_PUNTEGGIO09+w_QADV_PUNTEGGIO10+w_QADV_PUNTEGGIO11+w_QADV_PUNTEGGIO12;
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
  public final static String[] m_KeyColumns = {"SNAINUMOPE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_qadv_operazioni_storico","cgo_qadv_operazioni_storico",m_KeyColumns,m_Ctx);
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
    w_QADV_DOMANDA01 = 0;
    w_QADV_DOMANDA02 = 0;
    w_QADV_DOMANDA03 = 0;
    w_QADV_DOMANDA03_1 = "";
    w_QADV_DOMANDA03_2 = "";
    w_QADV_DOMANDA03_3 = "";
    w_QADV_MOTIVO03 = "";
    w_QADV_DOMANDA04 = 0;
    w_QADV_DOMANDA04_1 = "";
    w_QADV_DOMANDA04_2 = "";
    w_QADV_DOMANDA04_3 = "";
    w_QADV_DOMANDA04_4 = "";
    w_QADV_DOMANDA05 = 0;
    w_QADV_MOTIVO05 = "";
    w_QADV_DOMANDA06 = 0;
    w_QADV_DOMANDA07 = 0;
    w_QADV_DOMANDA08 = 0;
    w_QADV_DOMANDA09 = 0;
    w_QADV_DOMANDA10 = 0;
    w_QADV_DOMANDA11 = 0;
    w_QADV_DOMANDA12 = 0;
    w_SNAINUMOPE = "";
    w_QADV_PUNTEGGIO01 = 0;
    w_QADV_PUNTEGGIO02 = 0;
    w_QADV_PUNTEGGIO03 = 0;
    w_QADV_PUNTEGGIO04 = 0;
    w_QADV_MOTIVO04 = "";
    w_QADV_PUNTEGGIO05 = 0;
    w_QADV_PUNTEGGIO06 = 0;
    w_QADV_PUNTEGGIO07 = 0;
    w_QADV_PUNTEGGIO08 = 0;
    w_QADV_PUNTEGGIO09 = 0;
    w_QADV_PUNTEGGIO10 = 0;
    w_QADV_PUNTEGGIO11 = 0;
    w_QADV_PUNTEGGIO12 = 0;
    w_QADV_FLGCOMPLETO = "";
    w_QADV_TOTALE = 0;
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_QADV_DOMANDA01 = CPLib.GetProperty(p,"QADV_DOMANDA01",w_QADV_DOMANDA01,0);
      w_QADV_DOMANDA02 = CPLib.GetProperty(p,"QADV_DOMANDA02",w_QADV_DOMANDA02,0);
      w_QADV_DOMANDA03 = CPLib.GetProperty(p,"QADV_DOMANDA03",w_QADV_DOMANDA03,0);
      w_QADV_DOMANDA03_1 = CPLib.GetProperty(p,"QADV_DOMANDA03_1",w_QADV_DOMANDA03_1,0);
      w_QADV_DOMANDA03_2 = CPLib.GetProperty(p,"QADV_DOMANDA03_2",w_QADV_DOMANDA03_2,0);
      w_QADV_DOMANDA03_3 = CPLib.GetProperty(p,"QADV_DOMANDA03_3",w_QADV_DOMANDA03_3,0);
      w_QADV_MOTIVO03 = CPLib.GetProperty(p,"QADV_MOTIVO03",w_QADV_MOTIVO03,0);
      w_QADV_DOMANDA04 = CPLib.GetProperty(p,"QADV_DOMANDA04",w_QADV_DOMANDA04,0);
      w_QADV_DOMANDA04_1 = CPLib.GetProperty(p,"QADV_DOMANDA04_1",w_QADV_DOMANDA04_1,0);
      w_QADV_DOMANDA04_2 = CPLib.GetProperty(p,"QADV_DOMANDA04_2",w_QADV_DOMANDA04_2,0);
      w_QADV_DOMANDA04_3 = CPLib.GetProperty(p,"QADV_DOMANDA04_3",w_QADV_DOMANDA04_3,0);
      w_QADV_DOMANDA04_4 = CPLib.GetProperty(p,"QADV_DOMANDA04_4",w_QADV_DOMANDA04_4,0);
      w_QADV_DOMANDA05 = CPLib.GetProperty(p,"QADV_DOMANDA05",w_QADV_DOMANDA05,0);
      w_QADV_MOTIVO05 = CPLib.GetProperty(p,"QADV_MOTIVO05",w_QADV_MOTIVO05,0);
      w_QADV_DOMANDA06 = CPLib.GetProperty(p,"QADV_DOMANDA06",w_QADV_DOMANDA06,0);
      w_QADV_DOMANDA07 = CPLib.GetProperty(p,"QADV_DOMANDA07",w_QADV_DOMANDA07,0);
      w_QADV_DOMANDA08 = CPLib.GetProperty(p,"QADV_DOMANDA08",w_QADV_DOMANDA08,0);
      w_QADV_DOMANDA09 = CPLib.GetProperty(p,"QADV_DOMANDA09",w_QADV_DOMANDA09,0);
      w_QADV_DOMANDA10 = CPLib.GetProperty(p,"QADV_DOMANDA10",w_QADV_DOMANDA10,0);
      w_QADV_DOMANDA11 = CPLib.GetProperty(p,"QADV_DOMANDA11",w_QADV_DOMANDA11,0);
      w_QADV_DOMANDA12 = CPLib.GetProperty(p,"QADV_DOMANDA12",w_QADV_DOMANDA12,0);
      w_SNAINUMOPE = CPLib.GetProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
      w_QADV_PUNTEGGIO01 = CPLib.GetProperty(p,"QADV_PUNTEGGIO01",w_QADV_PUNTEGGIO01,0);
      w_QADV_PUNTEGGIO02 = CPLib.GetProperty(p,"QADV_PUNTEGGIO02",w_QADV_PUNTEGGIO02,0);
      w_QADV_PUNTEGGIO03 = CPLib.GetProperty(p,"QADV_PUNTEGGIO03",w_QADV_PUNTEGGIO03,0);
      w_QADV_PUNTEGGIO04 = CPLib.GetProperty(p,"QADV_PUNTEGGIO04",w_QADV_PUNTEGGIO04,0);
      w_QADV_MOTIVO04 = CPLib.GetProperty(p,"QADV_MOTIVO04",w_QADV_MOTIVO04,0);
      w_QADV_PUNTEGGIO05 = CPLib.GetProperty(p,"QADV_PUNTEGGIO05",w_QADV_PUNTEGGIO05,0);
      w_QADV_PUNTEGGIO06 = CPLib.GetProperty(p,"QADV_PUNTEGGIO06",w_QADV_PUNTEGGIO06,0);
      w_QADV_PUNTEGGIO07 = CPLib.GetProperty(p,"QADV_PUNTEGGIO07",w_QADV_PUNTEGGIO07,0);
      w_QADV_PUNTEGGIO08 = CPLib.GetProperty(p,"QADV_PUNTEGGIO08",w_QADV_PUNTEGGIO08,0);
      w_QADV_PUNTEGGIO09 = CPLib.GetProperty(p,"QADV_PUNTEGGIO09",w_QADV_PUNTEGGIO09,0);
      w_QADV_PUNTEGGIO10 = CPLib.GetProperty(p,"QADV_PUNTEGGIO10",w_QADV_PUNTEGGIO10,0);
      w_QADV_PUNTEGGIO11 = CPLib.GetProperty(p,"QADV_PUNTEGGIO11",w_QADV_PUNTEGGIO11,0);
      w_QADV_PUNTEGGIO12 = CPLib.GetProperty(p,"QADV_PUNTEGGIO12",w_QADV_PUNTEGGIO12,0);
      w_QADV_FLGCOMPLETO = CPLib.GetProperty(p,"QADV_FLGCOMPLETO",w_QADV_FLGCOMPLETO,0);
      w_QADV_TOTALE = CPLib.GetProperty(p,"QADV_TOTALE",w_QADV_TOTALE,0);
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
    for(String child : CPLib.LoadableMNTs("armt_cgo_qadv_operazioni_storico",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_qadv_operazioni_storico",child);
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
    m_MNTs = CPLib.MNTChilds("armt_cgo_qadv_operazioni_storico",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.Empty(w_QADV_MOTIVO03) && HOWAZKTGQK_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_QADV_MOTIVO03));
      String obblMsgError = m_Ctx.Translate("Motivo Risposta 3")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_QADV_MOTIVO03 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "QADV_MOTIVO03";
      }
    } else if (CPLib.Empty(w_QADV_MOTIVO05) && NAOHLRJFKW_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_QADV_MOTIVO05));
      String obblMsgError = m_Ctx.Translate("Motivo Risposta 4")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_QADV_MOTIVO05 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "QADV_MOTIVO05";
      }
    } else if (CPLib.Empty(w_QADV_MOTIVO04) && IPNCGLSXHQ_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_QADV_MOTIVO04));
      String obblMsgError = m_Ctx.Translate("Motivo Risposta 4")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_QADV_MOTIVO04 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "QADV_MOTIVO04";
      }
    }
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
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
      l_Keys = new String[]{"armt_cgo_qadv_operazioni_storico"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_qadv_operazioni_storico\\"+p_cState};
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
    CPLib.PutProperty(p,"QADV_DOMANDA01",w_QADV_DOMANDA01,0);
    CPLib.PutProperty(p,"QADV_DOMANDA02",w_QADV_DOMANDA02,0);
    CPLib.PutProperty(p,"QADV_DOMANDA03",w_QADV_DOMANDA03,0);
    CPLib.PutProperty(p,"QADV_DOMANDA03_1",w_QADV_DOMANDA03_1,0);
    CPLib.PutProperty(p,"QADV_DOMANDA03_2",w_QADV_DOMANDA03_2,0);
    CPLib.PutProperty(p,"QADV_DOMANDA03_3",w_QADV_DOMANDA03_3,0);
    CPLib.PutProperty(p,"QADV_MOTIVO03",w_QADV_MOTIVO03,0);
    CPLib.PutProperty(p,"QADV_DOMANDA04",w_QADV_DOMANDA04,0);
    CPLib.PutProperty(p,"QADV_DOMANDA04_1",w_QADV_DOMANDA04_1,0);
    CPLib.PutProperty(p,"QADV_DOMANDA04_2",w_QADV_DOMANDA04_2,0);
    CPLib.PutProperty(p,"QADV_DOMANDA04_3",w_QADV_DOMANDA04_3,0);
    CPLib.PutProperty(p,"QADV_DOMANDA04_4",w_QADV_DOMANDA04_4,0);
    CPLib.PutProperty(p,"QADV_DOMANDA05",w_QADV_DOMANDA05,0);
    CPLib.PutProperty(p,"QADV_MOTIVO05",w_QADV_MOTIVO05,0);
    CPLib.PutProperty(p,"QADV_DOMANDA06",w_QADV_DOMANDA06,0);
    CPLib.PutProperty(p,"QADV_DOMANDA07",w_QADV_DOMANDA07,0);
    CPLib.PutProperty(p,"QADV_DOMANDA08",w_QADV_DOMANDA08,0);
    CPLib.PutProperty(p,"QADV_DOMANDA09",w_QADV_DOMANDA09,0);
    CPLib.PutProperty(p,"QADV_DOMANDA10",w_QADV_DOMANDA10,0);
    CPLib.PutProperty(p,"QADV_DOMANDA11",w_QADV_DOMANDA11,0);
    CPLib.PutProperty(p,"QADV_DOMANDA12",w_QADV_DOMANDA12,0);
    CPLib.PutProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO01",w_QADV_PUNTEGGIO01,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO02",w_QADV_PUNTEGGIO02,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO03",w_QADV_PUNTEGGIO03,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO04",w_QADV_PUNTEGGIO04,0);
    CPLib.PutProperty(p,"QADV_MOTIVO04",w_QADV_MOTIVO04,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO05",w_QADV_PUNTEGGIO05,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO06",w_QADV_PUNTEGGIO06,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO07",w_QADV_PUNTEGGIO07,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO08",w_QADV_PUNTEGGIO08,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO09",w_QADV_PUNTEGGIO09,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO10",w_QADV_PUNTEGGIO10,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO11",w_QADV_PUNTEGGIO11,0);
    CPLib.PutProperty(p,"QADV_PUNTEGGIO12",w_QADV_PUNTEGGIO12,0);
    CPLib.PutProperty(p,"QADV_FLGCOMPLETO",w_QADV_FLGCOMPLETO,0);
    CPLib.PutProperty(p,"QADV_TOTALE",w_QADV_TOTALE,0);
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
    return "cgo_qadv_operazioni_storico"+"\\"+CPLib.ToCPStr(p_Caller.GetString("SNAINUMOPE","C",15,0));
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
