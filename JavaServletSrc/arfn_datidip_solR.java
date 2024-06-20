// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_datidip_solR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
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
  public String pCodDip;
  public String pCodCab;
  public String pDesCit;
  public String pProv;
  public String cRitorno;
  public String _numsto;
  public String _ramate;
  public String w_codcab;
  public String w_desccit;
  public String w_provin;
  public String w_coddipe;
  public String w_cabcod;
  public String w_citdesc;
  public String w_provind;
  public String w_agente;
  public String _tipoag;
  public String gIntemediario;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_datidip_solR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_datidip_sol",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
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
      return "arfn_datidip_sol";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("pCodCab",p_cVarName)) {
      return pCodCab;
    }
    if (CPLib.eqr("pDesCit",p_cVarName)) {
      return pDesCit;
    }
    if (CPLib.eqr("pProv",p_cVarName)) {
      return pProv;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return w_codcab;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return w_desccit;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      return w_provin;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      return w_coddipe;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      return w_cabcod;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      return w_citdesc;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      return w_provind;
    }
    if (CPLib.eqr("agente",p_cVarName)) {
      return w_agente;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("pCodCab",p_cVarName)) {
      pCodCab = value;
      return;
    }
    if (CPLib.eqr("pDesCit",p_cVarName)) {
      pDesCit = value;
      return;
    }
    if (CPLib.eqr("pProv",p_cVarName)) {
      pProv = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      w_codcab = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      w_desccit = value;
      return;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      w_provin = value;
      return;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      w_coddipe = value;
      return;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      w_cabcod = value;
      return;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      w_citdesc = value;
      return;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      w_provind = value;
      return;
    }
    if (CPLib.eqr("agente",p_cVarName)) {
      w_agente = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    try {
      /* pCodDip Char(6) // Codice Soggetto */
      /* pCodCab Char(6) // Data Operazione */
      /* pDesCit Char(30) // Codice Rapporto */
      /* pProv Char(2) // Tipo Rapporto */
      /* cRitorno Char(44) // Stringa di ritorno */
      /* _numsto Char(15) */
      /* _ramate Char(3) */
      /* w_codcab Char(6) */
      /* w_desccit Char(30) */
      /* w_provin Char(2) */
      /* w_coddipe Char(6) */
      /* w_cabcod Char(6) */
      /* w_citdesc Char(30) */
      /* w_provind Char(2) */
      /* w_agente Char(1) */
      /* cRitorno Char(44) */
      /* _tipoag Char(10) */
      /* gIntemediario Char(11) // Intermediario */
      /* Verifica il tipo riga */
      /* cRitorno := '' // Stringa di ritorno */
      cRitorno = "";
      /* If Empty(pCodDip) */
      if (CPLib.Empty(pCodDip)) {
        // * --- Read from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        m_cSql = "";
        m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"C",11,0,m_cServer),m_cServer,gIntemediario);
        if (m_Ctx.IsSharedTemp("intermbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          w_codcab = Read_Cursor.GetString("CODCAB");
          w_desccit = Read_Cursor.GetString("DESCCIT");
          w_provin = Read_Cursor.GetString("PROVINCIA");
          w_coddipe = Read_Cursor.GetString("CODDIPE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on intermbo into routine arfn_datidip_sol returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          w_codcab = "";
          w_desccit = "";
          w_provin = "";
          w_coddipe = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(w_coddipe) */
        if (CPLib.Empty(w_coddipe)) {
          /* cRitorno := cRitorno + "000000" + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
          cRitorno = cRitorno+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          /* _tipoag := Space(10) */
          _tipoag = CPLib.Space(10);
        } else { // Else
          /* cRitorno := cRitorno + Left(LRTrim(w_coddipe)+Space(6),6) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(w_coddipe)+CPLib.Space(6),6);
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_cabcod = Read_Cursor.GetString("CAB");
            w_citdesc = Read_Cursor.GetString("DESCCIT");
            w_provind = Read_Cursor.GetString("PROVINCIA");
            w_agente = Read_Cursor.GetString("AGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arfn_datidip_sol returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_cabcod = "";
            w_citdesc = "";
            w_provind = "";
            w_agente = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_cabcod) */
          if (CPLib.Empty(w_cabcod)) {
            /* cRitorno := cRitorno + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
          } // End If
          /* _tipoag := iif((w_agente='S' or w_agente='1'),'AGENZIA   ',Space(10)) */
          _tipoag = ((CPLib.eqr(w_agente,"S") || CPLib.eqr(w_agente,"1"))?"AGENZIA   ":CPLib.Space(10));
        } // End If
      } else { // Else
        // * --- Select from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
        Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodDip,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodDip)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anadip.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(pCodDip)+Space(6),6) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCodDip)+CPLib.Space(6),6);
          /* cRitorno := cRitorno + iif(Empty(LRTrim(pCodCab)),Left(LRTrim(anadip->CAB)+Space(6),6),Left(LRTrim(pCodCab)+Space(6),6)) */
          cRitorno = cRitorno+(CPLib.Empty(CPLib.LRTrim(pCodCab))?CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(pCodCab)+CPLib.Space(6),6));
          /* cRitorno := cRitorno + iif(Empty(LRTrim(pDesCit)),Left(LRTrim(anadip->DESCCIT)+Space(30),30),Left(LRTrim(pDesCit)+Space(30),30)) */
          cRitorno = cRitorno+(CPLib.Empty(CPLib.LRTrim(pDesCit))?CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(pDesCit)+CPLib.Space(30),30));
          /* cRitorno := cRitorno + iif(Empty(LRTrim(pProv)),Left(LRTrim(anadip->PROVINCIA)+Space(2),2),Left(LRTrim(pProv)+Space(2),2)) */
          cRitorno = cRitorno+(CPLib.Empty(CPLib.LRTrim(pProv))?CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(pProv)+CPLib.Space(2),2));
          /* _tipoag := iif((anadip->AGENTE='S' or anadip->AGENTE='1'),'AGENZIA   ',Space(10)) */
          _tipoag = ((CPLib.eqr(Cursor_anadip.GetString("AGENTE"),"S") || CPLib.eqr(Cursor_anadip.GetString("AGENTE"),"1"))?"AGENZIA   ":CPLib.Space(10));
          Cursor_anadip.Next();
        }
        m_cConnectivityError = Cursor_anadip.ErrorMessage();
        Cursor_anadip.Close();
        // * --- End Select
      } // End If
      /* Return cRitorno+_tipoag */
      throw new Stop(cRitorno+_tipoag);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCodDip,String p_pCodCab,String p_pDesCit,String p_pProv) {
    pCodDip = p_pCodDip;
    pCodCab = p_pCodCab;
    pDesCit = p_pDesCit;
    pProv = p_pProv;
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
  public String Run(String p_pCodDip,String p_pCodCab,String p_pDesCit,String p_pProv) {
    pCodDip = p_pCodDip;
    pCodCab = p_pCodCab;
    pDesCit = p_pDesCit;
    pProv = p_pProv;
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
  public static arfn_datidip_solR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_datidip_solR(p_Ctx, p_Caller);
  }
  public static arfn_datidip_solR Make(CPContext p_Ctx) {
    return new arfn_datidip_solR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCodDip = CPLib.Space(6);
    pCodCab = CPLib.Space(6);
    pDesCit = CPLib.Space(30);
    pProv = CPLib.Space(2);
    cRitorno = CPLib.Space(44);
    _numsto = CPLib.Space(15);
    _ramate = CPLib.Space(3);
    w_codcab = CPLib.Space(6);
    w_desccit = CPLib.Space(30);
    w_provin = CPLib.Space(2);
    w_coddipe = CPLib.Space(6);
    w_cabcod = CPLib.Space(6);
    w_citdesc = CPLib.Space(30);
    w_provind = CPLib.Space(2);
    w_agente = CPLib.Space(1);
    _tipoag = CPLib.Space(10);
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_datidip_sol,
  public static final String i_InvokedRoutines = ",arfn_datidip_sol,";
  public static String[] m_cRunParameterNames={"pCodDip","pCodCab","pDesCit","pProv"};
}
