import java.util.*;

public class arpg_storrapBL extends arpg_storrapWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String c_RAPPORTO;
    public String c_DESCRAP;
    public String c_TIPORAP;
    public String c_FLAGLIRE;
    public String c_VALUTA;
    public int m_nRowStatus;
  }
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
  public static final String i_EntityName = "arpg_storrap";
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
  public static final String i_StateStructure = "{'tipoope':tipoope,'DaDatOpe':DaDatOpe,'ADatOpe':ADatOpe}";
  public static final String i_CompleteStateStructure = "{'tipoope':tipoope,'DaDatOpe':DaDatOpe,'ADatOpe':ADatOpe,'gDatDel':gDatDel,'gDatTra':gDatTra,'errmsg':errmsg,'test':test}";
  public static final String i_ItemSequence = "tipoope,DaDatOpe,ADatOpe";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"tipoope","","C","1","0","variabile","nokey","false","false"},new String[]{"DaDatOpe","","D","8","0","variabile","nokey","false","false"},new String[]{"ADatOpe","","D","8","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public ArrayList<TrsRow> m_oTrs= new ArrayList<TrsRow>();
  public String m_cQueryName = "";
  public boolean m_bQuery = false;
  public double m_nStartRow = 0;
  public int m_nCurrentRow = 0;
  public boolean m_bExitRow = false;
  public arpg_storrapBL (CPContext p_ContextObject) {
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
    w_DaDatOpe = CPLib.NullDate();
    w_gDatDel = m_Ctx.GetGlobalDate("gDatDel");
    w_gDatTra = m_Ctx.GetGlobalDate("gDatTra");
    w_errmsg = "";
    w_test = "";
    w_tipoope = "T";
    w_ADatOpe = (CPLib.eq(w_tipoope,"T")?w_gDatTra:w_gDatDel);
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
    o_tipoope = w_tipoope;
    o_ADatOpe = w_ADatOpe;
    o_errmsg = w_errmsg;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_tipoope(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipoope = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DaDatOpe(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DaDatOpe = p_workVariableValue;
    // 
    l_bResult = CPLib.Empty(w_ADatOpe) || CPLib.le(w_DaDatOpe,w_ADatOpe);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di inizio periodo deve essere minore di quella fine periodo";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DaDatOpe = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ADatOpe(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ADatOpe = p_workVariableValue;
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
    if (CPLib.ne(o_ADatOpe,w_ADatOpe)) {
      Calculation_QEGAAHNZYG();
    }
    if (CPLib.ne(o_errmsg,w_errmsg)) {
      Calculation_HABPLZLYUM();
    }
    if (CPLib.ne(o_tipoope,w_tipoope)) {
      Calculation_FZZGQGHVJO();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_QEGAAHNZYG() {
    w_errmsg = arfn_chkdatperR.Make(m_Ctx,this).Run(w_DaDatOpe,w_ADatOpe,w_tipoope);
    w_test = LibreriaMit.cWarning(w_errmsg);
  }
  void Calculation_HABPLZLYUM() {
    w_ADatOpe = (CPLib.Empty(w_errmsg)?w_ADatOpe:(CPLib.eq(w_tipoope,"T")?w_gDatTra:w_gDatDel));
  }
  void Calculation_FZZGQGHVJO() {
    w_ADatOpe = (CPLib.eq(w_tipoope,"T")?w_gDatTra:w_gDatDel);
    w_DaDatOpe = CPLib.NullDate();
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_storrap","",m_KeyColumns,m_Ctx);
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
      w_tipoope = CPLib.GetProperty(p,"tipoope",w_tipoope,0);
      w_DaDatOpe = CPLib.GetProperty(p,"DaDatOpe",w_DaDatOpe,0);
      w_ADatOpe = CPLib.GetProperty(p,"ADatOpe",w_ADatOpe,0);
      w_gDatDel = CPLib.GetProperty(p,"gDatDel",w_gDatDel,0);
      w_gDatTra = CPLib.GetProperty(p,"gDatTra",w_gDatTra,0);
      w_errmsg = CPLib.GetProperty(p,"errmsg",w_errmsg,0);
      w_test = CPLib.GetProperty(p,"test",w_test,0);
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
  public void AddTrsRow() {
    CPLib.AppendToTrs(m_oTrs,new TrsRow());
    m_nCurrentRow = Rows()-1;
    // Salvataggio dei valori delle variabili di work nel transitorio
    WorkToTrs();
  }
  public void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).c_RAPPORTO=c_RAPPORTO;
    m_oTrs.get(m_nCurrentRow).c_DESCRAP=c_DESCRAP;
    m_oTrs.get(m_nCurrentRow).c_TIPORAP=c_TIPORAP;
    m_oTrs.get(m_nCurrentRow).c_FLAGLIRE=c_FLAGLIRE;
    m_oTrs.get(m_nCurrentRow).c_VALUTA=c_VALUTA;
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
  }
  public void TrsToWork() {
    c_RAPPORTO= m_oTrs.get(m_nCurrentRow).c_RAPPORTO;
    c_DESCRAP= m_oTrs.get(m_nCurrentRow).c_DESCRAP;
    c_TIPORAP= m_oTrs.get(m_nCurrentRow).c_TIPORAP;
    c_FLAGLIRE= m_oTrs.get(m_nCurrentRow).c_FLAGLIRE;
    c_VALUTA= m_oTrs.get(m_nCurrentRow).c_VALUTA;
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
  }
  public int Rows() {
    /*  Restituisce il numero di righe della query.
                              */
    return m_oTrs.size();
  }
  public boolean SetRow(int p_nRowNumberToSet) {
    boolean l_bResult;
    l_bResult = true;
    if (CPLib.lt(p_nRowNumberToSet,Rows())) {
      m_nCurrentRow = p_nRowNumberToSet;
      // Popolamento delle variabili di work
      TrsToWork();
    } else {
      // Si sta tentando di impostare una riga non valida
      l_bResult = false;
    }
    return l_bResult;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
