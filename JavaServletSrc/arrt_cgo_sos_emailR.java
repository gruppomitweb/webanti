// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_sos_emailR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cgo_sos;
  public String m_cServer_cgo_sos;
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
  public double pCodice;
  public String _srvmail;
  public double _prtmail;
  public String _emlmail;
  public String _usrmail;
  public String _pwdmail;
  public String _destsos;
  public String _testo;
  public String _desdip;
  public String _esito;
  public String cProg;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_sos_emailR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_sos_email",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cgo_sos = p_ContextObject.GetPhName("cgo_sos");
    if (m_cPhName_cgo_sos.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_sos = m_cPhName_cgo_sos+" "+m_Ctx.GetWritePhName("cgo_sos");
    }
    m_cServer_cgo_sos = p_ContextObject.GetServer("cgo_sos");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pCodice",p_cVarName)) {
      return pCodice;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      return _prtmail;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_sos_email";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      return _srvmail;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      return _emlmail;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      return _usrmail;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      return _pwdmail;
    }
    if (CPLib.eqr("_destsos",p_cVarName)) {
      return _destsos;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_desdip",p_cVarName)) {
      return _desdip;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("pCodice",p_cVarName)) {
      pCodice = value;
      return;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      _prtmail = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      _srvmail = value;
      return;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      _emlmail = value;
      return;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      _usrmail = value;
      return;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      _pwdmail = value;
      return;
    }
    if (CPLib.eqr("_destsos",p_cVarName)) {
      _destsos = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_desdip",p_cVarName)) {
      _desdip = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_sos=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pCodice Numeric(10, 0) // Numero Segnalazione */
      /* _srvmail Char(50) */
      /* _prtmail Numeric(5, 0) */
      /* _emlmail Char(50) */
      /* _usrmail Char(50) */
      /* _pwdmail Char(30) */
      /* _destsos Char(80) */
      /* _testo Memo */
      /* _desdip Char(30) */
      /* _esito Memo */
      /* cProg Char(20) */
      /* gAzienda Char(10) // Azienda */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ALTSRVMAIL,ALTPRTMAIL,ALTEMLMAIL,ALTUSRMAIL,ALTPWDMAIL,PRGAEPATH  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _srvmail := intermbo->ALTSRVMAIL */
        _srvmail = Cursor_intermbo.GetString("ALTSRVMAIL");
        /* _prtmail := iif(Empty(LRTrim(intermbo->ALTPRTMAIL)),25,Val(LRTrim(intermbo->ALTPRTMAIL))) */
        _prtmail = CPLib.Round((CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))?25:CPLib.Val(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))),0);
        /* _emlmail := intermbo->ALTEMLMAIL */
        _emlmail = Cursor_intermbo.GetString("ALTEMLMAIL");
        /* _usrmail := intermbo->ALTUSRMAIL */
        _usrmail = Cursor_intermbo.GetString("ALTUSRMAIL");
        /* _pwdmail := intermbo->ALTPWDMAIL */
        _pwdmail = Cursor_intermbo.GetString("ALTPWDMAIL");
        /* _destsos := LRTrim(intermbo->PRGAEPATH) */
        _destsos = CPLib.LRTrim(Cursor_intermbo.GetString("PRGAEPATH"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Select from cgo_sos
      m_cServer = m_Ctx.GetServer("cgo_sos");
      m_cPhName = m_Ctx.GetPhName("cgo_sos");
      if (Cursor_cgo_sos!=null)
        Cursor_cgo_sos.Close();
      Cursor_cgo_sos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SOSCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodice,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodice)+" "+")"+(m_Ctx.IsSharedTemp("cgo_sos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_sos.Eof())) {
        // * --- Read from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_cSql = "";
        m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_sos.GetString("SOSCODDIP"),"C",6,0,m_cServer),m_cServer,Cursor_cgo_sos.GetString("SOSCODDIP"));
        if (m_Ctx.IsSharedTemp("anadip")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRIZ",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _desdip = Read_Cursor.GetString("DESCRIZ");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_sos_email returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _desdip = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _testo := 'Inserimento nuova SOS da parte di '+LRTrim(cgo_sos->SOSSEGNACOG)+" "+LRTrim(cgo_sos->SOSSEGNANOM)+NL */
        _testo = "Inserimento nuova SOS da parte di "+CPLib.LRTrim(Cursor_cgo_sos.GetString("SOSSEGNACOG"))+" "+CPLib.LRTrim(Cursor_cgo_sos.GetString("SOSSEGNANOM"))+"\n";
        /* _testo := _testo + 'Agenzia di riferimento: '+LRTrim(cgo_sos->SOSCODDIP) +" - " + LRTrim(_desdip)+ NL */
        _testo = _testo+"Agenzia di riferimento: "+CPLib.LRTrim(Cursor_cgo_sos.GetString("SOSCODDIP"))+" - "+CPLib.LRTrim(_desdip)+"\n";
        /* _testo := _testo + 'Data Segnalazione: '+arfn_fdate(cgo_sos->SOSDATSEG) + NL */
        _testo = _testo+"Data Segnalazione: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_sos.GetDate("SOSDATSEG"))+"\n";
        /* _testo := _testo + 'N. Segnalazione: '+LRTrim(Str(cgo_sos->SOSCODICE,10,0)) */
        _testo = _testo+"N. Segnalazione: "+CPLib.LRTrim(CPLib.Str(Cursor_cgo_sos.GetDouble("SOSCODICE"),10,0));
        Cursor_cgo_sos.Next();
      }
      m_cConnectivityError = Cursor_cgo_sos.ErrorMessage();
      Cursor_cgo_sos.Close();
      // * --- End Select
      /* _esito := MailLibrary.sendMail(_testo,'TXT','Nuova Possibile Operazione Sospetta',LRTrim(_srvmail),_destsos,'','',LRTrim(_emlmail),'',LRTrim(_usrmail),LRTrim(_pwdmail),False,_prtmail,False,0,255,'','',False) */
      _esito = MailLibrary.sendMail(_testo,"TXT","Nuova Possibile Operazione Sospetta",CPLib.LRTrim(_srvmail),_destsos,"","",CPLib.LRTrim(_emlmail),"",CPLib.LRTrim(_usrmail),CPLib.LRTrim(_pwdmail),false,_prtmail,false,0,255,"","",false);
      /* Exec Routine arrt_writelog('INVIO SOS','CGO_SOS','MESSAGE',_esito,"I") */
      arrt_writelogR.Make(m_Ctx,this).Run("INVIO SOS","CGO_SOS","MESSAGE",_esito,"I");
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
  public String RunAsync(double p_pCodice) {
    pCodice = p_pCodice;
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
  public Forward Run(double p_pCodice) {
    pCodice = p_pCodice;
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
  public static arrt_cgo_sos_emailR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_sos_emailR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pCodice = 0;
    _srvmail = CPLib.Space(50);
    _prtmail = 0;
    _emlmail = CPLib.Space(50);
    _usrmail = CPLib.Space(50);
    _pwdmail = CPLib.Space(30);
    _destsos = CPLib.Space(80);
    _testo = "";
    _desdip = CPLib.Space(30);
    _esito = "";
    cProg = CPLib.Space(20);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdate,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_fdate,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pCodice"};
}
