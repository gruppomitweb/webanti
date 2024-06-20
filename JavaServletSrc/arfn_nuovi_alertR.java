// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_nuovi_alertR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
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
  public MemoryCursor_mcritorno_mcrdef mcRitorno;
  public double _tot;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_nuovi_alertR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_nuovi_alert",m_Caller);
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_nuovi_alert";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      return mcRitorno;
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      mcRitorno = (MemoryCursor_mcritorno_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_cgo_conta_dc=null;
    CPResultSet Cursor_qbe_cgo_conta_no=null;
    CPResultSet Cursor_qbe_cgo_conta_om=null;
    CPResultSet Cursor_qbe_cgo_conta_in=null;
    CPResultSet Cursor_qbe_cgo_conta_mc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcRitorno MemoryCursor(mcRitorno.MCRDef) */
      /* _tot Numeric(15, 0) */
      /* gCodDip Char(6) // Dipendenza */
      /* anpratiche.PRCODAGE=gDealer */
      /* If Utilities.IsInGroup(6) */
      if (Utilities.Make(m_Ctx,m_Caller).IsInGroup(6)) {
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_cgo_conta_dc
        if (Cursor_qbe_cgo_conta_dc!=null)
          Cursor_qbe_cgo_conta_dc.Close();
        Cursor_qbe_cgo_conta_dc = new VQRHolder("qbe_cgo_conta_dc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_conta_dc.Eof())) {
          /* _tot := qbe_cgo_conta_dc->TOTALE */
          _tot = CPLib.Round(Cursor_qbe_cgo_conta_dc.GetDouble("TOTALE"),0);
          Cursor_qbe_cgo_conta_dc.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_conta_dc.ErrorMessage();
        Cursor_qbe_cgo_conta_dc.Close();
        // * --- End Select
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.tipo := 'dc' */
        mcRitorno.row.tipo = "dc";
        /* mcRitorno.numero := _tot */
        mcRitorno.row.numero = _tot;
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_cgo_conta_no
        if (Cursor_qbe_cgo_conta_no!=null)
          Cursor_qbe_cgo_conta_no.Close();
        Cursor_qbe_cgo_conta_no = new VQRHolder("qbe_cgo_conta_no",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_conta_no.Eof())) {
          /* _tot := qbe_cgo_conta_no->TOTALE */
          _tot = CPLib.Round(Cursor_qbe_cgo_conta_no.GetDouble("TOTALE"),0);
          Cursor_qbe_cgo_conta_no.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_conta_no.ErrorMessage();
        Cursor_qbe_cgo_conta_no.Close();
        // * --- End Select
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.tipo := 'no' */
        mcRitorno.row.tipo = "no";
        /* mcRitorno.numero := _tot */
        mcRitorno.row.numero = _tot;
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_cgo_conta_om
        if (Cursor_qbe_cgo_conta_om!=null)
          Cursor_qbe_cgo_conta_om.Close();
        Cursor_qbe_cgo_conta_om = new VQRHolder("qbe_cgo_conta_om",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_conta_om.Eof())) {
          /* _tot := qbe_cgo_conta_om->TOTALE */
          _tot = CPLib.Round(Cursor_qbe_cgo_conta_om.GetDouble("TOTALE"),0);
          Cursor_qbe_cgo_conta_om.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_conta_om.ErrorMessage();
        Cursor_qbe_cgo_conta_om.Close();
        // * --- End Select
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.tipo := 'om' */
        mcRitorno.row.tipo = "om";
        /* mcRitorno.numero := _tot */
        mcRitorno.row.numero = _tot;
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
        // * --- Select from qbe_cgo_conta_in
        if (Cursor_qbe_cgo_conta_in!=null)
          Cursor_qbe_cgo_conta_in.Close();
        Cursor_qbe_cgo_conta_in = new VQRHolder("qbe_cgo_conta_in",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_conta_in.Eof())) {
          /* _tot := qbe_cgo_conta_in->TOTALE */
          _tot = CPLib.Round(Cursor_qbe_cgo_conta_in.GetDouble("TOTALE"),0);
          Cursor_qbe_cgo_conta_in.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_conta_in.ErrorMessage();
        Cursor_qbe_cgo_conta_in.Close();
        // * --- End Select
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.tipo := 'in' */
        mcRitorno.row.tipo = "in";
        /* mcRitorno.numero := _tot */
        mcRitorno.row.numero = _tot;
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_cgo_conta_mc
        if (Cursor_qbe_cgo_conta_mc!=null)
          Cursor_qbe_cgo_conta_mc.Close();
        Cursor_qbe_cgo_conta_mc = new VQRHolder("qbe_cgo_conta_mc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_conta_mc.Eof())) {
          /* _tot := qbe_cgo_conta_mc->TOTALE */
          _tot = CPLib.Round(Cursor_qbe_cgo_conta_mc.GetDouble("TOTALE"),0);
          Cursor_qbe_cgo_conta_mc.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_conta_mc.ErrorMessage();
        Cursor_qbe_cgo_conta_mc.Close();
        // * --- End Select
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.tipo := 'mc' */
        mcRitorno.row.tipo = "mc";
        /* mcRitorno.numero := _tot */
        mcRitorno.row.numero = _tot;
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
      } // End If
      /* Return mcRitorno */
      throw new Stop(mcRitorno);
    } finally {
      try {
        if (Cursor_qbe_cgo_conta_dc!=null)
          Cursor_qbe_cgo_conta_dc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_conta_no!=null)
          Cursor_qbe_cgo_conta_no.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_conta_om!=null)
          Cursor_qbe_cgo_conta_om.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_conta_in!=null)
          Cursor_qbe_cgo_conta_in.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_conta_mc!=null)
          Cursor_qbe_cgo_conta_mc.Close();
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
  public MemoryCursor_mcritorno_mcrdef Run() {
    MemoryCursor_mcritorno_mcrdef l_result;
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
        l_result = (MemoryCursor_mcritorno_mcrdef)stop_value.GetObject();
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
  public static arfn_nuovi_alertR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_nuovi_alertR(p_Ctx, p_Caller);
  }
  public static arfn_nuovi_alertR Make(CPContext p_Ctx) {
    return new arfn_nuovi_alertR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcRitorno = new MemoryCursor_mcritorno_mcrdef();
    _tot = 0;
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_conta_dc,qbe_cgo_conta_no,qbe_cgo_conta_om,qbe_cgo_conta_in,qbe_cgo_conta_mc,
  public static final String m_cVQRList = ",qbe_cgo_conta_dc,qbe_cgo_conta_no,qbe_cgo_conta_om,qbe_cgo_conta_in,qbe_cgo_conta_mc,";
  // ENTITY_BATCHES: ,arfn_nuovi_alert,
  public static final String i_InvokedRoutines = ",arfn_nuovi_alert,";
  public static String[] m_cRunParameterNames={};
}
