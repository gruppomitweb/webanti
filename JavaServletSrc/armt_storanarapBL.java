import java.util.*;

public class armt_storanarapBL extends armt_storanarapWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_storanarap";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wnarapbo;
  public String m_cServer_wnarapbo;
  public CPPhTableWrInfo m_oWrInfo_wnarapbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wnarapbo;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public CPPhTableWrInfo m_oWrInfo_tbtipnat;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog;
  public String m_cPhName_tbsvolgim;
  public String m_cServer_tbsvolgim;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim;
  public String m_cPhName_tbplauso;
  public String m_cServer_tbplauso;
  public CPPhTableWrInfo m_oWrInfo_tbplauso;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc;
  public String m_cPhName_tbdurata;
  public String m_cServer_tbdurata;
  public CPPhTableWrInfo m_oWrInfo_tbdurata;
  public String m_cPhName_tbimporto;
  public String m_cServer_tbimporto;
  public CPPhTableWrInfo m_oWrInfo_tbimporto;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wnarapbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'NOPROT':NOPROT,'NATURA':NATURA,'SCOPO':SCOPO,'AREAGEO':AREAGEO,'MODSVOL':MODSVOL,'RAGIO':RAGIO,'TIPO':TIPO,'RFREQ':RFREQ,'RIMP':RIMP,'RAREA':RAREA,'RCOMP':RCOMP,'RRAGIO':RRAGIO,'RTIPO':RTIPO,'DURAT':DURAT,'AMMONT':AMMONT,'ardt_delegabo':ardt_delegabo,'SPLITCODE':SPLITCODE,'MACODICE':MACODICE"+FoundlingChildrenList("armt_storanarap",true)+"}";
  public static final String i_CompleteStateStructure = "{'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'descval':descval,'daticoll':daticoll,'NOPROT':NOPROT,'NATURA':NATURA,'SCOPO':SCOPO,'AREAGEO':AREAGEO,'MODSVOL':MODSVOL,'RAGIO':RAGIO,'TIPO':TIPO,'RFREQ':RFREQ,'RIMP':RIMP,'RAREA':RAREA,'RCOMP':RCOMP,'RRAGIO':RRAGIO,'RTIPO':RTIPO,'xdescmodsvo':xdescmodsvo,'xdescareag':xdescareag,'xdescplauso':xdescplauso,'xdesctipor':xdesctipor,'PRGIMPRAP':PRGIMPRAP,'DURAT':DURAT,'AMMONT':AMMONT,'xdescfreq':xdescfreq,'xdescammo':xdescammo,'gTelepass':gTelepass,'gBrowser':gBrowser,'CODDIP':CODDIP,'gCodDip':gCodDip,'mess':mess,'ardt_delegabo':ardt_delegabo,'SPLITCODE':SPLITCODE,'MACODICE':MACODICE,'xMADESCRI':xMADESCRI"+FoundlingChildrenList("armt_storanarap",true)+"}";
  public static final String i_ItemSequence = "RAPPORTO,DESCRAP,TIPORAP,TIPOAG,FLAGLIRE,VALUTA,NOPROT,NATURA,SCOPO,AREAGEO,MODSVOL,RAGIO,TIPO,RFREQ,RIMP,RAREA,RCOMP,RRAGIO,RTIPO,DURAT,AMMONT,ardt_delegabo,SPLITCODE,MACODICE"+FoundlingChildrenList("armt_storanarap",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_storanarap"),new String[][]{new String[]{"RAPPORTO","Codice Rapporto","C","25","0","campo","key1","false","false"},new String[]{"DESCRAP","Descrizione","C","50","0","campo","key2","false","false"},new String[]{"TIPORAP","Tipo Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"TIPOAG","","C","2","0","campo","nokey","false","false"},new String[]{"FLAGLIRE","Divisa","C","1","0","campo","nokey","false","false"},new String[]{"VALUTA","Codice Divisa","C","3","0","campo","nokey","false","false"},new String[]{"NOPROT","Non inviare agenzia entrate","N","1","0","campo","nokey","false","false"},new String[]{"NATURA","","C","50","0","campo","nokey","false","false"},new String[]{"SCOPO","","C","50","0","campo","nokey","false","false"},new String[]{"AREAGEO","","C","5","0","campo","nokey","false","false"},new String[]{"MODSVOL","","C","5","0","campo","nokey","false","false"},new String[]{"RAGIO","","C","5","0","campo","nokey","false","false"},new String[]{"TIPO","","C","3","0","campo","nokey","false","false"},new String[]{"RFREQ","","N","3","0","campo","nokey","false","false"},new String[]{"RIMP","","N","3","0","campo","nokey","false","false"},new String[]{"RAREA","","N","3","0","campo","nokey","false","false"},new String[]{"RCOMP","","N","3","0","campo","nokey","false","false"},new String[]{"RRAGIO","","N","3","0","campo","nokey","false","false"},new String[]{"RTIPO","","N","3","0","campo","nokey","false","false"},new String[]{"DURAT","","C","5","0","campo","nokey","false","false"},new String[]{"AMMONT","","C","5","0","campo","nokey","false","false"},new String[]{"ardt_delegabo","LinkPC","","","","link_PC","","false",""},new String[]{"SPLITCODE","Customer ID (WUBS)","C","15","0","campo","nokey","false","true"},new String[]{"MACODICE","Macro Agente","C","5","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_storanarapBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wnarapbo = p_ContextObject.GetPhName("wnarapbo",p_ContextObject.GetCompany(),false);
    m_cServer_wnarapbo = p_ContextObject.GetServer("wnarapbo");
    m_oWrInfo_wnarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wnarapbo",p_ContextObject.GetCompany());
    m_cVirtName_wnarapbo = CPSql.ManipulateTablePhName("wnarapbo",m_cServer_wnarapbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_oWrInfo_tbtipnat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipnat",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_oWrInfo_tbareegeog = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim = p_ContextObject.GetPhName("tbsvolgim");
    m_cServer_tbsvolgim = p_ContextObject.GetServer("tbsvolgim");
    m_oWrInfo_tbsvolgim = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim",p_ContextObject.GetCompany());
    m_cPhName_tbplauso = p_ContextObject.GetPhName("tbplauso");
    m_cServer_tbplauso = p_ContextObject.GetServer("tbplauso");
    m_oWrInfo_tbplauso = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_oWrInfo_tbtiporisc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc",p_ContextObject.GetCompany());
    m_cPhName_tbdurata = p_ContextObject.GetPhName("tbdurata");
    m_cServer_tbdurata = p_ContextObject.GetServer("tbdurata");
    m_oWrInfo_tbdurata = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata",p_ContextObject.GetCompany());
    m_cPhName_tbimporto = p_ContextObject.GetPhName("tbimporto");
    m_cServer_tbimporto = p_ContextObject.GetServer("tbimporto");
    m_oWrInfo_tbimporto = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_delegabo = new ardt_delegaboBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_storanarap",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_descval = "";
    w_daticoll = 0;
    w_NATURA = "";
    w_SCOPO = "";
    w_AREAGEO = "";
    w_MODSVOL = "";
    w_RAGIO = "";
    w_TIPO = "";
    w_RFREQ = 0;
    w_RIMP = 0;
    w_RAREA = 0;
    w_RCOMP = 0;
    w_RRAGIO = 0;
    w_RTIPO = 0;
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_PRGIMPRAP = 0;
    w_DURAT = "";
    w_AMMONT = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_CODDIP = "";
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_SPLITCODE = "";
    w_MACODICE = "";
    w_xMADESCRI = "";
    Link_RUMXLFCOKA();
    w_NOPROT = 0;
    Link_QJSTZIPOQB();
    Link_SFFFOYOWNH();
    Link_NOBMPHKVTX();
    Link_DJOWYRMDDC();
    Link_CKJQULDXKW();
    Link_SXTYCPHBIM();
    w_mess = "";
    w_mess = "Messaggio\\nSecondo\\nTerzo";
    Link_SSYXHQXJLD();
    m_cWv_ardt_delegabo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_delegabo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_delegabo);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_FLAGLIRE = w_FLAGLIRE;
    o_VALUTA = w_VALUTA;
    ardt_delegabo.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete start")) {
      Calculation_XEYBWIHFFE();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_GUQDVKITTU();
      Calculation_IXFNYZEOIT();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_RUMXLFCOKA() {
    return Link_RUMXLFCOKA("Full");
  }
  protected boolean Link_RUMXLFCOKA(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_VALUTA))) {
      String l_OldValue = w_VALUTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VALUTA,"C",3,0),m_cServer_tbvalute,w_VALUTA);
      if (m_Ctx.IsSharedTemp("tbvalute")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbvalute,"select CODVAL,DESCRI from "+m_cPhName_tbvalute+((m_cPhName_tbvalute).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODVAL"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VALUTA,"C",30,0),m_cServer_tbvalute,w_VALUTA);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbvalute,"select CODVAL,DESCRI from "+m_cPhName_tbvalute+((m_cPhName_tbvalute).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_VALUTA = l_rsLink.GetString("CODVAL");
          w_descval = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RUMXLFCOKA_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_VALUTA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","VALUTA");
          }
          m_cLastWorkVarError = "VALUTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RUMXLFCOKA_blank();
    }
    return l_bResult;
  }
  void Link_RUMXLFCOKA_blank() {
    w_VALUTA = "";
    w_descval = "";
  }
  protected boolean Link_QJSTZIPOQB() {
    return Link_QJSTZIPOQB("Full");
  }
  protected boolean Link_QJSTZIPOQB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AREAGEO))) {
      String l_OldValue = w_AREAGEO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",5,0),m_cServer_tbareegeog,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",50,0),m_cServer_tbareegeog,w_AREAGEO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_xdescareag = l_rsLink.GetString("DESCRI");
          w_RAREA = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QJSTZIPOQB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AREAGEO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AREAGEO");
          }
          m_cLastWorkVarError = "AREAGEO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QJSTZIPOQB_blank();
    }
    return l_bResult;
  }
  void Link_QJSTZIPOQB_blank() {
    w_AREAGEO = "";
    w_xdescareag = "";
    w_RAREA = 0;
  }
  protected boolean Link_SFFFOYOWNH() {
    return Link_SFFFOYOWNH("Full");
  }
  protected boolean Link_SFFFOYOWNH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MODSVOL))) {
      String l_OldValue = w_MODSVOL;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",5,0),m_cServer_tbsvolgim,w_MODSVOL);
      if (m_Ctx.IsSharedTemp("tbsvolgim")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",200,0),m_cServer_tbsvolgim,w_MODSVOL);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MODSVOL = l_rsLink.GetString("CODICE");
          w_xdescmodsvo = l_rsLink.GetString("DESCRI");
          w_RCOMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SFFFOYOWNH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MODSVOL = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MODSVOL");
          }
          m_cLastWorkVarError = "MODSVOL";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SFFFOYOWNH_blank();
    }
    return l_bResult;
  }
  void Link_SFFFOYOWNH_blank() {
    w_MODSVOL = "";
    w_xdescmodsvo = "";
    w_RCOMP = 0;
  }
  protected boolean Link_NOBMPHKVTX() {
    return Link_NOBMPHKVTX("Full");
  }
  protected boolean Link_NOBMPHKVTX(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAGIO))) {
      String l_OldValue = w_RAGIO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",5,0),m_cServer_tbplauso,w_RAGIO);
      if (m_Ctx.IsSharedTemp("tbplauso")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",200,0),m_cServer_tbplauso,w_RAGIO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAGIO = l_rsLink.GetString("CODICE");
          w_xdescplauso = l_rsLink.GetString("DESCRI");
          w_RRAGIO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NOBMPHKVTX_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAGIO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAGIO");
          }
          m_cLastWorkVarError = "RAGIO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NOBMPHKVTX_blank();
    }
    return l_bResult;
  }
  void Link_NOBMPHKVTX_blank() {
    w_RAGIO = "";
    w_xdescplauso = "";
    w_RRAGIO = 0;
  }
  protected boolean Link_DJOWYRMDDC() {
    return Link_DJOWYRMDDC("Full");
  }
  protected boolean Link_DJOWYRMDDC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPO))) {
      String l_OldValue = w_TIPO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",3,0),m_cServer_tbtiporisc,w_TIPO);
      if (m_Ctx.IsSharedTemp("tbtiporisc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",100,0),m_cServer_tbtiporisc,w_TIPO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPO = l_rsLink.GetString("CODICE");
          w_xdesctipor = l_rsLink.GetString("DESCRI");
          w_RTIPO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DJOWYRMDDC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPO");
          }
          m_cLastWorkVarError = "TIPO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DJOWYRMDDC_blank();
    }
    return l_bResult;
  }
  void Link_DJOWYRMDDC_blank() {
    w_TIPO = "";
    w_xdesctipor = "";
    w_RTIPO = 0;
  }
  protected boolean Link_CKJQULDXKW() {
    return Link_CKJQULDXKW("Full");
  }
  protected boolean Link_CKJQULDXKW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DURAT))) {
      String l_OldValue = w_DURAT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",5,0),m_cServer_tbdurata,w_DURAT);
      if (m_Ctx.IsSharedTemp("tbdurata")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",200,0),m_cServer_tbdurata,w_DURAT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DURAT = l_rsLink.GetString("CODICE");
          w_xdescfreq = l_rsLink.GetString("DESCRI");
          w_RFREQ = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CKJQULDXKW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_DURAT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DURAT");
          }
          m_cLastWorkVarError = "DURAT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CKJQULDXKW_blank();
    }
    return l_bResult;
  }
  void Link_CKJQULDXKW_blank() {
    w_DURAT = "";
    w_xdescfreq = "";
    w_RFREQ = 0;
  }
  protected boolean Link_SXTYCPHBIM() {
    return Link_SXTYCPHBIM("Full");
  }
  protected boolean Link_SXTYCPHBIM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AMMONT))) {
      String l_OldValue = w_AMMONT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",5,0),m_cServer_tbimporto,w_AMMONT);
      if (m_Ctx.IsSharedTemp("tbimporto")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",200,0),m_cServer_tbimporto,w_AMMONT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AMMONT = l_rsLink.GetString("CODICE");
          w_xdescammo = l_rsLink.GetString("DESCRI");
          w_RIMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SXTYCPHBIM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AMMONT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AMMONT");
          }
          m_cLastWorkVarError = "AMMONT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SXTYCPHBIM_blank();
    }
    return l_bResult;
  }
  void Link_SXTYCPHBIM_blank() {
    w_AMMONT = "";
    w_xdescammo = "";
    w_RIMP = 0;
  }
  protected boolean Link_SSYXHQXJLD() {
    return Link_SSYXHQXJLD("Full");
  }
  protected boolean Link_SSYXHQXJLD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MACODICE))) {
      String l_OldValue = w_MACODICE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",5,0),m_cServer_tbmacage,w_MACODICE);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",60,0),m_cServer_tbmacage,w_MACODICE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MADESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MACODICE = l_rsLink.GetString("MACODICE");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SSYXHQXJLD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MACODICE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MACODICE");
          }
          m_cLastWorkVarError = "MACODICE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SSYXHQXJLD_blank();
    }
    return l_bResult;
  }
  void Link_SSYXHQXJLD_blank() {
    w_MACODICE = "";
    w_xMADESCRI = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCRAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPORAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPORAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLAGLIRE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGLIRE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VALUTA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VALUTA = p_workVariableValue;
    l_bResult = Link_RUMXLFCOKA();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VALUTA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOPROT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOPROT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NATURA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NATURA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SCOPO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SCOPO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AREAGEO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AREAGEO = p_workVariableValue;
    l_bResult = Link_QJSTZIPOQB();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MODSVOL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MODSVOL = p_workVariableValue;
    l_bResult = Link_SFFFOYOWNH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MODSVOL = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAGIO = p_workVariableValue;
    l_bResult = Link_NOBMPHKVTX();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAGIO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPO = p_workVariableValue;
    l_bResult = Link_DJOWYRMDDC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RFREQ(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RFREQ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RIMP(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RIMP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAREA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAREA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RCOMP(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RCOMP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RRAGIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RRAGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RTIPO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RTIPO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DURAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DURAT = p_workVariableValue;
    l_bResult = Link_CKJQULDXKW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DURAT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AMMONT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AMMONT = p_workVariableValue;
    l_bResult = Link_SXTYCPHBIM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AMMONT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SPLITCODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SPLITCODE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SPLITCODE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean YSBAKLZECK_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_gTelepass,"6");
  }
  public boolean Set_MACODICE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACODICE = p_workVariableValue;
    l_bResult = Link_SSYXHQXJLD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MACODICE = "";
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
  public boolean getVisible_SPLITCODE() {
    return CPLib.ne(w_gTelepass,"6");
  }
  public boolean getVisible_MACODICE() {
    return CPLib.ne(w_gTelepass,"5");
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
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE)) {
      Calculation_LMOPUUAIMR();
    }
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE) || CPLib.ne(o_VALUTA,w_VALUTA)) {
      l_bTmpRes = Link_RUMXLFCOKA();
    }
    w_mess = "Messaggio\\nSecondo\\nTerzo";
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_LMOPUUAIMR() {
    w_VALUTA = (CPLib.eq(w_FLAGLIRE,"L")?"018":(CPLib.eq(w_FLAGLIRE,"E")?"242":""));
  }
  void Calculation_XEYBWIHFFE() {
    arrt_numopecollR l_oRoutine_arrt_numopecoll;
    l_oRoutine_arrt_numopecoll = arrt_numopecollR.Make(m_Ctx,this);
    l_oRoutine_arrt_numopecoll.pTipo = "D";
    l_oRoutine_arrt_numopecoll.Run();
  }
  void Calculation_GUQDVKITTU() {
    w_CODDIP = w_gCodDip;
  }
  void Calculation_IXFNYZEOIT() {
    arfn_chkrapportoR l_oRoutine_arfn_chkrapporto;
    l_oRoutine_arfn_chkrapporto = arfn_chkrapportoR.Make(m_Ctx,this);
    l_oRoutine_arfn_chkrapporto.pRapporto = w_RAPPORTO;
    l_oRoutine_arfn_chkrapporto.Run();
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
  public final static String[] m_KeyColumns = {"RAPPORTO"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_storanarap","wnarapbo",m_KeyColumns,m_Ctx);
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
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_descval = "";
    w_daticoll = 0;
    w_NOPROT = 0;
    w_NATURA = "";
    w_SCOPO = "";
    w_AREAGEO = "";
    w_MODSVOL = "";
    w_RAGIO = "";
    w_TIPO = "";
    w_RFREQ = 0;
    w_RIMP = 0;
    w_RAREA = 0;
    w_RCOMP = 0;
    w_RRAGIO = 0;
    w_RTIPO = 0;
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_PRGIMPRAP = 0;
    w_DURAT = "";
    w_AMMONT = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_CODDIP = "";
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_mess = "";
    w_SPLITCODE = "";
    w_MACODICE = "";
    w_xMADESCRI = "";
    m_cWv_ardt_delegabo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_DESCRAP = CPLib.GetProperty(p,"DESCRAP",w_DESCRAP,0);
      w_TIPORAP = CPLib.GetProperty(p,"TIPORAP",w_TIPORAP,0);
      w_TIPOAG = CPLib.GetProperty(p,"TIPOAG",w_TIPOAG,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_NOPROT = CPLib.GetProperty(p,"NOPROT",w_NOPROT,0);
      w_NATURA = CPLib.GetProperty(p,"NATURA",w_NATURA,0);
      w_SCOPO = CPLib.GetProperty(p,"SCOPO",w_SCOPO,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_MODSVOL = CPLib.GetProperty(p,"MODSVOL",w_MODSVOL,0);
      w_RAGIO = CPLib.GetProperty(p,"RAGIO",w_RAGIO,0);
      w_TIPO = CPLib.GetProperty(p,"TIPO",w_TIPO,0);
      w_RFREQ = CPLib.GetProperty(p,"RFREQ",w_RFREQ,0);
      w_RIMP = CPLib.GetProperty(p,"RIMP",w_RIMP,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_RRAGIO = CPLib.GetProperty(p,"RRAGIO",w_RRAGIO,0);
      w_RTIPO = CPLib.GetProperty(p,"RTIPO",w_RTIPO,0);
      w_PRGIMPRAP = CPLib.GetProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
      op_PRGIMPRAP = CPLib.GetProperty(p,"op_PRGIMPRAP",0,0);
      w_DURAT = CPLib.GetProperty(p,"DURAT",w_DURAT,0);
      w_AMMONT = CPLib.GetProperty(p,"AMMONT",w_AMMONT,0);
      w_SPLITCODE = CPLib.GetProperty(p,"SPLITCODE",w_SPLITCODE,0);
      w_MACODICE = CPLib.GetProperty(p,"MACODICE",w_MACODICE,0);
      w_CODDIP = CPLib.GetProperty(p,"CODDIP",w_CODDIP,0);
      w_descval = CPLib.GetProperty(p,"descval",w_descval,0);
      w_daticoll = CPLib.GetProperty(p,"daticoll",w_daticoll,0);
      w_xdescmodsvo = CPLib.GetProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescplauso = CPLib.GetProperty(p,"xdescplauso",w_xdescplauso,0);
      w_xdesctipor = CPLib.GetProperty(p,"xdesctipor",w_xdesctipor,0);
      w_xdescfreq = CPLib.GetProperty(p,"xdescfreq",w_xdescfreq,0);
      w_xdescammo = CPLib.GetProperty(p,"xdescammo",w_xdescammo,0);
      w_gTelepass = CPLib.GetProperty(p,"gTelepass",w_gTelepass,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_mess = CPLib.GetProperty(p,"mess",w_mess,0);
      w_gBrowser = CPLib.GetProperty(p,"gBrowser",w_gBrowser,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      m_cWv_ardt_delegabo = CPLib.GetProperty(p,"m_cWv_ardt_delegabo",m_cWv_ardt_delegabo,0);
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
    items = tables.get("delegabo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("delegabo",items);
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
    map.put("property.value",zeroSplit.split("delegabo\u0000false\u0000false\u00001\u00000\u0000ardt_delegabo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbvalute");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbvalute",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODVAL","DESCRI"});
    map.put("rd_var",new String[]{"w_VALUTA","w_descval"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Divisa\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbvalute\u0000false\u0000false\u00002\u00000\u0000armt_divise\u0000false\u0000false\u0000Valute\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbareegeog");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbareegeog",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_AREAGEO","w_xdescareag","w_RAREA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000050\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbareegeog\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Area Geografica\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbsvolgim");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbsvolgim",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_MODSVOL","w_xdescmodsvo","w_RCOMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsvolgim\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Modalità Svolgimento\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbplauso");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbplauso",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_RAGIO","w_xdescplauso","w_RRAGIO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbplauso\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Ragionevolezza Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtiporisc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtiporisc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_TIPO","w_xdesctipor","w_RTIPO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u0000100\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtiporisc\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipologia Rischio\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbdurata");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbdurata",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_DURAT","w_xdescfreq","w_RFREQ"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbdurata\u0000false\u0000false\u00002\u00000\u0000ammt_tbdurata\u0000false\u0000false\u0000Frequenza Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbimporto");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbimporto",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_AMMONT","w_xdescammo","w_RIMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbimporto\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Ammontare Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbmacage");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbmacage",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"MACODICE","MADESCRI"});
    map.put("rd_var",new String[]{"w_MACODICE","w_xMADESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Macro Agente\u0000Denominazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Marco Agenti\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_storanarap",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_storanarap",child);
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
    ardt_delegabo = new ardt_delegaboBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_storanarap",m_Ctx);
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
    if (CPLib.Empty(w_SPLITCODE) && YSBAKLZECK_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SPLITCODE));
      String obblMsgError = m_Ctx.Translate("Customer ID (WUBS)")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SPLITCODE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SPLITCODE";
      }
    }
    if (l_bResult && (( ! (ardt_delegabo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_delegabo)) || ( ! (ardt_delegabo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_delegabo)))) {
      ardt_delegabo.SetFromContext(m_cWv_ardt_delegabo);
      m_cWv_ardt_delegabo = "_not_empty_";
    }
    if (l_bResult && (ardt_delegabo.m_bLoaded || ardt_delegabo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_delegabo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_delegabo.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_storanarap"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_storanarap\\"+p_cState};
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
    l_bResult = CPLib.ne(p_cState,GetCurrentState()) || (false);
    if ( ! (l_bResult)) {
      m_cLastMsgError = "MSG_CANNOT_EDIT_DATA";
    }
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = false;
    if ( ! (l_bResult)) {
      m_cLastMsgError = "MSG_CANNOT_DEL_DATA";
    }
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  public boolean CanAdd() {
    return CanAdd(GetCurrentState());
  }
  public boolean CanAdd(String p_cState) {
    boolean l_bResult = true;
    ResetErrorMessage();
    l_bResult = false;
    if ( ! (l_bResult)) {
      m_cLastMsgError = "MSG_CANNOT_ADD_DATA";
    }
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wnarapbo);
    op_codazi = m_Ctx.GetCompany();
    op_PRGIMPRAP = w_PRGIMPRAP;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wnarapbo);
      op_codazi = m_Ctx.GetCompany();
      op_PRGIMPRAP = w_PRGIMPRAP;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PRGIMPRAP = 0;
    // Inizializzazione delle variabili per DependsOn
    o_FLAGLIRE = "";
    o_VALUTA = "";
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
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"DESCRAP",w_DESCRAP,0);
    CPLib.PutProperty(p,"TIPORAP",w_TIPORAP,0);
    CPLib.PutProperty(p,"TIPOAG",w_TIPOAG,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"NOPROT",w_NOPROT,0);
    CPLib.PutProperty(p,"NATURA",w_NATURA,0);
    CPLib.PutProperty(p,"SCOPO",w_SCOPO,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"MODSVOL",w_MODSVOL,0);
    CPLib.PutProperty(p,"RAGIO",w_RAGIO,0);
    CPLib.PutProperty(p,"TIPO",w_TIPO,0);
    CPLib.PutProperty(p,"RFREQ",w_RFREQ,0);
    CPLib.PutProperty(p,"RIMP",w_RIMP,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"RRAGIO",w_RRAGIO,0);
    CPLib.PutProperty(p,"RTIPO",w_RTIPO,0);
    CPLib.PutProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
    CPLib.PutProperty(p,"op_PRGIMPRAP",op_PRGIMPRAP,0);
    CPLib.PutProperty(p,"DURAT",w_DURAT,0);
    CPLib.PutProperty(p,"AMMONT",w_AMMONT,0);
    CPLib.PutProperty(p,"SPLITCODE",w_SPLITCODE,0);
    CPLib.PutProperty(p,"MACODICE",w_MACODICE,0);
    CPLib.PutProperty(p,"CODDIP",w_CODDIP,0);
    CPLib.PutProperty(p,"descval",w_descval,0);
    CPLib.PutProperty(p,"daticoll",w_daticoll,0);
    CPLib.PutProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescplauso",w_xdescplauso,0);
    CPLib.PutProperty(p,"xdesctipor",w_xdesctipor,0);
    CPLib.PutProperty(p,"xdescfreq",w_xdescfreq,0);
    CPLib.PutProperty(p,"xdescammo",w_xdescammo,0);
    CPLib.PutProperty(p,"gTelepass",w_gTelepass,0);
    CPLib.PutProperty(p,"xMADESCRI",w_xMADESCRI,0);
    CPLib.PutProperty(p,"mess",w_mess,0);
    CPLib.PutProperty(p,"gBrowser",w_gBrowser,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    if (p_bGetChildren) {
      if (ardt_delegabo.IsUpdated()) {
        m_cWv_ardt_delegabo = ardt_delegabo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_delegabo",m_cWv_ardt_delegabo,0);
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
    return "wnarapbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PRGIMPRAP");
    oneAutoNum.add("PRGIMPRAP");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_delegabo() {
    if (ardt_delegabo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_delegabo) || CPLib.IsLoaded(m_cWv_ardt_delegabo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_delegabo.m_bLoaded)) {
      ardt_delegabo.Blank();
      ardt_delegabo.w_RAPPORTO = w_RAPPORTO;
      ardt_delegabo.Load();
    }
    return ardt_delegabo.m_bLoaded;
  }
  public void CtxLoad_ardt_delegabo() {
    if ( ! (ardt_delegabo.m_lCtxLoaded)) {
      ardt_delegabo.Blank();
    }
    ardt_delegabo.m_lCtxLoaded = true;
    if ( ! (ardt_delegabo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_delegabo) || CPLib.IsLoaded(m_cWv_ardt_delegabo)) {
        ardt_delegabo.SetFromContext(m_cWv_ardt_delegabo);
        m_cWv_ardt_delegabo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_delegabo.m_bLoaded)) {
          ardt_delegabo.Blank();
          ardt_delegabo.w_RAPPORTO = w_RAPPORTO;
          ardt_delegabo.Load();
          if ( ! (ardt_delegabo.m_bLoaded)) {
            ardt_delegabo.Initialize();
            ardt_delegabo.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_delegabo")) {
      CtxLoad_ardt_delegabo();
      return ardt_delegabo;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
