// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_imp_newtabs_oldR implements CallerWithObjs {
  // gestori associati a particolari eventi ('Routine start')
  public static volatile java.util.Map<String,java.util.List<com.zucchetti.sitepainter.EventHandler>> specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile java.util.List<com.zucchetti.sitepainter.EventHandler> allEventsHandlers;
  // indica se si sta gestendo un evento scatenato da questa routine per restituire il valore corretto di i_EntityName ed i_EntityType
  static boolean m_bEventRunning;
  public String m_cLastMsgError;
  public boolean m_bError;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabile di caller (variabili di caller): passata nel costruttore
  public CallerWithObjs m_Caller;
  public String m_cPhName_cauanainter;
  public String m_cServer_cauanainter;
  public String m_cPhName_cgo_tbconvgio;
  public String m_cServer_cgo_tbconvgio;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcandistr;
  public String m_cServer_tbcandistr;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tberrdge;
  public String m_cServer_tberrdge;
  public String m_cPhName_tberrorisid;
  public String m_cServer_tberrorisid;
  public String m_cPhName_tberrsiddgn;
  public String m_cServer_tberrsiddgn;
  public String m_cPhName_tbesielb;
  public String m_cServer_tbesielb;
  public String m_cPhName_tbesitoae;
  public String m_cServer_tbesitoae;
  public String m_cPhName_tbident;
  public String m_cServer_tbident;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
  public String m_cPhName_tbnatura;
  public String m_cServer_tbnatura;
  public String m_cPhName_tbprovsv;
  public String m_cServer_tbprovsv;
  public String m_cPhName_tbprvreg;
  public String m_cServer_tbprvreg;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public String m_cPhName_tbrapp;
  public String m_cServer_tbrapp;
  public String m_cPhName_tbrappogg;
  public String m_cServer_tbrappogg;
  public String m_cPhName_tbricevutesid;
  public String m_cServer_tbricevutesid;
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
  public String m_cPhName_tbscopo;
  public String m_cServer_tbscopo;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tbsetsina;
  public String m_cServer_tbsetsina;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbstatiocse;
  public String m_cServer_tbstatiocse;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_tbtipint;
  public String m_cServer_tbtipint;
  public String m_cPhName_tbtipleg;
  public String m_cServer_tbtipleg;
  public String m_cPhName_tbtipnat;
  public String m_cServer_tbtipnat;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_tbtipope;
  public String m_cServer_tbtipope;
  public String m_cPhName_tbprcsched;
  public String m_cServer_tbprcsched;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String w_tbcitta;
  public String w_tbstati;
  public String w_tbsetsin;
  public String w_tbcauana;
  public String w_inter2bo;
  public String w_tbvalute;
  public String w_tbtipreg;
  public String w_tbtipint;
  public String w_tbesitoage;
  public String w_tbrapp;
  public String w_tbstgru;
  public String w_tbramgru;
  public String w_tbtipdoc;
  public String w_tbtipleg;
  public String w_tbtipnat;
  public String w_tberrorisid;
  public String w_tberrsiddgn;
  public String w_tbricevutesid;
  public String w_tbcittna;
  public String w_tbstatna;
  public String w_tberrdge;
  public String w_tbprvreg;
  public String w_tbesielb;
  public String w_convgio;
  public String w_staticrs;
  public String w_tbcandistr;
  public String w_tbluonas;
  public String w_tbprovsv;
  public String w_rapogg;
  public String w_tbnatura;
  public String w_tbscopo;
  public String w_tbrisglob;
  public String w_tbident;
  public String w_tbtipope;
  public String w_tbprcsched;
  public String fhand;
  public String riga;
  public String _code1;
  public String _code;
  public String _code2;
  public String _code3;
  public String _code4;
  public String _code10;
  public String _code11;
  public String _code40;
  public double _codenum;
  public String _dbaicab;
  public double conta;
  public String _lista;
  public String _oldazi;
  public String _id4;
  public String _stringa;
  public double _id;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgWU;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_imp_newtabs_oldR (CPContext p_ContextObject, Caller caller) {
    if (caller == null)
      m_Caller = CallerWithObjsImpl.EMPTY;
    else if (caller instanceof CallerWithObjs)
      m_Caller = (CallerWithObjs)caller;
    else
      m_Caller = new CallerWithObjsImpl(caller);
    m_Ctx=p_ContextObject;
    // Assegnazione della variabile di collegamento con il database
    m_Sql=m_Ctx.GetSql();
    /*  Impostazione dell'ambiente globale: il businness object si collega
                                all'oggetto globale (unico per più istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda è contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_imp_newtabs_old",m_Caller);
    m_cPhName_cauanainter = p_ContextObject.GetPhName("cauanainter");
    if (m_cPhName_cauanainter.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cauanainter = m_cPhName_cauanainter+" "+m_Ctx.GetWritePhName("cauanainter");
    }
    m_cServer_cauanainter = p_ContextObject.GetServer("cauanainter");
    m_cPhName_cgo_tbconvgio = p_ContextObject.GetPhName("cgo_tbconvgio");
    if (m_cPhName_cgo_tbconvgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbconvgio = m_cPhName_cgo_tbconvgio+" "+m_Ctx.GetWritePhName("cgo_tbconvgio");
    }
    m_cServer_cgo_tbconvgio = p_ContextObject.GetServer("cgo_tbconvgio");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcandistr = p_ContextObject.GetPhName("tbcandistr");
    if (m_cPhName_tbcandistr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcandistr = m_cPhName_tbcandistr+" "+m_Ctx.GetWritePhName("tbcandistr");
    }
    m_cServer_tbcandistr = p_ContextObject.GetServer("tbcandistr");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    if (m_cPhName_tbcausin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcausin = m_cPhName_tbcausin+" "+m_Ctx.GetWritePhName("tbcausin");
    }
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tberrdge = p_ContextObject.GetPhName("tberrdge");
    if (m_cPhName_tberrdge.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrdge = m_cPhName_tberrdge+" "+m_Ctx.GetWritePhName("tberrdge");
    }
    m_cServer_tberrdge = p_ContextObject.GetServer("tberrdge");
    m_cPhName_tberrorisid = p_ContextObject.GetPhName("tberrorisid");
    if (m_cPhName_tberrorisid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrorisid = m_cPhName_tberrorisid+" "+m_Ctx.GetWritePhName("tberrorisid");
    }
    m_cServer_tberrorisid = p_ContextObject.GetServer("tberrorisid");
    m_cPhName_tberrsiddgn = p_ContextObject.GetPhName("tberrsiddgn");
    if (m_cPhName_tberrsiddgn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrsiddgn = m_cPhName_tberrsiddgn+" "+m_Ctx.GetWritePhName("tberrsiddgn");
    }
    m_cServer_tberrsiddgn = p_ContextObject.GetServer("tberrsiddgn");
    m_cPhName_tbesielb = p_ContextObject.GetPhName("tbesielb");
    if (m_cPhName_tbesielb.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesielb = m_cPhName_tbesielb+" "+m_Ctx.GetWritePhName("tbesielb");
    }
    m_cServer_tbesielb = p_ContextObject.GetServer("tbesielb");
    m_cPhName_tbesitoae = p_ContextObject.GetPhName("tbesitoae");
    if (m_cPhName_tbesitoae.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesitoae = m_cPhName_tbesitoae+" "+m_Ctx.GetWritePhName("tbesitoae");
    }
    m_cServer_tbesitoae = p_ContextObject.GetServer("tbesitoae");
    m_cPhName_tbident = p_ContextObject.GetPhName("tbident");
    if (m_cPhName_tbident.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbident = m_cPhName_tbident+" "+m_Ctx.GetWritePhName("tbident");
    }
    m_cServer_tbident = p_ContextObject.GetServer("tbident");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    m_cPhName_tbnatura = p_ContextObject.GetPhName("tbnatura");
    if (m_cPhName_tbnatura.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbnatura = m_cPhName_tbnatura+" "+m_Ctx.GetWritePhName("tbnatura");
    }
    m_cServer_tbnatura = p_ContextObject.GetServer("tbnatura");
    m_cPhName_tbprovsv = p_ContextObject.GetPhName("tbprovsv");
    if (m_cPhName_tbprovsv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprovsv = m_cPhName_tbprovsv+" "+m_Ctx.GetWritePhName("tbprovsv");
    }
    m_cServer_tbprovsv = p_ContextObject.GetServer("tbprovsv");
    m_cPhName_tbprvreg = p_ContextObject.GetPhName("tbprvreg");
    if (m_cPhName_tbprvreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprvreg = m_cPhName_tbprvreg+" "+m_Ctx.GetWritePhName("tbprvreg");
    }
    m_cServer_tbprvreg = p_ContextObject.GetServer("tbprvreg");
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    if (m_cPhName_tbramgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbramgru = m_cPhName_tbramgru+" "+m_Ctx.GetWritePhName("tbramgru");
    }
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_cPhName_tbrapp = p_ContextObject.GetPhName("tbrapp");
    if (m_cPhName_tbrapp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbrapp = m_cPhName_tbrapp+" "+m_Ctx.GetWritePhName("tbrapp");
    }
    m_cServer_tbrapp = p_ContextObject.GetServer("tbrapp");
    m_cPhName_tbrappogg = p_ContextObject.GetPhName("tbrappogg");
    if (m_cPhName_tbrappogg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbrappogg = m_cPhName_tbrappogg+" "+m_Ctx.GetWritePhName("tbrappogg");
    }
    m_cServer_tbrappogg = p_ContextObject.GetServer("tbrappogg");
    m_cPhName_tbricevutesid = p_ContextObject.GetPhName("tbricevutesid");
    if (m_cPhName_tbricevutesid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbricevutesid = m_cPhName_tbricevutesid+" "+m_Ctx.GetWritePhName("tbricevutesid");
    }
    m_cServer_tbricevutesid = p_ContextObject.GetServer("tbricevutesid");
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    if (m_cPhName_tbrisglob.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbrisglob = m_cPhName_tbrisglob+" "+m_Ctx.GetWritePhName("tbrisglob");
    }
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    m_cPhName_tbscopo = p_ContextObject.GetPhName("tbscopo");
    if (m_cPhName_tbscopo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbscopo = m_cPhName_tbscopo+" "+m_Ctx.GetWritePhName("tbscopo");
    }
    m_cServer_tbscopo = p_ContextObject.GetServer("tbscopo");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_tbsetsina = p_ContextObject.GetPhName("tbsetsina");
    if (m_cPhName_tbsetsina.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsina = m_cPhName_tbsetsina+" "+m_Ctx.GetWritePhName("tbsetsina");
    }
    m_cServer_tbsetsina = p_ContextObject.GetServer("tbsetsina");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbstatiocse = p_ContextObject.GetPhName("tbstatiocse");
    if (m_cPhName_tbstatiocse.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatiocse = m_cPhName_tbstatiocse+" "+m_Ctx.GetWritePhName("tbstatiocse");
    }
    m_cServer_tbstatiocse = p_ContextObject.GetServer("tbstatiocse");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_tbtipint = p_ContextObject.GetPhName("tbtipint");
    if (m_cPhName_tbtipint.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipint = m_cPhName_tbtipint+" "+m_Ctx.GetWritePhName("tbtipint");
    }
    m_cServer_tbtipint = p_ContextObject.GetServer("tbtipint");
    m_cPhName_tbtipleg = p_ContextObject.GetPhName("tbtipleg");
    if (m_cPhName_tbtipleg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipleg = m_cPhName_tbtipleg+" "+m_Ctx.GetWritePhName("tbtipleg");
    }
    m_cServer_tbtipleg = p_ContextObject.GetServer("tbtipleg");
    m_cPhName_tbtipnat = p_ContextObject.GetPhName("tbtipnat");
    if (m_cPhName_tbtipnat.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipnat = m_cPhName_tbtipnat+" "+m_Ctx.GetWritePhName("tbtipnat");
    }
    m_cServer_tbtipnat = p_ContextObject.GetServer("tbtipnat");
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    if (m_cPhName_tbtipreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipreg = m_cPhName_tbtipreg+" "+m_Ctx.GetWritePhName("tbtipreg");
    }
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_tbtipope = p_ContextObject.GetPhName("tbtipope");
    if (m_cPhName_tbtipope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipope = m_cPhName_tbtipope+" "+m_Ctx.GetWritePhName("tbtipope");
    }
    m_cServer_tbtipope = p_ContextObject.GetServer("tbtipope");
    m_cPhName_tbprcsched = p_ContextObject.GetPhName("tbprcsched");
    if (m_cPhName_tbprcsched.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprcsched = m_cPhName_tbprcsched+" "+m_Ctx.GetWritePhName("tbprcsched");
    }
    m_cServer_tbprcsched = p_ContextObject.GetServer("tbprcsched");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_codenum",p_cVarName)) {
      return _codenum;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_imp_newtabs_old";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tbcitta",p_cVarName)) {
      return w_tbcitta;
    }
    if (CPLib.eqr("tbstati",p_cVarName)) {
      return w_tbstati;
    }
    if (CPLib.eqr("tbsetsin",p_cVarName)) {
      return w_tbsetsin;
    }
    if (CPLib.eqr("tbcauana",p_cVarName)) {
      return w_tbcauana;
    }
    if (CPLib.eqr("inter2bo",p_cVarName)) {
      return w_inter2bo;
    }
    if (CPLib.eqr("tbvalute",p_cVarName)) {
      return w_tbvalute;
    }
    if (CPLib.eqr("tbtipreg",p_cVarName)) {
      return w_tbtipreg;
    }
    if (CPLib.eqr("tbtipint",p_cVarName)) {
      return w_tbtipint;
    }
    if (CPLib.eqr("tbesitoage",p_cVarName)) {
      return w_tbesitoage;
    }
    if (CPLib.eqr("tbrapp",p_cVarName)) {
      return w_tbrapp;
    }
    if (CPLib.eqr("tbstgru",p_cVarName)) {
      return w_tbstgru;
    }
    if (CPLib.eqr("tbramgru",p_cVarName)) {
      return w_tbramgru;
    }
    if (CPLib.eqr("tbtipdoc",p_cVarName)) {
      return w_tbtipdoc;
    }
    if (CPLib.eqr("tbtipleg",p_cVarName)) {
      return w_tbtipleg;
    }
    if (CPLib.eqr("tbtipnat",p_cVarName)) {
      return w_tbtipnat;
    }
    if (CPLib.eqr("tberrorisid",p_cVarName)) {
      return w_tberrorisid;
    }
    if (CPLib.eqr("tberrsiddgn",p_cVarName)) {
      return w_tberrsiddgn;
    }
    if (CPLib.eqr("tbricevutesid",p_cVarName)) {
      return w_tbricevutesid;
    }
    if (CPLib.eqr("tbcittna",p_cVarName)) {
      return w_tbcittna;
    }
    if (CPLib.eqr("tbstatna",p_cVarName)) {
      return w_tbstatna;
    }
    if (CPLib.eqr("tberrdge",p_cVarName)) {
      return w_tberrdge;
    }
    if (CPLib.eqr("tbprvreg",p_cVarName)) {
      return w_tbprvreg;
    }
    if (CPLib.eqr("tbesielb",p_cVarName)) {
      return w_tbesielb;
    }
    if (CPLib.eqr("convgio",p_cVarName)) {
      return w_convgio;
    }
    if (CPLib.eqr("staticrs",p_cVarName)) {
      return w_staticrs;
    }
    if (CPLib.eqr("tbcandistr",p_cVarName)) {
      return w_tbcandistr;
    }
    if (CPLib.eqr("tbluonas",p_cVarName)) {
      return w_tbluonas;
    }
    if (CPLib.eqr("tbprovsv",p_cVarName)) {
      return w_tbprovsv;
    }
    if (CPLib.eqr("rapogg",p_cVarName)) {
      return w_rapogg;
    }
    if (CPLib.eqr("tbnatura",p_cVarName)) {
      return w_tbnatura;
    }
    if (CPLib.eqr("tbscopo",p_cVarName)) {
      return w_tbscopo;
    }
    if (CPLib.eqr("tbrisglob",p_cVarName)) {
      return w_tbrisglob;
    }
    if (CPLib.eqr("tbident",p_cVarName)) {
      return w_tbident;
    }
    if (CPLib.eqr("tbtipope",p_cVarName)) {
      return w_tbtipope;
    }
    if (CPLib.eqr("tbprcsched",p_cVarName)) {
      return w_tbprcsched;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_code1",p_cVarName)) {
      return _code1;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      return _code;
    }
    if (CPLib.eqr("_code2",p_cVarName)) {
      return _code2;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      return _code3;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      return _code4;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      return _code10;
    }
    if (CPLib.eqr("_code11",p_cVarName)) {
      return _code11;
    }
    if (CPLib.eqr("_code40",p_cVarName)) {
      return _code40;
    }
    if (CPLib.eqr("_dbaicab",p_cVarName)) {
      return _dbaicab;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      return _lista;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_id4",p_cVarName)) {
      return _id4;
    }
    if (CPLib.eqr("_stringa",p_cVarName)) {
      return _stringa;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_codenum",p_cVarName)) {
      _codenum = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tbcitta",p_cVarName)) {
      w_tbcitta = value;
      return;
    }
    if (CPLib.eqr("tbstati",p_cVarName)) {
      w_tbstati = value;
      return;
    }
    if (CPLib.eqr("tbsetsin",p_cVarName)) {
      w_tbsetsin = value;
      return;
    }
    if (CPLib.eqr("tbcauana",p_cVarName)) {
      w_tbcauana = value;
      return;
    }
    if (CPLib.eqr("inter2bo",p_cVarName)) {
      w_inter2bo = value;
      return;
    }
    if (CPLib.eqr("tbvalute",p_cVarName)) {
      w_tbvalute = value;
      return;
    }
    if (CPLib.eqr("tbtipreg",p_cVarName)) {
      w_tbtipreg = value;
      return;
    }
    if (CPLib.eqr("tbtipint",p_cVarName)) {
      w_tbtipint = value;
      return;
    }
    if (CPLib.eqr("tbesitoage",p_cVarName)) {
      w_tbesitoage = value;
      return;
    }
    if (CPLib.eqr("tbrapp",p_cVarName)) {
      w_tbrapp = value;
      return;
    }
    if (CPLib.eqr("tbstgru",p_cVarName)) {
      w_tbstgru = value;
      return;
    }
    if (CPLib.eqr("tbramgru",p_cVarName)) {
      w_tbramgru = value;
      return;
    }
    if (CPLib.eqr("tbtipdoc",p_cVarName)) {
      w_tbtipdoc = value;
      return;
    }
    if (CPLib.eqr("tbtipleg",p_cVarName)) {
      w_tbtipleg = value;
      return;
    }
    if (CPLib.eqr("tbtipnat",p_cVarName)) {
      w_tbtipnat = value;
      return;
    }
    if (CPLib.eqr("tberrorisid",p_cVarName)) {
      w_tberrorisid = value;
      return;
    }
    if (CPLib.eqr("tberrsiddgn",p_cVarName)) {
      w_tberrsiddgn = value;
      return;
    }
    if (CPLib.eqr("tbricevutesid",p_cVarName)) {
      w_tbricevutesid = value;
      return;
    }
    if (CPLib.eqr("tbcittna",p_cVarName)) {
      w_tbcittna = value;
      return;
    }
    if (CPLib.eqr("tbstatna",p_cVarName)) {
      w_tbstatna = value;
      return;
    }
    if (CPLib.eqr("tberrdge",p_cVarName)) {
      w_tberrdge = value;
      return;
    }
    if (CPLib.eqr("tbprvreg",p_cVarName)) {
      w_tbprvreg = value;
      return;
    }
    if (CPLib.eqr("tbesielb",p_cVarName)) {
      w_tbesielb = value;
      return;
    }
    if (CPLib.eqr("convgio",p_cVarName)) {
      w_convgio = value;
      return;
    }
    if (CPLib.eqr("staticrs",p_cVarName)) {
      w_staticrs = value;
      return;
    }
    if (CPLib.eqr("tbcandistr",p_cVarName)) {
      w_tbcandistr = value;
      return;
    }
    if (CPLib.eqr("tbluonas",p_cVarName)) {
      w_tbluonas = value;
      return;
    }
    if (CPLib.eqr("tbprovsv",p_cVarName)) {
      w_tbprovsv = value;
      return;
    }
    if (CPLib.eqr("rapogg",p_cVarName)) {
      w_rapogg = value;
      return;
    }
    if (CPLib.eqr("tbnatura",p_cVarName)) {
      w_tbnatura = value;
      return;
    }
    if (CPLib.eqr("tbscopo",p_cVarName)) {
      w_tbscopo = value;
      return;
    }
    if (CPLib.eqr("tbrisglob",p_cVarName)) {
      w_tbrisglob = value;
      return;
    }
    if (CPLib.eqr("tbident",p_cVarName)) {
      w_tbident = value;
      return;
    }
    if (CPLib.eqr("tbtipope",p_cVarName)) {
      w_tbtipope = value;
      return;
    }
    if (CPLib.eqr("tbprcsched",p_cVarName)) {
      w_tbprcsched = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_code1",p_cVarName)) {
      _code1 = value;
      return;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      _code = value;
      return;
    }
    if (CPLib.eqr("_code2",p_cVarName)) {
      _code2 = value;
      return;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      _code3 = value;
      return;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      _code4 = value;
      return;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      _code10 = value;
      return;
    }
    if (CPLib.eqr("_code11",p_cVarName)) {
      _code11 = value;
      return;
    }
    if (CPLib.eqr("_code40",p_cVarName)) {
      _code40 = value;
      return;
    }
    if (CPLib.eqr("_dbaicab",p_cVarName)) {
      _dbaicab = value;
      return;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      _lista = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_id4",p_cVarName)) {
      _id4 = value;
      return;
    }
    if (CPLib.eqr("_stringa",p_cVarName)) {
      _stringa = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbcauana=null;
    try {
      /* w_tbcitta Char(1) */
      /* w_tbstati Char(1) */
      /* w_tbsetsin Char(1) */
      /* w_tbcauana Char(1) */
      /* w_inter2bo Char(1) */
      /* w_tbvalute Char(1) */
      /* w_tbtipreg Char(1) */
      /* w_tbtipint Char(1) */
      /* w_tbesitoage Char(1) */
      /* w_tbrapp Char(1) */
      /* w_tbstgru Char(1) */
      /* w_tbramgru Char(1) */
      /* w_tbtipdoc Char(1) */
      /* w_tbtipleg Char(1) */
      /* w_tbtipnat Char(1) */
      /* w_tberrorisid Char(1) */
      /* w_tberrsiddgn Char(1) */
      /* w_tbricevutesid Char(1) */
      /* w_tbcittna Char(1) */
      /* w_tbstatna Char(1) */
      /* w_tberrdge Char(1) */
      /* w_tbprvreg Char(1) */
      /* w_tbesielb Char(1) */
      /* w_convgio Char(1) */
      /* w_staticrs Char(1) */
      /* w_tbcandistr Char(1) */
      /* w_tbluonas Char(1) */
      /* w_tbprovsv Char(1) */
      /* w_rapogg Char(1) */
      /* w_tbnatura Char(1) */
      /* w_tbscopo Char(1) */
      /* w_tbrisglob Char(1) */
      /* w_tbident Char(1) */
      /* w_tbtipope Char(1) */
      /* w_tbtipope Char(1) */
      /* w_tbprcsched Char(1) // Processi Schedulabili */
      /* fhand Char(1) */
      /* riga Memo */
      /* _code1 Char(1) */
      /* _code Char(2) */
      /* _code2 Char(2) */
      /* _code3 Char(3) */
      /* _code4 Char(4) */
      /* _code10 Char(10) */
      /* _code11 Char(11) */
      /* _code40 Char(40) */
      /* _codenum Numeric(10, 0) */
      /* _dbaicab Char(70) */
      /* conta Numeric(10, 0) */
      /* _lista Char(30) */
      /* _oldazi Char(10) */
      /* _id4 Char(4) */
      /* _stringa Char(100) */
      /* _id Numeric(5, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo */
      /* gFlgWU Char(1) // Gestione WU */
      /* Lettura Tabelle */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000003Fstatus;
      nTry0000003Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000003Fmsg;
      cTry0000003Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_tbtipdoc='S' */
        if (CPLib.eqr(w_tbtipdoc,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipdoc.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipdoc.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipdoc.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbtipdoc.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPDOC - Inserimento codice '+ Left(riga,2) */
              gMsgImp = "TBTIPDOC - Inserimento codice "+CPLib.Left(riga,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbtipdoc
              m_cServer = m_Ctx.GetServer("tbtipdoc");
              m_cPhName = m_Ctx.GetPhName("tbtipdoc");
              m_cSql = "";
              m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"C",2,0,m_cServer),m_cServer,CPLib.Left(riga,2));
              if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPDOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("TIPDOC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code)),0)) {
                // * --- Insert into tbtipdoc from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipdoc");
                m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipdoc",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000004B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000004B(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,3,30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipdoc",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipdoc from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipdoc");
                m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipdoc",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000004C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,3,30),"C",30,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipdoc",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPDOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,2))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipdoc.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipdoc.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbtipleg='S' */
        if (CPLib.eqr(w_tbtipleg,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipleg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipleg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipleg.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbtipleg.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPLEG - Inserimento codice '+ Left(riga,1) */
              gMsgImp = "TBTIPLEG - Inserimento codice "+CPLib.Left(riga,1);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code1 := '' */
              _code1 = "";
              // * --- Read from tbtipleg
              m_cServer = m_Ctx.GetServer("tbtipleg");
              m_cPhName = m_Ctx.GetPhName("tbtipleg");
              m_cSql = "";
              m_cSql = m_cSql+"TIPLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(riga,1));
              if (m_Ctx.IsSharedTemp("tbtipleg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPLEG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code1 = Read_Cursor.GetString("TIPLEG");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipleg into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code1 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code1)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code1)),0)) {
                // * --- Insert into tbtipleg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipleg");
                m_cPhName = m_Ctx.GetPhName("tbtipleg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipleg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,95),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,97,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,105,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,113,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,114,95),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,209,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,217,8)),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipleg",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipleg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipleg");
                m_cPhName = m_Ctx.GetPhName("tbtipleg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipleg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000005B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.Substr(riga,2,95),"C",95,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,97,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,105,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"FILTRO = "+CPLib.ToSQL(CPLib.Substr(riga,113,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCRIZ2 = "+CPLib.ToSQL(CPLib.Substr(riga,114,95),"C",95,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINID2 = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,209,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFIND2 = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,217,8)),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipleg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,1))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipleg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipleg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbstgru='S' */
        if (CPLib.eqr(w_tbstgru,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstgru.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstgru.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbstgru.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbstgru.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBSTGRU - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBSTGRU - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbstgru
              m_cServer = m_Ctx.GetServer("tbstgru");
              m_cPhName = m_Ctx.GetPhName("tbstgru");
              m_cSql = "";
              m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbstgru")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SOTGRU",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("SOTGRU");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbstgru from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbstgru");
                m_cPhName = m_Ctx.GetPhName("tbstgru");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstgru",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000069")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000069(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,200),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,204,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,206,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,214,8)),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstgru",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbstgru from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbstgru");
                m_cPhName = m_Ctx.GetPhName("tbstgru");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstgru",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,200),"C",200,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOSOT = "+CPLib.ToSQL(CPLib.Substr(riga,204,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,206,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,214,8)),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbstgru",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SOTGRU = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstgru.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstgru.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbramgru='S' */
        if (CPLib.eqr(w_tbramgru,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbramgru.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbramgru.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbramgru.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbramgru.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBRAMGRU - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBRAMGRU - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbramgru
              m_cServer = m_Ctx.GetServer("tbramgru");
              m_cPhName = m_Ctx.GetPhName("tbramgru");
              m_cSql = "";
              m_cSql = m_cSql+"RAMGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbramgru")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAMGRU",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("RAMGRU");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbramgru from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbramgru");
                m_cPhName = m_Ctx.GetPhName("tbramgru");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbramgru",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,70),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbramgru",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbramgru from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbramgru");
                m_cPhName = m_Ctx.GetPhName("tbramgru");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbramgru",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000079")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,70),"C",70,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbramgru",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAMGRU = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbramgru.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbramgru.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbsetsin='S' */
        if (CPLib.eqr(w_tbsetsin,"S")) {
          // * --- Delete from tbsetsina
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbsetsina");
          m_cPhName = m_Ctx.GetPhName("tbsetsina");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsetsina",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000007E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          // * --- Delete from tbsetsin
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbsetsin");
          m_cPhName = m_Ctx.GetPhName("tbsetsin");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsetsin",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000007F")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbsetsin.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbsetsin.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbsetsin.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbsetsin.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* _id := Val(LRTrim(Substr(riga,365,2))) */
              _id = CPLib.Round(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,365,2))),0);
              /* gMsgImp := 'TBSETSIN - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBSETSIN - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tbsetsin
              m_cServer = m_Ctx.GetServer("tbsetsin");
              m_cPhName = m_Ctx.GetPhName("tbsetsin");
              m_cSql = "";
              m_cSql = m_cSql+"IDSETSIN="+CPSql.SQLValueAdapter(CPLib.ToSQL(_id,"N",5,0,m_cServer),m_cServer,_id);
              if (m_Ctx.IsSharedTemp("tbsetsin")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SETSINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("SETSINT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_code3)) */
              if (CPLib.Empty(CPLib.LRTrim(_code3))) {
                // * --- Insert into tbsetsin from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbsetsin");
                m_cPhName = m_Ctx.GetPhName("tbsetsin");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsetsin",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000008A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000008A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,200),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,204,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,207,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,210,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,213,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,216,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,219,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,225,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,228,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,234,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,237,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,241,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,247,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,250,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,253,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,256,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,259,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,262,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,265,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,268,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,271,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,274,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,277,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,280,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,283,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,286,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,289,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,292,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,298,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,304,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,307,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,310,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,313,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,316,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,319,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,322,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,325,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,334,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,337,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,343,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,346,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,349,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,357,8)),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbsetsin",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbsetsin from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbsetsin");
                m_cPhName = m_Ctx.GetPhName("tbsetsin");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsetsin",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000008B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,200),"C",200,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU1 = "+CPLib.ToSQL(CPLib.Substr(riga,204,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU1 = "+CPLib.ToSQL(CPLib.Substr(riga,207,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU2 = "+CPLib.ToSQL(CPLib.Substr(riga,210,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU2 = "+CPLib.ToSQL(CPLib.Substr(riga,213,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU3 = "+CPLib.ToSQL(CPLib.Substr(riga,216,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU3 = "+CPLib.ToSQL(CPLib.Substr(riga,219,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU4 = "+CPLib.ToSQL(CPLib.Substr(riga,222,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU4 = "+CPLib.ToSQL(CPLib.Substr(riga,225,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU5 = "+CPLib.ToSQL(CPLib.Substr(riga,228,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU5 = "+CPLib.ToSQL(CPLib.Substr(riga,231,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAGRU6 = "+CPLib.ToSQL(CPLib.Substr(riga,234,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGRU6 = "+CPLib.ToSQL(CPLib.Substr(riga,237,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT1 = "+CPLib.ToSQL(CPLib.Substr(riga,241,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT1 = "+CPLib.ToSQL(CPLib.Substr(riga,244,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT2 = "+CPLib.ToSQL(CPLib.Substr(riga,247,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT2 = "+CPLib.ToSQL(CPLib.Substr(riga,250,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT3 = "+CPLib.ToSQL(CPLib.Substr(riga,253,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT3 = "+CPLib.ToSQL(CPLib.Substr(riga,256,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT4 = "+CPLib.ToSQL(CPLib.Substr(riga,259,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT4 = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT5 = "+CPLib.ToSQL(CPLib.Substr(riga,265,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT5 = "+CPLib.ToSQL(CPLib.Substr(riga,268,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT6 = "+CPLib.ToSQL(CPLib.Substr(riga,271,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT6 = "+CPLib.ToSQL(CPLib.Substr(riga,274,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT7 = "+CPLib.ToSQL(CPLib.Substr(riga,277,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT7 = "+CPLib.ToSQL(CPLib.Substr(riga,280,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT8 = "+CPLib.ToSQL(CPLib.Substr(riga,283,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT8 = "+CPLib.ToSQL(CPLib.Substr(riga,286,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT9 = "+CPLib.ToSQL(CPLib.Substr(riga,289,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT9 = "+CPLib.ToSQL(CPLib.Substr(riga,292,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT10 = "+CPLib.ToSQL(CPLib.Substr(riga,295,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT10 = "+CPLib.ToSQL(CPLib.Substr(riga,298,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT11 = "+CPLib.ToSQL(CPLib.Substr(riga,301,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT11 = "+CPLib.ToSQL(CPLib.Substr(riga,304,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DASOT12 = "+CPLib.ToSQL(CPLib.Substr(riga,307,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASOT12 = "+CPLib.ToSQL(CPLib.Substr(riga,310,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE1 = "+CPLib.ToSQL(CPLib.Substr(riga,313,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE1 = "+CPLib.ToSQL(CPLib.Substr(riga,316,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE2 = "+CPLib.ToSQL(CPLib.Substr(riga,319,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE2 = "+CPLib.ToSQL(CPLib.Substr(riga,322,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE3 = "+CPLib.ToSQL(CPLib.Substr(riga,325,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE3 = "+CPLib.ToSQL(CPLib.Substr(riga,328,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE4 = "+CPLib.ToSQL(CPLib.Substr(riga,331,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE4 = "+CPLib.ToSQL(CPLib.Substr(riga,334,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE5 = "+CPLib.ToSQL(CPLib.Substr(riga,337,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE5 = "+CPLib.ToSQL(CPLib.Substr(riga,340,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DAATE6 = "+CPLib.ToSQL(CPLib.Substr(riga,343,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"AATE6 = "+CPLib.ToSQL(CPLib.Substr(riga,346,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,349,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,357,8)),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbsetsin",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SETSINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+" and IDSETSIN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_id,"?",0,0,m_cServer),m_cServer,_id)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbsetsin.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbsetsin.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbtipint='S' */
        if (CPLib.eqr(w_tbtipint,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipint.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipint.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipint.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbtipint.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPINT - Inserimento codice '+ Left(riga,2) */
              gMsgImp = "TBTIPINT - Inserimento codice "+CPLib.Left(riga,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbtipint
              m_cServer = m_Ctx.GetServer("tbtipint");
              m_cPhName = m_Ctx.GetPhName("tbtipint");
              m_cSql = "";
              m_cSql = m_cSql+"TIPOINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"C",2,0,m_cServer),m_cServer,CPLib.Left(riga,2));
              if (m_Ctx.IsSharedTemp("tbtipint")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("TIPOINT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipint into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code)),0)) {
                // * --- Insert into tbtipint from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipint");
                m_cPhName = m_Ctx.GetPhName("tbtipint");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipint",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000099")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000099(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,3,240),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipint",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipint from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipint");
                m_cPhName = m_Ctx.GetPhName("tbtipint");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipint",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000009A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,3,240),"C",240,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipint",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPOINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,2))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipint.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipint.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbtipreg='S' */
        if (CPLib.eqr(w_tbtipreg,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipreg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipreg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipreg.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbtipreg.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPREG - Inserimento codice '+ Substr(riga,193,2) */
              gMsgImp = "TBTIPREG - Inserimento codice "+CPLib.Substr(riga,193,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbtipreg
              m_cServer = m_Ctx.GetServer("tbtipreg");
              m_cPhName = m_Ctx.GetPhName("tbtipreg");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,193,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,193,2));
              if (m_Ctx.IsSharedTemp("tbtipreg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipreg into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code)),0)) {
                // * --- Insert into tbtipreg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipreg");
                m_cPhName = m_Ctx.GetPhName("tbtipreg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipreg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A8(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,193,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,90),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,92,60),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,192,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,196,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,155,8))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,204,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,163,8))),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipreg",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipreg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipreg");
                m_cPhName = m_Ctx.GetPhName("tbtipreg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipreg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000A9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DES1 = "+CPLib.ToSQL(CPLib.Substr(riga,2,90),"C",90,0,m_cServer)+", ";
                m_cSql = m_cSql+"DES2 = "+CPLib.ToSQL(CPLib.Substr(riga,92,60),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPREG = "+CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"OPERAZIO = "+CPLib.ToSQL(CPLib.Substr(riga,192,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,196,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,196,8))),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,204,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,204,8))),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipreg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,193,2),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,193,2))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipreg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipreg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbvalute='S' */
        if (CPLib.eqr(w_tbvalute,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbvalute.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbvalute.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbvalute.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbvalute.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBVALUTE - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBVALUTE - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tbvalute
              m_cServer = m_Ctx.GetServer("tbvalute");
              m_cPhName = m_Ctx.GetPhName("tbvalute");
              m_cSql = "";
              m_cSql = m_cSql+"CODVAL="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbvalute")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODVAL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("CODVAL");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbvalute into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbvalute from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbvalute");
                m_cPhName = m_Ctx.GetPhName("tbvalute");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbvalute",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000B7(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,45),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbvalute",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbvalute from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbvalute");
                m_cPhName = m_Ctx.GetPhName("tbvalute");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbvalute",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000B8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,45),"C",45,0,m_cServer)+", ";
                m_cSql = m_cSql+"ISO = "+CPLib.ToSQL(CPLib.Substr(riga,49,3),"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbvalute",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODVAL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbvalute.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbvalute.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbcauana='S' */
        if (CPLib.eqr(w_tbcauana,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcausin.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcausin.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Delete from cauanainter
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cauanainter");
          m_cPhName = m_Ctx.GetPhName("cauanainter");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cauanainter",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000BE")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* fhand := FileLibMit.OpenRead('newtab/tbcausin.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbcausin.txt");
          /* _lista := '' */
          _lista = "";
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBCAUSIN - Inserimento codice '+ Left(riga,2) */
              gMsgImp = "TBCAUSIN - Inserimento codice "+CPLib.Left(riga,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Read from tbcausin
              m_cServer = m_Ctx.GetServer("tbcausin");
              m_cPhName = m_Ctx.GetPhName("tbcausin");
              m_cSql = "";
              m_cSql = m_cSql+"CODVOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"C",2,0,m_cServer),m_cServer,CPLib.Left(riga,2));
              if (m_Ctx.IsSharedTemp("tbcausin")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODVOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("CODVOC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcausin into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_code)) */
              if (CPLib.Empty(CPLib.LRTrim(_code))) {
                // * --- Insert into tbcausin from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcausin");
                m_cPhName = m_Ctx.GetPhName("tbcausin");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcausin",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000C7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C7(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,2)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,3,165)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,169,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,169,8))),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcausin",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbcausin from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcausin");
                m_cPhName = m_Ctx.GetPhName("tbcausin");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcausin",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,3,165)),"C",165,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,169,8)))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,169,8))),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcausin",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODVOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,2)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(riga,2)))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcausin.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcausin.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcauana.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcauana.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* fhand := FileLibMit.OpenRead('newtab/tbcauana.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbcauana.txt");
          /* conta := -1 */
          conta = CPLib.Round(-1,0);
          // * --- Select from tbcauana
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          if (Cursor_tbcauana!=null)
            Cursor_tbcauana.Close();
          Cursor_tbcauana = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select idbase  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcauana")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"idbase ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_tbcauana.Eof())) {
            /* If Val(tbcauana->idbase) > conta */
            if (CPLib.gt(CPLib.Val(Cursor_tbcauana.GetString("idbase")),conta)) {
              /* conta := Val(tbcauana->idbase) */
              conta = CPLib.Round(CPLib.Val(Cursor_tbcauana.GetString("idbase")),0);
            } // End If
            Cursor_tbcauana.Next();
          }
          m_cConnectivityError = Cursor_tbcauana.ErrorMessage();
          Cursor_tbcauana.Close();
          // * --- End Select
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBCAUANA - Inserimento codice '+ Left(riga,4) */
              gMsgImp = "TBCAUANA - Inserimento codice "+CPLib.Left(riga,4);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _lista := Substr(riga,174,50) */
              _lista = CPLib.Substr(riga,174,50);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* _code4 := Right('0000'+LRTrim(Str(conta,10,0)),4) */
              _code4 = CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(conta,10,0)),4);
              // * --- Merge into tbcauana from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbcauana");
              m_cPhName = m_Ctx.GetPhName("tbcauana");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcauana",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(_code4,"?",0,0)+" as idbase";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "tbcauana.idbase = cptmp_1xab23.idbase";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000D8")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" tbcauana USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,5,165)),"C",165,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAU = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,4)),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(CPLib.Substr(riga,170,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAUSINT = "+CPLib.ToSQLNull(CPLib.LRTrim(CPLib.Substr(riga,171,2)),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,224,8)),"")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,224,8))),"D",8,0)+", ";
                m_cSql = m_cSql+"VALPERINT = "+CPLib.ToSQL(CPLib.LRTrim(_lista),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGINTER = "+CPLib.ToSQL(CPLib.Substr(riga,173,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"MITBASE = "+CPLib.ToSQL(CPLib.Substr(riga,232,1),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcauana",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_000000D8(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_code4,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,5,165)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,4)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,170,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.LRTrim(CPLib.Substr(riga,171,2)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,224,8)),"")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,224,8))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_lista),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,173,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,232,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcauana",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,5,165)),"C",165,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAU = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,4)),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(CPLib.Substr(riga,170,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAUSINT = "+CPLib.ToSQLNull(CPLib.LRTrim(CPLib.Substr(riga,171,2)),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,224,8)),"")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,224,8))),"D",8,0)+", ";
                m_cSql = m_cSql+"VALPERINT = "+CPLib.ToSQL(CPLib.LRTrim(_lista),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGINTER = "+CPLib.ToSQL(CPLib.Substr(riga,173,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"MITBASE = "+CPLib.ToSQL(CPLib.Substr(riga,232,1),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcauana",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"idbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_code4,"?",0,0,m_cServer),m_cServer,_code4)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000D8(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_code4,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,5,165)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,4)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,170,1),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.LRTrim(CPLib.Substr(riga,171,2)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,224,8)),"")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,224,8))),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_lista),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,173,1),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,232,1),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcauana",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcauana.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcauana.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbstati='S' */
        if (CPLib.eqr(w_tbstati,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstati.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstati.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Delete from tbstati
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstati",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000DE")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODSTA <> "+CPSql.SQLValueAdapter(CPLib.ToSQL("086","?",0,0,m_cServer),m_cServer,"086")+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* fhand := FileLibMit.OpenRead('newtab/tbstati.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbstati.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBSTATI - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBSTATI - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Merge into tbstati from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstati",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0)+" as CODSTA";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "tbstati.CODSTA = cptmp_1xab23.CODSTA";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000E4")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" tbstati USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,9,40),"C",40,0,m_cServer)+", ";
                m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(CPLib.Substr(riga,50,4),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"ISO = "+CPLib.ToSQL(CPLib.Substr(riga,4,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ISO2 = "+CPLib.ToSQL(CPLib.Substr(riga,7,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(CPLib.Substr(riga,53,10),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGSAE = "+CPLib.ToSQL(CPLib.Substr(riga,81,3),"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbstati",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_000000E4(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,40),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,4),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,53,10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstati",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000E4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,9,40),"C",40,0,m_cServer)+", ";
                m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(CPLib.Substr(riga,50,4),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"ISO = "+CPLib.ToSQL(CPLib.Substr(riga,4,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ISO2 = "+CPLib.ToSQL(CPLib.Substr(riga,7,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(CPLib.Substr(riga,53,10),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGSAE = "+CPLib.ToSQL(CPLib.Substr(riga,81,3),"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbstati",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODSTA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000E4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000E4(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,40),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,4),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,53,10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstati",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstati.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstati.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbcitta='S' */
        if (CPLib.eqr(w_tbcitta,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcitta.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcitta.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbcitta.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbcitta.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* _code4 := Substr(riga,121,4) */
              _code4 = CPLib.Substr(riga,121,4);
              /* gMsgImp := 'COMUNI - Inserimento codice '+ _code4 */
              gMsgImp = "COMUNI - Inserimento codice "+_code4;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code10 := '' */
              _code10 = "";
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_code4,"C",4,0,m_cServer),m_cServer,_code4);
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code10 = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code10 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_code10)) */
              if (CPLib.Empty(CPLib.LRTrim(_code10))) {
                // * --- Insert into tbcitta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcitta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000F3(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,41,60)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,107,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,129,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_code4,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,101,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,109,9),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,118,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,125,4),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,135,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,141,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcitta",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbcitta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcitta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CITTA = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,41,60)),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(CPLib.Substr(riga,107,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDTBLS = "+CPLib.ToSQL(CPLib.Substr(riga,129,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.Substr(riga,101,6),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,109,9),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"PKTBSTATI = "+CPLib.ToSQLNull(CPLib.Substr(riga,118,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(CPLib.Substr(riga,125,4),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDISTAT = "+CPLib.ToSQL(CPLib.Substr(riga,135,6),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDREGIO = "+CPLib.ToSQL(CPLib.Substr(riga,141,2),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcitta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SIGLA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_code4,"?",0,0,m_cServer),m_cServer,_code4)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* If gFlgWU='S' */
              if (CPLib.eqr(gFlgWU,"S")) {
                // * --- Merge into DecodeCitta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("DecodeCitta");
                m_cPhName = m_Ctx.GetPhName("DecodeCitta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(_code4,"?",0,0)+" as SIGLA";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "DecodeCitta.SIGLA = cptmp_1xab23.SIGLA";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000F6")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" DecodeCitta USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"CITTAMIT = "+CPLib.ToSQL(CPLib.Substr(riga,41,60),"C",60,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.Substr(riga,101,6),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(CPLib.Substr(riga,107,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAPMIT = "+CPLib.ToSQL(CPLib.Substr(riga,109,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PKTBSTATI = "+CPLib.ToSQL(CPLib.Substr(riga,118,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(_code4,"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(CPLib.Substr(riga,125,4),"C",4,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"DecodeCitta",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_000000F6(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,41,60),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,101,6),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,107,2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,109,9),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,118,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_code4,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,125,4),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeCitta",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000F6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CITTAMIT = "+CPLib.ToSQL(CPLib.Substr(riga,41,60),"C",60,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.Substr(riga,101,6),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(CPLib.Substr(riga,107,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAPMIT = "+CPLib.ToSQL(CPLib.Substr(riga,109,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PKTBSTATI = "+CPLib.ToSQL(CPLib.Substr(riga,118,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(_code4,"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(CPLib.Substr(riga,125,4),"C",4,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"DecodeCitta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SIGLA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_code4,"?",0,0,m_cServer),m_cServer,_code4)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000000F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000F6(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,41,60),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,101,6),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,107,2),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,109,9),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,118,3),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_code4,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,125,4),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeCitta",true);
                    m_cSql = m_cSql+")";
                  } else {
                    m_cSql = "";
                  }
                }
                if ( ! (CPLib.Empty(m_cSql))) {
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                }
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcitta.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcitta.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbesitoage='S' */
        if (CPLib.eqr(w_tbesitoage,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbesitoae.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbesitoae.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbesitoae.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbesitoae.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBESITOAE - Inserimento codice '+ Left(riga,4) */
              gMsgImp = "TBESITOAE - Inserimento codice "+CPLib.Left(riga,4);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tbesitoae
              m_cServer = m_Ctx.GetServer("tbesitoae");
              m_cPhName = m_Ctx.GetPhName("tbesitoae");
              m_cSql = "";
              m_cSql = m_cSql+"TIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(riga,1));
              m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,2,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,2,3));
              if (m_Ctx.IsSharedTemp("tbesitoae")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbesitoae into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbesitoae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbesitoae");
                m_cPhName = m_Ctx.GetPhName("tbesitoae");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbesitoae",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000104")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000104(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,5,254),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbesitoae",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbesitoae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbesitoae");
                m_cPhName = m_Ctx.GetPhName("tbesitoae");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbesitoae",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000105")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,5,254),"M",10,0,m_cServer,m_oParameters)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbesitoae",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,1))+"";
                m_cSql = m_cSql+" and CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,2,3),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,2,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbesitoae.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbesitoae.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbrapp='S' */
        if (CPLib.eqr(w_tbrapp,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbrapp.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbrapp.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbrapp.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbrapp.txt");
          // * --- Delete from tbrapp
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbrapp");
          m_cPhName = m_Ctx.GetPhName("tbrapp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrapp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000010C")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBRAPP - Inserimento codice '+ Left(riga,4) */
              gMsgImp = "TBRAPP - Inserimento codice "+CPLib.Left(riga,4);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code10 := '' */
              _code10 = "";
              // * --- Read from tbrapp
              m_cServer = m_Ctx.GetServer("tbrapp");
              m_cPhName = m_Ctx.GetPhName("tbrapp");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,11,2));
              if (m_Ctx.IsSharedTemp("tbrapp")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code10 = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbrapp into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code10 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code10)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code10)),0)) {
                // * --- Insert into tbrapp from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrapp");
                m_cPhName = m_Ctx.GetPhName("tbrapp");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrapp",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000114")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000114(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,11,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,13,50),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,63,254),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,317,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,250))),0)?"Vale Zero":CPLib.Substr(riga,318,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,568,250))),0)?"Vale Zero":CPLib.Substr(riga,568,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,818,250))),0)?"Vale Zero":CPLib.Substr(riga,818,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1068,250))),0)?"Vale Zero":CPLib.Substr(riga,1068,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1318,250))),0)?"Vale Zero":CPLib.Substr(riga,1318,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1568,250))),0)?"Vale Zero":CPLib.Substr(riga,1568,250)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbrapp",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbrapp from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrapp");
                m_cPhName = m_Ctx.GetPhName("tbrapp");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrapp",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000115")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,13,50),"C",150,0,m_cServer)+", ";
                m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(CPLib.Substr(riga,63,254),"C",254,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP1 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,250))),0)?"Vale Zero":CPLib.Substr(riga,318,250)),"C",250,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP2 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,568,250))),0)?"Vale Zero":CPLib.Substr(riga,568,250)),"C",250,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP3 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,818,250))),0)?"Vale Zero":CPLib.Substr(riga,818,250)),"C",250,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP4 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1068,250))),0)?"Vale Zero":CPLib.Substr(riga,1068,250)),"C",250,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP5 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1318,250))),0)?"Vale Zero":CPLib.Substr(riga,1318,250)),"C",250,0,m_cServer)+", ";
                m_cSql = m_cSql+"IMP6 = "+CPLib.ToSQL((CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,1568,250))),0)?"Vale Zero":CPLib.Substr(riga,1568,250)),"C",250,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbrapp",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,2),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,11,2))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbrapp.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbrapp.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbtipnat='S' */
        if (CPLib.eqr(w_tbtipnat,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipnat.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipnat.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipnat.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbtipnat.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPNAT - Inserimento codice '+ Left(riga,1) */
              gMsgImp = "TBTIPNAT - Inserimento codice "+CPLib.Left(riga,1);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code1 := '' */
              _code1 = "";
              // * --- Read from tbtipnat
              m_cServer = m_Ctx.GetServer("tbtipnat");
              m_cPhName = m_Ctx.GetPhName("tbtipnat");
              m_cSql = "";
              m_cSql = m_cSql+"TIPONAT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(riga,1));
              if (m_Ctx.IsSharedTemp("tbtipnat")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPONAT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code1 = Read_Cursor.GetString("TIPONAT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipnat into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code1 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code1)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code1)),0)) {
                // * --- Insert into tbtipnat from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipnat");
                m_cPhName = m_Ctx.GetPhName("tbtipnat");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipnat",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000123")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000123(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,110),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipnat",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipnat from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipnat");
                m_cPhName = m_Ctx.GetPhName("tbtipnat");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipnat",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000124")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,2,110),"C",110,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipnat",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPONAT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,1))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipnat.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipnat.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tberrorisid='S' */
        if (CPLib.eqr(w_tberrorisid,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrorisid.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrorisid.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tberrorisid.txt') */
          fhand = FileLibMit.OpenRead("newtab/tberrorisid.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBERRORISID - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBERRORISID - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tberrorisid
              m_cServer = m_Ctx.GetServer("tberrorisid");
              m_cPhName = m_Ctx.GetPhName("tberrorisid");
              m_cSql = "";
              m_cSql = m_cSql+"SIDCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tberrorisid")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIDCODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("SIDCODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tberrorisid into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tberrorisid from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrorisid");
                m_cPhName = m_Ctx.GetPhName("tberrorisid");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrorisid",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000132")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000132(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,15),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,19,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tberrorisid",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tberrorisid from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrorisid");
                m_cPhName = m_Ctx.GetPhName("tberrorisid");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrorisid",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000133")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"SIDTIPOELAB = "+CPLib.ToSQL(CPLib.Substr(riga,4,15),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"SIDDESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,19,100),"C",100,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tberrorisid",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SIDCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrorisid.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrorisid.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tberrsiddgn='S' */
        if (CPLib.eqr(w_tberrsiddgn,"S")) {
          // * --- Delete from tberrsiddgn
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tberrsiddgn");
          m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrsiddgn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000138")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrsiddgn.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrsiddgn.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tberrsiddgn.txt') */
          fhand = FileLibMit.OpenRead("newtab/tberrsiddgn.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBERRSIDDGN - Inserimento codice '+ Left(riga,1)+Substr(riga,17,3) */
              gMsgImp = "TBERRSIDDGN - Inserimento codice "+CPLib.Left(riga,1)+CPLib.Substr(riga,17,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tberrsiddgn
              m_cServer = m_Ctx.GetServer("tberrsiddgn");
              m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
              m_cSql = "";
              m_cSql = m_cSql+"DGNTIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(riga,1));
              m_cSql = m_cSql+" and DGNCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,17,3));
              if (m_Ctx.IsSharedTemp("tberrsiddgn")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DGNCODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("DGNCODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tberrsiddgn into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tberrsiddgn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrsiddgn");
                m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrsiddgn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000142")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000142(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,15),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,20,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tberrsiddgn",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tberrsiddgn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrsiddgn");
                m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrsiddgn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000143")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DGNTIPOERR = "+CPLib.ToSQL(CPLib.Substr(riga,2,15),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DGNDESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,20,100),"C",100,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tberrsiddgn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"DGNTIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,1))+"";
                m_cSql = m_cSql+" and DGNCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,3),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrsiddgn.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrsiddgn.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbricevutesid='S' */
        if (CPLib.eqr(w_tbricevutesid,"S")) {
          // * --- Delete from tbricevutesid
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbricevutesid");
          m_cPhName = m_Ctx.GetPhName("tbricevutesid");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbricevutesid",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000148")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbricevutesid.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbricevutesid.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbricevutesid.txt') */
          fhand = FileLibMit.OpenRead("newtab/tbricevutesid.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBRICEVUTE - Inserimento codice '+ Substr(riga,2,3) */
              gMsgImp = "TBRICEVUTE - Inserimento codice "+CPLib.Substr(riga,2,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tbricevutesid
              m_cServer = m_Ctx.GetServer("tbricevutesid");
              m_cPhName = m_Ctx.GetPhName("tbricevutesid");
              m_cSql = "";
              m_cSql = m_cSql+"ESICODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,2,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,2,3));
              if (m_Ctx.IsSharedTemp("tbricevutesid")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ESICODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("ESICODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbricevutesid into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbricevutesid from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbricevutesid");
                m_cPhName = m_Ctx.GetPhName("tbricevutesid");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbricevutesid",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000152")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000152(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,5,128),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbricevutesid",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbricevutesid from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbricevutesid");
                m_cPhName = m_Ctx.GetPhName("tbricevutesid");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbricevutesid",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000153")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"ESIDESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,5,128),"C",128,0,m_cServer)+", ";
                m_cSql = m_cSql+"ESITIPO = "+CPLib.ToSQL(CPLib.Left(riga,1),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbricevutesid",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"ESICODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,2,3),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,2,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbricevutesid.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbricevutesid.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tberrdge='S' */
        if (CPLib.eqr(w_tberrdge,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrdge.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrdge.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tberrdge.txt') */
          fhand = FileLibMit.OpenRead("newtab/tberrdge.txt");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBERRDGE - Inserimento codice '+ Substr(riga,1,3) */
              gMsgImp = "TBERRDGE - Inserimento codice "+CPLib.Substr(riga,1,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tberrdge
              m_cServer = m_Ctx.GetServer("tberrdge");
              m_cPhName = m_Ctx.GetPhName("tberrdge");
              m_cSql = "";
              m_cSql = m_cSql+"DGECODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3));
              if (m_Ctx.IsSharedTemp("tberrdge")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DGECODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("DGECODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tberrdge into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tberrdge from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrdge");
                m_cPhName = m_Ctx.GetPhName("tberrdge");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrdge",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000161")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000161(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,118),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,122,52),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,174,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tberrdge",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tberrdge from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tberrdge");
                m_cPhName = m_Ctx.GetPhName("tberrdge");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tberrdge",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000162")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DGEDESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,118),"C",128,0,m_cServer)+", ";
                m_cSql = m_cSql+"DGEAZIONE = "+CPLib.ToSQL(CPLib.Substr(riga,122,52),"C",100,0,m_cServer)+", ";
                m_cSql = m_cSql+"DGECONSEG = "+CPLib.ToSQL(CPLib.Substr(riga,174,100),"C",128,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tberrdge",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"DGECODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tberrdge.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tberrdge.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_tbstatna='S' */
        if (CPLib.eqr(w_tbstatna,"S")) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000168status;
          nTry00000168status = m_Sql.GetTransactionStatus();
          String cTry00000168msg;
          cTry00000168msg = m_Sql.TransactionErrorMessage();
          try {
            /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstatna.txt' + NL */
            gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstatna.txt"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* fhand := FileLibMit.OpenRead('newtab/tbstatna.txt') */
            fhand = FileLibMit.OpenRead("newtab/tbstatna.txt");
            /* While not(FileLibMit.Eof(fhand)) */
            while ( ! (FileLibMit.Eof(fhand))) {
              /* riga := FileLibMit.ReadLine(fhand) */
              riga = FileLibMit.ReadLine(fhand);
              /* If Len(LRTrim(riga)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
                /* gMsgImp := 'TBSTATNA - Inserimento codice '+ Left(riga,4) */
                gMsgImp = "TBSTATNA - Inserimento codice "+CPLib.Left(riga,4);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* _code10 := '' */
                _code10 = "";
                // * --- Read from tbstatna
                m_cServer = m_Ctx.GetServer("tbstatna");
                m_cPhName = m_Ctx.GetPhName("tbstatna");
                m_cSql = "";
                m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,88,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,88,10));
                if (m_Ctx.IsSharedTemp("tbstatna")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _code10 = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstatna into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _code10 = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Len(LRTrim(_code10)) = 0 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code10)),0)) {
                  // * --- Insert into tbstatna from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tbstatna");
                  m_cPhName = m_Ctx.GetPhName("tbstatna");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstatna",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000172")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000172(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,4),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,5,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,8,2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,10,8)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,18,8)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,4),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,30,8)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,38,50),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,88,10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,98,1),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,99,3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstatna",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } else { // Else
                  // * --- Write into tbstatna from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tbstatna");
                  m_cPhName = m_Ctx.GetPhName("tbstatna");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstatna",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000173")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,38,50),"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(CPLib.Left(riga,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ISO = "+CPLib.ToSQL(CPLib.Substr(riga,5,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ISO2 = "+CPLib.ToSQL(CPLib.Substr(riga,8,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"INIZIO = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,10,8)),"D",8,0)+", ";
                  m_cSql = m_cSql+"FINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,18,8)),"D",8,0)+", ";
                  m_cSql = m_cSql+"SIGLANEW = "+CPLib.ToSQL(CPLib.Substr(riga,26,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"VARIATO = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,30,8)),"D",8,0)+", ";
                  m_cSql = m_cSql+"IDTBLS = "+CPLib.ToSQL(CPLib.Substr(riga,98,1),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODSTA = "+CPLib.ToSQL(CPLib.Substr(riga,99,3),"C",3,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbstatna",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,88,10),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,88,10))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
              } // End If
            } // End While
            /* FileLibMit.Close(fhand) */
            FileLibMit.Close(fhand);
            /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbstatna.txt' + NL */
            gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbstatna.txt"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000168status,0)) {
              m_Sql.SetTransactionStatus(nTry00000168status,cTry00000168msg);
            }
          }
        } // End If
        /* Exec "Estensione" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000003Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000003Fstatus,cTry0000003Fmsg);
        }
      }
      /* gMsgImp := 'ELABORAZIONE TERMINATA' */
      gMsgImp = "ELABORAZIONE TERMINATA";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcauana!=null)
          Cursor_tbcauana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cpazi=null;
    try {
      /* If w_tbcittna='S' */
      if (CPLib.eqr(w_tbcittna,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000017Fstatus;
        nTry0000017Fstatus = m_Sql.GetTransactionStatus();
        String cTry0000017Fmsg;
        cTry0000017Fmsg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcittna.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcittna.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbcittna.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbcittna.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBCITTNA - Inserimento Città '+ Substr(riga,2,40) */
              gMsgImp = "TBCITTNA - Inserimento Città "+CPLib.Substr(riga,2,40);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code40 := '' */
              _code40 = "";
              // * --- Read from tbcittna
              m_cServer = m_Ctx.GetServer("tbcittna");
              m_cPhName = m_Ctx.GetPhName("tbcittna");
              m_cSql = "";
              m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,2,40)),"C",40,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Substr(riga,2,40)));
              if (m_Ctx.IsSharedTemp("tbcittna")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code40 = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcittna into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code40 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_code40)) */
              if (CPLib.Empty(CPLib.LRTrim(_code40))) {
                // * --- Insert into tbcittna from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcittna");
                m_cPhName = m_Ctx.GetPhName("tbcittna");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcittna",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000189")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000189(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,2,40)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,42,5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,53,60)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,113,40)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,153,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,157,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,163,4),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,167,5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,172,5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,177,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,185,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,193,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,194,8),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcittna",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbcittna from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbcittna");
                m_cPhName = m_Ctx.GetPhName("tbcittna");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcittna",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000018A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(CPLib.Substr(riga,42,5),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDISTAT = "+CPLib.ToSQL(CPLib.Substr(riga,47,6),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"CITTA = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,53,60)),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"CITTAX = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,113,40)),"C",40,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDREGIO = "+CPLib.ToSQL(CPLib.Substr(riga,153,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(CPLib.Substr(riga,155,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.Substr(riga,157,6),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(CPLib.Substr(riga,163,4),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,167,5),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(CPLib.Substr(riga,172,5),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,177,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"DATAFIN = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,185,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"ATTCES = "+CPLib.ToSQL(CPLib.Substr(riga,193,1),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODID = "+CPLib.ToSQL(CPLib.Substr(riga,194,8),"C",8,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcittna",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_code40),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(_code40))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcittna.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcittna.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000017Fstatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000017Fstatus,cTry0000017Fmsg);
          }
        }
      } // End If
      /* If w_inter2bo='S' */
      if (CPLib.eqr(w_inter2bo,"S")) {
        /* _oldazi := Utilities.GetCompany() */
        _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file abicab.txt - Azienda: '+cpazi->CODAZI + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file abicab.txt - Azienda: "+Cursor_cpazi.GetString("CODAZI")+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Utilities.SetCompany(cpazi->codazi) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(Cursor_cpazi.GetString("codazi"));
          /* fhand := FileLibMit.OpenRead('newtab/abicab.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/abicab.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* If Left(riga,1)='1' */
              if (CPLib.eqr(CPLib.Left(riga,1),"1")) {
                /* _dbaicab := Substr(riga,14,70) */
                _dbaicab = CPLib.Substr(riga,14,70);
              } // End If
              /* If Left(riga,1)='2' */
              if (CPLib.eqr(CPLib.Left(riga,1),"2")) {
                /* gMsgImp := 'ABICAB - Inserimento codice '+ Substr(riga,3,5)+"-"+Substr(riga,8,5) */
                gMsgImp = "ABICAB - Inserimento codice "+CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* _code11 := '' */
                _code11 = "";
                // * --- Read from inter2bo
                m_cServer = m_Ctx.GetServer("inter2bo");
                m_cPhName = m_Ctx.GetPhName("inter2bo");
                m_cSql = "";
                m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5),"C",11,0,m_cServer),m_cServer,CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5));
                if (m_Ctx.IsSharedTemp("inter2bo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _code11 = Read_Cursor.GetString("CODINTER");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on inter2bo into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _code11 = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Len(LRTrim(_code11)) = 0 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code11)),0)) {
                  // * --- Insert into inter2bo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("inter2bo");
                  m_cPhName = m_Ctx.GetPhName("inter2bo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"inter2bo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001A0(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dbaicab,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,6),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,35),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,3,5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,141,30),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,186,2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,181,5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("086","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("02","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"inter2bo",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } else { // Else
                  // * --- Write into inter2bo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("inter2bo");
                  m_cPhName = m_Ctx.GetPhName("inter2bo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"inter2bo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001A1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_dbaicab,"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Substr(riga,14,6),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,21,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,3,5),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,141,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,186,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,181,5),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL("086","C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQLNull("02","C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"inter2bo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,3,5)+"-"+CPLib.Substr(riga,8,5))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file abicab.txt - Azienda: '+cpazi->CODAZI + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file abicab.txt - Azienda: "+Cursor_cpazi.GetString("CODAZI")+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* Utilities.SetCompany(_oldazi) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
      } // End If
      /* If w_tbesielb='S' */
      if (CPLib.eqr(w_tbesielb,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry000001A8status;
        nTry000001A8status = m_Sql.GetTransactionStatus();
        String cTry000001A8msg;
        cTry000001A8msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbesielb.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbesielb.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbesielb.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbesielb.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBESIELB - Inserimento codice '+ Substr(riga,1,3) */
              gMsgImp = "TBESIELB - Inserimento codice "+CPLib.Substr(riga,1,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbesielb
              m_cServer = m_Ctx.GetServer("tbesielb");
              m_cPhName = m_Ctx.GetPhName("tbesielb");
              m_cSql = "";
              m_cSql = m_cSql+"EECODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3));
              if (m_Ctx.IsSharedTemp("tbesielb")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("EECODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("EECODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbesielb into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbesielb from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbesielb");
                m_cPhName = m_Ctx.GetPhName("tbesielb");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbesielb",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001B2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,128)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,132,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbesielb",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbesielb from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbesielb");
                m_cPhName = m_Ctx.GetPhName("tbesielb");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbesielb",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001B3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"EEDESCRI = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,128)),"C",128,0,m_cServer)+", ";
                m_cSql = m_cSql+"EELETINI = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,132,1)),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbesielb",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"EECODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbesielb.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbesielb.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001A8status,0)) {
            m_Sql.SetTransactionStatus(nTry000001A8status,cTry000001A8msg);
          }
        }
      } // End If
      /* If w_convgio='S' */
      if (CPLib.eqr(w_convgio,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry000001BBstatus;
        nTry000001BBstatus = m_Sql.GetTransactionStatus();
        String cTry000001BBmsg;
        cTry000001BBmsg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Delete from cgo_tbconvgio
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_tbconvgio");
          m_cPhName = m_Ctx.GetPhName("cgo_tbconvgio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbconvgio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001BC")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file convgioco.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file convgioco.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/convgioco.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/convgioco.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'CONVGIOCO - Inserimento codice '+ Substr(riga,1,3) */
              gMsgImp = "CONVGIOCO - Inserimento codice "+CPLib.Substr(riga,1,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _id := 0 */
              _id = CPLib.Round(0,0);
              // * --- Read from cgo_tbconvgio
              m_cServer = m_Ctx.GetServer("cgo_tbconvgio");
              m_cPhName = m_Ctx.GetPhName("cgo_tbconvgio");
              m_cSql = "";
              m_cSql = m_cSql+"CODGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,1,3))),"N",3,0,m_cServer),m_cServer,CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,1,3))));
              if (m_Ctx.IsSharedTemp("cgo_tbconvgio")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODGIO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _id = CPLib.Round(Read_Cursor.GetDouble("CODGIO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on cgo_tbconvgio into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _id = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _id=0 */
              if (CPLib.eqr(_id,0)) {
                // * --- Insert into cgo_tbconvgio from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_tbconvgio");
                m_cPhName = m_Ctx.GetPhName("cgo_tbconvgio");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbconvgio",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001C6(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,3)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbconvgio",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into cgo_tbconvgio from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_tbconvgio");
                m_cPhName = m_Ctx.GetPhName("cgo_tbconvgio");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbconvgio",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TIPGIO = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,3)),"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_tbconvgio",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODGIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))),"?",0,0,m_cServer),m_cServer,CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file convgioco.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file convgioco.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001BBstatus,0)) {
            m_Sql.SetTransactionStatus(nTry000001BBstatus,cTry000001BBmsg);
          }
        }
      } // End If
      /* If w_staticrs='S' */
      if (CPLib.eqr(w_staticrs,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry000001CFstatus;
        nTry000001CFstatus = m_Sql.GetTransactionStatus();
        String cTry000001CFmsg;
        cTry000001CFmsg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Delete from tbstatiocse
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbstatiocse");
          m_cPhName = m_Ctx.GetPhName("tbstatiocse");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstatiocse",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001D0")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file stati_ocse.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file stati_ocse.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/stati_ocse.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/stati_ocse.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBSTATIOCSE - Inserimento codice '+ Substr(riga,1,3) */
              gMsgImp = "TBSTATIOCSE - Inserimento codice "+CPLib.Substr(riga,1,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _id := 0 */
              _id = CPLib.Round(0,0);
              // * --- Read from tbstatiocse
              m_cServer = m_Ctx.GetServer("tbstatiocse");
              m_cPhName = m_Ctx.GetPhName("tbstatiocse");
              m_cSql = "";
              m_cSql = m_cSql+"NUMERO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,1,3))),"N",3,0,m_cServer),m_cServer,CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,1,3))));
              if (m_Ctx.IsSharedTemp("tbstatiocse")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _id = CPLib.Round(Read_Cursor.GetDouble("NUMERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstatiocse into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _id = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _id=0 */
              if (CPLib.eqr(_id,0)) {
                // * --- Insert into tbstatiocse from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbstatiocse");
                m_cPhName = m_Ctx.GetPhName("tbstatiocse");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstatiocse",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001DA(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,40)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,44,4))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,48,3)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstatiocse",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbstatiocse from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbstatiocse");
                m_cPhName = m_Ctx.GetPhName("tbstatiocse");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstatiocse",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001DB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,4,40)),"C",40,0,m_cServer)+", ";
                m_cSql = m_cSql+"ANNO = "+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,44,4))),"N",4,0)+", ";
                m_cSql = m_cSql+"STATOUIF = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,48,3)),"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbstatiocse",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"NUMERO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))),"?",0,0,m_cServer),m_cServer,CPLib.Val(CPLib.LRTrim(CPLib.Left(riga,3))))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file stati_ocse.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file stati_ocse.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001CFstatus,0)) {
            m_Sql.SetTransactionStatus(nTry000001CFstatus,cTry000001CFmsg);
          }
        }
      } // End If
      /* If w_tbcandistr='S' */
      if (CPLib.eqr(w_tbcandistr,"S")) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcandistr.txt' + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcandistr.txt"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* fhand := FileLibMit.OpenRead('newtab/tbcandistr.txt','UTF-8') */
        fhand = FileLibMit.OpenRead("newtab/tbcandistr.txt","UTF-8");
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* gMsgImp := 'TBCANDISTR - Inserimento codice '+ Substr(riga,1,3) */
            gMsgImp = "TBCANDISTR - Inserimento codice "+CPLib.Substr(riga,1,3);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _code3 := '' */
            _code3 = "";
            // * --- Read from tbcandistr
            m_cServer = m_Ctx.GetServer("tbcandistr");
            m_cPhName = m_Ctx.GetPhName("tbcandistr");
            m_cSql = "";
            m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3));
            if (m_Ctx.IsSharedTemp("tbcandistr")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _code3 = Read_Cursor.GetString("CODICE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcandistr into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _code3 = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Len(LRTrim(_code3)) = 0 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
              // * --- Insert into tbcandistr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbcandistr");
              m_cPhName = m_Ctx.GetPhName("tbcandistr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcandistr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001EB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001EB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,50),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcandistr",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into tbcandistr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbcandistr");
              m_cPhName = m_Ctx.GetPhName("tbcandistr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcandistr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001EC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,50),"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcandistr",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcandistr.txt' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcandistr.txt"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If w_tbluonas='S' */
      if (CPLib.eqr(w_tbluonas,"S")) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file comuni_ccat.res' + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file comuni_ccat.res"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* fhand := FileLibMit.OpenRead('newtab/comuni_ccat.res','UTF-8') */
        fhand = FileLibMit.OpenRead("newtab/comuni_ccat.res","UTF-8");
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* gMsgImp := 'TBLUONAS - Inserimento codice '+ Substr(riga,At("*",riga)+1,4) */
            gMsgImp = "TBLUONAS - Inserimento codice "+CPLib.Substr(riga,CPLib.At("*",riga)+1,4);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _code4 := '' */
            _code4 = "";
            // * --- Read from tbluonas
            m_cServer = m_Ctx.GetServer("tbluonas");
            m_cPhName = m_Ctx.GetPhName("tbluonas");
            m_cSql = "";
            m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,CPLib.At("*",riga)+1,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,CPLib.At("*",riga)+1,4));
            if (m_Ctx.IsSharedTemp("tbluonas")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _code4 = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbluonas into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _code4 = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Len(LRTrim(_code4)) = 0 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code4)),0)) {
              // * --- Insert into tbluonas from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbluonas");
              m_cPhName = m_Ctx.GetPhName("tbluonas");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbluonas",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001FA(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,CPLib.At("*",riga)+1,4),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,CPLib.At("*",riga)-1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.LRTrim(riga),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbluonas",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into tbluonas from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbluonas");
              m_cPhName = m_Ctx.GetPhName("tbluonas");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbluonas",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000001FB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Left(riga,CPLib.At("*",riga)-1),"C",60,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Right(CPLib.LRTrim(riga),2),"C",2,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbluonas",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SIGLA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,CPLib.At("*",riga)+1,4),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,CPLib.At("*",riga)+1,4))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file comuni_ccat.res' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file comuni_ccat.res"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If w_tbprovsv='S' */
      if (CPLib.eqr(w_tbprovsv,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000201status;
        nTry00000201status = m_Sql.GetTransactionStatus();
        String cTry00000201msg;
        cTry00000201msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprovsv.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprovsv.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Delete from tbprovsv
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbprovsv");
          m_cPhName = m_Ctx.GetPhName("tbprovsv");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprovsv",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000203")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* fhand := FileLibMit.OpenRead('newtab/tbprovsv.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbprovsv.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBPROVSV - Inserimento codice '+ Substr(riga,1,2) */
              gMsgImp = "TBPROVSV - Inserimento codice "+CPLib.Substr(riga,1,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbprovsv
              m_cServer = m_Ctx.GetServer("tbprovsv");
              m_cPhName = m_Ctx.GetPhName("tbprovsv");
              m_cSql = "";
              m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,1,2));
              m_cSql = m_cSql+" and SIGLASV="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,33,5)),"C",5,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Substr(riga,33,5)));
              if (m_Ctx.IsSharedTemp("tbprovsv")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbprovsv into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code)),0)) {
                // * --- Insert into tbprovsv from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbprovsv");
                m_cPhName = m_Ctx.GetPhName("tbprovsv");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprovsv",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000020C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000020C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,3,30)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,33,5)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprovsv",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbprovsv from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbprovsv");
                m_cPhName = m_Ctx.GetPhName("tbprovsv");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprovsv",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000020D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,3,30)),"C",30,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprovsv",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SIGLA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,2))+"";
                m_cSql = m_cSql+" and SIGLASV = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,33,5)),"?",0,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Substr(riga,33,5)))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprovsv.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprovsv.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000201status,0)) {
            m_Sql.SetTransactionStatus(nTry00000201status,cTry00000201msg);
          }
        }
      } // End If
      /* If w_rapogg='S' */
      if (CPLib.eqr(w_rapogg,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000215status;
        nTry00000215status = m_Sql.GetTransactionStatus();
        String cTry00000215msg;
        cTry00000215msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbrappogg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbrappogg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbrappogg.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbrappogg.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBRAPPOGG - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBRAPPOGG - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbrappogg
              m_cServer = m_Ctx.GetServer("tbrappogg");
              m_cPhName = m_Ctx.GetPhName("tbrappogg");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbrappogg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbrappogg into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbrappogg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrappogg");
                m_cPhName = m_Ctx.GetPhName("tbrappogg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrappogg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000021F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000021F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbrappogg",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbrappogg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrappogg");
                m_cPhName = m_Ctx.GetPhName("tbrappogg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrappogg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000220")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,100),"C",100,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbrappogg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del filetbrappogg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del filetbrappogg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000215status,0)) {
            m_Sql.SetTransactionStatus(nTry00000215status,cTry00000215msg);
          }
        }
      } // End If
      /* If w_tbprvreg='S' */
      if (CPLib.eqr(w_tbprvreg,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000228status;
        nTry00000228status = m_Sql.GetTransactionStatus();
        String cTry00000228msg;
        cTry00000228msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprvreg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprvreg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbprvreg.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbprvreg.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBPRVREG - Inserimento codice '+ Substr(riga,1,2) */
              gMsgImp = "TBPRVREG - Inserimento codice "+CPLib.Substr(riga,1,2);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code := '' */
              _code = "";
              // * --- Read from tbprvreg
              m_cServer = m_Ctx.GetServer("tbprvreg");
              m_cPhName = m_Ctx.GetPhName("tbprvreg");
              m_cSql = "";
              m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,1,2));
              if (m_Ctx.IsSharedTemp("tbprvreg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbprvreg into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code)),0)) {
                // * --- Insert into tbprvreg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbprvreg");
                m_cPhName = m_Ctx.GetPhName("tbprvreg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprvreg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000232")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000232(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,3,21)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,24,21)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprvreg",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbprvreg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbprvreg");
                m_cPhName = m_Ctx.GetPhName("tbprvreg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprvreg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000233")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,3,21)),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"REGIONE = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,24,21)),"C",30,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprvreg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SIGLA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,2),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,2))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprvreg.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprvreg.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000228status,0)) {
            m_Sql.SetTransactionStatus(nTry00000228status,cTry00000228msg);
          }
        }
      } // End If
      /* If w_tbnatura='S' */
      if (CPLib.eqr(w_tbnatura,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000023Bstatus;
        nTry0000023Bstatus = m_Sql.GetTransactionStatus();
        String cTry0000023Bmsg;
        cTry0000023Bmsg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbnatura.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbnatura.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbnatura.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbnatura.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBNATURA - Inserimento codice '+ Left(riga,5) */
              gMsgImp = "TBNATURA - Inserimento codice "+CPLib.Left(riga,5);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _codenum := 0 */
              _codenum = CPLib.Round(0,0);
              // * --- Read from tbnatura
              m_cServer = m_Ctx.GetServer("tbnatura");
              m_cPhName = m_Ctx.GetPhName("tbnatura");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"N",5,0,m_cServer),m_cServer,CPLib.Val(CPLib.Left(riga,5)));
              if (m_Ctx.IsSharedTemp("tbnatura")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codenum = CPLib.Round(Read_Cursor.GetDouble("CODICE"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbnatura into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codenum = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _codenum = 0 */
              if (CPLib.eqr(_codenum,0)) {
                // * --- Insert into tbnatura from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbnatura");
                m_cPhName = m_Ctx.GetPhName("tbnatura");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbnatura",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000245")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000245(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbnatura",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbnatura from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbnatura");
                m_cPhName = m_Ctx.GetPhName("tbnatura");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbnatura",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000246")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,100),"C",100,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbnatura",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"?",0,0,m_cServer),m_cServer,CPLib.Val(CPLib.Left(riga,5)))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbnatura.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbnatura.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000023Bstatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000023Bstatus,cTry0000023Bmsg);
          }
        }
      } // End If
      /* If w_tbscopo='S' */
      if (CPLib.eqr(w_tbscopo,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000024Estatus;
        nTry0000024Estatus = m_Sql.GetTransactionStatus();
        String cTry0000024Emsg;
        cTry0000024Emsg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbscopo.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbscopo.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbscopo.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbscopo.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBSCOPO - Inserimento codice '+ Left(riga,5) */
              gMsgImp = "TBSCOPO - Inserimento codice "+CPLib.Left(riga,5);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _codenum := 0 */
              _codenum = CPLib.Round(0,0);
              // * --- Read from tbscopo
              m_cServer = m_Ctx.GetServer("tbscopo");
              m_cPhName = m_Ctx.GetPhName("tbscopo");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"N",5,0,m_cServer),m_cServer,CPLib.Val(CPLib.Left(riga,5)));
              if (m_Ctx.IsSharedTemp("tbscopo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codenum = CPLib.Round(Read_Cursor.GetDouble("CODICE"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbscopo into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codenum = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _codenum = 0 */
              if (CPLib.eqr(_codenum,0)) {
                // * --- Insert into tbscopo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbscopo");
                m_cPhName = m_Ctx.GetPhName("tbscopo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbscopo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000258")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000258(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,100),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbscopo",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbscopo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbscopo");
                m_cPhName = m_Ctx.GetPhName("tbscopo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbscopo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000259")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,100),"C",100,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbscopo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Left(riga,5)),"?",0,0,m_cServer),m_cServer,CPLib.Val(CPLib.Left(riga,5)))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbscopo.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbscopo.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000024Estatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000024Estatus,cTry0000024Emsg);
          }
        }
      } // End If
      /* If w_tbrisglob='S' */
      if (CPLib.eqr(w_tbrisglob,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000261status;
        nTry00000261status = m_Sql.GetTransactionStatus();
        String cTry00000261msg;
        cTry00000261msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbrisglob.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbrisglob.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbrisglob.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbrisglob.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBRISGLOB - Inserimento codice '+ Left(riga,1) */
              gMsgImp = "TBRISGLOB - Inserimento codice "+CPLib.Left(riga,1);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code1 := "" */
              _code1 = "";
              // * --- Read from tbrisglob
              m_cServer = m_Ctx.GetServer("tbrisglob");
              m_cPhName = m_Ctx.GetPhName("tbrisglob");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,1));
              if (m_Ctx.IsSharedTemp("tbrisglob")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code1 = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbrisglob into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code1 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code1)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code1)),0)) {
                // * --- Insert into tbrisglob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrisglob");
                m_cPhName = m_Ctx.GetPhName("tbrisglob");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrisglob",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000026B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000026B(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,60),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,61,10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbrisglob",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbrisglob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbrisglob");
                m_cPhName = m_Ctx.GetPhName("tbrisglob");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbrisglob",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000026C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,2,60),"C",150,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(CPLib.Substr(riga,61,10),"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbrisglob",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,1))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbrisglob.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbrisglob.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000261status,0)) {
            m_Sql.SetTransactionStatus(nTry00000261status,cTry00000261msg);
          }
        }
      } // End If
      /* If w_tbident='S' */
      if (CPLib.eqr(w_tbident,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000274status;
        nTry00000274status = m_Sql.GetTransactionStatus();
        String cTry00000274msg;
        cTry00000274msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbident.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbident.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbident.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbident.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBIDENT - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBIDENT - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := "" */
              _code3 = "";
              // * --- Read from tbident
              m_cServer = m_Ctx.GetServer("tbident");
              m_cPhName = m_Ctx.GetPhName("tbident");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbident")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbident into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_code3)) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_code3)),0)) {
                // * --- Insert into tbident from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbident");
                m_cPhName = m_Ctx.GetPhName("tbident");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbident",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000027E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000027E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,150),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbident",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbident from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbident");
                m_cPhName = m_Ctx.GetPhName("tbident");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbident",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"0000027F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,150),"C",150,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbident",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbident.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbident.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000274status,0)) {
            m_Sql.SetTransactionStatus(nTry00000274status,cTry00000274msg);
          }
        }
      } // End If
      /* If w_tbtipope='S' */
      if (CPLib.eqr(w_tbtipope,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000287status;
        nTry00000287status = m_Sql.GetTransactionStatus();
        String cTry00000287msg;
        cTry00000287msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipope.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipope.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbtipope.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbtipope.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBTIPOPE - Inserimento codice '+ Left(riga,3) */
              gMsgImp = "TBTIPOPE - Inserimento codice "+CPLib.Left(riga,3);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _code3 := '' */
              _code3 = "";
              // * --- Read from tbtipope
              m_cServer = m_Ctx.GetServer("tbtipope");
              m_cPhName = m_Ctx.GetPhName("tbtipope");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"C",3,0,m_cServer),m_cServer,CPLib.Left(riga,3));
              if (m_Ctx.IsSharedTemp("tbtipope")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _code3 = Read_Cursor.GetString("CODICE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipope into routine arfn_imp_newtabs_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _code3 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_code3)) */
              if (CPLib.Empty(CPLib.LRTrim(_code3))) {
                // * --- Insert into tbtipope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipope");
                m_cPhName = m_Ctx.GetPhName("tbtipope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000291")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000291(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,254),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipope",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                // * --- Write into tbtipope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tbtipope");
                m_cPhName = m_Ctx.GetPhName("tbtipope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"00000292")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,254),"C",254,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipope",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,3))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipope.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipope.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000287status,0)) {
            m_Sql.SetTransactionStatus(nTry00000287status,cTry00000287msg);
          }
        }
      } // End If
      /* If w_tbprcsched='S' */
      if (CPLib.eqr(w_tbprcsched,"S")) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000029Astatus;
        nTry0000029Astatus = m_Sql.GetTransactionStatus();
        String cTry0000029Amsg;
        cTry0000029Amsg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprcsched.txt' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprcsched.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* fhand := FileLibMit.OpenRead('newtab/tbprcsched.txt','UTF-8') */
          fhand = FileLibMit.OpenRead("newtab/tbprcsched.txt","UTF-8");
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* riga := FileLibMit.ReadLine(fhand) */
            riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(riga)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
              /* gMsgImp := 'TBPRCSCHED - Inserimento proceduracodice '+ LRTrim(Left(riga,60)) */
              gMsgImp = "TBPRCSCHED - Inserimento proceduracodice "+CPLib.LRTrim(CPLib.Left(riga,60));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Merge into tbprcsched from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbprcsched");
              m_cPhName = m_Ctx.GetPhName("tbprcsched");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcsched",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.Left(riga,60),"?",0,0)+" as PSPROCESSO";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "tbprcsched.PSPROCESSO = cptmp_1xab23.PSPROCESSO";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000002A1")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" tbprcsched USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"PSDESCRIZ = "+CPLib.ToSQL(CPLib.Substr(riga,61,80),"C",80,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcsched",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_000002A1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,60),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,61,80),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcsched",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000002A1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"PSDESCRIZ = "+CPLib.ToSQL(CPLib.Substr(riga,61,80),"C",80,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcsched",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"PSPROCESSO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,60),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,60))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_imp_newtabs_old",186,"000002A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002A1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,60),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,61,80),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcsched",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbprcsched.txt' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbprcsched.txt"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000029Astatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000029Astatus,cTry0000029Amsg);
          }
        }
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_tbcitta,String p_w_tbstati,String p_w_tbsetsin,String p_w_tbcauana,String p_w_inter2bo,String p_w_tbvalute,String p_w_tbtipreg,String p_w_tbtipint,String p_w_tbesitoage,String p_w_tbrapp,String p_w_tbstgru,String p_w_tbramgru,String p_w_tbtipdoc,String p_w_tbtipleg,String p_w_tbtipnat,String p_w_tberrorisid,String p_w_tberrsiddgn,String p_w_tbricevutesid,String p_w_tbcittna,String p_w_tbstatna,String p_w_tberrdge,String p_w_tbprvreg,String p_w_tbesielb,String p_w_convgio,String p_w_staticrs,String p_w_tbcandistr,String p_w_tbluonas,String p_w_tbprovsv,String p_w_rapogg,String p_w_tbnatura,String p_w_tbscopo,String p_w_tbrisglob,String p_w_tbident,String p_w_tbtipope,String p_w_tbprcsched) {
    w_tbcitta = p_w_tbcitta;
    w_tbstati = p_w_tbstati;
    w_tbsetsin = p_w_tbsetsin;
    w_tbcauana = p_w_tbcauana;
    w_inter2bo = p_w_inter2bo;
    w_tbvalute = p_w_tbvalute;
    w_tbtipreg = p_w_tbtipreg;
    w_tbtipint = p_w_tbtipint;
    w_tbesitoage = p_w_tbesitoage;
    w_tbrapp = p_w_tbrapp;
    w_tbstgru = p_w_tbstgru;
    w_tbramgru = p_w_tbramgru;
    w_tbtipdoc = p_w_tbtipdoc;
    w_tbtipleg = p_w_tbtipleg;
    w_tbtipnat = p_w_tbtipnat;
    w_tberrorisid = p_w_tberrorisid;
    w_tberrsiddgn = p_w_tberrsiddgn;
    w_tbricevutesid = p_w_tbricevutesid;
    w_tbcittna = p_w_tbcittna;
    w_tbstatna = p_w_tbstatna;
    w_tberrdge = p_w_tberrdge;
    w_tbprvreg = p_w_tbprvreg;
    w_tbesielb = p_w_tbesielb;
    w_convgio = p_w_convgio;
    w_staticrs = p_w_staticrs;
    w_tbcandistr = p_w_tbcandistr;
    w_tbluonas = p_w_tbluonas;
    w_tbprovsv = p_w_tbprovsv;
    w_rapogg = p_w_rapogg;
    w_tbnatura = p_w_tbnatura;
    w_tbscopo = p_w_tbscopo;
    w_tbrisglob = p_w_tbrisglob;
    w_tbident = p_w_tbident;
    w_tbtipope = p_w_tbtipope;
    w_tbprcsched = p_w_tbprcsched;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    );
  }
  public String Run(String p_w_tbcitta,String p_w_tbstati,String p_w_tbsetsin,String p_w_tbcauana,String p_w_inter2bo,String p_w_tbvalute,String p_w_tbtipreg,String p_w_tbtipint,String p_w_tbesitoage,String p_w_tbrapp,String p_w_tbstgru,String p_w_tbramgru,String p_w_tbtipdoc,String p_w_tbtipleg,String p_w_tbtipnat,String p_w_tberrorisid,String p_w_tberrsiddgn,String p_w_tbricevutesid,String p_w_tbcittna,String p_w_tbstatna,String p_w_tberrdge,String p_w_tbprvreg,String p_w_tbesielb,String p_w_convgio,String p_w_staticrs,String p_w_tbcandistr,String p_w_tbluonas,String p_w_tbprovsv,String p_w_rapogg,String p_w_tbnatura,String p_w_tbscopo,String p_w_tbrisglob,String p_w_tbident,String p_w_tbtipope,String p_w_tbprcsched) {
    w_tbcitta = p_w_tbcitta;
    w_tbstati = p_w_tbstati;
    w_tbsetsin = p_w_tbsetsin;
    w_tbcauana = p_w_tbcauana;
    w_inter2bo = p_w_inter2bo;
    w_tbvalute = p_w_tbvalute;
    w_tbtipreg = p_w_tbtipreg;
    w_tbtipint = p_w_tbtipint;
    w_tbesitoage = p_w_tbesitoage;
    w_tbrapp = p_w_tbrapp;
    w_tbstgru = p_w_tbstgru;
    w_tbramgru = p_w_tbramgru;
    w_tbtipdoc = p_w_tbtipdoc;
    w_tbtipleg = p_w_tbtipleg;
    w_tbtipnat = p_w_tbtipnat;
    w_tberrorisid = p_w_tberrorisid;
    w_tberrsiddgn = p_w_tberrsiddgn;
    w_tbricevutesid = p_w_tbricevutesid;
    w_tbcittna = p_w_tbcittna;
    w_tbstatna = p_w_tbstatna;
    w_tberrdge = p_w_tberrdge;
    w_tbprvreg = p_w_tbprvreg;
    w_tbesielb = p_w_tbesielb;
    w_convgio = p_w_convgio;
    w_staticrs = p_w_staticrs;
    w_tbcandistr = p_w_tbcandistr;
    w_tbluonas = p_w_tbluonas;
    w_tbprovsv = p_w_tbprovsv;
    w_rapogg = p_w_rapogg;
    w_tbnatura = p_w_tbnatura;
    w_tbscopo = p_w_tbscopo;
    w_tbrisglob = p_w_tbrisglob;
    w_tbident = p_w_tbident;
    w_tbtipope = p_w_tbtipope;
    w_tbprcsched = p_w_tbprcsched;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
    m_Ctx = m_Ctx.DisabledDataFilteringVersion();
    try {
      try {
        try {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run start",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
          Page_1();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
        CPStdCounter.Error(fault);
        CallerExImpl l_oTraceSink;
        l_oTraceSink = new CallerExImpl(m_Caller,"");
        if (l_oTraceSink.HasWorkingVar("m_cFaultTrace")) {
          if ( ! (CPLib.IsAdministrator(m_Ctx)) && m_Ctx.HasAdministeredUsers()) {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,"MSG_ADMIN_REQUIRED");
          } else {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,CPLib.DumpException(fault));
          }
        }
      }
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_imp_newtabs_oldR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_imp_newtabs_oldR(p_Ctx, p_Caller);
  }
  public static arfn_imp_newtabs_oldR Make(CPContext p_Ctx) {
    return new arfn_imp_newtabs_oldR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tbcitta = CPLib.Space(1);
    w_tbstati = CPLib.Space(1);
    w_tbsetsin = CPLib.Space(1);
    w_tbcauana = CPLib.Space(1);
    w_inter2bo = CPLib.Space(1);
    w_tbvalute = CPLib.Space(1);
    w_tbtipreg = CPLib.Space(1);
    w_tbtipint = CPLib.Space(1);
    w_tbesitoage = CPLib.Space(1);
    w_tbrapp = CPLib.Space(1);
    w_tbstgru = CPLib.Space(1);
    w_tbramgru = CPLib.Space(1);
    w_tbtipdoc = CPLib.Space(1);
    w_tbtipleg = CPLib.Space(1);
    w_tbtipnat = CPLib.Space(1);
    w_tberrorisid = CPLib.Space(1);
    w_tberrsiddgn = CPLib.Space(1);
    w_tbricevutesid = CPLib.Space(1);
    w_tbcittna = CPLib.Space(1);
    w_tbstatna = CPLib.Space(1);
    w_tberrdge = CPLib.Space(1);
    w_tbprvreg = CPLib.Space(1);
    w_tbesielb = CPLib.Space(1);
    w_convgio = CPLib.Space(1);
    w_staticrs = CPLib.Space(1);
    w_tbcandistr = CPLib.Space(1);
    w_tbluonas = CPLib.Space(1);
    w_tbprovsv = CPLib.Space(1);
    w_rapogg = CPLib.Space(1);
    w_tbnatura = CPLib.Space(1);
    w_tbscopo = CPLib.Space(1);
    w_tbrisglob = CPLib.Space(1);
    w_tbident = CPLib.Space(1);
    w_tbtipope = CPLib.Space(1);
    w_tbprcsched = CPLib.Space(1);
    fhand = CPLib.Space(1);
    riga = "";
    _code1 = CPLib.Space(1);
    _code = CPLib.Space(2);
    _code2 = CPLib.Space(2);
    _code3 = CPLib.Space(3);
    _code4 = CPLib.Space(4);
    _code10 = CPLib.Space(10);
    _code11 = CPLib.Space(11);
    _code40 = CPLib.Space(40);
    _codenum = 0;
    _dbaicab = CPLib.Space(70);
    conta = 0;
    _lista = CPLib.Space(30);
    _oldazi = CPLib.Space(10);
    _id4 = CPLib.Space(4);
    _stringa = CPLib.Space(100);
    _id = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_imp_newtabs_old,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_imp_newtabs_old,";
  public static String[] m_cRunParameterNames={"w_tbcitta","w_tbstati","w_tbsetsin","w_tbcauana","w_inter2bo","w_tbvalute","w_tbtipreg","w_tbtipint","w_tbesitoage","w_tbrapp","w_tbstgru","w_tbramgru","w_tbtipdoc","w_tbtipleg","w_tbtipnat","w_tberrorisid","w_tberrsiddgn","w_tbricevutesid","w_tbcittna","w_tbstatna","w_tberrdge","w_tbprvreg","w_tbesielb","w_convgio","w_staticrs","w_tbcandistr","w_tbluonas","w_tbprovsv","w_rapogg","w_tbnatura","w_tbscopo","w_tbrisglob","w_tbident","w_tbtipope","w_tbprcsched"};
  protected static String GetFieldsName_0000004B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPDOC,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipdoc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPLEG,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"FILTRO,";
    p_cSql = p_cSql+"DESCRIZ2,";
    p_cSql = p_cSql+"DATAINID2,";
    p_cSql = p_cSql+"DATAFIND2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipleg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000069(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SOTGRU,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"TIPOSOT,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbstgru",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAMGRU,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbramgru",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDSETSIN,";
    p_cSql = p_cSql+"SETSINT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"DAGRU1,";
    p_cSql = p_cSql+"AGRU1,";
    p_cSql = p_cSql+"DAGRU2,";
    p_cSql = p_cSql+"AGRU2,";
    p_cSql = p_cSql+"DAGRU3,";
    p_cSql = p_cSql+"AGRU3,";
    p_cSql = p_cSql+"DAGRU4,";
    p_cSql = p_cSql+"AGRU4,";
    p_cSql = p_cSql+"DAGRU5,";
    p_cSql = p_cSql+"AGRU5,";
    p_cSql = p_cSql+"DAGRU6,";
    p_cSql = p_cSql+"AGRU6,";
    p_cSql = p_cSql+"DASOT1,";
    p_cSql = p_cSql+"ASOT1,";
    p_cSql = p_cSql+"DASOT2,";
    p_cSql = p_cSql+"ASOT2,";
    p_cSql = p_cSql+"DASOT3,";
    p_cSql = p_cSql+"ASOT3,";
    p_cSql = p_cSql+"DASOT4,";
    p_cSql = p_cSql+"ASOT4,";
    p_cSql = p_cSql+"DASOT5,";
    p_cSql = p_cSql+"ASOT5,";
    p_cSql = p_cSql+"DASOT6,";
    p_cSql = p_cSql+"ASOT6,";
    p_cSql = p_cSql+"DASOT7,";
    p_cSql = p_cSql+"ASOT7,";
    p_cSql = p_cSql+"DASOT8,";
    p_cSql = p_cSql+"ASOT8,";
    p_cSql = p_cSql+"DASOT9,";
    p_cSql = p_cSql+"ASOT9,";
    p_cSql = p_cSql+"DASOT10,";
    p_cSql = p_cSql+"ASOT10,";
    p_cSql = p_cSql+"DASOT11,";
    p_cSql = p_cSql+"ASOT11,";
    p_cSql = p_cSql+"DASOT12,";
    p_cSql = p_cSql+"ASOT12,";
    p_cSql = p_cSql+"DAATE1,";
    p_cSql = p_cSql+"AATE1,";
    p_cSql = p_cSql+"DAATE2,";
    p_cSql = p_cSql+"AATE2,";
    p_cSql = p_cSql+"DAATE3,";
    p_cSql = p_cSql+"AATE3,";
    p_cSql = p_cSql+"DAATE4,";
    p_cSql = p_cSql+"AATE4,";
    p_cSql = p_cSql+"DAATE5,";
    p_cSql = p_cSql+"AATE5,";
    p_cSql = p_cSql+"DAATE6,";
    p_cSql = p_cSql+"AATE6,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbsetsin",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000099(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOINT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipint",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DES1,";
    p_cSql = p_cSql+"DES2,";
    p_cSql = p_cSql+"TIPREG,";
    p_cSql = p_cSql+"OPERAZIO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipreg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODVAL,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"ISO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbvalute",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcausin",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"CODCAU,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CAUSINT,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"VALPERINT,";
    p_cSql = p_cSql+"FLGINTER,";
    p_cSql = p_cSql+"MITBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcauana",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODSTA,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"ISO,";
    p_cSql = p_cSql+"ISO2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGSAE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbstati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CITTA,";
    p_cSql = p_cSql+"PROV,";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"PKTBSTATI,";
    p_cSql = p_cSql+"PREF,";
    p_cSql = p_cSql+"IDISTAT,";
    p_cSql = p_cSql+"IDREGIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcitta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CITTAMIT,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"PROV,";
    p_cSql = p_cSql+"CAPMIT,";
    p_cSql = p_cSql+"PKTBSTATI,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"PREF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeCitta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000104(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbesitoae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000114(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"IMP1,";
    p_cSql = p_cSql+"IMP2,";
    p_cSql = p_cSql+"IMP3,";
    p_cSql = p_cSql+"IMP4,";
    p_cSql = p_cSql+"IMP5,";
    p_cSql = p_cSql+"IMP6,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbrapp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000123(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPONAT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipnat",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000132(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SIDCODICE,";
    p_cSql = p_cSql+"SIDTIPOELAB,";
    p_cSql = p_cSql+"SIDDESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tberrorisid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000142(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"DGNTIPO,";
    p_cSql = p_cSql+"DGNTIPOERR,";
    p_cSql = p_cSql+"DGNCODICE,";
    p_cSql = p_cSql+"DGNDESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tberrsiddgn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000152(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESITIPO,";
    p_cSql = p_cSql+"ESICODICE,";
    p_cSql = p_cSql+"ESIDESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbricevutesid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000161(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"DGECODICE,";
    p_cSql = p_cSql+"DGEDESCRI,";
    p_cSql = p_cSql+"DGEAZIONE,";
    p_cSql = p_cSql+"DGECONSEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tberrdge",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000172(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"ISO,";
    p_cSql = p_cSql+"ISO2,";
    p_cSql = p_cSql+"INIZIO,";
    p_cSql = p_cSql+"FINE,";
    p_cSql = p_cSql+"SIGLANEW,";
    p_cSql = p_cSql+"VARIATO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"CODSTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbstatna",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000189(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"IDISTAT,";
    p_cSql = p_cSql+"CITTA,";
    p_cSql = p_cSql+"CITTAX,";
    p_cSql = p_cSql+"IDREGIO,";
    p_cSql = p_cSql+"PROV,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"PREF,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFIN,";
    p_cSql = p_cSql+"ATTCES,";
    p_cSql = p_cSql+"CODID,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcittna",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"inter2bo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"EECODICE,";
    p_cSql = p_cSql+"EEDESCRI,";
    p_cSql = p_cSql+"EELETINI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbesielb",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODGIO,";
    p_cSql = p_cSql+"TIPGIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbconvgio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMERO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"STATOUIF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbstatiocse",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcandistr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbluonas",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000020C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"SIGLASV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprovsv",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbrappogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000232(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"REGIONE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprvreg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000245(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbnatura",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000258(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbscopo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbrisglob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbident",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000291(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PSPROCESSO,";
    p_cSql = p_cSql+"PSDESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcsched",true);
    return p_cSql;
  }
}
