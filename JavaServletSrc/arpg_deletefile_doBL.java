import java.util.*;

public class arpg_deletefile_doBL extends arpg_deletefile_doWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "arpg_deletefile_do";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
  public CPPhTableWrInfo m_oWrInfo_aefiles_do;
  public String m_cPhName_aefile_do_glob;
  public String m_cServer_aefile_do_glob;
  public CPPhTableWrInfo m_oWrInfo_aefile_do_glob;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'nomefile':nomefile}";
  public static final String i_CompleteStateStructure = "{'nomefile':nomefile,'idfile':idfile,'xdescfile':xdescfile}";
  public static final String i_ItemSequence = "nomefile";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"nomefile","","C","20","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_deletefile_doBL (CPContext p_ContextObject) {
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
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    m_oWrInfo_aefiles_do = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aefiles_do",p_ContextObject.GetCompany());
    m_cPhName_aefile_do_glob = p_ContextObject.GetPhName("aefile_do_glob");
    m_cServer_aefile_do_glob = p_ContextObject.GetServer("aefile_do_glob");
    m_oWrInfo_aefile_do_glob = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aefile_do_glob",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_nomefile = "";
    w_idfile = "";
    w_xdescfile = "";
    Link_UCCWMDWDFX();
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
  protected boolean Link_UCCWMDWDFX() {
    return Link_UCCWMDWDFX("Full");
  }
  protected boolean Link_UCCWMDWDFX(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_nomefile))) {
      String l_OldValue = w_nomefile;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"C",20,0),m_cServer_aefile_do_glob,w_nomefile);
      if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_aefile_do_glob,"select nomefile,idfile,descfile from "+m_cPhName_aefile_do_glob+((m_cPhName_aefile_do_glob).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"nomefile"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_nomefile = l_rsLink.GetString("nomefile");
          w_idfile = l_rsLink.GetString("idfile");
          w_xdescfile = l_rsLink.GetString("descfile");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_UCCWMDWDFX_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","nomefile");
          }
          m_cLastWorkVarError = "nomefile";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UCCWMDWDFX_blank();
    }
    return l_bResult;
  }
  void Link_UCCWMDWDFX_blank() {
    Link_UCCWMDWDFX_blank("");
  }
  void Link_UCCWMDWDFX_blank(String p_cType) {
    w_idfile = "";
    w_xdescfile = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_nomefile(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_nomefile = p_workVariableValue;
    l_bResult = Link_UCCWMDWDFX();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_nomefile = "";
    }
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_deletefile_do","",m_KeyColumns,m_Ctx);
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
      w_nomefile = CPLib.GetProperty(p,"nomefile",w_nomefile,0);
      w_idfile = CPLib.GetProperty(p,"idfile",w_idfile,0);
      w_xdescfile = CPLib.GetProperty(p,"xdescfile",w_xdescfile,0);
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
    items = tables.get("aefile_do_glob");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("aefile_do_glob",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"nomefile","idfile","descfile"});
    map.put("rd_var",new String[]{"w_nomefile","w_idfile","w_xdescfile"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("20\u000010\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Progressivo\u0000Descrizione FIle",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("aefile_do_glob\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000File Generati\u0000\u0000\u0000false",-1));
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
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
