import java.util.*;

public class armt_cgo_causaliBL extends armt_cgo_causaliWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record � stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record � stato variato
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
  public static final String i_EntityName = "armt_cgo_causali";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_causali;
  public String m_cServer_cgo_causali;
  public CPPhTableWrInfo m_oWrInfo_cgo_causali;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_causali;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public CPPhTableWrInfo m_oWrInfo_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public CPPhTableWrInfo m_oWrInfo_tbcausin;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public CPPhTableWrInfo m_oWrInfo_tbtipreg;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_causali"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CACODICE':CACODICE,'CADESCRI':CADESCRI,'CACODANA':CACODANA,'CACODSIN':CACODSIN,'CASEGNO':CASEGNO,'CATIPOPE':CATIPOPE,'CAFLGDIP':CAFLGDIP,'CAFLGOPE':CAFLGOPE,'CAFLGAUI':CAFLGAUI"+FoundlingChildrenList("armt_cgo_causali",true)+"}";
  public static final String i_CompleteStateStructure = "{'CACODICE':CACODICE,'CADESCRI':CADESCRI,'CACODANA':CACODANA,'CACODSIN':CACODSIN,'xdescauana':xdescauana,'xdescausin':xdescausin,'CASEGNO':CASEGNO,'CATIPOPE':CATIPOPE,'CAFLGDIP':CAFLGDIP,'CAFLGOPE':CAFLGOPE,'CAFLGAUI':CAFLGAUI"+FoundlingChildrenList("armt_cgo_causali",true)+"}";
  public static final String i_ItemSequence = "CACODICE,CADESCRI,CACODANA,CACODSIN,CASEGNO,CATIPOPE,CAFLGDIP,CAFLGOPE,CAFLGAUI"+FoundlingChildrenList("armt_cgo_causali",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_causali"),new String[][]{new String[]{"CACODICE","Codice Causale","C","5","0","campo","key1","false","false"},new String[]{"CADESCRI","Descrizione","C","90","0","campo","key2","false","false"},new String[]{"CACODANA","Causale Analitica ","C","4","0","campo","key1","false","false"},new String[]{"CACODSIN","Causale Sintetica","C","2","0","campo","nokey","false","false"},new String[]{"CASEGNO","Segno","C","1","0","campo","nokey","false","false"},new String[]{"CATIPOPE","Tipo Operazione","C","2","0","campo","key1","false","false"},new String[]{"CAFLGDIP","Utilizzabile Dipendenze","C","1","0","campo","nokey","false","false"},new String[]{"CAFLGOPE","Tipologia causale","C","1","0","campo","nokey","false","false"},new String[]{"CAFLGAUI","Causale AUI","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_causaliBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
    m_oWrInfo_cgo_causali = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_causali",p_ContextObject.GetCompany());
    m_cVirtName_cgo_causali = CPSql.ManipulateTablePhName("cgo_causali",m_cServer_cgo_causali);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_oWrInfo_tbcauana = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcauana",p_ContextObject.GetCompany());
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_oWrInfo_tbcausin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcausin",p_ContextObject.GetCompany());
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_oWrInfo_tbtipreg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipreg",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_cgo_causali",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CACODICE = "";
    w_CADESCRI = "";
    w_CACODANA = "";
    w_CACODSIN = "";
    w_xdescauana = "";
    w_xdescausin = "";
    w_CASEGNO = "";
    w_CATIPOPE = "";
    w_CAFLGOPE = "";
    Link_VDOLZFWZIW();
    Link_DMYIBOGLPB();
    w_CAFLGDIP = "N";
    w_CAFLGAUI = "N";
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
  protected boolean Link_VDOLZFWZIW() {
    return Link_VDOLZFWZIW("Full");
  }
  protected boolean Link_VDOLZFWZIW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CACODANA))) {
      String l_OldValue = w_CACODANA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CACODANA,"C",4,0),m_cServer_tbcauana,w_CACODANA);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU,DESCRI,CAUSINT,SEGNO from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODCAU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CACODANA,"C",165,0),m_cServer_tbcauana,w_CACODANA);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU,DESCRI,CAUSINT,SEGNO from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CACODANA = l_rsLink.GetString("CODCAU");
          w_xdescauana = l_rsLink.GetString("DESCRI");
          w_CACODSIN = l_rsLink.GetString("CAUSINT");
          w_CASEGNO = l_rsLink.GetString("SEGNO");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_VDOLZFWZIW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CACODANA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CACODANA");
          }
          m_cLastWorkVarError = "CACODANA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_VDOLZFWZIW_blank();
    }
    return l_bResult;
  }
  void Link_VDOLZFWZIW_blank() {
    w_CACODANA = "";
    w_xdescauana = "";
    w_CACODSIN = "";
    w_CASEGNO = "";
  }
  protected boolean Link_DMYIBOGLPB() {
    return Link_DMYIBOGLPB("Full");
  }
  protected boolean Link_DMYIBOGLPB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CACODSIN))) {
      String l_OldValue = w_CACODSIN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CACODSIN,"C",2,0),m_cServer_tbcausin,w_CACODSIN);
      if (m_Ctx.IsSharedTemp("tbcausin")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcausin,"select CODVOC,DESCRIZ from "+m_cPhName_tbcausin+((m_cPhName_tbcausin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODVOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CACODSIN = l_rsLink.GetString("CODVOC");
          w_xdescausin = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DMYIBOGLPB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CACODSIN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CACODSIN");
          }
          m_cLastWorkVarError = "CACODSIN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DMYIBOGLPB_blank();
    }
    return l_bResult;
  }
  void Link_DMYIBOGLPB_blank() {
    w_CACODSIN = "";
    w_xdescausin = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CACODICE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CACODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CADESCRI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CADESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CACODANA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CACODANA = p_workVariableValue;
    l_bResult = Link_VDOLZFWZIW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CACODANA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CACODSIN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CACODSIN = p_workVariableValue;
    l_bResult = Link_DMYIBOGLPB();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CACODSIN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CASEGNO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CASEGNO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATIPOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATIPOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAFLGDIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAFLGDIP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAFLGOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAFLGOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAFLGAUI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAFLGAUI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
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
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"CACODICE","CACODANA","CATIPOPE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_causali","cgo_causali",m_KeyColumns,m_Ctx);
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
    w_CACODICE = "";
    w_CADESCRI = "";
    w_CACODANA = "";
    w_CACODSIN = "";
    w_xdescauana = "";
    w_xdescausin = "";
    w_CASEGNO = "";
    w_CATIPOPE = "";
    w_CAFLGDIP = "";
    w_CAFLGOPE = "";
    w_CAFLGAUI = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CACODICE = CPLib.GetProperty(p,"CACODICE",w_CACODICE,0);
      w_CADESCRI = CPLib.GetProperty(p,"CADESCRI",w_CADESCRI,0);
      w_CACODANA = CPLib.GetProperty(p,"CACODANA",w_CACODANA,0);
      w_CACODSIN = CPLib.GetProperty(p,"CACODSIN",w_CACODSIN,0);
      w_CASEGNO = CPLib.GetProperty(p,"CASEGNO",w_CASEGNO,0);
      w_CATIPOPE = CPLib.GetProperty(p,"CATIPOPE",w_CATIPOPE,0);
      w_CAFLGDIP = CPLib.GetProperty(p,"CAFLGDIP",w_CAFLGDIP,0);
      w_CAFLGOPE = CPLib.GetProperty(p,"CAFLGOPE",w_CAFLGOPE,0);
      w_CAFLGAUI = CPLib.GetProperty(p,"CAFLGAUI",w_CAFLGAUI,0);
      w_xdescauana = CPLib.GetProperty(p,"xdescauana",w_xdescauana,0);
      w_xdescausin = CPLib.GetProperty(p,"xdescausin",w_xdescausin,0);
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
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODCAU","DESCRI","CAUSINT","SEGNO"});
    map.put("rd_var",new String[]{"w_CACODANA","w_xdescauana","w_CACODSIN","w_CASEGNO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u0000165\u00002\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Analitica \u0000Descrizione\u0000Causale Sintetica\u0000Segno",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Causali Analitiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcausin");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcausin",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODVOC","DESCRIZ"});
    map.put("rd_var",new String[]{"w_CACODSIN","w_xdescausin"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u0000165",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Sintetica\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcausin\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Sintetiche\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_cgo_causali",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_causali",child);
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
    m_MNTs = CPLib.MNTChilds("armt_cgo_causali",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
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
      l_Keys = new String[]{"armt_cgo_causali"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_causali\\"+p_cState};
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
    CPLib.PutProperty(p,"CACODICE",w_CACODICE,0);
    CPLib.PutProperty(p,"CADESCRI",w_CADESCRI,0);
    CPLib.PutProperty(p,"CACODANA",w_CACODANA,0);
    CPLib.PutProperty(p,"CACODSIN",w_CACODSIN,0);
    CPLib.PutProperty(p,"CASEGNO",w_CASEGNO,0);
    CPLib.PutProperty(p,"CATIPOPE",w_CATIPOPE,0);
    CPLib.PutProperty(p,"CAFLGDIP",w_CAFLGDIP,0);
    CPLib.PutProperty(p,"CAFLGOPE",w_CAFLGOPE,0);
    CPLib.PutProperty(p,"CAFLGAUI",w_CAFLGAUI,0);
    CPLib.PutProperty(p,"xdescauana",w_xdescauana,0);
    CPLib.PutProperty(p,"xdescausin",w_xdescausin,0);
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
    return "cgo_causali"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CACODICE","C",5,0))+"\\"+CPLib.ToCPStr(p_Caller.GetString("CACODANA","C",4,0))+"\\"+CPLib.ToCPStr(p_Caller.GetString("CATIPOPE","C",2,0));
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
