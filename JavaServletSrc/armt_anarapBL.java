import java.util.*;

public class armt_anarapBL extends armt_anarapWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_anarap";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public CPPhTableWrInfo m_oWrInfo_anarapbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_anarapbo;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public CPPhTableWrInfo m_oWrInfo_tbtipnat;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public CPPhTableWrInfo m_oWrInfo_tbvalute;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public CPPhTableWrInfo m_oWrInfo_tbrapp;
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog;
  public String m_cPhName_tbsvolgim;
  public String m_cServer_tbsvolgim;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim;
  public String m_cPhName_tbplauso;
  public String m_cServer_tbplauso;
  public CPPhTableWrInfo m_oWrInfo_tbplauso;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public CPPhTableWrInfo m_oWrInfo_tbtipatt;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc;
  public String m_cPhName_tbdurata;
  public String m_cServer_tbdurata;
  public CPPhTableWrInfo m_oWrInfo_tbdurata;
  public String m_cPhName_tbimporto;
  public String m_cServer_tbimporto;
  public CPPhTableWrInfo m_oWrInfo_tbimporto;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public CPPhTableWrInfo m_oWrInfo_tbmacage;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public CPPhTableWrInfo m_oWrInfo_personbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
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
  public String m_cPhName_tbdurata_p;
  public String m_cServer_tbdurata_p;
  public CPPhTableWrInfo m_oWrInfo_tbdurata_p;
  public String m_cPhName_tbimporto_p;
  public String m_cServer_tbimporto_p;
  public CPPhTableWrInfo m_oWrInfo_tbimporto_p;
  public String m_cPhName_tbareegeog_p;
  public String m_cServer_tbareegeog_p;
  public CPPhTableWrInfo m_oWrInfo_tbareegeog_p;
  public String m_cPhName_tbsvolgim_p;
  public String m_cServer_tbsvolgim_p;
  public CPPhTableWrInfo m_oWrInfo_tbsvolgim_p;
  public String m_cPhName_tbplauso_p;
  public String m_cServer_tbplauso_p;
  public CPPhTableWrInfo m_oWrInfo_tbplauso_p;
  public String m_cPhName_tbtiporisc_p;
  public String m_cServer_tbtiporisc_p;
  public CPPhTableWrInfo m_oWrInfo_tbtiporisc_p;
  public String m_cPhName_tbrappogg;
  public String m_cServer_tbrappogg;
  public CPPhTableWrInfo m_oWrInfo_tbrappogg;
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
  public CPPhTableWrInfo m_oWrInfo_tbrisglob;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"anarapbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'ISOAGE':ISOAGE,'NOPROT':NOPROT,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'IBAN':IBAN,'CODOGG':CODOGG,'NATURA':NATURA,'SCOPO':SCOPO,'DURAT':DURAT,'RFREQ':RFREQ,'AMMONT':AMMONT,'RIMP':RIMP,'AREAGEO':AREAGEO,'RAREA':RAREA,'MODSVOL':MODSVOL,'RCOMP':RCOMP,'RAGIO':RAGIO,'RRAGIO':RRAGIO,'TIPO':TIPO,'RTIPO':RTIPO,'RISGLOB':RISGLOB,'DATAPROF':DATAPROF,'DATAREVPROF':DATAREVPROF,'MITIG':MITIG,'MITGDOC':MITGDOC,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CATEG04':CATEG04,'CATEG05':CATEG05,'NOCANC':NOCANC,'ardt_garantbo':ardt_garantbo,'CODDIPE':CODDIPE,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap,'ardt_saldi_idp':ardt_saldi_idp,'MACODICE':MACODICE,'SPLITCODE':SPLITCODE,'CODICELR':CODICELR"+FoundlingChildrenList("armt_anarap",true)+"}";
  public static final String i_CompleteStateStructure = "{'gTipInter':gTipInter,'gBrowser':gBrowser,'gTelepass':gTelepass,'gCodDip':gCodDip,'CODDIP':CODDIP,'RAPPORTO':RAPPORTO,'DESCRAP':DESCRAP,'TIPORAP':TIPORAP,'TIPOAG':TIPOAG,'ISOAGE':ISOAGE,'NOPROT':NOPROT,'FLAGLIRE':FLAGLIRE,'VALUTA':VALUTA,'PRGIMPRAP':PRGIMPRAP,'descval':descval,'IBAN':IBAN,'CODOGG':CODOGG,'daticoll':daticoll,'NATURA':NATURA,'SCOPO':SCOPO,'DURAT':DURAT,'RFREQ':RFREQ,'AMMONT':AMMONT,'RIMP':RIMP,'AREAGEO':AREAGEO,'RAREA':RAREA,'MODSVOL':MODSVOL,'RCOMP':RCOMP,'RAGIO':RAGIO,'RRAGIO':RRAGIO,'TIPO':TIPO,'RTIPO':RTIPO,'xdescmodsvo':xdescmodsvo,'xdescareag':xdescareag,'xdescplauso':xdescplauso,'xdesctipor':xdesctipor,'xdescfreq':xdescfreq,'xdescammo':xdescammo,'RISGLOB':RISGLOB,'DATAPROF':DATAPROF,'DATAREVPROF':DATAREVPROF,'MITIG':MITIG,'MITGDOC':MITGDOC,'CATEG01':CATEG01,'CATEG02':CATEG02,'CATEG03':CATEG03,'CATEG04':CATEG04,'CATEG05':CATEG05,'xC1DESCRI':xC1DESCRI,'xC2DESCRI':xC2DESCRI,'xC3DESCRI':xC3DESCRI,'xC4DESCRI':xC4DESCRI,'xC5DESCRI':xC5DESCRI,'CATEGORIA':CATEGORIA,'titolo':titolo,'NOCANC':NOCANC,'mess':mess,'xMADESCRI':xMADESCRI,'xRAGLEG':xRAGLEG,'ardt_garantbo':ardt_garantbo,'xDESDIPE':xDESDIPE,'CODDIPE':CODDIPE,'ardt_ae_saldianno_rap':ardt_ae_saldianno_rap,'ardt_saldi_idp':ardt_saldi_idp,'MACODICE':MACODICE,'SPLITCODE':SPLITCODE,'CODICELR':CODICELR"+FoundlingChildrenList("armt_anarap",true)+"}";
  public static final String i_ItemSequence = "RAPPORTO,DESCRAP,TIPORAP,TIPOAG,ISOAGE,NOPROT,FLAGLIRE,VALUTA,IBAN,CODOGG,NATURA,SCOPO,DURAT,RFREQ,AMMONT,RIMP,AREAGEO,RAREA,MODSVOL,RCOMP,RAGIO,RRAGIO,TIPO,RTIPO,RISGLOB,DATAPROF,DATAREVPROF,MITIG,MITGDOC,CATEG01,CATEG02,CATEG03,CATEG04,CATEG05,NOCANC,ardt_garantbo,CODDIPE,ardt_ae_saldianno_rap,ardt_saldi_idp,MACODICE,SPLITCODE,CODICELR"+FoundlingChildrenList("armt_anarap",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_anarap"),new String[][]{new String[]{"RAPPORTO","Codice Rapporto","C","25","0","campo","key1","false","false"},new String[]{"DESCRAP","Descrizione","C","50","0","campo","key2","false","false"},new String[]{"TIPORAP","Tipo Rapporto","C","1","0","campo","nokey","false","true"},new String[]{"TIPOAG","","C","2","0","campo","nokey","false","false"},new String[]{"ISOAGE","Per tipo rapporto 96/97","C","3","0","campo","nokey","false","true"},new String[]{"NOPROT","Non inviare agenzia entrate","N","1","0","campo","nokey","false","false"},new String[]{"FLAGLIRE","Divisa","C","1","0","campo","nokey","false","true"},new String[]{"VALUTA","Codice Divisa","C","3","0","campo","nokey","false","true"},new String[]{"IBAN","IBAN","C","30","0","campo","nokey","false","false"},new String[]{"CODOGG","Cod. Rapporto Oggettivo","C","3","0","campo","nokey","false","false"},new String[]{"NATURA","","C","50","0","campo","nokey","false","false"},new String[]{"SCOPO","","C","50","0","campo","nokey","false","false"},new String[]{"DURAT","","C","5","0","campo","nokey","false","false"},new String[]{"RFREQ","","N","3","0","campo","nokey","false","false"},new String[]{"AMMONT","","C","5","0","campo","nokey","false","false"},new String[]{"RIMP","","N","3","0","campo","nokey","false","false"},new String[]{"AREAGEO","","C","5","0","campo","nokey","false","false"},new String[]{"RAREA","","N","3","0","campo","nokey","false","false"},new String[]{"MODSVOL","","C","5","0","campo","nokey","false","false"},new String[]{"RCOMP","","N","3","0","campo","nokey","false","false"},new String[]{"RAGIO","","C","5","0","campo","nokey","false","false"},new String[]{"RRAGIO","","N","3","0","campo","nokey","false","false"},new String[]{"TIPO","","C","5","0","campo","nokey","false","false"},new String[]{"RTIPO","","N","3","0","campo","nokey","false","false"},new String[]{"RISGLOB","Rischio Globale","C","1","0","campo","nokey","false","false"},new String[]{"DATAPROF","Data Profilatura","D","8","0","campo","nokey","false","false"},new String[]{"DATAREVPROF","Data Revisione Profilatura","D","8","0","campo","nokey","false","false"},new String[]{"MITIG","Mitigazione (+/-)","N","4","0","campo","nokey","false","false"},new String[]{"MITGDOC","Documentazione Mitigazione","C","100","0","campo","nokey","false","false"},new String[]{"CATEG01","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG02","Categoria 2","C","2","0","campo","nokey","false","false"},new String[]{"CATEG03","Categoria 3","C","2","0","campo","nokey","false","false"},new String[]{"CATEG04","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"CATEG05","Categoria 1","C","2","0","campo","nokey","false","false"},new String[]{"NOCANC","Non considerare per passaggio storico/cancellazione","N","1","0","campo","nokey","false","false"},new String[]{"ardt_garantbo","Garantiti","","","","link_PC","","false",""},new String[]{"CODDIPE","Dipendeza Riferimento","C","6","0","campo","nokey","false","false"},new String[]{"ardt_ae_saldianno_rap","LinkPC","","","","link_PC","","false",""},new String[]{"ardt_saldi_idp","Saldi Trimestrali","","","","link_PC","","false",""},new String[]{"MACODICE","Macro Agente","C","5","0","campo","nokey","false","false"},new String[]{"SPLITCODE","Customer ID (WUBS)","C","15","0","campo","nokey","false","false"},new String[]{"CODICELR","Legale Rappresentante","C","16","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_anarapBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo",p_ContextObject.GetCompany(),false);
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_oWrInfo_anarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anarapbo",p_ContextObject.GetCompany());
    m_cVirtName_anarapbo = CPSql.ManipulateTablePhName("anarapbo",m_cServer_anarapbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_oWrInfo_tbtipnat = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipnat",p_ContextObject.GetCompany());
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_oWrInfo_tbvalute = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbvalute",p_ContextObject.GetCompany());
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_oWrInfo_tbrapp = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrapp",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_oWrInfo_tbareegeog = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim = p_ContextObject.GetPhName("tbsvolgim");
    m_cServer_tbsvolgim = p_ContextObject.GetServer("tbsvolgim");
    m_oWrInfo_tbsvolgim = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim",p_ContextObject.GetCompany());
    m_cPhName_tbplauso = p_ContextObject.GetPhName("tbplauso");
    m_cServer_tbplauso = p_ContextObject.GetServer("tbplauso");
    m_oWrInfo_tbplauso = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso",p_ContextObject.GetCompany());
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_oWrInfo_tbtipatt = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipatt",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_oWrInfo_tbtiporisc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc",p_ContextObject.GetCompany());
    m_cPhName_tbdurata = p_ContextObject.GetPhName("tbdurata");
    m_cServer_tbdurata = p_ContextObject.GetServer("tbdurata");
    m_oWrInfo_tbdurata = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata",p_ContextObject.GetCompany());
    m_cPhName_tbimporto = p_ContextObject.GetPhName("tbimporto");
    m_cServer_tbimporto = p_ContextObject.GetServer("tbimporto");
    m_oWrInfo_tbimporto = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto",p_ContextObject.GetCompany());
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_oWrInfo_tbmacage = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbmacage",p_ContextObject.GetCompany());
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_oWrInfo_personbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"personbo",p_ContextObject.GetCompany());
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
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
    m_cPhName_tbdurata_p = p_ContextObject.GetPhName("tbdurata_p");
    m_cServer_tbdurata_p = p_ContextObject.GetServer("tbdurata_p");
    m_oWrInfo_tbdurata_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbdurata_p",p_ContextObject.GetCompany());
    m_cPhName_tbimporto_p = p_ContextObject.GetPhName("tbimporto_p");
    m_cServer_tbimporto_p = p_ContextObject.GetServer("tbimporto_p");
    m_oWrInfo_tbimporto_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbimporto_p",p_ContextObject.GetCompany());
    m_cPhName_tbareegeog_p = p_ContextObject.GetPhName("tbareegeog_p");
    m_cServer_tbareegeog_p = p_ContextObject.GetServer("tbareegeog_p");
    m_oWrInfo_tbareegeog_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbareegeog_p",p_ContextObject.GetCompany());
    m_cPhName_tbsvolgim_p = p_ContextObject.GetPhName("tbsvolgim_p");
    m_cServer_tbsvolgim_p = p_ContextObject.GetServer("tbsvolgim_p");
    m_oWrInfo_tbsvolgim_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsvolgim_p",p_ContextObject.GetCompany());
    m_cPhName_tbplauso_p = p_ContextObject.GetPhName("tbplauso_p");
    m_cServer_tbplauso_p = p_ContextObject.GetServer("tbplauso_p");
    m_oWrInfo_tbplauso_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbplauso_p",p_ContextObject.GetCompany());
    m_cPhName_tbtiporisc_p = p_ContextObject.GetPhName("tbtiporisc_p");
    m_cServer_tbtiporisc_p = p_ContextObject.GetServer("tbtiporisc_p");
    m_oWrInfo_tbtiporisc_p = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtiporisc_p",p_ContextObject.GetCompany());
    m_cPhName_tbrappogg = p_ContextObject.GetPhName("tbrappogg");
    m_cServer_tbrappogg = p_ContextObject.GetServer("tbrappogg");
    m_oWrInfo_tbrappogg = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrappogg",p_ContextObject.GetCompany());
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    m_oWrInfo_tbrisglob = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrisglob",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_garantbo = new ardt_garantboBO(p_ContextObject);
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(p_ContextObject);
    ardt_saldi_idp = new ardt_saldi_idpBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_anarap",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_CODDIP = "";
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_ISOAGE = "";
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_PRGIMPRAP = 0;
    w_descval = "";
    w_IBAN = "";
    w_CODOGG = "";
    w_daticoll = 0;
    w_NATURA = "";
    w_SCOPO = "";
    w_DURAT = "";
    w_DURAT = "";
    w_RFREQ = 0;
    w_AMMONT = "";
    w_AMMONT = "";
    w_RIMP = 0;
    w_AREAGEO = "";
    w_AREAGEO = "";
    w_RAREA = 0;
    w_MODSVOL = "";
    w_MODSVOL = "";
    w_RCOMP = 0;
    w_RAGIO = "";
    w_RAGIO = "";
    w_RRAGIO = 0;
    w_TIPO = "";
    w_TIPO = "";
    w_RTIPO = 0;
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_RISGLOB = "";
    w_DATAPROF = CPLib.NullDate();
    w_DATAREVPROF = CPLib.NullDate();
    w_MITIG = 0;
    w_MITGDOC = "";
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
    w_NOCANC = 0;
    w_xMADESCRI = "";
    w_xRAGLEG = "";
    w_xDESDIPE = "";
    w_MACODICE = "";
    w_SPLITCODE = "";
    w_CODICELR = "";
    w_NOPROT = 0;
    Link_RUMXLFCOKA();
    Link_CKJQULDXKW();
    Link_VEAKSOSZMJ();
    Link_SXTYCPHBIM();
    Link_FLHYCYAKON();
    Link_QJSTZIPOQB();
    Link_MDMTUJRAZF();
    Link_SFFFOYOWNH();
    Link_ZKJUEEUNAK();
    Link_NOBMPHKVTX();
    Link_EAWVSIWQBM();
    Link_DJOWYRMDDC();
    Link_DTDVSGUEWE();
    Link_CANUTVNGFD();
    Link_IXGRJLAKIQ();
    Link_NKIXCWZJHO();
    Link_JQLGHMLOKO();
    Link_QVBZSFMTVP();
    w_CATEGORIA = "";
    w_CATEGORIA = fwfn_calc_categoriaR.Make(m_Ctx,this).Run(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
    w_titolo = "";
    w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari (AUI)":"Rapporti Continuativi (AUI)")+" - "+CPLib.LRTrim(w_RAPPORTO)+"-"+CPLib.LRTrim(w_DESCRAP);
    w_mess = "";
    w_mess = "Messaggio\\nSecondo\\nTerzo";
    w_CODDIPE = w_gCodDip;
    Link_HBPZQIPSZE();
    Link_SSYXHQXJLD();
    Link_UYHOJSIFEU();
    m_cWv_ardt_garantbo = "";
    m_cWv_ardt_ae_saldianno_rap = "";
    m_cWv_ardt_saldi_idp = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_garantbo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_garantbo);
    l_bResult = l_bResult || ardt_ae_saldianno_rap.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap);
    l_bResult = l_bResult || ardt_saldi_idp.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_saldi_idp);
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
    o_FLAGLIRE = w_FLAGLIRE;
    o_VALUTA = w_VALUTA;
    o_DURAT = w_DURAT;
    o_AMMONT = w_AMMONT;
    o_AREAGEO = w_AREAGEO;
    o_MODSVOL = w_MODSVOL;
    o_RAGIO = w_RAGIO;
    o_TIPO = w_TIPO;
    o_CATEG01 = w_CATEG01;
    o_CATEG02 = w_CATEG02;
    o_CATEG03 = w_CATEG03;
    o_CATEG04 = w_CATEG04;
    o_CATEG05 = w_CATEG05;
    ardt_garantbo.SaveDependsOn();
    ardt_ae_saldianno_rap.SaveDependsOn();
    ardt_saldi_idp.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Delete start")) {
      Calculation_XEYBWIHFFE();
    } else if (CPLib.eq(p_cEvent,"Insert end")) {
      Calculation_OISCNQOBOK();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_GUQDVKITTU();
      Calculation_IXFNYZEOIT();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
      Calculation_WVQZABBQGF();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
      Calculation_DFZSPGVPHX();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
      Calculation_MDBTHEOWAB();
    } else if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_OISCNQOBOK();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_LQFWQMTCLB();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_RUMXLFCOKA() {
    return Link_RUMXLFCOKA("Full");
  }
  protected boolean Link_RUMXLFCOKA(String p_cType) {
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
          w_descval = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RUMXLFCOKA_blank();
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
      Link_RUMXLFCOKA_blank();
    }
    return l_bResult;
  }
  void Link_RUMXLFCOKA_blank() {
    w_VALUTA = "";
    w_descval = "";
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
  protected boolean Link_VEAKSOSZMJ() {
    return Link_VEAKSOSZMJ("Full");
  }
  protected boolean Link_VEAKSOSZMJ(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",5,0),m_cServer_tbdurata_p,w_DURAT);
      if (m_Ctx.IsSharedTemp("tbdurata_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbdurata_p,"select CODICE,RISCHIO from "+m_cPhName_tbdurata_p+((m_cPhName_tbdurata_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DURAT = l_rsLink.GetString("CODICE");
          w_RFREQ = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_VEAKSOSZMJ_blank();
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
      Link_VEAKSOSZMJ_blank();
    }
    return l_bResult;
  }
  void Link_VEAKSOSZMJ_blank() {
    w_DURAT = "";
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
      l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",200,0),m_cServer_tbimporto,w_AMMONT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbimporto,"select CODICE,DESCRI from "+m_cPhName_tbimporto+((m_cPhName_tbimporto).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AMMONT = l_rsLink.GetString("CODICE");
          w_xdescammo = l_rsLink.GetString("DESCRI");
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
  }
  protected boolean Link_FLHYCYAKON() {
    return Link_FLHYCYAKON("Full");
  }
  protected boolean Link_FLHYCYAKON(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AMMONT,"C",5,0),m_cServer_tbimporto_p,w_AMMONT);
      if (m_Ctx.IsSharedTemp("tbimporto_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbimporto_p,"select CODICE,RISCHIO from "+m_cPhName_tbimporto_p+((m_cPhName_tbimporto_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AMMONT = l_rsLink.GetString("CODICE");
          w_RIMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_FLHYCYAKON_blank();
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
      Link_FLHYCYAKON_blank();
    }
    return l_bResult;
  }
  void Link_FLHYCYAKON_blank() {
    w_AMMONT = "";
    w_RIMP = 0;
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
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",50,0),m_cServer_tbareegeog,w_AREAGEO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbareegeog,"select CODICE,DESCRI from "+m_cPhName_tbareegeog+((m_cPhName_tbareegeog).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_xdescareag = l_rsLink.GetString("DESCRI");
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
  }
  protected boolean Link_MDMTUJRAZF() {
    return Link_MDMTUJRAZF("Full");
  }
  protected boolean Link_MDMTUJRAZF(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_AREAGEO,"C",5,0),m_cServer_tbareegeog_p,w_AREAGEO);
      if (m_Ctx.IsSharedTemp("tbareegeog_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbareegeog_p,"select CODICE,RISCHIO from "+m_cPhName_tbareegeog_p+((m_cPhName_tbareegeog_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_AREAGEO = l_rsLink.GetString("CODICE");
          w_RAREA = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_MDMTUJRAZF_blank();
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
      Link_MDMTUJRAZF_blank();
    }
    return l_bResult;
  }
  void Link_MDMTUJRAZF_blank() {
    w_AREAGEO = "";
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
      l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",200,0),m_cServer_tbsvolgim,w_MODSVOL);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsvolgim,"select CODICE,DESCRI from "+m_cPhName_tbsvolgim+((m_cPhName_tbsvolgim).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MODSVOL = l_rsLink.GetString("CODICE");
          w_xdescmodsvo = l_rsLink.GetString("DESCRI");
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
  }
  protected boolean Link_ZKJUEEUNAK() {
    return Link_ZKJUEEUNAK("Full");
  }
  protected boolean Link_ZKJUEEUNAK(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MODSVOL,"C",5,0),m_cServer_tbsvolgim_p,w_MODSVOL);
      if (m_Ctx.IsSharedTemp("tbsvolgim_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbsvolgim_p,"select CODICE,RISCHIO from "+m_cPhName_tbsvolgim_p+((m_cPhName_tbsvolgim_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MODSVOL = l_rsLink.GetString("CODICE");
          w_RCOMP = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZKJUEEUNAK_blank();
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
      Link_ZKJUEEUNAK_blank();
    }
    return l_bResult;
  }
  void Link_ZKJUEEUNAK_blank() {
    w_MODSVOL = "";
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
      l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",200,0),m_cServer_tbplauso,w_RAGIO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbplauso,"select CODICE,DESCRI from "+m_cPhName_tbplauso+((m_cPhName_tbplauso).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAGIO = l_rsLink.GetString("CODICE");
          w_xdescplauso = l_rsLink.GetString("DESCRI");
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
  }
  protected boolean Link_EAWVSIWQBM() {
    return Link_EAWVSIWQBM("Full");
  }
  protected boolean Link_EAWVSIWQBM(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAGIO,"C",5,0),m_cServer_tbplauso_p,w_RAGIO);
      if (m_Ctx.IsSharedTemp("tbplauso_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbplauso_p,"select CODICE,RISCHIO from "+m_cPhName_tbplauso_p+((m_cPhName_tbplauso_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAGIO = l_rsLink.GetString("CODICE");
          w_RRAGIO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_EAWVSIWQBM_blank();
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
      Link_EAWVSIWQBM_blank();
    }
    return l_bResult;
  }
  void Link_EAWVSIWQBM_blank() {
    w_RAGIO = "";
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",5,0),m_cServer_tbtiporisc,w_TIPO);
      if (m_Ctx.IsSharedTemp("tbtiporisc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",100,0),m_cServer_tbtiporisc,w_TIPO);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbtiporisc,"select CODICE,DESCRI from "+m_cPhName_tbtiporisc+((m_cPhName_tbtiporisc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPO = l_rsLink.GetString("CODICE");
          w_xdesctipor = l_rsLink.GetString("DESCRI");
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
  }
  protected boolean Link_DTDVSGUEWE() {
    return Link_DTDVSGUEWE("Full");
  }
  protected boolean Link_DTDVSGUEWE(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",2,0),m_cServer_tbtiporisc_p,w_TIPO);
      if (m_Ctx.IsSharedTemp("tbtiporisc_p")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtiporisc_p,"select CODICE,RISCHIO from "+m_cPhName_tbtiporisc_p+((m_cPhName_tbtiporisc_p).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPO = l_rsLink.GetString("CODICE");
          w_RTIPO = l_rsLink.GetDouble("RISCHIO");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DTDVSGUEWE_blank();
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
      Link_DTDVSGUEWE_blank();
    }
    return l_bResult;
  }
  void Link_DTDVSGUEWE_blank() {
    w_TIPO = "";
    w_RTIPO = 0;
  }
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
  protected boolean Link_HBPZQIPSZE() {
    return Link_HBPZQIPSZE("Full");
  }
  protected boolean Link_HBPZQIPSZE(String p_cType) {
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
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODDIPE = l_rsLink.GetString("CODDIP");
          w_xDESDIPE = l_rsLink.GetString("DESCRIZ");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_HBPZQIPSZE_blank();
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
      Link_HBPZQIPSZE_blank();
    }
    return l_bResult;
  }
  void Link_HBPZQIPSZE_blank() {
    w_CODDIPE = "";
    w_xDESDIPE = "";
  }
  protected boolean Link_SSYXHQXJLD() {
    return Link_SSYXHQXJLD("Full");
  }
  protected boolean Link_SSYXHQXJLD(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_MACODICE))) {
      String l_OldValue = w_MACODICE;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",5,0),m_cServer_tbmacage,w_MACODICE);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MACODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",60,0),m_cServer_tbmacage,w_MACODICE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbmacage,"select MACODICE,MADESCRI from "+m_cPhName_tbmacage+((m_cPhName_tbmacage).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"MADESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_MACODICE = l_rsLink.GetString("MACODICE");
          w_xMADESCRI = l_rsLink.GetString("MADESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_SSYXHQXJLD_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_MACODICE = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","MACODICE");
          }
          m_cLastWorkVarError = "MACODICE";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_SSYXHQXJLD_blank();
    }
    return l_bResult;
  }
  void Link_SSYXHQXJLD_blank() {
    w_MACODICE = "";
    w_xMADESCRI = "";
  }
  protected boolean Link_UYHOJSIFEU() {
    return Link_UYHOJSIFEU("Full");
  }
  protected boolean Link_UYHOJSIFEU(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_CODICELR))) {
      String l_OldValue = w_CODICELR;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODICELR,"C",16,0),m_cServer_personbo,w_CODICELR);
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
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODICELR,"C",70,0),m_cServer_personbo,w_CODICELR);
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
          w_CODICELR = l_rsLink.GetString("CONNES");
          w_xRAGLEG = l_rsLink.GetString("RAGSOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_UYHOJSIFEU_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CODICELR = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CODICELR");
          }
          m_cLastWorkVarError = "CODICELR";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_UYHOJSIFEU_blank();
    }
    return l_bResult;
  }
  void Link_UYHOJSIFEU_blank() {
    w_CODICELR = "";
    w_xRAGLEG = "";
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
  public boolean Set_DESCRAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCRAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPORAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPORAP = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPORAP = "";
    }
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
  public boolean Set_ISOAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ISOAGE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_ISOAGE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean QBUCLWUNFT_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_TIPOAG,"96") || CPLib.eq(w_TIPOAG,"97");
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
  public boolean Set_FLAGLIRE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLAGLIRE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_FLAGLIRE = "";
    }
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_RUMXLFCOKA();
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
  public boolean Set_IBAN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IBAN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODOGG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODOGG = p_workVariableValue;
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DURAT = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AMMONT = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MODSVOL = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAGIO = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPO = "";
    }
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
  public boolean Set_RISGLOB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RISGLOB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAPROF(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAPROF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAREVPROF(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAREVPROF = p_workVariableValue;
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
  public boolean Set_NOCANC(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOCANC = p_workVariableValue;
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
    l_bResult = Link_HBPZQIPSZE();
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
  public boolean Set_MACODICE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MACODICE = p_workVariableValue;
    l_bResult = Link_SSYXHQXJLD();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MACODICE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SPLITCODE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SPLITCODE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODICELR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODICELR = p_workVariableValue;
    l_bResult = Link_UYHOJSIFEU();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODICELR = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_CODDIPE() {
    return  ! (Utilities.Make(m_Ctx).IsInGroup(3));
  }
  public boolean getVisible_ISOAGE() {
    return CPLib.ne(w_TIPOAG,"96") && CPLib.ne(w_TIPOAG,"97");
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
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE)) {
      Calculation_LMOPUUAIMR();
    }
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE) || CPLib.ne(o_VALUTA,w_VALUTA)) {
      l_bTmpRes = Link_RUMXLFCOKA();
    }
    if (CPLib.ne(o_DURAT,w_DURAT)) {
      l_bTmpRes = Link_VEAKSOSZMJ();
    }
    if (CPLib.ne(o_AMMONT,w_AMMONT)) {
      l_bTmpRes = Link_FLHYCYAKON();
    }
    if (CPLib.ne(o_AREAGEO,w_AREAGEO)) {
      l_bTmpRes = Link_MDMTUJRAZF();
    }
    if (CPLib.ne(o_MODSVOL,w_MODSVOL)) {
      l_bTmpRes = Link_ZKJUEEUNAK();
    }
    if (CPLib.ne(o_RAGIO,w_RAGIO)) {
      l_bTmpRes = Link_EAWVSIWQBM();
    }
    if (CPLib.ne(o_TIPO,w_TIPO)) {
      l_bTmpRes = Link_DTDVSGUEWE();
    }
    if (CPLib.ne(o_CATEG01,w_CATEG01) || CPLib.ne(o_CATEG02,w_CATEG02) || CPLib.ne(o_CATEG03,w_CATEG03) || CPLib.ne(o_CATEG04,w_CATEG04) || CPLib.ne(o_CATEG05,w_CATEG05)) {
      w_CATEGORIA = fwfn_calc_categoriaR.Make(m_Ctx,this).Run(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
    }
    w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari (AUI)":"Rapporti Continuativi (AUI)")+" - "+CPLib.LRTrim(w_RAPPORTO)+"-"+CPLib.LRTrim(w_DESCRAP);
    w_mess = "Messaggio\\nSecondo\\nTerzo";
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
  void Calculation_LMOPUUAIMR() {
    w_VALUTA = (CPLib.eq(w_FLAGLIRE,"L")?"018":(CPLib.eq(w_FLAGLIRE,"E")?"242":""));
  }
  void Calculation_XEYBWIHFFE() {
    arrt_numopecollR l_oRoutine_arrt_numopecoll;
    l_oRoutine_arrt_numopecoll = arrt_numopecollR.Make(m_Ctx,this);
    l_oRoutine_arrt_numopecoll.pTipo = "D";
    l_oRoutine_arrt_numopecoll.Run();
  }
  void Calculation_OEZVQSLBRM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "ANARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
    arrt_ae_agg_aetestaR l_oRoutine_arrt_ae_agg_aetesta;
    l_oRoutine_arrt_ae_agg_aetesta = arrt_ae_agg_aetestaR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta.w_TIPOOPRAP = "";
    l_oRoutine_arrt_ae_agg_aetesta.w_NUMPROG = "";
    l_oRoutine_arrt_ae_agg_aetesta.w_DATAOPE = CPLib.NullDate();
    l_oRoutine_arrt_ae_agg_aetesta.w_closeall = "N";
    l_oRoutine_arrt_ae_agg_aetesta.Run();
  }
  void Calculation_KGBNFVNJHO() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "ANARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "ANARAPBO";
    l_oRoutine_arrt_writelog.pChiave = w_RAPPORTO;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_DFZSPGVPHX() {
    arrt_knarapboR l_oRoutine_arrt_knarapbo;
    l_oRoutine_arrt_knarapbo = arrt_knarapboR.Make(m_Ctx,this);
    l_oRoutine_arrt_knarapbo.pTipo = "D";
    l_oRoutine_arrt_knarapbo.pOper = "I";
    l_oRoutine_arrt_knarapbo.Run();
  }
  void Calculation_MDBTHEOWAB() {
    arrt_knarapboR l_oRoutine_arrt_knarapbo;
    l_oRoutine_arrt_knarapbo = arrt_knarapboR.Make(m_Ctx,this);
    l_oRoutine_arrt_knarapbo.pTipo = "D";
    l_oRoutine_arrt_knarapbo.pOper = "U";
    l_oRoutine_arrt_knarapbo.Run();
  }
  void Calculation_WVQZABBQGF() {
    arrt_knarapboR l_oRoutine_arrt_knarapbo;
    l_oRoutine_arrt_knarapbo = arrt_knarapboR.Make(m_Ctx,this);
    l_oRoutine_arrt_knarapbo.pTipo = "D";
    l_oRoutine_arrt_knarapbo.pOper = "D";
    l_oRoutine_arrt_knarapbo.Run();
  }
  void Calculation_GUQDVKITTU() {
    w_CODDIP = w_gCodDip;
  }
  void Calculation_IXFNYZEOIT() {
    arfn_chkrapportoR l_oRoutine_arfn_chkrapporto;
    l_oRoutine_arfn_chkrapporto = arfn_chkrapportoR.Make(m_Ctx,this);
    l_oRoutine_arfn_chkrapporto.pRapporto = w_RAPPORTO;
    l_oRoutine_arfn_chkrapporto.Run();
  }
  void Calculation_OISCNQOBOK() {
    arrt_ae_agg_aetesta_anarapR l_oRoutine_arrt_ae_agg_aetesta_anarap;
    l_oRoutine_arrt_ae_agg_aetesta_anarap = arrt_ae_agg_aetesta_anarapR.Make(m_Ctx,this);
    l_oRoutine_arrt_ae_agg_aetesta_anarap.pRif = "A";
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_RAPPORTO = w_RAPPORTO;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_DESCRAP = w_DESCRAP;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_TIPORAP = w_TIPORAP;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_TIPOAG = w_TIPOAG;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_VALUTA = w_VALUTA;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.w_NOPROT = w_NOPROT;
    l_oRoutine_arrt_ae_agg_aetesta_anarap.Run();
  }
  void Calculation_LQFWQMTCLB() {
    arrt_storico_rapportiR l_oRoutine_arrt_storico_rapporti;
    l_oRoutine_arrt_storico_rapporti = arrt_storico_rapportiR.Make(m_Ctx,this);
    l_oRoutine_arrt_storico_rapporti.Run();
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
  public final static String[] m_KeyColumns = {"RAPPORTO"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_anarap","anarapbo",m_KeyColumns,m_Ctx);
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
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
    w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
    w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
    w_CODDIP = "";
    w_RAPPORTO = "";
    w_DESCRAP = "";
    w_TIPORAP = "";
    w_TIPOAG = "";
    w_ISOAGE = "";
    w_NOPROT = 0;
    w_FLAGLIRE = "";
    w_VALUTA = "";
    w_PRGIMPRAP = 0;
    w_descval = "";
    w_IBAN = "";
    w_CODOGG = "";
    w_daticoll = 0;
    w_NATURA = "";
    w_SCOPO = "";
    w_DURAT = "";
    w_DURAT = "";
    w_RFREQ = 0;
    w_AMMONT = "";
    w_AMMONT = "";
    w_RIMP = 0;
    w_AREAGEO = "";
    w_AREAGEO = "";
    w_RAREA = 0;
    w_MODSVOL = "";
    w_MODSVOL = "";
    w_RCOMP = 0;
    w_RAGIO = "";
    w_RAGIO = "";
    w_RRAGIO = 0;
    w_TIPO = "";
    w_TIPO = "";
    w_RTIPO = 0;
    w_xdescmodsvo = "";
    w_xdescareag = "";
    w_xdescplauso = "";
    w_xdesctipor = "";
    w_xdescfreq = "";
    w_xdescammo = "";
    w_RISGLOB = "";
    w_DATAPROF = CPLib.NullDate();
    w_DATAREVPROF = CPLib.NullDate();
    w_MITIG = 0;
    w_MITGDOC = "";
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
    w_titolo = "";
    w_NOCANC = 0;
    w_mess = "";
    w_xMADESCRI = "";
    w_xRAGLEG = "";
    w_xDESDIPE = "";
    w_CODDIPE = "";
    w_MACODICE = "";
    w_SPLITCODE = "";
    w_CODICELR = "";
    m_cWv_ardt_garantbo = "";
    m_cWv_ardt_ae_saldianno_rap = "";
    m_cWv_ardt_saldi_idp = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CODDIP = CPLib.GetProperty(p,"CODDIP",w_CODDIP,0);
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_DESCRAP = CPLib.GetProperty(p,"DESCRAP",w_DESCRAP,0);
      w_TIPORAP = CPLib.GetProperty(p,"TIPORAP",w_TIPORAP,0);
      w_TIPOAG = CPLib.GetProperty(p,"TIPOAG",w_TIPOAG,0);
      w_ISOAGE = CPLib.GetProperty(p,"ISOAGE",w_ISOAGE,0);
      w_NOPROT = CPLib.GetProperty(p,"NOPROT",w_NOPROT,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_PRGIMPRAP = CPLib.GetProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
      op_PRGIMPRAP = CPLib.GetProperty(p,"op_PRGIMPRAP",0,0);
      w_IBAN = CPLib.GetProperty(p,"IBAN",w_IBAN,0);
      w_CODOGG = CPLib.GetProperty(p,"CODOGG",w_CODOGG,0);
      w_NATURA = CPLib.GetProperty(p,"NATURA",w_NATURA,0);
      w_SCOPO = CPLib.GetProperty(p,"SCOPO",w_SCOPO,0);
      w_DURAT = CPLib.GetProperty(p,"DURAT",w_DURAT,0);
      w_RFREQ = CPLib.GetProperty(p,"RFREQ",w_RFREQ,0);
      w_AMMONT = CPLib.GetProperty(p,"AMMONT",w_AMMONT,0);
      w_RIMP = CPLib.GetProperty(p,"RIMP",w_RIMP,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_MODSVOL = CPLib.GetProperty(p,"MODSVOL",w_MODSVOL,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_RAGIO = CPLib.GetProperty(p,"RAGIO",w_RAGIO,0);
      w_RRAGIO = CPLib.GetProperty(p,"RRAGIO",w_RRAGIO,0);
      w_TIPO = CPLib.GetProperty(p,"TIPO",w_TIPO,0);
      w_RTIPO = CPLib.GetProperty(p,"RTIPO",w_RTIPO,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_RISGLOB = CPLib.GetProperty(p,"RISGLOB",w_RISGLOB,0);
      w_DATAPROF = CPLib.GetProperty(p,"DATAPROF",w_DATAPROF,0);
      w_DATAREVPROF = CPLib.GetProperty(p,"DATAREVPROF",w_DATAREVPROF,0);
      w_MITIG = CPLib.GetProperty(p,"MITIG",w_MITIG,0);
      w_MITGDOC = CPLib.GetProperty(p,"MITGDOC",w_MITGDOC,0);
      w_CATEG01 = CPLib.GetProperty(p,"CATEG01",w_CATEG01,0);
      w_CATEG02 = CPLib.GetProperty(p,"CATEG02",w_CATEG02,0);
      w_CATEG03 = CPLib.GetProperty(p,"CATEG03",w_CATEG03,0);
      w_CATEG04 = CPLib.GetProperty(p,"CATEG04",w_CATEG04,0);
      w_CATEG05 = CPLib.GetProperty(p,"CATEG05",w_CATEG05,0);
      w_CATEGORIA = CPLib.GetProperty(p,"CATEGORIA",w_CATEGORIA,0);
      w_NOCANC = CPLib.GetProperty(p,"NOCANC",w_NOCANC,0);
      w_MACODICE = CPLib.GetProperty(p,"MACODICE",w_MACODICE,0);
      w_SPLITCODE = CPLib.GetProperty(p,"SPLITCODE",w_SPLITCODE,0);
      w_CODICELR = CPLib.GetProperty(p,"CODICELR",w_CODICELR,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_gBrowser = CPLib.GetProperty(p,"gBrowser",w_gBrowser,0);
      w_gTelepass = CPLib.GetProperty(p,"gTelepass",w_gTelepass,0);
      w_gCodDip = CPLib.GetProperty(p,"gCodDip",w_gCodDip,0);
      w_descval = CPLib.GetProperty(p,"descval",w_descval,0);
      w_daticoll = CPLib.GetProperty(p,"daticoll",w_daticoll,0);
      w_xdescmodsvo = CPLib.GetProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescplauso = CPLib.GetProperty(p,"xdescplauso",w_xdescplauso,0);
      w_xdesctipor = CPLib.GetProperty(p,"xdesctipor",w_xdesctipor,0);
      w_xdescfreq = CPLib.GetProperty(p,"xdescfreq",w_xdescfreq,0);
      w_xdescammo = CPLib.GetProperty(p,"xdescammo",w_xdescammo,0);
      w_xDESDIPE = CPLib.GetProperty(p,"xDESDIPE",w_xDESDIPE,0);
      w_xMADESCRI = CPLib.GetProperty(p,"xMADESCRI",w_xMADESCRI,0);
      w_xRAGLEG = CPLib.GetProperty(p,"xRAGLEG",w_xRAGLEG,0);
      w_mess = CPLib.GetProperty(p,"mess",w_mess,0);
      w_xC1DESCRI = CPLib.GetProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
      w_xC2DESCRI = CPLib.GetProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
      w_xC3DESCRI = CPLib.GetProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
      w_xC4DESCRI = CPLib.GetProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
      w_xC5DESCRI = CPLib.GetProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
      w_titolo = CPLib.GetProperty(p,"titolo",w_titolo,0);
      m_cWv_ardt_garantbo = CPLib.GetProperty(p,"m_cWv_ardt_garantbo",m_cWv_ardt_garantbo,0);
      m_cWv_ardt_ae_saldianno_rap = CPLib.GetProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
      m_cWv_ardt_saldi_idp = CPLib.GetProperty(p,"m_cWv_ardt_saldi_idp",m_cWv_ardt_saldi_idp,0);
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
    items = tables.get("tbdurata_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbdurata_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_DURAT","w_RFREQ"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbdurata_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbimporto_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbimporto_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_AMMONT","w_RIMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbimporto_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbareegeog_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbareegeog_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_AREAGEO","w_RAREA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbareegeog_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbsvolgim_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbsvolgim_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_MODSVOL","w_RCOMP"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsvolgim_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbplauso_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbplauso_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_RAGIO","w_RRAGIO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbplauso_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtiporisc_p");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtiporisc_p",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODICE","RISCHIO"});
    map.put("rd_var",new String[]{"w_TIPO","w_RTIPO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u00003",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtiporisc_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("garantbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("garantbo",items);
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
    map.put("property.value",zeroSplit.split("garantbo\u0000false\u0000false\u00001\u00000\u0000ardt_garantbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
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
    map.put("rd_var.comment",new String[]{""});
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
    items = tables.get("saldi_idp");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("saldi_idp",items);
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
    map.put("property.value",zeroSplit.split("saldi_idp\u0000false\u0000false\u00001\u00000\u0000ardt_saldi_idp\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_VALUTA","w_descval"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Divisa\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbvalute\u0000false\u0000false\u00002\u00000\u0000armt_divise\u0000false\u0000false\u0000Valute\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
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
    map = new HashMap<String,String[]>();
    items = tables.get("anadip");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("anadip",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ"});
    map.put("rd_var",new String[]{"w_CODDIPE","w_xDESDIPE"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Dipendeza Riferimento\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00001\u00000\u0000armt_anadip\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbmacage");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbmacage",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"MACODICE","MADESCRI"});
    map.put("rd_var",new String[]{"w_MACODICE","w_xMADESCRI"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("5\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Macro Agente\u0000Denominazione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbmacage\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Marco Agenti\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_CODICELR","w_xRAGLEG"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Legale Rappresentante\u0000Ragione Sociale",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("personbo\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Soggetti\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_anarap",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_anarap",child);
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
    ardt_garantbo = new ardt_garantboBO(m_Ctx);
    ardt_ae_saldianno_rap = new ardt_ae_saldianno_rapBO(m_Ctx);
    ardt_saldi_idp = new ardt_saldi_idpBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_anarap",m_Ctx);
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
    if (CPLib.Empty(w_TIPORAP)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPORAP));
      String obblMsgError = m_Ctx.Translate("Tipo Rapporto")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPORAP = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPORAP";
      }
    } else if (CPLib.Empty(w_ISOAGE) && QBUCLWUNFT_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_ISOAGE));
      String obblMsgError = m_Ctx.Translate("Per tipo rapporto 96/97")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_ISOAGE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "ISOAGE";
      }
    } else if (CPLib.Empty(w_FLAGLIRE)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_FLAGLIRE));
      String obblMsgError = m_Ctx.Translate("Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_FLAGLIRE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "FLAGLIRE";
      }
    } else if (CPLib.Empty(w_VALUTA)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_VALUTA));
      String obblMsgError = m_Ctx.Translate("Codice Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_VALUTA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "VALUTA";
      }
    }
    if (l_bResult && (( ! (ardt_garantbo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_garantbo)) || ( ! (ardt_garantbo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_garantbo)))) {
      ardt_garantbo.SetFromContext(m_cWv_ardt_garantbo);
      m_cWv_ardt_garantbo = "_not_empty_";
    }
    if (l_bResult && (ardt_garantbo.m_bLoaded || ardt_garantbo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_garantbo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_garantbo.m_cLastMsgError;
      }
    }
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
    if (l_bResult && (( ! (ardt_saldi_idp.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_saldi_idp)) || ( ! (ardt_saldi_idp.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_saldi_idp)))) {
      ardt_saldi_idp.SetFromContext(m_cWv_ardt_saldi_idp);
      m_cWv_ardt_saldi_idp = "_not_empty_";
    }
    if (l_bResult && (ardt_saldi_idp.m_bLoaded || ardt_saldi_idp.m_bUpdated)) {
      l_bResult = l_bResult && ardt_saldi_idp.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_saldi_idp.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_anarap"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_anarap\\"+p_cState};
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
    w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_anarapbo);
    op_codazi = m_Ctx.GetCompany();
    op_PRGIMPRAP = w_PRGIMPRAP;
  }
  void UpdateAutonumber() {
    // le l_bx memorizzano le condizione di aggiornamento degli autonumber 
    // >prima< di modificari i valori degli op_
    boolean l_b0;
    l_b0 =  ! (CPLib.eq(op_codazi,m_Ctx.GetCompany()));
    if (l_b0) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PRGIMPRAP = m_Ctx.AskTableProg(w_PRGIMPRAP,15,op_PRGIMPRAP,"PRGIMPRAP"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_anarapbo);
      op_codazi = m_Ctx.GetCompany();
      op_PRGIMPRAP = w_PRGIMPRAP;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_PRGIMPRAP = 0;
    // Inizializzazione delle variabili per DependsOn
    o_TIPOAG = "";
    o_FLAGLIRE = "";
    o_VALUTA = "";
    o_DURAT = "";
    o_AMMONT = "";
    o_AREAGEO = "";
    o_MODSVOL = "";
    o_RAGIO = "";
    o_TIPO = "";
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
    CPLib.PutProperty(p,"CODDIP",w_CODDIP,0);
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"DESCRAP",w_DESCRAP,0);
    CPLib.PutProperty(p,"TIPORAP",w_TIPORAP,0);
    CPLib.PutProperty(p,"TIPOAG",w_TIPOAG,0);
    CPLib.PutProperty(p,"ISOAGE",w_ISOAGE,0);
    CPLib.PutProperty(p,"NOPROT",w_NOPROT,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"PRGIMPRAP",w_PRGIMPRAP,0);
    CPLib.PutProperty(p,"op_PRGIMPRAP",op_PRGIMPRAP,0);
    CPLib.PutProperty(p,"IBAN",w_IBAN,0);
    CPLib.PutProperty(p,"CODOGG",w_CODOGG,0);
    CPLib.PutProperty(p,"NATURA",w_NATURA,0);
    CPLib.PutProperty(p,"SCOPO",w_SCOPO,0);
    CPLib.PutProperty(p,"DURAT",w_DURAT,0);
    CPLib.PutProperty(p,"RFREQ",w_RFREQ,0);
    CPLib.PutProperty(p,"AMMONT",w_AMMONT,0);
    CPLib.PutProperty(p,"RIMP",w_RIMP,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"MODSVOL",w_MODSVOL,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"RAGIO",w_RAGIO,0);
    CPLib.PutProperty(p,"RRAGIO",w_RRAGIO,0);
    CPLib.PutProperty(p,"TIPO",w_TIPO,0);
    CPLib.PutProperty(p,"RTIPO",w_RTIPO,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"RISGLOB",w_RISGLOB,0);
    CPLib.PutProperty(p,"DATAPROF",w_DATAPROF,0);
    CPLib.PutProperty(p,"DATAREVPROF",w_DATAREVPROF,0);
    CPLib.PutProperty(p,"MITIG",w_MITIG,0);
    CPLib.PutProperty(p,"MITGDOC",w_MITGDOC,0);
    CPLib.PutProperty(p,"CATEG01",w_CATEG01,0);
    CPLib.PutProperty(p,"CATEG02",w_CATEG02,0);
    CPLib.PutProperty(p,"CATEG03",w_CATEG03,0);
    CPLib.PutProperty(p,"CATEG04",w_CATEG04,0);
    CPLib.PutProperty(p,"CATEG05",w_CATEG05,0);
    CPLib.PutProperty(p,"CATEGORIA",w_CATEGORIA,0);
    CPLib.PutProperty(p,"NOCANC",w_NOCANC,0);
    CPLib.PutProperty(p,"MACODICE",w_MACODICE,0);
    CPLib.PutProperty(p,"SPLITCODE",w_SPLITCODE,0);
    CPLib.PutProperty(p,"CODICELR",w_CODICELR,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"gBrowser",w_gBrowser,0);
    CPLib.PutProperty(p,"gTelepass",w_gTelepass,0);
    CPLib.PutProperty(p,"gCodDip",w_gCodDip,0);
    CPLib.PutProperty(p,"descval",w_descval,0);
    CPLib.PutProperty(p,"daticoll",w_daticoll,0);
    CPLib.PutProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescplauso",w_xdescplauso,0);
    CPLib.PutProperty(p,"xdesctipor",w_xdesctipor,0);
    CPLib.PutProperty(p,"xdescfreq",w_xdescfreq,0);
    CPLib.PutProperty(p,"xdescammo",w_xdescammo,0);
    CPLib.PutProperty(p,"xDESDIPE",w_xDESDIPE,0);
    CPLib.PutProperty(p,"xMADESCRI",w_xMADESCRI,0);
    CPLib.PutProperty(p,"xRAGLEG",w_xRAGLEG,0);
    CPLib.PutProperty(p,"mess",w_mess,0);
    CPLib.PutProperty(p,"xC1DESCRI",w_xC1DESCRI,0);
    CPLib.PutProperty(p,"xC2DESCRI",w_xC2DESCRI,0);
    CPLib.PutProperty(p,"xC3DESCRI",w_xC3DESCRI,0);
    CPLib.PutProperty(p,"xC4DESCRI",w_xC4DESCRI,0);
    CPLib.PutProperty(p,"xC5DESCRI",w_xC5DESCRI,0);
    CPLib.PutProperty(p,"titolo",w_titolo,0);
    if (p_bGetChildren) {
      if (ardt_garantbo.IsUpdated()) {
        m_cWv_ardt_garantbo = ardt_garantbo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_garantbo",m_cWv_ardt_garantbo,0);
    }
    if (p_bGetChildren) {
      if (ardt_ae_saldianno_rap.IsUpdated()) {
        m_cWv_ardt_ae_saldianno_rap = ardt_ae_saldianno_rap.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_ae_saldianno_rap",m_cWv_ardt_ae_saldianno_rap,0);
    }
    if (p_bGetChildren) {
      if (ardt_saldi_idp.IsUpdated()) {
        m_cWv_ardt_saldi_idp = ardt_saldi_idp.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_saldi_idp",m_cWv_ardt_saldi_idp,0);
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
    return "anarapbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("RAPPORTO","C",25,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PRGIMPRAP");
    oneAutoNum.add("PRGIMPRAP");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_garantbo() {
    if (ardt_garantbo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_garantbo) || CPLib.IsLoaded(m_cWv_ardt_garantbo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_garantbo.m_bLoaded)) {
      ardt_garantbo.Blank();
      ardt_garantbo.w_RAPPORTO = w_RAPPORTO;
      ardt_garantbo.Load();
    }
    return ardt_garantbo.m_bLoaded;
  }
  public void CtxLoad_ardt_garantbo() {
    if ( ! (ardt_garantbo.m_lCtxLoaded)) {
      ardt_garantbo.Blank();
    }
    ardt_garantbo.m_lCtxLoaded = true;
    if ( ! (ardt_garantbo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_garantbo) || CPLib.IsLoaded(m_cWv_ardt_garantbo)) {
        ardt_garantbo.SetFromContext(m_cWv_ardt_garantbo);
        m_cWv_ardt_garantbo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_garantbo.m_bLoaded)) {
          ardt_garantbo.Blank();
          ardt_garantbo.w_RAPPORTO = w_RAPPORTO;
          ardt_garantbo.Load();
          if ( ! (ardt_garantbo.m_bLoaded)) {
            ardt_garantbo.Initialize();
            ardt_garantbo.SetUpdated();
          }
        }
      }
    }
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
  public boolean ChildExists_ardt_saldi_idp() {
    if (ardt_saldi_idp.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_saldi_idp) || CPLib.IsLoaded(m_cWv_ardt_saldi_idp))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_saldi_idp.m_bLoaded)) {
      ardt_saldi_idp.Blank();
      ardt_saldi_idp.w_RAPPORTO = w_RAPPORTO;
      ardt_saldi_idp.Load();
    }
    return ardt_saldi_idp.m_bLoaded;
  }
  public void CtxLoad_ardt_saldi_idp() {
    if ( ! (ardt_saldi_idp.m_lCtxLoaded)) {
      ardt_saldi_idp.Blank();
    }
    ardt_saldi_idp.m_lCtxLoaded = true;
    if ( ! (ardt_saldi_idp.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_saldi_idp) || CPLib.IsLoaded(m_cWv_ardt_saldi_idp)) {
        ardt_saldi_idp.SetFromContext(m_cWv_ardt_saldi_idp);
        m_cWv_ardt_saldi_idp = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_saldi_idp.m_bLoaded)) {
          ardt_saldi_idp.Blank();
          ardt_saldi_idp.w_RAPPORTO = w_RAPPORTO;
          ardt_saldi_idp.Load();
          if ( ! (ardt_saldi_idp.m_bLoaded)) {
            ardt_saldi_idp.Initialize();
            ardt_saldi_idp.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_garantbo")) {
      CtxLoad_ardt_garantbo();
      return ardt_garantbo;
    }
    if (CPLib.eq(p_cName,"ardt_ae_saldianno_rap")) {
      CtxLoad_ardt_ae_saldianno_rap();
      return ardt_ae_saldianno_rap;
    }
    if (CPLib.eq(p_cName,"ardt_saldi_idp")) {
      CtxLoad_ardt_saldi_idp();
      return ardt_saldi_idp;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
