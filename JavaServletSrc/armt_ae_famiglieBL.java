import java.util.*;

public class armt_ae_famiglieBL extends armt_ae_famiglieWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_ae_famiglie";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public CPPhTableWrInfo m_oWrInfo_aetesta;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_aetesta;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public CPPhTableWrInfo m_oWrInfo_tbtipnat;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"aetesta"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'TIPOAG':TIPOAG,'COINT':COINT,'DESCRI':DESCRI,'OLDINTER':OLDINTER,'VALUTA':VALUTA,'CAB':CAB,'INVIATO':INVIATO,'DATAINVIO':DATAINVIO,'DATAMODI':DATAMODI,'ANNULLA':ANNULLA,'DATAANNU':DATAANNU,'IDESITOFAM':IDESITOFAM,'UNIQUECODE':UNIQUECODE,'INVIATOC':INVIATOC,'DATAINVIOC':DATAINVIOC,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_famiglie",true)+"}";
  public static final String i_CompleteStateStructure = "{'RAPPORTO':RAPPORTO,'TIPOAG':TIPOAG,'COINT':COINT,'DESCRI':DESCRI,'OLDINTER':OLDINTER,'VALUTA':VALUTA,'CAB':CAB,'INVIATO':INVIATO,'DATAINVIO':DATAINVIO,'DATAMODI':DATAMODI,'ANNULLA':ANNULLA,'DATAANNU':DATAANNU,'IDESITOFAM':IDESITOFAM,'UNIQUECODE':UNIQUECODE,'INVIATOC':INVIATOC,'DATAINVIOC':DATAINVIOC,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_famiglie",true)+"}";
  public static final String i_ItemSequence = "RAPPORTO,TIPOAG,COINT,DESCRI,OLDINTER,VALUTA,CAB,INVIATO,DATAINVIO,DATAMODI,ANNULLA,DATAANNU,IDESITOFAM,UNIQUECODE,INVIATOC,DATAINVIOC,ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_famiglie",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_ae_famiglie"),new String[][]{new String[]{"RAPPORTO","Codice Rapporto","C","25","0","campo","key1","false","false"},new String[]{"TIPOAG","","C","2","0","campo","nokey","false","false"},new String[]{"COINT","Tipo Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"DESCRI","Descrizione","C","24","0","campo","nokey","false","false"},new String[]{"OLDINTER","Codice Fiscale Interm. Precedeten","C","16","0","campo","nokey","false","false"},new String[]{"VALUTA","Divisa","C","3","0","campo","nokey","false","false"},new String[]{"CAB","Codice CAB","C","5","0","campo","nokey","false","false"},new String[]{"INVIATO","","N","1","0","campo","nokey","false","false"},new String[]{"DATAINVIO","","D","8","0","campo","nokey","false","false"},new String[]{"DATAMODI","Data Modifica","D","8","0","campo","nokey","false","false"},new String[]{"ANNULLA","","N","1","0","campo","nokey","false","false"},new String[]{"DATAANNU","","D","8","0","campo","nokey","false","false"},new String[]{"IDESITOFAM","Esito Agenzia Entrate","C","24","0","campo","nokey","false","false"},new String[]{"UNIQUECODE","","C","50","0","campo","nokey","false","false"},new String[]{"INVIATOC","","N","1","0","campo","nokey","false","false"},new String[]{"DATAINVIOC","","D","8","0","campo","nokey","false","false"},new String[]{"ardt_ae_saldianno_rap","LinkPC","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_ae_famiglieBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta",p_ContextObject.GetCompany(),false);
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_oWrInfo_aetesta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aetesta",p_ContextObject.GetCompany());
    m_cVirtName_aetesta = CPSql.ManipulateTablePhName("aetesta",m_cServer_aetesta);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_oWrInfo_tbtipnat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipnat",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_ae_famiglie",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_RAPPORTO = "";
    w_TIPOAG = "";
    w_COINT = "";
    w_DESCRI = "";
    w_OLDINTER = "";
    w_VALUTA = "";
    w_CAB = "";
    w_DATAINVIO = CPLib.NullDate();
    w_DATAMODI = CPLib.NullDate();
    w_DATAANNU = CPLib.NullDate();
    w_IDESITOFAM = "";
    w_UNIQUECODE = "";
    w_DATAINVIOC = CPLib.NullDate();
    w_INVIATO = 0;
    w_ANNULLA = 0;
    w_INVIATOC = 0;
    m_cWv_ardt_ae_saldianno_rap = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_ae_saldianno_rap.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_TIPOAG = w_TIPOAG;
    ardt_ae_saldianno_rap.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COINT = p_workVariableValue;
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
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_OLDINTER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_OLDINTER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VALUTA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VALUTA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_INVIATO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_INVIATO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINVIO(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAMODI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAMODI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ANNULLA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ANNULLA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAANNU(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAANNU = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDESITOFAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDESITOFAM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_UNIQUECODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_UNIQUECODE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_INVIATOC(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_INVIATOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINVIOC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINVIOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_DESCRI() {
    return CPLib.eq(w_TIPOAG,"99");
  }
  public boolean getWritable_CAB() {
    return CPLib.ne(CPLib.At(w_TIPOAG,"|01|02|03|12|13"),0);
  }
  public boolean getWritable_INVIATO() {
    return false;
  }
  public boolean getWritable_DATAINVIO() {
    return false;
  }
  public boolean getWritable_DATAMODI() {
    return false;
  }
  public boolean getWritable_ANNULLA() {
    return false;
  }
  public boolean getWritable_DATAANNU() {
    return false;
  }
  public boolean getWritable_INVIATOC() {
    return false;
  }
  public boolean getWritable_DATAINVIOC() {
    return false;
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
    CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},true);
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
  public final static String[] m_KeyColumns = {"RAPPORTO"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_ae_famiglie","aetesta",m_KeyColumns,m_Ctx);
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
    w_RAPPORTO = "";
    w_TIPOAG = "";
    w_COINT = "";
    w_DESCRI = "";
    w_OLDINTER = "";
    w_VALUTA = "";
    w_CAB = "";
    w_INVIATO = 0;
    w_DATAINVIO = CPLib.NullDate();
    w_DATAMODI = CPLib.NullDate();
    w_ANNULLA = 0;
    w_DATAANNU = CPLib.NullDate();
    w_IDESITOFAM = "";
    w_UNIQUECODE = "";
    w_INVIATOC = 0;
    w_DATAINVIOC = CPLib.NullDate();
    m_cWv_ardt_ae_saldianno_rap = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_TIPOAG = CPLib.GetProperty(p,"TIPOAG",w_TIPOAG,0);
      w_COINT = CPLib.GetProperty(p,"COINT",w_COINT,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      w_OLDINTER = CPLib.GetProperty(p,"OLDINTER",w_OLDINTER,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_CAB = CPLib.GetProperty(p,"CAB",w_CAB,0);
      w_INVIATO = CPLib.GetProperty(p,"INVIATO",w_INVIATO,0);
      w_DATAINVIO = CPLib.GetProperty(p,"DATAINVIO",w_DATAINVIO,0);
      w_DATAMODI = CPLib.GetProperty(p,"DATAMODI",w_DATAMODI,0);
      w_ANNULLA = CPLib.GetProperty(p,"ANNULLA",w_ANNULLA,0);
      w_DATAANNU = CPLib.GetProperty(p,"DATAANNU",w_DATAANNU,0);
      w_IDESITOFAM = CPLib.GetProperty(p,"IDESITOFAM",w_IDESITOFAM,0);
      w_UNIQUECODE = CPLib.GetProperty(p,"UNIQUECODE",w_UNIQUECODE,0);
      w_INVIATOC = CPLib.GetProperty(p,"INVIATOC",w_INVIATOC,0);
      w_DATAINVIOC = CPLib.GetProperty(p,"DATAINVIOC",w_DATAINVIOC,0);
      m_cWv_ardt_ae_saldianno_rap = CPLib.GetProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
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
    items = tables.get("aeannora");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("aeannora",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPPORTO"});
    map.put("rd_var",new String[]{"w_RAPPORTO"});
    map.put("wr_var",new String[]{"w_RAPPORTO"});
    map.put("wr_field",new String[]{"RAPPORTO"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{""});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("aeannora\u0000false\u0000false\u00001\u00000\u0000ardt_ae_saldianno_rap\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_ae_famiglie",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_ae_famiglie",child);
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
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_ae_famiglie",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    if (l_bResult && (( ! (ardt_ae_saldianno_rap.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap)) || ( ! (ardt_ae_saldianno_rap.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap)))) {
      ardt_ae_saldianno_rap.SetFromContext(m_cWv_ardt_ae_saldianno_rap);
      m_cWv_ardt_ae_saldianno_rap = "_not_empty_";
    }
    if (l_bResult && (ardt_ae_saldianno_rap.m_bLoaded || ardt_ae_saldianno_rap.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ae_saldianno_rap.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ae_saldianno_rap.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_ae_famiglie","Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_ae_famiglie\\"+p_cState,"Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
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
    o_TIPOAG = "";
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
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"TIPOAG",w_TIPOAG,0);
    CPLib.PutProperty(p,"COINT",w_COINT,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,"OLDINTER",w_OLDINTER,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"CAB",w_CAB,0);
    CPLib.PutProperty(p,"INVIATO",w_INVIATO,0);
    CPLib.PutProperty(p,"DATAINVIO",w_DATAINVIO,0);
    CPLib.PutProperty(p,"DATAMODI",w_DATAMODI,0);
    CPLib.PutProperty(p,"ANNULLA",w_ANNULLA,0);
    CPLib.PutProperty(p,"DATAANNU",w_DATAANNU,0);
    CPLib.PutProperty(p,"IDESITOFAM",w_IDESITOFAM,0);
    CPLib.PutProperty(p,"UNIQUECODE",w_UNIQUECODE,0);
    CPLib.PutProperty(p,"INVIATOC",w_INVIATOC,0);
    CPLib.PutProperty(p,"DATAINVIOC",w_DATAINVIOC,0);
    if (p_bGetChildren) {
      if (ardt_ae_saldianno_rap.IsUpdated()) {
        m_cWv_ardt_ae_saldianno_rap = ardt_ae_saldianno_rap.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
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
    return "aetesta"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
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
  public boolean ChildExists_ardt_ae_saldianno_rap() {
    if (ardt_ae_saldianno_rap.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap) || CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ae_saldianno_rap.m_bLoaded)) {
      ardt_ae_saldianno_rap.Blank();
      ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
      ardt_ae_saldianno_rap.Load();
    }
    return ardt_ae_saldianno_rap.m_bLoaded;
  }
  public void CtxLoad_ardt_ae_saldianno_rap() {
    if ( ! (ardt_ae_saldianno_rap.m_lCtxLoaded)) {
      ardt_ae_saldianno_rap.Blank();
    }
    ardt_ae_saldianno_rap.m_lCtxLoaded = true;
    if ( ! (ardt_ae_saldianno_rap.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap) || CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap)) {
        ardt_ae_saldianno_rap.SetFromContext(m_cWv_ardt_ae_saldianno_rap);
        m_cWv_ardt_ae_saldianno_rap = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ae_saldianno_rap.m_bLoaded)) {
          ardt_ae_saldianno_rap.Blank();
          ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_saldianno_rap.Load();
          if ( ! (ardt_ae_saldianno_rap.m_bLoaded)) {
            ardt_ae_saldianno_rap.Initialize();
            ardt_ae_saldianno_rap.SetUpdated();
          }
          CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},true);
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_ae_saldianno_rap")) {
      CtxLoad_ardt_ae_saldianno_rap();
      return ardt_ae_saldianno_rap;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
