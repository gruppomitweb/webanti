import java.util.*;

public class aosdt_rilevazioniBL extends aosdt_rilevazioniWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_IDIND;
    public String w_IDSUBIND;
    public String w_NOTA;
    public String w_PROGIND;
    public String w_DESCIND;
    public String w_PROGSUBIND;
    public String w_DESCSUB;
    public String opk_IDIND;
    public String opk_IDSUBIND;
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
  public static final String i_EntityName = "aosdt_rilevazioni";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_rilevazioni;
  public String m_cServer_rilevazioni;
  public CPPhTableWrInfo m_oWrInfo_rilevazioni;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_rilevazioni;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_mod_ind_def;
  public String m_cServer_mod_ind_def;
  public CPPhTableWrInfo m_oWrInfo_mod_ind_def;
  public String m_cPhName_ind_def;
  public String m_cServer_ind_def;
  public CPPhTableWrInfo m_oWrInfo_ind_def;
  public String m_cPhName_sub_ind_def;
  public String m_cServer_sub_ind_def;
  public CPPhTableWrInfo m_oWrInfo_sub_ind_def;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"rilevazioni"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CONNES':CONNES,'DTRIL':DTRIL,'IDMOD':IDMOD,'m_Detail':{'IDIND':IDIND,'IDSUBIND':IDSUBIND,'NOTA':NOTA,'DESCIND':DESCIND"+FoundlingChildrenList("aosdt_rilevazioni",true,true)+"}"+FoundlingChildrenList("aosdt_rilevazioni",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'CONNES':CONNES,'DTRIL':DTRIL,'IDMOD':IDMOD,'DESMODEL':DESMODEL,'m_Detail':{'IDIND':IDIND,'IDSUBIND':IDSUBIND,'NOTA':NOTA,'PROGIND':PROGIND,'DESCIND':DESCIND,'PROGSUBIND':PROGSUBIND,'DESCSUB':DESCSUB"+FoundlingChildrenList("aosdt_rilevazioni",true,true)+"}"+FoundlingChildrenList("aosdt_rilevazioni",true,false)+"}";
  public static final String i_ItemSequence = "CONNES,DTRIL,IDMOD,m_Detail[ IDIND IDSUBIND NOTA DESCIND"+FoundlingChildrenList("aosdt_rilevazioni",false,true)+"]"+FoundlingChildrenList("aosdt_rilevazioni",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("aosdt_rilevazioni"),new String[][]{new String[]{"CONNES","NDG Soggetto","C","16","0","campo","key1","false","false"},new String[]{"DTRIL","Data rilevazione","D","8","0","campo","key1","false","false"},new String[]{"IDMOD","ID del modello","C","10","0","campo","key1","false","false"},new String[]{"IDIND","ID del indicatore","C","10","0","campo","key1","true","false"},new String[]{"IDSUBIND","ID del subindicatore ","C","10","0","campo","key1","true","false"},new String[]{"NOTA","Nota Anomalia","M","10","0","campo","nokey","true","false"},new String[]{"DESCIND","Descrizione del indicatore","M","10","0","variabile","nokey","true","false"}});
  public static final String i_TrsKeys = ",IDIND,IDSUBIND";
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
  public aosdt_rilevazioniBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_rilevazioni = p_ContextObject.GetPhName("rilevazioni",p_ContextObject.GetCompany(),false);
    m_cServer_rilevazioni = p_ContextObject.GetServer("rilevazioni");
    m_oWrInfo_rilevazioni = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"rilevazioni",p_ContextObject.GetCompany());
    m_cVirtName_rilevazioni = CPSql.ManipulateTablePhName("rilevazioni",m_cServer_rilevazioni);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_mod_ind_def = p_ContextObject.GetPhName("mod_ind_def");
    m_cServer_mod_ind_def = p_ContextObject.GetServer("mod_ind_def");
    m_oWrInfo_mod_ind_def = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"mod_ind_def",p_ContextObject.GetCompany());
    m_cPhName_ind_def = p_ContextObject.GetPhName("ind_def");
    m_cServer_ind_def = p_ContextObject.GetServer("ind_def");
    m_oWrInfo_ind_def = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"ind_def",p_ContextObject.GetCompany());
    m_cPhName_sub_ind_def = p_ContextObject.GetPhName("sub_ind_def");
    m_cServer_sub_ind_def = p_ContextObject.GetServer("sub_ind_def");
    m_oWrInfo_sub_ind_def = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"sub_ind_def",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("aosdt_rilevazioni",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CONNES = "";
    w_IDMOD = "";
    w_DESMODEL = "";
    w_IDIND = "";
    w_IDSUBIND = "";
    w_NOTA = "";
    w_PROGIND = "";
    w_DESCIND = "";
    w_PROGSUBIND = "";
    w_DESCSUB = "";
    w_DTRIL = CPLib.Date();
    Link_GOROYGEXRL();
    Link_YTRSZBFLPF();
    Link_AIIXUOGHMQ();
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
    if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_ZRXYYQLTXO();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_ZRXYYQLTXO();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_GOROYGEXRL() {
    return Link_GOROYGEXRL("Full");
  }
  protected boolean Link_GOROYGEXRL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDMOD))) {
      String l_OldValue = w_IDMOD;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDMOD,"C",10,0),m_cServer_mod_ind_def,w_IDMOD);
      if (m_Ctx.IsSharedTemp("mod_ind_def")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_mod_ind_def,"select IDMOD,DESCRI from "+m_cPhName_mod_ind_def+((m_cPhName_mod_ind_def).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDMOD"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDMOD = l_rsLink.GetString("IDMOD");
          w_DESMODEL = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_GOROYGEXRL_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDMOD = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDMOD");
          }
          m_cLastWorkVarError = "IDMOD";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_GOROYGEXRL_blank();
    }
    return l_bResult;
  }
  void Link_GOROYGEXRL_blank() {
    w_IDMOD = "";
    w_DESMODEL = "";
  }
  protected boolean Link_YTRSZBFLPF() {
    return Link_YTRSZBFLPF("Full");
  }
  protected boolean Link_YTRSZBFLPF(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDIND))) {
      String l_OldValue = w_IDIND;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDIND,"C",10,0),m_cServer_ind_def,w_IDIND);
      l_cWhere = l_cWhere+" and IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDMOD,"C",10,0),m_cServer_ind_def,w_IDMOD);
      if (m_Ctx.IsSharedTemp("ind_def")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_ind_def,"select IDMOD,IDIND,PROGIND,DESCRI from "+m_cPhName_ind_def+((m_cPhName_ind_def).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDIND"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDIND = l_rsLink.GetString("IDIND");
          w_PROGIND = l_rsLink.GetString("PROGIND");
          w_DESCIND = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_YTRSZBFLPF_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDIND = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDIND");
          }
          m_cLastWorkVarError = "IDIND";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_YTRSZBFLPF_blank();
    }
    return l_bResult;
  }
  void Link_YTRSZBFLPF_blank() {
    w_IDIND = "";
    w_PROGIND = "";
    w_DESCIND = "";
  }
  protected boolean Link_AIIXUOGHMQ() {
    return Link_AIIXUOGHMQ("Full");
  }
  protected boolean Link_AIIXUOGHMQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDSUBIND))) {
      String l_OldValue = w_IDSUBIND;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDSUBIND,"C",10,0),m_cServer_sub_ind_def,w_IDSUBIND);
      l_cWhere = l_cWhere+" and IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDMOD,"C",10,0),m_cServer_sub_ind_def,w_IDMOD);
      l_cWhere = l_cWhere+" and IDIND = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDIND,"C",10,0),m_cServer_sub_ind_def,w_IDIND);
      if (m_Ctx.IsSharedTemp("sub_ind_def")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_sub_ind_def,"select IDMOD,IDIND,IDSUBIND,PROGSUBIND,DESCRI from "+m_cPhName_sub_ind_def+((m_cPhName_sub_ind_def).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDSUBIND"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDSUBIND = l_rsLink.GetString("IDSUBIND");
          w_PROGSUBIND = l_rsLink.GetString("PROGSUBIND");
          w_DESCSUB = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AIIXUOGHMQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDSUBIND = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDSUBIND");
          }
          m_cLastWorkVarError = "IDSUBIND";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AIIXUOGHMQ_blank();
    }
    return l_bResult;
  }
  void Link_AIIXUOGHMQ_blank() {
    w_IDSUBIND = "";
    w_PROGSUBIND = "";
    w_DESCSUB = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CONNES(String p_workVariableValue) {
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
  public boolean Set_DTRIL(java.sql.Date p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DTRIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDMOD(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDMOD = p_workVariableValue;
    l_bResult = Link_GOROYGEXRL();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (CPLib.Empty(w_IDIND))) {
      l_bTmpRes = Link_YTRSZBFLPF();
    }
    if ( ! (CPLib.Empty(w_IDSUBIND))) {
      l_bTmpRes = Link_AIIXUOGHMQ();
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDMOD = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDIND(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_IDIND = p_workVariableValue;
    l_bResult = Link_YTRSZBFLPF();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDIND = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDSUBIND(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_IDSUBIND = p_workVariableValue;
    l_bResult = Link_AIIXUOGHMQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDSUBIND = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOTA(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_NOTA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCIND(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DESCIND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_CONNES() {
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
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_ZRXYYQLTXO() {
    aosrt_salva_rilevazioniR l_oRoutine_aosrt_salva_rilevazioni;
    l_oRoutine_aosrt_salva_rilevazioni = aosrt_salva_rilevazioniR.Make(m_Ctx,this);
    l_oRoutine_aosrt_salva_rilevazioni.pConnes = w_CONNES;
    l_oRoutine_aosrt_salva_rilevazioni.pData = w_DTRIL;
    l_oRoutine_aosrt_salva_rilevazioni.pModello = w_IDMOD;
    l_oRoutine_aosrt_salva_rilevazioni.pTipo = "S";
    l_oRoutine_aosrt_salva_rilevazioni.Run();
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
  public final static String[] m_KeyColumns = {"CONNES","DTRIL","IDMOD"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("aosdt_rilevazioni","rilevazioni",m_KeyColumns,m_Ctx);
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
    w_DTRIL = CPLib.NullDate();
    w_IDMOD = "";
    w_DESMODEL = "";
    w_IDIND = "";
    w_IDSUBIND = "";
    w_NOTA = "";
    w_PROGIND = "";
    w_DESCIND = "";
    w_PROGSUBIND = "";
    w_DESCSUB = "";
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
      Properties p_IDSUBIND;
      p_IDSUBIND = CPLib.GetProperties(trs_p.getProperty("IDSUBIND"),new Properties());
      Properties p_NOTA;
      p_NOTA = CPLib.GetProperties(trs_p.getProperty("NOTA"),new Properties());
      Properties p_PROGIND;
      p_PROGIND = CPLib.GetProperties(trs_p.getProperty("PROGIND"),new Properties());
      Properties p_DESCIND;
      p_DESCIND = CPLib.GetProperties(trs_p.getProperty("DESCIND"),new Properties());
      Properties p_PROGSUBIND;
      p_PROGSUBIND = CPLib.GetProperties(trs_p.getProperty("PROGSUBIND"),new Properties());
      Properties p_DESCSUB;
      p_DESCSUB = CPLib.GetProperties(trs_p.getProperty("DESCSUB"),new Properties());
      Properties p_opk_IDIND;
      p_opk_IDIND = CPLib.GetProperties(trs_p.getProperty("opk_IDIND"),new Properties());
      Properties p_opk_IDSUBIND;
      p_opk_IDSUBIND = CPLib.GetProperties(trs_p.getProperty("opk_IDSUBIND"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_CONNES = CPLib.GetProperty(p,"CONNES",w_CONNES,0);
      w_DTRIL = CPLib.GetProperty(p,"DTRIL",w_DTRIL,0);
      w_IDMOD = CPLib.GetProperty(p,"IDMOD",w_IDMOD,0);
      w_DESMODEL = CPLib.GetProperty(p,"DESMODEL",w_DESMODEL,0);
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
        w_IDSUBIND = "";
        w_IDSUBIND = CPLib.GetProperty(p_IDSUBIND,"",w_IDSUBIND,i);
        w_NOTA = "";
        w_NOTA = CPLib.GetProperty(p_NOTA,"",w_NOTA,i);
        w_PROGIND = "";
        w_PROGIND = CPLib.GetProperty(p_PROGIND,"",w_PROGIND,i);
        w_DESCIND = "";
        w_DESCIND = CPLib.GetProperty(p_DESCIND,"",w_DESCIND,i);
        w_PROGSUBIND = "";
        w_PROGSUBIND = CPLib.GetProperty(p_PROGSUBIND,"",w_PROGSUBIND,i);
        w_DESCSUB = "";
        w_DESCSUB = CPLib.GetProperty(p_DESCSUB,"",w_DESCSUB,i);
        opk_IDIND = CPLib.GetProperty(p_opk_IDIND,"","",i);
        opk_IDSUBIND = CPLib.GetProperty(p_opk_IDSUBIND,"","",i);
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
    if (CPLib.eq(p_cName,"DTRIL")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"IDMOD")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"IDIND")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"IDSUBIND")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"NOTA")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DESCIND")) {
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
    items = tables.get("mod_ind_def");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("mod_ind_def",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDMOD","DESCRI"});
    map.put("rd_var",new String[]{"w_IDMOD","w_DESMODEL"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u0000200",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ID del modello\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("mod_ind_def\u0000false\u0000false\u00001\u00000\u0000aosmt_mod_ind_def\u0000false\u0000false\u0000Modelli\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("ind_def");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("ind_def",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_IDMOD"});
    map.put("rd_kfield",new String[]{"IDMOD"});
    map.put("rd_field",new String[]{"IDIND","PROGIND","DESCRI"});
    map.put("rd_var",new String[]{"w_IDIND","w_PROGIND","w_DESCIND"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000M",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("10\u000010\u000010",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("ID del indicatore\u0000Progressivo indicatore\u0000Descrizione del indicatore",-1));
    map.put("rd_kvar.comment",zeroSplit.split("ID del modello",-1));
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("key1",-1));
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("ind_def\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Indicatori\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("sub_ind_def");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("sub_ind_def",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_IDMOD","w_IDIND"});
    map.put("rd_kfield",new String[]{"IDMOD","IDIND"});
    map.put("rd_field",new String[]{"IDSUBIND","PROGSUBIND","DESCRI"});
    map.put("rd_var",new String[]{"w_IDSUBIND","w_PROGSUBIND","w_DESCSUB"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000M",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_var.len",zeroSplit.split("10\u000010\u000010",-1));
    map.put("rd_kvar.len",zeroSplit.split("10\u000010",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_var.comment",zeroSplit.split("ID del subindicatore \u0000Progressivo subindicatore\u0000Descrizione del subindicatore",-1));
    map.put("rd_kvar.comment",zeroSplit.split("ID del modello\u0000ID del indicatore",-1));
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("key1\u0000key1",-1));
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE\u0000TRUE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo\u0000campo",-1));
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
    for(String child : CPLib.LoadableMNTs("aosdt_rilevazioni",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_rilevazioni",child);
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
    for(String child : CPLib.LoadableMNTs("aosdt_rilevazioni",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_rilevazioni",child);
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
    m_MNTs = CPLib.MNTChilds("aosdt_rilevazioni",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = true;
    if ( ! (CPLib.Empty(w_IDIND))) {
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
      l_Keys = new String[]{"aosdt_rilevazioni"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"aosdt_rilevazioni\\"+p_cState};
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
    Properties p_IDIND;
    p_IDIND = new Properties();
    Properties p_IDSUBIND;
    p_IDSUBIND = new Properties();
    Properties p_NOTA;
    p_NOTA = new Properties();
    Properties p_PROGIND;
    p_PROGIND = new Properties();
    Properties p_DESCIND;
    p_DESCIND = new Properties();
    Properties p_PROGSUBIND;
    p_PROGSUBIND = new Properties();
    Properties p_DESCSUB;
    p_DESCSUB = new Properties();
    Properties p_opk_IDIND;
    p_opk_IDIND = new Properties();
    Properties p_opk_IDSUBIND;
    p_opk_IDSUBIND = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"CONNES",w_CONNES,0);
    CPLib.PutProperty(p,"DTRIL",w_DTRIL,0);
    CPLib.PutProperty(p,"IDMOD",w_IDMOD,0);
    CPLib.PutProperty(p,"DESMODEL",w_DESMODEL,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_IDIND,"",w_IDIND,trsrow);
      CPLib.PutProperty(p_IDSUBIND,"",w_IDSUBIND,trsrow);
      CPLib.PutProperty(p_NOTA,"",w_NOTA,trsrow);
      CPLib.PutProperty(p_PROGIND,"",w_PROGIND,trsrow);
      CPLib.PutProperty(p_DESCIND,"",w_DESCIND,trsrow);
      CPLib.PutProperty(p_PROGSUBIND,"",w_PROGSUBIND,trsrow);
      CPLib.PutProperty(p_DESCSUB,"",w_DESCSUB,trsrow);
      CPLib.PutProperty(p_opk_IDIND,"",opk_IDIND,trsrow);
      CPLib.PutProperty(p_opk_IDSUBIND,"",opk_IDSUBIND,trsrow);
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
      CPLib.PutProperty(p_IDSUBIND,"",w_IDSUBIND,trsrow);
      CPLib.PutProperty(p_NOTA,"",w_NOTA,trsrow);
      CPLib.PutProperty(p_PROGIND,"",w_PROGIND,trsrow);
      CPLib.PutProperty(p_DESCIND,"",w_DESCIND,trsrow);
      CPLib.PutProperty(p_PROGSUBIND,"",w_PROGSUBIND,trsrow);
      CPLib.PutProperty(p_DESCSUB,"",w_DESCSUB,trsrow);
      CPLib.PutProperty(p_opk_IDIND,"",opk_IDIND,trsrow);
      CPLib.PutProperty(p_opk_IDSUBIND,"",opk_IDSUBIND,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("IDIND",CPLib.ToProperties(p_IDIND));
    trs_p.setProperty("IDSUBIND",CPLib.ToProperties(p_IDSUBIND));
    trs_p.setProperty("NOTA",CPLib.ToProperties(p_NOTA));
    trs_p.setProperty("PROGIND",CPLib.ToProperties(p_PROGIND));
    trs_p.setProperty("DESCIND",CPLib.ToProperties(p_DESCIND));
    trs_p.setProperty("PROGSUBIND",CPLib.ToProperties(p_PROGSUBIND));
    trs_p.setProperty("DESCSUB",CPLib.ToProperties(p_DESCSUB));
    trs_p.setProperty("opk_IDIND",CPLib.ToProperties(p_opk_IDIND));
    trs_p.setProperty("opk_IDSUBIND",CPLib.ToProperties(p_opk_IDSUBIND));
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
    return "rilevazioni"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CONNES","C",16,0))+"\\"+CPLib.ToCPStr(p_Caller.GetDate("DTRIL","D",8,0))+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDMOD","C",10,0));
  }
  public String RowPrimaryKey() {
    return "rilevazioni"+"\\"+CPLib.ToCPStr(w_IDIND)+"\\"+CPLib.ToCPStr(w_IDSUBIND);
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
    w_IDIND= m_oTrs.get(m_nCurrentRow).w_IDIND;
    w_IDSUBIND= m_oTrs.get(m_nCurrentRow).w_IDSUBIND;
    w_NOTA= m_oTrs.get(m_nCurrentRow).w_NOTA;
    w_PROGIND= m_oTrs.get(m_nCurrentRow).w_PROGIND;
    w_DESCIND= m_oTrs.get(m_nCurrentRow).w_DESCIND;
    w_PROGSUBIND= m_oTrs.get(m_nCurrentRow).w_PROGSUBIND;
    w_DESCSUB= m_oTrs.get(m_nCurrentRow).w_DESCSUB;
    opk_IDIND= m_oTrs.get(m_nCurrentRow).opk_IDIND;
    opk_IDSUBIND= m_oTrs.get(m_nCurrentRow).opk_IDSUBIND;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_IDIND=w_IDIND;
    m_oTrs.get(m_nCurrentRow).w_IDSUBIND=w_IDSUBIND;
    m_oTrs.get(m_nCurrentRow).w_NOTA=w_NOTA;
    m_oTrs.get(m_nCurrentRow).w_PROGIND=w_PROGIND;
    m_oTrs.get(m_nCurrentRow).w_DESCIND=w_DESCIND;
    m_oTrs.get(m_nCurrentRow).w_PROGSUBIND=w_PROGSUBIND;
    m_oTrs.get(m_nCurrentRow).w_DESCSUB=w_DESCSUB;
    m_oTrs.get(m_nCurrentRow).opk_IDIND=opk_IDIND;
    m_oTrs.get(m_nCurrentRow).opk_IDSUBIND=opk_IDSUBIND;
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
    w_IDIND = "";
    w_IDSUBIND = "";
    w_NOTA = "";
    w_PROGIND = "";
    w_DESCIND = "";
    w_PROGSUBIND = "";
    w_DESCSUB = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if ( ! (CPLib.Empty(w_IDIND))) {
      l_bTmpRes = Link_YTRSZBFLPF();
    }
    if ( ! (CPLib.Empty(w_IDSUBIND))) {
      l_bTmpRes = Link_AIIXUOGHMQ();
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
    m_oDeletedRows.get(l_nRows).w_IDIND=w_IDIND;
    m_oDeletedRows.get(l_nRows).w_IDSUBIND=w_IDSUBIND;
    m_oDeletedRows.get(l_nRows).w_NOTA=w_NOTA;
    m_oDeletedRows.get(l_nRows).w_PROGIND=w_PROGIND;
    m_oDeletedRows.get(l_nRows).w_DESCIND=w_DESCIND;
    m_oDeletedRows.get(l_nRows).w_PROGSUBIND=w_PROGSUBIND;
    m_oDeletedRows.get(l_nRows).w_DESCSUB=w_DESCSUB;
    m_oDeletedRows.get(l_nRows).opk_IDIND=opk_IDIND;
    m_oDeletedRows.get(l_nRows).opk_IDSUBIND=opk_IDSUBIND;
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
    return  ! (CPLib.Empty(w_IDIND));
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
    w_IDIND= m_oDeletedRows.get(l_RowNumberToSet).w_IDIND;
    w_IDSUBIND= m_oDeletedRows.get(l_RowNumberToSet).w_IDSUBIND;
    w_NOTA= m_oDeletedRows.get(l_RowNumberToSet).w_NOTA;
    w_PROGIND= m_oDeletedRows.get(l_RowNumberToSet).w_PROGIND;
    w_DESCIND= m_oDeletedRows.get(l_RowNumberToSet).w_DESCIND;
    w_PROGSUBIND= m_oDeletedRows.get(l_RowNumberToSet).w_PROGSUBIND;
    w_DESCSUB= m_oDeletedRows.get(l_RowNumberToSet).w_DESCSUB;
    opk_IDIND= m_oDeletedRows.get(l_RowNumberToSet).opk_IDIND;
    opk_IDSUBIND= m_oDeletedRows.get(l_RowNumberToSet).opk_IDSUBIND;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
