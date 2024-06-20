import java.util.*;

public class armt_storopeBL extends armt_storopeWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_storope";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_wperazbo;
  public String m_cServer_wperazbo;
  public CPPhTableWrInfo m_oWrInfo_wperazbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_wperazbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public CPPhTableWrInfo m_oWrInfo_anarapbo;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public CPPhTableWrInfo m_oWrInfo_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public CPPhTableWrInfo m_oWrInfo_kersonbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public CPPhTableWrInfo m_oWrInfo_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public CPPhTableWrInfo m_oWrInfo_tbcausin;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbdurata;
  public String m_cServer_tbdurata;
  public CPPhTableWrInfo m_oWrInfo_tbdurata;
  public String m_cPhName_tbimporto;
  public String m_cServer_tbimporto;
  public CPPhTableWrInfo m_oWrInfo_tbimporto;
  public String m_cPhName_tbplauso;
  public String m_cServer_tbplauso;
  public CPPhTableWrInfo m_oWrInfo_tbplauso;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbsvolgim;
  public String m_cServer_tbsvolgim;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim;
  public String m_cPhName_tbtipint;
  public String m_cServer_tbtipint;
  public CPPhTableWrInfo m_oWrInfo_tbtipint;
  public String m_cPhName_tbtipleg;
  public String m_cServer_tbtipleg;
  public CPPhTableWrInfo m_oWrInfo_tbtipleg;
  public String m_cPhName_tbtipope;
  public String m_cServer_tbtipope;
  public CPPhTableWrInfo m_oWrInfo_tbtipope;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public CPPhTableWrInfo m_oWrInfo_tbtipreg;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"wperazbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'DATAOPE':DATAOPE,'DATAREG':DATAREG,'FLAGFRAZ':FLAGFRAZ,'TIPOOPRAP':TIPOOPRAP,'CODANA':CODANA,'CODVOC':CODVOC,'appolire':appolire,'VALUTA':VALUTA,'xTOTLIRE':xTOTLIRE,'FLAGCONT':FLAGCONT,'xTOTCONT':xTOTCONT,'CAMBIO':CAMBIO,'RAPPORTO':RAPPORTO,'CONNESCLI':CONNESCLI,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'PAGASOGOP':PAGASOGOP,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'C_RAG':C_RAG,'C_CTA':C_CTA,'C_PRV':C_PRV,'C_CAP':C_CAP,'C_CAB':C_CAB,'C_IND':C_IND,'C_STA':C_STA,'TIPOINT2':TIPOINT2,'CODINT2':CODINT2,'DESCINTER':DESCINTER,'PAESE':PAESE,'C_RAPPORTO':C_RAPPORTO,'CODCAB2':CODCAB2,'PROV2':PROV2,'DESC2':DESC2,'ZCPARTE':ZCPARTE,'IDBASE':IDBASE,'CODDIPE':CODDIPE,'DATARETT':DATARETT,'ardt_storsogope':ardt_storsogope,'ardt_wlientiope':ardt_wlientiope,'ardt_weneficope':ardt_weneficope,'ardt_werzistiope':ardt_werzistiope,'OPERAG':OPERAG,'NOPROT':NOPROT,'RESPINS':RESPINS,'INFORM':INFORM,'NATURA':NATURA,'SCOPO':SCOPO,'AREAGEO':AREAGEO,'MODSVOL':MODSVOL,'RAGIO':RAGIO,'TIPO':TIPO,'RAREA':RAREA,'RCOMP':RCOMP,'RRAGIO':RRAGIO,'RTIPO':RTIPO,'RFREQ':RFREQ,'RIMP':RIMP,'DURAT':DURAT,'AMMONT':AMMONT,'MITIG':MITIG,'MITGDOC':MITGDOC,'ardt_docopebo':ardt_docopebo,'CONNESDOC':CONNESDOC,'MTCN':MTCN"+FoundlingChildrenList("armt_storope",true)+"}";
  public static final String i_CompleteStateStructure = "{'DATAOPE':DATAOPE,'CDATOPE':CDATOPE,'filtro':filtro,'DATAREG':DATAREG,'FLAGFRAZ':FLAGFRAZ,'COLLEG':COLLEG,'TIPOOPRAP':TIPOOPRAP,'CODANA':CODANA,'CODVOC':CODVOC,'FLAGLIRE':FLAGLIRE,'appolire':appolire,'VALUTA':VALUTA,'xTOTLIRE':xTOTLIRE,'FLAGCONT':FLAGCONT,'xTOTCONT':xTOTCONT,'CAMBIO':CAMBIO,'RAPPORTO':RAPPORTO,'CONNESCLI':CONNESCLI,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'PAGASOGOP':PAGASOGOP,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'C_RAG':C_RAG,'C_CTA':C_CTA,'C_PRV':C_PRV,'C_CAP':C_CAP,'C_CAB':C_CAB,'C_IND':C_IND,'C_STA':C_STA,'TIPOINT2':TIPOINT2,'CODINT2':CODINT2,'DESCINTER':DESCINTER,'PAESE':PAESE,'C_RAPPORTO':C_RAPPORTO,'CODCAB2':CODCAB2,'PROV2':PROV2,'DESC2':DESC2,'ZCPARTE':ZCPARTE,'IDBASE':IDBASE,'NUMPROG':NUMPROG,'CODINTER':CODINTER,'CODDIPE':CODDIPE,'DESCCIT':DESCCIT,'SEGNO':SEGNO,'DATARETT':DATARETT,'STATOREG':STATOREG,'PROVINCIA':PROVINCIA,'CODCAB':CODCAB,'tipope':tipope,'TOTLIRE':TOTLIRE,'TOTCONT':TOTCONT,'TIPOINF':TIPOINF,'IDEREG':IDEREG,'FLAGRAP':FLAGRAP,'OPRAP':OPRAP,'OPERAZMOD':OPERAZMOD,'RAPPORTBEN':RAPPORTBEN,'OPERATORE':OPERATORE,'AUTOM':AUTOM,'gIntemediario':gIntemediario,'xdes1':xdes1,'desccauana':desccauana,'xdesccausin':xdesccausin,'descdiv':descdiv,'xragsocper':xragsocper,'xdescrap':xdescrap,'xragsocct':xragsocct,'xragsocben':xragsocben,'xdestipleg':xdestipleg,'xragint2':xragint2,'xdescpaese2':xdescpaese2,'datpaseuro':datpaseuro,'xDescDipe':xDescDipe,'sEdit':sEdit,'gChkDate':gChkDate,'errmsg':errmsg,'test':test,'FLAGRAP2':FLAGRAP2,'valflg2':valflg2,'gTipInter':gTipInter,'gSblocco':gSblocco,'xcodfisc':xcodfisc,'PRGIMPOPE':PRGIMPOPE,'dataoggi':dataoggi,'stringaflagrap2':stringaflagrap2,'CDATAOPE':CDATAOPE,'gDataVaria':gDataVaria,'gStatus':gStatus,'CITINT':CITINT,'CITDIP':CITDIP,'PROVDIP':PROVDIP,'CABDIP':CABDIP,'PROVINT':PROVINT,'CABINT':CABINT,'CONNESDOC':CONNESDOC,'gFlgDoc':gFlgDoc,'dessta':dessta,'xragsocalt':xragsocalt,'xdciticon':xdciticon,'gFlgWU':gFlgWU,'CDATREG':CDATREG,'DATAVALI':DATAVALI,'DATARILASC':DATARILASC,'apporeg':apporeg,'gFlgDTP':gFlgDTP,'ANNOOPE':ANNOOPE,'ardt_storsogope':ardt_storsogope,'xdescmodsvo':xdescmodsvo,'xdescareag':xdescareag,'xdescplauso':xdescplauso,'xdesctipor':xdesctipor,'xdescopeage':xdescopeage,'xdescfreq':xdescfreq,'xdescammo':xdescammo,'ardt_wlientiope':ardt_wlientiope,'ardt_weneficope':ardt_weneficope,'ardt_werzistiope':ardt_werzistiope,'OPERAG':OPERAG,'NOPROT':NOPROT,'RESPINS':RESPINS,'INFORM':INFORM,'NATURA':NATURA,'SCOPO':SCOPO,'AREAGEO':AREAGEO,'MODSVOL':MODSVOL,'RAGIO':RAGIO,'TIPO':TIPO,'RAREA':RAREA,'RCOMP':RCOMP,'RRAGIO':RRAGIO,'RTIPO':RTIPO,'RFREQ':RFREQ,'RIMP':RIMP,'DURAT':DURAT,'AMMONT':AMMONT,'IPCOLLEG':IPCOLLEG,'ORACOLLEG':ORACOLLEG,'DUCOLLEG':DUCOLLEG,'MITIG':MITIG,'MITGDOC':MITGDOC,'ardt_docopebo':ardt_docopebo,'xRAGSOCDOC':xRAGSOCDOC,'IDFILE':IDFILE,'MTCN':MTCN"+FoundlingChildrenList("armt_storope",true)+"}";
  public static final String i_ItemSequence = "DATAOPE,DATAREG,FLAGFRAZ,TIPOOPRAP,CODANA,CODVOC,appolire,VALUTA,xTOTLIRE,FLAGCONT,xTOTCONT,CAMBIO,RAPPORTO,CONNESCLI,CONNESOPER,TIPOLEG,PAGASOGOP,CONNESBEN,CONNALTRO,C_RAG,C_CTA,C_PRV,C_CAP,C_CAB,C_IND,C_STA,TIPOINT2,CODINT2,DESCINTER,PAESE,C_RAPPORTO,CODCAB2,PROV2,DESC2,ZCPARTE,IDBASE,CODDIPE,DATARETT,ardt_storsogope,ardt_wlientiope,ardt_weneficope,ardt_werzistiope,OPERAG,NOPROT,RESPINS,INFORM,NATURA,SCOPO,AREAGEO,MODSVOL,RAGIO,TIPO,RAREA,RCOMP,RRAGIO,RTIPO,RFREQ,RIMP,DURAT,AMMONT,MITIG,MITGDOC,ardt_docopebo,CONNESDOC,MTCN"+FoundlingChildrenList("armt_storope",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_storope"),new String[][]{new String[]{"DATAOPE","Data Operazione","D","8","0","campo","key2","false","true"},new String[]{"DATAREG","Data registrazione","D","8","0","campo","nokey","false","true"},new String[]{"FLAGFRAZ","Frazionata (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"TIPOOPRAP","Tipo Operazione Completa","C","2","0","campo","nokey","false","false"},new String[]{"CODANA","Causale Analitica","C","4","0","campo","nokey","false","false"},new String[]{"CODVOC","Causale Sintetica","C","2","0","campo","nokey","false","false"},new String[]{"appolire","","C","1","0","variabile","nokey","false","false"},new String[]{"VALUTA","Divisa","C","3","0","campo","nokey","false","false"},new String[]{"xTOTLIRE","","N","15","2","variabile","nokey","false","true"},new String[]{"FLAGCONT","Contanti (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"xTOTCONT","","N","15","2","variabile","nokey","false","true"},new String[]{"CAMBIO","Cambio","N","9","4","campo","nokey","false","false"},new String[]{"RAPPORTO","Rapporto Collegato","C","25","0","campo","nokey","false","false"},new String[]{"CONNESCLI","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"CONNESOPER","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"TIPOLEG","Tipo Legame","C","1","0","campo","nokey","false","true"},new String[]{"PAGASOGOP","","C","1","0","campo","nokey","false","false"},new String[]{"CONNESBEN","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"CONNALTRO","","C","16","0","campo","nokey","false","false"},new String[]{"C_RAG","","C","70","0","campo","nokey","false","false"},new String[]{"C_CTA","","C","30","0","campo","nokey","false","false"},new String[]{"C_PRV","","C","2","0","campo","nokey","false","false"},new String[]{"C_CAP","","C","5","0","campo","nokey","false","false"},new String[]{"C_CAB","","C","6","0","campo","nokey","false","false"},new String[]{"C_IND","","C","35","0","campo","nokey","false","false"},new String[]{"C_STA","","C","3","0","campo","nokey","false","false"},new String[]{"TIPOINT2","Tipo Intermediario C/Parte","C","2","0","campo","nokey","false","false"},new String[]{"CODINT2","Codice Intermediario C/Parte","C","11","0","campo","nokey","false","false"},new String[]{"DESCINTER","","C","50","0","campo","nokey","false","false"},new String[]{"PAESE","Stato Intermediario C/Parte","C","3","0","campo","nokey","false","false"},new String[]{"C_RAPPORTO","","C","25","0","campo","nokey","false","false"},new String[]{"CODCAB2","CAB Intermediario C/Parte","C","6","0","campo","nokey","false","false"},new String[]{"PROV2","Provincia Intermediario C/Parte","C","2","0","campo","nokey","false","true"},new String[]{"DESC2","Denominazione Intermediario C/Parte","C","30","0","campo","nokey","false","false"},new String[]{"ZCPARTE","","C","69","0","campo","nokey","false","false"},new String[]{"IDBASE","Idbase","C","10","0","campo","key1","false","false"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"DATARETT","Data Rettifica","D","8","0","campo","nokey","false","false"},new String[]{"ardt_storsogope","+ Soggetti Oper. Conto Terzi","","","","link_PC","","false",""},new String[]{"ardt_wlientiope","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_weneficope","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_werzistiope","LinkPC","","","","link_PC","","false",""},new String[]{"OPERAG","","C","3","0","campo","nokey","false","false"},new String[]{"NOPROT","","N","1","0","campo","nokey","false","false"},new String[]{"RESPINS","","C","30","0","campo","nokey","false","false"},new String[]{"INFORM","","C","30","0","campo","nokey","false","false"},new String[]{"NATURA","","C","50","0","campo","nokey","false","false"},new String[]{"SCOPO","","C","50","0","campo","nokey","false","false"},new String[]{"AREAGEO","","C","5","0","campo","nokey","false","false"},new String[]{"MODSVOL","","C","5","0","campo","nokey","false","false"},new String[]{"RAGIO","","C","5","0","campo","nokey","false","false"},new String[]{"TIPO","","C","3","0","campo","nokey","false","false"},new String[]{"RAREA","","N","3","0","campo","nokey","false","false"},new String[]{"RCOMP","","N","3","0","campo","nokey","false","false"},new String[]{"RRAGIO","","N","3","0","campo","nokey","false","false"},new String[]{"RTIPO","","N","3","0","campo","nokey","false","false"},new String[]{"RFREQ","","N","3","0","campo","nokey","false","false"},new String[]{"RIMP","","N","3","0","campo","nokey","false","false"},new String[]{"DURAT","","C","5","0","campo","nokey","false","false"},new String[]{"AMMONT","","C","5","0","campo","nokey","false","false"},new String[]{"MITIG","Mitigazione (+/-)","N","4","0","campo","nokey","false","false"},new String[]{"MITGDOC","Documentazione Mitigazione","C","100","0","campo","nokey","false","false"},new String[]{"ardt_docopebo","LinkPC","","","","link_PC","","false",""},new String[]{"CONNESDOC","Storico Documenti","C","50","0","campo","nokey","false","false"},new String[]{"MTCN","MTCN","C","10","0","campo","key11","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_storopeBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_wperazbo = p_ContextObject.GetPhName("wperazbo",p_ContextObject.GetCompany(),false);
    m_cServer_wperazbo = p_ContextObject.GetServer("wperazbo");
    m_oWrInfo_wperazbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"wperazbo",p_ContextObject.GetCompany());
    m_cVirtName_wperazbo = CPSql.ManipulateTablePhName("wperazbo",m_cServer_wperazbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_oWrInfo_anarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anarapbo",p_ContextObject.GetCompany());
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_oWrInfo_inter2bo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"inter2bo",p_ContextObject.GetCompany());
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_oWrInfo_kersonbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"kersonbo",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_oWrInfo_tbareegeog = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog",p_ContextObject.GetCompany());
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_oWrInfo_tbcauana = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcauana",p_ContextObject.GetCompany());
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_oWrInfo_tbcausin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcausin",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbdurata = p_ContextObject.GetPhName("tbdurata");
    m_cServer_tbdurata = p_ContextObject.GetServer("tbdurata");
    m_oWrInfo_tbdurata = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata",p_ContextObject.GetCompany());
    m_cPhName_tbimporto = p_ContextObject.GetPhName("tbimporto");
    m_cServer_tbimporto = p_ContextObject.GetServer("tbimporto");
    m_oWrInfo_tbimporto = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto",p_ContextObject.GetCompany());
    m_cPhName_tbplauso = p_ContextObject.GetPhName("tbplauso");
    m_cServer_tbplauso = p_ContextObject.GetServer("tbplauso");
    m_oWrInfo_tbplauso = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim = p_ContextObject.GetPhName("tbsvolgim");
    m_cServer_tbsvolgim = p_ContextObject.GetServer("tbsvolgim");
    m_oWrInfo_tbsvolgim = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim",p_ContextObject.GetCompany());
    m_cPhName_tbtipint = p_ContextObject.GetPhName("tbtipint");
    m_cServer_tbtipint = p_ContextObject.GetServer("tbtipint");
    m_oWrInfo_tbtipint = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipint",p_ContextObject.GetCompany());
    m_cPhName_tbtipleg = p_ContextObject.GetPhName("tbtipleg");
    m_cServer_tbtipleg = p_ContextObject.GetServer("tbtipleg");
    m_oWrInfo_tbtipleg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipleg",p_ContextObject.GetCompany());
    m_cPhName_tbtipope = p_ContextObject.GetPhName("tbtipope");
    m_cServer_tbtipope = p_ContextObject.GetServer("tbtipope");
    m_oWrInfo_tbtipope = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipope",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_oWrInfo_tbtiporisc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc",p_ContextObject.GetCompany());
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_oWrInfo_tbtipreg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipreg",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_storsogope = new ardt_storsogopeBO(p_ContextObject);
    ardt_wlientiope = new ardt_wlientiopeBO(p_ContextObject);
    ardt_weneficope = new ardt_weneficopeBO(p_ContextObject);
    ardt_werzistiope = new ardt_werzistiopeBO(p_ContextObject);
    ardt_docopebo = new ardt_docopeboBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_storope",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_DATAOPE = CPLib.NullDate();
    w_COLLEG = "";
    w_TIPOOPRAP = "";
    w_CODANA = "";
    w_CODVOC = "";
    w_VALUTA = "";
    w_xTOTLIRE = 0;
    w_xTOTCONT = 0;
    w_CAMBIO = 0;
    w_RAPPORTO = "";
    w_CONNESCLI = "";
    w_CONNESOPER = "";
    w_CONNESBEN = "";
    w_CONNALTRO = "";
    w_C_RAG = "";
    w_C_CTA = "";
    w_C_PRV = "";
    w_C_CAP = "";
    w_C_CAB = "";
    w_C_IND = "";
    w_C_STA = "";
    w_TIPOINT2 = "";
    w_CODINT2 = "";
    w_DESCINTER = "";
    w_PAESE = "";
    w_C_RAPPORTO = "";
    w_CODCAB2 = "";
    w_PROV2 = "";
    w_DESC2 = "";
    w_ZCPARTE = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_CODDIPE = "";
    w_DESCCIT = "";
    w_SEGNO = "";
    w_DATARETT = CPLib.NullDate();
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_DESCINTER = "";
    w_FLAGRAP = "";
    w_OPERAZMOD = "";
    w_RAPPORTBEN = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_xdes1 = "";
    w_desccauana = "";
    w_xdesccausin = "";
    w_descdiv = "";
    w_xragsocper = "";
    w_xdescrap = "";
    w_xragsocct = "";
    w_xragsocben = "";
    w_xdestipleg = "";
    w_xragint2 = "";
    w_xdescpaese2 = "";
    w_datpaseuro = CPLib.NullDate();
    w_xDescDipe = "";
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_errmsg = "";
    w_test = "";
    w_FLAGRAP2 = "";
    w_valflg2 = "";
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_xcodfisc = "";
    w_PRGIMPOPE = 0;
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_CONNESDOC = "";
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_dessta = "";
    w_xragsocalt = "";
    w_CODVOC = "";
    w_xdciticon = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_DATAVALI = CPLib.NullDate();
    w_DATARILASC = CPLib.NullDate();
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_xdescopeage = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_OPERAG = "";
    w_RESPINS = "";
    w_INFORM = "";
    w_NATURA = "";
    w_SCOPO = "";
    w_AREAGEO = "";
    w_MODSVOL = "";
    w_RAGIO = "";
    w_TIPO = "";
    w_RAREA = 0;
    w_RCOMP = 0;
    w_RRAGIO = 0;
    w_RTIPO = 0;
    w_RFREQ = 0;
    w_RIMP = 0;
    w_DURAT = "";
    w_AMMONT = "";
    w_IPCOLLEG = "";
    w_ORACOLLEG = CPLib.NullDateTime();
    w_DUCOLLEG = 0;
    w_MITIG = 0;
    w_MITGDOC = "";
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
    w_IDFILE = "";
    w_MTCN = "";
    w_CDATOPE = "";
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    w_filtro = "";
    w_filtro = "O";
    w_DATAREG = CPLib.Date();
    w_FLAGFRAZ = "0";
    Link_SQVJLYRFKQ();
    Link_SRWWPHPCUB();
    w_FLAGLIRE = "";
    w_FLAGLIRE = arfn_calcflaglireR.Make(m_Ctx,this).Run(w_DATAOPE,w_appolire,w_datpaseuro);
    w_appolire = "";
    w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
    Link_MKCXJZEKIG();
    w_FLAGCONT = "0";
    Link_RZIQZFKPUE();
    Link_QBLXDBODXR();
    Link_TCOTJNZLGM();
    w_TIPOLEG = "0";
    w_PAGASOGOP = "N";
    Link_ULVCBLFVEU();
    Link_HWFHDWYMIU();
    Link_ODAYKSRECA();
    Link_YVIKEGPYPM();
    Link_CDJFSCCGNX();
    Link_NYRJHOZOON();
    Link_YQINIDXZSL();
    w_CODINTER = "";
    w_CODINTER = w_gIntemediario;
    Link_WJSVGWKSFC();
    Link_AVHTGZTOSZ();
    w_STATOREG = "";
    w_STATOREG = "0";
    w_tipope = "";
    w_tipope = "1";
    w_TIPOINF = "";
    w_TIPOINF = "1";
    w_IDEREG = "";
    w_IDEREG = CPLib.DateToChar(w_DATAOPE)+w_NUMPROG+LibreriaMit.StatoReg("OPERAZBO",w_STATOREG);
    w_OPRAP = "";
    w_OPRAP = "1";
    w_sEdit = 0;
    w_dataoggi = CPLib.NullDate();
    w_dataoggi = CPLib.Date();
    w_stringaflagrap2 = "ABCDEFGHI";
    w_CDATAOPE = "";
    w_CDATAOPE = CPLib.DateToChar(w_DATAOPE);
    Link_LKEDJRUQJU();
    w_CDATREG = "";
    w_CDATREG = CPLib.DateToChar(w_DATAREG);
    w_apporeg = "";
    w_apporeg = CPLib.DateToChar(w_DATAREG);
    w_ANNOOPE = 0;
    w_ANNOOPE = CPLib.Year(w_DATAOPE);
    w_STATOREG = "";
    w_STATOREG = "0";
    Link_QEFXECTWSF();
    w_NOPROT = 0;
    Link_QJSTZIPOQB();
    Link_SFFFOYOWNH();
    Link_NOBMPHKVTX();
    Link_DJOWYRMDDC();
    Link_CKJQULDXKW();
    Link_SXTYCPHBIM();
    Link_WNMMMNSARU();
    m_cWv_ardt_storsogope = "";
    m_cWv_ardt_wlientiope = "";
    m_cWv_ardt_weneficope = "";
    m_cWv_ardt_werzistiope = "";
    m_cWv_ardt_docopebo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_storsogope.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_storsogope);
    l_bResult = l_bResult || ardt_wlientiope.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_wlientiope);
    l_bResult = l_bResult || ardt_weneficope.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_weneficope);
    l_bResult = l_bResult || ardt_werzistiope.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_werzistiope);
    l_bResult = l_bResult || ardt_docopebo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_docopebo);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_DATAOPE = w_DATAOPE;
    o_CDATOPE = w_CDATOPE;
    o_filtro = w_filtro;
    o_DATAREG = w_DATAREG;
    o_CODVOC = w_CODVOC;
    o_FLAGLIRE = w_FLAGLIRE;
    o_appolire = w_appolire;
    o_FLAGCONT = w_FLAGCONT;
    o_CONNESBEN = w_CONNESBEN;
    o_C_CTA = w_C_CTA;
    o_CODINT2 = w_CODINT2;
    o_CODINTER = w_CODINTER;
    o_CODDIPE = w_CODDIPE;
    ardt_storsogope.SaveDependsOn();
    ardt_wlientiope.SaveDependsOn();
    ardt_weneficope.SaveDependsOn();
    ardt_werzistiope.SaveDependsOn();
    ardt_docopebo.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_KCAZOZICOY();
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Load")) {
      Calculation_NAKGPBRIRV();
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_USKTDKFUXZ();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_KCAZOZICOY();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_SQVJLYRFKQ() {
    return Link_SQVJLYRFKQ("Full");
  }
  protected boolean Link_SQVJLYRFKQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODANA))) {
      String l_OldValue = w_CODANA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODANA,"C",4,0),m_cServer_tbcauana,w_CODANA);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODCAU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODANA = l_rsLink.GetString("CODCAU");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SQVJLYRFKQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODANA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODANA");
          }
          m_cLastWorkVarError = "CODANA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SQVJLYRFKQ_blank();
    }
    return l_bResult;
  }
  void Link_SQVJLYRFKQ_blank() {
    w_CODANA = "";
  }
  protected boolean Link_SRWWPHPCUB() {
    return Link_SRWWPHPCUB("Full");
  }
  protected boolean Link_SRWWPHPCUB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODVOC))) {
      String l_OldValue = w_CODVOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODVOC,"C",2,0),m_cServer_tbcauana,w_CODVOC);
      l_cWhere = l_cWhere+" and CODCAU = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODANA,"C",4,0),m_cServer_tbcauana,w_CODANA);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU,CAUSINT,SEGNO,DESCRI from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CAUSINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODVOC = l_rsLink.GetString("CAUSINT");
          w_SEGNO = l_rsLink.GetString("SEGNO");
          w_desccauana = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SRWWPHPCUB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODVOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODVOC");
          }
          m_cLastWorkVarError = "CODVOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SRWWPHPCUB_blank();
    }
    return l_bResult;
  }
  void Link_SRWWPHPCUB_blank() {
    w_CODVOC = "";
    w_SEGNO = "";
    w_desccauana = "";
  }
  protected boolean Link_MKCXJZEKIG() {
    return Link_MKCXJZEKIG("Full");
  }
  protected boolean Link_MKCXJZEKIG(String p_cType) {
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
          w_descdiv = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MKCXJZEKIG_blank();
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
      Link_MKCXJZEKIG_blank();
    }
    return l_bResult;
  }
  void Link_MKCXJZEKIG_blank() {
    w_VALUTA = "";
    w_descdiv = "";
  }
  protected boolean Link_RZIQZFKPUE() {
    return Link_RZIQZFKPUE("Full");
  }
  protected boolean Link_RZIQZFKPUE(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAPPORTO))) {
      String l_OldValue = w_RAPPORTO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_anarapbo,w_RAPPORTO);
      if (m_Ctx.IsSharedTemp("anarapbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anarapbo,"select RAPPORTO,DESCRAP,TIPORAP from "+m_cPhName_anarapbo+((m_cPhName_anarapbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAPPORTO"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",50,0),m_cServer_anarapbo,w_RAPPORTO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anarapbo,"select RAPPORTO,DESCRAP,TIPORAP from "+m_cPhName_anarapbo+((m_cPhName_anarapbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRAP"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAPPORTO = l_rsLink.GetString("RAPPORTO");
          w_xdescrap = l_rsLink.GetString("DESCRAP");
          w_FLAGRAP = l_rsLink.GetString("TIPORAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RZIQZFKPUE_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAPPORTO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAPPORTO");
          }
          m_cLastWorkVarError = "RAPPORTO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RZIQZFKPUE_blank();
    }
    return l_bResult;
  }
  void Link_RZIQZFKPUE_blank() {
    w_RAPPORTO = "";
    w_xdescrap = "";
    w_FLAGRAP = "";
  }
  protected boolean Link_QBLXDBODXR() {
    return Link_QBLXDBODXR("Full");
  }
  protected boolean Link_QBLXDBODXR(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"C",16,0),m_cServer_personbo,w_CONNESCLI);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CODFISC,DATAVALI,DATARILASC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"C",70,0),m_cServer_personbo,w_CONNESCLI);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CODFISC,DATAVALI,DATARILASC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESCLI = l_rsLink.GetString("CONNES");
          w_xragsocper = l_rsLink.GetString("RAGSOC");
          w_xcodfisc = l_rsLink.GetString("CODFISC");
          w_DATAVALI = l_rsLink.GetDate("DATAVALI");
          w_DATARILASC = l_rsLink.GetDate("DATARILASC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QBLXDBODXR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESCLI = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNESCLI,w_DATAOPE);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESCLI");
              }
              m_cLastWorkVarError = "CONNESCLI";
              w_CONNESCLI = "";
              Link_QBLXDBODXR_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESCLI");
              }
              m_cLastWorkVarError = "CONNESCLI";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QBLXDBODXR_blank();
    }
    return l_bResult;
  }
  void Link_QBLXDBODXR_blank() {
    w_CONNESCLI = "";
    w_xragsocper = "";
    w_xcodfisc = "";
    w_DATAVALI = CPLib.NullDate();
    w_DATARILASC = CPLib.NullDate();
  }
  protected boolean Link_TCOTJNZLGM() {
    return Link_TCOTJNZLGM("Full");
  }
  protected boolean Link_TCOTJNZLGM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESOPER))) {
      String l_OldValue = w_CONNESOPER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESOPER,"C",16,0),m_cServer_personbo,w_CONNESOPER);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESOPER,"C",70,0),m_cServer_personbo,w_CONNESOPER);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESOPER = l_rsLink.GetString("CONNES");
          w_xragsocct = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_TCOTJNZLGM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESOPER = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNESOPER,w_DATAOPE);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESOPER");
              }
              m_cLastWorkVarError = "CONNESOPER";
              w_CONNESOPER = "";
              Link_TCOTJNZLGM_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESOPER");
              }
              m_cLastWorkVarError = "CONNESOPER";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_TCOTJNZLGM_blank();
    }
    return l_bResult;
  }
  void Link_TCOTJNZLGM_blank() {
    w_CONNESOPER = "";
    w_xragsocct = "";
  }
  protected boolean Link_ULVCBLFVEU() {
    return Link_ULVCBLFVEU("Full");
  }
  protected boolean Link_ULVCBLFVEU(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"C",16,0),m_cServer_personbo,w_CONNESBEN);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"C",70,0),m_cServer_personbo,w_CONNESBEN);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESBEN = l_rsLink.GetString("CONNES");
          w_xragsocben = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ULVCBLFVEU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESBEN = l_OldValue;
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
      Link_ULVCBLFVEU_blank();
    }
    return l_bResult;
  }
  void Link_ULVCBLFVEU_blank() {
    w_CONNESBEN = "";
    w_xragsocben = "";
  }
  protected boolean Link_HWFHDWYMIU() {
    return Link_HWFHDWYMIU("Full");
  }
  protected boolean Link_HWFHDWYMIU(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNALTRO,"C",16,0),m_cServer_personbo,w_CONNALTRO);
      if (m_Ctx.IsSharedTemp("personbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNALTRO,"C",70,0),m_cServer_personbo,w_CONNALTRO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNALTRO = l_rsLink.GetString("CONNES");
          w_xragsocalt = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HWFHDWYMIU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNALTRO = l_OldValue;
          }
        }
        // Check dopo il link da esguire solo se non siamo in fase di load del BO
        if (CPLib.ne(p_cType,"Load")) {
          if (l_bResult) {
            l_bResult = arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNALTRO,w_DATAOPE);
            if ( ! (l_bResult)) {
              // Se il check è fallito vengono caricati i valori di blank nelle variabili
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNALTRO");
              }
              m_cLastWorkVarError = "CONNALTRO";
              w_CONNALTRO = "";
              Link_HWFHDWYMIU_blank();
            }
          } else {
            if ( ! (l_bResult)) {
              m_nLastError = 3;
              m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
              if (CPLib.eq(m_cLastMsgError,"")) {
                m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNALTRO");
              }
              m_cLastWorkVarError = "CONNALTRO";
            }
          }
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_HWFHDWYMIU_blank();
    }
    return l_bResult;
  }
  void Link_HWFHDWYMIU_blank() {
    w_CONNALTRO = "";
    w_xragsocalt = "";
  }
  protected boolean Link_ODAYKSRECA() {
    return Link_ODAYKSRECA("Full");
  }
  protected boolean Link_ODAYKSRECA(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_C_CTA))) {
      String l_OldValue = w_C_CTA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_C_CTA,"C",30,0),m_cServer_tbcitta,w_C_CTA);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAB,PROV,PKTBSTATI,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_C_CTA,"C",6,0),m_cServer_tbcitta,w_C_CTA);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAB,PROV,PKTBSTATI,CAP from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CAB"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_C_CTA = l_rsLink.GetString("CITTA");
          w_C_CAB = l_rsLink.GetString("CAB");
          w_C_PRV = l_rsLink.GetString("PROV");
          w_C_STA = l_rsLink.GetString("PKTBSTATI");
          w_C_CAP = l_rsLink.GetString("CAP");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_ODAYKSRECA_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","C_CTA");
          }
          m_cLastWorkVarError = "C_CTA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ODAYKSRECA_blank();
    }
    return l_bResult;
  }
  void Link_ODAYKSRECA_blank() {
    Link_ODAYKSRECA_blank("");
  }
  void Link_ODAYKSRECA_blank(String p_cType) {
    w_C_CAB = "";
    w_C_PRV = "";
    w_C_STA = "";
    w_C_CAP = "";
  }
  protected boolean Link_YVIKEGPYPM() {
    return Link_YVIKEGPYPM("Full");
  }
  protected boolean Link_YVIKEGPYPM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_C_STA))) {
      String l_OldValue = w_C_STA;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_C_STA,"C",3,0),m_cServer_tbstati,w_C_STA);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_C_STA,"C",40,0),m_cServer_tbstati,w_C_STA);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_C_STA = l_rsLink.GetString("CODSTA");
          w_dessta = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_YVIKEGPYPM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_C_STA = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","C_STA");
          }
          m_cLastWorkVarError = "C_STA";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_YVIKEGPYPM_blank();
    }
    return l_bResult;
  }
  void Link_YVIKEGPYPM_blank() {
    w_C_STA = "";
    w_dessta = "";
  }
  protected boolean Link_CDJFSCCGNX() {
    return Link_CDJFSCCGNX("Full");
  }
  protected boolean Link_CDJFSCCGNX(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODINT2))) {
      String l_OldValue = w_CODINT2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINT2,"C",11,0),m_cServer_inter2bo,w_CODINT2);
      if (m_Ctx.IsSharedTemp("inter2bo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_inter2bo,"select CODINTER,RAGSOC,CODCAB,PROVINCIA,PAESE,TIPINTER from "+m_cPhName_inter2bo+((m_cPhName_inter2bo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINT2,"C",50,0),m_cServer_inter2bo,w_CODINT2);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_inter2bo,"select CODINTER,RAGSOC,CODCAB,PROVINCIA,PAESE,TIPINTER from "+m_cPhName_inter2bo+((m_cPhName_inter2bo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODINT2 = l_rsLink.GetString("CODINTER");
          w_DESCINTER = l_rsLink.GetString("RAGSOC");
          w_CODCAB2 = l_rsLink.GetString("CODCAB");
          w_PROV2 = l_rsLink.GetString("PROVINCIA");
          w_PAESE = l_rsLink.GetString("PAESE");
          w_TIPOINT2 = l_rsLink.GetString("TIPINTER");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_CDJFSCCGNX_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINT2");
          }
          m_cLastWorkVarError = "CODINT2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CDJFSCCGNX_blank();
    }
    return l_bResult;
  }
  void Link_CDJFSCCGNX_blank() {
    Link_CDJFSCCGNX_blank("");
  }
  void Link_CDJFSCCGNX_blank(String p_cType) {
    w_DESCINTER = "";
    w_CODCAB2 = "";
    w_PROV2 = "";
    w_PAESE = "";
    w_TIPOINT2 = "";
  }
  protected boolean Link_NYRJHOZOON() {
    return Link_NYRJHOZOON("Full");
  }
  protected boolean Link_NYRJHOZOON(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_PAESE))) {
      String l_OldValue = w_PAESE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",3,0),m_cServer_tbstati,w_PAESE);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODSTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PAESE,"C",30,0),m_cServer_tbstati,w_PAESE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstati,"select CODSTA,DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_PAESE = l_rsLink.GetString("CODSTA");
          w_xdescpaese2 = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NYRJHOZOON_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_PAESE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","PAESE");
          }
          m_cLastWorkVarError = "PAESE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NYRJHOZOON_blank();
    }
    return l_bResult;
  }
  void Link_NYRJHOZOON_blank() {
    w_PAESE = "";
    w_xdescpaese2 = "";
  }
  protected boolean Link_YQINIDXZSL() {
    return Link_YQINIDXZSL("Full");
  }
  protected boolean Link_YQINIDXZSL(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODCAB2))) {
      String l_OldValue = w_CODCAB2;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODCAB2,"C",6,0),m_cServer_tbcitta,w_CODCAB2);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CAB,CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CAB"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODCAB2,"C",30,0),m_cServer_tbcitta,w_CODCAB2);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CAB,CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODCAB2 = l_rsLink.GetString("CAB");
          w_DESC2 = l_rsLink.GetString("CITTA");
          w_PROV2 = l_rsLink.GetString("PROV");
          w_xdciticon = l_rsLink.GetString("CITTA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_YQINIDXZSL_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODCAB2");
          }
          m_cLastWorkVarError = "CODCAB2";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_YQINIDXZSL_blank();
    }
    return l_bResult;
  }
  void Link_YQINIDXZSL_blank() {
    Link_YQINIDXZSL_blank("");
  }
  void Link_YQINIDXZSL_blank(String p_cType) {
    w_DESC2 = "";
    w_PROV2 = "";
    w_xdciticon = "";
  }
  protected boolean Link_WJSVGWKSFC() {
    return Link_WJSVGWKSFC("Full");
  }
  protected boolean Link_WJSVGWKSFC(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",11,0),m_cServer_intermbo,w_CODINTER);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_intermbo,"select CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT from "+m_cPhName_intermbo+((m_cPhName_intermbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODINTER"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODINTER = l_rsLink.GetString("CODINTER");
          w_datpaseuro = l_rsLink.GetDate("DATANASC");
          w_CABINT = l_rsLink.GetString("CODCAB");
          w_PROVINT = l_rsLink.GetString("PROVINCIA");
          w_CITINT = l_rsLink.GetString("DESCCIT");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_WJSVGWKSFC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODINTER = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODINTER");
          }
          m_cLastWorkVarError = "CODINTER";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_WJSVGWKSFC_blank();
    }
    return l_bResult;
  }
  void Link_WJSVGWKSFC_blank() {
    w_CODINTER = "";
    w_datpaseuro = CPLib.NullDate();
    w_CABINT = "";
    w_PROVINT = "";
    w_CITINT = "";
  }
  protected boolean Link_AVHTGZTOSZ() {
    return Link_AVHTGZTOSZ("Full");
  }
  protected boolean Link_AVHTGZTOSZ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODDIPE))) {
      String l_OldValue = w_CODDIPE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",6,0),m_cServer_anadip,w_CODDIPE);
      if (m_Ctx.IsSharedTemp("anadip")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",30,0),m_cServer_anadip,w_CODDIPE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODDIPE = l_rsLink.GetString("CODDIP");
          w_xDescDipe = l_rsLink.GetString("DESCRIZ");
          w_CITDIP = l_rsLink.GetString("DESCCIT");
          w_PROVDIP = l_rsLink.GetString("PROVINCIA");
          w_CABDIP = l_rsLink.GetString("CAB");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AVHTGZTOSZ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODDIPE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODDIPE");
          }
          m_cLastWorkVarError = "CODDIPE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AVHTGZTOSZ_blank();
    }
    return l_bResult;
  }
  void Link_AVHTGZTOSZ_blank() {
    w_CODDIPE = "";
    w_xDescDipe = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
  }
  protected boolean Link_LKEDJRUQJU() {
    return Link_LKEDJRUQJU("Full");
  }
  protected boolean Link_LKEDJRUQJU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODVOC))) {
      String l_OldValue = w_CODVOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODVOC,"C",2,0),m_cServer_tbcausin,w_CODVOC);
      if (m_Ctx.IsSharedTemp("tbcausin")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcausin,"select CODVOC,DESCRIZ from "+m_cPhName_tbcausin+((m_cPhName_tbcausin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODVOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODVOC = l_rsLink.GetString("CODVOC");
          w_xdesccausin = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LKEDJRUQJU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODVOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODVOC");
          }
          m_cLastWorkVarError = "CODVOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LKEDJRUQJU_blank();
    }
    return l_bResult;
  }
  void Link_LKEDJRUQJU_blank() {
    w_CODVOC = "";
    w_xdesccausin = "";
  }
  protected boolean Link_QEFXECTWSF() {
    return Link_QEFXECTWSF("Full");
  }
  protected boolean Link_QEFXECTWSF(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_OPERAG))) {
      String l_OldValue = w_OPERAG;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_OPERAG,"C",3,0),m_cServer_tbtipope,w_OPERAG);
      if (m_Ctx.IsSharedTemp("tbtipope")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipope,"select CODICE,DESCRI from "+m_cPhName_tbtipope+((m_cPhName_tbtipope).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_OPERAG,"C",254,0),m_cServer_tbtipope,w_OPERAG);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtipope,"select CODICE,DESCRI from "+m_cPhName_tbtipope+((m_cPhName_tbtipope).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_OPERAG = l_rsLink.GetString("CODICE");
          w_xdescopeage = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QEFXECTWSF_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_OPERAG = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","OPERAG");
          }
          m_cLastWorkVarError = "OPERAG";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QEFXECTWSF_blank();
    }
    return l_bResult;
  }
  void Link_QEFXECTWSF_blank() {
    w_OPERAG = "";
    w_xdescopeage = "";
  }
  protected boolean Link_QJSTZIPOQB() {
    return Link_QJSTZIPOQB("Full");
  }
  protected boolean Link_QJSTZIPOQB(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AREAGEO))) {
      String l_OldValue = w_AREAGEO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",5,0),m_cServer_tbareegeog,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",50,0),m_cServer_tbareegeog,w_AREAGEO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_xdescareag = l_rsLink.GetString("DESCRI");
          w_RAREA = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_QJSTZIPOQB_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AREAGEO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AREAGEO");
          }
          m_cLastWorkVarError = "AREAGEO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_QJSTZIPOQB_blank();
    }
    return l_bResult;
  }
  void Link_QJSTZIPOQB_blank() {
    w_AREAGEO = "";
    w_xdescareag = "";
    w_RAREA = 0;
  }
  protected boolean Link_SFFFOYOWNH() {
    return Link_SFFFOYOWNH("Full");
  }
  protected boolean Link_SFFFOYOWNH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MODSVOL))) {
      String l_OldValue = w_MODSVOL;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",5,0),m_cServer_tbsvolgim,w_MODSVOL);
      if (m_Ctx.IsSharedTemp("tbsvolgim")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",200,0),m_cServer_tbsvolgim,w_MODSVOL);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MODSVOL = l_rsLink.GetString("CODICE");
          w_xdescmodsvo = l_rsLink.GetString("DESCRI");
          w_RCOMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SFFFOYOWNH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MODSVOL = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MODSVOL");
          }
          m_cLastWorkVarError = "MODSVOL";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SFFFOYOWNH_blank();
    }
    return l_bResult;
  }
  void Link_SFFFOYOWNH_blank() {
    w_MODSVOL = "";
    w_xdescmodsvo = "";
    w_RCOMP = 0;
  }
  protected boolean Link_NOBMPHKVTX() {
    return Link_NOBMPHKVTX("Full");
  }
  protected boolean Link_NOBMPHKVTX(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAGIO))) {
      String l_OldValue = w_RAGIO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",5,0),m_cServer_tbplauso,w_RAGIO);
      if (m_Ctx.IsSharedTemp("tbplauso")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",200,0),m_cServer_tbplauso,w_RAGIO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAGIO = l_rsLink.GetString("CODICE");
          w_xdescplauso = l_rsLink.GetString("DESCRI");
          w_RRAGIO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_NOBMPHKVTX_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAGIO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAGIO");
          }
          m_cLastWorkVarError = "RAGIO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_NOBMPHKVTX_blank();
    }
    return l_bResult;
  }
  void Link_NOBMPHKVTX_blank() {
    w_RAGIO = "";
    w_xdescplauso = "";
    w_RRAGIO = 0;
  }
  protected boolean Link_DJOWYRMDDC() {
    return Link_DJOWYRMDDC("Full");
  }
  protected boolean Link_DJOWYRMDDC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPO))) {
      String l_OldValue = w_TIPO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",3,0),m_cServer_tbtiporisc,w_TIPO);
      if (m_Ctx.IsSharedTemp("tbtiporisc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",100,0),m_cServer_tbtiporisc,w_TIPO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPO = l_rsLink.GetString("CODICE");
          w_xdesctipor = l_rsLink.GetString("DESCRI");
          w_RTIPO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DJOWYRMDDC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPO");
          }
          m_cLastWorkVarError = "TIPO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DJOWYRMDDC_blank();
    }
    return l_bResult;
  }
  void Link_DJOWYRMDDC_blank() {
    w_TIPO = "";
    w_xdesctipor = "";
    w_RTIPO = 0;
  }
  protected boolean Link_CKJQULDXKW() {
    return Link_CKJQULDXKW("Full");
  }
  protected boolean Link_CKJQULDXKW(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DURAT))) {
      String l_OldValue = w_DURAT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",5,0),m_cServer_tbdurata,w_DURAT);
      if (m_Ctx.IsSharedTemp("tbdurata")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",200,0),m_cServer_tbdurata,w_DURAT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DURAT = l_rsLink.GetString("CODICE");
          w_xdescfreq = l_rsLink.GetString("DESCRI");
          w_RFREQ = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_CKJQULDXKW_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_DURAT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DURAT");
          }
          m_cLastWorkVarError = "DURAT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CKJQULDXKW_blank();
    }
    return l_bResult;
  }
  void Link_CKJQULDXKW_blank() {
    w_DURAT = "";
    w_xdescfreq = "";
    w_RFREQ = 0;
  }
  protected boolean Link_SXTYCPHBIM() {
    return Link_SXTYCPHBIM("Full");
  }
  protected boolean Link_SXTYCPHBIM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_AMMONT))) {
      String l_OldValue = w_AMMONT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",5,0),m_cServer_tbimporto,w_AMMONT);
      if (m_Ctx.IsSharedTemp("tbimporto")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",200,0),m_cServer_tbimporto,w_AMMONT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI,RISCHIO from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AMMONT = l_rsLink.GetString("CODICE");
          w_xdescammo = l_rsLink.GetString("DESCRI");
          w_RIMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SXTYCPHBIM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_AMMONT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","AMMONT");
          }
          m_cLastWorkVarError = "AMMONT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SXTYCPHBIM_blank();
    }
    return l_bResult;
  }
  void Link_SXTYCPHBIM_blank() {
    w_AMMONT = "";
    w_xdescammo = "";
    w_RIMP = 0;
  }
  protected boolean Link_WNMMMNSARU() {
    return Link_WNMMMNSARU("Full");
  }
  protected boolean Link_WNMMMNSARU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CONNESDOC))) {
      String l_OldValue = w_CONNESDOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESDOC,"C",50,0),m_cServer_kersonbo,w_CONNESDOC);
      if (m_Ctx.IsSharedTemp("kersonbo")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_kersonbo,"select CONNES,RAGSOC from "+m_cPhName_kersonbo+((m_cPhName_kersonbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESDOC,"C",70,0),m_cServer_kersonbo,w_CONNESDOC);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_kersonbo,"select CONNES,RAGSOC from "+m_cPhName_kersonbo+((m_cPhName_kersonbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESDOC = l_rsLink.GetString("CONNES");
          w_xRAGSOCDOC = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_WNMMMNSARU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNESDOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESDOC");
          }
          m_cLastWorkVarError = "CONNESDOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_WNMMMNSARU_blank();
    }
    return l_bResult;
  }
  void Link_WNMMMNSARU_blank() {
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_DATAOPE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAOPE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = CPLib.ge(w_DATAREG,w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di registrazione deve essere maggiore o uguale a quella dell'operazione";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAOPE = CPLib.NullDate();
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public java.sql.Date getDefault_DATAOPE() {
    // Gestione del default
    return CPLib.Date();
  }
  public boolean Set_DATAREG(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAREG = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = CPLib.ge(w_DATAREG,w_DATAOPE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "La data di registrazione deve essere maggiore o uguale a quella dell'operazione";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DATAREG = CPLib.NullDate();
    }
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
  public boolean Set_TIPOOPRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOOPRAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODANA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODANA = p_workVariableValue;
    l_bResult = Link_SQVJLYRFKQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (CPLib.Empty(w_CODVOC))) {
      l_bTmpRes = Link_SRWWPHPCUB();
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODANA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODVOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODVOC = p_workVariableValue;
    l_bResult = Link_SRWWPHPCUB();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODVOC = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODVOC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_appolire(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_appolire = p_workVariableValue;
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
    l_bResult = Link_MKCXJZEKIG();
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
  public boolean Set_xTOTLIRE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_xTOTLIRE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_xTOTLIRE = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLAGCONT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGCONT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_xTOTCONT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_xTOTCONT = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    // 
    l_bResult = arfn_chktotalelire_contR.Make(m_Ctx,this).Run(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_xTOTCONT = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAMBIO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAMBIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAPPORTO = p_workVariableValue;
    l_bResult = Link_RZIQZFKPUE();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAPPORTO = "";
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
    l_bResult = Link_QBLXDBODXR();
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
  public boolean Set_CONNESOPER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESOPER = p_workVariableValue;
    l_bResult = Link_TCOTJNZLGM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESOPER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOLEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOLEG = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOLEG = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PAGASOGOP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PAGASOGOP = p_workVariableValue;
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
    l_bResult = Link_ULVCBLFVEU();
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
    l_bResult = Link_HWFHDWYMIU();
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
  public boolean Set_C_RAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_RAG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_CTA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_CTA = p_workVariableValue;
    l_bResult = Link_ODAYKSRECA();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_C_CTA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_PRV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_PRV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_CAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_CAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_CAB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_CAB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_IND(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_IND = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_STA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_STA = p_workVariableValue;
    l_bResult = Link_YVIKEGPYPM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_C_STA = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOINT2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOINT2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODINT2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODINT2 = p_workVariableValue;
    l_bResult = Link_CDJFSCCGNX();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODINT2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCINTER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCINTER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PAESE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PAESE = p_workVariableValue;
    l_bResult = Link_NYRJHOZOON();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PAESE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_C_RAPPORTO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_C_RAPPORTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODCAB2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODCAB2 = p_workVariableValue;
    l_bResult = Link_YQINIDXZSL();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODCAB2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROV2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROV2 = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PROV2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean ACAPFGYRVI_isObligatory() {
    // Condizione di obbligatorietà
    return  ! (CPLib.Empty(w_CODINT2));
  }
  public boolean Set_DESC2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESC2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ZCPARTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ZCPARTE = p_workVariableValue;
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
    l_bResult = Link_AVHTGZTOSZ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODDIPE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARETT(java.sql.Date p_workVariableValue) {
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
  public boolean Set_OPERAG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_OPERAG = p_workVariableValue;
    l_bResult = Link_QEFXECTWSF();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_OPERAG = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOPROT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOPROT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RESPINS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RESPINS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_INFORM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_INFORM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NATURA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NATURA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SCOPO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SCOPO = p_workVariableValue;
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
    l_bResult = Link_QJSTZIPOQB();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
    }
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
    l_bResult = Link_SFFFOYOWNH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MODSVOL = "";
    }
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
    l_bResult = Link_NOBMPHKVTX();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAGIO = "";
    }
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
    l_bResult = Link_DJOWYRMDDC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPO = "";
    }
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
  public boolean Set_DURAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DURAT = p_workVariableValue;
    l_bResult = Link_CKJQULDXKW();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DURAT = "";
    }
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
    l_bResult = Link_SXTYCPHBIM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AMMONT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MITIG(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MITIG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MITGDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MITGDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CONNESDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CONNESDOC = p_workVariableValue;
    l_bResult = Link_WNMMMNSARU();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESDOC = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESDOC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MTCN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MTCN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_DATAREG() {
    return CPLib.ne(w_gChkDate,"U") && CPLib.ne(w_gChkDate,"B") && CPLib.eq(w_gFlgDTP,0);
  }
  public boolean getWritable_xTOTCONT() {
    return CPLib.eq(w_FLAGCONT,"1");
  }
  public boolean getWritable_PAGASOGOP() {
    return  ! (CPLib.Empty(CPLib.LRTrim(w_CONNESOPER)));
  }
  public boolean getWritable_DATARETT() {
    return false;
  }
  public boolean getVisible_COLLEG() {
    return CPLib.Empty(w_COLLEG);
  }
  public boolean getVisible_IDBASE() {
    return CPLib.eq(1,1);
  }
  public boolean getVisible_DATARETT() {
    return CPLib.eq(w_STATOREG,"0");
  }
  public boolean getVisible_MTCN() {
    return CPLib.ne(w_gFlgWU,"S");
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
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    w_filtro = "O";
    w_FLAGLIRE = arfn_calcflaglireR.Make(m_Ctx,this).Run(w_DATAOPE,w_appolire,w_datpaseuro);
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE)) {
      w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
    }
    if (CPLib.ne(o_C_CTA,w_C_CTA)) {
      l_bTmpRes = Link_YVIKEGPYPM();
    }
    if (CPLib.ne(o_CODINT2,w_CODINT2)) {
      l_bTmpRes = Link_NYRJHOZOON();
    }
    if (CPLib.ne(o_CODINT2,w_CODINT2)) {
      l_bTmpRes = Link_YQINIDXZSL();
    }
    w_CODINTER = w_gIntemediario;
    l_bTmpRes = Link_WJSVGWKSFC();
    w_STATOREG = "0";
    w_tipope = "1";
    w_TIPOINF = "1";
    w_IDEREG = CPLib.DateToChar(w_DATAOPE)+w_NUMPROG+LibreriaMit.StatoReg("OPERAZBO",w_STATOREG);
    w_OPRAP = "1";
    if (CPLib.ne(o_FLAGCONT,w_FLAGCONT)) {
      Calculation_EBRTUDXQTQ();
    }
    w_dataoggi = CPLib.Date();
    w_CDATAOPE = CPLib.DateToChar(w_DATAOPE);
    if (CPLib.ne(o_CODINTER,w_CODINTER) || CPLib.ne(o_CODDIPE,w_CODDIPE)) {
      Calculation_WKUMXNRIRT();
    }
    if (CPLib.ne(o_CODVOC,w_CODVOC)) {
      l_bTmpRes = Link_LKEDJRUQJU();
    }
    w_CDATREG = CPLib.DateToChar(w_DATAREG);
    if (CPLib.ne(o_CONNESBEN,w_CONNESBEN)) {
      Calculation_LNKPNNFRDI();
    }
    if (CPLib.ne(o_DATAREG,w_DATAREG)) {
      w_apporeg = CPLib.DateToChar(w_DATAREG);
    }
    w_ANNOOPE = CPLib.Year(w_DATAOPE);
    w_STATOREG = "0";
    if (CPLib.ne(o_appolire,w_appolire)) {
      Calculation_TBLTXFHXJY();
    }
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
  void Calculation_KCAZOZICOY() {
    w_TOTLIRE = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_xTOTLIRE*100:w_xTOTLIRE);
    w_TOTCONT = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_xTOTCONT*100:w_xTOTCONT);
  }
  void Calculation_NAKGPBRIRV() {
    w_xTOTLIRE = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_TOTLIRE/100:w_TOTLIRE);
    w_xTOTCONT = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_TOTCONT/100:w_TOTCONT);
  }
  void Calculation_EBRTUDXQTQ() {
    w_xTOTCONT = (CPLib.eq(w_FLAGCONT,"1")?w_xTOTCONT:0);
  }
  void Calculation_USKTDKFUXZ() {
    arrt_aggstatoregR l_oRoutine_arrt_aggstatoreg;
    l_oRoutine_arrt_aggstatoreg = arrt_aggstatoregR.Make(m_Ctx,this);
    l_oRoutine_arrt_aggstatoreg.pFile = "OPERAZBO";
    l_oRoutine_arrt_aggstatoreg.pOper = "EDIT";
    l_oRoutine_arrt_aggstatoreg.Run();
  }
  void Calculation_WKUMXNRIRT() {
    w_DESCCIT = (CPLib.Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
    w_PROVINCIA = (CPLib.Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
    w_CODCAB = (CPLib.Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
  }
  void Calculation_LNKPNNFRDI() {
    arrt_val_beneficR l_oRoutine_arrt_val_benefic;
    l_oRoutine_arrt_val_benefic = arrt_val_beneficR.Make(m_Ctx,this);
    l_oRoutine_arrt_val_benefic.Run();
  }
  void Calculation_TBLTXFHXJY() {
    w_VALUTA = (CPLib.eq(w_appolire,"L")?"018":(CPLib.eq(w_appolire,"E")?"242":w_VALUTA));
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_storope","wperazbo",m_KeyColumns,m_Ctx);
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
    w_DATAOPE = CPLib.NullDate();
    w_CDATOPE = "";
    w_filtro = "";
    w_DATAREG = CPLib.NullDate();
    w_FLAGFRAZ = "";
    w_COLLEG = "";
    w_TIPOOPRAP = "";
    w_CODANA = "";
    w_CODVOC = "";
    w_FLAGLIRE = "";
    w_appolire = "";
    w_VALUTA = "";
    w_xTOTLIRE = 0;
    w_FLAGCONT = "";
    w_xTOTCONT = 0;
    w_CAMBIO = 0;
    w_RAPPORTO = "";
    w_CONNESCLI = "";
    w_CONNESOPER = "";
    w_TIPOLEG = "";
    w_PAGASOGOP = "";
    w_CONNESBEN = "";
    w_CONNALTRO = "";
    w_C_RAG = "";
    w_C_CTA = "";
    w_C_PRV = "";
    w_C_CAP = "";
    w_C_CAB = "";
    w_C_IND = "";
    w_C_STA = "";
    w_TIPOINT2 = "";
    w_CODINT2 = "";
    w_DESCINTER = "";
    w_PAESE = "";
    w_C_RAPPORTO = "";
    w_CODCAB2 = "";
    w_PROV2 = "";
    w_DESC2 = "";
    w_ZCPARTE = "";
    w_IDBASE = "";
    w_NUMPROG = "";
    w_CODINTER = "";
    w_CODDIPE = "";
    w_DESCCIT = "";
    w_SEGNO = "";
    w_DATARETT = CPLib.NullDate();
    w_STATOREG = "";
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_tipope = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_TIPOINF = "";
    w_IDEREG = "";
    w_DESCINTER = "";
    w_FLAGRAP = "";
    w_OPRAP = "";
    w_OPERAZMOD = "";
    w_RAPPORTBEN = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_xdes1 = "";
    w_desccauana = "";
    w_xdesccausin = "";
    w_descdiv = "";
    w_xragsocper = "";
    w_xdescrap = "";
    w_xragsocct = "";
    w_xragsocben = "";
    w_xdestipleg = "";
    w_xragint2 = "";
    w_xdescpaese2 = "";
    w_datpaseuro = CPLib.NullDate();
    w_xDescDipe = "";
    w_sEdit = 0;
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_errmsg = "";
    w_test = "";
    w_FLAGRAP2 = "";
    w_valflg2 = "";
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_xcodfisc = "";
    w_PRGIMPOPE = 0;
    w_dataoggi = CPLib.NullDate();
    w_stringaflagrap2 = "";
    w_CDATAOPE = "";
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CABINT = "";
    w_CONNESDOC = "";
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_dessta = "";
    w_xragsocalt = "";
    w_CODVOC = "";
    w_xdciticon = "";
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_CDATREG = "";
    w_DATAVALI = CPLib.NullDate();
    w_DATARILASC = CPLib.NullDate();
    w_apporeg = "";
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_ANNOOPE = 0;
    w_STATOREG = "";
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_xdescopeage = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_OPERAG = "";
    w_NOPROT = 0;
    w_RESPINS = "";
    w_INFORM = "";
    w_NATURA = "";
    w_SCOPO = "";
    w_AREAGEO = "";
    w_MODSVOL = "";
    w_RAGIO = "";
    w_TIPO = "";
    w_RAREA = 0;
    w_RCOMP = 0;
    w_RRAGIO = 0;
    w_RTIPO = 0;
    w_RFREQ = 0;
    w_RIMP = 0;
    w_DURAT = "";
    w_AMMONT = "";
    w_IPCOLLEG = "";
    w_ORACOLLEG = CPLib.NullDateTime();
    w_DUCOLLEG = 0;
    w_MITIG = 0;
    w_MITGDOC = "";
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
    w_IDFILE = "";
    w_MTCN = "";
    m_cWv_ardt_storsogope = "";
    m_cWv_ardt_wlientiope = "";
    m_cWv_ardt_weneficope = "";
    m_cWv_ardt_werzistiope = "";
    m_cWv_ardt_docopebo = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_DATAOPE = CPLib.GetProperty(p,"DATAOPE",w_DATAOPE,0);
      w_CDATOPE = CPLib.GetProperty(p,"CDATOPE",w_CDATOPE,0);
      w_DATAREG = CPLib.GetProperty(p,"DATAREG",w_DATAREG,0);
      w_FLAGFRAZ = CPLib.GetProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
      w_COLLEG = CPLib.GetProperty(p,"COLLEG",w_COLLEG,0);
      w_TIPOOPRAP = CPLib.GetProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
      w_CODANA = CPLib.GetProperty(p,"CODANA",w_CODANA,0);
      w_CODVOC = CPLib.GetProperty(p,"CODVOC",w_CODVOC,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_FLAGCONT = CPLib.GetProperty(p,"FLAGCONT",w_FLAGCONT,0);
      w_CAMBIO = CPLib.GetProperty(p,"CAMBIO",w_CAMBIO,0);
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_CONNESCLI = CPLib.GetProperty(p,"CONNESCLI",w_CONNESCLI,0);
      w_CONNESOPER = CPLib.GetProperty(p,"CONNESOPER",w_CONNESOPER,0);
      w_TIPOLEG = CPLib.GetProperty(p,"TIPOLEG",w_TIPOLEG,0);
      w_PAGASOGOP = CPLib.GetProperty(p,"PAGASOGOP",w_PAGASOGOP,0);
      w_CONNESBEN = CPLib.GetProperty(p,"CONNESBEN",w_CONNESBEN,0);
      w_CONNALTRO = CPLib.GetProperty(p,"CONNALTRO",w_CONNALTRO,0);
      w_C_RAG = CPLib.GetProperty(p,"C_RAG",w_C_RAG,0);
      w_C_CTA = CPLib.GetProperty(p,"C_CTA",w_C_CTA,0);
      w_C_PRV = CPLib.GetProperty(p,"C_PRV",w_C_PRV,0);
      w_C_CAP = CPLib.GetProperty(p,"C_CAP",w_C_CAP,0);
      w_C_CAB = CPLib.GetProperty(p,"C_CAB",w_C_CAB,0);
      w_C_IND = CPLib.GetProperty(p,"C_IND",w_C_IND,0);
      w_C_STA = CPLib.GetProperty(p,"C_STA",w_C_STA,0);
      w_TIPOINT2 = CPLib.GetProperty(p,"TIPOINT2",w_TIPOINT2,0);
      w_CODINT2 = CPLib.GetProperty(p,"CODINT2",w_CODINT2,0);
      w_DESCINTER = CPLib.GetProperty(p,"DESCINTER",w_DESCINTER,0);
      w_PAESE = CPLib.GetProperty(p,"PAESE",w_PAESE,0);
      w_C_RAPPORTO = CPLib.GetProperty(p,"C_RAPPORTO",w_C_RAPPORTO,0);
      w_CODCAB2 = CPLib.GetProperty(p,"CODCAB2",w_CODCAB2,0);
      w_PROV2 = CPLib.GetProperty(p,"PROV2",w_PROV2,0);
      w_DESC2 = CPLib.GetProperty(p,"DESC2",w_DESC2,0);
      w_ZCPARTE = CPLib.GetProperty(p,"ZCPARTE",w_ZCPARTE,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      op_IDBASE = CPLib.GetProperty(p,"op_IDBASE","",0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      op_NUMPROG = CPLib.GetProperty(p,"op_NUMPROG","",0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_SEGNO = CPLib.GetProperty(p,"SEGNO",w_SEGNO,0);
      w_DATARETT = CPLib.GetProperty(p,"DATARETT",w_DATARETT,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_OPERAG = CPLib.GetProperty(p,"OPERAG",w_OPERAG,0);
      w_NOPROT = CPLib.GetProperty(p,"NOPROT",w_NOPROT,0);
      w_RESPINS = CPLib.GetProperty(p,"RESPINS",w_RESPINS,0);
      w_INFORM = CPLib.GetProperty(p,"INFORM",w_INFORM,0);
      w_NATURA = CPLib.GetProperty(p,"NATURA",w_NATURA,0);
      w_SCOPO = CPLib.GetProperty(p,"SCOPO",w_SCOPO,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_MODSVOL = CPLib.GetProperty(p,"MODSVOL",w_MODSVOL,0);
      w_RAGIO = CPLib.GetProperty(p,"RAGIO",w_RAGIO,0);
      w_TIPO = CPLib.GetProperty(p,"TIPO",w_TIPO,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_RRAGIO = CPLib.GetProperty(p,"RRAGIO",w_RRAGIO,0);
      w_RTIPO = CPLib.GetProperty(p,"RTIPO",w_RTIPO,0);
      w_RFREQ = CPLib.GetProperty(p,"RFREQ",w_RFREQ,0);
      w_RIMP = CPLib.GetProperty(p,"RIMP",w_RIMP,0);
      w_DURAT = CPLib.GetProperty(p,"DURAT",w_DURAT,0);
      w_AMMONT = CPLib.GetProperty(p,"AMMONT",w_AMMONT,0);
      w_CONNESDOC = CPLib.GetProperty(p,"CONNESDOC",w_CONNESDOC,0);
      w_IDFILE = CPLib.GetProperty(p,"IDFILE",w_IDFILE,0);
      w_MTCN = CPLib.GetProperty(p,"MTCN",w_MTCN,0);
      w_TOTLIRE = CPLib.GetProperty(p,"TOTLIRE",w_TOTLIRE,0);
      w_TOTCONT = CPLib.GetProperty(p,"TOTCONT",w_TOTCONT,0);
      w_TIPOINF = CPLib.GetProperty(p,"TIPOINF",w_TIPOINF,0);
      w_IDEREG = CPLib.GetProperty(p,"IDEREG",w_IDEREG,0);
      w_FLAGRAP = CPLib.GetProperty(p,"FLAGRAP",w_FLAGRAP,0);
      w_OPRAP = CPLib.GetProperty(p,"OPRAP",w_OPRAP,0);
      w_OPERAZMOD = CPLib.GetProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
      w_RAPPORTBEN = CPLib.GetProperty(p,"RAPPORTBEN",w_RAPPORTBEN,0);
      w_OPERATORE = CPLib.GetProperty(p,"OPERATORE",w_OPERATORE,0);
      w_AUTOM = CPLib.GetProperty(p,"AUTOM",w_AUTOM,0);
      w_FLAGRAP2 = CPLib.GetProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
      w_PRGIMPOPE = CPLib.GetProperty(p,"PRGIMPOPE",w_PRGIMPOPE,0);
      op_PRGIMPOPE = CPLib.GetProperty(p,"op_PRGIMPOPE",0,0);
      w_CDATAOPE = CPLib.GetProperty(p,"CDATAOPE",w_CDATAOPE,0);
      w_CDATREG = CPLib.GetProperty(p,"CDATREG",w_CDATREG,0);
      w_IPCOLLEG = CPLib.GetProperty(p,"IPCOLLEG",w_IPCOLLEG,0);
      w_ORACOLLEG = CPLib.GetProperty(p,"ORACOLLEG",w_ORACOLLEG,0);
      w_DUCOLLEG = CPLib.GetProperty(p,"DUCOLLEG",w_DUCOLLEG,0);
      w_ANNOOPE = CPLib.GetProperty(p,"ANNOOPE",w_ANNOOPE,0);
      w_MITIG = CPLib.GetProperty(p,"MITIG",w_MITIG,0);
      w_MITGDOC = CPLib.GetProperty(p,"MITGDOC",w_MITGDOC,0);
      w_filtro = CPLib.GetProperty(p,"filtro",w_filtro,0);
      w_appolire = CPLib.GetProperty(p,"appolire",w_appolire,0);
      w_xTOTLIRE = CPLib.GetProperty(p,"xTOTLIRE",w_xTOTLIRE,0);
      w_xTOTCONT = CPLib.GetProperty(p,"xTOTCONT",w_xTOTCONT,0);
      w_xdescmodsvo = CPLib.GetProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescplauso = CPLib.GetProperty(p,"xdescplauso",w_xdescplauso,0);
      w_xdesctipor = CPLib.GetProperty(p,"xdesctipor",w_xdesctipor,0);
      w_xdescopeage = CPLib.GetProperty(p,"xdescopeage",w_xdescopeage,0);
      w_xdescfreq = CPLib.GetProperty(p,"xdescfreq",w_xdescfreq,0);
      w_xdescammo = CPLib.GetProperty(p,"xdescammo",w_xdescammo,0);
      w_xRAGSOCDOC = CPLib.GetProperty(p,"xRAGSOCDOC",w_xRAGSOCDOC,0);
      w_tipope = CPLib.GetProperty(p,"tipope",w_tipope,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_xdes1 = CPLib.GetProperty(p,"xdes1",w_xdes1,0);
      w_desccauana = CPLib.GetProperty(p,"desccauana",w_desccauana,0);
      w_xdesccausin = CPLib.GetProperty(p,"xdesccausin",w_xdesccausin,0);
      w_descdiv = CPLib.GetProperty(p,"descdiv",w_descdiv,0);
      w_xragsocper = CPLib.GetProperty(p,"xragsocper",w_xragsocper,0);
      w_xdescrap = CPLib.GetProperty(p,"xdescrap",w_xdescrap,0);
      w_xragsocct = CPLib.GetProperty(p,"xragsocct",w_xragsocct,0);
      w_xragsocben = CPLib.GetProperty(p,"xragsocben",w_xragsocben,0);
      w_xdestipleg = CPLib.GetProperty(p,"xdestipleg",w_xdestipleg,0);
      w_xragint2 = CPLib.GetProperty(p,"xragint2",w_xragint2,0);
      w_xdescpaese2 = CPLib.GetProperty(p,"xdescpaese2",w_xdescpaese2,0);
      w_datpaseuro = CPLib.GetProperty(p,"datpaseuro",w_datpaseuro,0);
      w_xDescDipe = CPLib.GetProperty(p,"xDescDipe",w_xDescDipe,0);
      w_sEdit = CPLib.GetProperty(p,"sEdit",w_sEdit,0);
      w_gChkDate = CPLib.GetProperty(p,"gChkDate",w_gChkDate,0);
      w_errmsg = CPLib.GetProperty(p,"errmsg",w_errmsg,0);
      w_test = CPLib.GetProperty(p,"test",w_test,0);
      w_valflg2 = CPLib.GetProperty(p,"valflg2",w_valflg2,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_gSblocco = CPLib.GetProperty(p,"gSblocco",w_gSblocco,0);
      w_xcodfisc = CPLib.GetProperty(p,"xcodfisc",w_xcodfisc,0);
      w_dataoggi = CPLib.GetProperty(p,"dataoggi",w_dataoggi,0);
      w_stringaflagrap2 = CPLib.GetProperty(p,"stringaflagrap2",w_stringaflagrap2,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gStatus = CPLib.GetProperty(p,"gStatus",w_gStatus,0);
      w_CITINT = CPLib.GetProperty(p,"CITINT",w_CITINT,0);
      w_CITDIP = CPLib.GetProperty(p,"CITDIP",w_CITDIP,0);
      w_PROVDIP = CPLib.GetProperty(p,"PROVDIP",w_PROVDIP,0);
      w_CABDIP = CPLib.GetProperty(p,"CABDIP",w_CABDIP,0);
      w_PROVINT = CPLib.GetProperty(p,"PROVINT",w_PROVINT,0);
      w_CABINT = CPLib.GetProperty(p,"CABINT",w_CABINT,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_xragsocalt = CPLib.GetProperty(p,"xragsocalt",w_xragsocalt,0);
      w_xdciticon = CPLib.GetProperty(p,"xdciticon",w_xdciticon,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_apporeg = CPLib.GetProperty(p,"apporeg",w_apporeg,0);
      w_gFlgDTP = CPLib.GetProperty(p,"gFlgDTP",w_gFlgDTP,0);
      m_cWv_ardt_storsogope = CPLib.GetProperty(p,"m_cWv_ardt_storsogope",m_cWv_ardt_storsogope,0);
      m_cWv_ardt_wlientiope = CPLib.GetProperty(p,"m_cWv_ardt_wlientiope",m_cWv_ardt_wlientiope,0);
      m_cWv_ardt_weneficope = CPLib.GetProperty(p,"m_cWv_ardt_weneficope",m_cWv_ardt_weneficope,0);
      m_cWv_ardt_werzistiope = CPLib.GetProperty(p,"m_cWv_ardt_werzistiope",m_cWv_ardt_werzistiope,0);
      m_cWv_ardt_docopebo = CPLib.GetProperty(p,"m_cWv_ardt_docopebo",m_cWv_ardt_docopebo,0);
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
    items = tables.get("wogopebo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("wogopebo",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDFILEBO"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDFILEBO"});
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
    map.put("property.value",zeroSplit.split("wogopebo\u0000false\u0000false\u00001\u00000\u0000ardt_storsogope\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("wlientiope");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("wlientiope",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDFILEBO"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDFILEBO"});
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
    map.put("property.value",zeroSplit.split("wlientiope\u0000false\u0000false\u00001\u00000\u0000ardt_wlientiope\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("weneficope");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("weneficope",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDFILEBO"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDFILEBO"});
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
    map.put("property.value",zeroSplit.split("weneficope\u0000false\u0000false\u00001\u00000\u0000ardt_weneficope\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("werzistiope");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("werzistiope",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDFILEBO"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDFILEBO"});
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
    map.put("property.value",zeroSplit.split("werzistiope\u0000false\u0000false\u00001\u00000\u0000ardt_werzistiope\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("docopebo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("docopebo",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"NUMPROG"});
    map.put("rd_var",new String[]{"w_NUMPROG"});
    map.put("wr_var",new String[]{"w_NUMPROG"});
    map.put("wr_field",new String[]{"NUMPROG"});
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
    map.put("property.value",zeroSplit.split("docopebo\u0000false\u0000false\u00001\u00000\u0000ardt_docopebo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODCAU"});
    map.put("rd_var",new String[]{"w_CODANA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Analitica",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Analitiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{"w_CODANA"});
    map.put("rd_kfield",new String[]{"CODCAU"});
    map.put("rd_field",new String[]{"CAUSINT","SEGNO","DESCRI"});
    map.put("rd_var",new String[]{"w_CODVOC","w_SEGNO","w_desccauana"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",zeroSplit.split("C",-1));
    map.put("rd_var.len",zeroSplit.split("2\u00001\u0000165",-1));
    map.put("rd_kvar.len",zeroSplit.split("4",-1));
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",zeroSplit.split("0",-1));
    map.put("rd_var.comment",zeroSplit.split("Causale Sintetica\u0000Segno\u0000Descrizione",-1));
    map.put("rd_kvar.comment",zeroSplit.split("Causale Analitica",-1));
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{""});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000variabile",-1));
    map.put("rd_kvar.obj",zeroSplit.split("campo",-1));
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Sintetiche\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_VALUTA","w_descdiv"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Divisa\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbvalute\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Valute\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("anarapbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anarapbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAPPORTO","DESCRAP","TIPORAP"});
    map.put("rd_var",new String[]{"w_RAPPORTO","w_xdescrap","w_FLAGRAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("25\u000050\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Rapporto Collegato\u0000Descrizione\u0000Tipo Rapporto Collegato",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anarapbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Rapporti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC","CODFISC","DATAVALI","DATARILASC"});
    map.put("rd_var",new String[]{"w_CONNESCLI","w_xragsocper","w_xcodfisc","w_DATAVALI","w_DATARILASC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000D\u0000D",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u000016\u00008\u00008",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Cliente Occasionale\u0000Ragione Sociale\u0000Codice Fiscale\u0000\u0000Data Rilascio Doc.",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Clienti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESOPER","w_xragsocct"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Cliente Occasionale\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Clienti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESBEN","w_xragsocben"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Cliente Occasionale\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Clienti\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNALTRO","w_xragsocalt"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Clienti\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CITTA","CAB","PROV","PKTBSTATI","CAP"});
    map.put("rd_var",new String[]{"w_C_CTA","w_C_CAB","w_C_PRV","w_C_STA","w_C_CAP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u00006\u00002\u00003\u00005",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_C_STA","w_dessta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("inter2bo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("inter2bo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","RAGSOC","CODCAB","PROVINCIA","PAESE","TIPINTER"});
    map.put("rd_var",new String[]{"w_CODINT2","w_DESCINTER","w_CODCAB2","w_PROV2","w_PAESE","w_TIPOINT2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u000050\u00006\u00002\u00003\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Intermediario C/Parte\u0000\u0000CAB Intermediario C/Parte\u0000Provincia Intermediario C/Parte\u0000Stato Intermediario C/Parte\u0000Tipo Intermediario C/Parte",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000not(Empty(w_CODINT2))\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("inter2bo\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Altri Intermediari\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbstati");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstati",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODSTA","DESCRI"});
    map.put("rd_var",new String[]{"w_PAESE","w_xdescpaese2"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato Intermediario C/Parte\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcitta");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcitta",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CAB","CITTA","PROV","CITTA"});
    map.put("rd_var",new String[]{"w_CODCAB2","w_DESC2","w_PROV2","w_xdciticon"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030\u00002\u000040",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("CAB Intermediario C/Parte\u0000Denominazione Intermediario C/Parte\u0000Provincia Intermediario C/Parte\u0000Località",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000not(Empty(w_CODINT2))\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("intermbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("intermbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODINTER","DATANASC","CODCAB","PROVINCIA","DESCCIT"});
    map.put("rd_var",new String[]{"w_CODINTER","w_datpaseuro","w_CABINT","w_PROVINT","w_CITINT"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000D\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("11\u00008\u00006\u00002\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Intermediario\u0000Data Passaggio EURO\u0000CAB\u0000Provincia\u0000Città",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("intermbo\u0000false\u0000false\u00001\u00000\u0000armt_intermbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ","DESCCIT","PROVINCIA","CAB"});
    map.put("rd_var",new String[]{"w_CODDIPE","w_xDescDipe","w_CITDIP","w_PROVDIP","w_CABDIP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030\u000030\u00002\u00006",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Dipendenza\u0000Descrizione\u0000Città\u0000Provincia\u0000CAB",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Dipendenze\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipope");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipope",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI"});
    map.put("rd_var",new String[]{"w_OPERAG","w_xdescopeage"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u0000254",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipope\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipo Operazione Agenzia Entrate\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbareegeog");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbareegeog",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_AREAGEO","w_xdescareag","w_RAREA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000050\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbareegeog\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Area Geografica\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbsvolgim");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbsvolgim",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_MODSVOL","w_xdescmodsvo","w_RCOMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsvolgim\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Modalità Svolgimento\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbplauso");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbplauso",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_RAGIO","w_xdescplauso","w_RRAGIO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbplauso\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Ragionevolezza Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtiporisc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtiporisc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_TIPO","w_xdesctipor","w_RTIPO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u0000100\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtiporisc\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Tipologia Rischio\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbdurata");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbdurata",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_DURAT","w_xdescfreq","w_RFREQ"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbdurata\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Frequenza Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbimporto");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbimporto",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","DESCRI","RISCHIO"});
    map.put("rd_var",new String[]{"w_AMMONT","w_xdescammo","w_RIMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u0000200\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000Descrizione\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbimporto\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Ammontare Operazione\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("kersonbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("kersonbo",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CONNES","RAGSOC"});
    map.put("rd_var",new String[]{"w_CONNESDOC","w_xRAGSOCDOC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("50\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Storico Documenti\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("kersonbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Documenti\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_storope",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_storope",child);
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
    ardt_storsogope = new ardt_storsogopeBO(m_Ctx);
    ardt_wlientiope = new ardt_wlientiopeBO(m_Ctx);
    ardt_weneficope = new ardt_weneficopeBO(m_Ctx);
    ardt_werzistiope = new ardt_werzistiopeBO(m_Ctx);
    ardt_docopebo = new ardt_docopeboBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_storope",m_Ctx);
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
    if ((CPLib.Empty(w_DATAOPE)) || ( ! (CPLib.ge(w_DATAREG,w_DATAOPE)))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAOPE));
      String obblMsgError = m_Ctx.Translate("Data Operazione")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione");
      } else {
        m_cLastMsgError = m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATAOPE = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAOPE";
      }
    } else if ((CPLib.ne(w_gChkDate,"U") && CPLib.ne(w_gChkDate,"B") && CPLib.eq(w_gFlgDTP,0)) && ((CPLib.Empty(w_DATAREG)) || ( ! (CPLib.ge(w_DATAREG,w_DATAOPE))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DATAREG));
      String obblMsgError = m_Ctx.Translate("Data registrazione")+" : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = obblMsgError+m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione");
      } else {
        m_cLastMsgError = m_Ctx.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione");
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_DATAREG = CPLib.NullDate();
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DATAREG";
      }
    } else if (CPLib.Empty(w_xTOTLIRE)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_xTOTLIRE));
      String obblMsgError = "xTOTLIRE : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_xTOTLIRE = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "xTOTLIRE";
      }
    } else if ((CPLib.eq(w_FLAGCONT,"1")) && ((CPLib.Empty(w_xTOTCONT)) || ( ! (arfn_chktotalelire_contR.Make(m_Ctx,this).Run(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE))))) {
      l_bNoObligatory =  ! (CPLib.Empty(w_xTOTCONT));
      String obblMsgError = "xTOTCONT : ";
      if ( ! (l_bNoObligatory)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
        } else {
          m_cLastMsgError = obblMsgError+m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
        if (CPLib.eq(m_cLastMsgError,"")) {
          m_cLastMsgError = "xTOTCONT : ";
          m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
        }
        l_bNoCheck = false;
      }
      l_bResult = false;
      w_xTOTCONT = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "xTOTCONT";
      }
    } else if ( ! (CPLib.Empty(w_CONNESCLI)) &&  ! (arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNESCLI,w_DATAOPE))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = m_Ctx.Translate("Codice Cliente Occasionale")+" : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_CONNESCLI = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CONNESCLI";
      }
    } else if ( ! (CPLib.Empty(w_CONNESOPER)) &&  ! (arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNESOPER,w_DATAOPE))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = m_Ctx.Translate("Codice Cliente Occasionale")+" : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_CONNESOPER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CONNESOPER";
      }
    } else if (CPLib.Empty(w_TIPOLEG)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPOLEG));
      String obblMsgError = m_Ctx.Translate("Tipo Legame")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPOLEG = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPOLEG";
      }
    } else if ( ! (CPLib.Empty(w_CONNALTRO)) &&  ! (arfn_chkdatdocR.Make(m_Ctx,this).Run(w_CONNALTRO,w_DATAOPE))) {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      if (CPLib.eq(m_cLastMsgError,"")) {
        m_cLastMsgError = "CONNALTRO : ";
        m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      }
      l_bNoCheck = false;
      l_bResult = false;
      w_CONNALTRO = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CONNALTRO";
      }
    } else if (CPLib.Empty(w_PROV2) && ACAPFGYRVI_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROV2));
      String obblMsgError = m_Ctx.Translate("Provincia Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROV2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROV2";
      }
    }
    if (l_bResult && (( ! (ardt_storsogope.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_storsogope)) || ( ! (ardt_storsogope.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_storsogope)))) {
      ardt_storsogope.SetFromContext(m_cWv_ardt_storsogope);
      m_cWv_ardt_storsogope = "_not_empty_";
    }
    if (l_bResult && (ardt_storsogope.m_bLoaded || ardt_storsogope.m_bUpdated)) {
      l_bResult = l_bResult && ardt_storsogope.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_storsogope.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_wlientiope.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_wlientiope)) || ( ! (ardt_wlientiope.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_wlientiope)))) {
      ardt_wlientiope.SetFromContext(m_cWv_ardt_wlientiope);
      m_cWv_ardt_wlientiope = "_not_empty_";
    }
    if (l_bResult && (ardt_wlientiope.m_bLoaded || ardt_wlientiope.m_bUpdated)) {
      l_bResult = l_bResult && ardt_wlientiope.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_wlientiope.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_weneficope.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_weneficope)) || ( ! (ardt_weneficope.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_weneficope)))) {
      ardt_weneficope.SetFromContext(m_cWv_ardt_weneficope);
      m_cWv_ardt_weneficope = "_not_empty_";
    }
    if (l_bResult && (ardt_weneficope.m_bLoaded || ardt_weneficope.m_bUpdated)) {
      l_bResult = l_bResult && ardt_weneficope.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_weneficope.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_werzistiope.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_werzistiope)) || ( ! (ardt_werzistiope.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_werzistiope)))) {
      ardt_werzistiope.SetFromContext(m_cWv_ardt_werzistiope);
      m_cWv_ardt_werzistiope = "_not_empty_";
    }
    if (l_bResult && (ardt_werzistiope.m_bLoaded || ardt_werzistiope.m_bUpdated)) {
      l_bResult = l_bResult && ardt_werzistiope.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_werzistiope.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_docopebo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_docopebo)) || ( ! (ardt_docopebo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_docopebo)))) {
      ardt_docopebo.SetFromContext(m_cWv_ardt_docopebo);
      m_cWv_ardt_docopebo = "_not_empty_";
    }
    if (l_bResult && (ardt_docopebo.m_bLoaded || ardt_docopebo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_docopebo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_docopebo.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_storope"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_storope\\"+p_cState};
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
      m_cLastMsgError = "Impossibile variare un'operazione nell'archivio storico";
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
      m_cLastMsgError = "Impossibile cancellare un'operazione dall'archivio storico";
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
      m_cLastMsgError = "Impossibile inserire un'operazione nell'archivio storico";
    }
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"POPERAZ1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"POPERAZ2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PRGIMPOPE = m_Ctx.AskTableProg(w_PRGIMPOPE,15,op_PRGIMPOPE,"PRGIMPOPE"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
    op_codazi = m_Ctx.GetCompany();
    op_IDBASE = w_IDBASE;
    op_NUMPROG = w_NUMPROG;
    op_PRGIMPOPE = w_PRGIMPOPE;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    boolean l_b1;
    l_b1 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    boolean l_b2;
    l_b2 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"POPERAZ1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
      op_codazi = m_Ctx.GetCompany();
      op_IDBASE = w_IDBASE;
    }
    if (l_b1) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"POPERAZ2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
      op_NUMPROG = w_NUMPROG;
    }
    if (l_b2) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PRGIMPOPE = m_Ctx.AskTableProg(w_PRGIMPOPE,15,op_PRGIMPOPE,"PRGIMPOPE"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_wperazbo);
      op_PRGIMPOPE = w_PRGIMPOPE;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_IDBASE = "";
    op_NUMPROG = "";
    op_PRGIMPOPE = 0;
    // Inizializzazione delle variabili per DependsOn
    o_DATAOPE = CPLib.NullDate();
    o_CDATOPE = "";
    o_filtro = "";
    o_DATAREG = CPLib.NullDate();
    o_CODVOC = "";
    o_FLAGLIRE = "";
    o_appolire = "";
    o_FLAGCONT = "";
    o_CONNESBEN = "";
    o_C_CTA = "";
    o_CODINT2 = "";
    o_CODINTER = "";
    o_CODDIPE = "";
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
    CPLib.PutProperty(p,"DATAOPE",w_DATAOPE,0);
    CPLib.PutProperty(p,"CDATOPE",w_CDATOPE,0);
    CPLib.PutProperty(p,"DATAREG",w_DATAREG,0);
    CPLib.PutProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
    CPLib.PutProperty(p,"COLLEG",w_COLLEG,0);
    CPLib.PutProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
    CPLib.PutProperty(p,"CODANA",w_CODANA,0);
    CPLib.PutProperty(p,"CODVOC",w_CODVOC,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"FLAGCONT",w_FLAGCONT,0);
    CPLib.PutProperty(p,"CAMBIO",w_CAMBIO,0);
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"CONNESCLI",w_CONNESCLI,0);
    CPLib.PutProperty(p,"CONNESOPER",w_CONNESOPER,0);
    CPLib.PutProperty(p,"TIPOLEG",w_TIPOLEG,0);
    CPLib.PutProperty(p,"PAGASOGOP",w_PAGASOGOP,0);
    CPLib.PutProperty(p,"CONNESBEN",w_CONNESBEN,0);
    CPLib.PutProperty(p,"CONNALTRO",w_CONNALTRO,0);
    CPLib.PutProperty(p,"C_RAG",w_C_RAG,0);
    CPLib.PutProperty(p,"C_CTA",w_C_CTA,0);
    CPLib.PutProperty(p,"C_PRV",w_C_PRV,0);
    CPLib.PutProperty(p,"C_CAP",w_C_CAP,0);
    CPLib.PutProperty(p,"C_CAB",w_C_CAB,0);
    CPLib.PutProperty(p,"C_IND",w_C_IND,0);
    CPLib.PutProperty(p,"C_STA",w_C_STA,0);
    CPLib.PutProperty(p,"TIPOINT2",w_TIPOINT2,0);
    CPLib.PutProperty(p,"CODINT2",w_CODINT2,0);
    CPLib.PutProperty(p,"DESCINTER",w_DESCINTER,0);
    CPLib.PutProperty(p,"PAESE",w_PAESE,0);
    CPLib.PutProperty(p,"C_RAPPORTO",w_C_RAPPORTO,0);
    CPLib.PutProperty(p,"CODCAB2",w_CODCAB2,0);
    CPLib.PutProperty(p,"PROV2",w_PROV2,0);
    CPLib.PutProperty(p,"DESC2",w_DESC2,0);
    CPLib.PutProperty(p,"ZCPARTE",w_ZCPARTE,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"op_IDBASE",op_IDBASE,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"op_NUMPROG",op_NUMPROG,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"SEGNO",w_SEGNO,0);
    CPLib.PutProperty(p,"DATARETT",w_DATARETT,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"OPERAG",w_OPERAG,0);
    CPLib.PutProperty(p,"NOPROT",w_NOPROT,0);
    CPLib.PutProperty(p,"RESPINS",w_RESPINS,0);
    CPLib.PutProperty(p,"INFORM",w_INFORM,0);
    CPLib.PutProperty(p,"NATURA",w_NATURA,0);
    CPLib.PutProperty(p,"SCOPO",w_SCOPO,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"MODSVOL",w_MODSVOL,0);
    CPLib.PutProperty(p,"RAGIO",w_RAGIO,0);
    CPLib.PutProperty(p,"TIPO",w_TIPO,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"RRAGIO",w_RRAGIO,0);
    CPLib.PutProperty(p,"RTIPO",w_RTIPO,0);
    CPLib.PutProperty(p,"RFREQ",w_RFREQ,0);
    CPLib.PutProperty(p,"RIMP",w_RIMP,0);
    CPLib.PutProperty(p,"DURAT",w_DURAT,0);
    CPLib.PutProperty(p,"AMMONT",w_AMMONT,0);
    CPLib.PutProperty(p,"CONNESDOC",w_CONNESDOC,0);
    CPLib.PutProperty(p,"IDFILE",w_IDFILE,0);
    CPLib.PutProperty(p,"MTCN",w_MTCN,0);
    CPLib.PutProperty(p,"TOTLIRE",w_TOTLIRE,0);
    CPLib.PutProperty(p,"TOTCONT",w_TOTCONT,0);
    CPLib.PutProperty(p,"TIPOINF",w_TIPOINF,0);
    CPLib.PutProperty(p,"IDEREG",w_IDEREG,0);
    CPLib.PutProperty(p,"FLAGRAP",w_FLAGRAP,0);
    CPLib.PutProperty(p,"OPRAP",w_OPRAP,0);
    CPLib.PutProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
    CPLib.PutProperty(p,"RAPPORTBEN",w_RAPPORTBEN,0);
    CPLib.PutProperty(p,"OPERATORE",w_OPERATORE,0);
    CPLib.PutProperty(p,"AUTOM",w_AUTOM,0);
    CPLib.PutProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
    CPLib.PutProperty(p,"PRGIMPOPE",w_PRGIMPOPE,0);
    CPLib.PutProperty(p,"op_PRGIMPOPE",op_PRGIMPOPE,0);
    CPLib.PutProperty(p,"CDATAOPE",w_CDATAOPE,0);
    CPLib.PutProperty(p,"CDATREG",w_CDATREG,0);
    CPLib.PutProperty(p,"IPCOLLEG",w_IPCOLLEG,0);
    CPLib.PutProperty(p,"ORACOLLEG",w_ORACOLLEG,0);
    CPLib.PutProperty(p,"DUCOLLEG",w_DUCOLLEG,0);
    CPLib.PutProperty(p,"ANNOOPE",w_ANNOOPE,0);
    CPLib.PutProperty(p,"MITIG",w_MITIG,0);
    CPLib.PutProperty(p,"MITGDOC",w_MITGDOC,0);
    CPLib.PutProperty(p,"filtro",w_filtro,0);
    CPLib.PutProperty(p,"appolire",w_appolire,0);
    CPLib.PutProperty(p,"xTOTLIRE",w_xTOTLIRE,0);
    CPLib.PutProperty(p,"xTOTCONT",w_xTOTCONT,0);
    CPLib.PutProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescplauso",w_xdescplauso,0);
    CPLib.PutProperty(p,"xdesctipor",w_xdesctipor,0);
    CPLib.PutProperty(p,"xdescopeage",w_xdescopeage,0);
    CPLib.PutProperty(p,"xdescfreq",w_xdescfreq,0);
    CPLib.PutProperty(p,"xdescammo",w_xdescammo,0);
    CPLib.PutProperty(p,"xRAGSOCDOC",w_xRAGSOCDOC,0);
    CPLib.PutProperty(p,"tipope",w_tipope,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"xdes1",w_xdes1,0);
    CPLib.PutProperty(p,"desccauana",w_desccauana,0);
    CPLib.PutProperty(p,"xdesccausin",w_xdesccausin,0);
    CPLib.PutProperty(p,"descdiv",w_descdiv,0);
    CPLib.PutProperty(p,"xragsocper",w_xragsocper,0);
    CPLib.PutProperty(p,"xdescrap",w_xdescrap,0);
    CPLib.PutProperty(p,"xragsocct",w_xragsocct,0);
    CPLib.PutProperty(p,"xragsocben",w_xragsocben,0);
    CPLib.PutProperty(p,"xdestipleg",w_xdestipleg,0);
    CPLib.PutProperty(p,"xragint2",w_xragint2,0);
    CPLib.PutProperty(p,"xdescpaese2",w_xdescpaese2,0);
    CPLib.PutProperty(p,"datpaseuro",w_datpaseuro,0);
    CPLib.PutProperty(p,"xDescDipe",w_xDescDipe,0);
    CPLib.PutProperty(p,"sEdit",w_sEdit,0);
    CPLib.PutProperty(p,"gChkDate",w_gChkDate,0);
    CPLib.PutProperty(p,"errmsg",w_errmsg,0);
    CPLib.PutProperty(p,"test",w_test,0);
    CPLib.PutProperty(p,"valflg2",w_valflg2,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"gSblocco",w_gSblocco,0);
    CPLib.PutProperty(p,"xcodfisc",w_xcodfisc,0);
    CPLib.PutProperty(p,"dataoggi",w_dataoggi,0);
    CPLib.PutProperty(p,"stringaflagrap2",w_stringaflagrap2,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gStatus",w_gStatus,0);
    CPLib.PutProperty(p,"CITINT",w_CITINT,0);
    CPLib.PutProperty(p,"CITDIP",w_CITDIP,0);
    CPLib.PutProperty(p,"PROVDIP",w_PROVDIP,0);
    CPLib.PutProperty(p,"CABDIP",w_CABDIP,0);
    CPLib.PutProperty(p,"PROVINT",w_PROVINT,0);
    CPLib.PutProperty(p,"CABINT",w_CABINT,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"xragsocalt",w_xragsocalt,0);
    CPLib.PutProperty(p,"xdciticon",w_xdciticon,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"apporeg",w_apporeg,0);
    CPLib.PutProperty(p,"gFlgDTP",w_gFlgDTP,0);
    if (p_bGetChildren) {
      if (ardt_storsogope.IsUpdated()) {
        m_cWv_ardt_storsogope = ardt_storsogope.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_storsogope",m_cWv_ardt_storsogope,0);
    }
    if (p_bGetChildren) {
      if (ardt_wlientiope.IsUpdated()) {
        m_cWv_ardt_wlientiope = ardt_wlientiope.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_wlientiope",m_cWv_ardt_wlientiope,0);
    }
    if (p_bGetChildren) {
      if (ardt_weneficope.IsUpdated()) {
        m_cWv_ardt_weneficope = ardt_weneficope.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_weneficope",m_cWv_ardt_weneficope,0);
    }
    if (p_bGetChildren) {
      if (ardt_werzistiope.IsUpdated()) {
        m_cWv_ardt_werzistiope = ardt_werzistiope.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_werzistiope",m_cWv_ardt_werzistiope,0);
    }
    if (p_bGetChildren) {
      if (ardt_docopebo.IsUpdated()) {
        m_cWv_ardt_docopebo = ardt_docopebo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_docopebo",m_cWv_ardt_docopebo,0);
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
    return "wperazbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
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
    oneAutoNum.add("POPERAZ1");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_NUMPROG");
    oneAutoNum.add("POPERAZ2");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PRGIMPOPE");
    oneAutoNum.add("PRGIMPOPE");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_storsogope() {
    if (ardt_storsogope.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_storsogope) || CPLib.IsLoaded(m_cWv_ardt_storsogope))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_storsogope.m_bLoaded)) {
      ardt_storsogope.Blank();
      ardt_storsogope.w_IDFILEBO = w_IDBASE;
      ardt_storsogope.Load();
    }
    return ardt_storsogope.m_bLoaded;
  }
  public void CtxLoad_ardt_storsogope() {
    if ( ! (ardt_storsogope.m_lCtxLoaded)) {
      ardt_storsogope.Blank();
    }
    ardt_storsogope.m_lCtxLoaded = true;
    if ( ! (ardt_storsogope.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_storsogope) || CPLib.IsLoaded(m_cWv_ardt_storsogope)) {
        ardt_storsogope.SetFromContext(m_cWv_ardt_storsogope);
        m_cWv_ardt_storsogope = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_storsogope.m_bLoaded)) {
          ardt_storsogope.Blank();
          ardt_storsogope.w_IDFILEBO = w_IDBASE;
          ardt_storsogope.Load();
          if ( ! (ardt_storsogope.m_bLoaded)) {
            ardt_storsogope.Initialize();
            ardt_storsogope.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_wlientiope() {
    if (ardt_wlientiope.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_wlientiope) || CPLib.IsLoaded(m_cWv_ardt_wlientiope))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_wlientiope.m_bLoaded)) {
      ardt_wlientiope.Blank();
      ardt_wlientiope.w_IDFILEBO = w_IDBASE;
      ardt_wlientiope.Load();
    }
    return ardt_wlientiope.m_bLoaded;
  }
  public void CtxLoad_ardt_wlientiope() {
    if ( ! (ardt_wlientiope.m_lCtxLoaded)) {
      ardt_wlientiope.Blank();
    }
    ardt_wlientiope.m_lCtxLoaded = true;
    if ( ! (ardt_wlientiope.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_wlientiope) || CPLib.IsLoaded(m_cWv_ardt_wlientiope)) {
        ardt_wlientiope.SetFromContext(m_cWv_ardt_wlientiope);
        m_cWv_ardt_wlientiope = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_wlientiope.m_bLoaded)) {
          ardt_wlientiope.Blank();
          ardt_wlientiope.w_IDFILEBO = w_IDBASE;
          ardt_wlientiope.Load();
          if ( ! (ardt_wlientiope.m_bLoaded)) {
            ardt_wlientiope.Initialize();
            ardt_wlientiope.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_weneficope() {
    if (ardt_weneficope.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_weneficope) || CPLib.IsLoaded(m_cWv_ardt_weneficope))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_weneficope.m_bLoaded)) {
      ardt_weneficope.Blank();
      ardt_weneficope.w_IDFILEBO = w_IDBASE;
      ardt_weneficope.Load();
    }
    return ardt_weneficope.m_bLoaded;
  }
  public void CtxLoad_ardt_weneficope() {
    if ( ! (ardt_weneficope.m_lCtxLoaded)) {
      ardt_weneficope.Blank();
    }
    ardt_weneficope.m_lCtxLoaded = true;
    if ( ! (ardt_weneficope.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_weneficope) || CPLib.IsLoaded(m_cWv_ardt_weneficope)) {
        ardt_weneficope.SetFromContext(m_cWv_ardt_weneficope);
        m_cWv_ardt_weneficope = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_weneficope.m_bLoaded)) {
          ardt_weneficope.Blank();
          ardt_weneficope.w_IDFILEBO = w_IDBASE;
          ardt_weneficope.Load();
          if ( ! (ardt_weneficope.m_bLoaded)) {
            ardt_weneficope.Initialize();
            ardt_weneficope.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_werzistiope() {
    if (ardt_werzistiope.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_werzistiope) || CPLib.IsLoaded(m_cWv_ardt_werzistiope))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_werzistiope.m_bLoaded)) {
      ardt_werzistiope.Blank();
      ardt_werzistiope.w_IDFILEBO = w_IDBASE;
      ardt_werzistiope.Load();
    }
    return ardt_werzistiope.m_bLoaded;
  }
  public void CtxLoad_ardt_werzistiope() {
    if ( ! (ardt_werzistiope.m_lCtxLoaded)) {
      ardt_werzistiope.Blank();
    }
    ardt_werzistiope.m_lCtxLoaded = true;
    if ( ! (ardt_werzistiope.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_werzistiope) || CPLib.IsLoaded(m_cWv_ardt_werzistiope)) {
        ardt_werzistiope.SetFromContext(m_cWv_ardt_werzistiope);
        m_cWv_ardt_werzistiope = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_werzistiope.m_bLoaded)) {
          ardt_werzistiope.Blank();
          ardt_werzistiope.w_IDFILEBO = w_IDBASE;
          ardt_werzistiope.Load();
          if ( ! (ardt_werzistiope.m_bLoaded)) {
            ardt_werzistiope.Initialize();
            ardt_werzistiope.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_docopebo() {
    if (ardt_docopebo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_docopebo) || CPLib.IsLoaded(m_cWv_ardt_docopebo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_docopebo.m_bLoaded)) {
      ardt_docopebo.Blank();
      ardt_docopebo.w_NUMPROG = w_NUMPROG;
      ardt_docopebo.Load();
    }
    return ardt_docopebo.m_bLoaded;
  }
  public void CtxLoad_ardt_docopebo() {
    if ( ! (ardt_docopebo.m_lCtxLoaded)) {
      ardt_docopebo.Blank();
    }
    ardt_docopebo.m_lCtxLoaded = true;
    if ( ! (ardt_docopebo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_docopebo) || CPLib.IsLoaded(m_cWv_ardt_docopebo)) {
        ardt_docopebo.SetFromContext(m_cWv_ardt_docopebo);
        m_cWv_ardt_docopebo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_docopebo.m_bLoaded)) {
          ardt_docopebo.Blank();
          ardt_docopebo.w_NUMPROG = w_NUMPROG;
          ardt_docopebo.Load();
          if ( ! (ardt_docopebo.m_bLoaded)) {
            ardt_docopebo.Initialize();
            ardt_docopebo.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_storsogope")) {
      CtxLoad_ardt_storsogope();
      return ardt_storsogope;
    }
    if (CPLib.eq(p_cName,"ardt_wlientiope")) {
      CtxLoad_ardt_wlientiope();
      return ardt_wlientiope;
    }
    if (CPLib.eq(p_cName,"ardt_weneficope")) {
      CtxLoad_ardt_weneficope();
      return ardt_weneficope;
    }
    if (CPLib.eq(p_cName,"ardt_werzistiope")) {
      CtxLoad_ardt_werzistiope();
      return ardt_werzistiope;
    }
    if (CPLib.eq(p_cName,"ardt_docopebo")) {
      CtxLoad_ardt_docopebo();
      return ardt_docopebo;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
