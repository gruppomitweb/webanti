import java.util.*;

public class ardt_fatca_indBL extends ardt_fatca_indWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_COUNTRYCOD;
    public String w_COUNTRYSUB;
    public String w_ADDRESSTYP;
    public String w_TEL;
    public String w_EMAIL;
    public String w_IDBASE;
    public String w_CAREOF;
    public String w_DISTRICTNA;
    public String w_POSTCODE;
    public String w_CITY;
    public String w_STREET;
    public String w_BUILDINGID;
    public String w_FLOORIDENT;
    public String w_SUITEIDENT;
    public String w_POB;
    public double w_CPROWNUM;
    public String w_xdescpaese;
    public int m_nCPRowNum;
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
  public static final String i_EntityName = "ardt_fatca_ind";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_fatca_ind;
  public String m_cServer_fatca_ind;
  public CPPhTableWrInfo m_oWrInfo_fatca_ind;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_fatca_ind;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"fatca_ind"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CONNES':CONNES,'m_Detail':{'COUNTRYCOD':COUNTRYCOD,'COUNTRYSUB':COUNTRYSUB,'ADDRESSTYP':ADDRESSTYP,'TEL':TEL,'EMAIL':EMAIL,'CAREOF':CAREOF,'DISTRICTNA':DISTRICTNA,'POSTCODE':POSTCODE,'CITY':CITY,'STREET':STREET,'BUILDINGID':BUILDINGID,'FLOORIDENT':FLOORIDENT,'SUITEIDENT':SUITEIDENT,'POB':POB,'CPROWNUM':CPROWNUM"+FoundlingChildrenList("ardt_fatca_ind",true,true)+"}"+FoundlingChildrenList("ardt_fatca_ind",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'CONNES':CONNES,'tipoIND':tipoIND,'m_Detail':{'COUNTRYCOD':COUNTRYCOD,'COUNTRYSUB':COUNTRYSUB,'ADDRESSTYP':ADDRESSTYP,'TEL':TEL,'EMAIL':EMAIL,'IDBASE':IDBASE,'CAREOF':CAREOF,'DISTRICTNA':DISTRICTNA,'POSTCODE':POSTCODE,'CITY':CITY,'STREET':STREET,'BUILDINGID':BUILDINGID,'FLOORIDENT':FLOORIDENT,'SUITEIDENT':SUITEIDENT,'POB':POB,'CPROWNUM':CPROWNUM,'xdescpaese':xdescpaese"+FoundlingChildrenList("ardt_fatca_ind",true,true)+"}"+FoundlingChildrenList("ardt_fatca_ind",true,false)+"}";
  public static final String i_ItemSequence = "CONNES,m_Detail[ COUNTRYCOD COUNTRYSUB ADDRESSTYP TEL EMAIL CAREOF DISTRICTNA POSTCODE CITY STREET BUILDINGID FLOORIDENT SUITEIDENT POB CPROWNUM"+FoundlingChildrenList("ardt_fatca_ind",false,true)+"]"+FoundlingChildrenList("ardt_fatca_ind",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("ardt_fatca_ind"),new String[][]{new String[]{"CONNES","Soggetto","C","16","0","campo","key1","false","false"},new String[]{"COUNTRYCOD","","C","2","0","campo","nokey","true","false"},new String[]{"COUNTRYSUB","","C","30","0","campo","nokey","true","false"},new String[]{"ADDRESSTYP","Via/Piazza","C","7","0","campo","nokey","true","false"},new String[]{"TEL","","C","40","0","campo","nokey","true","false"},new String[]{"EMAIL","","C","50","0","campo","nokey","true","false"},new String[]{"CAREOF","","C","80","0","campo","nokey","true","false"},new String[]{"DISTRICTNA","","C","30","0","campo","nokey","true","false"},new String[]{"POSTCODE","","C","20","0","campo","nokey","true","false"},new String[]{"CITY","","C","40","0","campo","nokey","true","false"},new String[]{"STREET","","C","60","0","campo","nokey","true","false"},new String[]{"BUILDINGID","","C","20","0","campo","nokey","true","false"},new String[]{"FLOORIDENT","","C","20","0","campo","nokey","true","false"},new String[]{"SUITEIDENT","","C","20","0","campo","nokey","true","false"},new String[]{"POB","","C","20","0","campo","nokey","true","false"},new String[]{"CPROWNUM","","N","4","0","campo","key1","true","false"}});
  public static final String i_TrsKeys = ",CPROWNUM";
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
  // Variabile per la gestione del CPROWNUM
  public int m_nCPRowNum;
  public ardt_fatca_indBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_fatca_ind = p_ContextObject.GetPhName("fatca_ind",p_ContextObject.GetCompany(),false);
    m_cServer_fatca_ind = p_ContextObject.GetServer("fatca_ind");
    m_oWrInfo_fatca_ind = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"fatca_ind",p_ContextObject.GetCompany());
    m_cVirtName_fatca_ind = CPSql.ManipulateTablePhName("fatca_ind",m_cServer_fatca_ind);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("ardt_fatca_ind",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CONNES = "";
    w_tipoIND = "";
    w_COUNTRYCOD = "";
    w_COUNTRYSUB = "";
    w_ADDRESSTYP = "";
    w_TEL = "";
    w_EMAIL = "";
    w_IDBASE = "";
    w_CAREOF = "";
    w_DISTRICTNA = "";
    w_POSTCODE = "";
    w_CITY = "";
    w_STREET = "";
    w_BUILDINGID = "";
    w_FLOORIDENT = "";
    w_SUITEIDENT = "";
    w_POB = "";
    w_CPROWNUM = 0;
    w_xdescpaese = "";
    Link_QXOWROTOBD();
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
    if (CPLib.eq(p_cEvent,"Insert row start")) {
      Calculation_UWBQFYRDAL();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_QXOWROTOBD() {
    return Link_QXOWROTOBD("Full");
  }
  protected boolean Link_QXOWROTOBD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_COUNTRYCOD))) {
      String l_OldValue = w_COUNTRYCOD;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COUNTRYCOD,"C",2,0),m_cServer_tbstati,w_COUNTRYCOD);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select ISO2,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"ISO2"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COUNTRYCOD,"C",40,0),m_cServer_tbstati,w_COUNTRYCOD);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstati,"select ISO2,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_COUNTRYCOD = l_rsLink.GetString("ISO2");
          w_xdescpaese = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QXOWROTOBD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_COUNTRYCOD = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","COUNTRYCOD");
          }
          m_cLastWorkVarError = "COUNTRYCOD";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QXOWROTOBD_blank();
    }
    return l_bResult;
  }
  void Link_QXOWROTOBD_blank() {
    w_COUNTRYCOD = "";
    w_xdescpaese = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CONNES(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNES = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COUNTRYCOD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_COUNTRYCOD = p_workVariableValue;
    l_bResult = Link_QXOWROTOBD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_COUNTRYCOD = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COUNTRYSUB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_COUNTRYSUB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ADDRESSTYP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ADDRESSTYP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TEL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_TEL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_EMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_EMAIL = p_workVariableValue;
    // 
    l_bResult = arfn_emailokR.Make(m_Ctx,this).Run(w_EMAIL);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_EMAIL = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAREOF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CAREOF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DISTRICTNA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DISTRICTNA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_POSTCODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_POSTCODE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CITY(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CITY = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_STREET(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_STREET = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BUILDINGID(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_BUILDINGID = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLOORIDENT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_FLOORIDENT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SUITEIDENT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_SUITEIDENT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_POB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_POB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPROWNUM(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CPROWNUM = p_workVariableValue;
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
  void Calculation_UWBQFYRDAL() {
    w_IDBASE = LibreriaMit.UniqueId();
  }
  boolean Check_ACAOQGBTKF(boolean p_bForce) {
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
    m_nCPRowNum = 0;
    m_cOldRowCPCCCHK = "";
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"CONNES"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("ardt_fatca_ind","fatca_ind",m_KeyColumns,m_Ctx);
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
    w_CONNES = "";
    w_tipoIND = "";
    w_COUNTRYCOD = "";
    w_COUNTRYSUB = "";
    w_ADDRESSTYP = "";
    w_TEL = "";
    w_EMAIL = "";
    w_IDBASE = "";
    w_CAREOF = "";
    w_DISTRICTNA = "";
    w_POSTCODE = "";
    w_CITY = "";
    w_STREET = "";
    w_BUILDINGID = "";
    w_FLOORIDENT = "";
    w_SUITEIDENT = "";
    w_POB = "";
    w_CPROWNUM = 0;
    w_xdescpaese = "";
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
      Properties p_COUNTRYCOD;
      p_COUNTRYCOD = CPLib.GetProperties(trs_p.getProperty("COUNTRYCOD"),new Properties());
      Properties p_COUNTRYSUB;
      p_COUNTRYSUB = CPLib.GetProperties(trs_p.getProperty("COUNTRYSUB"),new Properties());
      Properties p_ADDRESSTYP;
      p_ADDRESSTYP = CPLib.GetProperties(trs_p.getProperty("ADDRESSTYP"),new Properties());
      Properties p_TEL;
      p_TEL = CPLib.GetProperties(trs_p.getProperty("TEL"),new Properties());
      Properties p_EMAIL;
      p_EMAIL = CPLib.GetProperties(trs_p.getProperty("EMAIL"),new Properties());
      Properties p_IDBASE;
      p_IDBASE = CPLib.GetProperties(trs_p.getProperty("IDBASE"),new Properties());
      Properties p_CAREOF;
      p_CAREOF = CPLib.GetProperties(trs_p.getProperty("CAREOF"),new Properties());
      Properties p_DISTRICTNA;
      p_DISTRICTNA = CPLib.GetProperties(trs_p.getProperty("DISTRICTNA"),new Properties());
      Properties p_POSTCODE;
      p_POSTCODE = CPLib.GetProperties(trs_p.getProperty("POSTCODE"),new Properties());
      Properties p_CITY;
      p_CITY = CPLib.GetProperties(trs_p.getProperty("CITY"),new Properties());
      Properties p_STREET;
      p_STREET = CPLib.GetProperties(trs_p.getProperty("STREET"),new Properties());
      Properties p_BUILDINGID;
      p_BUILDINGID = CPLib.GetProperties(trs_p.getProperty("BUILDINGID"),new Properties());
      Properties p_FLOORIDENT;
      p_FLOORIDENT = CPLib.GetProperties(trs_p.getProperty("FLOORIDENT"),new Properties());
      Properties p_SUITEIDENT;
      p_SUITEIDENT = CPLib.GetProperties(trs_p.getProperty("SUITEIDENT"),new Properties());
      Properties p_POB;
      p_POB = CPLib.GetProperties(trs_p.getProperty("POB"),new Properties());
      Properties p_CPROWNUM;
      p_CPROWNUM = CPLib.GetProperties(trs_p.getProperty("CPROWNUM"),new Properties());
      Properties p_xdescpaese;
      p_xdescpaese = CPLib.GetProperties(trs_p.getProperty("xdescpaese"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_CONNES = CPLib.GetProperty(p,"CONNES",w_CONNES,0);
      w_tipoIND = CPLib.GetProperty(p,"tipoIND",w_tipoIND,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_COUNTRYCOD = "";
        w_COUNTRYCOD = CPLib.GetProperty(p_COUNTRYCOD,"",w_COUNTRYCOD,i);
        w_COUNTRYSUB = "";
        w_COUNTRYSUB = CPLib.GetProperty(p_COUNTRYSUB,"",w_COUNTRYSUB,i);
        w_ADDRESSTYP = "";
        w_ADDRESSTYP = CPLib.GetProperty(p_ADDRESSTYP,"",w_ADDRESSTYP,i);
        w_TEL = "";
        w_TEL = CPLib.GetProperty(p_TEL,"",w_TEL,i);
        w_EMAIL = "";
        w_EMAIL = CPLib.GetProperty(p_EMAIL,"",w_EMAIL,i);
        w_IDBASE = "";
        w_IDBASE = CPLib.GetProperty(p_IDBASE,"",w_IDBASE,i);
        w_CAREOF = "";
        w_CAREOF = CPLib.GetProperty(p_CAREOF,"",w_CAREOF,i);
        w_DISTRICTNA = "";
        w_DISTRICTNA = CPLib.GetProperty(p_DISTRICTNA,"",w_DISTRICTNA,i);
        w_POSTCODE = "";
        w_POSTCODE = CPLib.GetProperty(p_POSTCODE,"",w_POSTCODE,i);
        w_CITY = "";
        w_CITY = CPLib.GetProperty(p_CITY,"",w_CITY,i);
        w_STREET = "";
        w_STREET = CPLib.GetProperty(p_STREET,"",w_STREET,i);
        w_BUILDINGID = "";
        w_BUILDINGID = CPLib.GetProperty(p_BUILDINGID,"",w_BUILDINGID,i);
        w_FLOORIDENT = "";
        w_FLOORIDENT = CPLib.GetProperty(p_FLOORIDENT,"",w_FLOORIDENT,i);
        w_SUITEIDENT = "";
        w_SUITEIDENT = CPLib.GetProperty(p_SUITEIDENT,"",w_SUITEIDENT,i);
        w_POB = "";
        w_POB = CPLib.GetProperty(p_POB,"",w_POB,i);
        w_CPROWNUM = 0;
        w_CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",w_CPROWNUM,i);
        w_xdescpaese = "";
        w_xdescpaese = CPLib.GetProperty(p_xdescpaese,"",w_xdescpaese,i);
        m_nCPRowNum = (int)CPLib.GetProperty(p_m_nCPRowNum,"",0,i);
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
    if (CPLib.eq(p_cName,"CONNES")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"COUNTRYCOD")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"COUNTRYSUB")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ADDRESSTYP")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"TEL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"EMAIL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CAREOF")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DISTRICTNA")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"POSTCODE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CITY")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"STREET")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"BUILDINGID")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"FLOORIDENT")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"SUITEIDENT")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"POB")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CPROWNUM")) {
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
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"ISO2","DESCRI"});
    map.put("rd_var",new String[]{"w_COUNTRYCOD","w_xdescpaese"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati (ISO)\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("ardt_fatca_ind",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_fatca_ind",child);
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
    for(String child : CPLib.LoadableMNTs("ardt_fatca_ind",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_fatca_ind",child);
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
    m_MNTs = CPLib.MNTChilds("ardt_fatca_ind",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    l_bResult = true;
    if ( ! (CPLib.Empty(w_COUNTRYCOD))) {
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
      l_Keys = new String[]{"ardt_fatca_ind"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"ardt_fatca_ind\\"+p_cState};
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
    Properties p_COUNTRYCOD;
    p_COUNTRYCOD = new Properties();
    Properties p_COUNTRYSUB;
    p_COUNTRYSUB = new Properties();
    Properties p_ADDRESSTYP;
    p_ADDRESSTYP = new Properties();
    Properties p_TEL;
    p_TEL = new Properties();
    Properties p_EMAIL;
    p_EMAIL = new Properties();
    Properties p_IDBASE;
    p_IDBASE = new Properties();
    Properties p_CAREOF;
    p_CAREOF = new Properties();
    Properties p_DISTRICTNA;
    p_DISTRICTNA = new Properties();
    Properties p_POSTCODE;
    p_POSTCODE = new Properties();
    Properties p_CITY;
    p_CITY = new Properties();
    Properties p_STREET;
    p_STREET = new Properties();
    Properties p_BUILDINGID;
    p_BUILDINGID = new Properties();
    Properties p_FLOORIDENT;
    p_FLOORIDENT = new Properties();
    Properties p_SUITEIDENT;
    p_SUITEIDENT = new Properties();
    Properties p_POB;
    p_POB = new Properties();
    Properties p_CPROWNUM;
    p_CPROWNUM = new Properties();
    Properties p_xdescpaese;
    p_xdescpaese = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"CONNES",w_CONNES,0);
    CPLib.PutProperty(p,"tipoIND",w_tipoIND,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_COUNTRYCOD,"",w_COUNTRYCOD,trsrow);
      CPLib.PutProperty(p_COUNTRYSUB,"",w_COUNTRYSUB,trsrow);
      CPLib.PutProperty(p_ADDRESSTYP,"",w_ADDRESSTYP,trsrow);
      CPLib.PutProperty(p_TEL,"",w_TEL,trsrow);
      CPLib.PutProperty(p_EMAIL,"",w_EMAIL,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_CAREOF,"",w_CAREOF,trsrow);
      CPLib.PutProperty(p_DISTRICTNA,"",w_DISTRICTNA,trsrow);
      CPLib.PutProperty(p_POSTCODE,"",w_POSTCODE,trsrow);
      CPLib.PutProperty(p_CITY,"",w_CITY,trsrow);
      CPLib.PutProperty(p_STREET,"",w_STREET,trsrow);
      CPLib.PutProperty(p_BUILDINGID,"",w_BUILDINGID,trsrow);
      CPLib.PutProperty(p_FLOORIDENT,"",w_FLOORIDENT,trsrow);
      CPLib.PutProperty(p_SUITEIDENT,"",w_SUITEIDENT,trsrow);
      CPLib.PutProperty(p_POB,"",w_POB,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_xdescpaese,"",w_xdescpaese,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
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
      CPLib.PutProperty(p_COUNTRYCOD,"",w_COUNTRYCOD,trsrow);
      CPLib.PutProperty(p_COUNTRYSUB,"",w_COUNTRYSUB,trsrow);
      CPLib.PutProperty(p_ADDRESSTYP,"",w_ADDRESSTYP,trsrow);
      CPLib.PutProperty(p_TEL,"",w_TEL,trsrow);
      CPLib.PutProperty(p_EMAIL,"",w_EMAIL,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_CAREOF,"",w_CAREOF,trsrow);
      CPLib.PutProperty(p_DISTRICTNA,"",w_DISTRICTNA,trsrow);
      CPLib.PutProperty(p_POSTCODE,"",w_POSTCODE,trsrow);
      CPLib.PutProperty(p_CITY,"",w_CITY,trsrow);
      CPLib.PutProperty(p_STREET,"",w_STREET,trsrow);
      CPLib.PutProperty(p_BUILDINGID,"",w_BUILDINGID,trsrow);
      CPLib.PutProperty(p_FLOORIDENT,"",w_FLOORIDENT,trsrow);
      CPLib.PutProperty(p_SUITEIDENT,"",w_SUITEIDENT,trsrow);
      CPLib.PutProperty(p_POB,"",w_POB,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_xdescpaese,"",w_xdescpaese,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("COUNTRYCOD",CPLib.ToProperties(p_COUNTRYCOD));
    trs_p.setProperty("COUNTRYSUB",CPLib.ToProperties(p_COUNTRYSUB));
    trs_p.setProperty("ADDRESSTYP",CPLib.ToProperties(p_ADDRESSTYP));
    trs_p.setProperty("TEL",CPLib.ToProperties(p_TEL));
    trs_p.setProperty("EMAIL",CPLib.ToProperties(p_EMAIL));
    trs_p.setProperty("IDBASE",CPLib.ToProperties(p_IDBASE));
    trs_p.setProperty("CAREOF",CPLib.ToProperties(p_CAREOF));
    trs_p.setProperty("DISTRICTNA",CPLib.ToProperties(p_DISTRICTNA));
    trs_p.setProperty("POSTCODE",CPLib.ToProperties(p_POSTCODE));
    trs_p.setProperty("CITY",CPLib.ToProperties(p_CITY));
    trs_p.setProperty("STREET",CPLib.ToProperties(p_STREET));
    trs_p.setProperty("BUILDINGID",CPLib.ToProperties(p_BUILDINGID));
    trs_p.setProperty("FLOORIDENT",CPLib.ToProperties(p_FLOORIDENT));
    trs_p.setProperty("SUITEIDENT",CPLib.ToProperties(p_SUITEIDENT));
    trs_p.setProperty("POB",CPLib.ToProperties(p_POB));
    trs_p.setProperty("CPROWNUM",CPLib.ToProperties(p_CPROWNUM));
    trs_p.setProperty("xdescpaese",CPLib.ToProperties(p_xdescpaese));
    trs_p.setProperty("m_nCPRowNum",CPLib.ToProperties(p_m_nCPRowNum));
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
    return "fatca_ind"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CONNES","C",16,0));
  }
  public String RowPrimaryKey() {
    return "fatca_ind"+"\\"+CPLib.ToCPStr(w_CPROWNUM);
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
    w_COUNTRYCOD= m_oTrs.get(m_nCurrentRow).w_COUNTRYCOD;
    w_COUNTRYSUB= m_oTrs.get(m_nCurrentRow).w_COUNTRYSUB;
    w_ADDRESSTYP= m_oTrs.get(m_nCurrentRow).w_ADDRESSTYP;
    w_TEL= m_oTrs.get(m_nCurrentRow).w_TEL;
    w_EMAIL= m_oTrs.get(m_nCurrentRow).w_EMAIL;
    w_IDBASE= m_oTrs.get(m_nCurrentRow).w_IDBASE;
    w_CAREOF= m_oTrs.get(m_nCurrentRow).w_CAREOF;
    w_DISTRICTNA= m_oTrs.get(m_nCurrentRow).w_DISTRICTNA;
    w_POSTCODE= m_oTrs.get(m_nCurrentRow).w_POSTCODE;
    w_CITY= m_oTrs.get(m_nCurrentRow).w_CITY;
    w_STREET= m_oTrs.get(m_nCurrentRow).w_STREET;
    w_BUILDINGID= m_oTrs.get(m_nCurrentRow).w_BUILDINGID;
    w_FLOORIDENT= m_oTrs.get(m_nCurrentRow).w_FLOORIDENT;
    w_SUITEIDENT= m_oTrs.get(m_nCurrentRow).w_SUITEIDENT;
    w_POB= m_oTrs.get(m_nCurrentRow).w_POB;
    w_CPROWNUM= m_oTrs.get(m_nCurrentRow).w_CPROWNUM;
    w_xdescpaese= m_oTrs.get(m_nCurrentRow).w_xdescpaese;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_COUNTRYCOD=w_COUNTRYCOD;
    m_oTrs.get(m_nCurrentRow).w_COUNTRYSUB=w_COUNTRYSUB;
    m_oTrs.get(m_nCurrentRow).w_ADDRESSTYP=w_ADDRESSTYP;
    m_oTrs.get(m_nCurrentRow).w_TEL=w_TEL;
    m_oTrs.get(m_nCurrentRow).w_EMAIL=w_EMAIL;
    m_oTrs.get(m_nCurrentRow).w_IDBASE=w_IDBASE;
    m_oTrs.get(m_nCurrentRow).w_CAREOF=w_CAREOF;
    m_oTrs.get(m_nCurrentRow).w_DISTRICTNA=w_DISTRICTNA;
    m_oTrs.get(m_nCurrentRow).w_POSTCODE=w_POSTCODE;
    m_oTrs.get(m_nCurrentRow).w_CITY=w_CITY;
    m_oTrs.get(m_nCurrentRow).w_STREET=w_STREET;
    m_oTrs.get(m_nCurrentRow).w_BUILDINGID=w_BUILDINGID;
    m_oTrs.get(m_nCurrentRow).w_FLOORIDENT=w_FLOORIDENT;
    m_oTrs.get(m_nCurrentRow).w_SUITEIDENT=w_SUITEIDENT;
    m_oTrs.get(m_nCurrentRow).w_POB=w_POB;
    m_oTrs.get(m_nCurrentRow).w_CPROWNUM=w_CPROWNUM;
    m_oTrs.get(m_nCurrentRow).w_xdescpaese=w_xdescpaese;
    m_oTrs.get(m_nCurrentRow).m_nCPRowNum=m_nCPRowNum;
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
    int i;
    double l_nRowCprownum;
    m_nCPRowNum = 0;
    for ( i = 0; CPLib.lt(i,Rows()); i = i + (1)) {
      l_nRowCprownum= m_oTrs.get(i).w_CPROWNUM;
      if (CPLib.gt(l_nRowCprownum,m_nCPRowNum)) {
        m_nCPRowNum = (int)l_nRowCprownum;
      }
    }
    m_nCPRowNum = m_nCPRowNum+1;
    w_CPROWNUM = m_nCPRowNum;
    // Inizializzazione delle variabili di work al loro valore di blank
    w_COUNTRYCOD = "";
    w_COUNTRYSUB = "";
    w_ADDRESSTYP = "";
    w_TEL = "";
    w_EMAIL = "";
    w_IDBASE = "";
    w_CAREOF = "";
    w_DISTRICTNA = "";
    w_POSTCODE = "";
    w_CITY = "";
    w_STREET = "";
    w_BUILDINGID = "";
    w_FLOORIDENT = "";
    w_SUITEIDENT = "";
    w_POB = "";
    w_xdescpaese = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if ( ! (CPLib.Empty(w_COUNTRYCOD))) {
      l_bTmpRes = Link_QXOWROTOBD();
    }
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
    m_oDeletedRows.get(l_nRows).w_COUNTRYCOD=w_COUNTRYCOD;
    m_oDeletedRows.get(l_nRows).w_COUNTRYSUB=w_COUNTRYSUB;
    m_oDeletedRows.get(l_nRows).w_ADDRESSTYP=w_ADDRESSTYP;
    m_oDeletedRows.get(l_nRows).w_TEL=w_TEL;
    m_oDeletedRows.get(l_nRows).w_EMAIL=w_EMAIL;
    m_oDeletedRows.get(l_nRows).w_IDBASE=w_IDBASE;
    m_oDeletedRows.get(l_nRows).w_CAREOF=w_CAREOF;
    m_oDeletedRows.get(l_nRows).w_DISTRICTNA=w_DISTRICTNA;
    m_oDeletedRows.get(l_nRows).w_POSTCODE=w_POSTCODE;
    m_oDeletedRows.get(l_nRows).w_CITY=w_CITY;
    m_oDeletedRows.get(l_nRows).w_STREET=w_STREET;
    m_oDeletedRows.get(l_nRows).w_BUILDINGID=w_BUILDINGID;
    m_oDeletedRows.get(l_nRows).w_FLOORIDENT=w_FLOORIDENT;
    m_oDeletedRows.get(l_nRows).w_SUITEIDENT=w_SUITEIDENT;
    m_oDeletedRows.get(l_nRows).w_POB=w_POB;
    m_oDeletedRows.get(l_nRows).w_CPROWNUM=w_CPROWNUM;
    m_oDeletedRows.get(l_nRows).w_xdescpaese=w_xdescpaese;
    m_oDeletedRows.get(l_nRows).m_nCPRowNum=m_nCPRowNum;
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
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
      if ( ! (arfn_emailokR.Make(m_Ctx,this).Run(w_EMAIL))) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = "EMAIL : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
        l_bResult = false;
        w_EMAIL = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "EMAIL";
        }
      } else if ( ! (Check_ACAOQGBTKF(true))) {
        l_bResult = false;
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
    }
    m_bUpdated = true;
    // Esecuzione dei calcoli
    Calculate();
    return true;
  }
  void SubtractTotals() {
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_COUNTRYCOD));
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
    w_COUNTRYCOD= m_oDeletedRows.get(l_RowNumberToSet).w_COUNTRYCOD;
    w_COUNTRYSUB= m_oDeletedRows.get(l_RowNumberToSet).w_COUNTRYSUB;
    w_ADDRESSTYP= m_oDeletedRows.get(l_RowNumberToSet).w_ADDRESSTYP;
    w_TEL= m_oDeletedRows.get(l_RowNumberToSet).w_TEL;
    w_EMAIL= m_oDeletedRows.get(l_RowNumberToSet).w_EMAIL;
    w_IDBASE= m_oDeletedRows.get(l_RowNumberToSet).w_IDBASE;
    w_CAREOF= m_oDeletedRows.get(l_RowNumberToSet).w_CAREOF;
    w_DISTRICTNA= m_oDeletedRows.get(l_RowNumberToSet).w_DISTRICTNA;
    w_POSTCODE= m_oDeletedRows.get(l_RowNumberToSet).w_POSTCODE;
    w_CITY= m_oDeletedRows.get(l_RowNumberToSet).w_CITY;
    w_STREET= m_oDeletedRows.get(l_RowNumberToSet).w_STREET;
    w_BUILDINGID= m_oDeletedRows.get(l_RowNumberToSet).w_BUILDINGID;
    w_FLOORIDENT= m_oDeletedRows.get(l_RowNumberToSet).w_FLOORIDENT;
    w_SUITEIDENT= m_oDeletedRows.get(l_RowNumberToSet).w_SUITEIDENT;
    w_POB= m_oDeletedRows.get(l_RowNumberToSet).w_POB;
    w_CPROWNUM= m_oDeletedRows.get(l_RowNumberToSet).w_CPROWNUM;
    w_xdescpaese= m_oDeletedRows.get(l_RowNumberToSet).w_xdescpaese;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
