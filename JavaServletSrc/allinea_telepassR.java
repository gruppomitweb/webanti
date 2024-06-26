// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allinea_telepassR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_tbareegeog_p;
  public String m_cServer_tbareegeog_p;
  public String m_cPhName_tbspecie_p;
  public String m_cServer_tbspecie_p;
  public String m_cPhName_tbtipatt_p;
  public String m_cServer_tbtipatt_p;
  public String m_cPhName_tbcondotta_p;
  public String m_cServer_tbcondotta_p;
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
  public String gAzienda;
  public String cPassword;
  public double _maxute;
  public MemoryCursor_tbareegeog_p mcArea;
  public MemoryCursor_tbspecie_p mcSpecie;
  public MemoryCursor_tbtipatt_p mcAteco;
  public MemoryCursor_tbcondotta_p mcCond;
  public double _ris1;
  public double _ris2;
  public double _ris3;
  public double _ris4;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allinea_telepassR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("allinea_telepass",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_tbareegeog_p = p_ContextObject.GetPhName("tbareegeog_p");
    if (m_cPhName_tbareegeog_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbareegeog_p = m_cPhName_tbareegeog_p+" "+m_Ctx.GetWritePhName("tbareegeog_p");
    }
    m_cServer_tbareegeog_p = p_ContextObject.GetServer("tbareegeog_p");
    m_cPhName_tbspecie_p = p_ContextObject.GetPhName("tbspecie_p");
    if (m_cPhName_tbspecie_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbspecie_p = m_cPhName_tbspecie_p+" "+m_Ctx.GetWritePhName("tbspecie_p");
    }
    m_cServer_tbspecie_p = p_ContextObject.GetServer("tbspecie_p");
    m_cPhName_tbtipatt_p = p_ContextObject.GetPhName("tbtipatt_p");
    if (m_cPhName_tbtipatt_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt_p = m_cPhName_tbtipatt_p+" "+m_Ctx.GetWritePhName("tbtipatt_p");
    }
    m_cServer_tbtipatt_p = p_ContextObject.GetServer("tbtipatt_p");
    m_cPhName_tbcondotta_p = p_ContextObject.GetPhName("tbcondotta_p");
    if (m_cPhName_tbcondotta_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcondotta_p = m_cPhName_tbcondotta_p+" "+m_Ctx.GetWritePhName("tbcondotta_p");
    }
    m_cServer_tbcondotta_p = p_ContextObject.GetServer("tbcondotta_p");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_maxute",p_cVarName)) {
      return _maxute;
    }
    if (CPLib.eqr("_ris1",p_cVarName)) {
      return _ris1;
    }
    if (CPLib.eqr("_ris2",p_cVarName)) {
      return _ris2;
    }
    if (CPLib.eqr("_ris3",p_cVarName)) {
      return _ris3;
    }
    if (CPLib.eqr("_ris4",p_cVarName)) {
      return _ris4;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "allinea_telepass";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("cPassword",p_cVarName)) {
      return cPassword;
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
    if (CPLib.eqr("mcArea",p_cVarName)) {
      return mcArea;
    }
    if (CPLib.eqr("mcSpecie",p_cVarName)) {
      return mcSpecie;
    }
    if (CPLib.eqr("mcAteco",p_cVarName)) {
      return mcAteco;
    }
    if (CPLib.eqr("mcCond",p_cVarName)) {
      return mcCond;
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
    if (CPLib.eqr("_maxute",p_cVarName)) {
      _maxute = value;
      return;
    }
    if (CPLib.eqr("_ris1",p_cVarName)) {
      _ris1 = value;
      return;
    }
    if (CPLib.eqr("_ris2",p_cVarName)) {
      _ris2 = value;
      return;
    }
    if (CPLib.eqr("_ris3",p_cVarName)) {
      _ris3 = value;
      return;
    }
    if (CPLib.eqr("_ris4",p_cVarName)) {
      _ris4 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("cPassword",p_cVarName)) {
      cPassword = value;
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
    if (CPLib.eqr("mcArea",p_cVarName)) {
      mcArea = (MemoryCursor_tbareegeog_p)value;
      return;
    }
    if (CPLib.eqr("mcSpecie",p_cVarName)) {
      mcSpecie = (MemoryCursor_tbspecie_p)value;
      return;
    }
    if (CPLib.eqr("mcAteco",p_cVarName)) {
      mcAteco = (MemoryCursor_tbtipatt_p)value;
      return;
    }
    if (CPLib.eqr("mcCond",p_cVarName)) {
      mcCond = (MemoryCursor_tbcondotta_p)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cpusers=null;
    try {
      /* gAzienda Char(10) // Azienda */
      /* cPassword Char(50) */
      /* _maxute Numeric(10, 0) */
      /* mcArea MemoryCursor(tbareegeog_p) */
      /* mcSpecie MemoryCursor(tbspecie_p) */
      /* mcAteco MemoryCursor(tbtipatt_p) */
      /* mcCond MemoryCursor(tbcondotta_p) */
      /* _ris1 Numeric(4, 0) */
      /* _ris2 Numeric(4, 0) */
      /* _ris3 Numeric(4, 0) */
      /* _ris4 Numeric(4, 0) */
      // * --- Select from cpusers
      m_cServer = m_Ctx.GetServer("cpusers");
      m_cPhName = m_Ctx.GetPhName("cpusers");
      if (Cursor_cpusers!=null)
        Cursor_cpusers.Close();
      Cursor_cpusers = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpusers")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpusers.Eof())) {
        /* _maxute := cpusers->code */
        _maxute = CPLib.Round(Cursor_cpusers.GetDouble("code"),0);
        /* cPassword := CPLib.CriptPwd(_maxute,'mitwebanti') */
        cPassword = CPLib.CriptPwd(_maxute,"mitwebanti");
        // * --- Write into cpusers from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpusers");
        m_cPhName = m_Ctx.GetPhName("cpusers");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allinea_telepass",46,"0000000F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(cPassword,"C",20,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cpusers.GetDouble("code"),"?",0,0,m_cServer),m_cServer,Cursor_cpusers.GetDouble("code"))+"";
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
        Cursor_cpusers.Next();
      }
      m_cConnectivityError = Cursor_cpusers.ErrorMessage();
      Cursor_cpusers.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpusers!=null)
          Cursor_cpusers.Close();
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
  public static allinea_telepassR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_telepassR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cPassword = CPLib.Space(50);
    _maxute = 0;
    mcArea = new MemoryCursor_tbareegeog_p();
    mcSpecie = new MemoryCursor_tbspecie_p();
    mcAteco = new MemoryCursor_tbtipatt_p();
    mcCond = new MemoryCursor_tbcondotta_p();
    _ris1 = 0;
    _ris2 = 0;
    _ris3 = 0;
    _ris4 = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
