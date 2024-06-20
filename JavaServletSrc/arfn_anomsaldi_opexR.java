// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anomsaldi_opexR implements CallerWithObjs {
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
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
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
  public String pRapporto;
  public String pTipo;
  public String pAnno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_anomsaldi_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anomsaldi_opex",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_anomsaldi_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      pRapporto = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
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
    CPResultSet Cursor_opextrbo=null;
    try {
      /* pRapporto Char(25) // NDG */
      /* pTipo Char(1) // Nuova o Modifica */
      /* pAnno Char(4) // Nuova o Modifica */
      /* cRitorno Memo := '' // Errori Rilevati */
      String cRitorno;
      cRitorno = "";
      /* _nofind Bool := True  // non trovata tra le operazioni */
      boolean _nofind;
      _nofind = true;
      // * --- Select from opextrbo
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      if (Cursor_opextrbo!=null)
        Cursor_opextrbo.Close();
      Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,pAnno)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_opextrbo.Eof())) {
        /* _nofind := False // non trovata tra le operazioni */
        _nofind = false;
        /* If opextrbo->INVIATO=0 or Empty(opextrbo->DATAINVIO) */
        if (CPLib.eqr(Cursor_opextrbo.GetDouble("INVIATO"),0) || CPLib.Empty(Cursor_opextrbo.GetDate("DATAINVIO"))) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' non inviata' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" non inviata"+"\n";
        } // End If
        /* If Empty(opextrbo->VALUTA) */
        if (CPLib.Empty(Cursor_opextrbo.GetString("VALUTA"))) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' valuta non valorizzata' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" valuta non valorizzata"+"\n";
        } // End If
        /* If not(Empty(opextrbo->VALUTA)) and Len(LRTrim(opextrbo->VALUTA)) < 3 */
        if ( ! (CPLib.Empty(Cursor_opextrbo.GetString("VALUTA"))) && CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_opextrbo.GetString("VALUTA"))),3)) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' valuta anomala' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" valuta anomala"+"\n";
        } // End If
        /* If (opextrbo->SALDO > 0 and opextrbo->QUANTITA <= 0) or (opextrbo->SALDO<=0 and opextrbo->QUANTITA>0) */
        if ((CPLib.gt(Cursor_opextrbo.GetDouble("SALDO"),0) && CPLib.le(Cursor_opextrbo.GetDouble("QUANTITA"),0)) || (CPLib.le(Cursor_opextrbo.GetDouble("SALDO"),0) && CPLib.gt(Cursor_opextrbo.GetDouble("QUANTITA"),0))) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' incongruenza tra saldo e quantita' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" incongruenza tra saldo e quantita"+"\n";
        } // End If
        /* If opextrbo->SALDO <= 0 */
        if (CPLib.le(Cursor_opextrbo.GetDouble("SALDO"),0)) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' importo saldo assente' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" importo saldo assente"+"\n";
        } // End If
        /* If opextrbo->QUANTITA <= 0 */
        if (CPLib.le(Cursor_opextrbo.GetDouble("QUANTITA"),0)) {
          /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' valore quantità assente' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" valore quantità assente"+"\n";
        } // End If
        Cursor_opextrbo.Next();
      }
      m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
      Cursor_opextrbo.Close();
      // * --- End Select
      /* If _nofind */
      if (_nofind) {
        /* cRitorno := cRitorno + 'Operazione Extraconto '+LRTrim(pRapporto)+"-"+pAnno+' non individuata' + NL // Errori Rilevati */
        cRitorno = cRitorno+"Operazione Extraconto "+CPLib.LRTrim(pRapporto)+"-"+pAnno+" non individuata"+"\n";
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
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
  public String RunAsync(String p_pRapporto,String p_pTipo,String p_pAnno) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pAnno = p_pAnno;
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
  public String Run(String p_pRapporto,String p_pTipo,String p_pAnno) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pAnno = p_pAnno;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
  public static arfn_anomsaldi_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anomsaldi_opexR(p_Ctx, p_Caller);
  }
  public static arfn_anomsaldi_opexR Make(CPContext p_Ctx) {
    return new arfn_anomsaldi_opexR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(25);
    pTipo = CPLib.Space(1);
    pAnno = CPLib.Space(4);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_anomsaldi_opex,
  public static final String i_InvokedRoutines = ",arfn_anomsaldi_opex,";
  public static String[] m_cRunParameterNames={"pRapporto","pTipo","pAnno"};
}
