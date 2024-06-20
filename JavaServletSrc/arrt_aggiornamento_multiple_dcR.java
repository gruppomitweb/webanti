// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_aggiornamento_multiple_dcR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_dl_multi_dt;
  public String m_cServer_cgo_operazioni_dl_multi_dt;
  public String m_cPhName_cgo_operazioni_dl_multi_dt_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dt_dc;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
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
  public ardt_cgo_oper_multiBL pObj;
  public String azione;
  public String CAIDBIGLIETTO;
  public double row;
  public boolean find;
  public double conta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_aggiornamento_multiple_dcR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_aggiornamento_multiple_dc",m_Caller);
    m_cPhName_cgo_operazioni_dl_multi_dt = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt");
    if (m_cPhName_cgo_operazioni_dl_multi_dt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt = m_cPhName_cgo_operazioni_dl_multi_dt+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt");
    }
    m_cServer_cgo_operazioni_dl_multi_dt = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt");
    m_cPhName_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt_dc");
    if (m_cPhName_cgo_operazioni_dl_multi_dt_dc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt_dc = m_cPhName_cgo_operazioni_dl_multi_dt_dc+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt_dc");
    }
    m_cServer_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt_dc");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("row",p_cVarName)) {
      return row;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_aggiornamento_multiple_dc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("azione",p_cVarName)) {
      return azione;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      return CAIDBIGLIETTO;
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
    if (CPLib.eqr("find",p_cVarName)) {
      return find;
    }
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
    if (CPLib.eqr("row",p_cVarName)) {
      row = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("azione",p_cVarName)) {
      azione = value;
      return;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      CAIDBIGLIETTO = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("find",p_cVarName)) {
      find = value;
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
    /* pObj Object(ardt_cgo_oper_multiBL) // oggetto del dt */
    /* azione Char(1) // azione da intraprendere */
    /* CAIDBIGLIETTO Char(30) // biglietto della riga */
    /* row Numeric(4, 0) // row */
    /* find Bool // trovato */
    /* conta Numeric(4, 0) // contatore di record */
    /* Case azione='I' */
    if (CPLib.eqr(azione,"I")) {
      /* Exec "Inserimento/Aggiornamento elementi in griglia da MULTIPLA" Page 2: */
      Page_2();
      /* pObj.Set_snainumope_sel('') // oggetto del dt */
      pObj.Set_snainumope_sel("");
      /* Case azione='J' */
    } else if (CPLib.eqr(azione,"J")) {
      /* Exec "Inserimento/Aggiornamento elementi in griglia da SINGOLA" Page 3: */
      Page_3();
      /* pObj.Set_s_snainumope_sel('') // oggetto del dt */
      pObj.Set_s_snainumope_sel("");
    } // End Case
    /* pObj.Calculate() // oggetto del dt */
    pObj.Calculate();
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt_dc=null;
    try {
      /* fnd_flg Bool */
      boolean fnd_flg;
      fnd_flg = false;
      // * --- Select from cgo_operazioni_dl_multi_dt_dc
      m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
      if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
        Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      Cursor_cgo_operazioni_dl_multi_dt_dc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_snainumope_sel,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_snainumope_sel)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt_dc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_dl_multi_dt_dc.Eof())) {
        /* conta := 0 // contatore di record */
        conta = CPLib.Round(0,0);
        /* pObj.SetRow(conta) */
        pObj.SetRow(conta);
        /* fnd_flg := False */
        fnd_flg = false;
        /* While conta<pObj.Rows() */
        while (CPLib.lt(conta,pObj.Rows())) {
          /* row := pObj.CurrentRow() // row */
          row = CPLib.Round(pObj.CurrentRow(),0);
          /* If Upper(LRTrim(pObj.w_CAIDBIGLIETTO))=Upper(LRTrim(cgo_operazioni_dl_multi_dt_dc->CAIDBIGLIETTO)) */
          if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(pObj.w_CAIDBIGLIETTO)),CPLib.Upper(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CAIDBIGLIETTO"))))) {
            /* pObj.Set_TIPOGIOCO(cgo_operazioni_dl_multi_dt_dc->TIPOGIOCO) */
            pObj.Set_TIPOGIOCO(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("TIPOGIOCO"));
            /* pObj.Set_TOTLIRE(cgo_operazioni_dl_multi_dt_dc->TOTLIRE) */
            pObj.Set_TOTLIRE(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("TOTLIRE"));
            /* pObj.Set_NUMOPEDL(cgo_operazioni_dl_multi_dt_dc->SNAINUMOPE) */
            pObj.Set_NUMOPEDL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("SNAINUMOPE"));
            /* pObj.Set_ROWNUMDL(cgo_operazioni_dl_multi_dt_dc->CPROWNUM) */
            pObj.Set_ROWNUMDL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CPROWNUM"));
            /* pObj.w_CACODICE := cgo_operazioni_dl_multi_dt_dc->CACODICE */
            pObj.w_CACODICE = Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CACODICE");
            /* pObj.Set_FLGFULL('S') */
            pObj.Set_FLGFULL("S");
            /* pObj.Calculate() */
            pObj.Calculate();
            /* pObj.SaveRow() */
            pObj.SaveRow();
            /* fnd_flg := True */
            fnd_flg = true;
          } // End If
          /* conta := conta+1 // contatore di record */
          conta = CPLib.Round(conta+1,0);
          /* pObj.SetRow(conta) */
          pObj.SetRow(conta);
        } // End While
        /* If not(fnd_flg) */
        if ( ! (fnd_flg)) {
          /* pObj.AddRow() */
          pObj.AddRow();
          /* pObj.Set_DATOPE(cgo_operazioni_dl_multi_dt_dc->DATOPE) */
          pObj.Set_DATOPE(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDate("DATOPE"));
          /* pObj.Set_TIPOGIOCO(cgo_operazioni_dl_multi_dt_dc->TIPOGIOCO) */
          pObj.Set_TIPOGIOCO(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("TIPOGIOCO"));
          /* pObj.Set_CAIDBIGLIETTO(Upper(LRTrim(cgo_operazioni_dl_multi_dt_dc->CAIDBIGLIETTO))) */
          pObj.Set_CAIDBIGLIETTO(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CAIDBIGLIETTO"))));
          /* pObj.Set_TOTLIRE(cgo_operazioni_dl_multi_dt_dc->TOTLIRE) */
          pObj.Set_TOTLIRE(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("TOTLIRE"));
          /* pObj.Set_FLGFULL('S') */
          pObj.Set_FLGFULL("S");
          /* pObj.Set_NUMOPEDL(cgo_operazioni_dl_multi_dt_dc->SNAINUMOPE) */
          pObj.Set_NUMOPEDL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("SNAINUMOPE"));
          /* pObj.Set_ROWNUMDL(cgo_operazioni_dl_multi_dt_dc->CPROWNUM) */
          pObj.Set_ROWNUMDL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CPROWNUM"));
          /* pObj.w_CACODICE := cgo_operazioni_dl_multi_dt_dc->CACODICE */
          pObj.w_CACODICE = Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CACODICE");
          /* pObj.w_CODLOB := cgo_operazioni_dl_multi_dt_dc->CODLOB */
          pObj.w_CODLOB = Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CODLOB");
          /* pObj.w_CATIPGIO := cgo_operazioni_dl_multi_dt_dc->CATIPGIO */
          pObj.w_CATIPGIO = Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CATIPGIO");
          /* pObj.w_CATIPCON := cgo_operazioni_dl_multi_dt_dc->CATIPCON */
          pObj.w_CATIPCON = Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CATIPCON");
          /* pObj.Calculate() */
          pObj.Calculate();
          /* pObj.SaveRow() */
          pObj.SaveRow();
        } // End If
        Cursor_cgo_operazioni_dl_multi_dt_dc.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt_dc.ErrorMessage();
      Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
          Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_cgo_operazioni=null;
    try {
      /* fnd_flg Bool */
      boolean fnd_flg;
      fnd_flg = false;
      // * --- Select from cgo_operazioni
      m_cServer = m_Ctx.GetServer("cgo_operazioni");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
      if (Cursor_cgo_operazioni!=null)
        Cursor_cgo_operazioni.Close();
      Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_s_snainumope_sel,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_s_snainumope_sel)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni.Eof())) {
        /* conta := 0 // contatore di record */
        conta = CPLib.Round(0,0);
        /* pObj.SetRow(conta) */
        pObj.SetRow(conta);
        /* fnd_flg := False */
        fnd_flg = false;
        /* While conta<pObj.Rows() */
        while (CPLib.lt(conta,pObj.Rows())) {
          /* row := pObj.CurrentRow() // row */
          row = CPLib.Round(pObj.CurrentRow(),0);
          /* If Upper(LRTrim(pObj.w_CAIDBIGLIETTO))=Upper(LRTrim(cgo_operazioni->CAIDBIGLIETTO)) */
          if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(pObj.w_CAIDBIGLIETTO)),CPLib.Upper(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("CAIDBIGLIETTO"))))) {
            /* pObj.Set_DATOPE(cgo_operazioni->DATAOPE) */
            pObj.Set_DATOPE(Cursor_cgo_operazioni.GetDate("DATAOPE"));
            /* pObj.Set_TIPOGIOCO(cgo_operazioni->TIPOGIOCO) */
            pObj.Set_TIPOGIOCO(Cursor_cgo_operazioni.GetString("TIPOGIOCO"));
            /* pObj.Set_TOTLIRE(cgo_operazioni->TOTLIRE) */
            pObj.Set_TOTLIRE(Cursor_cgo_operazioni.GetDouble("TOTLIRE"));
            /* pObj.Set_NUMOPEDL(cgo_operazioni->SNAINUMOPE) */
            pObj.Set_NUMOPEDL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"));
            /* pObj.w_CACODICE := cgo_operazioni->CACODICE */
            pObj.w_CACODICE = Cursor_cgo_operazioni.GetDouble("CACODICE");
            /* pObj.Set_FLGFULL('S') */
            pObj.Set_FLGFULL("S");
            /* pObj.Calculate() */
            pObj.Calculate();
            /* pObj.SaveRow() */
            pObj.SaveRow();
            /* fnd_flg := True */
            fnd_flg = true;
          } // End If
          /* conta := conta+1 // contatore di record */
          conta = CPLib.Round(conta+1,0);
          /* pObj.SetRow(conta) */
          pObj.SetRow(conta);
        } // End While
        /* If not(fnd_flg) */
        if ( ! (fnd_flg)) {
          /* pObj.AddRow() */
          pObj.AddRow();
          /* pObj.Set_DATOPE(cgo_operazioni->DATAOPE) */
          pObj.Set_DATOPE(Cursor_cgo_operazioni.GetDate("DATAOPE"));
          /* pObj.Set_TIPOGIOCO(cgo_operazioni->TIPOGIOCO) */
          pObj.Set_TIPOGIOCO(Cursor_cgo_operazioni.GetString("TIPOGIOCO"));
          /* pObj.Set_CAIDBIGLIETTO(Upper(LRTrim(cgo_operazioni->CAIDBIGLIETTO))) */
          pObj.Set_CAIDBIGLIETTO(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("CAIDBIGLIETTO"))));
          /* pObj.Set_TOTLIRE(cgo_operazioni->TOTLIRE) */
          pObj.Set_TOTLIRE(Cursor_cgo_operazioni.GetDouble("TOTLIRE"));
          /* pObj.Set_FLGFULL('S') */
          pObj.Set_FLGFULL("S");
          /* pObj.Set_NUMOPEDL(cgo_operazioni->SNAINUMOPE) */
          pObj.Set_NUMOPEDL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"));
          /* pObj.w_CACODICE := cgo_operazioni->CACODICE */
          pObj.w_CACODICE = Cursor_cgo_operazioni.GetDouble("CACODICE");
          /* pObj.w_CODLOB := cgo_operazioni->CODLOB */
          pObj.w_CODLOB = Cursor_cgo_operazioni.GetString("CODLOB");
          /* pObj.Calculate() */
          pObj.Calculate();
          /* pObj.SaveRow() */
          pObj.SaveRow();
        } // End If
        Cursor_cgo_operazioni.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
      Cursor_cgo_operazioni.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(ardt_cgo_oper_multiBL p_pObj,String p_azione,String p_CAIDBIGLIETTO) {
    pObj = p_pObj;
    azione = p_azione;
    CAIDBIGLIETTO = p_CAIDBIGLIETTO;
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
  public Forward Run(ardt_cgo_oper_multiBL p_pObj,String p_azione,String p_CAIDBIGLIETTO) {
    pObj = p_pObj;
    azione = p_azione;
    CAIDBIGLIETTO = p_CAIDBIGLIETTO;
    return Run();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_aggiornamento_multiple_dcR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_aggiornamento_multiple_dcR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    azione = CPLib.Space(1);
    CAIDBIGLIETTO = CPLib.Space(30);
    row = 0;
    find = false;
    conta = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj","azione","CAIDBIGLIETTO"};
}
