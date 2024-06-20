// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_chkdataR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
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
  public java.sql.Date pData;
  public String pDoc;
  public String pTipo;
  public java.sql.Date pDatOpe;
  public boolean bRitorno;
  public java.sql.Date _datconf;
  public double _anno;
  public String _cdate;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_chkdataR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_cgo_chkdata",m_Caller);
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    if (m_cPhName_cgo_tipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tipdoc = m_cPhName_cgo_tipdoc+" "+m_Ctx.GetWritePhName("cgo_tipdoc");
    }
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_chkdata";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pDoc",p_cVarName)) {
      return pDoc;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_cdate",p_cVarName)) {
      return _cdate;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pData",p_cVarName)) {
      return pData;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("_datconf",p_cVarName)) {
      return _datconf;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pDoc",p_cVarName)) {
      pDoc = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_cdate",p_cVarName)) {
      _cdate = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pData",p_cVarName)) {
      pData = value;
      return;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("_datconf",p_cVarName)) {
      _datconf = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
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
    CPResultSet Cursor_cgo_tipdoc=null;
    try {
      /* pData Date // Data Da verificare */
      /* pDoc Char(2) // Tipo Documento */
      /* pTipo Char(1) // Tipo Data */
      /* pDatOpe Date // Tipo Data */
      /* bRitorno Bool */
      /* _datconf Date */
      /* _anno Numeric(10, 0) */
      /* _cdate Char(8) */
      /* bRitorno := True */
      bRitorno = true;
      /* If not(Empty(pDatOpe)) */
      if ( ! (CPLib.Empty(pDatOpe))) {
        /* _cdate := DateToChar(pDatOpe) */
        _cdate = CPLib.DateToChar(pDatOpe);
        // * --- Select from cgo_tipdoc
        m_cServer = m_Ctx.GetServer("cgo_tipdoc");
        m_cPhName = m_Ctx.GetPhName("cgo_tipdoc");
        if (Cursor_cgo_tipdoc!=null)
          Cursor_cgo_tipdoc.Close();
        Cursor_cgo_tipdoc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DISANNIMIN,DISANNIMAX  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(pDoc,"?",0,0,m_cServer, m_oParameters),m_cServer,pDoc)+" "+")"+(m_Ctx.IsSharedTemp("cgo_tipdoc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_tipdoc.Eof())) {
          /* If pTipo='R' */
          if (CPLib.eqr(pTipo,"R")) {
            /* _anno := Year(pDatOpe) - cgo_tipdoc->DISANNIMIN */
            _anno = CPLib.Round(CPLib.Year(pDatOpe)-Cursor_cgo_tipdoc.GetDouble("DISANNIMIN"),0);
            /* _datconf := CharToDate(Str(_anno,4,0)+Substr(_cdate,5,4)) */
            _datconf = CPLib.CharToDate(CPLib.Str(_anno,4,0)+CPLib.Substr(_cdate,5,4));
            /* If pData < _datconf  */
            if (CPLib.lt(pData,_datconf)) {
              /* bRitorno := False */
              bRitorno = false;
              /* Error Msg 'La data di rilascio è inferiore al minimo previsto per il tipo di documento: ' + arfn_fdate(_datconf) */
              m_cLastMsgError = "La data di rilascio è inferiore al minimo previsto per il tipo di documento: "+arfn_fdateR.Make(m_Ctx,this).Run(_datconf);
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            } // End If
            /* ElseIf pTipo='S' */
          } else if (CPLib.eqr(pTipo,"S")) {
            /* _anno := Year(pDatOpe) + cgo_tipdoc->DISANNIMIN */
            _anno = CPLib.Round(CPLib.Year(pDatOpe)+Cursor_cgo_tipdoc.GetDouble("DISANNIMIN"),0);
            /* _datconf := CharToDate(Str(_anno,4,0)+Substr(_cdate,5,4)) */
            _datconf = CPLib.CharToDate(CPLib.Str(_anno,4,0)+CPLib.Substr(_cdate,5,4));
            /* If pData > _datconf  */
            if (CPLib.gt(pData,_datconf)) {
              /* bRitorno := False */
              bRitorno = false;
              /* Error Msg 'La data di scadenza è superiore al massimo previsto per il tipo di documento: ' + arfn_fdate(_datconf) */
              m_cLastMsgError = "La data di scadenza è superiore al massimo previsto per il tipo di documento: "+arfn_fdateR.Make(m_Ctx,this).Run(_datconf);
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            } // End If
          } // End If
          Cursor_cgo_tipdoc.Next();
        }
        m_cConnectivityError = Cursor_cgo_tipdoc.ErrorMessage();
        Cursor_cgo_tipdoc.Close();
        // * --- End Select
      } // End If
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_cgo_tipdoc!=null)
          Cursor_cgo_tipdoc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pData,String p_pDoc,String p_pTipo,java.sql.Date p_pDatOpe) {
    pData = p_pData;
    pDoc = p_pDoc;
    pTipo = p_pTipo;
    pDatOpe = p_pDatOpe;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public boolean Run(java.sql.Date p_pData,String p_pDoc,String p_pTipo,java.sql.Date p_pDatOpe) {
    pData = p_pData;
    pDoc = p_pDoc;
    pTipo = p_pTipo;
    pDatOpe = p_pDatOpe;
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
  public static arfn_cgo_chkdataR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_chkdataR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_chkdataR Make(CPContext p_Ctx) {
    return new arfn_cgo_chkdataR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pData = CPLib.NullDate();
    pDoc = CPLib.Space(2);
    pTipo = CPLib.Space(1);
    pDatOpe = CPLib.NullDate();
    bRitorno = false;
    _datconf = CPLib.NullDate();
    _anno = 0;
    _cdate = CPLib.Space(8);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_chkdata,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_cgo_chkdata,arfn_fdate,";
  public static String[] m_cRunParameterNames={"pData","pDoc","pTipo","pDatOpe"};
}
