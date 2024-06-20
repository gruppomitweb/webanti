import java.util.*;

public class armd_anagrappoBL extends armd_anagrappoWV implements CPLib.QueryFilterFromApplication {
  static public class TrsRow {
    public String w_CONNESINT;
    public double w_ASPEDITO;
    public java.sql.Date w_ADATA;
    public String w_APROG;
    public String w_AOLDPROG;
    public String w_AFILE;
    public String w_AOLDFILE;
    public java.sql.Date w_ADATARET;
    public double w_CSPEDITO;
    public java.sql.Date w_CDATA;
    public String w_CPROG;
    public String w_COLDPROG;
    public String w_CFILE;
    public String w_COLDFILE;
    public java.sql.Date w_CDATARET;
    public String w_IDRIF;
    public String w_NOCODFISC;
    public String w_IDBASE;
    public double w_CPROWNUM;
    public String w_IDESITO;
    public double w_RSPEDITO;
    public double w_PROGAER;
    public java.sql.Date w_DATESITO;
    public double w_CFESTERO;
    public String w_xragsoc;
    public java.sql.Date w_dtcanc;
    public double w_spcanc;
    public String w_filecanc;
    public String w_idcanc;
    public int m_nCPRowNum;
    // Stato della riga (variata, nuova, non variata)
    public int m_nRowStatus;
    public String m_cOldRowCPCCCHK;
    public String[] work_children = new String[]{};
    public XDCFieldValue[] work_extended = new XDCFieldValue[]{};
  }
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
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
  public static final String i_EntityName = "armd_anagrappo";
  public static final String i_EntityType = "master/detail";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public CPPhTableWrInfo m_oWrInfo_aerighe;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_aerighe;
  // Variabili che contengono il nome fisico e la connessione per la tabella master
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public CPPhTableWrInfo m_oWrInfo_aetesta;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_aetesta;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public CPPhTableWrInfo m_oWrInfo_aecanc;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"aetesta","aerighe"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'TIPOAG':TIPOAG,'COINT':COINT,'m_Detail':{'CONNESINT':CONNESINT,'ASPEDITO':ASPEDITO,'ADATA':ADATA,'APROG':APROG,'AFILE':AFILE,'CSPEDITO':CSPEDITO,'CDATA':CDATA,'CPROG':CPROG,'CFILE':CFILE,'CPROWNUM':CPROWNUM,'ADATARET':ADATARET,'RSPEDITO':RSPEDITO,'COLDFILE':COLDFILE,'COLDPROG':COLDPROG"+FoundlingChildrenList("armd_anagrappo",true,true)+"},'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap,'CAB':CAB,'VALUTA':VALUTA"+FoundlingChildrenList("armd_anagrappo",true,false)+"}";
  public static final String i_CompleteStateStructure = "{'RAPPORTO':RAPPORTO,'TIPOAG':TIPOAG,'COINT':COINT,'RIFANA':RIFANA,'PROGAET':PROGAET,'m_Detail':{'CONNESINT':CONNESINT,'ASPEDITO':ASPEDITO,'ADATA':ADATA,'APROG':APROG,'AOLDPROG':AOLDPROG,'AFILE':AFILE,'AOLDFILE':AOLDFILE,'ADATARET':ADATARET,'CSPEDITO':CSPEDITO,'CDATA':CDATA,'CPROG':CPROG,'COLDPROG':COLDPROG,'CFILE':CFILE,'COLDFILE':COLDFILE,'CDATARET':CDATARET,'CFESTERO':CFESTERO,'IDRIF':IDRIF,'NOCODFISC':NOCODFISC,'IDBASE':IDBASE,'xragsoc':xragsoc,'CPROWNUM':CPROWNUM,'IDESITO':IDESITO,'RSPEDITO':RSPEDITO,'dtcanc':dtcanc,'spcanc':spcanc,'filecanc':filecanc,'idcanc':idcanc,'PROGAER':PROGAER,'DATESITO':DATESITO"+FoundlingChildrenList("armd_anagrappo",true,true)+"},'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap,'UNIQUECODE':UNIQUECODE,'CAB':CAB,'VALUTA':VALUTA"+FoundlingChildrenList("armd_anagrappo",true,false)+"}";
  public static final String i_ItemSequence = "RAPPORTO,TIPOAG,COINT,m_Detail[ CONNESINT ASPEDITO ADATA APROG AFILE CSPEDITO CDATA CPROG CFILE CPROWNUM ADATARET RSPEDITO COLDFILE COLDPROG"+FoundlingChildrenList("armd_anagrappo",false,true)+"],ardt_ae_saldianno_rap,CAB,VALUTA"+FoundlingChildrenList("armd_anagrappo",false,false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armd_anagrappo"),new String[][]{new String[]{"RAPPORTO","Codice Rapporto","C","25","0","campo","key1","false","false"},new String[]{"TIPOAG","Tipo Rapporto","C","2","0","campo","nokey","false","false"},new String[]{"COINT","Tipo Rapporto","C","1","0","campo","nokey","false","false"},new String[]{"CONNESINT","Codice Intestatario","C","16","0","campo","nokey","true","false"},new String[]{"ASPEDITO","Apertura Spedita","N","1","0","campo","nokey","true","false"},new String[]{"ADATA","Data Apertura","D","8","0","campo","nokey","true","false"},new String[]{"APROG","Riferimento Spedizione Apertura","C","25","0","campo","nokey","true","false"},new String[]{"AFILE","Riferimento file spedizione","C","15","0","campo","nokey","true","false"},new String[]{"CSPEDITO","Data Spedizione Chiusura","N","1","0","campo","nokey","true","false"},new String[]{"CDATA","Data Chiusura Rapporto","D","8","0","campo","nokey","true","false"},new String[]{"CPROG","Riferimento spedizione chiusura","C","25","0","campo","nokey","true","false"},new String[]{"CFILE","File spedizione Chiusura","C","15","0","campo","nokey","true","false"},new String[]{"CPROWNUM","N° Riga","N","4","0","campo","key1","true","false"},new String[]{"ADATARET","Data rettifica apertura","D","8","0","campo","nokey","true","false"},new String[]{"RSPEDITO","Rettifica Inviata","N","1","0","campo","nokey","true","false"},new String[]{"COLDFILE","Precedente file spedizione chiusura","C","15","0","campo","nokey","true","false"},new String[]{"COLDPROG","Precedente riferimento chiusura","C","25","0","campo","nokey","true","false"},new String[]{"ardt_ae_saldianno_rap","LinkPC","","","","link_PC","","false",""},new String[]{"CAB","CAB","C","5","0","campo","nokey","false","false"},new String[]{"VALUTA","Valuta","C","3","0","campo","nokey","false","false"}});
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
  public armd_anagrappoBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta",p_ContextObject.GetCompany(),false);
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_oWrInfo_aetesta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aetesta",p_ContextObject.GetCompany());
    m_cVirtName_aetesta = CPSql.ManipulateTablePhName("aetesta",m_cServer_aetesta);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe",p_ContextObject.GetCompany(),false);
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_oWrInfo_aerighe = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aerighe",p_ContextObject.GetCompany());
    m_cVirtName_aerighe = CPSql.ManipulateTablePhName("aerighe",m_cServer_aerighe);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_oWrInfo_aecanc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"aecanc",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armd_anagrappo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_RAPPORTO = "";
    w_TIPOAG = "";
    w_COINT = "";
    w_RIFANA = "";
    w_PROGAET = 0;
    w_CONNESINT = "";
    w_ASPEDITO = 0;
    w_ADATA = CPLib.NullDate();
    w_APROG = "";
    w_AOLDPROG = "";
    w_AFILE = "";
    w_AOLDFILE = "";
    w_ADATARET = CPLib.NullDate();
    w_CSPEDITO = 0;
    w_CDATA = CPLib.NullDate();
    w_CPROG = "";
    w_COLDPROG = "";
    w_CFILE = "";
    w_COLDFILE = "";
    w_CDATARET = CPLib.NullDate();
    w_CFESTERO = 0;
    w_IDRIF = "";
    w_xragsoc = "";
    w_ADATA = CPLib.NullDate();
    w_CDATA = CPLib.NullDate();
    w_CPROWNUM = 0;
    w_IDESITO = "";
    w_ADATARET = CPLib.NullDate();
    w_RSPEDITO = 0;
    w_COLDFILE = "";
    w_COLDPROG = "";
    w_IDBASE = "";
    w_dtcanc = CPLib.NullDate();
    w_spcanc = 0;
    w_filecanc = "";
    w_idcanc = "";
    w_PROGAER = 0;
    w_DATESITO = CPLib.NullDate();
    w_UNIQUECODE = "";
    w_CAB = "";
    w_VALUTA = "";
    Link_ZWBKZJLHCV();
    w_NOCODFISC = (CPLib.eq(w_CFESTERO,1)?"S":"N");
    w_IDBASE = "";
    w_IDBASE = LibreriaMit.UniqueId();
    Link_NQPTOOEBKN();
    m_cWv_ardt_ae_saldianno_rap = "";
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    CPExtenderLib.BlankExtendedFields(extendedFields);
    work_extended = SPExtenderLib.BlankRepeatedExtendedFields(extendedFields_trs);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
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
    o_IDBASE = w_IDBASE;
    ardt_ae_saldianno_rap.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_ZWBKZJLHCV() {
    return Link_ZWBKZJLHCV("Full");
  }
  protected boolean Link_ZWBKZJLHCV(String p_cType) {
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
          w_CFESTERO = l_rsLink.GetDouble("CFESTERO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZWBKZJLHCV_blank();
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
      Link_ZWBKZJLHCV_blank();
    }
    return l_bResult;
  }
  void Link_ZWBKZJLHCV_blank() {
    w_CONNESINT = "";
    w_xragsoc = "";
    w_CFESTERO = 0;
  }
  protected boolean Link_NQPTOOEBKN() {
    return Link_NQPTOOEBKN("Full");
  }
  protected boolean Link_NQPTOOEBKN(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_aecanc,w_IDBASE);
      if (m_Ctx.IsSharedTemp("aecanc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_aecanc,"select IDBASE,IDFILE,IDPROG,SPEDITO,DATARIF from "+m_cPhName_aecanc+((m_cPhName_aecanc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"IDBASE"+l_cCurrentKey+l_cWhere);
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
          Link_NQPTOOEBKN_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_IDBASE = l_OldValue;
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
      Link_NQPTOOEBKN_blank();
    }
    return l_bResult;
  }
  void Link_NQPTOOEBKN_blank() {
    w_IDBASE = "";
    w_filecanc = "";
    w_idcanc = "";
    w_spcanc = 0;
    w_dtcanc = CPLib.NullDate();
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
  public boolean Set_CONNESINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CONNESINT = p_workVariableValue;
    l_bResult = Link_ZWBKZJLHCV();
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
  public boolean Set_ASPEDITO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ASPEDITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public double getDefault_ASPEDITO() {
    // Gestione del default
    return 0;
  }
  public boolean Set_ADATA(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ADATA = p_workVariableValue;
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
    SetUpdatedRow();
    w_APROG = p_workVariableValue;
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
    SetUpdatedRow();
    w_AFILE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CSPEDITO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CSPEDITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public double getDefault_CSPEDITO() {
    // Gestione del default
    return 0;
  }
  public boolean Set_CDATA(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CDATA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CPROG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CPROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CFILE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_CFILE = p_workVariableValue;
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
  public boolean Set_ADATARET(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
    w_ADATARET = p_workVariableValue;
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
    SetUpdatedRow();
    w_RSPEDITO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public double getDefault_RSPEDITO() {
    // Gestione del default
    return 0;
  }
  public boolean Set_COLDFILE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdatedRow();
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
    SetUpdatedRow();
    w_COLDPROG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAB = p_workVariableValue;
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
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_CPROG() {
    return CPLib.ne(1,1);
  }
  public boolean getWritable_CFILE() {
    return CPLib.ne(1,1);
  }
  public boolean getWritable_ADATA() {
    return CPLib.ne(1,1);
  }
  public boolean getWritable_CDATA() {
    return CPLib.ne(1,1);
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
    w_IDBASE = LibreriaMit.UniqueId();
    if (CPLib.ne(o_IDBASE,w_IDBASE)) {
      l_bTmpRes = Link_NQPTOOEBKN();
    }
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
    l_cFilter = CPLib.ApplicationQueryFilter("armd_anagrappo","aetesta",m_KeyColumns,m_Ctx);
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
    w_TIPOAG = "";
    w_COINT = "";
    w_RIFANA = "";
    w_PROGAET = 0;
    w_CONNESINT = "";
    w_ASPEDITO = 0;
    w_ADATA = CPLib.NullDate();
    w_APROG = "";
    w_AOLDPROG = "";
    w_AFILE = "";
    w_AOLDFILE = "";
    w_ADATARET = CPLib.NullDate();
    w_CSPEDITO = 0;
    w_CDATA = CPLib.NullDate();
    w_CPROG = "";
    w_COLDPROG = "";
    w_CFILE = "";
    w_COLDFILE = "";
    w_CDATARET = CPLib.NullDate();
    w_CFESTERO = 0;
    w_IDRIF = "";
    w_NOCODFISC = "";
    w_IDBASE = "";
    w_xragsoc = "";
    w_ADATA = CPLib.NullDate();
    w_CDATA = CPLib.NullDate();
    w_CPROWNUM = 0;
    w_IDESITO = "";
    w_ADATARET = CPLib.NullDate();
    w_RSPEDITO = 0;
    w_COLDFILE = "";
    w_COLDPROG = "";
    w_IDBASE = "";
    w_dtcanc = CPLib.NullDate();
    w_spcanc = 0;
    w_filecanc = "";
    w_idcanc = "";
    w_PROGAER = 0;
    w_DATESITO = CPLib.NullDate();
    w_UNIQUECODE = "";
    w_CAB = "";
    w_VALUTA = "";
    m_cWv_ardt_ae_saldianno_rap = "";
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    CPExtenderLib.BlankExtendedFields(extendedFields);
    work_extended = SPExtenderLib.BlankRepeatedExtendedFields(extendedFields_trs);
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
      Properties p_CONNESINT;
      p_CONNESINT = CPLib.GetProperties(trs_p.getProperty("CONNESINT"),new Properties());
      Properties p_ASPEDITO;
      p_ASPEDITO = CPLib.GetProperties(trs_p.getProperty("ASPEDITO"),new Properties());
      Properties p_ADATA;
      p_ADATA = CPLib.GetProperties(trs_p.getProperty("ADATA"),new Properties());
      Properties p_APROG;
      p_APROG = CPLib.GetProperties(trs_p.getProperty("APROG"),new Properties());
      Properties p_AOLDPROG;
      p_AOLDPROG = CPLib.GetProperties(trs_p.getProperty("AOLDPROG"),new Properties());
      Properties p_AFILE;
      p_AFILE = CPLib.GetProperties(trs_p.getProperty("AFILE"),new Properties());
      Properties p_AOLDFILE;
      p_AOLDFILE = CPLib.GetProperties(trs_p.getProperty("AOLDFILE"),new Properties());
      Properties p_ADATARET;
      p_ADATARET = CPLib.GetProperties(trs_p.getProperty("ADATARET"),new Properties());
      Properties p_CSPEDITO;
      p_CSPEDITO = CPLib.GetProperties(trs_p.getProperty("CSPEDITO"),new Properties());
      Properties p_CDATA;
      p_CDATA = CPLib.GetProperties(trs_p.getProperty("CDATA"),new Properties());
      Properties p_CPROG;
      p_CPROG = CPLib.GetProperties(trs_p.getProperty("CPROG"),new Properties());
      Properties p_COLDPROG;
      p_COLDPROG = CPLib.GetProperties(trs_p.getProperty("COLDPROG"),new Properties());
      Properties p_CFILE;
      p_CFILE = CPLib.GetProperties(trs_p.getProperty("CFILE"),new Properties());
      Properties p_COLDFILE;
      p_COLDFILE = CPLib.GetProperties(trs_p.getProperty("COLDFILE"),new Properties());
      Properties p_CDATARET;
      p_CDATARET = CPLib.GetProperties(trs_p.getProperty("CDATARET"),new Properties());
      Properties p_IDRIF;
      p_IDRIF = CPLib.GetProperties(trs_p.getProperty("IDRIF"),new Properties());
      Properties p_NOCODFISC;
      p_NOCODFISC = CPLib.GetProperties(trs_p.getProperty("NOCODFISC"),new Properties());
      Properties p_IDBASE;
      p_IDBASE = CPLib.GetProperties(trs_p.getProperty("IDBASE"),new Properties());
      Properties p_CPROWNUM;
      p_CPROWNUM = CPLib.GetProperties(trs_p.getProperty("CPROWNUM"),new Properties());
      Properties p_IDESITO;
      p_IDESITO = CPLib.GetProperties(trs_p.getProperty("IDESITO"),new Properties());
      Properties p_RSPEDITO;
      p_RSPEDITO = CPLib.GetProperties(trs_p.getProperty("RSPEDITO"),new Properties());
      Properties p_PROGAER;
      p_PROGAER = CPLib.GetProperties(trs_p.getProperty("PROGAER"),new Properties());
      Properties p_DATESITO;
      p_DATESITO = CPLib.GetProperties(trs_p.getProperty("DATESITO"),new Properties());
      Properties p_CFESTERO;
      p_CFESTERO = CPLib.GetProperties(trs_p.getProperty("CFESTERO"),new Properties());
      Properties p_xragsoc;
      p_xragsoc = CPLib.GetProperties(trs_p.getProperty("xragsoc"),new Properties());
      Properties p_dtcanc;
      p_dtcanc = CPLib.GetProperties(trs_p.getProperty("dtcanc"),new Properties());
      Properties p_spcanc;
      p_spcanc = CPLib.GetProperties(trs_p.getProperty("spcanc"),new Properties());
      Properties p_filecanc;
      p_filecanc = CPLib.GetProperties(trs_p.getProperty("filecanc"),new Properties());
      Properties p_idcanc;
      p_idcanc = CPLib.GetProperties(trs_p.getProperty("idcanc"),new Properties());
      Properties p_m_nCPRowNum;
      p_m_nCPRowNum = CPLib.GetProperties(trs_p.getProperty("m_nCPRowNum"),new Properties());
      Properties p_m_nRowStatus;
      p_m_nRowStatus = CPLib.GetProperties(trs_p.getProperty("m_nRowStatus"),new Properties());
      Properties p_m_cOldRowCPCCCHK;
      p_m_cOldRowCPCCCHK = CPLib.GetProperties(trs_p.getProperty("m_cOldRowCPCCCHK"),new Properties());
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_TIPOAG = CPLib.GetProperty(p,"TIPOAG",w_TIPOAG,0);
      w_COINT = CPLib.GetProperty(p,"COINT",w_COINT,0);
      w_RIFANA = CPLib.GetProperty(p,"RIFANA",w_RIFANA,0);
      w_UNIQUECODE = CPLib.GetProperty(p,"UNIQUECODE",w_UNIQUECODE,0);
      w_CAB = CPLib.GetProperty(p,"CAB",w_CAB,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_PROGAET = CPLib.GetProperty(p,"PROGAET",w_PROGAET,0);
      op_PROGAET = CPLib.GetProperty(p,"op_PROGAET",0,0);
      m_cWv_ardt_ae_saldianno_rap = CPLib.GetProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
      Rows = trs_p.getProperty("Rows");
      if (CPLib.Empty(Rows)) {
        Rows = "0";
      }
      rows = (int)CPLib.Val(Rows);
      m_oTrs.clear();
      m_oDeletedRows.clear();
      i = 1;
      while (CPLib.le(i,rows)) {
        w_CONNESINT = "";
        w_CONNESINT = CPLib.GetProperty(p_CONNESINT,"",w_CONNESINT,i);
        w_ASPEDITO = 0;
        w_ASPEDITO = CPLib.GetProperty(p_ASPEDITO,"",w_ASPEDITO,i);
        w_ADATA = CPLib.NullDate();
        w_ADATA = CPLib.GetProperty(p_ADATA,"",w_ADATA,i);
        w_APROG = "";
        w_APROG = CPLib.GetProperty(p_APROG,"",w_APROG,i);
        w_AOLDPROG = "";
        w_AOLDPROG = CPLib.GetProperty(p_AOLDPROG,"",w_AOLDPROG,i);
        w_AFILE = "";
        w_AFILE = CPLib.GetProperty(p_AFILE,"",w_AFILE,i);
        w_AOLDFILE = "";
        w_AOLDFILE = CPLib.GetProperty(p_AOLDFILE,"",w_AOLDFILE,i);
        w_ADATARET = CPLib.NullDate();
        w_ADATARET = CPLib.GetProperty(p_ADATARET,"",w_ADATARET,i);
        w_CSPEDITO = 0;
        w_CSPEDITO = CPLib.GetProperty(p_CSPEDITO,"",w_CSPEDITO,i);
        w_CDATA = CPLib.NullDate();
        w_CDATA = CPLib.GetProperty(p_CDATA,"",w_CDATA,i);
        w_CPROG = "";
        w_CPROG = CPLib.GetProperty(p_CPROG,"",w_CPROG,i);
        w_COLDPROG = "";
        w_COLDPROG = CPLib.GetProperty(p_COLDPROG,"",w_COLDPROG,i);
        w_CFILE = "";
        w_CFILE = CPLib.GetProperty(p_CFILE,"",w_CFILE,i);
        w_COLDFILE = "";
        w_COLDFILE = CPLib.GetProperty(p_COLDFILE,"",w_COLDFILE,i);
        w_CDATARET = CPLib.NullDate();
        w_CDATARET = CPLib.GetProperty(p_CDATARET,"",w_CDATARET,i);
        w_IDRIF = "";
        w_IDRIF = CPLib.GetProperty(p_IDRIF,"",w_IDRIF,i);
        w_NOCODFISC = "";
        w_NOCODFISC = CPLib.GetProperty(p_NOCODFISC,"",w_NOCODFISC,i);
        w_IDBASE = "";
        w_IDBASE = CPLib.GetProperty(p_IDBASE,"",w_IDBASE,i);
        w_CPROWNUM = 0;
        w_CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",w_CPROWNUM,i);
        w_IDESITO = "";
        w_IDESITO = CPLib.GetProperty(p_IDESITO,"",w_IDESITO,i);
        w_RSPEDITO = 0;
        w_RSPEDITO = CPLib.GetProperty(p_RSPEDITO,"",w_RSPEDITO,i);
        w_PROGAER = 0;
        w_PROGAER = CPLib.GetProperty(p_PROGAER,"",w_PROGAER,i);
        op_PROGAER = CPLib.GetProperty(p_PROGAER,"",0,i);
        w_DATESITO = CPLib.NullDate();
        w_DATESITO = CPLib.GetProperty(p_DATESITO,"",w_DATESITO,i);
        w_CFESTERO = 0;
        w_CFESTERO = CPLib.GetProperty(p_CFESTERO,"",w_CFESTERO,i);
        w_xragsoc = "";
        w_xragsoc = CPLib.GetProperty(p_xragsoc,"",w_xragsoc,i);
        w_dtcanc = CPLib.NullDate();
        w_dtcanc = CPLib.GetProperty(p_dtcanc,"",w_dtcanc,i);
        w_spcanc = 0;
        w_spcanc = CPLib.GetProperty(p_spcanc,"",w_spcanc,i);
        w_filecanc = "";
        w_filecanc = CPLib.GetProperty(p_filecanc,"",w_filecanc,i);
        w_idcanc = "";
        w_idcanc = CPLib.GetProperty(p_idcanc,"",w_idcanc,i);
        m_nCPRowNum = (int)CPLib.GetProperty(p_m_nCPRowNum,"",0,i);
        work_children = CPLib.SetFromContextChildMNTs(trs_p,m_MNTs,true,i);
        work_extended = SPExtenderLib.SetFromContextExtendeds(trs_p,extendedFields_trs,i);
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
    SetUpdated();
    SetModified();
  }
  void SetUpdated(String p_cName) {
    if (CPLib.eq(p_cName,"RAPPORTO")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"TIPOAG")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"COINT")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"CONNESINT")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ASPEDITO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ADATA")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"APROG")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"AFILE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CSPEDITO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CDATA")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CPROG")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CFILE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CPROWNUM")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"ADATARET")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"RSPEDITO")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"COLDFILE")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"COLDPROG")) {
      SetUpdatedRow();
      return;
    }
    if (CPLib.eq(p_cName,"CAB")) {
      SetUpdated();
      return;
    }
    if (CPLib.eq(p_cName,"VALUTA")) {
      SetUpdated();
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
    map.put("rd_var.comment",zeroSplit.split("Tipo Rapporto",-1));
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
    items = tables.get("personbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("personbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC","CFESTERO"});
    map.put("rd_var",new String[]{"w_CONNESINT","w_xragsoc","w_CFESTERO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Intestatario\u0000Ragione Sociale\u0000Codice Fiscale Estero",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("aecanc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("aecanc",items);
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
    map.put("rd_var.comment",zeroSplit.split("IDBASE\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("TRUE\u0000TRUE\u0000TRUE\u0000TRUE\u0000TRUE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("aecanc\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armd_anagrappo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armd_anagrappo",child);
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
    for(String child : CPLib.LoadableMNTs("armd_anagrappo",true)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armd_anagrappo",child);
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
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armd_anagrappo",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    ResetErrorMessage();
    l_bResult = true;
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
    if ( ! (CPLib.Empty(w_CONNESINT))) {
      // * --- Area Manuale = BO - Check Form
      // * --- Fine Area Manuale
    }
    if ( ! (l_bNoCheck)) {
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
      l_Keys = new String[]{"armd_anagrappo"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armd_anagrappo\\"+p_cState};
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
  public boolean CanDeleteRow() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PROGAET = m_Ctx.AskTableProg(w_PROGAET,15,op_PROGAET,"PROGAET"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aerighe);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PROGAER = m_Ctx.AskTableProg(w_PROGAER,15,op_PROGAER,"PROGAER"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aerighe);
    op_codazi = m_Ctx.GetCompany();
    op_PROGAET = w_PROGAET;
    op_PROGAER = w_PROGAER;
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
      w_PROGAET = m_Ctx.AskTableProg(w_PROGAET,15,op_PROGAET,"PROGAET"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aerighe);
      op_codazi = m_Ctx.GetCompany();
      op_PROGAET = w_PROGAET;
    }
    if (l_b1) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PROGAER = m_Ctx.AskTableProg(w_PROGAER,15,op_PROGAER,"PROGAER"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_aerighe);
      op_PROGAER = w_PROGAER;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PROGAET = 0;
    op_PROGAER = 0;
    // Inizializzazione delle variabili per DependsOn
    o_TIPOAG = "";
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
    int i;
    int trsrow;
    Properties trs_p;
    trs_p = new Properties();
    Properties p_CONNESINT;
    p_CONNESINT = new Properties();
    Properties p_ASPEDITO;
    p_ASPEDITO = new Properties();
    Properties p_ADATA;
    p_ADATA = new Properties();
    Properties p_APROG;
    p_APROG = new Properties();
    Properties p_AOLDPROG;
    p_AOLDPROG = new Properties();
    Properties p_AFILE;
    p_AFILE = new Properties();
    Properties p_AOLDFILE;
    p_AOLDFILE = new Properties();
    Properties p_ADATARET;
    p_ADATARET = new Properties();
    Properties p_CSPEDITO;
    p_CSPEDITO = new Properties();
    Properties p_CDATA;
    p_CDATA = new Properties();
    Properties p_CPROG;
    p_CPROG = new Properties();
    Properties p_COLDPROG;
    p_COLDPROG = new Properties();
    Properties p_CFILE;
    p_CFILE = new Properties();
    Properties p_COLDFILE;
    p_COLDFILE = new Properties();
    Properties p_CDATARET;
    p_CDATARET = new Properties();
    Properties p_IDRIF;
    p_IDRIF = new Properties();
    Properties p_NOCODFISC;
    p_NOCODFISC = new Properties();
    Properties p_IDBASE;
    p_IDBASE = new Properties();
    Properties p_CPROWNUM;
    p_CPROWNUM = new Properties();
    Properties p_IDESITO;
    p_IDESITO = new Properties();
    Properties p_RSPEDITO;
    p_RSPEDITO = new Properties();
    Properties p_PROGAER;
    p_PROGAER = new Properties();
    Properties p_DATESITO;
    p_DATESITO = new Properties();
    Properties p_CFESTERO;
    p_CFESTERO = new Properties();
    Properties p_xragsoc;
    p_xragsoc = new Properties();
    Properties p_dtcanc;
    p_dtcanc = new Properties();
    Properties p_spcanc;
    p_spcanc = new Properties();
    Properties p_filecanc;
    p_filecanc = new Properties();
    Properties p_idcanc;
    p_idcanc = new Properties();
    Properties p_m_nCPRowNum;
    p_m_nCPRowNum = new Properties();
    Properties p_m_nRowStatus;
    p_m_nRowStatus = new Properties();
    Properties p_m_cOldRowCPCCCHK;
    p_m_cOldRowCPCCCHK = new Properties();
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"TIPOAG",w_TIPOAG,0);
    CPLib.PutProperty(p,"COINT",w_COINT,0);
    CPLib.PutProperty(p,"RIFANA",w_RIFANA,0);
    CPLib.PutProperty(p,"UNIQUECODE",w_UNIQUECODE,0);
    CPLib.PutProperty(p,"CAB",w_CAB,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"PROGAET",w_PROGAET,0);
    CPLib.PutProperty(p,"op_PROGAET",op_PROGAET,0);
    if (p_bGetChildren) {
      if (ardt_ae_saldianno_rap.IsUpdated()) {
        m_cWv_ardt_ae_saldianno_rap = ardt_ae_saldianno_rap.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
    }
    CPLib.PutProperty(p,m_MNTs);
    i = 0;
    trsrow = 0;
    while (CPLib.lt(i,Rows())) {
      SetRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_CONNESINT,"",w_CONNESINT,trsrow);
      CPLib.PutProperty(p_ASPEDITO,"",w_ASPEDITO,trsrow);
      CPLib.PutProperty(p_ADATA,"",w_ADATA,trsrow);
      CPLib.PutProperty(p_APROG,"",w_APROG,trsrow);
      CPLib.PutProperty(p_AOLDPROG,"",w_AOLDPROG,trsrow);
      CPLib.PutProperty(p_AFILE,"",w_AFILE,trsrow);
      CPLib.PutProperty(p_AOLDFILE,"",w_AOLDFILE,trsrow);
      CPLib.PutProperty(p_ADATARET,"",w_ADATARET,trsrow);
      CPLib.PutProperty(p_CSPEDITO,"",w_CSPEDITO,trsrow);
      CPLib.PutProperty(p_CDATA,"",w_CDATA,trsrow);
      CPLib.PutProperty(p_CPROG,"",w_CPROG,trsrow);
      CPLib.PutProperty(p_COLDPROG,"",w_COLDPROG,trsrow);
      CPLib.PutProperty(p_CFILE,"",w_CFILE,trsrow);
      CPLib.PutProperty(p_COLDFILE,"",w_COLDFILE,trsrow);
      CPLib.PutProperty(p_CDATARET,"",w_CDATARET,trsrow);
      CPLib.PutProperty(p_IDRIF,"",w_IDRIF,trsrow);
      CPLib.PutProperty(p_NOCODFISC,"",w_NOCODFISC,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_IDESITO,"",w_IDESITO,trsrow);
      CPLib.PutProperty(p_RSPEDITO,"",w_RSPEDITO,trsrow);
      CPLib.PutProperty(p_PROGAER,"",w_PROGAER,trsrow);
      CPLib.PutProperty(p_PROGAER,"",op_PROGAER,trsrow);
      CPLib.PutProperty(p_DATESITO,"",w_DATESITO,trsrow);
      CPLib.PutProperty(p_CFESTERO,"",w_CFESTERO,trsrow);
      CPLib.PutProperty(p_xragsoc,"",w_xragsoc,trsrow);
      CPLib.PutProperty(p_dtcanc,"",w_dtcanc,trsrow);
      CPLib.PutProperty(p_spcanc,"",w_spcanc,trsrow);
      CPLib.PutProperty(p_filecanc,"",w_filecanc,trsrow);
      CPLib.PutProperty(p_idcanc,"",w_idcanc,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      SPExtenderLib.PutExtendedRepeatedProperties(trs_p,work_extended,trsrow);
      i = i+1;
    }
    i = 0;
    while (CPLib.lt(i,m_oDeletedRows.size())) {
      SetDeletedRow(i);
      trsrow = trsrow+1;
      CPLib.PutProperty(p_CONNESINT,"",w_CONNESINT,trsrow);
      CPLib.PutProperty(p_ASPEDITO,"",w_ASPEDITO,trsrow);
      CPLib.PutProperty(p_ADATA,"",w_ADATA,trsrow);
      CPLib.PutProperty(p_APROG,"",w_APROG,trsrow);
      CPLib.PutProperty(p_AOLDPROG,"",w_AOLDPROG,trsrow);
      CPLib.PutProperty(p_AFILE,"",w_AFILE,trsrow);
      CPLib.PutProperty(p_AOLDFILE,"",w_AOLDFILE,trsrow);
      CPLib.PutProperty(p_ADATARET,"",w_ADATARET,trsrow);
      CPLib.PutProperty(p_CSPEDITO,"",w_CSPEDITO,trsrow);
      CPLib.PutProperty(p_CDATA,"",w_CDATA,trsrow);
      CPLib.PutProperty(p_CPROG,"",w_CPROG,trsrow);
      CPLib.PutProperty(p_COLDPROG,"",w_COLDPROG,trsrow);
      CPLib.PutProperty(p_CFILE,"",w_CFILE,trsrow);
      CPLib.PutProperty(p_COLDFILE,"",w_COLDFILE,trsrow);
      CPLib.PutProperty(p_CDATARET,"",w_CDATARET,trsrow);
      CPLib.PutProperty(p_IDRIF,"",w_IDRIF,trsrow);
      CPLib.PutProperty(p_NOCODFISC,"",w_NOCODFISC,trsrow);
      CPLib.PutProperty(p_IDBASE,"",w_IDBASE,trsrow);
      CPLib.PutProperty(p_CPROWNUM,"",w_CPROWNUM,trsrow);
      CPLib.PutProperty(p_IDESITO,"",w_IDESITO,trsrow);
      CPLib.PutProperty(p_RSPEDITO,"",w_RSPEDITO,trsrow);
      CPLib.PutProperty(p_PROGAER,"",w_PROGAER,trsrow);
      CPLib.PutProperty(p_PROGAER,"",op_PROGAER,trsrow);
      CPLib.PutProperty(p_DATESITO,"",w_DATESITO,trsrow);
      CPLib.PutProperty(p_CFESTERO,"",w_CFESTERO,trsrow);
      CPLib.PutProperty(p_xragsoc,"",w_xragsoc,trsrow);
      CPLib.PutProperty(p_dtcanc,"",w_dtcanc,trsrow);
      CPLib.PutProperty(p_spcanc,"",w_spcanc,trsrow);
      CPLib.PutProperty(p_filecanc,"",w_filecanc,trsrow);
      CPLib.PutProperty(p_idcanc,"",w_idcanc,trsrow);
      CPLib.PutProperty(p_m_nCPRowNum,"",m_nCPRowNum,trsrow);
      CPLib.PutProperty(p_m_nRowStatus,"",m_nRowStatus,trsrow);
      CPLib.PutProperty(p_m_cOldRowCPCCCHK,"",m_cOldRowCPCCCHK,trsrow);
      if (p_bGetChildren) {
        CPLib.PutProperty(trs_p,m_MNTs,work_children,trsrow);
      }
      SPExtenderLib.PutExtendedRepeatedProperties(trs_p,work_extended,trsrow);
      i = i+1;
    }
    trs_p.setProperty("CONNESINT",CPLib.ToProperties(p_CONNESINT));
    trs_p.setProperty("ASPEDITO",CPLib.ToProperties(p_ASPEDITO));
    trs_p.setProperty("ADATA",CPLib.ToProperties(p_ADATA));
    trs_p.setProperty("APROG",CPLib.ToProperties(p_APROG));
    trs_p.setProperty("AOLDPROG",CPLib.ToProperties(p_AOLDPROG));
    trs_p.setProperty("AFILE",CPLib.ToProperties(p_AFILE));
    trs_p.setProperty("AOLDFILE",CPLib.ToProperties(p_AOLDFILE));
    trs_p.setProperty("ADATARET",CPLib.ToProperties(p_ADATARET));
    trs_p.setProperty("CSPEDITO",CPLib.ToProperties(p_CSPEDITO));
    trs_p.setProperty("CDATA",CPLib.ToProperties(p_CDATA));
    trs_p.setProperty("CPROG",CPLib.ToProperties(p_CPROG));
    trs_p.setProperty("COLDPROG",CPLib.ToProperties(p_COLDPROG));
    trs_p.setProperty("CFILE",CPLib.ToProperties(p_CFILE));
    trs_p.setProperty("COLDFILE",CPLib.ToProperties(p_COLDFILE));
    trs_p.setProperty("CDATARET",CPLib.ToProperties(p_CDATARET));
    trs_p.setProperty("IDRIF",CPLib.ToProperties(p_IDRIF));
    trs_p.setProperty("NOCODFISC",CPLib.ToProperties(p_NOCODFISC));
    trs_p.setProperty("IDBASE",CPLib.ToProperties(p_IDBASE));
    trs_p.setProperty("CPROWNUM",CPLib.ToProperties(p_CPROWNUM));
    trs_p.setProperty("IDESITO",CPLib.ToProperties(p_IDESITO));
    trs_p.setProperty("RSPEDITO",CPLib.ToProperties(p_RSPEDITO));
    trs_p.setProperty("PROGAER",CPLib.ToProperties(p_PROGAER));
    trs_p.setProperty("DATESITO",CPLib.ToProperties(p_DATESITO));
    trs_p.setProperty("CFESTERO",CPLib.ToProperties(p_CFESTERO));
    trs_p.setProperty("xragsoc",CPLib.ToProperties(p_xragsoc));
    trs_p.setProperty("dtcanc",CPLib.ToProperties(p_dtcanc));
    trs_p.setProperty("spcanc",CPLib.ToProperties(p_spcanc));
    trs_p.setProperty("filecanc",CPLib.ToProperties(p_filecanc));
    trs_p.setProperty("idcanc",CPLib.ToProperties(p_idcanc));
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
    return "aetesta"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
  }
  public String RowPrimaryKey() {
    return "aerighe"+"\\"+CPLib.ToCPStr(w_CPROWNUM);
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PROGAET");
    oneAutoNum.add("PROGAET");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PROGAER");
    oneAutoNum.add("PROGAER");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
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
    if (CPLib.eq(p_cName,"ardt_ae_saldianno_rap")) {
      CtxLoad_ardt_ae_saldianno_rap();
      return ardt_ae_saldianno_rap;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  protected void TrsToWork() {
    w_CONNESINT= m_oTrs.get(m_nCurrentRow).w_CONNESINT;
    w_ASPEDITO= m_oTrs.get(m_nCurrentRow).w_ASPEDITO;
    w_ADATA= m_oTrs.get(m_nCurrentRow).w_ADATA;
    w_APROG= m_oTrs.get(m_nCurrentRow).w_APROG;
    w_AOLDPROG= m_oTrs.get(m_nCurrentRow).w_AOLDPROG;
    w_AFILE= m_oTrs.get(m_nCurrentRow).w_AFILE;
    w_AOLDFILE= m_oTrs.get(m_nCurrentRow).w_AOLDFILE;
    w_ADATARET= m_oTrs.get(m_nCurrentRow).w_ADATARET;
    w_CSPEDITO= m_oTrs.get(m_nCurrentRow).w_CSPEDITO;
    w_CDATA= m_oTrs.get(m_nCurrentRow).w_CDATA;
    w_CPROG= m_oTrs.get(m_nCurrentRow).w_CPROG;
    w_COLDPROG= m_oTrs.get(m_nCurrentRow).w_COLDPROG;
    w_CFILE= m_oTrs.get(m_nCurrentRow).w_CFILE;
    w_COLDFILE= m_oTrs.get(m_nCurrentRow).w_COLDFILE;
    w_CDATARET= m_oTrs.get(m_nCurrentRow).w_CDATARET;
    w_IDRIF= m_oTrs.get(m_nCurrentRow).w_IDRIF;
    w_NOCODFISC= m_oTrs.get(m_nCurrentRow).w_NOCODFISC;
    w_IDBASE= m_oTrs.get(m_nCurrentRow).w_IDBASE;
    w_CPROWNUM= m_oTrs.get(m_nCurrentRow).w_CPROWNUM;
    w_IDESITO= m_oTrs.get(m_nCurrentRow).w_IDESITO;
    w_RSPEDITO= m_oTrs.get(m_nCurrentRow).w_RSPEDITO;
    w_PROGAER= m_oTrs.get(m_nCurrentRow).w_PROGAER;
    w_DATESITO= m_oTrs.get(m_nCurrentRow).w_DATESITO;
    w_CFESTERO= m_oTrs.get(m_nCurrentRow).w_CFESTERO;
    w_xragsoc= m_oTrs.get(m_nCurrentRow).w_xragsoc;
    w_dtcanc= m_oTrs.get(m_nCurrentRow).w_dtcanc;
    w_spcanc= m_oTrs.get(m_nCurrentRow).w_spcanc;
    w_filecanc= m_oTrs.get(m_nCurrentRow).w_filecanc;
    w_idcanc= m_oTrs.get(m_nCurrentRow).w_idcanc;
    m_nCPRowNum= m_oTrs.get(m_nCurrentRow).m_nCPRowNum;
    work_children= (String[])m_oTrs.get(m_nCurrentRow).work_children.clone();
    CPLib.TrsToWorkMNTs(m_MNTs,work_children);
    work_extended= m_oTrs.get(m_nCurrentRow).work_extended;
    m_nRowStatus= m_oTrs.get(m_nCurrentRow).m_nRowStatus;
    m_cOldRowCPCCCHK= m_oTrs.get(m_nCurrentRow).m_cOldRowCPCCCHK;
    SaveDependsOn();
  }
  void WorkToTrs() {
    m_oTrs.get(m_nCurrentRow).w_CONNESINT=w_CONNESINT;
    m_oTrs.get(m_nCurrentRow).w_ASPEDITO=w_ASPEDITO;
    m_oTrs.get(m_nCurrentRow).w_ADATA=w_ADATA;
    m_oTrs.get(m_nCurrentRow).w_APROG=w_APROG;
    m_oTrs.get(m_nCurrentRow).w_AOLDPROG=w_AOLDPROG;
    m_oTrs.get(m_nCurrentRow).w_AFILE=w_AFILE;
    m_oTrs.get(m_nCurrentRow).w_AOLDFILE=w_AOLDFILE;
    m_oTrs.get(m_nCurrentRow).w_ADATARET=w_ADATARET;
    m_oTrs.get(m_nCurrentRow).w_CSPEDITO=w_CSPEDITO;
    m_oTrs.get(m_nCurrentRow).w_CDATA=w_CDATA;
    m_oTrs.get(m_nCurrentRow).w_CPROG=w_CPROG;
    m_oTrs.get(m_nCurrentRow).w_COLDPROG=w_COLDPROG;
    m_oTrs.get(m_nCurrentRow).w_CFILE=w_CFILE;
    m_oTrs.get(m_nCurrentRow).w_COLDFILE=w_COLDFILE;
    m_oTrs.get(m_nCurrentRow).w_CDATARET=w_CDATARET;
    m_oTrs.get(m_nCurrentRow).w_IDRIF=w_IDRIF;
    m_oTrs.get(m_nCurrentRow).w_NOCODFISC=w_NOCODFISC;
    m_oTrs.get(m_nCurrentRow).w_IDBASE=w_IDBASE;
    m_oTrs.get(m_nCurrentRow).w_CPROWNUM=w_CPROWNUM;
    m_oTrs.get(m_nCurrentRow).w_IDESITO=w_IDESITO;
    m_oTrs.get(m_nCurrentRow).w_RSPEDITO=w_RSPEDITO;
    m_oTrs.get(m_nCurrentRow).w_PROGAER=w_PROGAER;
    m_oTrs.get(m_nCurrentRow).w_DATESITO=w_DATESITO;
    m_oTrs.get(m_nCurrentRow).w_CFESTERO=w_CFESTERO;
    m_oTrs.get(m_nCurrentRow).w_xragsoc=w_xragsoc;
    m_oTrs.get(m_nCurrentRow).w_dtcanc=w_dtcanc;
    m_oTrs.get(m_nCurrentRow).w_spcanc=w_spcanc;
    m_oTrs.get(m_nCurrentRow).w_filecanc=w_filecanc;
    m_oTrs.get(m_nCurrentRow).w_idcanc=w_idcanc;
    m_oTrs.get(m_nCurrentRow).m_nCPRowNum=m_nCPRowNum;
    CPLib.WorkToTrsMNTs(m_MNTs,work_children);
    m_oTrs.get(m_nCurrentRow).work_children=CPLib.GetClone(work_children);
    m_oTrs.get(m_nCurrentRow).work_extended=work_extended;
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
    w_CONNESINT = "";
    w_ASPEDITO = 0;
    w_ADATA = CPLib.NullDate();
    w_APROG = "";
    w_AOLDPROG = "";
    w_AFILE = "";
    w_AOLDFILE = "";
    w_ADATARET = CPLib.NullDate();
    w_CSPEDITO = 0;
    w_CDATA = CPLib.NullDate();
    w_CPROG = "";
    w_COLDPROG = "";
    w_CFILE = "";
    w_COLDFILE = "";
    w_CDATARET = CPLib.NullDate();
    w_CFESTERO = 0;
    w_IDRIF = "";
    w_NOCODFISC = "";
    w_IDBASE = "";
    w_xragsoc = "";
    w_ADATA = CPLib.NullDate();
    w_CDATA = CPLib.NullDate();
    w_IDESITO = "";
    w_ADATARET = CPLib.NullDate();
    w_RSPEDITO = 0;
    w_COLDFILE = "";
    w_COLDPROG = "";
    w_IDBASE = "";
    w_dtcanc = CPLib.NullDate();
    w_spcanc = 0;
    w_filecanc = "";
    w_idcanc = "";
    w_PROGAER = 0;
    w_DATESITO = CPLib.NullDate();
    // Se ci sono dei calcoli le variabili di work vengono inizializzate con la formula di calcolo
    if ( ! (CPLib.Empty(w_CONNESINT))) {
      l_bTmpRes = Link_ZWBKZJLHCV();
    }
    w_NOCODFISC = (CPLib.eq(w_CFESTERO,1)?"S":"N");
    w_IDBASE = LibreriaMit.UniqueId();
    if ( ! (CPLib.Empty(w_IDBASE))) {
      l_bTmpRes = Link_NQPTOOEBKN();
    }
    work_children = CPLib.BlankChildMNTs(m_MNTs,true);
    work_extended = SPExtenderLib.BlankRepeatedExtendedFields(extendedFields_trs);
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
    m_oDeletedRows.get(l_nRows).w_CONNESINT=w_CONNESINT;
    m_oDeletedRows.get(l_nRows).w_ASPEDITO=w_ASPEDITO;
    m_oDeletedRows.get(l_nRows).w_ADATA=w_ADATA;
    m_oDeletedRows.get(l_nRows).w_APROG=w_APROG;
    m_oDeletedRows.get(l_nRows).w_AOLDPROG=w_AOLDPROG;
    m_oDeletedRows.get(l_nRows).w_AFILE=w_AFILE;
    m_oDeletedRows.get(l_nRows).w_AOLDFILE=w_AOLDFILE;
    m_oDeletedRows.get(l_nRows).w_ADATARET=w_ADATARET;
    m_oDeletedRows.get(l_nRows).w_CSPEDITO=w_CSPEDITO;
    m_oDeletedRows.get(l_nRows).w_CDATA=w_CDATA;
    m_oDeletedRows.get(l_nRows).w_CPROG=w_CPROG;
    m_oDeletedRows.get(l_nRows).w_COLDPROG=w_COLDPROG;
    m_oDeletedRows.get(l_nRows).w_CFILE=w_CFILE;
    m_oDeletedRows.get(l_nRows).w_COLDFILE=w_COLDFILE;
    m_oDeletedRows.get(l_nRows).w_CDATARET=w_CDATARET;
    m_oDeletedRows.get(l_nRows).w_IDRIF=w_IDRIF;
    m_oDeletedRows.get(l_nRows).w_NOCODFISC=w_NOCODFISC;
    m_oDeletedRows.get(l_nRows).w_IDBASE=w_IDBASE;
    m_oDeletedRows.get(l_nRows).w_CPROWNUM=w_CPROWNUM;
    m_oDeletedRows.get(l_nRows).w_IDESITO=w_IDESITO;
    m_oDeletedRows.get(l_nRows).w_RSPEDITO=w_RSPEDITO;
    m_oDeletedRows.get(l_nRows).w_PROGAER=w_PROGAER;
    m_oDeletedRows.get(l_nRows).w_DATESITO=w_DATESITO;
    m_oDeletedRows.get(l_nRows).w_CFESTERO=w_CFESTERO;
    m_oDeletedRows.get(l_nRows).w_xragsoc=w_xragsoc;
    m_oDeletedRows.get(l_nRows).w_dtcanc=w_dtcanc;
    m_oDeletedRows.get(l_nRows).w_spcanc=w_spcanc;
    m_oDeletedRows.get(l_nRows).w_filecanc=w_filecanc;
    m_oDeletedRows.get(l_nRows).w_idcanc=w_idcanc;
    m_oDeletedRows.get(l_nRows).m_nCPRowNum=m_nCPRowNum;
    m_oDeletedRows.get(l_nRows).work_children=CPLib.GetClone(work_children);
    m_oDeletedRows.get(l_nRows).work_extended=work_extended;
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
    if (CPLib.ge(m_nCurrentRow,Rows())) {
    } else if ( ! (FullRow())) {
      m_cLastMsgError = m_Ctx.Translate("MSG_FULLROW_NOT_SAT");
      l_bResult = false;
    } else {
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
  }
  boolean FullRow() {
    return  ! (CPLib.Empty(w_CONNESINT));
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
    w_CONNESINT= m_oDeletedRows.get(l_RowNumberToSet).w_CONNESINT;
    w_ASPEDITO= m_oDeletedRows.get(l_RowNumberToSet).w_ASPEDITO;
    w_ADATA= m_oDeletedRows.get(l_RowNumberToSet).w_ADATA;
    w_APROG= m_oDeletedRows.get(l_RowNumberToSet).w_APROG;
    w_AOLDPROG= m_oDeletedRows.get(l_RowNumberToSet).w_AOLDPROG;
    w_AFILE= m_oDeletedRows.get(l_RowNumberToSet).w_AFILE;
    w_AOLDFILE= m_oDeletedRows.get(l_RowNumberToSet).w_AOLDFILE;
    w_ADATARET= m_oDeletedRows.get(l_RowNumberToSet).w_ADATARET;
    w_CSPEDITO= m_oDeletedRows.get(l_RowNumberToSet).w_CSPEDITO;
    w_CDATA= m_oDeletedRows.get(l_RowNumberToSet).w_CDATA;
    w_CPROG= m_oDeletedRows.get(l_RowNumberToSet).w_CPROG;
    w_COLDPROG= m_oDeletedRows.get(l_RowNumberToSet).w_COLDPROG;
    w_CFILE= m_oDeletedRows.get(l_RowNumberToSet).w_CFILE;
    w_COLDFILE= m_oDeletedRows.get(l_RowNumberToSet).w_COLDFILE;
    w_CDATARET= m_oDeletedRows.get(l_RowNumberToSet).w_CDATARET;
    w_IDRIF= m_oDeletedRows.get(l_RowNumberToSet).w_IDRIF;
    w_NOCODFISC= m_oDeletedRows.get(l_RowNumberToSet).w_NOCODFISC;
    w_IDBASE= m_oDeletedRows.get(l_RowNumberToSet).w_IDBASE;
    w_CPROWNUM= m_oDeletedRows.get(l_RowNumberToSet).w_CPROWNUM;
    w_IDESITO= m_oDeletedRows.get(l_RowNumberToSet).w_IDESITO;
    w_RSPEDITO= m_oDeletedRows.get(l_RowNumberToSet).w_RSPEDITO;
    w_PROGAER= m_oDeletedRows.get(l_RowNumberToSet).w_PROGAER;
    w_DATESITO= m_oDeletedRows.get(l_RowNumberToSet).w_DATESITO;
    w_CFESTERO= m_oDeletedRows.get(l_RowNumberToSet).w_CFESTERO;
    w_xragsoc= m_oDeletedRows.get(l_RowNumberToSet).w_xragsoc;
    w_dtcanc= m_oDeletedRows.get(l_RowNumberToSet).w_dtcanc;
    w_spcanc= m_oDeletedRows.get(l_RowNumberToSet).w_spcanc;
    w_filecanc= m_oDeletedRows.get(l_RowNumberToSet).w_filecanc;
    w_idcanc= m_oDeletedRows.get(l_RowNumberToSet).w_idcanc;
    m_nCPRowNum= m_oDeletedRows.get(l_RowNumberToSet).m_nCPRowNum;
    work_children= (String[])m_oDeletedRows.get(l_RowNumberToSet).work_children.clone();
    work_extended= m_oDeletedRows.get(l_RowNumberToSet).work_extended;
    m_nRowStatus = 3;
    m_cOldRowCPCCCHK= m_oDeletedRows.get(l_RowNumberToSet).m_cOldRowCPCCCHK;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
