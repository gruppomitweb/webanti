import java.util.*;

public class armt_cgo_vltplatBL extends armt_cgo_vltplatWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_cgo_vltplat";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cgo_vltplat;
  public String m_cServer_cgo_vltplat;
  public CPPhTableWrInfo m_oWrInfo_cgo_vltplat;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cgo_vltplat;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cgo_vltplat"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'VPCODICE':VPCODICE,'VPDESCRI':VPDESCRI,'VPFLGATT':VPFLGATT,'VPIDAAMS':VPIDAAMS,'VPCODPIAT':VPCODPIAT,'VPSIGLAPIAT':VPSIGLAPIAT,'VPPROVENIENZA':VPPROVENIENZA,'VPVLTCODPLAT':VPVLTCODPLAT,'VPFLGCRYPTO':VPFLGCRYPTO,'VFPKAYCRYPTO':VFPKAYCRYPTO,'VPDIRFILE':VPDIRFILE,'VPFILEINTESTA1':VPFILEINTESTA1,'VPFFILESPERATOR1':VPFFILESPERATOR1,'VPFILEFORDATA1':VPFILEFORDATA1,'VPPREFFILE1':VPPREFFILE1,'VPFILEINTESTA2':VPFILEINTESTA2,'VPFFILESPERATOR2':VPFFILESPERATOR2,'VPFILEFORDATA2':VPFILEFORDATA2,'VPPREFFILE2':VPPREFFILE2,'VPFILEINTESTA3':VPFILEINTESTA3,'VPFFILESPERATOR3':VPFFILESPERATOR3,'VPFILEFORDATA3':VPFILEFORDATA3,'VPPREFFILE3':VPPREFFILE3,'VPFLGPRESUF1':VPFLGPRESUF1,'VPFLGPRESUF2':VPFLGPRESUF2,'VPFLGPRESUF3':VPFLGPRESUF3,'VFPFLAGIMPORT':VFPFLAGIMPORT,'VFPTIPOFILE1':VFPTIPOFILE1,'VFPTIPOFILE2':VFPTIPOFILE2,'VFPTIPOFILE3':VFPTIPOFILE3"+FoundlingChildrenList("armt_cgo_vltplat",true)+"}";
  public static final String i_CompleteStateStructure = "{'VPCODICE':VPCODICE,'VPDESCRI':VPDESCRI,'VPFLGATT':VPFLGATT,'VPIDAAMS':VPIDAAMS,'VPCODPIAT':VPCODPIAT,'VPSIGLAPIAT':VPSIGLAPIAT,'VPPROVENIENZA':VPPROVENIENZA,'VPVLTCODPLAT':VPVLTCODPLAT,'VPFLGCRYPTO':VPFLGCRYPTO,'VFPKAYCRYPTO':VFPKAYCRYPTO,'VPDIRFILE':VPDIRFILE,'VPFILEINTESTA1':VPFILEINTESTA1,'VPFFILESPERATOR1':VPFFILESPERATOR1,'VPFILEFORDATA1':VPFILEFORDATA1,'VPPREFFILE1':VPPREFFILE1,'VPFILEINTESTA2':VPFILEINTESTA2,'VPFFILESPERATOR2':VPFFILESPERATOR2,'VPFILEFORDATA2':VPFILEFORDATA2,'VPPREFFILE2':VPPREFFILE2,'VPFILEINTESTA3':VPFILEINTESTA3,'VPFFILESPERATOR3':VPFFILESPERATOR3,'VPFILEFORDATA3':VPFILEFORDATA3,'VPPREFFILE3':VPPREFFILE3,'VPFLGPRESUF1':VPFLGPRESUF1,'VPFLGPRESUF2':VPFLGPRESUF2,'VPFLGPRESUF3':VPFLGPRESUF3,'VFPFLAGIMPORT':VFPFLAGIMPORT,'VFPTIPOFILE1':VFPTIPOFILE1,'VFPTIPOFILE2':VFPTIPOFILE2,'VFPTIPOFILE3':VFPTIPOFILE3"+FoundlingChildrenList("armt_cgo_vltplat",true)+"}";
  public static final String i_ItemSequence = "VPCODICE,VPDESCRI,VPFLGATT,VPIDAAMS,VPCODPIAT,VPSIGLAPIAT,VPPROVENIENZA,VPVLTCODPLAT,VPFLGCRYPTO,VFPKAYCRYPTO,VPDIRFILE,VPFILEINTESTA1,VPFFILESPERATOR1,VPFILEFORDATA1,VPPREFFILE1,VPFILEINTESTA2,VPFFILESPERATOR2,VPFILEFORDATA2,VPPREFFILE2,VPFILEINTESTA3,VPFFILESPERATOR3,VPFILEFORDATA3,VPPREFFILE3,VPFLGPRESUF1,VPFLGPRESUF2,VPFLGPRESUF3,VFPFLAGIMPORT,VFPTIPOFILE1,VFPTIPOFILE2,VFPTIPOFILE3"+FoundlingChildrenList("armt_cgo_vltplat",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_cgo_vltplat"),new String[][]{new String[]{"VPCODICE","Codice","C","2","0","campo","key1","false","false"},new String[]{"VPDESCRI","Descrizione","C","50","0","campo","key2","false","false"},new String[]{"VPFLGATT","Piattaforma Attiva","C","1","0","campo","nokey","false","false"},new String[]{"VPIDAAMS","ID AAMS","C","16","0","campo","key3","false","false"},new String[]{"VPCODPIAT","Codice Piasttaforma (da CSV)","N","4","0","campo","key4","false","false"},new String[]{"VPSIGLAPIAT","Sigla Piattaforma","C","3","0","campo","key5","false","false"},new String[]{"VPPROVENIENZA","Provenienza","C","1","0","campo","nokey","false","false"},new String[]{"VPVLTCODPLAT","Codice Piattaforma VLT","N","4","0","campo","key6","false","false"},new String[]{"VPFLGCRYPTO","Check SSL","C","1","0","campo","nokey","false","false"},new String[]{"VFPKAYCRYPTO","Chiave Crittografazione","M","10","0","campo","nokey","false","false"},new String[]{"VPDIRFILE","Cartella File Import","C","30","0","campo","nokey","false","false"},new String[]{"VPFILEINTESTA1","Presenza riga intestazioni","C","1","0","campo","nokey","false","false"},new String[]{"VPFFILESPERATOR1","Separatore campi","C","1","0","campo","nokey","false","false"},new String[]{"VPFILEFORDATA1","Formato Data","C","1","0","campo","nokey","false","false"},new String[]{"VPPREFFILE1","Prefisso file","C","30","0","campo","nokey","false","false"},new String[]{"VPFILEINTESTA2","Presenza riga intestazioni","C","1","0","campo","nokey","false","false"},new String[]{"VPFFILESPERATOR2","Separatore campi","C","1","0","campo","nokey","false","false"},new String[]{"VPFILEFORDATA2","Formato Data","C","1","0","campo","nokey","false","false"},new String[]{"VPPREFFILE2","Prefisso file","C","30","0","campo","nokey","false","false"},new String[]{"VPFILEINTESTA3","Presenza riga intestazioni","C","1","0","campo","nokey","false","false"},new String[]{"VPFFILESPERATOR3","Separatore campi","C","1","0","campo","nokey","false","false"},new String[]{"VPFILEFORDATA3","Formato Data","C","1","0","campo","nokey","false","false"},new String[]{"VPPREFFILE3","Prefisso file","C","30","0","campo","nokey","false","false"},new String[]{"VPFLGPRESUF1","Prefisso o Suffisso","C","1","0","campo","nokey","false","false"},new String[]{"VPFLGPRESUF2","Prefisso o Suffisso","C","1","0","campo","nokey","false","false"},new String[]{"VPFLGPRESUF3","Prefisso o Suffisso","C","1","0","campo","nokey","false","false"},new String[]{"VFPFLAGIMPORT","Piattaforma per import","C","1","0","campo","nokey","false","false"},new String[]{"VFPTIPOFILE1","Tipo File 1 (Struttura)","C","1","0","campo","nokey","false","false"},new String[]{"VFPTIPOFILE2","Tipo File 2 (Struttura)","C","1","0","campo","nokey","false","false"},new String[]{"VFPTIPOFILE3","Tipo File 3 (Struttura)","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_cgo_vltplatBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cgo_vltplat = p_ContextObject.GetPhName("cgo_vltplat",p_ContextObject.GetCompany(),false);
    m_cServer_cgo_vltplat = p_ContextObject.GetServer("cgo_vltplat");
    m_oWrInfo_cgo_vltplat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_vltplat",p_ContextObject.GetCompany());
    m_cVirtName_cgo_vltplat = CPSql.ManipulateTablePhName("cgo_vltplat",m_cServer_cgo_vltplat);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_cgo_vltplat",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_VPCODICE = "";
    w_VPDESCRI = "";
    w_VPIDAAMS = "";
    w_VPCODPIAT = 0;
    w_VPSIGLAPIAT = "";
    w_VPPROVENIENZA = "";
    w_VPVLTCODPLAT = 0;
    w_VPFLGCRYPTO = "";
    w_VFPKAYCRYPTO = "";
    w_VPDIRFILE = "";
    w_VPPREFFILE1 = "";
    w_VPPREFFILE2 = "";
    w_VPPREFFILE3 = "";
    w_VFPTIPOFILE1 = "";
    w_VFPTIPOFILE2 = "";
    w_VFPTIPOFILE3 = "";
    w_VPFLGATT = "N";
    w_VPFILEINTESTA1 = "N";
    w_VPFFILESPERATOR1 = ";";
    w_VPFILEFORDATA1 = "1";
    w_VPFILEINTESTA2 = "N";
    w_VPFFILESPERATOR2 = ";";
    w_VPFILEFORDATA2 = "1";
    w_VPFILEINTESTA3 = "N";
    w_VPFFILESPERATOR3 = ";";
    w_VPFILEFORDATA3 = "1";
    w_VPFLGPRESUF1 = "P";
    w_VPFLGPRESUF2 = "P";
    w_VPFLGPRESUF3 = "P";
    w_VFPFLAGIMPORT = "S";
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
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_VPCODICE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPCODICE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPDESCRI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPDESCRI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFLGATT(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFLGATT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPIDAAMS(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPIDAAMS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPCODPIAT(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPCODPIAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPSIGLAPIAT(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPSIGLAPIAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPPROVENIENZA(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPPROVENIENZA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPVLTCODPLAT(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPVLTCODPLAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFLGCRYPTO(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFLGCRYPTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VFPKAYCRYPTO(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VFPKAYCRYPTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPDIRFILE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPDIRFILE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEINTESTA1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEINTESTA1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFFILESPERATOR1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFFILESPERATOR1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEFORDATA1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEFORDATA1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPPREFFILE1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPPREFFILE1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEINTESTA2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEINTESTA2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFFILESPERATOR2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFFILESPERATOR2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEFORDATA2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEFORDATA2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPPREFFILE2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPPREFFILE2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEINTESTA3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEINTESTA3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFFILESPERATOR3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFFILESPERATOR3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFILEFORDATA3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFILEFORDATA3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPPREFFILE3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPPREFFILE3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFLGPRESUF1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFLGPRESUF1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFLGPRESUF2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFLGPRESUF2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VPFLGPRESUF3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VPFLGPRESUF3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VFPFLAGIMPORT(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VFPFLAGIMPORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VFPTIPOFILE1(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VFPTIPOFILE1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VFPTIPOFILE2(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VFPTIPOFILE2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_VFPTIPOFILE3(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VFPTIPOFILE3 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_VFPKAYCRYPTO() {
    return CPLib.eq(w_VPFLGCRYPTO,"N");
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
  public final static String[] m_KeyColumns = {"VPCODICE"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_cgo_vltplat","cgo_vltplat",m_KeyColumns,m_Ctx);
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
    w_VPCODICE = "";
    w_VPDESCRI = "";
    w_VPFLGATT = "";
    w_VPIDAAMS = "";
    w_VPCODPIAT = 0;
    w_VPSIGLAPIAT = "";
    w_VPPROVENIENZA = "";
    w_VPVLTCODPLAT = 0;
    w_VPFLGCRYPTO = "";
    w_VFPKAYCRYPTO = "";
    w_VPDIRFILE = "";
    w_VPFILEINTESTA1 = "";
    w_VPFFILESPERATOR1 = "";
    w_VPFILEFORDATA1 = "";
    w_VPPREFFILE1 = "";
    w_VPFILEINTESTA2 = "";
    w_VPFFILESPERATOR2 = "";
    w_VPFILEFORDATA2 = "";
    w_VPPREFFILE2 = "";
    w_VPFILEINTESTA3 = "";
    w_VPFFILESPERATOR3 = "";
    w_VPFILEFORDATA3 = "";
    w_VPPREFFILE3 = "";
    w_VPFLGPRESUF1 = "";
    w_VPFLGPRESUF2 = "";
    w_VPFLGPRESUF3 = "";
    w_VFPFLAGIMPORT = "";
    w_VFPTIPOFILE1 = "";
    w_VFPTIPOFILE2 = "";
    w_VFPTIPOFILE3 = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_VPCODICE = CPLib.GetProperty(p,"VPCODICE",w_VPCODICE,0);
      w_VPDESCRI = CPLib.GetProperty(p,"VPDESCRI",w_VPDESCRI,0);
      w_VPFLGATT = CPLib.GetProperty(p,"VPFLGATT",w_VPFLGATT,0);
      w_VPIDAAMS = CPLib.GetProperty(p,"VPIDAAMS",w_VPIDAAMS,0);
      w_VPCODPIAT = CPLib.GetProperty(p,"VPCODPIAT",w_VPCODPIAT,0);
      w_VPSIGLAPIAT = CPLib.GetProperty(p,"VPSIGLAPIAT",w_VPSIGLAPIAT,0);
      w_VPPROVENIENZA = CPLib.GetProperty(p,"VPPROVENIENZA",w_VPPROVENIENZA,0);
      w_VPVLTCODPLAT = CPLib.GetProperty(p,"VPVLTCODPLAT",w_VPVLTCODPLAT,0);
      w_VPFLGCRYPTO = CPLib.GetProperty(p,"VPFLGCRYPTO",w_VPFLGCRYPTO,0);
      w_VFPKAYCRYPTO = CPLib.GetProperty(p,"VFPKAYCRYPTO",w_VFPKAYCRYPTO,0);
      w_VPDIRFILE = CPLib.GetProperty(p,"VPDIRFILE",w_VPDIRFILE,0);
      w_VPFILEINTESTA1 = CPLib.GetProperty(p,"VPFILEINTESTA1",w_VPFILEINTESTA1,0);
      w_VPFFILESPERATOR1 = CPLib.GetProperty(p,"VPFFILESPERATOR1",w_VPFFILESPERATOR1,0);
      w_VPFILEFORDATA1 = CPLib.GetProperty(p,"VPFILEFORDATA1",w_VPFILEFORDATA1,0);
      w_VPPREFFILE1 = CPLib.GetProperty(p,"VPPREFFILE1",w_VPPREFFILE1,0);
      w_VPFILEINTESTA2 = CPLib.GetProperty(p,"VPFILEINTESTA2",w_VPFILEINTESTA2,0);
      w_VPFFILESPERATOR2 = CPLib.GetProperty(p,"VPFFILESPERATOR2",w_VPFFILESPERATOR2,0);
      w_VPFILEFORDATA2 = CPLib.GetProperty(p,"VPFILEFORDATA2",w_VPFILEFORDATA2,0);
      w_VPPREFFILE2 = CPLib.GetProperty(p,"VPPREFFILE2",w_VPPREFFILE2,0);
      w_VPFILEINTESTA3 = CPLib.GetProperty(p,"VPFILEINTESTA3",w_VPFILEINTESTA3,0);
      w_VPFFILESPERATOR3 = CPLib.GetProperty(p,"VPFFILESPERATOR3",w_VPFFILESPERATOR3,0);
      w_VPFILEFORDATA3 = CPLib.GetProperty(p,"VPFILEFORDATA3",w_VPFILEFORDATA3,0);
      w_VPPREFFILE3 = CPLib.GetProperty(p,"VPPREFFILE3",w_VPPREFFILE3,0);
      w_VPFLGPRESUF1 = CPLib.GetProperty(p,"VPFLGPRESUF1",w_VPFLGPRESUF1,0);
      w_VPFLGPRESUF2 = CPLib.GetProperty(p,"VPFLGPRESUF2",w_VPFLGPRESUF2,0);
      w_VPFLGPRESUF3 = CPLib.GetProperty(p,"VPFLGPRESUF3",w_VPFLGPRESUF3,0);
      w_VFPFLAGIMPORT = CPLib.GetProperty(p,"VFPFLAGIMPORT",w_VFPFLAGIMPORT,0);
      w_VFPTIPOFILE1 = CPLib.GetProperty(p,"VFPTIPOFILE1",w_VFPTIPOFILE1,0);
      w_VFPTIPOFILE2 = CPLib.GetProperty(p,"VFPTIPOFILE2",w_VFPTIPOFILE2,0);
      w_VFPTIPOFILE3 = CPLib.GetProperty(p,"VFPTIPOFILE3",w_VFPTIPOFILE3,0);
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
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("armt_cgo_vltplat",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_cgo_vltplat",child);
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
    m_MNTs = CPLib.MNTChilds("armt_cgo_vltplat",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
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
      l_Keys = new String[]{"armt_cgo_vltplat"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_cgo_vltplat\\"+p_cState};
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
    CPLib.PutProperty(p,"VPCODICE",w_VPCODICE,0);
    CPLib.PutProperty(p,"VPDESCRI",w_VPDESCRI,0);
    CPLib.PutProperty(p,"VPFLGATT",w_VPFLGATT,0);
    CPLib.PutProperty(p,"VPIDAAMS",w_VPIDAAMS,0);
    CPLib.PutProperty(p,"VPCODPIAT",w_VPCODPIAT,0);
    CPLib.PutProperty(p,"VPSIGLAPIAT",w_VPSIGLAPIAT,0);
    CPLib.PutProperty(p,"VPPROVENIENZA",w_VPPROVENIENZA,0);
    CPLib.PutProperty(p,"VPVLTCODPLAT",w_VPVLTCODPLAT,0);
    CPLib.PutProperty(p,"VPFLGCRYPTO",w_VPFLGCRYPTO,0);
    CPLib.PutProperty(p,"VFPKAYCRYPTO",w_VFPKAYCRYPTO,0);
    CPLib.PutProperty(p,"VPDIRFILE",w_VPDIRFILE,0);
    CPLib.PutProperty(p,"VPFILEINTESTA1",w_VPFILEINTESTA1,0);
    CPLib.PutProperty(p,"VPFFILESPERATOR1",w_VPFFILESPERATOR1,0);
    CPLib.PutProperty(p,"VPFILEFORDATA1",w_VPFILEFORDATA1,0);
    CPLib.PutProperty(p,"VPPREFFILE1",w_VPPREFFILE1,0);
    CPLib.PutProperty(p,"VPFILEINTESTA2",w_VPFILEINTESTA2,0);
    CPLib.PutProperty(p,"VPFFILESPERATOR2",w_VPFFILESPERATOR2,0);
    CPLib.PutProperty(p,"VPFILEFORDATA2",w_VPFILEFORDATA2,0);
    CPLib.PutProperty(p,"VPPREFFILE2",w_VPPREFFILE2,0);
    CPLib.PutProperty(p,"VPFILEINTESTA3",w_VPFILEINTESTA3,0);
    CPLib.PutProperty(p,"VPFFILESPERATOR3",w_VPFFILESPERATOR3,0);
    CPLib.PutProperty(p,"VPFILEFORDATA3",w_VPFILEFORDATA3,0);
    CPLib.PutProperty(p,"VPPREFFILE3",w_VPPREFFILE3,0);
    CPLib.PutProperty(p,"VPFLGPRESUF1",w_VPFLGPRESUF1,0);
    CPLib.PutProperty(p,"VPFLGPRESUF2",w_VPFLGPRESUF2,0);
    CPLib.PutProperty(p,"VPFLGPRESUF3",w_VPFLGPRESUF3,0);
    CPLib.PutProperty(p,"VFPFLAGIMPORT",w_VFPFLAGIMPORT,0);
    CPLib.PutProperty(p,"VFPTIPOFILE1",w_VFPTIPOFILE1,0);
    CPLib.PutProperty(p,"VFPTIPOFILE2",w_VFPTIPOFILE2,0);
    CPLib.PutProperty(p,"VFPTIPOFILE3",w_VFPTIPOFILE3,0);
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
    return "cgo_vltplat"+"\\"+CPLib.ToCPStr(p_Caller.GetString("VPCODICE","C",2,0));
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
