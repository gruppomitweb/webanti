import java.util.*;

public class arpg_scaricodati_globaleBL extends arpg_scaricodati_globaleWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "arpg_scaricodati_globale";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'a_data':a_data,'CFINVIO':CFINVIO,'CAFINVIO':CAFINVIO,'FILEINVIO':FILEINVIO,'DATAINVIO':DATAINVIO}";
  public static final String i_CompleteStateStructure = "{'dadata':dadata,'a_data':a_data,'bloccaedit':bloccaedit,'files':files,'gIntemediario':gIntemediario,'CFINVIO':CFINVIO,'CAFINVIO':CAFINVIO,'FILEINVIO':FILEINVIO,'DATAINVIO':DATAINVIO,'gDescAzi':gDescAzi}";
  public static final String i_ItemSequence = "a_data,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIO";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"a_data","","D","8","0","variabile","nokey","false","false"},new String[]{"CFINVIO","Codice Fiscale Organo Invio File","C","16","0","variabile","nokey","false","false"},new String[]{"CAFINVIO","Codice CAF Organo Invio","C","5","0","variabile","nokey","false","false"},new String[]{"FILEINVIO","Tipo Preparazione FIle","C","1","0","variabile","nokey","false","false"},new String[]{"DATAINVIO","Data Impegno Organo Invio","D","8","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_scaricodati_globaleBL (CPContext p_ContextObject) {
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
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_a_data = CPLib.NullDate();
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_CFINVIO = "";
    w_CAFINVIO = "";
    w_FILEINVIO = "";
    w_DATAINVIO = CPLib.NullDate();
    w_gDescAzi = m_Ctx.GetGlobalString("gDescAzi");
    w_dadata = CPLib.NullDate();
    w_dadata = CPLib.CharToDate("20050101");
    w_bloccaedit = "N";
    w_files = 0;
    w_files = arfn_filesageR.Make(m_Ctx,this).Run();
    Link_AHMXEPADOR();
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
    o_gIntemediario = w_gIntemediario;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_AHMXEPADOR() {
    return Link_AHMXEPADOR("Full");
  }
  protected boolean Link_AHMXEPADOR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_gIntemediario))) {
      String l_OldValue = w_gIntemediario;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_gIntemediario,"C",11,0),m_cServer_intermbo,w_gIntemediario);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_intermbo,"select CODINTER,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIO from "+m_cPhName_intermbo+((m_cPhName_intermbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_gIntemediario = l_rsLink.GetString("CODINTER");
          w_CFINVIO = l_rsLink.GetString("CFINVIO");
          w_CAFINVIO = l_rsLink.GetString("CAFINVIO");
          w_FILEINVIO = l_rsLink.GetString("FILEINVIO");
          w_DATAINVIO = l_rsLink.GetDate("DATAINVIO");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AHMXEPADOR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_gIntemediario = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","gIntemediario");
          }
          m_cLastWorkVarError = "gIntemediario";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AHMXEPADOR_blank();
    }
    return l_bResult;
  }
  void Link_AHMXEPADOR_blank() {
    w_gIntemediario = "";
    w_CFINVIO = "";
    w_CAFINVIO = "";
    w_FILEINVIO = "";
    w_DATAINVIO = CPLib.NullDate();
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
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
    l_bResult = CPLib.ge(w_a_data,w_dadata);
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
  public boolean Set_CFINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CFINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAFINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAFINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FILEINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FILEINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINVIO(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINVIO = p_workVariableValue;
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
    w_dadata = CPLib.CharToDate("20050101");
    w_files = arfn_filesageR.Make(m_Ctx,this).Run();
    if (CPLib.ne(o_gIntemediario,w_gIntemediario)) {
      l_bTmpRes = Link_AHMXEPADOR("Load");
    }
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_scaricodati_globale","",m_KeyColumns,m_Ctx);
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
      w_dadata = CPLib.GetProperty(p,"dadata",w_dadata,0);
      w_a_data = CPLib.GetProperty(p,"a_data",w_a_data,0);
      w_bloccaedit = CPLib.GetProperty(p,"bloccaedit",w_bloccaedit,0);
      w_files = CPLib.GetProperty(p,"files",w_files,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_CFINVIO = CPLib.GetProperty(p,"CFINVIO",w_CFINVIO,0);
      w_CAFINVIO = CPLib.GetProperty(p,"CAFINVIO",w_CAFINVIO,0);
      w_FILEINVIO = CPLib.GetProperty(p,"FILEINVIO",w_FILEINVIO,0);
      w_DATAINVIO = CPLib.GetProperty(p,"DATAINVIO",w_DATAINVIO,0);
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
    map = new HashMap<String,String[]>();
    items = tables.get("intermbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("intermbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","CFINVIO","CAFINVIO","FILEINVIO","DATAINVIO"});
    map.put("rd_var",new String[]{"w_gIntemediario","w_CFINVIO","w_CAFINVIO","w_FILEINVIO","w_DATAINVIO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000D",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000016\u00005\u00001\u00008",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Intermediario\u0000Codice Fiscale Organo Invio File\u0000Codice CAF Organo Invio\u0000Tipo Preparazione FIle\u0000Data Impegno Organo Invio",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("intermbo\u0000false\u0000false\u00001\u00000\u0000armt_intermbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
