// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spas_fregR implements CallerWithObjs {
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
  public String m_cPhName_cpappreg;
  public String m_cServer_cpappreg;
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
  public boolean isOnline;
  public String code;
  public String e_mail;
  public String fullname;
  public String company;
  public String note;
  public String appurl;
  public String cResult;
  public String codeapp;
  public boolean isonlineapp;
  public String ar__code;
  public String ar__mail;
  public java.sql.Timestamp ar_dtreg;
  public String arcompany;
  public String arfullname;
  public String arappurl;
  public String ar__note;
  public spadministration_mobappregBO oReg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spas_fregR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spas_freg",m_Caller);
    m_cPhName_cpappreg = p_ContextObject.GetPhName("cpappreg");
    if (m_cPhName_cpappreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpappreg = m_cPhName_cpappreg+" "+m_Ctx.GetWritePhName("cpappreg");
    }
    m_cServer_cpappreg = p_ContextObject.GetServer("cpappreg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spas_freg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("code",p_cVarName)) {
      return code;
    }
    if (CPLib.eqr("e_mail",p_cVarName)) {
      return e_mail;
    }
    if (CPLib.eqr("fullname",p_cVarName)) {
      return fullname;
    }
    if (CPLib.eqr("company",p_cVarName)) {
      return company;
    }
    if (CPLib.eqr("note",p_cVarName)) {
      return note;
    }
    if (CPLib.eqr("appurl",p_cVarName)) {
      return appurl;
    }
    if (CPLib.eqr("cResult",p_cVarName)) {
      return cResult;
    }
    if (CPLib.eqr("codeapp",p_cVarName)) {
      return codeapp;
    }
    if (CPLib.eqr("ar__code",p_cVarName)) {
      return ar__code;
    }
    if (CPLib.eqr("ar__mail",p_cVarName)) {
      return ar__mail;
    }
    if (CPLib.eqr("arcompany",p_cVarName)) {
      return arcompany;
    }
    if (CPLib.eqr("arfullname",p_cVarName)) {
      return arfullname;
    }
    if (CPLib.eqr("arappurl",p_cVarName)) {
      return arappurl;
    }
    if (CPLib.eqr("ar__note",p_cVarName)) {
      return ar__note;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ar_dtreg",p_cVarName)) {
      return ar_dtreg;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("isOnline",p_cVarName)) {
      return isOnline;
    }
    if (CPLib.eqr("isonlineapp",p_cVarName)) {
      return isonlineapp;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("code",p_cVarName)) {
      code = value;
      return;
    }
    if (CPLib.eqr("e_mail",p_cVarName)) {
      e_mail = value;
      return;
    }
    if (CPLib.eqr("fullname",p_cVarName)) {
      fullname = value;
      return;
    }
    if (CPLib.eqr("company",p_cVarName)) {
      company = value;
      return;
    }
    if (CPLib.eqr("note",p_cVarName)) {
      note = value;
      return;
    }
    if (CPLib.eqr("appurl",p_cVarName)) {
      appurl = value;
      return;
    }
    if (CPLib.eqr("cResult",p_cVarName)) {
      cResult = value;
      return;
    }
    if (CPLib.eqr("codeapp",p_cVarName)) {
      codeapp = value;
      return;
    }
    if (CPLib.eqr("ar__code",p_cVarName)) {
      ar__code = value;
      return;
    }
    if (CPLib.eqr("ar__mail",p_cVarName)) {
      ar__mail = value;
      return;
    }
    if (CPLib.eqr("arcompany",p_cVarName)) {
      arcompany = value;
      return;
    }
    if (CPLib.eqr("arfullname",p_cVarName)) {
      arfullname = value;
      return;
    }
    if (CPLib.eqr("arappurl",p_cVarName)) {
      arappurl = value;
      return;
    }
    if (CPLib.eqr("ar__note",p_cVarName)) {
      ar__note = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("ar_dtreg",p_cVarName)) {
      ar_dtreg = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("isOnline",p_cVarName)) {
      isOnline = value;
      return;
    }
    if (CPLib.eqr("isonlineapp",p_cVarName)) {
      isonlineapp = value;
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
    try {
      /* isOnline Bool // isOnline true/false */
      /* code Char(10) // Codice Applicazione */
      /* e_mail Char(80) */
      /* fullname Char(80) */
      /* company Char(80) */
      /* note Memo */
      /* appurl Char(120) */
      /* cResult Char(0) */
      /* codeapp Char(10) // Codice app */
      /* isonlineapp Bool // is online app */
      /* ar__code Char(10) */
      /* ar__mail Char(80) */
      /* ar_dtreg DateTime */
      /* arcompany Char(80) */
      /* arfullname Char(80) */
      /* arappurl Char(120) */
      /* ar__note Memo */
      /* codeapp := code // Codice app */
      codeapp = code;
      /* isonlineapp := isOnline // is online app */
      isonlineapp = isOnline;
      // * --- Read from cpappreg
      m_cServer = m_Ctx.GetServer("cpappreg");
      m_cPhName = m_Ctx.GetPhName("cpappreg");
      m_cSql = "";
      m_cSql = m_cSql+"ar__mail="+CPSql.SQLValueAdapter(CPLib.ToSQL(e_mail,"C",80,0,m_cServer),m_cServer,e_mail);
      if (m_Ctx.IsSharedTemp("cpappreg")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ar__code",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ar__mail",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        ar__code = Read_Cursor.GetString("ar__code");
        ar__mail = Read_Cursor.GetString("ar__mail");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpappreg into routine spas_freg returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        ar__code = "";
        ar__mail = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(ar__code) */
      if (CPLib.Empty(ar__code)) {
        /* -- mail non trovata registro e notifico */
        /* oReg Object(spadministration_mobappregBO) */
        /* oReg := new spadministration_mobappregBO() */
        oReg = new spadministration_mobappregBO(m_Ctx);
        /* oReg.Initialize() */
        oReg.Initialize();
        /* ar__code := oReg.w_ar__code */
        ar__code = oReg.w_ar__code;
        /* ar__mail := e_mail */
        ar__mail = e_mail;
        /* ar_dtreg := DateTime() */
        ar_dtreg = CPLib.DateTime();
        /* arfullname := fullname */
        arfullname = fullname;
        /* arcompany := company */
        arcompany = company;
        /* arappurl := appurl */
        arappurl = appurl;
        /* ar__note := note */
        ar__note = note;
        /* oReg.Set_ar__mail(e_mail) */
        oReg.Set_ar__mail(e_mail);
        /* oReg.Set_arfullname(fullname) */
        oReg.Set_arfullname(fullname);
        /* oReg.Set_arcompany(company) */
        oReg.Set_arcompany(company);
        /* oReg.Set_ar__note(note) */
        oReg.Set_ar__note(note);
        /* oReg.w_ar_dtreg := ar_dtreg */
        oReg.w_ar_dtreg = ar_dtreg;
        /* oReg.w_arappurl := arappurl */
        oReg.w_arappurl = arappurl;
        /* If not(oReg.Save()) */
        if ( ! (oReg.Save())) {
          /* cResult := "Mancata registrazione :"+LRTrim(oReg.LastErrorMessage()) */
          cResult = "Mancata registrazione :"+CPLib.LRTrim(oReg.LastErrorMessage());
        } else { // Else
          /* Fire Event 'SPRegisteredDemoUser' */
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("SPRegisteredDemoUser",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        } // End If
      } else { // Else
        /* -- mail trovata notifico esistenza */
        /* ar__mail := e_mail */
        ar__mail = e_mail;
        /* ar_dtreg := DateTime() */
        ar_dtreg = CPLib.DateTime();
        /* arfullname := fullname */
        arfullname = fullname;
        /* arcompany := company */
        arcompany = company;
        /* arappurl := appurl */
        arappurl = appurl;
        /* ar__note := note */
        ar__note = note;
        /* Fire Event 'SPRegisteredDemoUser' */
        try {
          m_bEventRunning = true;
          com.zucchetti.sitepainter.EventHandler.notifyEvent("SPRegisteredDemoUser",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
        } finally {
          m_bEventRunning = false;
        }
      } // End If
      /* Return cResult */
      throw new Stop(cResult);
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
  public String RunAsync(boolean p_isOnline,String p_code,String p_e_mail,String p_fullname,String p_company,String p_note,String p_appurl) {
    isOnline = p_isOnline;
    code = p_code;
    e_mail = p_e_mail;
    fullname = p_fullname;
    company = p_company;
    note = p_note;
    appurl = p_appurl;
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
  public String Run(boolean p_isOnline,String p_code,String p_e_mail,String p_fullname,String p_company,String p_note,String p_appurl) {
    isOnline = p_isOnline;
    code = p_code;
    e_mail = p_e_mail;
    fullname = p_fullname;
    company = p_company;
    note = p_note;
    appurl = p_appurl;
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
  public static spas_fregR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spas_fregR(p_Ctx, p_Caller);
  }
  public static spas_fregR Make(CPContext p_Ctx) {
    return new spas_fregR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    isOnline = false;
    code = CPLib.Space(10);
    e_mail = CPLib.Space(80);
    fullname = CPLib.Space(80);
    company = CPLib.Space(80);
    note = "";
    appurl = CPLib.Space(120);
    cResult = CPLib.Space(0);
    codeapp = CPLib.Space(10);
    isonlineapp = false;
    ar__code = CPLib.Space(10);
    ar__mail = CPLib.Space(80);
    ar_dtreg = CPLib.NullDateTime();
    arcompany = CPLib.Space(80);
    arfullname = CPLib.Space(80);
    arappurl = CPLib.Space(120);
    ar__note = "";
    oReg = null;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spas_freg,
  public static final String i_InvokedRoutines = ",spas_freg,";
  public static String[] m_cRunParameterNames={"isOnline","code","e_mail","fullname","company","note","appurl"};
}
