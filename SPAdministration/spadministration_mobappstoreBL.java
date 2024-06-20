import java.util.*;

public class spadministration_mobappstoreBL extends spadministration_mobappstoreWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "spadministration_mobappstore";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cpappstore;
  public String m_cServer_cpappstore;
  public CPPhTableWrInfo m_oWrInfo_cpappstore;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cpappstore;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cpappstore"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'oa__code':oa__code,'oaapppublished':oaapppublished,'oareserved':oareserved,'oaappmenu':oaappmenu,'oaapptitle':oaapptitle,'oadescri':oadescri,'oaapplogo':oaapplogo,'oaappfavico':oaappfavico,'oaapplanding':oaapplanding,'oaskinname':oaskinname,'changeSkin':changeSkin,'oaappvariantname':oaappvariantname,'oaappheader':oaappheader,'oaappdescrheader':oaappdescrheader,'oaapphideutilitygroup':oaapphideutilitygroup,'oaapphomelink':oaapphomelink,'combo_homelink':combo_homelink,'custom_homelink':custom_homelink,'oaappchecksum':oaappchecksum,'OAAPPACCESSMODE':OAAPPACCESSMODE,'oaappdevtyp':oaappdevtyp,'oaappreqreg':oaappreqreg,'oaappurlreg':oaappurlreg,'spadministration_dmobapp_qkm':spadministration_dmobapp_qkm,'spadministration_mobapppermissions':spadministration_mobapppermissions"+FoundlingChildrenList("spadministration_mobappstore",true)+"}";
  public static final String i_CompleteStateStructure = "{'oa__code':oa__code,'oaapppublished':oaapppublished,'oareserved':oareserved,'oaappmenu':oaappmenu,'oaapptitle':oaapptitle,'oadescri':oadescri,'oaapplogo':oaapplogo,'oaappfavico':oaappfavico,'oaapplanding':oaapplanding,'oaskinname':oaskinname,'changeSkin':changeSkin,'oaappvariantname':oaappvariantname,'oaappheader':oaappheader,'oaappdescrheader':oaappdescrheader,'oaapphideutilitygroup':oaapphideutilitygroup,'oaapphomelink':oaapphomelink,'combo_homelink':combo_homelink,'custom_homelink':custom_homelink,'oaappchecksum':oaappchecksum,'OAAPPACCESSMODE':OAAPPACCESSMODE,'oaappdevtyp':oaappdevtyp,'oaappreqreg':oaappreqreg,'oaappurlreg':oaappurlreg,'forceCreateFile':forceCreateFile,'ignoreFile':ignoreFile,'spadministration_dmobapp_qkm':spadministration_dmobapp_qkm,'spadministration_mobapppermissions':spadministration_mobapppermissions"+FoundlingChildrenList("spadministration_mobappstore",true)+"}";
  public static final String i_ItemSequence = "oa__code,oaapppublished,oareserved,oaappmenu,oaapptitle,oadescri,oaapplogo,oaappfavico,oaapplanding,oaskinname,changeSkin,oaappvariantname,oaappheader,oaappdescrheader,oaapphideutilitygroup,oaapphomelink,combo_homelink,custom_homelink,oaappchecksum,OAAPPACCESSMODE,oaappdevtyp,oaappreqreg,oaappurlreg,spadministration_dmobapp_qkm,spadministration_mobapppermissions"+FoundlingChildrenList("spadministration_mobappstore",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("spadministration_mobappstore"),new String[][]{new String[]{"oa__code","MOBAPPSTORE_CODE","C","10","0","campo","key1","false","false"},new String[]{"oaapppublished","Published","N","1","0","campo","nokey","false","false"},new String[]{"oareserved","Profilata","C","1","0","campo","nokey","false","false"},new String[]{"oaappmenu","MOBAPPSTORE_MENU_APPL","C","100","0","campo","key3","false","true"},new String[]{"oaapptitle","MOBAPPSTORE_TITLE","C","50","0","campo","nokey","false","false"},new String[]{"oadescri","MOBAPPSTORE_DESCRIPTION","M","10","0","campo","key2","false","false"},new String[]{"oaapplogo","MOBAPPSTORE_LOGO","C","50","0","campo","nokey","false","false"},new String[]{"oaappfavico","MOBAPPSTORE_ICON","C","50","0","campo","nokey","false","false"},new String[]{"oaapplanding","Landing page","C","255","0","campo","nokey","false","false"},new String[]{"oaskinname","Nome Skin","C","30","0","campo","nokey","false","false"},new String[]{"changeSkin","","L","1","0","variabile","nokey","false","false"},new String[]{"oaappvariantname","Variant name","C","30","0","campo","nokey","false","false"},new String[]{"oaappheader","Header image","C","50","0","campo","nokey","false","false"},new String[]{"oaappdescrheader","Description header","C","50","0","campo","nokey","false","false"},new String[]{"oaapphideutilitygroup","MOBAPPSTORE_HIDE_UTILITY_GROUP","N","1","0","campo","nokey","false","false"},new String[]{"oaapphomelink","Home link of home button","C","255","0","campo","nokey","false","false"},new String[]{"combo_homelink","MOBAPPSTORE_HOME_BUTTON_LINK","N","1","0","variabile","nokey","false","false"},new String[]{"custom_homelink","","C","255","0","variabile","nokey","false","false"},new String[]{"oaappchecksum","Cheksum","C","20","0","campo","nokey","false","false"},new String[]{"OAAPPACCESSMODE","Access mode","C","30","0","campo","nokey","false","false"},new String[]{"oaappdevtyp","Designed for","C","1","0","campo","nokey","false","false"},new String[]{"oaappreqreg","MOBAPPSTORE_REQUIRE_REGISTRATION","N","1","0","campo","nokey","false","false"},new String[]{"oaappurlreg","MOBAPPSTORE_URL_REGISTRATION","C","255","0","campo","nokey","false","false"},new String[]{"spadministration_dmobapp_qkm","LinkPC","","","","link_PC","","false",""},new String[]{"spadministration_mobapppermissions","Gruppi/Utenti","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public spadministration_mobappstoreBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cpappstore = p_ContextObject.GetPhName("cpappstore",p_ContextObject.GetCompany(),false);
    m_cServer_cpappstore = p_ContextObject.GetServer("cpappstore");
    m_oWrInfo_cpappstore = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cpappstore",p_ContextObject.GetCompany());
    m_cVirtName_cpappstore = CPSql.ManipulateTablePhName("cpappstore",m_cServer_cpappstore);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    spadministration_dmobapp_qkm = new spadministration_dmobapp_qkmBO(p_ContextObject);
    spadministration_mobapppermissions = new spadministration_mobapppermissionsBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("spadministration_mobappstore",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_oa__code = "";
    w_oaapppublished = 0;
    w_oaappmenu = "";
    w_oaapptitle = "";
    w_oadescri = "";
    w_oaapplogo = "";
    w_oaappfavico = "";
    w_oaapplanding = "";
    w_changeSkin = false;
    w_oaappvariantname = "";
    w_oaappheader = "";
    w_oaappdescrheader = "";
    w_oaapphideutilitygroup = 0;
    w_custom_homelink = "";
    w_oaappchecksum = "";
    w_OAAPPACCESSMODE = "";
    w_oaappreqreg = 0;
    w_forceCreateFile = false;
    w_ignoreFile = false;
    w_oareserved = "N";
    w_oaskinname = "iMobile";
    w_oaapphomelink = "index";
    w_combo_homelink = 1;
    w_oaappdevtyp = "B";
    w_oaappurlreg = "";
    w_oaappurlreg = (CPLib.ne(w_oaappreqreg,1)?"":(CPLib.Empty(w_oaappurlreg)?calc_url()+"/jsp-system/spadministration_mobappreg.jsp":w_oaappurlreg));
    m_cWv_spadministration_dmobapp_qkm = "";
    m_cWv_spadministration_mobapppermissions = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || spadministration_dmobapp_qkm.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_dmobapp_qkm);
    l_bResult = l_bResult || spadministration_mobapppermissions.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_mobapppermissions);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_oaappreqreg = w_oaappreqreg;
    spadministration_dmobapp_qkm.SaveDependsOn();
    spadministration_mobapppermissions.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete end")) {
      Calculation_FOBZRHWJMI();
    } else if (CPLib.eq(p_cEvent,"Insert end")) {
      Calculation_VDUVAGEDMV();
    } else if (CPLib.eq(p_cEvent,"Load")) {
      Calculation_OUCLWVJPWS();
    } else if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_RRZEOTWLZS();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_oa__code(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oa__code = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapppublished(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapppublished = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oareserved(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oareserved = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappmenu(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappmenu = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_oaappmenu = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapptitle(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapptitle = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oadescri(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oadescri = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapplogo(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapplogo = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappfavico(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappfavico = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapplanding(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapplanding = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaskinname(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaskinname = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_changeSkin(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_changeSkin = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappvariantname(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappvariantname = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappheader(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappheader = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappdescrheader(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappdescrheader = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapphideutilitygroup(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapphideutilitygroup = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaapphomelink(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaapphomelink = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_combo_homelink(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_combo_homelink = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_custom_homelink(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_custom_homelink = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappchecksum(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappchecksum = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_OAAPPACCESSMODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_OAAPPACCESSMODE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappdevtyp(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappdevtyp = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappreqreg(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappreqreg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_oaappurlreg(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_oaappurlreg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_oaappmenu() {
    return CPLib.eq(EntityStatus(),"N");
  }
  public boolean getWritable_oaskinname() {
    return w_changeSkin;
  }
  public boolean getWritable_oaappchecksum() {
    return false;
  }
  public boolean getWritable_OAAPPACCESSMODE() {
    return false;
  }
  public boolean getVisible_oaapphomelink() {
    return true;
  }
  public boolean getVisible_custom_homelink() {
    return CPLib.ne(w_combo_homelink,3);
  }
  public boolean getVisible_oaappurlreg() {
    return CPLib.eq(w_oaappreqreg,0);
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
    if (CPLib.ne(o_oaappreqreg,w_oaappreqreg)) {
      w_oaappurlreg = (CPLib.ne(w_oaappreqreg,1)?"":(CPLib.Empty(w_oaappurlreg)?calc_url()+"/jsp-system/spadministration_mobappreg.jsp":w_oaappurlreg));
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_VDUVAGEDMV() {
    if ( ! (w_ignoreFile)) {
      spadministration_createmobappdirR l_oRoutine_spadministration_createmobappdir;
      l_oRoutine_spadministration_createmobappdir = spadministration_createmobappdirR.Make(m_Ctx,this);
      l_oRoutine_spadministration_createmobappdir.Run();
    }
  }
  void Calculation_FOBZRHWJMI() {
    spadministration_deletemobappdirR l_oRoutine_spadministration_deletemobappdir;
    l_oRoutine_spadministration_deletemobappdir = spadministration_deletemobappdirR.Make(m_Ctx,this);
    l_oRoutine_spadministration_deletemobappdir.Run();
  }
  void Calculation_RRZEOTWLZS() {
    if (w_forceCreateFile || spadministration_checkmobappdirR.Make(m_Ctx,this).Run(w_oaappmenu)) {
      spadministration_createmobappdirR l_oRoutine_spadministration_createmobappdir;
      l_oRoutine_spadministration_createmobappdir = spadministration_createmobappdirR.Make(m_Ctx,this);
      l_oRoutine_spadministration_createmobappdir.dontCheckExists = true;
      l_oRoutine_spadministration_createmobappdir.Run();
    }
  }
  void Calculation_OUCLWVJPWS() {
    w_combo_homelink = (CPLib.eq(CPLib.Lower(w_oaapphomelink),"default")?2:(CPLib.eq(CPLib.Lower(w_oaapphomelink),"index")?1:3));
    w_custom_homelink = (CPLib.ne(CPLib.Lower(w_oaapphomelink),"index") && CPLib.ne(CPLib.Lower(w_oaapphomelink),"default")?w_oaapphomelink:"");
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
  public final static String[] m_KeyColumns = {"oa__code"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("spadministration_mobappstore","cpappstore",m_KeyColumns,m_Ctx);
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
    w_oa__code = "";
    w_oaapppublished = 0;
    w_oareserved = "";
    w_oaappmenu = "";
    w_oaapptitle = "";
    w_oadescri = "";
    w_oaapplogo = "";
    w_oaappfavico = "";
    w_oaapplanding = "";
    w_oaskinname = "";
    w_changeSkin = false;
    w_oaappvariantname = "";
    w_oaappheader = "";
    w_oaappdescrheader = "";
    w_oaapphideutilitygroup = 0;
    w_oaapphomelink = "";
    w_combo_homelink = 0;
    w_custom_homelink = "";
    w_oaappchecksum = "";
    w_OAAPPACCESSMODE = "";
    w_oaappdevtyp = "";
    w_oaappreqreg = 0;
    w_oaappurlreg = "";
    w_forceCreateFile = false;
    w_ignoreFile = false;
    m_cWv_spadministration_dmobapp_qkm = "";
    m_cWv_spadministration_mobapppermissions = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_oa__code = CPLib.GetProperty(p,"oa__code",w_oa__code,0);
      op_oa__code = CPLib.GetProperty(p,"op_oa__code","",0);
      w_oaapppublished = CPLib.GetProperty(p,"oaapppublished",w_oaapppublished,0);
      w_oareserved = CPLib.GetProperty(p,"oareserved",w_oareserved,0);
      w_oaappmenu = CPLib.GetProperty(p,"oaappmenu",w_oaappmenu,0);
      w_oaapptitle = CPLib.GetProperty(p,"oaapptitle",w_oaapptitle,0);
      w_oadescri = CPLib.GetProperty(p,"oadescri",w_oadescri,0);
      w_oaapplogo = CPLib.GetProperty(p,"oaapplogo",w_oaapplogo,0);
      w_oaappfavico = CPLib.GetProperty(p,"oaappfavico",w_oaappfavico,0);
      w_oaapplanding = CPLib.GetProperty(p,"oaapplanding",w_oaapplanding,0);
      w_oaskinname = CPLib.GetProperty(p,"oaskinname",w_oaskinname,0);
      w_oaappvariantname = CPLib.GetProperty(p,"oaappvariantname",w_oaappvariantname,0);
      w_oaappheader = CPLib.GetProperty(p,"oaappheader",w_oaappheader,0);
      w_oaappdescrheader = CPLib.GetProperty(p,"oaappdescrheader",w_oaappdescrheader,0);
      w_oaapphideutilitygroup = CPLib.GetProperty(p,"oaapphideutilitygroup",w_oaapphideutilitygroup,0);
      w_oaapphomelink = CPLib.GetProperty(p,"oaapphomelink",w_oaapphomelink,0);
      w_oaappchecksum = CPLib.GetProperty(p,"oaappchecksum",w_oaappchecksum,0);
      w_OAAPPACCESSMODE = CPLib.GetProperty(p,"OAAPPACCESSMODE",w_OAAPPACCESSMODE,0);
      w_oaappdevtyp = CPLib.GetProperty(p,"oaappdevtyp",w_oaappdevtyp,0);
      w_oaappreqreg = CPLib.GetProperty(p,"oaappreqreg",w_oaappreqreg,0);
      w_oaappurlreg = CPLib.GetProperty(p,"oaappurlreg",w_oaappurlreg,0);
      w_changeSkin = CPLib.GetProperty(p,"changeSkin",w_changeSkin,0);
      w_combo_homelink = CPLib.GetProperty(p,"combo_homelink",w_combo_homelink,0);
      w_custom_homelink = CPLib.GetProperty(p,"custom_homelink",w_custom_homelink,0);
      w_forceCreateFile = CPLib.GetProperty(p,"forceCreateFile",w_forceCreateFile,0);
      w_ignoreFile = CPLib.GetProperty(p,"ignoreFile",w_ignoreFile,0);
      m_cWv_spadministration_dmobapp_qkm = CPLib.GetProperty(p,"m_cWv_spadministration_dmobapp_qkm",m_cWv_spadministration_dmobapp_qkm,0);
      m_cWv_spadministration_mobapppermissions = CPLib.GetProperty(p,"m_cWv_spadministration_mobapppermissions",m_cWv_spadministration_mobapppermissions,0);
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
    items = tables.get("cpqkmappstore");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cpqkmappstore",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"QA_CODE"});
    map.put("rd_var",new String[]{"w_oa__code"});
    map.put("wr_var",new String[]{"w_oa__code"});
    map.put("wr_field",new String[]{"QA_CODE"});
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
    map.put("property.value",zeroSplit.split("cpqkmappstore\u0000false\u0000false\u00001\u00000\u0000spadministration_dmobapp_qkm\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cppermappstore");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cppermappstore",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"pecodice"});
    map.put("rd_var",new String[]{"w_oa__code"});
    map.put("wr_var",new String[]{"w_oa__code"});
    map.put("wr_field",new String[]{"pecodice"});
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
    map.put("property.value",zeroSplit.split("cppermappstore\u0000false\u0000false\u00001\u00000\u0000spadministration_mobapppermissions\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("spadministration_mobappstore",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("spadministration_mobappstore",child);
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
    // Prenota i progressivi
    InitAutonumber();
    spadministration_dmobapp_qkm = new spadministration_dmobapp_qkmBO(m_Ctx);
    spadministration_mobapppermissions = new spadministration_mobapppermissionsBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("spadministration_mobappstore",m_Ctx);
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
    if ((CPLib.eq(EntityStatus(),"N")) && (CPLib.Empty(w_oaappmenu))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_oaappmenu));
      String obblMsgError = m_Ctx.Translate("MOBAPPSTORE_MENU_APPL")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_oaappmenu = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "oaappmenu";
      }
    }
    if (l_bResult && (( ! (spadministration_dmobapp_qkm.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_dmobapp_qkm)) || ( ! (spadministration_dmobapp_qkm.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_dmobapp_qkm)))) {
      spadministration_dmobapp_qkm.SetFromContext(m_cWv_spadministration_dmobapp_qkm);
      m_cWv_spadministration_dmobapp_qkm = "_not_empty_";
    }
    if (l_bResult && (spadministration_dmobapp_qkm.m_bLoaded || spadministration_dmobapp_qkm.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_dmobapp_qkm.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_dmobapp_qkm.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (spadministration_mobapppermissions.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_mobapppermissions)) || ( ! (spadministration_mobapppermissions.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_mobapppermissions)))) {
      spadministration_mobapppermissions.SetFromContext(m_cWv_spadministration_mobapppermissions);
      m_cWv_spadministration_mobapppermissions = "_not_empty_";
    }
    if (l_bResult && (spadministration_mobapppermissions.m_bLoaded || spadministration_mobapppermissions.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_mobapppermissions.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_mobapppermissions.m_cLastMsgError;
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
      l_Keys = new String[]{"spadministration_mobappstore"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"spadministration_mobappstore\\"+p_cState};
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
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_oa__code = m_Ctx.AskTableProg(w_oa__code,10,op_oa__code,"cpappstore",m_cServer_cpappstore);
    op_oa__code = w_oa__code;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_oa__code = "";
    // Inizializzazione delle variabili per DependsOn
    o_oaappreqreg = 0;
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
    CPLib.PutProperty(p,"oa__code",w_oa__code,0);
    CPLib.PutProperty(p,"op_oa__code",op_oa__code,0);
    CPLib.PutProperty(p,"oaapppublished",w_oaapppublished,0);
    CPLib.PutProperty(p,"oareserved",w_oareserved,0);
    CPLib.PutProperty(p,"oaappmenu",w_oaappmenu,0);
    CPLib.PutProperty(p,"oaapptitle",w_oaapptitle,0);
    CPLib.PutProperty(p,"oadescri",w_oadescri,0);
    CPLib.PutProperty(p,"oaapplogo",w_oaapplogo,0);
    CPLib.PutProperty(p,"oaappfavico",w_oaappfavico,0);
    CPLib.PutProperty(p,"oaapplanding",w_oaapplanding,0);
    CPLib.PutProperty(p,"oaskinname",w_oaskinname,0);
    CPLib.PutProperty(p,"oaappvariantname",w_oaappvariantname,0);
    CPLib.PutProperty(p,"oaappheader",w_oaappheader,0);
    CPLib.PutProperty(p,"oaappdescrheader",w_oaappdescrheader,0);
    CPLib.PutProperty(p,"oaapphideutilitygroup",w_oaapphideutilitygroup,0);
    CPLib.PutProperty(p,"oaapphomelink",w_oaapphomelink,0);
    CPLib.PutProperty(p,"oaappchecksum",w_oaappchecksum,0);
    CPLib.PutProperty(p,"OAAPPACCESSMODE",w_OAAPPACCESSMODE,0);
    CPLib.PutProperty(p,"oaappdevtyp",w_oaappdevtyp,0);
    CPLib.PutProperty(p,"oaappreqreg",w_oaappreqreg,0);
    CPLib.PutProperty(p,"oaappurlreg",w_oaappurlreg,0);
    CPLib.PutProperty(p,"changeSkin",w_changeSkin,0);
    CPLib.PutProperty(p,"combo_homelink",w_combo_homelink,0);
    CPLib.PutProperty(p,"custom_homelink",w_custom_homelink,0);
    CPLib.PutProperty(p,"forceCreateFile",w_forceCreateFile,0);
    CPLib.PutProperty(p,"ignoreFile",w_ignoreFile,0);
    if (p_bGetChildren) {
      if (spadministration_dmobapp_qkm.IsUpdated()) {
        m_cWv_spadministration_dmobapp_qkm = spadministration_dmobapp_qkm.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_dmobapp_qkm",m_cWv_spadministration_dmobapp_qkm,0);
    }
    if (p_bGetChildren) {
      if (spadministration_mobapppermissions.IsUpdated()) {
        m_cWv_spadministration_mobapppermissions = spadministration_mobapppermissions.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_mobapppermissions",m_cWv_spadministration_mobapppermissions,0);
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
    return "cpappstore"+"\\"+CPLib.ToCPStr(p_Caller.GetString("oa__code","C",10,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("w_oa__code");
    oneAutoNum.add("cpappstore");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_spadministration_dmobapp_qkm() {
    if (spadministration_dmobapp_qkm.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_dmobapp_qkm) || CPLib.IsLoaded(m_cWv_spadministration_dmobapp_qkm))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_dmobapp_qkm.m_bLoaded)) {
      spadministration_dmobapp_qkm.Blank();
      spadministration_dmobapp_qkm.w_QA_CODE = w_oa__code;
      spadministration_dmobapp_qkm.Load();
    }
    return spadministration_dmobapp_qkm.m_bLoaded;
  }
  public void CtxLoad_spadministration_dmobapp_qkm() {
    if ( ! (spadministration_dmobapp_qkm.m_lCtxLoaded)) {
      spadministration_dmobapp_qkm.Blank();
    }
    spadministration_dmobapp_qkm.m_lCtxLoaded = true;
    if ( ! (spadministration_dmobapp_qkm.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_dmobapp_qkm) || CPLib.IsLoaded(m_cWv_spadministration_dmobapp_qkm)) {
        spadministration_dmobapp_qkm.SetFromContext(m_cWv_spadministration_dmobapp_qkm);
        m_cWv_spadministration_dmobapp_qkm = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_dmobapp_qkm.m_bLoaded)) {
          spadministration_dmobapp_qkm.Blank();
          spadministration_dmobapp_qkm.w_QA_CODE = w_oa__code;
          spadministration_dmobapp_qkm.Load();
          if ( ! (spadministration_dmobapp_qkm.m_bLoaded)) {
            spadministration_dmobapp_qkm.Initialize();
            spadministration_dmobapp_qkm.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_spadministration_mobapppermissions() {
    if (spadministration_mobapppermissions.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_mobapppermissions) || CPLib.IsLoaded(m_cWv_spadministration_mobapppermissions))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_mobapppermissions.m_bLoaded)) {
      spadministration_mobapppermissions.Blank();
      spadministration_mobapppermissions.w_pecodice = w_oa__code;
      spadministration_mobapppermissions.Load();
    }
    return spadministration_mobapppermissions.m_bLoaded;
  }
  public void CtxLoad_spadministration_mobapppermissions() {
    if ( ! (spadministration_mobapppermissions.m_lCtxLoaded)) {
      spadministration_mobapppermissions.Blank();
    }
    spadministration_mobapppermissions.m_lCtxLoaded = true;
    if ( ! (spadministration_mobapppermissions.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_mobapppermissions) || CPLib.IsLoaded(m_cWv_spadministration_mobapppermissions)) {
        spadministration_mobapppermissions.SetFromContext(m_cWv_spadministration_mobapppermissions);
        m_cWv_spadministration_mobapppermissions = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_mobapppermissions.m_bLoaded)) {
          spadministration_mobapppermissions.Blank();
          spadministration_mobapppermissions.w_pecodice = w_oa__code;
          spadministration_mobapppermissions.Load();
          if ( ! (spadministration_mobapppermissions.m_bLoaded)) {
            spadministration_mobapppermissions.Initialize();
            spadministration_mobapppermissions.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"spadministration_dmobapp_qkm")) {
      CtxLoad_spadministration_dmobapp_qkm();
      return spadministration_dmobapp_qkm;
    }
    if (CPLib.eq(p_cName,"spadministration_mobapppermissions")) {
      CtxLoad_spadministration_mobapppermissions();
      return spadministration_mobapppermissions;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- spadministration_mobappstore
  String calc_url(){
    return SPLib.GetWebRootPath()+"/jsp-system/spadministration_mobappreg.jsp";
  }
  // * --- Fine Area Manuale
}
