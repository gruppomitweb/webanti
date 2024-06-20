// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_agg_famiglieR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
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
  public String w_CONNES;
  public double w_CFESTERO;
  public String w_flgaggfam;
  public java.sql.Date gDataTito;
  public double _noage;
  public String _annomin;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_agg_famiglieR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_agg_famiglie",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
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
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("CFESTERO",p_cVarName)) {
      return w_CFESTERO;
    }
    if (CPLib.eqr("_noage",p_cVarName)) {
      return _noage;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_agg_famiglie";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("flgaggfam",p_cVarName)) {
      return w_flgaggfam;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      return _annomin;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
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
    if (CPLib.eqr("CFESTERO",p_cVarName)) {
      w_CFESTERO = value;
      return;
    }
    if (CPLib.eqr("_noage",p_cVarName)) {
      _noage = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("flgaggfam",p_cVarName)) {
      w_flgaggfam = value;
      return;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      _annomin = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
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
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_aggfam_aetesta=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_qbe_aggfam_opextrbo=null;
    CPResultSet Cursor_qbe_aggfam_opextrbo_new=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_CONNES Char(16) */
      /* w_CFESTERO Numeric(1, 0) */
      /* w_flgaggfam Char(1) */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* _noage Numeric(1, 0) */
      /* _annomin Char(4) */
      /* _annomin := Str(Year(Date())-10,4,0) */
      _annomin = CPLib.Str(CPLib.Year(CPLib.Date())-10,4,0);
      /* If w_flgaggfam='S' */
      if (CPLib.eqr(w_flgaggfam,"S")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _noage := 0 */
          _noage = CPLib.Round(0,0);
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _noage = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_agg_famiglie returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _noage = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _noage = 0 */
          if (CPLib.eqr(_noage,0)) {
            /* If Empty(intestbo->DATAFINE) */
            if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
              // * --- Select from qbe_aggfam_aetesta
              SPBridge.HMCaller _h00000012;
              _h00000012 = new SPBridge.HMCaller();
              _h00000012.Set("m_cVQRList",m_cVQRList);
              _h00000012.Set("pRAPPORTO",Cursor_intestbo.GetString("RAPPORTO"));
              if (Cursor_qbe_aggfam_aetesta!=null)
                Cursor_qbe_aggfam_aetesta.Close();
              Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000012,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000013")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
                Cursor_qbe_aggfam_aetesta.Next();
              }
              m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
              Cursor_qbe_aggfam_aetesta.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If Empty(jntestbo->DATAFINE) */
          if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
            // * --- Select from qbe_aggfam_aetesta
            SPBridge.HMCaller _h00000016;
            _h00000016 = new SPBridge.HMCaller();
            _h00000016.Set("m_cVQRList",m_cVQRList);
            _h00000016.Set("pRAPPORTO",Cursor_jntestbo.GetString("RAPPORTO"));
            if (Cursor_qbe_aggfam_aetesta!=null)
              Cursor_qbe_aggfam_aetesta.Close();
            Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000016,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
              // * --- Write into aetesta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000017")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
              Cursor_qbe_aggfam_aetesta.Next();
            }
            m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
            Cursor_qbe_aggfam_aetesta.Close();
            // * --- End Select
          } // End If
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* _noage := 0 */
          _noage = CPLib.Round(0,0);
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
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _noage = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_agg_famiglie returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _noage = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _noage = 0 */
          if (CPLib.eqr(_noage,0)) {
            /* If delegabo->NOAGE='N' or Empty(delegabo->NOAGE) */
            if (CPLib.eqr(Cursor_delegabo.GetString("NOAGE"),"N") || CPLib.Empty(Cursor_delegabo.GetString("NOAGE"))) {
              // * --- Select from qbe_aggfam_aetesta
              SPBridge.HMCaller _h0000001E;
              _h0000001E = new SPBridge.HMCaller();
              _h0000001E.Set("m_cVQRList",m_cVQRList);
              _h0000001E.Set("pRAPPORTO",Cursor_delegabo.GetString("RAPPORTO"));
              if (Cursor_qbe_aggfam_aetesta!=null)
                Cursor_qbe_aggfam_aetesta.Close();
              Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001E,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
                Cursor_qbe_aggfam_aetesta.Next();
              }
              m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
              Cursor_qbe_aggfam_aetesta.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        // * --- Select from jelegabo
        m_cServer = m_Ctx.GetServer("jelegabo");
        m_cPhName = m_Ctx.GetPhName("jelegabo");
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
        Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jelegabo.Eof())) {
          // * --- Select from qbe_aggfam_aetesta
          SPBridge.HMCaller _h00000021;
          _h00000021 = new SPBridge.HMCaller();
          _h00000021.Set("m_cVQRList",m_cVQRList);
          _h00000021.Set("pRAPPORTO",Cursor_jelegabo.GetString("RAPPORTO"));
          if (Cursor_qbe_aggfam_aetesta!=null)
            Cursor_qbe_aggfam_aetesta.Close();
          Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000021,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
            // * --- Write into aetesta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000022")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
            Cursor_qbe_aggfam_aetesta.Next();
          }
          m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
          Cursor_qbe_aggfam_aetesta.Close();
          // * --- End Select
          Cursor_jelegabo.Next();
        }
        m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
        Cursor_jelegabo.Close();
        // * --- End Select
        // * --- Select from intestit
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
        Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestit.Eof())) {
          /* If Empty(intestit->DATAFINE) and intestit->DATAINI >= gDataTito */
          if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) && CPLib.ge(Cursor_intestit.GetDate("DATAINI"),gDataTito)) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _noage := 0 */
              _noage = CPLib.Round(0,0);
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _noage = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_agg_famiglie returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _noage = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _noage = 0 */
              if (CPLib.eqr(_noage,0)) {
                /* If Empty(intestbo->DATAFINE) */
                if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
                  // * --- Select from qbe_aggfam_aetesta
                  SPBridge.HMCaller _h0000002B;
                  _h0000002B = new SPBridge.HMCaller();
                  _h0000002B.Set("m_cVQRList",m_cVQRList);
                  _h0000002B.Set("pRAPPORTO",Cursor_intestbo.GetString("RAPPORTO"));
                  if (Cursor_qbe_aggfam_aetesta!=null)
                    Cursor_qbe_aggfam_aetesta.Close();
                  Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002B,true).GetResultSet(m_Ctx);
                  while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
                    Cursor_qbe_aggfam_aetesta.Next();
                  }
                  m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
                  Cursor_qbe_aggfam_aetesta.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            // * --- Select from jntestbo
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestbo.Eof())) {
              /* If Empty(jntestbo->DATAFINE) */
              if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
                // * --- Select from qbe_aggfam_aetesta
                SPBridge.HMCaller _h0000002F;
                _h0000002F = new SPBridge.HMCaller();
                _h0000002F.Set("m_cVQRList",m_cVQRList);
                _h0000002F.Set("pRAPPORTO",Cursor_jntestbo.GetString("RAPPORTO"));
                if (Cursor_qbe_aggfam_aetesta!=null)
                  Cursor_qbe_aggfam_aetesta.Close();
                Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
                  // * --- Write into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
                  Cursor_qbe_aggfam_aetesta.Next();
                }
                m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
                Cursor_qbe_aggfam_aetesta.Close();
                // * --- End Select
              } // End If
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            // * --- End Select
          } // End If
          Cursor_intestit.Next();
        }
        m_cConnectivityError = Cursor_intestit.ErrorMessage();
        Cursor_intestit.Close();
        // * --- End Select
        // * --- Select from jntestit
        m_cServer = m_Ctx.GetServer("jntestit");
        m_cPhName = m_Ctx.GetPhName("jntestit");
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
        Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestit.Eof())) {
          /* If Empty(jntestit->DATAFINE) and jntestit->DATAINI >= gDataTito */
          if (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")) && CPLib.ge(Cursor_jntestit.GetDate("DATAINI"),gDataTito)) {
            // * --- Select from jntestbo
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_jntestit.GetString("CODCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestbo.Eof())) {
              /* If Empty(jntestbo->DATAFINE) */
              if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
                // * --- Select from qbe_aggfam_aetesta
                SPBridge.HMCaller _h00000035;
                _h00000035 = new SPBridge.HMCaller();
                _h00000035.Set("m_cVQRList",m_cVQRList);
                _h00000035.Set("pRAPPORTO",Cursor_jntestbo.GetString("RAPPORTO"));
                if (Cursor_qbe_aggfam_aetesta!=null)
                  Cursor_qbe_aggfam_aetesta.Close();
                Cursor_qbe_aggfam_aetesta = new VQRHolder("qbe_aggfam_aetesta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000035,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_aggfam_aetesta.Eof())) {
                  // * --- Write into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_aetesta.GetString("RAPPORTO"))+"";
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
                  Cursor_qbe_aggfam_aetesta.Next();
                }
                m_cConnectivityError = Cursor_qbe_aggfam_aetesta.ErrorMessage();
                Cursor_qbe_aggfam_aetesta.Close();
                // * --- End Select
              } // End If
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            // * --- End Select
          } // End If
          Cursor_jntestit.Next();
        }
        m_cConnectivityError = Cursor_jntestit.ErrorMessage();
        Cursor_jntestit.Close();
        // * --- End Select
        // * --- Select from qbe_aggfam_opextrbo
        SPBridge.HMCaller _h00000038;
        _h00000038 = new SPBridge.HMCaller();
        _h00000038.Set("m_cVQRList",m_cVQRList);
        _h00000038.Set("CONNES",w_CONNES);
        _h00000038.Set("pAnno",_annomin);
        if (Cursor_qbe_aggfam_opextrbo!=null)
          Cursor_qbe_aggfam_opextrbo.Close();
        Cursor_qbe_aggfam_opextrbo = new VQRHolder("qbe_aggfam_opextrbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000038,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_aggfam_opextrbo.Eof())) {
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"00000039")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(w_CFESTERO,1)?"S":"N"),"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo.GetString("ANNO"))+"";
          m_cSql = m_cSql+" and COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo.GetString("COLLEG"))+"";
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
          Cursor_qbe_aggfam_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_aggfam_opextrbo.ErrorMessage();
        Cursor_qbe_aggfam_opextrbo.Close();
        // * --- End Select
      } // End If
      // * --- Select from qbe_aggfam_opextrbo_new
      SPBridge.HMCaller _h0000003A;
      _h0000003A = new SPBridge.HMCaller();
      _h0000003A.Set("m_cVQRList",m_cVQRList);
      _h0000003A.Set("CONNES",w_CONNES);
      _h0000003A.Set("pAnno",_annomin);
      if (Cursor_qbe_aggfam_opextrbo_new!=null)
        Cursor_qbe_aggfam_opextrbo_new.Close();
      Cursor_qbe_aggfam_opextrbo_new = new VQRHolder("qbe_aggfam_opextrbo_new",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_aggfam_opextrbo_new.Eof())) {
        // * --- Write into opextrbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_famiglie",14,"0000003B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(w_CFESTERO,1)?"S":"N"),"C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo_new.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo_new.GetString("ANNO"))+"";
        m_cSql = m_cSql+" and COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo_new.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo_new.GetString("COLLEG"))+"";
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
        Cursor_qbe_aggfam_opextrbo_new.Next();
      }
      m_cConnectivityError = Cursor_qbe_aggfam_opextrbo_new.ErrorMessage();
      Cursor_qbe_aggfam_opextrbo_new.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_qbe_aggfam_aetesta!=null)
          Cursor_qbe_aggfam_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
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
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aggfam_opextrbo!=null)
          Cursor_qbe_aggfam_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aggfam_opextrbo_new!=null)
          Cursor_qbe_aggfam_opextrbo_new.Close();
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
      m_Caller.SetString("CONNES","C",16,0,w_CONNES);
      m_Caller.SetNumber("CFESTERO","N",1,0,w_CFESTERO);
      m_Caller.SetString("flgaggfam","C",1,0,w_flgaggfam);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_agg_famiglieR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_agg_famiglieR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CONNES = m_Caller.GetString("CONNES","C",16,0);
    w_CFESTERO = m_Caller.GetNumber("CFESTERO","N",1,0);
    w_flgaggfam = m_Caller.GetString("flgaggfam","C",1,0);
    _noage = 0;
    _annomin = CPLib.Space(4);
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_opextrbo,qbe_aggfam_opextrbo_new,
  public static final String m_cVQRList = ",qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_aetesta,qbe_aggfam_opextrbo,qbe_aggfam_opextrbo_new,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
