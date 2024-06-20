// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_anagraficheR implements CallerWithObjs {
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
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_errpersonbo;
  public String m_cServer_tmp_errpersonbo;
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
  public double w_ccab;
  public double w_ccodfisc;
  public String w_rvalcampi;
  public double w_cutf8;
  public double w_cstandard;
  public String gMsgAll;
  public String gMsgProc;
  public double gReport;
  public String connes;
  public String ragsoc;
  public double errori;
  public double _max;
  public double _cnt;
  public double _cicli;
  public double _conta;
  public double _top;
  public double _bottom;
  public double _contar;
  public double _errcabnofind;
  public double _errnocab;
  public double _errcfnocorretto;
  public double _errcfnocomune;
  public double _errutf8;
  public double _report;
  public double w_a_comuni;
  public double w_b_cf;
  public double w_c_utf8;
  public double w_d_totali;
  public String _mini;
  public String cab_citta;
  public String cab_cap;
  public String cab_prov;
  public String cab_stato;
  public String cab2_citta;
  public String cab2_cap;
  public String cab2_prov;
  public String cab2_stato;
  public String cf_oggi;
  public String cf_decennio;
  public java.sql.Date cf_datanasc;
  public String cf_anno;
  public String cf_mese;
  public double cf_asc;
  public String cf_giorno;
  public String cf_sesso;
  public String cf_sigla;
  public String cf_citta;
  public String cf_prov;
  public String cf_stato;
  public java.sql.Date cf2_datanasc;
  public String cf2_sesso;
  public String cf2_citta;
  public String cf2_prov;
  public String cf2_stato;
  public String u_nascomun;
  public String u_desccit;
  public String u_ragsoc;
  public String u_nome;
  public String u_cognome;
  public String u_c;
  public String u_c2;
  public String u_c3;
  public double u_i;
  public double u_lenfor;
  public double u_mod;
  public double cabok;
  public double cfok;
  public double utf8ok;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_allinea_anagraficheR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_anagrafiche",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_errpersonbo")) {
      m_cPhName_tmp_errpersonbo = p_ContextObject.GetPhName("tmp_errpersonbo");
      if (m_cPhName_tmp_errpersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_errpersonbo = m_cPhName_tmp_errpersonbo+" "+m_Ctx.GetWritePhName("tmp_errpersonbo");
      }
      m_cServer_tmp_errpersonbo = p_ContextObject.GetServer("tmp_errpersonbo");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ccab",p_cVarName)) {
      return w_ccab;
    }
    if (CPLib.eqr("ccodfisc",p_cVarName)) {
      return w_ccodfisc;
    }
    if (CPLib.eqr("cutf8",p_cVarName)) {
      return w_cutf8;
    }
    if (CPLib.eqr("cstandard",p_cVarName)) {
      return w_cstandard;
    }
    if (CPLib.eqr("gReport",p_cVarName)) {
      return gReport;
    }
    if (CPLib.eqr("errori",p_cVarName)) {
      return errori;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cnt",p_cVarName)) {
      return _cnt;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    if (CPLib.eqr("_errcabnofind",p_cVarName)) {
      return _errcabnofind;
    }
    if (CPLib.eqr("_errnocab",p_cVarName)) {
      return _errnocab;
    }
    if (CPLib.eqr("_errcfnocorretto",p_cVarName)) {
      return _errcfnocorretto;
    }
    if (CPLib.eqr("_errcfnocomune",p_cVarName)) {
      return _errcfnocomune;
    }
    if (CPLib.eqr("_errutf8",p_cVarName)) {
      return _errutf8;
    }
    if (CPLib.eqr("_report",p_cVarName)) {
      return _report;
    }
    if (CPLib.eqr("a_comuni",p_cVarName)) {
      return w_a_comuni;
    }
    if (CPLib.eqr("b_cf",p_cVarName)) {
      return w_b_cf;
    }
    if (CPLib.eqr("c_utf8",p_cVarName)) {
      return w_c_utf8;
    }
    if (CPLib.eqr("d_totali",p_cVarName)) {
      return w_d_totali;
    }
    if (CPLib.eqr("cf_asc",p_cVarName)) {
      return cf_asc;
    }
    if (CPLib.eqr("u_i",p_cVarName)) {
      return u_i;
    }
    if (CPLib.eqr("u_lenfor",p_cVarName)) {
      return u_lenfor;
    }
    if (CPLib.eqr("u_mod",p_cVarName)) {
      return u_mod;
    }
    if (CPLib.eqr("cabok",p_cVarName)) {
      return cabok;
    }
    if (CPLib.eqr("cfok",p_cVarName)) {
      return cfok;
    }
    if (CPLib.eqr("utf8ok",p_cVarName)) {
      return utf8ok;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_anagrafiche";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("rvalcampi",p_cVarName)) {
      return w_rvalcampi;
    }
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      return gMsgAll;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return connes;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      return ragsoc;
    }
    if (CPLib.eqr("_mini",p_cVarName)) {
      return _mini;
    }
    if (CPLib.eqr("cab_citta",p_cVarName)) {
      return cab_citta;
    }
    if (CPLib.eqr("cab_cap",p_cVarName)) {
      return cab_cap;
    }
    if (CPLib.eqr("cab_prov",p_cVarName)) {
      return cab_prov;
    }
    if (CPLib.eqr("cab_stato",p_cVarName)) {
      return cab_stato;
    }
    if (CPLib.eqr("cab2_citta",p_cVarName)) {
      return cab2_citta;
    }
    if (CPLib.eqr("cab2_cap",p_cVarName)) {
      return cab2_cap;
    }
    if (CPLib.eqr("cab2_prov",p_cVarName)) {
      return cab2_prov;
    }
    if (CPLib.eqr("cab2_stato",p_cVarName)) {
      return cab2_stato;
    }
    if (CPLib.eqr("cf_oggi",p_cVarName)) {
      return cf_oggi;
    }
    if (CPLib.eqr("cf_decennio",p_cVarName)) {
      return cf_decennio;
    }
    if (CPLib.eqr("cf_anno",p_cVarName)) {
      return cf_anno;
    }
    if (CPLib.eqr("cf_mese",p_cVarName)) {
      return cf_mese;
    }
    if (CPLib.eqr("cf_giorno",p_cVarName)) {
      return cf_giorno;
    }
    if (CPLib.eqr("cf_sesso",p_cVarName)) {
      return cf_sesso;
    }
    if (CPLib.eqr("cf_sigla",p_cVarName)) {
      return cf_sigla;
    }
    if (CPLib.eqr("cf_citta",p_cVarName)) {
      return cf_citta;
    }
    if (CPLib.eqr("cf_prov",p_cVarName)) {
      return cf_prov;
    }
    if (CPLib.eqr("cf_stato",p_cVarName)) {
      return cf_stato;
    }
    if (CPLib.eqr("cf2_sesso",p_cVarName)) {
      return cf2_sesso;
    }
    if (CPLib.eqr("cf2_citta",p_cVarName)) {
      return cf2_citta;
    }
    if (CPLib.eqr("cf2_prov",p_cVarName)) {
      return cf2_prov;
    }
    if (CPLib.eqr("cf2_stato",p_cVarName)) {
      return cf2_stato;
    }
    if (CPLib.eqr("u_nascomun",p_cVarName)) {
      return u_nascomun;
    }
    if (CPLib.eqr("u_desccit",p_cVarName)) {
      return u_desccit;
    }
    if (CPLib.eqr("u_ragsoc",p_cVarName)) {
      return u_ragsoc;
    }
    if (CPLib.eqr("u_nome",p_cVarName)) {
      return u_nome;
    }
    if (CPLib.eqr("u_cognome",p_cVarName)) {
      return u_cognome;
    }
    if (CPLib.eqr("u_c",p_cVarName)) {
      return u_c;
    }
    if (CPLib.eqr("u_c2",p_cVarName)) {
      return u_c2;
    }
    if (CPLib.eqr("u_c3",p_cVarName)) {
      return u_c3;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cf_datanasc",p_cVarName)) {
      return cf_datanasc;
    }
    if (CPLib.eqr("cf2_datanasc",p_cVarName)) {
      return cf2_datanasc;
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
    if (CPLib.eqr("ccab",p_cVarName)) {
      w_ccab = value;
      return;
    }
    if (CPLib.eqr("ccodfisc",p_cVarName)) {
      w_ccodfisc = value;
      return;
    }
    if (CPLib.eqr("cutf8",p_cVarName)) {
      w_cutf8 = value;
      return;
    }
    if (CPLib.eqr("cstandard",p_cVarName)) {
      w_cstandard = value;
      return;
    }
    if (CPLib.eqr("gReport",p_cVarName)) {
      gReport = value;
      return;
    }
    if (CPLib.eqr("errori",p_cVarName)) {
      errori = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cnt",p_cVarName)) {
      _cnt = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
    if (CPLib.eqr("_errcabnofind",p_cVarName)) {
      _errcabnofind = value;
      return;
    }
    if (CPLib.eqr("_errnocab",p_cVarName)) {
      _errnocab = value;
      return;
    }
    if (CPLib.eqr("_errcfnocorretto",p_cVarName)) {
      _errcfnocorretto = value;
      return;
    }
    if (CPLib.eqr("_errcfnocomune",p_cVarName)) {
      _errcfnocomune = value;
      return;
    }
    if (CPLib.eqr("_errutf8",p_cVarName)) {
      _errutf8 = value;
      return;
    }
    if (CPLib.eqr("_report",p_cVarName)) {
      _report = value;
      return;
    }
    if (CPLib.eqr("a_comuni",p_cVarName)) {
      w_a_comuni = value;
      return;
    }
    if (CPLib.eqr("b_cf",p_cVarName)) {
      w_b_cf = value;
      return;
    }
    if (CPLib.eqr("c_utf8",p_cVarName)) {
      w_c_utf8 = value;
      return;
    }
    if (CPLib.eqr("d_totali",p_cVarName)) {
      w_d_totali = value;
      return;
    }
    if (CPLib.eqr("cf_asc",p_cVarName)) {
      cf_asc = value;
      return;
    }
    if (CPLib.eqr("u_i",p_cVarName)) {
      u_i = value;
      return;
    }
    if (CPLib.eqr("u_lenfor",p_cVarName)) {
      u_lenfor = value;
      return;
    }
    if (CPLib.eqr("u_mod",p_cVarName)) {
      u_mod = value;
      return;
    }
    if (CPLib.eqr("cabok",p_cVarName)) {
      cabok = value;
      return;
    }
    if (CPLib.eqr("cfok",p_cVarName)) {
      cfok = value;
      return;
    }
    if (CPLib.eqr("utf8ok",p_cVarName)) {
      utf8ok = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("rvalcampi",p_cVarName)) {
      w_rvalcampi = value;
      return;
    }
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      gMsgAll = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      connes = value;
      return;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      ragsoc = value;
      return;
    }
    if (CPLib.eqr("_mini",p_cVarName)) {
      _mini = value;
      return;
    }
    if (CPLib.eqr("cab_citta",p_cVarName)) {
      cab_citta = value;
      return;
    }
    if (CPLib.eqr("cab_cap",p_cVarName)) {
      cab_cap = value;
      return;
    }
    if (CPLib.eqr("cab_prov",p_cVarName)) {
      cab_prov = value;
      return;
    }
    if (CPLib.eqr("cab_stato",p_cVarName)) {
      cab_stato = value;
      return;
    }
    if (CPLib.eqr("cab2_citta",p_cVarName)) {
      cab2_citta = value;
      return;
    }
    if (CPLib.eqr("cab2_cap",p_cVarName)) {
      cab2_cap = value;
      return;
    }
    if (CPLib.eqr("cab2_prov",p_cVarName)) {
      cab2_prov = value;
      return;
    }
    if (CPLib.eqr("cab2_stato",p_cVarName)) {
      cab2_stato = value;
      return;
    }
    if (CPLib.eqr("cf_oggi",p_cVarName)) {
      cf_oggi = value;
      return;
    }
    if (CPLib.eqr("cf_decennio",p_cVarName)) {
      cf_decennio = value;
      return;
    }
    if (CPLib.eqr("cf_anno",p_cVarName)) {
      cf_anno = value;
      return;
    }
    if (CPLib.eqr("cf_mese",p_cVarName)) {
      cf_mese = value;
      return;
    }
    if (CPLib.eqr("cf_giorno",p_cVarName)) {
      cf_giorno = value;
      return;
    }
    if (CPLib.eqr("cf_sesso",p_cVarName)) {
      cf_sesso = value;
      return;
    }
    if (CPLib.eqr("cf_sigla",p_cVarName)) {
      cf_sigla = value;
      return;
    }
    if (CPLib.eqr("cf_citta",p_cVarName)) {
      cf_citta = value;
      return;
    }
    if (CPLib.eqr("cf_prov",p_cVarName)) {
      cf_prov = value;
      return;
    }
    if (CPLib.eqr("cf_stato",p_cVarName)) {
      cf_stato = value;
      return;
    }
    if (CPLib.eqr("cf2_sesso",p_cVarName)) {
      cf2_sesso = value;
      return;
    }
    if (CPLib.eqr("cf2_citta",p_cVarName)) {
      cf2_citta = value;
      return;
    }
    if (CPLib.eqr("cf2_prov",p_cVarName)) {
      cf2_prov = value;
      return;
    }
    if (CPLib.eqr("cf2_stato",p_cVarName)) {
      cf2_stato = value;
      return;
    }
    if (CPLib.eqr("u_nascomun",p_cVarName)) {
      u_nascomun = value;
      return;
    }
    if (CPLib.eqr("u_desccit",p_cVarName)) {
      u_desccit = value;
      return;
    }
    if (CPLib.eqr("u_ragsoc",p_cVarName)) {
      u_ragsoc = value;
      return;
    }
    if (CPLib.eqr("u_nome",p_cVarName)) {
      u_nome = value;
      return;
    }
    if (CPLib.eqr("u_cognome",p_cVarName)) {
      u_cognome = value;
      return;
    }
    if (CPLib.eqr("u_c",p_cVarName)) {
      u_c = value;
      return;
    }
    if (CPLib.eqr("u_c2",p_cVarName)) {
      u_c2 = value;
      return;
    }
    if (CPLib.eqr("u_c3",p_cVarName)) {
      u_c3 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("cf_datanasc",p_cVarName)) {
      cf_datanasc = value;
      return;
    }
    if (CPLib.eqr("cf2_datanasc",p_cVarName)) {
      cf2_datanasc = value;
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
    CPResultSet Cursor_qbe_max_personbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_ccab Numeric(1, 0) // controllo coici CAB */
      /* w_ccodfisc Numeric(1, 0) // controllo codice fiscale */
      /* w_rvalcampi Char(1) // modo di assegnare i campi */
      /* w_cutf8 Numeric(1, 0) // controllo utf8 */
      /* w_cstandard Numeric(10, 0) // convertire i caratteri non utf8 */
      /* gMsgAll Char(120) // Messaggio allineamento 1 */
      /* gMsgProc Memo // Messaggio */
      /* gReport Numeric(1, 0) // Bottone Stampe */
      /* connes Char(10) */
      /* ragsoc Char(70) */
      /* errori Numeric(19, 0) */
      /* _max Numeric(15, 0) */
      /* _cnt Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _contar Numeric(15, 0) */
      /* _errcabnofind Numeric(15, 0) */
      /* _errnocab Numeric(15, 0) */
      /* _errcfnocorretto Numeric(15, 0) */
      /* _errcfnocomune Numeric(15, 0) */
      /* _errutf8 Numeric(15, 0) */
      /* _report Numeric(1, 0) */
      /* w_a_comuni Numeric(10, 0) */
      /* w_b_cf Numeric(10, 0) */
      /* w_c_utf8 Numeric(10, 0) */
      /* w_d_totali Numeric(10, 0) */
      /* _mini Char(120) */
      /* cab_citta Char(30) */
      /* cab_cap Char(9) */
      /* cab_prov Char(2) */
      /* cab_stato Char(3) */
      /* cab2_citta Char(30) */
      /* cab2_cap Char(9) */
      /* cab2_prov Char(2) */
      /* cab2_stato Char(3) */
      /* cf_oggi Char(4) */
      /* cf_decennio Char(2) */
      /* cf_datanasc Date */
      /* cf_anno Char(4) */
      /* cf_mese Char(2) */
      /* cf_asc Numeric(3, 0) */
      /* cf_giorno Char(2) */
      /* cf_sesso Char(1) */
      /* cf_sigla Char(4) */
      /* cf_citta Char(30) */
      /* cf_prov Char(2) */
      /* cf_stato Char(30) */
      /* cf2_datanasc Date */
      /* cf2_sesso Char(1) */
      /* cf2_citta Char(30) */
      /* cf2_prov Char(2) */
      /* cf2_stato Char(30) */
      /* u_nascomun Char(30) */
      /* u_desccit Char(30) */
      /* u_ragsoc Char(70) */
      /* u_nome Char(25) */
      /* u_cognome Char(26) */
      /* u_c Char(1) // carattere originale */
      /* u_c2 Char(1) // carattere modificato */
      /* u_c3 Char(1) // upper del carattere originale u_c */
      /* u_i Numeric(3, 0) */
      /* u_lenfor Numeric(3, 0) */
      /* u_mod Numeric(1, 0) */
      /* cabok Numeric(1, 0) */
      /* cfok Numeric(1, 0) */
      /* utf8ok Numeric(1, 0) */
      // * --- Drop temporary table tmp_errpersonbo
      if (m_Ctx.IsSharedTemp("tmp_errpersonbo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errpersonbo")) {
          m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
          m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errpersonbo");
      }
      // * --- Create temporary table tmp_errpersonbo
      if (m_Ctx.IsSharedTemp("tmp_errpersonbo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errpersonbo")) {
          m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
          m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errpersonbo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_errpersonbo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_errpersonbo"))) {
        m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_errpersonbo",m_cServer,"proto")),m_cPhName,"tmp_errpersonbo",m_Ctx);
      }
      m_cPhName_tmp_errpersonbo = m_cPhName;
      /* cab = codice cab non individuato */
      /* ca2 = codice cab non valorizzato */
      /* cod = codice fiscale non strutturalmente corretto */
      /* pro = codice comune nel codice fiscale non individuato */
      /* utf = è presente un campo non UTF8 */
      /* cf_oggi := LRTrim(Str(Year(Date()))) */
      cf_oggi = CPLib.LRTrim(CPLib.Str(CPLib.Year(CPLib.Date())));
      /* w_a_comuni := 0 */
      w_a_comuni = CPLib.Round(0,0);
      /* w_b_cf := 0 */
      w_b_cf = CPLib.Round(0,0);
      /* w_c_utf8 := 0 */
      w_c_utf8 = CPLib.Round(0,0);
      /* w_d_totali := 0 */
      w_d_totali = CPLib.Round(0,0);
      /* _report := 0 */
      _report = CPLib.Round(0,0);
      /* _errcabnofind := 0 */
      _errcabnofind = CPLib.Round(0,0);
      /* _errnocab := 0 */
      _errnocab = CPLib.Round(0,0);
      /* _errcfnocorretto := 0 */
      _errcfnocorretto = CPLib.Round(0,0);
      /* _errcfnocomune := 0 */
      _errcfnocomune = CPLib.Round(0,0);
      /* _errutf8 := 0 */
      _errutf8 = CPLib.Round(0,0);
      /* _cnt := 0 */
      _cnt = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* gMsgProc := '' // Messaggio */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _mini := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL + NL */
      _mini = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n"+"\n";
      /* Verifica il contatore massimo */
      // * --- Select from qbe_max_personbo
      if (Cursor_qbe_max_personbo!=null)
        Cursor_qbe_max_personbo.Close();
      Cursor_qbe_max_personbo = new VQRHolder("qbe_max_personbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_personbo.Eof())) {
        /* _max := qbe_max_personbo->MAXPROG */
        _max = CPLib.Round(Cursor_qbe_max_personbo.GetDouble("MAXPROG"),0);
        /* _cnt := qbe_max_personbo->CNTPROG */
        _cnt = CPLib.Round(Cursor_qbe_max_personbo.GetDouble("CNTPROG"),0);
        Cursor_qbe_max_personbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_personbo.ErrorMessage();
      Cursor_qbe_max_personbo.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ALLINEATO=0  and  PROGIMPORT >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPORT <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _contar := _contar + 1 */
          _contar = CPLib.Round(_contar+1,0);
          /* gMsgAll := 'Sono stati elaborati '+LRTrim(Str(_contar,10,0))+' nominativi. '+LRTrim(Str((_contar/_cnt)*100,5,2))+'%.' // Messaggio allineamento 1 */
          gMsgAll = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contar,10,0))+" nominativi. "+CPLib.LRTrim(CPLib.Str((_contar/_cnt)*100,5,2))+"%.";
          m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
          /* escludo le anagrafiche con 'allineato' a 1 */
          /* cabok := 0 */
          cabok = CPLib.Round(0,0);
          /* cfok := 0 */
          cfok = CPLib.Round(0,0);
          /* utf8ok := 0 */
          utf8ok = CPLib.Round(0,0);
          /* w_d_totali := w_d_totali + 1 */
          w_d_totali = CPLib.Round(w_d_totali+1,0);
          /* connes := personbo->CONNES */
          connes = Cursor_personbo.GetString("CONNES");
          /* ragsoc := LRTrim(personbo->RAGSOC) */
          ragsoc = CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"));
          /* If w_ccab = 1 */
          if (CPLib.eqr(w_ccab,1)) {
            /* If Len(LRTrim(personbo->CODFISC)) <> 16 or  personbo->CFESTERO = 1 */
            if (CPLib.ne(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16) || CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* Solo se  non è persona fisica italiana. */
              /* If not(Empty(LRTrim(personbo->CODCAB))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))))) {
                /* cab_citta := '' */
                cab_citta = "";
                /* cab_cap := '' */
                cab_cap = "";
                /* cab_prov := '' */
                cab_prov = "";
                /* cab_stato := '' */
                cab_stato = "";
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"CAB="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODCAB"));
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PKTBSTATI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  cab_citta = Read_Cursor.GetString("CITTA");
                  cab_prov = Read_Cursor.GetString("PROV");
                  cab_cap = Read_Cursor.GetString("CAP");
                  cab_stato = Read_Cursor.GetString("PKTBSTATI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_allinea_anagrafiche returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  cab_citta = "";
                  cab_prov = "";
                  cab_cap = "";
                  cab_stato = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If cab_cap = ''  and cab_citta= '' and cab_prov='' and cab_stato= '' */
                if (CPLib.eqr(cab_cap,"") && CPLib.eqr(cab_citta,"") && CPLib.eqr(cab_prov,"") && CPLib.eqr(cab_stato,"")) {
                  /* Errore CAB non trovato */
                  /* _errcabnofind := _errcabnofind+1 */
                  _errcabnofind = CPLib.Round(_errcabnofind+1,0);
                  // * --- Insert into tmp_errpersonbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000082")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000082(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("CAB non individuato: "+Cursor_personbo.GetString("CODCAB")+" di: "+ragsoc,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("cab","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_errcabnofind,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errcabnofind,15,0)),10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                  /* _report := 1 */
                  _report = CPLib.Round(1,0);
                } else { // Else
                  /* If w_rvalcampi = 'A' */
                  if (CPLib.eqr(w_rvalcampi,"A")) {
                    /* cabok := 1 */
                    cabok = CPLib.Round(1,0);
                    /* w_a_comuni := w_a_comuni + 1 */
                    w_a_comuni = CPLib.Round(w_a_comuni+1,0);
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000087")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(cab_citta,"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(cab_cap,"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(cab_prov,"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cab_stato,"C",3,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
                  } else { // Else
                    /* cabok := 1 */
                    cabok = CPLib.Round(1,0);
                    /* w_a_comuni := w_a_comuni + 1 */
                    w_a_comuni = CPLib.Round(w_a_comuni+1,0);
                    // * --- Read from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"C",16,0,m_cServer),m_cServer,connes);
                    if (m_Ctx.IsSharedTemp("personbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      cab2_citta = Read_Cursor.GetString("DESCCIT");
                      cab2_cap = Read_Cursor.GetString("CAP");
                      cab2_prov = Read_Cursor.GetString("PROVINCIA");
                      cab2_stato = Read_Cursor.GetString("PAESE");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on personbo into routine arrt_allinea_anagrafiche returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      cab2_citta = "";
                      cab2_cap = "";
                      cab2_prov = "";
                      cab2_stato = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If LRTrim(cab2_citta)<>'' */
                    if (CPLib.ne(CPLib.LRTrim(cab2_citta),"")) {
                      /* cab_citta := cab2_citta */
                      cab_citta = cab2_citta;
                    } // End If
                    /* If LRTrim(cab2_cap)<>'' */
                    if (CPLib.ne(CPLib.LRTrim(cab2_cap),"")) {
                      /* cab_cap := cab2_cap */
                      cab_cap = cab2_cap;
                    } // End If
                    /* If LRTrim(cab2_prov)<>'' */
                    if (CPLib.ne(CPLib.LRTrim(cab2_prov),"")) {
                      /* cab_prov := cab2_prov */
                      cab_prov = cab2_prov;
                    } // End If
                    /* If LRTrim(cab2_stato)<>'' */
                    if (CPLib.ne(CPLib.LRTrim(cab2_stato),"")) {
                      /* cab_stato := cab2_stato */
                      cab_stato = cab2_stato;
                    } // End If
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000093")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(cab_citta,"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(cab_cap,"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(cab_prov,"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cab_stato,"C",3,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* Errore CAB non valorizzato */
                /* _errnocab := _errnocab+1 */
                _errnocab = CPLib.Round(_errnocab+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000096")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000096(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("CAB non valorizzato di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("ca2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errnocab,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errnocab,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } else { // Else
              /* If Len(LRTrim(personbo->CODFISC))= 16 and arfn_chkcodfis(personbo->CODFISC,'086',0) */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16) && arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",0)) {
                /* non allinea i comuni per le persone fisiche,quindi gli dò l'ok ugualmente */
                /* cabok := 1 */
                cabok = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
          /* If w_ccodfisc = 1 */
          if (CPLib.eqr(w_ccodfisc,1)) {
            /* If Len(LRTrim(personbo->CODFISC))= 11 and arfn_chkcodfis(personbo->CODFISC,'086',0) */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),11) && arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",0)) {
              /* w_b_cf := w_b_cf + 1 */
              w_b_cf = CPLib.Round(w_b_cf+1,0);
              // * --- Write into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000009E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL("","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              /* è una società corretta,quindi gli dò l'ok per il CF */
              /* cfok := 1 */
              cfok = CPLib.Round(1,0);
            } // End If
            /* If Len(LRTrim(personbo->CODFISC))= 16 and not(personbo->CFESTERO= 1) */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16) &&  ! (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1))) {
              /* If arfn_chkcodfis(LRTrim(personbo->CODFISC),'086',0) */
              if (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),"086",0)) {
                /* cf_decennio := Substr(LRTrim(personbo->CODFISC),7,2) */
                cf_decennio = CPLib.Substr(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),7,2);
                /* cf_anno := '20'+cf_decennio */
                cf_anno = "20"+cf_decennio;
                /* If Val(cf_oggi)-Val(cf_anno) < 18 */
                if (CPLib.lt(CPLib.Val(cf_oggi)-CPLib.Val(cf_anno),18)) {
                  /* cf_anno := '19'+cf_decennio */
                  cf_anno = "19"+cf_decennio;
                } // End If
                /* cf_mese := Substr(LRTrim(personbo->CODFISC),9,1) */
                cf_mese = CPLib.Substr(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),9,1);
                /* cf_asc := Asc(cf_mese) */
                cf_asc = CPLib.Round(CPLib.Asc(cf_mese),0);
                /* Case cf_asc <= 69 */
                if (CPLib.le(cf_asc,69)) {
                  /* cf_asc := cf_asc -16 */
                  cf_asc = CPLib.Round(cf_asc-16,0);
                  /* cf_mese := '0'+Chr(cf_asc) */
                  cf_mese = "0"+CPLib.Chr(cf_asc);
                  /* Case cf_asc = 72 */
                } else if (CPLib.eqr(cf_asc,72)) {
                  /* cf_mese := '06' */
                  cf_mese = "06";
                  /* Case cf_asc = 76 */
                } else if (CPLib.eqr(cf_asc,76)) {
                  /* cf_mese := '07' */
                  cf_mese = "07";
                  /* Case cf_asc = 77 */
                } else if (CPLib.eqr(cf_asc,77)) {
                  /* cf_mese := '08' */
                  cf_mese = "08";
                  /* Case cf_asc = 80 */
                } else if (CPLib.eqr(cf_asc,80)) {
                  /* cf_mese := '09' */
                  cf_mese = "09";
                  /* Case cf_asc = 82 */
                } else if (CPLib.eqr(cf_asc,82)) {
                  /* cf_mese := '10' */
                  cf_mese = "10";
                  /* Case cf_asc = 83 */
                } else if (CPLib.eqr(cf_asc,83)) {
                  /* cf_mese := '11' */
                  cf_mese = "11";
                  /* Case cf_asc = 84 */
                } else if (CPLib.eqr(cf_asc,84)) {
                  /* cf_mese := '12' */
                  cf_mese = "12";
                } // End Case
                /* cf_giorno := Substr(LRTrim(personbo->CODFISC),10,2) */
                cf_giorno = CPLib.Substr(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),10,2);
                /* If Val(cf_giorno)> 40 */
                if (CPLib.gt(CPLib.Val(cf_giorno),40)) {
                  /* cf_sesso := '2' // 2 è donna F */
                  cf_sesso = "2";
                  /* cf_giorno := Str(Val(cf_giorno)- 40) */
                  cf_giorno = CPLib.Str(CPLib.Val(cf_giorno)-40);
                } else { // Else
                  /* cf_sesso := '1' // 1 uomo M */
                  cf_sesso = "1";
                } // End If
                /* cf_datanasc := CharToDate(LRTrim(cf_anno)+LRTrim(cf_mese)+LRTrim(cf_giorno)) */
                cf_datanasc = CPLib.CharToDate(CPLib.LRTrim(cf_anno)+CPLib.LRTrim(cf_mese)+CPLib.LRTrim(cf_giorno));
                /* cf_sigla := Substr(LRTrim(personbo->CODFISC),12,4) */
                cf_sigla = CPLib.Substr(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),12,4);
                /* cf_citta := '' */
                cf_citta = "";
                /* cf_prov := '' */
                cf_prov = "";
                /* cf_stato := '' */
                cf_stato = "";
                /* considero che per gli stati esteri è SEMPRE presente una Z */
                /* If not(Substr(Upper(LRTrim(personbo->CODFISC)),12,1)= 'Z') */
                if ( ! (CPLib.eqr(CPLib.Substr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),12,1),"Z"))) {
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(cf_sigla,"C",4,0,m_cServer),m_cServer,cf_sigla);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    cf_citta = Read_Cursor.GetString("CITTA");
                    cf_prov = Read_Cursor.GetString("PROV");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_allinea_anagrafiche returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    cf_citta = "";
                    cf_prov = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* cf_stato := '' */
                  cf_stato = "";
                } else { // Else
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(cf_sigla,"C",4,0,m_cServer),m_cServer,cf_sigla);
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    cf_stato = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_allinea_anagrafiche returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    cf_stato = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If cf_stato <> '' */
                  if (CPLib.ne(cf_stato,"")) {
                    /* cf_prov := 'EE' */
                    cf_prov = "EE";
                  } // End If
                  /* cf_citta := '' */
                  cf_citta = "";
                } // End If
                /* If (cf_citta = '' or cf_stato ='')  and cf_prov = '' */
                if ((CPLib.eqr(cf_citta,"") || CPLib.eqr(cf_stato,"")) && CPLib.eqr(cf_prov,"")) {
                  /* errore sigla non individuata */
                  /* _errcfnocomune := _errcfnocomune+1 */
                  _errcfnocomune = CPLib.Round(_errcfnocomune+1,0);
                  // * --- Insert into tmp_errpersonbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"000000C8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000C8(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Codice comune di nascita non individuato di: "+ragsoc,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("pro","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_errcfnocomune,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errcfnocomune,15,0)),10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                  /* _report := 1 */
                  _report = CPLib.Round(1,0);
                  /* cf_citta := personbo->NASCOMUN */
                  cf_citta = Cursor_personbo.GetString("NASCOMUN");
                  /* cf_prov := personbo->TIPINTER */
                  cf_prov = Cursor_personbo.GetString("TIPINTER");
                  /* cf_stato := personbo->NASSTATO */
                  cf_stato = Cursor_personbo.GetString("NASSTATO");
                  /* al cfok gli dò 2, per capire che è "mezzo errore" */
                  /* cfok := 2 */
                  cfok = CPLib.Round(2,0);
                } // End If
                /* If w_rvalcampi = 'A' */
                if (CPLib.eqr(w_rvalcampi,"A")) {
                  /* w_b_cf := w_b_cf + 1 */
                  w_b_cf = CPLib.Round(w_b_cf+1,0);
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"000000D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cf_datanasc,"D",8,0)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(cf_sesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cf_citta,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cf_prov,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cf_stato,"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
                  /* If cfok<>2 */
                  if (CPLib.ne(cfok,2)) {
                    /* cfok := 1 */
                    cfok = CPLib.Round(1,0);
                  } // End If
                } else { // Else
                  /* If cfok<>2 */
                  if (CPLib.ne(cfok,2)) {
                    /* cfok := 1 */
                    cfok = CPLib.Round(1,0);
                  } // End If
                  /* w_b_cf := w_b_cf + 1 */
                  w_b_cf = CPLib.Round(w_b_cf+1,0);
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"C",16,0,m_cServer),m_cServer,connes);
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    cf2_datanasc = Read_Cursor.GetDate("DATANASC");
                    cf2_sesso = Read_Cursor.GetString("SESSO");
                    cf2_citta = Read_Cursor.GetString("NASCOMUN");
                    cf2_stato = Read_Cursor.GetString("NASSTATO");
                    cf2_prov = Read_Cursor.GetString("TIPINTER");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_allinea_anagrafiche returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    cf2_datanasc = CPLib.NullDate();
                    cf2_sesso = "";
                    cf2_citta = "";
                    cf2_stato = "";
                    cf2_prov = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If not(Empty(cf2_datanasc)) */
                  if ( ! (CPLib.Empty(cf2_datanasc))) {
                    /* cf_datanasc := cf2_datanasc */
                    cf_datanasc = cf2_datanasc;
                  } // End If
                  /* If LRTrim(cf2_sesso)<>'' */
                  if (CPLib.ne(CPLib.LRTrim(cf2_sesso),"")) {
                    /* cf_sesso := cf2_sesso */
                    cf_sesso = cf2_sesso;
                  } // End If
                  /* If LRTrim(cf2_citta)<>'' */
                  if (CPLib.ne(CPLib.LRTrim(cf2_citta),"")) {
                    /* cf_citta := cf2_citta */
                    cf_citta = cf2_citta;
                  } // End If
                  /* If LRTrim(cf2_stato)<>'' */
                  if (CPLib.ne(CPLib.LRTrim(cf2_stato),"")) {
                    /* cf_stato := cf2_stato */
                    cf_stato = cf2_stato;
                  } // End If
                  /* If LRTrim(cf2_prov)<>'' */
                  if (CPLib.ne(CPLib.LRTrim(cf2_prov),"")) {
                    /* cf_prov := cf2_prov */
                    cf_prov = cf2_prov;
                  } // End If
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"000000E2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cf_datanasc,"D",8,0)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(cf_sesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cf_citta,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cf_prov,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cf_stato,"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore CF non strutturalmente corretto */
                /* _errcfnocorretto := _errcfnocorretto+1 */
                _errcfnocorretto = CPLib.Round(_errcfnocorretto+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"000000E5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000E5(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Codice fiscale non strutturalmente corretto di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("cod","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errcfnocorretto,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errcfnocorretto,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
          /* If w_cutf8 = 1 */
          if (CPLib.eqr(w_cutf8,1)) {
            /* If w_cstandard=1 */
            if (CPLib.eqr(w_cstandard,1)) {
              /* se li cancello io, dò direttamente l'ok */
              /* utf8ok := 1 */
              utf8ok = CPLib.Round(1,0);
            } // End If
            /* u_nascomun := LRTrim(personbo->NASCOMUN) */
            u_nascomun = CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"));
            /* u_desccit := LRTrim(personbo->DESCCIT) */
            u_desccit = CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"));
            /* u_ragsoc := LRTrim(personbo->RAGSOC) */
            u_ragsoc = CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"));
            /* u_nome := LRTrim(personbo->NOME) */
            u_nome = CPLib.LRTrim(Cursor_personbo.GetString("NOME"));
            /* u_cognome := LRTrim(personbo->COGNOME) */
            u_cognome = CPLib.LRTrim(Cursor_personbo.GetString("COGNOME"));
            /* If not(LibreriaMit.TestAscii(u_nascomun,'UTF-8')) */
            if ( ! (LibreriaMit.TestAscii(u_nascomun,"UTF-8"))) {
              /* u_mod := 0 */
              u_mod = CPLib.Round(0,0);
              /* If w_cstandard = 1 */
              if (CPLib.eqr(w_cstandard,1)) {
                /* u_i := 1 */
                u_i = CPLib.Round(1,0);
                /* u_lenfor := Len(u_nascomun) */
                u_lenfor = CPLib.Round(CPLib.Len(u_nascomun),0);
                /* While not(u_i>u_lenfor) */
                while ( ! (CPLib.gt(u_i,u_lenfor))) {
                  /* u_c := Substr(u_nascomun,u_i,1) // carattere originale */
                  u_c = CPLib.Substr(u_nascomun,u_i,1);
                  /* If not(LibreriaMit.TestAscii(u_c,'UTF-8')) */
                  if ( ! (LibreriaMit.TestAscii(u_c,"UTF-8"))) {
                    /* u_c3 := Upper(u_c) // upper del carattere originale u_c */
                    u_c3 = CPLib.Upper(u_c);
                    /* Exec "listutf8" Page 2 */
                    Page_2();
                    /* If u_c2<> u_c3 */
                    if (CPLib.ne(u_c2,u_c3)) {
                      /* u_nascomun := Strtran(u_nascomun,u_c,u_c2) */
                      u_nascomun = CPLib.Strtran(u_nascomun,u_c,u_c2);
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_nascomun)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_nascomun)),0);
                    } else { // Else
                      /* errore carattere eliminato nel comune di nascita non UTF8 */
                      /* _errutf8 := _errutf8+1 */
                      _errutf8 = CPLib.Round(_errutf8+1,0);
                      // * --- Insert into tmp_errpersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                      m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000101")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000101(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Carattere ELIMINATO nel comune di nascita: "+u_c+" del soggetto : "+ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                      /* _report := 1 */
                      _report = CPLib.Round(1,0);
                      /* u_nascomun := Strtran(u_nascomun,u_c,'') */
                      u_nascomun = CPLib.Strtran(u_nascomun,u_c,"");
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_nascomun)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_nascomun)),0);
                    } // End If
                  } // End If
                  /* u_i := u_i + 1 */
                  u_i = CPLib.Round(u_i+1,0);
                } // End While
                /* If u_mod=1 */
                if (CPLib.eqr(u_mod,1)) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000109")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(u_nascomun,"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore comune di nascita non UTF8 */
                /* _errutf8 := _errutf8+1 */
                _errutf8 = CPLib.Round(_errutf8+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000010C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000010C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Comune di nascita non UTF-8 di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(LibreriaMit.TestAscii(u_desccit,'UTF-8')) */
            if ( ! (LibreriaMit.TestAscii(u_desccit,"UTF-8"))) {
              /* u_mod := 0 */
              u_mod = CPLib.Round(0,0);
              /* If w_cstandard = 1 */
              if (CPLib.eqr(w_cstandard,1)) {
                /* u_i := 1 */
                u_i = CPLib.Round(1,0);
                /* u_lenfor := Len(u_desccit) */
                u_lenfor = CPLib.Round(CPLib.Len(u_desccit),0);
                /* While not(u_i>u_lenfor) */
                while ( ! (CPLib.gt(u_i,u_lenfor))) {
                  /* u_c := Substr(u_desccit,u_i,1) // carattere originale */
                  u_c = CPLib.Substr(u_desccit,u_i,1);
                  /* If not(LibreriaMit.TestAscii(u_c,'UTF-8')) */
                  if ( ! (LibreriaMit.TestAscii(u_c,"UTF-8"))) {
                    /* u_c3 := Upper(u_c) // upper del carattere originale u_c */
                    u_c3 = CPLib.Upper(u_c);
                    /* Exec "listutf8" Page 2 */
                    Page_2();
                    /* If u_c2<> u_c3 */
                    if (CPLib.ne(u_c2,u_c3)) {
                      /* u_desccit := Strtran(u_desccit,u_c,u_c2) */
                      u_desccit = CPLib.Strtran(u_desccit,u_c,u_c2);
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LTrim(u_desccit)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LTrim(u_desccit)),0);
                    } else { // Else
                      /* errore carattere eliminato nel comune di residenza non UTF8 */
                      /* _errutf8 := _errutf8+1 */
                      _errutf8 = CPLib.Round(_errutf8+1,0);
                      // * --- Insert into tmp_errpersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                      m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000011F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000011F(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Carattere ELIMINATO nel comune di residenza: "+u_c+" del soggetto : "+ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                      /* _report := 1 */
                      _report = CPLib.Round(1,0);
                      /* u_desccit := Strtran(u_desccit,u_c,'') */
                      u_desccit = CPLib.Strtran(u_desccit,u_c,"");
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LTrim(u_desccit)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LTrim(u_desccit)),0);
                    } // End If
                  } // End If
                  /* u_i := u_i + 1 */
                  u_i = CPLib.Round(u_i+1,0);
                } // End While
                /* If u_mod=1 */
                if (CPLib.eqr(u_mod,1)) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000127")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(u_desccit,"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore comune di residenza non UTF8 */
                /* _errutf8 := _errutf8+1 */
                _errutf8 = CPLib.Round(_errutf8+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000012A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000012A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Comune di residenza non UTF-8 di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(LibreriaMit.TestAscii(u_ragsoc,'UTF-8')) */
            if ( ! (LibreriaMit.TestAscii(u_ragsoc,"UTF-8"))) {
              /* u_mod := 0 */
              u_mod = CPLib.Round(0,0);
              /* If w_cstandard = 1 */
              if (CPLib.eqr(w_cstandard,1)) {
                /* u_i := 1 */
                u_i = CPLib.Round(1,0);
                /* u_lenfor := Len(u_ragsoc) */
                u_lenfor = CPLib.Round(CPLib.Len(u_ragsoc),0);
                /* While not(u_i>u_lenfor) */
                while ( ! (CPLib.gt(u_i,u_lenfor))) {
                  /* u_c := Substr(u_ragsoc,u_i,1) // carattere originale */
                  u_c = CPLib.Substr(u_ragsoc,u_i,1);
                  /* If not(LibreriaMit.TestAscii(u_c,'UTF-8')) */
                  if ( ! (LibreriaMit.TestAscii(u_c,"UTF-8"))) {
                    /* u_c3 := Upper(u_c) // upper del carattere originale u_c */
                    u_c3 = CPLib.Upper(u_c);
                    /* Exec "listutf8" Page 2 */
                    Page_2();
                    /* If u_c2<> u_c3 */
                    if (CPLib.ne(u_c2,u_c3)) {
                      /* u_ragsoc := Strtran(u_ragsoc,u_c,u_c2) */
                      u_ragsoc = CPLib.Strtran(u_ragsoc,u_c,u_c2);
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_ragsoc)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_ragsoc)),0);
                    } else { // Else
                      /* errore carattere eliminato nella ragione sociale non UTF8 */
                      /* _errutf8 := _errutf8+1 */
                      _errutf8 = CPLib.Round(_errutf8+1,0);
                      // * --- Insert into tmp_errpersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                      m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000013D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000013D(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Carattere ELIMINATO nella ragione sociale: "+u_c+" del soggetto : "+ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                      /* _report := 1 */
                      _report = CPLib.Round(1,0);
                      /* u_ragsoc := Strtran(u_ragsoc,u_c,'') */
                      u_ragsoc = CPLib.Strtran(u_ragsoc,u_c,"");
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_ragsoc)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_ragsoc)),0);
                    } // End If
                  } // End If
                  /* u_i := u_i + 1 */
                  u_i = CPLib.Round(u_i+1,0);
                } // End While
                /* If u_mod=1 */
                if (CPLib.eqr(u_mod,1)) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000145")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(u_ragsoc,"C",70,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore ragione sociale non UTF8 */
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000147")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000147(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Ragione sociale non UTF-8 di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(LibreriaMit.TestAscii(u_nome,'UTF-8')) */
            if ( ! (LibreriaMit.TestAscii(u_nome,"UTF-8"))) {
              /* u_mod := 0 */
              u_mod = CPLib.Round(0,0);
              /* If w_cstandard = 1 */
              if (CPLib.eqr(w_cstandard,1)) {
                /* u_i := 1 */
                u_i = CPLib.Round(1,0);
                /* u_lenfor := Len(u_nome) */
                u_lenfor = CPLib.Round(CPLib.Len(u_nome),0);
                /* While not(u_i>u_lenfor) */
                while ( ! (CPLib.gt(u_i,u_lenfor))) {
                  /* u_c := Substr(u_nome,u_i,1) // carattere originale */
                  u_c = CPLib.Substr(u_nome,u_i,1);
                  /* If not(LibreriaMit.TestAscii(u_c,'UTF-8')) */
                  if ( ! (LibreriaMit.TestAscii(u_c,"UTF-8"))) {
                    /* u_c3 := Upper(u_c) // upper del carattere originale u_c */
                    u_c3 = CPLib.Upper(u_c);
                    /* Exec "listutf8" Page 2 */
                    Page_2();
                    /* If u_c2<> u_c3 */
                    if (CPLib.ne(u_c2,u_c3)) {
                      /* u_nome := Strtran(u_nome,u_c,u_c2) */
                      u_nome = CPLib.Strtran(u_nome,u_c,u_c2);
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_nome)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_nome)),0);
                    } else { // Else
                      /* errore carattere eliminato nel nome non UTF8 */
                      /* _errutf8 := _errutf8+1 */
                      _errutf8 = CPLib.Round(_errutf8+1,0);
                      // * --- Insert into tmp_errpersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                      m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"0000015A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000015A(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Carattere ELIMINATO nel nome: "+u_c+" del soggetto : "+ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                      /* _report := 1 */
                      _report = CPLib.Round(1,0);
                      /* u_nome := Strtran(u_nome,u_c,'') */
                      u_nome = CPLib.Strtran(u_nome,u_c,"");
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_nome)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_nome)),0);
                    } // End If
                  } // End If
                  /* u_i := u_i + 1 */
                  u_i = CPLib.Round(u_i+1,0);
                } // End While
                /* If u_mod=1 */
                if (CPLib.eqr(u_mod,1)) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000162")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(u_nome,"C",25,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore nome non UTF8 */
                /* _errutf8 := _errutf8+1 */
                _errutf8 = CPLib.Round(_errutf8+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000165")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000165(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Nome non UTF-8 di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(LibreriaMit.TestAscii(u_cognome,'UTF-8')) */
            if ( ! (LibreriaMit.TestAscii(u_cognome,"UTF-8"))) {
              /* u_mod := 0 */
              u_mod = CPLib.Round(0,0);
              /* If w_cstandard = 1 */
              if (CPLib.eqr(w_cstandard,1)) {
                /* u_i := 1 */
                u_i = CPLib.Round(1,0);
                /* u_lenfor := Len(u_cognome) */
                u_lenfor = CPLib.Round(CPLib.Len(u_cognome),0);
                /* While not(u_i>u_lenfor) */
                while ( ! (CPLib.gt(u_i,u_lenfor))) {
                  /* u_c := Substr(u_cognome,u_i,1) // carattere originale */
                  u_c = CPLib.Substr(u_cognome,u_i,1);
                  /* If not(LibreriaMit.TestAscii(u_c,'UTF-8')) */
                  if ( ! (LibreriaMit.TestAscii(u_c,"UTF-8"))) {
                    /* u_c3 := Upper(u_c) // upper del carattere originale u_c */
                    u_c3 = CPLib.Upper(u_c);
                    /* Exec "listutf8" Page 2 */
                    Page_2();
                    /* If u_c2<> u_c3 */
                    if (CPLib.ne(u_c2,u_c3)) {
                      /* u_cognome := Strtran(u_cognome,u_c,u_c2) */
                      u_cognome = CPLib.Strtran(u_cognome,u_c,u_c2);
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_cognome)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_cognome)),0);
                    } else { // Else
                      /* errore carattere eliminato nel cognome non UTF8 */
                      /* _errutf8 := _errutf8+1 */
                      _errutf8 = CPLib.Round(_errutf8+1,0);
                      // * --- Insert into tmp_errpersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                      m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000178")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000178(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Carattere ELIMINATO nel cognome: "+u_c+" del soggetto : "+ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                      /* _report := 1 */
                      _report = CPLib.Round(1,0);
                      /* u_cognome := Strtran(u_cognome,u_c,'') */
                      u_cognome = CPLib.Strtran(u_cognome,u_c,"");
                      /* w_c_utf8 := w_c_utf8 + 1 */
                      w_c_utf8 = CPLib.Round(w_c_utf8+1,0);
                      /* u_mod := 1 */
                      u_mod = CPLib.Round(1,0);
                      /* u_lenfor := Len(LRTrim(u_cognome)) */
                      u_lenfor = CPLib.Round(CPLib.Len(CPLib.LRTrim(u_cognome)),0);
                    } // End If
                  } // End If
                  /* u_i := u_i + 1 */
                  u_i = CPLib.Round(u_i+1,0);
                } // End While
                /* If u_mod=1 */
                if (CPLib.eqr(u_mod,1)) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000180")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(u_cognome,"C",26,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
              } else { // Else
                /* errore cognome non UTF8 */
                /* _errutf8 := _errutf8+1 */
                _errutf8 = CPLib.Round(_errutf8+1,0);
                // * --- Insert into tmp_errpersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_errpersonbo");
                m_cPhName = m_Ctx.GetPhName("tmp_errpersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errpersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000183")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000183(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Cognome non UTF-8 di: "+ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("utf","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errutf8,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_errutf8,15,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errpersonbo",true);
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
                /* _report := 1 */
                _report = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
          /* If cabok=1 and cfok=1 and utf8ok=1 */
          if (CPLib.eqr(cabok,1) && CPLib.eqr(cfok,1) && CPLib.eqr(utf8ok,1)) {
            /* tutto ok, quindi imposto ALLINEATO a 1 */
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche",125,"00000187")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ALLINEATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"?",0,0,m_cServer),m_cServer,connes)+"";
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
          /* gMsgProc := _mini + 'Sono stati allineati: '  + NL + NL // Messaggio */
          gMsgProc = _mini+"Sono stati allineati: "+"\n"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Comuni: '+LRTrim(Str(w_a_comuni,10,0)) + NL // Messaggio */
          gMsgProc = gMsgProc+"Comuni: "+CPLib.LRTrim(CPLib.Str(w_a_comuni,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Codici Fiscali: '+ LRTrim(Str(w_b_cf,10,0)) + NL // Messaggio */
          gMsgProc = gMsgProc+"Codici Fiscali: "+CPLib.LRTrim(CPLib.Str(w_b_cf,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'UTF8: '+LRTrim(Str(w_c_utf8,10,0)) + NL // Messaggio */
          gMsgProc = gMsgProc+"UTF8: "+CPLib.LRTrim(CPLib.Str(w_c_utf8,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Analizzati: '+LRTrim(Str(w_d_totali,10,0)) + NL + NL // Messaggio */
          gMsgProc = gMsgProc+"Analizzati: "+CPLib.LRTrim(CPLib.Str(w_d_totali,10,0))+"\n"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gReport := _report // Bottone Stampe */
      gReport = CPLib.Round(_report,0);
      m_Ctx.SetGlobalNumber("gReport",gReport);
      /* gMsgAll := 'Fine elaborazione. Sono stati elaborati '+LRTrim(Str(_contar,10,0))+' nominativi. 100%' // Messaggio allineamento 1 */
      gMsgAll = "Fine elaborazione. Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contar,10,0))+" nominativi. 100%";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
    } finally {
      try {
        if (Cursor_qbe_max_personbo!=null)
          Cursor_qbe_max_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
    }
  }
  void Page_2() throws Exception {
    /* Case u_c3="Ç" */
    if (CPLib.eqr(u_c3,"Ç")) {
      /* u_c2 := "C" // carattere modificato */
      u_c2 = "C";
      /* Case At(u_c3,"ÄÅÂÃ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÄÅÂÃ"),0)) {
      /* u_c2 := "A" // carattere modificato */
      u_c2 = "A";
      /* Case At(u_c3,"ÀÁ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÀÁ"),0)) {
      /* u_c2 := "A'" // carattere modificato */
      u_c2 = "A'";
      /* Case At(u_c3,"ÊË")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÊË"),0)) {
      /* u_c2 := "E" // carattere modificato */
      u_c2 = "E";
      /* Case At(u_c3,"ÈÉ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÈÉ"),0)) {
      /* u_c2 := "E'" // carattere modificato */
      u_c2 = "E'";
      /* Case At(u_c3,"ÎÏ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÎÏ"),0)) {
      /* u_c2 := "I" // carattere modificato */
      u_c2 = "I";
      /* Case At(u_c3,"ÌÍ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÌÍ"),0)) {
      /* u_c2 := "I'" // carattere modificato */
      u_c2 = "I'";
      /* Case At(u_c3,"ÔÕÖ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÔÕÖ"),0)) {
      /* u_c2 := "O" // carattere modificato */
      u_c2 = "O";
      /* Case At(u_c3,"ÒÓ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÒÓ"),0)) {
      /* u_c2 := "O'" // carattere modificato */
      u_c2 = "O'";
      /* Case At(u_c3,"ÛÜ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"ÛÜ"),0)) {
      /* u_c2 := "U" // carattere modificato */
      u_c2 = "U";
      /* Case At(u_c3,"Ù")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"Ù"),0)) {
      /* u_c2 := "U'" // carattere modificato */
      u_c2 = "U'";
      /* Case At(u_c3,"Ý")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"Ý"),0)) {
      /* u_c2 := "Y'" // carattere modificato */
      u_c2 = "Y'";
      /* Case At(u_c3,"Ñ")>0 */
    } else if (CPLib.gt(CPLib.At(u_c3,"Ñ"),0)) {
      /* u_c2 := "N" // carattere modificato */
      u_c2 = "N";
    } else { // Otherwise
      /* se non trovo nulla ci rimetto l'originale per il confronto */
      /* u_c2 := u_c3 // carattere modificato */
      u_c2 = u_c3;
    } // End Case
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
      m_Caller.SetNumber("ccab","N",1,0,w_ccab);
      m_Caller.SetNumber("ccodfisc","N",1,0,w_ccodfisc);
      m_Caller.SetString("rvalcampi","C",1,0,w_rvalcampi);
      m_Caller.SetNumber("cutf8","N",1,0,w_cutf8);
      m_Caller.SetNumber("cstandard","N",10,0,w_cstandard);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_allinea_anagraficheR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_anagraficheR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_ccab = m_Caller.GetNumber("ccab","N",1,0);
    w_ccodfisc = m_Caller.GetNumber("ccodfisc","N",1,0);
    w_rvalcampi = m_Caller.GetString("rvalcampi","C",1,0);
    w_cutf8 = m_Caller.GetNumber("cutf8","N",1,0);
    w_cstandard = m_Caller.GetNumber("cstandard","N",10,0);
    connes = CPLib.Space(10);
    ragsoc = CPLib.Space(70);
    errori = 0;
    _max = 0;
    _cnt = 0;
    _cicli = 0;
    _conta = 0;
    _top = 0;
    _bottom = 0;
    _contar = 0;
    _errcabnofind = 0;
    _errnocab = 0;
    _errcfnocorretto = 0;
    _errcfnocomune = 0;
    _errutf8 = 0;
    _report = 0;
    w_a_comuni = 0;
    w_b_cf = 0;
    w_c_utf8 = 0;
    w_d_totali = 0;
    _mini = CPLib.Space(120);
    cab_citta = CPLib.Space(30);
    cab_cap = CPLib.Space(9);
    cab_prov = CPLib.Space(2);
    cab_stato = CPLib.Space(3);
    cab2_citta = CPLib.Space(30);
    cab2_cap = CPLib.Space(9);
    cab2_prov = CPLib.Space(2);
    cab2_stato = CPLib.Space(3);
    cf_oggi = CPLib.Space(4);
    cf_decennio = CPLib.Space(2);
    cf_datanasc = CPLib.NullDate();
    cf_anno = CPLib.Space(4);
    cf_mese = CPLib.Space(2);
    cf_asc = 0;
    cf_giorno = CPLib.Space(2);
    cf_sesso = CPLib.Space(1);
    cf_sigla = CPLib.Space(4);
    cf_citta = CPLib.Space(30);
    cf_prov = CPLib.Space(2);
    cf_stato = CPLib.Space(30);
    cf2_datanasc = CPLib.NullDate();
    cf2_sesso = CPLib.Space(1);
    cf2_citta = CPLib.Space(30);
    cf2_prov = CPLib.Space(2);
    cf2_stato = CPLib.Space(30);
    u_nascomun = CPLib.Space(30);
    u_desccit = CPLib.Space(30);
    u_ragsoc = CPLib.Space(70);
    u_nome = CPLib.Space(25);
    u_cognome = CPLib.Space(26);
    u_c = CPLib.Space(1);
    u_c2 = CPLib.Space(1);
    u_c3 = CPLib.Space(1);
    u_i = 0;
    u_lenfor = 0;
    u_mod = 0;
    cabok = 0;
    cfok = 0;
    utf8ok = 0;
    gMsgAll=m_Ctx.GetGlobalString("gMsgAll");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gReport=m_Ctx.GetGlobalNumber("gReport");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_max_personbo,
  public static final String m_cVQRList = ",qbe_max_personbo,";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000082(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000096(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000101(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000013D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000147(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000165(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000178(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000183(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"tipo,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"PROGERRORE,";
    p_cSql = p_cSql+"PROGERR_C,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errpersonbo",true);
    return p_cSql;
  }
}
