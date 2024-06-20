import java.util.*;

public class arpg_import_rtraBL extends arpg_import_rtraWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "arpg_import_rtra";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'tipodest':tipodest,'idmage':idmage,'destfin':destfin,'delprec':delprec}";
  public static final String i_CompleteStateStructure = "{'tipodest':tipodest,'idmage':idmage,'nomefile':nomefile,'impzip':impzip,'errchk':errchk,'gFlgCMod':gFlgCMod,'xMADESCRI':xMADESCRI,'destfin':destfin,'xMAFLGRAP':xMAFLGRAP,'xMAFLGBON':xMAFLGBON,'xMAFLGCKR':xMAFLGCKR,'xMAFLGASR':xMAFLGASR,'gAzienda':gAzienda,'gPathApp':gPathApp,'fscarti':fscarti,'xMADIPSTD':xMADIPSTD,'xMANAIDWU':xMANAIDWU,'xMAFLGCHKDAT':xMAFLGCHKDAT,'delprec':delprec}";
  public static final String i_ItemSequence = "tipodest,idmage,destfin,delprec";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"tipodest","","C","1","0","variabile","nokey","false","false"},new String[]{"idmage","MacroAgente","C","5","0","variabile","nokey","false","false"},new String[]{"destfin","","C","1","0","variabile","nokey","false","false"},new String[]{"delprec","","C","10","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public arpg_import_rtraBL (CPContext p_ContextObject) {
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
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_idmage = "";
    w_nomefile = "";
    w_gFlgCMod = m_Ctx.GetGlobalString("gFlgCMod");
    w_xMADESCRI = "";
    w_xMAFLGRAP = "";
    w_xMAFLGBON = "";
    w_xMAFLGCKR = "";
    w_xMAFLGASR = "";
    w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
    w_gPathApp = m_Ctx.GetGlobalString("gPathApp");
    w_fscarti = 0;
    w_xMADIPSTD = "";
    w_xMANAIDWU = "";
    w_xMAFLGCHKDAT = "";
    w_tipodest = "P";
    Link_XFVQTXPEXL();
    w_impzip = 0;
    w_errchk = 0;
    w_destfin = "O";
    w_delprec = "N";
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
    o_idmage = w_idmage;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_IJLORSXQBU();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_XFVQTXPEXL() {
    return Link_XFVQTXPEXL("Full");
  }
  protected boolean Link_XFVQTXPEXL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_idmage))) {
      String l_OldValue = w_idmage;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idmage,"C",5,0),m_cServer_tbmacage,w_idmage);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON,MAFLGCKR,MAFLGASR,MADIPSTD,MANAIDWU,MAFLGCHKDAT from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idmage,"C",60,0),m_cServer_tbmacage,w_idmage);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON,MAFLGCKR,MAFLGASR,MADIPSTD,MANAIDWU,MAFLGCHKDAT from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MADESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_idmage = l_rsLink.GetString("MACODICE");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          w_xMAFLGRAP = l_rsLink.GetString("MAFLGRAP");
          w_destfin = l_rsLink.GetString("MAFLGOPE");
          w_xMAFLGBON = l_rsLink.GetString("MAFLGBON");
          w_xMAFLGCKR = l_rsLink.GetString("MAFLGCKR");
          w_xMAFLGASR = l_rsLink.GetString("MAFLGASR");
          w_xMADIPSTD = l_rsLink.GetString("MADIPSTD");
          w_xMANAIDWU = l_rsLink.GetString("MANAIDWU");
          w_xMAFLGCHKDAT = l_rsLink.GetString("MAFLGCHKDAT");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_XFVQTXPEXL_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_idmage = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","idmage");
          }
          m_cLastWorkVarError = "idmage";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XFVQTXPEXL_blank();
    }
    return l_bResult;
  }
  void Link_XFVQTXPEXL_blank() {
    w_idmage = "";
    w_xMADESCRI = "";
    w_xMAFLGRAP = "";
    w_destfin = "";
    w_xMAFLGBON = "";
    w_xMAFLGCKR = "";
    w_xMAFLGASR = "";
    w_xMADIPSTD = "";
    w_xMANAIDWU = "";
    w_xMAFLGCHKDAT = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_tipodest(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_tipodest = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_idmage(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_idmage = p_workVariableValue;
    l_bResult = Link_XFVQTXPEXL();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_idmage = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_destfin(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_destfin = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_delprec(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_delprec = p_workVariableValue;
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
    if (CPLib.ne(o_idmage,w_idmage)) {
      Calculation_YTRRRNBWKF();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_IJLORSXQBU() {
    azzera_messaggiR l_oRoutine_azzera_messaggi;
    l_oRoutine_azzera_messaggi = azzera_messaggiR.Make(m_Ctx,this);
    l_oRoutine_azzera_messaggi.Run();
  }
  void Calculation_YTRRRNBWKF() {
    w_destfin = (CPLib.Empty(w_idmage)?"O":w_destfin);
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
    l_cFilter = CPLib.ApplicationQueryFilter("arpg_import_rtra","",m_KeyColumns,m_Ctx);
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
      w_tipodest = CPLib.GetProperty(p,"tipodest",w_tipodest,0);
      w_idmage = CPLib.GetProperty(p,"idmage",w_idmage,0);
      w_nomefile = CPLib.GetProperty(p,"nomefile",w_nomefile,0);
      w_impzip = CPLib.GetProperty(p,"impzip",w_impzip,0);
      w_errchk = CPLib.GetProperty(p,"errchk",w_errchk,0);
      w_gFlgCMod = CPLib.GetProperty(p,"gFlgCMod",w_gFlgCMod,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_destfin = CPLib.GetProperty(p,"destfin",w_destfin,0);
      w_xMAFLGRAP = CPLib.GetProperty(p,"xMAFLGRAP",w_xMAFLGRAP,0);
      w_xMAFLGBON = CPLib.GetProperty(p,"xMAFLGBON",w_xMAFLGBON,0);
      w_xMAFLGCKR = CPLib.GetProperty(p,"xMAFLGCKR",w_xMAFLGCKR,0);
      w_xMAFLGASR = CPLib.GetProperty(p,"xMAFLGASR",w_xMAFLGASR,0);
      w_gAzienda = CPLib.GetProperty(p,"gAzienda",w_gAzienda,0);
      w_gPathApp = CPLib.GetProperty(p,"gPathApp",w_gPathApp,0);
      w_fscarti = CPLib.GetProperty(p,"fscarti",w_fscarti,0);
      w_xMADIPSTD = CPLib.GetProperty(p,"xMADIPSTD",w_xMADIPSTD,0);
      w_xMANAIDWU = CPLib.GetProperty(p,"xMANAIDWU",w_xMANAIDWU,0);
      w_xMAFLGCHKDAT = CPLib.GetProperty(p,"xMAFLGCHKDAT",w_xMAFLGCHKDAT,0);
      w_delprec = CPLib.GetProperty(p,"delprec",w_delprec,0);
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
    items = tables.get("tbmacage");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbmacage",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"MACODICE","MADESCRI","MAFLGRAP","MAFLGOPE","MAFLGBON","MAFLGCKR","MAFLGASR","MADIPSTD","MANAIDWU","MAFLGCHKDAT"});
    map.put("rd_var",new String[]{"w_idmage","w_xMADESCRI","w_xMAFLGRAP","w_destfin","w_xMAFLGBON","w_xMAFLGCKR","w_xMAFLGASR","w_xMADIPSTD","w_xMANAIDWU","w_xMAFLGCHKDAT"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060\u00001\u00001\u00001\u00001\u00001\u00006\u00005\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("MacroAgente\u0000Denominazione\u0000Generazione Rapporti da operazioni\u0000\u0000Scrive tipo operazione come bonifico\u0000Controllo esistenza Rapporto\u0000Associa Operazione a Rapporto\u0000Dipendenza Default\u0000NAID\u0000Dati certi per Soggetti",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000MacroAgenti\u0000\u0000\u0000false",-1));
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
