// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chkatecoR implements CallerWithObjs {
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
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tbsetsina;
  public String m_cServer_tbsetsina;
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
  public String pSOTGRU;
  public String pATECO;
  public boolean bRitorno;
  public String _NewRamo;
  public String _ateco;
  public double _oksotgru;
  public double _okramatt;
  public double _okateco;
  public String _tipsot;
  public String _settori;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkatecoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chkateco",m_Caller);
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_tbsetsina = p_ContextObject.GetPhName("tbsetsina");
    if (m_cPhName_tbsetsina.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsina = m_cPhName_tbsetsina+" "+m_Ctx.GetWritePhName("tbsetsina");
    }
    m_cServer_tbsetsina = p_ContextObject.GetServer("tbsetsina");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_oksotgru",p_cVarName)) {
      return _oksotgru;
    }
    if (CPLib.eqr("_okramatt",p_cVarName)) {
      return _okramatt;
    }
    if (CPLib.eqr("_okateco",p_cVarName)) {
      return _okateco;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chkateco";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pSOTGRU",p_cVarName)) {
      return pSOTGRU;
    }
    if (CPLib.eqr("pATECO",p_cVarName)) {
      return pATECO;
    }
    if (CPLib.eqr("_NewRamo",p_cVarName)) {
      return _NewRamo;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      return _tipsot;
    }
    if (CPLib.eqr("_settori",p_cVarName)) {
      return _settori;
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
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
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
    if (CPLib.eqr("_oksotgru",p_cVarName)) {
      _oksotgru = value;
      return;
    }
    if (CPLib.eqr("_okramatt",p_cVarName)) {
      _okramatt = value;
      return;
    }
    if (CPLib.eqr("_okateco",p_cVarName)) {
      _okateco = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSOTGRU",p_cVarName)) {
      pSOTGRU = value;
      return;
    }
    if (CPLib.eqr("pATECO",p_cVarName)) {
      pATECO = value;
      return;
    }
    if (CPLib.eqr("_NewRamo",p_cVarName)) {
      _NewRamo = value;
      return;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      _ateco = value;
      return;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      _tipsot = value;
      return;
    }
    if (CPLib.eqr("_settori",p_cVarName)) {
      _settori = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbsetsin=null;
    try {
      /* pSOTGRU Char(3) // SAE */
      /* pATECO Char(10) // Codice ATECO */
      /* bRitorno Bool // Valore Ritorno */
      /* _NewRamo Char(3) */
      /* _ateco Char(3) */
      /* _oksotgru Numeric(1, 0) */
      /* _okramatt Numeric(1, 0) */
      /* _okateco Numeric(1, 0) */
      /* _tipsot Char(1) */
      /* _settori Memo */
      /* _ateco := Left(LRTrim(pATECO),3) */
      _ateco = CPLib.Left(CPLib.LRTrim(pATECO),3);
      /* Controlla i valori del sottogruppo e del ramo */
      /* _tipsot := '' */
      _tipsot = "";
      /* bRitorno := False // Valore Ritorno */
      bRitorno = false;
      /* _settori := '' */
      _settori = "";
      // * --- Read from tbstgru
      m_cServer = m_Ctx.GetServer("tbstgru");
      m_cPhName = m_Ctx.GetPhName("tbstgru");
      m_cSql = "";
      m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSOTGRU,"C",3,0,m_cServer),m_cServer,pSOTGRU);
      if (m_Ctx.IsSharedTemp("tbstgru")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _tipsot = Read_Cursor.GetString("TIPOSOT");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on tbstgru into routine arfn_chkateco returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _tipsot = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Select from tbsetsin
      m_cServer = m_Ctx.GetServer("tbsetsin");
      m_cPhName = m_Ctx.GetPhName("tbsetsin");
      if (Cursor_tbsetsin!=null)
        Cursor_tbsetsin.Close();
      Cursor_tbsetsin = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbsetsin")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbsetsin.Eof())) {
        /* _oksotgru := 0 */
        _oksotgru = CPLib.Round(0,0);
        /* If pSOTGRU >= tbsetsin->DASOT1 and pSOTGRU <= tbsetsin->ASOT1 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT1")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT1"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT2 and pSOTGRU <= tbsetsin->ASOT2 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT2")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT2"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT3 and pSOTGRU <= tbsetsin->ASOT3 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT3")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT3"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT4 and pSOTGRU <= tbsetsin->ASOT4 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT4")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT4"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT5 and pSOTGRU <= tbsetsin->ASOT5 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT5")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT5"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT6 and pSOTGRU <= tbsetsin->ASOT6 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT6")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT6"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT7 and pSOTGRU <= tbsetsin->ASOT7 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT7")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT7"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT8 and pSOTGRU <= tbsetsin->ASOT8 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT8")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT8"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT9 and pSOTGRU <= tbsetsin->ASOT9 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT9")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT9"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT10 and pSOTGRU <= tbsetsin->ASOT10 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT10")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT10"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT11 and pSOTGRU <= tbsetsin->ASOT11 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT11")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT11"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If pSOTGRU >= tbsetsin->DASOT12 and pSOTGRU <= tbsetsin->ASOT12 */
        if (CPLib.ge(pSOTGRU,Cursor_tbsetsin.GetString("DASOT12")) && CPLib.le(pSOTGRU,Cursor_tbsetsin.GetString("ASOT12"))) {
          /* _oksotgru := 1 */
          _oksotgru = CPLib.Round(1,0);
        } // End If
        /* If _oksotgru=1 and _tipsot='1' */
        if (CPLib.eqr(_oksotgru,1) && CPLib.eqr(_tipsot,"1")) {
          /* _settori := _settori + LRTrim(tbsetsin->SETSINT)+"|" */
          _settori = _settori+CPLib.LRTrim(Cursor_tbsetsin.GetString("SETSINT"))+"|";
        } // End If
        Cursor_tbsetsin.Next();
      }
      m_cConnectivityError = Cursor_tbsetsin.ErrorMessage();
      Cursor_tbsetsin.Close();
      // * --- End Select
      /* _settori := Left(LRTrim(_settori),Len(LRTrim(_settori))-1) */
      _settori = CPLib.Left(CPLib.LRTrim(_settori),CPLib.Len(CPLib.LRTrim(_settori))-1);
      // * --- Select from tbsetsin
      m_cServer = m_Ctx.GetServer("tbsetsin");
      m_cPhName = m_Ctx.GetPhName("tbsetsin");
      if (Cursor_tbsetsin!=null)
        Cursor_tbsetsin.Close();
      Cursor_tbsetsin = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbsetsin")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbsetsin.Eof())) {
        /* If At(tbsetsin->SETSINT,_settori)<>0 */
        if (CPLib.ne(CPLib.At(Cursor_tbsetsin.GetString("SETSINT"),_settori),0)) {
          /* If _ateco >= tbsetsin->DAATE1 and _ateco <= tbsetsin->AATE1 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE1")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE1"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _ateco >= tbsetsin->DAATE2 and _ateco <= tbsetsin->AATE2 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE2")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE2"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _ateco >= tbsetsin->DAATE3 and _ateco <= tbsetsin->AATE3 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE3")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE3"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _ateco >= tbsetsin->DAATE4 and _ateco <= tbsetsin->AATE4 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE4")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE4"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _ateco >= tbsetsin->DAATE5 and _ateco <= tbsetsin->AATE5 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE5")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE5"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _ateco >= tbsetsin->DAATE6 and _ateco <= tbsetsin->AATE6 */
          if (CPLib.ge(_ateco,Cursor_tbsetsin.GetString("DAATE6")) && CPLib.le(_ateco,Cursor_tbsetsin.GetString("AATE6"))) {
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
        } // End If
        Cursor_tbsetsin.Next();
      }
      m_cConnectivityError = Cursor_tbsetsin.ErrorMessage();
      Cursor_tbsetsin.Close();
      // * --- End Select
      /* If _okateco=1 */
      if (CPLib.eqr(_okateco,1)) {
        /* bRitorno := True // Valore Ritorno */
        bRitorno = true;
      } // End If
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbsetsin!=null)
          Cursor_tbsetsin.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pSOTGRU,String p_pATECO) {
    pSOTGRU = p_pSOTGRU;
    pATECO = p_pATECO;
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
  public boolean Run(String p_pSOTGRU,String p_pATECO) {
    pSOTGRU = p_pSOTGRU;
    pATECO = p_pATECO;
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
  public static arfn_chkatecoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkatecoR(p_Ctx, p_Caller);
  }
  public static arfn_chkatecoR Make(CPContext p_Ctx) {
    return new arfn_chkatecoR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pSOTGRU = CPLib.Space(3);
    pATECO = CPLib.Space(10);
    bRitorno = false;
    _NewRamo = CPLib.Space(3);
    _ateco = CPLib.Space(3);
    _oksotgru = 0;
    _okramatt = 0;
    _okateco = 0;
    _tipsot = CPLib.Space(1);
    _settori = "";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkateco,
  public static final String i_InvokedRoutines = ",arfn_chkateco,";
  public static String[] m_cRunParameterNames={"pSOTGRU","pATECO"};
}
