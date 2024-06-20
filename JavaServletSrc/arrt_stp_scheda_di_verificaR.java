// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_scheda_di_verificaR implements CallerWithObjs {
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
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
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
  public String gUrlApp;
  public String gInter;
  public String gTAEG;
  public String gTEG;
  public String gPromo;
  public String gPrevPers;
  public String gCalcCG;
  public String w_CONNES;
  public String w_CONNESLEG;
  public double w_ana;
  public double w_mpa;
  public double w_neo;
  public double w_vcam;
  public String _contito;
  public String pModRep;
  public String nomefile;
  public String intesfile;
  public String fhand;
  public String verifica;
  public String c_neo;
  public String c_old;
  public String c_cod;
  public String pf_rag;
  public String pf_cnome;
  public String pf_nome;
  public String pf_fcf;
  public String pf_f;
  public String pf_fdoc;
  public String pf_doc;
  public String pf_dnas;
  public String pf_lnas;
  public String pf_ctz;
  public String pf_cf;
  public String pf_piva;
  public String pf_sexM;
  public String pf_sexF;
  public String pf_ind;
  public String pf_cap;
  public String pf_cta;
  public String pf_prv;
  public String pf_stato;
  public String pf_tel;
  public String pf_fax;
  public String pf_mail;
  public String pf_ind2;
  public String pf_cap2;
  public String pf_cta2;
  public String pf_prv2;
  public String s_rag;
  public String s_f;
  public String s_fvisu;
  public String s_fdoc;
  public String s_fcf;
  public String s_cf;
  public String s_piva;
  public String s_ind;
  public String s_cap;
  public String s_cta;
  public String s_prv;
  public String s_stato;
  public String l_rag;
  public String l_cnome;
  public String l_nome;
  public String l_fdoc;
  public String l_doc;
  public String l_fcf;
  public String l_cf;
  public String l_sexM;
  public String l_sexF;
  public String l_ind;
  public String l_cap;
  public String l_cta;
  public String l_prv;
  public String l_stato;
  public String l_dnasc;
  public String l_lnasc;
  public String l_ctz;
  public String l_tel;
  public String l_fax;
  public String l_mail;
  public String l_ind2;
  public String l_cap2;
  public String l_cta2;
  public String l_prv2;
  public String t_fsi;
  public String t_fno;
  public String t_f231;
  public String t_fcf;
  public String t_fdoc;
  public String t_doc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_scheda_di_verificaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_scheda_di_verifica",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    if (m_cPhName_titopers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titopers = m_cPhName_titopers+" "+m_Ctx.GetWritePhName("titopers");
    }
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    if (m_cPhName_titolabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titolabo = m_cPhName_titolabo+" "+m_Ctx.GetWritePhName("titolabo");
    }
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ana",p_cVarName)) {
      return w_ana;
    }
    if (CPLib.eqr("mpa",p_cVarName)) {
      return w_mpa;
    }
    if (CPLib.eqr("neo",p_cVarName)) {
      return w_neo;
    }
    if (CPLib.eqr("vcam",p_cVarName)) {
      return w_vcam;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_scheda_di_verifica";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("CONNESLEG",p_cVarName)) {
      return w_CONNESLEG;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gInter",p_cVarName)) {
      return gInter;
    }
    if (CPLib.eqr("gTAEG",p_cVarName)) {
      return gTAEG;
    }
    if (CPLib.eqr("gTEG",p_cVarName)) {
      return gTEG;
    }
    if (CPLib.eqr("gPromo",p_cVarName)) {
      return gPromo;
    }
    if (CPLib.eqr("gPrevPers",p_cVarName)) {
      return gPrevPers;
    }
    if (CPLib.eqr("gCalcCG",p_cVarName)) {
      return gCalcCG;
    }
    if (CPLib.eqr("_contito",p_cVarName)) {
      return _contito;
    }
    if (CPLib.eqr("pModRep",p_cVarName)) {
      return pModRep;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("intesfile",p_cVarName)) {
      return intesfile;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("verifica",p_cVarName)) {
      return verifica;
    }
    if (CPLib.eqr("c_neo",p_cVarName)) {
      return c_neo;
    }
    if (CPLib.eqr("c_old",p_cVarName)) {
      return c_old;
    }
    if (CPLib.eqr("c_cod",p_cVarName)) {
      return c_cod;
    }
    if (CPLib.eqr("pf_rag",p_cVarName)) {
      return pf_rag;
    }
    if (CPLib.eqr("pf_cnome",p_cVarName)) {
      return pf_cnome;
    }
    if (CPLib.eqr("pf_nome",p_cVarName)) {
      return pf_nome;
    }
    if (CPLib.eqr("pf_fcf",p_cVarName)) {
      return pf_fcf;
    }
    if (CPLib.eqr("pf_f",p_cVarName)) {
      return pf_f;
    }
    if (CPLib.eqr("pf_fdoc",p_cVarName)) {
      return pf_fdoc;
    }
    if (CPLib.eqr("pf_doc",p_cVarName)) {
      return pf_doc;
    }
    if (CPLib.eqr("pf_dnas",p_cVarName)) {
      return pf_dnas;
    }
    if (CPLib.eqr("pf_lnas",p_cVarName)) {
      return pf_lnas;
    }
    if (CPLib.eqr("pf_ctz",p_cVarName)) {
      return pf_ctz;
    }
    if (CPLib.eqr("pf_cf",p_cVarName)) {
      return pf_cf;
    }
    if (CPLib.eqr("pf_piva",p_cVarName)) {
      return pf_piva;
    }
    if (CPLib.eqr("pf_sexM",p_cVarName)) {
      return pf_sexM;
    }
    if (CPLib.eqr("pf_sexF",p_cVarName)) {
      return pf_sexF;
    }
    if (CPLib.eqr("pf_ind",p_cVarName)) {
      return pf_ind;
    }
    if (CPLib.eqr("pf_cap",p_cVarName)) {
      return pf_cap;
    }
    if (CPLib.eqr("pf_cta",p_cVarName)) {
      return pf_cta;
    }
    if (CPLib.eqr("pf_prv",p_cVarName)) {
      return pf_prv;
    }
    if (CPLib.eqr("pf_stato",p_cVarName)) {
      return pf_stato;
    }
    if (CPLib.eqr("pf_tel",p_cVarName)) {
      return pf_tel;
    }
    if (CPLib.eqr("pf_fax",p_cVarName)) {
      return pf_fax;
    }
    if (CPLib.eqr("pf_mail",p_cVarName)) {
      return pf_mail;
    }
    if (CPLib.eqr("pf_ind2",p_cVarName)) {
      return pf_ind2;
    }
    if (CPLib.eqr("pf_cap2",p_cVarName)) {
      return pf_cap2;
    }
    if (CPLib.eqr("pf_cta2",p_cVarName)) {
      return pf_cta2;
    }
    if (CPLib.eqr("pf_prv2",p_cVarName)) {
      return pf_prv2;
    }
    if (CPLib.eqr("s_rag",p_cVarName)) {
      return s_rag;
    }
    if (CPLib.eqr("s_f",p_cVarName)) {
      return s_f;
    }
    if (CPLib.eqr("s_fvisu",p_cVarName)) {
      return s_fvisu;
    }
    if (CPLib.eqr("s_fdoc",p_cVarName)) {
      return s_fdoc;
    }
    if (CPLib.eqr("s_fcf",p_cVarName)) {
      return s_fcf;
    }
    if (CPLib.eqr("s_cf",p_cVarName)) {
      return s_cf;
    }
    if (CPLib.eqr("s_piva",p_cVarName)) {
      return s_piva;
    }
    if (CPLib.eqr("s_ind",p_cVarName)) {
      return s_ind;
    }
    if (CPLib.eqr("s_cap",p_cVarName)) {
      return s_cap;
    }
    if (CPLib.eqr("s_cta",p_cVarName)) {
      return s_cta;
    }
    if (CPLib.eqr("s_prv",p_cVarName)) {
      return s_prv;
    }
    if (CPLib.eqr("s_stato",p_cVarName)) {
      return s_stato;
    }
    if (CPLib.eqr("l_rag",p_cVarName)) {
      return l_rag;
    }
    if (CPLib.eqr("l_cnome",p_cVarName)) {
      return l_cnome;
    }
    if (CPLib.eqr("l_nome",p_cVarName)) {
      return l_nome;
    }
    if (CPLib.eqr("l_fdoc",p_cVarName)) {
      return l_fdoc;
    }
    if (CPLib.eqr("l_doc",p_cVarName)) {
      return l_doc;
    }
    if (CPLib.eqr("l_fcf",p_cVarName)) {
      return l_fcf;
    }
    if (CPLib.eqr("l_cf",p_cVarName)) {
      return l_cf;
    }
    if (CPLib.eqr("l_sexM",p_cVarName)) {
      return l_sexM;
    }
    if (CPLib.eqr("l_sexF",p_cVarName)) {
      return l_sexF;
    }
    if (CPLib.eqr("l_ind",p_cVarName)) {
      return l_ind;
    }
    if (CPLib.eqr("l_cap",p_cVarName)) {
      return l_cap;
    }
    if (CPLib.eqr("l_cta",p_cVarName)) {
      return l_cta;
    }
    if (CPLib.eqr("l_prv",p_cVarName)) {
      return l_prv;
    }
    if (CPLib.eqr("l_stato",p_cVarName)) {
      return l_stato;
    }
    if (CPLib.eqr("l_dnasc",p_cVarName)) {
      return l_dnasc;
    }
    if (CPLib.eqr("l_lnasc",p_cVarName)) {
      return l_lnasc;
    }
    if (CPLib.eqr("l_ctz",p_cVarName)) {
      return l_ctz;
    }
    if (CPLib.eqr("l_tel",p_cVarName)) {
      return l_tel;
    }
    if (CPLib.eqr("l_fax",p_cVarName)) {
      return l_fax;
    }
    if (CPLib.eqr("l_mail",p_cVarName)) {
      return l_mail;
    }
    if (CPLib.eqr("l_ind2",p_cVarName)) {
      return l_ind2;
    }
    if (CPLib.eqr("l_cap2",p_cVarName)) {
      return l_cap2;
    }
    if (CPLib.eqr("l_cta2",p_cVarName)) {
      return l_cta2;
    }
    if (CPLib.eqr("l_prv2",p_cVarName)) {
      return l_prv2;
    }
    if (CPLib.eqr("t_fsi",p_cVarName)) {
      return t_fsi;
    }
    if (CPLib.eqr("t_fno",p_cVarName)) {
      return t_fno;
    }
    if (CPLib.eqr("t_f231",p_cVarName)) {
      return t_f231;
    }
    if (CPLib.eqr("t_fcf",p_cVarName)) {
      return t_fcf;
    }
    if (CPLib.eqr("t_fdoc",p_cVarName)) {
      return t_fdoc;
    }
    if (CPLib.eqr("t_doc",p_cVarName)) {
      return t_doc;
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
    if (CPLib.eqr("ana",p_cVarName)) {
      w_ana = value;
      return;
    }
    if (CPLib.eqr("mpa",p_cVarName)) {
      w_mpa = value;
      return;
    }
    if (CPLib.eqr("neo",p_cVarName)) {
      w_neo = value;
      return;
    }
    if (CPLib.eqr("vcam",p_cVarName)) {
      w_vcam = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("CONNESLEG",p_cVarName)) {
      w_CONNESLEG = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gInter",p_cVarName)) {
      gInter = value;
      return;
    }
    if (CPLib.eqr("gTAEG",p_cVarName)) {
      gTAEG = value;
      return;
    }
    if (CPLib.eqr("gTEG",p_cVarName)) {
      gTEG = value;
      return;
    }
    if (CPLib.eqr("gPromo",p_cVarName)) {
      gPromo = value;
      return;
    }
    if (CPLib.eqr("gPrevPers",p_cVarName)) {
      gPrevPers = value;
      return;
    }
    if (CPLib.eqr("gCalcCG",p_cVarName)) {
      gCalcCG = value;
      return;
    }
    if (CPLib.eqr("_contito",p_cVarName)) {
      _contito = value;
      return;
    }
    if (CPLib.eqr("pModRep",p_cVarName)) {
      pModRep = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("intesfile",p_cVarName)) {
      intesfile = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("verifica",p_cVarName)) {
      verifica = value;
      return;
    }
    if (CPLib.eqr("c_neo",p_cVarName)) {
      c_neo = value;
      return;
    }
    if (CPLib.eqr("c_old",p_cVarName)) {
      c_old = value;
      return;
    }
    if (CPLib.eqr("c_cod",p_cVarName)) {
      c_cod = value;
      return;
    }
    if (CPLib.eqr("pf_rag",p_cVarName)) {
      pf_rag = value;
      return;
    }
    if (CPLib.eqr("pf_cnome",p_cVarName)) {
      pf_cnome = value;
      return;
    }
    if (CPLib.eqr("pf_nome",p_cVarName)) {
      pf_nome = value;
      return;
    }
    if (CPLib.eqr("pf_fcf",p_cVarName)) {
      pf_fcf = value;
      return;
    }
    if (CPLib.eqr("pf_f",p_cVarName)) {
      pf_f = value;
      return;
    }
    if (CPLib.eqr("pf_fdoc",p_cVarName)) {
      pf_fdoc = value;
      return;
    }
    if (CPLib.eqr("pf_doc",p_cVarName)) {
      pf_doc = value;
      return;
    }
    if (CPLib.eqr("pf_dnas",p_cVarName)) {
      pf_dnas = value;
      return;
    }
    if (CPLib.eqr("pf_lnas",p_cVarName)) {
      pf_lnas = value;
      return;
    }
    if (CPLib.eqr("pf_ctz",p_cVarName)) {
      pf_ctz = value;
      return;
    }
    if (CPLib.eqr("pf_cf",p_cVarName)) {
      pf_cf = value;
      return;
    }
    if (CPLib.eqr("pf_piva",p_cVarName)) {
      pf_piva = value;
      return;
    }
    if (CPLib.eqr("pf_sexM",p_cVarName)) {
      pf_sexM = value;
      return;
    }
    if (CPLib.eqr("pf_sexF",p_cVarName)) {
      pf_sexF = value;
      return;
    }
    if (CPLib.eqr("pf_ind",p_cVarName)) {
      pf_ind = value;
      return;
    }
    if (CPLib.eqr("pf_cap",p_cVarName)) {
      pf_cap = value;
      return;
    }
    if (CPLib.eqr("pf_cta",p_cVarName)) {
      pf_cta = value;
      return;
    }
    if (CPLib.eqr("pf_prv",p_cVarName)) {
      pf_prv = value;
      return;
    }
    if (CPLib.eqr("pf_stato",p_cVarName)) {
      pf_stato = value;
      return;
    }
    if (CPLib.eqr("pf_tel",p_cVarName)) {
      pf_tel = value;
      return;
    }
    if (CPLib.eqr("pf_fax",p_cVarName)) {
      pf_fax = value;
      return;
    }
    if (CPLib.eqr("pf_mail",p_cVarName)) {
      pf_mail = value;
      return;
    }
    if (CPLib.eqr("pf_ind2",p_cVarName)) {
      pf_ind2 = value;
      return;
    }
    if (CPLib.eqr("pf_cap2",p_cVarName)) {
      pf_cap2 = value;
      return;
    }
    if (CPLib.eqr("pf_cta2",p_cVarName)) {
      pf_cta2 = value;
      return;
    }
    if (CPLib.eqr("pf_prv2",p_cVarName)) {
      pf_prv2 = value;
      return;
    }
    if (CPLib.eqr("s_rag",p_cVarName)) {
      s_rag = value;
      return;
    }
    if (CPLib.eqr("s_f",p_cVarName)) {
      s_f = value;
      return;
    }
    if (CPLib.eqr("s_fvisu",p_cVarName)) {
      s_fvisu = value;
      return;
    }
    if (CPLib.eqr("s_fdoc",p_cVarName)) {
      s_fdoc = value;
      return;
    }
    if (CPLib.eqr("s_fcf",p_cVarName)) {
      s_fcf = value;
      return;
    }
    if (CPLib.eqr("s_cf",p_cVarName)) {
      s_cf = value;
      return;
    }
    if (CPLib.eqr("s_piva",p_cVarName)) {
      s_piva = value;
      return;
    }
    if (CPLib.eqr("s_ind",p_cVarName)) {
      s_ind = value;
      return;
    }
    if (CPLib.eqr("s_cap",p_cVarName)) {
      s_cap = value;
      return;
    }
    if (CPLib.eqr("s_cta",p_cVarName)) {
      s_cta = value;
      return;
    }
    if (CPLib.eqr("s_prv",p_cVarName)) {
      s_prv = value;
      return;
    }
    if (CPLib.eqr("s_stato",p_cVarName)) {
      s_stato = value;
      return;
    }
    if (CPLib.eqr("l_rag",p_cVarName)) {
      l_rag = value;
      return;
    }
    if (CPLib.eqr("l_cnome",p_cVarName)) {
      l_cnome = value;
      return;
    }
    if (CPLib.eqr("l_nome",p_cVarName)) {
      l_nome = value;
      return;
    }
    if (CPLib.eqr("l_fdoc",p_cVarName)) {
      l_fdoc = value;
      return;
    }
    if (CPLib.eqr("l_doc",p_cVarName)) {
      l_doc = value;
      return;
    }
    if (CPLib.eqr("l_fcf",p_cVarName)) {
      l_fcf = value;
      return;
    }
    if (CPLib.eqr("l_cf",p_cVarName)) {
      l_cf = value;
      return;
    }
    if (CPLib.eqr("l_sexM",p_cVarName)) {
      l_sexM = value;
      return;
    }
    if (CPLib.eqr("l_sexF",p_cVarName)) {
      l_sexF = value;
      return;
    }
    if (CPLib.eqr("l_ind",p_cVarName)) {
      l_ind = value;
      return;
    }
    if (CPLib.eqr("l_cap",p_cVarName)) {
      l_cap = value;
      return;
    }
    if (CPLib.eqr("l_cta",p_cVarName)) {
      l_cta = value;
      return;
    }
    if (CPLib.eqr("l_prv",p_cVarName)) {
      l_prv = value;
      return;
    }
    if (CPLib.eqr("l_stato",p_cVarName)) {
      l_stato = value;
      return;
    }
    if (CPLib.eqr("l_dnasc",p_cVarName)) {
      l_dnasc = value;
      return;
    }
    if (CPLib.eqr("l_lnasc",p_cVarName)) {
      l_lnasc = value;
      return;
    }
    if (CPLib.eqr("l_ctz",p_cVarName)) {
      l_ctz = value;
      return;
    }
    if (CPLib.eqr("l_tel",p_cVarName)) {
      l_tel = value;
      return;
    }
    if (CPLib.eqr("l_fax",p_cVarName)) {
      l_fax = value;
      return;
    }
    if (CPLib.eqr("l_mail",p_cVarName)) {
      l_mail = value;
      return;
    }
    if (CPLib.eqr("l_ind2",p_cVarName)) {
      l_ind2 = value;
      return;
    }
    if (CPLib.eqr("l_cap2",p_cVarName)) {
      l_cap2 = value;
      return;
    }
    if (CPLib.eqr("l_cta2",p_cVarName)) {
      l_cta2 = value;
      return;
    }
    if (CPLib.eqr("l_prv2",p_cVarName)) {
      l_prv2 = value;
      return;
    }
    if (CPLib.eqr("t_fsi",p_cVarName)) {
      t_fsi = value;
      return;
    }
    if (CPLib.eqr("t_fno",p_cVarName)) {
      t_fno = value;
      return;
    }
    if (CPLib.eqr("t_f231",p_cVarName)) {
      t_f231 = value;
      return;
    }
    if (CPLib.eqr("t_fcf",p_cVarName)) {
      t_fcf = value;
      return;
    }
    if (CPLib.eqr("t_fdoc",p_cVarName)) {
      t_fdoc = value;
      return;
    }
    if (CPLib.eqr("t_doc",p_cVarName)) {
      t_doc = value;
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
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_titolabo=null;
    try {
      /* gUrlApp Char(80) // URL Applicazione */
      /* gInter Char(10) // Codice Intermediario */
      /* gTAEG Char(1) // Flag Calcolo TAEG */
      /* gTEG Char(1) // Flag Calcolo TEG */
      /* gPromo Char(10) // Promotore */
      /* gPrevPers Char(1) // Preventivi Personalizzati */
      /* gCalcCG Char(1) // Tipo Calcolo Importi Capogruppo e Direttore Commerciale */
      /* w_CONNES Char(16) */
      /* w_CONNESLEG Char(16) */
      /* w_ana Numeric(1, 0) // Solo dati Anagrafici */
      /* w_mpa Numeric(1, 0) // Scheda Vuota */
      /* w_neo Numeric(1, 0) */
      /* w_vcam Numeric(1, 0) */
      /* _contito Char(16) // Valore di codice titolare preso da titopers */
      /* pModRep Char(120) // Modello da usare (da passare alla servlet come parametro) */
      /* nomefile Char(10) */
      /* intesfile Char(10) */
      /* fhand Char(1) */
      /* verifica Char(100) */
      /* c_neo Char(1) */
      /* c_old Char(1) */
      /* c_cod Char(16) */
      /* pf_rag Char(70) */
      /* pf_cnome Char(30) */
      /* pf_nome Char(30) */
      /* pf_fcf Char(1) */
      /* pf_f Char(1) */
      /* pf_fdoc Char(1) */
      /* pf_doc Char(40) */
      /* pf_dnas Char(10) */
      /* pf_lnas Char(40) */
      /* pf_ctz Char(40) */
      /* pf_cf Char(16) */
      /* pf_piva Char(16) */
      /* pf_sexM Char(1) */
      /* pf_sexF Char(1) */
      /* pf_ind Char(50) */
      /* pf_cap Char(5) */
      /* pf_cta Char(40) */
      /* pf_prv Char(2) */
      /* pf_stato Char(40) */
      /* pf_tel Char(50) */
      /* pf_fax Char(30) */
      /* pf_mail Char(50) */
      /* pf_ind2 Char(50) */
      /* pf_cap2 Char(5) */
      /* pf_cta2 Char(40) */
      /* pf_prv2 Char(2) */
      /* s_rag Char(30) */
      /* s_f Char(1) */
      /* s_fvisu Char(1) */
      /* s_fdoc Char(1) */
      /* s_fcf Char(1) */
      /* s_cf Char(16) */
      /* s_piva Char(16) */
      /* s_ind Char(50) */
      /* s_cap Char(5) */
      /* s_cta Char(40) */
      /* s_prv Char(2) */
      /* s_stato Char(40) */
      /* l_rag Char(70) */
      /* l_cnome Char(30) */
      /* l_nome Char(30) */
      /* l_fdoc Char(1) */
      /* l_doc Char(40) */
      /* l_fcf Char(1) */
      /* l_cf Char(16) */
      /* l_sexM Char(1) */
      /* l_sexF Char(1) */
      /* l_ind Char(50) */
      /* l_cap Char(5) */
      /* l_cta Char(40) */
      /* l_prv Char(2) */
      /* l_stato Char(40) */
      /* l_dnasc Char(10) */
      /* l_lnasc Char(40) */
      /* l_ctz Char(40) */
      /* l_tel Char(50) */
      /* l_fax Char(30) */
      /* l_mail Char(50) */
      /* l_ind2 Char(50) */
      /* l_cap2 Char(5) */
      /* l_cta2 Char(40) */
      /* l_prv2 Char(2) */
      /* t_fsi Char(1) */
      /* t_fno Char(1) */
      /* t_f231 Char(1) */
      /* t_fcf Char(1) */
      /* t_fdoc Char(1) */
      /* t_doc Char(40) */
      /* pModRep := 'mit_scheda_verifica.pdf' // Modello da usare (da passare alla servlet come parametro) */
      pModRep = "mit_scheda_verifica.pdf";
      /* _contito := '' // Valore di codice titolare preso da titopers */
      _contito = "";
      /* Se mpa vale 1 si vuole una scheda vuota */
      /* If w_mpa=0 */
      if (CPLib.eqr(w_mpa,0)) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* Verifico se sesso è valorizzato per distinguere persone fisiche dalle persone giuridiche */
          /* If Empty(personbo->SESSO) */
          if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
            /* c_neo := iif(w_neo=0,'X',' ') // nuovo cliente */
            c_neo = (CPLib.eqr(w_neo,0)?"X":" ");
            /* c_old := iif(w_neo=1,'X',' ') // vecchio cliente */
            c_old = (CPLib.eqr(w_neo,1)?"X":" ");
            /* c_cod := personbo->CONNES */
            c_cod = Cursor_personbo.GetString("CONNES");
            /* s_rag := personbo->RAGSOC // ragione sociale del soggetto */
            s_rag = Cursor_personbo.GetString("RAGSOC");
            /* s_f := 'X' // flag persona giuridica */
            s_f = "X";
            /* s_fdoc := ' ' // flag di acquisita idonea attestazione circa l’effettiva esistenza del potere di rappresentanza e/o di delega alla firma */
            s_fdoc = " ";
            /* s_fcf := iif(personbo->CFESTERO=0 and not(Empty(personbo->CODFISC)),'X',' ') // flag codice fiscale fittizio società */
            s_fcf = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0) &&  ! (CPLib.Empty(Cursor_personbo.GetString("CODFISC")))?"X":" ");
            /* s_cf := iif(personbo->CFESTERO=0,personbo->CODFISC,'') // codice fiscale società */
            s_cf = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0)?Cursor_personbo.GetString("CODFISC"):"");
            /* s_piva := iif(Empty(personbo->PARTIVA),'',personbo->PARTIVA) // partita iva società */
            s_piva = (CPLib.Empty(Cursor_personbo.GetString("PARTIVA"))?"":Cursor_personbo.GetString("PARTIVA"));
            /* s_ind := personbo->DOMICILIO // indirizzo della società */
            s_ind = Cursor_personbo.GetString("DOMICILIO");
            /* s_cap := personbo->CAP // codice cap società */
            s_cap = Cursor_personbo.GetString("CAP");
            /* s_cta := personbo->DESCCIT // citta della società */
            s_cta = Cursor_personbo.GetString("DESCCIT");
            /* s_prv := personbo->PROVINCIA  // provincia della società */
            s_prv = Cursor_personbo.GetString("PROVINCIA");
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              s_stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              s_stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESLEG,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNESLEG)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* l_rag := personbo->RAGSOC // ragione sociale legale rappresentante */
              l_rag = Cursor_personbo.GetString("RAGSOC");
              /* l_cnome := personbo->COGNOME // cognome legale rappresentante */
              l_cnome = Cursor_personbo.GetString("COGNOME");
              /* l_nome := personbo->NOME // nome del legale rappresentante */
              l_nome = Cursor_personbo.GetString("NOME");
              /* Metto la X in l_fcf nel caso in cui ho la carta d'identita e il codice fiscale del soggetto */
              /* iif(not(Empty(personbo->NUMDOCUM)) and (personbo->CFESTERO=0 and not(Empty(personbo->CODFISC)) or personbo->CFESTERO=1) and w_ana=0,'X',' ') */
              /* l_fcf := iif((personbo->CFESTERO=0 and not(Empty(personbo->CODFISC)) or personbo->CFESTERO=1) and w_ana=0,'X',' ') // flag codice fiscale fittizio legale rappresentante */
              l_fcf = ((CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0) &&  ! (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) || CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) && CPLib.eqr(w_ana,0)?"X":" ");
              /* l_cf := iif(personbo->CFESTERO=0,personbo->CODFISC,'') // codice fiscale legale rappresentante */
              l_cf = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0)?Cursor_personbo.GetString("CODFISC"):"");
              /* l_fdoc := iif(Empty(personbo->TIPODOC) or w_ana=1,' ','X') */
              l_fdoc = (CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.eqr(w_ana,1)?" ":"X");
              /* l_doc := '' // documento del legale */
              l_doc = "";
              // * --- Read from tbtipdoc
              m_cServer = m_Ctx.GetServer("tbtipdoc");
              m_cPhName = m_Ctx.GetPhName("tbtipdoc");
              m_cSql = "";
              m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
              if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                l_doc = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                l_doc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* l_dnasc := iif(Empty(personbo->DATANASC),'' ,arfn_fdate(personbo->DATANASC)) */
              l_dnasc = (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))?"":arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC")));
              /* l_lnasc := personbo->NASCOMUN */
              l_lnasc = Cursor_personbo.GetString("NASCOMUN");
              /* l_sexM := iif(personbo->SESSO='1','X',' ') */
              l_sexM = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"X":" ");
              /* l_sexF := iif(personbo->SESSO='1' or Empty(personbo->SESSO),' ','X') */
              l_sexF = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1") || CPLib.Empty(Cursor_personbo.GetString("SESSO"))?" ":"X");
              /* l_ind := personbo->DOMICILIO */
              l_ind = Cursor_personbo.GetString("DOMICILIO");
              /* l_cap := personbo->CAP */
              l_cap = Cursor_personbo.GetString("CAP");
              /* l_cta := personbo->DESCCIT */
              l_cta = Cursor_personbo.GetString("DESCCIT");
              /* l_prv := personbo->PROVINCIA  */
              l_prv = Cursor_personbo.GetString("PROVINCIA");
              /* l_stato := '' */
              l_stato = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                l_stato = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                l_stato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            // * --- Read from titopers
            m_cServer = m_Ctx.GetServer("titopers");
            m_cPhName = m_Ctx.GetPhName("titopers");
            m_cSql = "";
            m_cSql = m_cSql+"CONPERS="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0,m_cServer),m_cServer,w_CONNES);
            if (m_Ctx.IsSharedTemp("titopers")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTITO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _contito = Read_Cursor.GetString("CONTITO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on titopers into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _contito = "";
              Read_Cursor.Close();
              /* t_fsi := ' ' // Titolare esistente */
              t_fsi = " ";
              /* t_fno := 'X' // Titolare inesistente */
              t_fno = "X";
              /* t_fcf := ' ' */
              t_fcf = " ";
              /* t_fdoc := ' ' */
              t_fdoc = " ";
              /* t_doc := ' ' */
              t_doc = " ";
            }
            /* If _contito<>'' */
            if (CPLib.ne(_contito,"")) {
              // * --- Select from titolabo
              m_cServer = m_Ctx.GetServer("titolabo");
              m_cPhName = m_Ctx.GetPhName("titolabo");
              if (Cursor_titolabo!=null)
                Cursor_titolabo.Close();
              Cursor_titolabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_contito,"?",0,0,m_cServer, m_oParameters),m_cServer,_contito)+" "+")"+(m_Ctx.IsSharedTemp("titolabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_titolabo.Eof())) {
                /* t_fsi := iif(Empty(titolabo->CONNES)or w_ana=1,' ','X') // Titolare esistente */
                t_fsi = (CPLib.Empty(Cursor_titolabo.GetString("CONNES")) || CPLib.eqr(w_ana,1)?" ":"X");
                /* t_fno := iif(t_fsi='X',' ','X') // Titolare inesistente */
                t_fno = (CPLib.eqr(t_fsi,"X")?" ":"X");
                /* t_fcf := iif((titolabo->CFESTERO=0 and not(Empty(titolabo->CODFISC)) or titolabo->CFESTERO=1) and w_ana=0,'X',' ') */
                t_fcf = ((CPLib.eqr(Cursor_titolabo.GetDouble("CFESTERO"),0) &&  ! (CPLib.Empty(Cursor_titolabo.GetString("CODFISC"))) || CPLib.eqr(Cursor_titolabo.GetDouble("CFESTERO"),1)) && CPLib.eqr(w_ana,0)?"X":" ");
                /* t_fdoc := iif(Empty(titolabo->NUMDOCUM) or w_ana=1,' ','X') */
                t_fdoc = (CPLib.Empty(Cursor_titolabo.GetString("NUMDOCUM")) || CPLib.eqr(w_ana,1)?" ":"X");
                /* If t_fdoc='X' */
                if (CPLib.eqr(t_fdoc,"X")) {
                  // * --- Read from tbtipdoc
                  m_cServer = m_Ctx.GetServer("tbtipdoc");
                  m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                  m_cSql = "";
                  m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_titolabo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_titolabo.GetString("TIPODOC"));
                  if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    t_doc = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    t_doc = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* t_doc := ' ' */
                  t_doc = " ";
                } // End If
                Cursor_titolabo.Next();
              }
              m_cConnectivityError = Cursor_titolabo.ErrorMessage();
              Cursor_titolabo.Close();
              // * --- End Select
            } // End If
            /* pf_f := ' ' */
            pf_f = " ";
            /* pf_fcf := ' ' */
            pf_fcf = " ";
            /* pf_doc := ' ' */
            pf_doc = " ";
            /* pf_sexM := ' ' */
            pf_sexM = " ";
            /* pf_sexF := ' ' */
            pf_sexF = " ";
            /* s_fvisu := iif(w_vcam=1,'X',' ') */
            s_fvisu = (CPLib.eqr(w_vcam,1)?"X":" ");
          } else { // Else
            /* c_neo := iif(w_neo=0,'X',' ') // nuovo cliente */
            c_neo = (CPLib.eqr(w_neo,0)?"X":" ");
            /* c_old := iif(w_neo=1,'X',' ') // vecchio cliente */
            c_old = (CPLib.eqr(w_neo,1)?"X":" ");
            /* c_cod := personbo->CONNES */
            c_cod = Cursor_personbo.GetString("CONNES");
            /* pf_rag := personbo->RAGSOC */
            pf_rag = Cursor_personbo.GetString("RAGSOC");
            /* pf_cnome := iif(Empty(personbo->COGNOME),'',personbo->COGNOME) */
            pf_cnome = (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))?"":Cursor_personbo.GetString("COGNOME"));
            /* pf_nome := iif(Empty(personbo->NOME),'',personbo->NOME) */
            pf_nome = (CPLib.Empty(Cursor_personbo.GetString("NOME"))?"":Cursor_personbo.GetString("NOME"));
            /* pf_f := 'X' */
            pf_f = "X";
            /* pf_fcf := iif((personbo->CFESTERO=0 and not(Empty(personbo->CODFISC))) or personbo->CFESTERO=1,'X',' ') */
            pf_fcf = ((CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0) &&  ! (CPLib.Empty(Cursor_personbo.GetString("CODFISC")))) || CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"X":" ");
            /* pf_fdoc := iif(Empty(personbo->TIPODOC) or w_ana=1,' ','X') */
            pf_fdoc = (CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.eqr(w_ana,1)?" ":"X");
            /* pf_doc := '' */
            pf_doc = "";
            // * --- Read from tbtipdoc
            m_cServer = m_Ctx.GetServer("tbtipdoc");
            m_cPhName = m_Ctx.GetPhName("tbtipdoc");
            m_cSql = "";
            m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
            if (m_Ctx.IsSharedTemp("tbtipdoc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              pf_doc = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              pf_doc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* pf_dnas := iif(Empty(personbo->DATANASC),'',arfn_fdate(personbo->DATANASC)) */
            pf_dnas = (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))?"":arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC")));
            /* pf_lnas := iif(Empty(personbo->NASCOMUN),'',personbo->NASCOMUN) */
            pf_lnas = (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN"))?"":Cursor_personbo.GetString("NASCOMUN"));
            /* verifica := personbo->CFESTERO+ ' '+personbo->CODFISC */
            verifica = Cursor_personbo.GetDouble("CFESTERO")+" "+Cursor_personbo.GetString("CODFISC");
            /* pf_cf := iif(personbo->CFESTERO=0,personbo->CODFISC,'') */
            pf_cf = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),0)?Cursor_personbo.GetString("CODFISC"):"");
            /* pf_piva := iif(Empty(personbo->PARTIVA),'',personbo->PARTIVA) */
            pf_piva = (CPLib.Empty(Cursor_personbo.GetString("PARTIVA"))?"":Cursor_personbo.GetString("PARTIVA"));
            /* pf_sexM := iif(personbo->SESSO='1','X',' ') */
            pf_sexM = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"X":" ");
            /* pf_sexF := iif(personbo->SESSO='1' or Empty(personbo->SESSO),' ','X') */
            pf_sexF = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1") || CPLib.Empty(Cursor_personbo.GetString("SESSO"))?" ":"X");
            /* pf_ind := personbo->DOMICILIO */
            pf_ind = Cursor_personbo.GetString("DOMICILIO");
            /* pf_cap := personbo->CAP */
            pf_cap = Cursor_personbo.GetString("CAP");
            /* pf_cta := personbo->DESCCIT */
            pf_cta = Cursor_personbo.GetString("DESCCIT");
            /* pf_prv := personbo->PROVINCIA */
            pf_prv = Cursor_personbo.GetString("PROVINCIA");
            /* pf_stato := '' */
            pf_stato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              pf_stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              pf_stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from titopers
            m_cServer = m_Ctx.GetServer("titopers");
            m_cPhName = m_Ctx.GetPhName("titopers");
            m_cSql = "";
            m_cSql = m_cSql+"CONPERS="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0,m_cServer),m_cServer,w_CONNES);
            if (m_Ctx.IsSharedTemp("titopers")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTITO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _contito = Read_Cursor.GetString("CONTITO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on titopers into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _contito = "";
              Read_Cursor.Close();
              /* t_fsi := ' ' // Titolare esistente */
              t_fsi = " ";
              /* t_fno := 'X' // Titolare inesistente */
              t_fno = "X";
              /* t_fcf := ' ' */
              t_fcf = " ";
              /* t_fdoc := ' ' */
              t_fdoc = " ";
              /* t_doc := ' ' */
              t_doc = " ";
            }
            /* If _contito<>'' */
            if (CPLib.ne(_contito,"")) {
              // * --- Select from titolabo
              m_cServer = m_Ctx.GetServer("titolabo");
              m_cPhName = m_Ctx.GetPhName("titolabo");
              if (Cursor_titolabo!=null)
                Cursor_titolabo.Close();
              Cursor_titolabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_contito,"?",0,0,m_cServer, m_oParameters),m_cServer,_contito)+" "+")"+(m_Ctx.IsSharedTemp("titolabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_titolabo.Eof())) {
                /* t_fsi := iif(Empty(titolabo->CONNES)or w_ana=1,' ','X') // Titolare esistente */
                t_fsi = (CPLib.Empty(Cursor_titolabo.GetString("CONNES")) || CPLib.eqr(w_ana,1)?" ":"X");
                /* t_fno := iif(t_fsi='X',' ','X') // Titolare inesistente */
                t_fno = (CPLib.eqr(t_fsi,"X")?" ":"X");
                /* t_fcf := iif((titolabo->CFESTERO=0 and not(Empty(titolabo->CODFISC)) or titolabo->CFESTERO=1) and w_ana=0,'X',' ') */
                t_fcf = ((CPLib.eqr(Cursor_titolabo.GetDouble("CFESTERO"),0) &&  ! (CPLib.Empty(Cursor_titolabo.GetString("CODFISC"))) || CPLib.eqr(Cursor_titolabo.GetDouble("CFESTERO"),1)) && CPLib.eqr(w_ana,0)?"X":" ");
                /* t_fdoc := iif(Empty(titolabo->NUMDOCUM) or w_ana=1,' ','X') */
                t_fdoc = (CPLib.Empty(Cursor_titolabo.GetString("NUMDOCUM")) || CPLib.eqr(w_ana,1)?" ":"X");
                /* If t_fdoc='X' */
                if (CPLib.eqr(t_fdoc,"X")) {
                  // * --- Read from tbtipdoc
                  m_cServer = m_Ctx.GetServer("tbtipdoc");
                  m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                  m_cSql = "";
                  m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_titolabo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_titolabo.GetString("TIPODOC"));
                  if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    t_doc = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stp_scheda_di_verifica returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    t_doc = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* t_doc := ' ' */
                  t_doc = " ";
                } // End If
                Cursor_titolabo.Next();
              }
              m_cConnectivityError = Cursor_titolabo.ErrorMessage();
              Cursor_titolabo.Close();
              // * --- End Select
            } // End If
            /* s_f := ' ' */
            s_f = " ";
            /* s_fvisu := ' ' */
            s_fvisu = " ";
            /* s_fdoc := ' ' */
            s_fdoc = " ";
            /* s_fcf := ' ' */
            s_fcf = " ";
            /* l_fcf := ' ' */
            l_fcf = " ";
            /* l_fdoc := ' ' */
            l_fdoc = " ";
            /* l_sexM := ' ' */
            l_sexM = " ";
            /* l_sexF := ' ' */
            l_sexF = " ";
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        /* c_neo := ' ' */
        c_neo = " ";
        /* c_old := ' ' */
        c_old = " ";
        /* s_f := ' ' */
        s_f = " ";
        /* s_fvisu := ' ' */
        s_fvisu = " ";
        /* s_fdoc := ' ' */
        s_fdoc = " ";
        /* s_fcf := ' ' */
        s_fcf = " ";
        /* l_fcf := ' ' */
        l_fcf = " ";
        /* l_fdoc := ' ' */
        l_fdoc = " ";
        /* l_sexM := ' ' */
        l_sexM = " ";
        /* l_sexF := ' ' */
        l_sexF = " ";
        /* t_fsi := ' ' */
        t_fsi = " ";
        /* t_fno := ' ' */
        t_fno = " ";
        /* t_fcf := ' ' */
        t_fcf = " ";
        /* t_fdoc := ' ' */
        t_fdoc = " ";
        /* pf_f := ' ' */
        pf_f = " ";
        /* pf_fcf := ' ' */
        pf_fcf = " ";
        /* pf_fdoc := ' ' */
        pf_fdoc = " ";
        /* pf_sexM := ' ' */
        pf_sexM = " ";
        /* pf_sexF := ' ' */
        pf_sexF = " ";
      } // End If
      /* Exec "Scrive il file di testo con le variabili" Page 2:Page_2 */
      Page_2();
      /* Stop servlet/createpdf */
      Forward f;
      f=new Forward("../servlet/createpdf",false,this,Forward.NoStatus,true);
      f.SetParameter("cOutName",CPLib.LRTrim(gUrlApp)+"/MODULI/"+CPLib.LRTrim(pModRep));
      f.SetParameter("cInName",nomefile);
      f.SetParameter("cHfName",intesfile);
      f.SetParameter("m_cParameterSequence","cOutName"+","+"cInName"+","+"cHfName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_titolabo!=null)
          Cursor_titolabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Crea il nome file e lo apre in scrittura */
    /* nomefile := LibreriaMit.UniqueId() */
    nomefile = LibreriaMit.UniqueId();
    /* fhand := FileLibMit.OpenWrite('appo/'+nomefile) */
    fhand = FileLibMit.OpenWrite("appo/"+nomefile);
    /* FileLibMit.WriteLine(fhand,'c_neo') */
    FileLibMit.WriteLine(fhand,"c_neo");
    /* FileLibMit.WriteLine(fhand,LRTrim(c_neo)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(c_neo));
    /* FileLibMit.WriteLine(fhand,'c_old') */
    FileLibMit.WriteLine(fhand,"c_old");
    /* FileLibMit.WriteLine(fhand,LRTrim(c_old)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(c_old));
    /* FileLibMit.WriteLine(fhand,'c_cod') */
    FileLibMit.WriteLine(fhand,"c_cod");
    /* FileLibMit.WriteLine(fhand,LRTrim(c_cod)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(c_cod));
    /* FileLibMit.WriteLine(fhand,'pf_rag') */
    FileLibMit.WriteLine(fhand,"pf_rag");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_rag)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_rag));
    /* FileLibMit.WriteLine(fhand,'s_rag') */
    FileLibMit.WriteLine(fhand,"s_rag");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_rag)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_rag));
    /* FileLibMit.WriteLine(fhand,'pf_f') */
    FileLibMit.WriteLine(fhand,"pf_f");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_f)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_f));
    /* FileLibMit.WriteLine(fhand,'pf_fcf') */
    FileLibMit.WriteLine(fhand,"pf_fcf");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_fcf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_fcf));
    /* FileLibMit.WriteLine(fhand,'pf_fdoc') */
    FileLibMit.WriteLine(fhand,"pf_fdoc");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_fdoc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_fdoc));
    /* FileLibMit.WriteLine(fhand,'pf_doc') */
    FileLibMit.WriteLine(fhand,"pf_doc");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_doc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_doc));
    /* FileLibMit.WriteLine(fhand,'pf_dnas') */
    FileLibMit.WriteLine(fhand,"pf_dnas");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_dnas)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_dnas));
    /* FileLibMit.WriteLine(fhand,'pf_lnas') */
    FileLibMit.WriteLine(fhand,"pf_lnas");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_lnas)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_lnas));
    /* FileLibMit.WriteLine(fhand,'pf_ctz') */
    FileLibMit.WriteLine(fhand,"pf_ctz");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_ctz)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_ctz));
    /* FileLibMit.WriteLine(fhand,'pf_cf') */
    FileLibMit.WriteLine(fhand,"pf_cf");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_cf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_cf));
    /* FileLibMit.WriteLine(fhand,'pf_piva') */
    FileLibMit.WriteLine(fhand,"pf_piva");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_piva)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_piva));
    /* FileLibMit.WriteLine(fhand,'pf_sexM') */
    FileLibMit.WriteLine(fhand,"pf_sexM");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_sexM)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_sexM));
    /* FileLibMit.WriteLine(fhand,'pf_sexF') */
    FileLibMit.WriteLine(fhand,"pf_sexF");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_sexF)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_sexF));
    /* FileLibMit.WriteLine(fhand,'pf_ind') */
    FileLibMit.WriteLine(fhand,"pf_ind");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_ind)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_ind));
    /* FileLibMit.WriteLine(fhand,'pf_cap') */
    FileLibMit.WriteLine(fhand,"pf_cap");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_cap)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_cap));
    /* FileLibMit.WriteLine(fhand,'pf_cta') */
    FileLibMit.WriteLine(fhand,"pf_cta");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_cta)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_cta));
    /* FileLibMit.WriteLine(fhand,'pf_prv') */
    FileLibMit.WriteLine(fhand,"pf_prv");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_prv)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_prv));
    /* FileLibMit.WriteLine(fhand,'pf_stato') */
    FileLibMit.WriteLine(fhand,"pf_stato");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_stato)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_stato));
    /* FileLibMit.WriteLine(fhand,'pf_tel') */
    FileLibMit.WriteLine(fhand,"pf_tel");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_tel)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_tel));
    /* FileLibMit.WriteLine(fhand,'pf_fax') */
    FileLibMit.WriteLine(fhand,"pf_fax");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_fax)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_fax));
    /* FileLibMit.WriteLine(fhand,'pf_mail') */
    FileLibMit.WriteLine(fhand,"pf_mail");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_mail)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_mail));
    /* FileLibMit.WriteLine(fhand,'pf_ind2') */
    FileLibMit.WriteLine(fhand,"pf_ind2");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_ind2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_ind2));
    /* FileLibMit.WriteLine(fhand,'pf_cap2') */
    FileLibMit.WriteLine(fhand,"pf_cap2");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_cap2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_cap2));
    /* FileLibMit.WriteLine(fhand,'pf_prv2') */
    FileLibMit.WriteLine(fhand,"pf_prv2");
    /* FileLibMit.WriteLine(fhand,LRTrim(pf_prv2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(pf_prv2));
    /* FileLibMit.WriteLine(fhand,'s_f') */
    FileLibMit.WriteLine(fhand,"s_f");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_f)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_f));
    /* FileLibMit.WriteLine(fhand,'s_fvisu') */
    FileLibMit.WriteLine(fhand,"s_fvisu");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_fvisu)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_fvisu));
    /* FileLibMit.WriteLine(fhand,'s_fdoc') */
    FileLibMit.WriteLine(fhand,"s_fdoc");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_fdoc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_fdoc));
    /* FileLibMit.WriteLine(fhand,'s_ind') */
    FileLibMit.WriteLine(fhand,"s_ind");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_ind)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_ind));
    /* FileLibMit.WriteLine(fhand,'s_cap') */
    FileLibMit.WriteLine(fhand,"s_cap");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_cap)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_cap));
    /* FileLibMit.WriteLine(fhand,'s_cta') */
    FileLibMit.WriteLine(fhand,"s_cta");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_cta)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_cta));
    /* FileLibMit.WriteLine(fhand,'s_prv') */
    FileLibMit.WriteLine(fhand,"s_prv");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_prv)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_prv));
    /* FileLibMit.WriteLine(fhand,'s_cf') */
    FileLibMit.WriteLine(fhand,"s_cf");
    /* FileLibMit.WriteLine(fhand,LRTrim(s_cf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(s_cf));
    /* FileLibMit.WriteLine(fhand,'l_cnome') */
    FileLibMit.WriteLine(fhand,"l_cnome");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cnome)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cnome));
    /* FileLibMit.WriteLine(fhand,'l_nome') */
    FileLibMit.WriteLine(fhand,"l_nome");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_nome)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_nome));
    /* FileLibMit.WriteLine(fhand,'l_rag') */
    FileLibMit.WriteLine(fhand,"l_rag");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_rag)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_rag));
    /* FileLibMit.WriteLine(fhand,'l_dnasc') */
    FileLibMit.WriteLine(fhand,"l_dnasc");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_dnasc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_dnasc));
    /* FileLibMit.WriteLine(fhand,'l_lnasc') */
    FileLibMit.WriteLine(fhand,"l_lnasc");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_lnasc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_lnasc));
    /* FileLibMit.WriteLine(fhand,'l_ctz') */
    FileLibMit.WriteLine(fhand,"l_ctz");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_ctz)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_ctz));
    /* FileLibMit.WriteLine(fhand,'l_cf') */
    FileLibMit.WriteLine(fhand,"l_cf");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cf));
    /* FileLibMit.WriteLine(fhand,'l_sexM') */
    FileLibMit.WriteLine(fhand,"l_sexM");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_sexM)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_sexM));
    /* FileLibMit.WriteLine(fhand,'l_sexF') */
    FileLibMit.WriteLine(fhand,"l_sexF");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_sexF)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_sexF));
    /* FileLibMit.WriteLine(fhand,'l_ind') */
    FileLibMit.WriteLine(fhand,"l_ind");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_ind)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_ind));
    /* FileLibMit.WriteLine(fhand,'l_cap') */
    FileLibMit.WriteLine(fhand,"l_cap");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cap)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cap));
    /* FileLibMit.WriteLine(fhand,'l_cta') */
    FileLibMit.WriteLine(fhand,"l_cta");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cta)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cta));
    /* FileLibMit.WriteLine(fhand,'l_prv') */
    FileLibMit.WriteLine(fhand,"l_prv");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_prv)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_prv));
    /* FileLibMit.WriteLine(fhand,'l_stato') */
    FileLibMit.WriteLine(fhand,"l_stato");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_stato)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_stato));
    /* FileLibMit.WriteLine(fhand,'l_tel') */
    FileLibMit.WriteLine(fhand,"l_tel");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_tel)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_tel));
    /* FileLibMit.WriteLine(fhand,'l_fax') */
    FileLibMit.WriteLine(fhand,"l_fax");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_fax)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_fax));
    /* FileLibMit.WriteLine(fhand,'l_mail') */
    FileLibMit.WriteLine(fhand,"l_mail");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_mail)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_mail));
    /* FileLibMit.WriteLine(fhand,'l_ind2') */
    FileLibMit.WriteLine(fhand,"l_ind2");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_ind2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_ind2));
    /* FileLibMit.WriteLine(fhand,'l_cap2') */
    FileLibMit.WriteLine(fhand,"l_cap2");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cap2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cap2));
    /* FileLibMit.WriteLine(fhand,'l_cta2') */
    FileLibMit.WriteLine(fhand,"l_cta2");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_cta2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_cta2));
    /* FileLibMit.WriteLine(fhand,'l_prv2') */
    FileLibMit.WriteLine(fhand,"l_prv2");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_prv2)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_prv2));
    /* FileLibMit.WriteLine(fhand,'l_fcf') */
    FileLibMit.WriteLine(fhand,"l_fcf");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_fcf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_fcf));
    /* FileLibMit.WriteLine(fhand,'l_fdoc') */
    FileLibMit.WriteLine(fhand,"l_fdoc");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_fdoc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_fdoc));
    /* FileLibMit.WriteLine(fhand,'l_doc') */
    FileLibMit.WriteLine(fhand,"l_doc");
    /* FileLibMit.WriteLine(fhand,LRTrim(l_doc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(l_doc));
    /* FileLibMit.WriteLine(fhand,'t_fsi') */
    FileLibMit.WriteLine(fhand,"t_fsi");
    /* FileLibMit.WriteLine(fhand,LRTrim(t_fsi)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(t_fsi));
    /* FileLibMit.WriteLine(fhand,'t_fno') */
    FileLibMit.WriteLine(fhand,"t_fno");
    /* FileLibMit.WriteLine(fhand,LRTrim(t_fno)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(t_fno));
    /* FileLibMit.WriteLine(fhand,'t_fcf') */
    FileLibMit.WriteLine(fhand,"t_fcf");
    /* FileLibMit.WriteLine(fhand,LRTrim(t_fcf)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(t_fcf));
    /* FileLibMit.WriteLine(fhand,'t_fdoc') */
    FileLibMit.WriteLine(fhand,"t_fdoc");
    /* FileLibMit.WriteLine(fhand,LRTrim(t_fdoc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(t_fdoc));
    /* FileLibMit.WriteLine(fhand,'t_doc') */
    FileLibMit.WriteLine(fhand,"t_doc");
    /* FileLibMit.WriteLine(fhand,LRTrim(t_doc)) */
    FileLibMit.WriteLine(fhand,CPLib.LRTrim(t_doc));
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
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
      m_Caller.SetString("CONNES","C",16,0,w_CONNES);
      m_Caller.SetString("CONNESLEG","C",16,0,w_CONNESLEG);
      m_Caller.SetNumber("ana","N",1,0,w_ana);
      m_Caller.SetNumber("mpa","N",1,0,w_mpa);
      m_Caller.SetNumber("neo","N",1,0,w_neo);
      m_Caller.SetNumber("vcam","N",1,0,w_vcam);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_scheda_di_verificaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_scheda_di_verificaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CONNES = m_Caller.GetString("CONNES","C",16,0);
    w_CONNESLEG = m_Caller.GetString("CONNESLEG","C",16,0);
    w_ana = m_Caller.GetNumber("ana","N",1,0);
    w_mpa = m_Caller.GetNumber("mpa","N",1,0);
    w_neo = m_Caller.GetNumber("neo","N",1,0);
    w_vcam = m_Caller.GetNumber("vcam","N",1,0);
    _contito = CPLib.Space(16);
    pModRep = CPLib.Space(120);
    nomefile = CPLib.Space(10);
    intesfile = CPLib.Space(10);
    fhand = CPLib.Space(1);
    verifica = CPLib.Space(100);
    c_neo = CPLib.Space(1);
    c_old = CPLib.Space(1);
    c_cod = CPLib.Space(16);
    pf_rag = CPLib.Space(70);
    pf_cnome = CPLib.Space(30);
    pf_nome = CPLib.Space(30);
    pf_fcf = CPLib.Space(1);
    pf_f = CPLib.Space(1);
    pf_fdoc = CPLib.Space(1);
    pf_doc = CPLib.Space(40);
    pf_dnas = CPLib.Space(10);
    pf_lnas = CPLib.Space(40);
    pf_ctz = CPLib.Space(40);
    pf_cf = CPLib.Space(16);
    pf_piva = CPLib.Space(16);
    pf_sexM = CPLib.Space(1);
    pf_sexF = CPLib.Space(1);
    pf_ind = CPLib.Space(50);
    pf_cap = CPLib.Space(5);
    pf_cta = CPLib.Space(40);
    pf_prv = CPLib.Space(2);
    pf_stato = CPLib.Space(40);
    pf_tel = CPLib.Space(50);
    pf_fax = CPLib.Space(30);
    pf_mail = CPLib.Space(50);
    pf_ind2 = CPLib.Space(50);
    pf_cap2 = CPLib.Space(5);
    pf_cta2 = CPLib.Space(40);
    pf_prv2 = CPLib.Space(2);
    s_rag = CPLib.Space(30);
    s_f = CPLib.Space(1);
    s_fvisu = CPLib.Space(1);
    s_fdoc = CPLib.Space(1);
    s_fcf = CPLib.Space(1);
    s_cf = CPLib.Space(16);
    s_piva = CPLib.Space(16);
    s_ind = CPLib.Space(50);
    s_cap = CPLib.Space(5);
    s_cta = CPLib.Space(40);
    s_prv = CPLib.Space(2);
    s_stato = CPLib.Space(40);
    l_rag = CPLib.Space(70);
    l_cnome = CPLib.Space(30);
    l_nome = CPLib.Space(30);
    l_fdoc = CPLib.Space(1);
    l_doc = CPLib.Space(40);
    l_fcf = CPLib.Space(1);
    l_cf = CPLib.Space(16);
    l_sexM = CPLib.Space(1);
    l_sexF = CPLib.Space(1);
    l_ind = CPLib.Space(50);
    l_cap = CPLib.Space(5);
    l_cta = CPLib.Space(40);
    l_prv = CPLib.Space(2);
    l_stato = CPLib.Space(40);
    l_dnasc = CPLib.Space(10);
    l_lnasc = CPLib.Space(40);
    l_ctz = CPLib.Space(40);
    l_tel = CPLib.Space(50);
    l_fax = CPLib.Space(30);
    l_mail = CPLib.Space(50);
    l_ind2 = CPLib.Space(50);
    l_cap2 = CPLib.Space(5);
    l_cta2 = CPLib.Space(40);
    l_prv2 = CPLib.Space(2);
    t_fsi = CPLib.Space(1);
    t_fno = CPLib.Space(1);
    t_f231 = CPLib.Space(1);
    t_fcf = CPLib.Space(1);
    t_fdoc = CPLib.Space(1);
    t_doc = CPLib.Space(40);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gInter=m_Ctx.GetGlobalString("gInter");
    gTAEG=m_Ctx.GetGlobalString("gTAEG");
    gTEG=m_Ctx.GetGlobalString("gTEG");
    gPromo=m_Ctx.GetGlobalString("gPromo");
    gPrevPers=m_Ctx.GetGlobalString("gPrevPers");
    gCalcCG=m_Ctx.GetGlobalString("gCalcCG");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={};
}
