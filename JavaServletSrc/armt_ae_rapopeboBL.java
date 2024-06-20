import java.util.*;

public class armt_ae_rapopeboBL extends armt_ae_rapopeboWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
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
  public static final String i_EntityName = "armt_ae_rapopebo";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public CPPhTableWrInfo m_oWrInfo_japopebo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_japopebo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public CPPhTableWrInfo m_oWrInfo_anarapbo;
  public String m_cPhName_tbtipleg;
  public String m_cServer_tbtipleg;
  public CPPhTableWrInfo m_oWrInfo_tbtipleg;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public CPPhTableWrInfo m_oWrInfo_tbtipreg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public CPPhTableWrInfo m_oWrInfo_jnarapbo;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"japopebo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'ardt_ae_intestbo':ardt_ae_intestbo,'ardt_ae_delegabo':ardt_ae_delegabo,'CODDIPE':CODDIPE,'RAPPORTO':RAPPORTO,'DATAOPE':DATAOPE,'DATAREG':DATAREG,'TIPOOPRAP':TIPOOPRAP,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'IDBASE':IDBASE,'ardt_ae_soginfo':ardt_ae_soginfo"+FoundlingChildrenList("armt_ae_rapopebo",true)+"}";
  public static final String i_CompleteStateStructure = "{'ardt_ae_intestbo':ardt_ae_intestbo,'ardt_ae_delegabo':ardt_ae_delegabo,'gIntemediario':gIntemediario,'gSblocco':gSblocco,'gFlgDTP':gFlgDTP,'gChkDate':gChkDate,'gStatus':gStatus,'gDataVaria':gDataVaria,'gCodDip':gCodDip,'filtro':filtro,'dataoggi':dataoggi,'tipreg':tipreg,'tipregn':tipregn,'CDATOPE':CDATOPE,'sEdit':sEdit,'CODINTER':CODINTER,'CODDIPE':CODDIPE,'RAPPORTO':RAPPORTO,'DATAOPE':DATAOPE,'DATAREG':DATAREG,'TIPOOPRAP':TIPOOPRAP,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'IDBASE':IDBASE,'TIPOINTER':TIPOINTER,'TIPOINF':TIPOINF,'IDEREG':IDEREG,'FLAGRAP':FLAGRAP,'OPRAP':OPRAP,'OPERATORE':OPERATORE,'AUTOM':AUTOM,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CODCAB':CODCAB,'NUMPROG':NUMPROG,'xdescrap':xdescrap,'xDescDipe':xDescDipe,'datpaseuro':datpaseuro,'xDesReg':xDesReg,'xRagSoc':xRagSoc,'errmsg':errmsg,'Aggiorna':Aggiorna,'FLAGRAP2':FLAGRAP2,'lancio':lancio,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'PRGIMPINF':PRGIMPINF,'CITINT':CITINT,'CITDIP':CITDIP,'PROVDIP':PROVDIP,'CABDIP':CABDIP,'PROVINT':PROVINT,'CABINT':CABINT,'OPERAZMOD':OPERAZMOD,'inutile':inutile,'prova':prova,'ardt_ae_soginfo':ardt_ae_soginfo"+FoundlingChildrenList("armt_ae_rapopebo",true)+"}";
  public static final String i_ItemSequence = "ardt_ae_intestbo,ardt_ae_delegabo,CODDIPE,RAPPORTO,DATAOPE,DATAREG,TIPOOPRAP,CONNESOPER,TIPOLEG,IDBASE,ardt_ae_soginfo"+FoundlingChildrenList("armt_ae_rapopebo",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_ae_rapopebo"),new String[][]{new String[]{"ardt_ae_intestbo","Informazioni","","","","link_PC","","false",""},new String[]{"ardt_ae_delegabo","Informazioni","","","","link_PC","","false",""},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"RAPPORTO","","C","25","0","campo","nokey","false","false"},new String[]{"DATAOPE","Data Operazione","D","8","0","campo","key2","false","true"},new String[]{"DATAREG","Data registrazione","D","8","0","campo","nokey","false","true"},new String[]{"TIPOOPRAP","Tipo Informazione","C","2","0","campo","key5","false","true"},new String[]{"CONNESOPER","Soggetto Operante Conto Terzi","C","16","0","campo","key6","false","false"},new String[]{"TIPOLEG","Tipo Legame Sogg.","C","1","0","campo","nokey","false","false"},new String[]{"IDBASE","idbase","C","10","0","campo","key1","false","false"},new String[]{"ardt_ae_soginfo","Soggetti Agenti per Conto Inform.","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_ae_rapopeboBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo",p_ContextObject.GetCompany(),false);
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_oWrInfo_japopebo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"japopebo",p_ContextObject.GetCompany());
    m_cVirtName_japopebo = CPSql.ManipulateTablePhName("japopebo",m_cServer_japopebo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_oWrInfo_anarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anarapbo",p_ContextObject.GetCompany());
    m_cPhName_tbtipleg = p_ContextObject.GetPhName("tbtipleg");
    m_cServer_tbtipleg = p_ContextObject.GetServer("tbtipleg");
    m_oWrInfo_tbtipleg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipleg",p_ContextObject.GetCompany());
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_oWrInfo_tbtipreg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipreg",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_oWrInfo_jnarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"jnarapbo",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_ae_intestbo = new ardt_ae_intestboBO(p_ContextObject);
    ardt_ae_delegabo = new ardt_ae_delegaboBO(p_ContextObject);
    ardt_ae_soginfo = new ardt_ae_soginfoBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_ae_rapopebo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_tipreg = "";
    w_RAPPORTO = "";
    w_DATAOPE = CPLib.NullDate();
    w_TIPOOPRAP = "";
    w_CONNESOPER = "";
    w_TIPOLEG = "";
    w_IDBASE = "";
    w_TIPOINTER = "";
    w_IDEREG = "";
    w_FLAGRAP = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_NUMPROG = "";
    w_xdescrap = "";
    w_xDescDipe = "";
    w_datpaseuro = CPLib.NullDate();
    w_xDesReg = "";
    w_xRagSoc = "";
    w_errmsg = "";
    w_Aggiorna = "";
    w_FLAGRAP2 = "";
    w_lancio = 0;
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_PRGIMPINF = 0;
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_IDEREG = "";
    w_OPERAZMOD = "";
    w_filtro = "";
    w_filtro = "O";
    w_dataoggi = CPLib.NullDate();
    w_dataoggi = CPLib.Date();
    w_tipregn = 0;
    w_tipregn = CPLib.Val(CPLib.LRTrim(w_tipreg));
    w_CDATOPE = "";
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    w_sEdit = 0;
    w_CODINTER = "";
    w_CODINTER = w_gIntemediario;
    Link_WJSVGWKSFC();
    w_CODDIPE = w_gCodDip;
    Link_AVHTGZTOSZ();
    Link_UMFEJVRUFZ();
    w_DATAREG = CPLib.Date();
    Link_SWRTSKXMDH();
    Link_SLTZSUMACW();
    Link_MLPGOPNAKN();
    w_TIPOINF = "1";
    w_OPRAP = "";
    w_OPRAP = CPLib.Left(w_TIPOOPRAP,1);
    w_inutile = 0;
    w_inutile = 0;
    w_prova = "";
    w_prova = LibreriaMit.URL_enc(w_RAPPORTO);
    m_cWv_ardt_ae_intestbo = "";
    m_cWv_ardt_ae_delegabo = "";
    m_cWv_ardt_ae_soginfo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_ae_intestbo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_intestbo);
    l_bResult = l_bResult || ardt_ae_delegabo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_delegabo);
    l_bResult = l_bResult || ardt_ae_soginfo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_soginfo);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_filtro = w_filtro;
    o_CDATOPE = w_CDATOPE;
    o_CODINTER = w_CODINTER;
    o_CODDIPE = w_CODDIPE;
    o_RAPPORTO = w_RAPPORTO;
    o_DATAOPE = w_DATAOPE;
    o_TIPOOPRAP = w_TIPOOPRAP;
    o_FLAGRAP = w_FLAGRAP;
    ardt_ae_intestbo.SaveDependsOn();
    ardt_ae_delegabo.SaveDependsOn();
    ardt_ae_soginfo.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_WJSVGWKSFC() {
    return Link_WJSVGWKSFC("Full");
  }
  protected boolean Link_WJSVGWKSFC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODINTER))) {
      String l_OldValue = w_CODINTER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",11,0),m_cServer_intermbo,w_CODINTER);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_intermbo,"select CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT,TIPINTER from "+m_cPhName_intermbo+((m_cPhName_intermbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODINTER = l_rsLink.GetString("CODINTER");
          w_datpaseuro = l_rsLink.GetDate("DATANASC");
          w_CABINT = l_rsLink.GetString("CODCAB");
          w_PROVINT = l_rsLink.GetString("PROVINCIA");
          w_CITINT = l_rsLink.GetString("DESCCIT");
          w_TIPOINTER = l_rsLink.GetString("TIPINTER");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_WJSVGWKSFC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODINTER = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINTER");
          }
          m_cLastWorkVarError = "CODINTER";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_WJSVGWKSFC_blank();
    }
    return l_bResult;
  }
  void Link_WJSVGWKSFC_blank() {
    w_CODINTER = "";
    w_datpaseuro = CPLib.NullDate();
    w_CABINT = "";
    w_PROVINT = "";
    w_CITINT = "";
    w_TIPOINTER = "";
  }
  protected boolean Link_AVHTGZTOSZ() {
    return Link_AVHTGZTOSZ("Full");
  }
  protected boolean Link_AVHTGZTOSZ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODDIPE))) {
      String l_OldValue = w_CODDIPE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",6,0),m_cServer_anadip,w_CODDIPE);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",30,0),m_cServer_anadip,w_CODDIPE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODDIPE = l_rsLink.GetString("CODDIP");
          w_xDescDipe = l_rsLink.GetString("DESCRIZ");
          w_CITDIP = l_rsLink.GetString("DESCCIT");
          w_PROVDIP = l_rsLink.GetString("PROVINCIA");
          w_CABDIP = l_rsLink.GetString("CAB");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AVHTGZTOSZ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODDIPE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODDIPE");
          }
          m_cLastWorkVarError = "CODDIPE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AVHTGZTOSZ_blank();
    }
    return l_bResult;
  }
  void Link_AVHTGZTOSZ_blank() {
    w_CODDIPE = "";
    w_xDescDipe = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
  }
  protected boolean Link_UMFEJVRUFZ() {
    return Link_UMFEJVRUFZ("Full");
  }
  protected boolean Link_UMFEJVRUFZ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAPPORTO))) {
      String l_OldValue = w_RAPPORTO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_jnarapbo,w_RAPPORTO);
      if (m_Ctx.IsSharedTemp("jnarapbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_jnarapbo,"select RAPPORTO,DESCRAP,FLAGLIRE,VALUTA,TIPORAP from "+m_cPhName_jnarapbo+((m_cPhName_jnarapbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAPPORTO"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",50,0),m_cServer_jnarapbo,w_RAPPORTO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_jnarapbo,"select RAPPORTO,DESCRAP,FLAGLIRE,VALUTA,TIPORAP from "+m_cPhName_jnarapbo+((m_cPhName_jnarapbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRAP"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAPPORTO = l_rsLink.GetString("RAPPORTO");
          w_xdescrap = l_rsLink.GetString("DESCRAP");
          w_FLAGLIRE = l_rsLink.GetString("FLAGLIRE");
          w_VALUTA = l_rsLink.GetString("VALUTA");
          w_FLAGRAP = l_rsLink.GetString("TIPORAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UMFEJVRUFZ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAPPORTO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAPPORTO");
          }
          m_cLastWorkVarError = "RAPPORTO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UMFEJVRUFZ_blank();
    }
    return l_bResult;
  }
  void Link_UMFEJVRUFZ_blank() {
    w_RAPPORTO = "";
    w_xdescrap = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_FLAGRAP = "";
  }
  protected boolean Link_SWRTSKXMDH() {
    return Link_SWRTSKXMDH("Full");
  }
  protected boolean Link_SWRTSKXMDH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOOPRAP))) {
      String l_OldValue = w_TIPOOPRAP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOOPRAP,"C",2,0),m_cServer_tbtipreg,w_TIPOOPRAP);
      if (m_Ctx.IsSharedTemp("tbtipreg")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipreg,"select CODICE,DES1,TIPREG from "+m_cPhName_tbtipreg+((m_cPhName_tbtipreg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOOPRAP,"C",90,0),m_cServer_tbtipreg,w_TIPOOPRAP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtipreg,"select CODICE,DES1,TIPREG from "+m_cPhName_tbtipreg+((m_cPhName_tbtipreg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DES1"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOOPRAP = l_rsLink.GetString("CODICE");
          w_xDesReg = l_rsLink.GetString("DES1");
          w_tipreg = l_rsLink.GetString("TIPREG");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SWRTSKXMDH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOOPRAP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOOPRAP");
          }
          m_cLastWorkVarError = "TIPOOPRAP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SWRTSKXMDH_blank();
    }
    return l_bResult;
  }
  void Link_SWRTSKXMDH_blank() {
    w_TIPOOPRAP = "";
    w_xDesReg = "";
    w_tipreg = "";
  }
  protected boolean Link_SLTZSUMACW() {
    return Link_SLTZSUMACW("Full");
  }
  protected boolean Link_SLTZSUMACW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESOPER))) {
      String l_OldValue = w_CONNESOPER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESOPER,"C",16,0),m_cServer_personbo,w_CONNESOPER);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESOPER,"C",70,0),m_cServer_personbo,w_CONNESOPER);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESOPER = l_rsLink.GetString("CONNES");
          w_xRagSoc = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SLTZSUMACW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESOPER = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chksoggR.Make(m_Ctx,this).Run(w_CONNESOPER,"8");
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESOPER");
              }
              m_cLastWorkVarError = "CONNESOPER";
              w_CONNESOPER = "";
              Link_SLTZSUMACW_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESOPER");
              }
              m_cLastWorkVarError = "CONNESOPER";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SLTZSUMACW_blank();
    }
    return l_bResult;
  }
  void Link_SLTZSUMACW_blank() {
    w_CONNESOPER = "";
    w_xRagSoc = "";
  }
  protected boolean Link_MLPGOPNAKN() {
    return Link_MLPGOPNAKN("Full");
  }
  protected boolean Link_MLPGOPNAKN(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOLEG))) {
      String l_OldValue = w_TIPOLEG;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOLEG,"C",1,0),m_cServer_tbtipleg,w_TIPOLEG);
      if (m_Ctx.IsSharedTemp("tbtipleg")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipleg,"select TIPLEG from "+m_cPhName_tbtipleg+((m_cPhName_tbtipleg).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPLEG"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOLEG = l_rsLink.GetString("TIPLEG");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MLPGOPNAKN_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOLEG = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOLEG");
          }
          m_cLastWorkVarError = "TIPOLEG";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MLPGOPNAKN_blank();
    }
    return l_bResult;
  }
  void Link_MLPGOPNAKN_blank() {
    w_TIPOLEG = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CODDIPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIPE = p_workVariableValue;
    l_bResult = Link_AVHTGZTOSZ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODDIPE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPPORTO = p_workVariableValue;
    l_bResult = Link_UMFEJVRUFZ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAPPORTO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAOPE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAOPE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = CPLib.ge(w_DATAREG,w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di registrazione deve essere maggiore o uguale a quella dell'informazione";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAOPE = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public java.sql.Date getDefault_DATAOPE() {
    // Gestione del default
    return CPLib.Date();
  }
  public boolean Set_DATAREG(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAREG = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = CPLib.ge(w_DATAREG,w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di registrazione deve essere maggiore o uguale a quella dell'informazione";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAREG = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOOPRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOOPRAP = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_SWRTSKXMDH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOOPRAP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESOPER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESOPER = p_workVariableValue;
    l_bResult = Link_SLTZSUMACW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESOPER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOLEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOLEG = p_workVariableValue;
    l_bResult = Link_MLPGOPNAKN();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOLEG = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDBASE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDBASE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_CODDIPE() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(3));
  }
  public boolean getWritable_DATAREG() {
    return CPLib.ne(w_gChkDate,"U") && CPLib.ne(w_gChkDate,"B") && CPLib.eq(w_gFlgDTP,0);
  }
  public boolean getVisible_CONNESOPER() {
    return arfn_view_soctR.Make(m_Ctx,this).Run(w_DATAOPE,w_TIPOOPRAP,"V");
  }
  public boolean getVisible_TIPOLEG() {
    return arfn_view_soctR.Make(m_Ctx,this).Run(w_DATAOPE,w_TIPOOPRAP,"T");
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
    w_filtro = "O";
    w_dataoggi = CPLib.Date();
    if (CPLib.ne(o_TIPOOPRAP,w_TIPOOPRAP)) {
      w_tipregn = CPLib.Val(CPLib.LRTrim(w_tipreg));
    }
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    w_CODINTER = w_gIntemediario;
    l_bTmpRes = Link_WJSVGWKSFC();
    if (CPLib.ne(o_CDATOPE,w_CDATOPE) || CPLib.ne(o_filtro,w_filtro)) {
      l_bTmpRes = Link_MLPGOPNAKN();
    }
    w_OPRAP = CPLib.Left(w_TIPOOPRAP,1);
    if (CPLib.ne(o_RAPPORTO,w_RAPPORTO)) {
      w_inutile = 0;
    }
    w_prova = LibreriaMit.URL_enc(w_RAPPORTO);
    if (CPLib.ne(o_CODINTER,w_CODINTER) || CPLib.ne(o_CODDIPE,w_CODDIPE)) {
      Calculation_WKUMXNRIRT();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    CopyWorkVar(this,ardt_ae_intestbo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},true);
    CopyWorkVar(this,ardt_ae_delegabo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},true);
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_OEZVQSLBRM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "JAPOPEBO";
    l_oRoutine_arrt_writelog.pChiave = w_NUMPROG;
    l_oRoutine_arrt_writelog.Run();
    arrt_ae_agg_aetesta_ageR l_oRoutine_arrt_ae_agg_aetesta_age;
    l_oRoutine_arrt_ae_agg_aetesta_age = arrt_ae_agg_aetesta_ageR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta_age.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_TIPOOPRAP = w_TIPOOPRAP;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_NUMPROG = w_NUMPROG;
    l_oRoutine_arrt_ae_agg_aetesta_age.Run();
    arrt_ae_delinfo_aggR l_oRoutine_arrt_ae_delinfo_agg;
    l_oRoutine_arrt_ae_delinfo_agg = arrt_ae_delinfo_aggR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_delinfo_agg.w_NUMPROG = w_NUMPROG;
    l_oRoutine_arrt_ae_delinfo_agg.w_TIPOOPRAP = w_TIPOOPRAP;
    l_oRoutine_arrt_ae_delinfo_agg.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_delinfo_agg.Run();
  }
  void Calculation_KGBNFVNJHO() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "JAPOPEBO";
    l_oRoutine_arrt_writelog.pChiave = w_NUMPROG;
    l_oRoutine_arrt_writelog.Run();
    arrt_ae_agg_aetesta_ageR l_oRoutine_arrt_ae_agg_aetesta_age;
    l_oRoutine_arrt_ae_agg_aetesta_age = arrt_ae_agg_aetesta_ageR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta_age.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_TIPOOPRAP = w_TIPOOPRAP;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_NUMPROG = w_NUMPROG;
    l_oRoutine_arrt_ae_agg_aetesta_age.Run();
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "JAPOPEBO";
    l_oRoutine_arrt_writelog.pChiave = w_NUMPROG;
    l_oRoutine_arrt_writelog.Run();
    arrt_ae_agg_aetesta_ageR l_oRoutine_arrt_ae_agg_aetesta_age;
    l_oRoutine_arrt_ae_agg_aetesta_age = arrt_ae_agg_aetesta_ageR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta_age.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_TIPOOPRAP = w_TIPOOPRAP;
    l_oRoutine_arrt_ae_agg_aetesta_age.w_NUMPROG = w_NUMPROG;
    l_oRoutine_arrt_ae_agg_aetesta_age.Run();
  }
  void Calculation_WKUMXNRIRT() {
    w_DESCCIT = (CPLib.Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
    w_PROVINCIA = (CPLib.Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
    w_CODCAB = (CPLib.Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
  }
  protected void BlankStatusVariables() {
    m_bLoaded = false;
    m_bUpdated = false;
    m_cPreviousState = CPSecurity.UNKNOWN_STATE;
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"IDBASE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_ae_rapopebo","japopebo",m_KeyColumns,m_Ctx);
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
    op_codazi = m_Ctx.GetCompany();
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_filtro = "";
    w_dataoggi = CPLib.NullDate();
    w_tipreg = "";
    w_tipregn = 0;
    w_CDATOPE = "";
    w_sEdit = 0;
    w_CODINTER = "";
    w_CODDIPE = "";
    w_RAPPORTO = "";
    w_DATAOPE = CPLib.NullDate();
    w_DATAREG = CPLib.NullDate();
    w_TIPOOPRAP = "";
    w_CONNESOPER = "";
    w_TIPOLEG = "";
    w_IDBASE = "";
    w_TIPOINTER = "";
    w_TIPOINF = "";
    w_IDEREG = "";
    w_FLAGRAP = "";
    w_OPRAP = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_NUMPROG = "";
    w_xdescrap = "";
    w_xDescDipe = "";
    w_datpaseuro = CPLib.NullDate();
    w_xDesReg = "";
    w_xRagSoc = "";
    w_errmsg = "";
    w_Aggiorna = "";
    w_FLAGRAP2 = "";
    w_lancio = 0;
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_PRGIMPINF = 0;
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_IDEREG = "";
    w_OPERAZMOD = "";
    w_inutile = 0;
    w_prova = "";
    m_cWv_ardt_ae_intestbo = "";
    m_cWv_ardt_ae_delegabo = "";
    m_cWv_ardt_ae_soginfo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CDATOPE = CPLib.GetProperty(p,"CDATOPE",w_CDATOPE,0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_DATAOPE = CPLib.GetProperty(p,"DATAOPE",w_DATAOPE,0);
      w_DATAREG = CPLib.GetProperty(p,"DATAREG",w_DATAREG,0);
      w_TIPOOPRAP = CPLib.GetProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
      w_CONNESOPER = CPLib.GetProperty(p,"CONNESOPER",w_CONNESOPER,0);
      w_TIPOLEG = CPLib.GetProperty(p,"TIPOLEG",w_TIPOLEG,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      op_IDBASE = CPLib.GetProperty(p,"op_IDBASE","",0);
      w_TIPOINTER = CPLib.GetProperty(p,"TIPOINTER",w_TIPOINTER,0);
      w_TIPOINF = CPLib.GetProperty(p,"TIPOINF",w_TIPOINF,0);
      w_IDEREG = CPLib.GetProperty(p,"IDEREG",w_IDEREG,0);
      w_FLAGRAP = CPLib.GetProperty(p,"FLAGRAP",w_FLAGRAP,0);
      w_OPRAP = CPLib.GetProperty(p,"OPRAP",w_OPRAP,0);
      w_OPERATORE = CPLib.GetProperty(p,"OPERATORE",w_OPERATORE,0);
      w_AUTOM = CPLib.GetProperty(p,"AUTOM",w_AUTOM,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      op_NUMPROG = CPLib.GetProperty(p,"op_NUMPROG","",0);
      w_FLAGRAP2 = CPLib.GetProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_PRGIMPINF = CPLib.GetProperty(p,"PRGIMPINF",w_PRGIMPINF,0);
      op_PRGIMPINF = CPLib.GetProperty(p,"op_PRGIMPINF",0,0);
      w_OPERAZMOD = CPLib.GetProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_gSblocco = CPLib.GetProperty(p,"gSblocco",w_gSblocco,0);
      w_gFlgDTP = CPLib.GetProperty(p,"gFlgDTP",w_gFlgDTP,0);
      w_gChkDate = CPLib.GetProperty(p,"gChkDate",w_gChkDate,0);
      w_gStatus = CPLib.GetProperty(p,"gStatus",w_gStatus,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_filtro = CPLib.GetProperty(p,"filtro",w_filtro,0);
      w_dataoggi = CPLib.GetProperty(p,"dataoggi",w_dataoggi,0);
      w_tipreg = CPLib.GetProperty(p,"tipreg",w_tipreg,0);
      w_tipregn = CPLib.GetProperty(p,"tipregn",w_tipregn,0);
      w_sEdit = CPLib.GetProperty(p,"sEdit",w_sEdit,0);
      w_xdescrap = CPLib.GetProperty(p,"xdescrap",w_xdescrap,0);
      w_xDescDipe = CPLib.GetProperty(p,"xDescDipe",w_xDescDipe,0);
      w_datpaseuro = CPLib.GetProperty(p,"datpaseuro",w_datpaseuro,0);
      w_xDesReg = CPLib.GetProperty(p,"xDesReg",w_xDesReg,0);
      w_xRagSoc = CPLib.GetProperty(p,"xRagSoc",w_xRagSoc,0);
      w_errmsg = CPLib.GetProperty(p,"errmsg",w_errmsg,0);
      w_Aggiorna = CPLib.GetProperty(p,"Aggiorna",w_Aggiorna,0);
      w_lancio = CPLib.GetProperty(p,"lancio",w_lancio,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_CITINT = CPLib.GetProperty(p,"CITINT",w_CITINT,0);
      w_CITDIP = CPLib.GetProperty(p,"CITDIP",w_CITDIP,0);
      w_PROVDIP = CPLib.GetProperty(p,"PROVDIP",w_PROVDIP,0);
      w_CABDIP = CPLib.GetProperty(p,"CABDIP",w_CABDIP,0);
      w_PROVINT = CPLib.GetProperty(p,"PROVINT",w_PROVINT,0);
      w_CABINT = CPLib.GetProperty(p,"CABINT",w_CABINT,0);
      w_inutile = CPLib.GetProperty(p,"inutile",w_inutile,0);
      w_prova = CPLib.GetProperty(p,"prova",w_prova,0);
      m_cWv_ardt_ae_intestbo = CPLib.GetProperty(p,"m_cWv_ardt_ae_intestbo",m_cWv_ardt_ae_intestbo,0);
      m_cWv_ardt_ae_delegabo = CPLib.GetProperty(p,"m_cWv_ardt_ae_delegabo",m_cWv_ardt_ae_delegabo,0);
      m_cWv_ardt_ae_soginfo = CPLib.GetProperty(p,"m_cWv_ardt_ae_soginfo",m_cWv_ardt_ae_soginfo,0);
      CPLib.SetFromContextMNTs(p,m_MNTs);
      SPExtenderLib.SetExtendedFromContext(p,extendedFields);
      m_bLoaded = CPLib.GetProperty(p,"m_bLoaded",false,0);
      m_bUpdated = CPLib.GetProperty(p,"m_bUpdated",false,0);
      m_cOldCPCCCHK = CPLib.GetProperty(p,"m_cOldCPCCCHK","",0);
      m_cPreviousState = CPLib.GetProperty(p,"m_cPrvsStt","",0);
      m_cPassword = CPLib.GetProperty(p,"m_cPwd","",0);
      m_cOTP = CPLib.GetProperty(p,"m_cOTP","",0);
      m_lCtxLoaded = true;
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
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
    items = tables.get("jntestbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("jntestbo",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPPORTO"});
    map.put("rd_var",new String[]{"w_RAPPORTO"});
    map.put("wr_var",new String[]{"w_RAPPORTO"});
    map.put("wr_field",new String[]{"RAPPORTO"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("1",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{""});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("jntestbo\u0000false\u0000false\u00001\u00000\u0000ardt_ae_intestbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("jelegabo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("jelegabo",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPPORTO"});
    map.put("rd_var",new String[]{"w_RAPPORTO"});
    map.put("wr_var",new String[]{"w_RAPPORTO"});
    map.put("wr_field",new String[]{"RAPPORTO"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("1",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{""});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("jelegabo\u0000false\u0000false\u00001\u00000\u0000ardt_ae_delegabo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("joginfo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("joginfo",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPCOL"});
    map.put("rd_var",new String[]{"w_RAPPORTO"});
    map.put("wr_var",new String[]{"w_RAPPORTO"});
    map.put("wr_field",new String[]{"RAPCOL"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",new String[]{});
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",new String[]{});
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",new String[]{});
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",new String[]{});
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",new String[]{});
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",new String[]{});
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("joginfo\u0000false\u0000false\u00001\u00000\u0000ardt_ae_soginfo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("intermbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("intermbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","DATANASC","CODCAB","PROVINCIA","DESCCIT","TIPINTER"});
    map.put("rd_var",new String[]{"w_CODINTER","w_datpaseuro","w_CABINT","w_PROVINT","w_CITINT","w_TIPOINTER"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000D\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u00008\u00006\u00002\u000030\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Intermediario\u0000Data Passaggio EURO\u0000CAB\u0000Provincia\u0000Città\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("intermbo\u0000false\u0000false\u00001\u00000\u0000armt_intermbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ","DESCCIT","PROVINCIA","CAB"});
    map.put("rd_var",new String[]{"w_CODDIPE","w_xDescDipe","w_CITDIP","w_PROVDIP","w_CABDIP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030\u000030\u00002\u00006",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Dipendenza\u0000Descrizione\u0000Città\u0000Provincia\u0000CAB",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Dipendenze\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("jnarapbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("jnarapbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPPORTO","DESCRAP","FLAGLIRE","VALUTA","TIPORAP"});
    map.put("rd_var",new String[]{"w_RAPPORTO","w_xdescrap","w_FLAGLIRE","w_VALUTA","w_FLAGRAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("25\u000050\u00001\u00003\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000\u0000Codice Divisa\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("jnarapbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Rapporti in essere\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipreg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipreg",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DES1","TIPREG"});
    map.put("rd_var",new String[]{"w_TIPOOPRAP","w_xDesReg","w_tipreg"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000090\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Informazione\u0000Descrizione\u0000Operazione/Rapporto",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key5\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipreg\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Registrazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESOPER","w_xRagSoc"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Soggetto Operante Conto Terzi\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key6\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Persone / Società / Legali Rappresentanti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipleg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipleg",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TIPLEG"});
    map.put("rd_var",new String[]{"w_TIPOLEG"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("1",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Legame Sogg.",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipleg\u0000false\u0000false\u00001\u00000\u0000armt_tipileg\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_ae_rapopebo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_ae_rapopebo",child);
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
    // Prenota i progressivi
    InitAutonumber();
    op_codazi = m_Ctx.GetCompany();
    ardt_ae_intestbo = new ardt_ae_intestboBO(m_Ctx);
    ardt_ae_delegabo = new ardt_ae_delegaboBO(m_Ctx);
    ardt_ae_soginfo = new ardt_ae_soginfoBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_ae_rapopebo",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if ((CPLib.Empty(w_DATAOPE)) || ( ! (CPLib.ge(w_DATAREG,w_DATAOPE)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAOPE));
      String obblMsgError = m_Ctx.Translate("Data Operazione")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'informazione");
      } else {
        m_cLastMsgError = m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'informazione");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATAOPE = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAOPE";
      }
    } else if ((CPLib.ne(w_gChkDate,"U") && CPLib.ne(w_gChkDate,"B") && CPLib.eq(w_gFlgDTP,0)) && ((CPLib.Empty(w_DATAREG)) || ( ! (CPLib.ge(w_DATAREG,w_DATAOPE))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAREG));
      String obblMsgError = m_Ctx.Translate("Data registrazione")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'informazione");
      } else {
        m_cLastMsgError = m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'informazione");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATAREG = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAREG";
      }
    } else if (CPLib.Empty(w_TIPOOPRAP)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPOOPRAP));
      String obblMsgError = m_Ctx.Translate("Tipo Informazione")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPOOPRAP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPOOPRAP";
      }
    } else if ( ! (CPLib.Empty(w_CONNESOPER)) &&  ! (arfn_chksoggR.Make(m_Ctx,this).Run(w_CONNESOPER,"8"))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = m_Ctx.Translate("Soggetto Operante Conto Terzi")+" : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_CONNESOPER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CONNESOPER";
      }
    }
    if (l_bResult && (( ! (ardt_ae_intestbo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ae_intestbo)) || ( ! (ardt_ae_intestbo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ae_intestbo)))) {
      ardt_ae_intestbo.SetFromContext(m_cWv_ardt_ae_intestbo);
      m_cWv_ardt_ae_intestbo = "_not_empty_";
    }
    if (l_bResult && (ardt_ae_intestbo.m_bLoaded || ardt_ae_intestbo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ae_intestbo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ae_intestbo.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_ae_delegabo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ae_delegabo)) || ( ! (ardt_ae_delegabo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ae_delegabo)))) {
      ardt_ae_delegabo.SetFromContext(m_cWv_ardt_ae_delegabo);
      m_cWv_ardt_ae_delegabo = "_not_empty_";
    }
    if (l_bResult && (ardt_ae_delegabo.m_bLoaded || ardt_ae_delegabo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ae_delegabo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ae_delegabo.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_ae_soginfo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ae_soginfo)) || ( ! (ardt_ae_soginfo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ae_soginfo)))) {
      ardt_ae_soginfo.SetFromContext(m_cWv_ardt_ae_soginfo);
      m_cWv_ardt_ae_soginfo = "_not_empty_";
    }
    if (l_bResult && (ardt_ae_soginfo.m_bLoaded || ardt_ae_soginfo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ae_soginfo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ae_soginfo.m_cLastMsgError;
      }
    }
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
    } else if ( ! (l_bNoCheck)) {
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
      l_Keys = new String[]{"armt_ae_rapopebo","administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_ae_rapopebo\\"+p_cState,"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
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
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PRGINFAGE1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"PRGINFAGE2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PRGIMPINF = m_Ctx.AskTableProg(w_PRGIMPINF,15,op_PRGIMPINF,"PRGIMPINFAGE"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
    op_codazi = m_Ctx.GetCompany();
    op_IDBASE = w_IDBASE;
    op_NUMPROG = w_NUMPROG;
    op_PRGIMPINF = w_PRGIMPINF;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    boolean l_b1;
    l_b1 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    boolean l_b2;
    l_b2 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PRGINFAGE1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
      op_codazi = m_Ctx.GetCompany();
      op_IDBASE = w_IDBASE;
    }
    if (l_b1) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"PRGINFAGE2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
      op_NUMPROG = w_NUMPROG;
    }
    if (l_b2) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PRGIMPINF = m_Ctx.AskTableProg(w_PRGIMPINF,15,op_PRGIMPINF,"PRGIMPINFAGE"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_japopebo);
      op_PRGIMPINF = w_PRGIMPINF;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_IDBASE = "";
    op_NUMPROG = "";
    op_PRGIMPINF = 0;
    // Inizializzazione delle variabili per DependsOn
    o_filtro = "";
    o_CDATOPE = "";
    o_CODINTER = "";
    o_CODDIPE = "";
    o_RAPPORTO = "";
    o_DATAOPE = CPLib.NullDate();
    o_TIPOOPRAP = "";
    o_FLAGRAP = "";
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
    CPLib.PutProperty(p,"CDATOPE",w_CDATOPE,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"DATAOPE",w_DATAOPE,0);
    CPLib.PutProperty(p,"DATAREG",w_DATAREG,0);
    CPLib.PutProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
    CPLib.PutProperty(p,"CONNESOPER",w_CONNESOPER,0);
    CPLib.PutProperty(p,"TIPOLEG",w_TIPOLEG,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"op_IDBASE",op_IDBASE,0);
    CPLib.PutProperty(p,"TIPOINTER",w_TIPOINTER,0);
    CPLib.PutProperty(p,"TIPOINF",w_TIPOINF,0);
    CPLib.PutProperty(p,"IDEREG",w_IDEREG,0);
    CPLib.PutProperty(p,"FLAGRAP",w_FLAGRAP,0);
    CPLib.PutProperty(p,"OPRAP",w_OPRAP,0);
    CPLib.PutProperty(p,"OPERATORE",w_OPERATORE,0);
    CPLib.PutProperty(p,"AUTOM",w_AUTOM,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"op_NUMPROG",op_NUMPROG,0);
    CPLib.PutProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"PRGIMPINF",w_PRGIMPINF,0);
    CPLib.PutProperty(p,"op_PRGIMPINF",op_PRGIMPINF,0);
    CPLib.PutProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"gSblocco",w_gSblocco,0);
    CPLib.PutProperty(p,"gFlgDTP",w_gFlgDTP,0);
    CPLib.PutProperty(p,"gChkDate",w_gChkDate,0);
    CPLib.PutProperty(p,"gStatus",w_gStatus,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"filtro",w_filtro,0);
    CPLib.PutProperty(p,"dataoggi",w_dataoggi,0);
    CPLib.PutProperty(p,"tipreg",w_tipreg,0);
    CPLib.PutProperty(p,"tipregn",w_tipregn,0);
    CPLib.PutProperty(p,"sEdit",w_sEdit,0);
    CPLib.PutProperty(p,"xdescrap",w_xdescrap,0);
    CPLib.PutProperty(p,"xDescDipe",w_xDescDipe,0);
    CPLib.PutProperty(p,"datpaseuro",w_datpaseuro,0);
    CPLib.PutProperty(p,"xDesReg",w_xDesReg,0);
    CPLib.PutProperty(p,"xRagSoc",w_xRagSoc,0);
    CPLib.PutProperty(p,"errmsg",w_errmsg,0);
    CPLib.PutProperty(p,"Aggiorna",w_Aggiorna,0);
    CPLib.PutProperty(p,"lancio",w_lancio,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"CITINT",w_CITINT,0);
    CPLib.PutProperty(p,"CITDIP",w_CITDIP,0);
    CPLib.PutProperty(p,"PROVDIP",w_PROVDIP,0);
    CPLib.PutProperty(p,"CABDIP",w_CABDIP,0);
    CPLib.PutProperty(p,"PROVINT",w_PROVINT,0);
    CPLib.PutProperty(p,"CABINT",w_CABINT,0);
    CPLib.PutProperty(p,"inutile",w_inutile,0);
    CPLib.PutProperty(p,"prova",w_prova,0);
    if (p_bGetChildren) {
      if (ardt_ae_intestbo.IsUpdated()) {
        m_cWv_ardt_ae_intestbo = ardt_ae_intestbo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_intestbo",m_cWv_ardt_ae_intestbo,0);
    }
    if (p_bGetChildren) {
      if (ardt_ae_delegabo.IsUpdated()) {
        m_cWv_ardt_ae_delegabo = ardt_ae_delegabo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_delegabo",m_cWv_ardt_ae_delegabo,0);
    }
    if (p_bGetChildren) {
      if (ardt_ae_soginfo.IsUpdated()) {
        m_cWv_ardt_ae_soginfo = ardt_ae_soginfo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_soginfo",m_cWv_ardt_ae_soginfo,0);
    }
    if (p_bGetChildren) {
      CPLib.PutProperty(p,m_MNTs);
    }
    SPExtenderLib.PutExtendedProperies(p,extendedFields);
    CPLib.PutProperty(p,"m_bLoaded",m_bLoaded);
    CPLib.PutProperty(p,"m_bUpdated",m_bUpdated);
    CPLib.PutProperty(p,"m_cOldCPCCCHK",m_cOldCPCCCHK);
    CPLib.PutProperty(p,"m_cPrvsStt",m_cPreviousState);
  }
  public String i_PrimaryKey() {
    return PrimaryKey(this);
  }
  public static String PrimaryKey(Caller p_Caller) {
    return "japopebo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_IDBASE");
    oneAutoNum.add("PRGINFAGE1");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_NUMPROG");
    oneAutoNum.add("PRGINFAGE2");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PRGIMPINF");
    oneAutoNum.add("PRGIMPINFAGE");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_ae_intestbo() {
    if (ardt_ae_intestbo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ae_intestbo) || CPLib.IsLoaded(m_cWv_ardt_ae_intestbo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ae_intestbo.m_bLoaded)) {
      ardt_ae_intestbo.Blank();
      ardt_ae_intestbo.w_RAPPORTO = w_RAPPORTO;
      ardt_ae_intestbo.Load();
    }
    return ardt_ae_intestbo.m_bLoaded;
  }
  public void CtxLoad_ardt_ae_intestbo() {
    if ( ! (ardt_ae_intestbo.m_lCtxLoaded)) {
      ardt_ae_intestbo.Blank();
    }
    ardt_ae_intestbo.m_lCtxLoaded = true;
    if ( ! (ardt_ae_intestbo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ae_intestbo) || CPLib.IsLoaded(m_cWv_ardt_ae_intestbo)) {
        ardt_ae_intestbo.SetFromContext(m_cWv_ardt_ae_intestbo);
        m_cWv_ardt_ae_intestbo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ae_intestbo.m_bLoaded)) {
          ardt_ae_intestbo.Blank();
          ardt_ae_intestbo.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_intestbo.Load();
          if ( ! (ardt_ae_intestbo.m_bLoaded)) {
            ardt_ae_intestbo.Initialize();
            ardt_ae_intestbo.SetUpdated();
          }
          CopyWorkVar(this,ardt_ae_intestbo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,ardt_ae_intestbo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},true);
        }
      }
    }
  }
  public boolean ChildExists_ardt_ae_delegabo() {
    if (ardt_ae_delegabo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ae_delegabo) || CPLib.IsLoaded(m_cWv_ardt_ae_delegabo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ae_delegabo.m_bLoaded)) {
      ardt_ae_delegabo.Blank();
      ardt_ae_delegabo.w_RAPPORTO = w_RAPPORTO;
      ardt_ae_delegabo.Load();
    }
    return ardt_ae_delegabo.m_bLoaded;
  }
  public void CtxLoad_ardt_ae_delegabo() {
    if ( ! (ardt_ae_delegabo.m_lCtxLoaded)) {
      ardt_ae_delegabo.Blank();
    }
    ardt_ae_delegabo.m_lCtxLoaded = true;
    if ( ! (ardt_ae_delegabo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ae_delegabo) || CPLib.IsLoaded(m_cWv_ardt_ae_delegabo)) {
        ardt_ae_delegabo.SetFromContext(m_cWv_ardt_ae_delegabo);
        m_cWv_ardt_ae_delegabo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ae_delegabo.m_bLoaded)) {
          ardt_ae_delegabo.Blank();
          ardt_ae_delegabo.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_delegabo.Load();
          if ( ! (ardt_ae_delegabo.m_bLoaded)) {
            ardt_ae_delegabo.Initialize();
            ardt_ae_delegabo.SetUpdated();
          }
          CopyWorkVar(this,ardt_ae_delegabo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,ardt_ae_delegabo,new String[]{"TIPORAP"},new String[]{"FLAGRAP"},true);
        }
      }
    }
  }
  public boolean ChildExists_ardt_ae_soginfo() {
    if (ardt_ae_soginfo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ae_soginfo) || CPLib.IsLoaded(m_cWv_ardt_ae_soginfo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ae_soginfo.m_bLoaded)) {
      ardt_ae_soginfo.Blank();
      ardt_ae_soginfo.w_RAPCOL = w_RAPPORTO;
      ardt_ae_soginfo.Load();
    }
    return ardt_ae_soginfo.m_bLoaded;
  }
  public void CtxLoad_ardt_ae_soginfo() {
    if ( ! (ardt_ae_soginfo.m_lCtxLoaded)) {
      ardt_ae_soginfo.Blank();
    }
    ardt_ae_soginfo.m_lCtxLoaded = true;
    if ( ! (ardt_ae_soginfo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ae_soginfo) || CPLib.IsLoaded(m_cWv_ardt_ae_soginfo)) {
        ardt_ae_soginfo.SetFromContext(m_cWv_ardt_ae_soginfo);
        m_cWv_ardt_ae_soginfo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ae_soginfo.m_bLoaded)) {
          ardt_ae_soginfo.Blank();
          ardt_ae_soginfo.w_RAPCOL = w_RAPPORTO;
          ardt_ae_soginfo.Load();
          if ( ! (ardt_ae_soginfo.m_bLoaded)) {
            ardt_ae_soginfo.Initialize();
            ardt_ae_soginfo.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_ae_intestbo")) {
      CtxLoad_ardt_ae_intestbo();
      return ardt_ae_intestbo;
    }
    if (CPLib.eq(p_cName,"ardt_ae_delegabo")) {
      CtxLoad_ardt_ae_delegabo();
      return ardt_ae_delegabo;
    }
    if (CPLib.eq(p_cName,"ardt_ae_soginfo")) {
      CtxLoad_ardt_ae_soginfo();
      return ardt_ae_soginfo;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
