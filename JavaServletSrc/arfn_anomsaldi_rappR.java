// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anomsaldi_rappR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
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
  public double pAnno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_anomsaldi_rappR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anomsaldi_rapp",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_anomsaldi_rapp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
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
    CPResultSet Cursor_qbe_fam_chkperiodo_saldi_rap=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pRapporto Char(25) */
      /* pTipo Char(1) */
      /* pAnno Numeric(4, 0) */
      /* _nofind Bool := True */
      boolean _nofind;
      _nofind = true;
      /* cRitorno Memo := '' // Errori Rilevati */
      String cRitorno;
      cRitorno = "";
      /* _tiprap Char(1) */
      String _tiprap;
      _tiprap = CPLib.Space(1);
      // * --- Select from qbe_fam_chkperiodo_saldi_rap
      SPBridge.HMCaller _h0000000A;
      _h0000000A = new SPBridge.HMCaller();
      _h0000000A.Set("m_cVQRList",m_cVQRList);
      _h0000000A.Set("pRAPPORTO",pRapporto);
      _h0000000A.Set("pANNO",CPLib.Str(pAnno,4,0));
      if (Cursor_qbe_fam_chkperiodo_saldi_rap!=null)
        Cursor_qbe_fam_chkperiodo_saldi_rap.Close();
      Cursor_qbe_fam_chkperiodo_saldi_rap = new VQRHolder("qbe_fam_chkperiodo_saldi_rap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_fam_chkperiodo_saldi_rap.Eof())) {
        /* _nofind := False */
        _nofind = false;
        /* If qbe_fam_chkperiodo_saldi_rap->INVIATO=0 or Empty(qbe_fam_chkperiodo_saldi_rap->DATAINVIO) */
        if (CPLib.eqr(Cursor_qbe_fam_chkperiodo_saldi_rap.GetDouble("INVIATO"),0) || CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetDate("DATAINVIO"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+' non inviata' + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" non inviata"+"\n";
        } // End If
        /* If Len(LRTrim(qbe_fam_chkperiodo_saldi_rap->TIPOAG)) < 2 */
        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"))),2)) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" tipo Agenzia Entrate mancante" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" tipo Agenzia Entrate mancante"+"\n";
          /* ElseIf Len(LRTrim(qbe_fam_chkperiodo_saldi_rap->TIPOAG)) < 2 */
        } else if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"))),2)) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" tipo Agenzia Entrate anomalo" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" tipo Agenzia Entrate anomalo"+"\n";
        } // End If
        /* If Empty(qbe_fam_chkperiodo_saldi_rap->DESCRI) and qbe_fam_chkperiodo_saldi_rap->TIPOAG='99' */
        if (CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("DESCRI")) && CPLib.eqr(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"),"99")) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Descrizione Mancante" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Descrizione Mancante"+"\n";
        } // End If
        /* If Empty(qbe_fam_chkperiodo_saldi_rap->COINT) */
        if (CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("COINT"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Natura Rapporto Mancante" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Natura Rapporto Mancante"+"\n";
        } // End If
        /* If not(Empty(qbe_fam_chkperiodo_saldi_rap->TIPOAG)) and At(qbe_fam_chkperiodo_saldi_rap->TIPOAG,"|01|02|03|12|13") <> 0 and Empty(qbe_fam_chkperiodo_saldi_rap->CAB) */
        if ( ! (CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"))) && CPLib.ne(CPLib.At(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"),"|01|02|03|12|13"),0) && CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("CAB"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Codice CAB Mancante" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Codice CAB Mancante"+"\n";
        } // End If
        /* If At(qbe_fam_chkperiodo_saldi_rap->TIPOAG,"|01|02|03|04|05|06|07|09|10|14|15|23|24") <> 0 and Empty(qbe_fam_chkperiodo_saldi_rap->VALUTA) */
        if (CPLib.ne(CPLib.At(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|14|15|23|24"),0) && CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("VALUTA"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Codice Valuta Mancante" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Codice Valuta Mancante"+"\n";
        } // End If
        /* If At(qbe_fam_chkperiodo_saldi_rap->TIPOAG,"|01|02|03|04|05|06|07|09|10|12|14|15|23|24") <> 0 and Empty(qbe_fam_chkperiodo_saldi_rap->IDBASE) */
        if (CPLib.ne(CPLib.At(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|12|14|15|23|24"),0) && CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("IDBASE"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Mancano i saldi per l'anno esaminato" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Mancano i saldi per l'anno esaminato"+"\n";
        } // End If
        /* If At(qbe_fam_chkperiodo_saldi_rap->TIPOAG,"|01|02|03|04|05|06|07|09|10|12|14|15|23|24") <> 0 and Empty(qbe_fam_chkperiodo_saldi_rap->ANNO) */
        if (CPLib.ne(CPLib.At(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|12|14|15|23|24"),0) && CPLib.Empty(Cursor_qbe_fam_chkperiodo_saldi_rap.GetString("ANNO"))) {
          /* cRitorno := cRitorno + 'Rapporto '+LRTrim(pRapporto)+" Anomalia dei saldi per l'anno esaminato" + NL // Errori Rilevati */
          cRitorno = cRitorno+"Rapporto "+CPLib.LRTrim(pRapporto)+" Anomalia dei saldi per l'anno esaminato"+"\n";
        } // End If
        Cursor_qbe_fam_chkperiodo_saldi_rap.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_chkperiodo_saldi_rap.ErrorMessage();
      Cursor_qbe_fam_chkperiodo_saldi_rap.Close();
      // * --- End Select
      /* If _nofind */
      if (_nofind) {
        /* cRitorno := cRitorno + 'Saldo Rapporto '+LRTrim(pRapporto)+"  mancante in anagrafe rapporti ADE" // Errori Rilevati */
        cRitorno = cRitorno+"Saldo Rapporto "+CPLib.LRTrim(pRapporto)+"  mancante in anagrafe rapporti ADE";
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_qbe_fam_chkperiodo_saldi_rap!=null)
          Cursor_qbe_fam_chkperiodo_saldi_rap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pRapporto,String p_pTipo,double p_pAnno) {
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
  public String Run(String p_pRapporto,String p_pTipo,double p_pAnno) {
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
  public static arfn_anomsaldi_rappR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anomsaldi_rappR(p_Ctx, p_Caller);
  }
  public static arfn_anomsaldi_rappR Make(CPContext p_Ctx) {
    return new arfn_anomsaldi_rappR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(25);
    pTipo = CPLib.Space(1);
    pAnno = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_chkperiodo_saldi_rap,
  public static final String m_cVQRList = ",qbe_fam_chkperiodo_saldi_rap,";
  // ENTITY_BATCHES: ,arfn_anomsaldi_rapp,
  public static final String i_InvokedRoutines = ",arfn_anomsaldi_rapp,";
  public static String[] m_cRunParameterNames={"pRapporto","pTipo","pAnno"};
}
