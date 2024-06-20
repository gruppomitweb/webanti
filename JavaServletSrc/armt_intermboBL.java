import java.util.*;

public class armt_intermboBL extends armt_intermboWV implements CPLib.QueryFilterFromApplication {
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
  public static final String i_EntityName = "armt_intermbo";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public CPPhTableWrInfo m_oWrInfo_intermbo;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public CPPhTableWrInfo m_oWrInfo_anadip;
  public String m_cPhName_tbcandistr;
  public String m_cServer_tbcandistr;
  public CPPhTableWrInfo m_oWrInfo_tbcandistr;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public CPPhTableWrInfo m_oWrInfo_tbcitta;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public CPPhTableWrInfo m_oWrInfo_tbramgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public CPPhTableWrInfo m_oWrInfo_tbsetsin;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public CPPhTableWrInfo m_oWrInfo_tbstati;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public CPPhTableWrInfo m_oWrInfo_tbstgru;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public CPPhTableWrInfo m_oWrInfo_tbtipdoc;
  public String m_cPhName_tbtipint;
  public String m_cServer_tbtipint;
  public CPPhTableWrInfo m_oWrInfo_tbtipint;
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public CPPhTableWrInfo m_oWrInfo_cgo_tbtipgio;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"intermbo"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'TIPINTER':TIPINTER,'RAGSOC':RAGSOC,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'PAESE':PAESE,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'DATANASC':DATANASC,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'SETTSINT':SETTSINT,'TIPODOC':TIPODOC,'SESSO':SESSO,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'AUTRILASC':AUTRILASC,'CODDIPE':CODDIPE,'NOTE':NOTE,'CODORO':CODORO,'CODINTER':CODINTER,'DATAVALI':DATAVALI,'CFINVIO':CFINVIO,'CAFINVIO':CAFINVIO,'FILEINVIO':FILEINVIO,'DATAINVIO':DATAINVIO,'IDSID':IDSID,'SIDPASS':SIDPASS,'PATHJAVA':PATHJAVA,'TIPOINST':TIPOINST,'FLGSIDAUTO':FLGSIDAUTO,'appocert':appocert,'TIPOSV':TIPOSV,'LIMITE20':LIMITE20,'CODVASP':CODVASP,'ART1':ART1,'URLAPPL':URLAPPL,'FLGLOG':FLGLOG,'FLGAOS':FLGAOS,'FLGEAOS':FLGEAOS,'FLGCDOC':FLGCDOC,'FLGFRAZ':FLGFRAZ,'FLGAPERS':FLGAPERS,'DTINIATT':DTINIATT,'FLGTIPIMP':FLGTIPIMP,'FLGSTPCON':FLGSTPCON,'FLGIMPAGE':FLGIMPAGE,'FLGWU':FLGWU,'IMPINTOPE':IMPINTOPE,'FLGOPEXTR':FLGOPEXTR,'FLGRAPCLI':FLGRAPCLI,'NOCODFISC':NOCODFISC,'FLGCHK':FLGCHK,'PWDSER':PWDSER,'SOSPMAF':SOSPMAF,'FLGRITORNO':FLGRITORNO,'FLGCREAAGE':FLGCREAAGE,'DTTITAGE':DTTITAGE,'SCADSALDI':SCADSALDI,'FLGIPMT':FLGIPMT,'LIMITEFRZ':LIMITEFRZ,'DBPROT':DBPROT,'OAMTPDOC':OAMTPDOC,'DAYSIMPORT':DAYSIMPORT,'DAYSIMPCMB':DAYSIMPCMB,'FLGAWUPOS':FLGAWUPOS,'WUGIOSCA':WUGIOSCA,'WUGGALERT':WUGGALERT,'RICEVUTE':RICEVUTE,'OGGI3I4':OGGI3I4,'CGOTGDEFMUL':CGOTGDEFMUL,'AUTOSARA':AUTOSARA,'FLGCGOOTP':FLGCGOOTP,'ITFLGPEP':ITFLGPEP,'ITPWDPEP':ITPWDPEP,'ITUSRPEP':ITUSRPEP,'FLGAGGFAM':FLGAGGFAM,'ALTSRVMAIL':ALTSRVMAIL,'ALTPRTMAIL':ALTPRTMAIL,'ALTEMLMAIL':ALTEMLMAIL,'ALTUSRMAIL':ALTUSRMAIL,'ALTPWDMAIL':ALTPWDMAIL,'ALTSSLEMAIL':ALTSSLEMAIL,'PATHIMPORT':PATHIMPORT,'DESTEMAIL':DESTEMAIL,'COGNOME':COGNOME,'NOME':NOME,'DNASC':DNASC,'CITTADINA':CITTADINA,'NASCOMUN':NASCOMUN,'NASSTATO':NASSTATO,'PRNASC':PRNASC,'SOGCOM':SOGCOM,'BPCODPAT':BPCODPAT,'BPENTSEG':BPENTSEG,'BPCOGSEG':BPCOGSEG,'BPNOMSEG':BPNOMSEG,'BPTELSEG':BPTELSEG,'BPEMLSEG':BPEMLSEG,'ABI':ABI,'CAB':CAB,'ardt_destwarn':ardt_destwarn,'GGWARNPRV':GGWARNPRV,'GGWARNAUI':GGWARNAUI,'SOGLIAMAX':SOGLIAMAX,'IDOAM':IDOAM,'IDOAMR':IDOAMR,'SKT_SERVER':SKT_SERVER,'SKT_PORT':SKT_PORT,'SKT_PATHS':SKT_PATHS,'SKT_MODET':SKT_MODET,'RASPAUI':RASPAUI,'RESPAUI':RESPAUI,'TESTIP':TESTIP,'MINFRZSNAI':MINFRZSNAI,'FLGSCDFRZ':FLGSCDFRZ,'GIORNIFRZ':GIORNIFRZ,'LIMITVLT':LIMITVLT,'LIMITVNP':LIMITVNP,'FLGSTPDIR':FLGSTPDIR,'FLGNODOC':FLGNODOC,'FRAZDEL':FRAZDEL,'PATHAPP':PATHAPP,'FLGLIGHT':FLGLIGHT,'pathmanuale':pathmanuale,'FLGCGOPWD':FLGCGOPWD,'PATHSID':PATHSID,'PATHCERT':PATHCERT,'PATHFTP':PATHFTP,'FLGUTEAGE':FLGUTEAGE,'PRGAEPATH':PRGAEPATH,'NUMGIORN':NUMGIORN,'FLGCGOQADV':FLGCGOQADV,'BLOCCOUSER':BLOCCOUSER,'CGOFLGPROF':CGOFLGPROF,'FLGGESDOC':FLGGESDOC,'USRGESDOC':USRGESDOC,'PWDGESDOC':PWDGESDOC,'URLDESDOC':URLDESDOC,'EMAILDOC':EMAILDOC,'ardt_cgo_tipall':ardt_cgo_tipall,'DATADOC':DATADOC,'ardt_cgo_subnets':ardt_cgo_subnets,'PATHDOCBAC':PATHDOCBAC,'IMPPATH':IMPPATH,'SONUMMESI':SONUMMESI,'SOMESIBACK':SOMESIBACK,'SOSHELLCMD':SOSHELLCMD,'SOAMBIENTE':SOAMBIENTE,'ardt_destemail':ardt_destemail,'SOPATHIMPORT':SOPATHIMPORT,'SOORAIMPORT':SOORAIMPORT,'QADV_SOGLIA':QADV_SOGLIA"+FoundlingChildrenList("armt_intermbo",true)+"}";
  public static final String i_CompleteStateStructure = "{'TIPINTER':TIPINTER,'RAGSOC':RAGSOC,'DESCCIT':DESCCIT,'PROVINCIA':PROVINCIA,'CAP':CAP,'CODCAB':CODCAB,'DOMICILIO':DOMICILIO,'PAESE':PAESE,'CODFISC':CODFISC,'PARTIVA':PARTIVA,'DATANASC':DATANASC,'SOTGRUP':SOTGRUP,'RAMOGRUP':RAMOGRUP,'SETTSINT':SETTSINT,'TIPODOC':TIPODOC,'SESSO':SESSO,'NUMDOCUM':NUMDOCUM,'DATARILASC':DATARILASC,'AUTRILASC':AUTRILASC,'CODDIPE':CODDIPE,'CONNES':CONNES,'NOTE':NOTE,'CODORO':CODORO,'CODINTER':CODINTER,'TIPOPERS':TIPOPERS,'IDCITTA':IDCITTA,'DESCRIsta':DESCRIsta,'DESCSGRU':DESCSGRU,'DESCRAMGRU':DESCRAMGRU,'DESCUIC':DESCUIC,'descdip':descdip,'tipsot':tipsot,'xdescitdip':xdescitdip,'xcabdip':xcabdip,'DATAVALI':DATAVALI,'gUserCode':gUserCode,'CONTATORE':CONTATORE,'ATTIV':ATTIV,'CFINVIO':CFINVIO,'CAFINVIO':CAFINVIO,'FILEINVIO':FILEINVIO,'DATAINVIO':DATAINVIO,'IDSID':IDSID,'SIDPASS':SIDPASS,'PATHJAVA':PATHJAVA,'TIPOINST':TIPOINST,'FLGSIDAUTO':FLGSIDAUTO,'gUrlApp':gUrlApp,'gAzienda':gAzienda,'appocert':appocert,'TIPOSV':TIPOSV,'LIMITE20':LIMITE20,'CODVASP':CODVASP,'ART1':ART1,'URLAPPL':URLAPPL,'FLGLOG':FLGLOG,'FLGAOS':FLGAOS,'FLGEAOS':FLGEAOS,'FLGCDOC':FLGCDOC,'FLGFRAZ':FLGFRAZ,'FLGAPERS':FLGAPERS,'DTINIATT':DTINIATT,'FLGTIPIMP':FLGTIPIMP,'FLGSTPCON':FLGSTPCON,'FLGIMPAGE':FLGIMPAGE,'FLGWU':FLGWU,'IMPINTOPE':IMPINTOPE,'FLGOPEXTR':FLGOPEXTR,'FLGRAPCLI':FLGRAPCLI,'FLGDATAIM':FLGDATAIM,'FLGDATATP':FLGDATATP,'NOCODFISC':NOCODFISC,'FLGCHK':FLGCHK,'CODAGE':CODAGE,'PWDSER':PWDSER,'SOSPMAF':SOSPMAF,'FLGRITORNO':FLGRITORNO,'FLGCREAAGE':FLGCREAAGE,'DTTITAGE':DTTITAGE,'SCADSALDI':SCADSALDI,'FLGIPMT':FLGIPMT,'LIMITEFRZ':LIMITEFRZ,'DBPROT':DBPROT,'OAMTPDOC':OAMTPDOC,'DAYSIMPORT':DAYSIMPORT,'DAYSIMPCMB':DAYSIMPCMB,'FLGAWUPOS':FLGAWUPOS,'WUGIOSCA':WUGIOSCA,'WUGGALERT':WUGGALERT,'RICEVUTE':RICEVUTE,'OGGI3I4':OGGI3I4,'CGOTGDEFMUL':CGOTGDEFMUL,'xDESCAN':xDESCAN,'AUTOSARA':AUTOSARA,'FLGCGOOTP':FLGCGOOTP,'ITFLGPEP':ITFLGPEP,'ITPWDPEP':ITPWDPEP,'ITUSRPEP':ITUSRPEP,'FLGAGGFAM':FLGAGGFAM,'ALTSRVMAIL':ALTSRVMAIL,'ALTPRTMAIL':ALTPRTMAIL,'ALTEMLMAIL':ALTEMLMAIL,'ALTUSRMAIL':ALTUSRMAIL,'ALTPWDMAIL':ALTPWDMAIL,'ALTSSLEMAIL':ALTSSLEMAIL,'PATHIMPORT':PATHIMPORT,'DESTEMAIL':DESTEMAIL,'COGNOME':COGNOME,'NOME':NOME,'DNASC':DNASC,'CITTADINA':CITTADINA,'NASCOMUN':NASCOMUN,'NASSTATO':NASSTATO,'PRNASC':PRNASC,'SOGCOM':SOGCOM,'BPCODPAT':BPCODPAT,'BPENTSEG':BPENTSEG,'BPCOGSEG':BPCOGSEG,'BPNOMSEG':BPNOMSEG,'BPTELSEG':BPTELSEG,'BPEMLSEG':BPEMLSEG,'ABI':ABI,'CAB':CAB,'ardt_destwarn':ardt_destwarn,'GGWARNPRV':GGWARNPRV,'GGWARNAUI':GGWARNAUI,'SOGLIAMAX':SOGLIAMAX,'IDOAM':IDOAM,'IDOAMR':IDOAMR,'SKT_SERVER':SKT_SERVER,'SKT_PORT':SKT_PORT,'SKT_PATHS':SKT_PATHS,'SKT_MODET':SKT_MODET,'RASPAUI':RASPAUI,'RESPAUI':RESPAUI,'TESTIP':TESTIP,'MINFRZSNAI':MINFRZSNAI,'FLGSCDFRZ':FLGSCDFRZ,'GIORNIFRZ':GIORNIFRZ,'LIMITVLT':LIMITVLT,'LIMITVNP':LIMITVNP,'FLGSTPDIR':FLGSTPDIR,'FLGNODOC':FLGNODOC,'SNAISTOR':SNAISTOR,'FRAZDEL':FRAZDEL,'PATHAPP':PATHAPP,'FLGDDOC':FLGDDOC,'FLGLIGHT':FLGLIGHT,'pathmanuale':pathmanuale,'FLGCGOPWD':FLGCGOPWD,'PATHSID':PATHSID,'PATHCERT':PATHCERT,'PATHFTP':PATHFTP,'FLGUTEAGE':FLGUTEAGE,'PRGAEPATH':PRGAEPATH,'NUMGIORN':NUMGIORN,'FLGCGOQADV':FLGCGOQADV,'BLOCCOUSER':BLOCCOUSER,'CGOFLGPROF':CGOFLGPROF,'FLGGESDOC':FLGGESDOC,'USRGESDOC':USRGESDOC,'PWDGESDOC':PWDGESDOC,'URLDESDOC':URLDESDOC,'EMAILDOC':EMAILDOC,'ardt_cgo_tipall':ardt_cgo_tipall,'DATADOC':DATADOC,'ardt_cgo_subnets':ardt_cgo_subnets,'PATHDOCBAC':PATHDOCBAC,'IMPPATH':IMPPATH,'SONUMMESI':SONUMMESI,'SOMESIBACK':SOMESIBACK,'SOSHELLCMD':SOSHELLCMD,'SOAMBIENTE':SOAMBIENTE,'ardt_destemail':ardt_destemail,'SOPATHIMPORT':SOPATHIMPORT,'SOORAIMPORT':SOORAIMPORT,'QADV_SOGLIA':QADV_SOGLIA"+FoundlingChildrenList("armt_intermbo",true)+"}";
  public static final String i_ItemSequence = "TIPINTER,RAGSOC,DESCCIT,PROVINCIA,CAP,CODCAB,DOMICILIO,PAESE,CODFISC,PARTIVA,DATANASC,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,SESSO,NUMDOCUM,DATARILASC,AUTRILASC,CODDIPE,NOTE,CODORO,CODINTER,DATAVALI,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIO,IDSID,SIDPASS,PATHJAVA,TIPOINST,FLGSIDAUTO,appocert,TIPOSV,LIMITE20,CODVASP,ART1,URLAPPL,FLGLOG,FLGAOS,FLGEAOS,FLGCDOC,FLGFRAZ,FLGAPERS,DTINIATT,FLGTIPIMP,FLGSTPCON,FLGIMPAGE,FLGWU,IMPINTOPE,FLGOPEXTR,FLGRAPCLI,NOCODFISC,FLGCHK,PWDSER,SOSPMAF,FLGRITORNO,FLGCREAAGE,DTTITAGE,SCADSALDI,FLGIPMT,LIMITEFRZ,DBPROT,OAMTPDOC,DAYSIMPORT,DAYSIMPCMB,FLGAWUPOS,WUGIOSCA,WUGGALERT,RICEVUTE,OGGI3I4,CGOTGDEFMUL,AUTOSARA,FLGCGOOTP,ITFLGPEP,ITPWDPEP,ITUSRPEP,FLGAGGFAM,ALTSRVMAIL,ALTPRTMAIL,ALTEMLMAIL,ALTUSRMAIL,ALTPWDMAIL,ALTSSLEMAIL,PATHIMPORT,DESTEMAIL,COGNOME,NOME,DNASC,CITTADINA,NASCOMUN,NASSTATO,PRNASC,SOGCOM,BPCODPAT,BPENTSEG,BPCOGSEG,BPNOMSEG,BPTELSEG,BPEMLSEG,ABI,CAB,ardt_destwarn,GGWARNPRV,GGWARNAUI,SOGLIAMAX,IDOAM,IDOAMR,SKT_SERVER,SKT_PORT,SKT_PATHS,SKT_MODET,RASPAUI,RESPAUI,TESTIP,MINFRZSNAI,FLGSCDFRZ,GIORNIFRZ,LIMITVLT,LIMITVNP,FLGSTPDIR,FLGNODOC,FRAZDEL,PATHAPP,FLGLIGHT,pathmanuale,FLGCGOPWD,PATHSID,PATHCERT,PATHFTP,FLGUTEAGE,PRGAEPATH,NUMGIORN,FLGCGOQADV,BLOCCOUSER,CGOFLGPROF,FLGGESDOC,USRGESDOC,PWDGESDOC,URLDESDOC,EMAILDOC,ardt_cgo_tipall,DATADOC,ardt_cgo_subnets,PATHDOCBAC,IMPPATH,SONUMMESI,SOMESIBACK,SOSHELLCMD,SOAMBIENTE,ardt_destemail,SOPATHIMPORT,SOORAIMPORT,QADV_SOGLIA"+FoundlingChildrenList("armt_intermbo",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("armt_intermbo"),new String[][]{new String[]{"TIPINTER","Tipo Intermediario","C","2","0","campo","nokey","false","false"},new String[]{"RAGSOC","Ragione Sociale","C","70","0","campo","key2","false","false"},new String[]{"DESCCIT","Città","C","30","0","campo","nokey","false","false"},new String[]{"PROVINCIA","Provincia","C","2","0","campo","nokey","false","false"},new String[]{"CAP","CAP","C","9","0","campo","nokey","false","false"},new String[]{"CODCAB","CAB","C","6","0","campo","nokey","false","false"},new String[]{"DOMICILIO","Indirizzo","C","35","0","campo","nokey","false","false"},new String[]{"PAESE","Stato","C","3","0","campo","nokey","false","false"},new String[]{"CODFISC","Codice Fiscale","C","16","0","campo","key3","false","false"},new String[]{"PARTIVA","Partita IVA","C","14","0","campo","nokey","false","false"},new String[]{"DATANASC","Data Passaggio EURO","D","8","0","campo","nokey","false","false"},new String[]{"SOTGRUP","Sottogruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"RAMOGRUP","Ramo Gruppo Att. Ec.","C","3","0","campo","nokey","false","false"},new String[]{"SETTSINT","Settorizzazione UIC","C","3","0","campo","nokey","false","false"},new String[]{"TIPODOC","Tipo Documento","C","2","0","campo","nokey","false","false"},new String[]{"SESSO","Sesso","C","1","0","campo","nokey","false","false"},new String[]{"NUMDOCUM","Numero Documento","C","15","0","campo","nokey","false","false"},new String[]{"DATARILASC","Data Rilascio","D","8","0","campo","nokey","false","false"},new String[]{"AUTRILASC","Autorità Competente","C","30","0","campo","nokey","false","false"},new String[]{"CODDIPE","Codice Dipendenza","C","6","0","campo","nokey","false","false"},new String[]{"NOTE","Annotazioni","M","10","0","campo","nokey","false","false"},new String[]{"CODORO","Cod. Segnalante ORO","C","20","0","campo","nokey","false","false"},new String[]{"CODINTER","Codice","C","11","0","campo","key1","false","true"},new String[]{"DATAVALI","Data Rilascio","D","8","0","campo","nokey","false","false"},new String[]{"CFINVIO","Codice Fiscale Organo Invio File","C","16","0","campo","nokey","false","false"},new String[]{"CAFINVIO","Codice CAF Organo Invio","C","5","0","campo","nokey","false","false"},new String[]{"FILEINVIO","Tipo Preparazione FIle","C","1","0","campo","nokey","false","false"},new String[]{"DATAINVIO","Data Impegno","D","8","0","campo","nokey","false","false"},new String[]{"IDSID","Identificativo SID","C","8","0","campo","nokey","false","false"},new String[]{"SIDPASS","Password","C","30","0","campo","nokey","false","false"},new String[]{"PATHJAVA","Percorso Java VM (JRE)","C","250","0","campo","nokey","false","false"},new String[]{"TIPOINST","Tipo Installazione","C","1","0","campo","nokey","false","false"},new String[]{"FLGSIDAUTO","","N","1","0","campo","nokey","false","false"},new String[]{"appocert","","C","10","0","variabile","nokey","false","false"},new String[]{"TIPOSV","Canale Distributivo (SV)","C","3","0","campo","nokey","false","false"},new String[]{"LIMITE20","Passaggio a \u20ac 5.000","D","8","0","campo","nokey","false","false"},new String[]{"CODVASP","VASP Registration Number","C","10","0","campo","nokey","false","false"},new String[]{"ART1","Controllo tetto \u20ac 5000","N","1","0","campo","nokey","false","false"},new String[]{"URLAPPL","URL Applicazione","C","80","0","campo","nokey","false","false"},new String[]{"FLGLOG","Attivazione Log Procedura","C","1","0","campo","nokey","false","false"},new String[]{"FLGAOS","Collegamento con AOS","C","1","0","campo","nokey","false","false"},new String[]{"FLGEAOS","Ereditarietà Fattori Rischio","C","1","0","campo","nokey","false","false"},new String[]{"FLGCDOC","Collegamento anagrafica documenti","C","1","0","campo","nokey","false","false"},new String[]{"FLGFRAZ","Aggerega solo frazionate","C","1","0","campo","nokey","false","false"},new String[]{"FLGAPERS","Campo Aggiuntivo In ARCHPERS","C","1","0","campo","nokey","false","false"},new String[]{"DTINIATT","Data Inizio Attività","D","8","0","campo","nokey","false","false"},new String[]{"FLGTIPIMP","Tipo Import per Scheduler","C","1","0","campo","nokey","false","false"},new String[]{"FLGSTPCON","Crea Stampa Controllo","C","1","0","campo","nokey","false","false"},new String[]{"FLGIMPAGE","Tipo Import Age","C","1","0","campo","nokey","false","false"},new String[]{"FLGWU","Gestione Western Union","C","1","0","campo","nokey","false","false"},new String[]{"IMPINTOPE","Importo per raggruppamento frazionate","N","12","2","campo","nokey","false","false"},new String[]{"FLGOPEXTR","Crea movimento modifica in anagrafe operazioni extraconto","C","1","0","campo","nokey","false","false"},new String[]{"FLGRAPCLI","Seleziona Automaticamente CLienti da rapport in import operazioni","C","1","0","campo","nokey","false","false"},new String[]{"NOCODFISC","Non effettuare calcolo automatico codice fiscale in anagrafica persone","N","1","0","campo","nokey","false","false"},new String[]{"FLGCHK","Collegamento a WEBCHK","C","1","0","campo","nokey","false","false"},new String[]{"PWDSER","","C","10","0","variabile","nokey","false","false"},new String[]{"SOSPMAF","Passato EURO","C","1","0","campo","nokey","false","false"},new String[]{"FLGRITORNO","Creazione Inversa File di Import prima di passaggio a definitivo","C","1","0","campo","nokey","false","false"},new String[]{"FLGCREAAGE","Crea rettifiche/cancellazioni per Agenzia Entrate","C","1","0","campo","nokey","false","false"},new String[]{"DTTITAGE","Data da cui inviare i titolari effettivi","D","8","0","campo","nokey","false","false"},new String[]{"SCADSALDI","Data Scadenza Invio Saldi","D","8","0","campo","nokey","false","false"},new String[]{"FLGIPMT","IDP MoneyTransfer","C","1","0","campo","nokey","false","false"},new String[]{"LIMITEFRZ","Minimo Controllo Fraz.","N","10","2","campo","nokey","false","false"},new String[]{"DBPROT","Modello Ad. Verifica","C","100","0","campo","nokey","false","false"},new String[]{"OAMTPDOC","Gestione documenti per OAM","N","1","0","campo","nokey","false","false"},new String[]{"DAYSIMPORT","Giorni Differenza Import","N","2","0","campo","nokey","false","false"},new String[]{"DAYSIMPCMB","Giorni Import Cambiavalute","N","2","0","campo","nokey","false","false"},new String[]{"FLGAWUPOS","Attiva gestione WUPOS","C","1","0","campo","nokey","false","false"},new String[]{"WUGIOSCA","Giorni Scadenza Correzione Errori","N","3","0","campo","nokey","false","false"},new String[]{"WUGGALERT","Giorni Alert Scadenza","N","3","0","campo","nokey","false","false"},new String[]{"RICEVUTE","Path Documenti","C","250","0","campo","nokey","false","false"},new String[]{"OGGI3I4","Gestisce Causali I3/I4 in Comunicazioni Oggettive","C","1","0","campo","nokey","false","false"},new String[]{"CGOTGDEFMUL","Tipo Gioco Default Multiple","C","3","0","campo","nokey","false","false"},new String[]{"AUTOSARA","Autocompletamento Intermediario Controparte SARA","C","1","0","campo","nokey","false","false"},new String[]{"FLGCGOOTP","Attiva Gestione OTP","C","1","0","campo","nokey","false","false"},new String[]{"ITFLGPEP","Collegamento Liste PEP","C","1","0","campo","nokey","false","false"},new String[]{"ITPWDPEP","Password per colloquio con liste pep","C","50","0","campo","nokey","false","false"},new String[]{"ITUSRPEP","Utente per colloquio liste PEP","C","50","0","campo","nokey","false","false"},new String[]{"FLGAGGFAM","Aggiorna Automaticamente Anagrafe Rapporti al salvataggio dei dati anagrafici","C","1","0","campo","nokey","false","false"},new String[]{"ALTSRVMAIL","Server Invio Posta","C","50","0","campo","nokey","false","false"},new String[]{"ALTPRTMAIL","Porta","C","5","0","campo","nokey","false","false"},new String[]{"ALTEMLMAIL","Mail Invio","C","50","0","campo","nokey","false","false"},new String[]{"ALTUSRMAIL","Utente Invio","C","50","0","campo","nokey","false","false"},new String[]{"ALTPWDMAIL","Password","C","80","0","campo","nokey","false","false"},new String[]{"ALTSSLEMAIL","Usa SSL","C","1","0","campo","nokey","false","false"},new String[]{"PATHIMPORT","Path File Import","C","128","0","campo","nokey","false","false"},new String[]{"DESTEMAIL","Destinatario Email Import","C","80","0","campo","nokey","false","false"},new String[]{"COGNOME","Cognome","C","30","0","campo","nokey","false","false"},new String[]{"NOME","Nome","C","30","0","campo","nokey","false","false"},new String[]{"DNASC","Nato il","D","8","0","campo","nokey","false","false"},new String[]{"CITTADINA","Cittadinanza","C","2","0","campo","nokey","false","false"},new String[]{"NASCOMUN","Comune di Nascita","C","30","0","campo","nokey","false","false"},new String[]{"NASSTATO","","C","30","0","campo","nokey","false","false"},new String[]{"PRNASC","Prov. Nasc.","C","2","0","campo","nokey","false","false"},new String[]{"SOGCOM","Tipo Società","C","1","0","campo","nokey","false","false"},new String[]{"BPCODPAT","Codice Partner","C","12","0","campo","nokey","false","false"},new String[]{"BPENTSEG","Codice Ente Segnalatore","C","12","0","campo","nokey","false","false"},new String[]{"BPCOGSEG","Cognome Segnalatore","C","30","0","campo","nokey","false","false"},new String[]{"BPNOMSEG","Nome","C","30","0","campo","nokey","false","false"},new String[]{"BPTELSEG","Telefono Segnalatore","C","15","0","campo","nokey","false","false"},new String[]{"BPEMLSEG","EMail","C","50","0","campo","nokey","false","false"},new String[]{"ABI","ABI","C","6","0","campo","nokey","false","false"},new String[]{"CAB","CAB","C","6","0","campo","nokey","false","false"},new String[]{"ardt_destwarn","LinkPC","","","","link_PC","","false",""},new String[]{"GGWARNPRV","Giorni Warning Provvisorio ","N","3","0","campo","nokey","false","false"},new String[]{"GGWARNAUI","Giorni Warning AUI","N","3","0","campo","nokey","false","false"},new String[]{"SOGLIAMAX","Soglia Max Controllo Transazioni","N","12","2","campo","nokey","false","false"},new String[]{"IDOAM","Identificativo OAM","C","8","0","campo","nokey","false","false"},new String[]{"IDOAMR","ID Soggetto rappresentato ","C","8","0","campo","nokey","false","false"},new String[]{"SKT_SERVER","Socket Server","C","30","0","campo","nokey","false","false"},new String[]{"SKT_PORT","Porta Socket","N","5","0","campo","nokey","false","false"},new String[]{"SKT_PATHS","Socket Script Path","C","60","0","campo","nokey","false","false"},new String[]{"SKT_MODET","Modalità","C","5","0","campo","nokey","false","false"},new String[]{"RASPAUI","Responsabile Antiriciclaggio","C","50","0","campo","nokey","false","false"},new String[]{"RESPAUI","Responsabile","C","50","0","campo","nokey","false","false"},new String[]{"TESTIP","Tripletta per controllo ip interni","C","11","0","campo","nokey","false","false"},new String[]{"MINFRZSNAI","Minimo Telematico x Operazioni","N","12","2","campo","nokey","false","false"},new String[]{"FLGSCDFRZ","Abilita Schedulazione Raggruppamento Frazionate","C","1","0","campo","nokey","false","false"},new String[]{"GIORNIFRZ","Giorni per Consolidamento Frazionate","N","3","0","campo","nokey","false","false"},new String[]{"LIMITVLT","Limite Pagamento VLT","N","10","2","campo","nokey","false","false"},new String[]{"LIMITVNP","Limite Vincite Prenotate","N","10","2","campo","nokey","false","false"},new String[]{"FLGSTPDIR","Download stampa","C","1","0","campo","nokey","false","false"},new String[]{"FLGNODOC","Controlla scadenza documento in import","C","1","0","campo","nokey","false","false"},new String[]{"FRAZDEL","Cancella frazionate al termine del consolidamento","C","1","0","campo","nokey","false","false"},new String[]{"PATHAPP","Nome applicazione CGO","C","80","0","campo","nokey","false","false"},new String[]{"FLGLIGHT","Consenti Soggetti Senza Documento","C","1","0","campo","nokey","false","false"},new String[]{"pathmanuale","","C","80","0","variabile","nokey","false","false"},new String[]{"FLGCGOPWD","Cambio Password CGO","C","1","0","campo","nokey","false","false"},new String[]{"PATHSID","Ultima versione Manuale","C","250","0","campo","nokey","false","false"},new String[]{"PATHCERT","Path Applicazione CGO","C","250","0","campo","nokey","false","false"},new String[]{"PATHFTP","Path FTP per Import","C","128","0","campo","nokey","false","false"},new String[]{"FLGUTEAGE","Crea Utente alla creazione dell'agenzia","C","1","0","campo","nokey","false","false"},new String[]{"PRGAEPATH","Email Destinatario SOS","C","250","0","campo","nokey","false","false"},new String[]{"NUMGIORN","GG  Provvisorio/Definitivo","N","3","0","campo","nokey","false","false"},new String[]{"FLGCGOQADV","Attiva QADV","C","1","0","campo","nokey","false","false"},new String[]{"BLOCCOUSER","GG Blocco utente non attivo","N","3","0","campo","nokey","false","false"},new String[]{"CGOFLGPROF","Flag Richiesta Professione","C","1","0","campo","nokey","false","false"},new String[]{"FLGGESDOC","Gestione Documentale","C","1","0","campo","nokey","false","false"},new String[]{"USRGESDOC","Utente Ges. Doc.","C","30","0","campo","nokey","false","false"},new String[]{"PWDGESDOC","Password Ges. Doc.","C","30","0","campo","nokey","false","false"},new String[]{"URLDESDOC","URL Ges. Doc.","C","80","0","campo","nokey","false","false"},new String[]{"EMAILDOC","EMail Comunicazioni","C","80","0","campo","nokey","false","false"},new String[]{"ardt_cgo_tipall","LinkPC","","","","link_PC","","false",""},new String[]{"DATADOC","Data Blocco Operazioni Senza Documenti","D","8","0","campo","nokey","false","false"},new String[]{"ardt_cgo_subnets","LinkPC","","","","link_PC","","false",""},new String[]{"PATHDOCBAC","Path Documenti Bacheca","C","128","0","campo","nokey","false","false"},new String[]{"IMPPATH","URL Sito E-Learning","C","240","0","campo","nokey","false","false"},new String[]{"SONUMMESI","Numero Mesi da estrarre","N","2","0","campo","nokey","false","false"},new String[]{"SOMESIBACK","Numero mesi indietro","N","2","0","campo","nokey","false","false"},new String[]{"SOSHELLCMD","Comando Shell da Eseguire al termine","M","10","0","campo","nokey","false","false"},new String[]{"SOAMBIENTE","Ambiente Esecuzione Comando Shell","C","1","0","campo","nokey","false","true"},new String[]{"ardt_destemail","LinkPC","","","","link_PC","","false",""},new String[]{"SOPATHIMPORT","Path file di import","M","10","0","campo","nokey","false","false"},new String[]{"SOORAIMPORT","Ora Max import VLT","N","2","0","campo","nokey","false","false"},new String[]{"QADV_SOGLIA","Soglia Alert QADV","N","4","0","campo","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public armt_intermboBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo",p_ContextObject.GetCompany(),false);
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_oWrInfo_intermbo = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"intermbo",p_ContextObject.GetCompany());
    m_cVirtName_intermbo = CPSql.ManipulateTablePhName("intermbo",m_cServer_intermbo);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_oWrInfo_anadip = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"anadip",p_ContextObject.GetCompany());
    m_cPhName_tbcandistr = p_ContextObject.GetPhName("tbcandistr");
    m_cServer_tbcandistr = p_ContextObject.GetServer("tbcandistr");
    m_oWrInfo_tbcandistr = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcandistr",p_ContextObject.GetCompany());
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_oWrInfo_tbcitta = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbcitta",p_ContextObject.GetCompany());
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_oWrInfo_tbramgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbramgru",p_ContextObject.GetCompany());
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_oWrInfo_tbsetsin = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbsetsin",p_ContextObject.GetCompany());
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_oWrInfo_tbstati = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstati",p_ContextObject.GetCompany());
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_oWrInfo_tbstgru = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbstgru",p_ContextObject.GetCompany());
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_oWrInfo_tbtipdoc = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipdoc",p_ContextObject.GetCompany());
    m_cPhName_tbtipint = p_ContextObject.GetPhName("tbtipint");
    m_cServer_tbtipint = p_ContextObject.GetServer("tbtipint");
    m_oWrInfo_tbtipint = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"tbtipint",p_ContextObject.GetCompany());
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_oWrInfo_cgo_tbtipgio = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cgo_tbtipgio",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    ardt_destwarn = new ardt_destwarnBO(p_ContextObject);
    ardt_cgo_tipall = new ardt_cgo_tipallBO(p_ContextObject);
    ardt_cgo_subnets = new ardt_cgo_subnetsBO(p_ContextObject);
    ardt_destemail = new ardt_destemailBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("armt_intermbo",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_TIPINTER = "";
    w_RAGSOC = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_PAESE = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_DATANASC = CPLib.NullDate();
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_SETTSINT = "";
    w_TIPODOC = "";
    w_SESSO = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODDIPE = "";
    w_CONNES = "";
    w_NOTE = "";
    w_CODORO = "";
    w_CODINTER = "";
    w_TIPOPERS = "";
    w_IDCITTA = "";
    w_DESCRIsta = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_descdip = "";
    w_tipsot = "";
    w_xdescitdip = "";
    w_xcabdip = "";
    w_DATAVALI = CPLib.NullDate();
    w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
    w_CONTATORE = 0;
    w_ATTIV = "";
    w_CFINVIO = "";
    w_CAFINVIO = "";
    w_FILEINVIO = "";
    w_DATAINVIO = CPLib.NullDate();
    w_IDSID = "";
    w_SIDPASS = "";
    w_PATHJAVA = "";
    w_gUrlApp = m_Ctx.GetGlobalString("gUrlApp");
    w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
    w_appocert = "";
    w_TIPOSV = "";
    w_LIMITE20 = CPLib.NullDate();
    w_CODVASP = "";
    w_URLAPPL = "";
    w_DTINIATT = CPLib.NullDate();
    w_FLGSTPCON = "";
    w_FLGIMPAGE = "";
    w_FLGOPEXTR = "";
    w_CODAGE = "";
    w_PWDSER = "";
    w_DTTITAGE = CPLib.NullDate();
    w_SCADSALDI = CPLib.NullDate();
    w_LIMITEFRZ = 0;
    w_LIMITEFRZ = 0;
    w_DBPROT = "";
    w_DAYSIMPORT = 0;
    w_DAYSIMPCMB = 0;
    w_WUGIOSCA = 0;
    w_WUGGALERT = 0;
    w_RICEVUTE = "";
    w_OGGI3I4 = "";
    w_xDESCAN = "";
    w_ITPWDPEP = "";
    w_ITUSRPEP = "";
    w_FLGAGGFAM = "";
    w_ALTSRVMAIL = "";
    w_ALTPRTMAIL = "";
    w_ALTEMLMAIL = "";
    w_ALTUSRMAIL = "";
    w_ALTPWDMAIL = "";
    w_PATHIMPORT = "";
    w_DESTEMAIL = "";
    w_COGNOME = "";
    w_NOME = "";
    w_SESSO = "";
    w_DNASC = CPLib.NullDate();
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CITTADINA = "";
    w_NASCOMUN = "";
    w_NASSTATO = "";
    w_PRNASC = "";
    w_SOGCOM = "";
    w_TIPODOC = "";
    w_BPCODPAT = "";
    w_BPENTSEG = "";
    w_BPCOGSEG = "";
    w_BPNOMSEG = "";
    w_BPTELSEG = "";
    w_BPEMLSEG = "";
    w_ABI = "";
    w_CAB = "";
    w_GGWARNPRV = 0;
    w_GGWARNAUI = 0;
    w_SOGLIAMAX = 0;
    w_CODVASP = "";
    w_IDOAM = "";
    w_IDOAMR = "";
    w_SKT_SERVER = "";
    w_SKT_PORT = 0;
    w_SKT_PATHS = "";
    w_SKT_MODET = "";
    w_RASPAUI = "";
    w_RESPAUI = "";
    w_TESTIP = "";
    w_MINFRZSNAI = 0;
    w_FLGSCDFRZ = "";
    w_GIORNIFRZ = 0;
    w_LIMITVLT = 0;
    w_LIMITVNP = 0;
    w_LIMITEFRZ = 0;
    w_PATHAPP = "";
    w_FLGDDOC = "";
    w_pathmanuale = "";
    w_PATHSID = "";
    w_PATHCERT = "";
    w_PATHFTP = "";
    w_PRGAEPATH = "";
    w_NUMGIORN = 0;
    w_FLGCGOQADV = "";
    w_BLOCCOUSER = 0;
    w_CGOFLGPROF = "";
    w_ALTSRVMAIL = "";
    w_ALTPRTMAIL = "";
    w_ALTEMLMAIL = "";
    w_ALTUSRMAIL = "";
    w_ALTPWDMAIL = "";
    w_USRGESDOC = "";
    w_PWDGESDOC = "";
    w_URLDESDOC = "";
    w_EMAILDOC = "";
    w_DATADOC = CPLib.NullDate();
    w_PATHDOCBAC = "";
    w_IMPPATH = "";
    w_CGOTGDEFMUL = "";
    w_SONUMMESI = 0;
    w_SOMESIBACK = 0;
    w_SOSHELLCMD = "";
    w_SOAMBIENTE = "";
    w_SOPATHIMPORT = "";
    w_SOORAIMPORT = 0;
    w_QADV_SOGLIA = 0;
    Link_JXOBOAXKRQ();
    Link_JCGROGAZTR();
    Link_IIXRREUEAM();
    Link_LLYIGAMXRH();
    Link_RVNHQCXNEM();
    Link_ZGNLLSFQHC();
    Link_AYYXYNLAUC();
    Link_PSZTLCSMPB();
    w_TIPOINST = "W";
    w_FLGSIDAUTO = 0;
    w_ART1 = 0;
    w_FLGLOG = "N";
    w_FLGAOS = "N";
    w_FLGEAOS = "N";
    w_FLGCDOC = "N";
    w_FLGFRAZ = "N";
    w_FLGAPERS = "1";
    w_FLGTIPIMP = "D";
    w_FLGWU = "N";
    w_IMPINTOPE = 15000;
    w_FLGRAPCLI = "N";
    w_FLGDATAIM = 0;
    w_FLGDATATP = 0;
    w_NOCODFISC = 0;
    w_FLGCHK = "N";
    w_SOSPMAF = "B";
    w_FLGRITORNO = "N";
    w_FLGCREAAGE = "N";
    w_FLGIPMT = "N";
    w_OAMTPDOC = 0;
    w_FLGAWUPOS = "N";
    w_CGOTGDEFMUL = "N";
    w_AUTOSARA = "N";
    w_FLGCGOOTP = "N";
    w_ITFLGPEP = "N";
    w_ALTSSLEMAIL = "N";
    Link_PZGXGIZQWY();
    Link_DUROREWBNG();
    Link_ZTUIXEONYI();
    w_FLGSTPDIR = "N";
    w_FLGNODOC = "N";
    w_SNAISTOR = "N";
    w_FRAZDEL = "N";
    w_FLGLIGHT = "N";
    w_FLGCGOPWD = "N";
    w_FLGUTEAGE = "N";
    w_FLGCGOOTP = "N";
    w_FLGGESDOC = "N";
    m_cWv_ardt_destwarn = "";
    m_cWv_ardt_cgo_tipall = "";
    m_cWv_ardt_cgo_subnets = "";
    m_cWv_ardt_destemail = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || ardt_destwarn.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_destwarn);
    l_bResult = l_bResult || ardt_cgo_tipall.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_cgo_tipall);
    l_bResult = l_bResult || ardt_cgo_subnets.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_cgo_subnets);
    l_bResult = l_bResult || ardt_destemail.IsUpdated() || CPLib.IsUpdated(m_cWv_ardt_destemail);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_DESCCIT = w_DESCCIT;
    o_SOTGRUP = w_SOTGRUP;
    o_RAMOGRUP = w_RAMOGRUP;
    ardt_destwarn.SaveDependsOn();
    ardt_cgo_tipall.SaveDependsOn();
    ardt_cgo_subnets.SaveDependsOn();
    ardt_destemail.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Insert start")) {
      Calculation_BBBKIFYTJJ();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_OEZVQSLBRM();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_FMZMADCIPT();
      Calculation_MKYPHHMQJX();
    } else if (CPLib.eq(p_cEvent,"Record Updated")) {
      Calculation_KGBNFVNJHO();
      Calculation_MKYPHHMQJX();
    } else if (CPLib.eq(p_cEvent,"Update start")) {
      Calculation_FPGLYSGRGN();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_JXOBOAXKRQ() {
    return Link_JXOBOAXKRQ("Full");
  }
  protected boolean Link_JXOBOAXKRQ(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPINTER))) {
      String l_OldValue = w_TIPINTER;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPINTER,"C",2,0),m_cServer_tbtipint,w_TIPINTER);
      if (m_Ctx.IsSharedTemp("tbtipint")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipint,"select TIPOINT from "+m_cPhName_tbtipint+((m_cPhName_tbtipint).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPOINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPINTER = l_rsLink.GetString("TIPOINT");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_JXOBOAXKRQ_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPINTER = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPINTER");
          }
          m_cLastWorkVarError = "TIPINTER";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_JXOBOAXKRQ_blank();
    }
    return l_bResult;
  }
  void Link_JXOBOAXKRQ_blank() {
    w_TIPINTER = "";
  }
  protected boolean Link_JCGROGAZTR() {
    return Link_JCGROGAZTR("Full");
  }
  protected boolean Link_JCGROGAZTR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      String l_OldValue = w_DESCCIT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",30,0),m_cServer_tbcitta,w_DESCCIT);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,CAB,PROV,CAP,PKTBSTATI,IDBASE from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DESCCIT = l_rsLink.GetString("CITTA");
          w_CODCAB = l_rsLink.GetString("CAB");
          w_PROVINCIA = l_rsLink.GetString("PROV");
          w_CAP = l_rsLink.GetString("CAP");
          w_PAESE = l_rsLink.GetString("PKTBSTATI");
          w_IDCITTA = l_rsLink.GetString("IDBASE");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_JCGROGAZTR_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DESCCIT");
          }
          m_cLastWorkVarError = "DESCCIT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_JCGROGAZTR_blank();
    }
    return l_bResult;
  }
  void Link_JCGROGAZTR_blank() {
    Link_JCGROGAZTR_blank("");
  }
  void Link_JCGROGAZTR_blank(String p_cType) {
    w_CODCAB = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_PAESE = "";
    w_IDCITTA = "";
  }
  protected boolean Link_IIXRREUEAM() {
    return Link_IIXRREUEAM("Full");
  }
  protected boolean Link_IIXRREUEAM(String p_cType) {
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
          w_DESCRIsta = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_IIXRREUEAM_blank();
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
      Link_IIXRREUEAM_blank();
    }
    return l_bResult;
  }
  void Link_IIXRREUEAM_blank() {
    w_PAESE = "";
    w_DESCRIsta = "";
  }
  protected boolean Link_LLYIGAMXRH() {
    return Link_LLYIGAMXRH("Full");
  }
  protected boolean Link_LLYIGAMXRH(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SOTGRUP))) {
      String l_OldValue = w_SOTGRUP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTGRUP,"C",3,0),m_cServer_tbstgru,w_SOTGRUP);
      if (m_Ctx.IsSharedTemp("tbstgru")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SOTGRU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOTGRUP,"C",60,0),m_cServer_tbstgru,w_SOTGRUP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbstgru,"select SOTGRU,DESCRI,TIPOSOT from "+m_cPhName_tbstgru+((m_cPhName_tbstgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SOTGRUP = l_rsLink.GetString("SOTGRU");
          w_DESCSGRU = l_rsLink.GetString("DESCRI");
          w_tipsot = l_rsLink.GetString("TIPOSOT");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_LLYIGAMXRH_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SOTGRUP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SOTGRUP");
          }
          m_cLastWorkVarError = "SOTGRUP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_LLYIGAMXRH_blank();
    }
    return l_bResult;
  }
  void Link_LLYIGAMXRH_blank() {
    w_SOTGRUP = "";
    w_DESCSGRU = "";
    w_tipsot = "";
  }
  protected boolean Link_RVNHQCXNEM() {
    return Link_RVNHQCXNEM("Full");
  }
  protected boolean Link_RVNHQCXNEM(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_RAMOGRUP))) {
      String l_OldValue = w_RAMOGRUP;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAMOGRUP,"C",3,0),m_cServer_tbramgru,w_RAMOGRUP);
      if (m_Ctx.IsSharedTemp("tbramgru")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbramgru,"select RAMGRU,DESCRI from "+m_cPhName_tbramgru+((m_cPhName_tbramgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"RAMGRU"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAMOGRUP,"C",70,0),m_cServer_tbramgru,w_RAMOGRUP);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbramgru,"select RAMGRU,DESCRI from "+m_cPhName_tbramgru+((m_cPhName_tbramgru).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_RAMOGRUP = l_rsLink.GetString("RAMGRU");
          w_DESCRAMGRU = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_RVNHQCXNEM_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_RAMOGRUP = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","RAMOGRUP");
          }
          m_cLastWorkVarError = "RAMOGRUP";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_RVNHQCXNEM_blank();
    }
    return l_bResult;
  }
  void Link_RVNHQCXNEM_blank() {
    w_RAMOGRUP = "";
    w_DESCRAMGRU = "";
  }
  protected boolean Link_ZGNLLSFQHC() {
    return Link_ZGNLLSFQHC("Full");
  }
  protected boolean Link_ZGNLLSFQHC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_SETTSINT))) {
      String l_OldValue = w_SETTSINT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETTSINT,"C",3,0),m_cServer_tbsetsin,w_SETTSINT);
      if (m_Ctx.IsSharedTemp("tbsetsin")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"SETSINT"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETTSINT,"C",60,0),m_cServer_tbsetsin,w_SETTSINT);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_tbsetsin,"select SETSINT,DESCRI from "+m_cPhName_tbsetsin+((m_cPhName_tbsetsin).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_SETTSINT = l_rsLink.GetString("SETSINT");
          w_DESCUIC = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZGNLLSFQHC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_SETTSINT = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","SETTSINT");
          }
          m_cLastWorkVarError = "SETTSINT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ZGNLLSFQHC_blank();
    }
    return l_bResult;
  }
  void Link_ZGNLLSFQHC_blank() {
    w_SETTSINT = "";
    w_DESCUIC = "";
  }
  protected boolean Link_AYYXYNLAUC() {
    return Link_AYYXYNLAUC("Full");
  }
  protected boolean Link_AYYXYNLAUC(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_TIPODOC))) {
      String l_OldValue = w_TIPODOC;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TIPODOC,"C",2,0),m_cServer_tbtipdoc,w_TIPODOC);
      if (m_Ctx.IsSharedTemp("tbtipdoc")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbtipdoc,"select TIPDOC from "+m_cPhName_tbtipdoc+((m_cPhName_tbtipdoc).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"TIPDOC"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_TIPODOC = l_rsLink.GetString("TIPDOC");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_AYYXYNLAUC_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_TIPODOC = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","TIPODOC");
          }
          m_cLastWorkVarError = "TIPODOC";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_AYYXYNLAUC_blank();
    }
    return l_bResult;
  }
  void Link_AYYXYNLAUC_blank() {
    w_TIPODOC = "";
  }
  protected boolean Link_PSZTLCSMPB() {
    return Link_PSZTLCSMPB("Full");
  }
  protected boolean Link_PSZTLCSMPB(String p_cType) {
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
      l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CODDIP"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (CPLib.ne(p_cType,"Load")) {
          if ( ! (l_bLoaded)) {
            l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIPE,"C",30,0),m_cServer_anadip,w_CODDIPE);
            if (l_rsLink!=null)
              l_rsLink.Close();
            l_rsLink = m_Sql.Query(m_cServer_anadip,"select CODDIP,DESCRIZ,DESCCIT,CAB from "+m_cPhName_anadip+((m_cPhName_anadip).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRIZ"+l_cCurrentKey+l_cWhere);
            l_bLoaded =  ! (l_rsLink.Eof());
          }
        }
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_CODDIPE = l_rsLink.GetString("CODDIP");
          w_descdip = l_rsLink.GetString("DESCRIZ");
          w_xdescitdip = l_rsLink.GetString("DESCCIT");
          w_xcabdip = l_rsLink.GetString("CAB");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_PSZTLCSMPB_blank();
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
      Link_PSZTLCSMPB_blank();
    }
    return l_bResult;
  }
  void Link_PSZTLCSMPB_blank() {
    w_CODDIPE = "";
    w_descdip = "";
    w_xdescitdip = "";
    w_xcabdip = "";
  }
  protected boolean Link_PZGXGIZQWY() {
    return Link_PZGXGIZQWY("Full");
  }
  protected boolean Link_PZGXGIZQWY(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_DESCCIT))) {
      String l_OldValue = w_DESCCIT;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DESCCIT,"C",30,0),m_cServer_tbcitta,w_DESCCIT);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_DESCCIT = l_rsLink.GetString("CITTA");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_PZGXGIZQWY_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","DESCCIT");
          }
          m_cLastWorkVarError = "DESCCIT";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_PZGXGIZQWY_blank();
    }
    return l_bResult;
  }
  void Link_PZGXGIZQWY_blank() {
    Link_PZGXGIZQWY_blank("");
  }
  void Link_PZGXGIZQWY_blank(String p_cType) {
  }
  protected boolean Link_DUROREWBNG() {
    return Link_DUROREWBNG("Full");
  }
  protected boolean Link_DUROREWBNG(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_NASCOMUN))) {
      String l_OldValue = w_NASCOMUN;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NASCOMUN,"C",30,0),m_cServer_tbcitta,w_NASCOMUN);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbcitta,"select CITTA,PROV from "+m_cPhName_tbcitta+((m_cPhName_tbcitta).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"CITTA"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_NASCOMUN = l_rsLink.GetString("CITTA");
          w_PRNASC = l_rsLink.GetString("PROV");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_DUROREWBNG_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_NASCOMUN = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","NASCOMUN");
          }
          m_cLastWorkVarError = "NASCOMUN";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_DUROREWBNG_blank();
    }
    return l_bResult;
  }
  void Link_DUROREWBNG_blank() {
    w_NASCOMUN = "";
    w_PRNASC = "";
  }
  protected boolean Link_ZTUIXEONYI() {
    return Link_ZTUIXEONYI("Full");
  }
  protected boolean Link_ZTUIXEONYI(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_NASSTATO))) {
      String l_OldValue = w_NASSTATO;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NASSTATO,"C",30,0),m_cServer_tbstati,w_NASSTATO);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_tbstati,"select DESCRI from "+m_cPhName_tbstati+((m_cPhName_tbstati).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"DESCRI"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_NASSTATO = l_rsLink.GetString("DESCRI");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_ZTUIXEONYI_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_NASSTATO = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","NASSTATO");
          }
          m_cLastWorkVarError = "NASSTATO";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_ZTUIXEONYI_blank();
    }
    return l_bResult;
  }
  void Link_ZTUIXEONYI_blank() {
    w_NASSTATO = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_TIPINTER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPINTER = p_workVariableValue;
    l_bResult = Link_JXOBOAXKRQ();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPINTER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAGSOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAGSOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESCCIT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESCCIT = p_workVariableValue;
    l_bResult = Link_JCGROGAZTR();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCCIT = "";
    }
    l_bResult = Link_PZGXGIZQWY();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_DESCCIT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PROVINCIA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PROVINCIA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODCAB(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODCAB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DOMICILIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DOMICILIO = p_workVariableValue;
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
    l_bResult = Link_IIXRREUEAM();
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
  public boolean Set_CODFISC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODFISC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PARTIVA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PARTIVA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATANASC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATANASC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOTGRUP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOTGRUP = p_workVariableValue;
    l_bResult = Link_LLYIGAMXRH();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOTGRUP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RAMOGRUP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RAMOGRUP = p_workVariableValue;
    l_bResult = Link_RVNHQCXNEM();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_RAMOGRUP = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SETTSINT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SETTSINT = p_workVariableValue;
    l_bResult = Link_ZGNLLSFQHC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SETTSINT = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPODOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPODOC = p_workVariableValue;
    l_bResult = Link_AYYXYNLAUC();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPODOC = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_TIPODOC = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SESSO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SESSO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMDOCUM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMDOCUM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATARILASC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATARILASC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AUTRILASC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AUTRILASC = p_workVariableValue;
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
    l_bResult = Link_PSZTLCSMPB();
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
  public boolean Set_NOTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODORO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODORO = p_workVariableValue;
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
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODINTER = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_CODINTER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAVALI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAVALI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CFINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CFINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CAFINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CAFINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FILEINVIO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FILEINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATAINVIO(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATAINVIO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDSID(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDSID = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SIDPASS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SIDPASS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHJAVA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHJAVA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOINST(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOINST = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGSIDAUTO(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGSIDAUTO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_appocert(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_appocert = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TIPOSV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TIPOSV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_LIMITE20(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_LIMITE20 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CODVASP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CODVASP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ART1(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ART1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_URLAPPL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_URLAPPL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGLOG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGLOG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGAOS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGAOS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGEAOS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGEAOS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGFRAZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGFRAZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGAPERS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGAPERS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DTINIATT(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DTINIATT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGTIPIMP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGTIPIMP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGSTPCON(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGSTPCON = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGIMPAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGIMPAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGWU(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGWU = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPINTOPE(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPINTOPE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGOPEXTR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGOPEXTR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGRAPCLI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGRAPCLI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOCODFISC(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOCODFISC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCHK(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCHK = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PWDSER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PWDSER = p_workVariableValue;
    // 
    l_bResult = (CPLib.Empty(w_PWDSER)?true:CPLib.eq(w_PWDSER,"MIT"+CPLib.Substr(CPLib.DateToChar(CPLib.Date()),3,6)));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_PWDSER = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSPMAF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSPMAF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGRITORNO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGRITORNO = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCREAAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCREAAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DTTITAGE(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DTTITAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SCADSALDI(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SCADSALDI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGIPMT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGIPMT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_LIMITEFRZ(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_LIMITEFRZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DBPROT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DBPROT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_OAMTPDOC(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_OAMTPDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DAYSIMPORT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DAYSIMPORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DAYSIMPCMB(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DAYSIMPCMB = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGAWUPOS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGAWUPOS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUGIOSCA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUGIOSCA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_WUGGALERT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_WUGGALERT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RICEVUTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RICEVUTE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_OGGI3I4(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_OGGI3I4 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CGOTGDEFMUL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CGOTGDEFMUL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_AUTOSARA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_AUTOSARA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCGOOTP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCGOOTP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ITFLGPEP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ITFLGPEP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ITPWDPEP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ITPWDPEP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ITUSRPEP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ITUSRPEP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGAGGFAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGAGGFAM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTSRVMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTSRVMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTPRTMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTPRTMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTEMLMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTEMLMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTUSRMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTUSRMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTPWDMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTPWDMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ALTSSLEMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ALTSSLEMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHIMPORT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHIMPORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DESTEMAIL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DESTEMAIL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_COGNOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_COGNOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NOME(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NOME = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DNASC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DNASC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CITTADINA(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CITTADINA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NASCOMUN(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NASCOMUN = p_workVariableValue;
    l_bResult = Link_DUROREWBNG();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NASCOMUN = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NASSTATO(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NASSTATO = p_workVariableValue;
    l_bResult = Link_ZTUIXEONYI();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_NASSTATO = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PRNASC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PRNASC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOGCOM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOGCOM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPCODPAT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPCODPAT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPENTSEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPENTSEG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPCOGSEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPCOGSEG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPNOMSEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPNOMSEG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPTELSEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPTELSEG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BPEMLSEG(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BPEMLSEG = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_ABI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_ABI = p_workVariableValue;
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
  public boolean Set_GGWARNPRV(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_GGWARNPRV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_GGWARNAUI(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_GGWARNAUI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOGLIAMAX(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOGLIAMAX = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDOAM(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDOAM = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IDOAMR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IDOAMR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SKT_SERVER(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SKT_SERVER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SKT_PORT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SKT_PORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SKT_PATHS(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SKT_PATHS = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SKT_MODET(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SKT_MODET = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RASPAUI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RASPAUI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_RESPAUI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_RESPAUI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_TESTIP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_TESTIP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_MINFRZSNAI(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_MINFRZSNAI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGSCDFRZ(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGSCDFRZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_GIORNIFRZ(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_GIORNIFRZ = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_LIMITVLT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_LIMITVLT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_LIMITVNP(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_LIMITVNP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGSTPDIR(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGSTPDIR = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGNODOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGNODOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FRAZDEL(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FRAZDEL = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHAPP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHAPP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGLIGHT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGLIGHT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pathmanuale(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pathmanuale = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCGOPWD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCGOPWD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHSID(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHSID = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHCERT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHCERT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHFTP(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHFTP = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGUTEAGE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGUTEAGE = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PRGAEPATH(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PRGAEPATH = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_NUMGIORN(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_NUMGIORN = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGCGOQADV(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGCGOQADV = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_BLOCCOUSER(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_BLOCCOUSER = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_CGOFLGPROF(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_CGOFLGPROF = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_FLGGESDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_FLGGESDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_USRGESDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_USRGESDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PWDGESDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PWDGESDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_URLDESDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_URLDESDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_EMAILDOC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_EMAILDOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_DATADOC(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_DATADOC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_PATHDOCBAC(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_PATHDOCBAC = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_IMPPATH(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_IMPPATH = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SONUMMESI(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SONUMMESI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOMESIBACK(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOMESIBACK = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOSHELLCMD(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOSHELLCMD = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOAMBIENTE(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOAMBIENTE = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_SOAMBIENTE = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean ATYYTAXDZW_isObligatory() {
    // Condizione di obbligatorietà
    return  ! (CPLib.Empty(CPLib.LRTrim(w_SOSHELLCMD)));
  }
  public boolean Set_SOPATHIMPORT(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOPATHIMPORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_SOORAIMPORT(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_SOORAIMPORT = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_QADV_SOGLIA(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_QADV_SOGLIA = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_RAMOGRUP() {
    return CPLib.ne(w_tipsot,"0") && CPLib.ne(w_tipsot,"2");
  }
  public boolean getWritable_ITPWDPEP() {
    return CPLib.eq(w_ITFLGPEP,"S");
  }
  public boolean getWritable_ITUSRPEP() {
    return CPLib.eq(w_ITFLGPEP,"S");
  }
  public boolean getWritable_GIORNIFRZ() {
    return CPLib.eq(w_FLGSCDFRZ,"S");
  }
  public boolean getWritable_PATHSID() {
    return false;
  }
  public boolean getVisible_appocert() {
    return true;
  }
  public boolean getVisible_LIMITE20() {
    return  ! (LibreriaMit.inter_art1(w_TIPINTER));
  }
  public boolean getVisible_FLGLOG() {
    return  ! (Utilities.Make(m_Ctx).IsAdministrator());
  }
  public boolean getVisible_FLGAOS() {
    return  ! (Utilities.Make(m_Ctx).IsAdministrator());
  }
  public boolean getVisible_FLGSTPCON() {
    return CPLib.ne(w_FLGAPERS,"4");
  }
  public boolean getVisible_FLGCHK() {
    return  ! (Utilities.Make(m_Ctx).IsAdministrator());
  }
  public boolean getVisible_PWDSER() {
    return  ! (Utilities.Make(m_Ctx).IsAdministrator());
  }
  public boolean getVisible_SOSPMAF() {
    return CPLib.ne(w_PWDSER,"MIT"+CPLib.Substr(CPLib.DateToChar(CPLib.Date()),3,6));
  }
  public boolean getVisible_SCADSALDI() {
    return true;
  }
  public boolean getVisible_FLGIPMT() {
    return CPLib.eq(CPLib.At(w_TIPINTER,"|46|17|81"),0);
  }
  public boolean getVisible_pathmanuale() {
    return true;
  }
  public boolean getVisible_DATADOC() {
    return CPLib.eq(w_FLGDDOC,"S");
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
    if (CPLib.ne(o_DESCCIT,w_DESCCIT)) {
      l_bTmpRes = Link_IIXRREUEAM();
    }
    if (CPLib.ne(o_RAMOGRUP,w_RAMOGRUP) || CPLib.ne(o_SOTGRUP,w_SOTGRUP)) {
      Calculation_OIDLDZGYTQ();
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_OIDLDZGYTQ() {
    arrt_calcolasettR l_oRoutine_arrt_calcolasett;
    l_oRoutine_arrt_calcolasett = arrt_calcolasettR.Make(m_Ctx,this);
    l_oRoutine_arrt_calcolasett.Run();
  }
  void Calculation_BBBKIFYTJJ() {
    w_CODINTER = (CPLib.Empty(w_CODINTER)?CPLib.LRTrim(w_CODFISC):w_CODINTER);
  }
  void Calculation_OEZVQSLBRM() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "CANCELLAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "INTERMBO";
    l_oRoutine_arrt_writelog.pChiave = w_CODINTER;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_KGBNFVNJHO() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "VARIAZIONE";
    l_oRoutine_arrt_writelog.pTabella = "INTERMBO";
    l_oRoutine_arrt_writelog.pChiave = w_CODINTER;
    l_oRoutine_arrt_writelog.Run();
  }
  void Calculation_FMZMADCIPT() {
    arrt_writelogR l_oRoutine_arrt_writelog;
    l_oRoutine_arrt_writelog = arrt_writelogR.Make(m_Ctx,this);
    l_oRoutine_arrt_writelog.pOperazione = "NUOVO RECORD";
    l_oRoutine_arrt_writelog.pTabella = "INTERMBO";
    l_oRoutine_arrt_writelog.pChiave = w_CODINTER;
    l_oRoutine_arrt_writelog.Run();
    arrt_creadirR l_oRoutine_arrt_creadir;
    l_oRoutine_arrt_creadir = arrt_creadirR.Make(m_Ctx,this);
    l_oRoutine_arrt_creadir.Run();
  }
  void Calculation_MKYPHHMQJX() {
    arrt_setsbloccoR l_oRoutine_arrt_setsblocco;
    l_oRoutine_arrt_setsblocco = arrt_setsbloccoR.Make(m_Ctx,this);
    l_oRoutine_arrt_setsblocco.Run();
    arrt_creadir_interR l_oRoutine_arrt_creadir_inter;
    l_oRoutine_arrt_creadir_inter = arrt_creadir_interR.Make(m_Ctx,this);
    l_oRoutine_arrt_creadir_inter.Run();
  }
  void Calculation_FPGLYSGRGN() {
    arrt_interstorR l_oRoutine_arrt_interstor;
    l_oRoutine_arrt_interstor = arrt_interstorR.Make(m_Ctx,this);
    l_oRoutine_arrt_interstor.Run();
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
  public final static String[] m_KeyColumns = {"CODINTER"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("armt_intermbo","intermbo",m_KeyColumns,m_Ctx);
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
    w_TIPINTER = "";
    w_RAGSOC = "";
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CAP = "";
    w_CODCAB = "";
    w_DOMICILIO = "";
    w_PAESE = "";
    w_CODFISC = "";
    w_PARTIVA = "";
    w_DATANASC = CPLib.NullDate();
    w_SOTGRUP = "";
    w_RAMOGRUP = "";
    w_SETTSINT = "";
    w_TIPODOC = "";
    w_SESSO = "";
    w_NUMDOCUM = "";
    w_DATARILASC = CPLib.NullDate();
    w_AUTRILASC = "";
    w_CODDIPE = "";
    w_CONNES = "";
    w_NOTE = "";
    w_CODORO = "";
    w_CODINTER = "";
    w_TIPOPERS = "";
    w_IDCITTA = "";
    w_DESCRIsta = "";
    w_DESCSGRU = "";
    w_DESCRAMGRU = "";
    w_DESCUIC = "";
    w_descdip = "";
    w_tipsot = "";
    w_xdescitdip = "";
    w_xcabdip = "";
    w_DATAVALI = CPLib.NullDate();
    w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
    w_CONTATORE = 0;
    w_ATTIV = "";
    w_CFINVIO = "";
    w_CAFINVIO = "";
    w_FILEINVIO = "";
    w_DATAINVIO = CPLib.NullDate();
    w_IDSID = "";
    w_SIDPASS = "";
    w_PATHJAVA = "";
    w_TIPOINST = "";
    w_FLGSIDAUTO = 0;
    w_gUrlApp = m_Ctx.GetGlobalString("gUrlApp");
    w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
    w_appocert = "";
    w_TIPOSV = "";
    w_LIMITE20 = CPLib.NullDate();
    w_CODVASP = "";
    w_ART1 = 0;
    w_URLAPPL = "";
    w_FLGLOG = "";
    w_FLGAOS = "";
    w_FLGEAOS = "";
    w_FLGCDOC = "";
    w_FLGFRAZ = "";
    w_FLGAPERS = "";
    w_DTINIATT = CPLib.NullDate();
    w_FLGTIPIMP = "";
    w_FLGSTPCON = "";
    w_FLGIMPAGE = "";
    w_FLGWU = "";
    w_IMPINTOPE = 0;
    w_FLGOPEXTR = "";
    w_FLGRAPCLI = "";
    w_FLGDATAIM = 0;
    w_FLGDATATP = 0;
    w_NOCODFISC = 0;
    w_FLGCHK = "";
    w_CODAGE = "";
    w_PWDSER = "";
    w_SOSPMAF = "";
    w_FLGRITORNO = "";
    w_FLGCREAAGE = "";
    w_DTTITAGE = CPLib.NullDate();
    w_SCADSALDI = CPLib.NullDate();
    w_FLGIPMT = "";
    w_LIMITEFRZ = 0;
    w_LIMITEFRZ = 0;
    w_DBPROT = "";
    w_OAMTPDOC = 0;
    w_DAYSIMPORT = 0;
    w_DAYSIMPCMB = 0;
    w_FLGAWUPOS = "";
    w_WUGIOSCA = 0;
    w_WUGGALERT = 0;
    w_RICEVUTE = "";
    w_OGGI3I4 = "";
    w_CGOTGDEFMUL = "";
    w_xDESCAN = "";
    w_AUTOSARA = "";
    w_FLGCGOOTP = "";
    w_ITFLGPEP = "";
    w_ITPWDPEP = "";
    w_ITUSRPEP = "";
    w_FLGAGGFAM = "";
    w_ALTSRVMAIL = "";
    w_ALTPRTMAIL = "";
    w_ALTEMLMAIL = "";
    w_ALTUSRMAIL = "";
    w_ALTPWDMAIL = "";
    w_ALTSSLEMAIL = "";
    w_PATHIMPORT = "";
    w_DESTEMAIL = "";
    w_COGNOME = "";
    w_NOME = "";
    w_SESSO = "";
    w_DNASC = CPLib.NullDate();
    w_DESCCIT = "";
    w_PROVINCIA = "";
    w_CITTADINA = "";
    w_NASCOMUN = "";
    w_NASSTATO = "";
    w_PRNASC = "";
    w_SOGCOM = "";
    w_TIPODOC = "";
    w_BPCODPAT = "";
    w_BPENTSEG = "";
    w_BPCOGSEG = "";
    w_BPNOMSEG = "";
    w_BPTELSEG = "";
    w_BPEMLSEG = "";
    w_ABI = "";
    w_CAB = "";
    w_GGWARNPRV = 0;
    w_GGWARNAUI = 0;
    w_SOGLIAMAX = 0;
    w_CODVASP = "";
    w_IDOAM = "";
    w_IDOAMR = "";
    w_SKT_SERVER = "";
    w_SKT_PORT = 0;
    w_SKT_PATHS = "";
    w_SKT_MODET = "";
    w_RASPAUI = "";
    w_RESPAUI = "";
    w_TESTIP = "";
    w_MINFRZSNAI = 0;
    w_FLGSCDFRZ = "";
    w_GIORNIFRZ = 0;
    w_LIMITVLT = 0;
    w_LIMITVNP = 0;
    w_FLGSTPDIR = "";
    w_FLGNODOC = "";
    w_SNAISTOR = "";
    w_LIMITEFRZ = 0;
    w_FRAZDEL = "";
    w_PATHAPP = "";
    w_FLGDDOC = "";
    w_FLGLIGHT = "";
    w_pathmanuale = "";
    w_FLGCGOPWD = "";
    w_PATHSID = "";
    w_PATHCERT = "";
    w_PATHFTP = "";
    w_FLGUTEAGE = "";
    w_PRGAEPATH = "";
    w_NUMGIORN = 0;
    w_FLGCGOOTP = "";
    w_FLGCGOQADV = "";
    w_BLOCCOUSER = 0;
    w_CGOFLGPROF = "";
    w_ALTSRVMAIL = "";
    w_ALTPRTMAIL = "";
    w_ALTEMLMAIL = "";
    w_ALTUSRMAIL = "";
    w_ALTPWDMAIL = "";
    w_FLGGESDOC = "";
    w_USRGESDOC = "";
    w_PWDGESDOC = "";
    w_URLDESDOC = "";
    w_EMAILDOC = "";
    w_DATADOC = CPLib.NullDate();
    w_PATHDOCBAC = "";
    w_IMPPATH = "";
    w_CGOTGDEFMUL = "";
    w_SONUMMESI = 0;
    w_SOMESIBACK = 0;
    w_SOSHELLCMD = "";
    w_SOAMBIENTE = "";
    w_SOPATHIMPORT = "";
    w_SOORAIMPORT = 0;
    w_QADV_SOGLIA = 0;
    m_cWv_ardt_destwarn = "";
    m_cWv_ardt_cgo_tipall = "";
    m_cWv_ardt_cgo_subnets = "";
    m_cWv_ardt_destemail = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_TIPINTER = CPLib.GetProperty(p,"TIPINTER",w_TIPINTER,0);
      w_RAGSOC = CPLib.GetProperty(p,"RAGSOC",w_RAGSOC,0);
      w_DESCCIT = CPLib.GetProperty(p,"DESCCIT",w_DESCCIT,0);
      w_PROVINCIA = CPLib.GetProperty(p,"PROVINCIA",w_PROVINCIA,0);
      w_CAP = CPLib.GetProperty(p,"CAP",w_CAP,0);
      w_CODCAB = CPLib.GetProperty(p,"CODCAB",w_CODCAB,0);
      w_DOMICILIO = CPLib.GetProperty(p,"DOMICILIO",w_DOMICILIO,0);
      w_PAESE = CPLib.GetProperty(p,"PAESE",w_PAESE,0);
      w_CODFISC = CPLib.GetProperty(p,"CODFISC",w_CODFISC,0);
      w_PARTIVA = CPLib.GetProperty(p,"PARTIVA",w_PARTIVA,0);
      w_DATANASC = CPLib.GetProperty(p,"DATANASC",w_DATANASC,0);
      w_SOTGRUP = CPLib.GetProperty(p,"SOTGRUP",w_SOTGRUP,0);
      w_RAMOGRUP = CPLib.GetProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
      w_SETTSINT = CPLib.GetProperty(p,"SETTSINT",w_SETTSINT,0);
      w_TIPODOC = CPLib.GetProperty(p,"TIPODOC",w_TIPODOC,0);
      w_SESSO = CPLib.GetProperty(p,"SESSO",w_SESSO,0);
      w_NUMDOCUM = CPLib.GetProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
      w_DATARILASC = CPLib.GetProperty(p,"DATARILASC",w_DATARILASC,0);
      w_AUTRILASC = CPLib.GetProperty(p,"AUTRILASC",w_AUTRILASC,0);
      w_CODDIPE = CPLib.GetProperty(p,"CODDIPE",w_CODDIPE,0);
      w_CONNES = CPLib.GetProperty(p,"CONNES",w_CONNES,0);
      w_NOTE = CPLib.GetProperty(p,"NOTE",w_NOTE,0);
      w_CODORO = CPLib.GetProperty(p,"CODORO",w_CODORO,0);
      w_CODINTER = CPLib.GetProperty(p,"CODINTER",w_CODINTER,0);
      w_TIPOPERS = CPLib.GetProperty(p,"TIPOPERS",w_TIPOPERS,0);
      w_IDCITTA = CPLib.GetProperty(p,"IDCITTA",w_IDCITTA,0);
      w_DATAVALI = CPLib.GetProperty(p,"DATAVALI",w_DATAVALI,0);
      w_CONTATORE = CPLib.GetProperty(p,"CONTATORE",w_CONTATORE,0);
      w_CFINVIO = CPLib.GetProperty(p,"CFINVIO",w_CFINVIO,0);
      w_CAFINVIO = CPLib.GetProperty(p,"CAFINVIO",w_CAFINVIO,0);
      w_FILEINVIO = CPLib.GetProperty(p,"FILEINVIO",w_FILEINVIO,0);
      w_URLAPPL = CPLib.GetProperty(p,"URLAPPL",w_URLAPPL,0);
      w_FLGLOG = CPLib.GetProperty(p,"FLGLOG",w_FLGLOG,0);
      w_FLGAOS = CPLib.GetProperty(p,"FLGAOS",w_FLGAOS,0);
      w_FLGEAOS = CPLib.GetProperty(p,"FLGEAOS",w_FLGEAOS,0);
      w_FLGCDOC = CPLib.GetProperty(p,"FLGCDOC",w_FLGCDOC,0);
      w_FLGFRAZ = CPLib.GetProperty(p,"FLGFRAZ",w_FLGFRAZ,0);
      w_FLGAPERS = CPLib.GetProperty(p,"FLGAPERS",w_FLGAPERS,0);
      w_DTINIATT = CPLib.GetProperty(p,"DTINIATT",w_DTINIATT,0);
      w_FLGTIPIMP = CPLib.GetProperty(p,"FLGTIPIMP",w_FLGTIPIMP,0);
      w_FLGSTPCON = CPLib.GetProperty(p,"FLGSTPCON",w_FLGSTPCON,0);
      w_FLGIMPAGE = CPLib.GetProperty(p,"FLGIMPAGE",w_FLGIMPAGE,0);
      w_FLGWU = CPLib.GetProperty(p,"FLGWU",w_FLGWU,0);
      w_DATAINVIO = CPLib.GetProperty(p,"DATAINVIO",w_DATAINVIO,0);
      w_IMPINTOPE = CPLib.GetProperty(p,"IMPINTOPE",w_IMPINTOPE,0);
      w_FLGOPEXTR = CPLib.GetProperty(p,"FLGOPEXTR",w_FLGOPEXTR,0);
      w_FLGRAPCLI = CPLib.GetProperty(p,"FLGRAPCLI",w_FLGRAPCLI,0);
      w_FLGDATAIM = CPLib.GetProperty(p,"FLGDATAIM",w_FLGDATAIM,0);
      w_FLGDATATP = CPLib.GetProperty(p,"FLGDATATP",w_FLGDATATP,0);
      w_NOCODFISC = CPLib.GetProperty(p,"NOCODFISC",w_NOCODFISC,0);
      w_FLGCHK = CPLib.GetProperty(p,"FLGCHK",w_FLGCHK,0);
      w_CODAGE = CPLib.GetProperty(p,"CODAGE",w_CODAGE,0);
      w_IDSID = CPLib.GetProperty(p,"IDSID",w_IDSID,0);
      w_SIDPASS = CPLib.GetProperty(p,"SIDPASS",w_SIDPASS,0);
      w_PATHJAVA = CPLib.GetProperty(p,"PATHJAVA",w_PATHJAVA,0);
      w_TIPOINST = CPLib.GetProperty(p,"TIPOINST",w_TIPOINST,0);
      w_FLGSIDAUTO = CPLib.GetProperty(p,"FLGSIDAUTO",w_FLGSIDAUTO,0);
      w_SOSPMAF = CPLib.GetProperty(p,"SOSPMAF",w_SOSPMAF,0);
      w_FLGRITORNO = CPLib.GetProperty(p,"FLGRITORNO",w_FLGRITORNO,0);
      w_FLGCREAAGE = CPLib.GetProperty(p,"FLGCREAAGE",w_FLGCREAAGE,0);
      w_DTTITAGE = CPLib.GetProperty(p,"DTTITAGE",w_DTTITAGE,0);
      w_SCADSALDI = CPLib.GetProperty(p,"SCADSALDI",w_SCADSALDI,0);
      w_FLGIPMT = CPLib.GetProperty(p,"FLGIPMT",w_FLGIPMT,0);
      w_LIMITEFRZ = CPLib.GetProperty(p,"LIMITEFRZ",w_LIMITEFRZ,0);
      w_DBPROT = CPLib.GetProperty(p,"DBPROT",w_DBPROT,0);
      w_OAMTPDOC = CPLib.GetProperty(p,"OAMTPDOC",w_OAMTPDOC,0);
      w_DAYSIMPORT = CPLib.GetProperty(p,"DAYSIMPORT",w_DAYSIMPORT,0);
      w_DAYSIMPCMB = CPLib.GetProperty(p,"DAYSIMPCMB",w_DAYSIMPCMB,0);
      w_TIPOSV = CPLib.GetProperty(p,"TIPOSV",w_TIPOSV,0);
      w_FLGAWUPOS = CPLib.GetProperty(p,"FLGAWUPOS",w_FLGAWUPOS,0);
      w_WUGIOSCA = CPLib.GetProperty(p,"WUGIOSCA",w_WUGIOSCA,0);
      w_WUGGALERT = CPLib.GetProperty(p,"WUGGALERT",w_WUGGALERT,0);
      w_SKT_SERVER = CPLib.GetProperty(p,"SKT_SERVER",w_SKT_SERVER,0);
      w_SKT_PORT = CPLib.GetProperty(p,"SKT_PORT",w_SKT_PORT,0);
      w_SKT_PATHS = CPLib.GetProperty(p,"SKT_PATHS",w_SKT_PATHS,0);
      w_SKT_MODET = CPLib.GetProperty(p,"SKT_MODET",w_SKT_MODET,0);
      w_RASPAUI = CPLib.GetProperty(p,"RASPAUI",w_RASPAUI,0);
      w_RESPAUI = CPLib.GetProperty(p,"RESPAUI",w_RESPAUI,0);
      w_TESTIP = CPLib.GetProperty(p,"TESTIP",w_TESTIP,0);
      w_MINFRZSNAI = CPLib.GetProperty(p,"MINFRZSNAI",w_MINFRZSNAI,0);
      w_FLGSCDFRZ = CPLib.GetProperty(p,"FLGSCDFRZ",w_FLGSCDFRZ,0);
      w_GIORNIFRZ = CPLib.GetProperty(p,"GIORNIFRZ",w_GIORNIFRZ,0);
      w_LIMITVLT = CPLib.GetProperty(p,"LIMITVLT",w_LIMITVLT,0);
      w_LIMITVNP = CPLib.GetProperty(p,"LIMITVNP",w_LIMITVNP,0);
      w_FLGSTPDIR = CPLib.GetProperty(p,"FLGSTPDIR",w_FLGSTPDIR,0);
      w_FLGNODOC = CPLib.GetProperty(p,"FLGNODOC",w_FLGNODOC,0);
      w_SNAISTOR = CPLib.GetProperty(p,"SNAISTOR",w_SNAISTOR,0);
      w_FRAZDEL = CPLib.GetProperty(p,"FRAZDEL",w_FRAZDEL,0);
      w_PATHAPP = CPLib.GetProperty(p,"PATHAPP",w_PATHAPP,0);
      w_FLGDDOC = CPLib.GetProperty(p,"FLGDDOC",w_FLGDDOC,0);
      w_FLGLIGHT = CPLib.GetProperty(p,"FLGLIGHT",w_FLGLIGHT,0);
      w_FLGCGOPWD = CPLib.GetProperty(p,"FLGCGOPWD",w_FLGCGOPWD,0);
      w_PATHSID = CPLib.GetProperty(p,"PATHSID",w_PATHSID,0);
      w_PATHCERT = CPLib.GetProperty(p,"PATHCERT",w_PATHCERT,0);
      w_PATHFTP = CPLib.GetProperty(p,"PATHFTP",w_PATHFTP,0);
      w_FLGUTEAGE = CPLib.GetProperty(p,"FLGUTEAGE",w_FLGUTEAGE,0);
      w_PRGAEPATH = CPLib.GetProperty(p,"PRGAEPATH",w_PRGAEPATH,0);
      w_NUMGIORN = CPLib.GetProperty(p,"NUMGIORN",w_NUMGIORN,0);
      w_COGNOME = CPLib.GetProperty(p,"COGNOME",w_COGNOME,0);
      w_NOME = CPLib.GetProperty(p,"NOME",w_NOME,0);
      w_DNASC = CPLib.GetProperty(p,"DNASC",w_DNASC,0);
      w_CITTADINA = CPLib.GetProperty(p,"CITTADINA",w_CITTADINA,0);
      w_NASCOMUN = CPLib.GetProperty(p,"NASCOMUN",w_NASCOMUN,0);
      w_NASSTATO = CPLib.GetProperty(p,"NASSTATO",w_NASSTATO,0);
      w_PRNASC = CPLib.GetProperty(p,"PRNASC",w_PRNASC,0);
      w_SOGCOM = CPLib.GetProperty(p,"SOGCOM",w_SOGCOM,0);
      w_ALTSRVMAIL = CPLib.GetProperty(p,"ALTSRVMAIL",w_ALTSRVMAIL,0);
      w_ALTPRTMAIL = CPLib.GetProperty(p,"ALTPRTMAIL",w_ALTPRTMAIL,0);
      w_ALTEMLMAIL = CPLib.GetProperty(p,"ALTEMLMAIL",w_ALTEMLMAIL,0);
      w_ALTUSRMAIL = CPLib.GetProperty(p,"ALTUSRMAIL",w_ALTUSRMAIL,0);
      w_ALTPWDMAIL = CPLib.GetProperty(p,"ALTPWDMAIL",w_ALTPWDMAIL,0);
      w_FLGGESDOC = CPLib.GetProperty(p,"FLGGESDOC",w_FLGGESDOC,0);
      w_USRGESDOC = CPLib.GetProperty(p,"USRGESDOC",w_USRGESDOC,0);
      w_PWDGESDOC = CPLib.GetProperty(p,"PWDGESDOC",w_PWDGESDOC,0);
      w_URLDESDOC = CPLib.GetProperty(p,"URLDESDOC",w_URLDESDOC,0);
      w_EMAILDOC = CPLib.GetProperty(p,"EMAILDOC",w_EMAILDOC,0);
      w_DATADOC = CPLib.GetProperty(p,"DATADOC",w_DATADOC,0);
      w_PATHDOCBAC = CPLib.GetProperty(p,"PATHDOCBAC",w_PATHDOCBAC,0);
      w_IMPPATH = CPLib.GetProperty(p,"IMPPATH",w_IMPPATH,0);
      w_BPCODPAT = CPLib.GetProperty(p,"BPCODPAT",w_BPCODPAT,0);
      w_BPENTSEG = CPLib.GetProperty(p,"BPENTSEG",w_BPENTSEG,0);
      w_BPCOGSEG = CPLib.GetProperty(p,"BPCOGSEG",w_BPCOGSEG,0);
      w_BPNOMSEG = CPLib.GetProperty(p,"BPNOMSEG",w_BPNOMSEG,0);
      w_BPTELSEG = CPLib.GetProperty(p,"BPTELSEG",w_BPTELSEG,0);
      w_BPEMLSEG = CPLib.GetProperty(p,"BPEMLSEG",w_BPEMLSEG,0);
      w_RICEVUTE = CPLib.GetProperty(p,"RICEVUTE",w_RICEVUTE,0);
      w_ABI = CPLib.GetProperty(p,"ABI",w_ABI,0);
      w_CAB = CPLib.GetProperty(p,"CAB",w_CAB,0);
      w_OGGI3I4 = CPLib.GetProperty(p,"OGGI3I4",w_OGGI3I4,0);
      w_CGOTGDEFMUL = CPLib.GetProperty(p,"CGOTGDEFMUL",w_CGOTGDEFMUL,0);
      w_AUTOSARA = CPLib.GetProperty(p,"AUTOSARA",w_AUTOSARA,0);
      w_GGWARNPRV = CPLib.GetProperty(p,"GGWARNPRV",w_GGWARNPRV,0);
      w_GGWARNAUI = CPLib.GetProperty(p,"GGWARNAUI",w_GGWARNAUI,0);
      w_SOGLIAMAX = CPLib.GetProperty(p,"SOGLIAMAX",w_SOGLIAMAX,0);
      w_LIMITE20 = CPLib.GetProperty(p,"LIMITE20",w_LIMITE20,0);
      w_SONUMMESI = CPLib.GetProperty(p,"SONUMMESI",w_SONUMMESI,0);
      w_SOMESIBACK = CPLib.GetProperty(p,"SOMESIBACK",w_SOMESIBACK,0);
      w_SOSHELLCMD = CPLib.GetProperty(p,"SOSHELLCMD",w_SOSHELLCMD,0);
      w_SOAMBIENTE = CPLib.GetProperty(p,"SOAMBIENTE",w_SOAMBIENTE,0);
      w_SOPATHIMPORT = CPLib.GetProperty(p,"SOPATHIMPORT",w_SOPATHIMPORT,0);
      w_SOORAIMPORT = CPLib.GetProperty(p,"SOORAIMPORT",w_SOORAIMPORT,0);
      w_QADV_SOGLIA = CPLib.GetProperty(p,"QADV_SOGLIA",w_QADV_SOGLIA,0);
      w_FLGCGOOTP = CPLib.GetProperty(p,"FLGCGOOTP",w_FLGCGOOTP,0);
      w_FLGCGOQADV = CPLib.GetProperty(p,"FLGCGOQADV",w_FLGCGOQADV,0);
      w_ITFLGPEP = CPLib.GetProperty(p,"ITFLGPEP",w_ITFLGPEP,0);
      w_ITPWDPEP = CPLib.GetProperty(p,"ITPWDPEP",w_ITPWDPEP,0);
      w_ITUSRPEP = CPLib.GetProperty(p,"ITUSRPEP",w_ITUSRPEP,0);
      w_BLOCCOUSER = CPLib.GetProperty(p,"BLOCCOUSER",w_BLOCCOUSER,0);
      w_CGOFLGPROF = CPLib.GetProperty(p,"CGOFLGPROF",w_CGOFLGPROF,0);
      w_FLGAGGFAM = CPLib.GetProperty(p,"FLGAGGFAM",w_FLGAGGFAM,0);
      w_ALTSSLEMAIL = CPLib.GetProperty(p,"ALTSSLEMAIL",w_ALTSSLEMAIL,0);
      w_PATHIMPORT = CPLib.GetProperty(p,"PATHIMPORT",w_PATHIMPORT,0);
      w_DESTEMAIL = CPLib.GetProperty(p,"DESTEMAIL",w_DESTEMAIL,0);
      w_CODVASP = CPLib.GetProperty(p,"CODVASP",w_CODVASP,0);
      w_IDOAM = CPLib.GetProperty(p,"IDOAM",w_IDOAM,0);
      w_IDOAMR = CPLib.GetProperty(p,"IDOAMR",w_IDOAMR,0);
      w_ART1 = CPLib.GetProperty(p,"ART1",w_ART1,0);
      w_DESCRIsta = CPLib.GetProperty(p,"DESCRIsta",w_DESCRIsta,0);
      w_DESCSGRU = CPLib.GetProperty(p,"DESCSGRU",w_DESCSGRU,0);
      w_DESCRAMGRU = CPLib.GetProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
      w_DESCUIC = CPLib.GetProperty(p,"DESCUIC",w_DESCUIC,0);
      w_descdip = CPLib.GetProperty(p,"descdip",w_descdip,0);
      w_tipsot = CPLib.GetProperty(p,"tipsot",w_tipsot,0);
      w_xdescitdip = CPLib.GetProperty(p,"xdescitdip",w_xdescitdip,0);
      w_xcabdip = CPLib.GetProperty(p,"xcabdip",w_xcabdip,0);
      w_gUserCode = CPLib.GetProperty(p,"gUserCode",w_gUserCode,0);
      w_ATTIV = CPLib.GetProperty(p,"ATTIV",w_ATTIV,0);
      w_gUrlApp = CPLib.GetProperty(p,"gUrlApp",w_gUrlApp,0);
      w_gAzienda = CPLib.GetProperty(p,"gAzienda",w_gAzienda,0);
      w_PWDSER = CPLib.GetProperty(p,"PWDSER",w_PWDSER,0);
      w_appocert = CPLib.GetProperty(p,"appocert",w_appocert,0);
      w_pathmanuale = CPLib.GetProperty(p,"pathmanuale",w_pathmanuale,0);
      w_xDESCAN = CPLib.GetProperty(p,"xDESCAN",w_xDESCAN,0);
      m_cWv_ardt_destwarn = CPLib.GetProperty(p,"m_cWv_ardt_destwarn",m_cWv_ardt_destwarn,0);
      m_cWv_ardt_cgo_tipall = CPLib.GetProperty(p,"m_cWv_ardt_cgo_tipall",m_cWv_ardt_cgo_tipall,0);
      m_cWv_ardt_cgo_subnets = CPLib.GetProperty(p,"m_cWv_ardt_cgo_subnets",m_cWv_ardt_cgo_subnets,0);
      m_cWv_ardt_destemail = CPLib.GetProperty(p,"m_cWv_ardt_destemail",m_cWv_ardt_destemail,0);
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
    items = tables.get("destwarn");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("destwarn",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"DWCODINT"});
    map.put("rd_var",new String[]{"w_CODINTER"});
    map.put("wr_var",new String[]{"w_CODINTER"});
    map.put("wr_field",new String[]{"DWCODINT"});
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
    map.put("property.value",zeroSplit.split("destwarn\u0000false\u0000false\u00001\u00000\u0000ardt_destwarn\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_tipall");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_tipall",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TACODINT"});
    map.put("rd_var",new String[]{"w_CODINTER"});
    map.put("wr_var",new String[]{"w_CODINTER"});
    map.put("wr_field",new String[]{"TACODINT"});
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
    map.put("property.value",zeroSplit.split("cgo_tipall\u0000false\u0000false\u00001\u00000\u0000ardt_cgo_tipall\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cgo_subnet");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cgo_subnet",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SNCODINT"});
    map.put("rd_var",new String[]{"w_CODINTER"});
    map.put("wr_var",new String[]{"w_CODINTER"});
    map.put("wr_field",new String[]{"SNCODINT"});
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
    map.put("property.value",zeroSplit.split("cgo_subnet\u0000false\u0000false\u00001\u00000\u0000ardt_cgo_subnets\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("destwarn");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("destwarn",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"DWCODINT"});
    map.put("rd_var",new String[]{"w_CODINTER"});
    map.put("wr_var",new String[]{"w_CODINTER"});
    map.put("wr_field",new String[]{"DWCODINT"});
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
    map.put("property.value",zeroSplit.split("destwarn\u0000false\u0000false\u00001\u00000\u0000ardt_destemail\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipint");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipint",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TIPOINT"});
    map.put("rd_var",new String[]{"w_TIPINTER"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Intermediario",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipint\u0000false\u0000false\u00001\u00000\u0000armt_tipinte\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","CAB","PROV","CAP","PKTBSTATI","IDBASE"});
    map.put("rd_var",new String[]{"w_DESCCIT","w_CODCAB","w_PROVINCIA","w_CAP","w_PAESE","w_IDCITTA"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u00006\u00002\u00009\u00003\u000010",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Città\u0000CAB\u0000Provincia\u0000CAP\u0000Stato\u0000Codice Città",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo\u0000campo\u0000campo\u0000campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000Citta\u0000\u0000\u0000false",-1));
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
    map.put("rd_var",new String[]{"w_PAESE","w_DESCRIsta"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000030",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Stato\u0000Descrizione",-1));
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
    items = tables.get("tbstgru");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbstgru",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SOTGRU","DESCRI","TIPOSOT"});
    map.put("rd_var",new String[]{"w_SOTGRUP","w_DESCSGRU","w_tipsot"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000060\u00001",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Sottogruppo Att. Ec.\u0000Descrizione\u0000Tipo",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbstgru\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Sottogruppi Att. Economiche\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbramgru");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbramgru",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"RAMGRU","DESCRI"});
    map.put("rd_var",new String[]{"w_RAMOGRUP","w_DESCRAMGRU"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000070",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Ramo Gruppo Att. Ec.\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbramgru\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000ramgru\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbsetsin");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbsetsin",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"SETSINT","DESCRI"});
    map.put("rd_var",new String[]{"w_SETTSINT","w_DESCUIC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000060",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Settorizzazione UIC\u0000Descrizione",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbsetsin\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Setto Sintetica UIC\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("tbtipdoc");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("tbtipdoc",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"TIPDOC"});
    map.put("rd_var",new String[]{"w_TIPODOC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("2",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Tipo Documento",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbtipdoc\u0000false\u0000false\u00001\u00000\u0000armt_tipdoc\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CODDIP","DESCRIZ","DESCCIT","CAB"});
    map.put("rd_var",new String[]{"w_CODDIPE","w_descdip","w_xdescitdip","w_xcabdip"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C\u0000C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("6\u000030\u000030\u00006",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000\u00000\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Codice Dipendenza\u0000Descrizione\u0000Città\u0000CAB",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey\u0000nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE\u0000FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000\u0000\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile\u0000variabile\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("anadip\u0000false\u0000false\u00002\u00000\u0000\u0000false\u0000false\u0000Dipendenze\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"CITTA","PROV"});
    map.put("rd_var",new String[]{"w_NASCOMUN","w_PRNASC"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30\u00002",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("Comune di Nascita\u0000Prov. Nasc.",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000campo",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("tbcitta\u0000false\u0000false\u00001\u00000\u0000armt_citta\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
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
    map.put("rd_field",new String[]{"DESCRI"});
    map.put("rd_var",new String[]{"w_NASSTATO"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("30",-1));
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
    map.put("property.value",zeroSplit.split("tbstati\u0000false\u0000false\u00001\u00000\u0000\u0000false\u0000false\u0000Stati\u0000\u0000\u0000false",-1));
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
    for(String child : CPLib.LoadableMNTs("armt_intermbo",false)) {
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
      String[][] definitions = CPMNTChild.GetM_Fkd("armt_intermbo",child);
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
    ardt_destwarn = new ardt_destwarnBO(m_Ctx);
    ardt_cgo_tipall = new ardt_cgo_tipallBO(m_Ctx);
    ardt_cgo_subnets = new ardt_cgo_subnetsBO(m_Ctx);
    ardt_destemail = new ardt_destemailBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("armt_intermbo",m_Ctx);
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
    if (CPLib.Empty(w_CODINTER)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_CODINTER));
      String obblMsgError = m_Ctx.Translate("Codice")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_CODINTER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "CODINTER";
      }
    } else if ( ! ((CPLib.Empty(w_PWDSER)?true:CPLib.eq(w_PWDSER,"MIT"+CPLib.Substr(CPLib.DateToChar(CPLib.Date()),3,6))))) {
      m_cLastMsgError = "PWDSER : ";
      m_cLastMsgError = m_cLastMsgError+m_Ctx.Translate("MSG_VALUE_NOT_ALLOWED");
      l_bNoCheck = false;
      l_bResult = false;
      w_PWDSER = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "PWDSER";
      }
    } else if (CPLib.Empty(w_SOAMBIENTE) && ATYYTAXDZW_isObligatory()) {
      l_bNoObligatory =  ! (CPLib.Empty(w_SOAMBIENTE));
      String obblMsgError = m_Ctx.Translate("Ambiente Esecuzione Comando Shell")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_SOAMBIENTE = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "SOAMBIENTE";
      }
    }
    if (l_bResult && (( ! (ardt_destwarn.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_destwarn)) || ( ! (ardt_destwarn.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_destwarn)))) {
      ardt_destwarn.SetFromContext(m_cWv_ardt_destwarn);
      m_cWv_ardt_destwarn = "_not_empty_";
    }
    if (l_bResult && (ardt_destwarn.m_bLoaded || ardt_destwarn.m_bUpdated)) {
      l_bResult = l_bResult && ardt_destwarn.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_destwarn.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_cgo_tipall.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_cgo_tipall)) || ( ! (ardt_cgo_tipall.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_cgo_tipall)))) {
      ardt_cgo_tipall.SetFromContext(m_cWv_ardt_cgo_tipall);
      m_cWv_ardt_cgo_tipall = "_not_empty_";
    }
    if (l_bResult && (ardt_cgo_tipall.m_bLoaded || ardt_cgo_tipall.m_bUpdated)) {
      l_bResult = l_bResult && ardt_cgo_tipall.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_cgo_tipall.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_cgo_subnets.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_cgo_subnets)) || ( ! (ardt_cgo_subnets.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_cgo_subnets)))) {
      ardt_cgo_subnets.SetFromContext(m_cWv_ardt_cgo_subnets);
      m_cWv_ardt_cgo_subnets = "_not_empty_";
    }
    if (l_bResult && (ardt_cgo_subnets.m_bLoaded || ardt_cgo_subnets.m_bUpdated)) {
      l_bResult = l_bResult && ardt_cgo_subnets.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_cgo_subnets.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (ardt_destemail.m_bLoaded) && CPLib.IsLoaded(m_cWv_ardt_destemail)) || ( ! (ardt_destemail.m_bUpdated) && CPLib.IsUpdated(m_cWv_ardt_destemail)))) {
      ardt_destemail.SetFromContext(m_cWv_ardt_destemail);
      m_cWv_ardt_destemail = "_not_empty_";
    }
    if (l_bResult && (ardt_destemail.m_bLoaded || ardt_destemail.m_bUpdated)) {
      l_bResult = l_bResult && ardt_destemail.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = ardt_destemail.m_cLastMsgError;
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
      l_Keys = new String[]{"armt_intermbo","Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"armt_intermbo\\"+p_cState,"Administrators","Utenti standard","Ruolo 3","Utenti Confidi","Ruolo 5","agenzia","Area Finanza","Help desk","Consultazione"};
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
    o_DESCCIT = "";
    o_SOTGRUP = "";
    o_RAMOGRUP = "";
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
    CPLib.PutProperty(p,"TIPINTER",w_TIPINTER,0);
    CPLib.PutProperty(p,"RAGSOC",w_RAGSOC,0);
    CPLib.PutProperty(p,"DESCCIT",w_DESCCIT,0);
    CPLib.PutProperty(p,"PROVINCIA",w_PROVINCIA,0);
    CPLib.PutProperty(p,"CAP",w_CAP,0);
    CPLib.PutProperty(p,"CODCAB",w_CODCAB,0);
    CPLib.PutProperty(p,"DOMICILIO",w_DOMICILIO,0);
    CPLib.PutProperty(p,"PAESE",w_PAESE,0);
    CPLib.PutProperty(p,"CODFISC",w_CODFISC,0);
    CPLib.PutProperty(p,"PARTIVA",w_PARTIVA,0);
    CPLib.PutProperty(p,"DATANASC",w_DATANASC,0);
    CPLib.PutProperty(p,"SOTGRUP",w_SOTGRUP,0);
    CPLib.PutProperty(p,"RAMOGRUP",w_RAMOGRUP,0);
    CPLib.PutProperty(p,"SETTSINT",w_SETTSINT,0);
    CPLib.PutProperty(p,"TIPODOC",w_TIPODOC,0);
    CPLib.PutProperty(p,"SESSO",w_SESSO,0);
    CPLib.PutProperty(p,"NUMDOCUM",w_NUMDOCUM,0);
    CPLib.PutProperty(p,"DATARILASC",w_DATARILASC,0);
    CPLib.PutProperty(p,"AUTRILASC",w_AUTRILASC,0);
    CPLib.PutProperty(p,"CODDIPE",w_CODDIPE,0);
    CPLib.PutProperty(p,"CONNES",w_CONNES,0);
    CPLib.PutProperty(p,"NOTE",w_NOTE,0);
    CPLib.PutProperty(p,"CODORO",w_CODORO,0);
    CPLib.PutProperty(p,"CODINTER",w_CODINTER,0);
    CPLib.PutProperty(p,"TIPOPERS",w_TIPOPERS,0);
    CPLib.PutProperty(p,"IDCITTA",w_IDCITTA,0);
    CPLib.PutProperty(p,"DATAVALI",w_DATAVALI,0);
    CPLib.PutProperty(p,"CONTATORE",w_CONTATORE,0);
    CPLib.PutProperty(p,"CFINVIO",w_CFINVIO,0);
    CPLib.PutProperty(p,"CAFINVIO",w_CAFINVIO,0);
    CPLib.PutProperty(p,"FILEINVIO",w_FILEINVIO,0);
    CPLib.PutProperty(p,"URLAPPL",w_URLAPPL,0);
    CPLib.PutProperty(p,"FLGLOG",w_FLGLOG,0);
    CPLib.PutProperty(p,"FLGAOS",w_FLGAOS,0);
    CPLib.PutProperty(p,"FLGEAOS",w_FLGEAOS,0);
    CPLib.PutProperty(p,"FLGCDOC",w_FLGCDOC,0);
    CPLib.PutProperty(p,"FLGFRAZ",w_FLGFRAZ,0);
    CPLib.PutProperty(p,"FLGAPERS",w_FLGAPERS,0);
    CPLib.PutProperty(p,"DTINIATT",w_DTINIATT,0);
    CPLib.PutProperty(p,"FLGTIPIMP",w_FLGTIPIMP,0);
    CPLib.PutProperty(p,"FLGSTPCON",w_FLGSTPCON,0);
    CPLib.PutProperty(p,"FLGIMPAGE",w_FLGIMPAGE,0);
    CPLib.PutProperty(p,"FLGWU",w_FLGWU,0);
    CPLib.PutProperty(p,"DATAINVIO",w_DATAINVIO,0);
    CPLib.PutProperty(p,"IMPINTOPE",w_IMPINTOPE,0);
    CPLib.PutProperty(p,"FLGOPEXTR",w_FLGOPEXTR,0);
    CPLib.PutProperty(p,"FLGRAPCLI",w_FLGRAPCLI,0);
    CPLib.PutProperty(p,"FLGDATAIM",w_FLGDATAIM,0);
    CPLib.PutProperty(p,"FLGDATATP",w_FLGDATATP,0);
    CPLib.PutProperty(p,"NOCODFISC",w_NOCODFISC,0);
    CPLib.PutProperty(p,"FLGCHK",w_FLGCHK,0);
    CPLib.PutProperty(p,"CODAGE",w_CODAGE,0);
    CPLib.PutProperty(p,"IDSID",w_IDSID,0);
    CPLib.PutProperty(p,"SIDPASS",w_SIDPASS,0);
    CPLib.PutProperty(p,"PATHJAVA",w_PATHJAVA,0);
    CPLib.PutProperty(p,"TIPOINST",w_TIPOINST,0);
    CPLib.PutProperty(p,"FLGSIDAUTO",w_FLGSIDAUTO,0);
    CPLib.PutProperty(p,"SOSPMAF",w_SOSPMAF,0);
    CPLib.PutProperty(p,"FLGRITORNO",w_FLGRITORNO,0);
    CPLib.PutProperty(p,"FLGCREAAGE",w_FLGCREAAGE,0);
    CPLib.PutProperty(p,"DTTITAGE",w_DTTITAGE,0);
    CPLib.PutProperty(p,"SCADSALDI",w_SCADSALDI,0);
    CPLib.PutProperty(p,"FLGIPMT",w_FLGIPMT,0);
    CPLib.PutProperty(p,"LIMITEFRZ",w_LIMITEFRZ,0);
    CPLib.PutProperty(p,"DBPROT",w_DBPROT,0);
    CPLib.PutProperty(p,"OAMTPDOC",w_OAMTPDOC,0);
    CPLib.PutProperty(p,"DAYSIMPORT",w_DAYSIMPORT,0);
    CPLib.PutProperty(p,"DAYSIMPCMB",w_DAYSIMPCMB,0);
    CPLib.PutProperty(p,"TIPOSV",w_TIPOSV,0);
    CPLib.PutProperty(p,"FLGAWUPOS",w_FLGAWUPOS,0);
    CPLib.PutProperty(p,"WUGIOSCA",w_WUGIOSCA,0);
    CPLib.PutProperty(p,"WUGGALERT",w_WUGGALERT,0);
    CPLib.PutProperty(p,"SKT_SERVER",w_SKT_SERVER,0);
    CPLib.PutProperty(p,"SKT_PORT",w_SKT_PORT,0);
    CPLib.PutProperty(p,"SKT_PATHS",w_SKT_PATHS,0);
    CPLib.PutProperty(p,"SKT_MODET",w_SKT_MODET,0);
    CPLib.PutProperty(p,"RASPAUI",w_RASPAUI,0);
    CPLib.PutProperty(p,"RESPAUI",w_RESPAUI,0);
    CPLib.PutProperty(p,"TESTIP",w_TESTIP,0);
    CPLib.PutProperty(p,"MINFRZSNAI",w_MINFRZSNAI,0);
    CPLib.PutProperty(p,"FLGSCDFRZ",w_FLGSCDFRZ,0);
    CPLib.PutProperty(p,"GIORNIFRZ",w_GIORNIFRZ,0);
    CPLib.PutProperty(p,"LIMITVLT",w_LIMITVLT,0);
    CPLib.PutProperty(p,"LIMITVNP",w_LIMITVNP,0);
    CPLib.PutProperty(p,"FLGSTPDIR",w_FLGSTPDIR,0);
    CPLib.PutProperty(p,"FLGNODOC",w_FLGNODOC,0);
    CPLib.PutProperty(p,"SNAISTOR",w_SNAISTOR,0);
    CPLib.PutProperty(p,"FRAZDEL",w_FRAZDEL,0);
    CPLib.PutProperty(p,"PATHAPP",w_PATHAPP,0);
    CPLib.PutProperty(p,"FLGDDOC",w_FLGDDOC,0);
    CPLib.PutProperty(p,"FLGLIGHT",w_FLGLIGHT,0);
    CPLib.PutProperty(p,"FLGCGOPWD",w_FLGCGOPWD,0);
    CPLib.PutProperty(p,"PATHSID",w_PATHSID,0);
    CPLib.PutProperty(p,"PATHCERT",w_PATHCERT,0);
    CPLib.PutProperty(p,"PATHFTP",w_PATHFTP,0);
    CPLib.PutProperty(p,"FLGUTEAGE",w_FLGUTEAGE,0);
    CPLib.PutProperty(p,"PRGAEPATH",w_PRGAEPATH,0);
    CPLib.PutProperty(p,"NUMGIORN",w_NUMGIORN,0);
    CPLib.PutProperty(p,"COGNOME",w_COGNOME,0);
    CPLib.PutProperty(p,"NOME",w_NOME,0);
    CPLib.PutProperty(p,"DNASC",w_DNASC,0);
    CPLib.PutProperty(p,"CITTADINA",w_CITTADINA,0);
    CPLib.PutProperty(p,"NASCOMUN",w_NASCOMUN,0);
    CPLib.PutProperty(p,"NASSTATO",w_NASSTATO,0);
    CPLib.PutProperty(p,"PRNASC",w_PRNASC,0);
    CPLib.PutProperty(p,"SOGCOM",w_SOGCOM,0);
    CPLib.PutProperty(p,"ALTSRVMAIL",w_ALTSRVMAIL,0);
    CPLib.PutProperty(p,"ALTPRTMAIL",w_ALTPRTMAIL,0);
    CPLib.PutProperty(p,"ALTEMLMAIL",w_ALTEMLMAIL,0);
    CPLib.PutProperty(p,"ALTUSRMAIL",w_ALTUSRMAIL,0);
    CPLib.PutProperty(p,"ALTPWDMAIL",w_ALTPWDMAIL,0);
    CPLib.PutProperty(p,"FLGGESDOC",w_FLGGESDOC,0);
    CPLib.PutProperty(p,"USRGESDOC",w_USRGESDOC,0);
    CPLib.PutProperty(p,"PWDGESDOC",w_PWDGESDOC,0);
    CPLib.PutProperty(p,"URLDESDOC",w_URLDESDOC,0);
    CPLib.PutProperty(p,"EMAILDOC",w_EMAILDOC,0);
    CPLib.PutProperty(p,"DATADOC",w_DATADOC,0);
    CPLib.PutProperty(p,"PATHDOCBAC",w_PATHDOCBAC,0);
    CPLib.PutProperty(p,"IMPPATH",w_IMPPATH,0);
    CPLib.PutProperty(p,"BPCODPAT",w_BPCODPAT,0);
    CPLib.PutProperty(p,"BPENTSEG",w_BPENTSEG,0);
    CPLib.PutProperty(p,"BPCOGSEG",w_BPCOGSEG,0);
    CPLib.PutProperty(p,"BPNOMSEG",w_BPNOMSEG,0);
    CPLib.PutProperty(p,"BPTELSEG",w_BPTELSEG,0);
    CPLib.PutProperty(p,"BPEMLSEG",w_BPEMLSEG,0);
    CPLib.PutProperty(p,"RICEVUTE",w_RICEVUTE,0);
    CPLib.PutProperty(p,"ABI",w_ABI,0);
    CPLib.PutProperty(p,"CAB",w_CAB,0);
    CPLib.PutProperty(p,"OGGI3I4",w_OGGI3I4,0);
    CPLib.PutProperty(p,"CGOTGDEFMUL",w_CGOTGDEFMUL,0);
    CPLib.PutProperty(p,"AUTOSARA",w_AUTOSARA,0);
    CPLib.PutProperty(p,"GGWARNPRV",w_GGWARNPRV,0);
    CPLib.PutProperty(p,"GGWARNAUI",w_GGWARNAUI,0);
    CPLib.PutProperty(p,"SOGLIAMAX",w_SOGLIAMAX,0);
    CPLib.PutProperty(p,"LIMITE20",w_LIMITE20,0);
    CPLib.PutProperty(p,"SONUMMESI",w_SONUMMESI,0);
    CPLib.PutProperty(p,"SOMESIBACK",w_SOMESIBACK,0);
    CPLib.PutProperty(p,"SOSHELLCMD",w_SOSHELLCMD,0);
    CPLib.PutProperty(p,"SOAMBIENTE",w_SOAMBIENTE,0);
    CPLib.PutProperty(p,"SOPATHIMPORT",w_SOPATHIMPORT,0);
    CPLib.PutProperty(p,"SOORAIMPORT",w_SOORAIMPORT,0);
    CPLib.PutProperty(p,"QADV_SOGLIA",w_QADV_SOGLIA,0);
    CPLib.PutProperty(p,"FLGCGOOTP",w_FLGCGOOTP,0);
    CPLib.PutProperty(p,"FLGCGOQADV",w_FLGCGOQADV,0);
    CPLib.PutProperty(p,"ITFLGPEP",w_ITFLGPEP,0);
    CPLib.PutProperty(p,"ITPWDPEP",w_ITPWDPEP,0);
    CPLib.PutProperty(p,"ITUSRPEP",w_ITUSRPEP,0);
    CPLib.PutProperty(p,"BLOCCOUSER",w_BLOCCOUSER,0);
    CPLib.PutProperty(p,"CGOFLGPROF",w_CGOFLGPROF,0);
    CPLib.PutProperty(p,"FLGAGGFAM",w_FLGAGGFAM,0);
    CPLib.PutProperty(p,"ALTSSLEMAIL",w_ALTSSLEMAIL,0);
    CPLib.PutProperty(p,"PATHIMPORT",w_PATHIMPORT,0);
    CPLib.PutProperty(p,"DESTEMAIL",w_DESTEMAIL,0);
    CPLib.PutProperty(p,"CODVASP",w_CODVASP,0);
    CPLib.PutProperty(p,"IDOAM",w_IDOAM,0);
    CPLib.PutProperty(p,"IDOAMR",w_IDOAMR,0);
    CPLib.PutProperty(p,"ART1",w_ART1,0);
    CPLib.PutProperty(p,"DESCRIsta",w_DESCRIsta,0);
    CPLib.PutProperty(p,"DESCSGRU",w_DESCSGRU,0);
    CPLib.PutProperty(p,"DESCRAMGRU",w_DESCRAMGRU,0);
    CPLib.PutProperty(p,"DESCUIC",w_DESCUIC,0);
    CPLib.PutProperty(p,"descdip",w_descdip,0);
    CPLib.PutProperty(p,"tipsot",w_tipsot,0);
    CPLib.PutProperty(p,"xdescitdip",w_xdescitdip,0);
    CPLib.PutProperty(p,"xcabdip",w_xcabdip,0);
    CPLib.PutProperty(p,"gUserCode",w_gUserCode,0);
    CPLib.PutProperty(p,"ATTIV",w_ATTIV,0);
    CPLib.PutProperty(p,"gUrlApp",w_gUrlApp,0);
    CPLib.PutProperty(p,"gAzienda",w_gAzienda,0);
    CPLib.PutProperty(p,"PWDSER",w_PWDSER,0);
    CPLib.PutProperty(p,"appocert",w_appocert,0);
    CPLib.PutProperty(p,"pathmanuale",w_pathmanuale,0);
    CPLib.PutProperty(p,"xDESCAN",w_xDESCAN,0);
    if (p_bGetChildren) {
      if (ardt_destwarn.IsUpdated()) {
        m_cWv_ardt_destwarn = ardt_destwarn.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_destwarn",m_cWv_ardt_destwarn,0);
    }
    if (p_bGetChildren) {
      if (ardt_cgo_tipall.IsUpdated()) {
        m_cWv_ardt_cgo_tipall = ardt_cgo_tipall.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_cgo_tipall",m_cWv_ardt_cgo_tipall,0);
    }
    if (p_bGetChildren) {
      if (ardt_cgo_subnets.IsUpdated()) {
        m_cWv_ardt_cgo_subnets = ardt_cgo_subnets.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_cgo_subnets",m_cWv_ardt_cgo_subnets,0);
    }
    if (p_bGetChildren) {
      if (ardt_destemail.IsUpdated()) {
        m_cWv_ardt_destemail = ardt_destemail.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_ardt_destemail",m_cWv_ardt_destemail,0);
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
    return "intermbo"+"\\"+CPLib.ToCPStr(p_Caller.GetString("CODINTER","C",11,0));
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
  public boolean ChildExists_ardt_destwarn() {
    if (ardt_destwarn.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_destwarn) || CPLib.IsLoaded(m_cWv_ardt_destwarn))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_destwarn.m_bLoaded)) {
      ardt_destwarn.Blank();
      ardt_destwarn.w_DWCODINT = w_CODINTER;
      ardt_destwarn.Load();
    }
    return ardt_destwarn.m_bLoaded;
  }
  public void CtxLoad_ardt_destwarn() {
    if ( ! (ardt_destwarn.m_lCtxLoaded)) {
      ardt_destwarn.Blank();
    }
    ardt_destwarn.m_lCtxLoaded = true;
    if ( ! (ardt_destwarn.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_destwarn) || CPLib.IsLoaded(m_cWv_ardt_destwarn)) {
        ardt_destwarn.SetFromContext(m_cWv_ardt_destwarn);
        m_cWv_ardt_destwarn = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_destwarn.m_bLoaded)) {
          ardt_destwarn.Blank();
          ardt_destwarn.w_DWCODINT = w_CODINTER;
          ardt_destwarn.Load();
          if ( ! (ardt_destwarn.m_bLoaded)) {
            ardt_destwarn.Initialize();
            ardt_destwarn.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_cgo_tipall() {
    if (ardt_cgo_tipall.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_cgo_tipall) || CPLib.IsLoaded(m_cWv_ardt_cgo_tipall))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_cgo_tipall.m_bLoaded)) {
      ardt_cgo_tipall.Blank();
      ardt_cgo_tipall.w_TACODINT = w_CODINTER;
      ardt_cgo_tipall.Load();
    }
    return ardt_cgo_tipall.m_bLoaded;
  }
  public void CtxLoad_ardt_cgo_tipall() {
    if ( ! (ardt_cgo_tipall.m_lCtxLoaded)) {
      ardt_cgo_tipall.Blank();
    }
    ardt_cgo_tipall.m_lCtxLoaded = true;
    if ( ! (ardt_cgo_tipall.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_cgo_tipall) || CPLib.IsLoaded(m_cWv_ardt_cgo_tipall)) {
        ardt_cgo_tipall.SetFromContext(m_cWv_ardt_cgo_tipall);
        m_cWv_ardt_cgo_tipall = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_cgo_tipall.m_bLoaded)) {
          ardt_cgo_tipall.Blank();
          ardt_cgo_tipall.w_TACODINT = w_CODINTER;
          ardt_cgo_tipall.Load();
          if ( ! (ardt_cgo_tipall.m_bLoaded)) {
            ardt_cgo_tipall.Initialize();
            ardt_cgo_tipall.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_cgo_subnets() {
    if (ardt_cgo_subnets.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_cgo_subnets) || CPLib.IsLoaded(m_cWv_ardt_cgo_subnets))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_cgo_subnets.m_bLoaded)) {
      ardt_cgo_subnets.Blank();
      ardt_cgo_subnets.w_SNCODINT = w_CODINTER;
      ardt_cgo_subnets.Load();
    }
    return ardt_cgo_subnets.m_bLoaded;
  }
  public void CtxLoad_ardt_cgo_subnets() {
    if ( ! (ardt_cgo_subnets.m_lCtxLoaded)) {
      ardt_cgo_subnets.Blank();
    }
    ardt_cgo_subnets.m_lCtxLoaded = true;
    if ( ! (ardt_cgo_subnets.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_cgo_subnets) || CPLib.IsLoaded(m_cWv_ardt_cgo_subnets)) {
        ardt_cgo_subnets.SetFromContext(m_cWv_ardt_cgo_subnets);
        m_cWv_ardt_cgo_subnets = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_cgo_subnets.m_bLoaded)) {
          ardt_cgo_subnets.Blank();
          ardt_cgo_subnets.w_SNCODINT = w_CODINTER;
          ardt_cgo_subnets.Load();
          if ( ! (ardt_cgo_subnets.m_bLoaded)) {
            ardt_cgo_subnets.Initialize();
            ardt_cgo_subnets.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_ardt_destemail() {
    if (ardt_destemail.IsUpdated() || (CPLib.IsUpdated(m_cWv_ardt_destemail) || CPLib.IsLoaded(m_cWv_ardt_destemail))) {
      return true;
    } else if (m_bLoaded &&  ! (ardt_destemail.m_bLoaded)) {
      ardt_destemail.Blank();
      ardt_destemail.w_DWCODINT = w_CODINTER;
      ardt_destemail.Load();
    }
    return ardt_destemail.m_bLoaded;
  }
  public void CtxLoad_ardt_destemail() {
    if ( ! (ardt_destemail.m_lCtxLoaded)) {
      ardt_destemail.Blank();
    }
    ardt_destemail.m_lCtxLoaded = true;
    if ( ! (ardt_destemail.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_ardt_destemail) || CPLib.IsLoaded(m_cWv_ardt_destemail)) {
        ardt_destemail.SetFromContext(m_cWv_ardt_destemail);
        m_cWv_ardt_destemail = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (ardt_destemail.m_bLoaded)) {
          ardt_destemail.Blank();
          ardt_destemail.w_DWCODINT = w_CODINTER;
          ardt_destemail.Load();
          if ( ! (ardt_destemail.m_bLoaded)) {
            ardt_destemail.Initialize();
            ardt_destemail.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"ardt_destwarn")) {
      CtxLoad_ardt_destwarn();
      return ardt_destwarn;
    }
    if (CPLib.eq(p_cName,"ardt_cgo_tipall")) {
      CtxLoad_ardt_cgo_tipall();
      return ardt_cgo_tipall;
    }
    if (CPLib.eq(p_cName,"ardt_cgo_subnets")) {
      CtxLoad_ardt_cgo_subnets();
      return ardt_cgo_subnets;
    }
    if (CPLib.eq(p_cName,"ardt_destemail")) {
      CtxLoad_ardt_destemail();
      return ardt_destemail;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
