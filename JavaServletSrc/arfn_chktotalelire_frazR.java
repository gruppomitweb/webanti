// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chktotalelire_frazR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public boolean bRitorno;
  public double _limite;
  public java.sql.Date _datlimite;
  public String _msgerr;
  public String gTipInter;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chktotalelire_frazR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chktotalelire_fraz",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pImporto",p_cVarName)) {
      return pImporto;
    }
    if (CPLib.eqr("_limite",p_cVarName)) {
      return _limite;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chktotalelire_fraz";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      return _msgerr;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
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
    if (CPLib.eqr("_datlimite",p_cVarName)) {
      return _datlimite;
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
    if (CPLib.eqr("_limite",p_cVarName)) {
      _limite = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      _msgerr = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
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
    if (CPLib.eqr("_datlimite",p_cVarName)) {
      _datlimite = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* Parametri */
      /* pDatOpe Date */
      /* pDatEuro Date */
      /* pImporto Numeric(15, 0) */
      /* bRitorno Bool */
      /* _limite Numeric(12, 2) */
      /* _datlimite Date */
      /* _msgerr Char(60) */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* Controllo */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IMPINTOPE,LIMITE20  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _limite := intermbo->IMPINTOPE */
        _limite = CPLib.Round(Cursor_intermbo.GetDouble("IMPINTOPE"),2);
        /* _datlimite := iif(Empty(intermbo->LIMITE20),CharToDate('20201231'),intermbo->LIMITE20) */
        _datlimite = (CPLib.Empty(Cursor_intermbo.GetDate("LIMITE20"))?CPLib.CharToDate("20201231"):Cursor_intermbo.GetDate("LIMITE20"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* bRitorno := True */
      bRitorno = true;
      /* If pDatEuro <= pDatOpe or pDatOpe >= CharToDate("20020101") */
      if (CPLib.le(pDatEuro,pDatOpe) || CPLib.ge(pDatOpe,CPLib.CharToDate("20020101"))) {
        /* If _limite <> 0  and pDatOpe < _datlimite */
        if (CPLib.ne(_limite,0) && CPLib.lt(pDatOpe,_datlimite)) {
          /* If pImporto > _limite */
          if (CPLib.gt(pImporto,_limite)) {
            /* _msgerr := "Valore superiore ai massimi richiesti ("+LRTrim(Format(Str(_limite,12,2),"999.999.999,99")) +")" */
            _msgerr = "Valore superiore ai massimi richiesti ("+CPLib.LRTrim(CPLib.Format(m_Ctx,CPLib.Str(_limite,12,2),"999.999.999,99"))+")";
            /* bRitorno := False */
            bRitorno = false;
          } // End If
        } else { // Else
          /* Case pDatOpe <= CharToDate("20021227")  */
          if (CPLib.le(pDatOpe,CPLib.CharToDate("20021227"))) {
            /* If pImporto > 10329.14 */
            if (CPLib.gt(pImporto,10329.14)) {
              /* _msgerr := "Valore superiore ai massimi richiesti (10.329,14)" */
              _msgerr = "Valore superiore ai massimi richiesti (10.329,14)";
              /* bRitorno := False */
              bRitorno = false;
            } // End If
            /* Case pDatOpe > CharToDate("20021227") and pDatOpe < CharToDate('20080101') */
          } else if (CPLib.gt(pDatOpe,CPLib.CharToDate("20021227")) && CPLib.lt(pDatOpe,CPLib.CharToDate("20080101"))) {
            /* If pImporto > 12500 */
            if (CPLib.gt(pImporto,12500)) {
              /* _msgerr := "Valore superiore ai massimi richiesti (12.500,00)" */
              _msgerr = "Valore superiore ai massimi richiesti (12.500,00)";
              /* bRitorno := False */
              bRitorno = false;
            } // End If
            /* Case pDatOpe >= CharToDate('20080101') and pDatOpe <= _datlimite */
          } else if (CPLib.ge(pDatOpe,CPLib.CharToDate("20080101")) && CPLib.le(pDatOpe,_datlimite)) {
            /* If pImporto > 15000 */
            if (CPLib.gt(pImporto,15000)) {
              /* _msgerr := "Valore superiore ai massimi richiesti (15.000,00)" */
              _msgerr = "Valore superiore ai massimi richiesti (15.000,00)";
              /* bRitorno := False */
              bRitorno = false;
            } // End If
            /* Case pDatOpe > _datlimite and LibreriaMit.inter_art1(gTipInter) */
          } else if (CPLib.gt(pDatOpe,_datlimite) && LibreriaMit.inter_art1(gTipInter)) {
            /* If pImporto > 5000 */
            if (CPLib.gt(pImporto,5000)) {
              /* _msgerr := "Valore superiore ai massimi richiesti (5.000,00)" */
              _msgerr = "Valore superiore ai massimi richiesti (5.000,00)";
              /* bRitorno := False */
              bRitorno = false;
            } // End If
          } // End Case
        } // End If
      } else { // Else
        /* If pImporto > 20000000 */
        if (CPLib.gt(pImporto,20000000)) {
          /* _msgerr := "Valore superiore ai massimi richiesti (20.000.000)" */
          _msgerr = "Valore superiore ai massimi richiesti (20.000.000)";
          /* bRitorno := False */
          bRitorno = false;
        } // End If
      } // End If
      /* Error Msg _msgerr */
      m_cLastMsgError = _msgerr;
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatOpe,java.sql.Date p_pDatEuro,double p_pImporto) {
    pDatOpe = p_pDatOpe;
    pDatEuro = p_pDatEuro;
    pImporto = p_pImporto;
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
  public boolean Run(java.sql.Date p_pDatOpe,java.sql.Date p_pDatEuro,double p_pImporto) {
    pDatOpe = p_pDatOpe;
    pDatEuro = p_pDatEuro;
    pImporto = p_pImporto;
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
  public static arfn_chktotalelire_frazR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chktotalelire_frazR(p_Ctx, p_Caller);
  }
  public static arfn_chktotalelire_frazR Make(CPContext p_Ctx) {
    return new arfn_chktotalelire_frazR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatOpe = CPLib.NullDate();
    pDatEuro = CPLib.NullDate();
    pImporto = 0;
    bRitorno = false;
    _limite = 0;
    _datlimite = CPLib.NullDate();
    _msgerr = CPLib.Space(60);
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chktotalelire_fraz,
  public static final String i_InvokedRoutines = ",arfn_chktotalelire_fraz,";
  public static String[] m_cRunParameterNames={"pDatOpe","pDatEuro","pImporto"};
}
