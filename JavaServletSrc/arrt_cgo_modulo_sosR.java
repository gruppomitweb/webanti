// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_modulo_sosR implements CallerWithObjs {
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
  public String m_cPhName_cgo_stampeav;
  public String m_cServer_cgo_stampeav;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_cgo_autorita;
  public String m_cServer_cgo_autorita;
  public String m_cPhName_cgo_sos;
  public String m_cServer_cgo_sos;
  public String m_cPhName_tmp_cgo_sos;
  public String m_cServer_tmp_cgo_sos;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public double pSOS;
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
  public String _tipgio;
  public String _desaut;
  public String _modello;
  public String _nomerep;
  public String _tipdoc;
  public String _comsta;
  public String _stares;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_modulo_sosR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_modulo_sos",m_Caller);
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
    m_cPhName_cgo_autorita = p_ContextObject.GetPhName("cgo_autorita");
    if (m_cPhName_cgo_autorita.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_autorita = m_cPhName_cgo_autorita+" "+m_Ctx.GetWritePhName("cgo_autorita");
    }
    m_cServer_cgo_autorita = p_ContextObject.GetServer("cgo_autorita");
    m_cPhName_cgo_sos = p_ContextObject.GetPhName("cgo_sos");
    if (m_cPhName_cgo_sos.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_sos = m_cPhName_cgo_sos+" "+m_Ctx.GetWritePhName("cgo_sos");
    }
    m_cServer_cgo_sos = p_ContextObject.GetServer("cgo_sos");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_sos")) {
      m_cPhName_tmp_cgo_sos = p_ContextObject.GetPhName("tmp_cgo_sos");
      if (m_cPhName_tmp_cgo_sos.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_cgo_sos = m_cPhName_tmp_cgo_sos+" "+m_Ctx.GetWritePhName("tmp_cgo_sos");
      }
      m_cServer_tmp_cgo_sos = p_ContextObject.GetServer("tmp_cgo_sos");
    }
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    if (m_cPhName_cgo_tipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tipdoc = m_cPhName_cgo_tipdoc+" "+m_Ctx.GetWritePhName("cgo_tipdoc");
    }
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pSOS",p_cVarName)) {
      return pSOS;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_modulo_sos";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      return _tipdoc;
    }
    if (CPLib.eqr("_comsta",p_cVarName)) {
      return _comsta;
    }
    if (CPLib.eqr("_stares",p_cVarName)) {
      return _stares;
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
    if (CPLib.eqr("pSOS",p_cVarName)) {
      pSOS = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      _tipdoc = value;
      return;
    }
    if (CPLib.eqr("_comsta",p_cVarName)) {
      _comsta = value;
      return;
    }
    if (CPLib.eqr("_stares",p_cVarName)) {
      _stares = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_sos=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pSOS Numeric(10, 0) */
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
      /* _tipgio Char(70) */
      /* _desaut Char(15) */
      /* _modello Char(100) */
      /* _nomerep Char(50) */
      /* _tipdoc Char(30) */
      /* _comsta Char(40) */
      /* _stares Char(40) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* Crea tabella d'appoggio per stampa */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _flgstpd := intermbo->FLGSTPDIR */
        _flgstpd = Cursor_intermbo.GetString("FLGSTPDIR");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_cgo_sos
      if (m_Ctx.IsSharedTemp("tmp_cgo_sos")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_sos")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_sos");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_sos");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_sos");
      }
      // * --- Create temporary table tmp_cgo_sos
      if (m_Ctx.IsSharedTemp("tmp_cgo_sos")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_sos")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_sos");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_sos");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_sos");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_cgo_sos");
      if ( ! (m_Ctx.IsSharedTemp("tmp_cgo_sos"))) {
        m_cServer = m_Ctx.GetServer("tmp_cgo_sos");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_cgo_sos",m_cServer,"proto")),m_cPhName,"tmp_cgo_sos",m_Ctx);
      }
      m_cPhName_tmp_cgo_sos = m_cPhName;
      // * --- Select from cgo_sos
      m_cServer = m_Ctx.GetServer("cgo_sos");
      m_cPhName = m_Ctx.GetPhName("cgo_sos");
      if (Cursor_cgo_sos!=null)
        Cursor_cgo_sos.Close();
      Cursor_cgo_sos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SOSCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSOS,"?",0,0,m_cServer, m_oParameters),m_cServer,pSOS)+" "+")"+(m_Ctx.IsSharedTemp("cgo_sos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_sos.Eof())) {
        /* Case cgo_sos->SOSMEZPAG='A' */
        if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"A")) {
          /* _mpagam := 'Altro Mezzo' */
          _mpagam = "Altro Mezzo";
          /* Case cgo_sos->SOSMEZPAG='B' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"B")) {
          /* _mpagam := 'Assegno Bancario' */
          _mpagam = "Assegno Bancario";
          /* Case cgo_sos->SOSMEZPAG='C' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"C")) {
          /* _mpagam := 'Assegno Circolare' */
          _mpagam = "Assegno Circolare";
          /* Case cgo_sos->SOSMEZPAG='E' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"E")) {
          /* _mpagam := 'Bonifico Estero' */
          _mpagam = "Bonifico Estero";
          /* Case cgo_sos->SOSMEZPAG='I' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"I")) {
          /* _mpagam := 'Bonifico Italia' */
          _mpagam = "Bonifico Italia";
          /* Case cgo_sos->SOSMEZPAG='P' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"P")) {
          /* _mpagam := 'Bonifico Postale' */
          _mpagam = "Bonifico Postale";
          /* Case cgo_sos->SOSMEZPAG='S' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"S")) {
          /* _mpagam := 'Contante' */
          _mpagam = "Contante";
          /* Case cgo_sos->SOSMEZPAG='V' */
        } else if (CPLib.eqr(Cursor_cgo_sos.GetString("SOSMEZPAG"),"V")) {
          /* _mpagam := 'Carta di Credito' */
          _mpagam = "Carta di Credito";
        } // End Case
        /* _stares := '' */
        _stares = "";
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEPAE"),"C",3,0,m_cServer),m_cServer,Cursor_cgo_sos.GetString("SOSCLIEPAE"));
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _stares = Read_Cursor.GetString("DESCRI");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_cgo_modulo_sos returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _stares = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _comsta := iif(cgo_sos->SOSCLIEPAE='086',cgo_sos->SOSCLIECR,_stares) */
        _comsta = (CPLib.eqr(Cursor_cgo_sos.GetString("SOSCLIEPAE"),"086")?Cursor_cgo_sos.GetString("SOSCLIECR"):_stares);
        /* _tipdoc := '' */
        _tipdoc = "";
        // * --- Read from cgo_tipdoc
        m_cServer = m_Ctx.GetServer("cgo_tipdoc");
        m_cPhName = m_Ctx.GetPhName("cgo_tipdoc");
        m_cSql = "";
        m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIETD"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_sos.GetString("SOSCLIETD"));
        if (m_Ctx.IsSharedTemp("cgo_tipdoc")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipdoc = Read_Cursor.GetString("DESCRI");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_tipdoc into routine arrt_cgo_modulo_sos returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipdoc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipgio := iif(cgo_sos->SOSTIPOOP='G','Giocata','Vincita') */
        _tipgio = (CPLib.eqr(Cursor_cgo_sos.GetString("SOSTIPOOP"),"G")?"Giocata":"Vincita");
        // * --- Insert into tmp_cgo_sos from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_cgo_sos");
        m_cPhName = m_Ctx.GetPhName("tmp_cgo_sos");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_cgo_sos",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_modulo_sos",86,"00000031")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000031(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDouble("SOSCODICE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCODDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNANT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNAFAX"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNAEM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNACF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNACOG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNANOM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNALN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSSEGNAPN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSSEGNADN"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_sos.GetString("SOSSEGNASX"),"M")?"X":""),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_sos.GetString("SOSSEGNASX"),"F")?"X":""),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_sos.GetString("SOSSTATOOP"),"E")?"Eseguita":"Non Eseguita"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSDATAOP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_mpagam,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSDESOPE"),"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSMOTSOS"),"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIECOG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIENOM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIELN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEPN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSCLIEDN"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_sos.GetString("SOSCLIESX"),"M")?"X":""),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_sos.GetString("SOSCLIESX"),"F")?"X":""),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIECF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEPAE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEIND"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_comsta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIECAR"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEPR"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEND"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSCLIEDRD"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSCLIEDSD"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCLIEAUD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDouble("SOSUTENTE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDouble("SOSIMPOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetDate("SOSDATSEG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSNUMBON"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSNUMASS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSBANASS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_cgo_sos",true);
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
        Cursor_cgo_sos.Next();
      }
      m_cConnectivityError = Cursor_cgo_sos.ErrorMessage();
      Cursor_cgo_sos.Close();
      // * --- End Select
      /* _nomerep := "sos_"+Right('0000000000'+LRTrim(Str(pSOS,10,0)),10) */
      _nomerep = "sos_"+CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(pSOS,10,0)),10);
      /* Crea il primo report */
      /* _report := ReportLibrary.GetReportLibrary() */
      _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
      /* _report.setFileName(LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+"/"+LRTrim(_nomerep)) */
      _report.setFileName(CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomerep));
      /* Case Upper(gAzienda)='SNAI' */
      if (CPLib.eqr(CPLib.Upper(gAzienda),"SNAI")) {
        /* _report.addReport('arrp_cgo_sos','armod_snai_sos.mrp',False) */
        _report.addReport("arrp_cgo_sos","armod_snai_sos.mrp",false);
        /* Case Upper(gAzienda)='SUNBET' */
      } else if (CPLib.eqr(CPLib.Upper(gAzienda),"SUNBET")) {
        /* _report.addReport('arrp_cgo_sos','armod_sunbet_sos.mrp',False) */
        _report.addReport("arrp_cgo_sos","armod_sunbet_sos.mrp",false);
      } // End Case
      /* bReport := _report.makeXmlStrReport() */
      bReport = _report.makeXmlStrReport();
      /* _urldef := LRTrim(gUrlApp) */
      _urldef = CPLib.LRTrim(gUrlApp);
      /* filepdf := LRTrim(Strtran(gPathApp,'/','//'))+"//stampe_off//"+LRTrim(gAzienda)+"//"+LRTrim(_nomerep)+'.pdf' */
      filepdf = CPLib.LRTrim(CPLib.Strtran(gPathApp,"/","//"))+"//stampe_off//"+CPLib.LRTrim(gAzienda)+"//"+CPLib.LRTrim(_nomerep)+".pdf";
      /* filename := LRTrim(_nomerep)+'.pdf' */
      filename = CPLib.LRTrim(_nomerep)+".pdf";
      /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filepdf)+"&delFile=S" */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filepdf)+"&delFile=S",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_sos!=null)
          Cursor_cgo_sos.Close();
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
  void _init_() {
  }
  public String RunAsync(double p_pSOS) {
    pSOS = p_pSOS;
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
  public Forward Run(double p_pSOS) {
    pSOS = p_pSOS;
    return Run();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_modulo_sosR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_modulo_sosR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pSOS = 0;
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
    _tipgio = CPLib.Space(70);
    _desaut = CPLib.Space(15);
    _modello = CPLib.Space(100);
    _nomerep = CPLib.Space(50);
    _tipdoc = CPLib.Space(30);
    _comsta = CPLib.Space(40);
    _stares = CPLib.Space(40);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pSOS"};
  protected static String GetFieldsName_00000031(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SOSCODICE,";
    p_cSql = p_cSql+"SOSCODDIP,";
    p_cSql = p_cSql+"SOSSEGNANT,";
    p_cSql = p_cSql+"SOSSEGNAFAX,";
    p_cSql = p_cSql+"SOSSEGNAEM,";
    p_cSql = p_cSql+"SOSSEGNACF,";
    p_cSql = p_cSql+"SOSSEGNACOG,";
    p_cSql = p_cSql+"SOSSEGNANOM,";
    p_cSql = p_cSql+"SOSSEGNALN,";
    p_cSql = p_cSql+"SOSSEGNAPN,";
    p_cSql = p_cSql+"SOSSEGNADN,";
    p_cSql = p_cSql+"SOSSEGNASXM,";
    p_cSql = p_cSql+"SOSSEGNASXF,";
    p_cSql = p_cSql+"SOSSTATOOP,";
    p_cSql = p_cSql+"SOSDATAOP,";
    p_cSql = p_cSql+"SOSTIPOOP,";
    p_cSql = p_cSql+"SOSMEZPAG,";
    p_cSql = p_cSql+"SOSDESOPE,";
    p_cSql = p_cSql+"SOSMOTSOS,";
    p_cSql = p_cSql+"SOSCLIECOG,";
    p_cSql = p_cSql+"SOSCLIENOM,";
    p_cSql = p_cSql+"SOSCLIELN,";
    p_cSql = p_cSql+"SOSCLIEPN,";
    p_cSql = p_cSql+"SOSCLIEDN,";
    p_cSql = p_cSql+"SOSCLIESXM,";
    p_cSql = p_cSql+"SOSCLIESXF,";
    p_cSql = p_cSql+"SOSCLIECF,";
    p_cSql = p_cSql+"SOSCLIEPAE,";
    p_cSql = p_cSql+"SOSCLIEIND,";
    p_cSql = p_cSql+"SOSCLIECR,";
    p_cSql = p_cSql+"SOSCLIECAR,";
    p_cSql = p_cSql+"SOSCLIEPR,";
    p_cSql = p_cSql+"SOSCLIETD,";
    p_cSql = p_cSql+"SOSCLIEND,";
    p_cSql = p_cSql+"SOSCLIEDRD,";
    p_cSql = p_cSql+"SOSCLIEDSD,";
    p_cSql = p_cSql+"SOSCLIEAUD,";
    p_cSql = p_cSql+"SOSUTENTE,";
    p_cSql = p_cSql+"SOSIMPOPE,";
    p_cSql = p_cSql+"SOSDATSEG,";
    p_cSql = p_cSql+"SOSNUMBON,";
    p_cSql = p_cSql+"SOSNUMASS,";
    p_cSql = p_cSql+"SOSBANASS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_cgo_sos",true);
    return p_cSql;
  }
}
