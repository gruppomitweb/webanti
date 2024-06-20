// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_ctiticitaR implements CallerWithObjs {
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
  public String w_ctipo;
  public double _ggyel;
  public double _ggred;
  public String _flagtype;
  public double _ndif;
  public String w_tipo;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_ctiticitaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_ctiticita",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_crtc")) {
      m_cPhName_tmp_cgo_crtc = p_ContextObject.GetPhName("tmp_cgo_crtc");
      if (m_cPhName_tmp_cgo_crtc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_cgo_crtc = m_cPhName_tmp_cgo_crtc+" "+m_Ctx.GetWritePhName("tmp_cgo_crtc");
      }
      m_cServer_tmp_cgo_crtc = p_ContextObject.GetServer("tmp_cgo_crtc");
    }
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
      return "arrt_cgo_ctiticita";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("ctipo",p_cVarName)) {
      return w_ctipo;
    }
    if (CPLib.eqr("_flagtype",p_cVarName)) {
      return _flagtype;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
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
    if (CPLib.eqr("ctipo",p_cVarName)) {
      w_ctipo = value;
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
    CPResultSet Cursor_qbe_cgo_criticita=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_ctipo Char(1) */
      /* _ggyel Numeric(3, 0) */
      /* _ggred Numeric(3, 0) */
      /* _flagtype Char(1) */
      /* _ndif Numeric(4, 0) */
      /* w_tipo Char(1) */
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
      /* Seleziona igli agenti con criticità sulle registrazioni */
      /* w_tipo := iif(w_ctipo='T' or Empty(LRTrim(w_ctipo)),'',w_ctipo) */
      w_tipo = (CPLib.eqr(w_ctipo,"T") || CPLib.Empty(CPLib.LRTrim(w_ctipo))?"":w_ctipo);
      // * --- Drop temporary table tmp_cgo_crtc
      if (m_Ctx.IsSharedTemp("tmp_cgo_crtc")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_crtc")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_crtc");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_crtc");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_crtc");
      }
      // * --- Create temporary table tmp_cgo_crtc
      if (m_Ctx.IsSharedTemp("tmp_cgo_crtc")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_crtc")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_crtc");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_crtc");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_crtc");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_cgo_crtc");
      if ( ! (m_Ctx.IsSharedTemp("tmp_cgo_crtc"))) {
        m_cServer = m_Ctx.GetServer("tmp_cgo_crtc");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_cgo_crtc",m_cServer,"proto")),m_cPhName,"tmp_cgo_crtc",m_Ctx);
      }
      m_cPhName_tmp_cgo_crtc = m_cPhName;
      // * --- Select from qbe_cgo_criticita
      if (Cursor_qbe_cgo_criticita!=null)
        Cursor_qbe_cgo_criticita.Close();
      Cursor_qbe_cgo_criticita = new VQRHolder("qbe_cgo_criticita",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_criticita.Eof())) {
        /* _ndif := DateDiff(qbe_cgo_criticita->DATAOPE,Date())  */
        _ndif = CPLib.Round(CPLib.DateDiff(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"),CPLib.Date()),0);
        /* Case _ndif >= _ggred */
        if (CPLib.ge(_ndif,_ggred)) {
          /* _flagtype := 'R' */
          _flagtype = "R";
          // * --- Insert into tmp_cgo_crtc from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_cgo_crtc");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_crtc");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_cgo_crtc",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_ctiticita",16,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_cgo_criticita.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flagtype,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndif,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_cgo_crtc",true);
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
          /* Case _ndif >= _ggyel and _ndif < _ggred */
        } else if (CPLib.ge(_ndif,_ggyel) && CPLib.lt(_ndif,_ggred)) {
          /* _flagtype := 'Y' */
          _flagtype = "Y";
          // * --- Insert into tmp_cgo_crtc from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_cgo_crtc");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_crtc");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_cgo_crtc",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_ctiticita",16,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_cgo_criticita.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flagtype,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndif,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_cgo_crtc",true);
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
        } // End Case
        Cursor_qbe_cgo_criticita.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_criticita.ErrorMessage();
      Cursor_qbe_cgo_criticita.Close();
      // * --- End Select
      /* Stop arpg_cgo_criticita */
      Forward f;
      f=new Forward("arpg_cgo_criticita",false,this,Forward.Start,false);
      f.SetParameter("m_bQuery",true);
      f.SetParameter("m_cParameterSequence","m_bQuery");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
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
      m_Caller.SetString("ctipo","C",1,0,w_ctipo);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_ctiticitaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_ctiticitaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_ctipo = m_Caller.GetString("ctipo","C",1,0);
    _ggyel = 0;
    _ggred = 0;
    _flagtype = CPLib.Space(1);
    _ndif = 0;
    w_tipo = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_criticita,
  public static final String m_cVQRList = ",qbe_cgo_criticita,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"FLGCRTC,";
    p_cSql = p_cSql+"NUMDAYS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_cgo_crtc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"FLGCRTC,";
    p_cSql = p_cSql+"NUMDAYS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_cgo_crtc",true);
    return p_cSql;
  }
}
