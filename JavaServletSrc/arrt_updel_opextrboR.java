// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_updel_opextrboR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
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
  public String pTipo;
  public String w_IDBASE;
  public String w_NUMPROG;
  public java.sql.Date w_DATAOPE;
  public java.sql.Date w_DATARETT;
  public String w_CONNESCLI;
  public String w_MTCN;
  public String gAzienda;
  public String gFlgWU;
  public java.sql.Date _mindataO;
  public java.sql.Date _mindataF;
  public java.sql.Date _mindata;
  public String _anno;
  public double _id;
  public String _numprogF;
  public String _numprogO;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_updel_opextrboR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_updel_opextrbo",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_updel_opextrbo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      return w_CONNESCLI;
    }
    if (CPLib.eqr("MTCN",p_cVarName)) {
      return w_MTCN;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_numprogF",p_cVarName)) {
      return _numprogF;
    }
    if (CPLib.eqr("_numprogO",p_cVarName)) {
      return _numprogO;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      return w_DATAOPE;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
    }
    if (CPLib.eqr("_mindataO",p_cVarName)) {
      return _mindataO;
    }
    if (CPLib.eqr("_mindataF",p_cVarName)) {
      return _mindataF;
    }
    if (CPLib.eqr("_mindata",p_cVarName)) {
      return _mindata;
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
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      w_CONNESCLI = value;
      return;
    }
    if (CPLib.eqr("MTCN",p_cVarName)) {
      w_MTCN = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_numprogF",p_cVarName)) {
      _numprogF = value;
      return;
    }
    if (CPLib.eqr("_numprogO",p_cVarName)) {
      _numprogO = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      w_DATAOPE = value;
      return;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
      return;
    }
    if (CPLib.eqr("_mindataO",p_cVarName)) {
      _mindataO = value;
      return;
    }
    if (CPLib.eqr("_mindataF",p_cVarName)) {
      _mindataF = value;
      return;
    }
    if (CPLib.eqr("_mindata",p_cVarName)) {
      _mindata = value;
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
    CPResultSet Cursor_qbe_mindata_operazbo=null;
    CPResultSet Cursor_qbe_mindata_fraziobo=null;
    CPResultSet Cursor_opextrbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* w_IDBASE Char(10) // Idbase */
      /* w_NUMPROG Char(11) // Idbase */
      /* w_DATAOPE Date */
      /* w_DATARETT Date */
      /* w_CONNESCLI Char(16) */
      /* w_MTCN Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* gFlgWU Char(1) // Gestione WU */
      /* _mindataO Date */
      /* _mindataF Date */
      /* _mindata Date */
      /* _anno Char(4) */
      /* _id Numeric(10, 0) */
      /* _numprogF Char(11) */
      /* _numprogO Char(11) */
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        /* _numprogF := iif(pTipo='F',w_NUMPROG,'') */
        _numprogF = (CPLib.eqr(pTipo,"F")?w_NUMPROG:"");
        /* _numprogO := iif(pTipo='O',w_NUMPROG,'') */
        _numprogO = (CPLib.eqr(pTipo,"O")?w_NUMPROG:"");
        /* _mindata := NullDate() */
        _mindata = CPLib.NullDate();
        // * --- Select from qbe_mindata_operazbo
        SPBridge.HMCaller _h0000001A;
        _h0000001A = new SPBridge.HMCaller();
        _h0000001A.Set("m_cVQRList",m_cVQRList);
        _h0000001A.Set("pNUMPROG",_numprogO);
        _h0000001A.Set("pCONNESCLI",w_CONNESCLI);
        _h0000001A.Set("pANNOOPE",CPLib.Year(w_DATAOPE));
        if (Cursor_qbe_mindata_operazbo!=null)
          Cursor_qbe_mindata_operazbo.Close();
        Cursor_qbe_mindata_operazbo = new VQRHolder("qbe_mindata_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001A,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_mindata_operazbo.Eof())) {
          /* _mindataO := qbe_mindata_operazbo->MINDATA */
          _mindataO = Cursor_qbe_mindata_operazbo.GetDate("MINDATA");
          Cursor_qbe_mindata_operazbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_mindata_operazbo.ErrorMessage();
        Cursor_qbe_mindata_operazbo.Close();
        // * --- End Select
        // * --- Select from qbe_mindata_fraziobo
        SPBridge.HMCaller _h0000001C;
        _h0000001C = new SPBridge.HMCaller();
        _h0000001C.Set("m_cVQRList",m_cVQRList);
        _h0000001C.Set("pNUMPROG",_numprogF);
        _h0000001C.Set("pCONNESCLI",w_CONNESCLI);
        _h0000001C.Set("pANNOOPE",CPLib.Year(w_DATAOPE));
        if (Cursor_qbe_mindata_fraziobo!=null)
          Cursor_qbe_mindata_fraziobo.Close();
        Cursor_qbe_mindata_fraziobo = new VQRHolder("qbe_mindata_fraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001C,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_mindata_fraziobo.Eof())) {
          /* _mindataF := qbe_mindata_fraziobo->MINDATA */
          _mindataF = Cursor_qbe_mindata_fraziobo.GetDate("MINDATA");
          Cursor_qbe_mindata_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_qbe_mindata_fraziobo.ErrorMessage();
        Cursor_qbe_mindata_fraziobo.Close();
        // * --- End Select
        /* If not(Empty(_mindataO)) or not(Empty(_mindataF)) */
        if ( ! (CPLib.Empty(_mindataO)) ||  ! (CPLib.Empty(_mindataF))) {
          /* Case Empty(_mindataO) */
          if (CPLib.Empty(_mindataO)) {
            /* _mindata := _mindataF */
            _mindata = _mindataF;
            /* Case Empty(_mindataF) */
          } else if (CPLib.Empty(_mindataF)) {
            /* _mindata := _mindataO */
            _mindata = _mindataO;
          } else { // Otherwise
            /* _mindata := iif(_mindataO < _mindataF,_mindataO,_mindataF) */
            _mindata = (CPLib.lt(_mindataO,_mindataF)?_mindataO:_mindataF);
          } // End Case
        } // End If
        /* _anno := Str(Year(w_DATAOPE),4,0) */
        _anno = CPLib.Str(CPLib.Year(w_DATAOPE),4,0);
        // * --- Select from opextrbo
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
        Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNESCLI)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,_anno)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_opextrbo.Eof())) {
          /* If Empty(_mindata) */
          if (CPLib.Empty(_mindata)) {
            /* If opextrbo->INVIATO=1 */
            if (CPLib.eqr(Cursor_opextrbo.GetDouble("INVIATO"),1)) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_updel_opextrbo",8,"00000027")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer),m_cServer,w_CONNESCLI)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
            } else { // Else
              // * --- Delete from opextrbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_updel_opextrbo",8,"00000028")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer),m_cServer,w_CONNESCLI)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
          } else { // Else
            /* If opextrbo->INVIATO=1 */
            if (CPLib.eqr(Cursor_opextrbo.GetDouble("INVIATO"),1)) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_updel_opextrbo",8,"0000002A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_mindata,"D",8,0)+", ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer),m_cServer,w_CONNESCLI)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
            } else { // Else
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_updel_opextrbo",8,"0000002B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer),m_cServer,w_CONNESCLI)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
          Cursor_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
        Cursor_opextrbo.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_qbe_mindata_operazbo!=null)
          Cursor_qbe_mindata_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_mindata_fraziobo!=null)
          Cursor_qbe_mindata_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
    return Run();
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("NUMPROG","C",11,0,w_NUMPROG);
      m_Caller.SetDate("DATAOPE","D",8,0,w_DATAOPE);
      m_Caller.SetDate("DATARETT","D",8,0,w_DATARETT);
      m_Caller.SetString("CONNESCLI","C",16,0,w_CONNESCLI);
      m_Caller.SetString("MTCN","C",10,0,w_MTCN);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_updel_opextrboR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_updel_opextrboR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",11,0);
    w_DATAOPE = m_Caller.GetDate("DATAOPE","D",8,0);
    w_DATARETT = m_Caller.GetDate("DATARETT","D",8,0);
    w_CONNESCLI = m_Caller.GetString("CONNESCLI","C",16,0);
    w_MTCN = m_Caller.GetString("MTCN","C",10,0);
    _mindataO = CPLib.NullDate();
    _mindataF = CPLib.NullDate();
    _mindata = CPLib.NullDate();
    _anno = CPLib.Space(4);
    _id = 0;
    _numprogF = CPLib.Space(11);
    _numprogO = CPLib.Space(11);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_mindata_operazbo,qbe_mindata_fraziobo,
  public static final String m_cVQRList = ",qbe_mindata_operazbo,qbe_mindata_fraziobo,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pTipo"};
}
