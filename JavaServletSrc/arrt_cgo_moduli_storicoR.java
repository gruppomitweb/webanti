// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_moduli_storicoR implements CallerWithObjs {
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
  public String m_cPhName_tmp_cgo_operazioni;
  public String m_cServer_tmp_cgo_operazioni;
  public String m_cPhName_cgo_stampeav;
  public String m_cServer_cgo_stampeav;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_cgo_operazioni_storico_multi;
  public String m_cServer_cgo_operazioni_storico_multi;
  public String m_cPhName_cgo_autorita;
  public String m_cServer_cgo_autorita;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
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
  public String w_SNAINUMOPE;
  public String w_CODFISC;
  public String w_CODDIPE;
  public String w_CAIDBIGLIETTO;
  public String w_MIDBIGLIETTO;
  public String w_MIDBIGLIETTO1;
  public String w_MIDBIGLIETTO2;
  public String w_MIDBIGLIETTO3;
  public String w_MIDBIGLIETTO4;
  public String cProg;
  public ReportLibrary _report;
  public boolean bReport;
  public String _ra1;
  public String _ra2;
  public String _flgstpd;
  public String filepdf;
  public String filename;
  public String _urldef;
  public String _mpagam;
  public String _pagam;
  public double conta;
  public double conta2;
  public String _tipgio;
  public String _desaut;
  public String _modello;
  public String _coddip;
  public String _concessione;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_moduli_storicoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_moduli_storico",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
      m_cPhName_tmp_cgo_operazioni = p_ContextObject.GetPhName("tmp_cgo_operazioni");
      if (m_cPhName_tmp_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_cgo_operazioni = m_cPhName_tmp_cgo_operazioni+" "+m_Ctx.GetWritePhName("tmp_cgo_operazioni");
      }
      m_cServer_tmp_cgo_operazioni = p_ContextObject.GetServer("tmp_cgo_operazioni");
    }
    m_cPhName_cgo_stampeav = p_ContextObject.GetPhName("cgo_stampeav");
    if (m_cPhName_cgo_stampeav.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_stampeav = m_cPhName_cgo_stampeav+" "+m_Ctx.GetWritePhName("cgo_stampeav");
    }
    m_cServer_cgo_stampeav = p_ContextObject.GetServer("cgo_stampeav");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_cgo_operazioni_storico_multi = p_ContextObject.GetPhName("cgo_operazioni_storico_multi");
    if (m_cPhName_cgo_operazioni_storico_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico_multi = m_cPhName_cgo_operazioni_storico_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico_multi");
    }
    m_cServer_cgo_operazioni_storico_multi = p_ContextObject.GetServer("cgo_operazioni_storico_multi");
    m_cPhName_cgo_autorita = p_ContextObject.GetPhName("cgo_autorita");
    if (m_cPhName_cgo_autorita.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_autorita = m_cPhName_cgo_autorita+" "+m_Ctx.GetWritePhName("cgo_autorita");
    }
    m_cServer_cgo_autorita = p_ContextObject.GetServer("cgo_autorita");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("conta2",p_cVarName)) {
      return conta2;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_moduli_storico";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      return w_SNAINUMOPE;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("CODDIPE",p_cVarName)) {
      return w_CODDIPE;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      return w_CAIDBIGLIETTO;
    }
    if (CPLib.eqr("MIDBIGLIETTO",p_cVarName)) {
      return w_MIDBIGLIETTO;
    }
    if (CPLib.eqr("MIDBIGLIETTO1",p_cVarName)) {
      return w_MIDBIGLIETTO1;
    }
    if (CPLib.eqr("MIDBIGLIETTO2",p_cVarName)) {
      return w_MIDBIGLIETTO2;
    }
    if (CPLib.eqr("MIDBIGLIETTO3",p_cVarName)) {
      return w_MIDBIGLIETTO3;
    }
    if (CPLib.eqr("MIDBIGLIETTO4",p_cVarName)) {
      return w_MIDBIGLIETTO4;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_ra1",p_cVarName)) {
      return _ra1;
    }
    if (CPLib.eqr("_ra2",p_cVarName)) {
      return _ra2;
    }
    if (CPLib.eqr("_flgstpd",p_cVarName)) {
      return _flgstpd;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      return filepdf;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("_urldef",p_cVarName)) {
      return _urldef;
    }
    if (CPLib.eqr("_mpagam",p_cVarName)) {
      return _mpagam;
    }
    if (CPLib.eqr("_pagam",p_cVarName)) {
      return _pagam;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      return _tipgio;
    }
    if (CPLib.eqr("_desaut",p_cVarName)) {
      return _desaut;
    }
    if (CPLib.eqr("_modello",p_cVarName)) {
      return _modello;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_concessione",p_cVarName)) {
      return _concessione;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      return gIPS;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      return gIPSP;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
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
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
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
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("conta2",p_cVarName)) {
      conta2 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      w_SNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("CODDIPE",p_cVarName)) {
      w_CODDIPE = value;
      return;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      w_CAIDBIGLIETTO = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO",p_cVarName)) {
      w_MIDBIGLIETTO = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO1",p_cVarName)) {
      w_MIDBIGLIETTO1 = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO2",p_cVarName)) {
      w_MIDBIGLIETTO2 = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO3",p_cVarName)) {
      w_MIDBIGLIETTO3 = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO4",p_cVarName)) {
      w_MIDBIGLIETTO4 = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_ra1",p_cVarName)) {
      _ra1 = value;
      return;
    }
    if (CPLib.eqr("_ra2",p_cVarName)) {
      _ra2 = value;
      return;
    }
    if (CPLib.eqr("_flgstpd",p_cVarName)) {
      _flgstpd = value;
      return;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      filepdf = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("_urldef",p_cVarName)) {
      _urldef = value;
      return;
    }
    if (CPLib.eqr("_mpagam",p_cVarName)) {
      _mpagam = value;
      return;
    }
    if (CPLib.eqr("_pagam",p_cVarName)) {
      _pagam = value;
      return;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      _tipgio = value;
      return;
    }
    if (CPLib.eqr("_desaut",p_cVarName)) {
      _desaut = value;
      return;
    }
    if (CPLib.eqr("_modello",p_cVarName)) {
      _modello = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_concessione",p_cVarName)) {
      _concessione = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      gIPS = value;
      return;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      gIPSP = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
      return;
    }
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_operazioni_storico=null;
    CPResultSet Cursor_cgo_operazioni_storico_multi=null;
    try {
      /* w_SNAINUMOPE Char(15) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_CODDIPE Char(6) // Codice Dipendenza */
      /* w_CAIDBIGLIETTO Char(30) // ID BIGLIETTO */
      /* w_MIDBIGLIETTO Memo // ID BIGLIETTO */
      /* w_MIDBIGLIETTO1 Memo // ID BIGLIETTO */
      /* w_MIDBIGLIETTO2 Memo // ID BIGLIETTO */
      /* w_MIDBIGLIETTO3 Memo // ID BIGLIETTO */
      /* w_MIDBIGLIETTO4 Memo // ID BIGLIETTO */
      /* cProg Char(10) */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* _ra1 Char(70) */
      /* _ra2 Char(70) */
      /* _flgstpd Char(1) */
      /* filepdf Char(128) */
      /* filename Char(128) */
      /* _urldef Char(200) */
      /* _mpagam Char(30) */
      /* _pagam Char(128) */
      /* conta Numeric(3, 0) */
      /* conta2 Numeric(3, 0) */
      /* _tipgio Char(70) */
      /* _desaut Char(15) */
      /* _modello Char(100) */
      /* _coddip Char(6) */
      /* _concessione Char(10) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* gCodDip Char(6) // Dipendenza */
      /* _coddip := '' */
      _coddip = "";
      // * --- Read from cgo_operazioni_storico
      m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
      m_cSql = "";
      m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0,m_cServer),m_cServer,w_SNAINUMOPE);
      if (m_Ctx.IsSharedTemp("cgo_operazioni_storico")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _coddip = Read_Cursor.GetString("CODDIPE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cgo_operazioni_storico into routine arrt_cgo_moduli_storico returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _coddip = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If _coddip=gCodDip */
      if (CPLib.eqr(_coddip,gCodDip)) {
        /* Crea tabella d'appoggio per stampa */
        /* _concessione := '' */
        _concessione = "";
        // * --- Read from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_cSql = "";
        m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
        if (m_Ctx.IsSharedTemp("anadip")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONCESSIONE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _concessione = Read_Cursor.GetString("CONCESSIONE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_moduli_storico returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _concessione = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _ra1 := intermbo->RASPAUI */
          _ra1 = Cursor_intermbo.GetString("RASPAUI");
          /* _ra2 := intermbo->RESPAUI */
          _ra2 = Cursor_intermbo.GetString("RESPAUI");
          /* _flgstpd := intermbo->FLGSTPDIR */
          _flgstpd = Cursor_intermbo.GetString("FLGSTPDIR");
          /* _modello := intermbo->DBPROT */
          _modello = Cursor_intermbo.GetString("DBPROT");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        // * --- Drop temporary table tmp_cgo_operazioni
        if (m_Ctx.IsSharedTemp("tmp_cgo_operazioni")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
            m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_cgo_operazioni");
        }
        // * --- Create temporary table tmp_cgo_operazioni
        if (m_Ctx.IsSharedTemp("tmp_cgo_operazioni")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
            m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_cgo_operazioni");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_cgo_operazioni");
        if ( ! (m_Ctx.IsSharedTemp("tmp_cgo_operazioni"))) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_cgo_operazioni",m_cServer,"proto")),m_cPhName,"tmp_cgo_operazioni",m_Ctx);
        }
        m_cPhName_tmp_cgo_operazioni = m_cPhName;
        // * --- Select from cgo_operazioni_storico
        m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
        Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
          /* w_CODFISC := cgo_operazioni_storico->CODFISC // Codice Fiscale */
          w_CODFISC = Cursor_cgo_operazioni_storico.GetString("CODFISC");
          /* w_CODDIPE := cgo_operazioni_storico->CODDIPE // Codice Dipendenza */
          w_CODDIPE = Cursor_cgo_operazioni_storico.GetString("CODDIPE");
          /* w_CAIDBIGLIETTO := cgo_operazioni_storico->CAIDBIGLIETTO // ID BIGLIETTO */
          w_CAIDBIGLIETTO = Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO");
          /* Case cgo_operazioni_storico->MEZPAGAM='A' */
          if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"A")) {
            /* _mpagam := 'Altro Mezzo di Pagamento' */
            _mpagam = "Altro Mezzo di Pagamento";
            /* Case cgo_operazioni_storico->MEZPAGAM='I' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"I")) {
            /* _mpagam := 'Bonifico Italia' */
            _mpagam = "Bonifico Italia";
            /* Case cgo_operazioni_storico->MEZPAGAM='E' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"E")) {
            /* _mpagam := 'Bonifico Estero' */
            _mpagam = "Bonifico Estero";
            /* Case cgo_operazioni_storico->MEZPAGAM='P' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"P")) {
            /* _mpagam := 'Bonifico Postale' */
            _mpagam = "Bonifico Postale";
            /* Case cgo_operazioni_storico->MEZPAGAM='C' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"C")) {
            /* _mpagam := 'Assegno Circolare' */
            _mpagam = "Assegno Circolare";
            /* Case cgo_operazioni_storico->MEZPAGAM='B' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"B")) {
            /* _mpagam := 'Assegno Bancario' */
            _mpagam = "Assegno Bancario";
            /* Case cgo_operazioni_storico->MEZPAGAM='V' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"V")) {
            /* _mpagam := 'Carta di Credito' */
            _mpagam = "Carta di Credito";
            /* Case cgo_operazioni_storico->MEZPAGAM='S' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"S")) {
            /* _mpagam := 'Contante' */
            _mpagam = "Contante";
            /* Case cgo_operazioni_storico->MEZPAGAM='W' */
          } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"W")) {
            /* _mpagam := 'SnayPay Wallet' */
            _mpagam = "SnayPay Wallet";
          } // End Case
          /* _tipgio := arfn_cgo_tbtipgio(cgo_operazioni_storico->TIPOGIOCO,cgo_operazioni_storico->VLTPLAT) */
          _tipgio = arfn_cgo_tbtipgioR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("TIPOGIOCO"),Cursor_cgo_operazioni_storico.GetString("VLTPLAT"));
          /* If cgo_operazioni_storico->MEZPAGAM='S' or cgo_operazioni_storico->MEZPAGAM='W' */
          if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"S") || CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"W")) {
            /* _pagam := LRTrim(_mpagam) + ' € ' +LRTrim(Str(cgo_operazioni_storico->TOTLIRE,15,2)) */
            _pagam = CPLib.LRTrim(_mpagam)+" \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE"),15,2));
          } else { // Else
            /* If cgo_operazioni_storico->TOTLIRE - (cgo_operazioni_storico->TOTCONT + cgo_operazioni_storico->IMPWALLET)=0 */
            if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")-(Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")+Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET")),0)) {
              /* _pagam := iif(cgo_operazioni_storico->FLAGCONT='1','Contanti € '+LRTrim(Str(cgo_operazioni_storico->TOTCONT,15,2)),'') */
              _pagam = (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"1")?"Contanti \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("TOTCONT"),15,2)):"");
              /* Case cgo_operazioni_storico->FLAGWALLET='1' and cgo_operazioni_storico->FLAGCONT='1' */
              if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGWALLET"),"1") && CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"1")) {
                /* _pagam := _pagam + ' - SnaiPay Wallet € '+LRTrim(Str(cgo_operazioni_storico->IMPWALLET,15,2)) */
                _pagam = _pagam+" - SnaiPay Wallet \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET"),15,2));
                /* Case cgo_operazioni_storico->FLAGWALLET='1' and cgo_operazioni_storico->FLAGCONT='0' */
              } else if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGWALLET"),"1") && CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"0")) {
                /* _pagam := 'SnaiPay Wallet € '+LRTrim(Str(cgo_operazioni_storico->IMPWALLET,15,2)) */
                _pagam = "SnaiPay Wallet \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET"),15,2));
              } // End Case
            } else { // Else
              /* _pagam := LRTrim(_mpagam) + ' € ' +LRTrim(Str((cgo_operazioni_storico->TOTLIRE - cgo_operazioni_storico->TOTCONT- cgo_operazioni_storico->IMPWALLET),15,2)) */
              _pagam = CPLib.LRTrim(_mpagam)+" \u20ac "+CPLib.LRTrim(CPLib.Str((Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")-Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")-Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET")),15,2));
              /* _pagam := _pagam + iif(cgo_operazioni_storico->FLAGCONT='1',' - Contanti € '+LRTrim(Str(cgo_operazioni_storico->TOTCONT,15,2)),'') */
              _pagam = _pagam+(CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"1")?" - Contanti \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("TOTCONT"),15,2)):"");
              /* _pagam := _pagam + iif(cgo_operazioni_storico->FLAGWALLET='1',' - SnaiPay Wallet € '+LRTrim(Str(cgo_operazioni_storico->IMPWALLET,15,2)),'') */
              _pagam = _pagam+(CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGWALLET"),"1")?" - SnaiPay Wallet \u20ac "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET"),15,2)):"");
            } // End If
          } // End If
          /* w_MIDBIGLIETTO := '' // ID BIGLIETTO */
          w_MIDBIGLIETTO = "";
          /* w_MIDBIGLIETTO1 := '' // ID BIGLIETTO */
          w_MIDBIGLIETTO1 = "";
          /* w_MIDBIGLIETTO2 := '' // ID BIGLIETTO */
          w_MIDBIGLIETTO2 = "";
          /* w_MIDBIGLIETTO3 := '' // ID BIGLIETTO */
          w_MIDBIGLIETTO3 = "";
          /* w_MIDBIGLIETTO4 := '' // ID BIGLIETTO */
          w_MIDBIGLIETTO4 = "";
          /* conta2 := 1 */
          conta2 = CPLib.Round(1,0);
          // * --- Select from cgo_operazioni_storico_multi
          m_cServer = m_Ctx.GetServer("cgo_operazioni_storico_multi");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico_multi");
          if (Cursor_cgo_operazioni_storico_multi!=null)
            Cursor_cgo_operazioni_storico_multi.Close();
          Cursor_cgo_operazioni_storico_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_storico_multi.Eof())) {
            /* Case conta2 = 1 */
            if (CPLib.eqr(conta2,1)) {
              /* w_MIDBIGLIETTO1 := w_MIDBIGLIETTO1 + iif(not(Empty(LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO))),LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO)+" - ",'') // ID BIGLIETTO */
              w_MIDBIGLIETTO1 = w_MIDBIGLIETTO1+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))))?CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))+" - ":"");
              /* Case conta2 = 2 */
            } else if (CPLib.eqr(conta2,2)) {
              /* w_MIDBIGLIETTO2 := w_MIDBIGLIETTO2 + iif(not(Empty(LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO))),LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO)+" - ",'') // ID BIGLIETTO */
              w_MIDBIGLIETTO2 = w_MIDBIGLIETTO2+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))))?CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))+" - ":"");
              /* Case conta2 = 3 */
            } else if (CPLib.eqr(conta2,3)) {
              /* w_MIDBIGLIETTO3 := w_MIDBIGLIETTO3 + iif(not(Empty(LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO))),LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO)+" - ",'') // ID BIGLIETTO */
              w_MIDBIGLIETTO3 = w_MIDBIGLIETTO3+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))))?CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))+" - ":"");
              /* Case conta2 = 4 */
            } else if (CPLib.eqr(conta2,4)) {
              /* w_MIDBIGLIETTO4 := w_MIDBIGLIETTO4 + iif(not(Empty(LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO))),LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO)+" - ",'') // ID BIGLIETTO */
              w_MIDBIGLIETTO4 = w_MIDBIGLIETTO4+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))))?CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))+" - ":"");
            } // End Case
            /* w_MIDBIGLIETTO := w_MIDBIGLIETTO + iif(not(Empty(LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO))),LRTrim(cgo_operazioni_storico_multi->CAIDBIGLIETTO)+" - ",'') // ID BIGLIETTO */
            w_MIDBIGLIETTO = w_MIDBIGLIETTO+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))))?CPLib.LRTrim(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"))+" - ":"");
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* If conta = 6 */
            if (CPLib.eqr(conta,6)) {
              /* w_MIDBIGLIETTO := Left(w_MIDBIGLIETTO,Len(LRTrim(w_MIDBIGLIETTO)) - 2) // ID BIGLIETTO */
              w_MIDBIGLIETTO = CPLib.Left(w_MIDBIGLIETTO,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO))-2);
              /* conta := 0 */
              conta = CPLib.Round(0,0);
              /* conta2 := conta2 + 1 */
              conta2 = CPLib.Round(conta2+1,0);
            } // End If
            Cursor_cgo_operazioni_storico_multi.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_storico_multi.ErrorMessage();
          Cursor_cgo_operazioni_storico_multi.Close();
          // * --- End Select
          /* If not(Empty(LRTrim(w_MIDBIGLIETTO))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(w_MIDBIGLIETTO)))) {
            /* If conta < 6 */
            if (CPLib.lt(conta,6)) {
              /* w_MIDBIGLIETTO := Left(w_MIDBIGLIETTO,Len(LRTrim(w_MIDBIGLIETTO)) - 2) // ID BIGLIETTO */
              w_MIDBIGLIETTO = CPLib.Left(w_MIDBIGLIETTO,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO))-2);
            } // End If
            /* w_MIDBIGLIETTO1 := Left(w_MIDBIGLIETTO1,Len(LRTrim(w_MIDBIGLIETTO1)) - 2) // ID BIGLIETTO */
            w_MIDBIGLIETTO1 = CPLib.Left(w_MIDBIGLIETTO1,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO1))-2);
            /* w_MIDBIGLIETTO2 := Left(w_MIDBIGLIETTO2,Len(LRTrim(w_MIDBIGLIETTO2)) - 2) // ID BIGLIETTO */
            w_MIDBIGLIETTO2 = CPLib.Left(w_MIDBIGLIETTO2,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO2))-2);
            /* w_MIDBIGLIETTO3 := Left(w_MIDBIGLIETTO3,Len(LRTrim(w_MIDBIGLIETTO3)) - 2) // ID BIGLIETTO */
            w_MIDBIGLIETTO3 = CPLib.Left(w_MIDBIGLIETTO3,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO3))-2);
            /* w_MIDBIGLIETTO4 := Left(w_MIDBIGLIETTO4,Len(LRTrim(w_MIDBIGLIETTO4)) - 2) // ID BIGLIETTO */
            w_MIDBIGLIETTO4 = CPLib.Left(w_MIDBIGLIETTO4,CPLib.Len(CPLib.LRTrim(w_MIDBIGLIETTO4))-2);
          } else { // Else
            /* w_MIDBIGLIETTO := cgo_operazioni_storico->CAIDBIGLIETTO // ID BIGLIETTO */
            w_MIDBIGLIETTO = Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO");
            /* w_MIDBIGLIETTO1 := cgo_operazioni_storico->CAIDBIGLIETTO // ID BIGLIETTO */
            w_MIDBIGLIETTO1 = Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO");
          } // End If
          /* _desaut := '' */
          _desaut = "";
          // * --- Read from cgo_autorita
          m_cServer = m_Ctx.GetServer("cgo_autorita");
          m_cPhName = m_Ctx.GetPhName("cgo_autorita");
          m_cSql = "";
          m_cSql = m_cSql+"ARCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDCODAUT"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("RDCODAUT"));
          if (m_Ctx.IsSharedTemp("cgo_autorita")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ARDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _desaut = Read_Cursor.GetString("ARDESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cgo_autorita into routine arrt_cgo_moduli_storico returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _desaut = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_cgo_operazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_cgo_operazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_moduli_storico",115,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("CACODICE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("CFESTERO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODCABDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("DESCCITDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PEP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PROVINCIADIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("CAFLGOPE"),"V")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("CAFLGOPE"),"G")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("CAFLGOPE"),"P")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("CAFLGOPE"),"R")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"I") || CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"E") || CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"P")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"B") || CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"C")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ra1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ra2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_MIDBIGLIETTO,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_pagam,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_MIDBIGLIETTO1,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_MIDBIGLIETTO2,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_MIDBIGLIETTO3,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_MIDBIGLIETTO4,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("ASSEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("VLTPLAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CC4CIFRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CCDATSCA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"V")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_desaut,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"S")?"X":""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CGOFLGVLT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PEPDESCRI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("DOMICILIO2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("DESCCIT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PROVINCIA2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PAESE2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("FLGDOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PROFESSIONE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetDouble("IMPWALLET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODWALLET"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("FLAGWALLET"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_concessione,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODTRANSZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_cgo_operazioni",true);
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
          Cursor_cgo_operazioni_storico.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
        Cursor_cgo_operazioni_storico.Close();
        // * --- End Select
        /* Crea il primo report */
        /* filename := LRTrim(w_CODDIPE)+"_"+LRTrim(w_CODFISC)+"_"+LRTrim(w_CAIDBIGLIETTO)+LibreriaMit.UniqueId() */
        filename = CPLib.LRTrim(w_CODDIPE)+"_"+CPLib.LRTrim(w_CODFISC)+"_"+CPLib.LRTrim(w_CAIDBIGLIETTO)+LibreriaMit.UniqueId();
        /* cProg := Utilities.GetAutonumber("PSTPMAV\'"+LRTrim(gAzienda)+"'","",10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTPMAV\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into cgo_stampeav from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_stampeav");
        m_cPhName = m_Ctx.GetPhName("cgo_stampeav");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_stampeav",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_moduli_storico",115,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_CODFISC,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_CODDIPE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(filename)+".pdf","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_stampeav",true);
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
        /* _report := ReportLibrary.GetReportLibrary() */
        _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
        /* _report.setFileName(LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+"/"+filename) */
        _report.setFileName(CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+filename);
        /* _report.addReport('arrp_snai_stp_mod_identificazione_cliente',_modello,False) */
        _report.addReport("arrp_snai_stp_mod_identificazione_cliente",_modello,false);
        /* bReport := _report.makeXmlStrReport() */
        bReport = _report.makeXmlStrReport();
      } else { // Else
        /* cProg := 'KO' */
        cProg = "KO";
      } // End If
      /* Return cProg */
      throw new Stop(cProg);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_storico_multi!=null)
          Cursor_cgo_operazioni_storico_multi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_SNAINUMOPE) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
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
  public String Run(String p_w_SNAINUMOPE) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arrt_cgo_moduli_storicoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_moduli_storicoR(p_Ctx, p_Caller);
  }
  public static arrt_cgo_moduli_storicoR Make(CPContext p_Ctx) {
    return new arrt_cgo_moduli_storicoR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_SNAINUMOPE = CPLib.Space(15);
    w_CODFISC = CPLib.Space(16);
    w_CODDIPE = CPLib.Space(6);
    w_CAIDBIGLIETTO = CPLib.Space(30);
    w_MIDBIGLIETTO = "";
    w_MIDBIGLIETTO1 = "";
    w_MIDBIGLIETTO2 = "";
    w_MIDBIGLIETTO3 = "";
    w_MIDBIGLIETTO4 = "";
    cProg = CPLib.Space(10);
    _report = null;
    bReport = false;
    _ra1 = CPLib.Space(70);
    _ra2 = CPLib.Space(70);
    _flgstpd = CPLib.Space(1);
    filepdf = CPLib.Space(128);
    filename = CPLib.Space(128);
    _urldef = CPLib.Space(200);
    _mpagam = CPLib.Space(30);
    _pagam = CPLib.Space(128);
    conta = 0;
    conta2 = 0;
    _tipgio = CPLib.Space(70);
    _desaut = CPLib.Space(15);
    _modello = CPLib.Space(100);
    _coddip = CPLib.Space(6);
    _concessione = CPLib.Space(10);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_tbtipgio,arrt_cgo_moduli_storico,
  public static final String i_InvokedRoutines = ",arfn_cgo_tbtipgio,arrt_cgo_moduli_storico,";
  public static String[] m_cRunParameterNames={"w_SNAINUMOPE"};
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLGVIN,";
    p_cSql = p_cSql+"FLGGIO,";
    p_cSql = p_cSql+"FLGPRE,";
    p_cSql = p_cSql+"FLGVER,";
    p_cSql = p_cSql+"FLGBON,";
    p_cSql = p_cSql+"FLGASS,";
    p_cSql = p_cSql+"RESPANTI1,";
    p_cSql = p_cSql+"RESPANTI2,";
    p_cSql = p_cSql+"MIDBIGLIETTO,";
    p_cSql = p_cSql+"PAGAMENTO,";
    p_cSql = p_cSql+"MIGBIGLIETTO1,";
    p_cSql = p_cSql+"MIGBIGLIETTO2,";
    p_cSql = p_cSql+"MIGBIGLIETTO3,";
    p_cSql = p_cSql+"MIGBIGLIETTO4,";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"VLTPLAT,";
    p_cSql = p_cSql+"CC4CIFRE,";
    p_cSql = p_cSql+"CCDATSCA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"FLAGCC,";
    p_cSql = p_cSql+"DAUTRIL,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"FLAGCN,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"PEPDESCRI,";
    p_cSql = p_cSql+"DOMICILIO2,";
    p_cSql = p_cSql+"DESCCIT2,";
    p_cSql = p_cSql+"PROVINCIA2,";
    p_cSql = p_cSql+"PAESE2,";
    p_cSql = p_cSql+"CAP2,";
    p_cSql = p_cSql+"FLGDOM,";
    p_cSql = p_cSql+"PROFESSIONE,";
    p_cSql = p_cSql+"IMPWALLET,";
    p_cSql = p_cSql+"CODWALLET,";
    p_cSql = p_cSql+"FLAGWALLET,";
    p_cSql = p_cSql+"CONCESSIONE,";
    p_cSql = p_cSql+"CODTRANSZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESCODICE,";
    p_cSql = p_cSql+"ESCONNES,";
    p_cSql = p_cSql+"ESCODDIP,";
    p_cSql = p_cSql+"ESIDTICKET,";
    p_cSql = p_cSql+"ESDATREP,";
    p_cSql = p_cSql+"ESNUMREP,";
    p_cSql = p_cSql+"ESNOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_stampeav",true);
    return p_cSql;
  }
}
