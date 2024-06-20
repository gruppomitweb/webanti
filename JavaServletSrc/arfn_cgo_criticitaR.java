// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_criticitaR implements CallerWithObjs {
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
  public String m_cPhName_tmp_cgo_crtc;
  public String m_cServer_tmp_cgo_crtc;
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
  public MemoryCursor_tmp_cgo_crtc mcCritici;
  public double _ggyel;
  public double _ggred;
  public String _flagtype;
  public double _ndif;
  public String w_tipo;
  public String NoName;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_criticitaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_criticita",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tmp_cgo_crtc = p_ContextObject.GetPhName("tmp_cgo_crtc");
    if (m_cPhName_tmp_cgo_crtc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_cgo_crtc = m_cPhName_tmp_cgo_crtc+" "+m_Ctx.GetWritePhName("tmp_cgo_crtc");
    }
    m_cServer_tmp_cgo_crtc = p_ContextObject.GetServer("tmp_cgo_crtc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ggyel",p_cVarName)) {
      return _ggyel;
    }
    if (CPLib.eqr("_ggred",p_cVarName)) {
      return _ggred;
    }
    if (CPLib.eqr("_ndif",p_cVarName)) {
      return _ndif;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_criticita";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_flagtype",p_cVarName)) {
      return _flagtype;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      return NoName;
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
    if (CPLib.eqr("mcCritici",p_cVarName)) {
      return mcCritici;
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
    if (CPLib.eqr("_ggyel",p_cVarName)) {
      _ggyel = value;
      return;
    }
    if (CPLib.eqr("_ggred",p_cVarName)) {
      _ggred = value;
      return;
    }
    if (CPLib.eqr("_ndif",p_cVarName)) {
      _ndif = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_flagtype",p_cVarName)) {
      _flagtype = value;
      return;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      w_tipo = value;
      return;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      NoName = value;
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
    if (CPLib.eqr("mcCritici",p_cVarName)) {
      mcCritici = (MemoryCursor_tmp_cgo_crtc)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_cgo_criticita=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* mcCritici MemoryCursor(tmp_cgo_crtc) */
      /* _ggyel Numeric(3, 0) */
      /* _ggred Numeric(3, 0) */
      /* _flagtype Char(1) */
      /* _ndif Numeric(4, 0) */
      /* w_tipo Char(1) */
      /* NoName Char(0) */
      /* Legge i parametri  */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select GGYELWAR,GGREDWAR  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _ggyel := intermbo->GGYELWAR */
        _ggyel = CPLib.Round(Cursor_intermbo.GetDouble("GGYELWAR"),0);
        /* _ggred := intermbo->GGREDWAR */
        _ggred = CPLib.Round(Cursor_intermbo.GetDouble("GGREDWAR"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Select from qbe_cgo_criticita
      SPBridge.HMCaller _h0000000F;
      _h0000000F = new SPBridge.HMCaller();
      _h0000000F.Set("m_cVQRList",m_cVQRList);
      _h0000000F.Set("tipo",pTipo);
      if (Cursor_qbe_cgo_criticita!=null)
        Cursor_qbe_cgo_criticita.Close();
      Cursor_qbe_cgo_criticita = new VQRHolder("qbe_cgo_criticita",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_criticita.Eof())) {
        /* _ndif := DateDiff(qbe_cgo_criticita->DATAOPE,Date())  */
        _ndif = CPLib.Round(CPLib.DateDiff(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"),CPLib.Date()),0);
        /* Case _ndif >= _ggred */
        if (CPLib.ge(_ndif,_ggred)) {
          /* _flagtype := 'R' */
          _flagtype = "R";
          /* Case _ndif >= _ggyel and _ndif < _ggred */
        } else if (CPLib.ge(_ndif,_ggyel) && CPLib.lt(_ndif,_ggred)) {
          /* _flagtype := 'Y' */
          _flagtype = "Y";
        } // End Case
        /* mcCritici.AppendBlank() */
        mcCritici.AppendBlank();
        /* mcCritici.CODDIP := qbe_cgo_criticita->CODDIPE */
        mcCritici.row.CODDIP = Cursor_qbe_cgo_criticita.GetString("CODDIPE");
        /* mcCritici.DATAOPE := qbe_cgo_criticita->DATAOPE */
        mcCritici.row.DATAOPE = Cursor_qbe_cgo_criticita.GetDate("DATAOPE");
        /* mcCritici.FLGCRTC := _flagtype */
        mcCritici.row.FLGCRTC = _flagtype;
        /* mcCritici.NUMDAYS := _ndif */
        mcCritici.row.NUMDAYS = _ndif;
        /* mcCritici.DESCDIP := qbe_cgo_criticita->DESCRIZ */
        mcCritici.row.DESCDIP = Cursor_qbe_cgo_criticita.GetString("DESCRIZ");
        /* mcCritici.CITDIP := qbe_cgo_criticita->DESCCIT */
        mcCritici.row.CITDIP = Cursor_qbe_cgo_criticita.GetString("DESCCIT");
        /* mcCritici.IDBASE := qbe_cgo_criticita->IDBASE */
        mcCritici.row.IDBASE = Cursor_qbe_cgo_criticita.GetString("IDBASE");
        /* mcCritici.SaveRow() */
        mcCritici.SaveRow();
        Cursor_qbe_cgo_criticita.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_criticita.ErrorMessage();
      Cursor_qbe_cgo_criticita.Close();
      // * --- End Select
      /* Return mcCritici */
      throw new Stop(mcCritici);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_criticita!=null)
          Cursor_qbe_cgo_criticita.Close();
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
  public MemoryCursor_tmp_cgo_crtc Run(String p_pTipo) {
    pTipo = p_pTipo;
    return Run();
  }
  public MemoryCursor_tmp_cgo_crtc Run() {
    MemoryCursor_tmp_cgo_crtc l_result;
    l_result = null;
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
        l_result = (MemoryCursor_tmp_cgo_crtc)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_cgo_criticitaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_criticitaR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_criticitaR Make(CPContext p_Ctx) {
    return new arfn_cgo_criticitaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    mcCritici = new MemoryCursor_tmp_cgo_crtc();
    _ggyel = 0;
    _ggred = 0;
    _flagtype = CPLib.Space(1);
    _ndif = 0;
    w_tipo = CPLib.Space(1);
    NoName = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_criticita,
  public static final String m_cVQRList = ",qbe_cgo_criticita,";
  // ENTITY_BATCHES: ,arfn_cgo_criticita,
  public static final String i_InvokedRoutines = ",arfn_cgo_criticita,";
  public static String[] m_cRunParameterNames={"pTipo"};
}
