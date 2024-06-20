import java.util.*;

public class opemt_scarti_importBL extends opemt_scarti_importWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "opemt_scarti_import";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_scarti_import;
  public String m_cServer_scarti_import;
  public CPPhTableWrInfo m_oWrInfo_scarti_import;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_scarti_import;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tipilegbo_m;
  public String m_cServer_tipilegbo_m;
  public CPPhTableWrInfo m_oWrInfo_tipilegbo_m;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"scarti_import"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IMPPROG':IMPPROG,'CODSTUDIO':CODSTUDIO,'CODDIPE':CODDIPE,'NUMPROG':NUMPROG,'DATAOPE':DATAOPE,'FLAGFRAZ':FLAGFRAZ,'CAUOPER':CAUOPER,'CONNESREAL':CONNESREAL,'CONNESCLI':CONNESCLI,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'DATAREG':DATAREG,'STATOREG':STATOREG,'DATARETT':DATARETT,'VALUTA':VALUTA,'IMPORTO':IMPORTO,'CONTANTI':CONTANTI,'MEZPAG':MEZPAG,'PRESTAZ':PRESTAZ,'RAGIO':RAGIO,'MODSVOL':MODSVOL,'AREAGEO':AREAGEO,'TIPO':TIPO,'AMMONT':AMMONT,'DURAT':DURAT,'RAREA':RAREA,'RRAGIO':RRAGIO,'RCOMP':RCOMP,'RTIPO':RTIPO,'RFREQ':RFREQ,'RIMP':RIMP,'TIPOOPER':TIPOOPER,'TXTERR':TXTERR,'DESPUNTO':DESPUNTO,'IMPPROG13':IMPPROG13"+FoundlingChildrenList("opemt_scarti_import",true)+"}";
  public static final String i_CompleteStateStructure = "{'IMPPROG':IMPPROG,'CODSTUDIO':CODSTUDIO,'CODDIPE':CODDIPE,'NUMPROG':NUMPROG,'DATAOPE':DATAOPE,'FLAGFRAZ':FLAGFRAZ,'CAUOPER':CAUOPER,'CONNESREAL':CONNESREAL,'CONNESCLI':CONNESCLI,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'DATAREG':DATAREG,'STATOREG':STATOREG,'DATARETT':DATARETT,'VALUTA':VALUTA,'IMPORTO':IMPORTO,'CONTANTI':CONTANTI,'MEZPAG':MEZPAG,'PRESTAZ':PRESTAZ,'RAGIO':RAGIO,'MODSVOL':MODSVOL,'AREAGEO':AREAGEO,'TIPO':TIPO,'AMMONT':AMMONT,'DURAT':DURAT,'RAREA':RAREA,'RRAGIO':RRAGIO,'RCOMP':RCOMP,'RTIPO':RTIPO,'RFREQ':RFREQ,'RIMP':RIMP,'xdestipope':xdestipope,'TIPOOPER':TIPOOPER,'RAGSOCexec':RAGSOCexec,'RAGSOCreal':RAGSOCreal,'RAGSOCben':RAGSOCben,'RAGSOCaltro':RAGSOCaltro,'TXTERR':TXTERR,'DESPUNTO':DESPUNTO,'IMPPROG13':IMPPROG13"+FoundlingChildrenList("opemt_scarti_import",true)+"}";
  public static final String i_ItemSequence = "IMPPROG,CODSTUDIO,CODDIPE,NUMPROG,DATAOPE,FLAGFRAZ,CAUOPER,CONNESREAL,CONNESCLI,CONNESBEN,CONNALTRO,DATAREG,STATOREG,DATARETT,VALUTA,IMPORTO,CONTANTI,MEZPAG,PRESTAZ,RAGIO,MODSVOL,AREAGEO,TIPO,AMMONT,DURAT,RAREA,RRAGIO,RCOMP,RTIPO,RFREQ,RIMP,TIPOOPER,TXTERR,DESPUNTO,IMPPROG13"+FoundlingChildrenList("opemt_scarti_import",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("opemt_scarti_import"),new String[][]{new String[]{"IMPPROG","ID SCarto","N","10","0","campo","key1","false","false"},new String[]{"CODSTUDIO","Codice Intermediario","C","11","0","campo","nokey","false","false"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"NUMPROG","ID Operazione","C","11","0","campo","nokey","false","false"},new String[]{"DATAOPE","Data Operazione","C","8","0","campo","nokey","false","false"},new String[]{"FLAGFRAZ","Frazionata / Multiple / Coneessa","C","1","0","campo","nokey","false","false"},new String[]{"CAUOPER","Causale Operazione","C","4","0","campo","nokey","false","false"},new String[]{"CONNESREAL","Cliente","C","11","0","campo","nokey","false","false"},new String[]{"CONNESCLI","Escutore","C","11","0","campo","nokey","false","false"},new String[]{"CONNESBEN","Soggetto Servito","C","11","0","campo","nokey","false","false"},new String[]{"CONNALTRO","Controparte","C","11","0","campo","nokey","false","false"},new String[]{"DATAREG","Data Registrazione","C","8","0","campo","nokey","false","false"},new String[]{"STATOREG","Stato Registrazione","C","1","0","campo","nokey","false","false"},new String[]{"DATARETT","Data Rettifica","C","8","0","campo","nokey","false","false"},new String[]{"VALUTA","Valuta","C","3","0","campo","nokey","false","false"},new String[]{"IMPORTO","Importo","N","15","2","campo","nokey","false","false"},new String[]{"CONTANTI","Contanti","N","15","2","campo","nokey","false","false"},new String[]{"MEZPAG","Mezzo Pagamento / Origine","C","30","0","campo","nokey","false","false"},new String[]{"PRESTAZ","Prestazione","C","30","0","campo","nokey","false","false"},new String[]{"RAGIO","Ragionevolezza","C","5","0","campo","nokey","false","false"},new String[]{"MODSVOL","Modalità Svolgimento","C","5","0","campo","nokey","false","false"},new String[]{"AREAGEO","Area Geografica","C","3","0","campo","nokey","false","false"},new String[]{"TIPO","Tipo Rischio","C","3","0","campo","nokey","false","false"},new String[]{"AMMONT","Ammonater (Rischio)","C","2","0","campo","nokey","false","false"},new String[]{"DURAT","Durata (Rischio)","C","2","0","campo","nokey","false","false"},new String[]{"RAREA","Rischio Area","N","3","0","campo","nokey","false","false"},new String[]{"RRAGIO","Rischio Ragionevolezza","N","3","0","campo","nokey","false","false"},new String[]{"RCOMP","Rischio Comportamento","N","3","0","campo","nokey","false","false"},new String[]{"RTIPO","Rischio Tipologia","N","3","0","campo","nokey","false","false"},new String[]{"RFREQ","Rischio Frequenza","N","3","0","campo","nokey","false","false"},new String[]{"RIMP","Rischio Importo","N","3","0","campo","nokey","false","false"},new String[]{"TIPOOPER","Tipo Operatore","C","2","0","campo","nokey","false","false"},new String[]{"TXTERR","Errori Rilevati","M","10","0","campo","nokey","false","false"},new String[]{"DESPUNTO","Descrizione Punto","C","80","0","campo","nokey","false","false"},new String[]{"IMPPROG13","Progressivo Import con Anno","C","13","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public opemt_scarti_importBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_scarti_import = p_ContextObject.GetPhName("scarti_import",p_ContextObject.GetCompany(),false);
    m_cServer_scarti_import = p_ContextObject.GetServer("scarti_import");
    m_oWrInfo_scarti_import = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"scarti_import",p_ContextObject.GetCompany());
    m_cVirtName_scarti_import = CPSql.ManipulateTablePhName("scarti_import",m_cServer_scarti_import);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tipilegbo_m = p_ContextObject.GetPhName("tipilegbo_m");
    m_cServer_tipilegbo_m = p_ContextObject.GetServer("tipilegbo_m");
    m_oWrInfo_tipilegbo_m = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tipilegbo_m",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("opemt_scarti_import",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IMPPROG = 0;
    w_CODSTUDIO = "";
    w_CODDIPE = "";
    w_NUMPROG = "";
    w_DATAOPE = "";
    w_FLAGFRAZ = "";
    w_CAUOPER = "";
    w_CONNESREAL = "";
    w_CONNESCLI = "";
    w_CONNESBEN = "";
    w_CONNALTRO = "";
    w_DATAREG = "";
    w_STATOREG = "";
    w_DATARETT = "";
    w_VALUTA = "";
    w_IMPORTO = 0;
    w_CONTANTI = 0;
    w_MEZPAG = "";
    w_PRESTAZ = "";
    w_RAGIO = "";
    w_MODSVOL = "";
    w_AREAGEO = "";
    w_TIPO = "";
    w_AMMONT = "";
    w_DURAT = "";
    w_RAREA = 0;
    w_RRAGIO = 0;
    w_RCOMP = 0;
    w_RTIPO = 0;
    w_RFREQ = 0;
    w_RIMP = 0;
    w_xdestipope = "";
    w_TIPOOPER = "";
    w_RAGSOCexec = "";
    w_RAGSOCreal = "";
    w_RAGSOCben = "";
    w_RAGSOCaltro = "";
    w_TXTERR = "";
    w_DESPUNTO = "";
    w_IMPPROG13 = "";
    Link_TRIYBQSKCQ();
    Link_DHRGEXYQZL();
    Link_SQWOYVEXHD();
    Link_SFOARTDXXG();
    Link_KYUSCDSEVM();
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
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete start")) {
      Calculation_VRSXTLNAAI();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_TRIYBQSKCQ() {
    return Link_TRIYBQSKCQ("Full");
  }
  protected boolean Link_TRIYBQSKCQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESREAL))) {
      String l_OldValue = w_CONNESREAL;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESREAL,"C",11,0),m_cServer_personbo,w_CONNESREAL);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"PARTIVA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESREAL,"C",70,0),m_cServer_personbo,w_CONNESREAL);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESREAL = l_rsLink.GetString("PARTIVA");
          w_RAGSOCreal = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_TRIYBQSKCQ_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESREAL");
          }
          m_cLastWorkVarError = "CONNESREAL";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_TRIYBQSKCQ_blank();
    }
    return l_bResult;
  }
  void Link_TRIYBQSKCQ_blank() {
    Link_TRIYBQSKCQ_blank("");
  }
  void Link_TRIYBQSKCQ_blank(String p_cType) {
    w_RAGSOCreal = "";
  }
  protected boolean Link_DHRGEXYQZL() {
    return Link_DHRGEXYQZL("Full");
  }
  protected boolean Link_DHRGEXYQZL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESCLI))) {
      String l_OldValue = w_CONNESCLI;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"C",11,0),m_cServer_personbo,w_CONNESCLI);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"PARTIVA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"C",70,0),m_cServer_personbo,w_CONNESCLI);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESCLI = l_rsLink.GetString("PARTIVA");
          w_RAGSOCexec = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_DHRGEXYQZL_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESCLI");
          }
          m_cLastWorkVarError = "CONNESCLI";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DHRGEXYQZL_blank();
    }
    return l_bResult;
  }
  void Link_DHRGEXYQZL_blank() {
    Link_DHRGEXYQZL_blank("");
  }
  void Link_DHRGEXYQZL_blank(String p_cType) {
    w_RAGSOCexec = "";
  }
  protected boolean Link_SQWOYVEXHD() {
    return Link_SQWOYVEXHD("Full");
  }
  protected boolean Link_SQWOYVEXHD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESBEN))) {
      String l_OldValue = w_CONNESBEN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"C",11,0),m_cServer_personbo,w_CONNESBEN);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"PARTIVA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESBEN = l_rsLink.GetString("PARTIVA");
          w_RAGSOCben = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_SQWOYVEXHD_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESBEN");
          }
          m_cLastWorkVarError = "CONNESBEN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SQWOYVEXHD_blank();
    }
    return l_bResult;
  }
  void Link_SQWOYVEXHD_blank() {
    Link_SQWOYVEXHD_blank("");
  }
  void Link_SQWOYVEXHD_blank(String p_cType) {
    w_RAGSOCben = "";
  }
  protected boolean Link_SFOARTDXXG() {
    return Link_SFOARTDXXG("Full");
  }
  protected boolean Link_SFOARTDXXG(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNALTRO))) {
      String l_OldValue = w_CONNALTRO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNALTRO,"C",11,0),m_cServer_personbo,w_CONNALTRO);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"PARTIVA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNALTRO,"C",70,0),m_cServer_personbo,w_CONNALTRO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select PARTIVA,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNALTRO = l_rsLink.GetString("PARTIVA");
          w_RAGSOCaltro = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_SFOARTDXXG_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNALTRO");
          }
          m_cLastWorkVarError = "CONNALTRO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SFOARTDXXG_blank();
    }
    return l_bResult;
  }
  void Link_SFOARTDXXG_blank() {
    Link_SFOARTDXXG_blank("");
  }
  void Link_SFOARTDXXG_blank(String p_cType) {
    w_RAGSOCaltro = "";
  }
  protected boolean Link_KYUSCDSEVM() {
    return Link_KYUSCDSEVM("Full");
  }
  protected boolean Link_KYUSCDSEVM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOOPER))) {
      String l_OldValue = w_TIPOOPER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOOPER,"C",2,0),m_cServer_tipilegbo_m,w_TIPOOPER);
      if (m_Ctx.IsSharedTemp("tipilegbo_m")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tipilegbo_m,"select TIPLEG,DESCRIZ from "+m_cPhName_tipilegbo_m+((m_cPhName_tipilegbo_m).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPLEG"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOOPER,"C",254,0),m_cServer_tipilegbo_m,w_TIPOOPER);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tipilegbo_m,"select TIPLEG,DESCRIZ from "+m_cPhName_tipilegbo_m+((m_cPhName_tipilegbo_m).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOOPER = l_rsLink.GetString("TIPLEG");
          w_xdestipope = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_KYUSCDSEVM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOOPER = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOOPER");
          }
          m_cLastWorkVarError = "TIPOOPER";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_KYUSCDSEVM_blank();
    }
    return l_bResult;
  }
  void Link_KYUSCDSEVM_blank() {
    w_TIPOOPER = "";
    w_xdestipope = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_IMPPROG(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPPROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODSTUDIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODSTUDIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODDIPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMPROG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMPROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLAGFRAZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGFRAZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAUOPER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAUOPER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESREAL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESREAL = p_workVariableValue;
    l_bResult = Link_TRIYBQSKCQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESREAL = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESCLI = p_workVariableValue;
    l_bResult = Link_DHRGEXYQZL();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESCLI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESBEN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESBEN = p_workVariableValue;
    l_bResult = Link_SQWOYVEXHD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESBEN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNALTRO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNALTRO = p_workVariableValue;
    l_bResult = Link_SFOARTDXXG();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNALTRO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAREG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAREG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_STATOREG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_STATOREG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARETT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATARETT = p_workVariableValue;
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
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPORTO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONTANTI(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONTANTI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MEZPAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MEZPAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PRESTAZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PRESTAZ = p_workVariableValue;
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
  public boolean Set_TIPOOPER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOOPER = p_workVariableValue;
    l_bResult = Link_KYUSCDSEVM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOOPER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TXTERR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TXTERR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESPUNTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESPUNTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPPROG13(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPPROG13 = p_workVariableValue;
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
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_VRSXTLNAAI() {
    opert_del_scarti_contanteR l_oRoutine_opert_del_scarti_contante;
    l_oRoutine_opert_del_scarti_contante = opert_del_scarti_contanteR.Make(m_Ctx,this);
    l_oRoutine_opert_del_scarti_contante.pProg = w_IMPPROG13;
    l_oRoutine_opert_del_scarti_contante.Run();
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
  public final static String[] m_KeyColumns = {"IMPPROG"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("opemt_scarti_import","scarti_import",m_KeyColumns,m_Ctx);
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
    w_IMPPROG = 0;
    w_CODSTUDIO = "";
    w_CODDIPE = "";
    w_NUMPROG = "";
    w_DATAOPE = "";
    w_FLAGFRAZ = "";
    w_CAUOPER = "";
    w_CONNESREAL = "";
    w_CONNESCLI = "";
    w_CONNESBEN = "";
    w_CONNALTRO = "";
    w_DATAREG = "";
    w_STATOREG = "";
    w_DATARETT = "";
    w_VALUTA = "";
    w_IMPORTO = 0;
    w_CONTANTI = 0;
    w_MEZPAG = "";
    w_PRESTAZ = "";
    w_RAGIO = "";
    w_MODSVOL = "";
    w_AREAGEO = "";
    w_TIPO = "";
    w_AMMONT = "";
    w_DURAT = "";
    w_RAREA = 0;
    w_RRAGIO = 0;
    w_RCOMP = 0;
    w_RTIPO = 0;
    w_RFREQ = 0;
    w_RIMP = 0;
    w_xdestipope = "";
    w_TIPOOPER = "";
    w_RAGSOCexec = "";
    w_RAGSOCreal = "";
    w_RAGSOCben = "";
    w_RAGSOCaltro = "";
    w_TXTERR = "";
    w_DESPUNTO = "";
    w_IMPPROG13 = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_IMPPROG = CPLib.GetProperty(p,"IMPPROG",w_IMPPROG,0);
      w_CODSTUDIO = CPLib.GetProperty(p,"CODSTUDIO",w_CODSTUDIO,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      w_DATAOPE = CPLib.GetProperty(p,"DATAOPE",w_DATAOPE,0);
      w_FLAGFRAZ = CPLib.GetProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
      w_CAUOPER = CPLib.GetProperty(p,"CAUOPER",w_CAUOPER,0);
      w_CONNESREAL = CPLib.GetProperty(p,"CONNESREAL",w_CONNESREAL,0);
      w_CONNESCLI = CPLib.GetProperty(p,"CONNESCLI",w_CONNESCLI,0);
      w_CONNESBEN = CPLib.GetProperty(p,"CONNESBEN",w_CONNESBEN,0);
      w_CONNALTRO = CPLib.GetProperty(p,"CONNALTRO",w_CONNALTRO,0);
      w_DATAREG = CPLib.GetProperty(p,"DATAREG",w_DATAREG,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_DATARETT = CPLib.GetProperty(p,"DATARETT",w_DATARETT,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_IMPORTO = CPLib.GetProperty(p,"IMPORTO",w_IMPORTO,0);
      w_CONTANTI = CPLib.GetProperty(p,"CONTANTI",w_CONTANTI,0);
      w_MEZPAG = CPLib.GetProperty(p,"MEZPAG",w_MEZPAG,0);
      w_PRESTAZ = CPLib.GetProperty(p,"PRESTAZ",w_PRESTAZ,0);
      w_RAGIO = CPLib.GetProperty(p,"RAGIO",w_RAGIO,0);
      w_MODSVOL = CPLib.GetProperty(p,"MODSVOL",w_MODSVOL,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_TIPO = CPLib.GetProperty(p,"TIPO",w_TIPO,0);
      w_AMMONT = CPLib.GetProperty(p,"AMMONT",w_AMMONT,0);
      w_DURAT = CPLib.GetProperty(p,"DURAT",w_DURAT,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_RRAGIO = CPLib.GetProperty(p,"RRAGIO",w_RRAGIO,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_RTIPO = CPLib.GetProperty(p,"RTIPO",w_RTIPO,0);
      w_RFREQ = CPLib.GetProperty(p,"RFREQ",w_RFREQ,0);
      w_RIMP = CPLib.GetProperty(p,"RIMP",w_RIMP,0);
      w_TIPOOPER = CPLib.GetProperty(p,"TIPOOPER",w_TIPOOPER,0);
      w_TXTERR = CPLib.GetProperty(p,"TXTERR",w_TXTERR,0);
      w_DESPUNTO = CPLib.GetProperty(p,"DESPUNTO",w_DESPUNTO,0);
      w_IMPPROG13 = CPLib.GetProperty(p,"IMPPROG13",w_IMPPROG13,0);
      w_xdestipope = CPLib.GetProperty(p,"xdestipope",w_xdestipope,0);
      w_RAGSOCexec = CPLib.GetProperty(p,"RAGSOCexec",w_RAGSOCexec,0);
      w_RAGSOCreal = CPLib.GetProperty(p,"RAGSOCreal",w_RAGSOCreal,0);
      w_RAGSOCben = CPLib.GetProperty(p,"RAGSOCben",w_RAGSOCben,0);
      w_RAGSOCaltro = CPLib.GetProperty(p,"RAGSOCaltro",w_RAGSOCaltro,0);
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
    map.put("rd_field",new String[]{"PARTIVA","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESREAL","w_RAGSOCreal"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Cliente\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000true\u00002\u00000\u0000opemt_personbo\u0000true\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"PARTIVA","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESCLI","w_RAGSOCexec"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Escutore\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"PARTIVA","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESBEN","w_RAGSOCben"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Soggetto Servito\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000true\u00001\u00000\u0000opemt_personbo\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"PARTIVA","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNALTRO","w_RAGSOCaltro"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Controparte\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000true\u00002\u00000\u0000opemt_personbo\u0000true\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tipilegbo_m");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tipilegbo_m",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TIPLEG","DESCRIZ"});
    map.put("rd_var",new String[]{"w_TIPOOPER","w_xdestipope"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u0000254",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Operatore\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tipilegbo_m\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Operatore\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("opemt_scarti_import",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("opemt_scarti_import",child);
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
    m_MNTs = CPLib.MNTChilds("opemt_scarti_import",m_Ctx);
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
      l_Keys = new String[]{"opemt_scarti_import"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"opemt_scarti_import\\"+p_cState};
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
    CPLib.PutProperty(p,"IMPPROG",w_IMPPROG,0);
    CPLib.PutProperty(p,"CODSTUDIO",w_CODSTUDIO,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"DATAOPE",w_DATAOPE,0);
    CPLib.PutProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
    CPLib.PutProperty(p,"CAUOPER",w_CAUOPER,0);
    CPLib.PutProperty(p,"CONNESREAL",w_CONNESREAL,0);
    CPLib.PutProperty(p,"CONNESCLI",w_CONNESCLI,0);
    CPLib.PutProperty(p,"CONNESBEN",w_CONNESBEN,0);
    CPLib.PutProperty(p,"CONNALTRO",w_CONNALTRO,0);
    CPLib.PutProperty(p,"DATAREG",w_DATAREG,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"DATARETT",w_DATARETT,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"IMPORTO",w_IMPORTO,0);
    CPLib.PutProperty(p,"CONTANTI",w_CONTANTI,0);
    CPLib.PutProperty(p,"MEZPAG",w_MEZPAG,0);
    CPLib.PutProperty(p,"PRESTAZ",w_PRESTAZ,0);
    CPLib.PutProperty(p,"RAGIO",w_RAGIO,0);
    CPLib.PutProperty(p,"MODSVOL",w_MODSVOL,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"TIPO",w_TIPO,0);
    CPLib.PutProperty(p,"AMMONT",w_AMMONT,0);
    CPLib.PutProperty(p,"DURAT",w_DURAT,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"RRAGIO",w_RRAGIO,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"RTIPO",w_RTIPO,0);
    CPLib.PutProperty(p,"RFREQ",w_RFREQ,0);
    CPLib.PutProperty(p,"RIMP",w_RIMP,0);
    CPLib.PutProperty(p,"TIPOOPER",w_TIPOOPER,0);
    CPLib.PutProperty(p,"TXTERR",w_TXTERR,0);
    CPLib.PutProperty(p,"DESPUNTO",w_DESPUNTO,0);
    CPLib.PutProperty(p,"IMPPROG13",w_IMPPROG13,0);
    CPLib.PutProperty(p,"xdestipope",w_xdestipope,0);
    CPLib.PutProperty(p,"RAGSOCexec",w_RAGSOCexec,0);
    CPLib.PutProperty(p,"RAGSOCreal",w_RAGSOCreal,0);
    CPLib.PutProperty(p,"RAGSOCben",w_RAGSOCben,0);
    CPLib.PutProperty(p,"RAGSOCaltro",w_RAGSOCaltro,0);
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
    return "scarti_import"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("IMPPROG","N",10,0));
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
  CallerBRImpl GetChild(String p_cName) {
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
