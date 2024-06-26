import java.util.*;

public class ardt_pdelegaboBL extends ardt_pdelegaboWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_CODINTER;
    public java.sql.Date w_DATAINI;
    public String w_TIPORAP;
    public String w_TIPOPERS;
    public String w_STATOREG;
    public String w_OPERAZMOD;
    public java.sql.Date w_DATARETT;
    public String w_IDEREG;
    public String w_COLLEGAMEN;
    public java.sql.Date w_DATAFINE;
    public String w_IDBASE;
    public String w_UCODE;
    public String w_NUMPROG1;
    public String w_NUMPROG2;
    public String w_NOAGE;
    public String w_xragsocd;
    public double w_tiporegr;
    public String w_DOMICILIO;
    public String w_DESCCIT;
    public String w_PROVINCIA;
    public String w_CAP;
    public String w_xRagSoc;
    public int m_nCPRowNum;
    // Stato della riga (variata, nuova, non variata)
    public int m_nRowStatus;
    public String m_cOldRowCPCCCHK;
    public String[] work_children = new String[]{};
  }
  // Variabile che indica se il record � stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record � stato variato
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
  public static final String i_EntityName = "ardt_pdelegabo";
  public static final String i_EntityType = "detail";
  public static final boolean i_IsSon = true;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public CPPhTableWrInfo m_oWrInfo_xelegabo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_xelegabo;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"xelegabo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'m_Detail':{'CODINTER':CODINTER,'DATAINI':DATAINI,'DATAFINE':DATAFINE,'NOAGE':NOAGE"+FoundlingChildrenList("ardt_pdelegabo",true,true)+"}"+FoundlingChildrenList("ardt_pdelegabo",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'RAPPORTO':RAPPORTO,'DESCINTER':DESCINTER,'m_Detail':{'CODINTER':CODINTER,'xragsocd':xragsocd,'DATAINI':DATAINI,'TIPORAP':TIPORAP,'TIPOPERS':TIPOPERS,'STATOREG':STATOREG,'OPERAZMOD':OPERAZMOD,'DATARETT':DATARETT,'IDEREG':IDEREG,'COLLEGAMEN':COLLEGAMEN,'DATAFINE':DATAFINE,'IDBASE':IDBASE,'UCODE':UCODE,'tiporegr':tiporegr,'DOMICILIO':DOMICILIO,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'NUMPROG1':NUMPROG1,'NUMPROG2':NUMPROG2,'xRagSoc':xRagSoc,'NOAGE':NOAGE"+FoundlingChildrenList("ardt_pdelegabo",true,true)+"}"+FoundlingChildrenList("ardt_pdelegabo",true,false)+"}";
  public static final String i_ItemSequence = "RAPPORTO,m_Detail[ CODINTER DATAINI DATAFINE NOAGE"+FoundlingChildrenList("ardt_pdelegabo",false,true)+"]"+FoundlingChildrenList("ardt_pdelegabo",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("ardt_pdelegabo"),new String[][]{new String[]{"RAPPORTO","Rapporto (Copia della testata)","C","25","0","campo","key1","false","false"},new String[]{"CODINTER","","C","16","0","campo","nokey","true","false"},new String[]{"DATAINI","Data Inizio","D","8","0","campo","nokey","true","true"},new String[]{"DATAFINE","Data Fine","D","8","0","campo","nokey","true","true"},new String[]{"NOAGE","","C","1","0","campo","nokey","true","false"}});
  public static final String i_TrsKeys = "";
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
  public ardt_pdelegaboBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo",p_ContextObject.GetCompany(),false);
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_oWrInfo_xelegabo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"xelegabo",p_ContextObject.GetCompany());
    m_cVirtName_xelegabo = CPSql.ManipulateTablePhName("xelegabo",m_cServer_xelegabo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("ardt_pdelegabo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_RAPPORTO = "";
    w_CODINTER = "";
    w_xragsocd = "";
    w_DATAINI = CPLib.NullDate();
    w_TIPORAP = "";
    w_TIPOPERS = "";
    w_STATOREG = "";
    w_OPERAZMOD = "";
    w_DATARETT = CPLib.NullDate();
    w_IDEREG = "";
    w_COLLEGAMEN = "";
    w_DATAFINE = CPLib.NullDate();
    w_IDBASE = "";
    w_UCODE = "";
    w_DOMICILIO = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_DESCINTER = "";
    Link_CROCGCIGKF();
    w_tiporegr = 0;
    w_tiporegr = Utilities.Make(m_Ctx).GetCallerNumber("tipregn");
    w_NUMPROG1 = "";
    w_NUMPROG1 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0) && CPLib.Empty(w_NUMPROG1) &&  ! (CPLib.Empty(w_DATAINI))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG1);
    w_NUMPROG2 = "";
    w_NUMPROG2 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0) && CPLib.Empty(w_NUMPROG2) &&  ! (CPLib.Empty(w_DATAFINE))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG2);
    w_xRagSoc = "";
    w_xRagSoc = ( ! (CPLib.Empty(CPLib.LRTrim(w_xragsocd)))?w_xragsocd:( ! (CPLib.Empty(w_CODINTER))?"Soggetto non presente in anagrafica":""));
    w_NOAGE = "N";
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
    o_CODINTER = w_CODINTER;
    o_DATAINI = w_DATAINI;
    o_DATAFINE = w_DATAFINE;
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Insert row start")) {
      Calculation_SFWVXVZTVV();
      Calculation_GVAXMWDMDH();
    } else if (CPLib.eq(p_cEvent,"Update row start")) {
      Calculation_GVAXMWDMDH();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_CROCGCIGKF() {
    return Link_CROCGCIGKF("Full");
  }
  protected boolean Link_CROCGCIGKF(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",16,0),m_cServer_personbo,w_CODINTER);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,CAP from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",70,0),m_cServer_personbo,w_CODINTER);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,CAP from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODINTER = l_rsLink.GetString("CONNES");
          w_xragsocd = l_rsLink.GetString("RAGSOC");
          w_DOMICILIO = l_rsLink.GetString("DOMICILIO");
          w_DESCCIT = l_rsLink.GetString("DESCCIT");
          w_PROVINCIA = l_rsLink.GetString("PROVINCIA");
          w_CAP = l_rsLink.GetString("CAP");
          w_DESCINTER = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se � stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_CROCGCIGKF_blank();
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chksoggR.Make(m_Ctx,this).Run(w_CODINTER,"8");
            if ( ! (l_bResult)) {
              // Se il check � fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINTER");
              }
              m_cLastWorkVarError = "CODINTER";
              w_CODINTER = "";
              Link_CROCGCIGKF_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINTER");
              }
              m_cLastWorkVarError = "CODINTER";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile � vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CROCGCIGKF_blank();
    }
    return l_bResult;
  }
  void Link_CROCGCIGKF_blank() {
    Link_CROCGCIGKF_blank("");
  }
  void Link_CROCGCIGKF_blank(String p_cType) {
    w_xragsocd = "";
    w_DOMICILIO = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_DESCINTER = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODINTER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CODINTER = p_workVariableValue;
    l_bResult = Link_CROCGCIGKF();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODINTER = "";
    }
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
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DATAINI = p_workVariableValue;
    // Se il campo � vuoto, demando la segnalazione dell'obbligatoriet� alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAINI = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public java.sql.Date getDefault_DATAINI() {
    // Gestione del default
    return Utilities.Make(m_Ctx).GetCallerDate("DATAOPE");
  }
  public boolean BJKHVZBXDR_isObligatory() {
    // Condizione di obbligatoriet�
    return CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0);
  }
  public boolean Set_DATAFINE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_DATAFINE = p_workVariableValue;
    // Se il campo � vuoto, demando la segnalazione dell'obbligatoriet� alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAFINE = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public java.sql.Date getDefault_DATAFINE() {
    // Gestione del default
    return Utilities.Make(m_Ctx).GetCallerDate("DATAOPE");
  }
  public boolean JCFUNSQXBI_isObligatory() {
    // Condizione di obbligatoriet�
    return CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0);
  }
  public boolean Set_NOAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_NOAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
                              abilitazione di un control.
                            */
  public boolean getWritable_DATAINI() {
    return CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0);
  }
  public boolean getWritable_DATAFINE() {
    return CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0);
  }
  public boolean getVisible_RAPPORTO() {
    return CPLib.eq(1,1);
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
    w_tiporegr = Utilities.Make(m_Ctx).GetCallerNumber("tipregn");
    w_NUMPROG1 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0) && CPLib.Empty(w_NUMPROG1) &&  ! (CPLib.Empty(w_DATAINI))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG1);
    w_NUMPROG2 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0) && CPLib.Empty(w_NUMPROG2) &&  ! (CPLib.Empty(w_DATAFINE))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG2);
    w_xRagSoc = ( ! (CPLib.Empty(CPLib.LRTrim(w_xragsocd)))?w_xragsocd:( ! (CPLib.Empty(w_CODINTER))?"Soggetto non presente in anagrafica":""));
    if (CPLib.ne(o_CODINTER,w_CODINTER)) {
      Calculation_XSORDCKKLR();
    }
    if (CPLib.ne(o_DATAFINE,w_DATAFINE)) {
      Calculation_HQRGXFMPSR();
    }
    if (CPLib.ne(o_DATAINI,w_DATAINI)) {
      Calculation_GVAXMWDMDH();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_XSORDCKKLR() {
    w_DATAINI = (CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0)?Utilities.Make(m_Ctx).GetCallerDate("DATAOPE"):w_DATAINI);
    w_DATAFINE = (CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0)?Utilities.Make(m_Ctx).GetCallerDate("DATAOPE"):w_DATAFINE);
  }
  void Calculation_SFWVXVZTVV() {
    w_IDBASE = LibreriaMit.UniqueId();
  }
  void Calculation_HQRGXFMPSR() {
    w_NUMPROG2 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0) && CPLib.Empty(w_NUMPROG2) &&  ! (CPLib.Empty(w_DATAFINE))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):(CPLib.Empty(w_DATAFINE)?"":w_NUMPROG2));
  }
  void Calculation_GVAXMWDMDH() {
    w_NUMPROG1 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0) && CPLib.Empty(w_NUMPROG1) &&  ! (CPLib.Empty(w_DATAINI))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):(CPLib.Empty(w_DATAINI)?"":w_NUMPROG1));
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
  public final static String[] m_KeyColumns = {"RAPPORTO"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("ardt_pdelegabo","xelegabo",m_KeyColumns,m_Ctx);
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
    w_RAPPORTO = "";
    w_CODINTER = "";
    w_xragsocd = "";
    w_DATAINI = CPLib.NullDate();
    w_TIPORAP = "";
    w_TIPOPERS = "";
    w_STATOREG = "";
    w_OPERAZMOD = "";
    w_DATARETT = CPLib.NullDate();
    w_IDEREG = "";
    w_COLLEGAMEN = "";
    w_DATAFINE = CPLib.NullDate();
    w_IDBASE = "";
    w_UCODE = "";
    w_tiporegr = 0;
    w_DOMICILIO = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_NUMPROG1 = "";
    w_NUMPROG2 = "";
    w_xRagSoc = "";
    w_NOAGE = "";
    w_DESCINTER = "";
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
      Properties p_CODINTER;
      p_CODINTER = CPLib.GetProperties(trs_p.getProperty("CODINTER"),new Properties());
      Properties p_DATAINI;
      p_DATAINI = CPLib.GetProperties(trs_p.getProperty("DATAINI"),new Properties());
      Properties p_TIPORAP;
      p_TIPORAP = CPLib.GetProperties(trs_p.getProperty("TIPORAP"),new Properties());
      Properties p_TIPOPERS;
      p_TIPOPERS = CPLib.GetProperties(trs_p.getProperty("TIPOPERS"),new Properties());
      Properties p_STATOREG;
      p_STATOREG = CPLib.GetProperties(trs_p.getProperty("STATOREG"),new Properties());
      Properties p_OPERAZMOD;
      p_OPERAZMOD = CPLib.GetProperties(trs_p.getProperty("OPERAZMOD"),new Properties());
      Properties p_DATARETT;
      p_DATARETT = CPLib.GetProperties(trs_p.getProperty("DATARETT"),new Properties());
      Properties p_IDEREG;
      p_IDEREG = CPLib.GetProperties(trs_p.getProperty("IDEREG"),new Properties());
      Properties p_COLLEGAMEN;
      p_COLLEGAMEN = CPLib.GetProperties(trs_p.getProperty("COLLEGAMEN"),new Properties());
      Properties p_DATAFINE;
      p_DATAFINE = CPLib.GetProperties(trs_p.getProperty("DATAFINE"),new Properties());
      Properties p_IDBASE;
      p_IDBASE = CPLib.GetProperties(trs_p.getProperty("IDBASE"),new Properties());
      Properties p_UCODE;
      p_UCODE = CPLib.GetProperties(trs_p.getProperty("UCODE"),new Properties());
      Properties p_NUMPROG1;
      p_NUMPROG1 = CPLib.GetProperties(trs_p.getProperty("NUMPROG1"),new Properties());
      Properties p_NUMPROG2;
      p_NUMPROG2 = CPLib.GetProperties(trs_p.getProperty("NUMPROG2"),new Properties());
      Properties p_NOAGE;
      p_NOAGE = CPLib.GetProperties(trs_p.getProperty("NOAGE"),new Properties());
      Properties p_xragsocd;
      p_xragsocd = CPLib.GetProperties(trs_p.getProperty("xragsocd"),new Properties());
      Properties p_tiporegr;
      p_tiporegr = CPLib.GetProperties(trs_p.getProperty("tiporegr"),new Properties());
      Properties p_DOMICILIO;
      p_DOMICILIO = CPLib.GetProperties(trs_p.getProperty("DOMICILIO"),new Properties());
      Properties p_DESCCIT;
      p_DESCCIT = CPLib.GetProperties(trs_p.getProperty("DESCCIT"),new Properties());
      Properties p_PROVINCIA;
      p_PROVINCIA = CPLib.GetProperties(trs_p.getProperty("PROVINCIA"),new Properties());
      Properties p_CAP;
      p_CAP = CPLib.GetProperties(trs_p.getProperty("CAP"),new Properties());
      Properties p_xRagSoc;
      p_xRagSoc = CPLib.GetProperties(trs_p.getProperty("xRagSoc"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_DESCINTER = CPLib.GetProperty(p,"DESCINTER",w_DESCINTER,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_CODINTER = "";
        w_CODINTER = CPLib.GetProperty(p_CODINTER,"",w_CODINTER,i);
        w_DATAINI = CPLib.NullDate();
        w_DATAINI = CPLib.GetProperty(p_DATAINI,"",w_DATAINI,i);
        w_TIPORAP = "";
        w_TIPORAP = CPLib.GetProperty(p_TIPORAP,"",w_TIPORAP,i);
        w_TIPOPERS = "";
        w_TIPOPERS = CPLib.GetProperty(p_TIPOPERS,"",w_TIPOPERS,i);
        w_STATOREG = "";
        w_STATOREG = CPLib.GetProperty(p_STATOREG,"",w_STATOREG,i);
        w_OPERAZMOD = "";
        w_OPERAZMOD = CPLib.GetProperty(p_OPERAZMOD,"",w_OPERAZMOD,i);
        w_DATARETT = CPLib.NullDate();
        w_DATARETT = CPLib.GetProperty(p_DATARETT,"",w_DATARETT,i);
        w_IDEREG = "";
        w_IDEREG = CPLib.GetProperty(p_IDEREG,"",w_IDEREG,i);
        w_COLLEGAMEN = "";
        w_COLLEGAMEN = CPLib.GetProperty(p_COLLEGAMEN,"",w_COLLEGAMEN,i);
        w_DATAFINE = CPLib.NullDate();
        w_DATAFINE = CPLib.GetProperty(p_DATAFINE,"",w_DATAFINE,i);
        w_IDBASE = "";
        w_IDBASE = CPLib.GetProperty(p_IDBASE,"",w_IDBASE,i);
        w_UCODE = "";
        w_UCODE = CPLib.GetProperty(p_UCODE,"",w_UCODE,i);
        w_NUMPROG1 = "";
        w_NUMPROG1 = CPLib.GetProperty(p_NUMPROG1,"",w_NUMPROG1,i);
        w_NUMPROG2 = "";
        w_NUMPROG2 = CPLib.GetProperty(p_NUMPROG2,"",w_NUMPROG2,i);
        w_NOAGE = "";
        w_NOAGE = CPLib.GetProperty(p_NOAGE,"",w_NOAGE,i);
        w_xragsocd = "";
        w_xragsocd = CPLib.GetProperty(p_xragsocd,"",w_xragsocd,i);
        w_tiporegr = 0;
        w_tiporegr = CPLib.GetProperty(p_tiporegr,"",w_tiporegr,i);
        w_DOMICILIO = "";
        w_DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"",w_DOMICILIO,i);
        w_DESCCIT = "";
        w_DESCCIT = CPLib.GetProperty(p_DESCCIT,"",w_DESCCIT,i);
        w_PROVINCIA = "";
        w_PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"",w_PROVINCIA,i);
        w_CAP = "";
        w_CAP = CPLib.GetProperty(p_CAP,"",w_CAP,i);
        w_xRagSoc = "";
        w_xRagSoc = CPLib.GetProperty(p_xRagSoc,"",w_xRagSoc,i);
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
    if (CPLib.eq(p_cName,"RAPPORTO")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"CODINTER")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DATAINI")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"DATAFINE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"NOAGE")) {
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
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC","DOMICILIO","DESCCIT","PROVINCIA","CAP","RAGSOC"});
    map.put("rd_var",new String[]{"w_CODINTER","w_xragsocd","w_DOMICILIO","w_DESCCIT","w_PROVINCIA","w_CAP","w_DESCINTER"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u000035\u000030\u00002\u00009\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Ragione Sociale\u0000Indirizzo\u0000Citt�\u0000Provincia\u0000CAP\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Soggetti Registrati\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("ardt_pdelegabo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_pdelegabo",child);
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
    for(String child : CPLib.LoadableMNTs("ardt_pdelegabo",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("ardt_pdelegabo",child);
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
    m_MNTs = CPLib.MNTChilds("ardt_pdelegabo",m_Ctx);
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
    l_bResult = true;
    if ( ! (CPLib.Empty(w_CODINTER))) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
    }
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
      l_Keys = new String[]{"ardt_pdelegabo"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"ardt_pdelegabo\\"+p_cState};
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
    o_CODINTER = "";
    o_DATAINI = CPLib.NullDate();
    o_DATAFINE = CPLib.NullDate();
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
    Properties p_CODINTER;
    p_CODINTER = new Properties();
    Properties p_DATAINI;
    p_DATAINI = new Properties();
    Properties p_TIPORAP;
    p_TIPORAP = new Properties();
    Properties p_TIPOPERS;
    p_TIPOPERS = new Properties();
    Properties p_STATOREG;
    p_STATOREG = new Properties();
    Properties p_OPERAZMOD;
    p_OPERAZMOD = new Properties();
    Properties p_DATARETT;
    p_DATARETT = new Properties();
    Properties p_IDEREG;
    p_IDEREG = new Properties();
    Properties p_COLLEGAMEN;
    p_COLLEGAMEN = new Properties();
    Properties p_DATAFINE;
    p_DATAFINE = new Properties();
    Properties p_IDBASE;
    p_IDBASE = new Properties();
    Properties p_UCODE;
    p_UCODE = new Properties();
    Properties p_NUMPROG1;
    p_NUMPROG1 = new Properties();
    Properties p_NUMPROG2;
    p_NUMPROG2 = new Properties();
    Properties p_NOAGE;
    p_NOAGE = new Properties();
    Properties p_xragsocd;
    p_xragsocd = new Properties();
    Properties p_tiporegr;
    p_tiporegr = new Properties();
    Properties p_DOMICILIO;
    p_DOMICILIO = new Properties();
    Properties p_DESCCIT;
    p_DESCCIT = new Properties();
    Properties p_PROVINCIA;
    p_PROVINCIA = new Properties();
    Properties p_CAP;
    p_CAP = new Properties();
    Properties p_xRagSoc;
    p_xRagSoc = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"DESCINTER",w_DESCINTER,0);
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_CODINTER,"",w_CODINTER,trsrow);
      CPLib.PutProperty(p_DATAINI,"",w_DATAINI,trsrow);
      CPLib.PutProperty(p_TIPORAP,"",w_TIPORAP,trsrow);
      CPLib.PutProperty(p_TIPOPERS,"",w_TIPOPERS,trsrow);
      CPLib.PutProperty(p_STATOREG,"",w_STATOREG,trsrow);
      CPLib.PutProperty(p_OPERAZMOD,"",w_OPERAZMOD,trsrow);
      CPLib.PutProperty(p_DATARETT,"",w_DATARETT,trsrow);
      CPLib.PutProperty(p_IDEREG,"",w_IDEREG,trsrow);
      CPLib.PutProperty(p_COLLEGAMEN,"",w_COLLEGAMEN,trsrow);
      CPLib.PutProperty(p_DATAFINE,"",w_DATAFINE,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_UCODE,"",w_UCODE,trsrow);
      CPLib.PutProperty(p_NUMPROG1,"",w_NUMPROG1,trsrow);
      CPLib.PutProperty(p_NUMPROG2,"",w_NUMPROG2,trsrow);
      CPLib.PutProperty(p_NOAGE,"",w_NOAGE,trsrow);
      CPLib.PutProperty(p_xragsocd,"",w_xragsocd,trsrow);
      CPLib.PutProperty(p_tiporegr,"",w_tiporegr,trsrow);
      CPLib.PutProperty(p_DOMICILIO,"",w_DOMICILIO,trsrow);
      CPLib.PutProperty(p_DESCCIT,"",w_DESCCIT,trsrow);
      CPLib.PutProperty(p_PROVINCIA,"",w_PROVINCIA,trsrow);
      CPLib.PutProperty(p_CAP,"",w_CAP,trsrow);
      CPLib.PutProperty(p_xRagSoc,"",w_xRagSoc,trsrow);
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
      CPLib.PutProperty(p_CODINTER,"",w_CODINTER,trsrow);
      CPLib.PutProperty(p_DATAINI,"",w_DATAINI,trsrow);
      CPLib.PutProperty(p_TIPORAP,"",w_TIPORAP,trsrow);
      CPLib.PutProperty(p_TIPOPERS,"",w_TIPOPERS,trsrow);
      CPLib.PutProperty(p_STATOREG,"",w_STATOREG,trsrow);
      CPLib.PutProperty(p_OPERAZMOD,"",w_OPERAZMOD,trsrow);
      CPLib.PutProperty(p_DATARETT,"",w_DATARETT,trsrow);
      CPLib.PutProperty(p_IDEREG,"",w_IDEREG,trsrow);
      CPLib.PutProperty(p_COLLEGAMEN,"",w_COLLEGAMEN,trsrow);
      CPLib.PutProperty(p_DATAFINE,"",w_DATAFINE,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_UCODE,"",w_UCODE,trsrow);
      CPLib.PutProperty(p_NUMPROG1,"",w_NUMPROG1,trsrow);
      CPLib.PutProperty(p_NUMPROG2,"",w_NUMPROG2,trsrow);
      CPLib.PutProperty(p_NOAGE,"",w_NOAGE,trsrow);
      CPLib.PutProperty(p_xragsocd,"",w_xragsocd,trsrow);
      CPLib.PutProperty(p_tiporegr,"",w_tiporegr,trsrow);
      CPLib.PutProperty(p_DOMICILIO,"",w_DOMICILIO,trsrow);
      CPLib.PutProperty(p_DESCCIT,"",w_DESCCIT,trsrow);
      CPLib.PutProperty(p_PROVINCIA,"",w_PROVINCIA,trsrow);
      CPLib.PutProperty(p_CAP,"",w_CAP,trsrow);
      CPLib.PutProperty(p_xRagSoc,"",w_xRagSoc,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      i = i+1;
    }
    trs_p.setProperty("CODINTER",CPLib.ToProperties(p_CODINTER));
    trs_p.setProperty("DATAINI",CPLib.ToProperties(p_DATAINI));
    trs_p.setProperty("TIPORAP",CPLib.ToProperties(p_TIPORAP));
    trs_p.setProperty("TIPOPERS",CPLib.ToProperties(p_TIPOPERS));
    trs_p.setProperty("STATOREG",CPLib.ToProperties(p_STATOREG));
    trs_p.setProperty("OPERAZMOD",CPLib.ToProperties(p_OPERAZMOD));
    trs_p.setProperty("DATARETT",CPLib.ToProperties(p_DATARETT));
    trs_p.setProperty("IDEREG",CPLib.ToProperties(p_IDEREG));
    trs_p.setProperty("COLLEGAMEN",CPLib.ToProperties(p_COLLEGAMEN));
    trs_p.setProperty("DATAFINE",CPLib.ToProperties(p_DATAFINE));
    trs_p.setProperty("IDBASE",CPLib.ToProperties(p_IDBASE));
    trs_p.setProperty("UCODE",CPLib.ToProperties(p_UCODE));
    trs_p.setProperty("NUMPROG1",CPLib.ToProperties(p_NUMPROG1));
    trs_p.setProperty("NUMPROG2",CPLib.ToProperties(p_NUMPROG2));
    trs_p.setProperty("NOAGE",CPLib.ToProperties(p_NOAGE));
    trs_p.setProperty("xragsocd",CPLib.ToProperties(p_xragsocd));
    trs_p.setProperty("tiporegr",CPLib.ToProperties(p_tiporegr));
    trs_p.setProperty("DOMICILIO",CPLib.ToProperties(p_DOMICILIO));
    trs_p.setProperty("DESCCIT",CPLib.ToProperties(p_DESCCIT));
    trs_p.setProperty("PROVINCIA",CPLib.ToProperties(p_PROVINCIA));
    trs_p.setProperty("CAP",CPLib.ToProperties(p_CAP));
    trs_p.setProperty("xRagSoc",CPLib.ToProperties(p_xRagSoc));
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
    return "xelegabo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
  }
  public String RowPrimaryKey() {
    return "xelegabo"+"\\"+CPLib.ToCPStr(m_nCPRowNum);
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
    w_CODINTER= m_oTrs.get(m_nCurrentRow).w_CODINTER;
    w_DATAINI= m_oTrs.get(m_nCurrentRow).w_DATAINI;
    w_TIPORAP= m_oTrs.get(m_nCurrentRow).w_TIPORAP;
    w_TIPOPERS= m_oTrs.get(m_nCurrentRow).w_TIPOPERS;
    w_STATOREG= m_oTrs.get(m_nCurrentRow).w_STATOREG;
    w_OPERAZMOD= m_oTrs.get(m_nCurrentRow).w_OPERAZMOD;
    w_DATARETT= m_oTrs.get(m_nCurrentRow).w_DATARETT;
    w_IDEREG= m_oTrs.get(m_nCurrentRow).w_IDEREG;
    w_COLLEGAMEN= m_oTrs.get(m_nCurrentRow).w_COLLEGAMEN;
    w_DATAFINE= m_oTrs.get(m_nCurrentRow).w_DATAFINE;
    w_IDBASE= m_oTrs.get(m_nCurrentRow).w_IDBASE;
    w_UCODE= m_oTrs.get(m_nCurrentRow).w_UCODE;
    w_NUMPROG1= m_oTrs.get(m_nCurrentRow).w_NUMPROG1;
    w_NUMPROG2= m_oTrs.get(m_nCurrentRow).w_NUMPROG2;
    w_NOAGE= m_oTrs.get(m_nCurrentRow).w_NOAGE;
    w_xragsocd= m_oTrs.get(m_nCurrentRow).w_xragsocd;
    w_tiporegr= m_oTrs.get(m_nCurrentRow).w_tiporegr;
    w_DOMICILIO= m_oTrs.get(m_nCurrentRow).w_DOMICILIO;
    w_DESCCIT= m_oTrs.get(m_nCurrentRow).w_DESCCIT;
    w_PROVINCIA= m_oTrs.get(m_nCurrentRow).w_PROVINCIA;
    w_CAP= m_oTrs.get(m_nCurrentRow).w_CAP;
    w_xRagSoc= m_oTrs.get(m_nCurrentRow).w_xRagSoc;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_CODINTER=w_CODINTER;
    m_oTrs.get(m_nCurrentRow).w_DATAINI=w_DATAINI;
    m_oTrs.get(m_nCurrentRow).w_TIPORAP=w_TIPORAP;
    m_oTrs.get(m_nCurrentRow).w_TIPOPERS=w_TIPOPERS;
    m_oTrs.get(m_nCurrentRow).w_STATOREG=w_STATOREG;
    m_oTrs.get(m_nCurrentRow).w_OPERAZMOD=w_OPERAZMOD;
    m_oTrs.get(m_nCurrentRow).w_DATARETT=w_DATARETT;
    m_oTrs.get(m_nCurrentRow).w_IDEREG=w_IDEREG;
    m_oTrs.get(m_nCurrentRow).w_COLLEGAMEN=w_COLLEGAMEN;
    m_oTrs.get(m_nCurrentRow).w_DATAFINE=w_DATAFINE;
    m_oTrs.get(m_nCurrentRow).w_IDBASE=w_IDBASE;
    m_oTrs.get(m_nCurrentRow).w_UCODE=w_UCODE;
    m_oTrs.get(m_nCurrentRow).w_NUMPROG1=w_NUMPROG1;
    m_oTrs.get(m_nCurrentRow).w_NUMPROG2=w_NUMPROG2;
    m_oTrs.get(m_nCurrentRow).w_NOAGE=w_NOAGE;
    m_oTrs.get(m_nCurrentRow).w_xragsocd=w_xragsocd;
    m_oTrs.get(m_nCurrentRow).w_tiporegr=w_tiporegr;
    m_oTrs.get(m_nCurrentRow).w_DOMICILIO=w_DOMICILIO;
    m_oTrs.get(m_nCurrentRow).w_DESCCIT=w_DESCCIT;
    m_oTrs.get(m_nCurrentRow).w_PROVINCIA=w_PROVINCIA;
    m_oTrs.get(m_nCurrentRow).w_CAP=w_CAP;
    m_oTrs.get(m_nCurrentRow).w_xRagSoc=w_xRagSoc;
    m_oTrs.get(m_nCurrentRow).m_nCPRowNum=m_nCPRowNum;
    CPLib.WorkToTrsMNTs(m_MNTs,work_children);
    m_oTrs.get(m_nCurrentRow).work_children=CPLib.GetClone(work_children);
    m_oTrs.get(m_nCurrentRow).m_nRowStatus=m_nRowStatus;
    m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;
  }
  public void AddRow() {
    /*  Inizializzazione di una nuova riga del transitorio.
                                Questo metodo pubblico viene chiamato quando c'� la richiesta dall'interfaccia
                                di aggiungere una riga nella movimentazione.
                              */
    m_nRowStatus = 2;
    m_nCurrentRow = Rows();
    boolean l_bTmpRes;
    int i;
    double l_nRowCprownum;
    m_nCPRowNum = 0;
    for ( i = 0; CPLib.lt(i,Rows()); i = i + (1)) {
      l_nRowCprownum= m_oTrs.get(i).m_nCPRowNum;
      if (CPLib.gt(l_nRowCprownum,m_nCPRowNum)) {
        m_nCPRowNum = (int)l_nRowCprownum;
      }
    }
    m_nCPRowNum = m_nCPRowNum+1;
    // Inizializzazione delle variabili di work al loro valore di blank
    w_CODINTER = "";
    w_xragsocd = "";
    w_DATAINI = CPLib.NullDate();
    w_TIPORAP = "";
    w_TIPOPERS = "";
    w_STATOREG = "";
    w_OPERAZMOD = "";
    w_DATARETT = CPLib.NullDate();
    w_IDEREG = "";
    w_COLLEGAMEN = "";
    w_DATAFINE = CPLib.NullDate();
    w_IDBASE = "";
    w_UCODE = "";
    w_tiporegr = 0;
    w_DOMICILIO = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_NUMPROG1 = "";
    w_NUMPROG2 = "";
    w_xRagSoc = "";
    w_NOAGE = "";
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if ( ! (CPLib.Empty(w_CODINTER))) {
      l_bTmpRes = Link_CROCGCIGKF();
    }
    w_tiporegr = Utilities.Make(m_Ctx).GetCallerNumber("tipregn");
    w_NUMPROG1 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0) && CPLib.Empty(w_NUMPROG1) &&  ! (CPLib.Empty(w_DATAINI))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG1);
    w_NUMPROG2 = ( ! (CPLib.Empty(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"))) && CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0) && CPLib.Empty(w_NUMPROG2) &&  ! (CPLib.Empty(w_DATAFINE))?Utilities.Make(m_Ctx).GetCallerString("NUMPROG"):w_NUMPROG2);
    w_xRagSoc = ( ! (CPLib.Empty(CPLib.LRTrim(w_xragsocd)))?w_xragsocd:( ! (CPLib.Empty(w_CODINTER))?"Soggetto non presente in anagrafica":""));
    w_NOAGE = "N";
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    m_cOldRowCPCCCHK = "";
    // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
    SaveDependsOn();
    AppendRow();
  }
  public boolean SetRow(double p_nRowNumberToSet) {
    /*  Impostazione delle variabili di work ad una riga del transitorio.
                                Se la riga richiesta � nuova, viene chiamata una inizializzazione.
                                Se la riga richiesta � pi� grande della dimensione del transitorio + 1,
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
    m_oDeletedRows.get(l_nRows).w_CODINTER=w_CODINTER;
    m_oDeletedRows.get(l_nRows).w_DATAINI=w_DATAINI;
    m_oDeletedRows.get(l_nRows).w_TIPORAP=w_TIPORAP;
    m_oDeletedRows.get(l_nRows).w_TIPOPERS=w_TIPOPERS;
    m_oDeletedRows.get(l_nRows).w_STATOREG=w_STATOREG;
    m_oDeletedRows.get(l_nRows).w_OPERAZMOD=w_OPERAZMOD;
    m_oDeletedRows.get(l_nRows).w_DATARETT=w_DATARETT;
    m_oDeletedRows.get(l_nRows).w_IDEREG=w_IDEREG;
    m_oDeletedRows.get(l_nRows).w_COLLEGAMEN=w_COLLEGAMEN;
    m_oDeletedRows.get(l_nRows).w_DATAFINE=w_DATAFINE;
    m_oDeletedRows.get(l_nRows).w_IDBASE=w_IDBASE;
    m_oDeletedRows.get(l_nRows).w_UCODE=w_UCODE;
    m_oDeletedRows.get(l_nRows).w_NUMPROG1=w_NUMPROG1;
    m_oDeletedRows.get(l_nRows).w_NUMPROG2=w_NUMPROG2;
    m_oDeletedRows.get(l_nRows).w_NOAGE=w_NOAGE;
    m_oDeletedRows.get(l_nRows).w_xragsocd=w_xragsocd;
    m_oDeletedRows.get(l_nRows).w_tiporegr=w_tiporegr;
    m_oDeletedRows.get(l_nRows).w_DOMICILIO=w_DOMICILIO;
    m_oDeletedRows.get(l_nRows).w_DESCCIT=w_DESCCIT;
    m_oDeletedRows.get(l_nRows).w_PROVINCIA=w_PROVINCIA;
    m_oDeletedRows.get(l_nRows).w_CAP=w_CAP;
    m_oDeletedRows.get(l_nRows).w_xRagSoc=w_xRagSoc;
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
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
      if ((CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"25|39|40"),0)) && (CPLib.Empty(w_DATAINI) && BJKHVZBXDR_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_DATAINI));
        String obblMsgError = m_Ctx.Translate("Data Inizio")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_DATAINI = CPLib.NullDate();
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "DATAINI";
        }
      } else if ((CPLib.ne(CPLib.At(Utilities.Make(m_Ctx).GetCallerString("TIPOOPRAP"),"28|41|47"),0)) && (CPLib.Empty(w_DATAFINE) && JCFUNSQXBI_isObligatory())) {
        l_bNoObligatory =  ! (CPLib.Empty(w_DATAFINE));
        String obblMsgError = m_Ctx.Translate("Data Fine")+" : ";
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        l_bResult = false;
        w_DATAFINE = CPLib.NullDate();
        if (CPLib.eq(m_cLastWorkVarError,"")) {
          m_cLastWorkVarError = "DATAFINE";
        }
      }
      if ( ! (l_bNoObligatory)) {
        m_nLastError = 1;
      } else if ( ! (l_bNoCheck)) {
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
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_CODINTER));
  }
  void SetModified() {
    /*  Segna la riga corrente del transitorio come modificata se non � una riga aggiunta
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
    w_CODINTER= m_oDeletedRows.get(l_RowNumberToSet).w_CODINTER;
    w_DATAINI= m_oDeletedRows.get(l_RowNumberToSet).w_DATAINI;
    w_TIPORAP= m_oDeletedRows.get(l_RowNumberToSet).w_TIPORAP;
    w_TIPOPERS= m_oDeletedRows.get(l_RowNumberToSet).w_TIPOPERS;
    w_STATOREG= m_oDeletedRows.get(l_RowNumberToSet).w_STATOREG;
    w_OPERAZMOD= m_oDeletedRows.get(l_RowNumberToSet).w_OPERAZMOD;
    w_DATARETT= m_oDeletedRows.get(l_RowNumberToSet).w_DATARETT;
    w_IDEREG= m_oDeletedRows.get(l_RowNumberToSet).w_IDEREG;
    w_COLLEGAMEN= m_oDeletedRows.get(l_RowNumberToSet).w_COLLEGAMEN;
    w_DATAFINE= m_oDeletedRows.get(l_RowNumberToSet).w_DATAFINE;
    w_IDBASE= m_oDeletedRows.get(l_RowNumberToSet).w_IDBASE;
    w_UCODE= m_oDeletedRows.get(l_RowNumberToSet).w_UCODE;
    w_NUMPROG1= m_oDeletedRows.get(l_RowNumberToSet).w_NUMPROG1;
    w_NUMPROG2= m_oDeletedRows.get(l_RowNumberToSet).w_NUMPROG2;
    w_NOAGE= m_oDeletedRows.get(l_RowNumberToSet).w_NOAGE;
    w_xragsocd= m_oDeletedRows.get(l_RowNumberToSet).w_xragsocd;
    w_tiporegr= m_oDeletedRows.get(l_RowNumberToSet).w_tiporegr;
    w_DOMICILIO= m_oDeletedRows.get(l_RowNumberToSet).w_DOMICILIO;
    w_DESCCIT= m_oDeletedRows.get(l_RowNumberToSet).w_DESCCIT;
    w_PROVINCIA= m_oDeletedRows.get(l_RowNumberToSet).w_PROVINCIA;
    w_CAP= m_oDeletedRows.get(l_RowNumberToSet).w_CAP;
    w_xRagSoc= m_oDeletedRows.get(l_RowNumberToSet).w_xRagSoc;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
