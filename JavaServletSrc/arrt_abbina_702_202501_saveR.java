// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_abbina_702_202501_saveR implements CallerWithObjs {
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_tmp_allinearap;
  public String m_cServer_tmp_allinearap;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
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
  public MemoryCursor_allinearapdel_mcrdef mcValues;
  public String gMsgImp;
  public String gMsgProc;
  public double _ok;
  public double _okAcc;
  public double _riga;
  public String _tage;
  public String _cage;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_abbina_702_202501_saveR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_abbina_702_202501_save",m_Caller);
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_tmp_allinearap = p_ContextObject.GetPhName("tmp_allinearap");
    if (m_cPhName_tmp_allinearap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_allinearap = m_cPhName_tmp_allinearap+" "+m_Ctx.GetWritePhName("tmp_allinearap");
    }
    m_cServer_tmp_allinearap = p_ContextObject.GetServer("tmp_allinearap");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
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
      return "arrt_abbina_702_202501_save";
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
    if (CPLib.eqr("mcValues",p_cVarName)) {
      return mcValues;
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
    if (CPLib.eqr("mcValues",p_cVarName)) {
      mcValues = (MemoryCursor_allinearapdel_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_allinearap=null;
    try {
      /* mcValues MemoryCursor(AllineaRapDel.MCRDef) // Cursore per allineamento rapporti */
      /* Nel memory cursor riceviamo il numero riga e lo stato ps_rowstatus 
         
         S-Selected, 
         U-Unselected. 
         M-Modified) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _ok Numeric(1, 0) // Rapporto trovato e allineato */
      /* _okAcc Numeric(1, 0) // Rapporto trovato e allineato */
      /* _riga Numeric(10, 0) */
      /* _tage Char(2) */
      /* _cage Char(1) */
      /* Lancia la pagina in base all'operazione */
      /* If mcValues.RecCount()<>0 */
      if (CPLib.ne(mcValues.RecCount(),0)) {
        /* Creo la chiave sul memory cursor */
        /* _riga := 1 */
        _riga = CPLib.Round(1,0);
        /* While _riga<=mcValues.RecCount() */
        while (CPLib.le(_riga,mcValues.RecCount())) {
          /* If mcValues.ps_rowstatus='S' */
          if (CPLib.eqr(mcValues.row.ps_rowstatus,"S")) {
            // * --- Select from tmp_allinearap
            m_cServer = m_Ctx.GetServer("tmp_allinearap");
            m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
            if (Cursor_tmp_allinearap!=null)
              Cursor_tmp_allinearap.Close();
            Cursor_tmp_allinearap = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMRIGA="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcValues.row.NUMRIGA,"?",0,0,m_cServer, m_oParameters),m_cServer,mcValues.row.NUMRIGA)+" "+")"+(m_Ctx.IsSharedTemp("tmp_allinearap")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_allinearap.Eof())) {
              // * --- Write into aederig from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aederig");
              m_cPhName = m_Ctx.GetPhName("aederig");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501_save",46,"00000014")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AUIRAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AGERAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AGERAPPORTO"))+"";
              m_cSql = m_cSql+" and CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AGECONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AGECONNESCLI"))+"";
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
              /* If tmp_allinearap->FLGSEL='A' */
              if (CPLib.eqr(Cursor_tmp_allinearap.GetString("FLGSEL"),"A")) {
                // * --- Write into delegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501_save",46,"00000016")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AUIRAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AUIRAPPORTO"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AUICONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AUICONNESCLI"))+"";
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
                /* ElseIf tmp_allinearap->FLGSEL='E' */
              } else if (CPLib.eqr(Cursor_tmp_allinearap.GetString("FLGSEL"),"E")) {
                // * --- Write into jelegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501_save",46,"00000017")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AUIRAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AUIRAPPORTO"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_allinearap.GetString("AUICONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_allinearap.GetString("AUICONNESCLI"))+"";
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
              // * --- Delete from tmp_allinearap
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_allinearap");
              m_cPhName = m_Ctx.GetPhName("tmp_allinearap");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allinearap",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_abbina_702_202501_save",46,"00000018")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMRIGA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(mcValues.row.NUMRIGA,"?",0,0,m_cServer),m_cServer,mcValues.row.NUMRIGA)+"";
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
              Cursor_tmp_allinearap.Next();
            }
            m_cConnectivityError = Cursor_tmp_allinearap.ErrorMessage();
            Cursor_tmp_allinearap.Close();
            // * --- End Select
          } // End If
          /* _riga := _riga + 1 */
          _riga = CPLib.Round(_riga+1,0);
          /* mcValues.Next() // Elementi selezionati */
          mcValues.Next();
        } // End While
      } // End If
      /* Return True */
      throw new Stop(true);
    } finally {
      try {
        if (Cursor_tmp_allinearap!=null)
          Cursor_tmp_allinearap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_allinearapdel_mcrdef p_mcValues) {
    mcValues = p_mcValues;
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
  public boolean Run(MemoryCursor_allinearapdel_mcrdef p_mcValues) {
    mcValues = p_mcValues;
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
  public static arrt_abbina_702_202501_saveR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_abbina_702_202501_saveR(p_Ctx, p_Caller);
  }
  public static arrt_abbina_702_202501_saveR Make(CPContext p_Ctx) {
    return new arrt_abbina_702_202501_saveR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcValues = new MemoryCursor_allinearapdel_mcrdef();
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
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_abbina_702_202501_save,
  public static final String i_InvokedRoutines = ",arrt_abbina_702_202501_save,";
  public static String[] m_cRunParameterNames={"mcValues"};
}
