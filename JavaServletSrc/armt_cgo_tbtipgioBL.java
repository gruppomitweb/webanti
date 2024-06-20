import java.util.*;

public class armt_cgo_tbtipgioBL extends armt_cgo_tbtipgioWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_cgo_tbtipgio";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public CPPhTableWrInfo m_oWrInfo_cgo_tbtipgio;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_tbtipgio;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_tbtipgio"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CODTPGIO':CODTPGIO,'DESTPGIO':DESTPGIO,'SOGTPGIO':SOGTPGIO,'EDTTPGIO':EDTTPGIO,'DEFTPGIO':DEFTPGIO,'EDTSPGIO':EDTSPGIO,'DEFSPGIO':DEFSPGIO,'FLGPLGIO':FLGPLGIO,'FLGMLGIO':FLGMLGIO,'MAGPAGGIO':MAGPAGGIO,'MINPAGGIO':MINPAGGIO,'FDC1OSGIO':FDC1OSGIO,'FDC2OSGIO':FDC2OSGIO,'FDC3OSGIO':FDC3OSGIO,'FDC4OSGIO':FDC4OSGIO,'FDC5OSGIO':FDC5OSGIO,'FDC6OSGIO':FDC6OSGIO,'FDC1SSGIO':FDC1SSGIO,'FDC2SSGIO':FDC2SSGIO,'FDC3SSGIO':FDC3SSGIO,'FDC4SSGIO':FDC4SSGIO,'FDC5SSGIO':FDC5SSGIO,'FDC6SSGIO':FDC6SSGIO,'FDC1ACGIO':FDC1ACGIO,'FDC2ACGIO':FDC2ACGIO,'FDC3ACGIO':FDC3ACGIO,'FDC4ACGIO':FDC4ACGIO,'FDC5ACGIO':FDC5ACGIO,'FDC6ACGIO':FDC6ACGIO,'NCOPAGGIO':NCOPAGGIO,'ardt_cgo_tgtiporeg':ardt_cgo_tgtiporeg,'FLTIPGIO':FLTIPGIO,'FLGATTIVO':FLGATTIVO,'IMPMINGIO':IMPMINGIO,'IMPMINTOT':IMPMINTOT"+FoundlingChildrenList("armt_cgo_tbtipgio",true)+"}";
  public static final String i_CompleteStateStructure = "{'CODTPGIO':CODTPGIO,'DESTPGIO':DESTPGIO,'SOGTPGIO':SOGTPGIO,'EDTTPGIO':EDTTPGIO,'DEFTPGIO':DEFTPGIO,'EDTSPGIO':EDTSPGIO,'DEFSPGIO':DEFSPGIO,'FLGPLGIO':FLGPLGIO,'FLGMLGIO':FLGMLGIO,'MAGPAGGIO':MAGPAGGIO,'MINPAGGIO':MINPAGGIO,'FDC1OSGIO':FDC1OSGIO,'FDC2OSGIO':FDC2OSGIO,'FDC3OSGIO':FDC3OSGIO,'FDC4OSGIO':FDC4OSGIO,'FDC5OSGIO':FDC5OSGIO,'FDC6OSGIO':FDC6OSGIO,'FDC1SSGIO':FDC1SSGIO,'FDC2SSGIO':FDC2SSGIO,'FDC3SSGIO':FDC3SSGIO,'FDC4SSGIO':FDC4SSGIO,'FDC5SSGIO':FDC5SSGIO,'FDC6SSGIO':FDC6SSGIO,'FDC1ACGIO':FDC1ACGIO,'FDC2ACGIO':FDC2ACGIO,'FDC3ACGIO':FDC3ACGIO,'FDC4ACGIO':FDC4ACGIO,'FDC5ACGIO':FDC5ACGIO,'FDC6ACGIO':FDC6ACGIO,'NCOPAGGIO':NCOPAGGIO,'ardt_cgo_tgtiporeg':ardt_cgo_tgtiporeg,'FLTIPGIO':FLTIPGIO,'FLGATTIVO':FLGATTIVO,'IMPMINGIO':IMPMINGIO,'IMPMINTOT':IMPMINTOT"+FoundlingChildrenList("armt_cgo_tbtipgio",true)+"}";
  public static final String i_ItemSequence = "CODTPGIO,DESTPGIO,SOGTPGIO,EDTTPGIO,DEFTPGIO,EDTSPGIO,DEFSPGIO,FLGPLGIO,FLGMLGIO,MAGPAGGIO,MINPAGGIO,FDC1OSGIO,FDC2OSGIO,FDC3OSGIO,FDC4OSGIO,FDC5OSGIO,FDC6OSGIO,FDC1SSGIO,FDC2SSGIO,FDC3SSGIO,FDC4SSGIO,FDC5SSGIO,FDC6SSGIO,FDC1ACGIO,FDC2ACGIO,FDC3ACGIO,FDC4ACGIO,FDC5ACGIO,FDC6ACGIO,NCOPAGGIO,ardt_cgo_tgtiporeg,FLTIPGIO,FLGATTIVO,IMPMINGIO,IMPMINTOT"+FoundlingChildrenList("armt_cgo_tbtipgio",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_tbtipgio"),new String[][]{new String[]{"CODTPGIO","Tipo Gioco","C","3","0","campo","key1","false","false"},new String[]{"DESTPGIO","Descrizione","C","50","0","campo","key2","false","false"},new String[]{"SOGTPGIO","Soglia pagamento","N","12","2","campo","nokey","false","false"},new String[]{"EDTTPGIO","Abilita modifica Scelta","C","1","0","campo","nokey","false","false"},new String[]{"DEFTPGIO","Default pagamento","C","1","0","campo","nokey","false","false"},new String[]{"EDTSPGIO","Abilita Modifica Sotto Soglia","C","1","0","campo","nokey","false","false"},new String[]{"DEFSPGIO","Default Sotto Soglia","C","1","0","campo","nokey","false","false"},new String[]{"FLGPLGIO","Abilita Selezione Piattaforma","C","1","0","campo","nokey","false","false"},new String[]{"FLGMLGIO","Inserimento Operazioni Multiple","C","1","0","campo","nokey","false","false"},new String[]{"MAGPAGGIO","N° Massimo Pagine Documento Unico o N° Max Documenti","N","2","0","campo","nokey","false","false"},new String[]{"MINPAGGIO","N° Pagine Documento Unico o N° Documenti (Importo Sotto Soglia):","N","2","0","campo","nokey","false","false"},new String[]{"FDC1OSGIO","Adeguata Verifica Sopra Soglia","C","1","0","campo","nokey","false","false"},new String[]{"FDC2OSGIO","Copia Biglietto","C","1","0","campo","nokey","false","false"},new String[]{"FDC3OSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC4OSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC5OSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC6OSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC1SSGIO","Adeguata Verifica Sopra Soglia","C","1","0","campo","nokey","false","false"},new String[]{"FDC2SSGIO","Copia Biglietto","C","1","0","campo","nokey","false","false"},new String[]{"FDC3SSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC4SSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC5SSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC6SSGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC1ACGIO","Adeguata Verifica Sopra Soglia","C","1","0","campo","nokey","false","false"},new String[]{"FDC2ACGIO","Copia Biglietto","C","1","0","campo","nokey","false","false"},new String[]{"FDC3ACGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC4ACGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC5ACGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"FDC6ACGIO","Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"NCOPAGGIO","N° pagine Pagamento in contanti","N","2","0","campo","nokey","false","false"},new String[]{"ardt_cgo_tgtiporeg","LinkPC","","","","link_PC","","false",""},new String[]{"FLTIPGIO","Tipologia","C","1","0","campo","nokey","false","true"},new String[]{"FLGATTIVO","Tipo Gioco Attivo","C","1","0","campo","nokey","false","false"},new String[]{"IMPMINGIO","Importo minimo autovalidazione multiple","N","10","2","campo","nokey","false","false"},new String[]{"IMPMINTOT","Importo Minimo Totale Multiple","N","12","2","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_tbtipgioBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_oWrInfo_cgo_tbtipgio = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tbtipgio",p_ContextObject.GetCompany());
    m_cVirtName_cgo_tbtipgio = CPSql.ManipulateTablePhName("cgo_tbtipgio",m_cServer_cgo_tbtipgio);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    ardt_cgo_tgtiporeg = new ardt_cgo_tgtiporegBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_cgo_tbtipgio",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CODTPGIO = "";
    w_DESTPGIO = "";
    w_SOGTPGIO = 0;
    w_DEFTPGIO = "";
    w_DEFSPGIO = "";
    w_MAGPAGGIO = 0;
    w_MINPAGGIO = 0;
    w_NCOPAGGIO = 0;
    w_IMPMINGIO = 0;
    w_IMPMINTOT = 0;
    w_EDTTPGIO = "S";
    w_EDTSPGIO = "S";
    w_FLGPLGIO = "N";
    w_FLGMLGIO = "N";
    w_FDC1OSGIO = "N";
    w_FDC2OSGIO = "N";
    w_FDC3OSGIO = "N";
    w_FDC4OSGIO = "N";
    w_FDC5OSGIO = "N";
    w_FDC6OSGIO = "N";
    w_FDC1SSGIO = "N";
    w_FDC2SSGIO = "N";
    w_FDC3SSGIO = "N";
    w_FDC4SSGIO = "N";
    w_FDC5SSGIO = "N";
    w_FDC6SSGIO = "N";
    w_FDC1ACGIO = "N";
    w_FDC2ACGIO = "N";
    w_FDC3ACGIO = "N";
    w_FDC4ACGIO = "N";
    w_FDC5ACGIO = "N";
    w_FDC6ACGIO = "N";
    w_FLTIPGIO = "A";
    w_FLGATTIVO = "S";
    m_cWv_ardt_cgo_tgtiporeg = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_cgo_tgtiporeg.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_cgo_tgtiporeg);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    ardt_cgo_tgtiporeg.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_QKTXGXQWMD();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CODTPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODTPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESTPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESTPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOGTPGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOGTPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_EDTTPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_EDTTPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DEFTPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DEFTPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_EDTSPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_EDTSPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DEFSPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DEFSPGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGPLGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGPLGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGMLGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGMLGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MAGPAGGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MAGPAGGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MINPAGGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MINPAGGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC1OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC1OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC2OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC2OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC3OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC3OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC4OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC4OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC5OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC5OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC6OSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC6OSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC1SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC1SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC2SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC2SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC3SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC3SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC4SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC4SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC5SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC5SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC6SSGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC6SSGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC1ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC1ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC2ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC2ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC3ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC3ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC4ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC4ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC5ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC5ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FDC6ACGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FDC6ACGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NCOPAGGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NCOPAGGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLTIPGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLTIPGIO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_FLTIPGIO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGATTIVO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGATTIVO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPMINGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPMINGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPMINTOT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPMINTOT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_IMPMINGIO() {
    return CPLib.eq(w_FLGMLGIO,"S");
  }
  public boolean getWritable_IMPMINTOT() {
    return CPLib.eq(w_FLGMLGIO,"S");
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
  void Calculation_QKTXGXQWMD() {
    arrt_cgo_agg_cgotipopeR l_oRoutine_arrt_cgo_agg_cgotipope;
    l_oRoutine_arrt_cgo_agg_cgotipope = arrt_cgo_agg_cgotipopeR.Make(m_Ctx,this);
    l_oRoutine_arrt_cgo_agg_cgotipope.pCodGio = w_CODTPGIO;
    l_oRoutine_arrt_cgo_agg_cgotipope.pTipGio = w_FLTIPGIO;
    l_oRoutine_arrt_cgo_agg_cgotipope.Run();
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
  public final static String[] m_KeyColumns = {"CODTPGIO"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_tbtipgio","cgo_tbtipgio",m_KeyColumns,m_Ctx);
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
    w_CODTPGIO = "";
    w_DESTPGIO = "";
    w_SOGTPGIO = 0;
    w_EDTTPGIO = "";
    w_DEFTPGIO = "";
    w_EDTSPGIO = "";
    w_DEFSPGIO = "";
    w_FLGPLGIO = "";
    w_FLGMLGIO = "";
    w_MAGPAGGIO = 0;
    w_MINPAGGIO = 0;
    w_FDC1OSGIO = "";
    w_FDC2OSGIO = "";
    w_FDC3OSGIO = "";
    w_FDC4OSGIO = "";
    w_FDC5OSGIO = "";
    w_FDC6OSGIO = "";
    w_FDC1SSGIO = "";
    w_FDC2SSGIO = "";
    w_FDC3SSGIO = "";
    w_FDC4SSGIO = "";
    w_FDC5SSGIO = "";
    w_FDC6SSGIO = "";
    w_FDC1ACGIO = "";
    w_FDC2ACGIO = "";
    w_FDC3ACGIO = "";
    w_FDC4ACGIO = "";
    w_FDC5ACGIO = "";
    w_FDC6ACGIO = "";
    w_NCOPAGGIO = 0;
    w_FLTIPGIO = "";
    w_FLGATTIVO = "";
    w_IMPMINGIO = 0;
    w_IMPMINTOT = 0;
    m_cWv_ardt_cgo_tgtiporeg = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CODTPGIO = CPLib.GetProperty(p,"CODTPGIO",w_CODTPGIO,0);
      w_DESTPGIO = CPLib.GetProperty(p,"DESTPGIO",w_DESTPGIO,0);
      w_SOGTPGIO = CPLib.GetProperty(p,"SOGTPGIO",w_SOGTPGIO,0);
      w_EDTTPGIO = CPLib.GetProperty(p,"EDTTPGIO",w_EDTTPGIO,0);
      w_DEFTPGIO = CPLib.GetProperty(p,"DEFTPGIO",w_DEFTPGIO,0);
      w_EDTSPGIO = CPLib.GetProperty(p,"EDTSPGIO",w_EDTSPGIO,0);
      w_DEFSPGIO = CPLib.GetProperty(p,"DEFSPGIO",w_DEFSPGIO,0);
      w_FLGPLGIO = CPLib.GetProperty(p,"FLGPLGIO",w_FLGPLGIO,0);
      w_FLGMLGIO = CPLib.GetProperty(p,"FLGMLGIO",w_FLGMLGIO,0);
      w_MAGPAGGIO = CPLib.GetProperty(p,"MAGPAGGIO",w_MAGPAGGIO,0);
      w_MINPAGGIO = CPLib.GetProperty(p,"MINPAGGIO",w_MINPAGGIO,0);
      w_FDC1OSGIO = CPLib.GetProperty(p,"FDC1OSGIO",w_FDC1OSGIO,0);
      w_FDC2OSGIO = CPLib.GetProperty(p,"FDC2OSGIO",w_FDC2OSGIO,0);
      w_FDC3OSGIO = CPLib.GetProperty(p,"FDC3OSGIO",w_FDC3OSGIO,0);
      w_FDC4OSGIO = CPLib.GetProperty(p,"FDC4OSGIO",w_FDC4OSGIO,0);
      w_FDC5OSGIO = CPLib.GetProperty(p,"FDC5OSGIO",w_FDC5OSGIO,0);
      w_FDC6OSGIO = CPLib.GetProperty(p,"FDC6OSGIO",w_FDC6OSGIO,0);
      w_FDC1SSGIO = CPLib.GetProperty(p,"FDC1SSGIO",w_FDC1SSGIO,0);
      w_FDC2SSGIO = CPLib.GetProperty(p,"FDC2SSGIO",w_FDC2SSGIO,0);
      w_FDC3SSGIO = CPLib.GetProperty(p,"FDC3SSGIO",w_FDC3SSGIO,0);
      w_FDC4SSGIO = CPLib.GetProperty(p,"FDC4SSGIO",w_FDC4SSGIO,0);
      w_FDC5SSGIO = CPLib.GetProperty(p,"FDC5SSGIO",w_FDC5SSGIO,0);
      w_FDC6SSGIO = CPLib.GetProperty(p,"FDC6SSGIO",w_FDC6SSGIO,0);
      w_FDC1ACGIO = CPLib.GetProperty(p,"FDC1ACGIO",w_FDC1ACGIO,0);
      w_FDC2ACGIO = CPLib.GetProperty(p,"FDC2ACGIO",w_FDC2ACGIO,0);
      w_FDC3ACGIO = CPLib.GetProperty(p,"FDC3ACGIO",w_FDC3ACGIO,0);
      w_FDC4ACGIO = CPLib.GetProperty(p,"FDC4ACGIO",w_FDC4ACGIO,0);
      w_FDC5ACGIO = CPLib.GetProperty(p,"FDC5ACGIO",w_FDC5ACGIO,0);
      w_FDC6ACGIO = CPLib.GetProperty(p,"FDC6ACGIO",w_FDC6ACGIO,0);
      w_NCOPAGGIO = CPLib.GetProperty(p,"NCOPAGGIO",w_NCOPAGGIO,0);
      w_FLTIPGIO = CPLib.GetProperty(p,"FLTIPGIO",w_FLTIPGIO,0);
      w_FLGATTIVO = CPLib.GetProperty(p,"FLGATTIVO",w_FLGATTIVO,0);
      w_IMPMINGIO = CPLib.GetProperty(p,"IMPMINGIO",w_IMPMINGIO,0);
      w_IMPMINTOT = CPLib.GetProperty(p,"IMPMINTOT",w_IMPMINTOT,0);
      m_cWv_ardt_cgo_tgtiporeg = CPLib.GetProperty(p,"m_cWv_ardt_cgo_tgtiporeg",m_cWv_ardt_cgo_tgtiporeg,0);
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
    items = tables.get("cgo_tgtiporeg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_tgtiporeg",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TRCODGIO"});
    map.put("rd_var",new String[]{"w_CODTPGIO"});
    map.put("wr_var",new String[]{"w_CODTPGIO"});
    map.put("wr_field",new String[]{"TRCODGIO"});
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
    map.put("property.value",zeroSplit.split("cgo_tgtiporeg\u0000false\u0000false\u00001\u00000\u0000ardt_cgo_tgtiporeg\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_cgo_tbtipgio",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_tbtipgio",child);
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
    ardt_cgo_tgtiporeg = new ardt_cgo_tgtiporegBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_cgo_tbtipgio",m_Ctx);
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
    if (CPLib.Empty(w_FLTIPGIO)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_FLTIPGIO));
      String obblMsgError = m_Ctx.Translate("Tipologia")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_FLTIPGIO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "FLTIPGIO";
      }
    }
    if (l_bResult && (( ! (ardt_cgo_tgtiporeg.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_cgo_tgtiporeg)) || ( ! (ardt_cgo_tgtiporeg.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_cgo_tgtiporeg)))) {
      ardt_cgo_tgtiporeg.SetFromContext(m_cWv_ardt_cgo_tgtiporeg);
      m_cWv_ardt_cgo_tgtiporeg = "_not_empty_";
    }
    if (l_bResult && (ardt_cgo_tgtiporeg.m_bLoaded || ardt_cgo_tgtiporeg.m_bUpdated)) {
      l_bResult = l_bResult && ardt_cgo_tgtiporeg.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_cgo_tgtiporeg.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_cgo_tbtipgio"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_tbtipgio\\"+p_cState};
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
    CPLib.PutProperty(p,"CODTPGIO",w_CODTPGIO,0);
    CPLib.PutProperty(p,"DESTPGIO",w_DESTPGIO,0);
    CPLib.PutProperty(p,"SOGTPGIO",w_SOGTPGIO,0);
    CPLib.PutProperty(p,"EDTTPGIO",w_EDTTPGIO,0);
    CPLib.PutProperty(p,"DEFTPGIO",w_DEFTPGIO,0);
    CPLib.PutProperty(p,"EDTSPGIO",w_EDTSPGIO,0);
    CPLib.PutProperty(p,"DEFSPGIO",w_DEFSPGIO,0);
    CPLib.PutProperty(p,"FLGPLGIO",w_FLGPLGIO,0);
    CPLib.PutProperty(p,"FLGMLGIO",w_FLGMLGIO,0);
    CPLib.PutProperty(p,"MAGPAGGIO",w_MAGPAGGIO,0);
    CPLib.PutProperty(p,"MINPAGGIO",w_MINPAGGIO,0);
    CPLib.PutProperty(p,"FDC1OSGIO",w_FDC1OSGIO,0);
    CPLib.PutProperty(p,"FDC2OSGIO",w_FDC2OSGIO,0);
    CPLib.PutProperty(p,"FDC3OSGIO",w_FDC3OSGIO,0);
    CPLib.PutProperty(p,"FDC4OSGIO",w_FDC4OSGIO,0);
    CPLib.PutProperty(p,"FDC5OSGIO",w_FDC5OSGIO,0);
    CPLib.PutProperty(p,"FDC6OSGIO",w_FDC6OSGIO,0);
    CPLib.PutProperty(p,"FDC1SSGIO",w_FDC1SSGIO,0);
    CPLib.PutProperty(p,"FDC2SSGIO",w_FDC2SSGIO,0);
    CPLib.PutProperty(p,"FDC3SSGIO",w_FDC3SSGIO,0);
    CPLib.PutProperty(p,"FDC4SSGIO",w_FDC4SSGIO,0);
    CPLib.PutProperty(p,"FDC5SSGIO",w_FDC5SSGIO,0);
    CPLib.PutProperty(p,"FDC6SSGIO",w_FDC6SSGIO,0);
    CPLib.PutProperty(p,"FDC1ACGIO",w_FDC1ACGIO,0);
    CPLib.PutProperty(p,"FDC2ACGIO",w_FDC2ACGIO,0);
    CPLib.PutProperty(p,"FDC3ACGIO",w_FDC3ACGIO,0);
    CPLib.PutProperty(p,"FDC4ACGIO",w_FDC4ACGIO,0);
    CPLib.PutProperty(p,"FDC5ACGIO",w_FDC5ACGIO,0);
    CPLib.PutProperty(p,"FDC6ACGIO",w_FDC6ACGIO,0);
    CPLib.PutProperty(p,"NCOPAGGIO",w_NCOPAGGIO,0);
    CPLib.PutProperty(p,"FLTIPGIO",w_FLTIPGIO,0);
    CPLib.PutProperty(p,"FLGATTIVO",w_FLGATTIVO,0);
    CPLib.PutProperty(p,"IMPMINGIO",w_IMPMINGIO,0);
    CPLib.PutProperty(p,"IMPMINTOT",w_IMPMINTOT,0);
    if (p_bGetChildren) {
      if (ardt_cgo_tgtiporeg.IsUpdated()) {
        m_cWv_ardt_cgo_tgtiporeg = ardt_cgo_tgtiporeg.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_cgo_tgtiporeg",m_cWv_ardt_cgo_tgtiporeg,0);
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
    return "cgo_tbtipgio"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CODTPGIO","C",3,0));
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
  public boolean ChildExists_ardt_cgo_tgtiporeg() {
    if (ardt_cgo_tgtiporeg.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_cgo_tgtiporeg) || CPLib.IsLoaded(m_cWv_ardt_cgo_tgtiporeg))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_cgo_tgtiporeg.m_bLoaded)) {
      ardt_cgo_tgtiporeg.Blank();
      ardt_cgo_tgtiporeg.w_TRCODGIO = w_CODTPGIO;
      ardt_cgo_tgtiporeg.Load();
    }
    return ardt_cgo_tgtiporeg.m_bLoaded;
  }
  public void CtxLoad_ardt_cgo_tgtiporeg() {
    if ( ! (ardt_cgo_tgtiporeg.m_lCtxLoaded)) {
      ardt_cgo_tgtiporeg.Blank();
    }
    ardt_cgo_tgtiporeg.m_lCtxLoaded = true;
    if ( ! (ardt_cgo_tgtiporeg.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_cgo_tgtiporeg) || CPLib.IsLoaded(m_cWv_ardt_cgo_tgtiporeg)) {
        ardt_cgo_tgtiporeg.SetFromContext(m_cWv_ardt_cgo_tgtiporeg);
        m_cWv_ardt_cgo_tgtiporeg = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_cgo_tgtiporeg.m_bLoaded)) {
          ardt_cgo_tgtiporeg.Blank();
          ardt_cgo_tgtiporeg.w_TRCODGIO = w_CODTPGIO;
          ardt_cgo_tgtiporeg.Load();
          if ( ! (ardt_cgo_tgtiporeg.m_bLoaded)) {
            ardt_cgo_tgtiporeg.Initialize();
            ardt_cgo_tgtiporeg.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_cgo_tgtiporeg")) {
      CtxLoad_ardt_cgo_tgtiporeg();
      return ardt_cgo_tgtiporeg;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
