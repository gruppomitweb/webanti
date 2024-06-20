import java.util.*;

public class arpg_allinea_nome_cognomeBL extends arpg_allinea_nome_cognomeWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_NOME;
    public String t_NOME;
    public String k_NOME_IDBASE;
    public String w_COGNOME;
    public String t_COGNOME;
    public String k_COGNOME_IDBASE;
    public String w_RAGSOC;
    public String t_RAGSOC;
    public String k_RAGSOC_IDBASE;
    public String c_IDBASE;
    public String c_CONNES;
    public String c_RAGSOC;
    public String c_CODFISC;
    public String c_NOME;
    public String c_COGNOME;
    public String c_ALLINEAMENTO;
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
  public static final String i_EntityName = "arpg_allinea_nome_cognome";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_tmp_allin_anag;
  public String m_cServer_tmp_allin_anag;
  public CPPhTableWrInfo m_oWrInfo_tmp_allin_anag;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'Countot':Countot,'Countok':Countok,'ALLINEAMENTO':ALLINEAMENTO,'Countpr':Countpr,'Countpr2':Countpr2,'Countko':Countko}";
  public static final String i_CompleteStateStructure = "{'Countot':Countot,'Countok':Countok,'ALLINEAMENTO':ALLINEAMENTO,'Countpr':Countpr,'Countpr2':Countpr2,'Countko':Countko}";
  public static final String i_ItemSequence = "Countot,Countok,ALLINEAMENTO,Countpr,Countpr2,Countko";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"Countot","","N","20","0","variabile","nokey","false","false"},new String[]{"Countok","","N","20","0","variabile","nokey","false","false"},new String[]{"ALLINEAMENTO","","C","2","0","variabile","nokey","false","false"},new String[]{"Countpr","","N","20","0","variabile","nokey","false","false"},new String[]{"Countpr2","","N","20","0","variabile","nokey","false","false"},new String[]{"Countko","","N","20","0","variabile","nokey","false","false"}});
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
  public boolean m_bQuery = true;
  public double m_nStartRow = 0;
  public int m_nCurrentRow = 0;
  public boolean m_bExitRow = false;
  public arpg_allinea_nome_cognomeBL (CPContext p_ContextObject) {
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
    m_cPhName_tmp_allin_anag = p_ContextObject.GetPhName("tmp_allin_anag");
    m_cServer_tmp_allin_anag = p_ContextObject.GetServer("tmp_allin_anag");
    m_oWrInfo_tmp_allin_anag = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tmp_allin_anag",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_Countot = 0;
    w_Countok = 0;
    w_Countpr = 0;
    w_Countpr2 = 0;
    w_Countko = 0;
    w_ALLINEAMENTO = "";
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
    o_RAGSOC = w_RAGSOC;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_Countot(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_Countot = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_Countok(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_Countok = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALLINEAMENTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALLINEAMENTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_Countpr(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_Countpr = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_Countpr2(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_Countpr2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_Countko(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_Countko = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_Countot() {
    return false;
  }
  public boolean getWritable_Countok() {
    return false;
  }
  public boolean getWritable_Countpr() {
    return false;
  }
  public boolean getWritable_Countpr2() {
    return false;
  }
  public boolean getWritable_Countko() {
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_allinea_nome_cognome","",m_KeyColumns,m_Ctx);
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
      w_Countot = CPLib.GetProperty(p,"Countot",w_Countot,0);
      w_Countok = CPLib.GetProperty(p,"Countok",w_Countok,0);
      w_ALLINEAMENTO = CPLib.GetProperty(p,"ALLINEAMENTO",w_ALLINEAMENTO,0);
      w_Countpr = CPLib.GetProperty(p,"Countpr",w_Countpr,0);
      w_Countpr2 = CPLib.GetProperty(p,"Countpr2",w_Countpr2,0);
      w_Countko = CPLib.GetProperty(p,"Countko",w_Countko,0);
      int rows;
      int i;
      String Rows;
      Properties trs_p;
      trs_p = CPLib.GetProperties(CPLib.GetProperty(p, "m_oTrs", "", 0),new Properties());
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      rows = (int)CPLib.Val(Rows);
      i = 1;
      while (CPLib.le(i,rows)) {
        w_NOME = CPLib.GetProperty(trs_p,"w_NOME","",i);
        t_NOME = CPLib.GetProperty(trs_p,"t_NOME","",i);
        k_NOME_IDBASE = CPLib.GetProperty(trs_p,"k_NOME_IDBASE","",i);
        w_COGNOME = CPLib.GetProperty(trs_p,"w_COGNOME","",i);
        t_COGNOME = CPLib.GetProperty(trs_p,"t_COGNOME","",i);
        k_COGNOME_IDBASE = CPLib.GetProperty(trs_p,"k_COGNOME_IDBASE","",i);
        w_RAGSOC = CPLib.GetProperty(trs_p,"w_RAGSOC","",i);
        t_RAGSOC = CPLib.GetProperty(trs_p,"t_RAGSOC","",i);
        k_RAGSOC_IDBASE = CPLib.GetProperty(trs_p,"k_RAGSOC_IDBASE","",i);
        m_nRowStatus = (int)CPLib.GetProperty(trs_p,"m_nRowStatus",0,i);
        AddTrsRow();
        i = i+1;
      }
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
  public void Link_ULURFNZXUM(String IDBASE) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_allin_anag,"select NOME from "+m_cPhName_tmp_allin_anag+((m_cPhName_tmp_allin_anag).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE="+CPLib.ToSQL(IDBASE,"C",10,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_NOME = l_rsLink.GetString("NOME");
      } else {
        w_NOME = "";
      }
    } finally {
      l_rsLink.Close();
    }
  }
  public void Link_QUYFYKVQUY(String IDBASE) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_allin_anag,"select COGNOME from "+m_cPhName_tmp_allin_anag+((m_cPhName_tmp_allin_anag).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE="+CPLib.ToSQL(IDBASE,"C",10,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_COGNOME = l_rsLink.GetString("COGNOME");
      } else {
        w_COGNOME = "";
      }
    } finally {
      l_rsLink.Close();
    }
  }
  public void Link_MGZZLJDIWH(String IDBASE) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_allin_anag,"select RAGSOC from "+m_cPhName_tmp_allin_anag+((m_cPhName_tmp_allin_anag).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE="+CPLib.ToSQL(IDBASE,"C",10,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_RAGSOC = l_rsLink.GetString("RAGSOC");
      } else {
        w_RAGSOC = "";
      }
    } finally {
      l_rsLink.Close();
    }
  }
  public void AddTrsRow() {
    CPLib.AppendToTrs(m_oTrs,new TrsRow());
    m_nCurrentRow = Rows()-1;
    // Salvataggio dei valori delle variabili di work nel transitorio
    WorkToTrs();
  }
  public void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).c_IDBASE=c_IDBASE;
    m_oTrs.get(m_nCurrentRow).c_CONNES=c_CONNES;
    m_oTrs.get(m_nCurrentRow).c_RAGSOC=c_RAGSOC;
    m_oTrs.get(m_nCurrentRow).c_CODFISC=c_CODFISC;
    m_oTrs.get(m_nCurrentRow).c_NOME=c_NOME;
    m_oTrs.get(m_nCurrentRow).c_COGNOME=c_COGNOME;
    m_oTrs.get(m_nCurrentRow).c_ALLINEAMENTO=c_ALLINEAMENTO;
    m_oTrs.get(m_nCurrentRow).w_NOME=w_NOME;
    m_oTrs.get(m_nCurrentRow).t_NOME=t_NOME;
    m_oTrs.get(m_nCurrentRow).k_NOME_IDBASE=k_NOME_IDBASE;
    m_oTrs.get(m_nCurrentRow).w_COGNOME=w_COGNOME;
    m_oTrs.get(m_nCurrentRow).t_COGNOME=t_COGNOME;
    m_oTrs.get(m_nCurrentRow).k_COGNOME_IDBASE=k_COGNOME_IDBASE;
    m_oTrs.get(m_nCurrentRow).w_RAGSOC=w_RAGSOC;
    m_oTrs.get(m_nCurrentRow).t_RAGSOC=t_RAGSOC;
    m_oTrs.get(m_nCurrentRow).k_RAGSOC_IDBASE=k_RAGSOC_IDBASE;
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
  }
  public void TrsToWork() {
    c_IDBASE= m_oTrs.get(m_nCurrentRow).c_IDBASE;
    c_CONNES= m_oTrs.get(m_nCurrentRow).c_CONNES;
    c_RAGSOC= m_oTrs.get(m_nCurrentRow).c_RAGSOC;
    c_CODFISC= m_oTrs.get(m_nCurrentRow).c_CODFISC;
    c_NOME= m_oTrs.get(m_nCurrentRow).c_NOME;
    c_COGNOME= m_oTrs.get(m_nCurrentRow).c_COGNOME;
    c_ALLINEAMENTO= m_oTrs.get(m_nCurrentRow).c_ALLINEAMENTO;
    w_NOME= m_oTrs.get(m_nCurrentRow).w_NOME;
    t_NOME= m_oTrs.get(m_nCurrentRow).t_NOME;
    k_NOME_IDBASE= m_oTrs.get(m_nCurrentRow).k_NOME_IDBASE;
    w_COGNOME= m_oTrs.get(m_nCurrentRow).w_COGNOME;
    t_COGNOME= m_oTrs.get(m_nCurrentRow).t_COGNOME;
    k_COGNOME_IDBASE= m_oTrs.get(m_nCurrentRow).k_COGNOME_IDBASE;
    w_RAGSOC= m_oTrs.get(m_nCurrentRow).w_RAGSOC;
    t_RAGSOC= m_oTrs.get(m_nCurrentRow).t_RAGSOC;
    k_RAGSOC_IDBASE= m_oTrs.get(m_nCurrentRow).k_RAGSOC_IDBASE;
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
