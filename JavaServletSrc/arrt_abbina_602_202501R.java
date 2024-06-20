// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_abbina_602_202501R implements CallerWithObjs {
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
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_tmp_imprappo;
  public String m_cServer_tmp_imprappo;
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
  public String pOper;
  public String gMsgImp;
  public String gMsgProc;
  public double _ok;
  public double _okAcc;
  public double _riga;
  public String _tage;
  public String _cage;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_abbina_602_202501R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_abbina_602_202501",m_Caller);
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_tmp_imprappo = p_ContextObject.GetPhName("tmp_imprappo");
    if (m_cPhName_tmp_imprappo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_imprappo = m_cPhName_tmp_imprappo+" "+m_Ctx.GetWritePhName("tmp_imprappo");
    }
    m_cServer_tmp_imprappo = p_ContextObject.GetServer("tmp_imprappo");
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_abbina_602_202501";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      return pOper;
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
    if (CPLib.eqr("_cage",p_cVarName)) {
      return _cage;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pOper",p_cVarName)) {
      pOper = value;
      return;
    }
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
    if (CPLib.eqr("_cage",p_cVarName)) {
      _cage = value;
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
    /* pOper Char(1) // Accuratezza */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* _ok Numeric(1, 0) // Rapporto trovato e allineato */
    /* _okAcc Numeric(1, 0) // Rapporto trovato e allineato */
    /* _riga Numeric(10, 0) */
    /* _tage Char(2) */
    /* _cage Char(1) */
    /* Lancia la pagina in base all'operazione */
    /* Exec "Selezione" Page 2: */
    Page_2();
    /* Return True */
    throw new Stop(true);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_aerighe=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_rapporti_202501_a1=null;
    CPResultSet Cursor_qbe_rapporti_202501_a2=null;
    CPResultSet Cursor_qbe_rapporti_202501_a3=null;
    CPResultSet Cursor_qbe_rapporti_202501_a4=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Legge i dati da AERIGHE non abbinati */
      // * --- Delete from tmp_allinearap
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_allinearap");
      m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000010")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      // * --- Select from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      if (Cursor_aerighe!=null)
        Cursor_aerighe.Close();
      Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ABBINATO=0 "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aerighe.Eof())) {
        /* _ok := 0 // Rapporto trovato e allineato */
        _ok = CPLib.Round(0,0);
        /* _tage := '' */
        _tage = "";
        /* _cage := '' */
        _cage = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tage = Read_Cursor.GetString("TIPOAG");
          _cage = Read_Cursor.GetString("COINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_abbina_602_202501 returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tage = "";
          _cage = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Select from qbe_rapporti_202501_a1
        SPBridge.HMCaller _h00000017;
        _h00000017 = new SPBridge.HMCaller();
        _h00000017.Set("m_cVQRList",m_cVQRList);
        _h00000017.Set("codrap",Cursor_aerighe.GetString("RAPPORTO"));
        if (Cursor_qbe_rapporti_202501_a1!=null)
          Cursor_qbe_rapporti_202501_a1.Close();
        Cursor_qbe_rapporti_202501_a1 = new VQRHolder("qbe_rapporti_202501_a1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000017,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapporti_202501_a1.Eof())) {
          /* If qbe_rapporti_202501_a1->CODINTER=aerighe->CONNESINT and qbe_rapporti_202501_a1->DATAINI=aerighe->ADATA and qbe_rapporti_202501_a1->DATAFINE=aerighe->CDATA and qbe_rapporti_202501_a1->TIPOAG=_tage and iif(_cage="1",qbe_rapporti_202501_a1->TIPORAP='1',At(qbe_rapporti_202501_a1->TIPORAP,'|0|2') <> 0) and qbe_rapporti_202501_a1->NOPROT = 0 */
          if (CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetString("CODINTER"),Cursor_aerighe.GetString("CONNESINT")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetDate("DATAINI"),Cursor_aerighe.GetDate("ADATA")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetDate("DATAFINE"),Cursor_aerighe.GetDate("CDATA")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetString("TIPOAG"),_tage) && (CPLib.eqr(_cage,"1")?CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetString("TIPORAP"),"1"):CPLib.ne(CPLib.At(Cursor_qbe_rapporti_202501_a1.GetString("TIPORAP"),"|0|2"),0)) && CPLib.eqr(Cursor_qbe_rapporti_202501_a1.GetDouble("NOPROT"),0)) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000019")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_rapporti_202501_a1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_rapporti_202501_a1.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(Cursor_qbe_rapporti_202501_a1.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_rapporti_202501_a1.GetString("CODINTER"))+"";
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
          Cursor_qbe_rapporti_202501_a1.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_202501_a1.ErrorMessage();
        Cursor_qbe_rapporti_202501_a1.Close();
        // * --- End Select
        /* If _ok=1 */
        if (CPLib.eqr(_ok,1)) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"0000001C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
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
          // * --- Select from qbe_rapporti_202501_a2
          SPBridge.HMCaller _h0000001E;
          _h0000001E = new SPBridge.HMCaller();
          _h0000001E.Set("m_cVQRList",m_cVQRList);
          _h0000001E.Set("codrap",Cursor_aerighe.GetString("RAPPORTO"));
          if (Cursor_qbe_rapporti_202501_a2!=null)
            Cursor_qbe_rapporti_202501_a2.Close();
          Cursor_qbe_rapporti_202501_a2 = new VQRHolder("qbe_rapporti_202501_a2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_rapporti_202501_a2.Eof())) {
            /* If qbe_rapporti_202501_a2->CODINTER=aerighe->CONNESINT and qbe_rapporti_202501_a2->DATAINI=aerighe->ADATA and qbe_rapporti_202501_a2->DATAFINE=aerighe->CDATA and qbe_rapporti_202501_a2->TIPOAG=_tage and iif(_cage="1",qbe_rapporti_202501_a2->TIPORAP='1',At(qbe_rapporti_202501_a2->TIPORAP,'|0|2') <> 0) and qbe_rapporti_202501_a2->NOPROT = 0 */
            if (CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetString("CODINTER"),Cursor_aerighe.GetString("CONNESINT")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetDate("DATAINI"),Cursor_aerighe.GetDate("ADATA")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetDate("DATAFINE"),Cursor_aerighe.GetDate("CDATA")) && CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetString("TIPOAG"),_tage) && (CPLib.eqr(_cage,"1")?CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetString("TIPORAP"),"1"):CPLib.ne(CPLib.At(Cursor_qbe_rapporti_202501_a2.GetString("TIPORAP"),"|0|2"),0)) && CPLib.eqr(Cursor_qbe_rapporti_202501_a2.GetDouble("NOPROT"),0)) {
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000020")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_rapporti_202501_a2.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_rapporti_202501_a2.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_rapporti_202501_a2.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_rapporti_202501_a2.GetString("CODINTER"))+"";
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
            /* If _ok=1 */
            if (CPLib.eqr(_ok,1)) {
              // * --- Write into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000023")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
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
            Cursor_qbe_rapporti_202501_a2.Next();
          }
          m_cConnectivityError = Cursor_qbe_rapporti_202501_a2.ErrorMessage();
          Cursor_qbe_rapporti_202501_a2.Close();
          // * --- End Select
        } // End If
        /* If _ok = 0 */
        if (CPLib.eqr(_ok,0)) {
          /* If pOper='A' or LRTrim(pOper)='' */
          if (CPLib.eqr(pOper,"A") || CPLib.eqr(CPLib.LRTrim(pOper),"")) {
            // * --- Select from qbe_rapporti_202501_a3
            SPBridge.HMCaller _h00000026;
            _h00000026 = new SPBridge.HMCaller();
            _h00000026.Set("m_cVQRList",m_cVQRList);
            _h00000026.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
            _h00000026.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
            _h00000026.Set("pDATAFINE",Cursor_aerighe.GetDate("CDATA"));
            if (Cursor_qbe_rapporti_202501_a3!=null)
              Cursor_qbe_rapporti_202501_a3.Close();
            Cursor_qbe_rapporti_202501_a3 = new VQRHolder("qbe_rapporti_202501_a3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000026,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_rapporti_202501_a3.Eof())) {
              /* If Val(qbe_rapporti_202501_a3->TIPOAG)=Val(_tage) and iif(_cage="1",qbe_rapporti_202501_a3->TIPORAP='1',At(qbe_rapporti_202501_a3->TIPORAP,'|0|2') <> 0) */
              if (CPLib.eqr(CPLib.Val(Cursor_qbe_rapporti_202501_a3.GetString("TIPOAG")),CPLib.Val(_tage)) && (CPLib.eqr(_cage,"1")?CPLib.eqr(Cursor_qbe_rapporti_202501_a3.GetString("TIPORAP"),"1"):CPLib.ne(CPLib.At(Cursor_qbe_rapporti_202501_a3.GetString("TIPORAP"),"|0|2"),0))) {
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a3.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
              } // End If
              Cursor_qbe_rapporti_202501_a3.Next();
            }
            m_cConnectivityError = Cursor_qbe_rapporti_202501_a3.ErrorMessage();
            Cursor_qbe_rapporti_202501_a3.Close();
            // * --- End Select
            /* If _okAcc=0 */
            if (CPLib.eqr(_okAcc,0)) {
              // * --- Select from qbe_rapporti_202501_a4
              SPBridge.HMCaller _h0000002C;
              _h0000002C = new SPBridge.HMCaller();
              _h0000002C.Set("m_cVQRList",m_cVQRList);
              _h0000002C.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
              _h0000002C.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
              _h0000002C.Set("pDATAFINE",Cursor_aerighe.GetDate("CDATA"));
              if (Cursor_qbe_rapporti_202501_a4!=null)
                Cursor_qbe_rapporti_202501_a4.Close();
              Cursor_qbe_rapporti_202501_a4 = new VQRHolder("qbe_rapporti_202501_a4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002C,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_rapporti_202501_a4.Eof())) {
                /* If Val(qbe_rapporti_202501_a4->TIPOAG)=Val(_tage) and iif(_cage="1",qbe_rapporti_202501_a4->TIPORAP='1',At(qbe_rapporti_202501_a4->TIPORAP,'|0|2') <> 0) */
                if (CPLib.eqr(CPLib.Val(Cursor_qbe_rapporti_202501_a4.GetString("TIPOAG")),CPLib.Val(_tage)) && (CPLib.eqr(_cage,"1")?CPLib.eqr(Cursor_qbe_rapporti_202501_a4.GetString("TIPORAP"),"1"):CPLib.ne(CPLib.At(Cursor_qbe_rapporti_202501_a4.GetString("TIPORAP"),"|0|2"),0))) {
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a4.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
                } // End If
                Cursor_qbe_rapporti_202501_a4.Next();
              }
              m_cConnectivityError = Cursor_qbe_rapporti_202501_a4.ErrorMessage();
              Cursor_qbe_rapporti_202501_a4.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If pOper='B' or (LRTrim(pOper)='' and _okAcc=0) */
          if (CPLib.eqr(pOper,"B") || (CPLib.eqr(CPLib.LRTrim(pOper),"") && CPLib.eqr(_okAcc,0))) {
            // * --- Select from qbe_rapporti_202501_a3
            SPBridge.HMCaller _h00000032;
            _h00000032 = new SPBridge.HMCaller();
            _h00000032.Set("m_cVQRList",m_cVQRList);
            _h00000032.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
            _h00000032.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
            _h00000032.Set("pDATAFINE",Cursor_aerighe.GetDate("CDATA"));
            if (Cursor_qbe_rapporti_202501_a3!=null)
              Cursor_qbe_rapporti_202501_a3.Close();
            Cursor_qbe_rapporti_202501_a3 = new VQRHolder("qbe_rapporti_202501_a3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000032,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_rapporti_202501_a3.Eof())) {
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000035")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000035(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a3.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
              Cursor_qbe_rapporti_202501_a3.Next();
            }
            m_cConnectivityError = Cursor_qbe_rapporti_202501_a3.ErrorMessage();
            Cursor_qbe_rapporti_202501_a3.Close();
            // * --- End Select
            /* If _okAcc=0 */
            if (CPLib.eqr(_okAcc,0)) {
              // * --- Select from qbe_rapporti_202501_a4
              SPBridge.HMCaller _h00000037;
              _h00000037 = new SPBridge.HMCaller();
              _h00000037.Set("m_cVQRList",m_cVQRList);
              _h00000037.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
              _h00000037.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
              _h00000037.Set("pDATAFINE",Cursor_aerighe.GetDate("CDATA"));
              if (Cursor_qbe_rapporti_202501_a4!=null)
                Cursor_qbe_rapporti_202501_a4.Close();
              Cursor_qbe_rapporti_202501_a4 = new VQRHolder("qbe_rapporti_202501_a4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000037,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_rapporti_202501_a4.Eof())) {
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"0000003A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000003A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a4.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
                Cursor_qbe_rapporti_202501_a4.Next();
              }
              m_cConnectivityError = Cursor_qbe_rapporti_202501_a4.ErrorMessage();
              Cursor_qbe_rapporti_202501_a4.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If pOper='C' or (LRTrim(pOper)='' and _okAcc=0) */
          if (CPLib.eqr(pOper,"C") || (CPLib.eqr(CPLib.LRTrim(pOper),"") && CPLib.eqr(_okAcc,0))) {
            // * --- Select from qbe_rapporti_202501_a3
            SPBridge.HMCaller _h0000003C;
            _h0000003C = new SPBridge.HMCaller();
            _h0000003C.Set("m_cVQRList",m_cVQRList);
            _h0000003C.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
            _h0000003C.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
            if (Cursor_qbe_rapporti_202501_a3!=null)
              Cursor_qbe_rapporti_202501_a3.Close();
            Cursor_qbe_rapporti_202501_a3 = new VQRHolder("qbe_rapporti_202501_a3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003C,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_rapporti_202501_a3.Eof())) {
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"0000003F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000003F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a3.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
              Cursor_qbe_rapporti_202501_a3.Next();
            }
            m_cConnectivityError = Cursor_qbe_rapporti_202501_a3.ErrorMessage();
            Cursor_qbe_rapporti_202501_a3.Close();
            // * --- End Select
            /* If _okAcc=0 */
            if (CPLib.eqr(_okAcc,0)) {
              // * --- Select from qbe_rapporti_202501_a4
              SPBridge.HMCaller _h00000041;
              _h00000041 = new SPBridge.HMCaller();
              _h00000041.Set("m_cVQRList",m_cVQRList);
              _h00000041.Set("pCODINTER",Cursor_aerighe.GetString("CONNESINT"));
              _h00000041.Set("pDATAINI",Cursor_aerighe.GetDate("ADATA"));
              if (Cursor_qbe_rapporti_202501_a4!=null)
                Cursor_qbe_rapporti_202501_a4.Close();
              Cursor_qbe_rapporti_202501_a4 = new VQRHolder("qbe_rapporti_202501_a4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000041,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_rapporti_202501_a4.Eof())) {
                /* _riga := _riga + 1 */
                _riga = CPLib.Round(_riga+1,0);
                // * --- Insert into tmp_allinearap from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_allinearap");
                m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_602_202501",31,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cage,"1")?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_rapporti_202501_a4.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_rapporti_202501_a4.GetString("TIPORAP"),"1")?"S":"N"),"?",0,0,m_cServer)+", ";
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
                Cursor_qbe_rapporti_202501_a4.Next();
              }
              m_cConnectivityError = Cursor_qbe_rapporti_202501_a4.ErrorMessage();
              Cursor_qbe_rapporti_202501_a4.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        Cursor_aerighe.Next();
      }
      m_cConnectivityError = Cursor_aerighe.ErrorMessage();
      Cursor_aerighe.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
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
        if (Cursor_qbe_rapporti_202501_a1!=null)
          Cursor_qbe_rapporti_202501_a1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_202501_a2!=null)
          Cursor_qbe_rapporti_202501_a2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_202501_a3!=null)
          Cursor_qbe_rapporti_202501_a3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_202501_a4!=null)
          Cursor_qbe_rapporti_202501_a4.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pOper) {
    pOper = p_pOper;
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
  public boolean Run(String p_pOper) {
    pOper = p_pOper;
    return Run();
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
  public static arrt_abbina_602_202501R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_abbina_602_202501R(p_Ctx, p_Caller);
  }
  public static arrt_abbina_602_202501R Make(CPContext p_Ctx) {
    return new arrt_abbina_602_202501R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pOper = CPLib.Space(1);
    _ok = 0;
    _okAcc = 0;
    _riga = 0;
    _tage = CPLib.Space(2);
    _cage = CPLib.Space(1);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_rapporti_202501_a1,qbe_rapporti_202501_a2,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,
  public static final String m_cVQRList = ",qbe_rapporti_202501_a1,qbe_rapporti_202501_a2,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,qbe_rapporti_202501_a3,qbe_rapporti_202501_a4,";
  // ENTITY_BATCHES: ,arrt_abbina_602_202501,
  public static final String i_InvokedRoutines = ",arrt_abbina_602_202501,";
  public static String[] m_cRunParameterNames={"pOper"};
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000035(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AGERAPPORTO,";
    p_cSql = p_cSql+"AGENRIG,";
    p_cSql = p_cSql+"AGEDATAOPE,";
    p_cSql = p_cSql+"AGEDATACHIU,";
    p_cSql = p_cSql+"AGECONNESCLI,";
    p_cSql = p_cSql+"AGETIPO,";
    p_cSql = p_cSql+"AGECOIN,";
    p_cSql = p_cSql+"AUIRAPPORTO,";
    p_cSql = p_cSql+"AUINRIG,";
    p_cSql = p_cSql+"AUIDATAOPE,";
    p_cSql = p_cSql+"AUIDATACHIU,";
    p_cSql = p_cSql+"AUICONNESCLI,";
    p_cSql = p_cSql+"AUITIPO,";
    p_cSql = p_cSql+"AUICOIN,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+"NUMRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allinearap",true);
    return p_cSql;
  }
}
