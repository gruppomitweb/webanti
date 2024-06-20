import java.util.*;

public class armt_ofrazionateBL extends armt_ofrazionateWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_ofrazionate";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public CPPhTableWrInfo m_oWrInfo_fraziobo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_fraziobo;
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
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public CPPhTableWrInfo m_oWrInfo_xnarapbo;
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
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
  public CPPhTableWrInfo m_oWrInfo_tbrisglob;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"fraziobo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'IDBASE':IDBASE,'CODDIPE':CODDIPE,'DATAOPE':DATAOPE,'DATAREG':DATAREG,'FLAGFRAZ':FLAGFRAZ,'TIPOOPRAP':TIPOOPRAP,'idcauana':idcauana,'appolire':appolire,'VALUTA':VALUTA,'xTOTLIRE':xTOTLIRE,'FLAGCONT':FLAGCONT,'xTOTCONT':xTOTCONT,'CAMBIO':CAMBIO,'IMPIN':IMPIN,'IMPOUT':IMPOUT,'RAPPORTO':RAPPORTO,'CONNESCLI':CONNESCLI,'PROQUOTA':PROQUOTA,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'PAGASOGOP':PAGASOGOP,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'C_RAG':C_RAG,'C_CTA':C_CTA,'C_PRV':C_PRV,'C_CAP':C_CAP,'C_CAB':C_CAB,'C_IND':C_IND,'C_STA':C_STA,'TIPOINT2':TIPOINT2,'CODINT2':CODINT2,'DESCINTER':DESCINTER,'PAESE':PAESE,'C_RAPPORTO':C_RAPPORTO,'CODCAB2':CODCAB2,'DESC2':DESC2,'PROV2':PROV2,'ZCPARTE':ZCPARTE,'STATOREG':STATOREG,'DATARETT':DATARETT,'NOSARA':NOSARA,'CALCOLI':CALCOLI,'COMPLETA':COMPLETA,'ardt_clientifrz':ardt_clientifrz,'ardt_mlientifrz':ardt_mlientifrz,'ardt_sogopefraz':ardt_sogopefraz,'ardt_mogopefbo':ardt_mogopefbo,'ardt_meneficfrz':ardt_meneficfrz,'ardt_beneficfrz':ardt_beneficfrz,'ardt_terzistifrz':ardt_terzistifrz,'ardt_merzistifrz':ardt_merzistifrz,'NOPROT':NOPROT,'OPERAG':OPERAG,'RESPINS':RESPINS,'INFORM':INFORM,'NATURA':NATURA,'SCOPO':SCOPO,'SV58550':SV58550,'SV58550MA':SV58550MA,'MEZPAG':MEZPAG,'PRESTAZ':PRESTAZ,'VASP':VASP,'ardt_docfrabo':ardt_docfrabo,'CONNESDOC':CONNESDOC,'MTCN':MTCN,'DURAT':DURAT,'RFREQ':RFREQ,'AMMONT':AMMONT,'RIMP':RIMP,'AREAGEO':AREAGEO,'RAREA':RAREA,'MODSVOL':MODSVOL,'RCOMP':RCOMP,'RAGIO':RAGIO,'RRAGIO':RRAGIO,'TIPO':TIPO,'armt_fraziobo_agg':armt_fraziobo_agg,'RTIPO':RTIPO,'RISGLOB':RISGLOB,'MITIG':MITIG,'MITIGDOC':MITIGDOC,'ardt_frz_contante':ardt_frz_contante"+FoundlingChildrenList("armt_ofrazionate",true)+"}";
  public static final String i_CompleteStateStructure = "{'gIntemediario':gIntemediario,'gChkDate':gChkDate,'gTipInter':gTipInter,'gSblocco':gSblocco,'gFlgWU':gFlgWU,'gStatus':gStatus,'gDataVaria':gDataVaria,'gFlgDoc':gFlgDoc,'gFlgDTP':gFlgDTP,'gSeekAos':gSeekAos,'gVerSim':gVerSim,'dataoggi':dataoggi,'filtro':filtro,'sEdit':sEdit,'test':test,'datpaseuro':datpaseuro,'tipope':tipope,'stringaflagrap2':stringaflagrap2,'IDBASE':IDBASE,'CODINTER':CODINTER,'apporeg':apporeg,'CODDIPE':CODDIPE,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CODCAB':CODCAB,'DATAOPE':DATAOPE,'NUMPROG':NUMPROG,'CDATOPE':CDATOPE,'CDATAOPE':CDATAOPE,'ANNOOPE':ANNOOPE,'DATAREG':DATAREG,'CDATREG':CDATREG,'FLAGFRAZ':FLAGFRAZ,'COLLEG':COLLEG,'TIPOOPRAP':TIPOOPRAP,'idcauana':idcauana,'CODANA':CODANA,'CODVOC':CODVOC,'FLAGLIRE':FLAGLIRE,'appolire':appolire,'VALUTA':VALUTA,'xTOTLIRE':xTOTLIRE,'FLAGCONT':FLAGCONT,'xTOTCONT':xTOTCONT,'CAMBIO':CAMBIO,'IMPIN':IMPIN,'IMPOUT':IMPOUT,'RAPPORTO':RAPPORTO,'CONNESCLI':CONNESCLI,'PROQUOTA':PROQUOTA,'CONNESOPER':CONNESOPER,'TIPOLEG':TIPOLEG,'PAGASOGOP':PAGASOGOP,'CONNESBEN':CONNESBEN,'CONNALTRO':CONNALTRO,'C_RAG':C_RAG,'C_CTA':C_CTA,'C_PRV':C_PRV,'C_CAP':C_CAP,'C_CAB':C_CAB,'C_IND':C_IND,'C_STA':C_STA,'TIPOINT2':TIPOINT2,'CODINT2':CODINT2,'DESCINTER':DESCINTER,'PAESE':PAESE,'C_RAPPORTO':C_RAPPORTO,'CODCAB2':CODCAB2,'DESC2':DESC2,'PROV2':PROV2,'ZCPARTE':ZCPARTE,'STATOREG':STATOREG,'DATARETT':DATARETT,'OPERAZMOD':OPERAZMOD,'xdestipleg':xdestipleg,'xragsocct':xragsocct,'xDescDipe':xDescDipe,'descdiv':descdiv,'TIPOINF':TIPOINF,'valflg2':valflg2,'xragint2':xragint2,'errmsg':errmsg,'CABINT':CABINT,'xragsocper':xragsocper,'desccauana':desccauana,'xragsocben':xragsocben,'xdesccausin':xdesccausin,'xdescpaese2':xdescpaese2,'xdescrap':xdescrap,'xdes1':xdes1,'xcodfisc':xcodfisc,'xdciticon':xdciticon,'dessta':dessta,'xragsocalt':xragsocalt,'xFLGITAEST':xFLGITAEST,'SEGNO':SEGNO,'TOTLIRE':TOTLIRE,'TOTCONT':TOTCONT,'IDEREG':IDEREG,'FLAGRAP':FLAGRAP,'OPRAP':OPRAP,'RAPPORTBEN':RAPPORTBEN,'OPERATORE':OPERATORE,'AUTOM':AUTOM,'FLAGRAP2':FLAGRAP2,'PRGIMPFRZ':PRGIMPFRZ,'CITINT':CITINT,'CITDIP':CITDIP,'PROVDIP':PROVDIP,'CABDIP':CABDIP,'PROVINT':PROVINT,'CONNESDOC':CONNESDOC,'DATAVALI':DATAVALI,'DATARILASC':DATARILASC,'IDBASE2':IDBASE2,'NOSARA':NOSARA,'CALCOLI':CALCOLI,'COMPLETA':COMPLETA,'ardt_clientifrz':ardt_clientifrz,'ardt_mlientifrz':ardt_mlientifrz,'ardt_sogopefraz':ardt_sogopefraz,'ardt_mogopefbo':ardt_mogopefbo,'ardt_meneficfrz':ardt_meneficfrz,'ardt_beneficfrz':ardt_beneficfrz,'ardt_terzistifrz':ardt_terzistifrz,'ardt_merzistifrz':ardt_merzistifrz,'NOPROT':NOPROT,'OPERAG':OPERAG,'xdescopeage':xdescopeage,'RESPINS':RESPINS,'INFORM':INFORM,'NATURA':NATURA,'SCOPO':SCOPO,'SV58550':SV58550,'SV58550MA':SV58550MA,'xdescfreq':xdescfreq,'DURAT':DURAT,'xdescammo':xdescammo,'AMMONT':AMMONT,'xdescareag':xdescareag,'AREAGEO':AREAGEO,'xdescmodsvo':xdescmodsvo,'MODSVOL':MODSVOL,'xdescplauso':xdescplauso,'RAGIO':RAGIO,'xdesctipor':xdesctipor,'TIPO':TIPO,'DUCOLLEG':DUCOLLEG,'ORACOLLEG':ORACOLLEG,'IPCOLLEG':IPCOLLEG,'MEZPAG':MEZPAG,'PRESTAZ':PRESTAZ,'DESPUNTO':DESPUNTO,'CODCLICON':CODCLICON,'TIPATT':TIPATT,'VASP':VASP,'RIFIMP':RIFIMP,'ardt_docfrabo':ardt_docfrabo,'xRAGSOCDOC':xRAGSOCDOC,'IDFILE':IDFILE,'MTCN':MTCN,'RFREQ':RFREQ,'RIMP':RIMP,'RAREA':RAREA,'RCOMP':RCOMP,'RRAGIO':RRAGIO,'armt_fraziobo_agg':armt_fraziobo_agg,'RTIPO':RTIPO,'RISGLOB':RISGLOB,'MITIG':MITIG,'MITIGDOC':MITIGDOC,'ardt_frz_contante':ardt_frz_contante"+FoundlingChildrenList("armt_ofrazionate",true)+"}";
  public static final String i_ItemSequence = "IDBASE,CODDIPE,DATAOPE,DATAREG,FLAGFRAZ,TIPOOPRAP,idcauana,appolire,VALUTA,xTOTLIRE,FLAGCONT,xTOTCONT,CAMBIO,IMPIN,IMPOUT,RAPPORTO,CONNESCLI,PROQUOTA,CONNESOPER,TIPOLEG,PAGASOGOP,CONNESBEN,CONNALTRO,C_RAG,C_CTA,C_PRV,C_CAP,C_CAB,C_IND,C_STA,TIPOINT2,CODINT2,DESCINTER,PAESE,C_RAPPORTO,CODCAB2,DESC2,PROV2,ZCPARTE,STATOREG,DATARETT,NOSARA,CALCOLI,COMPLETA,ardt_clientifrz,ardt_mlientifrz,ardt_sogopefraz,ardt_mogopefbo,ardt_meneficfrz,ardt_beneficfrz,ardt_terzistifrz,ardt_merzistifrz,NOPROT,OPERAG,RESPINS,INFORM,NATURA,SCOPO,SV58550,SV58550MA,MEZPAG,PRESTAZ,VASP,ardt_docfrabo,CONNESDOC,MTCN,DURAT,RFREQ,AMMONT,RIMP,AREAGEO,RAREA,MODSVOL,RCOMP,RAGIO,RRAGIO,TIPO,armt_fraziobo_agg,RTIPO,RISGLOB,MITIG,MITIGDOC,ardt_frz_contante"+FoundlingChildrenList("armt_ofrazionate",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_ofrazionate"),new String[][]{new String[]{"IDBASE","Idbase","C","10","0","campo","key1","false","false"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"DATAOPE","Data Operazione","D","8","0","campo","key2","false","true"},new String[]{"DATAREG","Data registrazione","D","8","0","campo","nokey","false","true"},new String[]{"FLAGFRAZ","Frazionata (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"TIPOOPRAP","Tipo Operazione Completa","C","2","0","campo","nokey","false","false"},new String[]{"idcauana","Causale","C","4","0","campo","nokey","false","true"},new String[]{"appolire","B11. Tipo Divisa","C","1","0","variabile","nokey","false","true"},new String[]{"VALUTA","B12. Divisa","C","3","0","campo","nokey","false","true"},new String[]{"xTOTLIRE","B14. Totale Euro","N","15","2","variabile","nokey","false","true"},new String[]{"FLAGCONT","Contanti (S/N)","C","1","0","campo","nokey","false","false"},new String[]{"xTOTCONT","B15. di cui contanti","N","15","2","variabile","nokey","false","true"},new String[]{"CAMBIO","Cambio","N","9","4","campo","nokey","false","false"},new String[]{"IMPIN","Importo in Entrata","N","15","2","campo","nokey","false","false"},new String[]{"IMPOUT","Importo in Uscita","N","15","2","campo","nokey","false","false"},new String[]{"RAPPORTO","Rapporto Collegato","C","25","0","campo","nokey","false","false"},new String[]{"CONNESCLI","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"PROQUOTA","% Pro Quota","N","3","0","campo","nokey","false","false"},new String[]{"CONNESOPER","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"TIPOLEG","Tipo Legame","C","1","0","campo","nokey","false","true"},new String[]{"PAGASOGOP","","C","1","0","campo","nokey","false","false"},new String[]{"CONNESBEN","Codice Cliente Occasionale","C","16","0","campo","nokey","false","false"},new String[]{"CONNALTRO","","C","16","0","campo","nokey","false","false"},new String[]{"C_RAG","F11. Denominazione Controparte","C","70","0","campo","nokey","false","true"},new String[]{"C_CTA","F14B. Comune Controparte","C","30","0","campo","nokey","false","false"},new String[]{"C_PRV","F14C. Provincia Controparte","C","2","0","campo","nokey","false","false"},new String[]{"C_CAP","F16. CAP Controparte","C","5","0","campo","nokey","false","false"},new String[]{"C_CAB","F14A. CAB Controparte","C","6","0","campo","nokey","false","false"},new String[]{"C_IND","F15. Indirizzo Controparte","C","35","0","campo","nokey","false","false"},new String[]{"C_STA","F13. Stato Controparte","C","3","0","campo","nokey","false","true"},new String[]{"TIPOINT2","A31A. Tipo Intermediario C/Parte","C","2","0","campo","nokey","false","true"},new String[]{"CODINT2","Codice Intermediario C/Parte","C","11","0","campo","nokey","false","false"},new String[]{"DESCINTER","A43. Denominazione Intermediario C/Parte","C","50","0","campo","nokey","false","true"},new String[]{"PAESE","A32. Stato Intermediario C/Parte","C","3","0","campo","nokey","false","true"},new String[]{"C_RAPPORTO","","C","25","0","campo","nokey","false","false"},new String[]{"CODCAB2","A33A. CAB Intermediario C/Parte","C","6","0","campo","nokey","false","true"},new String[]{"DESC2","A33B. Comune Intermediario C/Parte","C","30","0","campo","nokey","false","true"},new String[]{"PROV2","A33C. Provincia Intermediario C/Parte","C","2","0","campo","nokey","false","true"},new String[]{"ZCPARTE","","C","69","0","campo","nokey","false","false"},new String[]{"STATOREG","Stato","C","1","0","campo","nokey","false","false"},new String[]{"DATARETT","Data Rettifica","D","8","0","campo","nokey","false","false"},new String[]{"NOSARA","Escludi operazioni soggetto da SARA","C","1","0","campo","nokey","false","false"},new String[]{"CALCOLI","","L","1","0","variabile","nokey","false","false"},new String[]{"COMPLETA","","L","1","0","variabile","nokey","false","false"},new String[]{"ardt_clientifrz","Intestatari Fraz. ","","","","link_PC","","false",""},new String[]{"ardt_mlientifrz","Intestatari Fraz. (Modifiche)","","","","link_PC","","false",""},new String[]{"ardt_sogopefraz","+ Soggetti Oper. Conto Terzi","","","","link_PC","","false",""},new String[]{"ardt_mogopefbo","+ Soggetti Oper. Conto Terzi","","","","link_PC","","false",""},new String[]{"ardt_meneficfrz","Beneficiari Fraz. (Modifiche)","","","","link_PC","","false",""},new String[]{"ardt_beneficfrz","Beneficiari Frazionate","","","","link_PC","","false",""},new String[]{"ardt_terzistifrz","Terzisti Frazionate","","","","link_PC","","false",""},new String[]{"ardt_merzistifrz","Copy of Terzisti Oper. (Modifiche)","","","","link_PC","","false",""},new String[]{"NOPROT","","N","1","0","campo","nokey","false","false"},new String[]{"OPERAG","","C","3","0","campo","nokey","false","false"},new String[]{"RESPINS","","C","30","0","campo","nokey","false","false"},new String[]{"INFORM","","C","30","0","campo","nokey","false","false"},new String[]{"NATURA","","C","50","0","campo","nokey","false","false"},new String[]{"SCOPO","","C","50","0","campo","nokey","false","false"},new String[]{"SV58550","Modalità bonifico in uscita","C","1","0","campo","nokey","false","false"},new String[]{"SV58550MA","Modalità di avvio","C","2","0","campo","nokey","false","false"},new String[]{"MEZPAG","Mezzo pagamento","C","30","0","campo","nokey","false","false"},new String[]{"PRESTAZ","Beni Oggetto Incarico","C","30","0","campo","nokey","false","false"},new String[]{"VASP","Tipo VASP","C","2","0","campo","nokey","false","false"},new String[]{"ardt_docfrabo","LinkPC","","","","link_PC","","false",""},new String[]{"CONNESDOC","Storico Documenti","C","50","0","campo","nokey","false","false"},new String[]{"MTCN","MTCN","C","10","0","campo","key11","false","false"},new String[]{"DURAT","","C","5","0","campo","nokey","false","false"},new String[]{"RFREQ","","N","3","0","campo","nokey","false","false"},new String[]{"AMMONT","","C","5","0","campo","nokey","false","false"},new String[]{"RIMP","","N","3","0","campo","nokey","false","false"},new String[]{"AREAGEO","","C","5","0","campo","nokey","false","false"},new String[]{"RAREA","","N","3","0","campo","nokey","false","false"},new String[]{"MODSVOL","","C","5","0","campo","nokey","false","false"},new String[]{"RCOMP","","N","3","0","campo","nokey","false","false"},new String[]{"RAGIO","","C","5","0","campo","nokey","false","false"},new String[]{"RRAGIO","","N","3","0","campo","nokey","false","false"},new String[]{"TIPO","","C","3","0","campo","nokey","false","false"},new String[]{"armt_fraziobo_agg","LinkPC","","","","link_PC","","false",""},new String[]{"RTIPO","","N","3","0","campo","nokey","false","false"},new String[]{"RISGLOB","Rischio Globale","C","1","0","campo","nokey","false","false"},new String[]{"MITIG","Mitigazione (+/-)","N","4","0","campo","nokey","false","false"},new String[]{"MITIGDOC","Path Documentazione Mitigazione","C","100","0","campo","nokey","false","false"},new String[]{"ardt_frz_contante","LinkPC","","","","link_PC","","false",""}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_ofrazionateBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo",p_ContextObject.GetCompany(),false);
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_oWrInfo_fraziobo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"fraziobo",p_ContextObject.GetCompany());
    m_cVirtName_fraziobo = CPSql.ManipulateTablePhName("fraziobo",m_cServer_fraziobo);
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
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_oWrInfo_xnarapbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"xnarapbo",p_ContextObject.GetCompany());
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
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    m_oWrInfo_tbrisglob = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbrisglob",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_clientifrz = new ardt_clientifrzBO(p_ContextObject);
    ardt_mlientifrz = new ardt_mlientifrzBO(p_ContextObject);
    ardt_sogopefraz = new ardt_sogopefrazBO(p_ContextObject);
    ardt_mogopefbo = new ardt_mogopefboBO(p_ContextObject);
    ardt_meneficfrz = new ardt_meneficfrzBO(p_ContextObject);
    ardt_beneficfrz = new ardt_beneficfrzBO(p_ContextObject);
    ardt_terzistifrz = new ardt_terzistifrzBO(p_ContextObject);
    ardt_merzistifrz = new ardt_merzistifrzBO(p_ContextObject);
    ardt_docfrabo = new ardt_docfraboBO(p_ContextObject);
    armt_fraziobo_agg = new armt_fraziobo_aggBO(p_ContextObject);
    ardt_frz_contante = new ardt_frz_contanteBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_ofrazionate",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_test = "";
    w_datpaseuro = CPLib.NullDate();
    w_IDBASE = "";
    w_CODDIPE = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_DATAOPE = CPLib.NullDate();
    w_NUMPROG = "";
    w_COLLEG = "";
    w_TIPOOPRAP = "";
    w_idcauana = "";
    w_CODANA = "";
    w_CODVOC = "";
    w_xTOTLIRE = 0;
    w_xTOTCONT = 0;
    w_CAMBIO = 0;
    w_IMPIN = 0;
    w_IMPOUT = 0;
    w_RAPPORTO = "";
    w_CONNESCLI = "";
    w_PROQUOTA = 0;
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
    w_DESC2 = "";
    w_PROV2 = "";
    w_ZCPARTE = "";
    w_DATARETT = CPLib.NullDate();
    w_OPERAZMOD = "";
    w_xdestipleg = "";
    w_xragsocct = "";
    w_xDescDipe = "";
    w_descdiv = "";
    w_valflg2 = "";
    w_xragint2 = "";
    w_errmsg = "";
    w_CABINT = "";
    w_xragsocper = "";
    w_desccauana = "";
    w_xragsocben = "";
    w_xdesccausin = "";
    w_xdescpaese2 = "";
    w_xdescrap = "";
    w_xdes1 = "";
    w_xcodfisc = "";
    w_xdciticon = "";
    w_dessta = "";
    w_xragsocalt = "";
    w_xFLGITAEST = "";
    w_SEGNO = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_IDEREG = "";
    w_DESCINTER = "";
    w_FLAGRAP = "";
    w_RAPPORTBEN = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_FLAGRAP2 = "";
    w_PRGIMPFRZ = 0;
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CONNESDOC = "";
    w_DATAVALI = CPLib.NullDate();
    w_DATARILASC = CPLib.NullDate();
    w_IDBASE2 = "";
    w_OPERAG = "";
    w_xdescopeage = "";
    w_RESPINS = "";
    w_INFORM = "";
    w_NATURA = "";
    w_SCOPO = "";
    w_SV58550 = "";
    w_SV58550MA = "";
    w_xdescfreq = "";
    w_DURAT = "";
    w_xdescammo = "";
    w_AMMONT = "";
    w_xdescareag = "";
    w_AREAGEO = "";
    w_xdescmodsvo = "";
    w_MODSVOL = "";
    w_xdescplauso = "";
    w_RAGIO = "";
    w_xdesctipor = "";
    w_TIPO = "";
    w_DUCOLLEG = 0;
    w_ORACOLLEG = CPLib.NullDateTime();
    w_IPCOLLEG = "";
    w_MEZPAG = "";
    w_PRESTAZ = "";
    w_DESPUNTO = "";
    w_CODCLICON = "";
    w_TIPATT = "";
    w_VASP = "";
    w_RIFIMP = "";
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
    w_IDFILE = "";
    w_MTCN = "";
    w_DURAT = "";
    w_RFREQ = 0;
    w_AMMONT = "";
    w_RIMP = 0;
    w_AREAGEO = "";
    w_RAREA = 0;
    w_MODSVOL = "";
    w_RCOMP = 0;
    w_RAGIO = "";
    w_RRAGIO = 0;
    w_TIPO = "";
    w_RTIPO = 0;
    w_RISGLOB = "";
    w_MITIG = 0;
    w_MITIGDOC = "";
    w_dataoggi = CPLib.NullDate();
    w_dataoggi = CPLib.Date();
    w_filtro = "O";
    w_sEdit = 0;
    w_tipope = "";
    w_tipope = "1";
    w_stringaflagrap2 = "JLMNOTUV?";
    w_CODINTER = "";
    w_CODINTER = w_gIntemediario;
    Link_NNOUMHTLXJ();
    w_apporeg = "";
    w_apporeg = CPLib.DateToChar(w_DATAREG);
    Link_SDNFDOJDLP();
    w_CDATOPE = "";
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    w_CDATAOPE = "";
    w_CDATAOPE = w_CDATOPE;
    w_ANNOOPE = 0;
    w_ANNOOPE = CPLib.Year(w_DATAOPE);
    w_DATAREG = CPLib.Date();
    w_CDATREG = "";
    w_CDATREG = CPLib.DateToChar(w_DATAREG);
    w_FLAGFRAZ = "0";
    Link_XDPPAEWQFR();
    Link_SQVJLYRFKQ();
    Link_SRWWPHPCUB();
    w_FLAGLIRE = "";
    w_FLAGLIRE = arfn_calcflaglireR.Make(m_Ctx,this).Run(w_DATAOPE,w_appolire,w_datpaseuro);
    w_appolire = "";
    w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
    w_VALUTA = "242";
    Link_JCKYJRZABA();
    w_FLAGCONT = "0";
    Link_RZIQZFKPUE();
    Link_QBLXDBODXR();
    Link_TCOTJNZLGM();
    w_TIPOLEG = "0";
    w_PAGASOGOP = "N";
    Link_ULVCBLFVEU();
    Link_TRNDHQYOXC();
    Link_ODAYKSRECA();
    Link_YVIKEGPYPM();
    Link_OGZBJVOVLN();
    Link_MUTRCJYNJT();
    Link_CRVLITCYRD();
    w_STATOREG = "0";
    w_TIPOINF = "";
    w_TIPOINF = "1";
    w_OPRAP = "";
    w_OPRAP = "1";
    w_NOSARA = "N";
    w_CALCOLI = true;
    w_COMPLETA = true;
    w_NOPROT = 0;
    Link_QEFXECTWSF();
    Link_VMVNJQLPEN();
    Link_ASETEUZIOS();
    Link_UXDPSYOTRU();
    Link_VZKBEOYRRK();
    Link_NVHOMNEASH();
    Link_XSVOIKCEKR();
    Link_EOXCZYYEBY();
    Link_CKJQULDXKW();
    Link_SXTYCPHBIM();
    Link_QJSTZIPOQB();
    Link_SFFFOYOWNH();
    Link_NOBMPHKVTX();
    Link_DJOWYRMDDC();
    m_cWv_ardt_clientifrz = "";
    m_cWv_ardt_mlientifrz = "";
    m_cWv_ardt_sogopefraz = "";
    m_cWv_ardt_mogopefbo = "";
    m_cWv_ardt_meneficfrz = "";
    m_cWv_ardt_beneficfrz = "";
    m_cWv_ardt_terzistifrz = "";
    m_cWv_ardt_merzistifrz = "";
    m_cWv_ardt_docfrabo = "";
    m_cWv_armt_fraziobo_agg = "";
    m_cWv_ardt_frz_contante = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_clientifrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_clientifrz);
    l_bResult = l_bResult || ardt_mlientifrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_mlientifrz);
    l_bResult = l_bResult || ardt_sogopefraz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_sogopefraz);
    l_bResult = l_bResult || ardt_mogopefbo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_mogopefbo);
    l_bResult = l_bResult || ardt_meneficfrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_meneficfrz);
    l_bResult = l_bResult || ardt_beneficfrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_beneficfrz);
    l_bResult = l_bResult || ardt_terzistifrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_terzistifrz);
    l_bResult = l_bResult || ardt_merzistifrz.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_merzistifrz);
    l_bResult = l_bResult || ardt_docfrabo.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_docfrabo);
    l_bResult = l_bResult || armt_fraziobo_agg.IsUpdated() || CPLib.IsUpdated(m_cWv_armt_fraziobo_agg);
    l_bResult = l_bResult || ardt_frz_contante.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_frz_contante);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_filtro = w_filtro;
    o_CODINTER = w_CODINTER;
    o_CODDIPE = w_CODDIPE;
    o_DATAOPE = w_DATAOPE;
    o_CDATOPE = w_CDATOPE;
    o_DATAREG = w_DATAREG;
    o_TIPOOPRAP = w_TIPOOPRAP;
    o_CODANA = w_CODANA;
    o_CODVOC = w_CODVOC;
    o_FLAGLIRE = w_FLAGLIRE;
    o_appolire = w_appolire;
    o_VALUTA = w_VALUTA;
    o_FLAGCONT = w_FLAGCONT;
    o_RAPPORTO = w_RAPPORTO;
    o_CONNESCLI = w_CONNESCLI;
    o_CONNESOPER = w_CONNESOPER;
    o_CONNESBEN = w_CONNESBEN;
    o_CONNALTRO = w_CONNALTRO;
    o_C_CTA = w_C_CTA;
    o_CODINT2 = w_CODINT2;
    o_SEGNO = w_SEGNO;
    o_DURAT = w_DURAT;
    o_AMMONT = w_AMMONT;
    o_AREAGEO = w_AREAGEO;
    o_MODSVOL = w_MODSVOL;
    o_RAGIO = w_RAGIO;
    o_TIPO = w_TIPO;
    ardt_clientifrz.SaveDependsOn();
    ardt_mlientifrz.SaveDependsOn();
    ardt_sogopefraz.SaveDependsOn();
    ardt_mogopefbo.SaveDependsOn();
    ardt_meneficfrz.SaveDependsOn();
    ardt_beneficfrz.SaveDependsOn();
    ardt_terzistifrz.SaveDependsOn();
    ardt_merzistifrz.SaveDependsOn();
    ardt_docfrabo.SaveDependsOn();
    armt_fraziobo_agg.SaveDependsOn();
    ardt_frz_contante.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Blank")) {
      Calculation_WKUMXNRIRT();
    } else if (CPLib.eq(p_cEvent,"Delete end")) {
      Calculation_BVXCMRSYKS();
    } else if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_WKUMXNRIRT();
      Calculation_KCAZOZICOY();
    } else if (CPLib.eq(p_cEvent,"Load")) {
      Calculation_NAKGPBRIRV();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_KCAZOZICOY();
      Calculation_RMCHLJQOEX();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_NNOUMHTLXJ() {
    return Link_NNOUMHTLXJ("Full");
  }
  protected boolean Link_NNOUMHTLXJ(String p_cType) {
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
          Link_NNOUMHTLXJ_blank();
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
      Link_NNOUMHTLXJ_blank();
    }
    return l_bResult;
  }
  void Link_NNOUMHTLXJ_blank() {
    w_CODINTER = "";
    w_datpaseuro = CPLib.NullDate();
    w_CABINT = "";
    w_PROVINT = "";
    w_CITINT = "";
  }
  protected boolean Link_SDNFDOJDLP() {
    return Link_SDNFDOJDLP("Full");
  }
  protected boolean Link_SDNFDOJDLP(String p_cType) {
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
          Link_SDNFDOJDLP_blank();
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
      Link_SDNFDOJDLP_blank();
    }
    return l_bResult;
  }
  void Link_SDNFDOJDLP_blank() {
    w_CODDIPE = "";
    w_xDescDipe = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
  }
  protected boolean Link_XDPPAEWQFR() {
    return Link_XDPPAEWQFR("Full");
  }
  protected boolean Link_XDPPAEWQFR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_idcauana))) {
      String l_OldValue = w_idcauana;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idcauana,"C",4,0),m_cServer_tbcauana,w_idcauana);
      l_cWhere = l_cWhere+" and VALPERINT like "+CPLib.ToSQL("%"+w_gTipInter+"%","?",0,0);
      if (m_Ctx.IsSharedTemp("tbcauana")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select idbase,CODCAU,CAUSINT,SEGNO,NOSARA,FLGINTER,DESCRI from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"idbase"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_idcauana = l_rsLink.GetString("idbase");
          w_CODANA = l_rsLink.GetString("CODCAU");
          w_CODVOC = l_rsLink.GetString("CAUSINT");
          w_SEGNO = l_rsLink.GetString("SEGNO");
          w_NOSARA = l_rsLink.GetString("NOSARA");
          w_xFLGITAEST = l_rsLink.GetString("FLGINTER");
          w_desccauana = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_XDPPAEWQFR_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","idcauana");
          }
          m_cLastWorkVarError = "idcauana";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XDPPAEWQFR_blank();
    }
    return l_bResult;
  }
  void Link_XDPPAEWQFR_blank() {
    Link_XDPPAEWQFR_blank("");
  }
  void Link_XDPPAEWQFR_blank(String p_cType) {
    w_CODANA = "";
    w_CODVOC = "";
    w_SEGNO = "";
    w_NOSARA = "";
    w_xFLGITAEST = "";
    w_desccauana = "";
  }
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
      l_rsLink = m_Sql.Query(m_cServer_tbcauana,"select CODCAU,DESCRI from "+m_cPhName_tbcauana+((m_cPhName_tbcauana).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODCAU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODANA = l_rsLink.GetString("CODCAU");
          w_desccauana = l_rsLink.GetString("DESCRI");
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
    w_desccauana = "";
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
    w_xdesccausin = "";
  }
  protected boolean Link_JCKYJRZABA() {
    return Link_JCKYJRZABA("Full");
  }
  protected boolean Link_JCKYJRZABA(String p_cType) {
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
          Link_JCKYJRZABA_blank();
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
      Link_JCKYJRZABA_blank();
    }
    return l_bResult;
  }
  void Link_JCKYJRZABA_blank() {
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
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","CONNESOPER");
          }
          m_cLastWorkVarError = "CONNESOPER";
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
      l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CONTO from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CONNES"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"C",70,0),m_cServer_personbo,w_CONNESBEN);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_personbo,"select CONNES,RAGSOC,CONTO from "+m_cPhName_personbo+((m_cPhName_personbo).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAGSOC"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CONNESBEN = l_rsLink.GetString("CONNES");
          w_xragsocben = l_rsLink.GetString("RAGSOC");
          w_C_RAPPORTO = l_rsLink.GetString("CONTO");
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
    w_C_RAPPORTO = "";
  }
  protected boolean Link_TRNDHQYOXC() {
    return Link_TRNDHQYOXC("Full");
  }
  protected boolean Link_TRNDHQYOXC(String p_cType) {
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
          Link_TRNDHQYOXC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_CONNALTRO = l_OldValue;
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
      Link_TRNDHQYOXC_blank();
    }
    return l_bResult;
  }
  void Link_TRNDHQYOXC_blank() {
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
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_YVIKEGPYPM_blank();
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
    Link_YVIKEGPYPM_blank("");
  }
  void Link_YVIKEGPYPM_blank(String p_cType) {
    w_dessta = "";
  }
  protected boolean Link_OGZBJVOVLN() {
    return Link_OGZBJVOVLN("Full");
  }
  protected boolean Link_OGZBJVOVLN(String p_cType) {
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
            Link_OGZBJVOVLN_blank();
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
      Link_OGZBJVOVLN_blank();
    }
    return l_bResult;
  }
  void Link_OGZBJVOVLN_blank() {
    Link_OGZBJVOVLN_blank("");
  }
  void Link_OGZBJVOVLN_blank(String p_cType) {
    w_DESCINTER = "";
    w_CODCAB2 = "";
    w_PROV2 = "";
    w_PAESE = "";
    w_TIPOINT2 = "";
  }
  protected boolean Link_MUTRCJYNJT() {
    return Link_MUTRCJYNJT("Full");
  }
  protected boolean Link_MUTRCJYNJT(String p_cType) {
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
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_MUTRCJYNJT_blank();
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
      Link_MUTRCJYNJT_blank();
    }
    return l_bResult;
  }
  void Link_MUTRCJYNJT_blank() {
    Link_MUTRCJYNJT_blank("");
  }
  void Link_MUTRCJYNJT_blank(String p_cType) {
    w_xdescpaese2 = "";
  }
  protected boolean Link_CRVLITCYRD() {
    return Link_CRVLITCYRD("Full");
  }
  protected boolean Link_CRVLITCYRD(String p_cType) {
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
            Link_CRVLITCYRD_blank();
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
      Link_CRVLITCYRD_blank();
    }
    return l_bResult;
  }
  void Link_CRVLITCYRD_blank() {
    Link_CRVLITCYRD_blank("");
  }
  void Link_CRVLITCYRD_blank(String p_cType) {
    w_DESC2 = "";
    w_PROV2 = "";
    w_xdciticon = "";
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
  protected boolean Link_VMVNJQLPEN() {
    return Link_VMVNJQLPEN("Full");
  }
  protected boolean Link_VMVNJQLPEN(String p_cType) {
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
          Link_VMVNJQLPEN_blank();
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
      Link_VMVNJQLPEN_blank();
    }
    return l_bResult;
  }
  void Link_VMVNJQLPEN_blank() {
    w_DURAT = "";
    w_RFREQ = 0;
  }
  protected boolean Link_ASETEUZIOS() {
    return Link_ASETEUZIOS("Full");
  }
  protected boolean Link_ASETEUZIOS(String p_cType) {
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
          Link_ASETEUZIOS_blank();
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
      Link_ASETEUZIOS_blank();
    }
    return l_bResult;
  }
  void Link_ASETEUZIOS_blank() {
    w_AMMONT = "";
    w_RIMP = 0;
  }
  protected boolean Link_UXDPSYOTRU() {
    return Link_UXDPSYOTRU("Full");
  }
  protected boolean Link_UXDPSYOTRU(String p_cType) {
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
          Link_UXDPSYOTRU_blank();
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
      Link_UXDPSYOTRU_blank();
    }
    return l_bResult;
  }
  void Link_UXDPSYOTRU_blank() {
    w_AREAGEO = "";
    w_RAREA = 0;
  }
  protected boolean Link_VZKBEOYRRK() {
    return Link_VZKBEOYRRK("Full");
  }
  protected boolean Link_VZKBEOYRRK(String p_cType) {
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
          Link_VZKBEOYRRK_blank();
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
      Link_VZKBEOYRRK_blank();
    }
    return l_bResult;
  }
  void Link_VZKBEOYRRK_blank() {
    w_MODSVOL = "";
    w_RCOMP = 0;
  }
  protected boolean Link_NVHOMNEASH() {
    return Link_NVHOMNEASH("Full");
  }
  protected boolean Link_NVHOMNEASH(String p_cType) {
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
          Link_NVHOMNEASH_blank();
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
      Link_NVHOMNEASH_blank();
    }
    return l_bResult;
  }
  void Link_NVHOMNEASH_blank() {
    w_RAGIO = "";
    w_RRAGIO = 0;
  }
  protected boolean Link_XSVOIKCEKR() {
    return Link_XSVOIKCEKR("Full");
  }
  protected boolean Link_XSVOIKCEKR(String p_cType) {
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
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPO,"C",3,0),m_cServer_tbtiporisc_p,w_TIPO);
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
          Link_XSVOIKCEKR_blank();
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
      Link_XSVOIKCEKR_blank();
    }
    return l_bResult;
  }
  void Link_XSVOIKCEKR_blank() {
    w_TIPO = "";
    w_RTIPO = 0;
  }
  protected boolean Link_EOXCZYYEBY() {
    return Link_EOXCZYYEBY("Full");
  }
  protected boolean Link_EOXCZYYEBY(String p_cType) {
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
          Link_EOXCZYYEBY_blank();
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
      Link_EOXCZYYEBY_blank();
    }
    return l_bResult;
  }
  void Link_EOXCZYYEBY_blank() {
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
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
      l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODICE"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DURAT,"C",200,0),m_cServer_tbdurata,w_DURAT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbdurata,"select CODICE,DESCRI from "+m_cPhName_tbdurata+((m_cPhName_tbdurata).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DURAT = l_rsLink.GetString("CODICE");
          w_xdescfreq = l_rsLink.GetString("DESCRI");
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
  public boolean Set_CODDIPE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODDIPE = p_workVariableValue;
    l_bResult = Link_SDNFDOJDLP();
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
    l_bResult = (w_COMPLETA?CPLib.ge(w_DATAREG,w_DATAOPE):true);
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
    l_bResult = (w_COMPLETA?CPLib.ge(w_DATAREG,w_DATAOPE):true);
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
  public boolean Set_idcauana(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_idcauana = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_XDPPAEWQFR();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_idcauana = "";
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_appolire = "";
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
    l_bResult = Link_JCKYJRZABA();
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_xTOTCONT = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean KUMAEYPETV_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.eq(w_FLAGCONT,"1");
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
  public boolean Set_IMPIN(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPIN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPOUT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPOUT = p_workVariableValue;
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
    if (l_bResult &&  ! (Check_FBYJKRFVBE(false))) {
      m_nLastError = 2;
      w_CONNESCLI = "";
      return false;
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CONNESCLI = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROQUOTA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROQUOTA = p_workVariableValue;
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
    if (l_bResult &&  ! (Check_DUNXKFRTPZ(false))) {
      m_nLastError = 2;
      w_CONNESOPER = "";
      return false;
    }
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
  public boolean WBHSORBZAV_isObligatory() {
    // Condizione di obbligatorietà
    return  ! (CPLib.Empty(w_CONNESOPER));
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
    if (l_bResult &&  ! (Check_CSHBHPWJQE(false))) {
      m_nLastError = 2;
      w_CONNESBEN = "";
      return false;
    }
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
    l_bResult = Link_TRNDHQYOXC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if (l_bResult &&  ! (Check_ZZBVRHATAX(false))) {
      m_nLastError = 2;
      w_CONNALTRO = "";
      return false;
    }
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_C_RAG = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean AWPNTOJIRR_isObligatory() {
    // Condizione di obbligatorietà
    return (w_COMPLETA?CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0):false);
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
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
  public boolean YVIKEGPYPM_isObligatory() {
    // Condizione di obbligatorietà
    return (w_COMPLETA?CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0):false);
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPOINT2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean OBBUSHLGFO_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && w_CALCOLI;
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
    l_bResult = Link_OGZBJVOVLN();
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCINTER = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCINTER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean TYCTKKPTQQ_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && CPLib.Empty(w_CODINT2) && CPLib.eq(w_gVerSim,"N") && w_CALCOLI;
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_MUTRCJYNJT();
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
  public boolean MUTRCJYNJT_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && w_CALCOLI;
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    l_bResult = Link_CRVLITCYRD();
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
  public boolean CRVLITCYRD_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && CPLib.eq(w_xFLGITAEST,"I") && w_CALCOLI;
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
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESC2 = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean KDONRVZYMP_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && CPLib.eq(w_xFLGITAEST,"I") && w_CALCOLI;
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
  public boolean HWGWORUQJF_isObligatory() {
    // Condizione di obbligatorietà
    return CPLib.ne(CPLib.At(w_CODVOC,"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0) && CPLib.eq(w_xFLGITAEST,"I") && w_CALCOLI;
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
  public boolean Set_NOSARA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOSARA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CALCOLI(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CALCOLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COMPLETA(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COMPLETA = p_workVariableValue;
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
  public boolean Set_SV58550(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58550 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SV58550MA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SV58550MA = p_workVariableValue;
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
  public boolean Set_VASP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_VASP = p_workVariableValue;
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
    l_bResult = Link_EOXCZYYEBY();
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
  public boolean Set_DURAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DURAT = p_workVariableValue;
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DURAT = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AMMONT = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_AREAGEO = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_MODSVOL = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAGIO = "";
    }
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
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPO = "";
    }
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
  public boolean Set_MITIGDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MITIGDOC = p_workVariableValue;
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
  public boolean getWritable_STATOREG() {
    return false;
  }
  public boolean getWritable_DATARETT() {
    return false;
  }
  public boolean getVisible_IDBASE() {
    return CPLib.eq(1,1);
  }
  public boolean getVisible_COLLEG() {
    return CPLib.Empty(w_COLLEG);
  }
  public boolean getVisible_IMPIN() {
    return CPLib.eq(CPLib.At(w_CODANA,"|DB|DC"),0);
  }
  public boolean getVisible_DATARETT() {
    return CPLib.eq(w_STATOREG,"0");
  }
  public boolean getVisible_NOSARA() {
    return CPLib.ge(w_gTipInter,"30") && CPLib.le(w_gTipInter,"41");
  }
  public boolean getVisible_CALCOLI() {
    return true;
  }
  public boolean getVisible_COMPLETA() {
    return true;
  }
  public boolean getVisible_SV58550() {
    return CPLib.ne(w_TIPOOPRAP,"11");
  }
  public boolean getVisible_MEZPAG() {
    return CPLib.lt(w_gTipInter,"30") || CPLib.gt(w_gTipInter,"41");
  }
  public boolean getVisible_PRESTAZ() {
    return CPLib.lt(w_gTipInter,"30") || CPLib.gt(w_gTipInter,"41");
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
    w_dataoggi = CPLib.Date();
    w_tipope = "1";
    w_CODINTER = w_gIntemediario;
    l_bTmpRes = Link_NNOUMHTLXJ();
    if (CPLib.ne(o_DATAREG,w_DATAREG)) {
      w_apporeg = CPLib.DateToChar(w_DATAREG);
    }
    w_CDATOPE = CPLib.DateToChar(w_DATAOPE);
    if (CPLib.ne(o_CDATOPE,w_CDATOPE)) {
      w_CDATAOPE = w_CDATOPE;
    }
    w_ANNOOPE = CPLib.Year(w_DATAOPE);
    w_CDATREG = CPLib.DateToChar(w_DATAREG);
    if (CPLib.ne(o_CODANA,w_CODANA)) {
      l_bTmpRes = Link_SQVJLYRFKQ();
    }
    if (CPLib.ne(o_CODVOC,w_CODVOC)) {
      l_bTmpRes = Link_SRWWPHPCUB();
    }
    w_FLAGLIRE = arfn_calcflaglireR.Make(m_Ctx,this).Run(w_DATAOPE,w_appolire,w_datpaseuro);
    if (CPLib.ne(o_FLAGLIRE,w_FLAGLIRE)) {
      w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
    }
    if (CPLib.ne(o_C_CTA,w_C_CTA)) {
      l_bTmpRes = Link_YVIKEGPYPM();
    }
    if (CPLib.ne(o_CODINT2,w_CODINT2)) {
      l_bTmpRes = Link_MUTRCJYNJT();
    }
    if (CPLib.ne(o_CODINT2,w_CODINT2)) {
      l_bTmpRes = Link_CRVLITCYRD();
    }
    w_TIPOINF = "1";
    w_OPRAP = "1";
    if (CPLib.ne(o_DATAOPE,w_DATAOPE)) {
      Calculation_ISMPZVVNVG();
    }
    if (CPLib.ne(o_CONNESCLI,w_CONNESCLI) || CPLib.ne(o_RAPPORTO,w_RAPPORTO)) {
      Calculation_QCJQRCFUFB();
    }
    if (CPLib.ne(o_CONNESBEN,w_CONNESBEN)) {
      Calculation_LNKPNNFRDI();
    }
    if (CPLib.ne(o_RAPPORTO,w_RAPPORTO)) {
      Calculation_DIWSVSDVMG();
    }
    if (CPLib.ne(o_appolire,w_appolire)) {
      Calculation_TBLTXFHXJY();
    }
    if (CPLib.ne(o_FLAGCONT,w_FLAGCONT)) {
      Calculation_EBRTUDXQTQ();
    }
    if (CPLib.ne(o_CODINTER,w_CODINTER) || CPLib.ne(o_CODDIPE,w_CODDIPE)) {
      Calculation_WKUMXNRIRT();
    }
    if (CPLib.ne(o_appolire,w_appolire) || CPLib.ne(o_DATAOPE,w_DATAOPE)) {
      Calculation_NAKGPBRIRV();
    }
    if (CPLib.ne(o_DURAT,w_DURAT)) {
      l_bTmpRes = Link_VMVNJQLPEN();
    }
    if (CPLib.ne(o_AMMONT,w_AMMONT)) {
      l_bTmpRes = Link_ASETEUZIOS();
    }
    if (CPLib.ne(o_AREAGEO,w_AREAGEO)) {
      l_bTmpRes = Link_UXDPSYOTRU();
    }
    if (CPLib.ne(o_MODSVOL,w_MODSVOL)) {
      l_bTmpRes = Link_VZKBEOYRRK();
    }
    if (CPLib.ne(o_RAGIO,w_RAGIO)) {
      l_bTmpRes = Link_NVHOMNEASH();
    }
    if (CPLib.ne(o_TIPO,w_TIPO)) {
      l_bTmpRes = Link_XSVOIKCEKR();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    // Aggiorna l'autonumber se cambia la parte fissa
    UpdateAutonumber();
    CopyWorkVar(this,armt_fraziobo_agg,new String[]{"SEGNO"},new String[]{"SEGNO"},true);
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_ISMPZVVNVG() {
    w_TIPOLEG = arfn_read_tipolegR.Make(m_Ctx,this).Run(w_IDBASE,"OP");
  }
  void Calculation_QCJQRCFUFB() {
    arrt_imp_frischioR l_oRoutine_arrt_imp_frischio;
    l_oRoutine_arrt_imp_frischio = arrt_imp_frischioR.Make(m_Ctx,this);
    l_oRoutine_arrt_imp_frischio.pTipo = "B";
    l_oRoutine_arrt_imp_frischio.Run();
  }
  void Calculation_LNKPNNFRDI() {
    arrt_val_beneficR l_oRoutine_arrt_val_benefic;
    l_oRoutine_arrt_val_benefic = arrt_val_beneficR.Make(m_Ctx,this);
    l_oRoutine_arrt_val_benefic.Run();
  }
  void Calculation_DIWSVSDVMG() {
    if (w_CALCOLI) {
      arrt_li_frazioboR l_oRoutine_arrt_li_fraziobo;
      l_oRoutine_arrt_li_fraziobo = arrt_li_frazioboR.Make(m_Ctx,this);
      l_oRoutine_arrt_li_fraziobo.pObj = this;
      l_oRoutine_arrt_li_fraziobo.Run();
    }
  }
  void Calculation_TBLTXFHXJY() {
    w_VALUTA = (CPLib.eq(w_appolire,"L")?"018":(CPLib.eq(w_appolire,"E")?"242":w_VALUTA));
  }
  void Calculation_EBRTUDXQTQ() {
    w_xTOTCONT = (CPLib.eq(w_FLAGCONT,"1")?w_xTOTCONT:0);
  }
  void Calculation_WKUMXNRIRT() {
    w_DESCCIT = (CPLib.Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
    w_PROVINCIA = (CPLib.Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
    w_CODCAB = (CPLib.Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
  }
  void Calculation_NAKGPBRIRV() {
    w_xTOTLIRE = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_TOTLIRE/100:w_TOTLIRE);
    w_xTOTCONT = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_TOTCONT/100:w_TOTCONT);
  }
  void Calculation_KCAZOZICOY() {
    w_TOTLIRE = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_xTOTLIRE*100:w_xTOTLIRE);
    w_TOTCONT = (CPLib.ge(w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(w_datpaseuro,w_DATAOPE)?w_xTOTCONT*100:w_xTOTCONT);
  }
  void Calculation_KGBNFVNJHO() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "FRAZIOBO";
    l_oRoutine_arrt_writelog.pChiave = w_IDBASE;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_RMCHLJQOEX() {
    arrt_copiaoperazionefR l_oRoutine_arrt_copiaoperazionef;
    l_oRoutine_arrt_copiaoperazionef = arrt_copiaoperazionefR.Make(m_Ctx,this);
    l_oRoutine_arrt_copiaoperazionef.Run();
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "FRAZIOBO";
    l_oRoutine_arrt_writelog.pChiave = w_IDBASE;
    l_oRoutine_arrt_writelog.Run();
    arrt_crea_ideregR l_oRoutine_arrt_crea_idereg;
    l_oRoutine_arrt_crea_idereg = arrt_crea_ideregR.Make(m_Ctx,this);
    l_oRoutine_arrt_crea_idereg.pTab = "F";
    l_oRoutine_arrt_crea_idereg.pIDB = w_IDBASE;
    l_oRoutine_arrt_crea_idereg.pTipo = "D";
    l_oRoutine_arrt_crea_idereg.Run();
  }
  void Calculation_BVXCMRSYKS() {
    arrt_deloperazionefR l_oRoutine_arrt_deloperazionef;
    l_oRoutine_arrt_deloperazionef = arrt_deloperazionefR.Make(m_Ctx,this);
    l_oRoutine_arrt_deloperazionef.Run();
  }
  void Calculation_OEZVQSLBRM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "FRAZIOBO";
    l_oRoutine_arrt_writelog.pChiave = w_IDBASE;
    l_oRoutine_arrt_writelog.Run();
    arrt_updel_opextrboR l_oRoutine_arrt_updel_opextrbo;
    l_oRoutine_arrt_updel_opextrbo = arrt_updel_opextrboR.Make(m_Ctx,this);
    l_oRoutine_arrt_updel_opextrbo.pTipo = "F";
    l_oRoutine_arrt_updel_opextrbo.Run();
  }
  boolean Check_CUIIXQPPLV(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_VALUTA,w_VALUTA) || CPLib.ne(o_appolire,w_appolire)) {
    }
    return l_bResult;
  }
  boolean Check_VTUPGRKHMU(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_SEGNO,w_SEGNO) || CPLib.ne(o_CODVOC,w_CODVOC) || CPLib.ne(o_TIPOOPRAP,w_TIPOOPRAP)) {
    }
    return l_bResult;
  }
  boolean Check_FBYJKRFVBE(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_CONNESCLI,w_CONNESCLI)) {
      l_bResult = (w_COMPLETA?arfn_chksoggR.Make(m_Ctx,this).Run(w_CONNESCLI,"7"):true);
      if ( ! (l_bResult)) {
        m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
      }
    }
    return l_bResult;
  }
  boolean Check_DUNXKFRTPZ(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_CONNESOPER,w_CONNESOPER)) {
    }
    return l_bResult;
  }
  boolean Check_CSHBHPWJQE(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_CONNESBEN,w_CONNESBEN)) {
    }
    return l_bResult;
  }
  boolean Check_ZZBVRHATAX(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce || CPLib.ne(o_CONNALTRO,w_CONNALTRO)) {
    }
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
    l_cFilter = CPLib.ApplicationQueryFilter("armt_ofrazionate","fraziobo",m_KeyColumns,m_Ctx);
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
    w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
    w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
    w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
    w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
    w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
    w_gStatus = m_Ctx.GetGlobalString("gStatus");
    w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
    w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
    w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
    w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
    w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
    w_dataoggi = CPLib.NullDate();
    w_filtro = "";
    w_sEdit = 0;
    w_test = "";
    w_datpaseuro = CPLib.NullDate();
    w_tipope = "";
    w_stringaflagrap2 = "";
    w_IDBASE = "";
    w_CODINTER = "";
    w_apporeg = "";
    w_CODDIPE = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CODCAB = "";
    w_DATAOPE = CPLib.NullDate();
    w_NUMPROG = "";
    w_CDATOPE = "";
    w_CDATAOPE = "";
    w_ANNOOPE = 0;
    w_DATAREG = CPLib.NullDate();
    w_CDATREG = "";
    w_FLAGFRAZ = "";
    w_COLLEG = "";
    w_TIPOOPRAP = "";
    w_idcauana = "";
    w_CODANA = "";
    w_CODVOC = "";
    w_FLAGLIRE = "";
    w_appolire = "";
    w_VALUTA = "";
    w_xTOTLIRE = 0;
    w_FLAGCONT = "";
    w_xTOTCONT = 0;
    w_CAMBIO = 0;
    w_IMPIN = 0;
    w_IMPOUT = 0;
    w_RAPPORTO = "";
    w_CONNESCLI = "";
    w_PROQUOTA = 0;
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
    w_DESC2 = "";
    w_PROV2 = "";
    w_ZCPARTE = "";
    w_STATOREG = "";
    w_DATARETT = CPLib.NullDate();
    w_OPERAZMOD = "";
    w_xdestipleg = "";
    w_xragsocct = "";
    w_xDescDipe = "";
    w_descdiv = "";
    w_TIPOINF = "";
    w_valflg2 = "";
    w_xragint2 = "";
    w_errmsg = "";
    w_CABINT = "";
    w_xragsocper = "";
    w_desccauana = "";
    w_xragsocben = "";
    w_xdesccausin = "";
    w_xdescpaese2 = "";
    w_xdescrap = "";
    w_xdes1 = "";
    w_xcodfisc = "";
    w_xdciticon = "";
    w_dessta = "";
    w_xragsocalt = "";
    w_xFLGITAEST = "";
    w_SEGNO = "";
    w_TOTLIRE = 0;
    w_TOTCONT = 0;
    w_IDEREG = "";
    w_DESCINTER = "";
    w_FLAGRAP = "";
    w_OPRAP = "";
    w_RAPPORTBEN = "";
    w_OPERATORE = "";
    w_AUTOM = "";
    w_FLAGRAP2 = "";
    w_PRGIMPFRZ = 0;
    w_CITINT = "";
    w_CITDIP = "";
    w_PROVDIP = "";
    w_CABDIP = "";
    w_PROVINT = "";
    w_CONNESDOC = "";
    w_DATAVALI = CPLib.NullDate();
    w_DATARILASC = CPLib.NullDate();
    w_IDBASE2 = "";
    w_NOSARA = "";
    w_CALCOLI = false;
    w_COMPLETA = false;
    w_NOPROT = 0;
    w_OPERAG = "";
    w_xdescopeage = "";
    w_RESPINS = "";
    w_INFORM = "";
    w_NATURA = "";
    w_SCOPO = "";
    w_SV58550 = "";
    w_SV58550MA = "";
    w_xdescfreq = "";
    w_DURAT = "";
    w_xdescammo = "";
    w_AMMONT = "";
    w_xdescareag = "";
    w_AREAGEO = "";
    w_xdescmodsvo = "";
    w_MODSVOL = "";
    w_xdescplauso = "";
    w_RAGIO = "";
    w_xdesctipor = "";
    w_TIPO = "";
    w_DUCOLLEG = 0;
    w_ORACOLLEG = CPLib.NullDateTime();
    w_IPCOLLEG = "";
    w_MEZPAG = "";
    w_PRESTAZ = "";
    w_DESPUNTO = "";
    w_CODCLICON = "";
    w_TIPATT = "";
    w_VASP = "";
    w_RIFIMP = "";
    w_CONNESDOC = "";
    w_xRAGSOCDOC = "";
    w_IDFILE = "";
    w_MTCN = "";
    w_DURAT = "";
    w_RFREQ = 0;
    w_AMMONT = "";
    w_RIMP = 0;
    w_AREAGEO = "";
    w_RAREA = 0;
    w_MODSVOL = "";
    w_RCOMP = 0;
    w_RAGIO = "";
    w_RRAGIO = 0;
    w_TIPO = "";
    w_RTIPO = 0;
    w_RISGLOB = "";
    w_MITIG = 0;
    w_MITIGDOC = "";
    m_cWv_ardt_clientifrz = "";
    m_cWv_ardt_mlientifrz = "";
    m_cWv_ardt_sogopefraz = "";
    m_cWv_ardt_mogopefbo = "";
    m_cWv_ardt_meneficfrz = "";
    m_cWv_ardt_beneficfrz = "";
    m_cWv_ardt_terzistifrz = "";
    m_cWv_ardt_merzistifrz = "";
    m_cWv_ardt_docfrabo = "";
    m_cWv_armt_fraziobo_agg = "";
    m_cWv_ardt_frz_contante = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_CONNESDOC = CPLib.GetProperty(p,"CONNESDOC",w_CONNESDOC,0);
      w_IDBASE = CPLib.GetProperty(p,"IDBASE",w_IDBASE,0);
      op_IDBASE = CPLib.GetProperty(p,"op_IDBASE","",0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_DATAOPE = CPLib.GetProperty(p,"DATAOPE",w_DATAOPE,0);
      w_NUMPROG = CPLib.GetProperty(p,"NUMPROG",w_NUMPROG,0);
      op_NUMPROG = CPLib.GetProperty(p,"op_NUMPROG","",0);
      w_CDATOPE = CPLib.GetProperty(p,"CDATOPE",w_CDATOPE,0);
      w_CDATAOPE = CPLib.GetProperty(p,"CDATAOPE",w_CDATAOPE,0);
      w_ANNOOPE = CPLib.GetProperty(p,"ANNOOPE",w_ANNOOPE,0);
      w_DATAREG = CPLib.GetProperty(p,"DATAREG",w_DATAREG,0);
      w_CDATREG = CPLib.GetProperty(p,"CDATREG",w_CDATREG,0);
      w_FLAGFRAZ = CPLib.GetProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
      w_COLLEG = CPLib.GetProperty(p,"COLLEG",w_COLLEG,0);
      w_TIPOOPRAP = CPLib.GetProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
      w_idcauana = CPLib.GetProperty(p,"idcauana",w_idcauana,0);
      w_CODANA = CPLib.GetProperty(p,"CODANA",w_CODANA,0);
      w_CODVOC = CPLib.GetProperty(p,"CODVOC",w_CODVOC,0);
      w_FLAGLIRE = CPLib.GetProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
      w_VALUTA = CPLib.GetProperty(p,"VALUTA",w_VALUTA,0);
      w_FLAGCONT = CPLib.GetProperty(p,"FLAGCONT",w_FLAGCONT,0);
      w_CAMBIO = CPLib.GetProperty(p,"CAMBIO",w_CAMBIO,0);
      w_IMPIN = CPLib.GetProperty(p,"IMPIN",w_IMPIN,0);
      w_IMPOUT = CPLib.GetProperty(p,"IMPOUT",w_IMPOUT,0);
      w_RAPPORTO = CPLib.GetProperty(p,"RAPPORTO",w_RAPPORTO,0);
      w_CONNESCLI = CPLib.GetProperty(p,"CONNESCLI",w_CONNESCLI,0);
      w_PROQUOTA = CPLib.GetProperty(p,"PROQUOTA",w_PROQUOTA,0);
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
      w_DESC2 = CPLib.GetProperty(p,"DESC2",w_DESC2,0);
      w_PROV2 = CPLib.GetProperty(p,"PROV2",w_PROV2,0);
      w_ZCPARTE = CPLib.GetProperty(p,"ZCPARTE",w_ZCPARTE,0);
      w_STATOREG = CPLib.GetProperty(p,"STATOREG",w_STATOREG,0);
      w_DATARETT = CPLib.GetProperty(p,"DATARETT",w_DATARETT,0);
      w_OPERAZMOD = CPLib.GetProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
      w_TIPOINF = CPLib.GetProperty(p,"TIPOINF",w_TIPOINF,0);
      w_SEGNO = CPLib.GetProperty(p,"SEGNO",w_SEGNO,0);
      w_IDFILE = CPLib.GetProperty(p,"IDFILE",w_IDFILE,0);
      w_MTCN = CPLib.GetProperty(p,"MTCN",w_MTCN,0);
      w_TOTLIRE = CPLib.GetProperty(p,"TOTLIRE",w_TOTLIRE,0);
      w_TOTCONT = CPLib.GetProperty(p,"TOTCONT",w_TOTCONT,0);
      w_IDEREG = CPLib.GetProperty(p,"IDEREG",w_IDEREG,0);
      w_FLAGRAP = CPLib.GetProperty(p,"FLAGRAP",w_FLAGRAP,0);
      w_OPRAP = CPLib.GetProperty(p,"OPRAP",w_OPRAP,0);
      w_RAPPORTBEN = CPLib.GetProperty(p,"RAPPORTBEN",w_RAPPORTBEN,0);
      w_OPERATORE = CPLib.GetProperty(p,"OPERATORE",w_OPERATORE,0);
      w_AUTOM = CPLib.GetProperty(p,"AUTOM",w_AUTOM,0);
      w_FLAGRAP2 = CPLib.GetProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
      w_PRGIMPFRZ = CPLib.GetProperty(p,"PRGIMPFRZ",w_PRGIMPFRZ,0);
      op_PRGIMPFRZ = CPLib.GetProperty(p,"op_PRGIMPFRZ",0,0);
      w_IDBASE2 = CPLib.GetProperty(p,"IDBASE2",w_IDBASE2,0);
      w_NOPROT = CPLib.GetProperty(p,"NOPROT",w_NOPROT,0);
      w_OPERAG = CPLib.GetProperty(p,"OPERAG",w_OPERAG,0);
      w_RESPINS = CPLib.GetProperty(p,"RESPINS",w_RESPINS,0);
      w_INFORM = CPLib.GetProperty(p,"INFORM",w_INFORM,0);
      w_NATURA = CPLib.GetProperty(p,"NATURA",w_NATURA,0);
      w_SCOPO = CPLib.GetProperty(p,"SCOPO",w_SCOPO,0);
      w_SV58550 = CPLib.GetProperty(p,"SV58550",w_SV58550,0);
      w_SV58550MA = CPLib.GetProperty(p,"SV58550MA",w_SV58550MA,0);
      w_DURAT = CPLib.GetProperty(p,"DURAT",w_DURAT,0);
      w_AMMONT = CPLib.GetProperty(p,"AMMONT",w_AMMONT,0);
      w_AREAGEO = CPLib.GetProperty(p,"AREAGEO",w_AREAGEO,0);
      w_MODSVOL = CPLib.GetProperty(p,"MODSVOL",w_MODSVOL,0);
      w_RAGIO = CPLib.GetProperty(p,"RAGIO",w_RAGIO,0);
      w_TIPO = CPLib.GetProperty(p,"TIPO",w_TIPO,0);
      w_DUCOLLEG = CPLib.GetProperty(p,"DUCOLLEG",w_DUCOLLEG,0);
      w_ORACOLLEG = CPLib.GetProperty(p,"ORACOLLEG",w_ORACOLLEG,0);
      w_IPCOLLEG = CPLib.GetProperty(p,"IPCOLLEG",w_IPCOLLEG,0);
      w_MEZPAG = CPLib.GetProperty(p,"MEZPAG",w_MEZPAG,0);
      w_PRESTAZ = CPLib.GetProperty(p,"PRESTAZ",w_PRESTAZ,0);
      w_NOSARA = CPLib.GetProperty(p,"NOSARA",w_NOSARA,0);
      w_RFREQ = CPLib.GetProperty(p,"RFREQ",w_RFREQ,0);
      w_RIMP = CPLib.GetProperty(p,"RIMP",w_RIMP,0);
      w_RAREA = CPLib.GetProperty(p,"RAREA",w_RAREA,0);
      w_RCOMP = CPLib.GetProperty(p,"RCOMP",w_RCOMP,0);
      w_RRAGIO = CPLib.GetProperty(p,"RRAGIO",w_RRAGIO,0);
      w_RTIPO = CPLib.GetProperty(p,"RTIPO",w_RTIPO,0);
      w_RISGLOB = CPLib.GetProperty(p,"RISGLOB",w_RISGLOB,0);
      w_MITIG = CPLib.GetProperty(p,"MITIG",w_MITIG,0);
      w_MITIGDOC = CPLib.GetProperty(p,"MITIGDOC",w_MITIGDOC,0);
      w_DESPUNTO = CPLib.GetProperty(p,"DESPUNTO",w_DESPUNTO,0);
      w_CODCLICON = CPLib.GetProperty(p,"CODCLICON",w_CODCLICON,0);
      w_TIPATT = CPLib.GetProperty(p,"TIPATT",w_TIPATT,0);
      w_VASP = CPLib.GetProperty(p,"VASP",w_VASP,0);
      w_RIFIMP = CPLib.GetProperty(p,"RIFIMP",w_RIFIMP,0);
      w_xRAGSOCDOC = CPLib.GetProperty(p,"xRAGSOCDOC",w_xRAGSOCDOC,0);
      w_gIntemediario = CPLib.GetProperty(p,"gIntemediario",w_gIntemediario,0);
      w_gChkDate = CPLib.GetProperty(p,"gChkDate",w_gChkDate,0);
      w_gTipInter = CPLib.GetProperty(p,"gTipInter",w_gTipInter,0);
      w_gSblocco = CPLib.GetProperty(p,"gSblocco",w_gSblocco,0);
      w_gFlgWU = CPLib.GetProperty(p,"gFlgWU",w_gFlgWU,0);
      w_gStatus = CPLib.GetProperty(p,"gStatus",w_gStatus,0);
      w_gDataVaria = CPLib.GetProperty(p,"gDataVaria",w_gDataVaria,0);
      w_gFlgDoc = CPLib.GetProperty(p,"gFlgDoc",w_gFlgDoc,0);
      w_gFlgDTP = CPLib.GetProperty(p,"gFlgDTP",w_gFlgDTP,0);
      w_gSeekAos = CPLib.GetProperty(p,"gSeekAos",w_gSeekAos,0);
      w_gVerSim = CPLib.GetProperty(p,"gVerSim",w_gVerSim,0);
      w_dataoggi = CPLib.GetProperty(p,"dataoggi",w_dataoggi,0);
      w_filtro = CPLib.GetProperty(p,"filtro",w_filtro,0);
      w_sEdit = CPLib.GetProperty(p,"sEdit",w_sEdit,0);
      w_test = CPLib.GetProperty(p,"test",w_test,0);
      w_datpaseuro = CPLib.GetProperty(p,"datpaseuro",w_datpaseuro,0);
      w_tipope = CPLib.GetProperty(p,"tipope",w_tipope,0);
      w_stringaflagrap2 = CPLib.GetProperty(p,"stringaflagrap2",w_stringaflagrap2,0);
      w_apporeg = CPLib.GetProperty(p,"apporeg",w_apporeg,0);
      w_appolire = CPLib.GetProperty(p,"appolire",w_appolire,0);
      w_xTOTLIRE = CPLib.GetProperty(p,"xTOTLIRE",w_xTOTLIRE,0);
      w_xTOTCONT = CPLib.GetProperty(p,"xTOTCONT",w_xTOTCONT,0);
      w_xdestipleg = CPLib.GetProperty(p,"xdestipleg",w_xdestipleg,0);
      w_xragsocct = CPLib.GetProperty(p,"xragsocct",w_xragsocct,0);
      w_xDescDipe = CPLib.GetProperty(p,"xDescDipe",w_xDescDipe,0);
      w_descdiv = CPLib.GetProperty(p,"descdiv",w_descdiv,0);
      w_valflg2 = CPLib.GetProperty(p,"valflg2",w_valflg2,0);
      w_xragint2 = CPLib.GetProperty(p,"xragint2",w_xragint2,0);
      w_errmsg = CPLib.GetProperty(p,"errmsg",w_errmsg,0);
      w_CABINT = CPLib.GetProperty(p,"CABINT",w_CABINT,0);
      w_xragsocper = CPLib.GetProperty(p,"xragsocper",w_xragsocper,0);
      w_desccauana = CPLib.GetProperty(p,"desccauana",w_desccauana,0);
      w_xragsocben = CPLib.GetProperty(p,"xragsocben",w_xragsocben,0);
      w_xdesccausin = CPLib.GetProperty(p,"xdesccausin",w_xdesccausin,0);
      w_xdescpaese2 = CPLib.GetProperty(p,"xdescpaese2",w_xdescpaese2,0);
      w_xdescrap = CPLib.GetProperty(p,"xdescrap",w_xdescrap,0);
      w_xdes1 = CPLib.GetProperty(p,"xdes1",w_xdes1,0);
      w_xcodfisc = CPLib.GetProperty(p,"xcodfisc",w_xcodfisc,0);
      w_xdciticon = CPLib.GetProperty(p,"xdciticon",w_xdciticon,0);
      w_dessta = CPLib.GetProperty(p,"dessta",w_dessta,0);
      w_xragsocalt = CPLib.GetProperty(p,"xragsocalt",w_xragsocalt,0);
      w_xFLGITAEST = CPLib.GetProperty(p,"xFLGITAEST",w_xFLGITAEST,0);
      w_CITINT = CPLib.GetProperty(p,"CITINT",w_CITINT,0);
      w_CITDIP = CPLib.GetProperty(p,"CITDIP",w_CITDIP,0);
      w_PROVDIP = CPLib.GetProperty(p,"PROVDIP",w_PROVDIP,0);
      w_CABDIP = CPLib.GetProperty(p,"CABDIP",w_CABDIP,0);
      w_PROVINT = CPLib.GetProperty(p,"PROVINT",w_PROVINT,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_xdescopeage = CPLib.GetProperty(p,"xdescopeage",w_xdescopeage,0);
      w_xdescfreq = CPLib.GetProperty(p,"xdescfreq",w_xdescfreq,0);
      w_xdescammo = CPLib.GetProperty(p,"xdescammo",w_xdescammo,0);
      w_xdescareag = CPLib.GetProperty(p,"xdescareag",w_xdescareag,0);
      w_xdescmodsvo = CPLib.GetProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
      w_xdescplauso = CPLib.GetProperty(p,"xdescplauso",w_xdescplauso,0);
      w_xdesctipor = CPLib.GetProperty(p,"xdesctipor",w_xdesctipor,0);
      w_CALCOLI = CPLib.GetProperty(p,"CALCOLI",w_CALCOLI,0);
      w_COMPLETA = CPLib.GetProperty(p,"COMPLETA",w_COMPLETA,0);
      m_cWv_ardt_clientifrz = CPLib.GetProperty(p,"m_cWv_ardt_clientifrz",m_cWv_ardt_clientifrz,0);
      m_cWv_ardt_mlientifrz = CPLib.GetProperty(p,"m_cWv_ardt_mlientifrz",m_cWv_ardt_mlientifrz,0);
      m_cWv_ardt_sogopefraz = CPLib.GetProperty(p,"m_cWv_ardt_sogopefraz",m_cWv_ardt_sogopefraz,0);
      m_cWv_ardt_mogopefbo = CPLib.GetProperty(p,"m_cWv_ardt_mogopefbo",m_cWv_ardt_mogopefbo,0);
      m_cWv_ardt_meneficfrz = CPLib.GetProperty(p,"m_cWv_ardt_meneficfrz",m_cWv_ardt_meneficfrz,0);
      m_cWv_ardt_beneficfrz = CPLib.GetProperty(p,"m_cWv_ardt_beneficfrz",m_cWv_ardt_beneficfrz,0);
      m_cWv_ardt_terzistifrz = CPLib.GetProperty(p,"m_cWv_ardt_terzistifrz",m_cWv_ardt_terzistifrz,0);
      m_cWv_ardt_merzistifrz = CPLib.GetProperty(p,"m_cWv_ardt_merzistifrz",m_cWv_ardt_merzistifrz,0);
      m_cWv_ardt_docfrabo = CPLib.GetProperty(p,"m_cWv_ardt_docfrabo",m_cWv_ardt_docfrabo,0);
      m_cWv_armt_fraziobo_agg = CPLib.GetProperty(p,"m_cWv_armt_fraziobo_agg",m_cWv_armt_fraziobo_agg,0);
      m_cWv_ardt_frz_contante = CPLib.GetProperty(p,"m_cWv_ardt_frz_contante",m_cWv_ardt_frz_contante,0);
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
    items = tables.get("clientifrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("clientifrz",items);
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
    map.put("property.value",zeroSplit.split("clientifrz\u0000false\u0000false\u00001\u00000\u0000ardt_clientifrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("mlientifrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("mlientifrz",items);
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
    map.put("property.value",zeroSplit.split("mlientifrz\u0000false\u0000false\u00001\u00000\u0000ardt_mlientifrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("sogopefbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("sogopefbo",items);
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
    map.put("property.value",zeroSplit.split("sogopefbo\u0000false\u0000false\u00001\u00000\u0000ardt_sogopefraz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("mogopefbo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("mogopefbo",items);
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
    map.put("property.value",zeroSplit.split("mogopefbo\u0000false\u0000false\u00001\u00000\u0000ardt_mogopefbo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("meneficfrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("meneficfrz",items);
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
    map.put("property.value",zeroSplit.split("meneficfrz\u0000false\u0000false\u00001\u00000\u0000ardt_meneficfrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("beneficfrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("beneficfrz",items);
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
    map.put("property.value",zeroSplit.split("beneficfrz\u0000false\u0000false\u00001\u00000\u0000ardt_beneficfrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("terzistifrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("terzistifrz",items);
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
    map.put("property.value",zeroSplit.split("terzistifrz\u0000false\u0000false\u00001\u00000\u0000ardt_terzistifrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("merzistifrz");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("merzistifrz",items);
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
    map.put("property.value",zeroSplit.split("merzistifrz\u0000false\u0000false\u00001\u00000\u0000ardt_merzistifrz\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("docfrabo");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("docfrabo",items);
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
    map.put("property.value",zeroSplit.split("docfrabo\u0000false\u0000false\u00001\u00000\u0000ardt_docfrabo\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("fraziobo_agg");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("fraziobo_agg",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDBASE"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDBASE"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("1",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Segno",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("fraziobo_agg\u0000false\u0000false\u00001\u00000\u0000armt_fraziobo_agg\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("frz_contante");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("frz_contante",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"IDOPE"});
    map.put("rd_var",new String[]{"w_IDBASE"});
    map.put("wr_var",new String[]{"w_IDBASE"});
    map.put("wr_field",new String[]{"IDOPE"});
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
    map.put("property.value",zeroSplit.split("frz_contante\u0000false\u0000false\u00001\u00000\u0000ardt_frz_contante\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    items = tables.get("tbcauana");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcauana",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"idbase","CODCAU","CAUSINT","SEGNO","NOSARA","FLGINTER","DESCRI"});
    map.put("rd_var",new String[]{"w_idcauana","w_CODANA","w_CODVOC","w_SEGNO","w_NOSARA","w_xFLGITAEST","w_desccauana"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u00004\u00002\u00001\u00001\u00001\u0000165",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale\u0000Causale Analitica\u0000Causale Sintetica\u0000Segno\u0000Escludi operazioni soggetto da SARA\u0000I=Italia,E=Estero\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Causali Analitiche\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CODCAU","DESCRI"});
    map.put("rd_var",new String[]{"w_CODANA","w_desccauana"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4\u0000165",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Analitica\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcauana\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Causali Analitiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbcausin");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbcausin",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"CODVOC","DESCRIZ"});
    map.put("rd_var",new String[]{"w_CODVOC","w_xdesccausin"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2\u0000165",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Causale Sintetica\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcausin\u0000false\u0000false\u00001\u00000\u0000armt_causalis\u0000false\u0000false\u0000Causali Sintetiche\u0000\u0000\u0000false",-1));
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
    map.put("rd_var.comment",zeroSplit.split("B12. Divisa\u0000Descrizione",-1));
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
    map.put("rd_field",new String[]{"CONNES","RAGSOC","CONTO"});
    map.put("rd_var",new String[]{"w_CONNESBEN","w_xragsocben","w_C_RAPPORTO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("16\u000070\u000025",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Cliente Occasionale\u0000Ragione Sociale\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000campo",-1));
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
    map.put("rd_var.comment",zeroSplit.split("F14B. Comune Controparte\u0000F14A. CAB Controparte\u0000F14C. Provincia Controparte\u0000F13. Stato Controparte\u0000F16. CAP Controparte",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000iif(w_COMPLETA,At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0,False)\u0000",-1));
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
    map.put("rd_var.comment",zeroSplit.split("F13. Stato Controparte\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("iif(w_COMPLETA,At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0,False)\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_var.comment",zeroSplit.split("Codice Intermediario C/Parte\u0000A43. Denominazione Intermediario C/Parte\u0000A33A. CAB Intermediario C/Parte\u0000A33C. Provincia Intermediario C/Parte\u0000A32. Stato Intermediario C/Parte\u0000A31A. Tipo Intermediario C/Parte",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and Empty(w_CODINT2) and w_gVerSim='N' and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_xFLGITAEST = 'I' and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_xFLGITAEST = 'I' and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_CALCOLI",-1));
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
    map.put("rd_var.comment",zeroSplit.split("A32. Stato Intermediario C/Parte\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_CALCOLI\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    map.put("rd_var.comment",zeroSplit.split("A33A. CAB Intermediario C/Parte\u0000A33B. Comune Intermediario C/Parte\u0000A33C. Provincia Intermediario C/Parte\u0000Località",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_xFLGITAEST = 'I' and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_xFLGITAEST = 'I' and w_CALCOLI\u0000At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 and w_xFLGITAEST = 'I' and w_CALCOLI\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00002\u00000\u0000\u0000true\u0000false\u0000Città\u0000\u0000\u0000false",-1));
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
    map.put("property.value",zeroSplit.split("tbdurata_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Frequenza Operazione\u0000\u0000\u0000false",-1));
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
    map.put("property.value",zeroSplit.split("tbimporto_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Ammontare Operazione\u0000\u0000\u0000false",-1));
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
    map.put("property.value",zeroSplit.split("tbareegeog_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Area Geografica\u0000\u0000\u0000false",-1));
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
    map.put("property.value",zeroSplit.split("tbplauso_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Ragionevolezza Operazione\u0000\u0000\u0000false",-1));
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
    map.put("rd_var.len",zeroSplit.split("3\u00003",-1));
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
    map.put("property.value",zeroSplit.split("tbtiporisc_p\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Tipologia Rischio\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_ofrazionate",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_ofrazionate",child);
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
    ardt_clientifrz = new ardt_clientifrzBO(m_Ctx);
    ardt_mlientifrz = new ardt_mlientifrzBO(m_Ctx);
    ardt_sogopefraz = new ardt_sogopefrazBO(m_Ctx);
    ardt_mogopefbo = new ardt_mogopefboBO(m_Ctx);
    ardt_meneficfrz = new ardt_meneficfrzBO(m_Ctx);
    ardt_beneficfrz = new ardt_beneficfrzBO(m_Ctx);
    ardt_terzistifrz = new ardt_terzistifrzBO(m_Ctx);
    ardt_merzistifrz = new ardt_merzistifrzBO(m_Ctx);
    ardt_docfrabo = new ardt_docfraboBO(m_Ctx);
    armt_fraziobo_agg = new armt_fraziobo_aggBO(m_Ctx);
    ardt_frz_contante = new ardt_frz_contanteBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_ofrazionate",m_Ctx);
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
    if ((CPLib.Empty(w_DATAOPE)) || ( ! ((w_COMPLETA?CPLib.ge(w_DATAREG,w_DATAOPE):true)))) {
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
    } else if ((CPLib.ne(w_gChkDate,"U") && CPLib.ne(w_gChkDate,"B") && CPLib.eq(w_gFlgDTP,0)) && ((CPLib.Empty(w_DATAREG)) || ( ! ((w_COMPLETA?CPLib.ge(w_DATAREG,w_DATAOPE):true))))) {
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
    } else if (CPLib.Empty(w_idcauana)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_idcauana));
      String obblMsgError = m_Ctx.Translate("Causale")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_idcauana = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "idcauana";
      }
    } else if (CPLib.Empty(w_appolire)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_appolire));
      String obblMsgError = m_Ctx.Translate("B11. Tipo Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_appolire = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "appolire";
      }
    } else if (CPLib.Empty(w_VALUTA)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_VALUTA));
      String obblMsgError = m_Ctx.Translate("B12. Divisa")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_VALUTA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "VALUTA";
      }
    } else if (CPLib.Empty(w_xTOTLIRE)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_xTOTLIRE));
      String obblMsgError = m_Ctx.Translate("B14. Totale Euro")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_xTOTLIRE = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "xTOTLIRE";
      }
    } else if ((CPLib.eq(w_FLAGCONT,"1")) && (CPLib.Empty(w_xTOTCONT) && KUMAEYPETV_isObligatory())) {
      l_bNoObligatory =  ! (CPLib.Empty(w_xTOTCONT));
      String obblMsgError = m_Ctx.Translate("B15. di cui contanti")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_xTOTCONT = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "xTOTCONT";
      }
    } else if (CPLib.Empty(w_TIPOLEG) && WBHSORBZAV_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPOLEG));
      String obblMsgError = m_Ctx.Translate("Tipo Legame")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPOLEG = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPOLEG";
      }
    } else if (CPLib.Empty(w_C_RAG) && AWPNTOJIRR_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_C_RAG));
      String obblMsgError = m_Ctx.Translate("F11. Denominazione Controparte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_C_RAG = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "C_RAG";
      }
    } else if (CPLib.Empty(w_C_STA) && YVIKEGPYPM_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_C_STA));
      String obblMsgError = m_Ctx.Translate("F13. Stato Controparte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_C_STA = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "C_STA";
      }
    } else if (CPLib.Empty(w_TIPOINT2) && OBBUSHLGFO_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_TIPOINT2));
      String obblMsgError = m_Ctx.Translate("A31A. Tipo Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_TIPOINT2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "TIPOINT2";
      }
    } else if (CPLib.Empty(w_DESCINTER) && TYCTKKPTQQ_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DESCINTER));
      String obblMsgError = m_Ctx.Translate("A43. Denominazione Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DESCINTER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DESCINTER";
      }
    } else if (CPLib.Empty(w_PAESE) && MUTRCJYNJT_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PAESE));
      String obblMsgError = m_Ctx.Translate("A32. Stato Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PAESE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PAESE";
      }
    } else if (CPLib.Empty(w_CODCAB2) && CRVLITCYRD_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODCAB2));
      String obblMsgError = m_Ctx.Translate("A33A. CAB Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODCAB2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODCAB2";
      }
    } else if (CPLib.Empty(w_DESC2) && KDONRVZYMP_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_DESC2));
      String obblMsgError = m_Ctx.Translate("A33B. Comune Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_DESC2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "DESC2";
      }
    } else if (CPLib.Empty(w_PROV2) && HWGWORUQJF_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_PROV2));
      String obblMsgError = m_Ctx.Translate("A33C. Provincia Intermediario C/Parte")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_PROV2 = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PROV2";
      }
    } else if ( ! (Check_CUIIXQPPLV(true))) {
      l_bResult = false;
    } else if ( ! (Check_VTUPGRKHMU(true))) {
      l_bResult = false;
    } else if ( ! (Check_FBYJKRFVBE(true))) {
      l_bResult = false;
    } else if ( ! (Check_DUNXKFRTPZ(true))) {
      l_bResult = false;
    } else if ( ! (Check_CSHBHPWJQE(true))) {
      l_bResult = false;
    } else if ( ! (Check_ZZBVRHATAX(true))) {
      l_bResult = false;
    }
    if (l_bResult && (( ! (ardt_clientifrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_clientifrz)) || ( ! (ardt_clientifrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_clientifrz)))) {
      ardt_clientifrz.SetFromContext(m_cWv_ardt_clientifrz);
      m_cWv_ardt_clientifrz = "_not_empty_";
    }
    if (l_bResult && (ardt_clientifrz.m_bLoaded || ardt_clientifrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_clientifrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_clientifrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_mlientifrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_mlientifrz)) || ( ! (ardt_mlientifrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_mlientifrz)))) {
      ardt_mlientifrz.SetFromContext(m_cWv_ardt_mlientifrz);
      m_cWv_ardt_mlientifrz = "_not_empty_";
    }
    if (l_bResult && (ardt_mlientifrz.m_bLoaded || ardt_mlientifrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_mlientifrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_mlientifrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_sogopefraz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_sogopefraz)) || ( ! (ardt_sogopefraz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_sogopefraz)))) {
      ardt_sogopefraz.SetFromContext(m_cWv_ardt_sogopefraz);
      m_cWv_ardt_sogopefraz = "_not_empty_";
    }
    if (l_bResult && (ardt_sogopefraz.m_bLoaded || ardt_sogopefraz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_sogopefraz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_sogopefraz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_mogopefbo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_mogopefbo)) || ( ! (ardt_mogopefbo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_mogopefbo)))) {
      ardt_mogopefbo.SetFromContext(m_cWv_ardt_mogopefbo);
      m_cWv_ardt_mogopefbo = "_not_empty_";
    }
    if (l_bResult && (ardt_mogopefbo.m_bLoaded || ardt_mogopefbo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_mogopefbo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_mogopefbo.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_meneficfrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_meneficfrz)) || ( ! (ardt_meneficfrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_meneficfrz)))) {
      ardt_meneficfrz.SetFromContext(m_cWv_ardt_meneficfrz);
      m_cWv_ardt_meneficfrz = "_not_empty_";
    }
    if (l_bResult && (ardt_meneficfrz.m_bLoaded || ardt_meneficfrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_meneficfrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_meneficfrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_beneficfrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_beneficfrz)) || ( ! (ardt_beneficfrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_beneficfrz)))) {
      ardt_beneficfrz.SetFromContext(m_cWv_ardt_beneficfrz);
      m_cWv_ardt_beneficfrz = "_not_empty_";
    }
    if (l_bResult && (ardt_beneficfrz.m_bLoaded || ardt_beneficfrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_beneficfrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_beneficfrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_terzistifrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_terzistifrz)) || ( ! (ardt_terzistifrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_terzistifrz)))) {
      ardt_terzistifrz.SetFromContext(m_cWv_ardt_terzistifrz);
      m_cWv_ardt_terzistifrz = "_not_empty_";
    }
    if (l_bResult && (ardt_terzistifrz.m_bLoaded || ardt_terzistifrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_terzistifrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_terzistifrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_merzistifrz.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_merzistifrz)) || ( ! (ardt_merzistifrz.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_merzistifrz)))) {
      ardt_merzistifrz.SetFromContext(m_cWv_ardt_merzistifrz);
      m_cWv_ardt_merzistifrz = "_not_empty_";
    }
    if (l_bResult && (ardt_merzistifrz.m_bLoaded || ardt_merzistifrz.m_bUpdated)) {
      l_bResult = l_bResult && ardt_merzistifrz.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_merzistifrz.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_docfrabo.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_docfrabo)) || ( ! (ardt_docfrabo.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_docfrabo)))) {
      ardt_docfrabo.SetFromContext(m_cWv_ardt_docfrabo);
      m_cWv_ardt_docfrabo = "_not_empty_";
    }
    if (l_bResult && (ardt_docfrabo.m_bLoaded || ardt_docfrabo.m_bUpdated)) {
      l_bResult = l_bResult && ardt_docfrabo.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_docfrabo.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (armt_fraziobo_agg.m_bLoaded) && CPLib.IsLoaded(m_cWv_armt_fraziobo_agg)) || ( ! (armt_fraziobo_agg.m_bUpdated) && CPLib.IsUpdated(m_cWv_armt_fraziobo_agg)))) {
      armt_fraziobo_agg.SetFromContext(m_cWv_armt_fraziobo_agg);
      m_cWv_armt_fraziobo_agg = "_not_empty_";
    }
    if (l_bResult && (armt_fraziobo_agg.m_bLoaded || armt_fraziobo_agg.m_bUpdated)) {
      l_bResult = l_bResult && armt_fraziobo_agg.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = armt_fraziobo_agg.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_frz_contante.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_frz_contante)) || ( ! (ardt_frz_contante.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_frz_contante)))) {
      ardt_frz_contante.SetFromContext(m_cWv_ardt_frz_contante);
      m_cWv_ardt_frz_contante = "_not_empty_";
    }
    if (l_bResult && (ardt_frz_contante.m_bLoaded || ardt_frz_contante.m_bUpdated)) {
      l_bResult = l_bResult && ardt_frz_contante.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_frz_contante.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_ofrazionate"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_ofrazionate\\"+p_cState};
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
    l_bResult = CPLib.ne(p_cState,GetCurrentState()) || ((CPLib.eq(w_STATOREG,"0") || CPLib.eq(w_STATOREG,"1")));
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile modificare un'operazione frazionata già cancellata o copia di modifica";
    }
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = (CPLib.eq(w_STATOREG,"0") || CPLib.eq(w_STATOREG,"1"));
    if ( ! (l_bResult)) {
      m_cLastMsgError = "Impossibile cancellare un'operazione frazionata già cancellata o copia di modifica";
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
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void InitAutonumber() {
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PFRAZIO1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"PFRAZIO2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
    // For each autonumbered field set according to values in table CPWARN 
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
    // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    w_PRGIMPFRZ = m_Ctx.AskTableProg(w_PRGIMPFRZ,15,op_PRGIMPFRZ,"PRGIMPFRZ"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
    op_codazi = m_Ctx.GetCompany();
    op_IDBASE = w_IDBASE;
    op_NUMPROG = w_NUMPROG;
    op_PRGIMPFRZ = w_PRGIMPFRZ;
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
      w_IDBASE = m_Ctx.AskTableProg(w_IDBASE,10,op_IDBASE,"PFRAZIO1"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
      op_codazi = m_Ctx.GetCompany();
      op_IDBASE = w_IDBASE;
    }
    if (l_b1) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_NUMPROG = m_Ctx.AskTableProg(w_NUMPROG,11,op_NUMPROG,"PFRAZIO2"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
      op_NUMPROG = w_NUMPROG;
    }
    if (l_b2) {
      // For each autonumbered field set according to values in table CPWARN 
      // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno
      // lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
      w_PRGIMPFRZ = m_Ctx.AskTableProg(w_PRGIMPFRZ,15,op_PRGIMPFRZ,"PRGIMPFRZ"+"\\"+CPLib.ToCPWarnStr(m_Ctx.GetCompany(),10),m_cServer_fraziobo);
      op_PRGIMPFRZ = w_PRGIMPFRZ;
    }
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    op_IDBASE = "";
    op_NUMPROG = "";
    op_PRGIMPFRZ = 0;
    // Inizializzazione delle variabili per DependsOn
    o_filtro = "";
    o_CODINTER = "";
    o_CODDIPE = "";
    o_DATAOPE = CPLib.NullDate();
    o_CDATOPE = "";
    o_DATAREG = CPLib.NullDate();
    o_TIPOOPRAP = "";
    o_CODANA = "";
    o_CODVOC = "";
    o_FLAGLIRE = "";
    o_appolire = "";
    o_VALUTA = "";
    o_FLAGCONT = "";
    o_RAPPORTO = "";
    o_CONNESCLI = "";
    o_CONNESOPER = "";
    o_CONNESBEN = "";
    o_CONNALTRO = "";
    o_C_CTA = "";
    o_CODINT2 = "";
    o_SEGNO = "";
    o_DURAT = "";
    o_AMMONT = "";
    o_AREAGEO = "";
    o_MODSVOL = "";
    o_RAGIO = "";
    o_TIPO = "";
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
    CPLib.PutProperty(p,"CONNESDOC",w_CONNESDOC,0);
    CPLib.PutProperty(p,"IDBASE",w_IDBASE,0);
    CPLib.PutProperty(p,"op_IDBASE",op_IDBASE,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"DATAOPE",w_DATAOPE,0);
    CPLib.PutProperty(p,"NUMPROG",w_NUMPROG,0);
    CPLib.PutProperty(p,"op_NUMPROG",op_NUMPROG,0);
    CPLib.PutProperty(p,"CDATOPE",w_CDATOPE,0);
    CPLib.PutProperty(p,"CDATAOPE",w_CDATAOPE,0);
    CPLib.PutProperty(p,"ANNOOPE",w_ANNOOPE,0);
    CPLib.PutProperty(p,"DATAREG",w_DATAREG,0);
    CPLib.PutProperty(p,"CDATREG",w_CDATREG,0);
    CPLib.PutProperty(p,"FLAGFRAZ",w_FLAGFRAZ,0);
    CPLib.PutProperty(p,"COLLEG",w_COLLEG,0);
    CPLib.PutProperty(p,"TIPOOPRAP",w_TIPOOPRAP,0);
    CPLib.PutProperty(p,"idcauana",w_idcauana,0);
    CPLib.PutProperty(p,"CODANA",w_CODANA,0);
    CPLib.PutProperty(p,"CODVOC",w_CODVOC,0);
    CPLib.PutProperty(p,"FLAGLIRE",w_FLAGLIRE,0);
    CPLib.PutProperty(p,"VALUTA",w_VALUTA,0);
    CPLib.PutProperty(p,"FLAGCONT",w_FLAGCONT,0);
    CPLib.PutProperty(p,"CAMBIO",w_CAMBIO,0);
    CPLib.PutProperty(p,"IMPIN",w_IMPIN,0);
    CPLib.PutProperty(p,"IMPOUT",w_IMPOUT,0);
    CPLib.PutProperty(p,"RAPPORTO",w_RAPPORTO,0);
    CPLib.PutProperty(p,"CONNESCLI",w_CONNESCLI,0);
    CPLib.PutProperty(p,"PROQUOTA",w_PROQUOTA,0);
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
    CPLib.PutProperty(p,"DESC2",w_DESC2,0);
    CPLib.PutProperty(p,"PROV2",w_PROV2,0);
    CPLib.PutProperty(p,"ZCPARTE",w_ZCPARTE,0);
    CPLib.PutProperty(p,"STATOREG",w_STATOREG,0);
    CPLib.PutProperty(p,"DATARETT",w_DATARETT,0);
    CPLib.PutProperty(p,"OPERAZMOD",w_OPERAZMOD,0);
    CPLib.PutProperty(p,"TIPOINF",w_TIPOINF,0);
    CPLib.PutProperty(p,"SEGNO",w_SEGNO,0);
    CPLib.PutProperty(p,"IDFILE",w_IDFILE,0);
    CPLib.PutProperty(p,"MTCN",w_MTCN,0);
    CPLib.PutProperty(p,"TOTLIRE",w_TOTLIRE,0);
    CPLib.PutProperty(p,"TOTCONT",w_TOTCONT,0);
    CPLib.PutProperty(p,"IDEREG",w_IDEREG,0);
    CPLib.PutProperty(p,"FLAGRAP",w_FLAGRAP,0);
    CPLib.PutProperty(p,"OPRAP",w_OPRAP,0);
    CPLib.PutProperty(p,"RAPPORTBEN",w_RAPPORTBEN,0);
    CPLib.PutProperty(p,"OPERATORE",w_OPERATORE,0);
    CPLib.PutProperty(p,"AUTOM",w_AUTOM,0);
    CPLib.PutProperty(p,"FLAGRAP2",w_FLAGRAP2,0);
    CPLib.PutProperty(p,"PRGIMPFRZ",w_PRGIMPFRZ,0);
    CPLib.PutProperty(p,"op_PRGIMPFRZ",op_PRGIMPFRZ,0);
    CPLib.PutProperty(p,"IDBASE2",w_IDBASE2,0);
    CPLib.PutProperty(p,"NOPROT",w_NOPROT,0);
    CPLib.PutProperty(p,"OPERAG",w_OPERAG,0);
    CPLib.PutProperty(p,"RESPINS",w_RESPINS,0);
    CPLib.PutProperty(p,"INFORM",w_INFORM,0);
    CPLib.PutProperty(p,"NATURA",w_NATURA,0);
    CPLib.PutProperty(p,"SCOPO",w_SCOPO,0);
    CPLib.PutProperty(p,"SV58550",w_SV58550,0);
    CPLib.PutProperty(p,"SV58550MA",w_SV58550MA,0);
    CPLib.PutProperty(p,"DURAT",w_DURAT,0);
    CPLib.PutProperty(p,"AMMONT",w_AMMONT,0);
    CPLib.PutProperty(p,"AREAGEO",w_AREAGEO,0);
    CPLib.PutProperty(p,"MODSVOL",w_MODSVOL,0);
    CPLib.PutProperty(p,"RAGIO",w_RAGIO,0);
    CPLib.PutProperty(p,"TIPO",w_TIPO,0);
    CPLib.PutProperty(p,"DUCOLLEG",w_DUCOLLEG,0);
    CPLib.PutProperty(p,"ORACOLLEG",w_ORACOLLEG,0);
    CPLib.PutProperty(p,"IPCOLLEG",w_IPCOLLEG,0);
    CPLib.PutProperty(p,"MEZPAG",w_MEZPAG,0);
    CPLib.PutProperty(p,"PRESTAZ",w_PRESTAZ,0);
    CPLib.PutProperty(p,"NOSARA",w_NOSARA,0);
    CPLib.PutProperty(p,"RFREQ",w_RFREQ,0);
    CPLib.PutProperty(p,"RIMP",w_RIMP,0);
    CPLib.PutProperty(p,"RAREA",w_RAREA,0);
    CPLib.PutProperty(p,"RCOMP",w_RCOMP,0);
    CPLib.PutProperty(p,"RRAGIO",w_RRAGIO,0);
    CPLib.PutProperty(p,"RTIPO",w_RTIPO,0);
    CPLib.PutProperty(p,"RISGLOB",w_RISGLOB,0);
    CPLib.PutProperty(p,"MITIG",w_MITIG,0);
    CPLib.PutProperty(p,"MITIGDOC",w_MITIGDOC,0);
    CPLib.PutProperty(p,"DESPUNTO",w_DESPUNTO,0);
    CPLib.PutProperty(p,"CODCLICON",w_CODCLICON,0);
    CPLib.PutProperty(p,"TIPATT",w_TIPATT,0);
    CPLib.PutProperty(p,"VASP",w_VASP,0);
    CPLib.PutProperty(p,"RIFIMP",w_RIFIMP,0);
    CPLib.PutProperty(p,"xRAGSOCDOC",w_xRAGSOCDOC,0);
    CPLib.PutProperty(p,"gIntemediario",w_gIntemediario,0);
    CPLib.PutProperty(p,"gChkDate",w_gChkDate,0);
    CPLib.PutProperty(p,"gTipInter",w_gTipInter,0);
    CPLib.PutProperty(p,"gSblocco",w_gSblocco,0);
    CPLib.PutProperty(p,"gFlgWU",w_gFlgWU,0);
    CPLib.PutProperty(p,"gStatus",w_gStatus,0);
    CPLib.PutProperty(p,"gDataVaria",w_gDataVaria,0);
    CPLib.PutProperty(p,"gFlgDoc",w_gFlgDoc,0);
    CPLib.PutProperty(p,"gFlgDTP",w_gFlgDTP,0);
    CPLib.PutProperty(p,"gSeekAos",w_gSeekAos,0);
    CPLib.PutProperty(p,"gVerSim",w_gVerSim,0);
    CPLib.PutProperty(p,"dataoggi",w_dataoggi,0);
    CPLib.PutProperty(p,"filtro",w_filtro,0);
    CPLib.PutProperty(p,"sEdit",w_sEdit,0);
    CPLib.PutProperty(p,"test",w_test,0);
    CPLib.PutProperty(p,"datpaseuro",w_datpaseuro,0);
    CPLib.PutProperty(p,"tipope",w_tipope,0);
    CPLib.PutProperty(p,"stringaflagrap2",w_stringaflagrap2,0);
    CPLib.PutProperty(p,"apporeg",w_apporeg,0);
    CPLib.PutProperty(p,"appolire",w_appolire,0);
    CPLib.PutProperty(p,"xTOTLIRE",w_xTOTLIRE,0);
    CPLib.PutProperty(p,"xTOTCONT",w_xTOTCONT,0);
    CPLib.PutProperty(p,"xdestipleg",w_xdestipleg,0);
    CPLib.PutProperty(p,"xragsocct",w_xragsocct,0);
    CPLib.PutProperty(p,"xDescDipe",w_xDescDipe,0);
    CPLib.PutProperty(p,"descdiv",w_descdiv,0);
    CPLib.PutProperty(p,"valflg2",w_valflg2,0);
    CPLib.PutProperty(p,"xragint2",w_xragint2,0);
    CPLib.PutProperty(p,"errmsg",w_errmsg,0);
    CPLib.PutProperty(p,"CABINT",w_CABINT,0);
    CPLib.PutProperty(p,"xragsocper",w_xragsocper,0);
    CPLib.PutProperty(p,"desccauana",w_desccauana,0);
    CPLib.PutProperty(p,"xragsocben",w_xragsocben,0);
    CPLib.PutProperty(p,"xdesccausin",w_xdesccausin,0);
    CPLib.PutProperty(p,"xdescpaese2",w_xdescpaese2,0);
    CPLib.PutProperty(p,"xdescrap",w_xdescrap,0);
    CPLib.PutProperty(p,"xdes1",w_xdes1,0);
    CPLib.PutProperty(p,"xcodfisc",w_xcodfisc,0);
    CPLib.PutProperty(p,"xdciticon",w_xdciticon,0);
    CPLib.PutProperty(p,"dessta",w_dessta,0);
    CPLib.PutProperty(p,"xragsocalt",w_xragsocalt,0);
    CPLib.PutProperty(p,"xFLGITAEST",w_xFLGITAEST,0);
    CPLib.PutProperty(p,"CITINT",w_CITINT,0);
    CPLib.PutProperty(p,"CITDIP",w_CITDIP,0);
    CPLib.PutProperty(p,"PROVDIP",w_PROVDIP,0);
    CPLib.PutProperty(p,"CABDIP",w_CABDIP,0);
    CPLib.PutProperty(p,"PROVINT",w_PROVINT,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"xdescopeage",w_xdescopeage,0);
    CPLib.PutProperty(p,"xdescfreq",w_xdescfreq,0);
    CPLib.PutProperty(p,"xdescammo",w_xdescammo,0);
    CPLib.PutProperty(p,"xdescareag",w_xdescareag,0);
    CPLib.PutProperty(p,"xdescmodsvo",w_xdescmodsvo,0);
    CPLib.PutProperty(p,"xdescplauso",w_xdescplauso,0);
    CPLib.PutProperty(p,"xdesctipor",w_xdesctipor,0);
    CPLib.PutProperty(p,"CALCOLI",w_CALCOLI,0);
    CPLib.PutProperty(p,"COMPLETA",w_COMPLETA,0);
    if (p_bGetChildren) {
      if (ardt_clientifrz.IsUpdated()) {
        m_cWv_ardt_clientifrz = ardt_clientifrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_clientifrz",m_cWv_ardt_clientifrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_mlientifrz.IsUpdated()) {
        m_cWv_ardt_mlientifrz = ardt_mlientifrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_mlientifrz",m_cWv_ardt_mlientifrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_sogopefraz.IsUpdated()) {
        m_cWv_ardt_sogopefraz = ardt_sogopefraz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_sogopefraz",m_cWv_ardt_sogopefraz,0);
    }
    if (p_bGetChildren) {
      if (ardt_mogopefbo.IsUpdated()) {
        m_cWv_ardt_mogopefbo = ardt_mogopefbo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_mogopefbo",m_cWv_ardt_mogopefbo,0);
    }
    if (p_bGetChildren) {
      if (ardt_meneficfrz.IsUpdated()) {
        m_cWv_ardt_meneficfrz = ardt_meneficfrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_meneficfrz",m_cWv_ardt_meneficfrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_beneficfrz.IsUpdated()) {
        m_cWv_ardt_beneficfrz = ardt_beneficfrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_beneficfrz",m_cWv_ardt_beneficfrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_terzistifrz.IsUpdated()) {
        m_cWv_ardt_terzistifrz = ardt_terzistifrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_terzistifrz",m_cWv_ardt_terzistifrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_merzistifrz.IsUpdated()) {
        m_cWv_ardt_merzistifrz = ardt_merzistifrz.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_merzistifrz",m_cWv_ardt_merzistifrz,0);
    }
    if (p_bGetChildren) {
      if (ardt_docfrabo.IsUpdated()) {
        m_cWv_ardt_docfrabo = ardt_docfrabo.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_docfrabo",m_cWv_ardt_docfrabo,0);
    }
    if (p_bGetChildren) {
      if (armt_fraziobo_agg.IsUpdated()) {
        m_cWv_armt_fraziobo_agg = armt_fraziobo_agg.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_armt_fraziobo_agg",m_cWv_armt_fraziobo_agg,0);
    }
    if (p_bGetChildren) {
      if (ardt_frz_contante.IsUpdated()) {
        m_cWv_ardt_frz_contante = ardt_frz_contante.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_frz_contante",m_cWv_ardt_frz_contante,0);
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
    return "fraziobo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("IDBASE","C",10,0));
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
    oneAutoNum.add("PFRAZIO1");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_NUMPROG");
    oneAutoNum.add("PFRAZIO2");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    oneAutoNum = new ArrayList<String>();
    oneAutoNum.add("i_codazi,w_PRGIMPFRZ");
    oneAutoNum.add("PRGIMPFRZ");
    oneAutoNum.add("");
    autonums.add(oneAutoNum);
    return autonums;
  }
  public boolean ChildExists_ardt_clientifrz() {
    if (ardt_clientifrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_clientifrz) || CPLib.IsLoaded(m_cWv_ardt_clientifrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_clientifrz.m_bLoaded)) {
      ardt_clientifrz.Blank();
      ardt_clientifrz.w_IDFILEBO = w_IDBASE;
      ardt_clientifrz.Load();
    }
    return ardt_clientifrz.m_bLoaded;
  }
  public void CtxLoad_ardt_clientifrz() {
    if ( ! (ardt_clientifrz.m_lCtxLoaded)) {
      ardt_clientifrz.Blank();
    }
    ardt_clientifrz.m_lCtxLoaded = true;
    if ( ! (ardt_clientifrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_clientifrz) || CPLib.IsLoaded(m_cWv_ardt_clientifrz)) {
        ardt_clientifrz.SetFromContext(m_cWv_ardt_clientifrz);
        m_cWv_ardt_clientifrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_clientifrz.m_bLoaded)) {
          ardt_clientifrz.Blank();
          ardt_clientifrz.w_IDFILEBO = w_IDBASE;
          ardt_clientifrz.Load();
          if ( ! (ardt_clientifrz.m_bLoaded)) {
            ardt_clientifrz.Initialize();
            ardt_clientifrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_mlientifrz() {
    if (ardt_mlientifrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_mlientifrz) || CPLib.IsLoaded(m_cWv_ardt_mlientifrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_mlientifrz.m_bLoaded)) {
      ardt_mlientifrz.Blank();
      ardt_mlientifrz.w_IDFILEBO = w_IDBASE;
      ardt_mlientifrz.Load();
    }
    return ardt_mlientifrz.m_bLoaded;
  }
  public void CtxLoad_ardt_mlientifrz() {
    if ( ! (ardt_mlientifrz.m_lCtxLoaded)) {
      ardt_mlientifrz.Blank();
    }
    ardt_mlientifrz.m_lCtxLoaded = true;
    if ( ! (ardt_mlientifrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_mlientifrz) || CPLib.IsLoaded(m_cWv_ardt_mlientifrz)) {
        ardt_mlientifrz.SetFromContext(m_cWv_ardt_mlientifrz);
        m_cWv_ardt_mlientifrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_mlientifrz.m_bLoaded)) {
          ardt_mlientifrz.Blank();
          ardt_mlientifrz.w_IDFILEBO = w_IDBASE;
          ardt_mlientifrz.Load();
          if ( ! (ardt_mlientifrz.m_bLoaded)) {
            ardt_mlientifrz.Initialize();
            ardt_mlientifrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_sogopefraz() {
    if (ardt_sogopefraz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_sogopefraz) || CPLib.IsLoaded(m_cWv_ardt_sogopefraz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_sogopefraz.m_bLoaded)) {
      ardt_sogopefraz.Blank();
      ardt_sogopefraz.w_IDFILEBO = w_IDBASE;
      ardt_sogopefraz.Load();
    }
    return ardt_sogopefraz.m_bLoaded;
  }
  public void CtxLoad_ardt_sogopefraz() {
    if ( ! (ardt_sogopefraz.m_lCtxLoaded)) {
      ardt_sogopefraz.Blank();
    }
    ardt_sogopefraz.m_lCtxLoaded = true;
    if ( ! (ardt_sogopefraz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_sogopefraz) || CPLib.IsLoaded(m_cWv_ardt_sogopefraz)) {
        ardt_sogopefraz.SetFromContext(m_cWv_ardt_sogopefraz);
        m_cWv_ardt_sogopefraz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_sogopefraz.m_bLoaded)) {
          ardt_sogopefraz.Blank();
          ardt_sogopefraz.w_IDFILEBO = w_IDBASE;
          ardt_sogopefraz.Load();
          if ( ! (ardt_sogopefraz.m_bLoaded)) {
            ardt_sogopefraz.Initialize();
            ardt_sogopefraz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_mogopefbo() {
    if (ardt_mogopefbo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_mogopefbo) || CPLib.IsLoaded(m_cWv_ardt_mogopefbo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_mogopefbo.m_bLoaded)) {
      ardt_mogopefbo.Blank();
      ardt_mogopefbo.w_IDFILEBO = w_IDBASE;
      ardt_mogopefbo.Load();
    }
    return ardt_mogopefbo.m_bLoaded;
  }
  public void CtxLoad_ardt_mogopefbo() {
    if ( ! (ardt_mogopefbo.m_lCtxLoaded)) {
      ardt_mogopefbo.Blank();
    }
    ardt_mogopefbo.m_lCtxLoaded = true;
    if ( ! (ardt_mogopefbo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_mogopefbo) || CPLib.IsLoaded(m_cWv_ardt_mogopefbo)) {
        ardt_mogopefbo.SetFromContext(m_cWv_ardt_mogopefbo);
        m_cWv_ardt_mogopefbo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_mogopefbo.m_bLoaded)) {
          ardt_mogopefbo.Blank();
          ardt_mogopefbo.w_IDFILEBO = w_IDBASE;
          ardt_mogopefbo.Load();
          if ( ! (ardt_mogopefbo.m_bLoaded)) {
            ardt_mogopefbo.Initialize();
            ardt_mogopefbo.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_meneficfrz() {
    if (ardt_meneficfrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_meneficfrz) || CPLib.IsLoaded(m_cWv_ardt_meneficfrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_meneficfrz.m_bLoaded)) {
      ardt_meneficfrz.Blank();
      ardt_meneficfrz.w_IDFILEBO = w_IDBASE;
      ardt_meneficfrz.Load();
    }
    return ardt_meneficfrz.m_bLoaded;
  }
  public void CtxLoad_ardt_meneficfrz() {
    if ( ! (ardt_meneficfrz.m_lCtxLoaded)) {
      ardt_meneficfrz.Blank();
    }
    ardt_meneficfrz.m_lCtxLoaded = true;
    if ( ! (ardt_meneficfrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_meneficfrz) || CPLib.IsLoaded(m_cWv_ardt_meneficfrz)) {
        ardt_meneficfrz.SetFromContext(m_cWv_ardt_meneficfrz);
        m_cWv_ardt_meneficfrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_meneficfrz.m_bLoaded)) {
          ardt_meneficfrz.Blank();
          ardt_meneficfrz.w_IDFILEBO = w_IDBASE;
          ardt_meneficfrz.Load();
          if ( ! (ardt_meneficfrz.m_bLoaded)) {
            ardt_meneficfrz.Initialize();
            ardt_meneficfrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_beneficfrz() {
    if (ardt_beneficfrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_beneficfrz) || CPLib.IsLoaded(m_cWv_ardt_beneficfrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_beneficfrz.m_bLoaded)) {
      ardt_beneficfrz.Blank();
      ardt_beneficfrz.w_IDFILEBO = w_IDBASE;
      ardt_beneficfrz.Load();
    }
    return ardt_beneficfrz.m_bLoaded;
  }
  public void CtxLoad_ardt_beneficfrz() {
    if ( ! (ardt_beneficfrz.m_lCtxLoaded)) {
      ardt_beneficfrz.Blank();
    }
    ardt_beneficfrz.m_lCtxLoaded = true;
    if ( ! (ardt_beneficfrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_beneficfrz) || CPLib.IsLoaded(m_cWv_ardt_beneficfrz)) {
        ardt_beneficfrz.SetFromContext(m_cWv_ardt_beneficfrz);
        m_cWv_ardt_beneficfrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_beneficfrz.m_bLoaded)) {
          ardt_beneficfrz.Blank();
          ardt_beneficfrz.w_IDFILEBO = w_IDBASE;
          ardt_beneficfrz.Load();
          if ( ! (ardt_beneficfrz.m_bLoaded)) {
            ardt_beneficfrz.Initialize();
            ardt_beneficfrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_terzistifrz() {
    if (ardt_terzistifrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_terzistifrz) || CPLib.IsLoaded(m_cWv_ardt_terzistifrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_terzistifrz.m_bLoaded)) {
      ardt_terzistifrz.Blank();
      ardt_terzistifrz.w_IDFILEBO = w_IDBASE;
      ardt_terzistifrz.Load();
    }
    return ardt_terzistifrz.m_bLoaded;
  }
  public void CtxLoad_ardt_terzistifrz() {
    if ( ! (ardt_terzistifrz.m_lCtxLoaded)) {
      ardt_terzistifrz.Blank();
    }
    ardt_terzistifrz.m_lCtxLoaded = true;
    if ( ! (ardt_terzistifrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_terzistifrz) || CPLib.IsLoaded(m_cWv_ardt_terzistifrz)) {
        ardt_terzistifrz.SetFromContext(m_cWv_ardt_terzistifrz);
        m_cWv_ardt_terzistifrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_terzistifrz.m_bLoaded)) {
          ardt_terzistifrz.Blank();
          ardt_terzistifrz.w_IDFILEBO = w_IDBASE;
          ardt_terzistifrz.Load();
          if ( ! (ardt_terzistifrz.m_bLoaded)) {
            ardt_terzistifrz.Initialize();
            ardt_terzistifrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_merzistifrz() {
    if (ardt_merzistifrz.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_merzistifrz) || CPLib.IsLoaded(m_cWv_ardt_merzistifrz))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_merzistifrz.m_bLoaded)) {
      ardt_merzistifrz.Blank();
      ardt_merzistifrz.w_IDFILEBO = w_IDBASE;
      ardt_merzistifrz.Load();
    }
    return ardt_merzistifrz.m_bLoaded;
  }
  public void CtxLoad_ardt_merzistifrz() {
    if ( ! (ardt_merzistifrz.m_lCtxLoaded)) {
      ardt_merzistifrz.Blank();
    }
    ardt_merzistifrz.m_lCtxLoaded = true;
    if ( ! (ardt_merzistifrz.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_merzistifrz) || CPLib.IsLoaded(m_cWv_ardt_merzistifrz)) {
        ardt_merzistifrz.SetFromContext(m_cWv_ardt_merzistifrz);
        m_cWv_ardt_merzistifrz = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_merzistifrz.m_bLoaded)) {
          ardt_merzistifrz.Blank();
          ardt_merzistifrz.w_IDFILEBO = w_IDBASE;
          ardt_merzistifrz.Load();
          if ( ! (ardt_merzistifrz.m_bLoaded)) {
            ardt_merzistifrz.Initialize();
            ardt_merzistifrz.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_docfrabo() {
    if (ardt_docfrabo.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_docfrabo) || CPLib.IsLoaded(m_cWv_ardt_docfrabo))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_docfrabo.m_bLoaded)) {
      ardt_docfrabo.Blank();
      ardt_docfrabo.w_NUMPROG = w_NUMPROG;
      ardt_docfrabo.Load();
    }
    return ardt_docfrabo.m_bLoaded;
  }
  public void CtxLoad_ardt_docfrabo() {
    if ( ! (ardt_docfrabo.m_lCtxLoaded)) {
      ardt_docfrabo.Blank();
    }
    ardt_docfrabo.m_lCtxLoaded = true;
    if ( ! (ardt_docfrabo.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_docfrabo) || CPLib.IsLoaded(m_cWv_ardt_docfrabo)) {
        ardt_docfrabo.SetFromContext(m_cWv_ardt_docfrabo);
        m_cWv_ardt_docfrabo = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_docfrabo.m_bLoaded)) {
          ardt_docfrabo.Blank();
          ardt_docfrabo.w_NUMPROG = w_NUMPROG;
          ardt_docfrabo.Load();
          if ( ! (ardt_docfrabo.m_bLoaded)) {
            ardt_docfrabo.Initialize();
            ardt_docfrabo.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_armt_fraziobo_agg() {
    if (armt_fraziobo_agg.IsUpdated() || (CPLib.IsUpdated(m_cWv_armt_fraziobo_agg) || CPLib.IsLoaded(m_cWv_armt_fraziobo_agg))) {
      return true;
    } else if (m_bLoaded &&  ! (armt_fraziobo_agg.m_bLoaded)) {
      armt_fraziobo_agg.Blank();
      armt_fraziobo_agg.w_IDBASE = w_IDBASE;
      armt_fraziobo_agg.Load();
    }
    return armt_fraziobo_agg.m_bLoaded;
  }
  public void CtxLoad_armt_fraziobo_agg() {
    if ( ! (armt_fraziobo_agg.m_lCtxLoaded)) {
      armt_fraziobo_agg.Blank();
    }
    armt_fraziobo_agg.m_lCtxLoaded = true;
    if ( ! (armt_fraziobo_agg.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_armt_fraziobo_agg) || CPLib.IsLoaded(m_cWv_armt_fraziobo_agg)) {
        armt_fraziobo_agg.SetFromContext(m_cWv_armt_fraziobo_agg);
        m_cWv_armt_fraziobo_agg = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (armt_fraziobo_agg.m_bLoaded)) {
          armt_fraziobo_agg.Blank();
          armt_fraziobo_agg.w_IDBASE = w_IDBASE;
          armt_fraziobo_agg.Load();
          if ( ! (armt_fraziobo_agg.m_bLoaded)) {
            armt_fraziobo_agg.Initialize();
            armt_fraziobo_agg.SetUpdated();
          }
          CopyWorkVar(this,armt_fraziobo_agg,new String[]{"SEGNO"},new String[]{"SEGNO"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,armt_fraziobo_agg,new String[]{"SEGNO"},new String[]{"SEGNO"},true);
        }
      }
    }
  }
  public boolean ChildExists_ardt_frz_contante() {
    if (ardt_frz_contante.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_frz_contante) || CPLib.IsLoaded(m_cWv_ardt_frz_contante))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_frz_contante.m_bLoaded)) {
      ardt_frz_contante.Blank();
      ardt_frz_contante.w_IDOPE = w_IDBASE;
      ardt_frz_contante.Load();
    }
    return ardt_frz_contante.m_bLoaded;
  }
  public void CtxLoad_ardt_frz_contante() {
    if ( ! (ardt_frz_contante.m_lCtxLoaded)) {
      ardt_frz_contante.Blank();
    }
    ardt_frz_contante.m_lCtxLoaded = true;
    if ( ! (ardt_frz_contante.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_frz_contante) || CPLib.IsLoaded(m_cWv_ardt_frz_contante)) {
        ardt_frz_contante.SetFromContext(m_cWv_ardt_frz_contante);
        m_cWv_ardt_frz_contante = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_frz_contante.m_bLoaded)) {
          ardt_frz_contante.Blank();
          ardt_frz_contante.w_IDOPE = w_IDBASE;
          ardt_frz_contante.Load();
          if ( ! (ardt_frz_contante.m_bLoaded)) {
            ardt_frz_contante.Initialize();
            ardt_frz_contante.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_clientifrz")) {
      CtxLoad_ardt_clientifrz();
      return ardt_clientifrz;
    }
    if (CPLib.eq(p_cName,"ardt_mlientifrz")) {
      CtxLoad_ardt_mlientifrz();
      return ardt_mlientifrz;
    }
    if (CPLib.eq(p_cName,"ardt_sogopefraz")) {
      CtxLoad_ardt_sogopefraz();
      return ardt_sogopefraz;
    }
    if (CPLib.eq(p_cName,"ardt_mogopefbo")) {
      CtxLoad_ardt_mogopefbo();
      return ardt_mogopefbo;
    }
    if (CPLib.eq(p_cName,"ardt_meneficfrz")) {
      CtxLoad_ardt_meneficfrz();
      return ardt_meneficfrz;
    }
    if (CPLib.eq(p_cName,"ardt_beneficfrz")) {
      CtxLoad_ardt_beneficfrz();
      return ardt_beneficfrz;
    }
    if (CPLib.eq(p_cName,"ardt_terzistifrz")) {
      CtxLoad_ardt_terzistifrz();
      return ardt_terzistifrz;
    }
    if (CPLib.eq(p_cName,"ardt_merzistifrz")) {
      CtxLoad_ardt_merzistifrz();
      return ardt_merzistifrz;
    }
    if (CPLib.eq(p_cName,"ardt_docfrabo")) {
      CtxLoad_ardt_docfrabo();
      return ardt_docfrabo;
    }
    if (CPLib.eq(p_cName,"armt_fraziobo_agg")) {
      CtxLoad_armt_fraziobo_agg();
      return armt_fraziobo_agg;
    }
    if (CPLib.eq(p_cName,"ardt_frz_contante")) {
      CtxLoad_ardt_frz_contante();
      return ardt_frz_contante;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
