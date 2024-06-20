import java.util.*;

public class arpg_trasffra_age_oldBL extends arpg_trasffra_age_oldWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_FLGSEL;
    public String t_FLGSEL;
    public String k_FLGSEL_NUMPROG;
    public String c_NUMPROG;
    public java.sql.Date c_DATAOPE;
    public String c_RAPPORTO;
    public String c_CONNESCLI;
    public double c_TOTLIRE;
    public double c_TOTCONT;
    public String c_VALUTA;
    public String c_IDBASE;
    public String c_CODDIP;
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
  public static final String i_EntityName = "arpg_trasffra_age_old";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_tmp_trasfope;
  public String m_cServer_tmp_trasfope;
  public CPPhTableWrInfo m_oWrInfo_tmp_trasfope;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'flgglob':flgglob,'coddip':coddip,'DaDatOpe':DaDatOpe,'ADatOpe':ADatOpe}";
  public static final String i_CompleteStateStructure = "{'flgage':flgage,'flgglob':flgglob,'coddip':coddip,'DaDatOpe':DaDatOpe,'ADatOpe':ADatOpe,'cdadata':cdadata,'c_adata':c_adata,'xdesdip':xdesdip}";
  public static final String i_ItemSequence = "flgglob,coddip,DaDatOpe,ADatOpe";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"flgglob","","C","1","0","variabile","nokey","false","false"},new String[]{"coddip","","C","6","0","variabile","nokey","false","false"},new String[]{"DaDatOpe","","D","8","0","variabile","nokey","false","false"},new String[]{"ADatOpe","","D","8","0","variabile","nokey","false","false"}});
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
  public arpg_trasffra_age_oldBL (CPContext p_ContextObject) {
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
    m_cPhName_tmp_trasfope = p_ContextObject.GetPhName("tmp_trasfope");
    m_cServer_tmp_trasfope = p_ContextObject.GetServer("tmp_trasfope");
    m_oWrInfo_tmp_trasfope = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tmp_trasfope",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_coddip = "";
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_xdesdip = "";
    w_flgage = "";
    w_flgage = "S";
    w_flgglob = "N";
    Link_MRVXCEHVUD();
    w_cdadata = "";
    w_cdadata = CPLib.DateToChar(w_DaDatOpe);
    w_c_adata = "";
    w_c_adata = CPLib.DateToChar(w_ADatOpe);
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
  protected boolean Link_MRVXCEHVUD() {
    return Link_MRVXCEHVUD("Full");
  }
  protected boolean Link_MRVXCEHVUD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_coddip))) {
      String l_OldValue = w_coddip;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddip,"C",6,0),m_cServer_anadip,w_coddip);
      l_cWhere = l_cWhere+" and AGENTE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_flgage,"C",1,0),m_cServer_anadip,w_flgage);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select AGENTE,CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddip,"C",30,0),m_cServer_anadip,w_coddip);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select AGENTE,CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_coddip = l_rsLink.GetString("CODDIP");
          w_xdesdip = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MRVXCEHVUD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_coddip = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","coddip");
          }
          m_cLastWorkVarError = "coddip";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MRVXCEHVUD_blank();
    }
    return l_bResult;
  }
  void Link_MRVXCEHVUD_blank() {
    w_coddip = "";
    w_xdesdip = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_flgglob(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_flgglob = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_coddip(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_coddip = p_workVariableValue;
    l_bResult = Link_MRVXCEHVUD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_coddip = "";
    }
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
    // 
    l_bResult = CPLib.ge(w_ADatOpe,w_DaDatOpe);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di fine periodo deve essere minore di quella di inizio periodo !";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ADatOpe = CPLib.NullDate();
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
  public boolean getWritable_coddip() {
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
    w_flgage = "S";
    w_cdadata = CPLib.DateToChar(w_DaDatOpe);
    w_c_adata = CPLib.DateToChar(w_ADatOpe);
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_trasffra_age_old","",m_KeyColumns,m_Ctx);
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
      w_flgage = CPLib.GetProperty(p,"flgage",w_flgage,0);
      w_flgglob = CPLib.GetProperty(p,"flgglob",w_flgglob,0);
      w_coddip = CPLib.GetProperty(p,"coddip",w_coddip,0);
      w_DaDatOpe = CPLib.GetProperty(p,"DaDatOpe",w_DaDatOpe,0);
      w_ADatOpe = CPLib.GetProperty(p,"ADatOpe",w_ADatOpe,0);
      w_cdadata = CPLib.GetProperty(p,"cdadata",w_cdadata,0);
      w_c_adata = CPLib.GetProperty(p,"c_adata",w_c_adata,0);
      w_xdesdip = CPLib.GetProperty(p,"xdesdip",w_xdesdip,0);
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
        k_FLGSEL_NUMPROG = CPLib.GetProperty(trs_p,"k_FLGSEL_NUMPROG","",i);
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
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_flgage"});
    map.put("rd_kfield",new String[]{"AGENTE"});
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ"});
    map.put("rd_var",new String[]{"w_coddip","w_xdesdip"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("6\u000030",-1));
    map.put("rd_kvar.len",zeroSplit.split("1",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Agenzie\u0000\u0000\u0000false",-1));
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
  public void Link_BBVZXDYMJX(String NUMPROG) {
    boolean l_bLoaded;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if (l_rsLink!=null)
      l_rsLink.Close();
    l_rsLink = m_Sql.Query(m_cServer_tmp_trasfope,"select FLGSEL from "+m_cPhName_tmp_trasfope+((m_cPhName_tmp_trasfope).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"NUMPROG="+CPLib.ToSQL(NUMPROG,"C",11,0));
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
    m_oTrs.get(m_nCurrentRow).c_NUMPROG=c_NUMPROG;
    m_oTrs.get(m_nCurrentRow).c_DATAOPE=c_DATAOPE;
    m_oTrs.get(m_nCurrentRow).c_RAPPORTO=c_RAPPORTO;
    m_oTrs.get(m_nCurrentRow).c_CONNESCLI=c_CONNESCLI;
    m_oTrs.get(m_nCurrentRow).c_TOTLIRE=c_TOTLIRE;
    m_oTrs.get(m_nCurrentRow).c_TOTCONT=c_TOTCONT;
    m_oTrs.get(m_nCurrentRow).c_VALUTA=c_VALUTA;
    m_oTrs.get(m_nCurrentRow).c_IDBASE=c_IDBASE;
    m_oTrs.get(m_nCurrentRow).c_CODDIP=c_CODDIP;
    m_oTrs.get(m_nCurrentRow).w_FLGSEL=w_FLGSEL;
    m_oTrs.get(m_nCurrentRow).t_FLGSEL=t_FLGSEL;
    m_oTrs.get(m_nCurrentRow).k_FLGSEL_NUMPROG=k_FLGSEL_NUMPROG;
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
  }
  public void TrsToWork() {
    c_NUMPROG= m_oTrs.get(m_nCurrentRow).c_NUMPROG;
    c_DATAOPE= m_oTrs.get(m_nCurrentRow).c_DATAOPE;
    c_RAPPORTO= m_oTrs.get(m_nCurrentRow).c_RAPPORTO;
    c_CONNESCLI= m_oTrs.get(m_nCurrentRow).c_CONNESCLI;
    c_TOTLIRE= m_oTrs.get(m_nCurrentRow).c_TOTLIRE;
    c_TOTCONT= m_oTrs.get(m_nCurrentRow).c_TOTCONT;
    c_VALUTA= m_oTrs.get(m_nCurrentRow).c_VALUTA;
    c_IDBASE= m_oTrs.get(m_nCurrentRow).c_IDBASE;
    c_CODDIP= m_oTrs.get(m_nCurrentRow).c_CODDIP;
    w_FLGSEL= m_oTrs.get(m_nCurrentRow).w_FLGSEL;
    t_FLGSEL= m_oTrs.get(m_nCurrentRow).t_FLGSEL;
    k_FLGSEL_NUMPROG= m_oTrs.get(m_nCurrentRow).k_FLGSEL_NUMPROG;
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
