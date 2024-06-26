import java.util.*;

public class armt_wutrxchkBL extends armt_wutrxchkWV implements CPLib.QueryFilterFromProject {
  // Variabile che indica se il record � stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record � stato variato
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
  public static final String i_EntityName = "armt_wutrxchk";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public CPPhTableWrInfo m_oWrInfo_wutrxchk;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wutrxchk;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wutrxchk"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TRXCODPRG':TRXCODPRG,'TRXCOGNOM':TRXCOGNOM,'TRXNOME':TRXNOME,'TRXDOMICI':TRXDOMICI,'TRXFLGCF':TRXFLGCF,'TRXCODFIS':TRXCODFIS,'TRXLUONAS':TRXLUONAS,'TRXNUMDOC':TRXNUMDOC,'TRXDATSCA':TRXDATSCA,'TRXDATRIL':TRXDATRIL,'TRXAUTRIL':TRXAUTRIL,'TRXNAZRES':TRXNAZRES,'TRXCITRES':TRXCITRES,'TRXTIPDOC':TRXTIPDOC,'TRXDATOPE':TRXDATOPE,'TRXFLGCON':TRXFLGCON,'TRSSEGNO':TRSSEGNO,'TRXIMPORTO':TRXIMPORTO,'TRXCONTAN':TRXCONTAN,'TRXUNIQUE':TRXUNIQUE,'TRXCODDIP':TRXCODDIP,'TRXCOGCON':TRXCOGCON,'TRXNOMCON':TRXNOMCON,'TRXDESTIN':TRXDESTIN,'TRXMTCN':TRXMTCN,'TRXDATNAS':TRXDATNAS,'TRXSESSO':TRXSESSO,'TRXCODCAS':TRXCODCAS,'TRXRECTYPE':TRXRECTYPE,'TRXCODMAG':TRXCODMAG,'TRXCODUNI':TRXCODUNI,'TRXERROR01':TRXERROR01,'TRXERROR02':TRXERROR02,'TRXERROR03':TRXERROR03,'TRXERROR04':TRXERROR04,'TRXERROR05':TRXERROR05,'TRXERROR06':TRXERROR06,'TRXERROR07':TRXERROR07,'TRXERROR08':TRXERROR08,'TRXERROR09':TRXERROR09,'TRXERROR10':TRXERROR10,'TRXERROR11':TRXERROR11,'TRXERROR12':TRXERROR12,'TRXERROR13':TRXERROR13,'TRXERROR14':TRXERROR14,'TRXERROR15':TRXERROR15,'TRXERROR16':TRXERROR16,'TRXERROR17':TRXERROR17,'TRXERROR18':TRXERROR18,'TRXERROR19':TRXERROR19,'TRXERROR20':TRXERROR20,'TRXERROR21':TRXERROR21,'TRXERROR22':TRXERROR22,'TRXERROR23':TRXERROR23,'TRXERROR24':TRXERROR24,'TRXERROR25':TRXERROR25,'TRXERROR26':TRXERROR26,'TRXERROR27':TRXERROR27,'TRXERROR28':TRXERROR28,'TRXERROR29':TRXERROR29,'TRXERROR30':TRXERROR30,'TRXERROR31':TRXERROR31,'TRXERROR32':TRXERROR32,'TRXERROR33':TRXERROR33,'TRXERROR34':TRXERROR34,'TRXERROR35':TRXERROR35,'TRXERROR36':TRXERROR36,'TRXERROR37':TRXERROR37,'TRXERROR38':TRXERROR38,'TRXERROR39':TRXERROR39,'TRXERROR40':TRXERROR40,'TRXERROR41':TRXERROR41,'TRXERROR42':TRXERROR42,'TRXERROR43':TRXERROR43,'TRXERROR44':TRXERROR44,'TRXERROR45':TRXERROR45,'TRXERROR46':TRXERROR46,'TRXERROR47':TRXERROR47,'TRXERROR48':TRXERROR48,'TRXERROR49':TRXERROR49,'TRXERROR50':TRXERROR50,'TRXERRAUA01':TRXERRAUA01,'TRXERRAUA02':TRXERRAUA02,'TRXERRAUA03':TRXERRAUA03,'TRXERRAUA04':TRXERRAUA04,'TRXERRAUA05':TRXERRAUA05,'TRXERRAUA06':TRXERRAUA06,'TRXERRAUA07':TRXERRAUA07,'TRXERRAUA08':TRXERRAUA08,'TRXERRAUA09':TRXERRAUA09,'TRXERRAUA10':TRXERRAUA10,'TRXFLGAUI':TRXFLGAUI,'TRXFLGAUA':TRXFLGAUA,'TRXFLGFOR':TRXFLGFOR,'TRXAUICHK':TRXAUICHK,'TRXAUACHK':TRXAUACHK"+FoundlingChildrenList("armt_wutrxchk",true)+"}";
  public static final String i_CompleteStateStructure = "{'TRXCODPRG':TRXCODPRG,'TRXCOGNOM':TRXCOGNOM,'TRXNOME':TRXNOME,'TRXDOMICI':TRXDOMICI,'TRXFLGCF':TRXFLGCF,'TRXCODFIS':TRXCODFIS,'TRXLUONAS':TRXLUONAS,'TRXNUMDOC':TRXNUMDOC,'TRXDATSCA':TRXDATSCA,'TRXDATRIL':TRXDATRIL,'TRXAUTRIL':TRXAUTRIL,'TRXNAZRES':TRXNAZRES,'TRXCITRES':TRXCITRES,'TRXTIPDOC':TRXTIPDOC,'TRXDATOPE':TRXDATOPE,'TRXFLGCON':TRXFLGCON,'TRSSEGNO':TRSSEGNO,'TRXIMPORTO':TRXIMPORTO,'TRXCONTAN':TRXCONTAN,'TRXUNIQUE':TRXUNIQUE,'TRXCODDIP':TRXCODDIP,'TRXCOGCON':TRXCOGCON,'TRXNOMCON':TRXNOMCON,'TRXDESTIN':TRXDESTIN,'TRXMTCN':TRXMTCN,'TRXDATNAS':TRXDATNAS,'TRXSESSO':TRXSESSO,'TRXCODCAS':TRXCODCAS,'TRXRECTYPE':TRXRECTYPE,'TRXCODMAG':TRXCODMAG,'TRXCODUNI':TRXCODUNI,'TRXERROR01':TRXERROR01,'TRXERROR02':TRXERROR02,'TRXERROR03':TRXERROR03,'TRXERROR04':TRXERROR04,'TRXERROR05':TRXERROR05,'TRXERROR06':TRXERROR06,'TRXERROR07':TRXERROR07,'TRXERROR08':TRXERROR08,'TRXERROR09':TRXERROR09,'TRXERROR10':TRXERROR10,'TRXERROR11':TRXERROR11,'TRXERROR12':TRXERROR12,'TRXERROR13':TRXERROR13,'TRXERROR14':TRXERROR14,'TRXERROR15':TRXERROR15,'TRXERROR16':TRXERROR16,'TRXERROR17':TRXERROR17,'TRXERROR18':TRXERROR18,'TRXERROR19':TRXERROR19,'TRXERROR20':TRXERROR20,'TRXERROR21':TRXERROR21,'TRXERROR22':TRXERROR22,'TRXERROR23':TRXERROR23,'TRXERROR24':TRXERROR24,'TRXERROR25':TRXERROR25,'TRXERROR26':TRXERROR26,'TRXERROR27':TRXERROR27,'TRXERROR28':TRXERROR28,'TRXERROR29':TRXERROR29,'TRXERROR30':TRXERROR30,'TRXERROR31':TRXERROR31,'TRXERROR32':TRXERROR32,'TRXERROR33':TRXERROR33,'TRXERROR34':TRXERROR34,'TRXERROR35':TRXERROR35,'TRXERROR36':TRXERROR36,'TRXERROR37':TRXERROR37,'TRXERROR38':TRXERROR38,'TRXERROR39':TRXERROR39,'TRXERROR40':TRXERROR40,'TRXERROR41':TRXERROR41,'TRXERROR42':TRXERROR42,'TRXERROR43':TRXERROR43,'TRXERROR44':TRXERROR44,'TRXERROR45':TRXERROR45,'TRXERROR46':TRXERROR46,'TRXERROR47':TRXERROR47,'TRXERROR48':TRXERROR48,'TRXERROR49':TRXERROR49,'TRXERROR50':TRXERROR50,'TRXERRAUA01':TRXERRAUA01,'TRXERRAUA02':TRXERRAUA02,'TRXERRAUA03':TRXERRAUA03,'TRXERRAUA04':TRXERRAUA04,'TRXERRAUA05':TRXERRAUA05,'TRXERRAUA06':TRXERRAUA06,'TRXERRAUA07':TRXERRAUA07,'TRXERRAUA08':TRXERRAUA08,'TRXERRAUA09':TRXERRAUA09,'TRXERRAUA10':TRXERRAUA10,'TRXFLGAUI':TRXFLGAUI,'TRXFLGAUA':TRXFLGAUA,'TRXFLGFOR':TRXFLGFOR,'TRXAUICHK':TRXAUICHK,'TRXAUACHK':TRXAUACHK"+FoundlingChildrenList("armt_wutrxchk",true)+"}";
  public static final String i_ItemSequence = "TRXCODPRG,TRXCOGNOM,TRXNOME,TRXDOMICI,TRXFLGCF,TRXCODFIS,TRXLUONAS,TRXNUMDOC,TRXDATSCA,TRXDATRIL,TRXAUTRIL,TRXNAZRES,TRXCITRES,TRXTIPDOC,TRXDATOPE,TRXFLGCON,TRSSEGNO,TRXIMPORTO,TRXCONTAN,TRXUNIQUE,TRXCODDIP,TRXCOGCON,TRXNOMCON,TRXDESTIN,TRXMTCN,TRXDATNAS,TRXSESSO,TRXCODCAS,TRXRECTYPE,TRXCODMAG,TRXCODUNI,TRXERROR01,TRXERROR02,TRXERROR03,TRXERROR04,TRXERROR05,TRXERROR06,TRXERROR07,TRXERROR08,TRXERROR09,TRXERROR10,TRXERROR11,TRXERROR12,TRXERROR13,TRXERROR14,TRXERROR15,TRXERROR16,TRXERROR17,TRXERROR18,TRXERROR19,TRXERROR20,TRXERROR21,TRXERROR22,TRXERROR23,TRXERROR24,TRXERROR25,TRXERROR26,TRXERROR27,TRXERROR28,TRXERROR29,TRXERROR30,TRXERROR31,TRXERROR32,TRXERROR33,TRXERROR34,TRXERROR35,TRXERROR36,TRXERROR37,TRXERROR38,TRXERROR39,TRXERROR40,TRXERROR41,TRXERROR42,TRXERROR43,TRXERROR44,TRXERROR45,TRXERROR46,TRXERROR47,TRXERROR48,TRXERROR49,TRXERROR50,TRXERRAUA01,TRXERRAUA02,TRXERRAUA03,TRXERRAUA04,TRXERRAUA05,TRXERRAUA06,TRXERRAUA07,TRXERRAUA08,TRXERRAUA09,TRXERRAUA10,TRXFLGAUI,TRXFLGAUA,TRXFLGFOR,TRXAUICHK,TRXAUACHK"+FoundlingChildrenList("armt_wutrxchk",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_wutrxchk"),new String[][]{new String[]{"TRXCODPRG","ID Transazione","N","15","0","campo","key1","false","false"},new String[]{"TRXCOGNOM","Cognome","C","50","0","campo","key2","false","false"},new String[]{"TRXNOME","Nome","C","50","0","campo","nokey","false","false"},new String[]{"TRXDOMICI","Domicilio","C","100","0","campo","nokey","false","false"},new String[]{"TRXFLGCF","Flag Codice Fiscale","C","1","0","campo","nokey","false","false"},new String[]{"TRXCODFIS","Codice Ficale (reale)","C","16","0","campo","key4","false","false"},new String[]{"TRXLUONAS","Luogo di nascita","C","50","0","campo","nokey","false","false"},new String[]{"TRXNUMDOC","Numero Documento","C","30","0","campo","nokey","false","false"},new String[]{"TRXDATSCA","Data Scadenza Documento","D","8","0","campo","nokey","false","false"},new String[]{"TRXDATRIL","Data Rilascio Documento","D","8","0","campo","nokey","false","false"},new String[]{"TRXAUTRIL","Autorit� Rilascio Documento","C","50","0","campo","nokey","false","false"},new String[]{"TRXNAZRES","Nazione di Residenza","C","50","0","campo","nokey","false","false"},new String[]{"TRXCITRES","Citt� Di residenza","C","50","0","campo","nokey","false","false"},new String[]{"TRXTIPDOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"TRXDATOPE","Data Operazione","D","8","0","campo","nokey","false","false"},new String[]{"TRXFLGCON","Flag Contanti","C","1","0","campo","nokey","false","false"},new String[]{"TRSSEGNO","Segno (A=Send,D=Receive)","C","1","0","campo","nokey","false","false"},new String[]{"TRXIMPORTO","Importo","N","15","2","campo","nokey","false","false"},new String[]{"TRXCONTAN","Contante","N","15","2","campo","nokey","false","false"},new String[]{"TRXUNIQUE","Unique ID","C","10","0","campo","nokey","false","false"},new String[]{"TRXCODDIP","Codice Agenzia","C","10","0","campo","nokey","false","false"},new String[]{"TRXCOGCON","Cognome Controparte","C","100","0","campo","nokey","false","false"},new String[]{"TRXNOMCON","Nome Controparte","C","100","0","campo","nokey","false","false"},new String[]{"TRXDESTIN","Stato Controparte","C","100","0","campo","nokey","false","false"},new String[]{"TRXMTCN","MTCN Operazione","C","10","0","campo","key3","false","false"},new String[]{"TRXDATNAS","Data Di Nascita","D","8","0","campo","nokey","false","false"},new String[]{"TRXSESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"TRXCODCAS","Codice Catastale","C","4","0","campo","nokey","false","false"},new String[]{"TRXRECTYPE","Tipo Record","C","1","0","campo","nokey","false","false"},new String[]{"TRXCODMAG","Codice MacroAgente","C","5","0","campo","nokey","false","false"},new String[]{"TRXCODUNI","Codice Univoco","C","18","0","campo","nokey","false","false"},new String[]{"TRXERROR01","Errore 1","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR02","Errore 2","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR03","Errore 3","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR04","Errore 4","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR05","Errore 5","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR06","Errore 6","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR07","Errore 7","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR08","Errore 8","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR09","Errore 9","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR10","Errore 10","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR11","Errore 11","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR12","Errore 12","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR13","Errore 13","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR14","Errore 14","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR15","Errore 15","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR16","Errore 16","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR17","Errore 17","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR18","Errore 18","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR19","Errore 19","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR20","Errore 20","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR21","Errore 21","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR22","Errore 22","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR23","Errore 23","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR24","Errore 24","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR25","Errore 25","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR26","Errore 26","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR27","Errore27","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR28","Errore 28","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR29","Errore 29","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR30","Errore 30","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR31","Errore 31","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR32","Errore 32","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR33","Errore 33","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR34","Errore 34","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR35","Errore 35","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR36","Errore 36","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR37","Errore 37","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR38","Errore 38","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR39","Errore 39","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR40","Errore 40","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR41","Errore 41","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR42","Errore 42","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR43","Errore 43","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR44","Errore 44","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR45","Errore 45","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR46","Errore 46","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR47","Errore 47","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR48","Errore 48","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR49","Errore 49","C","80","0","campo","nokey","false","false"},new String[]{"TRXERROR50","Errore 50","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA01","Errore AUA 1","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA02","Errore AUA 2","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA03","Errore AUA 3","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA04","Errore AUA 4","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA05","Errore AUA 5","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA06","Errore AUA 6","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA07","Errore AUA 7","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA08","Errore AUA 8","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA09","Errore AUA 9","C","80","0","campo","nokey","false","false"},new String[]{"TRXERRAUA10","Errore AUA 10","C","80","0","campo","nokey","false","false"},new String[]{"TRXFLGAUI","OPERAZIONE CORRETTA AUI","C","1","0","campo","nokey","false","false"},new String[]{"TRXFLGAUA","OPERAZIONE CORRETTA AUA","C","1","0","campo","nokey","false","false"},new String[]{"TRXFLGFOR","FORZATURA INSERIMENTO","C","1","0","campo","nokey","false","false"},new String[]{"TRXAUICHK","Check AUI Passato","C","1","0","campo","nokey","false","false"},new String[]{"TRXAUACHK","Check AUA Passato","C","1","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_wutrxchkBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per pi� istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda � contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk",p_ContextObject.GetCompany(),false);
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_oWrInfo_wutrxchk = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wutrxchk",p_ContextObject.GetCompany());
    m_cVirtName_wutrxchk = CPSql.ManipulateTablePhName("wutrxchk",m_cServer_wutrxchk);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    // Istanziazione dei business object dei figli
    m_MNTs = CPLib.MNTChilds("armt_wutrxchk",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_TRXCODPRG = 0;
    w_TRXCOGNOM = "";
    w_TRXNOME = "";
    w_TRXDOMICI = "";
    w_TRXFLGCF = "";
    w_TRXCODFIS = "";
    w_TRXLUONAS = "";
    w_TRXNUMDOC = "";
    w_TRXDATSCA = CPLib.NullDate();
    w_TRXDATRIL = CPLib.NullDate();
    w_TRXAUTRIL = "";
    w_TRXNAZRES = "";
    w_TRXCITRES = "";
    w_TRXTIPDOC = "";
    w_TRXDATOPE = CPLib.NullDate();
    w_TRXFLGCON = "";
    w_TRSSEGNO = "";
    w_TRXIMPORTO = 0;
    w_TRXCONTAN = 0;
    w_TRXUNIQUE = "";
    w_TRXCODDIP = "";
    w_TRXCOGCON = "";
    w_TRXNOMCON = "";
    w_TRXDESTIN = "";
    w_TRXMTCN = "";
    w_TRXDATNAS = CPLib.NullDate();
    w_TRXSESSO = "";
    w_TRXCODCAS = "";
    w_TRXRECTYPE = "";
    w_TRXCODMAG = "";
    w_TRXCODUNI = "";
    w_TRXERROR01 = "";
    w_TRXERROR02 = "";
    w_TRXERROR03 = "";
    w_TRXERROR04 = "";
    w_TRXERROR05 = "";
    w_TRXERROR06 = "";
    w_TRXERROR07 = "";
    w_TRXERROR08 = "";
    w_TRXERROR09 = "";
    w_TRXERROR10 = "";
    w_TRXERROR11 = "";
    w_TRXERROR12 = "";
    w_TRXERROR13 = "";
    w_TRXERROR14 = "";
    w_TRXERROR15 = "";
    w_TRXERROR16 = "";
    w_TRXERROR17 = "";
    w_TRXERROR18 = "";
    w_TRXERROR19 = "";
    w_TRXERROR20 = "";
    w_TRXERROR21 = "";
    w_TRXERROR22 = "";
    w_TRXERROR23 = "";
    w_TRXERROR24 = "";
    w_TRXERROR25 = "";
    w_TRXERROR26 = "";
    w_TRXERROR27 = "";
    w_TRXERROR28 = "";
    w_TRXERROR29 = "";
    w_TRXERROR30 = "";
    w_TRXERROR31 = "";
    w_TRXERROR32 = "";
    w_TRXERROR33 = "";
    w_TRXERROR34 = "";
    w_TRXERROR35 = "";
    w_TRXERROR36 = "";
    w_TRXERROR37 = "";
    w_TRXERROR38 = "";
    w_TRXERROR39 = "";
    w_TRXERROR40 = "";
    w_TRXERROR41 = "";
    w_TRXERROR42 = "";
    w_TRXERROR43 = "";
    w_TRXERROR44 = "";
    w_TRXERROR45 = "";
    w_TRXERROR46 = "";
    w_TRXERROR47 = "";
    w_TRXERROR48 = "";
    w_TRXERROR49 = "";
    w_TRXERROR50 = "";
    w_TRXERRAUA01 = "";
    w_TRXERRAUA02 = "";
    w_TRXERRAUA03 = "";
    w_TRXERRAUA04 = "";
    w_TRXERRAUA05 = "";
    w_TRXERRAUA06 = "";
    w_TRXERRAUA07 = "";
    w_TRXERRAUA08 = "";
    w_TRXERRAUA09 = "";
    w_TRXERRAUA10 = "";
    w_TRXFLGAUI = "";
    w_TRXFLGAUA = "";
    w_TRXFLGFOR = "";
    w_TRXAUICHK = "";
    w_TRXAUACHK = "";
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
                              I seguenti metodi sono pubblici perch� vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_TRXCODPRG(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODPRG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCOGNOM(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCOGNOM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNOME(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDOMICI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDOMICI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGCF(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGCF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODFIS(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODFIS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXLUONAS(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXLUONAS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNUMDOC(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNUMDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATSCA(java.sql.Date p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATSCA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATRIL(java.sql.Date p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATRIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXAUTRIL(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXAUTRIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNAZRES(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNAZRES = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCITRES(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCITRES = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXTIPDOC(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXTIPDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATOPE(java.sql.Date p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGCON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRSSEGNO(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRSSEGNO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXIMPORTO(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXIMPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCONTAN(double p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCONTAN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXUNIQUE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXUNIQUE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODDIP(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODDIP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCOGCON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCOGCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXNOMCON(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXNOMCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDESTIN(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDESTIN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXMTCN(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXMTCN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXDATNAS(java.sql.Date p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXDATNAS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXSESSO(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXSESSO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODCAS(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODCAS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXRECTYPE(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXRECTYPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODMAG(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODMAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXCODUNI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXCODUNI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR01(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR01 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR02(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR02 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR03(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR03 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR04(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR04 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR05(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR05 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR06(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR06 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR07(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR07 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR08(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR08 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR09(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR09 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR10(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR10 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR11(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR11 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR12(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR12 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR13(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR13 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR14(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR14 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR15(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR15 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR16(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR16 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR17(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR17 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR18(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR18 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR19(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR19 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR20(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR20 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR21(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR21 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR22(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR22 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR23(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR23 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR24(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR24 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR25(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR25 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR26(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR26 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR27(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR27 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR28(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR28 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR29(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR29 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR30(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR30 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR31(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR31 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR32(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR32 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR33(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR33 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR34(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR34 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR35(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR35 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR36(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR36 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR37(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR37 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR38(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR38 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR39(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR39 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR40(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR40 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR41(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR41 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR42(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR42 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR43(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR43 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR44(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR44 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR45(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR45 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR46(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR46 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR47(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR47 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR48(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR48 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR49(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR49 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERROR50(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERROR50 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA01(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA01 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA02(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA02 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA03(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA03 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA04(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA04 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA05(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA05 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA06(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA06 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA07(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA07 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA08(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA08 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA09(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA09 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXERRAUA10(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXERRAUA10 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGAUI(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGAUI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGAUA(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGAUA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXFLGFOR(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXFLGFOR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXAUICHK(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXAUICHK = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TRXAUACHK(String p_workVariableValue) {
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterr� il risultato della funzione di link se l'item corrente � parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TRXAUACHK = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilit� e di
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
  public final static String[] m_KeyColumns = {"TRXCODPRG"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ProjectAndApplicationQueryFilter("armt_wutrxchk","wutrxchk",m_KeyColumns,"TRXAUACHK='N' and TRXAUICHK='S'",m_Ctx);
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
    w_TRXCODPRG = 0;
    w_TRXCOGNOM = "";
    w_TRXNOME = "";
    w_TRXDOMICI = "";
    w_TRXFLGCF = "";
    w_TRXCODFIS = "";
    w_TRXLUONAS = "";
    w_TRXNUMDOC = "";
    w_TRXDATSCA = CPLib.NullDate();
    w_TRXDATRIL = CPLib.NullDate();
    w_TRXAUTRIL = "";
    w_TRXNAZRES = "";
    w_TRXCITRES = "";
    w_TRXTIPDOC = "";
    w_TRXDATOPE = CPLib.NullDate();
    w_TRXFLGCON = "";
    w_TRSSEGNO = "";
    w_TRXIMPORTO = 0;
    w_TRXCONTAN = 0;
    w_TRXUNIQUE = "";
    w_TRXCODDIP = "";
    w_TRXCOGCON = "";
    w_TRXNOMCON = "";
    w_TRXDESTIN = "";
    w_TRXMTCN = "";
    w_TRXDATNAS = CPLib.NullDate();
    w_TRXSESSO = "";
    w_TRXCODCAS = "";
    w_TRXRECTYPE = "";
    w_TRXCODMAG = "";
    w_TRXCODUNI = "";
    w_TRXERROR01 = "";
    w_TRXERROR02 = "";
    w_TRXERROR03 = "";
    w_TRXERROR04 = "";
    w_TRXERROR05 = "";
    w_TRXERROR06 = "";
    w_TRXERROR07 = "";
    w_TRXERROR08 = "";
    w_TRXERROR09 = "";
    w_TRXERROR10 = "";
    w_TRXERROR11 = "";
    w_TRXERROR12 = "";
    w_TRXERROR13 = "";
    w_TRXERROR14 = "";
    w_TRXERROR15 = "";
    w_TRXERROR16 = "";
    w_TRXERROR17 = "";
    w_TRXERROR18 = "";
    w_TRXERROR19 = "";
    w_TRXERROR20 = "";
    w_TRXERROR21 = "";
    w_TRXERROR22 = "";
    w_TRXERROR23 = "";
    w_TRXERROR24 = "";
    w_TRXERROR25 = "";
    w_TRXERROR26 = "";
    w_TRXERROR27 = "";
    w_TRXERROR28 = "";
    w_TRXERROR29 = "";
    w_TRXERROR30 = "";
    w_TRXERROR31 = "";
    w_TRXERROR32 = "";
    w_TRXERROR33 = "";
    w_TRXERROR34 = "";
    w_TRXERROR35 = "";
    w_TRXERROR36 = "";
    w_TRXERROR37 = "";
    w_TRXERROR38 = "";
    w_TRXERROR39 = "";
    w_TRXERROR40 = "";
    w_TRXERROR41 = "";
    w_TRXERROR42 = "";
    w_TRXERROR43 = "";
    w_TRXERROR44 = "";
    w_TRXERROR45 = "";
    w_TRXERROR46 = "";
    w_TRXERROR47 = "";
    w_TRXERROR48 = "";
    w_TRXERROR49 = "";
    w_TRXERROR50 = "";
    w_TRXERRAUA01 = "";
    w_TRXERRAUA02 = "";
    w_TRXERRAUA03 = "";
    w_TRXERRAUA04 = "";
    w_TRXERRAUA05 = "";
    w_TRXERRAUA06 = "";
    w_TRXERRAUA07 = "";
    w_TRXERRAUA08 = "";
    w_TRXERRAUA09 = "";
    w_TRXERRAUA10 = "";
    w_TRXFLGAUI = "";
    w_TRXFLGAUA = "";
    w_TRXFLGFOR = "";
    w_TRXAUICHK = "";
    w_TRXAUACHK = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_TRXCODPRG = CPLib.GetProperty(p,"TRXCODPRG",w_TRXCODPRG,0);
      op_TRXCODPRG = CPLib.GetProperty(p,"op_TRXCODPRG",0,0);
      w_TRXCOGNOM = CPLib.GetProperty(p,"TRXCOGNOM",w_TRXCOGNOM,0);
      w_TRXNOME = CPLib.GetProperty(p,"TRXNOME",w_TRXNOME,0);
      w_TRXDOMICI = CPLib.GetProperty(p,"TRXDOMICI",w_TRXDOMICI,0);
      w_TRXFLGCF = CPLib.GetProperty(p,"TRXFLGCF",w_TRXFLGCF,0);
      w_TRXCODFIS = CPLib.GetProperty(p,"TRXCODFIS",w_TRXCODFIS,0);
      w_TRXLUONAS = CPLib.GetProperty(p,"TRXLUONAS",w_TRXLUONAS,0);
      w_TRXNUMDOC = CPLib.GetProperty(p,"TRXNUMDOC",w_TRXNUMDOC,0);
      w_TRXDATSCA = CPLib.GetProperty(p,"TRXDATSCA",w_TRXDATSCA,0);
      w_TRXDATRIL = CPLib.GetProperty(p,"TRXDATRIL",w_TRXDATRIL,0);
      w_TRXAUTRIL = CPLib.GetProperty(p,"TRXAUTRIL",w_TRXAUTRIL,0);
      w_TRXNAZRES = CPLib.GetProperty(p,"TRXNAZRES",w_TRXNAZRES,0);
      w_TRXCITRES = CPLib.GetProperty(p,"TRXCITRES",w_TRXCITRES,0);
      w_TRXTIPDOC = CPLib.GetProperty(p,"TRXTIPDOC",w_TRXTIPDOC,0);
      w_TRXDATOPE = CPLib.GetProperty(p,"TRXDATOPE",w_TRXDATOPE,0);
      w_TRXFLGCON = CPLib.GetProperty(p,"TRXFLGCON",w_TRXFLGCON,0);
      w_TRSSEGNO = CPLib.GetProperty(p,"TRSSEGNO",w_TRSSEGNO,0);
      w_TRXIMPORTO = CPLib.GetProperty(p,"TRXIMPORTO",w_TRXIMPORTO,0);
      w_TRXCONTAN = CPLib.GetProperty(p,"TRXCONTAN",w_TRXCONTAN,0);
      w_TRXUNIQUE = CPLib.GetProperty(p,"TRXUNIQUE",w_TRXUNIQUE,0);
      w_TRXCODDIP = CPLib.GetProperty(p,"TRXCODDIP",w_TRXCODDIP,0);
      w_TRXCOGCON = CPLib.GetProperty(p,"TRXCOGCON",w_TRXCOGCON,0);
      w_TRXNOMCON = CPLib.GetProperty(p,"TRXNOMCON",w_TRXNOMCON,0);
      w_TRXDESTIN = CPLib.GetProperty(p,"TRXDESTIN",w_TRXDESTIN,0);
      w_TRXMTCN = CPLib.GetProperty(p,"TRXMTCN",w_TRXMTCN,0);
      w_TRXDATNAS = CPLib.GetProperty(p,"TRXDATNAS",w_TRXDATNAS,0);
      w_TRXSESSO = CPLib.GetProperty(p,"TRXSESSO",w_TRXSESSO,0);
      w_TRXCODCAS = CPLib.GetProperty(p,"TRXCODCAS",w_TRXCODCAS,0);
      w_TRXRECTYPE = CPLib.GetProperty(p,"TRXRECTYPE",w_TRXRECTYPE,0);
      w_TRXCODMAG = CPLib.GetProperty(p,"TRXCODMAG",w_TRXCODMAG,0);
      w_TRXCODUNI = CPLib.GetProperty(p,"TRXCODUNI",w_TRXCODUNI,0);
      w_TRXERROR01 = CPLib.GetProperty(p,"TRXERROR01",w_TRXERROR01,0);
      w_TRXERROR02 = CPLib.GetProperty(p,"TRXERROR02",w_TRXERROR02,0);
      w_TRXERROR03 = CPLib.GetProperty(p,"TRXERROR03",w_TRXERROR03,0);
      w_TRXERROR04 = CPLib.GetProperty(p,"TRXERROR04",w_TRXERROR04,0);
      w_TRXERROR05 = CPLib.GetProperty(p,"TRXERROR05",w_TRXERROR05,0);
      w_TRXERROR06 = CPLib.GetProperty(p,"TRXERROR06",w_TRXERROR06,0);
      w_TRXERROR07 = CPLib.GetProperty(p,"TRXERROR07",w_TRXERROR07,0);
      w_TRXERROR08 = CPLib.GetProperty(p,"TRXERROR08",w_TRXERROR08,0);
      w_TRXERROR09 = CPLib.GetProperty(p,"TRXERROR09",w_TRXERROR09,0);
      w_TRXERROR10 = CPLib.GetProperty(p,"TRXERROR10",w_TRXERROR10,0);
      w_TRXERROR11 = CPLib.GetProperty(p,"TRXERROR11",w_TRXERROR11,0);
      w_TRXERROR12 = CPLib.GetProperty(p,"TRXERROR12",w_TRXERROR12,0);
      w_TRXERROR13 = CPLib.GetProperty(p,"TRXERROR13",w_TRXERROR13,0);
      w_TRXERROR14 = CPLib.GetProperty(p,"TRXERROR14",w_TRXERROR14,0);
      w_TRXERROR15 = CPLib.GetProperty(p,"TRXERROR15",w_TRXERROR15,0);
      w_TRXERROR16 = CPLib.GetProperty(p,"TRXERROR16",w_TRXERROR16,0);
      w_TRXERROR17 = CPLib.GetProperty(p,"TRXERROR17",w_TRXERROR17,0);
      w_TRXERROR18 = CPLib.GetProperty(p,"TRXERROR18",w_TRXERROR18,0);
      w_TRXERROR19 = CPLib.GetProperty(p,"TRXERROR19",w_TRXERROR19,0);
      w_TRXERROR20 = CPLib.GetProperty(p,"TRXERROR20",w_TRXERROR20,0);
      w_TRXERROR21 = CPLib.GetProperty(p,"TRXERROR21",w_TRXERROR21,0);
      w_TRXERROR22 = CPLib.GetProperty(p,"TRXERROR22",w_TRXERROR22,0);
      w_TRXERROR23 = CPLib.GetProperty(p,"TRXERROR23",w_TRXERROR23,0);
      w_TRXERROR24 = CPLib.GetProperty(p,"TRXERROR24",w_TRXERROR24,0);
      w_TRXERROR25 = CPLib.GetProperty(p,"TRXERROR25",w_TRXERROR25,0);
      w_TRXERROR26 = CPLib.GetProperty(p,"TRXERROR26",w_TRXERROR26,0);
      w_TRXERROR27 = CPLib.GetProperty(p,"TRXERROR27",w_TRXERROR27,0);
      w_TRXERROR28 = CPLib.GetProperty(p,"TRXERROR28",w_TRXERROR28,0);
      w_TRXERROR29 = CPLib.GetProperty(p,"TRXERROR29",w_TRXERROR29,0);
      w_TRXERROR30 = CPLib.GetProperty(p,"TRXERROR30",w_TRXERROR30,0);
      w_TRXERROR31 = CPLib.GetProperty(p,"TRXERROR31",w_TRXERROR31,0);
      w_TRXERROR32 = CPLib.GetProperty(p,"TRXERROR32",w_TRXERROR32,0);
      w_TRXERROR33 = CPLib.GetProperty(p,"TRXERROR33",w_TRXERROR33,0);
      w_TRXERROR34 = CPLib.GetProperty(p,"TRXERROR34",w_TRXERROR34,0);
      w_TRXERROR35 = CPLib.GetProperty(p,"TRXERROR35",w_TRXERROR35,0);
      w_TRXERROR36 = CPLib.GetProperty(p,"TRXERROR36",w_TRXERROR36,0);
      w_TRXERROR37 = CPLib.GetProperty(p,"TRXERROR37",w_TRXERROR37,0);
      w_TRXERROR38 = CPLib.GetProperty(p,"TRXERROR38",w_TRXERROR38,0);
      w_TRXERROR39 = CPLib.GetProperty(p,"TRXERROR39",w_TRXERROR39,0);
      w_TRXERROR40 = CPLib.GetProperty(p,"TRXERROR40",w_TRXERROR40,0);
      w_TRXERROR41 = CPLib.GetProperty(p,"TRXERROR41",w_TRXERROR41,0);
      w_TRXERROR42 = CPLib.GetProperty(p,"TRXERROR42",w_TRXERROR42,0);
      w_TRXERROR43 = CPLib.GetProperty(p,"TRXERROR43",w_TRXERROR43,0);
      w_TRXERROR44 = CPLib.GetProperty(p,"TRXERROR44",w_TRXERROR44,0);
      w_TRXERROR45 = CPLib.GetProperty(p,"TRXERROR45",w_TRXERROR45,0);
      w_TRXERROR46 = CPLib.GetProperty(p,"TRXERROR46",w_TRXERROR46,0);
      w_TRXERROR47 = CPLib.GetProperty(p,"TRXERROR47",w_TRXERROR47,0);
      w_TRXERROR48 = CPLib.GetProperty(p,"TRXERROR48",w_TRXERROR48,0);
      w_TRXERROR49 = CPLib.GetProperty(p,"TRXERROR49",w_TRXERROR49,0);
      w_TRXERROR50 = CPLib.GetProperty(p,"TRXERROR50",w_TRXERROR50,0);
      w_TRXERRAUA01 = CPLib.GetProperty(p,"TRXERRAUA01",w_TRXERRAUA01,0);
      w_TRXERRAUA02 = CPLib.GetProperty(p,"TRXERRAUA02",w_TRXERRAUA02,0);
      w_TRXERRAUA03 = CPLib.GetProperty(p,"TRXERRAUA03",w_TRXERRAUA03,0);
      w_TRXERRAUA04 = CPLib.GetProperty(p,"TRXERRAUA04",w_TRXERRAUA04,0);
      w_TRXERRAUA05 = CPLib.GetProperty(p,"TRXERRAUA05",w_TRXERRAUA05,0);
      w_TRXERRAUA06 = CPLib.GetProperty(p,"TRXERRAUA06",w_TRXERRAUA06,0);
      w_TRXERRAUA07 = CPLib.GetProperty(p,"TRXERRAUA07",w_TRXERRAUA07,0);
      w_TRXERRAUA08 = CPLib.GetProperty(p,"TRXERRAUA08",w_TRXERRAUA08,0);
      w_TRXERRAUA09 = CPLib.GetProperty(p,"TRXERRAUA09",w_TRXERRAUA09,0);
      w_TRXERRAUA10 = CPLib.GetProperty(p,"TRXERRAUA10",w_TRXERRAUA10,0);
      w_TRXFLGAUI = CPLib.GetProperty(p,"TRXFLGAUI",w_TRXFLGAUI,0);
      w_TRXFLGAUA = CPLib.GetProperty(p,"TRXFLGAUA",w_TRXFLGAUA,0);
      w_TRXFLGFOR = CPLib.GetProperty(p,"TRXFLGFOR",w_TRXFLGFOR,0);
      w_TRXAUICHK = CPLib.GetProperty(p,"TRXAUICHK",w_TRXAUICHK,0);
      w_TRXAUACHK = CPLib.GetProperty(p,"TRXAUACHK",w_TRXAUACHK,0);
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
    for(String child : CPLib.LoadableMNTs("armt_wutrxchk",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_wutrxchk",child);
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
    m_MNTs = CPLib.MNTChilds("armt_wutrxchk",m_Ctx);
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
      l_Keys = new String[]{"armt_wutrxchk"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_wutrxchk\\"+p_cState};
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
    w_TRXCODPRG = m_Ctx.AskTableProg(w_TRXCODPRG,15,op_TRXCODPRG,"PRGRTRA",m_cServer_wutrxchk);
    op_TRXCODPRG = w_TRXCODPRG;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_TRXCODPRG = 0;
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
    CPLib.PutProperty(p,"TRXCODPRG",w_TRXCODPRG,0);
    CPLib.PutProperty(p,"op_TRXCODPRG",op_TRXCODPRG,0);
    CPLib.PutProperty(p,"TRXCOGNOM",w_TRXCOGNOM,0);
    CPLib.PutProperty(p,"TRXNOME",w_TRXNOME,0);
    CPLib.PutProperty(p,"TRXDOMICI",w_TRXDOMICI,0);
    CPLib.PutProperty(p,"TRXFLGCF",w_TRXFLGCF,0);
    CPLib.PutProperty(p,"TRXCODFIS",w_TRXCODFIS,0);
    CPLib.PutProperty(p,"TRXLUONAS",w_TRXLUONAS,0);
    CPLib.PutProperty(p,"TRXNUMDOC",w_TRXNUMDOC,0);
    CPLib.PutProperty(p,"TRXDATSCA",w_TRXDATSCA,0);
    CPLib.PutProperty(p,"TRXDATRIL",w_TRXDATRIL,0);
    CPLib.PutProperty(p,"TRXAUTRIL",w_TRXAUTRIL,0);
    CPLib.PutProperty(p,"TRXNAZRES",w_TRXNAZRES,0);
    CPLib.PutProperty(p,"TRXCITRES",w_TRXCITRES,0);
    CPLib.PutProperty(p,"TRXTIPDOC",w_TRXTIPDOC,0);
    CPLib.PutProperty(p,"TRXDATOPE",w_TRXDATOPE,0);
    CPLib.PutProperty(p,"TRXFLGCON",w_TRXFLGCON,0);
    CPLib.PutProperty(p,"TRSSEGNO",w_TRSSEGNO,0);
    CPLib.PutProperty(p,"TRXIMPORTO",w_TRXIMPORTO,0);
    CPLib.PutProperty(p,"TRXCONTAN",w_TRXCONTAN,0);
    CPLib.PutProperty(p,"TRXUNIQUE",w_TRXUNIQUE,0);
    CPLib.PutProperty(p,"TRXCODDIP",w_TRXCODDIP,0);
    CPLib.PutProperty(p,"TRXCOGCON",w_TRXCOGCON,0);
    CPLib.PutProperty(p,"TRXNOMCON",w_TRXNOMCON,0);
    CPLib.PutProperty(p,"TRXDESTIN",w_TRXDESTIN,0);
    CPLib.PutProperty(p,"TRXMTCN",w_TRXMTCN,0);
    CPLib.PutProperty(p,"TRXDATNAS",w_TRXDATNAS,0);
    CPLib.PutProperty(p,"TRXSESSO",w_TRXSESSO,0);
    CPLib.PutProperty(p,"TRXCODCAS",w_TRXCODCAS,0);
    CPLib.PutProperty(p,"TRXRECTYPE",w_TRXRECTYPE,0);
    CPLib.PutProperty(p,"TRXCODMAG",w_TRXCODMAG,0);
    CPLib.PutProperty(p,"TRXCODUNI",w_TRXCODUNI,0);
    CPLib.PutProperty(p,"TRXERROR01",w_TRXERROR01,0);
    CPLib.PutProperty(p,"TRXERROR02",w_TRXERROR02,0);
    CPLib.PutProperty(p,"TRXERROR03",w_TRXERROR03,0);
    CPLib.PutProperty(p,"TRXERROR04",w_TRXERROR04,0);
    CPLib.PutProperty(p,"TRXERROR05",w_TRXERROR05,0);
    CPLib.PutProperty(p,"TRXERROR06",w_TRXERROR06,0);
    CPLib.PutProperty(p,"TRXERROR07",w_TRXERROR07,0);
    CPLib.PutProperty(p,"TRXERROR08",w_TRXERROR08,0);
    CPLib.PutProperty(p,"TRXERROR09",w_TRXERROR09,0);
    CPLib.PutProperty(p,"TRXERROR10",w_TRXERROR10,0);
    CPLib.PutProperty(p,"TRXERROR11",w_TRXERROR11,0);
    CPLib.PutProperty(p,"TRXERROR12",w_TRXERROR12,0);
    CPLib.PutProperty(p,"TRXERROR13",w_TRXERROR13,0);
    CPLib.PutProperty(p,"TRXERROR14",w_TRXERROR14,0);
    CPLib.PutProperty(p,"TRXERROR15",w_TRXERROR15,0);
    CPLib.PutProperty(p,"TRXERROR16",w_TRXERROR16,0);
    CPLib.PutProperty(p,"TRXERROR17",w_TRXERROR17,0);
    CPLib.PutProperty(p,"TRXERROR18",w_TRXERROR18,0);
    CPLib.PutProperty(p,"TRXERROR19",w_TRXERROR19,0);
    CPLib.PutProperty(p,"TRXERROR20",w_TRXERROR20,0);
    CPLib.PutProperty(p,"TRXERROR21",w_TRXERROR21,0);
    CPLib.PutProperty(p,"TRXERROR22",w_TRXERROR22,0);
    CPLib.PutProperty(p,"TRXERROR23",w_TRXERROR23,0);
    CPLib.PutProperty(p,"TRXERROR24",w_TRXERROR24,0);
    CPLib.PutProperty(p,"TRXERROR25",w_TRXERROR25,0);
    CPLib.PutProperty(p,"TRXERROR26",w_TRXERROR26,0);
    CPLib.PutProperty(p,"TRXERROR27",w_TRXERROR27,0);
    CPLib.PutProperty(p,"TRXERROR28",w_TRXERROR28,0);
    CPLib.PutProperty(p,"TRXERROR29",w_TRXERROR29,0);
    CPLib.PutProperty(p,"TRXERROR30",w_TRXERROR30,0);
    CPLib.PutProperty(p,"TRXERROR31",w_TRXERROR31,0);
    CPLib.PutProperty(p,"TRXERROR32",w_TRXERROR32,0);
    CPLib.PutProperty(p,"TRXERROR33",w_TRXERROR33,0);
    CPLib.PutProperty(p,"TRXERROR34",w_TRXERROR34,0);
    CPLib.PutProperty(p,"TRXERROR35",w_TRXERROR35,0);
    CPLib.PutProperty(p,"TRXERROR36",w_TRXERROR36,0);
    CPLib.PutProperty(p,"TRXERROR37",w_TRXERROR37,0);
    CPLib.PutProperty(p,"TRXERROR38",w_TRXERROR38,0);
    CPLib.PutProperty(p,"TRXERROR39",w_TRXERROR39,0);
    CPLib.PutProperty(p,"TRXERROR40",w_TRXERROR40,0);
    CPLib.PutProperty(p,"TRXERROR41",w_TRXERROR41,0);
    CPLib.PutProperty(p,"TRXERROR42",w_TRXERROR42,0);
    CPLib.PutProperty(p,"TRXERROR43",w_TRXERROR43,0);
    CPLib.PutProperty(p,"TRXERROR44",w_TRXERROR44,0);
    CPLib.PutProperty(p,"TRXERROR45",w_TRXERROR45,0);
    CPLib.PutProperty(p,"TRXERROR46",w_TRXERROR46,0);
    CPLib.PutProperty(p,"TRXERROR47",w_TRXERROR47,0);
    CPLib.PutProperty(p,"TRXERROR48",w_TRXERROR48,0);
    CPLib.PutProperty(p,"TRXERROR49",w_TRXERROR49,0);
    CPLib.PutProperty(p,"TRXERROR50",w_TRXERROR50,0);
    CPLib.PutProperty(p,"TRXERRAUA01",w_TRXERRAUA01,0);
    CPLib.PutProperty(p,"TRXERRAUA02",w_TRXERRAUA02,0);
    CPLib.PutProperty(p,"TRXERRAUA03",w_TRXERRAUA03,0);
    CPLib.PutProperty(p,"TRXERRAUA04",w_TRXERRAUA04,0);
    CPLib.PutProperty(p,"TRXERRAUA05",w_TRXERRAUA05,0);
    CPLib.PutProperty(p,"TRXERRAUA06",w_TRXERRAUA06,0);
    CPLib.PutProperty(p,"TRXERRAUA07",w_TRXERRAUA07,0);
    CPLib.PutProperty(p,"TRXERRAUA08",w_TRXERRAUA08,0);
    CPLib.PutProperty(p,"TRXERRAUA09",w_TRXERRAUA09,0);
    CPLib.PutProperty(p,"TRXERRAUA10",w_TRXERRAUA10,0);
    CPLib.PutProperty(p,"TRXFLGAUI",w_TRXFLGAUI,0);
    CPLib.PutProperty(p,"TRXFLGAUA",w_TRXFLGAUA,0);
    CPLib.PutProperty(p,"TRXFLGFOR",w_TRXFLGFOR,0);
    CPLib.PutProperty(p,"TRXAUICHK",w_TRXAUICHK,0);
    CPLib.PutProperty(p,"TRXAUACHK",w_TRXAUACHK,0);
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
    return "wutrxchk"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("TRXCODPRG","N",15,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("w_TRXCODPRG");
    oneAutoNum.add("PRGRTRA");
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
