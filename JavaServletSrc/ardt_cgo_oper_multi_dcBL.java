import java.util.*;

public class ardt_cgo_oper_multi_dcBL extends ardt_cgo_oper_multi_dcWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public java.sql.Date w_DATOPE;
    public String w_TIPOGIOCO;
    public String w_CAIDBIGLIETTO;
    public double w_TOTLIRE;
    public String w_FLGFULL;
    public double w_CPROWNUM;
    public String w_NUMOPEDL;
    public double w_ROWNUMDL;
    public double w_CACODICE;
    public String w_CODLOB;
    public double w_CATIPGIO;
    public double w_CATIPCON;
    public String w_CGOTIPOPE;
    public double w_impmin;
    public String w_messaggio;
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
  public static final String i_EntityName = "ardt_cgo_oper_multi_dc";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_operazioni_dl_multi_dt_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dt_dc;
  public CPPhTableWrInfo m_oWrInfo_cgo_operazioni_dl_multi_dt_dc;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_operazioni_dl_multi_dt_dc;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public CPPhTableWrInfo m_oWrInfo_cgo_tbtipgio;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_operazioni_dl_multi_dt_dc"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'SNAINUMOPE':SNAINUMOPE,'snainumope_sel':snainumope_sel,'m_Detail':{'DATOPE':DATOPE,'TIPOGIOCO':TIPOGIOCO,'CAIDBIGLIETTO':CAIDBIGLIETTO,'TOTLIRE':TOTLIRE,'FLGFULL':FLGFULL,'CPROWNUM':CPROWNUM,'NUMOPEDL':NUMOPEDL,'ROWNUMDL':ROWNUMDL,'CGOTIPOPE':CGOTIPOPE,'messaggio':messaggio"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",true,true)+"}"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'SNAINUMOPE':SNAINUMOPE,'dc':dc,'DATOPE_P':DATOPE_P,'SEGNO_P':SEGNO_P,'CGOTIPOPE_P':CGOTIPOPE_P,'snainumope_sel':snainumope_sel,'m_Detail':{'DATOPE':DATOPE,'TIPOGIOCO':TIPOGIOCO,'CAIDBIGLIETTO':CAIDBIGLIETTO,'TOTLIRE':TOTLIRE,'FLGFULL':FLGFULL,'CPROWNUM':CPROWNUM,'NUMOPEDL':NUMOPEDL,'ROWNUMDL':ROWNUMDL,'CACODICE':CACODICE,'CODLOB':CODLOB,'CATIPGIO':CATIPGIO,'CATIPCON':CATIPCON,'CGOTIPOPE':CGOTIPOPE,'impmin':impmin,'messaggio':messaggio"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",true,true)+"},'TOTALE':TOTALE"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",true,false)+"}";
  public static final String i_ItemSequence = "SNAINUMOPE,snainumope_sel,m_Detail[ DATOPE TIPOGIOCO CAIDBIGLIETTO TOTLIRE FLGFULL CPROWNUM NUMOPEDL ROWNUMDL CGOTIPOPE messaggio"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",false,true)+"]"+FoundlingChildrenList("ardt_cgo_oper_multi_dc",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("ardt_cgo_oper_multi_dc"),new String[][]{new String[]{"SNAINUMOPE","N° Operazione","C","15","0","campo","key1","false","false"},new String[]{"snainumope_sel","","C","15","0","variabile","nokey","false","false"},new String[]{"DATOPE","Data Operazione","D","8","0","campo","nokey","true","false"},new String[]{"TIPOGIOCO","Tipo gioco","C","3","0","campo","nokey","true","false"},new String[]{"CAIDBIGLIETTO","ID BIGLIETTO","C","30","0","campo","nokey","true","false"},new String[]{"TOTLIRE","Importo","N","15","2","campo","nokey","true","false"},new String[]{"FLGFULL","Operazione completa","C","1","0","campo","nokey","true","false"},new String[]{"CPROWNUM","N° Riga ","N","4","0","campo","key1","true","false"},new String[]{"NUMOPEDL","Operazione Associata","C","15","0","campo","nokey","true","false"},new String[]{"ROWNUMDL","Numero Riga Selezionata","N","4","0","campo","nokey","true","false"},new String[]{"CGOTIPOPE","Tipo Gioco","C","1","0","campo","nokey","true","false"},new String[]{"messaggio","messaggio da visualizzare","C","200","0","variabile","nokey","true","false"}});
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
  public ardt_cgo_oper_multi_dcBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt_dc",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt_dc");
    m_oWrInfo_cgo_operazioni_dl_multi_dt_dc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_operazioni_dl_multi_dt_dc",p_ContextObject.GetCompany());
    m_cVirtName_cgo_operazioni_dl_multi_dt_dc = CPSql.ManipulateTablePhName("cgo_operazioni_dl_multi_dt_dc",m_cServer_cgo_operazioni_dl_multi_dt_dc);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_oWrInfo_cgo_tbtipgio = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tbtipgio",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("ardt_cgo_oper_multi_dc",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_SNAINUMOPE = "";
    w_DATOPE_P = CPLib.NullDate();
    w_snainumope_sel = "";
    w_DATOPE = CPLib.NullDate();
    w_CAIDBIGLIETTO = "";
    w_TOTLIRE = 0;
    w_CPROWNUM = 0;
    w_NUMOPEDL = "";
    w_ROWNUMDL = 0;
    w_CACODICE = 0;
    w_CODLOB = "";
    w_CATIPGIO = 0;
    w_CATIPCON = 0;
    w_CGOTIPOPE = "";
    w_impmin = 0;
    w_messaggio = "";
    w_TOTALE = 0;
    w_dc = "N";
    w_SEGNO_P = "";
    w_SEGNO_P = Utilities.Make(m_Ctx).GetCallerString("SEGNO");
    w_CGOTIPOPE_P = "";
    w_CGOTIPOPE_P = Utilities.Make(m_Ctx).GetCallerString("CGOTIPOPE");
    w_TIPOGIOCO = "A";
    Link_BENOJFALBB();
    w_FLGFULL = "N";
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
    o_TOTLIRE = w_TOTLIRE;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_BENOJFALBB() {
    return Link_BENOJFALBB("Full");
  }
  protected boolean Link_BENOJFALBB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPOGIOCO))) {
      String l_OldValue = w_TIPOGIOCO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPOGIOCO,"C",3,0),m_cServer_cgo_tbtipgio,w_TIPOGIOCO);
      if (m_Ctx.IsSharedTemp("cgo_tbtipgio")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cgo_tbtipgio,"select CODTPGIO,IMPMINGIO from "+m_cPhName_cgo_tbtipgio+((m_cPhName_cgo_tbtipgio).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODTPGIO"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPOGIOCO = l_rsLink.GetString("CODTPGIO");
          w_impmin = l_rsLink.GetDouble("IMPMINGIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_BENOJFALBB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPOGIOCO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPOGIOCO");
          }
          m_cLastWorkVarError = "TIPOGIOCO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_BENOJFALBB_blank();
    }
    return l_bResult;
  }
  void Link_BENOJFALBB_blank() {
    w_TIPOGIOCO = "";
    w_impmin = 0;
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_SNAINUMOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SNAINUMOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_snainumope_sel(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_snainumope_sel = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATOPE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DATOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOGIOCO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_TIPOGIOCO = p_workVariableValue;
    l_bResult = Link_BENOJFALBB();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOGIOCO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAIDBIGLIETTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CAIDBIGLIETTO = p_workVariableValue;
    // 
    l_bResult = (CPLib.eq(w_CGOTIPOPE,"V")?true:arfn_cgo_chkidbR.Make(m_Ctx,this).Run(w_CAIDBIGLIETTO));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CAIDBIGLIETTO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TOTLIRE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    // Storno dei totali
    w_TOTALE = w_TOTALE-w_TOTLIRE;
    w_TOTLIRE = p_workVariableValue;
    // Aggiornamento dei totali
    w_TOTALE = w_TOTALE+w_TOTLIRE;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGFULL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_FLGFULL = p_workVariableValue;
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
  public boolean Set_NUMOPEDL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_NUMOPEDL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ROWNUMDL(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ROWNUMDL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CGOTIPOPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CGOTIPOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_messaggio(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_messaggio = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_FLGFULL() {
    return false;
  }
  public boolean getVisible_snainumope_sel() {
    return true;
  }
  public boolean getVisible_CPROWNUM() {
    return true;
  }
  public boolean getVisible_NUMOPEDL() {
    return true;
  }
  public boolean getVisible_ROWNUMDL() {
    return true;
  }
  public boolean getVisible_CGOTIPOPE() {
    return true;
  }
  public boolean getVisible_messaggio() {
    return true;
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
    w_SEGNO_P = Utilities.Make(m_Ctx).GetCallerString("SEGNO");
    w_CGOTIPOPE_P = Utilities.Make(m_Ctx).GetCallerString("CGOTIPOPE");
    if (CPLib.ne(o_TOTLIRE,w_TOTLIRE)) {
      Calculation_INBQRQVGTC();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_INBQRQVGTC() {
    w_FLGFULL = (CPLib.Empty(w_NUMOPEDL)?(CPLib.le(w_TOTLIRE,w_impmin)?"S":"N"):w_FLGFULL);
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
  public final static String[] m_KeyColumns = {"SNAINUMOPE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("ardt_cgo_oper_multi_dc","cgo_operazioni_dl_multi_dt_dc",m_KeyColumns,m_Ctx);
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
    w_SNAINUMOPE = "";
    w_dc = "";
    w_DATOPE_P = CPLib.NullDate();
    w_SEGNO_P = "";
    w_CGOTIPOPE_P = "";
    w_snainumope_sel = "";
    w_DATOPE = CPLib.NullDate();
    w_TIPOGIOCO = "";
    w_CAIDBIGLIETTO = "";
    w_TOTLIRE = 0;
    w_FLGFULL = "";
    w_CPROWNUM = 0;
    w_NUMOPEDL = "";
    w_ROWNUMDL = 0;
    w_CACODICE = 0;
    w_CODLOB = "";
    w_CATIPGIO = 0;
    w_CATIPCON = 0;
    w_CGOTIPOPE = "";
    w_impmin = 0;
    w_messaggio = "";
    w_TOTALE = 0;
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
      Properties p_DATOPE;
      p_DATOPE = CPLib.GetProperties(trs_p.getProperty("DATOPE"),new Properties());
      Properties p_TIPOGIOCO;
      p_TIPOGIOCO = CPLib.GetProperties(trs_p.getProperty("TIPOGIOCO"),new Properties());
      Properties p_CAIDBIGLIETTO;
      p_CAIDBIGLIETTO = CPLib.GetProperties(trs_p.getProperty("CAIDBIGLIETTO"),new Properties());
      Properties p_TOTLIRE;
      p_TOTLIRE = CPLib.GetProperties(trs_p.getProperty("TOTLIRE"),new Properties());
      Properties p_FLGFULL;
      p_FLGFULL = CPLib.GetProperties(trs_p.getProperty("FLGFULL"),new Properties());
      Properties p_CPROWNUM;
      p_CPROWNUM = CPLib.GetProperties(trs_p.getProperty("CPROWNUM"),new Properties());
      Properties p_NUMOPEDL;
      p_NUMOPEDL = CPLib.GetProperties(trs_p.getProperty("NUMOPEDL"),new Properties());
      Properties p_ROWNUMDL;
      p_ROWNUMDL = CPLib.GetProperties(trs_p.getProperty("ROWNUMDL"),new Properties());
      Properties p_CACODICE;
      p_CACODICE = CPLib.GetProperties(trs_p.getProperty("CACODICE"),new Properties());
      Properties p_CODLOB;
      p_CODLOB = CPLib.GetProperties(trs_p.getProperty("CODLOB"),new Properties());
      Properties p_CATIPGIO;
      p_CATIPGIO = CPLib.GetProperties(trs_p.getProperty("CATIPGIO"),new Properties());
      Properties p_CATIPCON;
      p_CATIPCON = CPLib.GetProperties(trs_p.getProperty("CATIPCON"),new Properties());
      Properties p_CGOTIPOPE;
      p_CGOTIPOPE = CPLib.GetProperties(trs_p.getProperty("CGOTIPOPE"),new Properties());
      Properties p_impmin;
      p_impmin = CPLib.GetProperties(trs_p.getProperty("impmin"),new Properties());
      Properties p_messaggio;
      p_messaggio = CPLib.GetProperties(trs_p.getProperty("messaggio"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_SNAINUMOPE = CPLib.GetProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
      w_dc = CPLib.GetProperty(p,"dc",w_dc,0);
      w_DATOPE_P = CPLib.GetProperty(p,"DATOPE_P",w_DATOPE_P,0);
      w_SEGNO_P = CPLib.GetProperty(p,"SEGNO_P",w_SEGNO_P,0);
      w_CGOTIPOPE_P = CPLib.GetProperty(p,"CGOTIPOPE_P",w_CGOTIPOPE_P,0);
      w_TOTALE = CPLib.GetProperty(p,"TOTALE",w_TOTALE,0);
      w_snainumope_sel = CPLib.GetProperty(p,"snainumope_sel",w_snainumope_sel,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_DATOPE = CPLib.NullDate();
        w_DATOPE = CPLib.GetProperty(p_DATOPE,"",w_DATOPE,i);
        w_TIPOGIOCO = "";
        w_TIPOGIOCO = CPLib.GetProperty(p_TIPOGIOCO,"",w_TIPOGIOCO,i);
        w_CAIDBIGLIETTO = "";
        w_CAIDBIGLIETTO = CPLib.GetProperty(p_CAIDBIGLIETTO,"",w_CAIDBIGLIETTO,i);
        w_TOTLIRE = 0;
        w_TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",w_TOTLIRE,i);
        w_FLGFULL = "";
        w_FLGFULL = CPLib.GetProperty(p_FLGFULL,"",w_FLGFULL,i);
        w_CPROWNUM = 0;
        w_CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",w_CPROWNUM,i);
        w_NUMOPEDL = "";
        w_NUMOPEDL = CPLib.GetProperty(p_NUMOPEDL,"",w_NUMOPEDL,i);
        w_ROWNUMDL = 0;
        w_ROWNUMDL = CPLib.GetProperty(p_ROWNUMDL,"",w_ROWNUMDL,i);
        w_CACODICE = 0;
        w_CACODICE = CPLib.GetProperty(p_CACODICE,"",w_CACODICE,i);
        w_CODLOB = "";
        w_CODLOB = CPLib.GetProperty(p_CODLOB,"",w_CODLOB,i);
        w_CATIPGIO = 0;
        w_CATIPGIO = CPLib.GetProperty(p_CATIPGIO,"",w_CATIPGIO,i);
        w_CATIPCON = 0;
        w_CATIPCON = CPLib.GetProperty(p_CATIPCON,"",w_CATIPCON,i);
        w_CGOTIPOPE = "";
        w_CGOTIPOPE = CPLib.GetProperty(p_CGOTIPOPE,"",w_CGOTIPOPE,i);
        w_impmin = 0;
        w_impmin = CPLib.GetProperty(p_impmin,"",w_impmin,i);
        w_messaggio = "";
        w_messaggio = CPLib.GetProperty(p_messaggio,"",w_messaggio,i);
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
    if (CPLib.eq(p_cName,"SNAINUMOPE")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"snainumope_sel")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"DATOPE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"TIPOGIOCO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CAIDBIGLIETTO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"TOTLIRE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"FLGFULL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CPROWNUM")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"NUMOPEDL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ROWNUMDL")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CGOTIPOPE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"messaggio")) {
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
    items = tables.get("cgo_tbtipgio");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_tbtipgio",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODTPGIO","IMPMINGIO"});
    map.put("rd_var",new String[]{"w_TIPOGIOCO","w_impmin"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000010",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00002",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo gioco\u0000Importo minimo autovalidazione multiple",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cgo_tbtipgio\u0000false\u0000false\u00001\u00000\u0000armt_cgo_tbtipgio\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("ardt_cgo_oper_multi_dc",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_cgo_oper_multi_dc",child);
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
    for(String child : CPLib.LoadableMNTs("ardt_cgo_oper_multi_dc",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_cgo_oper_multi_dc",child);
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
    m_MNTs = CPLib.MNTChilds("ardt_cgo_oper_multi_dc",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    int l_nRows;
    l_bResult = true;
    if ( ! (CPLib.Empty(w_DATOPE)) &&  ! (CPLib.Empty(w_CAIDBIGLIETTO)) && CPLib.gt(w_TOTLIRE,0)) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
    }
    if ( ! (l_bNoCheck)) {
      m_nLastError = 2;
    }
    l_nRows = Rows();
    if ( ! (CPLib.le(0,l_nRows) && CPLib.le(l_nRows,999))) {
      m_nLastError = 2;
      m_cLastMsgError = m_Ctx.Translate("MSG_MINMAX_ROW","0","999");
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
      l_Keys = new String[]{"ardt_cgo_oper_multi_dc"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"ardt_cgo_oper_multi_dc\\"+p_cState};
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
    o_TOTLIRE = 0;
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
    Properties p_DATOPE;
    p_DATOPE = new Properties();
    Properties p_TIPOGIOCO;
    p_TIPOGIOCO = new Properties();
    Properties p_CAIDBIGLIETTO;
    p_CAIDBIGLIETTO = new Properties();
    Properties p_TOTLIRE;
    p_TOTLIRE = new Properties();
    Properties p_FLGFULL;
    p_FLGFULL = new Properties();
    Properties p_CPROWNUM;
    p_CPROWNUM = new Properties();
    Properties p_NUMOPEDL;
    p_NUMOPEDL = new Properties();
    Properties p_ROWNUMDL;
    p_ROWNUMDL = new Properties();
    Properties p_CACODICE;
    p_CACODICE = new Properties();
    Properties p_CODLOB;
    p_CODLOB = new Properties();
    Properties p_CATIPGIO;
    p_CATIPGIO = new Properties();
    Properties p_CATIPCON;
    p_CATIPCON = new Properties();
    Properties p_CGOTIPOPE;
    p_CGOTIPOPE = new Properties();
    Properties p_impmin;
    p_impmin = new Properties();
    Properties p_messaggio;
    p_messaggio = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"SNAINUMOPE",w_SNAINUMOPE,0);
    CPLib.PutProperty(p,"dc",w_dc,0);
    CPLib.PutProperty(p,"DATOPE_P",w_DATOPE_P,0);
    CPLib.PutProperty(p,"SEGNO_P",w_SEGNO_P,0);
    CPLib.PutProperty(p,"CGOTIPOPE_P",w_CGOTIPOPE_P,0);
    CPLib.PutProperty(p,"TOTALE",w_TOTALE,0);
    CPLib.PutProperty(p,"snainumope_sel",w_snainumope_sel,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_DATOPE,"",w_DATOPE,trsrow);
      CPLib.PutProperty(p_TIPOGIOCO,"",w_TIPOGIOCO,trsrow);
      CPLib.PutProperty(p_CAIDBIGLIETTO,"",w_CAIDBIGLIETTO,trsrow);
      CPLib.PutProperty(p_TOTLIRE,"",w_TOTLIRE,trsrow);
      CPLib.PutProperty(p_FLGFULL,"",w_FLGFULL,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_NUMOPEDL,"",w_NUMOPEDL,trsrow);
      CPLib.PutProperty(p_ROWNUMDL,"",w_ROWNUMDL,trsrow);
      CPLib.PutProperty(p_CACODICE,"",w_CACODICE,trsrow);
      CPLib.PutProperty(p_CODLOB,"",w_CODLOB,trsrow);
      CPLib.PutProperty(p_CATIPGIO,"",w_CATIPGIO,trsrow);
      CPLib.PutProperty(p_CATIPCON,"",w_CATIPCON,trsrow);
      CPLib.PutProperty(p_CGOTIPOPE,"",w_CGOTIPOPE,trsrow);
      CPLib.PutProperty(p_impmin,"",w_impmin,trsrow);
      CPLib.PutProperty(p_messaggio,"",w_messaggio,trsrow);
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
      CPLib.PutProperty(p_DATOPE,"",w_DATOPE,trsrow);
      CPLib.PutProperty(p_TIPOGIOCO,"",w_TIPOGIOCO,trsrow);
      CPLib.PutProperty(p_CAIDBIGLIETTO,"",w_CAIDBIGLIETTO,trsrow);
      CPLib.PutProperty(p_TOTLIRE,"",w_TOTLIRE,trsrow);
      CPLib.PutProperty(p_FLGFULL,"",w_FLGFULL,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_NUMOPEDL,"",w_NUMOPEDL,trsrow);
      CPLib.PutProperty(p_ROWNUMDL,"",w_ROWNUMDL,trsrow);
      CPLib.PutProperty(p_CACODICE,"",w_CACODICE,trsrow);
      CPLib.PutProperty(p_CODLOB,"",w_CODLOB,trsrow);
      CPLib.PutProperty(p_CATIPGIO,"",w_CATIPGIO,trsrow);
      CPLib.PutProperty(p_CATIPCON,"",w_CATIPCON,trsrow);
      CPLib.PutProperty(p_CGOTIPOPE,"",w_CGOTIPOPE,trsrow);
      CPLib.PutProperty(p_impmin,"",w_impmin,trsrow);
      CPLib.PutProperty(p_messaggio,"",w_messaggio,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("DATOPE",CPLib.ToProperties(p_DATOPE));
    trs_p.setProperty("TIPOGIOCO",CPLib.ToProperties(p_TIPOGIOCO));
    trs_p.setProperty("CAIDBIGLIETTO",CPLib.ToProperties(p_CAIDBIGLIETTO));
    trs_p.setProperty("TOTLIRE",CPLib.ToProperties(p_TOTLIRE));
    trs_p.setProperty("FLGFULL",CPLib.ToProperties(p_FLGFULL));
    trs_p.setProperty("CPROWNUM",CPLib.ToProperties(p_CPROWNUM));
    trs_p.setProperty("NUMOPEDL",CPLib.ToProperties(p_NUMOPEDL));
    trs_p.setProperty("ROWNUMDL",CPLib.ToProperties(p_ROWNUMDL));
    trs_p.setProperty("CACODICE",CPLib.ToProperties(p_CACODICE));
    trs_p.setProperty("CODLOB",CPLib.ToProperties(p_CODLOB));
    trs_p.setProperty("CATIPGIO",CPLib.ToProperties(p_CATIPGIO));
    trs_p.setProperty("CATIPCON",CPLib.ToProperties(p_CATIPCON));
    trs_p.setProperty("CGOTIPOPE",CPLib.ToProperties(p_CGOTIPOPE));
    trs_p.setProperty("impmin",CPLib.ToProperties(p_impmin));
    trs_p.setProperty("messaggio",CPLib.ToProperties(p_messaggio));
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
    return "cgo_operazioni_dl_multi_dt_dc"+"\\"+CPLib.ToCPStr(p_Caller.GetString("SNAINUMOPE","C",15,0));
  }
  public String RowPrimaryKey() {
    return "cgo_operazioni_dl_multi_dt_dc"+"\\"+CPLib.ToCPStr(w_CPROWNUM);
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
    w_DATOPE= m_oTrs.get(m_nCurrentRow).w_DATOPE;
    w_TIPOGIOCO= m_oTrs.get(m_nCurrentRow).w_TIPOGIOCO;
    w_CAIDBIGLIETTO= m_oTrs.get(m_nCurrentRow).w_CAIDBIGLIETTO;
    w_TOTLIRE= m_oTrs.get(m_nCurrentRow).w_TOTLIRE;
    w_FLGFULL= m_oTrs.get(m_nCurrentRow).w_FLGFULL;
    w_CPROWNUM= m_oTrs.get(m_nCurrentRow).w_CPROWNUM;
    w_NUMOPEDL= m_oTrs.get(m_nCurrentRow).w_NUMOPEDL;
    w_ROWNUMDL= m_oTrs.get(m_nCurrentRow).w_ROWNUMDL;
    w_CACODICE= m_oTrs.get(m_nCurrentRow).w_CACODICE;
    w_CODLOB= m_oTrs.get(m_nCurrentRow).w_CODLOB;
    w_CATIPGIO= m_oTrs.get(m_nCurrentRow).w_CATIPGIO;
    w_CATIPCON= m_oTrs.get(m_nCurrentRow).w_CATIPCON;
    w_CGOTIPOPE= m_oTrs.get(m_nCurrentRow).w_CGOTIPOPE;
    w_impmin= m_oTrs.get(m_nCurrentRow).w_impmin;
    w_messaggio= m_oTrs.get(m_nCurrentRow).w_messaggio;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_DATOPE=w_DATOPE;
    m_oTrs.get(m_nCurrentRow).w_TIPOGIOCO=w_TIPOGIOCO;
    m_oTrs.get(m_nCurrentRow).w_CAIDBIGLIETTO=w_CAIDBIGLIETTO;
    m_oTrs.get(m_nCurrentRow).w_TOTLIRE=w_TOTLIRE;
    m_oTrs.get(m_nCurrentRow).w_FLGFULL=w_FLGFULL;
    m_oTrs.get(m_nCurrentRow).w_CPROWNUM=w_CPROWNUM;
    m_oTrs.get(m_nCurrentRow).w_NUMOPEDL=w_NUMOPEDL;
    m_oTrs.get(m_nCurrentRow).w_ROWNUMDL=w_ROWNUMDL;
    m_oTrs.get(m_nCurrentRow).w_CACODICE=w_CACODICE;
    m_oTrs.get(m_nCurrentRow).w_CODLOB=w_CODLOB;
    m_oTrs.get(m_nCurrentRow).w_CATIPGIO=w_CATIPGIO;
    m_oTrs.get(m_nCurrentRow).w_CATIPCON=w_CATIPCON;
    m_oTrs.get(m_nCurrentRow).w_CGOTIPOPE=w_CGOTIPOPE;
    m_oTrs.get(m_nCurrentRow).w_impmin=w_impmin;
    m_oTrs.get(m_nCurrentRow).w_messaggio=w_messaggio;
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
    w_DATOPE = CPLib.NullDate();
    w_TIPOGIOCO = "";
    w_CAIDBIGLIETTO = "";
    w_TOTLIRE = 0;
    w_FLGFULL = "";
    w_NUMOPEDL = "";
    w_ROWNUMDL = 0;
    w_CACODICE = 0;
    w_CODLOB = "";
    w_CATIPGIO = 0;
    w_CATIPCON = 0;
    w_CGOTIPOPE = "";
    w_impmin = 0;
    w_messaggio = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if (CPLib.Empty(w_TIPOGIOCO)) {
      w_TIPOGIOCO = "A";
    }
    if ( ! (CPLib.Empty(w_TIPOGIOCO))) {
      l_bTmpRes = Link_BENOJFALBB();
    }
    w_FLGFULL = "N";
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
    m_oDeletedRows.get(l_nRows).w_DATOPE=w_DATOPE;
    m_oDeletedRows.get(l_nRows).w_TIPOGIOCO=w_TIPOGIOCO;
    m_oDeletedRows.get(l_nRows).w_CAIDBIGLIETTO=w_CAIDBIGLIETTO;
    m_oDeletedRows.get(l_nRows).w_TOTLIRE=w_TOTLIRE;
    m_oDeletedRows.get(l_nRows).w_FLGFULL=w_FLGFULL;
    m_oDeletedRows.get(l_nRows).w_CPROWNUM=w_CPROWNUM;
    m_oDeletedRows.get(l_nRows).w_NUMOPEDL=w_NUMOPEDL;
    m_oDeletedRows.get(l_nRows).w_ROWNUMDL=w_ROWNUMDL;
    m_oDeletedRows.get(l_nRows).w_CACODICE=w_CACODICE;
    m_oDeletedRows.get(l_nRows).w_CODLOB=w_CODLOB;
    m_oDeletedRows.get(l_nRows).w_CATIPGIO=w_CATIPGIO;
    m_oDeletedRows.get(l_nRows).w_CATIPCON=w_CATIPCON;
    m_oDeletedRows.get(l_nRows).w_CGOTIPOPE=w_CGOTIPOPE;
    m_oDeletedRows.get(l_nRows).w_impmin=w_impmin;
    m_oDeletedRows.get(l_nRows).w_messaggio=w_messaggio;
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
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    int l_nRows;
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
      if ( ! ((CPLib.eq(w_CGOTIPOPE,"V")?true:arfn_cgo_chkidbR.Make(m_Ctx,this).Run(w_CAIDBIGLIETTO)))) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = m_Ctx.Translate("ID BIGLIETTO")+" : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
        l_bResult = false;
        w_CAIDBIGLIETTO = "";
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "CAIDBIGLIETTO";
        }
      }
      if ( ! (l_bNoCheck)) {
        m_nLastError = 2;
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
    w_TOTALE = w_TOTALE-w_TOTLIRE;
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_DATOPE)) &&  ! (CPLib.Empty(w_CAIDBIGLIETTO)) && CPLib.gt(w_TOTLIRE,0);
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
    w_DATOPE= m_oDeletedRows.get(l_RowNumberToSet).w_DATOPE;
    w_TIPOGIOCO= m_oDeletedRows.get(l_RowNumberToSet).w_TIPOGIOCO;
    w_CAIDBIGLIETTO= m_oDeletedRows.get(l_RowNumberToSet).w_CAIDBIGLIETTO;
    w_TOTLIRE= m_oDeletedRows.get(l_RowNumberToSet).w_TOTLIRE;
    w_FLGFULL= m_oDeletedRows.get(l_RowNumberToSet).w_FLGFULL;
    w_CPROWNUM= m_oDeletedRows.get(l_RowNumberToSet).w_CPROWNUM;
    w_NUMOPEDL= m_oDeletedRows.get(l_RowNumberToSet).w_NUMOPEDL;
    w_ROWNUMDL= m_oDeletedRows.get(l_RowNumberToSet).w_ROWNUMDL;
    w_CACODICE= m_oDeletedRows.get(l_RowNumberToSet).w_CACODICE;
    w_CODLOB= m_oDeletedRows.get(l_RowNumberToSet).w_CODLOB;
    w_CATIPGIO= m_oDeletedRows.get(l_RowNumberToSet).w_CATIPGIO;
    w_CATIPCON= m_oDeletedRows.get(l_RowNumberToSet).w_CATIPCON;
    w_CGOTIPOPE= m_oDeletedRows.get(l_RowNumberToSet).w_CGOTIPOPE;
    w_impmin= m_oDeletedRows.get(l_RowNumberToSet).w_impmin;
    w_messaggio= m_oDeletedRows.get(l_RowNumberToSet).w_messaggio;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
