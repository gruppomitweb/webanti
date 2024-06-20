import java.util.*;

public class ardt_dettaglioa7BL extends ardt_dettaglioa7WV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_VOCE;
    public String w_SOTTOVOCE;
    public String w_RESID;
    public String w_PROVINCIA;
    public String w_STATO;
    public String w_VAL01217;
    public String w_VAL02147;
    public java.sql.Date w_VAL02148;
    public String w_VAL02149;
    public java.sql.Date w_DATAEFF;
    public double w_IMPORTO;
    public String w_IDBASEA7;
    public double w_CPROWNUM;
    public String w_FLGRESID;
    public String w_FLG00015;
    public String w_FLG00016;
    public String w_FLG01217;
    public String w_FLG02147;
    public String w_FLG02148;
    public String w_FLG02149;
    public String w_xDESCRI;
    public String w_xDESVOCE;
    public int m_nCPRowNum;
    // Stato della riga (variata, nuova, non variata)
    public int m_nRowStatus;
    public String m_cOldRowCPCCCHK;
    public String[] work_children = new String[]{};
  }
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che indica se la testata e' stata variata
  public boolean m_bHeaderUpdated;
  public String m_cOldRowCPCCCHK;
  public int m_nRowStatus;
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
  public static final String i_EntityName = "ardt_dettaglioa7";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_detta7;
  public String m_cServer_detta7;
  public CPPhTableWrInfo m_oWrInfo_detta7;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_detta7;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_vocea7;
  public String m_cServer_vocea7;
  public CPPhTableWrInfo m_oWrInfo_vocea7;
  public String m_cPhName_sottovocea7;
  public String m_cServer_sottovocea7;
  public CPPhTableWrInfo m_oWrInfo_sottovocea7;
  public String m_cPhName_tb00016;
  public String m_cServer_tb00016;
  public CPPhTableWrInfo m_oWrInfo_tb00016;
  public String m_cPhName_tb01217;
  public String m_cServer_tb01217;
  public CPPhTableWrInfo m_oWrInfo_tb01217;
  public String m_cPhName_tb02147;
  public String m_cServer_tb02147;
  public CPPhTableWrInfo m_oWrInfo_tb02147;
  public String m_cPhName_tbprovsv;
  public String m_cServer_tbprovsv;
  public CPPhTableWrInfo m_oWrInfo_tbprovsv;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"detta7"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'ANNO':ANNO,'SEMESTRE':SEMESTRE,'m_Detail':{'VOCE':VOCE,'SOTTOVOCE':SOTTOVOCE,'RESID':RESID,'PROVINCIA':PROVINCIA,'STATO':STATO,'VAL01217':VAL01217,'VAL02147':VAL02147,'VAL02148':VAL02148,'VAL02149':VAL02149,'IMPORTO':IMPORTO,'CPROWNUM':CPROWNUM"+FoundlingChildrenList("ardt_dettaglioa7",true,true)+"}"+FoundlingChildrenList("ardt_dettaglioa7",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'ANNO':ANNO,'SEMESTRE':SEMESTRE,'m_Detail':{'VOCE':VOCE,'SOTTOVOCE':SOTTOVOCE,'RESID':RESID,'PROVINCIA':PROVINCIA,'STATO':STATO,'VAL01217':VAL01217,'VAL02147':VAL02147,'VAL02148':VAL02148,'VAL02149':VAL02149,'DATAEFF':DATAEFF,'IMPORTO':IMPORTO,'IDBASEA7':IDBASEA7,'CPROWNUM':CPROWNUM,'FLGRESID':FLGRESID,'FLG00015':FLG00015,'FLG00016':FLG00016,'FLG01217':FLG01217,'FLG02147':FLG02147,'FLG02148':FLG02148,'FLG02149':FLG02149,'xDESCRI':xDESCRI,'xDESVOCE':xDESVOCE"+FoundlingChildrenList("ardt_dettaglioa7",true,true)+"}"+FoundlingChildrenList("ardt_dettaglioa7",true,false)+"}";
  public static final String i_ItemSequence = "ANNO,SEMESTRE,m_Detail[ VOCE SOTTOVOCE RESID PROVINCIA STATO VAL01217 VAL02147 VAL02148 VAL02149 IMPORTO CPROWNUM"+FoundlingChildrenList("ardt_dettaglioa7",false,true)+"]"+FoundlingChildrenList("ardt_dettaglioa7",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("ardt_dettaglioa7"),new String[][]{new String[]{"ANNO","Annno","C","4","0","campo","key1","false","false"},new String[]{"SEMESTRE","SEMESTRE","C","1","0","campo","key1","false","false"},new String[]{"VOCE","Voce","C","5","0","campo","key2","true","false"},new String[]{"SOTTOVOCE","Sottovoce","C","2","0","campo","key3","true","false"},new String[]{"RESID","Residenza","C","1","0","campo","nokey","true","true"},new String[]{"PROVINCIA","Provincia","C","5","0","campo","nokey","true","true"},new String[]{"STATO","Stato","C","3","0","campo","nokey","true","true"},new String[]{"VAL01217","Oggetto dei reclami","C","5","0","campo","nokey","true","true"},new String[]{"VAL02147","Tipo Restituzione","C","5","0","campo","nokey","true","true"},new String[]{"VAL02148","Data Efficacia","D","8","0","campo","nokey","true","true"},new String[]{"VAL02149","Progressivo Manovra","C","6","0","campo","nokey","true","true"},new String[]{"IMPORTO","Importo/Numero","N","15","2","campo","nokey","true","true"},new String[]{"CPROWNUM","","N","4","0","campo","key1","true","false"}});
  public static final String i_TrsKeys = ",CPROWNUM";
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  /*  Variabili per i transitori: uno per le righe lette, modificate e/o inserite e
                              uno per le righe cancellate.
                            */
  public ArrayList<TrsRow> m_oTrs= new ArrayList<TrsRow>();
  public ArrayList<TrsRow> m_oDeletedRows= new ArrayList<TrsRow>();
  // Variabile che contiene il numero di riga corrente nel transitorio
  public int m_nCurrentRow;
  // Variabile per la gestione del CPROWNUM
  public int m_nCPRowNum;
  public ardt_dettaglioa7BL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_detta7 = p_ContextObject.GetPhName("detta7",p_ContextObject.GetCompany(),false);
    m_cServer_detta7 = p_ContextObject.GetServer("detta7");
    m_oWrInfo_detta7 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"detta7",p_ContextObject.GetCompany());
    m_cVirtName_detta7 = CPSql.ManipulateTablePhName("detta7",m_cServer_detta7);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_vocea7 = p_ContextObject.GetPhName("vocea7");
    m_cServer_vocea7 = p_ContextObject.GetServer("vocea7");
    m_oWrInfo_vocea7 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"vocea7",p_ContextObject.GetCompany());
    m_cPhName_sottovocea7 = p_ContextObject.GetPhName("sottovocea7");
    m_cServer_sottovocea7 = p_ContextObject.GetServer("sottovocea7");
    m_oWrInfo_sottovocea7 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"sottovocea7",p_ContextObject.GetCompany());
    m_cPhName_tb00016 = p_ContextObject.GetPhName("tb00016");
    m_cServer_tb00016 = p_ContextObject.GetServer("tb00016");
    m_oWrInfo_tb00016 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tb00016",p_ContextObject.GetCompany());
    m_cPhName_tb01217 = p_ContextObject.GetPhName("tb01217");
    m_cServer_tb01217 = p_ContextObject.GetServer("tb01217");
    m_oWrInfo_tb01217 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tb01217",p_ContextObject.GetCompany());
    m_cPhName_tb02147 = p_ContextObject.GetPhName("tb02147");
    m_cServer_tb02147 = p_ContextObject.GetServer("tb02147");
    m_oWrInfo_tb02147 = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tb02147",p_ContextObject.GetCompany());
    m_cPhName_tbprovsv = p_ContextObject.GetPhName("tbprovsv");
    m_cServer_tbprovsv = p_ContextObject.GetServer("tbprovsv");
    m_oWrInfo_tbprovsv = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbprovsv",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("ardt_dettaglioa7",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_ANNO = "";
    w_SEMESTRE = "";
    w_VOCE = "";
    w_SOTTOVOCE = "";
    w_PROVINCIA = "";
    w_STATO = "";
    w_VAL01217 = "";
    w_VAL02147 = "";
    w_VAL02148 = CPLib.NullDate();
    w_VAL02149 = "";
    w_DATAEFF = CPLib.NullDate();
    w_IMPORTO = 0;
    w_IDBASEA7 = "";
    w_CPROWNUM = 0;
    w_FLGRESID = "";
    w_FLG00015 = "";
    w_FLG00016 = "";
    w_FLG01217 = "";
    w_FLG02147 = "";
    w_FLG02148 = "";
    w_FLG02149 = "";
    w_xDESCRI = "";
    w_xDESVOCE = "";
    Link_GVMMKABWWU();
    Link_NNRZYWQBXJ();
    w_RESID = "1";
    Link_MDEBFTECJW();
    Link_NHFRSWSJPA();
    Link_KYDBUIQLMM();
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
    o_VOCE = w_VOCE;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_GVMMKABWWU() {
    return Link_GVMMKABWWU("Full");
  }
  protected boolean Link_GVMMKABWWU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_VOCE))) {
      String l_OldValue = w_VOCE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VOCE,"C",5,0),m_cServer_vocea7,w_VOCE);
      if (m_Ctx.IsSharedTemp("vocea7")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_vocea7,"select VOCE,DESCRI from "+m_cPhName_vocea7+((m_cPhName_vocea7).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"VOCE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VOCE,"C",160,0),m_cServer_vocea7,w_VOCE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_vocea7,"select VOCE,DESCRI from "+m_cPhName_vocea7+((m_cPhName_vocea7).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_VOCE = l_rsLink.GetString("VOCE");
          w_xDESVOCE = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_GVMMKABWWU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_VOCE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","VOCE");
          }
          m_cLastWorkVarError = "VOCE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_GVMMKABWWU_blank();
    }
    return l_bResult;
  }
  void Link_GVMMKABWWU_blank() {
    w_VOCE = "";
    w_xDESVOCE = "";
  }
  protected boolean Link_NNRZYWQBXJ() {
    return Link_NNRZYWQBXJ("Full");
  }
  protected boolean Link_NNRZYWQBXJ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOTTOVOCE))) {
      String l_OldValue = w_SOTTOVOCE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTTOVOCE,"C",2,0),m_cServer_sottovocea7,w_SOTTOVOCE);
      l_cWhere = l_cWhere+" and VOCE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VOCE,"C",5,0),m_cServer_sottovocea7,w_VOCE);
      if (m_Ctx.IsSharedTemp("sottovocea7")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_sottovocea7,"select VOCE,SOTTOVOCE,FLGRESID,FLG00015,FLG00016,FLG01217,FLG02147,FLG02148,FLG02149,DESCRI from "+m_cPhName_sottovocea7+((m_cPhName_sottovocea7).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SOTTOVOCE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SOTTOVOCE = l_rsLink.GetString("SOTTOVOCE");
          w_FLGRESID = l_rsLink.GetString("FLGRESID");
          w_FLG00015 = l_rsLink.GetString("FLG00015");
          w_FLG00016 = l_rsLink.GetString("FLG00016");
          w_FLG01217 = l_rsLink.GetString("FLG01217");
          w_FLG02147 = l_rsLink.GetString("FLG02147");
          w_FLG02148 = l_rsLink.GetString("FLG02148");
          w_FLG02149 = l_rsLink.GetString("FLG02149");
          w_xDESCRI = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NNRZYWQBXJ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOTTOVOCE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOTTOVOCE");
          }
          m_cLastWorkVarError = "SOTTOVOCE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NNRZYWQBXJ_blank();
    }
    return l_bResult;
  }
  void Link_NNRZYWQBXJ_blank() {
    w_SOTTOVOCE = "";
    w_FLGRESID = "";
    w_FLG00015 = "";
    w_FLG00016 = "";
    w_FLG01217 = "";
    w_FLG02147 = "";
    w_FLG02148 = "";
    w_FLG02149 = "";
    w_xDESCRI = "";
  }
  protected boolean Link_MDEBFTECJW() {
    return Link_MDEBFTECJW("Full");
  }
  protected boolean Link_MDEBFTECJW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_STATO))) {
      String l_OldValue = w_STATO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_STATO,"C",3,0),m_cServer_tb00016,w_STATO);
      if (m_Ctx.IsSharedTemp("tb00016")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tb00016,"select COD from "+m_cPhName_tb00016+((m_cPhName_tb00016).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"COD"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_STATO = l_rsLink.GetString("COD");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MDEBFTECJW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_STATO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","STATO");
          }
          m_cLastWorkVarError = "STATO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_MDEBFTECJW_blank();
    }
    return l_bResult;
  }
  void Link_MDEBFTECJW_blank() {
    w_STATO = "";
  }
  protected boolean Link_NHFRSWSJPA() {
    return Link_NHFRSWSJPA("Full");
  }
  protected boolean Link_NHFRSWSJPA(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_VAL01217))) {
      String l_OldValue = w_VAL01217;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VAL01217,"C",5,0),m_cServer_tb01217,w_VAL01217);
      if (m_Ctx.IsSharedTemp("tb01217")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tb01217,"select COD from "+m_cPhName_tb01217+((m_cPhName_tb01217).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"COD"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_VAL01217 = l_rsLink.GetString("COD");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NHFRSWSJPA_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_VAL01217 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","VAL01217");
          }
          m_cLastWorkVarError = "VAL01217";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NHFRSWSJPA_blank();
    }
    return l_bResult;
  }
  void Link_NHFRSWSJPA_blank() {
    w_VAL01217 = "";
  }
  protected boolean Link_KYDBUIQLMM() {
    return Link_KYDBUIQLMM("Full");
  }
  protected boolean Link_KYDBUIQLMM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_VAL02147))) {
      String l_OldValue = w_VAL02147;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VAL02147,"C",5,0),m_cServer_tb02147,w_VAL02147);
      if (m_Ctx.IsSharedTemp("tb02147")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tb02147,"select COD from "+m_cPhName_tb02147+((m_cPhName_tb02147).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"COD"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_VAL02147 = l_rsLink.GetString("COD");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_KYDBUIQLMM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_VAL02147 = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","VAL02147");
          }
          m_cLastWorkVarError = "VAL02147";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_KYDBUIQLMM_blank();
    }
    return l_bResult;
  }
  void Link_KYDBUIQLMM_blank() {
    w_VAL02147 = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_ANNO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ANNO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SEMESTRE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SEMESTRE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VOCE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_VOCE = p_workVariableValue;
    l_bResult = Link_GVMMKABWWU();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (CPLib.Empty(w_SOTTOVOCE))) {
      l_bTmpRes = Link_NNRZYWQBXJ();
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VOCE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOTTOVOCE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_SOTTOVOCE = p_workVariableValue;
    l_bResult = Link_NNRZYWQBXJ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOTTOVOCE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RESID(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_RESID = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RESID = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean MVCFXMIIPY_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLGRESID,"S");
  }
  public boolean Set_PROVINCIA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_PROVINCIA = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PROVINCIA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean SNYJQPAYYR_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG00015,"S");
  }
  public boolean Set_STATO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_STATO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_MDEBFTECJW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_STATO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean MDEBFTECJW_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG00016,"S");
  }
  public boolean Set_VAL01217(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_VAL01217 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_NHFRSWSJPA();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VAL01217 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean NHFRSWSJPA_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG01217,"S");
  }
  public boolean Set_VAL02147(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_VAL02147 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_KYDBUIQLMM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VAL02147 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean KYDBUIQLMM_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG02147,"S");
  }
  public boolean Set_VAL02148(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_VAL02148 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VAL02148 = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean CNCQNTLDXJ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG02148,"S");
  }
  public boolean Set_VAL02149(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_VAL02149 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_VAL02149 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean PDCPOALMKJ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLG02149,"S");
  }
  public boolean Set_IMPORTO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_IMPORTO = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_IMPORTO = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPROWNUM(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CPROWNUM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_RESID() {
    return CPLib.eq(w_FLGRESID,"S");
  }
  public boolean getWritable_PROVINCIA() {
    return CPLib.eq(w_FLG00015,"S");
  }
  public boolean getWritable_STATO() {
    return CPLib.eq(w_FLG00016,"S");
  }
  public boolean getWritable_VAL01217() {
    return CPLib.eq(w_FLG01217,"S");
  }
  public boolean getWritable_VAL02147() {
    return CPLib.eq(w_FLG02147,"S");
  }
  public boolean getWritable_VAL02148() {
    return CPLib.eq(w_FLG02148,"S");
  }
  public boolean getWritable_VAL02149() {
    return CPLib.eq(w_FLG02149,"S");
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
    if (CPLib.ne(o_VOCE,w_VOCE)) {
      l_bTmpRes = Link_NNRZYWQBXJ();
    }
    if (CPLib.ne(o_VOCE,w_VOCE)) {
      l_bTmpRes = Link_NHFRSWSJPA();
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
    m_bHeaderUpdated = false;
    // Rimozione degli elementi dai transitori
    m_oTrs.clear();
    m_oDeletedRows.clear();
    m_nCurrentRow = 0;
    m_nRowStatus = 0;
    m_nCPRowNum = 0;
    m_cOldRowCPCCCHK = "";
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"ANNO","SEMESTRE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("ardt_dettaglioa7","detta7",m_KeyColumns,m_Ctx);
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
    w_ANNO = "";
    w_SEMESTRE = "";
    w_VOCE = "";
    w_SOTTOVOCE = "";
    w_RESID = "";
    w_PROVINCIA = "";
    w_STATO = "";
    w_VAL01217 = "";
    w_VAL02147 = "";
    w_VAL02148 = CPLib.NullDate();
    w_VAL02149 = "";
    w_DATAEFF = CPLib.NullDate();
    w_IMPORTO = 0;
    w_IDBASEA7 = "";
    w_CPROWNUM = 0;
    w_FLGRESID = "";
    w_FLG00015 = "";
    w_FLG00016 = "";
    w_FLG01217 = "";
    w_FLG02147 = "";
    w_FLG02148 = "";
    w_FLG02149 = "";
    w_xDESCRI = "";
    w_xDESVOCE = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      int rows;
      int i;
      String Rows;
      Properties trs_p;
      trs_p = CPLib.GetProperties(CPLib.GetProperty(p, "m_oTrs", "", 0),new Properties());
      Properties p_VOCE;
      p_VOCE = CPLib.GetProperties(trs_p.getProperty("VOCE"),new Properties());
      Properties p_SOTTOVOCE;
      p_SOTTOVOCE = CPLib.GetProperties(trs_p.getProperty("SOTTOVOCE"),new Properties());
      Properties p_RESID;
      p_RESID = CPLib.GetProperties(trs_p.getProperty("RESID"),new Properties());
      Properties p_PROVINCIA;
      p_PROVINCIA = CPLib.GetProperties(trs_p.getProperty("PROVINCIA"),new Properties());
      Properties p_STATO;
      p_STATO = CPLib.GetProperties(trs_p.getProperty("STATO"),new Properties());
      Properties p_VAL01217;
      p_VAL01217 = CPLib.GetProperties(trs_p.getProperty("VAL01217"),new Properties());
      Properties p_VAL02147;
      p_VAL02147 = CPLib.GetProperties(trs_p.getProperty("VAL02147"),new Properties());
      Properties p_VAL02148;
      p_VAL02148 = CPLib.GetProperties(trs_p.getProperty("VAL02148"),new Properties());
      Properties p_VAL02149;
      p_VAL02149 = CPLib.GetProperties(trs_p.getProperty("VAL02149"),new Properties());
      Properties p_DATAEFF;
      p_DATAEFF = CPLib.GetProperties(trs_p.getProperty("DATAEFF"),new Properties());
      Properties p_IMPORTO;
      p_IMPORTO = CPLib.GetProperties(trs_p.getProperty("IMPORTO"),new Properties());
      Properties p_IDBASEA7;
      p_IDBASEA7 = CPLib.GetProperties(trs_p.getProperty("IDBASEA7"),new Properties());
      Properties p_CPROWNUM;
      p_CPROWNUM = CPLib.GetProperties(trs_p.getProperty("CPROWNUM"),new Properties());
      Properties p_FLGRESID;
      p_FLGRESID = CPLib.GetProperties(trs_p.getProperty("FLGRESID"),new Properties());
      Properties p_FLG00015;
      p_FLG00015 = CPLib.GetProperties(trs_p.getProperty("FLG00015"),new Properties());
      Properties p_FLG00016;
      p_FLG00016 = CPLib.GetProperties(trs_p.getProperty("FLG00016"),new Properties());
      Properties p_FLG01217;
      p_FLG01217 = CPLib.GetProperties(trs_p.getProperty("FLG01217"),new Properties());
      Properties p_FLG02147;
      p_FLG02147 = CPLib.GetProperties(trs_p.getProperty("FLG02147"),new Properties());
      Properties p_FLG02148;
      p_FLG02148 = CPLib.GetProperties(trs_p.getProperty("FLG02148"),new Properties());
      Properties p_FLG02149;
      p_FLG02149 = CPLib.GetProperties(trs_p.getProperty("FLG02149"),new Properties());
      Properties p_xDESCRI;
      p_xDESCRI = CPLib.GetProperties(trs_p.getProperty("xDESCRI"),new Properties());
      Properties p_xDESVOCE;
      p_xDESVOCE = CPLib.GetProperties(trs_p.getProperty("xDESVOCE"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_ANNO = CPLib.GetProperty(p,"ANNO",w_ANNO,0);
      w_SEMESTRE = CPLib.GetProperty(p,"SEMESTRE",w_SEMESTRE,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_VOCE = "";
        w_VOCE = CPLib.GetProperty(p_VOCE,"",w_VOCE,i);
        w_SOTTOVOCE = "";
        w_SOTTOVOCE = CPLib.GetProperty(p_SOTTOVOCE,"",w_SOTTOVOCE,i);
        w_RESID = "";
        w_RESID = CPLib.GetProperty(p_RESID,"",w_RESID,i);
        w_PROVINCIA = "";
        w_PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"",w_PROVINCIA,i);
        w_STATO = "";
        w_STATO = CPLib.GetProperty(p_STATO,"",w_STATO,i);
        w_VAL01217 = "";
        w_VAL01217 = CPLib.GetProperty(p_VAL01217,"",w_VAL01217,i);
        w_VAL02147 = "";
        w_VAL02147 = CPLib.GetProperty(p_VAL02147,"",w_VAL02147,i);
        w_VAL02148 = CPLib.NullDate();
        w_VAL02148 = CPLib.GetProperty(p_VAL02148,"",w_VAL02148,i);
        w_VAL02149 = "";
        w_VAL02149 = CPLib.GetProperty(p_VAL02149,"",w_VAL02149,i);
        w_DATAEFF = CPLib.NullDate();
        w_DATAEFF = CPLib.GetProperty(p_DATAEFF,"",w_DATAEFF,i);
        w_IMPORTO = 0;
        w_IMPORTO = CPLib.GetProperty(p_IMPORTO,"",w_IMPORTO,i);
        w_IDBASEA7 = "";
        w_IDBASEA7 = CPLib.GetProperty(p_IDBASEA7,"",w_IDBASEA7,i);
        w_CPROWNUM = 0;
        w_CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",w_CPROWNUM,i);
        w_FLGRESID = "";
        w_FLGRESID = CPLib.GetProperty(p_FLGRESID,"",w_FLGRESID,i);
        w_FLG00015 = "";
        w_FLG00015 = CPLib.GetProperty(p_FLG00015,"",w_FLG00015,i);
        w_FLG00016 = "";
        w_FLG00016 = CPLib.GetProperty(p_FLG00016,"",w_FLG00016,i);
        w_FLG01217 = "";
        w_FLG01217 = CPLib.GetProperty(p_FLG01217,"",w_FLG01217,i);
        w_FLG02147 = "";
        w_FLG02147 = CPLib.GetProperty(p_FLG02147,"",w_FLG02147,i);
        w_FLG02148 = "";
        w_FLG02148 = CPLib.GetProperty(p_FLG02148,"",w_FLG02148,i);
        w_FLG02149 = "";
        w_FLG02149 = CPLib.GetProperty(p_FLG02149,"",w_FLG02149,i);
        w_xDESCRI = "";
        w_xDESCRI = CPLib.GetProperty(p_xDESCRI,"",w_xDESCRI,i);
        w_xDESVOCE = "";
        w_xDESVOCE = CPLib.GetProperty(p_xDESVOCE,"",w_xDESVOCE,i);
        m_nCPRowNum = (int)CPLib.GetProperty(p_m_nCPRowNum,"",0,i);
        work_children = CPLib.SetFromContextChildMNTs(trs_p,m_MNTs,true,i);
        m_nRowStatus = (int)CPLib.GetProperty(p_m_nRowStatus,"",0,i);
        if (CPLib.eq(m_nRowStatus,2)) {
          m_cOldRowCPCCCHK = CPLib.NewCPCCCHK();
        } else {
          m_cOldRowCPCCCHK = CPLib.GetProperty(p_m_cOldRowCPCCCHK,"","",i);
        }
        if (CPLib.ne(m_nRowStatus,3)) {
          AppendRow();
        } else {
          AddTrsDeletedRow();
        }
        i = i+1;
      }
      SetRow(0);
      CPLib.SetFromContextMNTs(p,m_MNTs);
      SPExtenderLib.SetExtendedFromContext(p,extendedFields);
      m_bLoaded = CPLib.GetProperty(p,"m_bLoaded",false,0);
      m_bUpdated = CPLib.GetProperty(p,"m_bUpdated",false,0);
      m_cOldCPCCCHK = CPLib.GetProperty(p,"m_cOldCPCCCHK","",0);
      m_cPreviousState = CPLib.GetProperty(p,"m_cPrvsStt","",0);
      m_cPassword = CPLib.GetProperty(p,"m_cPwd","",0);
      m_cOTP = CPLib.GetProperty(p,"m_cOTP","",0);
      m_lCtxLoaded = true;
      m_bHeaderUpdated = CPLib.GetProperty(p,"m_bHeaderUpdated",false,0);
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
    m_bHeaderUpdated = true;
  }
  public void SetUpdatedRow() {
    m_bUpdated = true;
    SetModified();
  }
  void SetUpdated(String p_cName) {
    if (CPLib.eq(p_cName,"ANNO")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"SEMESTRE")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"VOCE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"SOTTOVOCE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"RESID")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"PROVINCIA")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"STATO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"VAL01217")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"VAL02147")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"VAL02148")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"VAL02149")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"IMPORTO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CPROWNUM")) {
      SetUpdatedRow();
      return;
    }
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
    items = tables.get("vocea7");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("vocea7",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"VOCE","DESCRI"});
    map.put("rd_var",new String[]{"w_VOCE","w_xDESVOCE"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000160",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Voce\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key2\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("vocea7\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Voci\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("sottovocea7");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("sottovocea7",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_VOCE"});
    map.put("rd_kfield",new String[]{"VOCE"});
    map.put("rd_field",new String[]{"SOTTOVOCE","FLGRESID","FLG00015","FLG00016","FLG01217","FLG02147","FLG02148","FLG02149","DESCRI"});
    map.put("rd_var",new String[]{"w_SOTTOVOCE","w_FLGRESID","w_FLG00015","w_FLG00016","w_FLG01217","w_FLG02147","w_FLG02148","w_FLG02149","w_xDESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u00001\u00001\u00001\u00001\u00001\u00001\u00001\u0000160",-1));
    map.put("rd_kvar.len",zeroSplit.split("5",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Sottovoce\u0000Flag Residenza\u0000Attiva Provincia\u0000Attiva Stato\u0000Attiva Tab 1217\u0000Attiva Tab 2147\u0000Attiva Tab 2148\u0000Attiva Tab 2149\u0000Descrizione",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Voce",-1));
    map.put("rd_var.key_num",zeroSplit.split("key3\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("key2",-1));
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("TRUE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("sottovocea7\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tb00016");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tb00016",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"COD"});
    map.put("rd_var",new String[]{"w_STATO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("w_FLG00016='S'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tb00016\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tb01217");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tb01217",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"COD"});
    map.put("rd_var",new String[]{"w_VAL01217"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Oggetto dei reclami",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("w_FLG01217='S'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tb01217\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tb02147");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tb02147",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"COD"});
    map.put("rd_var",new String[]{"w_VAL02147"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Restituzione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("w_FLG02147='S'",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tb02147\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("ardt_dettaglioa7",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_dettaglioa7",child);
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
    for(String child : CPLib.LoadableMNTs("ardt_dettaglioa7",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_dettaglioa7",child);
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
    m_MNTs = CPLib.MNTChilds("ardt_dettaglioa7",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    l_bResult = true;
    if ( ! (CPLib.Empty(w_VOCE))) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
    }
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
      l_Keys = new String[]{"ardt_dettaglioa7"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"ardt_dettaglioa7\\"+p_cState};
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
  public boolean CanDeleteRow() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_VOCE = "";
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
    int i;
    int trsrow;
    Properties trs_p;
    trs_p = new Properties();
    Properties p_VOCE;
    p_VOCE = new Properties();
    Properties p_SOTTOVOCE;
    p_SOTTOVOCE = new Properties();
    Properties p_RESID;
    p_RESID = new Properties();
    Properties p_PROVINCIA;
    p_PROVINCIA = new Properties();
    Properties p_STATO;
    p_STATO = new Properties();
    Properties p_VAL01217;
    p_VAL01217 = new Properties();
    Properties p_VAL02147;
    p_VAL02147 = new Properties();
    Properties p_VAL02148;
    p_VAL02148 = new Properties();
    Properties p_VAL02149;
    p_VAL02149 = new Properties();
    Properties p_DATAEFF;
    p_DATAEFF = new Properties();
    Properties p_IMPORTO;
    p_IMPORTO = new Properties();
    Properties p_IDBASEA7;
    p_IDBASEA7 = new Properties();
    Properties p_CPROWNUM;
    p_CPROWNUM = new Properties();
    Properties p_FLGRESID;
    p_FLGRESID = new Properties();
    Properties p_FLG00015;
    p_FLG00015 = new Properties();
    Properties p_FLG00016;
    p_FLG00016 = new Properties();
    Properties p_FLG01217;
    p_FLG01217 = new Properties();
    Properties p_FLG02147;
    p_FLG02147 = new Properties();
    Properties p_FLG02148;
    p_FLG02148 = new Properties();
    Properties p_FLG02149;
    p_FLG02149 = new Properties();
    Properties p_xDESCRI;
    p_xDESCRI = new Properties();
    Properties p_xDESVOCE;
    p_xDESVOCE = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"ANNO",w_ANNO,0);
    CPLib.PutProperty(p,"SEMESTRE",w_SEMESTRE,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_VOCE,"",w_VOCE,trsrow);
      CPLib.PutProperty(p_SOTTOVOCE,"",w_SOTTOVOCE,trsrow);
      CPLib.PutProperty(p_RESID,"",w_RESID,trsrow);
      CPLib.PutProperty(p_PROVINCIA,"",w_PROVINCIA,trsrow);
      CPLib.PutProperty(p_STATO,"",w_STATO,trsrow);
      CPLib.PutProperty(p_VAL01217,"",w_VAL01217,trsrow);
      CPLib.PutProperty(p_VAL02147,"",w_VAL02147,trsrow);
      CPLib.PutProperty(p_VAL02148,"",w_VAL02148,trsrow);
      CPLib.PutProperty(p_VAL02149,"",w_VAL02149,trsrow);
      CPLib.PutProperty(p_DATAEFF,"",w_DATAEFF,trsrow);
      CPLib.PutProperty(p_IMPORTO,"",w_IMPORTO,trsrow);
      CPLib.PutProperty(p_IDBASEA7,"",w_IDBASEA7,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_FLGRESID,"",w_FLGRESID,trsrow);
      CPLib.PutProperty(p_FLG00015,"",w_FLG00015,trsrow);
      CPLib.PutProperty(p_FLG00016,"",w_FLG00016,trsrow);
      CPLib.PutProperty(p_FLG01217,"",w_FLG01217,trsrow);
      CPLib.PutProperty(p_FLG02147,"",w_FLG02147,trsrow);
      CPLib.PutProperty(p_FLG02148,"",w_FLG02148,trsrow);
      CPLib.PutProperty(p_FLG02149,"",w_FLG02149,trsrow);
      CPLib.PutProperty(p_xDESCRI,"",w_xDESCRI,trsrow);
      CPLib.PutProperty(p_xDESVOCE,"",w_xDESVOCE,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    i = 0;
    while (CPLib.lt(i,m_oDeletedRows.size())) {
      SetDeletedRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_VOCE,"",w_VOCE,trsrow);
      CPLib.PutProperty(p_SOTTOVOCE,"",w_SOTTOVOCE,trsrow);
      CPLib.PutProperty(p_RESID,"",w_RESID,trsrow);
      CPLib.PutProperty(p_PROVINCIA,"",w_PROVINCIA,trsrow);
      CPLib.PutProperty(p_STATO,"",w_STATO,trsrow);
      CPLib.PutProperty(p_VAL01217,"",w_VAL01217,trsrow);
      CPLib.PutProperty(p_VAL02147,"",w_VAL02147,trsrow);
      CPLib.PutProperty(p_VAL02148,"",w_VAL02148,trsrow);
      CPLib.PutProperty(p_VAL02149,"",w_VAL02149,trsrow);
      CPLib.PutProperty(p_DATAEFF,"",w_DATAEFF,trsrow);
      CPLib.PutProperty(p_IMPORTO,"",w_IMPORTO,trsrow);
      CPLib.PutProperty(p_IDBASEA7,"",w_IDBASEA7,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_FLGRESID,"",w_FLGRESID,trsrow);
      CPLib.PutProperty(p_FLG00015,"",w_FLG00015,trsrow);
      CPLib.PutProperty(p_FLG00016,"",w_FLG00016,trsrow);
      CPLib.PutProperty(p_FLG01217,"",w_FLG01217,trsrow);
      CPLib.PutProperty(p_FLG02147,"",w_FLG02147,trsrow);
      CPLib.PutProperty(p_FLG02148,"",w_FLG02148,trsrow);
      CPLib.PutProperty(p_FLG02149,"",w_FLG02149,trsrow);
      CPLib.PutProperty(p_xDESCRI,"",w_xDESCRI,trsrow);
      CPLib.PutProperty(p_xDESVOCE,"",w_xDESVOCE,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("VOCE",CPLib.ToProperties(p_VOCE));
    trs_p.setProperty("SOTTOVOCE",CPLib.ToProperties(p_SOTTOVOCE));
    trs_p.setProperty("RESID",CPLib.ToProperties(p_RESID));
    trs_p.setProperty("PROVINCIA",CPLib.ToProperties(p_PROVINCIA));
    trs_p.setProperty("STATO",CPLib.ToProperties(p_STATO));
    trs_p.setProperty("VAL01217",CPLib.ToProperties(p_VAL01217));
    trs_p.setProperty("VAL02147",CPLib.ToProperties(p_VAL02147));
    trs_p.setProperty("VAL02148",CPLib.ToProperties(p_VAL02148));
    trs_p.setProperty("VAL02149",CPLib.ToProperties(p_VAL02149));
    trs_p.setProperty("DATAEFF",CPLib.ToProperties(p_DATAEFF));
    trs_p.setProperty("IMPORTO",CPLib.ToProperties(p_IMPORTO));
    trs_p.setProperty("IDBASEA7",CPLib.ToProperties(p_IDBASEA7));
    trs_p.setProperty("CPROWNUM",CPLib.ToProperties(p_CPROWNUM));
    trs_p.setProperty("FLGRESID",CPLib.ToProperties(p_FLGRESID));
    trs_p.setProperty("FLG00015",CPLib.ToProperties(p_FLG00015));
    trs_p.setProperty("FLG00016",CPLib.ToProperties(p_FLG00016));
    trs_p.setProperty("FLG01217",CPLib.ToProperties(p_FLG01217));
    trs_p.setProperty("FLG02147",CPLib.ToProperties(p_FLG02147));
    trs_p.setProperty("FLG02148",CPLib.ToProperties(p_FLG02148));
    trs_p.setProperty("FLG02149",CPLib.ToProperties(p_FLG02149));
    trs_p.setProperty("xDESCRI",CPLib.ToProperties(p_xDESCRI));
    trs_p.setProperty("xDESVOCE",CPLib.ToProperties(p_xDESVOCE));
    trs_p.setProperty("m_nCPRowNum",CPLib.ToProperties(p_m_nCPRowNum));
    trs_p.setProperty("m_nRowStatus",CPLib.ToProperties(p_m_nRowStatus));
    trs_p.setProperty("m_cOldRowCPCCCHK",CPLib.ToProperties(p_m_cOldRowCPCCCHK));
    trs_p.setProperty("Rows",CPLib.ToProperties(trsrow));
    CPLib.PutProperty(p,"m_oTrs",trs_p);
    SPExtenderLib.PutExtendedProperies(p,extendedFields);
    CPLib.PutProperty(p,"m_bLoaded",m_bLoaded);
    CPLib.PutProperty(p,"m_bUpdated",m_bUpdated);
    CPLib.PutProperty(p,"m_cOldCPCCCHK",m_cOldCPCCCHK);
    CPLib.PutProperty(p,"m_cPrvsStt",m_cPreviousState);
    CPLib.PutProperty(p,"m_bHeaderUpdated",m_bHeaderUpdated);
  }
  public String i_PrimaryKey() {
    return PrimaryKey(this);
  }
  public static String PrimaryKey(Caller p_Caller) {
    return "detta7"+"\\"+CPLib.ToCPStr(p_Caller.GetString("ANNO","C",4,0))+"\\"+CPLib.ToCPStr(p_Caller.GetString("SEMESTRE","C",1,0));
  }
  public String RowPrimaryKey() {
    return "detta7"+"\\"+CPLib.ToCPStr(w_CPROWNUM);
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
  protected void TrsToWork() {
    w_VOCE= m_oTrs.get(m_nCurrentRow).w_VOCE;
    w_SOTTOVOCE= m_oTrs.get(m_nCurrentRow).w_SOTTOVOCE;
    w_RESID= m_oTrs.get(m_nCurrentRow).w_RESID;
    w_PROVINCIA= m_oTrs.get(m_nCurrentRow).w_PROVINCIA;
    w_STATO= m_oTrs.get(m_nCurrentRow).w_STATO;
    w_VAL01217= m_oTrs.get(m_nCurrentRow).w_VAL01217;
    w_VAL02147= m_oTrs.get(m_nCurrentRow).w_VAL02147;
    w_VAL02148= m_oTrs.get(m_nCurrentRow).w_VAL02148;
    w_VAL02149= m_oTrs.get(m_nCurrentRow).w_VAL02149;
    w_DATAEFF= m_oTrs.get(m_nCurrentRow).w_DATAEFF;
    w_IMPORTO= m_oTrs.get(m_nCurrentRow).w_IMPORTO;
    w_IDBASEA7= m_oTrs.get(m_nCurrentRow).w_IDBASEA7;
    w_CPROWNUM= m_oTrs.get(m_nCurrentRow).w_CPROWNUM;
    w_FLGRESID= m_oTrs.get(m_nCurrentRow).w_FLGRESID;
    w_FLG00015= m_oTrs.get(m_nCurrentRow).w_FLG00015;
    w_FLG00016= m_oTrs.get(m_nCurrentRow).w_FLG00016;
    w_FLG01217= m_oTrs.get(m_nCurrentRow).w_FLG01217;
    w_FLG02147= m_oTrs.get(m_nCurrentRow).w_FLG02147;
    w_FLG02148= m_oTrs.get(m_nCurrentRow).w_FLG02148;
    w_FLG02149= m_oTrs.get(m_nCurrentRow).w_FLG02149;
    w_xDESCRI= m_oTrs.get(m_nCurrentRow).w_xDESCRI;
    w_xDESVOCE= m_oTrs.get(m_nCurrentRow).w_xDESVOCE;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_VOCE=w_VOCE;
    m_oTrs.get(m_nCurrentRow).w_SOTTOVOCE=w_SOTTOVOCE;
    m_oTrs.get(m_nCurrentRow).w_RESID=w_RESID;
    m_oTrs.get(m_nCurrentRow).w_PROVINCIA=w_PROVINCIA;
    m_oTrs.get(m_nCurrentRow).w_STATO=w_STATO;
    m_oTrs.get(m_nCurrentRow).w_VAL01217=w_VAL01217;
    m_oTrs.get(m_nCurrentRow).w_VAL02147=w_VAL02147;
    m_oTrs.get(m_nCurrentRow).w_VAL02148=w_VAL02148;
    m_oTrs.get(m_nCurrentRow).w_VAL02149=w_VAL02149;
    m_oTrs.get(m_nCurrentRow).w_DATAEFF=w_DATAEFF;
    m_oTrs.get(m_nCurrentRow).w_IMPORTO=w_IMPORTO;
    m_oTrs.get(m_nCurrentRow).w_IDBASEA7=w_IDBASEA7;
    m_oTrs.get(m_nCurrentRow).w_CPROWNUM=w_CPROWNUM;
    m_oTrs.get(m_nCurrentRow).w_FLGRESID=w_FLGRESID;
    m_oTrs.get(m_nCurrentRow).w_FLG00015=w_FLG00015;
    m_oTrs.get(m_nCurrentRow).w_FLG00016=w_FLG00016;
    m_oTrs.get(m_nCurrentRow).w_FLG01217=w_FLG01217;
    m_oTrs.get(m_nCurrentRow).w_FLG02147=w_FLG02147;
    m_oTrs.get(m_nCurrentRow).w_FLG02148=w_FLG02148;
    m_oTrs.get(m_nCurrentRow).w_FLG02149=w_FLG02149;
    m_oTrs.get(m_nCurrentRow).w_xDESCRI=w_xDESCRI;
    m_oTrs.get(m_nCurrentRow).w_xDESVOCE=w_xDESVOCE;
    m_oTrs.get(m_nCurrentRow).m_nCPRowNum=m_nCPRowNum;
    CPLib.WorkToTrsMNTs(m_MNTs,work_children);
    m_oTrs.get(m_nCurrentRow).work_children=CPLib.GetClone(work_children);
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
    m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public void AddRow() {
    /*  Inizializzazione di una nuova riga del transitorio.
                                Questo metodo pubblico viene chiamato quando c'è la richiesta dall'interfaccia
                                di aggiungere una riga nella movimentazione.
                              */
    m_nRowStatus = 2;
    m_nCurrentRow = Rows();
    boolean l_bTmpRes;
    int i;
    double l_nRowCprownum;
    m_nCPRowNum = 0;
    for ( i = 0; CPLib.lt(i,Rows()); i = i + (1)) {
      l_nRowCprownum= m_oTrs.get(i).w_CPROWNUM;
      if (CPLib.gt(l_nRowCprownum,m_nCPRowNum)) {
        m_nCPRowNum = (int)l_nRowCprownum;
      }
    }
    m_nCPRowNum = m_nCPRowNum+1;
    w_CPROWNUM = m_nCPRowNum;
    // Inizializzazione delle variabili di work al loro valore di blank
    w_VOCE = "";
    w_SOTTOVOCE = "";
    w_RESID = "";
    w_PROVINCIA = "";
    w_STATO = "";
    w_VAL01217 = "";
    w_VAL02147 = "";
    w_VAL02148 = CPLib.NullDate();
    w_VAL02149 = "";
    w_DATAEFF = CPLib.NullDate();
    w_IMPORTO = 0;
    w_IDBASEA7 = "";
    w_FLGRESID = "";
    w_FLG00015 = "";
    w_FLG00016 = "";
    w_FLG01217 = "";
    w_FLG02147 = "";
    w_FLG02148 = "";
    w_FLG02149 = "";
    w_xDESCRI = "";
    w_xDESVOCE = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if ( ! (CPLib.Empty(w_VOCE))) {
      l_bTmpRes = Link_GVMMKABWWU();
    }
    if ( ! (CPLib.Empty(w_SOTTOVOCE))) {
      l_bTmpRes = Link_NNRZYWQBXJ();
    }
    w_RESID = "1";
    if ( ! (CPLib.Empty(w_STATO))) {
      l_bTmpRes = Link_MDEBFTECJW();
    }
    if ( ! (CPLib.Empty(w_VAL01217))) {
      l_bTmpRes = Link_NHFRSWSJPA();
    }
    if ( ! (CPLib.Empty(w_VAL02147))) {
      l_bTmpRes = Link_KYDBUIQLMM();
    }
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    m_cOldRowCPCCCHK = "";
    // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
    SaveDependsOn();
    AppendRow();
  }
  public boolean SetRow(double p_nRowNumberToSet) {
    /*  Impostazione delle variabili di work ad una riga del transitorio.
                                Se la riga richiesta è nuova, viene chiamata una inizializzazione.
                                Se la riga richiesta è più grande della dimensione del transitorio + 1,
                                viene ritornato "False".
                                Questa procedura viene chiamata nella lettura di un record e in generale
                                quando si deve operare
                                nel transitorio non per caricare un nuovo dato, ma per leggere.
                                Negli altri casi si deve chiamare la "ChangeRow" che fa il check della riga
                                corrente e salva il transitorio.
                              */
    boolean l_bResult;
    l_bResult = true;
    if (CPLib.lt(p_nRowNumberToSet,Rows())) {
      m_nCurrentRow = (int)p_nRowNumberToSet;
      // Popolamento delle variabili di work
      TrsToWork();
    } else {
      // Si sta tentando di impostare una riga non valida
      l_bResult = false;
    }
    return l_bResult;
  }
  public void AppendRow() {
    CPLib.AppendToTrs(m_oTrs,new TrsRow());
    m_nCurrentRow = Rows()-1;
    // Salvataggio dei valori delle variabili di work nel transitorio
    WorkToTrs();
  }
  public void AddTrsDeletedRow() {
    // Aggiunta di una riga nel transitorio delle righe cancellate.
    int l_nRows;
    CPLib.AppendToTrs(m_oDeletedRows,new TrsRow());
    l_nRows = m_oDeletedRows.size()-1;
    m_oDeletedRows.get(l_nRows).w_VOCE=w_VOCE;
    m_oDeletedRows.get(l_nRows).w_SOTTOVOCE=w_SOTTOVOCE;
    m_oDeletedRows.get(l_nRows).w_RESID=w_RESID;
    m_oDeletedRows.get(l_nRows).w_PROVINCIA=w_PROVINCIA;
    m_oDeletedRows.get(l_nRows).w_STATO=w_STATO;
    m_oDeletedRows.get(l_nRows).w_VAL01217=w_VAL01217;
    m_oDeletedRows.get(l_nRows).w_VAL02147=w_VAL02147;
    m_oDeletedRows.get(l_nRows).w_VAL02148=w_VAL02148;
    m_oDeletedRows.get(l_nRows).w_VAL02149=w_VAL02149;
    m_oDeletedRows.get(l_nRows).w_DATAEFF=w_DATAEFF;
    m_oDeletedRows.get(l_nRows).w_IMPORTO=w_IMPORTO;
    m_oDeletedRows.get(l_nRows).w_IDBASEA7=w_IDBASEA7;
    m_oDeletedRows.get(l_nRows).w_CPROWNUM=w_CPROWNUM;
    m_oDeletedRows.get(l_nRows).w_FLGRESID=w_FLGRESID;
    m_oDeletedRows.get(l_nRows).w_FLG00015=w_FLG00015;
    m_oDeletedRows.get(l_nRows).w_FLG00016=w_FLG00016;
    m_oDeletedRows.get(l_nRows).w_FLG01217=w_FLG01217;
    m_oDeletedRows.get(l_nRows).w_FLG02147=w_FLG02147;
    m_oDeletedRows.get(l_nRows).w_FLG02148=w_FLG02148;
    m_oDeletedRows.get(l_nRows).w_FLG02149=w_FLG02149;
    m_oDeletedRows.get(l_nRows).w_xDESCRI=w_xDESCRI;
    m_oDeletedRows.get(l_nRows).w_xDESVOCE=w_xDESVOCE;
    m_oDeletedRows.get(l_nRows).m_nCPRowNum=m_nCPRowNum;
    m_oDeletedRows.get(l_nRows).work_children=CPLib.GetClone(work_children);
    m_oDeletedRows.get(l_nRows).m_nRowStatus=3;
    m_oDeletedRows.get(l_nRows).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public boolean SaveRow() {
    return CanSaveConditionallyRow(true);
  }
  boolean CanSaveConditionallyRow(boolean p_bSaveWork) {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
      if ((CPLib.eq(w_FLGRESID,"S")) && (CPLib.Empty(w_RESID) && MVCFXMIIPY_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_RESID));
        String obblMsgError = m_Ctx.Translate("Residenza")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_RESID = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "RESID";
        }
      } else if ((CPLib.eq(w_FLG00015,"S")) && (CPLib.Empty(w_PROVINCIA) && SNYJQPAYYR_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_PROVINCIA));
        String obblMsgError = m_Ctx.Translate("Provincia")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_PROVINCIA = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "PROVINCIA";
        }
      } else if ((CPLib.eq(w_FLG00016,"S")) && (CPLib.Empty(w_STATO) && MDEBFTECJW_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_STATO));
        String obblMsgError = m_Ctx.Translate("Stato")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_STATO = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "STATO";
        }
      } else if ((CPLib.eq(w_FLG01217,"S")) && (CPLib.Empty(w_VAL01217) && NHFRSWSJPA_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_VAL01217));
        String obblMsgError = m_Ctx.Translate("Oggetto dei reclami")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_VAL01217 = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "VAL01217";
        }
      } else if ((CPLib.eq(w_FLG02147,"S")) && (CPLib.Empty(w_VAL02147) && KYDBUIQLMM_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_VAL02147));
        String obblMsgError = m_Ctx.Translate("Tipo Restituzione")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_VAL02147 = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "VAL02147";
        }
      } else if ((CPLib.eq(w_FLG02148,"S")) && (CPLib.Empty(w_VAL02148) && CNCQNTLDXJ_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_VAL02148));
        String obblMsgError = m_Ctx.Translate("Data Efficacia")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_VAL02148 = CPLib.NullDate();
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "VAL02148";
        }
      } else if ((CPLib.eq(w_FLG02149,"S")) && (CPLib.Empty(w_VAL02149) && PDCPOALMKJ_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_VAL02149));
        String obblMsgError = m_Ctx.Translate("Progressivo Manovra")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_VAL02149 = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "VAL02149";
        }
      } else if (CPLib.Empty(w_IMPORTO)) {
        l_bNoObligatory =  ! (CPLib.Empty(w_IMPORTO));
        String obblMsgError = m_Ctx.Translate("Importo/Numero")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_IMPORTO = 0;
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "IMPORTO";
        }
      }
      if ( ! (l_bNoObligatory)) {
        m_nLastError = 1;
      }
      if (l_bResult && p_bSaveWork) {
        // Salvataggio della riga corrente nel transitorio
        WorkToTrs();
      }
    }
    return l_bResult;
  }
  public void ChangeRow(int p_nRowNumberToSet) {
    /*  Cambia la riga corrente.
                                Se la riga richiesta non esiste ne viene inizializzata un'altra.
                              */
    boolean l_bResult;
    l_bResult = SetRow(p_nRowNumberToSet);
    if ( ! (l_bResult)) {
      // Inizializzazione di una nuova riga
      AddRow();
    }
  }
  public String RowStatus() {
    switch (m_nRowStatus) {
      case 2:
      return "A";
      case 0:
      return " ";
      case 1:
      return "U";
      case 3:
      return "D";
    }
    return "";
  }
  public boolean IsRowUpdated() {
    return CPLib.eq(m_nRowStatus,2) || CPLib.eq(m_nRowStatus,1) || CPLib.eq(m_nRowStatus,3);
  }
  public boolean IsRowNew() {
    return CPLib.eq(m_nRowStatus,2);
  }
  public int Rows() {
    /*  Restituisce il numero di righe del transitorio.
                              */
    return m_oTrs.size();
  }
  public int DeletedRows() {
    /*  Restituisce il numero di righe del transitorio.
                              */
    return m_oDeletedRows.size();
  }
  public boolean DeleteRow() {
    /*  Cancellazione nel transitorio di una riga. La riga cancellata
                                viene scritta nel transitorio delle righe cancellate.
                              */
    if ( ! (CanDeleteRow())) {
      return false;
    }
    SubtractTotals();
    // Le variabili di work vengono salvate nel transitorio delle righe cancellate
    if (CPLib.ne(m_nRowStatus,2)) {
      AddTrsDeletedRow();
    }
    // Cancellazione della riga corrente
    m_oTrs.remove(m_nCurrentRow);
    // Assegnazione della nuova riga valida
    m_nCurrentRow = Rows()-1;
    if (CPLib.eq(m_nCurrentRow,-1)) {
      m_nCurrentRow = 0;
    }
    m_bUpdated = true;
    // Esecuzione dei calcoli
    Calculate();
    return true;
  }
  void SubtractTotals() {
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_VOCE));
  }
  void SetModified() {
    /*  Segna la riga corrente del transitorio come modificata se non è una riga aggiunta
                              */
    int l_nStatus;
    if (CPLib.gt(Rows(),0)) {
      l_nStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
      if (CPLib.ne(l_nStatus,2)) {
        m_nRowStatus = 1;
      }
    } else {
      m_nRowStatus = 2;
    }
  }
  void SetDeletedRow(double p_nRowNumberToSet) {
    int l_RowNumberToSet;
    l_RowNumberToSet = (int)p_nRowNumberToSet;
    w_VOCE= m_oDeletedRows.get(l_RowNumberToSet).w_VOCE;
    w_SOTTOVOCE= m_oDeletedRows.get(l_RowNumberToSet).w_SOTTOVOCE;
    w_RESID= m_oDeletedRows.get(l_RowNumberToSet).w_RESID;
    w_PROVINCIA= m_oDeletedRows.get(l_RowNumberToSet).w_PROVINCIA;
    w_STATO= m_oDeletedRows.get(l_RowNumberToSet).w_STATO;
    w_VAL01217= m_oDeletedRows.get(l_RowNumberToSet).w_VAL01217;
    w_VAL02147= m_oDeletedRows.get(l_RowNumberToSet).w_VAL02147;
    w_VAL02148= m_oDeletedRows.get(l_RowNumberToSet).w_VAL02148;
    w_VAL02149= m_oDeletedRows.get(l_RowNumberToSet).w_VAL02149;
    w_DATAEFF= m_oDeletedRows.get(l_RowNumberToSet).w_DATAEFF;
    w_IMPORTO= m_oDeletedRows.get(l_RowNumberToSet).w_IMPORTO;
    w_IDBASEA7= m_oDeletedRows.get(l_RowNumberToSet).w_IDBASEA7;
    w_CPROWNUM= m_oDeletedRows.get(l_RowNumberToSet).w_CPROWNUM;
    w_FLGRESID= m_oDeletedRows.get(l_RowNumberToSet).w_FLGRESID;
    w_FLG00015= m_oDeletedRows.get(l_RowNumberToSet).w_FLG00015;
    w_FLG00016= m_oDeletedRows.get(l_RowNumberToSet).w_FLG00016;
    w_FLG01217= m_oDeletedRows.get(l_RowNumberToSet).w_FLG01217;
    w_FLG02147= m_oDeletedRows.get(l_RowNumberToSet).w_FLG02147;
    w_FLG02148= m_oDeletedRows.get(l_RowNumberToSet).w_FLG02148;
    w_FLG02149= m_oDeletedRows.get(l_RowNumberToSet).w_FLG02149;
    w_xDESCRI= m_oDeletedRows.get(l_RowNumberToSet).w_xDESCRI;
    w_xDESVOCE= m_oDeletedRows.get(l_RowNumberToSet).w_xDESVOCE;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
