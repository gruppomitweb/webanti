import java.util.*;

public class armt_anadipBL extends armt_anadipWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_anadip";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_anadip;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbcandistr;
  public String m_cServer_tbcandistr;
  public CPPhTableWrInfo m_oWrInfo_tbcandistr;
  public String m_cPhName_tbcateg01;
  public String m_cServer_tbcateg01;
  public CPPhTableWrInfo m_oWrInfo_tbcateg01;
  public String m_cPhName_tbcateg02;
  public String m_cServer_tbcateg02;
  public CPPhTableWrInfo m_oWrInfo_tbcateg02;
  public String m_cPhName_tbcateg03;
  public String m_cServer_tbcateg03;
  public CPPhTableWrInfo m_oWrInfo_tbcateg03;
  public String m_cPhName_tbcateg04;
  public String m_cServer_tbcateg04;
  public CPPhTableWrInfo m_oWrInfo_tbcateg04;
  public String m_cPhName_tbcateg05;
  public String m_cServer_tbcateg05;
  public CPPhTableWrInfo m_oWrInfo_tbcateg05;
  public String m_cPhName_tbtipconcessioni;
  public String m_cServer_tbtipconcessioni;
  public CPPhTableWrInfo m_oWrInfo_tbtipconcessioni;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"anadip"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'CODDIP':CODDIP,'DESCRIZ':DESCRIZ,'DOMICILIO':DOMICILIO,'CAP':CAP,'DESCCIT':DESCCIT,'AGENTE':AGENTE,'MACROAGENTE':MACROAGENTE,'TERMINALID':TERMINALID,'IDBASE':IDBASE,'TELEFONO':TELEFONO,'ABICABSARA':ABICABSARA,'AGACCODE':AGACCODE,'NAZAGENTE':NAZAGENTE,'AGEREGIO':AGEREGIO,'FLGATT':FLGATT,'CODLOC':CODLOC,'CODAGE':CODAGE,'TIPOSV':TIPOSV,'FLGNOAUA':FLGNOAUA,'FLGWUPOS':FLGWUPOS,'CATEG04':CATEG04,'CATEG05':CATEG05,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CAB2':CAB2,'CODICEAAMS':CODICEAAMS,'CONCESSIONE':CONCESSIONE,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'TIPOAGENTE':TIPOAGENTE,'ardt_dippreposti':ardt_dippreposti,'NUMCIVICO':NUMCIVICO,'SERRIMDEN':SERRIMDEN,'DATAINI':DATAINI,'DATAFINE':DATAFINE,'FLGCOMPL':FLGCOMPL"+FoundlingChildrenList("armt_anadip",true)+"}";
  public static final String i_CompleteStateStructure = "{'CODDIP':CODDIP,'DESCRIZ':DESCRIZ,'DOMICILIO':DOMICILIO,'CAP':CAP,'IDCITTA':IDCITTA,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAB':CAB,'AGENTE':AGENTE,'gFlgWU':gFlgWU,'MACROAGENTE':MACROAGENTE,'TERMINALID':TERMINALID,'xMADESCRI':xMADESCRI,'IDBASE':IDBASE,'TELEFONO':TELEFONO,'ABICABSARA':ABICABSARA,'AGACCODE':AGACCODE,'NAZAGENTE':NAZAGENTE,'xDESCNAZ':xDESCNAZ,'VALCOMPL':VALCOMPL,'ANOMOPER':ANOMOPER,'OPXSOSCLI':OPXSOSCLI,'OPXSOSAGE':OPXSOSAGE,'AGEREGIO':AGEREGIO,'FLGATT':FLGATT,'CODLOC':CODLOC,'CODAGE':CODAGE,'gAgeCGO':gAgeCGO,'TIPOSV':TIPOSV,'FLGNOAUA':FLGNOAUA,'FLGWUPOS':FLGWUPOS,'tipocat':tipocat,'CATEG04':CATEG04,'CATEG05':CATEG05,'xC1DESCRI':xC1DESCRI,'xC2DESCRI':xC2DESCRI,'xC3DESCRI':xC3DESCRI,'xC4DESCRI':xC4DESCRI,'xC5DESCRI':xC5DESCRI,'CATEGORIA':CATEGORIA,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CAB2':CAB2,'CODICEAAMS':CODICEAAMS,'CONCESSIONE':CONCESSIONE,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'TIPOAGENTE':TIPOAGENTE,'ardt_dippreposti':ardt_dippreposti,'NUMCIVICO':NUMCIVICO,'SERRIMDEN':SERRIMDEN,'gTipInter':gTipInter,'DATAINI':DATAINI,'DATAFINE':DATAFINE,'xDESCAN':xDESCAN,'xMACOGNOME':xMACOGNOME,'xMANOME':xMANOME,'FLGCOMPL':FLGCOMPL"+FoundlingChildrenList("armt_anadip",true)+"}";
  public static final String i_ItemSequence = "CODDIP,DESCRIZ,DOMICILIO,CAP,DESCCIT,AGENTE,MACROAGENTE,TERMINALID,IDBASE,TELEFONO,ABICABSARA,AGACCODE,NAZAGENTE,AGEREGIO,FLGATT,CODLOC,CODAGE,TIPOSV,FLGNOAUA,FLGWUPOS,CATEG04,CATEG05,CATEG01,CATEG02,CATEG03,CAB2,CODICEAAMS,CONCESSIONE,CODFISC,PARTIVA,TIPOAGENTE,ardt_dippreposti,NUMCIVICO,SERRIMDEN,DATAINI,DATAFINE,FLGCOMPL"+FoundlingChildrenList("armt_anadip",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_anadip"),new String[][]{new String[]{"CODDIP","Codice Dipendenza","C","6","0","campo","key1","false","false"},new String[]{"DESCRIZ","Descrizione","C","30","0","campo","key2","false","false"},new String[]{"DOMICILIO","Indirizzo","C","50","0","campo","nokey","false","false"},new String[]{"CAP","CAP","C","5","0","campo","nokey","false","false"},new String[]{"DESCCIT","Città","C","60","0","campo","nokey","false","false"},new String[]{"AGENTE","Agente","C","1","0","campo","nokey","false","false"},new String[]{"MACROAGENTE","Denominazione MacroAgente","C","5","0","campo","nokey","false","false"},new String[]{"TERMINALID","ID Terrminale","C","15","0","campo","nokey","false","false"},new String[]{"IDBASE","CGO Codice Interno","C","10","0","campo","nokey","false","false"},new String[]{"TELEFONO","Telefono","C","15","0","campo","nokey","false","false"},new String[]{"ABICABSARA","ABI CAB Dipendenza per SARA","C","12","0","campo","nokey","false","false"},new String[]{"AGACCODE","Dipendenza WU","C","10","0","campo","key3","false","false"},new String[]{"NAZAGENTE","Nazionalità Agente","C","3","0","campo","key4","false","false"},new String[]{"AGEREGIO","Regione","C","2","0","campo","nokey","false","false"},new String[]{"FLGATT","Agenzia Attiva (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"CODLOC","Codice Locale (CGO)","C","25","0","campo","nokey","false","false"},new String[]{"CODAGE","Codice AGENTE","C","15","0","campo","nokey","false","true"},new String[]{"TIPOSV","Canale Distributivo (SV)","C","3","0","campo","nokey","false","false"},new String[]{"FLGNOAUA","Escludi Controlli AUA","C","1","0","campo","nokey","false","false"},new String[]{"FLGWUPOS","Flag WUPOS","C","1","0","campo","nokey","false","false"},new String[]{"CATEG04","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG05","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG01","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG02","Categoria 2","C","2","0","campo","nokey","false","false"},new String[]{"CATEG03","Categoria 3","C","2","0","campo","nokey","false","false"},new String[]{"CAB2","CAB Bancario","C","6","0","campo","nokey","false","false"},new String[]{"CODICEAAMS","Codice AAMS Sala","C","12","0","campo","key11","false","false"},new String[]{"CONCESSIONE","Concessione","C","10","0","campo","nokey","false","false"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","nokey","false","false"},new String[]{"PARTIVA","Partita IVA","C","11","0","campo","nokey","false","false"},new String[]{"TIPOAGENTE","Tipo Agente","C","2","0","campo","nokey","false","false"},new String[]{"ardt_dippreposti","LinkPC","","","","link_PC","","false",""},new String[]{"NUMCIVICO","Numero Civico","C","15","0","campo","nokey","false","false"},new String[]{"SERRIMDEN","Servizi Rimessa Denaro (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"DATAINI","Data Inizio Mandato","D","8","0","campo","nokey","false","false"},new String[]{"DATAFINE","Data Fine Mandato","D","8","0","campo","nokey","false","true"},new String[]{"FLGCOMPL","Chiusura per compliance","N","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_anadipBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip",p_ContextObject.GetCompany(),false);
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cVirtName_anadip = CPSql.ManipulateTablePhName("anadip",m_cServer_anadip);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbcandistr = p_ContextObject.GetPhName("tbcandistr");
    m_cServer_tbcandistr = p_ContextObject.GetServer("tbcandistr");
    m_oWrInfo_tbcandistr = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcandistr",p_ContextObject.GetCompany());
    m_cPhName_tbcateg01 = p_ContextObject.GetPhName("tbcateg01");
    m_cServer_tbcateg01 = p_ContextObject.GetServer("tbcateg01");
    m_oWrInfo_tbcateg01 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcateg01",p_ContextObject.GetCompany());
    m_cPhName_tbcateg02 = p_ContextObject.GetPhName("tbcateg02");
    m_cServer_tbcateg02 = p_ContextObject.GetServer("tbcateg02");
    m_oWrInfo_tbcateg02 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcateg02",p_ContextObject.GetCompany());
    m_cPhName_tbcateg03 = p_ContextObject.GetPhName("tbcateg03");
    m_cServer_tbcateg03 = p_ContextObject.GetServer("tbcateg03");
    m_oWrInfo_tbcateg03 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcateg03",p_ContextObject.GetCompany());
    m_cPhName_tbcateg04 = p_ContextObject.GetPhName("tbcateg04");
    m_cServer_tbcateg04 = p_ContextObject.GetServer("tbcateg04");
    m_oWrInfo_tbcateg04 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcateg04",p_ContextObject.GetCompany());
    m_cPhName_tbcateg05 = p_ContextObject.GetPhName("tbcateg05");
    m_cServer_tbcateg05 = p_ContextObject.GetServer("tbcateg05");
    m_oWrInfo_tbcateg05 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcateg05",p_ContextObject.GetCompany());
    m_cPhName_tbtipconcessioni = p_ContextObject.GetPhName("tbtipconcessioni");
    m_cServer_tbtipconcessioni = p_ContextObject.GetServer("tbtipconcessioni");
    m_oWrInfo_tbtipconcessioni = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipconcessioni",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_dippreposti = new ardt_dipprepostiBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_anadip",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_CODDIP = "";
    w_DESCRIZ = "";
    w_DOMICILIO = "";
    w_CAP = "";
    w_IDCITTA = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAB = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_MACROAGENTE = "";
    w_TERMINALID = "";
    w_xMADESCRI = "";
    w_IDBASE = "";
    w_TELEFONO = "";
    w_ABICABSARA = "";
    w_AGACCODE = "";
    w_NAZAGENTE = "";
    w_xDESCNAZ = "";
    w_VALCOMPL = "";
    w_ANOMOPER = "";
    w_OPXSOSCLI = 0;
    w_OPXSOSAGE = 0;
    w_AGEREGIO = "";
    w_CODLOC = "";
    w_CODAGE = "";
    w_gAgeCGO = m_Ctx.GetGlobalString("gAgeCGO");
    w_TIPOSV = "";
    w_CATEG04 = "";
    w_CATEG05 = "";
    w_xC1DESCRI = "";
    w_xC2DESCRI = "";
    w_xC3DESCRI = "";
    w_xC4DESCRI = "";
    w_xC5DESCRI = "";
    w_CATEG01 = "";
    w_CATEG02 = "";
    w_CATEG03 = "";
    w_CAB2 = "";
    w_CODICEAAMS = "";
    w_CONCESSIONE = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_TIPOAGENTE = "";
    w_NUMCIVICO = "";
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_DATAINI = CPLib.NullDate();
    w_DATAFINE = CPLib.NullDate();
    w_xDESCAN = "";
    w_xMACOGNOME = "";
    w_xMANOME = "";
    w_FLGCOMPL = 0;
    Link_CZGVBAYWKP();
    Link_AEZUFOYHTM();
    w_AGENTE = "N";
    Link_BPQQBVFABO();
    Link_SGDAQGMTNU();
    w_FLGATT = "S";
    w_FLGNOAUA = "N";
    w_FLGWUPOS = "N";
    w_tipocat = "";
    w_tipocat = "D";
    Link_JQLGHMLOKO();
    Link_QVBZSFMTVP();
    w_CATEGORIA = "";
    w_CATEGORIA = LibreriaMit.SpacePad(w_CATEG01,2)+LibreriaMit.SpacePad(w_CATEG02,2)+LibreriaMit.SpacePad(w_CATEG03,2)+LibreriaMit.SpacePad(w_CATEG04,2)+LibreriaMit.SpacePad(w_CATEG05,2);
    Link_ICGUZGYXTD();
    Link_TGQHYPERED();
    Link_QRJNKZVHDW();
    w_SERRIMDEN = "N";
    m_cWv_ardt_dippreposti = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_dippreposti.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_dippreposti);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_IDCITTA = w_IDCITTA;
    ardt_dippreposti.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_YWRNVCZZWM();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_YWRNVCZZWM();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_CZGVBAYWKP() {
    return Link_CZGVBAYWKP("Full");
  }
  protected boolean Link_CZGVBAYWKP(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDCITTA))) {
      String l_OldValue = w_IDCITTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDCITTA,"C",10,0),m_cServer_tbcitta,w_IDCITTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select IDBASE,CITTA,CAB,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDCITTA = l_rsLink.GetString("IDBASE");
          w_DESCCIT = l_rsLink.GetString("CITTA");
          w_CAB = l_rsLink.GetString("CAB");
          w_PROVINCIA = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CZGVBAYWKP_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDCITTA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDCITTA");
          }
          m_cLastWorkVarError = "IDCITTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CZGVBAYWKP_blank();
    }
    return l_bResult;
  }
  void Link_CZGVBAYWKP_blank() {
    w_IDCITTA = "";
    w_DESCCIT = "";
    w_CAB = "";
    w_PROVINCIA = "";
  }
  protected boolean Link_AEZUFOYHTM() {
    return Link_AEZUFOYHTM("Full");
  }
  protected boolean Link_AEZUFOYHTM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      String l_OldValue = w_DESCCIT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",60,0),m_cServer_tbcitta,w_DESCCIT);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,IDBASE,PROV,CAB,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",10,0),m_cServer_tbcitta,w_DESCCIT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,IDBASE,PROV,CAB,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DESCCIT = l_rsLink.GetString("CITTA");
          w_IDCITTA = l_rsLink.GetString("IDBASE");
          w_PROVINCIA = l_rsLink.GetString("PROV");
          w_CAB = l_rsLink.GetString("CAB");
          w_CAP = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AEZUFOYHTM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_DESCCIT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DESCCIT");
          }
          m_cLastWorkVarError = "DESCCIT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AEZUFOYHTM_blank();
    }
    return l_bResult;
  }
  void Link_AEZUFOYHTM_blank() {
    w_DESCCIT = "";
    w_IDCITTA = "";
    w_PROVINCIA = "";
    w_CAB = "";
    w_CAP = "";
  }
  protected boolean Link_BPQQBVFABO() {
    return Link_BPQQBVFABO("Full");
  }
  protected boolean Link_BPQQBVFABO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MACROAGENTE))) {
      String l_OldValue = w_MACROAGENTE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACROAGENTE,"C",5,0),m_cServer_tbmacage,w_MACROAGENTE);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI,MACOGNOME,MANOME from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACROAGENTE,"C",60,0),m_cServer_tbmacage,w_MACROAGENTE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI,MACOGNOME,MANOME from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MADESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MACROAGENTE = l_rsLink.GetString("MACODICE");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          w_xMACOGNOME = l_rsLink.GetString("MACOGNOME");
          w_xMANOME = l_rsLink.GetString("MANOME");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_BPQQBVFABO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MACROAGENTE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MACROAGENTE");
          }
          m_cLastWorkVarError = "MACROAGENTE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_BPQQBVFABO_blank();
    }
    return l_bResult;
  }
  void Link_BPQQBVFABO_blank() {
    w_MACROAGENTE = "";
    w_xMADESCRI = "";
    w_xMACOGNOME = "";
    w_xMANOME = "";
  }
  protected boolean Link_SGDAQGMTNU() {
    return Link_SGDAQGMTNU("Full");
  }
  protected boolean Link_SGDAQGMTNU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_NAZAGENTE))) {
      String l_OldValue = w_NAZAGENTE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NAZAGENTE,"C",3,0),m_cServer_tbstati,w_NAZAGENTE);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_NAZAGENTE = l_rsLink.GetString("CODSTA");
          w_xDESCNAZ = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SGDAQGMTNU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_NAZAGENTE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","NAZAGENTE");
          }
          m_cLastWorkVarError = "NAZAGENTE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SGDAQGMTNU_blank();
    }
    return l_bResult;
  }
  void Link_SGDAQGMTNU_blank() {
    w_NAZAGENTE = "";
    w_xDESCNAZ = "";
  }
  protected boolean Link_JQLGHMLOKO() {
    return Link_JQLGHMLOKO("Full");
  }
  protected boolean Link_JQLGHMLOKO(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CATEG04))) {
      String l_OldValue = w_CATEG04;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG04,"C",2,0),m_cServer_tbcateg04,w_CATEG04);
      l_cWhere = l_cWhere+" and C4CODTAB = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipocat,"C",10,0),m_cServer_tbcateg04,w_tipocat);
      if (m_Ctx.IsSharedTemp("tbcateg04")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg04,"select C4CODTAB,C4CODICE,C4DESCRI from "+m_cPhName_tbcateg04+((m_cPhName_tbcateg04).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C4CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CATEG04 = l_rsLink.GetString("C4CODICE");
          w_xC4DESCRI = l_rsLink.GetString("C4DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_JQLGHMLOKO_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CATEG04 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CATEG04");
          }
          m_cLastWorkVarError = "CATEG04";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_JQLGHMLOKO_blank();
    }
    return l_bResult;
  }
  void Link_JQLGHMLOKO_blank() {
    w_CATEG04 = "";
    w_xC4DESCRI = "";
  }
  protected boolean Link_QVBZSFMTVP() {
    return Link_QVBZSFMTVP("Full");
  }
  protected boolean Link_QVBZSFMTVP(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CATEG05))) {
      String l_OldValue = w_CATEG05;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG05,"C",2,0),m_cServer_tbcateg05,w_CATEG05);
      l_cWhere = l_cWhere+" and C5CODTAB = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipocat,"C",10,0),m_cServer_tbcateg05,w_tipocat);
      if (m_Ctx.IsSharedTemp("tbcateg05")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg05,"select C5CODTAB,C5CODICE,C5DESCRI from "+m_cPhName_tbcateg05+((m_cPhName_tbcateg05).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C5CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CATEG05 = l_rsLink.GetString("C5CODICE");
          w_xC5DESCRI = l_rsLink.GetString("C5DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QVBZSFMTVP_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CATEG05 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CATEG05");
          }
          m_cLastWorkVarError = "CATEG05";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QVBZSFMTVP_blank();
    }
    return l_bResult;
  }
  void Link_QVBZSFMTVP_blank() {
    w_CATEG05 = "";
    w_xC5DESCRI = "";
  }
  protected boolean Link_ICGUZGYXTD() {
    return Link_ICGUZGYXTD("Full");
  }
  protected boolean Link_ICGUZGYXTD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CATEG01))) {
      String l_OldValue = w_CATEG01;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG01,"C",2,0),m_cServer_tbcateg01,w_CATEG01);
      l_cWhere = l_cWhere+" and C1CODTAB = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipocat,"C",10,0),m_cServer_tbcateg01,w_tipocat);
      if (m_Ctx.IsSharedTemp("tbcateg01")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg01,"select C1CODTAB,C1CODICE,C1DESCRI from "+m_cPhName_tbcateg01+((m_cPhName_tbcateg01).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C1CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CATEG01 = l_rsLink.GetString("C1CODICE");
          w_xC1DESCRI = l_rsLink.GetString("C1DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ICGUZGYXTD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CATEG01 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CATEG01");
          }
          m_cLastWorkVarError = "CATEG01";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ICGUZGYXTD_blank();
    }
    return l_bResult;
  }
  void Link_ICGUZGYXTD_blank() {
    w_CATEG01 = "";
    w_xC1DESCRI = "";
  }
  protected boolean Link_TGQHYPERED() {
    return Link_TGQHYPERED("Full");
  }
  protected boolean Link_TGQHYPERED(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CATEG02))) {
      String l_OldValue = w_CATEG02;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG02,"C",2,0),m_cServer_tbcateg02,w_CATEG02);
      l_cWhere = l_cWhere+" and C2CODTAB = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipocat,"C",10,0),m_cServer_tbcateg02,w_tipocat);
      if (m_Ctx.IsSharedTemp("tbcateg02")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg02,"select C2CODTAB,C2CODICE,C2DESCRI from "+m_cPhName_tbcateg02+((m_cPhName_tbcateg02).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C2CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG02,"C",80,0),m_cServer_tbcateg02,w_CATEG02);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcateg02,"select C2CODTAB,C2CODICE,C2DESCRI from "+m_cPhName_tbcateg02+((m_cPhName_tbcateg02).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C2DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CATEG02 = l_rsLink.GetString("C2CODICE");
          w_xC2DESCRI = l_rsLink.GetString("C2DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_TGQHYPERED_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CATEG02 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CATEG02");
          }
          m_cLastWorkVarError = "CATEG02";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_TGQHYPERED_blank();
    }
    return l_bResult;
  }
  void Link_TGQHYPERED_blank() {
    w_CATEG02 = "";
    w_xC2DESCRI = "";
  }
  protected boolean Link_QRJNKZVHDW() {
    return Link_QRJNKZVHDW("Full");
  }
  protected boolean Link_QRJNKZVHDW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CATEG03))) {
      String l_OldValue = w_CATEG03;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG03,"C",2,0),m_cServer_tbcateg03,w_CATEG03);
      l_cWhere = l_cWhere+" and C3CODTAB = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_tipocat,"C",10,0),m_cServer_tbcateg03,w_tipocat);
      if (m_Ctx.IsSharedTemp("tbcateg03")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg03,"select C3CODTAB,C3CODICE,C3DESCRI from "+m_cPhName_tbcateg03+((m_cPhName_tbcateg03).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C3CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CATEG03,"C",80,0),m_cServer_tbcateg03,w_CATEG03);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcateg03,"select C3CODTAB,C3CODICE,C3DESCRI from "+m_cPhName_tbcateg03+((m_cPhName_tbcateg03).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C3DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CATEG03 = l_rsLink.GetString("C3CODICE");
          w_xC3DESCRI = l_rsLink.GetString("C3DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QRJNKZVHDW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CATEG03 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CATEG03");
          }
          m_cLastWorkVarError = "CATEG03";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QRJNKZVHDW_blank();
    }
    return l_bResult;
  }
  void Link_QRJNKZVHDW_blank() {
    w_CATEG03 = "";
    w_xC3DESCRI = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_CODDIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCRIZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCRIZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DOMICILIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOMICILIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCCIT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCCIT = p_workVariableValue;
    l_bResult = Link_AEZUFOYHTM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCCIT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AGENTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AGENTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MACROAGENTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACROAGENTE = p_workVariableValue;
    l_bResult = Link_BPQQBVFABO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MACROAGENTE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TERMINALID(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TERMINALID = p_workVariableValue;
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
  public boolean Set_TELEFONO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TELEFONO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ABICABSARA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ABICABSARA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AGACCODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AGACCODE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NAZAGENTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NAZAGENTE = p_workVariableValue;
    l_bResult = Link_SGDAQGMTNU();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NAZAGENTE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AGEREGIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AGEREGIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGATT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGATT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODLOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODLOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODAGE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODAGE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean MOQMJLJJNI_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_gAgeCGO,"S");
  }
  public boolean Set_TIPOSV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOSV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGNOAUA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGNOAUA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGWUPOS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGWUPOS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATEG04(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG04 = p_workVariableValue;
    l_bResult = Link_JQLGHMLOKO();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CATEG04 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATEG05(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG05 = p_workVariableValue;
    l_bResult = Link_QVBZSFMTVP();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CATEG05 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATEG01(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG01 = p_workVariableValue;
    l_bResult = Link_ICGUZGYXTD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CATEG01 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATEG02(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG02 = p_workVariableValue;
    l_bResult = Link_TGQHYPERED();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CATEG02 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CATEG03(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG03 = p_workVariableValue;
    l_bResult = Link_QRJNKZVHDW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CATEG03 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAB2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAB2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODICEAAMS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODICEAAMS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONCESSIONE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONCESSIONE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODFISC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODFISC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PARTIVA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PARTIVA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOAGENTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOAGENTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMCIVICO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMCIVICO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SERRIMDEN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SERRIMDEN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAFINE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAFINE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAFINE = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean QDGOPSCQNI_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLGCOMPL,1);
  }
  public boolean Set_FLGCOMPL(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCOMPL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_TERMINALID() {
    return CPLib.ne(w_gFlgWU,"S");
  }
  public boolean getVisible_CODAGE() {
    return CPLib.ne(w_gAgeCGO,"S");
  }
  public boolean getVisible_FLGNOAUA() {
    return CPLib.ne(w_gFlgWU,"S");
  }
  public boolean getVisible_FLGWUPOS() {
    return CPLib.ne(w_gFlgWU,"S");
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
    if (CPLib.ne(o_IDCITTA,w_IDCITTA)) {
      l_bTmpRes = Link_CZGVBAYWKP();
    }
    w_tipocat = "D";
    w_CATEGORIA = LibreriaMit.SpacePad(w_CATEG01,2)+LibreriaMit.SpacePad(w_CATEG02,2)+LibreriaMit.SpacePad(w_CATEG03,2)+LibreriaMit.SpacePad(w_CATEG04,2)+LibreriaMit.SpacePad(w_CATEG05,2);
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_YWRNVCZZWM() {
    arrt_creaute_ageR l_oRoutine_arrt_creaute_age;
    l_oRoutine_arrt_creaute_age = arrt_creaute_ageR.Make(m_Ctx,this);
    l_oRoutine_arrt_creaute_age.Run();
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
  public final static String[] m_KeyColumns = {"CODDIP"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_anadip","anadip",m_KeyColumns,m_Ctx);
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
    w_CODDIP = "";
    w_DESCRIZ = "";
    w_DOMICILIO = "";
    w_CAP = "";
    w_IDCITTA = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAB = "";
    w_AGENTE = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_MACROAGENTE = "";
    w_TERMINALID = "";
    w_xMADESCRI = "";
    w_IDBASE = "";
    w_TELEFONO = "";
    w_ABICABSARA = "";
    w_AGACCODE = "";
    w_NAZAGENTE = "";
    w_xDESCNAZ = "";
    w_VALCOMPL = "";
    w_ANOMOPER = "";
    w_OPXSOSCLI = 0;
    w_OPXSOSAGE = 0;
    w_AGEREGIO = "";
    w_FLGATT = "";
    w_CODLOC = "";
    w_CODAGE = "";
    w_gAgeCGO = m_Ctx.GetGlobalString("gAgeCGO");
    w_TIPOSV = "";
    w_FLGNOAUA = "";
    w_FLGWUPOS = "";
    w_tipocat = "";
    w_CATEG04 = "";
    w_CATEG05 = "";
    w_xC1DESCRI = "";
    w_xC2DESCRI = "";
    w_xC3DESCRI = "";
    w_xC4DESCRI = "";
    w_xC5DESCRI = "";
    w_CATEGORIA = "";
    w_CATEG01 = "";
    w_CATEG02 = "";
    w_CATEG03 = "";
    w_CAB2 = "";
    w_CODICEAAMS = "";
    w_CONCESSIONE = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_TIPOAGENTE = "";
    w_NUMCIVICO = "";
    w_SERRIMDEN = "";
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_DATAINI = CPLib.NullDate();
    w_DATAFINE = CPLib.NullDate();
    w_xDESCAN = "";
    w_xMACOGNOME = "";
    w_xMANOME = "";
    w_FLGCOMPL = 0;
    m_cWv_ardt_dippreposti = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CODDIP = CPLib.GetProperty(p,"CODDIP",w_CODDIP,0);
      w_DESCRIZ = CPLib.GetProperty(p,"DESCRIZ",w_DESCRIZ,0);
      w_DOMICILIO = CPLib.GetProperty(p,"DOMICILIO",w_DOMICILIO,0);
      w_CAP = CPLib.GetProperty(p,"CAP",w_CAP,0);
      w_IDCITTA = CPLib.GetProperty(p,"IDCITTA",w_IDCITTA,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CAB = CPLib.GetProperty(p,"CAB",w_CAB,0);
      w_AGENTE = CPLib.GetProperty(p,"AGENTE",w_AGENTE,0);
      w_MACROAGENTE = CPLib.GetProperty(p,"MACROAGENTE",w_MACROAGENTE,0);
      w_TERMINALID = CPLib.GetProperty(p,"TERMINALID",w_TERMINALID,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_TELEFONO = CPLib.GetProperty(p,"TELEFONO",w_TELEFONO,0);
      w_ABICABSARA = CPLib.GetProperty(p,"ABICABSARA",w_ABICABSARA,0);
      w_AGACCODE = CPLib.GetProperty(p,"AGACCODE",w_AGACCODE,0);
      w_NAZAGENTE = CPLib.GetProperty(p,"NAZAGENTE",w_NAZAGENTE,0);
      w_VALCOMPL = CPLib.GetProperty(p,"VALCOMPL",w_VALCOMPL,0);
      w_ANOMOPER = CPLib.GetProperty(p,"ANOMOPER",w_ANOMOPER,0);
      w_OPXSOSCLI = CPLib.GetProperty(p,"OPXSOSCLI",w_OPXSOSCLI,0);
      w_OPXSOSAGE = CPLib.GetProperty(p,"OPXSOSAGE",w_OPXSOSAGE,0);
      w_AGEREGIO = CPLib.GetProperty(p,"AGEREGIO",w_AGEREGIO,0);
      w_FLGATT = CPLib.GetProperty(p,"FLGATT",w_FLGATT,0);
      w_CODLOC = CPLib.GetProperty(p,"CODLOC",w_CODLOC,0);
      w_CODAGE = CPLib.GetProperty(p,"CODAGE",w_CODAGE,0);
      w_TIPOSV = CPLib.GetProperty(p,"TIPOSV",w_TIPOSV,0);
      w_FLGNOAUA = CPLib.GetProperty(p,"FLGNOAUA",w_FLGNOAUA,0);
      w_FLGWUPOS = CPLib.GetProperty(p,"FLGWUPOS",w_FLGWUPOS,0);
      w_CATEG04 = CPLib.GetProperty(p,"CATEG04",w_CATEG04,0);
      w_CATEG05 = CPLib.GetProperty(p,"CATEG05",w_CATEG05,0);
      w_CATEGORIA = CPLib.GetProperty(p,"CATEGORIA",w_CATEGORIA,0);
      w_CATEG01 = CPLib.GetProperty(p,"CATEG01",w_CATEG01,0);
      w_CATEG02 = CPLib.GetProperty(p,"CATEG02",w_CATEG02,0);
      w_CATEG03 = CPLib.GetProperty(p,"CATEG03",w_CATEG03,0);
      w_CAB2 = CPLib.GetProperty(p,"CAB2",w_CAB2,0);
      w_CODICEAAMS = CPLib.GetProperty(p,"CODICEAAMS",w_CODICEAAMS,0);
      w_CONCESSIONE = CPLib.GetProperty(p,"CONCESSIONE",w_CONCESSIONE,0);
      w_CODFISC = CPLib.GetProperty(p,"CODFISC",w_CODFISC,0);
      w_PARTIVA = CPLib.GetProperty(p,"PARTIVA",w_PARTIVA,0);
      w_TIPOAGENTE = CPLib.GetProperty(p,"TIPOAGENTE",w_TIPOAGENTE,0);
      w_NUMCIVICO = CPLib.GetProperty(p,"NUMCIVICO",w_NUMCIVICO,0);
      w_SERRIMDEN = CPLib.GetProperty(p,"SERRIMDEN",w_SERRIMDEN,0);
      w_DATAINI = CPLib.GetProperty(p,"DATAINI",w_DATAINI,0);
      w_DATAFINE = CPLib.GetProperty(p,"DATAFINE",w_DATAFINE,0);
      w_FLGCOMPL = CPLib.GetProperty(p,"FLGCOMPL",w_FLGCOMPL,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_xDESCNAZ = CPLib.GetProperty(p,"xDESCNAZ",w_xDESCNAZ,0);
      w_gAgeCGO = CPLib.GetProperty(p,"gAgeCGO",w_gAgeCGO,0);
      w_tipocat = CPLib.GetProperty(p,"tipocat",w_tipocat,0);
      w_xC1DESCRI = CPLib.GetProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
      w_xC2DESCRI = CPLib.GetProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
      w_xC3DESCRI = CPLib.GetProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
      w_xC4DESCRI = CPLib.GetProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
      w_xC5DESCRI = CPLib.GetProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_xDESCAN = CPLib.GetProperty(p,"xDESCAN",w_xDESCAN,0);
      w_xMACOGNOME = CPLib.GetProperty(p,"xMACOGNOME",w_xMACOGNOME,0);
      w_xMANOME = CPLib.GetProperty(p,"xMANOME",w_xMANOME,0);
      m_cWv_ardt_dippreposti = CPLib.GetProperty(p,"m_cWv_ardt_dippreposti",m_cWv_ardt_dippreposti,0);
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
    items = tables.get("dippreposti");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("dippreposti",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP"});
    map.put("rd_var",new String[]{"w_CODDIP"});
    map.put("wr_var",new String[]{"w_CODDIP"});
    map.put("wr_field",new String[]{"CODDIP"});
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
    map.put("property.value",zeroSplit.split("dippreposti\u0000false\u0000false\u00001\u00000\u0000ardt_dippreposti\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","CITTA","CAB","PROV"});
    map.put("rd_var",new String[]{"w_IDCITTA","w_DESCCIT","w_CAB","w_PROVINCIA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000060\u00006\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Città\u0000Città\u0000CAB\u0000Provincia",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00002\u00000\u0000armt_citta\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CITTA","IDBASE","PROV","CAB","CAP"});
    map.put("rd_var",new String[]{"w_DESCCIT","w_IDCITTA","w_PROVINCIA","w_CAB","w_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("60\u000010\u00002\u00006\u00005",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città\u0000Codice Città\u0000Provincia\u0000CAB\u0000CAP",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Città\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"MACODICE","MADESCRI","MACOGNOME","MANOME"});
    map.put("rd_var",new String[]{"w_MACROAGENTE","w_xMADESCRI","w_xMACOGNOME","w_xMANOME"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060\u000050\u000050",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Denominazione MacroAgente\u0000Denominazione\u0000Cognome\u0000Nome",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00002\u00000\u0000armt_tbmacage\u0000false\u0000false\u0000MacroAgenti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_NAZAGENTE","w_xDESCNAZ"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Nazionalità Agente\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key4\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg04");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg04",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_tipocat"});
    map.put("rd_kfield",new String[]{"C4CODTAB"});
    map.put("rd_field",new String[]{"C4CODICE","C4DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG04","w_xC4DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("tbcateg04\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg04\u0000false\u0000false\u0000Categoria 4\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg05");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg05",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_tipocat"});
    map.put("rd_kfield",new String[]{"C5CODTAB"});
    map.put("rd_field",new String[]{"C5CODICE","C5DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG05","w_xC5DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("tbcateg05\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg05\u0000false\u0000false\u0000Categoria 5\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg01");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg01",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_tipocat"});
    map.put("rd_kfield",new String[]{"C1CODTAB"});
    map.put("rd_field",new String[]{"C1CODICE","C1DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG01","w_xC1DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("tbcateg01\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Categoria 1\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg02");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg02",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_tipocat"});
    map.put("rd_kfield",new String[]{"C2CODTAB"});
    map.put("rd_field",new String[]{"C2CODICE","C2DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG02","w_xC2DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Categoria 2\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("tbcateg02\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Categoria 2\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg03");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg03",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_tipocat"});
    map.put("rd_kfield",new String[]{"C3CODTAB"});
    map.put("rd_field",new String[]{"C3CODICE","C3DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG03","w_xC3DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",zeroSplit.split("10",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Categoria 3\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{""});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("variabile",-1));
    map.put("property.value",zeroSplit.split("tbcateg03\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Categoria 3\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_anadip",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_anadip",child);
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
    ardt_dippreposti = new ardt_dipprepostiBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_anadip",m_Ctx);
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
    if (CPLib.Empty(w_CODAGE) && MOQMJLJJNI_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODAGE));
      String obblMsgError = m_Ctx.Translate("Codice AGENTE")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODAGE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODAGE";
      }
    } else if (CPLib.Empty(w_DATAFINE) && QDGOPSCQNI_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAFINE));
      String obblMsgError = m_Ctx.Translate("Data Fine Mandato")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("Obbligatoria se chiusura per compliance");
      l_bResult = false;
      w_DATAFINE = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAFINE";
      }
    }
    if (l_bResult && (( ! (ardt_dippreposti.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_dippreposti)) || ( ! (ardt_dippreposti.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_dippreposti)))) {
      ardt_dippreposti.SetFromContext(m_cWv_ardt_dippreposti);
      m_cWv_ardt_dippreposti = "_not_empty_";
    }
    if (l_bResult && (ardt_dippreposti.m_bLoaded || ardt_dippreposti.m_bUpdated)) {
      l_bResult = l_bResult && ardt_dippreposti.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_dippreposti.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_anadip"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_anadip\\"+p_cState};
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
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_IDCITTA = "";
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
    CPLib.PutProperty(p,"CODDIP",w_CODDIP,0);
    CPLib.PutProperty(p,"DESCRIZ",w_DESCRIZ,0);
    CPLib.PutProperty(p,"DOMICILIO",w_DOMICILIO,0);
    CPLib.PutProperty(p,"CAP",w_CAP,0);
    CPLib.PutProperty(p,"IDCITTA",w_IDCITTA,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CAB",w_CAB,0);
    CPLib.PutProperty(p,"AGENTE",w_AGENTE,0);
    CPLib.PutProperty(p,"MACROAGENTE",w_MACROAGENTE,0);
    CPLib.PutProperty(p,"TERMINALID",w_TERMINALID,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"TELEFONO",w_TELEFONO,0);
    CPLib.PutProperty(p,"ABICABSARA",w_ABICABSARA,0);
    CPLib.PutProperty(p,"AGACCODE",w_AGACCODE,0);
    CPLib.PutProperty(p,"NAZAGENTE",w_NAZAGENTE,0);
    CPLib.PutProperty(p,"VALCOMPL",w_VALCOMPL,0);
    CPLib.PutProperty(p,"ANOMOPER",w_ANOMOPER,0);
    CPLib.PutProperty(p,"OPXSOSCLI",w_OPXSOSCLI,0);
    CPLib.PutProperty(p,"OPXSOSAGE",w_OPXSOSAGE,0);
    CPLib.PutProperty(p,"AGEREGIO",w_AGEREGIO,0);
    CPLib.PutProperty(p,"FLGATT",w_FLGATT,0);
    CPLib.PutProperty(p,"CODLOC",w_CODLOC,0);
    CPLib.PutProperty(p,"CODAGE",w_CODAGE,0);
    CPLib.PutProperty(p,"TIPOSV",w_TIPOSV,0);
    CPLib.PutProperty(p,"FLGNOAUA",w_FLGNOAUA,0);
    CPLib.PutProperty(p,"FLGWUPOS",w_FLGWUPOS,0);
    CPLib.PutProperty(p,"CATEG04",w_CATEG04,0);
    CPLib.PutProperty(p,"CATEG05",w_CATEG05,0);
    CPLib.PutProperty(p,"CATEGORIA",w_CATEGORIA,0);
    CPLib.PutProperty(p,"CATEG01",w_CATEG01,0);
    CPLib.PutProperty(p,"CATEG02",w_CATEG02,0);
    CPLib.PutProperty(p,"CATEG03",w_CATEG03,0);
    CPLib.PutProperty(p,"CAB2",w_CAB2,0);
    CPLib.PutProperty(p,"CODICEAAMS",w_CODICEAAMS,0);
    CPLib.PutProperty(p,"CONCESSIONE",w_CONCESSIONE,0);
    CPLib.PutProperty(p,"CODFISC",w_CODFISC,0);
    CPLib.PutProperty(p,"PARTIVA",w_PARTIVA,0);
    CPLib.PutProperty(p,"TIPOAGENTE",w_TIPOAGENTE,0);
    CPLib.PutProperty(p,"NUMCIVICO",w_NUMCIVICO,0);
    CPLib.PutProperty(p,"SERRIMDEN",w_SERRIMDEN,0);
    CPLib.PutProperty(p,"DATAINI",w_DATAINI,0);
    CPLib.PutProperty(p,"DATAFINE",w_DATAFINE,0);
    CPLib.PutProperty(p,"FLGCOMPL",w_FLGCOMPL,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"xMADESCRI",w_xMADESCRI,0);
    CPLib.PutProperty(p,"xDESCNAZ",w_xDESCNAZ,0);
    CPLib.PutProperty(p,"gAgeCGO",w_gAgeCGO,0);
    CPLib.PutProperty(p,"tipocat",w_tipocat,0);
    CPLib.PutProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
    CPLib.PutProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
    CPLib.PutProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
    CPLib.PutProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
    CPLib.PutProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"xDESCAN",w_xDESCAN,0);
    CPLib.PutProperty(p,"xMACOGNOME",w_xMACOGNOME,0);
    CPLib.PutProperty(p,"xMANOME",w_xMANOME,0);
    if (p_bGetChildren) {
      if (ardt_dippreposti.IsUpdated()) {
        m_cWv_ardt_dippreposti = ardt_dippreposti.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_dippreposti",m_cWv_ardt_dippreposti,0);
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
    return "anadip"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CODDIP","C",6,0));
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
  public boolean ChildExists_ardt_dippreposti() {
    if (ardt_dippreposti.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_dippreposti) || CPLib.IsLoaded(m_cWv_ardt_dippreposti))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_dippreposti.m_bLoaded)) {
      ardt_dippreposti.Blank();
      ardt_dippreposti.w_CODDIP = w_CODDIP;
      ardt_dippreposti.Load();
    }
    return ardt_dippreposti.m_bLoaded;
  }
  public void CtxLoad_ardt_dippreposti() {
    if ( ! (ardt_dippreposti.m_lCtxLoaded)) {
      ardt_dippreposti.Blank();
    }
    ardt_dippreposti.m_lCtxLoaded = true;
    if ( ! (ardt_dippreposti.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_dippreposti) || CPLib.IsLoaded(m_cWv_ardt_dippreposti)) {
        ardt_dippreposti.SetFromContext(m_cWv_ardt_dippreposti);
        m_cWv_ardt_dippreposti = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_dippreposti.m_bLoaded)) {
          ardt_dippreposti.Blank();
          ardt_dippreposti.w_CODDIP = w_CODDIP;
          ardt_dippreposti.Load();
          if ( ! (ardt_dippreposti.m_bLoaded)) {
            ardt_dippreposti.Initialize();
            ardt_dippreposti.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_dippreposti")) {
      CtxLoad_ardt_dippreposti();
      return ardt_dippreposti;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
