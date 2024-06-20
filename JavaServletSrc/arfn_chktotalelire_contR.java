// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chktotalelire_contR implements CallerWithObjs {
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
  public String m_cPhName_tblimcon;
  public String m_cServer_tblimcon;
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
  public java.sql.Date pDatOpe;
  public java.sql.Date pDatEuro;
  public double pImporto;
  public double pTotale;
  public boolean bRitorno;
  public String cMsg;
  public double _valmin;
  public String gTipInter;
  public String gFlgIPMT;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chktotalelire_contR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chktotalelire_cont",m_Caller);
    m_cPhName_tblimcon = p_ContextObject.GetPhName("tblimcon");
    if (m_cPhName_tblimcon.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tblimcon = m_cPhName_tblimcon+" "+m_Ctx.GetWritePhName("tblimcon");
    }
    m_cServer_tblimcon = p_ContextObject.GetServer("tblimcon");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pImporto",p_cVarName)) {
      return pImporto;
    }
    if (CPLib.eqr("pTotale",p_cVarName)) {
      return pTotale;
    }
    if (CPLib.eqr("_valmin",p_cVarName)) {
      return _valmin;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chktotalelire_cont";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("cMsg",p_cVarName)) {
      return cMsg;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      return gFlgIPMT;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pDatEuro",p_cVarName)) {
      return pDatEuro;
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
    if (CPLib.eqr("pImporto",p_cVarName)) {
      pImporto = value;
      return;
    }
    if (CPLib.eqr("pTotale",p_cVarName)) {
      pTotale = value;
      return;
    }
    if (CPLib.eqr("_valmin",p_cVarName)) {
      _valmin = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cMsg",p_cVarName)) {
      cMsg = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      gFlgIPMT = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pDatEuro",p_cVarName)) {
      pDatEuro = value;
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
    CPResultSet Cursor_tblimcon=null;
    try {
      /* Parametri */
      /* pDatOpe Date */
      /* pDatEuro Date */
      /* pImporto Numeric(15, 0) */
      /* pTotale Numeric(15, 0) */
      /* bRitorno Bool */
      /* cMsg Char(60) */
      /* _valmin Numeric(12, 2) */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gFlgIPMT Char(1) // IP MoneyTrasfer */
      /* Controllo */
      /* bRitorno := True */
      bRitorno = true;
      /* If pImporto = 0 */
      if (CPLib.eqr(pImporto,0)) {
        /* cMsg := "L'importo deve essere superiore a 0" */
        cMsg = "L'importo deve essere superiore a 0";
        /* bRitorno := False */
        bRitorno = false;
      } else { // Else
        /* If pImporto > pTotale */
        if (CPLib.gt(pImporto,pTotale)) {
          /* cMsg := "L'importo in contanti non deve essere superiore al totale dell'operazione" */
          cMsg = "L'importo in contanti non deve essere superiore al totale dell'operazione";
          /* bRitorno := False */
          bRitorno = false;
        } else { // Else
          // * --- Select from tblimcon
          m_cServer = m_Ctx.GetServer("tblimcon");
          m_cPhName = m_Ctx.GetPhName("tblimcon");
          if (Cursor_tblimcon!=null)
            Cursor_tblimcon.Close();
          Cursor_tblimcon = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tblimcon")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tblimcon.Eof())) {
            /* If At(gTipInter,tblimcon->LCVALPER) > 0 or Empty(tblimcon->LCVALPER) */
            if (CPLib.gt(CPLib.At(gTipInter,Cursor_tblimcon.GetString("LCVALPER")),0) || CPLib.Empty(Cursor_tblimcon.GetString("LCVALPER"))) {
              /* If pDatOpe >= tblimcon->LCDATINI and pDatOpe <= tblimcon->LCDATFIN */
              if (CPLib.ge(pDatOpe,Cursor_tblimcon.GetDate("LCDATINI")) && CPLib.le(pDatOpe,Cursor_tblimcon.GetDate("LCDATFIN"))) {
                /* If pImporto >= tblimcon->LCIMPMAX */
                if (CPLib.ge(pImporto,Cursor_tblimcon.GetDouble("LCIMPMAX"))) {
                  /* _valmin := tblimcon->LCIMPMAX - 0.01 */
                  _valmin = CPLib.Round(Cursor_tblimcon.GetDouble("LCIMPMAX")-0.01,2);
                  /* cMsg := "Valore superiore ai massimi consentiti (€ "+Format(_valmin,"999,999,999,999.99")+")" */
                  cMsg = "Valore superiore ai massimi consentiti (\u20ac "+CPLib.Format(m_Ctx,_valmin,"999,999,999,999.99")+")";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
              } // End If
            } // End If
            Cursor_tblimcon.Next();
          }
          m_cConnectivityError = Cursor_tblimcon.ErrorMessage();
          Cursor_tblimcon.Close();
          // * --- End Select
        } // End If
      } // End If
      /* Error Msg cMsg */
      m_cLastMsgError = cMsg;
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_tblimcon!=null)
          Cursor_tblimcon.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatOpe,java.sql.Date p_pDatEuro,double p_pImporto,double p_pTotale) {
    pDatOpe = p_pDatOpe;
    pDatEuro = p_pDatEuro;
    pImporto = p_pImporto;
    pTotale = p_pTotale;
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
  public boolean Run(java.sql.Date p_pDatOpe,java.sql.Date p_pDatEuro,double p_pImporto,double p_pTotale) {
    pDatOpe = p_pDatOpe;
    pDatEuro = p_pDatEuro;
    pImporto = p_pImporto;
    pTotale = p_pTotale;
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
  public static arfn_chktotalelire_contR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chktotalelire_contR(p_Ctx, p_Caller);
  }
  public static arfn_chktotalelire_contR Make(CPContext p_Ctx) {
    return new arfn_chktotalelire_contR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatOpe = CPLib.NullDate();
    pDatEuro = CPLib.NullDate();
    pImporto = 0;
    pTotale = 0;
    bRitorno = false;
    cMsg = CPLib.Space(60);
    _valmin = 0;
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gFlgIPMT=m_Ctx.GetGlobalString("gFlgIPMT");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chktotalelire_cont,
  public static final String i_InvokedRoutines = ",arfn_chktotalelire_cont,";
  public static String[] m_cRunParameterNames={"pDatOpe","pDatEuro","pImporto","pTotale"};
}
