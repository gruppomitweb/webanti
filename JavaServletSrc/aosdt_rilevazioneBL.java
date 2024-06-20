import java.util.*;

public class aosdt_rilevazioneBL extends aosdt_rilevazioneWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_CONNES;
    public java.sql.Date w_DTRIL;
    public String w_PROVENIENZA;
    public double w_CPROWNUM;
    public int m_nCPRowNum;
    public String m_cWv_aosdt_anom_ril;
    public aosdt_anom_rilBO aosdt_anom_ril;
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
  public static final String i_EntityName = "aosdt_rilevazione";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_rilevazione;
  public String m_cServer_rilevazione;
  public CPPhTableWrInfo m_oWrInfo_rilevazione;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_rilevazione;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_mod_ind_def;
  public String m_cServer_mod_ind_def;
  public CPPhTableWrInfo m_oWrInfo_mod_ind_def;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"rilevazione"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IDMOD':IDMOD,'m_Detail':{'CONNES':CONNES,'DTRIL':DTRIL,'PROVENIENZA':PROVENIENZA,'CPROWNUM':CPROWNUM,'aosdt_anom_ril':aosdt_anom_ril"+FoundlingChildrenList("aosdt_rilevazione",true,true)+"}"+FoundlingChildrenList("aosdt_rilevazione",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'IDMOD':IDMOD,'DESCRI':DESCRI,'m_Detail':{'CONNES':CONNES,'DTRIL':DTRIL,'PROVENIENZA':PROVENIENZA,'CPROWNUM':CPROWNUM,'aosdt_anom_ril':aosdt_anom_ril"+FoundlingChildrenList("aosdt_rilevazione",true,true)+"}"+FoundlingChildrenList("aosdt_rilevazione",true,false)+"}";
  public static final String i_ItemSequence = "IDMOD,m_Detail[ CONNES DTRIL PROVENIENZA CPROWNUM aosdt_anom_ril"+FoundlingChildrenList("aosdt_rilevazione",false,true)+"]"+FoundlingChildrenList("aosdt_rilevazione",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("aosdt_rilevazione"),new String[][]{new String[]{"IDMOD","ID del modello","C","10","0","campo","key1","false","false"},new String[]{"CONNES","Codice di collegamento del soggetto","C","16","0","campo","key2","true","false"},new String[]{"DTRIL","Data rilevazione","D","8","0","campo","key3","true","false"},new String[]{"PROVENIENZA","Provenienza del dato","C","100","0","campo","key4","true","false"},new String[]{"CPROWNUM","Progressivo rilevazione","N","4","0","campo","key1","true","false"},new String[]{"aosdt_anom_ril","Anomalie rilevate","","","","link_PC","","true",""}});
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
  public aosdt_rilevazioneBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_rilevazione = p_ContextObject.GetPhName("rilevazione",p_ContextObject.GetCompany(),false);
    m_cServer_rilevazione = p_ContextObject.GetServer("rilevazione");
    m_oWrInfo_rilevazione = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"rilevazione",p_ContextObject.GetCompany());
    m_cVirtName_rilevazione = CPSql.ManipulateTablePhName("rilevazione",m_cServer_rilevazione);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_mod_ind_def = p_ContextObject.GetPhName("mod_ind_def");
    m_cServer_mod_ind_def = p_ContextObject.GetServer("mod_ind_def");
    m_oWrInfo_mod_ind_def = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"mod_ind_def",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    aosdt_anom_ril = new aosdt_anom_rilBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("aosdt_rilevazione",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IDMOD = "";
    w_DESCRI = "";
    w_CONNES = "";
    w_DTRIL = CPLib.NullDate();
    w_CPROWNUM = 0;
    Link_SZHUMIRICR();
    w_PROVENIENZA = "INTERNA";
    m_cWv_aosdt_anom_ril = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || aosdt_anom_ril.IsUpdated() || CPLib.IsUpdated(m_cWv_aosdt_anom_ril);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_IDMOD = w_IDMOD;
    o_CPROWNUM = w_CPROWNUM;
    aosdt_anom_ril.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_SZHUMIRICR() {
    return Link_SZHUMIRICR("Full");
  }
  protected boolean Link_SZHUMIRICR(String p_cType) {
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
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDMOD,"C",200,0),m_cServer_mod_ind_def,w_IDMOD);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_mod_ind_def,"select IDMOD,DESCRI from "+m_cPhName_mod_ind_def+((m_cPhName_mod_ind_def).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDMOD = l_rsLink.GetString("IDMOD");
          w_DESCRI = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SZHUMIRICR_blank();
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
      Link_SZHUMIRICR_blank();
    }
    return l_bResult;
  }
  void Link_SZHUMIRICR_blank() {
    w_IDMOD = "";
    w_DESCRI = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_IDMOD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDMOD = p_workVariableValue;
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDMOD = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNES(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CONNES = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DTRIL(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DTRIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROVENIENZA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_PROVENIENZA = p_workVariableValue;
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
    if (CPLib.ne(o_IDMOD,w_IDMOD)) {
      l_bTmpRes = Link_SZHUMIRICR();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    CopyWorkVar(this,aosdt_anom_ril,new String[]{"IDMOD","ROWRIL"},new String[]{"IDMOD","CPROWNUM"},true);
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
  public final static String[] m_KeyColumns = {"IDMOD"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("aosdt_rilevazione","rilevazione",m_KeyColumns,m_Ctx);
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
    w_IDMOD = "";
    w_DESCRI = "";
    w_CONNES = "";
    w_DTRIL = CPLib.NullDate();
    w_PROVENIENZA = "";
    w_CPROWNUM = 0;
    m_cWv_aosdt_anom_ril = "";
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
      Properties p_CONNES;
      p_CONNES = CPLib.GetProperties(trs_p.getProperty("CONNES"),new Properties());
      Properties p_DTRIL;
      p_DTRIL = CPLib.GetProperties(trs_p.getProperty("DTRIL"),new Properties());
      Properties p_PROVENIENZA;
      p_PROVENIENZA = CPLib.GetProperties(trs_p.getProperty("PROVENIENZA"),new Properties());
      Properties p_CPROWNUM;
      p_CPROWNUM = CPLib.GetProperties(trs_p.getProperty("CPROWNUM"),new Properties());
      Properties p_m_cWv_aosdt_anom_ril;
      p_m_cWv_aosdt_anom_ril = CPLib.GetProperties(trs_p.getProperty("m_cWv_aosdt_anom_ril"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_IDMOD = CPLib.GetProperty(p,"IDMOD",w_IDMOD,0);
      w_DESCRI = CPLib.GetProperty(p,"DESCRI",w_DESCRI,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_CONNES = "";
        w_CONNES = CPLib.GetProperty(p_CONNES,"",w_CONNES,i);
        w_DTRIL = CPLib.NullDate();
        w_DTRIL = CPLib.GetProperty(p_DTRIL,"",w_DTRIL,i);
        w_PROVENIENZA = "";
        w_PROVENIENZA = CPLib.GetProperty(p_PROVENIENZA,"",w_PROVENIENZA,i);
        w_CPROWNUM = 0;
        w_CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",w_CPROWNUM,i);
        aosdt_anom_ril = new aosdt_anom_rilBO(m_Ctx);
        m_cWv_aosdt_anom_ril = "";
        m_cWv_aosdt_anom_ril = CPLib.GetProperty(p_m_cWv_aosdt_anom_ril,"",m_cWv_aosdt_anom_ril,i);
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
    if (CPLib.eq(p_cName,"IDMOD")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"CONNES")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DTRIL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"PROVENIENZA")) {
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
    items = tables.get("ano_ril");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("ano_ril",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDMOD","ROWRIL"});
    map.put("rd_var",new String[]{"w_IDMOD","w_CPROWNUM"});
    map.put("wr_var",new String[]{"w_IDMOD","w_CPROWNUM"});
    map.put("wr_field",new String[]{"IDMOD","ROWRIL"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u00004",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ID del modello\u0000Progressivo rilevazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000key1",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("ano_ril\u0000false\u0000false\u00001\u00000\u0000aosdt_anom_ril\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
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
    map.put("rd_var",new String[]{"w_IDMOD","w_DESCRI"});
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
    map.put("property.value",zeroSplit.split("mod_ind_def\u0000false\u0000false\u00002\u00000\u0000aosmt_mod_ind_def\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("aosdt_rilevazione",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_rilevazione",child);
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
    for(String child : CPLib.LoadableMNTs("aosdt_rilevazione",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("aosdt_rilevazione",child);
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
    aosdt_anom_ril = new aosdt_anom_rilBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("aosdt_rilevazione",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    l_bResult = true;
    if ( ! (CPLib.Empty(w_IDMOD)) ||  ! (CPLib.Empty(w_CONNES)) ||  ! (CPLib.Empty(w_DTRIL)) ||  ! (CPLib.Empty(w_PROVENIENZA))) {
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
      l_Keys = new String[]{"aosdt_rilevazione"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"aosdt_rilevazione\\"+p_cState};
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
    o_IDMOD = "";
    o_CPROWNUM = 0;
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
    Properties p_CONNES;
    p_CONNES = new Properties();
    Properties p_DTRIL;
    p_DTRIL = new Properties();
    Properties p_PROVENIENZA;
    p_PROVENIENZA = new Properties();
    Properties p_CPROWNUM;
    p_CPROWNUM = new Properties();
    Properties p_m_cWv_aosdt_anom_ril;
    p_m_cWv_aosdt_anom_ril = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"IDMOD",w_IDMOD,0);
    CPLib.PutProperty(p,"DESCRI",w_DESCRI,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_CONNES,"",w_CONNES,trsrow);
      CPLib.PutProperty(p_DTRIL,"",w_DTRIL,trsrow);
      CPLib.PutProperty(p_PROVENIENZA,"",w_PROVENIENZA,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      if (p_bGetChildren) {
        if (aosdt_anom_ril.IsUpdated()) {
          m_cWv_aosdt_anom_ril = aosdt_anom_ril.GetContext();
        }
        CPLib.PutProperty(p_m_cWv_aosdt_anom_ril,"",m_cWv_aosdt_anom_ril,trsrow);
      }
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
      CPLib.PutProperty(p_CONNES,"",w_CONNES,trsrow);
      CPLib.PutProperty(p_DTRIL,"",w_DTRIL,trsrow);
      CPLib.PutProperty(p_PROVENIENZA,"",w_PROVENIENZA,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      if (p_bGetChildren) {
        if (aosdt_anom_ril.IsUpdated()) {
          m_cWv_aosdt_anom_ril = aosdt_anom_ril.GetContext();
        }
        CPLib.PutProperty(p_m_cWv_aosdt_anom_ril,"",m_cWv_aosdt_anom_ril,trsrow);
      }
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("m_cWv_aosdt_anom_ril",CPLib.ToProperties(p_m_cWv_aosdt_anom_ril));
    trs_p.setProperty("CONNES",CPLib.ToProperties(p_CONNES));
    trs_p.setProperty("DTRIL",CPLib.ToProperties(p_DTRIL));
    trs_p.setProperty("PROVENIENZA",CPLib.ToProperties(p_PROVENIENZA));
    trs_p.setProperty("CPROWNUM",CPLib.ToProperties(p_CPROWNUM));
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
    return "rilevazione"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDMOD","C",10,0));
  }
  public String RowPrimaryKey() {
    return "rilevazione"+"\\"+CPLib.ToCPStr(w_CPROWNUM);
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
  public boolean ChildExists_aosdt_anom_ril() {
    if (aosdt_anom_ril.IsUpdated() || (CPLib.IsUpdated(m_cWv_aosdt_anom_ril) || CPLib.IsLoaded(m_cWv_aosdt_anom_ril))) {
      return true;
    } else if (m_bLoaded &&  ! (aosdt_anom_ril.m_bLoaded)) {
      aosdt_anom_ril.Blank();
      aosdt_anom_ril.w_IDMOD = w_IDMOD;
      aosdt_anom_ril.w_ROWRIL = w_CPROWNUM;
      if (CPLib.ne(RowStatus(),"A")) {
        aosdt_anom_ril.Load();
      }
    }
    return aosdt_anom_ril.m_bLoaded;
  }
  public void CtxLoad_aosdt_anom_ril() {
    if ( ! (aosdt_anom_ril.m_lCtxLoaded)) {
      aosdt_anom_ril.Blank();
    }
    aosdt_anom_ril.m_lCtxLoaded = true;
    if ( ! (aosdt_anom_ril.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_aosdt_anom_ril) || CPLib.IsLoaded(m_cWv_aosdt_anom_ril)) {
        aosdt_anom_ril.SetFromContext(m_cWv_aosdt_anom_ril);
        m_cWv_aosdt_anom_ril = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (aosdt_anom_ril.m_bLoaded)) {
          aosdt_anom_ril.Blank();
          aosdt_anom_ril.w_IDMOD = w_IDMOD;
          aosdt_anom_ril.w_ROWRIL = w_CPROWNUM;
          if (CPLib.ne(RowStatus(),"A")) {
            aosdt_anom_ril.Load();
          }
          if ( ! (aosdt_anom_ril.m_bLoaded)) {
            aosdt_anom_ril.Initialize();
            aosdt_anom_ril.SetUpdated();
          }
          CopyWorkVar(this,aosdt_anom_ril,new String[]{"IDMOD","ROWRIL"},new String[]{"IDMOD","CPROWNUM"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,aosdt_anom_ril,new String[]{"IDMOD","ROWRIL"},new String[]{"IDMOD","CPROWNUM"},true);
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"aosdt_anom_ril")) {
      CtxLoad_aosdt_anom_ril();
      return aosdt_anom_ril;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  protected void TrsToWork() {
    w_CONNES= m_oTrs.get(m_nCurrentRow).w_CONNES;
    w_DTRIL= m_oTrs.get(m_nCurrentRow).w_DTRIL;
    w_PROVENIENZA= m_oTrs.get(m_nCurrentRow).w_PROVENIENZA;
    w_CPROWNUM= m_oTrs.get(m_nCurrentRow).w_CPROWNUM;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    m_cWv_aosdt_anom_ril= m_oTrs.get(m_nCurrentRow).m_cWv_aosdt_anom_ril;
    aosdt_anom_ril= m_oTrs.get(m_nCurrentRow).aosdt_anom_ril;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_CONNES=w_CONNES;
    m_oTrs.get(m_nCurrentRow).w_DTRIL=w_DTRIL;
    m_oTrs.get(m_nCurrentRow).w_PROVENIENZA=w_PROVENIENZA;
    m_oTrs.get(m_nCurrentRow).w_CPROWNUM=w_CPROWNUM;
    m_oTrs.get(m_nCurrentRow).m_nCPRowNum=m_nCPRowNum;
    m_oTrs.get(m_nCurrentRow).m_cWv_aosdt_anom_ril=m_cWv_aosdt_anom_ril;
    m_oTrs.get(m_nCurrentRow).aosdt_anom_ril=aosdt_anom_ril;
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
    w_CONNES = "";
    w_DTRIL = CPLib.NullDate();
    w_PROVENIENZA = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    w_PROVENIENZA = "INTERNA";
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    m_cOldRowCPCCCHK = "";
    // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
    if (CPLib.gt(Rows(),0)) {
      m_cWv_aosdt_anom_ril = "";
    }
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
    if (CPLib.gt(Rows(),0)) {
      aosdt_anom_ril = new aosdt_anom_rilBO(m_Ctx);
    }
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
    m_oDeletedRows.get(l_nRows).w_CONNES=w_CONNES;
    m_oDeletedRows.get(l_nRows).w_DTRIL=w_DTRIL;
    m_oDeletedRows.get(l_nRows).w_PROVENIENZA=w_PROVENIENZA;
    m_oDeletedRows.get(l_nRows).w_CPROWNUM=w_CPROWNUM;
    m_oDeletedRows.get(l_nRows).m_nCPRowNum=m_nCPRowNum;
    m_oDeletedRows.get(l_nRows).m_cWv_aosdt_anom_ril=m_cWv_aosdt_anom_ril;
    m_oDeletedRows.get(l_nRows).aosdt_anom_ril=aosdt_anom_ril;
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
      m_cLastMsgError = m_Ctx.Translate("Rilevazione Anomala");
      l_bResult = false;
    } else {
      if (l_bResult && (( ! (aosdt_anom_ril.m_bLoaded) && CPLib.IsLoaded(m_cWv_aosdt_anom_ril)) || ( ! (aosdt_anom_ril.m_bUpdated) && CPLib.IsUpdated(m_cWv_aosdt_anom_ril)))) {
        aosdt_anom_ril.SetFromContext(m_cWv_aosdt_anom_ril);
        m_cWv_aosdt_anom_ril = "_not_empty_";
      }
      if (l_bResult && (aosdt_anom_ril.m_bLoaded || aosdt_anom_ril.m_bUpdated)) {
        l_bResult = l_bResult && aosdt_anom_ril.Check();
        l_bNoCheck = l_bResult;
        if ( ! (l_bNoCheck)) {
          m_cLastMsgError = aosdt_anom_ril.m_cLastMsgError;
        }
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
      aosdt_anom_ril = new aosdt_anom_rilBO(m_Ctx);
      m_cWv_aosdt_anom_ril = "";
    }
    m_bUpdated = true;
    // Esecuzione dei calcoli
    Calculate();
    return true;
  }
  void SubtractTotals() {
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_IDMOD)) ||  ! (CPLib.Empty(w_CONNES)) ||  ! (CPLib.Empty(w_DTRIL)) ||  ! (CPLib.Empty(w_PROVENIENZA));
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
    w_CONNES= m_oDeletedRows.get(l_RowNumberToSet).w_CONNES;
    w_DTRIL= m_oDeletedRows.get(l_RowNumberToSet).w_DTRIL;
    w_PROVENIENZA= m_oDeletedRows.get(l_RowNumberToSet).w_PROVENIENZA;
    w_CPROWNUM= m_oDeletedRows.get(l_RowNumberToSet).w_CPROWNUM;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    m_cWv_aosdt_anom_ril= m_oDeletedRows.get(l_RowNumberToSet).m_cWv_aosdt_anom_ril;
    aosdt_anom_ril= m_oDeletedRows.get(l_RowNumberToSet).aosdt_anom_ril;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
