import java.util.*;

public class armt_xraziobo_aggBL extends armt_xraziobo_aggWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_xraziobo_agg";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_xraziobo_agg;
  public String m_cServer_xraziobo_agg;
  public CPPhTableWrInfo m_oWrInfo_xraziobo_agg;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_xraziobo_agg;
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
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"xraziobo_agg"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IDBASE':IDBASE,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CATEG04':CATEG04,'CATEG05':CATEG05,'FLAGFRAUD':FLAGFRAUD,'SV58724':SV58724,'SV58726SCA':SV58726SCA,'SV58726SA':SV58726SA,'SV58726PISP':SV58726PISP,'C_COGNOME':C_COGNOME,'C_NOME':C_NOME,'SOSPAGAM':SOSPAGAM"+FoundlingChildrenList("armt_xraziobo_agg",true)+"}";
  public static final String i_CompleteStateStructure = "{'IDBASE':IDBASE,'SEGNO':SEGNO,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CATEG04':CATEG04,'CATEG05':CATEG05,'xC1DESCRI':xC1DESCRI,'xC2DESCRI':xC2DESCRI,'xC3DESCRI':xC3DESCRI,'xC4DESCRI':xC4DESCRI,'xC5DESCRI':xC5DESCRI,'CATEGORIA':CATEGORIA,'FLAGFRAUD':FLAGFRAUD,'SV58724':SV58724,'SV58726SCA':SV58726SCA,'SV58726SA':SV58726SA,'SV58726PISP':SV58726PISP,'C_COGNOME':C_COGNOME,'C_NOME':C_NOME,'SOSPAGAM':SOSPAGAM"+FoundlingChildrenList("armt_xraziobo_agg",true)+"}";
  public static final String i_ItemSequence = "IDBASE,CATEG01,CATEG02,CATEG03,CATEG04,CATEG05,FLAGFRAUD,SV58724,SV58726SCA,SV58726SA,SV58726PISP,C_COGNOME,C_NOME,SOSPAGAM"+FoundlingChildrenList("armt_xraziobo_agg",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_xraziobo_agg"),new String[][]{new String[]{"IDBASE","Codice Operazione","C","10","0","campo","key1","false","false"},new String[]{"CATEG01","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG02","Categoria 2","C","2","0","campo","nokey","false","false"},new String[]{"CATEG03","Categoria 3","C","2","0","campo","nokey","false","false"},new String[]{"CATEG04","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG05","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"FLAGFRAUD","Operazione Fraudolenta","N","1","0","campo","nokey","false","false"},new String[]{"SV58724","SV 58724 Modalità Bonifici","C","2","0","campo","nokey","false","false"},new String[]{"SV58726SCA","Autorizzazione Forte (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"SV58726SA","SV58726  Schema di addebito","C","3","0","campo","nokey","false","false"},new String[]{"SV58726PISP","SV58726 Modalità PISP","C","3","0","campo","nokey","false","false"},new String[]{"C_COGNOME","Cognome Beneficiario per SOS","C","50","0","campo","nokey","false","false"},new String[]{"C_NOME","Nome Beneficiario per SOS","C","30","0","campo","nokey","false","false"},new String[]{"SOSPAGAM","Mezzo di Pagamento","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_xraziobo_aggBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_xraziobo_agg = p_ContextObject.GetPhName("xraziobo_agg",p_ContextObject.GetCompany(),false);
    m_cServer_xraziobo_agg = p_ContextObject.GetServer("xraziobo_agg");
    m_oWrInfo_xraziobo_agg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"xraziobo_agg",p_ContextObject.GetCompany());
    m_cVirtName_xraziobo_agg = CPSql.ManipulateTablePhName("xraziobo_agg",m_cServer_xraziobo_agg);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
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
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_xraziobo_agg",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_IDBASE = "";
    w_SEGNO = "";
    w_CATEG01 = "";
    w_CATEG02 = "";
    w_CATEG03 = "";
    w_CATEG04 = "";
    w_CATEG05 = "";
    w_xC1DESCRI = "";
    w_xC2DESCRI = "";
    w_xC3DESCRI = "";
    w_xC4DESCRI = "";
    w_xC5DESCRI = "";
    w_SV58724 = "";
    w_SV58726SCA = "";
    w_SV58726SA = "";
    w_SV58726PISP = "";
    w_C_COGNOME = "";
    w_C_NOME = "";
    w_SOSPAGAM = "";
    Link_CANUTVNGFD();
    Link_IXGRJLAKIQ();
    Link_NKIXCWZJHO();
    Link_JQLGHMLOKO();
    Link_QVBZSFMTVP();
    w_CATEGORIA = "";
    w_CATEGORIA = fwfn_calc_categoriaR.Make(m_Ctx,this).Run(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
    w_FLAGFRAUD = 0;
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
    o_CATEG01 = w_CATEG01;
    o_CATEG02 = w_CATEG02;
    o_CATEG03 = w_CATEG03;
    o_CATEG04 = w_CATEG04;
    o_CATEG05 = w_CATEG05;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_CANUTVNGFD() {
    return Link_CANUTVNGFD("Full");
  }
  protected boolean Link_CANUTVNGFD(String p_cType) {
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
      if (m_Ctx.IsSharedTemp("tbcateg01")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg01,"select C1CODICE,C1DESCRI from "+m_cPhName_tbcateg01+((m_cPhName_tbcateg01).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C1CODICE"+l_cCurrentKey+l_cWhere);
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
          Link_CANUTVNGFD_blank();
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
      Link_CANUTVNGFD_blank();
    }
    return l_bResult;
  }
  void Link_CANUTVNGFD_blank() {
    w_CATEG01 = "";
    w_xC1DESCRI = "";
  }
  protected boolean Link_IXGRJLAKIQ() {
    return Link_IXGRJLAKIQ("Full");
  }
  protected boolean Link_IXGRJLAKIQ(String p_cType) {
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
      if (m_Ctx.IsSharedTemp("tbcateg02")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg02,"select C2CODICE,C2DESCRI from "+m_cPhName_tbcateg02+((m_cPhName_tbcateg02).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C2CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
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
          Link_IXGRJLAKIQ_blank();
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
      Link_IXGRJLAKIQ_blank();
    }
    return l_bResult;
  }
  void Link_IXGRJLAKIQ_blank() {
    w_CATEG02 = "";
    w_xC2DESCRI = "";
  }
  protected boolean Link_NKIXCWZJHO() {
    return Link_NKIXCWZJHO("Full");
  }
  protected boolean Link_NKIXCWZJHO(String p_cType) {
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
      if (m_Ctx.IsSharedTemp("tbcateg03")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg03,"select C3CODICE,C3DESCRI from "+m_cPhName_tbcateg03+((m_cPhName_tbcateg03).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C3CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
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
          Link_NKIXCWZJHO_blank();
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
      Link_NKIXCWZJHO_blank();
    }
    return l_bResult;
  }
  void Link_NKIXCWZJHO_blank() {
    w_CATEG03 = "";
    w_xC3DESCRI = "";
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
      if (m_Ctx.IsSharedTemp("tbcateg04")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg04,"select C4CODICE,C4DESCRI from "+m_cPhName_tbcateg04+((m_cPhName_tbcateg04).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C4CODICE"+l_cCurrentKey+l_cWhere);
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
      if (m_Ctx.IsSharedTemp("tbcateg05")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcateg05,"select C5CODICE,C5DESCRI from "+m_cPhName_tbcateg05+((m_cPhName_tbcateg05).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"C5CODICE"+l_cCurrentKey+l_cWhere);
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
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
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
  public boolean Set_CATEG01(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CATEG01 = p_workVariableValue;
    l_bResult = Link_CANUTVNGFD();
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
    l_bResult = Link_IXGRJLAKIQ();
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
    l_bResult = Link_NKIXCWZJHO();
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
  public boolean Set_FLAGFRAUD(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGFRAUD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SV58724(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58724 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SV58726SCA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58726SCA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SV58726SA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58726SA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SV58726PISP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58726PISP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_COGNOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_COGNOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_NOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_NOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSPAGAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSPAGAM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_FLAGFRAUD() {
    return CPLib.ne(w_SEGNO,"D");
  }
  public boolean getVisible_SV58724() {
    return CPLib.ne(w_SEGNO,"D");
  }
  public boolean getVisible_SV58726SCA() {
    return CPLib.ne(w_SEGNO,"D");
  }
  public boolean getVisible_SV58726SA() {
    return CPLib.ne(w_SEGNO,"D");
  }
  public boolean getVisible_SV58726PISP() {
    return CPLib.ne(w_SEGNO,"D");
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
    if (CPLib.ne(o_CATEG01,w_CATEG01) || CPLib.ne(o_CATEG02,w_CATEG02) || CPLib.ne(o_CATEG03,w_CATEG03) || CPLib.ne(o_CATEG04,w_CATEG04) || CPLib.ne(o_CATEG05,w_CATEG05)) {
      w_CATEGORIA = fwfn_calc_categoriaR.Make(m_Ctx,this).Run(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_xraziobo_agg","xraziobo_agg",m_KeyColumns,m_Ctx);
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
    w_IDBASE = "";
    w_SEGNO = "";
    w_CATEG01 = "";
    w_CATEG02 = "";
    w_CATEG03 = "";
    w_CATEG04 = "";
    w_CATEG05 = "";
    w_xC1DESCRI = "";
    w_xC2DESCRI = "";
    w_xC3DESCRI = "";
    w_xC4DESCRI = "";
    w_xC5DESCRI = "";
    w_CATEGORIA = "";
    w_FLAGFRAUD = 0;
    w_SV58724 = "";
    w_SV58726SCA = "";
    w_SV58726SA = "";
    w_SV58726PISP = "";
    w_C_COGNOME = "";
    w_C_NOME = "";
    w_SOSPAGAM = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      w_CATEG01 = CPLib.GetProperty(p,"CATEG01",w_CATEG01,0);
      w_CATEG02 = CPLib.GetProperty(p,"CATEG02",w_CATEG02,0);
      w_CATEG03 = CPLib.GetProperty(p,"CATEG03",w_CATEG03,0);
      w_CATEG04 = CPLib.GetProperty(p,"CATEG04",w_CATEG04,0);
      w_CATEG05 = CPLib.GetProperty(p,"CATEG05",w_CATEG05,0);
      w_CATEGORIA = CPLib.GetProperty(p,"CATEGORIA",w_CATEGORIA,0);
      w_FLAGFRAUD = CPLib.GetProperty(p,"FLAGFRAUD",w_FLAGFRAUD,0);
      w_SV58724 = CPLib.GetProperty(p,"SV58724",w_SV58724,0);
      w_SV58726SCA = CPLib.GetProperty(p,"SV58726SCA",w_SV58726SCA,0);
      w_SV58726SA = CPLib.GetProperty(p,"SV58726SA",w_SV58726SA,0);
      w_SV58726PISP = CPLib.GetProperty(p,"SV58726PISP",w_SV58726PISP,0);
      w_C_COGNOME = CPLib.GetProperty(p,"C_COGNOME",w_C_COGNOME,0);
      w_C_NOME = CPLib.GetProperty(p,"C_NOME",w_C_NOME,0);
      w_SOSPAGAM = CPLib.GetProperty(p,"SOSPAGAM",w_SOSPAGAM,0);
      w_SEGNO = CPLib.GetProperty(p,"SEGNO",w_SEGNO,0);
      w_xC1DESCRI = CPLib.GetProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
      w_xC2DESCRI = CPLib.GetProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
      w_xC3DESCRI = CPLib.GetProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
      w_xC4DESCRI = CPLib.GetProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
      w_xC5DESCRI = CPLib.GetProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
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
    items = tables.get("tbcateg01");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg01",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"C1CODICE","C1DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG01","w_xC1DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcateg01\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg01\u0000false\u0000false\u0000Categoria 1\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg02");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg02",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"C2CODICE","C2DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG02","w_xC2DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Categoria 2\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcateg02\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg02\u0000false\u0000false\u0000Categoria 2\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg03");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg03",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"C3CODICE","C3DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG03","w_xC3DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Categoria 3\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcateg03\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg03\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg04");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg04",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"C4CODICE","C4DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG04","w_xC4DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcateg04\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg04\u0000false\u0000false\u0000Categoria 4\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcateg05");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcateg05",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"C5CODICE","C5DESCRI"});
    map.put("rd_var",new String[]{"w_CATEG05","w_xC5DESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u000080",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Categoria 1\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcateg05\u0000false\u0000false\u00001\u00000\u0000opemt_tbcateg05\u0000false\u0000false\u0000Categoria 5\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_xraziobo_agg",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_xraziobo_agg",child);
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
    m_MNTs = CPLib.MNTChilds("armt_xraziobo_agg",m_Ctx);
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
      l_Keys = new String[]{"armt_xraziobo_agg"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_xraziobo_agg\\"+p_cState};
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
    o_CATEG01 = "";
    o_CATEG02 = "";
    o_CATEG03 = "";
    o_CATEG04 = "";
    o_CATEG05 = "";
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
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"CATEG01",w_CATEG01,0);
    CPLib.PutProperty(p,"CATEG02",w_CATEG02,0);
    CPLib.PutProperty(p,"CATEG03",w_CATEG03,0);
    CPLib.PutProperty(p,"CATEG04",w_CATEG04,0);
    CPLib.PutProperty(p,"CATEG05",w_CATEG05,0);
    CPLib.PutProperty(p,"CATEGORIA",w_CATEGORIA,0);
    CPLib.PutProperty(p,"FLAGFRAUD",w_FLAGFRAUD,0);
    CPLib.PutProperty(p,"SV58724",w_SV58724,0);
    CPLib.PutProperty(p,"SV58726SCA",w_SV58726SCA,0);
    CPLib.PutProperty(p,"SV58726SA",w_SV58726SA,0);
    CPLib.PutProperty(p,"SV58726PISP",w_SV58726PISP,0);
    CPLib.PutProperty(p,"C_COGNOME",w_C_COGNOME,0);
    CPLib.PutProperty(p,"C_NOME",w_C_NOME,0);
    CPLib.PutProperty(p,"SOSPAGAM",w_SOSPAGAM,0);
    CPLib.PutProperty(p,"SEGNO",w_SEGNO,0);
    CPLib.PutProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
    CPLib.PutProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
    CPLib.PutProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
    CPLib.PutProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
    CPLib.PutProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
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
    return "xraziobo_agg"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
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
