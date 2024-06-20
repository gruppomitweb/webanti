// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_interstorR implements CallerWithObjs {
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
  public String m_cPhName_wntermbo;
  public String m_cServer_wntermbo;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_interstorR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_interstor",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wntermbo = p_ContextObject.GetPhName("wntermbo");
    if (m_cPhName_wntermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntermbo = m_cPhName_wntermbo+" "+m_Ctx.GetWritePhName("wntermbo");
    }
    m_cServer_wntermbo = p_ContextObject.GetServer("wntermbo");
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
      return "arrt_interstor";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    try {
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        // * --- Insert into wntermbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wntermbo");
        m_cPhName = m_Ctx.GetPhName("wntermbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntermbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_interstor",2,"00000002")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000002(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATANASC"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATARILASC"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("IDCITTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SUPPLEM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATAVALI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("DBPROT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("F_INGLESE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("CONTATORE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PATHAPP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("URLAPPL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGLOG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGAOS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("AEPATH"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("MOLTI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGEAOS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGCDOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGFRAZ"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGAPERS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DTINIATT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGTIPIMP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGSTPCON"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGIMPAGE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CFINVIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CAFINVIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FILEINVIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATAINVIO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGWU"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("IMPINTOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("GGYELWAR"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("GGREDWAR"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGOPEXTR"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SKT_SERVER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("SKT_PORT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SKT_PATHS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SKT_MODET"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("RASPAUI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("RESPAUI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("TESTIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("FLGDATAIM"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("FLGDATATP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("LIMITVLT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("LIMITVNP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("NOCODFISC"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGSTPDIR"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PATRONO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("NODOM"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("NOSAB"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NUMINTER2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("IMPINTER2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATAINTER"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("TPSOFTAE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PROVNA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("F_LOG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("IMPPATH"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PRGAEPATH"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("CODAGE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGCHK"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("FLGNODOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDate("DATAINTER2"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("IDSID"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SIDPASS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("FLGSIDAUTO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PATHSID"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("PATHJAVA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("TIPOINST"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetString("SNAISTOR"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intermbo.GetDouble("LIMITEFRZ"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wntermbo",true);
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
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_interstorR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_interstorR(p_Ctx, p_Caller);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000002(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"SUPPLEM,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DBPROT,";
    p_cSql = p_cSql+"F_INGLESE,";
    p_cSql = p_cSql+"CONTATORE,";
    p_cSql = p_cSql+"PATHAPP,";
    p_cSql = p_cSql+"URLAPPL,";
    p_cSql = p_cSql+"FLGLOG,";
    p_cSql = p_cSql+"FLGAOS,";
    p_cSql = p_cSql+"AEPATH,";
    p_cSql = p_cSql+"MOLTI,";
    p_cSql = p_cSql+"FLGEAOS,";
    p_cSql = p_cSql+"FLGCDOC,";
    p_cSql = p_cSql+"FLGFRAZ,";
    p_cSql = p_cSql+"FLGAPERS,";
    p_cSql = p_cSql+"DTINIATT,";
    p_cSql = p_cSql+"FLGTIPIMP,";
    p_cSql = p_cSql+"FLGSTPCON,";
    p_cSql = p_cSql+"FLGIMPAGE,";
    p_cSql = p_cSql+"CFINVIO,";
    p_cSql = p_cSql+"CAFINVIO,";
    p_cSql = p_cSql+"FILEINVIO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"FLGWU,";
    p_cSql = p_cSql+"IMPINTOPE,";
    p_cSql = p_cSql+"GGYELWAR,";
    p_cSql = p_cSql+"GGREDWAR,";
    p_cSql = p_cSql+"FLGOPEXTR,";
    p_cSql = p_cSql+"SKT_SERVER,";
    p_cSql = p_cSql+"SKT_PORT,";
    p_cSql = p_cSql+"SKT_PATHS,";
    p_cSql = p_cSql+"SKT_MODET,";
    p_cSql = p_cSql+"RASPAUI,";
    p_cSql = p_cSql+"RESPAUI,";
    p_cSql = p_cSql+"TESTIP,";
    p_cSql = p_cSql+"FLGDATAIM,";
    p_cSql = p_cSql+"FLGDATATP,";
    p_cSql = p_cSql+"LIMITVLT,";
    p_cSql = p_cSql+"LIMITVNP,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"FLGSTPDIR,";
    p_cSql = p_cSql+"PATRONO,";
    p_cSql = p_cSql+"NODOM,";
    p_cSql = p_cSql+"NOSAB,";
    p_cSql = p_cSql+"CODINTER2,";
    p_cSql = p_cSql+"NUMINTER2,";
    p_cSql = p_cSql+"IMPINTER2,";
    p_cSql = p_cSql+"DATAINTER,";
    p_cSql = p_cSql+"TPSOFTAE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"F_LOG,";
    p_cSql = p_cSql+"IMPPATH,";
    p_cSql = p_cSql+"PRGAEPATH,";
    p_cSql = p_cSql+"CODAGE,";
    p_cSql = p_cSql+"FLGCHK,";
    p_cSql = p_cSql+"FLGNODOC,";
    p_cSql = p_cSql+"DATAINTER2,";
    p_cSql = p_cSql+"IDSID,";
    p_cSql = p_cSql+"SIDPASS,";
    p_cSql = p_cSql+"FLGSIDAUTO,";
    p_cSql = p_cSql+"PATHSID,";
    p_cSql = p_cSql+"PATHJAVA,";
    p_cSql = p_cSql+"TIPOINST,";
    p_cSql = p_cSql+"SNAISTOR,";
    p_cSql = p_cSql+"LIMITEFRZ,";
    p_cSql = p_cSql+"DATAMODI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wntermbo",true);
    return p_cSql;
  }
}
