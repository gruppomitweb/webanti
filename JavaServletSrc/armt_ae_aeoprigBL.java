import java.util.*;

public class armt_ae_aeoprigBL extends armt_ae_aeoprigWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_ae_aeoprig";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public CPPhTableWrInfo m_oWrInfo_aeoprig;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_aeoprig;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public CPPhTableWrInfo m_oWrInfo_tbtipnat;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public CPPhTableWrInfo m_oWrInfo_aeopcanc;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"aeoprig"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'COINT':COINT,'TIPOAG':TIPOAG,'IDBASE':IDBASE,'CONNESINT':CONNESINT,'ADATA':ADATA,'ADATARET':ADATARET,'ASPEDITO':ASPEDITO,'AFILE':AFILE,'APROG':APROG,'IDESITO':IDESITO,'DATESITO':DATESITO,'RSPEDITO':RSPEDITO,'COLDFILE':COLDFILE,'COLDPROG':COLDPROG"+FoundlingChildrenList("armt_ae_aeoprig",true)+"}";
  public static final String i_CompleteStateStructure = "{'RAPPORTO':RAPPORTO,'COINT':COINT,'TIPOAG':TIPOAG,'IDBASE':IDBASE,'CONNESINT':CONNESINT,'ADATA':ADATA,'ADATARET':ADATARET,'ASPEDITO':ASPEDITO,'AFILE':AFILE,'APROG':APROG,'AOLDPROG':AOLDPROG,'AOLDFILE':AOLDFILE,'CSPEDITO':CSPEDITO,'CPROG':CPROG,'COLDPROG':COLDPROG,'CFILE':CFILE,'COLDFILE':COLDFILE,'IDRIF':IDRIF,'ADTPRE':ADTPRE,'CDTPRE':CDTPRE,'xragsoc':xragsoc,'CDATA':CDATA,'CDATARET':CDATARET,'NOCODFISC':NOCODFISC,'IDESITO':IDESITO,'DATESITO':DATESITO,'PROGOPX':PROGOPX,'RSPEDITO':RSPEDITO,'dtcanc':dtcanc,'spcanc':spcanc,'filecanc':filecanc,'idcanc':idcanc,'xcfestero':xcfestero,'desctrap':desctrap"+FoundlingChildrenList("armt_ae_aeoprig",true)+"}";
  public static final String i_ItemSequence = "COINT,TIPOAG,IDBASE,CONNESINT,ADATA,ADATARET,ASPEDITO,AFILE,APROG,IDESITO,DATESITO,RSPEDITO,COLDFILE,COLDPROG"+FoundlingChildrenList("armt_ae_aeoprig",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_ae_aeoprig"),new String[][]{new String[]{"COINT","Tipo Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"TIPOAG","","C","2","0","campo","nokey","false","false"},new String[]{"IDBASE","","C","10","0","campo","key1","false","false"},new String[]{"CONNESINT","Codice Delegato","C","16","0","campo","key3","false","false"},new String[]{"ADATA","data Inizio","D","8","0","campo","nokey","false","false"},new String[]{"ADATARET","Data Rettifica","D","8","0","campo","nokey","false","false"},new String[]{"ASPEDITO","Spedito Agenzia Entrate","N","1","0","campo","nokey","false","false"},new String[]{"AFILE","Nome File Spedizione","C","15","0","campo","nokey","false","false"},new String[]{"APROG","Progressivo","C","25","0","campo","nokey","false","false"},new String[]{"IDESITO","Esito AGE","C","8","0","campo","nokey","false","false"},new String[]{"DATESITO","Creazione Esito AGE","D","8","0","campo","nokey","false","false"},new String[]{"RSPEDITO","","N","1","0","campo","nokey","false","false"},new String[]{"COLDFILE","","C","15","0","campo","nokey","false","false"},new String[]{"COLDPROG","","C","25","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_ae_aeoprigBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig",p_ContextObject.GetCompany(),false);
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_oWrInfo_aeoprig = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aeoprig",p_ContextObject.GetCompany());
    m_cVirtName_aeoprig = CPSql.ManipulateTablePhName("aeoprig",m_cServer_aeoprig);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_oWrInfo_tbtipnat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipnat",p_ContextObject.GetCompany());
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_oWrInfo_aeopcanc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aeopcanc",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_ae_aeoprig",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_RAPPORTO = "";
    w_COINT = "";
    w_IDBASE = "";
    w_CONNESINT = "";
    w_ADATA = CPLib.NullDate();
    w_ADATARET = CPLib.NullDate();
    w_AFILE = "";
    w_APROG = "";
    w_AOLDPROG = "";
    w_AOLDFILE = "";
    w_CPROG = "";
    w_COLDPROG = "";
    w_CFILE = "";
    w_COLDFILE = "";
    w_IDRIF = "";
    w_ADTPRE = CPLib.NullDate();
    w_CDTPRE = CPLib.NullDate();
    w_xragsoc = "";
    w_CDATA = CPLib.NullDate();
    w_CDATARET = CPLib.NullDate();
    w_IDESITO = "";
    w_DATESITO = CPLib.NullDate();
    w_PROGOPX = 0;
    w_COLDFILE = "";
    w_COLDPROG = "";
    w_IDBASE = "";
    w_dtcanc = CPLib.NullDate();
    w_spcanc = 0;
    w_filecanc = "";
    w_idcanc = "";
    w_xcfestero = 0;
    w_desctrap = "";
    w_TIPOAG = "98";
    Link_DZWSXMBIHR();
    w_ASPEDITO = 0;
    w_CSPEDITO = 0;
    w_NOCODFISC = "N";
    w_RSPEDITO = 0;
    Link_VQOCGQDTYC();
    w_NOCODFISC = "";
    w_NOCODFISC = (CPLib.eq(w_xcfestero,0)?"N":"S");
    CPExtenderLib.BlankExtendedFields(extendedFields);
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
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_IDBASE = w_IDBASE;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_DZWSXMBIHR() {
    return Link_DZWSXMBIHR("Full");
  }
  protected boolean Link_DZWSXMBIHR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESINT))) {
      String l_OldValue = w_CONNESINT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESINT,"C",16,0),m_cServer_personbo,w_CONNESINT);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CFESTERO from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESINT,"C",70,0),m_cServer_personbo,w_CONNESINT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CFESTERO from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESINT = l_rsLink.GetString("CONNES");
          w_xragsoc = l_rsLink.GetString("RAGSOC");
          w_xcfestero = l_rsLink.GetDouble("CFESTERO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DZWSXMBIHR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESINT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESINT");
          }
          m_cLastWorkVarError = "CONNESINT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DZWSXMBIHR_blank();
    }
    return l_bResult;
  }
  void Link_DZWSXMBIHR_blank() {
    w_CONNESINT = "";
    w_xragsoc = "";
    w_xcfestero = 0;
  }
  protected boolean Link_VQOCGQDTYC() {
    return Link_VQOCGQDTYC("Full");
  }
  protected boolean Link_VQOCGQDTYC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_IDBASE))) {
      String l_OldValue = w_IDBASE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_aeopcanc,w_IDBASE);
      if (m_Ctx.IsSharedTemp("aeopcanc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_aeopcanc,"select IDBASE,IDFILE,IDPROG,SPEDITO,DATARIF from "+m_cPhName_aeopcanc+((m_cPhName_aeopcanc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_IDBASE = l_rsLink.GetString("IDBASE");
          w_filecanc = l_rsLink.GetString("IDFILE");
          w_idcanc = l_rsLink.GetString("IDPROG");
          w_spcanc = l_rsLink.GetDouble("SPEDITO");
          w_dtcanc = l_rsLink.GetDate("DATARIF");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_VQOCGQDTYC_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","IDBASE");
          }
          m_cLastWorkVarError = "IDBASE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_VQOCGQDTYC_blank();
    }
    return l_bResult;
  }
  void Link_VQOCGQDTYC_blank() {
    Link_VQOCGQDTYC_blank("");
  }
  void Link_VQOCGQDTYC_blank(String p_cType) {
    w_filecanc = "";
    w_idcanc = "";
    w_spcanc = 0;
    w_dtcanc = CPLib.NullDate();
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_COINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COINT = p_workVariableValue;
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
  public boolean Set_IDBASE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDBASE = p_workVariableValue;
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IDBASE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESINT = p_workVariableValue;
    l_bResult = Link_DZWSXMBIHR();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESINT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ADATA(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ADATA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ADATARET(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ADATARET = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ASPEDITO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ASPEDITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AFILE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AFILE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_APROG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_APROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDESITO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDESITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATESITO(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATESITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RSPEDITO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RSPEDITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COLDFILE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COLDFILE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COLDPROG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COLDPROG = p_workVariableValue;
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
    if (CPLib.ne(o_IDBASE,w_IDBASE)) {
      l_bTmpRes = Link_VQOCGQDTYC();
    }
    w_NOCODFISC = (CPLib.eq(w_xcfestero,0)?"N":"S");
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_ae_aeoprig","aeoprig",m_KeyColumns,m_Ctx);
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
    w_COINT = "";
    w_TIPOAG = "";
    w_IDBASE = "";
    w_CONNESINT = "";
    w_ADATA = CPLib.NullDate();
    w_ADATARET = CPLib.NullDate();
    w_ASPEDITO = 0;
    w_AFILE = "";
    w_APROG = "";
    w_AOLDPROG = "";
    w_AOLDFILE = "";
    w_CSPEDITO = 0;
    w_CPROG = "";
    w_COLDPROG = "";
    w_CFILE = "";
    w_COLDFILE = "";
    w_IDRIF = "";
    w_ADTPRE = CPLib.NullDate();
    w_CDTPRE = CPLib.NullDate();
    w_xragsoc = "";
    w_CDATA = CPLib.NullDate();
    w_CDATARET = CPLib.NullDate();
    w_NOCODFISC = "";
    w_IDESITO = "";
    w_DATESITO = CPLib.NullDate();
    w_PROGOPX = 0;
    w_RSPEDITO = 0;
    w_COLDFILE = "";
    w_COLDPROG = "";
    w_IDBASE = "";
    w_dtcanc = CPLib.NullDate();
    w_spcanc = 0;
    w_filecanc = "";
    w_idcanc = "";
    w_xcfestero = 0;
    w_NOCODFISC = "";
    w_desctrap = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_COINT = CPLib.GetProperty(p,"COINT",w_COINT,0);
      w_TIPOAG = CPLib.GetProperty(p,"TIPOAG",w_TIPOAG,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      op_IDBASE = CPLib.GetProperty(p,"op_IDBASE","",0);
      w_CONNESINT = CPLib.GetProperty(p,"CONNESINT",w_CONNESINT,0);
      w_ADATA = CPLib.GetProperty(p,"ADATA",w_ADATA,0);
      w_ADATARET = CPLib.GetProperty(p,"ADATARET",w_ADATARET,0);
      w_ASPEDITO = CPLib.GetProperty(p,"ASPEDITO",w_ASPEDITO,0);
      w_AFILE = CPLib.GetProperty(p,"AFILE",w_AFILE,0);
      w_APROG = CPLib.GetProperty(p,"APROG",w_APROG,0);
      w_AOLDPROG = CPLib.GetProperty(p,"AOLDPROG",w_AOLDPROG,0);
      w_AOLDFILE = CPLib.GetProperty(p,"AOLDFILE",w_AOLDFILE,0);
      w_CSPEDITO = CPLib.GetProperty(p,"CSPEDITO",w_CSPEDITO,0);
      w_CPROG = CPLib.GetProperty(p,"CPROG",w_CPROG,0);
      w_COLDPROG = CPLib.GetProperty(p,"COLDPROG",w_COLDPROG,0);
      w_CFILE = CPLib.GetProperty(p,"CFILE",w_CFILE,0);
      w_COLDFILE = CPLib.GetProperty(p,"COLDFILE",w_COLDFILE,0);
      w_IDRIF = CPLib.GetProperty(p,"IDRIF",w_IDRIF,0);
      w_ADTPRE = CPLib.GetProperty(p,"ADTPRE",w_ADTPRE,0);
      w_CDTPRE = CPLib.GetProperty(p,"CDTPRE",w_CDTPRE,0);
      w_CDATA = CPLib.GetProperty(p,"CDATA",w_CDATA,0);
      w_CDATARET = CPLib.GetProperty(p,"CDATARET",w_CDATARET,0);
      w_NOCODFISC = CPLib.GetProperty(p,"NOCODFISC",w_NOCODFISC,0);
      w_IDESITO = CPLib.GetProperty(p,"IDESITO",w_IDESITO,0);
      w_DATESITO = CPLib.GetProperty(p,"DATESITO",w_DATESITO,0);
      w_PROGOPX = CPLib.GetProperty(p,"PROGOPX",w_PROGOPX,0);
      op_PROGOPX = CPLib.GetProperty(p,"op_PROGOPX",0,0);
      w_RSPEDITO = CPLib.GetProperty(p,"RSPEDITO",w_RSPEDITO,0);
      w_xragsoc = CPLib.GetProperty(p,"xragsoc",w_xragsoc,0);
      w_dtcanc = CPLib.GetProperty(p,"dtcanc",w_dtcanc,0);
      w_spcanc = CPLib.GetProperty(p,"spcanc",w_spcanc,0);
      w_filecanc = CPLib.GetProperty(p,"filecanc",w_filecanc,0);
      w_idcanc = CPLib.GetProperty(p,"idcanc",w_idcanc,0);
      w_xcfestero = CPLib.GetProperty(p,"xcfestero",w_xcfestero,0);
      w_desctrap = CPLib.GetProperty(p,"desctrap",w_desctrap,0);
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
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC","CFESTERO"});
    map.put("rd_var",new String[]{"w_CONNESINT","w_xragsoc","w_xcfestero"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Delegato\u0000Ragione Sociale\u0000Codice Fiscale Estero",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key3\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("aeopcanc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("aeopcanc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE","IDFILE","IDPROG","SPEDITO","DATARIF"});
    map.put("rd_var",new String[]{"w_IDBASE","w_filecanc","w_idcanc","w_spcanc","w_dtcanc"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000N\u0000D",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("10\u000015\u000025\u00001\u00008",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("aeopcanc\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_ae_aeoprig",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_ae_aeoprig",child);
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
    m_MNTs = CPLib.MNTChilds("armt_ae_aeoprig",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
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
      l_Keys = new String[]{"armt_ae_aeoprig"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_ae_aeoprig\\"+p_cState};
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
      m_cLastMsgError = "Impossibile modificare (Dati storici)";
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
      m_cLastMsgError = "Impossibile cancellare (Dati storici)";
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
      m_cLastMsgError = "Impossibile inserire (Dati storici)";
    }
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PRGAEOPEXTR"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aeoprig);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PROGOPX = m_Ctx.AskTableProg(w_PROGOPX,15,op_PROGOPX,"PROGAED"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aeoprig);
    op_codazi = m_Ctx.GetCompany();
    op_IDBASE = w_IDBASE;
    o_IDBASE = w_IDBASE;
    op_PROGOPX = w_PROGOPX;
    o_IDBASE = w_IDBASE;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    boolean l_b1;
    l_b1 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PRGAEOPEXTR"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aeoprig);
      op_codazi = m_Ctx.GetCompany();
      op_IDBASE = w_IDBASE;
    }
    if (l_b1) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PROGOPX = m_Ctx.AskTableProg(w_PROGOPX,15,op_PROGOPX,"PROGAED"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aeoprig);
      op_PROGOPX = w_PROGOPX;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_IDBASE = "";
    op_PROGOPX = 0;
    op_IDBASE = "";
    // Inizializzazione delle variabili per DependsOn
    o_IDBASE = "";
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
    CPLib.PutProperty(p,"COINT",w_COINT,0);
    CPLib.PutProperty(p,"TIPOAG",w_TIPOAG,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"op_IDBASE",op_IDBASE,0);
    CPLib.PutProperty(p,"CONNESINT",w_CONNESINT,0);
    CPLib.PutProperty(p,"ADATA",w_ADATA,0);
    CPLib.PutProperty(p,"ADATARET",w_ADATARET,0);
    CPLib.PutProperty(p,"ASPEDITO",w_ASPEDITO,0);
    CPLib.PutProperty(p,"AFILE",w_AFILE,0);
    CPLib.PutProperty(p,"APROG",w_APROG,0);
    CPLib.PutProperty(p,"AOLDPROG",w_AOLDPROG,0);
    CPLib.PutProperty(p,"AOLDFILE",w_AOLDFILE,0);
    CPLib.PutProperty(p,"CSPEDITO",w_CSPEDITO,0);
    CPLib.PutProperty(p,"CPROG",w_CPROG,0);
    CPLib.PutProperty(p,"COLDPROG",w_COLDPROG,0);
    CPLib.PutProperty(p,"CFILE",w_CFILE,0);
    CPLib.PutProperty(p,"COLDFILE",w_COLDFILE,0);
    CPLib.PutProperty(p,"IDRIF",w_IDRIF,0);
    CPLib.PutProperty(p,"ADTPRE",w_ADTPRE,0);
    CPLib.PutProperty(p,"CDTPRE",w_CDTPRE,0);
    CPLib.PutProperty(p,"CDATA",w_CDATA,0);
    CPLib.PutProperty(p,"CDATARET",w_CDATARET,0);
    CPLib.PutProperty(p,"NOCODFISC",w_NOCODFISC,0);
    CPLib.PutProperty(p,"IDESITO",w_IDESITO,0);
    CPLib.PutProperty(p,"DATESITO",w_DATESITO,0);
    CPLib.PutProperty(p,"PROGOPX",w_PROGOPX,0);
    CPLib.PutProperty(p,"op_PROGOPX",op_PROGOPX,0);
    CPLib.PutProperty(p,"RSPEDITO",w_RSPEDITO,0);
    CPLib.PutProperty(p,"xragsoc",w_xragsoc,0);
    CPLib.PutProperty(p,"dtcanc",w_dtcanc,0);
    CPLib.PutProperty(p,"spcanc",w_spcanc,0);
    CPLib.PutProperty(p,"filecanc",w_filecanc,0);
    CPLib.PutProperty(p,"idcanc",w_idcanc,0);
    CPLib.PutProperty(p,"xcfestero",w_xcfestero,0);
    CPLib.PutProperty(p,"desctrap",w_desctrap,0);
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
    return "aeoprig"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
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
    oneAutoNum.add("PRGAEOPEXTR");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PROGOPX");
    oneAutoNum.add("PROGAED");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  CallerBRImpl GetChild(String p_cName) {
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
