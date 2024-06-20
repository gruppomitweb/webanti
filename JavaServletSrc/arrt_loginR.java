// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_loginR implements CallerWithObjs {
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
  public String m_cPhName_utenti;
  public String m_cServer_utenti;
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
  public String w_CodUte;
  public String w_PwdUte;
  public String w_ErrLogin;
  public String w_usercode;
  public String w_pwd;
  public double w_utentecp;
  public double gUserCode;
  public String gUtente;
  public String gEmail;
  public String gIntemediario;
  public String gTipInter;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_loginR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_login",m_Caller);
    m_cPhName_utenti = p_ContextObject.GetPhName("utenti");
    if (m_cPhName_utenti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_utenti = m_cPhName_utenti+" "+m_Ctx.GetWritePhName("utenti");
    }
    m_cServer_utenti = p_ContextObject.GetServer("utenti");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("utentecp",p_cVarName)) {
      return w_utentecp;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_login";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CodUte",p_cVarName)) {
      return w_CodUte;
    }
    if (CPLib.eqr("PwdUte",p_cVarName)) {
      return w_PwdUte;
    }
    if (CPLib.eqr("ErrLogin",p_cVarName)) {
      return w_ErrLogin;
    }
    if (CPLib.eqr("usercode",p_cVarName)) {
      return w_usercode;
    }
    if (CPLib.eqr("pwd",p_cVarName)) {
      return w_pwd;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      return gUtente;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      return gEmail;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
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
    if (CPLib.eqr("utentecp",p_cVarName)) {
      w_utentecp = value;
      return;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CodUte",p_cVarName)) {
      w_CodUte = value;
      return;
    }
    if (CPLib.eqr("PwdUte",p_cVarName)) {
      w_PwdUte = value;
      return;
    }
    if (CPLib.eqr("ErrLogin",p_cVarName)) {
      w_ErrLogin = value;
      return;
    }
    if (CPLib.eqr("usercode",p_cVarName)) {
      w_usercode = value;
      return;
    }
    if (CPLib.eqr("pwd",p_cVarName)) {
      w_pwd = value;
      return;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      gUtente = value;
      return;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      gEmail = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_CodUte Char(10) */
      /* w_PwdUte Char(20) */
      /* w_ErrLogin Char(100) */
      /* w_usercode Char(10) */
      /* w_pwd Char(20) */
      /* w_utentecp Numeric(4, 0) */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* gUtente Char(10) // Codice Utente */
      /* gEmail Char(40) // Email Utente */
      /* gIntemediario Char(11) // Intermediario */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      // * --- Read from utenti
      m_cServer = m_Ctx.GetServer("utenti");
      m_cPhName = m_Ctx.GetPhName("utenti");
      m_cSql = "";
      m_cSql = m_cSql+"utcodice="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodUte,"C",10,0,m_cServer),m_cServer,w_CodUte);
      if (m_Ctx.IsSharedTemp("utenti")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("utcod_cp",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("utpasswd",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ut_email",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        gUserCode = CPLib.Round(Read_Cursor.GetDouble("utcod_cp"),0);
        m_Ctx.SetGlobalNumber("gUserCode",gUserCode);
        w_pwd = Read_Cursor.GetString("utpasswd");
        gEmail = Read_Cursor.GetString("ut_email");
        m_Ctx.SetGlobalString("gEmail",gEmail);
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on utenti into routine arrt_login returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        gUserCode = 0;
        w_pwd = "";
        gEmail = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* w_utentecp := 0 */
      w_utentecp = CPLib.Round(0,0);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* If gUserCode = 0 */
        if (CPLib.eqr(gUserCode,0)) {
          /* w_utentecp := 1 */
          w_utentecp = CPLib.Round(1,0);
        } // End If
        /* gIntemediario := intermbo->CODINTER // Intermediario */
        gIntemediario = Cursor_intermbo.GetString("CODINTER");
        m_Ctx.SetGlobalString("gIntemediario",gIntemediario);
        /* gTipInter := intermbo->TIPINTER // Tipo Intermediario */
        gTipInter = Cursor_intermbo.GetString("TIPINTER");
        m_Ctx.SetGlobalString("gTipInter",gTipInter);
        /* gDescAzi := intermbo->RAGSOC // Descrizione Intermediario */
        gDescAzi = Cursor_intermbo.GetString("RAGSOC");
        m_Ctx.SetGlobalString("gDescAzi",gDescAzi);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If LRTrim(w_PwdUte) <> LRTrim(w_pwd) */
      if (CPLib.ne(CPLib.LRTrim(w_PwdUte),CPLib.LRTrim(w_pwd))) {
        /* Lancia maschera che segnala password */
        /* w_ErrLogin := "Utente e Password non corretti! Riprova l'inserimento." */
        w_ErrLogin = "Utente e Password non corretti! Riprova l'inserimento.";
        /* Return  */
        Forward f;
        f=new Forward("arpg_login",false,this,Forward.Start,false);
        f.SetParameter("ErrLogin",w_ErrLogin);
        f.SetParameter("m_cParameterSequence","ErrLogin");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
      // * --- Write into utenti from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("utenti");
      m_cPhName = m_Ctx.GetPhName("utenti");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"utenti",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_login",135,"00000019")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"utdatacc = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"utenti",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"utcodice = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodUte,"?",0,0,m_cServer),m_cServer,w_CodUte)+"";
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
      /* gUtente := w_CodUte // Codice Utente */
      gUtente = w_CodUte;
      m_Ctx.SetGlobalString("gUtente",gUtente);
      /* Return  */
      Forward f;
      f=new Forward("cp_login",false,this,Forward.Start,false);
      f.SetParameter("g_codute",gUserCode);
      f.SetParameter("m_cPassword","");
      f.SetParameter("m_cAction","login");
      f.SetParameter("m_cParameterSequence","g_codute"+","+"m_cPassword"+","+"m_cAction");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
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
      m_Caller.SetString("CodUte","C",10,0,w_CodUte);
      m_Caller.SetString("PwdUte","C",20,0,w_PwdUte);
      m_Caller.SetString("ErrLogin","C",100,0,w_ErrLogin);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_loginR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_loginR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CodUte = m_Caller.GetString("CodUte","C",10,0);
    w_PwdUte = m_Caller.GetString("PwdUte","C",20,0);
    w_ErrLogin = m_Caller.GetString("ErrLogin","C",100,0);
    w_usercode = CPLib.Space(10);
    w_pwd = CPLib.Space(20);
    w_utentecp = 0;
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gUtente=m_Ctx.GetGlobalString("gUtente");
    gEmail=m_Ctx.GetGlobalString("gEmail");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
