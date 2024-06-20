// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_crea_mass_cfR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
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
  public String w_tiposog;
  public String w_tipoinv;
  public double w_maxinvii;
  public String w_a2013;
  public String w_a2014;
  public String w_a2015;
  public String w_a2016;
  public String w_a2017;
  public String w_a2018;
  public String w_a2019;
  public String w_a2020;
  public String w_a2021;
  public String w_a2022;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  public String gIntemediario;
  public String gPathDoc;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String _mese;
  public String _riga;
  public String _filtroanni;
  public String w_Orderby;
  public String _blocco;
  public double _contarec;
  public double _tipo1;
  public double _tipo2;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public String _oldmsg;
  public double _reccount;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _cfint;
  public String _rsint;
  public String _codint;
  public double _contarighe;
  public double _contat1;
  public double _contat2;
  public MemoryCursor_mcmessaggi_mcrdef _sid;
  public double _maxrig;
  public String cRitorno;
  public String _newline;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_crea_mass_cfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_crea_mass_cf",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("maxinvii",p_cVarName)) {
      return w_maxinvii;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      return _tipo1;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      return _tipo2;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_contarighe",p_cVarName)) {
      return _contarighe;
    }
    if (CPLib.eqr("_contat1",p_cVarName)) {
      return _contat1;
    }
    if (CPLib.eqr("_contat2",p_cVarName)) {
      return _contat2;
    }
    if (CPLib.eqr("_maxrig",p_cVarName)) {
      return _maxrig;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_crea_mass_cf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tiposog",p_cVarName)) {
      return w_tiposog;
    }
    if (CPLib.eqr("tipoinv",p_cVarName)) {
      return w_tipoinv;
    }
    if (CPLib.eqr("a2013",p_cVarName)) {
      return w_a2013;
    }
    if (CPLib.eqr("a2014",p_cVarName)) {
      return w_a2014;
    }
    if (CPLib.eqr("a2015",p_cVarName)) {
      return w_a2015;
    }
    if (CPLib.eqr("a2016",p_cVarName)) {
      return w_a2016;
    }
    if (CPLib.eqr("a2017",p_cVarName)) {
      return w_a2017;
    }
    if (CPLib.eqr("a2018",p_cVarName)) {
      return w_a2018;
    }
    if (CPLib.eqr("a2019",p_cVarName)) {
      return w_a2019;
    }
    if (CPLib.eqr("a2020",p_cVarName)) {
      return w_a2020;
    }
    if (CPLib.eqr("a2021",p_cVarName)) {
      return w_a2021;
    }
    if (CPLib.eqr("a2022",p_cVarName)) {
      return w_a2022;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_filtroanni",p_cVarName)) {
      return _filtroanni;
    }
    if (CPLib.eqr("Orderby",p_cVarName)) {
      return w_Orderby;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      return _blocco;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      return _cfint;
    }
    if (CPLib.eqr("_rsint",p_cVarName)) {
      return _rsint;
    }
    if (CPLib.eqr("_codint",p_cVarName)) {
      return _codint;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_newline",p_cVarName)) {
      return _newline;
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
    if (CPLib.eqr("_sid",p_cVarName)) {
      return _sid;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("maxinvii",p_cVarName)) {
      w_maxinvii = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      _tipo1 = value;
      return;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      _tipo2 = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_contarighe",p_cVarName)) {
      _contarighe = value;
      return;
    }
    if (CPLib.eqr("_contat1",p_cVarName)) {
      _contat1 = value;
      return;
    }
    if (CPLib.eqr("_contat2",p_cVarName)) {
      _contat2 = value;
      return;
    }
    if (CPLib.eqr("_maxrig",p_cVarName)) {
      _maxrig = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tiposog",p_cVarName)) {
      w_tiposog = value;
      return;
    }
    if (CPLib.eqr("tipoinv",p_cVarName)) {
      w_tipoinv = value;
      return;
    }
    if (CPLib.eqr("a2013",p_cVarName)) {
      w_a2013 = value;
      return;
    }
    if (CPLib.eqr("a2014",p_cVarName)) {
      w_a2014 = value;
      return;
    }
    if (CPLib.eqr("a2015",p_cVarName)) {
      w_a2015 = value;
      return;
    }
    if (CPLib.eqr("a2016",p_cVarName)) {
      w_a2016 = value;
      return;
    }
    if (CPLib.eqr("a2017",p_cVarName)) {
      w_a2017 = value;
      return;
    }
    if (CPLib.eqr("a2018",p_cVarName)) {
      w_a2018 = value;
      return;
    }
    if (CPLib.eqr("a2019",p_cVarName)) {
      w_a2019 = value;
      return;
    }
    if (CPLib.eqr("a2020",p_cVarName)) {
      w_a2020 = value;
      return;
    }
    if (CPLib.eqr("a2021",p_cVarName)) {
      w_a2021 = value;
      return;
    }
    if (CPLib.eqr("a2022",p_cVarName)) {
      w_a2022 = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_filtroanni",p_cVarName)) {
      _filtroanni = value;
      return;
    }
    if (CPLib.eqr("Orderby",p_cVarName)) {
      w_Orderby = value;
      return;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      _blocco = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      _cfint = value;
      return;
    }
    if (CPLib.eqr("_rsint",p_cVarName)) {
      _rsint = value;
      return;
    }
    if (CPLib.eqr("_codint",p_cVarName)) {
      _codint = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_newline",p_cVarName)) {
      _newline = value;
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
    if (CPLib.eqr("_sid",p_cVarName)) {
      _sid = (MemoryCursor_mcmessaggi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_tiposog Char(1) */
      /* w_tipoinv Char(1) */
      /* w_maxinvii Numeric(10, 0) // N. Massimo Invii Effettuabili */
      /* w_a2013 Char(1) */
      /* w_a2014 Char(1) */
      /* w_a2015 Char(1) */
      /* w_a2016 Char(1) */
      /* w_a2017 Char(1) */
      /* w_a2018 Char(1) */
      /* w_a2019 Char(1) */
      /* w_a2020 Char(1) */
      /* w_a2021 Char(1) */
      /* w_a2022 Char(1) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gPathDoc Char(128) // Path Documenti */
      /* fhand Char(10) */
      /* _nomefile Char(10) */
      /* cNomeFile Char(100) */
      /* _mese Char(2) */
      /* _riga Char(300) */
      /* _filtroanni Char(128) */
      /* w_Orderby Char(30) */
      /* _blocco Char(1) */
      /* _contarec Numeric(10, 0) */
      /* _tipo1 Numeric(1, 0) */
      /* _tipo2 Numeric(1, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _oldmsg Char(100) */
      /* _reccount Numeric(0, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cfint Char(16) */
      /* _rsint Char(70) */
      /* _codint Char(15) */
      /* _contarighe Numeric(6, 0) */
      /* _contat1 Numeric(6, 0) */
      /* _contat2 Numeric(6, 0) */
      /* _sid MemoryCursor(mcMessaggi.MCRDef) // Errori del sid */
      /* _maxrig Numeric(6, 0) */
      /* cRitorno Char(50) */
      /* _newline Char(6) */
      /* cRitorno := 'OK' */
      cRitorno = "OK";
      /* If w_tipoinv <> 'G' and w_maxinvii = 0 */
      if (CPLib.ne(w_tipoinv,"G") && CPLib.eqr(w_maxinvii,0)) {
        /* cRitorno := "E' obbligatorio calcolare il numero massimo di invii. Elaborazione Abortita!" // Messaggio Import */
        cRitorno = "E' obbligatorio calcolare il numero massimo di invii. Elaborazione Abortita!";
        /* ElseIf w_tipoinv = 'G' and w_tiposog <> 'T' */
      } else if (CPLib.eqr(w_tipoinv,"G") && CPLib.ne(w_tiposog,"T")) {
        /* cRitorno := "Possibile selezionate solo la tipologia TUTTI. Elaborazione Abortita!" // Messaggio Import */
        cRitorno = "Possibile selezionate solo la tipologia TUTTI. Elaborazione Abortita!";
        /* ElseIf w_tipoinv <> 'S' and At(w_tiposog,'|1|2') <> 0 */
      } else if (CPLib.ne(w_tipoinv,"S") && CPLib.ne(CPLib.At(w_tiposog,"|1|2"),0)) {
        /* cRitorno := "Tipo soggetti con ordinamento (prima con o senza) valido solo per INVII SUCCESSIVI. Elaborazione Abortita!" // Messaggio Import */
        cRitorno = "Tipo soggetti con ordinamento (prima con o senza) valido solo per INVII SUCCESSIVI. Elaborazione Abortita!";
      } else { // Else
        // * --- Drop temporary table tmp_listafile
        if (m_Ctx.IsSharedTemp("tmp_listafile")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listafile");
        }
        // * --- Create temporary table tmp_listafile
        if (m_Ctx.IsSharedTemp("tmp_listafile")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listafile");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
        if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
        }
        m_cPhName_tmp_listafile = m_cPhName;
        /* If At(w_tiposog,'|T|1|2') <> 0 */
        if (CPLib.ne(CPLib.At(w_tiposog,"|T|1|2"),0)) {
          /* _tipo1 := 1 */
          _tipo1 = CPLib.Round(1,0);
          /* _tipo2 := 0 */
          _tipo2 = CPLib.Round(0,0);
          /* ElseIf w_tiposog='E' */
        } else if (CPLib.eqr(w_tiposog,"E")) {
          /* _tipo1 := 1 */
          _tipo1 = CPLib.Round(1,0);
          /* _tipo2 := 1 */
          _tipo2 = CPLib.Round(1,0);
        } else { // Else
          /* _tipo1 := 0 */
          _tipo1 = CPLib.Round(0,0);
          /* _tipo2 := 0 */
          _tipo2 = CPLib.Round(0,0);
        } // End If
        /* _filtroanni := '' */
        _filtroanni = "";
        /* If w_a2013='S' */
        if (CPLib.eqr(w_a2013,"S")) {
          /* _filtroanni := _filtroanni + "'2013'," */
          _filtroanni = _filtroanni+"'2013',";
        } // End If
        /* If w_a2014='S' */
        if (CPLib.eqr(w_a2014,"S")) {
          /* _filtroanni := _filtroanni + "'2014'," */
          _filtroanni = _filtroanni+"'2014',";
        } // End If
        /* If w_a2015='S' */
        if (CPLib.eqr(w_a2015,"S")) {
          /* _filtroanni := _filtroanni + "'2015'," */
          _filtroanni = _filtroanni+"'2015',";
        } // End If
        /* If w_a2016='S' */
        if (CPLib.eqr(w_a2016,"S")) {
          /* _filtroanni := _filtroanni + "'2016'," */
          _filtroanni = _filtroanni+"'2016',";
        } // End If
        /* If w_a2017='S' */
        if (CPLib.eqr(w_a2017,"S")) {
          /* _filtroanni := _filtroanni + "'2017'," */
          _filtroanni = _filtroanni+"'2017',";
        } // End If
        /* If w_a2018='S' */
        if (CPLib.eqr(w_a2018,"S")) {
          /* _filtroanni := _filtroanni + "'2018'," */
          _filtroanni = _filtroanni+"'2018',";
        } // End If
        /* If w_a2019='S' */
        if (CPLib.eqr(w_a2019,"S")) {
          /* _filtroanni := _filtroanni + "'2019'," */
          _filtroanni = _filtroanni+"'2019',";
        } // End If
        /* If w_a2020='S' */
        if (CPLib.eqr(w_a2020,"S")) {
          /* _filtroanni := _filtroanni + "'2020'," */
          _filtroanni = _filtroanni+"'2020',";
        } // End If
        /* If w_a2021='S' */
        if (CPLib.eqr(w_a2021,"S")) {
          /* _filtroanni := _filtroanni + "'2021'," */
          _filtroanni = _filtroanni+"'2021',";
        } // End If
        /* If w_a2022='S' */
        if (CPLib.eqr(w_a2022,"S")) {
          /* _filtroanni := _filtroanni + "'2022'," */
          _filtroanni = _filtroanni+"'2022',";
        } // End If
        /* _filtroanni := iif(Len(LRTrim(_filtroanni)) > 0,Left(_filtroanni,Len(LRTrim(_filtroanni))-1),'') */
        _filtroanni = (CPLib.gt(CPLib.Len(CPLib.LRTrim(_filtroanni)),0)?CPLib.Left(_filtroanni,CPLib.Len(CPLib.LRTrim(_filtroanni))-1):"");
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODFISC,RAGSOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _cfint := intermbo->CODFISC */
          _cfint = Cursor_intermbo.GetString("CODFISC");
          /* _rsint := intermbo->RAGSOC */
          _rsint = Cursor_intermbo.GetString("RAGSOC");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _maxrig := 100001 */
        _maxrig = CPLib.Round(100001,0);
        /* w_Orderby := iif(w_tiposog='1','CFESTERO desc',iif(w_tiposog='2','CFESTERO','')) */
        w_Orderby = (CPLib.eqr(w_tiposog,"1")?"CFESTERO desc":(CPLib.eqr(w_tiposog,"2")?"CFESTERO":""));
        /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If Empty(_filtroanni) */
        if (CPLib.Empty(_filtroanni)) {
          /* Exec "Crea File Globale" Page 2:Page_2 */
          Page_2();
        } else { // Else
          /* Exec "Crea File parziale" Page 3:Page_3 */
          Page_3();
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_mass_cf_min_max=null;
    CPResultSet Cursor_qbe_mass_cf=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbstati=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      // * --- Select from qbe_mass_cf_min_max
      SPBridge.HMCaller _h0000006E;
      _h0000006E = new SPBridge.HMCaller();
      _h0000006E.Set("m_cVQRList",m_cVQRList);
      _h0000006E.Set("pEstero1",_tipo1);
      _h0000006E.Set("pEstero2",_tipo2);
      if (Cursor_qbe_mass_cf_min_max!=null)
        Cursor_qbe_mass_cf_min_max.Close();
      Cursor_qbe_mass_cf_min_max = new VQRHolder("qbe_mass_cf_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_mass_cf_min_max.Eof())) {
        /* _min := qbe_mass_cf_min_max->MINSOG */
        _min = CPLib.Round(Cursor_qbe_mass_cf_min_max.GetDouble("MINSOG"),0);
        /* _max := qbe_mass_cf_min_max->MAXSOG */
        _max = CPLib.Round(Cursor_qbe_mass_cf_min_max.GetDouble("MAXSOG"),0);
        /* _tot := qbe_mass_cf_min_max->TOTSOG */
        _tot = CPLib.Round(Cursor_qbe_mass_cf_min_max.GetDouble("TOTSOG"),0);
        Cursor_qbe_mass_cf_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_mass_cf_min_max.ErrorMessage();
      Cursor_qbe_mass_cf_min_max.Close();
      // * --- End Select
      /* If _tot > 0 */
      if (CPLib.gt(_tot,0)) {
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _oldmsg := '' */
        _oldmsg = "";
        /* _mono := iif(_tot > 5000,0,1) */
        _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* If _tot = 0 */
          if (CPLib.eqr(_tot,0)) {
            /* _cicli := 0 */
            _cicli = CPLib.Round(0,0);
          } else { // Else
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } // End If
        } else { // Else
          /* _reccount := _max - _min */
          _reccount = CPLib.Round(_max-_min,0);
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* _nomefile := LRTrim(gIntemediario)+"_MASSCF_"+DateTimeToChar(DateTime()) */
        _nomefile = CPLib.LRTrim(gIntemediario)+"_MASSCF_"+CPLib.DateTimeToChar(CPLib.DateTime());
        /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/SID/MASSCF/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
        fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
        /* _riga := '0'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+DateTimeToChar(DateTime())+Space(138)+'SM1.02'+Space(4)+Space(60)+'A'+NL */
        _riga = "0"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.DateTimeToChar(CPLib.DateTime())+CPLib.Space(138)+"SM1.02"+CPLib.Space(4)+CPLib.Space(60)+"A"+"\n";
        /* FileLibMit.Write(fhand,_riga) */
        FileLibMit.Write(fhand,_riga);
        /* _contarighe := 1 */
        _contarighe = CPLib.Round(1,0);
        /* _contat1 := 0 */
        _contat1 = CPLib.Round(0,0);
        /* _contat2 := 0 */
        _contat2 = CPLib.Round(0,0);
        /* _contarec := 0 */
        _contarec = CPLib.Round(0,0);
        /* While _contacicli <= _cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _contacicli=1 */
            if (CPLib.eqr(_contacicli,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _contacicli = _cicli */
            } else if (CPLib.eqr(_contacicli,_cicli)) {
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _bottom + 999 */
              _top = CPLib.Round(_bottom+999,0);
            } // End If
          } // End If
          /* gMsgImp := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) + NL // Messaggio */
            gMsgProc = gMsgProc+"Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,LRTrim(gMsgImp)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,CPLib.LRTrim(gMsgImp));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
          _oldmsg = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_mass_cf
            SPBridge.HMCaller _h0000009A;
            _h0000009A = new SPBridge.HMCaller();
            _h0000009A.Set("m_cVQRList",m_cVQRList);
            _h0000009A.Set("pEstero1",_tipo1);
            _h0000009A.Set("pEstero2",_tipo2);
            _h0000009A.Set("_bottom",_bottom);
            _h0000009A.Set("_top",_top);
            _h0000009A.Set("OrderBy",w_Orderby);
            if (Cursor_qbe_mass_cf!=null)
              Cursor_qbe_mass_cf.Close();
            Cursor_qbe_mass_cf = new VQRHolder("qbe_mass_cf",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009A,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_mass_cf.Eof())) {
              /* gMsgImp := 'Elaboro il soggetto->'+LRTrim(qbe_mass_cf->COGNOME)+" "+LRTrim(qbe_mass_cf->NOME) // Messaggio Import */
              gMsgImp = "Elaboro il soggetto->"+CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("NOME"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _codint := Right('000000000000000'+LRTrim(Str(qbe_mass_cf->PROGIMPORT,15,0)),15) */
              _codint = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_mass_cf.GetDouble("PROGIMPORT"),15,0)),15);
              /* If w_tipoinv='G' */
              if (CPLib.eqr(w_tipoinv,"G")) {
                /* _blocco := 'N' */
                _blocco = "N";
              } else { // Else
                /* _blocco := '' */
                _blocco = "";
                // * --- Read from personbo_agg
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_mass_cf.GetString("CONNES"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_mass_cf.GetString("CONNES"));
                if (m_Ctx.IsSharedTemp("personbo_agg")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGVALIDO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _blocco = Read_Cursor.GetString("FLGVALIDO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_crea_mass_cf returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _blocco = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If _blocco='N' or Empty(_blocco) */
              if (CPLib.eqr(_blocco,"N") || CPLib.Empty(_blocco)) {
                /* If Empty(qbe_mass_cf->SESSO) */
                if (CPLib.Empty(Cursor_qbe_mass_cf.GetString("SESSO"))) {
                  /* If qbe_mass_cf->CFESTERO=1 */
                  if (CPLib.eqr(Cursor_qbe_mass_cf.GetDouble("CFESTERO"),1)) {
                    /* _riga := '2'+_codint+Space(11)+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf->RAGSOC),150)+Space(4) */
                    _riga = "2"+_codint+CPLib.Space(11)+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("RAGSOC")),150)+CPLib.Space(4);
                    /* If qbe_mass_cf->PROVINCIA='EE' */
                    if (CPLib.eqr(Cursor_qbe_mass_cf.GetString("PROVINCIA"),"EE")) {
                      // * --- Select from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      if (Cursor_tbstati!=null)
                        Cursor_tbstati.Close();
                      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DESCRI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSTA="+CPLib.ToSQL(Cursor_qbe_mass_cf.GetString("PAESE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbstati")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_tbstati.Eof())) {
                        /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(tbstati->DESCRI),45) */
                        _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_tbstati.GetString("DESCRI")),45);
                        Cursor_tbstati.Next();
                      }
                      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
                      Cursor_tbstati.Close();
                      // * --- End Select
                    } else { // Else
                      /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf->DESCCIT),45) */
                      _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("DESCCIT")),45);
                    } // End If
                    /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf->TIPINTER),2)+Space(71)+"A"+LibreriaMit.CloseLine() */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("TIPINTER")),2)+CPLib.Space(71)+"A"+LibreriaMit.CloseLine();
                  } else { // Else
                    /* _riga := '2'+_codint+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf->CODFISC),11)+Space(150)+Space(51)+Space(71)+"A"+LibreriaMit.CloseLine() */
                    _riga = "2"+_codint+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("CODFISC")),11)+CPLib.Space(150)+CPLib.Space(51)+CPLib.Space(71)+"A"+LibreriaMit.CloseLine();
                  } // End If
                  /* _contat2 := _contat2 + 1 */
                  _contat2 = CPLib.Round(_contat2+1,0);
                } else { // Else
                  /* If qbe_mass_cf->CFESTERO=1 or not(arfn_chkcodfis(Upper(qbe_mass_cf->CODFISC),qbe_mass_cf->PAESE,qbe_mass_cf->CFESTERO)) */
                  if (CPLib.eqr(Cursor_qbe_mass_cf.GetDouble("CFESTERO"),1) ||  ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf.GetString("CODFISC")),Cursor_qbe_mass_cf.GetString("PAESE"),Cursor_qbe_mass_cf.GetDouble("CFESTERO")))) {
                    /* _riga := '1'+_codint+Space(16) */
                    _riga = "1"+_codint+CPLib.Space(16);
                    /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf->COGNOME)," ")),40) */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf.GetString("COGNOME"))," ")),40);
                    /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf->NOME)," ")),40) */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf.GetString("NOME"))," ")),40);
                    /* _riga := _riga+iif(qbe_mass_cf->SESSO='1','M',iif(qbe_mass_cf->SESSO='2','F',' ')) */
                    _riga = _riga+(CPLib.eqr(Cursor_qbe_mass_cf.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_qbe_mass_cf.GetString("SESSO"),"2")?"F":" "));
                    /* _riga := _riga+arfn_fdate_nd(qbe_mass_cf->DATANASC,'S')+Space(4) */
                    _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_qbe_mass_cf.GetDate("DATANASC"),"S")+CPLib.Space(4);
                    /* _riga := _riga+iif(qbe_mass_cf->TIPINTER='EE',LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf->NASSTATO)," ")),45),LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf->NASCOMUN)," ")),45)) */
                    _riga = _riga+(CPLib.eqr(Cursor_qbe_mass_cf.GetString("TIPINTER"),"EE")?LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf.GetString("NASSTATO"))," ")),45):LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf.GetString("NASCOMUN"))," ")),45));
                    /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf->TIPINTER),2)+Space(127)+"A"+LibreriaMit.CloseLine() */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf.GetString("TIPINTER")),2)+CPLib.Space(127)+"A"+LibreriaMit.CloseLine();
                  } else { // Else
                    /* _riga := '1'+_codint+LibreriaMit.SpacePad(LRTrim(Upper(qbe_mass_cf->CODFISC)),16)+Space(81)+"00000000"+Space(51)+Space(127)+"A"+LibreriaMit.CloseLine() */
                    _riga = "1"+_codint+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(Cursor_qbe_mass_cf.GetString("CODFISC"))),16)+CPLib.Space(81)+"00000000"+CPLib.Space(51)+CPLib.Space(127)+"A"+LibreriaMit.CloseLine();
                  } // End If
                  /* _contat1 := _contat1 + 1 */
                  _contat1 = CPLib.Round(_contat1+1,0);
                } // End If
                /* FileLibMit.Write(fhand,_riga) */
                FileLibMit.Write(fhand,_riga);
                /* _contarighe := _contarighe + 1 */
                _contarighe = CPLib.Round(_contarighe+1,0);
                /* _contarec := _contarec + 1 */
                _contarec = CPLib.Round(_contarec+1,0);
                /* If _contarec = w_maxinvii and w_tipoinv <> 'G' */
                if (CPLib.eqr(_contarec,w_maxinvii) && CPLib.ne(w_tipoinv,"G")) {
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } // End If
                /* If _contarighe=_maxrig */
                if (CPLib.eqr(_contarighe,_maxrig)) {
                  /* _contarighe := _contarighe + 1 */
                  _contarighe = CPLib.Round(_contarighe+1,0);
                  /* _riga := '9'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+Space(152)+'SM1.02'+Space(4) */
                  _riga = "9"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.Space(152)+"SM1.02"+CPLib.Space(4);
                  /* _riga := _riga+Right('000000'+LRTrim(Str(_contarighe,6,0)),6)+Right('000000'+LRTrim(Str(_contat1,6,0)),6)+Right('000000'+LRTrim(Str(_contat2,6,0)),6)+Space(42)+'A'+NL */
                  _riga = _riga+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contarighe,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat1,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat2,6,0)),6)+CPLib.Space(42)+"A"+"\n";
                  /* FileLibMit.Write(fhand,_riga) */
                  FileLibMit.Write(fhand,_riga);
                  /* FileLibMit.Close(fhand) */
                  FileLibMit.Close(fhand);
                  /* _sid := arfn_exec_sid_sm(_nomefile) */
                  _sid = arfn_exec_sid_smR.Make(m_Ctx,this).Run(_nomefile);
                  /* If _sid.RecCount() > 0 */
                  if (CPLib.gt(_sid.RecCount(),0)) {
                    for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
                      /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
                      gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
                      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    }
                  } // End If
                  /* _nomefile := LRTrim(gIntemediario)+"_MASSCF_"+DateTimeToChar(DateTime()) */
                  _nomefile = CPLib.LRTrim(gIntemediario)+"_MASSCF_"+CPLib.DateTimeToChar(CPLib.DateTime());
                  /* fhand := FileLibMit.OpenWrite('/SID/MASSCF/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
                  fhand = FileLibMit.OpenWrite("/SID/MASSCF/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
                  /* _riga := '0'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+DateTimeToChar(DateTime())+Space(138)+'SM1.02'+Space(4)+Space(60)+'A'+NL */
                  _riga = "0"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.DateTimeToChar(CPLib.DateTime())+CPLib.Space(138)+"SM1.02"+CPLib.Space(4)+CPLib.Space(60)+"A"+"\n";
                  /* FileLibMit.Write(fhand,_riga) */
                  FileLibMit.Write(fhand,_riga);
                  /* _contarighe := 1 */
                  _contarighe = CPLib.Round(1,0);
                  /* _contat1 := 0 */
                  _contat1 = CPLib.Round(0,0);
                  /* _contat2 := 0 */
                  _contat2 = CPLib.Round(0,0);
                } // End If
              } // End If
              Cursor_qbe_mass_cf.Next();
            }
            m_cConnectivityError = Cursor_qbe_mass_cf.ErrorMessage();
            Cursor_qbe_mass_cf.Close();
            // * --- End Select
          } else { // Else
            /* gMsgImp := 'Lettura soggetti in corso ...' // Messaggio Import */
            gMsgImp = "Lettura soggetti in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If _contarec = w_maxinvii and w_tipoinv <> 'G' */
          if (CPLib.eqr(_contarec,w_maxinvii) && CPLib.ne(w_tipoinv,"G")) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _contarighe := _contarighe + 1 */
        _contarighe = CPLib.Round(_contarighe+1,0);
        /* _riga := '9'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+Space(152)+'SM1.02'+Space(4) */
        _riga = "9"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.Space(152)+"SM1.02"+CPLib.Space(4);
        /* _riga := _riga+Right('000000'+LRTrim(Str(_contarighe,6,0)),6)+Right('000000'+LRTrim(Str(_contat1,6,0)),6)+Right('000000'+LRTrim(Str(_contat2,6,0)),6)+Space(42)+'A'+NL */
        _riga = _riga+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contarighe,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat1,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat2,6,0)),6)+CPLib.Space(42)+"A"+"\n";
        /* FileLibMit.Write(fhand,_riga) */
        FileLibMit.Write(fhand,_riga);
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* _sid := arfn_exec_sid_sm(_nomefile) */
        _sid = arfn_exec_sid_smR.Make(m_Ctx,this).Run(_nomefile);
        /* If _sid.RecCount() > 0 */
        if (CPLib.gt(_sid.RecCount(),0)) {
          for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
            /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
            gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          }
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_mass_cf_min_max!=null)
          Cursor_qbe_mass_cf_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_mass_cf!=null)
          Cursor_qbe_mass_cf.Close();
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
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_mass_cf_selected=null;
    CPResultSet Cursor_tbstati=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _nomefile := LRTrim(gIntemediario)+"_MASSCF_"+DateTimeToChar(DateTime()) */
      _nomefile = CPLib.LRTrim(gIntemediario)+"_MASSCF_"+CPLib.DateTimeToChar(CPLib.DateTime());
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/SID/MASSCF/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* _riga := '0'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+DateTimeToChar(DateTime())+Space(138)+'SM1.02'+Space(4)+Space(60)+'A'+LibreriaMit.CloseLine() */
      _riga = "0"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.DateTimeToChar(CPLib.DateTime())+CPLib.Space(138)+"SM1.02"+CPLib.Space(4)+CPLib.Space(60)+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* _contarighe := 1 */
      _contarighe = CPLib.Round(1,0);
      /* _contat1 := 0 */
      _contat1 = CPLib.Round(0,0);
      /* _contat2 := 0 */
      _contat2 = CPLib.Round(0,0);
      /* _contarec := 0 */
      _contarec = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Lettura soggetti in corso ...' + NL // Messaggio */
      gMsgProc = gMsgProc+"Lettura soggetti in corso ..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Lettura soggetti in corso ... ' // Messaggio Import */
      gMsgImp = "Lettura soggetti in corso ... ";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_mass_cf_selected
      SPBridge.HMCaller _h000000E9;
      _h000000E9 = new SPBridge.HMCaller();
      _h000000E9.Set("m_cVQRList",m_cVQRList);
      _h000000E9.Set("pEstero1",_tipo1);
      _h000000E9.Set("pEstero2",_tipo2);
      _h000000E9.Set("pANNO",CPLib.LRTrim(_filtroanni));
      _h000000E9.Set("OrderBy",w_Orderby);
      if (Cursor_qbe_mass_cf_selected!=null)
        Cursor_qbe_mass_cf_selected.Close();
      Cursor_qbe_mass_cf_selected = new VQRHolder("qbe_mass_cf_selected",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000E9,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_mass_cf_selected.Eof())) {
        /* gMsgImp := 'Elaboro il soggetto->'+LRTrim(qbe_mass_cf_selected->COGNOME)+" "+LRTrim(qbe_mass_cf_selected->NOME) // Messaggio Import */
        gMsgImp = "Elaboro il soggetto->"+CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("NOME"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _codint := Right('000000000000000'+LRTrim(Str(qbe_mass_cf_selected->PROGIMPORT,15,0)),15) */
        _codint = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_mass_cf_selected.GetDouble("PROGIMPORT"),15,0)),15);
        /* If Empty(qbe_mass_cf_selected->SESSO) */
        if (CPLib.Empty(Cursor_qbe_mass_cf_selected.GetString("SESSO"))) {
          /* If qbe_mass_cf_selected->CFESTERO=1 */
          if (CPLib.eqr(Cursor_qbe_mass_cf_selected.GetDouble("CFESTERO"),1)) {
            /* _riga := '2'+_codint+Space(11)+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf_selected->RAGSOC),150)+Space(4) */
            _riga = "2"+_codint+CPLib.Space(11)+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("RAGSOC")),150)+CPLib.Space(4);
            /* If qbe_mass_cf_selected->PROVINCIA='EE' */
            if (CPLib.eqr(Cursor_qbe_mass_cf_selected.GetString("PROVINCIA"),"EE")) {
              // * --- Select from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              if (Cursor_tbstati!=null)
                Cursor_tbstati.Close();
              Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DESCRI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSTA="+CPLib.ToSQL(Cursor_qbe_mass_cf_selected.GetString("PAESE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbstati")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_tbstati.Eof())) {
                /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(tbstati->DESCRI),45) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_tbstati.GetString("DESCRI")),45);
                Cursor_tbstati.Next();
              }
              m_cConnectivityError = Cursor_tbstati.ErrorMessage();
              Cursor_tbstati.Close();
              // * --- End Select
            } else { // Else
              /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf_selected->DESCCIT),45) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("DESCCIT")),45);
            } // End If
            /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf_selected->TIPINTER),2)+Space(71)+"A"+LibreriaMit.CloseLine() */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("TIPINTER")),2)+CPLib.Space(71)+"A"+LibreriaMit.CloseLine();
          } else { // Else
            /* _riga := '2'+_codint+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf_selected->CODFISC),11)+Space(150)+Space(51)+Space(71)+"A"+LibreriaMit.CloseLine() */
            _riga = "2"+_codint+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("CODFISC")),11)+CPLib.Space(150)+CPLib.Space(51)+CPLib.Space(71)+"A"+LibreriaMit.CloseLine();
          } // End If
          /* _contat2 := _contat2 + 1 */
          _contat2 = CPLib.Round(_contat2+1,0);
        } else { // Else
          /* If qbe_mass_cf_selected->CFESTERO=1 or not(arfn_chkcodfis(Upper(qbe_mass_cf_selected->CODFISC),qbe_mass_cf_selected->PAESE,qbe_mass_cf_selected->CFESTERO)) */
          if (CPLib.eqr(Cursor_qbe_mass_cf_selected.GetDouble("CFESTERO"),1) ||  ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("CODFISC")),Cursor_qbe_mass_cf_selected.GetString("PAESE"),Cursor_qbe_mass_cf_selected.GetDouble("CFESTERO")))) {
            /* _riga := '1'+_codint+Space(16) */
            _riga = "1"+_codint+CPLib.Space(16);
            /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf_selected->COGNOME)," ")),40) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("COGNOME"))," ")),40);
            /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf_selected->NOME)," ")),40) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("NOME"))," ")),40);
            /* _riga := _riga+iif(qbe_mass_cf_selected->SESSO='1','M',iif(qbe_mass_cf_selected->SESSO='2','F',' ')) */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_mass_cf_selected.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_qbe_mass_cf_selected.GetString("SESSO"),"2")?"F":" "));
            /* _riga := _riga+arfn_fdate_nd(qbe_mass_cf_selected->DATANASC,'S')+Space(4) */
            _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_qbe_mass_cf_selected.GetDate("DATANASC"),"S")+CPLib.Space(4);
            /* _riga := _riga+iif(qbe_mass_cf_selected->TIPINTER='EE',LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf_selected->NASSTATO)," ")),45),LibreriaMit.SpacePad(LRTrim(arfn_agechar(Upper(qbe_mass_cf_selected->NASCOMUN)," ")),45)) */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_mass_cf_selected.GetString("TIPINTER"),"EE")?LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("NASSTATO"))," ")),45):LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("NASCOMUN"))," ")),45));
            /* _riga := _riga+LibreriaMit.SpacePad(LRTrim(qbe_mass_cf_selected->TIPINTER),2)+Space(127)+"A"+LibreriaMit.CloseLine() */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_mass_cf_selected.GetString("TIPINTER")),2)+CPLib.Space(127)+"A"+LibreriaMit.CloseLine();
          } else { // Else
            /* _riga := '1'+_codint+LibreriaMit.SpacePad(LRTrim(Upper(qbe_mass_cf_selected->CODFISC)),16)+Space(81)+"00000000"+Space(51)+Space(127)+"A"+LibreriaMit.CloseLine() */
            _riga = "1"+_codint+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(Cursor_qbe_mass_cf_selected.GetString("CODFISC"))),16)+CPLib.Space(81)+"00000000"+CPLib.Space(51)+CPLib.Space(127)+"A"+LibreriaMit.CloseLine();
          } // End If
          /* _contat1 := _contat1 + 1 */
          _contat1 = CPLib.Round(_contat1+1,0);
        } // End If
        /* FileLibMit.Write(fhand,_riga) */
        FileLibMit.Write(fhand,_riga);
        /* _contarighe := _contarighe + 1 */
        _contarighe = CPLib.Round(_contarighe+1,0);
        /* _contarec := _contarec + 1 */
        _contarec = CPLib.Round(_contarec+1,0);
        /* If _contarec = w_maxinvii */
        if (CPLib.eqr(_contarec,w_maxinvii)) {
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
        /* If _contarighe=_maxrig */
        if (CPLib.eqr(_contarighe,_maxrig)) {
          /* _contarighe := _contarighe + 1 */
          _contarighe = CPLib.Round(_contarighe+1,0);
          /* _riga := '9'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+Space(152)+'SM1.02'+Space(4) */
          _riga = "9"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.Space(152)+"SM1.02"+CPLib.Space(4);
          /* _riga := _riga+Right('000000'+LRTrim(Str(_contarighe,6,0)),6)+Right('000000'+LRTrim(Str(_contat1,6,0)),6)+Right('000000'+LRTrim(Str(_contat2,6,0)),6)+Space(42)+'A'+LibreriaMit.CloseLine() */
          _riga = _riga+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contarighe,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat1,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat2,6,0)),6)+CPLib.Space(42)+"A"+LibreriaMit.CloseLine();
          /* FileLibMit.Write(fhand,_riga) */
          FileLibMit.Write(fhand,_riga);
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* _sid := arfn_exec_sid_sm(_nomefile) */
          _sid = arfn_exec_sid_smR.Make(m_Ctx,this).Run(_nomefile);
          /* If _sid.RecCount() > 0 */
          if (CPLib.gt(_sid.RecCount(),0)) {
            for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
              /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
              gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            }
          } // End If
          /* _nomefile := LRTrim(gIntemediario)+"_MASSCF_"+DateTimeToChar(DateTime()) */
          _nomefile = CPLib.LRTrim(gIntemediario)+"_MASSCF_"+CPLib.DateTimeToChar(CPLib.DateTime());
          /* fhand := FileLibMit.OpenWrite('/SID/MASSCF/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
          fhand = FileLibMit.OpenWrite("/SID/MASSCF/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
          /* _riga := '0'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+DateTimeToChar(DateTime())+Space(138)+'SM1.02'+Space(4)+Space(60)+'A'+LibreriaMit.CloseLine() */
          _riga = "0"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.DateTimeToChar(CPLib.DateTime())+CPLib.Space(138)+"SM1.02"+CPLib.Space(4)+CPLib.Space(60)+"A"+LibreriaMit.CloseLine();
          /* FileLibMit.Write(fhand,_riga) */
          FileLibMit.Write(fhand,_riga);
          /* _contarighe := 1 */
          _contarighe = CPLib.Round(1,0);
          /* _contat1 := 0 */
          _contat1 = CPLib.Round(0,0);
          /* _contat2 := 0 */
          _contat2 = CPLib.Round(0,0);
        } // End If
        Cursor_qbe_mass_cf_selected.Next();
      }
      m_cConnectivityError = Cursor_qbe_mass_cf_selected.ErrorMessage();
      Cursor_qbe_mass_cf_selected.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + NL // Messaggio */
      gMsgProc = gMsgProc+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _contarighe := _contarighe + 1 */
      _contarighe = CPLib.Round(_contarighe+1,0);
      /* _riga := '9'+LibreriaMit.SpacePad(LRTrim(_cfint),16)+LibreriaMit.SpacePad(LRTrim(Left(_rsint,60)),60)+Space(152)+'SM1.02'+Space(4) */
      _riga = "9"+LibreriaMit.SpacePad(CPLib.LRTrim(_cfint),16)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_rsint,60)),60)+CPLib.Space(152)+"SM1.02"+CPLib.Space(4);
      /* _riga := _riga+Right('000000'+LRTrim(Str(_contarighe,6,0)),6)+Right('000000'+LRTrim(Str(_contat1,6,0)),6)+Right('000000'+LRTrim(Str(_contat2,6,0)),6)+Space(42)+'A'+LibreriaMit.CloseLine() */
      _riga = _riga+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contarighe,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat1,6,0)),6)+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_contat2,6,0)),6)+CPLib.Space(42)+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* _sid := arfn_exec_sid_sm(_nomefile) */
      _sid = arfn_exec_sid_smR.Make(m_Ctx,this).Run(_nomefile);
      /* If _sid.RecCount() > 1 */
      if (CPLib.gt(_sid.RecCount(),1)) {
        for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
          /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        }
        /* cRitorno := "Rilevati Errori nell'esecuzione del SID. Elaborazione Abortita!" // Messaggio Import */
        cRitorno = "Rilevati Errori nell'esecuzione del SID. Elaborazione Abortita!";
      } // End If
    } finally {
      try {
        if (Cursor_qbe_mass_cf_selected!=null)
          Cursor_qbe_mass_cf_selected.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_tiposog,String p_w_tipoinv,double p_w_maxinvii,String p_w_a2013,String p_w_a2014,String p_w_a2015,String p_w_a2016,String p_w_a2017,String p_w_a2018,String p_w_a2019,String p_w_a2020,String p_w_a2021,String p_w_a2022) {
    w_tiposog = p_w_tiposog;
    w_tipoinv = p_w_tipoinv;
    w_maxinvii = p_w_maxinvii;
    w_a2013 = p_w_a2013;
    w_a2014 = p_w_a2014;
    w_a2015 = p_w_a2015;
    w_a2016 = p_w_a2016;
    w_a2017 = p_w_a2017;
    w_a2018 = p_w_a2018;
    w_a2019 = p_w_a2019;
    w_a2020 = p_w_a2020;
    w_a2021 = p_w_a2021;
    w_a2022 = p_w_a2022;
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
  public String Run(String p_w_tiposog,String p_w_tipoinv,double p_w_maxinvii,String p_w_a2013,String p_w_a2014,String p_w_a2015,String p_w_a2016,String p_w_a2017,String p_w_a2018,String p_w_a2019,String p_w_a2020,String p_w_a2021,String p_w_a2022) {
    w_tiposog = p_w_tiposog;
    w_tipoinv = p_w_tipoinv;
    w_maxinvii = p_w_maxinvii;
    w_a2013 = p_w_a2013;
    w_a2014 = p_w_a2014;
    w_a2015 = p_w_a2015;
    w_a2016 = p_w_a2016;
    w_a2017 = p_w_a2017;
    w_a2018 = p_w_a2018;
    w_a2019 = p_w_a2019;
    w_a2020 = p_w_a2020;
    w_a2021 = p_w_a2021;
    w_a2022 = p_w_a2022;
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
  public static arrt_crea_mass_cfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_crea_mass_cfR(p_Ctx, p_Caller);
  }
  public static arrt_crea_mass_cfR Make(CPContext p_Ctx) {
    return new arrt_crea_mass_cfR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tiposog = CPLib.Space(1);
    w_tipoinv = CPLib.Space(1);
    w_maxinvii = 0;
    w_a2013 = CPLib.Space(1);
    w_a2014 = CPLib.Space(1);
    w_a2015 = CPLib.Space(1);
    w_a2016 = CPLib.Space(1);
    w_a2017 = CPLib.Space(1);
    w_a2018 = CPLib.Space(1);
    w_a2019 = CPLib.Space(1);
    w_a2020 = CPLib.Space(1);
    w_a2021 = CPLib.Space(1);
    w_a2022 = CPLib.Space(1);
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(10);
    cNomeFile = CPLib.Space(100);
    _mese = CPLib.Space(2);
    _riga = CPLib.Space(300);
    _filtroanni = CPLib.Space(128);
    w_Orderby = CPLib.Space(30);
    _blocco = CPLib.Space(1);
    _contarec = 0;
    _tipo1 = 0;
    _tipo2 = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _oldmsg = CPLib.Space(100);
    _reccount = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cfint = CPLib.Space(16);
    _rsint = CPLib.Space(70);
    _codint = CPLib.Space(15);
    _contarighe = 0;
    _contat1 = 0;
    _contat2 = 0;
    _sid = new MemoryCursor_mcmessaggi_mcrdef();
    _maxrig = 0;
    cRitorno = CPLib.Space(50);
    _newline = CPLib.Space(6);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_mass_cf_min_max,qbe_mass_cf,qbe_mass_cf_selected,
  public static final String m_cVQRList = ",qbe_mass_cf_min_max,qbe_mass_cf,qbe_mass_cf_selected,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkcodfis,arfn_exec_sid_sm,arfn_fdate_nd,arfn_fdatetime,arrt_crea_mass_cf,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkcodfis,arfn_exec_sid_sm,arfn_fdate_nd,arfn_fdatetime,arrt_crea_mass_cf,";
  public static String[] m_cRunParameterNames={"w_tiposog","w_tipoinv","w_maxinvii","w_a2013","w_a2014","w_a2015","w_a2016","w_a2017","w_a2018","w_a2019","w_a2020","w_a2021","w_a2022"};
}
