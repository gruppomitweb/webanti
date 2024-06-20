// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anomes_rappR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String pRapporto;
  public String pTipo;
  public String pNCF;
  public double _conta;
  public String _errore;
  public String _ndg;
  public String _tiprap;
  public String _cab;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrori;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrPers;
  public MemoryCursorRow_mcerrsaldi_mcrdef rowErrore;
  public String _codfisc;
  public String _rapporto;
  public double _cfestero;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public double _annobase;
  public double _annooggi;
  public double _annofine;
  public double _passa;
  public String _annoc;
  public String _cabinter;
  public java.sql.Date gDataTito;
  public java.sql.Date gScadSaldi;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_anomes_rapp
  public int _annob,_annof;
  // * --- Fine Area Manuale
  public arfn_anomes_rappR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anomes_rapp",m_Caller);
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
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("_annobase",p_cVarName)) {
      return _annobase;
    }
    if (CPLib.eqr("_annooggi",p_cVarName)) {
      return _annooggi;
    }
    if (CPLib.eqr("_annofine",p_cVarName)) {
      return _annofine;
    }
    if (CPLib.eqr("_passa",p_cVarName)) {
      return _passa;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_anomes_rapp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pNCF",p_cVarName)) {
      return pNCF;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      return _ndg;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      return _tiprap;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      return mcErrPers;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      return rowErrore;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
      return;
    }
    if (CPLib.eqr("_annobase",p_cVarName)) {
      _annobase = value;
      return;
    }
    if (CPLib.eqr("_annooggi",p_cVarName)) {
      _annooggi = value;
      return;
    }
    if (CPLib.eqr("_annofine",p_cVarName)) {
      _annofine = value;
      return;
    }
    if (CPLib.eqr("_passa",p_cVarName)) {
      _passa = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      pRapporto = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pNCF",p_cVarName)) {
      pNCF = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      _ndg = value;
      return;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      _tiprap = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      _annoc = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
      return;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      rowErrore = (MemoryCursorRow_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      mcErrPers = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_jnarapbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_qbe_famesiti_intestbo_minmax=null;
    CPResultSet Cursor_qbe_famesiti_jntestbo_minmax=null;
    CPResultSet Cursor_aeannora=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pRapporto Char(25) */
      /* pTipo Char(1) */
      /* pNCF Char(1) // Nuova o Modifica */
      /* _conta Numeric(1, 0) */
      /* _errore Char(128) // Errori Rilevati */
      /* _ndg Char(16) // NDG */
      /* _tiprap Char(1) */
      /* _cab Char(5) */
      /* mcErrori MemoryCursor(mcErrSaldi.MCRDef) */
      /* mcErrPers MemoryCursor(mcErrSaldi.MCRDef) */
      /* rowErrore Row(mcErrSaldi.MCRDef) */
      /* _codfisc Char(16) */
      /* _rapporto Char(25) */
      /* _cfestero Numeric(1, 0) */
      /* _datini Date */
      /* _datfin Date */
      /* _annobase Numeric(4, 0) */
      /* _annooggi Numeric(4, 0) */
      /* _annofine Numeric(4, 0) */
      /* _passa Numeric(1, 0) */
      /* _annoc Char(4) */
      /* _cabinter Char(5) */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCAB  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cabinter := Left(LRTrim(intermbo->CODCAB),5) */
        _cabinter = CPLib.Left(CPLib.LRTrim(Cursor_intermbo.GetString("CODCAB")),5);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _errore := '' // Errori Rilevati */
      _errore = "";
      /* If pTipo='A'  or pTipo='M' */
      if (CPLib.eqr(pTipo,"A") || CPLib.eqr(pTipo,"M")) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _errore := '' // Errori Rilevati */
        _errore = "";
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* If Empty(anarapbo->TIPORAP) */
          if (CPLib.Empty(Cursor_anarapbo.GetString("TIPORAP"))) {
            /* _errore := "Rapporto tipo rapporto mancante" // Errori Rilevati */
            _errore = "Rapporto tipo rapporto mancante";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(anarapbo->TIPOAG) */
          if (CPLib.Empty(Cursor_anarapbo.GetString("TIPOAG"))) {
            /* _errore := "Rapporto tipo Agenzia Entrate mancante" // Errori Rilevati */
            _errore = "Rapporto tipo Agenzia Entrate mancante";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
            /* ElseIf Len(LRTrim(anarapbo->TIPOAG)) < 2 */
          } else if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_anarapbo.GetString("TIPOAG"))),2)) {
            /* _errore := "Rapporto tipo Agenzia Entrate anomalo" // Errori Rilevati */
            _errore = "Rapporto tipo Agenzia Entrate anomalo";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If At(anarapbo->TIPOAG,'|01|02|03|12|13') <> 0 */
          if (CPLib.ne(CPLib.At(Cursor_anarapbo.GetString("TIPOAG"),"|01|02|03|12|13"),0)) {
            /* _cab := '' */
            _cab = "";
            /* _rapporto := '' */
            _rapporto = "";
            // * --- Read from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"C",25,0,m_cServer),m_cServer,pRapporto);
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cab = Read_Cursor.GetString("CAB");
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aetesta into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cab = "";
              _rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_rapporto)) */
            if ( ! (CPLib.Empty(_rapporto))) {
              /* If Empty(_cab) and Empty(_cabinter) */
              if (CPLib.Empty(_cab) && CPLib.Empty(_cabinter)) {
                /* _errore := "Rapporto codice CAB assente" // Errori Rilevati */
                _errore = "Rapporto codice CAB assente";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
                /* ElseIf not(Empty(_cab)) and Len(LRTrim(_cab)) < 5 */
              } else if ( ! (CPLib.Empty(_cab)) && CPLib.lt(CPLib.Len(CPLib.LRTrim(_cab)),5)) {
                /* _errore := "Rapporto codice CAB anomalo" // Errori Rilevati */
                _errore = "Rapporto codice CAB anomalo";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
                /* ElseIf Empty(_cab) and not(Empty(_cabinter)) and Len(LRTrim(_cabinter)) < 5 */
              } else if (CPLib.Empty(_cab) &&  ! (CPLib.Empty(_cabinter)) && CPLib.lt(CPLib.Len(CPLib.LRTrim(_cabinter)),5)) {
                /* _errore := "Rapporto codice CAB anomalo" // Errori Rilevati */
                _errore = "Rapporto codice CAB anomalo";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
            } // End If
          } // End If
          /* If Empty(anarapbo->DESCRAP) and anarapbo->TIPOAG='99' */
          if (CPLib.Empty(Cursor_anarapbo.GetString("DESCRAP")) && CPLib.eqr(Cursor_anarapbo.GetString("TIPOAG"),"99")) {
            /* _errore := "Rapporto Descrizione Mancante" // Errori Rilevati */
            _errore = "Rapporto Descrizione Mancante";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* _tiprap := anarapbo->TIPORAP */
          _tiprap = Cursor_anarapbo.GetString("TIPORAP");
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* _errore := "Rapporto non individuata testata" // Errori Rilevati */
          _errore = "Rapporto non individuata testata";
          /* _ndg := '' // NDG */
          _ndg = "";
          /* Exec "Scrive Errori" Page 2:Page_2 */
          Page_2();
        } // End If
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If Empty(intestbo->CODINTER) */
          if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
            /* _errore := "Rapporto Manca NDG intestatario" // Errori Rilevati */
            _errore = "Rapporto Manca NDG intestatario";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(intestbo->DATAINI) */
          if (CPLib.Empty(Cursor_intestbo.GetDate("DATAINI"))) {
            /* _errore := "Rapporto - Intestatario Anomalia Data Apertura" // Errori Rilevati */
            _errore = "Rapporto - Intestatario Anomalia Data Apertura";
            /* _ndg := intestbo->CODINTER // NDG */
            _ndg = Cursor_intestbo.GetString("CODINTER");
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(intestbo->DATAINI)) and not(Empty(intestbo->DATAFINE)) and intestbo->DATAINI > intestbo->DATAFINE */
          if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_intestbo.GetDate("DATAFINE"))) {
            /* _errore := "Rapporto - Intestatario Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
            _errore = "Rapporto - Intestatario Anomalia tra Data Apertura e Data chiusura";
            /* _ndg := intestbo->CODINTER // NDG */
            _ndg = Cursor_intestbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(intestbo->CODINTER)) */
          if ( ! (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")))) {
            /* mcErrPers := arfn_anompers(intestbo->CODINTER,_tiprap,pRapporto,'S',pTipo,'',pNCF) */
            mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),_tiprap,pRapporto,"S",pTipo,"",pNCF);
            /* If mcErrPers.RecCount() > 0 */
            if (CPLib.gt(mcErrPers.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                /* _errore := rowErrore.TXTERR // Errori Rilevati */
                _errore = rowErrore.TXTERR;
                /* _ndg := rowErrore.CONNESINT // NDG */
                _ndg = rowErrore.CONNESINT;
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              }
            } // End If
            /* If intestbo->DATAINI >= gDataTito or Empty(gDataTito) */
            if (CPLib.ge(Cursor_intestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* If Empty(intestit->CODINTER) */
                if (CPLib.Empty(Cursor_intestit.GetString("CODINTER"))) {
                  /* _errore := "Rapporto Manca NDG Titolare Effettivo" // Errori Rilevati */
                  _errore = "Rapporto Manca NDG Titolare Effettivo";
                  /* _ndg := '' // NDG */
                  _ndg = "";
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If Empty(intestit->DATAINI) */
                if (CPLib.Empty(Cursor_intestit.GetDate("DATAINI"))) {
                  /* _errore := "Rapporto - Titolare Anomalia Data Apertura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia Data Apertura";
                  /* _ndg := intestit->CODINTER // NDG */
                  _ndg = Cursor_intestit.GetString("CODINTER");
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(intestit->DATAINI)) and not(Empty(intestit->DATAFINE)) and intestit->DATAINI > intestit->DATAFINE */
                if ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.gt(Cursor_intestit.GetDate("DATAINI"),Cursor_intestit.GetDate("DATAFINE"))) {
                  /* _errore := "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura";
                  /* _ndg := intestit->CODINTER // NDG */
                  _ndg = Cursor_intestit.GetString("CODINTER");
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(intestit->CODINTER)) */
                if ( ! (CPLib.Empty(Cursor_intestit.GetString("CODINTER")))) {
                  /* _codfisc := '' */
                  _codfisc = "";
                  /* _cfestero := 0 */
                  _cfestero = CPLib.Round(0,0);
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codfisc = Read_Cursor.GetString("CODFISC");
                    _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codfisc = "";
                    _cfestero = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Len(LRTrim(_codfisc)) < 16 and _cfestero <> 1 */
                  if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16) && CPLib.ne(_cfestero,1)) {
                    /* _errore := "Rapporto - Titolare Soggetto non persona fisica" // Errori Rilevati */
                    _errore = "Rapporto - Titolare Soggetto non persona fisica";
                    /* _ndg := intestit->CODINTER // NDG */
                    _ndg = Cursor_intestit.GetString("CODINTER");
                    /* Exec "Scrive Errori" Page 2:Page_2 */
                    Page_2();
                  } // End If
                  /* mcErrPers := arfn_anompers(intestit->CODINTER,_tiprap,pRapporto,'N',pTipo,'F',pNCF) */
                  mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"F",pNCF);
                  /* If mcErrPers.RecCount() > 0 */
                  if (CPLib.gt(mcErrPers.RecCount(),0)) {
                    for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                      /* _errore := rowErrore.TXTERR // Errori Rilevati */
                      _errore = rowErrore.TXTERR;
                      /* _ndg := rowErrore.CONNESINT // NDG */
                      _ndg = rowErrore.CONNESINT;
                      /* Exec "Scrive Errori" Page 2:Page_2 */
                      Page_2();
                    }
                  } // End If
                } // End If
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
          } // End If
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* _errore := "Rapporto non individuati intestatari" // Errori Rilevati */
          _errore = "Rapporto non individuati intestatari";
          /* Exec "Scrive Errori" Page 2:Page_2 */
          Page_2();
        } // End If
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* If delegabo->NOAGE <> 'S' */
          if (CPLib.ne(Cursor_delegabo.GetString("NOAGE"),"S")) {
            /* If Empty(delegabo->CODINTER) */
            if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
              /* _errore := "Rapporto Manca NDG delegato" // Errori Rilevati */
              _errore = "Rapporto Manca NDG delegato";
              /* _ndg := '' // NDG */
              _ndg = "";
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If Empty(delegabo->DATAINI) */
            if (CPLib.Empty(Cursor_delegabo.GetDate("DATAINI"))) {
              /* _errore := "Rapporto - Delegato Anomalia Data Apertura" // Errori Rilevati */
              _errore = "Rapporto - Delegato Anomalia Data Apertura";
              /* _ndg := delegabo->CODINTER // NDG */
              _ndg = Cursor_delegabo.GetString("CODINTER");
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If not(Empty(delegabo->DATAINI)) and not(Empty(delegabo->DATAFINE)) and delegabo->DATAINI > delegabo->DATAFINE */
            if ( ! (CPLib.Empty(Cursor_delegabo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_delegabo.GetDate("DATAINI"),Cursor_delegabo.GetDate("DATAFINE"))) {
              /* _errore := "Rapporto - Delegato Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
              _errore = "Rapporto - Delegato Anomalia tra Data Apertura e Data chiusura";
              /* _ndg := delegabo->CODINTER // NDG */
              _ndg = Cursor_delegabo.GetString("CODINTER");
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If not(Empty(delegabo->CODINTER)) */
            if ( ! (CPLib.Empty(Cursor_delegabo.GetString("CODINTER")))) {
              /* _codfisc := '' */
              _codfisc = "";
              /* _cfestero := 0 */
              _cfestero = CPLib.Round(0,0);
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                _cfestero = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_codfisc)) < 16 and _cfestero <> 1 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16) && CPLib.ne(_cfestero,1)) {
                /* _errore := "Rapporto - Delegato Soggetto non persona fisica" // Errori Rilevati */
                _errore = "Rapporto - Delegato Soggetto non persona fisica";
                /* _ndg := delegabo->CODINTER // NDG */
                _ndg = Cursor_delegabo.GetString("CODINTER");
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
              /* mcErrPers := arfn_anompers(delegabo->CODINTER,_tiprap,pRapporto,'N',pTipo,'F',pNCF) */
              mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"F",pNCF);
              /* If mcErrPers.RecCount() > 0 */
              if (CPLib.gt(mcErrPers.RecCount(),0)) {
                for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                  /* _errore := rowErrore.TXTERR // Errori Rilevati */
                  _errore = rowErrore.TXTERR;
                  /* _ndg := rowErrore.CONNESINT // NDG */
                  _ndg = rowErrore.CONNESINT;
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                }
              } // End If
            } // End If
          } // End If
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        // * --- Select from garantbo
        m_cServer = m_Ctx.GetServer("garantbo");
        m_cPhName = m_Ctx.GetPhName("garantbo");
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
        Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_garantbo.Eof())) {
          /* If Empty(garantbo->CODINTER) */
          if (CPLib.Empty(Cursor_garantbo.GetString("CODINTER"))) {
            /* _errore := "Rapporto Manca NDG garantito" // Errori Rilevati */
            _errore = "Rapporto Manca NDG garantito";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(garantbo->DATAINI) */
          if (CPLib.Empty(Cursor_garantbo.GetDate("DATAINI"))) {
            /* _errore := "Rapporto - Garantito Anomalia Data Apertura" // Errori Rilevati */
            _errore = "Rapporto - Garantito Anomalia Data Apertura";
            /* _ndg := garantbo->CODINTER // NDG */
            _ndg = Cursor_garantbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(garantbo->DATAINI)) and not(Empty(garantbo->DATAFINE)) and garantbo->DATAINI > garantbo->DATAFINE */
          if ( ! (CPLib.Empty(Cursor_garantbo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_garantbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_garantbo.GetDate("DATAINI"),Cursor_garantbo.GetDate("DATAFINE"))) {
            /* _errore := "Rapporto - Garantito Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
            _errore = "Rapporto - Garantito Anomalia tra Data Apertura e Data chiusura";
            /* _ndg := garantbo->CODINTER // NDG */
            _ndg = Cursor_garantbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(garantbo->CODINTER)) */
          if ( ! (CPLib.Empty(Cursor_garantbo.GetString("CODINTER")))) {
            /* mcErrPers := arfn_anompers(garantbo->CODINTER,_tiprap,pRapporto,'N',pTipo,'',pNCF) */
            mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_garantbo.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"",pNCF);
            /* If mcErrPers.RecCount() > 0 */
            if (CPLib.gt(mcErrPers.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                /* _errore := rowErrore.TXTERR // Errori Rilevati */
                _errore = rowErrore.TXTERR;
                /* _ndg := rowErrore.CONNESINT // NDG */
                _ndg = rowErrore.CONNESINT;
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              }
            } // End If
          } // End If
          Cursor_garantbo.Next();
        }
        m_cConnectivityError = Cursor_garantbo.ErrorMessage();
        Cursor_garantbo.Close();
        // * --- End Select
        /* ElseIf pTipo='J' or pTipo='N' */
      } else if (CPLib.eqr(pTipo,"J") || CPLib.eqr(pTipo,"N")) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _errore := '' // Errori Rilevati */
        _errore = "";
        // * --- Select from jnarapbo
        m_cServer = m_Ctx.GetServer("jnarapbo");
        m_cPhName = m_Ctx.GetPhName("jnarapbo");
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
        Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jnarapbo.Eof())) {
          /* If Empty(jnarapbo->TIPORAP) */
          if (CPLib.Empty(Cursor_jnarapbo.GetString("TIPORAP"))) {
            /* _errore := "Rapporto tipo rapporto mancante" // Errori Rilevati */
            _errore = "Rapporto tipo rapporto mancante";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(jnarapbo->TIPOAG) */
          if (CPLib.Empty(Cursor_jnarapbo.GetString("TIPOAG"))) {
            /* _errore := "Rapporto tipo Agenzia Entrate mancante" // Errori Rilevati */
            _errore = "Rapporto tipo Agenzia Entrate mancante";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
            /* ElseIf Len(LRTrim(jnarapbo->TIPOAG)) < 2 */
          } else if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_jnarapbo.GetString("TIPOAG"))),2)) {
            /* _errore := "Rapporto tipo Agenzia Entrate anomalo" // Errori Rilevati */
            _errore = "Rapporto tipo Agenzia Entrate anomalo";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(jnarapbo->DESCRAP) and jnarapbo->TIPOAG='99' */
          if (CPLib.Empty(Cursor_jnarapbo.GetString("DESCRAP")) && CPLib.eqr(Cursor_jnarapbo.GetString("TIPOAG"),"99")) {
            /* _errore := "Rapporto Descrizione Mancante" // Errori Rilevati */
            _errore = "Rapporto Descrizione Mancante";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* _tiprap := jnarapbo->TIPORAP */
          _tiprap = Cursor_jnarapbo.GetString("TIPORAP");
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          Cursor_jnarapbo.Next();
        }
        m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
        Cursor_jnarapbo.Close();
        // * --- End Select
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* _errore := "Rapporto non individuata testata" // Errori Rilevati */
          _errore = "Rapporto non individuata testata";
          /* Exec "Scrive Errori" Page 2:Page_2 */
          Page_2();
        } // End If
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If Empty(jntestbo->CODINTER) */
          if (CPLib.Empty(Cursor_jntestbo.GetString("CODINTER"))) {
            /* _errore := "Rapporto Manca NDG intestatario" // Errori Rilevati */
            _errore = "Rapporto Manca NDG intestatario";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(jntestbo->DATAINI) */
          if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAINI"))) {
            /* _errore := "Rapporto - Intestatario Anomalia Data Apertura" // Errori Rilevati */
            _errore = "Rapporto - Intestatario Anomalia Data Apertura";
            /* _ndg := jntestbo->CODINTER // NDG */
            _ndg = Cursor_jntestbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(jntestbo->DATAINI)) and not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAINI > jntestbo->DATAFINE */
          if ( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jntestbo.GetDate("DATAINI"),Cursor_jntestbo.GetDate("DATAFINE"))) {
            /* _errore := "Rapporto - Intestatario Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
            _errore = "Rapporto - Intestatario Anomalia tra Data Apertura e Data chiusura";
            /* _ndg := jntestbo->CODINTER // NDG */
            _ndg = Cursor_jntestbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(jntestbo->CODINTER)) */
          if ( ! (CPLib.Empty(Cursor_jntestbo.GetString("CODINTER")))) {
            /* mcErrPers := arfn_anompers(jntestbo->CODINTER,_tiprap,pRapporto,'S',pTipo,'',pNCF) */
            mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetString("CODINTER"),_tiprap,pRapporto,"S",pTipo,"",pNCF);
            /* If mcErrPers.RecCount() > 0 */
            if (CPLib.gt(mcErrPers.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                /* _errore := rowErrore.TXTERR // Errori Rilevati */
                _errore = rowErrore.TXTERR;
                /* _ndg := rowErrore.CONNESINT // NDG */
                _ndg = rowErrore.CONNESINT;
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              }
            } // End If
            /* If jntestbo->DATAINI >= gDataTito or Empty(gDataTito) */
            if (CPLib.ge(Cursor_jntestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) {
              // * --- Select from jntestit
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              if (Cursor_jntestit!=null)
                Cursor_jntestit.Close();
              Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_jntestit.Eof())) {
                /* If Empty(jntestit->CODINTER) */
                if (CPLib.Empty(Cursor_jntestit.GetString("CODINTER"))) {
                  /* _errore := "Rapporto Manca NDG Titolare Effettivo" // Errori Rilevati */
                  _errore = "Rapporto Manca NDG Titolare Effettivo";
                  /* _ndg := '' // NDG */
                  _ndg = "";
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If Empty(jntestit->DATAINI) */
                if (CPLib.Empty(Cursor_jntestit.GetDate("DATAINI"))) {
                  /* _errore := "Rapporto - Titolare Anomalia Data Apertura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia Data Apertura";
                  /* _ndg := jntestit->CODINTER // NDG */
                  _ndg = Cursor_jntestit.GetString("CODINTER");
                  /* _ndg := '' // NDG */
                  _ndg = "";
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(jntestit->DATAINI)) and not(Empty(jntestit->DATAFINE)) and jntestit->DATAINI > jntestit->DATAFINE */
                if ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jntestit.GetDate("DATAINI"),Cursor_jntestit.GetDate("DATAFINE"))) {
                  /* _errore := "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura";
                  /* _ndg := jntestit->CODINTER // NDG */
                  _ndg = Cursor_jntestit.GetString("CODINTER");
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(jntestit->CODINTER)) */
                if ( ! (CPLib.Empty(Cursor_jntestit.GetString("CODINTER")))) {
                  /* _codfisc := '' */
                  _codfisc = "";
                  /* _cfestero := 0 */
                  _cfestero = CPLib.Round(0,0);
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jntestit.GetString("CODINTER"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codfisc = Read_Cursor.GetString("CODFISC");
                    _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codfisc = "";
                    _cfestero = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Len(LRTrim(_codfisc)) < 16 and _cfestero <> 1 */
                  if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16) && CPLib.ne(_cfestero,1)) {
                    /* _errore := "Rapporto - Titolare Soggetto non persona fisica" // Errori Rilevati */
                    _errore = "Rapporto - Titolare Soggetto non persona fisica";
                    /* _ndg := jntestit->CODINTER // NDG */
                    _ndg = Cursor_jntestit.GetString("CODINTER");
                    /* Exec "Scrive Errori" Page 2:Page_2 */
                    Page_2();
                  } // End If
                  /* mcErrPers := arfn_anompers(jntestit->CODINTER,_tiprap,pRapporto,'N',pTipo,'F',pNCF) */
                  mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_jntestit.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"F",pNCF);
                  /* If mcErrPers.RecCount() > 0 */
                  if (CPLib.gt(mcErrPers.RecCount(),0)) {
                    for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                      /* _errore := rowErrore.TXTERR // Errori Rilevati */
                      _errore = rowErrore.TXTERR;
                      /* _ndg := rowErrore.CONNESINT // NDG */
                      _ndg = rowErrore.CONNESINT;
                      /* Exec "Scrive Errori" Page 2:Page_2 */
                      Page_2();
                    }
                  } // End If
                } // End If
                Cursor_jntestit.Next();
              }
              m_cConnectivityError = Cursor_jntestit.ErrorMessage();
              Cursor_jntestit.Close();
              // * --- End Select
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* If Empty(intestit->CODINTER) */
                if (CPLib.Empty(Cursor_intestit.GetString("CODINTER"))) {
                  /* _errore := "Rapporto Manca NDG Titolare Effettivo" // Errori Rilevati */
                  _errore = "Rapporto Manca NDG Titolare Effettivo";
                  /* _ndg := '' // NDG */
                  _ndg = "";
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If Empty(intestit->DATAINI) */
                if (CPLib.Empty(Cursor_intestit.GetDate("DATAINI"))) {
                  /* _errore := "Rapporto - Titolare Anomalia Data Apertura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia Data Apertura";
                  /* _ndg := intestit->CODINTER // NDG */
                  _ndg = Cursor_intestit.GetString("CODINTER");
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(intestit->DATAINI)) and not(Empty(intestit->DATAFINE)) and intestit->DATAINI > intestit->DATAFINE */
                if ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.gt(Cursor_intestit.GetDate("DATAINI"),Cursor_intestit.GetDate("DATAFINE"))) {
                  /* _errore := "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
                  _errore = "Rapporto - Titolare Anomalia tra Data Apertura e Data chiusura";
                  /* _ndg := intestit->CODINTER // NDG */
                  _ndg = Cursor_intestit.GetString("CODINTER");
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                } // End If
                /* If not(Empty(intestit->CODINTER)) */
                if ( ! (CPLib.Empty(Cursor_intestit.GetString("CODINTER")))) {
                  /* _codfisc := '' */
                  _codfisc = "";
                  /* _cfestero := 0 */
                  _cfestero = CPLib.Round(0,0);
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codfisc = Read_Cursor.GetString("CODFISC");
                    _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codfisc = "";
                    _cfestero = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Len(LRTrim(_codfisc)) < 16 and _cfestero <> 1 */
                  if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16) && CPLib.ne(_cfestero,1)) {
                    /* _errore := "Rapporto - Titolare Soggetto non persona fisica" // Errori Rilevati */
                    _errore = "Rapporto - Titolare Soggetto non persona fisica";
                    /* _ndg := intestit->CODINTER // NDG */
                    _ndg = Cursor_intestit.GetString("CODINTER");
                    /* Exec "Scrive Errori" Page 2:Page_2 */
                    Page_2();
                  } // End If
                  /* mcErrPers := arfn_anompers(intestit->CODINTER,_tiprap,pRapporto,'N',pTipo,'F',pNCF) */
                  mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"F",pNCF);
                  /* If mcErrPers.RecCount() > 0 */
                  if (CPLib.gt(mcErrPers.RecCount(),0)) {
                    for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                      /* _errore := rowErrore.TXTERR // Errori Rilevati */
                      _errore = rowErrore.TXTERR;
                      /* _ndg := rowErrore.CONNESINT // NDG */
                      _ndg = rowErrore.CONNESINT;
                      /* Exec "Scrive Errori" Page 2:Page_2 */
                      Page_2();
                    }
                  } // End If
                } // End If
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
          } // End If
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* _errore := "Rapporto non individuati intestatari" // Errori Rilevati */
          _errore = "Rapporto non individuati intestatari";
          /* Exec "Scrive Errori" Page 2:Page_2 */
          Page_2();
        } // End If
        // * --- Select from jelegabo
        m_cServer = m_Ctx.GetServer("jelegabo");
        m_cPhName = m_Ctx.GetPhName("jelegabo");
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
        Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jelegabo.Eof())) {
          /* If jelegabo->NOAGE <> 'S' */
          if (CPLib.ne(Cursor_jelegabo.GetString("NOAGE"),"S")) {
            /* If Empty(jelegabo->CODINTER) */
            if (CPLib.Empty(Cursor_jelegabo.GetString("CODINTER"))) {
              /* _errore := "Rapporto Manca NDG delegato" // Errori Rilevati */
              _errore = "Rapporto Manca NDG delegato";
              /* _ndg := '' // NDG */
              _ndg = "";
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If Empty(jelegabo->DATAINI) */
            if (CPLib.Empty(Cursor_jelegabo.GetDate("DATAINI"))) {
              /* _errore := "Rapporto - Delegato Anomalia Data Apertura" // Errori Rilevati */
              _errore = "Rapporto - Delegato Anomalia Data Apertura";
              /* _ndg := jelegabo->CODINTER // NDG */
              _ndg = Cursor_jelegabo.GetString("CODINTER");
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If not(Empty(jelegabo->DATAINI)) and not(Empty(jelegabo->DATAFINE)) and jelegabo->DATAINI > jelegabo->DATAFINE */
            if ( ! (CPLib.Empty(Cursor_jelegabo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_jelegabo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jelegabo.GetDate("DATAINI"),Cursor_jelegabo.GetDate("DATAFINE"))) {
              /* _errore := "Rapporto - Delegato Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
              _errore = "Rapporto - Delegato Anomalia tra Data Apertura e Data chiusura";
              /* _ndg := jelegabo->CODINTER // NDG */
              _ndg = Cursor_jelegabo.GetString("CODINTER");
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } // End If
            /* If not(Empty(jelegabo->CODINTER)) */
            if ( ! (CPLib.Empty(Cursor_jelegabo.GetString("CODINTER")))) {
              /* _codfisc := '' */
              _codfisc = "";
              /* _cfestero := 0 */
              _cfestero = CPLib.Round(0,0);
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jelegabo.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_rapp returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                _cfestero = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_codfisc)) < 16 and _cfestero <> 1 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16) && CPLib.ne(_cfestero,1)) {
                /* _errore := "Rapporto - Delegato Soggetto non persona fisica" // Errori Rilevati */
                _errore = "Rapporto - Delegato Soggetto non persona fisica";
                /* _ndg := jelegabo->CODINTER // NDG */
                _ndg = Cursor_jelegabo.GetString("CODINTER");
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
              /* mcErrPers := arfn_anompers(jelegabo->CODINTER,_tiprap,pRapporto,'N',pTipo,'F',pNCF) */
              mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"F",pNCF);
              /* If mcErrPers.RecCount() > 0 */
              if (CPLib.gt(mcErrPers.RecCount(),0)) {
                for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                  /* _errore := rowErrore.TXTERR // Errori Rilevati */
                  _errore = rowErrore.TXTERR;
                  /* _ndg := rowErrore.CONNESINT // NDG */
                  _ndg = rowErrore.CONNESINT;
                  /* Exec "Scrive Errori" Page 2:Page_2 */
                  Page_2();
                }
              } // End If
            } // End If
          } // End If
          Cursor_jelegabo.Next();
        }
        m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
        Cursor_jelegabo.Close();
        // * --- End Select
        // * --- Select from jarantbo
        m_cServer = m_Ctx.GetServer("jarantbo");
        m_cPhName = m_Ctx.GetPhName("jarantbo");
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
        Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jarantbo.Eof())) {
          /* If Empty(jarantbo->CODINTER) */
          if (CPLib.Empty(Cursor_jarantbo.GetString("CODINTER"))) {
            /* _errore := "Rapporto Manca NDG garantito" // Errori Rilevati */
            _errore = "Rapporto Manca NDG garantito";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(jarantbo->DATAINI) */
          if (CPLib.Empty(Cursor_jarantbo.GetDate("DATAINI"))) {
            /* _errore := "Rapporto - Garantito Anomalia Data Apertura" // Errori Rilevati */
            _errore = "Rapporto - Garantito Anomalia Data Apertura";
            /* _ndg := jarantbo->CODINTER // NDG */
            _ndg = Cursor_jarantbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(jarantbo->DATAINI)) and not(Empty(jarantbo->DATAFINE)) and jarantbo->DATAINI > jarantbo->DATAFINE */
          if ( ! (CPLib.Empty(Cursor_jarantbo.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_jarantbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jarantbo.GetDate("DATAINI"),Cursor_jarantbo.GetDate("DATAFINE"))) {
            /* _errore := "Rapporto - Garantito Anomalia tra Data Apertura e Data chiusura" // Errori Rilevati */
            _errore = "Rapporto - Garantito Anomalia tra Data Apertura e Data chiusura";
            /* _ndg := jarantbo->CODINTER // NDG */
            _ndg = Cursor_jarantbo.GetString("CODINTER");
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If not(Empty(jarantbo->CODINTER)) */
          if ( ! (CPLib.Empty(Cursor_jarantbo.GetString("CODINTER")))) {
            /* mcErrPers := arfn_anompers(jarantbo->CODINTER,_tiprap,pRapporto,'N',pTipo,'',pNCF) */
            mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_jarantbo.GetString("CODINTER"),_tiprap,pRapporto,"N",pTipo,"",pNCF);
            /* If mcErrPers.RecCount() > 0 */
            if (CPLib.gt(mcErrPers.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                /* _errore := rowErrore.TXTERR // Errori Rilevati */
                _errore = rowErrore.TXTERR;
                /* _ndg := rowErrore.CONNESINT // NDG */
                _ndg = rowErrore.CONNESINT;
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              }
            } // End If
          } // End If
          Cursor_jarantbo.Next();
        }
        m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
        Cursor_jarantbo.Close();
        // * --- End Select
      } // End If
      /* If pTipo='M' or pTipo='N' */
      if (CPLib.eqr(pTipo,"M") || CPLib.eqr(pTipo,"N")) {
        // * --- Select from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
        Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aetesta.Eof())) {
          /* If Empty(aetesta->COINT) */
          if (CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
            /* _errore := "Rapporto (SID) non è presente il codice natura" // Errori Rilevati */
            _errore = "Rapporto (SID) non è presente il codice natura";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(aetesta->DESCRI) and aetesta->TIPOAG='99' */
          if (CPLib.Empty(Cursor_aetesta.GetString("DESCRI")) && CPLib.eqr(Cursor_aetesta.GetString("TIPOAG"),"99")) {
            /* _errore := "Rapporto (SID) Descrizione Mancante" // Errori Rilevati */
            _errore = "Rapporto (SID) Descrizione Mancante";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If Empty(aetesta->CAB) and Empty(_cabinter) */
          if (CPLib.Empty(Cursor_aetesta.GetString("CAB")) && CPLib.Empty(_cabinter)) {
            /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" codice CAB assente" // Errori Rilevati */
            _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" codice CAB assente";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
            /* ElseIf not(Empty(aetesta->CAB)) and Len(LRTrim(aetesta->CAB)) < 5 */
          } else if ( ! (CPLib.Empty(Cursor_aetesta.GetString("CAB"))) && CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_aetesta.GetString("CAB"))),5)) {
            /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" CAB anomalo" // Errori Rilevati */
            _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" CAB anomalo";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
            /* ElseIf Empty(aetesta->CAB) and not(Empty(_cabinter)) and Len(LRTrim(_cabinter)) < 5 */
          } else if (CPLib.Empty(Cursor_aetesta.GetString("CAB")) &&  ! (CPLib.Empty(_cabinter)) && CPLib.lt(CPLib.Len(CPLib.LRTrim(_cabinter)),5)) {
            /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" CAB anomalo" // Errori Rilevati */
            _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" CAB anomalo";
            /* _ndg := '' // NDG */
            _ndg = "";
            /* Exec "Scrive Errori" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If At(aetesta->TIPOAG,"01|02|03|04|05|06|07|09|10|14|15|23|24") <> 0 */
          if (CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"01|02|03|04|05|06|07|09|10|14|15|23|24"),0)) {
            /* If Empty(aetesta->VALUTA) */
            if (CPLib.Empty(Cursor_aetesta.GetString("VALUTA"))) {
              /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" non è presente il codice valuta" // Errori Rilevati */
              _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" non è presente il codice valuta";
              /* _ndg := '' // NDG */
              _ndg = "";
              /* Exec "Scrive Errori" Page 2:Page_2 */
              Page_2();
            } else { // Else
            } // End If
          } // End If
          /* If At(aetesta->TIPOAG,'01|02|03|04|05|06|07|09|10|12|14|15|23|24') <> 0 */
          if (CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"01|02|03|04|05|06|07|09|10|12|14|15|23|24"),0)) {
            // * --- Select from qbe_famesiti_intestbo_minmax
            SPBridge.HMCaller _h0000015B;
            _h0000015B = new SPBridge.HMCaller();
            _h0000015B.Set("m_cVQRList",m_cVQRList);
            _h0000015B.Set("pRAPPORTO",Cursor_aetesta.GetString("RAPPORTO"));
            if (Cursor_qbe_famesiti_intestbo_minmax!=null)
              Cursor_qbe_famesiti_intestbo_minmax.Close();
            Cursor_qbe_famesiti_intestbo_minmax = new VQRHolder("qbe_famesiti_intestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000015B,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_famesiti_intestbo_minmax.Eof())) {
              /* _datini := qbe_famesiti_intestbo_minmax->DATAINI */
              _datini = Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI");
              /* _datfin := qbe_famesiti_intestbo_minmax->DATAFINE */
              _datfin = Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAFINE");
              Cursor_qbe_famesiti_intestbo_minmax.Next();
            }
            m_cConnectivityError = Cursor_qbe_famesiti_intestbo_minmax.ErrorMessage();
            Cursor_qbe_famesiti_intestbo_minmax.Close();
            // * --- End Select
            /* If Empty(_datini) */
            if (CPLib.Empty(_datini)) {
              // * --- Select from qbe_famesiti_jntestbo_minmax
              SPBridge.HMCaller _h0000015F;
              _h0000015F = new SPBridge.HMCaller();
              _h0000015F.Set("m_cVQRList",m_cVQRList);
              _h0000015F.Set("pRAPPORTO",Cursor_aetesta.GetString("RAPPORTO"));
              if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
                Cursor_qbe_famesiti_jntestbo_minmax.Close();
              Cursor_qbe_famesiti_jntestbo_minmax = new VQRHolder("qbe_famesiti_jntestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000015F,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_famesiti_jntestbo_minmax.Eof())) {
                /* _datini := qbe_famesiti_jntestbo_minmax->DATAINI */
                _datini = Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI");
                /* _datfin := qbe_famesiti_jntestbo_minmax->DATAFINE */
                _datfin = Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAFINE");
                Cursor_qbe_famesiti_jntestbo_minmax.Next();
              }
              m_cConnectivityError = Cursor_qbe_famesiti_jntestbo_minmax.ErrorMessage();
              Cursor_qbe_famesiti_jntestbo_minmax.Close();
              // * --- End Select
            } // End If
            /* _annobase := iif(Year(_datini)<2011,2011,Year(_datini)) */
            _annobase = CPLib.Round((CPLib.lt(CPLib.Year(_datini),2011)?2011:CPLib.Year(_datini)),0);
            /* _annooggi := Year(Date()) */
            _annooggi = CPLib.Round(CPLib.Year(CPLib.Date()),0);
            /* _conta := 0 */
            _conta = CPLib.Round(0,0);
            /* If _annobase < _annooggi */
            if (CPLib.lt(_annobase,_annooggi)) {
              /* _annofine := _annooggi - 1 */
              _annofine = CPLib.Round(_annooggi-1,0);
              /* If not(Empty(_datfin)) */
              if ( ! (CPLib.Empty(_datfin))) {
                /* _annofine := iif(Year(_datfin) <_annooggi,Year(_datfin),_annofine) */
                _annofine = CPLib.Round((CPLib.lt(CPLib.Year(_datfin),_annooggi)?CPLib.Year(_datfin):_annofine),0);
              } // End If
              // Setta variabili per il ciclo
              _annob = (int) _annobase;
              _annof = (int) _annofine;
              for (int _i = _annob; CPLib.ne(_i,_annof); _i = _i + (1)) {
                /* _passa := 0 */
                _passa = CPLib.Round(0,0);
                /* If _i = (_annooggi - 1) and DateDiff(gScadSaldi,Date()) < 90 */
                if (CPLib.eqr(_i,(_annooggi-1)) && CPLib.lt(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)) {
                  /* _passa := 1 */
                  _passa = CPLib.Round(1,0);
                } // End If
                /* If _passa=0 */
                if (CPLib.eqr(_passa,0)) {
                  /* _annoc := Str(_i,4,0) */
                  _annoc = CPLib.Str(_i,4,0);
                  /* _conta := 0 */
                  _conta = CPLib.Round(0,0);
                  // * --- Select from aeannora
                  m_cServer = m_Ctx.GetServer("aeannora");
                  m_cPhName = m_Ctx.GetPhName("aeannora");
                  if (Cursor_aeannora!=null)
                    Cursor_aeannora.Close();
                  Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_annoc)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_aeannora.Eof())) {
                    /* _conta := _conta + 1 */
                    _conta = CPLib.Round(_conta+1,0);
                    Cursor_aeannora.Next();
                  }
                  m_cConnectivityError = Cursor_aeannora.ErrorMessage();
                  Cursor_aeannora.Close();
                  // * --- End Select
                  /* If _conta=0 */
                  if (CPLib.eqr(_conta,0)) {
                    /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" - Saldi dell'anno "+_annoc+" mancanti" // Errori Rilevati */
                    _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" - Saldi dell'anno "+_annoc+" mancanti";
                    /* _ndg := '' // NDG */
                    _ndg = "";
                    /* Exec "Scrive Errori" Page 2:Page_2 */
                    Page_2();
                  } // End If
                  /* If _conta>1 */
                  if (CPLib.gt(_conta,1)) {
                    /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" - Saldi dell'anno "+_annoc+" duplicati" // Errori Rilevati */
                    _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" - Saldi dell'anno "+_annoc+" duplicati";
                    /* _ndg := '' // NDG */
                    _ndg = "";
                    /* Exec "Scrive Errori" Page 2:Page_2 */
                    Page_2();
                  } // End If
                } // End If
              }
            } // End If
            // * --- Select from aeannora
            m_cServer = m_Ctx.GetServer("aeannora");
            m_cPhName = m_Ctx.GetPhName("aeannora");
            if (Cursor_aeannora!=null)
              Cursor_aeannora.Close();
            Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aeannora.Eof())) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* If Empty(aeannora->ANNO) */
              if (CPLib.Empty(Cursor_aeannora.GetString("ANNO"))) {
                /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" anomalia nell'anno dei saldi (anno mancante ma saldi presenti)" // Errori Rilevati */
                _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" anomalia nell'anno dei saldi (anno mancante ma saldi presenti)";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
              /* If not(Empty(_datini)) and Val(aeannora->ANNO) < Year(_datini) */
              if ( ! (CPLib.Empty(_datini)) && CPLib.lt(CPLib.Val(Cursor_aeannora.GetString("ANNO")),CPLib.Year(_datini))) {
                /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" anno dei saldi "+aeannora->ANNO+" non congruente (anno inferiore a data inizio rapporto)" // Errori Rilevati */
                _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" anno dei saldi "+Cursor_aeannora.GetString("ANNO")+" non congruente (anno inferiore a data inizio rapporto)";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
              /* If not(Empty(_datfin)) and Val(aeannora->ANNO) > Year(_datfin) */
              if ( ! (CPLib.Empty(_datfin)) && CPLib.gt(CPLib.Val(Cursor_aeannora.GetString("ANNO")),CPLib.Year(_datfin))) {
                /* _errore := 'Rapporto (SID) '+LRTrim(pRapporto)+" anno dei saldi "+aeannora->ANNO+" non congruente (anno superiore a data fine rapporto)" // Errori Rilevati */
                _errore = "Rapporto (SID) "+CPLib.LRTrim(pRapporto)+" anno dei saldi "+Cursor_aeannora.GetString("ANNO")+" non congruente (anno superiore a data fine rapporto)";
                /* _ndg := '' // NDG */
                _ndg = "";
                /* Exec "Scrive Errori" Page 2:Page_2 */
                Page_2();
              } // End If
              Cursor_aeannora.Next();
            }
            m_cConnectivityError = Cursor_aeannora.ErrorMessage();
            Cursor_aeannora.Close();
            // * --- End Select
          } // End If
          Cursor_aetesta.Next();
        }
        m_cConnectivityError = Cursor_aetesta.ErrorMessage();
        Cursor_aetesta.Close();
        // * --- End Select
      } // End If
      /* Return mcErrori */
      throw new Stop(mcErrori);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_intestbo_minmax!=null)
          Cursor_qbe_famesiti_intestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
          Cursor_qbe_famesiti_jntestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeannora!=null)
          Cursor_aeannora.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* mcErrori.AppendBlank() */
    mcErrori.AppendBlank();
    /* mcErrori.TIPO := pTipo */
    mcErrori.row.TIPO = pTipo;
    /* mcErrori.RAPPORTO := pRapporto */
    mcErrori.row.RAPPORTO = pRapporto;
    /* mcErrori.TXTERR := _errore */
    mcErrori.row.TXTERR = _errore;
    /* mcErrori.CONNESINT := _ndg */
    mcErrori.row.CONNESINT = _ndg;
    /* mcErrori.SaveRow() */
    mcErrori.SaveRow();
  }
  void _init_() {
  }
  public String RunAsync(String p_pRapporto,String p_pTipo,String p_pNCF) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pNCF = p_pNCF;
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
  public MemoryCursor_mcerrsaldi_mcrdef Run(String p_pRapporto,String p_pTipo,String p_pNCF) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pNCF = p_pNCF;
    return Run();
  }
  public MemoryCursor_mcerrsaldi_mcrdef Run() {
    MemoryCursor_mcerrsaldi_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_mcerrsaldi_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_anomes_rappR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anomes_rappR(p_Ctx, p_Caller);
  }
  public static arfn_anomes_rappR Make(CPContext p_Ctx) {
    return new arfn_anomes_rappR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(25);
    pTipo = CPLib.Space(1);
    pNCF = CPLib.Space(1);
    _conta = 0;
    _errore = CPLib.Space(128);
    _ndg = CPLib.Space(16);
    _tiprap = CPLib.Space(1);
    _cab = CPLib.Space(5);
    mcErrori = new MemoryCursor_mcerrsaldi_mcrdef();
    mcErrPers = new MemoryCursor_mcerrsaldi_mcrdef();
    rowErrore = new MemoryCursorRow_mcerrsaldi_mcrdef();
    _codfisc = CPLib.Space(16);
    _rapporto = CPLib.Space(25);
    _cfestero = 0;
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _annobase = 0;
    _annooggi = 0;
    _annofine = 0;
    _passa = 0;
    _annoc = CPLib.Space(4);
    _cabinter = CPLib.Space(5);
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famesiti_intestbo_minmax,qbe_famesiti_jntestbo_minmax,
  public static final String m_cVQRList = ",qbe_famesiti_intestbo_minmax,qbe_famesiti_jntestbo_minmax,";
  // ENTITY_BATCHES: ,arfn_anomes_rapp,arfn_anompers,
  public static final String i_InvokedRoutines = ",arfn_anomes_rapp,arfn_anompers,";
  public static String[] m_cRunParameterNames={"pRapporto","pTipo","pNCF"};
}
