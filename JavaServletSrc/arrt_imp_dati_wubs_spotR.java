// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_wubs_spot
import java.io.File; 
import java.util.Date; 
import jxl.*; 
// * --- Fine Area Manuale
public class arrt_imp_dati_wubs_spotR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_mtimport;
  public String m_cServer_mtimport;
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_tmp_impwu;
  public String m_cServer_tmp_impwu;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
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
  public String w_tipodest;
  public String gMsgProc;
  public double w_impzip;
  public String w_opextc;
  public String w_codmage;
  public String w_destfin;
  public String w_xMAFLGRAP;
  public String w_xMAFLGBON;
  public String fhand;
  public double nProg;
  public String nomefileimport;
  public String xConnes;
  public double conta;
  public double _nerrori;
  public String _tdest;
  public double _i;
  public String cOpeProg1;
  public String cOpeProg2;
  public double nProgImp;
  public String xData;
  public String _tiporap;
  public double nVal;
  public String cVal;
  public String cTVal;
  public String cCVal;
  public double nIntest;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public double _esito;
  public String _idbase;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _intertip;
  public String _ccab;
  public String _cprov;
  public String _ccap;
  public String _csta;
  public String _crag;
  public String _cbanca;
  public String _btipo;
  public String _bragsoc;
  public String _bcodcab;
  public String _bcitta;
  public String _bstato;
  public String _bprov;
  public String _cauana;
  public String _causin;
  public String _segno;
  public double _nocf;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_wubs_spot
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_wubs_spotR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_wubs_spot",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    if (m_cPhName_wucodes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wucodes = m_cPhName_wucodes+" "+m_Ctx.GetWritePhName("wucodes");
    }
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_mtimport = p_ContextObject.GetPhName("mtimport");
    if (m_cPhName_mtimport.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimport = m_cPhName_mtimport+" "+m_Ctx.GetWritePhName("mtimport");
    }
    m_cServer_mtimport = p_ContextObject.GetServer("mtimport");
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    m_cPhName_tmp_impwu = p_ContextObject.GetPhName("tmp_impwu");
    if (m_cPhName_tmp_impwu.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impwu = m_cPhName_tmp_impwu+" "+m_Ctx.GetWritePhName("tmp_impwu");
    }
    m_cServer_tmp_impwu = p_ContextObject.GetServer("tmp_impwu");
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      return _nerrori;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      return nVal;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      return nIntest;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      return cNumInv;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      return _nocf;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_wubs_spot";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("opextc",p_cVarName)) {
      return w_opextc;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      return w_destfin;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      return w_xMAFLGRAP;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      return w_xMAFLGBON;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("cVal",p_cVarName)) {
      return cVal;
    }
    if (CPLib.eqr("cTVal",p_cVarName)) {
      return cTVal;
    }
    if (CPLib.eqr("cCVal",p_cVarName)) {
      return cCVal;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      return xDIP;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      return xDIPx;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
    }
    if (CPLib.eqr("_ccab",p_cVarName)) {
      return _ccab;
    }
    if (CPLib.eqr("_cprov",p_cVarName)) {
      return _cprov;
    }
    if (CPLib.eqr("_ccap",p_cVarName)) {
      return _ccap;
    }
    if (CPLib.eqr("_csta",p_cVarName)) {
      return _csta;
    }
    if (CPLib.eqr("_crag",p_cVarName)) {
      return _crag;
    }
    if (CPLib.eqr("_cbanca",p_cVarName)) {
      return _cbanca;
    }
    if (CPLib.eqr("_btipo",p_cVarName)) {
      return _btipo;
    }
    if (CPLib.eqr("_bragsoc",p_cVarName)) {
      return _bragsoc;
    }
    if (CPLib.eqr("_bcodcab",p_cVarName)) {
      return _bcodcab;
    }
    if (CPLib.eqr("_bcitta",p_cVarName)) {
      return _bcitta;
    }
    if (CPLib.eqr("_bstato",p_cVarName)) {
      return _bstato;
    }
    if (CPLib.eqr("_bprov",p_cVarName)) {
      return _bprov;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      return _cauana;
    }
    if (CPLib.eqr("_causin",p_cVarName)) {
      return _causin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
    }
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
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      _nerrori = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      nVal = value;
      return;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      nIntest = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      cNumInv = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      _nocf = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("opextc",p_cVarName)) {
      w_opextc = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
      return;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      w_destfin = value;
      return;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      w_xMAFLGRAP = value;
      return;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      w_xMAFLGBON = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("cVal",p_cVarName)) {
      cVal = value;
      return;
    }
    if (CPLib.eqr("cTVal",p_cVarName)) {
      cTVal = value;
      return;
    }
    if (CPLib.eqr("cCVal",p_cVarName)) {
      cCVal = value;
      return;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
      return;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      xDIP = value;
      return;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      xDIPx = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
      return;
    }
    if (CPLib.eqr("_ccab",p_cVarName)) {
      _ccab = value;
      return;
    }
    if (CPLib.eqr("_cprov",p_cVarName)) {
      _cprov = value;
      return;
    }
    if (CPLib.eqr("_ccap",p_cVarName)) {
      _ccap = value;
      return;
    }
    if (CPLib.eqr("_csta",p_cVarName)) {
      _csta = value;
      return;
    }
    if (CPLib.eqr("_crag",p_cVarName)) {
      _crag = value;
      return;
    }
    if (CPLib.eqr("_cbanca",p_cVarName)) {
      _cbanca = value;
      return;
    }
    if (CPLib.eqr("_btipo",p_cVarName)) {
      _btipo = value;
      return;
    }
    if (CPLib.eqr("_bragsoc",p_cVarName)) {
      _bragsoc = value;
      return;
    }
    if (CPLib.eqr("_bcodcab",p_cVarName)) {
      _bcodcab = value;
      return;
    }
    if (CPLib.eqr("_bcitta",p_cVarName)) {
      _bcitta = value;
      return;
    }
    if (CPLib.eqr("_bstato",p_cVarName)) {
      _bstato = value;
      return;
    }
    if (CPLib.eqr("_bprov",p_cVarName)) {
      _bprov = value;
      return;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      _cauana = value;
      return;
    }
    if (CPLib.eqr("_causin",p_cVarName)) {
      _causin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
      return;
    }
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
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* gMsgProc Memo */
      /* w_impzip Numeric(1, 0) */
      /* w_opextc Char(1) */
      /* w_codmage Char(5) // Codice Macroagente */
      /* w_destfin Char(1) // Destinazione finale */
      /* w_xMAFLGRAP Char(1) */
      /* w_xMAFLGBON Char(1) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* nProg Numeric(10, 0) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* conta Numeric(10, 0) */
      /* _nerrori Numeric(10, 0) */
      /* _tdest Char(1) */
      /* _i Numeric(1, 0) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* xData Char(8) */
      /* _tiporap Char(1) */
      /* nVal Numeric(15, 0) */
      /* cVal Char(15) */
      /* cTVal Char(1) */
      /* cCVal Char(3) */
      /* nIntest Numeric(3, 0) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* _esito Numeric(1, 0) */
      /* _idbase Char(10) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _intertip Char(2) */
      /* _ccab Char(6) */
      /* _cprov Char(2) */
      /* _ccap Char(9) */
      /* _csta Char(3) */
      /* _crag Char(70) */
      /* _cbanca Char(11) */
      /* _btipo Char(2) */
      /* _bragsoc Char(70) */
      /* _bcodcab Char(6) */
      /* _bcitta Char(30) */
      /* _bstato Char(3) */
      /* _bprov Char(2) */
      /* _cauana Char(4) */
      /* _causin Char(2) */
      /* _segno Char(1) */
      /* _nocf Numeric(1, 0) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* righe Numeric(10, 0) */
      double righe;
      righe = 0;
      /* filenome Char(100) */
      String filenome;
      filenome = CPLib.Space(100);
      /* cell01 Char(100) */
      String cell01;
      cell01 = CPLib.Space(100);
      /* cell02 Char(100) */
      String cell02;
      cell02 = CPLib.Space(100);
      /* cell03 Char(100) */
      String cell03;
      cell03 = CPLib.Space(100);
      /* cell04 Char(100) */
      String cell04;
      cell04 = CPLib.Space(100);
      /* cell05 Char(100) */
      String cell05;
      cell05 = CPLib.Space(100);
      /* cell06 Char(100) */
      String cell06;
      cell06 = CPLib.Space(100);
      /* cell07 Char(100) */
      String cell07;
      cell07 = CPLib.Space(100);
      /* cell08 Char(100) */
      String cell08;
      cell08 = CPLib.Space(100);
      /* cell09 Char(100) */
      String cell09;
      cell09 = CPLib.Space(100);
      /* cell10 Char(100) */
      String cell10;
      cell10 = CPLib.Space(100);
      /* cell11 Char(100) */
      String cell11;
      cell11 = CPLib.Space(100);
      /* cell12 Char(100) */
      String cell12;
      cell12 = CPLib.Space(100);
      /* cell13 Char(100) */
      String cell13;
      cell13 = CPLib.Space(100);
      /* cell14 Char(100) */
      String cell14;
      cell14 = CPLib.Space(100);
      /* cell15 Char(100) */
      String cell15;
      cell15 = CPLib.Space(100);
      /* cell16 Char(100) */
      String cell16;
      cell16 = CPLib.Space(100);
      /* cell17 Char(100) */
      String cell17;
      cell17 = CPLib.Space(100);
      /* cell18 Char(100) */
      String cell18;
      cell18 = CPLib.Space(100);
      /* cell19 Char(100) */
      String cell19;
      cell19 = CPLib.Space(100);
      /* cell20 Char(100) */
      String cell20;
      cell20 = CPLib.Space(100);
      /* cell21 Char(100) */
      String cell21;
      cell21 = CPLib.Space(100);
      /* cell22 Char(100) */
      String cell22;
      cell22 = CPLib.Space(100);
      /* cell23 Char(100) */
      String cell23;
      cell23 = CPLib.Space(100);
      /* cell24 Char(100) */
      String cell24;
      cell24 = CPLib.Space(100);
      /* _rapporto Char(25) */
      String _rapporto;
      _rapporto = CPLib.Space(25);
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* Setta il nome del file */
      /* filenome := LRTrim(gPathApp)+'/appo/spots.xls' */
      filenome = CPLib.LRTrim(gPathApp)+"/appo/spots.xls";
      // Legge il worksheet
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(filenome))); 
      Sheet sheet = workbook.getSheet(0); 
      Cell[] row = null;
      righe=0;
      for (int riga = 1 ; riga < sheet.getRows() ; riga++) {
        row = sheet.getRow(riga);          
        if (row.length > 0 && CPLib.LRTrim(row[0].getContents()) != "" ) {
          cell01=row[0].getContents();
          cell02=row[1].getContents();
          cell03=row[2].getContents();
          cell04=row[3].getContents();
          cell05=row[4].getContents();
          cell06=row[5].getContents();
          cell07=row[6].getContents();
          cell08=row[7].getContents();
          cell09=row[8].getContents();
          righe++;
      /* _rapporto := '' */
      _rapporto = "";
      // * --- Read from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      m_cSql = "";
      m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell09),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(cell09));
      if (m_Ctx.IsSharedTemp("intestbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _rapporto = Read_Cursor.GetString("RAPPORTO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on intestbo into routine arrt_imp_dati_wubs_spot returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _rapporto = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If not(Empty(LRTrim(_rapporto))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(_rapporto)))) {
        // * --- Write into anarapbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs_spot",715,"0000006C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"SPLITCODE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell01),15),"C",15,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
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
      //
        }
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=Run();
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
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
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
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
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
      m_Caller.SetString("tipodest","C",1,0,w_tipodest);
      m_Caller.SetString("gMsgProc","M",10,0,gMsgProc);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetString("opextc","C",1,0,w_opextc);
      m_Caller.SetString("codmage","C",5,0,w_codmage);
      m_Caller.SetString("destfin","C",1,0,w_destfin);
      m_Caller.SetString("xMAFLGRAP","C",1,0,w_xMAFLGRAP);
      m_Caller.SetString("xMAFLGBON","C",1,0,w_xMAFLGBON);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_wubs_spotR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_wubs_spotR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    w_opextc = m_Caller.GetString("opextc","C",1,0);
    w_codmage = m_Caller.GetString("codmage","C",5,0);
    w_destfin = m_Caller.GetString("destfin","C",1,0);
    w_xMAFLGRAP = m_Caller.GetString("xMAFLGRAP","C",1,0);
    w_xMAFLGBON = m_Caller.GetString("xMAFLGBON","C",1,0);
    fhand = CPLib.Space(1);
    nProg = 0;
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    conta = 0;
    _nerrori = 0;
    _tdest = CPLib.Space(1);
    _i = 0;
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    nProgImp = 0;
    xData = CPLib.Space(8);
    _tiporap = CPLib.Space(1);
    nVal = 0;
    cVal = CPLib.Space(15);
    cTVal = CPLib.Space(1);
    cCVal = CPLib.Space(3);
    nIntest = 0;
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    _esito = 0;
    _idbase = CPLib.Space(10);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _ccab = CPLib.Space(6);
    _cprov = CPLib.Space(2);
    _ccap = CPLib.Space(9);
    _csta = CPLib.Space(3);
    _crag = CPLib.Space(70);
    _cbanca = CPLib.Space(11);
    _btipo = CPLib.Space(2);
    _bragsoc = CPLib.Space(70);
    _bcodcab = CPLib.Space(6);
    _bcitta = CPLib.Space(30);
    _bstato = CPLib.Space(3);
    _bprov = CPLib.Space(2);
    _cauana = CPLib.Space(4);
    _causin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _nocf = 0;
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
