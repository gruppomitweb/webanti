import java.util.*;

public class arpg_closerapBL extends arpg_closerapWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_FLGSEL;
    public String t_FLGSEL;
    public String k_FLGSEL_RAPPORTO;
    public String c_RAPPORTO;
    public String c_DESCRAP;
    public String c_FLGSEL;
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
  public static final String i_EntityName = "arpg_closerap";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_tmp_rapportipd;
  public String m_cServer_tmp_rapportipd;
  public CPPhTableWrInfo m_oWrInfo_tmp_rapportipd;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public CPPhTableWrInfo m_oWrInfo_tbtipreg;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'dataope':dataope,'datareg':datareg,'tipope':tipope}";
  public static final String i_CompleteStateStructure = "{'dataope':dataope,'datareg':datareg,'tipope':tipope,'xdes1':xdes1}";
  public static final String i_ItemSequence = "dataope,datareg,tipope";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"dataope","Data Operazione","D","8","0","variabile","nokey","false","false"},new String[]{"datareg","Data Operazione","D","8","0","variabile","nokey","false","false"},new String[]{"tipope","Tipo Operazione","C","2","0","variabile","nokey","false","false"}});
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
  public arpg_closerapBL (CPContext p_ContextObject) {
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
    m_cPhName_tmp_rapportipd = p_ContextObject.GetPhName("tmp_rapportipd");
    m_cServer_tmp_rapportipd = p_ContextObject.GetServer("tmp_rapportipd");
    m_oWrInfo_tmp_rapportipd = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tmp_rapportipd",p_ContextObject.GetCompany());
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_oWrInfo_tbtipreg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipreg",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_dataope = CPLib.NullDate();
    w_datareg = CPLib.NullDate();
    w_tipope = "";
    w_xdes1 = "";
    Link_OWENYZRHAH();
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
  protected boolean Link_OWENYZRHAH() {
    return Link_OWENYZRHAH("Full");
  }
  protected boolean Link_OWENYZRHAH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_tipope))) {
      String l_OldValue = w_tipope;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipope,"C",2,0),m_cServer_tbtipreg,w_tipope);
      if (m_Ctx.IsSharedTemp("tbtipreg")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipreg,"select CODICE,DES1 from "+m_cPhName_tbtipreg+((m_cPhName_tbtipreg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_tipope = l_rsLink.GetString("CODICE");
          w_xdes1 = l_rsLink.GetString("DES1");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_OWENYZRHAH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_tipope = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","tipope");
          }
          m_cLastWorkVarError = "tipope";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_OWENYZRHAH_blank();
    }
    return l_bResult;
  }
  void Link_OWENYZRHAH_blank() {
    w_tipope = "";
    w_xdes1 = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_dataope(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_dataope = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datareg(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datareg = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_tipope(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipope = p_workVariableValue;
    l_bResult = Link_OWENYZRHAH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_tipope = "";
    }
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_closerap","",m_KeyColumns,m_Ctx);
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
      w_dataope = CPLib.GetProperty(p,"dataope",w_dataope,0);
      w_datareg = CPLib.GetProperty(p,"datareg",w_datareg,0);
      w_tipope = CPLib.GetProperty(p,"tipope",w_tipope,0);
      w_xdes1 = CPLib.GetProperty(p,"xdes1",w_xdes1,0);
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
        w_FLGSEL = CPLib.GetProperty(trs_p,"w_FLGSEL","",i);
        t_FLGSEL = CPLib.GetProperty(trs_p,"t_FLGSEL","",i);
        k_FLGSEL_RAPPORTO = CPLib.GetProperty(trs_p,"k_FLGSEL_RAPPORTO","",i);
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
    items = tables.get("tbtipreg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipreg",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DES1"});
    map.put("rd_var",new String[]{"w_tipope","w_xdes1"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000090",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Operazione\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipreg\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Tipo Operazione\u0000\u0000\u0000false",-1));
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
  public void Link_BHCCADUOZN(String RAPPORTO) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_rapportipd,"select FLGSEL from "+m_cPhName_tmp_rapportipd+((m_cPhName_tmp_rapportipd).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAPPORTO="+CPLib.ToSQL(RAPPORTO,"C",25,0));
    try {
      l_bLoaded =  ! (l_rsLink.Eof());
      if (l_bLoaded) {
        w_FLGSEL = l_rsLink.GetString("FLGSEL");
      } else {
        w_FLGSEL = "";
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
    m_oTrs.get(m_nCurrentRow).c_RAPPORTO=c_RAPPORTO;
    m_oTrs.get(m_nCurrentRow).c_DESCRAP=c_DESCRAP;
    m_oTrs.get(m_nCurrentRow).c_FLGSEL=c_FLGSEL;
    m_oTrs.get(m_nCurrentRow).w_FLGSEL=w_FLGSEL;
    m_oTrs.get(m_nCurrentRow).t_FLGSEL=t_FLGSEL;
    m_oTrs.get(m_nCurrentRow).k_FLGSEL_RAPPORTO=k_FLGSEL_RAPPORTO;
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
  }
  public void TrsToWork() {
    c_RAPPORTO= m_oTrs.get(m_nCurrentRow).c_RAPPORTO;
    c_DESCRAP= m_oTrs.get(m_nCurrentRow).c_DESCRAP;
    c_FLGSEL= m_oTrs.get(m_nCurrentRow).c_FLGSEL;
    w_FLGSEL= m_oTrs.get(m_nCurrentRow).w_FLGSEL;
    t_FLGSEL= m_oTrs.get(m_nCurrentRow).t_FLGSEL;
    k_FLGSEL_RAPPORTO= m_oTrs.get(m_nCurrentRow).k_FLGSEL_RAPPORTO;
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
