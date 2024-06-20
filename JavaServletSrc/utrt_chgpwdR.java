// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class utrt_chgpwdR implements CallerWithObjs {
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
  public String w_newpwd;
  public String w_msgchg;
  public String gUtente;
  public double gUserCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public utrt_chgpwdR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("utrt_chgpwd",m_Caller);
    m_cPhName_utenti = p_ContextObject.GetPhName("utenti");
    if (m_cPhName_utenti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_utenti = m_cPhName_utenti+" "+m_Ctx.GetWritePhName("utenti");
    }
    m_cServer_utenti = p_ContextObject.GetServer("utenti");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "utrt_chgpwd";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("newpwd",p_cVarName)) {
      return w_newpwd;
    }
    if (CPLib.eqr("msgchg",p_cVarName)) {
      return w_msgchg;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      return gUtente;
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("newpwd",p_cVarName)) {
      w_newpwd = value;
      return;
    }
    if (CPLib.eqr("msgchg",p_cVarName)) {
      w_msgchg = value;
      return;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      gUtente = value;
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
    /* Variabili del caller */
    /* w_newpwd Char(20) */
    /* w_msgchg Char(100) */
    /* Variabili globali */
    /* gUtente Char(10) // Utente Procedura */
    /* gUserCode Numeric(4, 0) // Codice Utente CP */
    /* Scrive la password */
    /* If Len(LRTrim(w_newpwd)) < 8 */
    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(w_newpwd)),8)) {
      /* w_msgchg := 'La password deve essere lunga almeno 8 caratteri' */
      w_msgchg = "La password deve essere lunga almeno 8 caratteri";
      /* Return  */
      Forward f;
      f=new Forward("utpg_chgpwd",false,this,Forward.Start,false);
      f.SetParameter("msgchg",w_msgchg);
      f.SetParameter("m_cParameterSequence","msgchg");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
    // * --- Write into utenti from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("utenti");
    m_cPhName = m_Ctx.GetPhName("utenti");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"utenti",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("utrt_chgpwd",17,"0000000B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"utpasswd = "+CPLib.ToSQL(w_newpwd,"C",20,0,m_cServer)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"utenti",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"utcodice = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gUtente,"?",0,0,m_cServer),m_cServer,gUtente)+"";
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
    /* Richiama la corretta pagina */
    /* Return  */
    Forward f;
    f=new Forward("centrale",false,this,Forward.Start,false);
    f.SetParameter("m_cParameterSequence", "");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
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
      m_Caller.SetString("newpwd","C",20,0,w_newpwd);
      m_Caller.SetString("msgchg","C",100,0,w_msgchg);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static utrt_chgpwdR Make(CPContext p_Ctx, Caller p_Caller) {
    return new utrt_chgpwdR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_newpwd = m_Caller.GetString("newpwd","C",20,0);
    w_msgchg = m_Caller.GetString("msgchg","C",100,0);
    gUtente=m_Ctx.GetGlobalString("gUtente");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
