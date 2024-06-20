// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_abbina_702_202501R implements CallerWithObjs {
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
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_tmp_allinearap;
  public String m_cServer_tmp_allinearap;
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
  public String gMsgImp;
  public String gMsgProc;
  public double _ok;
  public double _okAcc;
  public double _riga;
  public String _tage;
  public double _nprot;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_abbina_702_202501R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_abbina_702_202501",m_Caller);
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_tmp_allinearap = p_ContextObject.GetPhName("tmp_allinearap");
    if (m_cPhName_tmp_allinearap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_allinearap = m_cPhName_tmp_allinearap+" "+m_Ctx.GetWritePhName("tmp_allinearap");
    }
    m_cServer_tmp_allinearap = p_ContextObject.GetServer("tmp_allinearap");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ok",p_cVarName)) {
      return _ok;
    }
    if (CPLib.eqr("_okAcc",p_cVarName)) {
      return _okAcc;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_nprot",p_cVarName)) {
      return _nprot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_abbina_702_202501";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_tage",p_cVarName)) {
      return _tage;
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
    if (CPLib.eqr("_ok",p_cVarName)) {
      _ok = value;
      return;
    }
    if (CPLib.eqr("_okAcc",p_cVarName)) {
      _okAcc = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_nprot",p_cVarName)) {
      _nprot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_tage",p_cVarName)) {
      _tage = value;
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
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_qbe_deleghe_202501_a1=null;
    CPResultSet Cursor_qbe_deleghe_202501_a2=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _ok Numeric(1, 0) // Rapporto trovato e allineato */
      /* _okAcc Numeric(1, 0) // Rapporto trovato e allineato */
      /* _riga Numeric(10, 0) */
      /* _tage Char(2) */
      /* _nprot Numeric(1, 0) */
      /* Lancia la pagina in base all'operazione */
      // * --- Delete from tmp_allinearap
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_allinearap");
      m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"0000000B")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      /* _riga := 0 */
      _riga = CPLib.Round(0,0);
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ABBINATO=0 "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* _ok := 0 // Rapporto trovato e allineato */
        _ok = CPLib.Round(0,0);
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* _tage := '' */
          _tage = "";
          /* _nprot := 0 */
          _nprot = CPLib.Round(0,0);
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_delegabo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tage = Read_Cursor.GetString("TIPOAG");
            _nprot = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_abbina_702_202501 returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tage = "";
            _nprot = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If delegabo->CODINTER=aederig->CONNESINT and delegabo->DATAINI=aederig->ADATA and delegabo->DATAFINE=aederig->CDATA and _tage=aederig->TIPOAG and _nprot=0 */
          if (CPLib.eqr(Cursor_delegabo.GetString("CODINTER"),Cursor_aederig.GetString("CONNESINT")) && CPLib.eqr(Cursor_delegabo.GetDate("DATAINI"),Cursor_aederig.GetDate("ADATA")) && CPLib.eqr(Cursor_delegabo.GetDate("DATAFINE"),Cursor_aederig.GetDate("CDATA")) && CPLib.eqr(_tage,Cursor_aederig.GetString("TIPOAG")) && CPLib.eqr(_nprot,0)) {
            // * --- Write into delegabo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000014")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
            /* _ok := 1 // Rapporto trovato e allineato */
            _ok = CPLib.Round(1,0);
          } // End If
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        /* If _ok=1 */
        if (CPLib.eqr(_ok,1)) {
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000017")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"))+"";
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
        /* If _ok = 0 */
        if (CPLib.eqr(_ok,0)) {
          // * --- Select from jelegabo
          m_cServer = m_Ctx.GetServer("jelegabo");
          m_cPhName = m_Ctx.GetPhName("jelegabo");
          if (Cursor_jelegabo!=null)
            Cursor_jelegabo.Close();
          Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jelegabo.Eof())) {
            /* _tage := '' */
            _tage = "";
            /* _nprot := 0 */
            _nprot = CPLib.Round(0,0);
            // * --- Read from jnarapbo
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jelegabo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_jelegabo.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("jnarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tage = Read_Cursor.GetString("TIPOAG");
              _nprot = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_abbina_702_202501 returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tage = "";
              _nprot = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If jelegabo->CODINTER=aederig->CONNESINT and jelegabo->DATAINI=aederig->ADATA and jelegabo->DATAFINE=aederig->CDATA and _tage=aederig->TIPOAG and _nprot=0 */
            if (CPLib.eqr(Cursor_jelegabo.GetString("CODINTER"),Cursor_aederig.GetString("CONNESINT")) && CPLib.eqr(Cursor_jelegabo.GetDate("DATAINI"),Cursor_aederig.GetDate("ADATA")) && CPLib.eqr(Cursor_jelegabo.GetDate("DATAFINE"),Cursor_aederig.GetDate("CDATA")) && CPLib.eqr(_tage,Cursor_aederig.GetString("TIPOAG")) && CPLib.eqr(_nprot,0)) {
              // * --- Write into jelegabo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jelegabo");
              m_cPhName = m_Ctx.GetPhName("jelegabo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jelegabo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_jelegabo.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_jelegabo.GetString("CODINTER"))+"";
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
              /* _ok := 1 // Rapporto trovato e allineato */
              _ok = CPLib.Round(1,0);
            } // End If
            Cursor_jelegabo.Next();
          }
          m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
          Cursor_jelegabo.Close();
          // * --- End Select
          /* If _ok=1 */
          if (CPLib.eqr(_ok,1)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000021")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"))+"";
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
        } // End If
        /* If _ok = 0 */
        if (CPLib.eqr(_ok,0)) {
          // * --- Select from qbe_deleghe_202501_a1
          SPBridge.HMCaller _h00000023;
          _h00000023 = new SPBridge.HMCaller();
          _h00000023.Set("m_cVQRList",m_cVQRList);
          _h00000023.Set("pCODINTER",Cursor_aederig.GetString("CONNESINT"));
          _h00000023.Set("pDATAINI",Cursor_aederig.GetDate("ADATA"));
          _h00000023.Set("pDATAFINE",Cursor_aederig.GetDate("CDATA"));
          if (Cursor_qbe_deleghe_202501_a1!=null)
            Cursor_qbe_deleghe_202501_a1.Close();
          Cursor_qbe_deleghe_202501_a1 = new VQRHolder("qbe_deleghe_202501_a1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000023,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_deleghe_202501_a1.Eof())) {
            /* _okAcc := 1 // Rapporto trovato e allineato */
            _okAcc = CPLib.Round(1,0);
            /* _riga := _riga + 1 */
            _riga = CPLib.Round(_riga+1,0);
            // * --- Insert into tmp_allinearap from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_allinearap");
            m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_allinearap",true);
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
            Cursor_qbe_deleghe_202501_a1.Next();
          }
          m_cConnectivityError = Cursor_qbe_deleghe_202501_a1.ErrorMessage();
          Cursor_qbe_deleghe_202501_a1.Close();
          // * --- End Select
          /* If _okAcc=0 */
          if (CPLib.eqr(_okAcc,0)) {
            // * --- Select from qbe_deleghe_202501_a2
            SPBridge.HMCaller _h00000028;
            _h00000028 = new SPBridge.HMCaller();
            _h00000028.Set("m_cVQRList",m_cVQRList);
            _h00000028.Set("pCODINTER",Cursor_aederig.GetString("CONNESINT"));
            _h00000028.Set("pDATAINI",Cursor_aederig.GetDate("ADATA"));
            _h00000028.Set("pDATAFINE",Cursor_aederig.GetDate("CDATA"));
            if (Cursor_qbe_deleghe_202501_a2!=null)
              Cursor_qbe_deleghe_202501_a2.Close();
            Cursor_qbe_deleghe_202501_a2 = new VQRHolder("qbe_deleghe_202501_a2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000028,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_deleghe_202501_a2.Eof())) {
              /* _okAcc := 1 // Rapporto trovato e allineato */
              _okAcc = CPLib.Round(1,0);
              /* _riga := _riga + 1 */
              _riga = CPLib.Round(_riga+1,0);
              // * --- Insert into tmp_allinearap from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_allinearap");
              m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"0000002B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_allinearap",true);
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
              Cursor_qbe_deleghe_202501_a2.Next();
            }
            m_cConnectivityError = Cursor_qbe_deleghe_202501_a2.ErrorMessage();
            Cursor_qbe_deleghe_202501_a2.Close();
            // * --- End Select
          } // End If
          /* If _okAcc=0 */
          if (CPLib.eqr(_okAcc,0)) {
            // * --- Select from qbe_deleghe_202501_a1
            SPBridge.HMCaller _h0000002D;
            _h0000002D = new SPBridge.HMCaller();
            _h0000002D.Set("m_cVQRList",m_cVQRList);
            _h0000002D.Set("pCODINTER",Cursor_aederig.GetString("CONNESINT"));
            _h0000002D.Set("pDATAINI",Cursor_aederig.GetDate("ADATA"));
            if (Cursor_qbe_deleghe_202501_a1!=null)
              Cursor_qbe_deleghe_202501_a1.Close();
            Cursor_qbe_deleghe_202501_a1 = new VQRHolder("qbe_deleghe_202501_a1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002D,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_deleghe_202501_a1.Eof())) {
              /* _okAcc := 1 // Rapporto trovato e allineato */
              _okAcc = CPLib.Round(1,0);
              /* _riga := _riga + 1 */
              _riga = CPLib.Round(_riga+1,0);
              // * --- Insert into tmp_allinearap from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_allinearap");
              m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_allinearap",true);
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
              Cursor_qbe_deleghe_202501_a1.Next();
            }
            m_cConnectivityError = Cursor_qbe_deleghe_202501_a1.ErrorMessage();
            Cursor_qbe_deleghe_202501_a1.Close();
            // * --- End Select
            /* If _okAcc=0 */
            if (CPLib.eqr(_okAcc,0)) {
              // * --- Select from qbe_deleghe_202501_a2
              SPBridge.HMCaller _h00000032;
              _h00000032 = new SPBridge.HMCaller();
              _h00000032.Set("m_cVQRList",m_cVQRList);
              _h00000032.Set("pCODINTER",Cursor_aederig.GetString("CONNESINT"));
              _h00000032.Set("pDATAINI",Cursor_aederig.GetDate("ADATA"));
              if (Cursor_qbe_deleghe_202501_a2!=null)
                Cursor_qbe_deleghe_202501_a2.Close();
              Cursor_qbe_deleghe_202501_a2 = new VQRHolder("qbe_deleghe_202501_a2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000032,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_deleghe_202501_a2.Eof())) {
                /* _riga := _riga + 1 */
                _riga = CPLib.Round(_riga+1,0);
                // * --- Insert into tmp_allinearap from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_allinearap");
                m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501",34,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_deleghe_202501_a2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_allinearap",true);
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
                Cursor_qbe_deleghe_202501_a2.Next();
              }
              m_cConnectivityError = Cursor_qbe_deleghe_202501_a2.ErrorMessage();
              Cursor_qbe_deleghe_202501_a2.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      /* Return True */
      throw new Stop(true);
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_deleghe_202501_a1!=null)
          Cursor_qbe_deleghe_202501_a1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_deleghe_202501_a2!=null)
          Cursor_qbe_deleghe_202501_a2.Close();
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
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
  public static arrt_abbina_702_202501R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_abbina_702_202501R(p_Ctx, p_Caller);
  }
  public static arrt_abbina_702_202501R Make(CPContext p_Ctx) {
    return new arrt_abbina_702_202501R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _ok = 0;
    _okAcc = 0;
    _riga = 0;
    _tage = CPLib.Space(2);
    _nprot = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_deleghe_202501_a1,qbe_deleghe_202501_a2,qbe_deleghe_202501_a1,qbe_deleghe_202501_a2,
  public static final String m_cVQRList = ",qbe_deleghe_202501_a1,qbe_deleghe_202501_a2,qbe_deleghe_202501_a1,qbe_deleghe_202501_a2,";
  // ENTITY_BATCHES: ,arrt_abbina_702_202501,
  public static final String i_InvokedRoutines = ",arrt_abbina_702_202501,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
}
