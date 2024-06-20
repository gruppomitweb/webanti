// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wutrxchk_upddataR implements CallerWithObjs {
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
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
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
  public String w_TRXCOGNOM;
  public String w_TRXNOME;
  public String w_TRXCODFIS;
  public String w_TRXLUONAS;
  public java.sql.Date w_TRXDATNAS;
  public String w_TRXSESSO;
  public String w_TRXFLGCF;
  public String w_xtipdoc;
  public String w_xtnumdoc;
  public String w_xluonas;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wutrxchk_upddataR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wutrxchk_upddata",m_Caller);
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
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
      return "arrt_wutrxchk_upddata";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      return w_TRXCOGNOM;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      return w_TRXNOME;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      return w_TRXCODFIS;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      return w_TRXLUONAS;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      return w_TRXSESSO;
    }
    if (CPLib.eqr("TRXFLGCF",p_cVarName)) {
      return w_TRXFLGCF;
    }
    if (CPLib.eqr("xtipdoc",p_cVarName)) {
      return w_xtipdoc;
    }
    if (CPLib.eqr("xtnumdoc",p_cVarName)) {
      return w_xtnumdoc;
    }
    if (CPLib.eqr("xluonas",p_cVarName)) {
      return w_xluonas;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      return w_TRXDATNAS;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      w_TRXCOGNOM = value;
      return;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      w_TRXNOME = value;
      return;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      w_TRXCODFIS = value;
      return;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      w_TRXLUONAS = value;
      return;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      w_TRXSESSO = value;
      return;
    }
    if (CPLib.eqr("TRXFLGCF",p_cVarName)) {
      w_TRXFLGCF = value;
      return;
    }
    if (CPLib.eqr("xtipdoc",p_cVarName)) {
      w_xtipdoc = value;
      return;
    }
    if (CPLib.eqr("xtnumdoc",p_cVarName)) {
      w_xtnumdoc = value;
      return;
    }
    if (CPLib.eqr("xluonas",p_cVarName)) {
      w_xluonas = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      w_TRXDATNAS = value;
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
    CPResultSet Cursor_dersonbo=null;
    try {
      /* w_TRXCOGNOM Char(50) // Cognome */
      /* w_TRXNOME Char(50) // Nome */
      /* w_TRXCODFIS Char(16) // Codice Ficale (reale) */
      /* w_TRXLUONAS Char(50) // Luogo di nascita */
      /* w_TRXDATNAS Date // Data Di Nascita */
      /* w_TRXSESSO Char(1) // Sesso */
      /* w_TRXFLGCF Char(1) // Flag Codice Fiscale */
      /* w_xtipdoc Char(2) */
      /* w_xtnumdoc Char(15) */
      /* w_xluonas Char(50) */
      // * --- Select from dersonbo
      m_cServer = m_Ctx.GetServer("dersonbo");
      m_cPhName = m_Ctx.GetPhName("dersonbo");
      if (Cursor_dersonbo!=null)
        Cursor_dersonbo.Close();
      Cursor_dersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TIPODOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_xtipdoc,"?",0,0,m_cServer, m_oParameters),m_cServer,w_xtipdoc)+"  and  NUMDOCUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_xtnumdoc,"?",0,0,m_cServer, m_oParameters),m_cServer,w_xtnumdoc)+" "+")"+(m_Ctx.IsSharedTemp("dersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_dersonbo.Eof())) {
        /* w_TRXCOGNOM := dersonbo->COGNOME // Cognome */
        w_TRXCOGNOM = Cursor_dersonbo.GetString("COGNOME");
        /* w_TRXNOME := dersonbo->NOME // Nome */
        w_TRXNOME = Cursor_dersonbo.GetString("NOME");
        /* w_TRXCODFIS := dersonbo->CODFISC // Codice Ficale (reale) */
        w_TRXCODFIS = Cursor_dersonbo.GetString("CODFISC");
        /* w_TRXLUONAS := dersonbo->LUOGONAS // Luogo di nascita */
        w_TRXLUONAS = Cursor_dersonbo.GetString("LUOGONAS");
        /* w_TRXDATNAS := dersonbo->DATANASC // Data Di Nascita */
        w_TRXDATNAS = Cursor_dersonbo.GetDate("DATANASC");
        /* w_TRXSESSO := iif(dersonbo->SESSO='1','M','F') // Sesso */
        w_TRXSESSO = (CPLib.eqr(Cursor_dersonbo.GetString("SESSO"),"1")?"M":"F");
        /* w_TRXFLGCF := iif(Empty(LRTrim(dersonbo->CODFISC)),'N','S') // Luogo di nascita */
        w_TRXFLGCF = (CPLib.Empty(CPLib.LRTrim(Cursor_dersonbo.GetString("CODFISC")))?"N":"S");
        Cursor_dersonbo.Next();
      }
      m_cConnectivityError = Cursor_dersonbo.ErrorMessage();
      Cursor_dersonbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
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
      m_Caller.SetString("TRXCOGNOM","C",50,0,w_TRXCOGNOM);
      m_Caller.SetString("TRXNOME","C",50,0,w_TRXNOME);
      m_Caller.SetString("TRXCODFIS","C",16,0,w_TRXCODFIS);
      m_Caller.SetString("TRXLUONAS","C",50,0,w_TRXLUONAS);
      m_Caller.SetDate("TRXDATNAS","D",8,0,w_TRXDATNAS);
      m_Caller.SetString("TRXSESSO","C",1,0,w_TRXSESSO);
      m_Caller.SetString("TRXFLGCF","C",1,0,w_TRXFLGCF);
      m_Caller.SetString("xtipdoc","C",2,0,w_xtipdoc);
      m_Caller.SetString("xtnumdoc","C",15,0,w_xtnumdoc);
      m_Caller.SetString("xluonas","C",50,0,w_xluonas);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wutrxchk_upddataR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wutrxchk_upddataR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_TRXCOGNOM = m_Caller.GetString("TRXCOGNOM","C",50,0);
    w_TRXNOME = m_Caller.GetString("TRXNOME","C",50,0);
    w_TRXCODFIS = m_Caller.GetString("TRXCODFIS","C",16,0);
    w_TRXLUONAS = m_Caller.GetString("TRXLUONAS","C",50,0);
    w_TRXDATNAS = m_Caller.GetDate("TRXDATNAS","D",8,0);
    w_TRXSESSO = m_Caller.GetString("TRXSESSO","C",1,0);
    w_TRXFLGCF = m_Caller.GetString("TRXFLGCF","C",1,0);
    w_xtipdoc = m_Caller.GetString("xtipdoc","C",2,0);
    w_xtnumdoc = m_Caller.GetString("xtnumdoc","C",15,0);
    w_xluonas = m_Caller.GetString("xluonas","C",50,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
