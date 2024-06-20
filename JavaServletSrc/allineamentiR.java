// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allineamentiR implements CallerWithObjs {
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
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_filedatiuic;
  public String m_cServer_filedatiuic;
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
  public String cAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allineamentiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("allineamenti",m_Caller);
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_filedatiuic = p_ContextObject.GetPhName("filedatiuic");
    if (m_cPhName_filedatiuic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_filedatiuic = m_cPhName_filedatiuic+" "+m_Ctx.GetWritePhName("filedatiuic");
    }
    m_cServer_filedatiuic = p_ContextObject.GetServer("filedatiuic");
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
      return "allineamenti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cAzi",p_cVarName)) {
      return cAzi;
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
    if (CPLib.eqr("cAzi",p_cVarName)) {
      cAzi = value;
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
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_japopebo=null;
    CPResultSet Cursor_cpwarn=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_aefiles=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_filedatiuic=null;
    try {
      /* Cancella i profgressivi esistenti */
      /* cAzi Char(10) */
      /* cAzi := Utilities.GetCompany() */
      cAzi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      /* Allinea Date */
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("rapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        // * --- Write into rapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000006")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.DateToChar(Cursor_rapopebo.GetDate("DATAOPE")),"C",8,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("IDBASE"))+"";
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
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
      // * --- Select from xapopebo
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      if (Cursor_xapopebo!=null)
        Cursor_xapopebo.Close();
      Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapopebo.Eof())) {
        // * --- Write into xapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000008")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.DateToChar(Cursor_xapopebo.GetDate("DATAOPE")),"C",8,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("IDBASE"))+"";
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
        Cursor_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
      Cursor_xapopebo.Close();
      // * --- End Select
      // * --- Select from japopebo
      m_cServer = m_Ctx.GetServer("japopebo");
      m_cPhName = m_Ctx.GetPhName("japopebo");
      if (Cursor_japopebo!=null)
        Cursor_japopebo.Close();
      Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("japopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_japopebo.Eof())) {
        // * --- Write into japopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000000A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.DateToChar(Cursor_japopebo.GetDate("DATAOPE")),"C",8,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"japopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_japopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_japopebo.GetString("IDBASE"))+"";
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
        Cursor_japopebo.Next();
      }
      m_cConnectivityError = Cursor_japopebo.ErrorMessage();
      Cursor_japopebo.Close();
      // * --- End Select
      // * --- Select from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      if (Cursor_cpwarn!=null)
        Cursor_cpwarn.Close();
      Cursor_cpwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(cAzi,"?",0,0,m_cServer, m_oParameters),m_cServer,cAzi)+" "+")"+(m_Ctx.IsSharedTemp("cpwarn")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpwarn.Eof())) {
        /* If Left(cpwarn->tablecode,4)='prog' */
        if (CPLib.eqr(CPLib.Left(Cursor_cpwarn.GetString("tablecode"),4),"prog")) {
          // * --- Delete from cpwarn
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000000D")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cpwarn.GetString("tablecode"),"?",0,0,m_cServer),m_cServer,Cursor_cpwarn.GetString("tablecode"))+"";
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
        } // End If
        Cursor_cpwarn.Next();
      }
      m_cConnectivityError = Cursor_cpwarn.ErrorMessage();
      Cursor_cpwarn.Close();
      // * --- End Select
      /* Cicla Sui Clienti */
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(PROGIMPORT)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000010")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000010(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_personbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPINF)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("rapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000012")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000012(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGINFO1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_rapopebo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000013")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000013(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_rapopebo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000014")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000014(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPINF\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_rapopebo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
      // * --- Select from xapopebo
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      if (Cursor_xapopebo!=null)
        Cursor_xapopebo.Close();
      Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPINF)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapopebo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000016")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000016(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPINFO1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xapopebo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPINFO2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xapopebo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000018")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000018(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPIMPINF\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xapopebo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
      Cursor_xapopebo.Close();
      // * --- End Select
      // * --- Select from japopebo
      m_cServer = m_Ctx.GetServer("japopebo");
      m_cPhName = m_Ctx.GetPhName("japopebo");
      if (Cursor_japopebo!=null)
        Cursor_japopebo.Close();
      Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPINF)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("japopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_japopebo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000001A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGINFAGE1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_japopebo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000001B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGINFAGE2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_japopebo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000001C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPIMPINFAGE\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_japopebo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_japopebo.Next();
      }
      m_cConnectivityError = Cursor_japopebo.ErrorMessage();
      Cursor_japopebo.Close();
      // * --- End Select
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPOPE)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("operazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000001E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_operazbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000001F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_operazbo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_operazbo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      // * --- End Select
      // * --- Select from xperazbo
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      if (Cursor_xperazbo!=null)
        Cursor_xperazbo.Close();
      Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPOPE)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xperazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xperazbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PPOPER1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xperazbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PPOPER2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xperazbo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000024")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000024(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xperazbo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_xperazbo.Next();
      }
      m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
      Cursor_xperazbo.Close();
      // * --- End Select
      // * --- Select from jperazbo
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      if (Cursor_jperazbo!=null)
        Cursor_jperazbo.Close();
      Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPOPE)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("jperazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jperazbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAGE1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_jperazbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000027")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000027(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAGE2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_jperazbo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000028")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000028(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPOPEAGE\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_jperazbo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_jperazbo.Next();
      }
      m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
      Cursor_jperazbo.Close();
      // * --- End Select
      // * --- Select from fraziobo
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      if (Cursor_fraziobo!=null)
        Cursor_fraziobo.Close();
      Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPFRZ)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("fraziobo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_fraziobo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_fraziobo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000002B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_fraziobo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_fraziobo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_fraziobo.Next();
      }
      m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
      Cursor_fraziobo.Close();
      // * --- End Select
      // * --- Select from xraziobo
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      if (Cursor_xraziobo!=null)
        Cursor_xraziobo.Close();
      Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1,Max(NUMPROG)  as prg2,Max(PRGIMPFRZ)  as prg3  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xraziobo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xraziobo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PPFRAZ1\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xraziobo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PPFRAZ2\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xraziobo.GetString("prg2")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xraziobo.GetString("prg3")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_xraziobo.Next();
      }
      m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
      Cursor_xraziobo.Close();
      // * --- End Select
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(PRGIMPSOG)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intestbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPSOG\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_intestbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_intestbo.Next();
      }
      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
      Cursor_intestbo.Close();
      // * --- End Select
      // * --- Select from xntestbo
      m_cServer = m_Ctx.GetServer("xntestbo");
      m_cPhName = m_Ctx.GetPhName("xntestbo");
      if (Cursor_xntestbo!=null)
        Cursor_xntestbo.Close();
      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(PRGIMPSOG)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xntestbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xntestbo.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPSOG\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_xntestbo.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_xntestbo.Next();
      }
      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
      Cursor_xntestbo.Close();
      // * --- End Select
      // * --- Select from aefiles
      m_cServer = m_Ctx.GetServer("aefiles");
      m_cPhName = m_Ctx.GetPhName("aefiles");
      if (Cursor_aefiles!=null)
        Cursor_aefiles.Close();
      Cursor_aefiles = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(idfile)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aefiles")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aefiles.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000036")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000036(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGFILES\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_aefiles.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_aefiles.Next();
      }
      m_cConnectivityError = Cursor_aefiles.ErrorMessage();
      Cursor_aefiles.Close();
      // * --- End Select
      // * --- Select from aetesta
      m_cServer = m_Ctx.GetServer("aetesta");
      m_cPhName = m_Ctx.GetPhName("aetesta");
      if (Cursor_aetesta!=null)
        Cursor_aetesta.Close();
      Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(PROGAET)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aetesta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aetesta.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PROGAET\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_aetesta.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_aetesta.Next();
      }
      m_cConnectivityError = Cursor_aetesta.ErrorMessage();
      Cursor_aetesta.Close();
      // * --- End Select
      // * --- Select from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      if (Cursor_aerighe!=null)
        Cursor_aerighe.Close();
      Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(PROGAER)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aerighe")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aerighe.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000003A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PROGAER\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_aerighe.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_aerighe.Next();
      }
      m_cConnectivityError = Cursor_aerighe.ErrorMessage();
      Cursor_aerighe.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aeoprig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000003C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGAEOPEXTR\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_aeoprig.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(IDBASE)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aederig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"0000003E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGAEDELEG\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_aederig.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from filedatiuic
      m_cServer = m_Ctx.GetServer("filedatiuic");
      m_cPhName = m_Ctx.GetPhName("filedatiuic");
      if (Cursor_filedatiuic!=null)
        Cursor_filedatiuic.Close();
      Cursor_filedatiuic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select Max(idfile)  as prg1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("filedatiuic")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_filedatiuic.Eof())) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allineamenti",38,"00000040")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGFILEUIC\\'"+CPLib.LRTrim(cAzi)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cAzi),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_filedatiuic.GetString("prg1")),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        Cursor_filedatiuic.Next();
      }
      m_cConnectivityError = Cursor_filedatiuic.ErrorMessage();
      Cursor_filedatiuic.Close();
      // * --- End Select
      /* Return  */
      Forward f;
      f=new Forward("../jsp/start_page_logo_portlet.jsp",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpwarn!=null)
          Cursor_cpwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aefiles!=null)
          Cursor_aefiles.Close();
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
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_filedatiuic!=null)
          Cursor_filedatiuic.Close();
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
  public static allineamentiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allineamentiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cAzi = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000010(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000012(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000013(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000014(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000016(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000018(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000024(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000027(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000028(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000036(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000040(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
}
