import java.util.*;

public class armt_ae_anarapBL extends armt_ae_anarapWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_ae_anarap";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public CPPhTableWrInfo m_oWrInfo_jnarapbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_jnarapbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog;
  public String m_cPhName_tbareegeog_p;
  public String m_cServer_tbareegeog_p;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog_p;
  public String m_cPhName_tbdurata;
  public String m_cServer_tbdurata;
  public CPPhTableWrInfo m_oWrInfo_tbdurata;
  public String m_cPhName_tbdurata_p;
  public String m_cServer_tbdurata_p;
  public CPPhTableWrInfo m_oWrInfo_tbdurata_p;
  public String m_cPhName_tbimporto;
  public String m_cServer_tbimporto;
  public CPPhTableWrInfo m_oWrInfo_tbimporto;
  public String m_cPhName_tbimporto_p;
  public String m_cServer_tbimporto_p;
  public CPPhTableWrInfo m_oWrInfo_tbimporto_p;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  public String m_cPhName_tbplauso;
  public String m_cServer_tbplauso;
  public CPPhTableWrInfo m_oWrInfo_tbplauso;
  public String m_cPhName_tbplauso_p;
  public String m_cServer_tbplauso_p;
  public CPPhTableWrInfo m_oWrInfo_tbplauso_p;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_tbrappogg;
  public String m_cServer_tbrappogg;
  public CPPhTableWrInfo m_oWrInfo_tbrappogg;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbsvolgim;
  public String m_cServer_tbsvolgim;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim;
  public String m_cPhName_tbsvolgim_p;
  public String m_cServer_tbsvolgim_p;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim_p;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public CPPhTableWrInfo m_oWrInfo_tbtipnat;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc;
  public String m_cPhName_tbtiporisc_p;
  public String m_cServer_tbtiporisc_p;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc_p;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"jnarapbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'ISOAGE':ISOAGE,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'ardt_ae_delegabo':ardt_ae_delegabo,'ardt_saldioro':ardt_saldioro,'ardt_jarantbo':ardt_jarantbo,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_anarap",true)+"}";
  public static final String i_CompleteStateStructure = "{'gTelepass':gTelepass,'gCodDip':gCodDip,'gBrowser':gBrowser,'gTipInter':gTipInter,'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'ISOAGE':ISOAGE,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'descval':descval,'daticoll':daticoll,'PRGIMPRAP':PRGIMPRAP,'CODDIP':CODDIP,'titolo':titolo,'NOPROT':NOPROT,'mess':mess,'ardt_ae_delegabo':ardt_ae_delegabo,'ardt_saldioro':ardt_saldioro,'ardt_jarantbo':ardt_jarantbo,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_anarap",true)+"}";
  public static final String i_ItemSequence = "RAPPORTO,DESCRAP,TIPORAP,TIPOAG,ISOAGE,FLAGLIRE,VALUTA,ardt_ae_delegabo,ardt_saldioro,ardt_jarantbo,ardt_ae_saldianno_rap"+FoundlingChildrenList("armt_ae_anarap",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_ae_anarap"),new String[][]{new String[]{"RAPPORTO","Codice Rapporto","C","25","0","campo","key1","false","false"},new String[]{"DESCRAP","Descrizione","C","50","0","campo","key2","false","false"},new String[]{"TIPORAP","Tipo Rapporto","C","1","0","campo","nokey","false","true"},new String[]{"TIPOAG","","C","2","0","campo","nokey","false","false"},new String[]{"ISOAGE","Per tipo rapporto 96/97","C","3","0","campo","nokey","false","true"},new String[]{"FLAGLIRE","Divisa","C","1","0","campo","nokey","false","true"},new String[]{"VALUTA","Codice Divisa","C","3","0","campo","nokey","false","true"},new String[]{"ardt_ae_delegabo","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_saldioro","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_jarantbo","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_ae_saldianno_rap","LinkPC","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_ae_anarapBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo",p_ContextObject.GetCompany(),false);
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_oWrInfo_jnarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"jnarapbo",p_ContextObject.GetCompany());
    m_cVirtName_jnarapbo = CPSql.ManipulateTablePhName("jnarapbo",m_cServer_jnarapbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_oWrInfo_tbareegeog = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog_p = p_ContextObject.GetPhName("tbareegeog_p");
    m_cServer_tbareegeog_p = p_ContextObject.GetServer("tbareegeog_p");
    m_oWrInfo_tbareegeog_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog_p",p_ContextObject.GetCompany());
    m_cPhName_tbdurata = p_ContextObject.GetPhName("tbdurata");
    m_cServer_tbdurata = p_ContextObject.GetServer("tbdurata");
    m_oWrInfo_tbdurata = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata",p_ContextObject.GetCompany());
    m_cPhName_tbdurata_p = p_ContextObject.GetPhName("tbdurata_p");
    m_cServer_tbdurata_p = p_ContextObject.GetServer("tbdurata_p");
    m_oWrInfo_tbdurata_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata_p",p_ContextObject.GetCompany());
    m_cPhName_tbimporto = p_ContextObject.GetPhName("tbimporto");
    m_cServer_tbimporto = p_ContextObject.GetServer("tbimporto");
    m_oWrInfo_tbimporto = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto",p_ContextObject.GetCompany());
    m_cPhName_tbimporto_p = p_ContextObject.GetPhName("tbimporto_p");
    m_cServer_tbimporto_p = p_ContextObject.GetServer("tbimporto_p");
    m_oWrInfo_tbimporto_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto_p",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cPhName_tbplauso = p_ContextObject.GetPhName("tbplauso");
    m_cServer_tbplauso = p_ContextObject.GetServer("tbplauso");
    m_oWrInfo_tbplauso = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso",p_ContextObject.GetCompany());
    m_cPhName_tbplauso_p = p_ContextObject.GetPhName("tbplauso_p");
    m_cServer_tbplauso_p = p_ContextObject.GetServer("tbplauso_p");
    m_oWrInfo_tbplauso_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso_p",p_ContextObject.GetCompany());
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_tbrappogg = p_ContextObject.GetPhName("tbrappogg");
    m_cServer_tbrappogg = p_ContextObject.GetServer("tbrappogg");
    m_oWrInfo_tbrappogg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrappogg",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim = p_ContextObject.GetPhName("tbsvolgim");
    m_cServer_tbsvolgim = p_ContextObject.GetServer("tbsvolgim");
    m_oWrInfo_tbsvolgim = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim_p = p_ContextObject.GetPhName("tbsvolgim_p");
    m_cServer_tbsvolgim_p = p_ContextObject.GetServer("tbsvolgim_p");
    m_oWrInfo_tbsvolgim_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim_p",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_oWrInfo_tbtipnat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipnat",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_oWrInfo_tbtiporisc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc_p = p_ContextObject.GetPhName("tbtiporisc_p");
    m_cServer_tbtiporisc_p = p_ContextObject.GetServer("tbtiporisc_p");
    m_oWrInfo_tbtiporisc_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc_p",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_ae_delegabo = new ardt_ae_delegaboBO(p_ContextObject);
    ardt_saldioro = new ardt_saldioroBO(p_ContextObject);
    ardt_jarantbo = new ardt_jarantboBO(p_ContextObject);
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_ae_anarap",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_ISOAGE = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_descval = "";
    w_daticoll = 0;
    w_PRGIMPRAP = 0;
    w_CODDIP = "";
    w_NOPROT = 0;
    Link_RUMXLFCOKA();
    w_titolo = "";
    w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari (AGE)":"Rapporti Continuativi (AGE)")+" - "+CPLib.LRTrim(w_RAPPORTO)+"-"+CPLib.LRTrim(w_DESCRAP);
    w_mess = "";
    w_mess = "Messaggio\\nSecondo\\nTerzo";
    m_cWv_ardt_ae_delegabo = "";
    m_cWv_ardt_saldioro = "";
    m_cWv_ardt_jarantbo = "";
    m_cWv_ardt_ae_saldianno_rap = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_ae_delegabo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_delegabo);
    l_bResult = l_bResult || ardt_saldioro.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_saldioro);
    l_bResult = l_bResult || ardt_jarantbo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_jarantbo);
    l_bResult = l_bResult || ardt_ae_saldianno_rap.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_TIPOAG = w_TIPOAG;
    o_FLAGLIRE = w_FLAGLIRE;
    o_VALUTA = w_VALUTA;
    ardt_ae_delegabo.SaveDependsOn();
    ardt_saldioro.SaveDependsOn();
    ardt_jarantbo.SaveDependsOn();
    ardt_ae_saldianno_rap.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete start")) {
      Calculation_PQINRWNSNC();
    } else if (CPLib.eq(p_cEvent,"Insert end")) {
      Calculation_WOANKLNERO();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_KKRQXBZJFM();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_QOTHWHLOGM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_QTELNPDLVT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_XJYYPODHBY();
    } else if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_WOANKLNERO();
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPORAP = "";
    }
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
  public boolean Set_ISOAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ISOAGE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ISOAGE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean QBUCLWUNFT_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_TIPOAG,"96") || CPLib.eq(w_TIPOAG,"97");
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_FLAGLIRE = "";
    }
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
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
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_ISOAGE() {
    return CPLib.ne(w_TIPOAG,"96") && CPLib.ne(w_TIPOAG,"97");
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
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE) || CPLib.ne(o_VALUTA,w_VALUTA)) {
      l_bTmpRes = Link_RUMXLFCOKA();
    }
    w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari (AGE)":"Rapporti Continuativi (AGE)")+" - "+CPLib.LRTrim(w_RAPPORTO)+"-"+CPLib.LRTrim(w_DESCRAP);
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE)) {
      Calculation_ONQBRXXLXG();
    }
    w_mess = "Messaggio\\nSecondo\\nTerzo";
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},true);
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_ONQBRXXLXG() {
    w_VALUTA = (CPLib.eq(w_FLAGLIRE,"L")?"018":(CPLib.eq(w_FLAGLIRE,"E")?"242":""));
  }
  void Calculation_QOTHWHLOGM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "JNARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_XJYYPODHBY() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "JNARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_QTELNPDLVT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "JNARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_PQINRWNSNC() {
    arrt_numopecollR l_oRoutine_arrt_numopecoll;
    l_oRoutine_arrt_numopecoll = arrt_numopecollR.Make(m_Ctx,this);
    l_oRoutine_arrt_numopecoll.pTipo = "A";
    l_oRoutine_arrt_numopecoll.Run();
  }
  void Calculation_KKRQXBZJFM() {
    w_CODDIP = w_gCodDip;
  }
  void Calculation_WOANKLNERO() {
    arrt_ae_agg_aetesta_anarapR l_oRoutine_arrt_ae_agg_aetesta_anarap;
    l_oRoutine_arrt_ae_agg_aetesta_anarap = arrt_ae_agg_aetesta_anarapR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta_anarap.pRif = "E";
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_DESCRAP = w_DESCRAP;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_TIPORAP = w_TIPORAP;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_TIPOAG = w_TIPOAG;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_VALUTA = w_VALUTA;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_NOPROT = w_NOPROT;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.Run();
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_ae_anarap","jnarapbo",m_KeyColumns,m_Ctx);
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
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_ISOAGE = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_descval = "";
    w_daticoll = 0;
    w_PRGIMPRAP = 0;
    w_CODDIP = "";
    w_titolo = "";
    w_NOPROT = 0;
    w_mess = "";
    m_cWv_ardt_ae_delegabo = "";
    m_cWv_ardt_saldioro = "";
    m_cWv_ardt_jarantbo = "";
    m_cWv_ardt_ae_saldianno_rap = "";
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
      w_ISOAGE = CPLib.GetProperty(p,"ISOAGE",w_ISOAGE,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_PRGIMPRAP = CPLib.GetProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
      op_PRGIMPRAP = CPLib.GetProperty(p,"op_PRGIMPRAP",0,0);
      w_CODDIP = CPLib.GetProperty(p,"CODDIP",w_CODDIP,0);
      w_NOPROT = CPLib.GetProperty(p,"NOPROT",w_NOPROT,0);
      w_gTelepass = CPLib.GetProperty(p,"gTelepass",w_gTelepass,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_gBrowser = CPLib.GetProperty(p,"gBrowser",w_gBrowser,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_descval = CPLib.GetProperty(p,"descval",w_descval,0);
      w_daticoll = CPLib.GetProperty(p,"daticoll",w_daticoll,0);
      w_titolo = CPLib.GetProperty(p,"titolo",w_titolo,0);
      w_mess = CPLib.GetProperty(p,"mess",w_mess,0);
      m_cWv_ardt_ae_delegabo = CPLib.GetProperty(p,"m_cWv_ardt_ae_delegabo",m_cWv_ardt_ae_delegabo,0);
      m_cWv_ardt_saldioro = CPLib.GetProperty(p,"m_cWv_ardt_saldioro",m_cWv_ardt_saldioro,0);
      m_cWv_ardt_jarantbo = CPLib.GetProperty(p,"m_cWv_ardt_jarantbo",m_cWv_ardt_jarantbo,0);
      m_cWv_ardt_ae_saldianno_rap = CPLib.GetProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
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
    map.put("property.value",zeroSplit.split("jelegabo\u0000false\u0000false\u00001\u00000\u0000ardt_ae_delegabo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("saldioro");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("saldioro",items);
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
    map.put("property.value",zeroSplit.split("saldioro\u0000false\u0000false\u00001\u00000\u0000ardt_saldioro\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("jarantbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("jarantbo",items);
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
    map.put("property.value",zeroSplit.split("jarantbo\u0000false\u0000false\u00001\u00000\u0000ardt_jarantbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("aeannora");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("aeannora",items);
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
    map.put("rd_var.len",zeroSplit.split("2",-1));
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
    map.put("property.value",zeroSplit.split("aeannora\u0000false\u0000false\u00001\u00000\u0000ardt_ae_saldianno_rap\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_ae_anarap",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_ae_anarap",child);
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
    ardt_ae_delegabo = new ardt_ae_delegaboBO(m_Ctx);
    ardt_saldioro = new ardt_saldioroBO(m_Ctx);
    ardt_jarantbo = new ardt_jarantboBO(m_Ctx);
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_ae_anarap",m_Ctx);
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
    if (CPLib.Empty(w_TIPORAP)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPORAP));
      String obblMsgError = m_Ctx.Translate("Tipo Rapporto")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPORAP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPORAP";
      }
    } else if (CPLib.Empty(w_ISOAGE) && QBUCLWUNFT_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_ISOAGE));
      String obblMsgError = m_Ctx.Translate("Per tipo rapporto 96/97")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_ISOAGE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "ISOAGE";
      }
    } else if (CPLib.Empty(w_FLAGLIRE)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_FLAGLIRE));
      String obblMsgError = m_Ctx.Translate("Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_FLAGLIRE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "FLAGLIRE";
      }
    } else if (CPLib.Empty(w_VALUTA)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_VALUTA));
      String obblMsgError = m_Ctx.Translate("Codice Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_VALUTA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "VALUTA";
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
    if (l_bResult && (( ! (ardt_saldioro.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_saldioro)) || ( ! (ardt_saldioro.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_saldioro)))) {
      ardt_saldioro.SetFromContext(m_cWv_ardt_saldioro);
      m_cWv_ardt_saldioro = "_not_empty_";
    }
    if (l_bResult && (ardt_saldioro.m_bLoaded || ardt_saldioro.m_bUpdated)) {
      l_bResult = l_bResult && ardt_saldioro.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_saldioro.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_jarantbo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_jarantbo)) || ( ! (ardt_jarantbo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_jarantbo)))) {
      ardt_jarantbo.SetFromContext(m_cWv_ardt_jarantbo);
      m_cWv_ardt_jarantbo = "_not_empty_";
    }
    if (l_bResult && (ardt_jarantbo.m_bLoaded || ardt_jarantbo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_jarantbo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_jarantbo.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_ae_saldianno_rap.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap)) || ( ! (ardt_ae_saldianno_rap.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap)))) {
      ardt_ae_saldianno_rap.SetFromContext(m_cWv_ardt_ae_saldianno_rap);
      m_cWv_ardt_ae_saldianno_rap = "_not_empty_";
    }
    if (l_bResult && (ardt_ae_saldianno_rap.m_bLoaded || ardt_ae_saldianno_rap.m_bUpdated)) {
      l_bResult = l_bResult && ardt_ae_saldianno_rap.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_ae_saldianno_rap.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_ae_anarap","administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_ae_anarap\\"+p_cState,"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"};
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
    w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_jnarapbo);
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
      w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_jnarapbo);
      op_codazi = m_Ctx.GetCompany();
      op_PRGIMPRAP = w_PRGIMPRAP;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PRGIMPRAP = 0;
    // Inizializzazione delle variabili per DependsOn
    o_TIPOAG = "";
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
    CPLib.PutProperty(p,"ISOAGE",w_ISOAGE,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
    CPLib.PutProperty(p,"op_PRGIMPRAP",op_PRGIMPRAP,0);
    CPLib.PutProperty(p,"CODDIP",w_CODDIP,0);
    CPLib.PutProperty(p,"NOPROT",w_NOPROT,0);
    CPLib.PutProperty(p,"gTelepass",w_gTelepass,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"gBrowser",w_gBrowser,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"descval",w_descval,0);
    CPLib.PutProperty(p,"daticoll",w_daticoll,0);
    CPLib.PutProperty(p,"titolo",w_titolo,0);
    CPLib.PutProperty(p,"mess",w_mess,0);
    if (p_bGetChildren) {
      if (ardt_ae_delegabo.IsUpdated()) {
        m_cWv_ardt_ae_delegabo = ardt_ae_delegabo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_delegabo",m_cWv_ardt_ae_delegabo,0);
    }
    if (p_bGetChildren) {
      if (ardt_saldioro.IsUpdated()) {
        m_cWv_ardt_saldioro = ardt_saldioro.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_saldioro",m_cWv_ardt_saldioro,0);
    }
    if (p_bGetChildren) {
      if (ardt_jarantbo.IsUpdated()) {
        m_cWv_ardt_jarantbo = ardt_jarantbo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_jarantbo",m_cWv_ardt_jarantbo,0);
    }
    if (p_bGetChildren) {
      if (ardt_ae_saldianno_rap.IsUpdated()) {
        m_cWv_ardt_ae_saldianno_rap = ardt_ae_saldianno_rap.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
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
    return "jnarapbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
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
        }
      }
    }
  }
  public boolean ChildExists_ardt_saldioro() {
    if (ardt_saldioro.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_saldioro) || CPLib.IsLoaded(m_cWv_ardt_saldioro))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_saldioro.m_bLoaded)) {
      ardt_saldioro.Blank();
      ardt_saldioro.w_RAPPORTO = w_RAPPORTO;
      ardt_saldioro.Load();
    }
    return ardt_saldioro.m_bLoaded;
  }
  public void CtxLoad_ardt_saldioro() {
    if ( ! (ardt_saldioro.m_lCtxLoaded)) {
      ardt_saldioro.Blank();
    }
    ardt_saldioro.m_lCtxLoaded = true;
    if ( ! (ardt_saldioro.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_saldioro) || CPLib.IsLoaded(m_cWv_ardt_saldioro)) {
        ardt_saldioro.SetFromContext(m_cWv_ardt_saldioro);
        m_cWv_ardt_saldioro = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_saldioro.m_bLoaded)) {
          ardt_saldioro.Blank();
          ardt_saldioro.w_RAPPORTO = w_RAPPORTO;
          ardt_saldioro.Load();
          if ( ! (ardt_saldioro.m_bLoaded)) {
            ardt_saldioro.Initialize();
            ardt_saldioro.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_jarantbo() {
    if (ardt_jarantbo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_jarantbo) || CPLib.IsLoaded(m_cWv_ardt_jarantbo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_jarantbo.m_bLoaded)) {
      ardt_jarantbo.Blank();
      ardt_jarantbo.w_RAPPORTO = w_RAPPORTO;
      ardt_jarantbo.Load();
    }
    return ardt_jarantbo.m_bLoaded;
  }
  public void CtxLoad_ardt_jarantbo() {
    if ( ! (ardt_jarantbo.m_lCtxLoaded)) {
      ardt_jarantbo.Blank();
    }
    ardt_jarantbo.m_lCtxLoaded = true;
    if ( ! (ardt_jarantbo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_jarantbo) || CPLib.IsLoaded(m_cWv_ardt_jarantbo)) {
        ardt_jarantbo.SetFromContext(m_cWv_ardt_jarantbo);
        m_cWv_ardt_jarantbo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_jarantbo.m_bLoaded)) {
          ardt_jarantbo.Blank();
          ardt_jarantbo.w_RAPPORTO = w_RAPPORTO;
          ardt_jarantbo.Load();
          if ( ! (ardt_jarantbo.m_bLoaded)) {
            ardt_jarantbo.Initialize();
            ardt_jarantbo.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_ae_saldianno_rap() {
    if (ardt_ae_saldianno_rap.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap) || CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_ae_saldianno_rap.m_bLoaded)) {
      ardt_ae_saldianno_rap.Blank();
      ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
      ardt_ae_saldianno_rap.Load();
    }
    return ardt_ae_saldianno_rap.m_bLoaded;
  }
  public void CtxLoad_ardt_ae_saldianno_rap() {
    if ( ! (ardt_ae_saldianno_rap.m_lCtxLoaded)) {
      ardt_ae_saldianno_rap.Blank();
    }
    ardt_ae_saldianno_rap.m_lCtxLoaded = true;
    if ( ! (ardt_ae_saldianno_rap.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap) || CPLib.IsLoaded(m_cWv_ardt_ae_saldianno_rap)) {
        ardt_ae_saldianno_rap.SetFromContext(m_cWv_ardt_ae_saldianno_rap);
        m_cWv_ardt_ae_saldianno_rap = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_ae_saldianno_rap.m_bLoaded)) {
          ardt_ae_saldianno_rap.Blank();
          ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_saldianno_rap.Load();
          if ( ! (ardt_ae_saldianno_rap.m_bLoaded)) {
            ardt_ae_saldianno_rap.Initialize();
            ardt_ae_saldianno_rap.SetUpdated();
          }
          CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,ardt_ae_saldianno_rap,new String[]{"TIPRAP"},new String[]{"TIPOAG"},true);
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_ae_delegabo")) {
      CtxLoad_ardt_ae_delegabo();
      return ardt_ae_delegabo;
    }
    if (CPLib.eq(p_cName,"ardt_saldioro")) {
      CtxLoad_ardt_saldioro();
      return ardt_saldioro;
    }
    if (CPLib.eq(p_cName,"ardt_jarantbo")) {
      CtxLoad_ardt_jarantbo();
      return ardt_jarantbo;
    }
    if (CPLib.eq(p_cName,"ardt_ae_saldianno_rap")) {
      CtxLoad_ardt_ae_saldianno_rap();
      return ardt_ae_saldianno_rap;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
