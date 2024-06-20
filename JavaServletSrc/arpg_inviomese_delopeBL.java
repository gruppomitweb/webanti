import java.util.*;

public class arpg_inviomese_delopeBL extends arpg_inviomese_delopeWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record � stato variato
  public boolean m_bUpdated;
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
  public static final String i_EntityName = "arpg_inviomese_delope";
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
  public static final String i_StateStructure = "{'iniz':iniz,'seco':seco,'dadata':dadata,'a_data':a_data,'a_datag':a_datag,'flgglob':flgglob}";
  public static final String i_CompleteStateStructure = "{'iniz':iniz,'seco':seco,'dadata':dadata,'a_data':a_data,'datpri':datpri,'datseci':datseci,'datsecf':datsecf,'datprf':datprf,'bloccaedit':bloccaedit,'_errore':_errore,'dadatag':dadatag,'a_datag':a_datag,'flgglob':flgglob,'gDescAzi':gDescAzi}";
  public static final String i_ItemSequence = "iniz,seco,dadata,a_data,a_datag,flgglob";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"iniz","","C","1","0","variabile","nokey","false","false"},new String[]{"seco","","C","1","0","variabile","nokey","false","false"},new String[]{"dadata","","D","8","0","variabile","nokey","false","false"},new String[]{"a_data","","D","8","0","variabile","nokey","false","false"},new String[]{"a_datag","","D","8","0","variabile","nokey","false","false"},new String[]{"flgglob","","C","1","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_inviomese_delopeBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    w_a_datag = CPLib.NullDate();
    w_gDescAzi = m_Ctx.GetGlobalString("gDescAzi");
    w_iniz = "N";
    w_seco = "N";
    w_datpri = CPLib.NullDate();
    w_datpri = (CPLib.eq(w_iniz,"S")?CPLib.CharToDate("20061231"):CPLib.NullDate());
    w_datseci = CPLib.NullDate();
    w_datseci = (CPLib.eq(w_seco,"S")?CPLib.CharToDate("20070101"):CPLib.NullDate());
    w_datsecf = CPLib.NullDate();
    w_datsecf = (CPLib.eq(w_seco,"S")?CPLib.CharToDate("20070430"):CPLib.NullDate());
    w_datprf = CPLib.NullDate();
    w_datprf = (CPLib.eq(w_iniz,"S")?CPLib.CharToDate("20050101"):CPLib.NullDate());
    w_bloccaedit = "N";
    w__errore = "";
    w_dadatag = CPLib.NullDate();
    w_dadatag = CPLib.CharToDate("20050101");
    w_flgglob = "N";
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
    o_iniz = w_iniz;
    o_seco = w_seco;
    o_dadata = w_dadata;
    o_a_data = w_a_data;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_iniz(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_iniz = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_seco(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_seco = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_dadata(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_dadata = p_workVariableValue;
    // 
    l_bResult = CPLib.gt(w_dadata,CPLib.CharToDate("20070430"));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "Impossibile selezionare un periodo precedente al 30/04/2007";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_dadata = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_a_data(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_a_data = p_workVariableValue;
    // 
    l_bResult = CPLib.gt(w_a_data,w_dadata);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data fine periodo deve essere superiore a quella di inizo periodo";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_a_data = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_a_datag(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_a_datag = p_workVariableValue;
    // 
    l_bResult = CPLib.gt(w_a_datag,w_dadatag);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data fine periodo deve essere superiore a quella di inizo periodo";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_a_datag = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_flgglob(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgglob = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
                              abilitazione di un control.
                            */
  public boolean getWritable_iniz() {
    return CPLib.eq(w_bloccaedit,"N");
  }
  public boolean getWritable_seco() {
    return CPLib.eq(w_bloccaedit,"N");
  }
  public boolean getWritable_dadata() {
    return CPLib.eq(w_bloccaedit,"N");
  }
  public boolean getWritable_a_data() {
    return CPLib.eq(w_bloccaedit,"N");
  }
  public boolean getWritable_a_datag() {
    return CPLib.eq(w_bloccaedit,"N");
  }
  public boolean getVisible_dadatag() {
    return CPLib.eq(w_flgglob,"N");
  }
  public boolean getVisible_a_datag() {
    return CPLib.eq(w_flgglob,"N");
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
    w_datpri = (CPLib.eq(w_iniz,"S")?CPLib.CharToDate("20061231"):CPLib.NullDate());
    w_datseci = (CPLib.eq(w_seco,"S")?CPLib.CharToDate("20070101"):CPLib.NullDate());
    w_datsecf = (CPLib.eq(w_seco,"S")?CPLib.CharToDate("20070430"):CPLib.NullDate());
    w_datprf = (CPLib.eq(w_iniz,"S")?CPLib.CharToDate("20050101"):CPLib.NullDate());
    if (CPLib.ne(o_iniz,w_iniz)) {
      Calculation_GUKRMGSICD();
    }
    if (CPLib.ne(o_seco,w_seco)) {
      Calculation_MSNBZDYCTF();
    }
    if (CPLib.ne(o_dadata,w_dadata) || CPLib.ne(o_a_data,w_a_data)) {
      Calculation_AVRILMTAOC();
    }
    w_dadatag = CPLib.CharToDate("20050101");
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_GUKRMGSICD() {
    w_seco = "N";
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
  }
  void Calculation_MSNBZDYCTF() {
    w_iniz = "N";
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
  }
  void Calculation_AVRILMTAOC() {
    w_iniz = "N";
    w_seco = "N";
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_inviomese_delope","",m_KeyColumns,m_Ctx);
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
      w_iniz = CPLib.GetProperty(p,"iniz",w_iniz,0);
      w_seco = CPLib.GetProperty(p,"seco",w_seco,0);
      w_dadata = CPLib.GetProperty(p,"dadata",w_dadata,0);
      w_a_data = CPLib.GetProperty(p,"a_data",w_a_data,0);
      w_datpri = CPLib.GetProperty(p,"datpri",w_datpri,0);
      w_datseci = CPLib.GetProperty(p,"datseci",w_datseci,0);
      w_datsecf = CPLib.GetProperty(p,"datsecf",w_datsecf,0);
      w_datprf = CPLib.GetProperty(p,"datprf",w_datprf,0);
      w_bloccaedit = CPLib.GetProperty(p,"bloccaedit",w_bloccaedit,0);
      w__errore = CPLib.GetProperty(p,"_errore",w__errore,0);
      w_dadatag = CPLib.GetProperty(p,"dadatag",w_dadatag,0);
      w_a_datag = CPLib.GetProperty(p,"a_datag",w_a_datag,0);
      w_flgglob = CPLib.GetProperty(p,"flgglob",w_flgglob,0);
      w_gDescAzi = CPLib.GetProperty(p,"gDescAzi",w_gDescAzi,0);
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