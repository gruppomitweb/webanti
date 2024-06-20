import java.util.*;

public class arpg_agg_deccittaBL extends arpg_agg_deccittaWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_SIGLA;
    public String t_SIGLA;
    public double k_SIGLA_ID;
    public String w_IDTBLS;
    public String t_IDTBLS;
    public double k_IDTBLS_ID;
    public double c_ID;
    public String c_IDBASE;
    public String c_CITTAMIT;
    public String c_CAB;
    public String c_PROV;
    public String c_CAPMIT;
    public String c_PKTBSTATI;
    public String c_SIGLA;
    public String c_PREF;
    public String c_IDTBLS;
    public String c_CITTA;
    public String c_PR;
    public String c_CATASTALE;
    public String c_CAP;
    public String c_REGIONE;
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
  public static final String i_EntityName = "arpg_agg_deccitta";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_tmp_decodecitta;
  public String m_cServer_tmp_decodecitta;
  public CPPhTableWrInfo m_oWrInfo_tmp_decodecitta;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{}";
  public static final String i_CompleteStateStructure = "{'xdescri':xdescri}";
  public static final String i_ItemSequence = "";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{});
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
  public arpg_agg_deccittaBL (CPContext p_ContextObject) {
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
    m_cPhName_tmp_decodecitta = p_ContextObject.GetPhName("tmp_decodecitta");
    m_cServer_tmp_decodecitta = p_ContextObject.GetServer("tmp_decodecitta");
    m_oWrInfo_tmp_decodecitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tmp_decodecitta",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_xdescri = "";
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
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_agg_deccitta","",m_KeyColumns,m_Ctx);
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
        w_SIGLA = CPLib.GetProperty(trs_p,"w_SIGLA","",i);
        t_SIGLA = CPLib.GetProperty(trs_p,"t_SIGLA","",i);
        k_SIGLA_ID = CPLib.GetProperty(trs_p,"k_SIGLA_ID",0,i);
        w_IDTBLS = CPLib.GetProperty(trs_p,"w_IDTBLS","",i);
        t_IDTBLS = CPLib.GetProperty(trs_p,"t_IDTBLS","",i);
        k_IDTBLS_ID = CPLib.GetProperty(trs_p,"k_IDTBLS_ID",0,i);
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
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SIGLA","CITTA"});
    map.put("rd_var",new String[]{"w_SIGLA","w_xdescri"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Sigla\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Città\u0000\u0000\u0000false",-1));
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
    return tables;
  }
  public void Link_ORJCJRTXVX(double ID) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_decodecitta,"select SIGLA from "+m_cPhName_tmp_decodecitta+((m_cPhName_tmp_decodecitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"ID="+CPLib.ToSQL(ID,"N",10,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_SIGLA = l_rsLink.GetString("SIGLA");
      } else {
        w_SIGLA = "";
      }
    } finally {
      l_rsLink.Close();
    }
  }
  public void Link_PQMVBJOFUR(double ID) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_decodecitta,"select IDTBLS from "+m_cPhName_tmp_decodecitta+((m_cPhName_tmp_decodecitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"ID="+CPLib.ToSQL(ID,"N",10,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_IDTBLS = l_rsLink.GetString("IDTBLS");
      } else {
        w_IDTBLS = "";
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
    m_oTrs.get(m_nCurrentRow).c_ID=c_ID;
    m_oTrs.get(m_nCurrentRow).c_IDBASE=c_IDBASE;
    m_oTrs.get(m_nCurrentRow).c_CITTAMIT=c_CITTAMIT;
    m_oTrs.get(m_nCurrentRow).c_CAB=c_CAB;
    m_oTrs.get(m_nCurrentRow).c_PROV=c_PROV;
    m_oTrs.get(m_nCurrentRow).c_CAPMIT=c_CAPMIT;
    m_oTrs.get(m_nCurrentRow).c_PKTBSTATI=c_PKTBSTATI;
    m_oTrs.get(m_nCurrentRow).c_SIGLA=c_SIGLA;
    m_oTrs.get(m_nCurrentRow).c_PREF=c_PREF;
    m_oTrs.get(m_nCurrentRow).c_IDTBLS=c_IDTBLS;
    m_oTrs.get(m_nCurrentRow).c_CITTA=c_CITTA;
    m_oTrs.get(m_nCurrentRow).c_PR=c_PR;
    m_oTrs.get(m_nCurrentRow).c_CATASTALE=c_CATASTALE;
    m_oTrs.get(m_nCurrentRow).c_CAP=c_CAP;
    m_oTrs.get(m_nCurrentRow).c_REGIONE=c_REGIONE;
    m_oTrs.get(m_nCurrentRow).w_SIGLA=w_SIGLA;
    m_oTrs.get(m_nCurrentRow).t_SIGLA=t_SIGLA;
    m_oTrs.get(m_nCurrentRow).k_SIGLA_ID=k_SIGLA_ID;
    m_oTrs.get(m_nCurrentRow).w_IDTBLS=w_IDTBLS;
    m_oTrs.get(m_nCurrentRow).t_IDTBLS=t_IDTBLS;
    m_oTrs.get(m_nCurrentRow).k_IDTBLS_ID=k_IDTBLS_ID;
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
  }
  public void TrsToWork() {
    c_ID= m_oTrs.get(m_nCurrentRow).c_ID;
    c_IDBASE= m_oTrs.get(m_nCurrentRow).c_IDBASE;
    c_CITTAMIT= m_oTrs.get(m_nCurrentRow).c_CITTAMIT;
    c_CAB= m_oTrs.get(m_nCurrentRow).c_CAB;
    c_PROV= m_oTrs.get(m_nCurrentRow).c_PROV;
    c_CAPMIT= m_oTrs.get(m_nCurrentRow).c_CAPMIT;
    c_PKTBSTATI= m_oTrs.get(m_nCurrentRow).c_PKTBSTATI;
    c_SIGLA= m_oTrs.get(m_nCurrentRow).c_SIGLA;
    c_PREF= m_oTrs.get(m_nCurrentRow).c_PREF;
    c_IDTBLS= m_oTrs.get(m_nCurrentRow).c_IDTBLS;
    c_CITTA= m_oTrs.get(m_nCurrentRow).c_CITTA;
    c_PR= m_oTrs.get(m_nCurrentRow).c_PR;
    c_CATASTALE= m_oTrs.get(m_nCurrentRow).c_CATASTALE;
    c_CAP= m_oTrs.get(m_nCurrentRow).c_CAP;
    c_REGIONE= m_oTrs.get(m_nCurrentRow).c_REGIONE;
    w_SIGLA= m_oTrs.get(m_nCurrentRow).w_SIGLA;
    t_SIGLA= m_oTrs.get(m_nCurrentRow).t_SIGLA;
    k_SIGLA_ID= m_oTrs.get(m_nCurrentRow).k_SIGLA_ID;
    w_IDTBLS= m_oTrs.get(m_nCurrentRow).w_IDTBLS;
    t_IDTBLS= m_oTrs.get(m_nCurrentRow).t_IDTBLS;
    k_IDTBLS_ID= m_oTrs.get(m_nCurrentRow).k_IDTBLS_ID;
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
