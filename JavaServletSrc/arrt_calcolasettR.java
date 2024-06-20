// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calcolasettR implements CallerWithObjs {
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
  public String w_SOTGRUP;
  public String w_RAMOGRUP;
  public String w_SETTSINT;
  public String w_OLDSETSIN;
  public String w_DESCUIC;
  public String w_ATTIV;
  public String w_tipsot;
  public String _NewRamo;
  public String _ateco;
  public double _oksotgru;
  public double _okramatt;
  public double _okateco;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calcolasettR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calcolasett",m_Caller);
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
      return "arrt_calcolasett";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("SOTGRUP",p_cVarName)) {
      return w_SOTGRUP;
    }
    if (CPLib.eqr("RAMOGRUP",p_cVarName)) {
      return w_RAMOGRUP;
    }
    if (CPLib.eqr("SETTSINT",p_cVarName)) {
      return w_SETTSINT;
    }
    if (CPLib.eqr("OLDSETSIN",p_cVarName)) {
      return w_OLDSETSIN;
    }
    if (CPLib.eqr("DESCUIC",p_cVarName)) {
      return w_DESCUIC;
    }
    if (CPLib.eqr("ATTIV",p_cVarName)) {
      return w_ATTIV;
    }
    if (CPLib.eqr("tipsot",p_cVarName)) {
      return w_tipsot;
    }
    if (CPLib.eqr("_NewRamo",p_cVarName)) {
      return _NewRamo;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
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
    if (CPLib.eqr("SOTGRUP",p_cVarName)) {
      w_SOTGRUP = value;
      return;
    }
    if (CPLib.eqr("RAMOGRUP",p_cVarName)) {
      w_RAMOGRUP = value;
      return;
    }
    if (CPLib.eqr("SETTSINT",p_cVarName)) {
      w_SETTSINT = value;
      return;
    }
    if (CPLib.eqr("OLDSETSIN",p_cVarName)) {
      w_OLDSETSIN = value;
      return;
    }
    if (CPLib.eqr("DESCUIC",p_cVarName)) {
      w_DESCUIC = value;
      return;
    }
    if (CPLib.eqr("ATTIV",p_cVarName)) {
      w_ATTIV = value;
      return;
    }
    if (CPLib.eqr("tipsot",p_cVarName)) {
      w_tipsot = value;
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
    CPResultSet Cursor_tbsetsin=null;
    try {
      /* Campi della maschera */
      /* w_SOTGRUP Char(3) // Sottogruppo Att. Ec. */
      /* w_RAMOGRUP Char(3) // Ramo Gruppo Att. Ec. */
      /* w_SETTSINT Char(3) // Settorizzazione UIC */
      /* w_OLDSETSIN Char(3) // Settorizzazione UIC */
      /* w_DESCUIC Char(60) // Descrizione Settorizzazione UIC */
      /* w_ATTIV Char(10) */
      /* w_tipsot Char(1) // Tipo */
      /* Variabili Locali */
      /* _NewRamo Char(3) */
      /* _ateco Char(3) */
      /* _oksotgru Numeric(1, 0) */
      /* _okramatt Numeric(1, 0) */
      /* _okateco Numeric(1, 0) */
      /* Verifica se presente codice Ateco */
      /* If Empty(LRTrim(w_ATTIV)) or LRTrim(w_ATTIV) = '0' */
      if (CPLib.Empty(CPLib.LRTrim(w_ATTIV)) || CPLib.eqr(CPLib.LRTrim(w_ATTIV),"0")) {
        /* _ateco := '' */
        _ateco = "";
      } // End If
      /* If not(Empty(w_ATTIV)) and Len(LRTrim(w_ATTIV)) > 3 */
      if ( ! (CPLib.Empty(w_ATTIV)) && CPLib.gt(CPLib.Len(CPLib.LRTrim(w_ATTIV)),3)) {
        /* _ateco := Left(LRTrim(w_ATTIV),3) */
        _ateco = CPLib.Left(CPLib.LRTrim(w_ATTIV),3);
      } // End If
      /* If Date() < CharToDate('20100801') */
      if (CPLib.lt(CPLib.Date(),CPLib.CharToDate("20100801"))) {
        /* _ateco := '' */
        _ateco = "";
      } // End If
      /* If not(Empty(_ateco)) and (_ateco='970' or _ateco='981' or _ateco='982' or _ateco='990' or _ateco='P00') */
      if ( ! (CPLib.Empty(_ateco)) && (CPLib.eqr(_ateco,"970") || CPLib.eqr(_ateco,"981") || CPLib.eqr(_ateco,"982") || CPLib.eqr(_ateco,"990") || CPLib.eqr(_ateco,"P00"))) {
        /* _ateco := '' */
        _ateco = "";
      } // End If
      /* Controlla i valori del sottogruppo e del ramo */
      // * --- Select from tbsetsin
      m_cServer = m_Ctx.GetServer("tbsetsin");
      m_cPhName = m_Ctx.GetPhName("tbsetsin");
      if (Cursor_tbsetsin!=null)
        Cursor_tbsetsin.Close();
      Cursor_tbsetsin = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbsetsin")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbsetsin.Eof())) {
        /* _okramatt := 0 */
        _okramatt = CPLib.Round(0,0);
        /* _oksotgru := 0 */
        _oksotgru = CPLib.Round(0,0);
        /* _okateco := 0 */
        _okateco = CPLib.Round(0,0);
        /* If (Empty(tbsetsin->DATAINI) or tbsetsin->DATAINI<=Date()) and (Empty(tbsetsin->DATAFINE) or tbsetsin->DATAFINE >= Date()) */
        if ((CPLib.Empty(Cursor_tbsetsin.GetDate("DATAINI")) || CPLib.le(Cursor_tbsetsin.GetDate("DATAINI"),CPLib.Date())) && (CPLib.Empty(Cursor_tbsetsin.GetDate("DATAFINE")) || CPLib.ge(Cursor_tbsetsin.GetDate("DATAFINE"),CPLib.Date()))) {
          /* If w_SOTGRUP >= tbsetsin->DASOT1 and w_SOTGRUP <= tbsetsin->ASOT1 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT1")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT1"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT2 and w_SOTGRUP <= tbsetsin->ASOT2 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT2")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT2"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT3 and w_SOTGRUP <= tbsetsin->ASOT3 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT3")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT3"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT4 and w_SOTGRUP <= tbsetsin->ASOT4 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT4")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT4"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT5 and w_SOTGRUP <= tbsetsin->ASOT5 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT5")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT5"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT6 and w_SOTGRUP <= tbsetsin->ASOT6 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT6")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT6"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT7 and w_SOTGRUP <= tbsetsin->ASOT7 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT7")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT7"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT8 and w_SOTGRUP <= tbsetsin->ASOT8 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT8")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT8"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT9 and w_SOTGRUP <= tbsetsin->ASOT9 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT9")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT9"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT10 and w_SOTGRUP <= tbsetsin->ASOT10 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT10")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT10"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT11 and w_SOTGRUP <= tbsetsin->ASOT11 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT11")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT11"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_SOTGRUP >= tbsetsin->DASOT12 and w_SOTGRUP <= tbsetsin->ASOT12 */
          if (CPLib.ge(w_SOTGRUP,Cursor_tbsetsin.GetString("DASOT12")) && CPLib.le(w_SOTGRUP,Cursor_tbsetsin.GetString("ASOT12"))) {
            /* _oksotgru := 1 */
            _oksotgru = CPLib.Round(1,0);
          } // End If
          /* If w_tipsot <> '0' and w_tipsot <> '2' */
          if (CPLib.ne(w_tipsot,"0") && CPLib.ne(w_tipsot,"2")) {
            /* If not(Empty(LRTrim(_ateco))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_ateco)))) {
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
          } else { // Else
            /* _okateco := 1 */
            _okateco = CPLib.Round(1,0);
          } // End If
          /* If _okateco=1 and _oksotgru = 1 */
          if (CPLib.eqr(_okateco,1) && CPLib.eqr(_oksotgru,1)) {
            /* w_SETTSINT := tbsetsin->SETSINT // Settorizzazione UIC */
            w_SETTSINT = Cursor_tbsetsin.GetString("SETSINT");
            /* w_DESCUIC := tbsetsin->DESCRI // Descrizione Settorizzazione UIC */
            w_DESCUIC = Cursor_tbsetsin.GetString("DESCRI");
            /* If _okramatt = 1 and _oksotgru = 1 */
            if (CPLib.eqr(_okramatt,1) && CPLib.eqr(_oksotgru,1)) {
              /* w_OLDSETSIN := tbsetsin->SETSINT // Settorizzazione UIC */
              w_OLDSETSIN = Cursor_tbsetsin.GetString("SETSINT");
            } // End If
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        Cursor_tbsetsin.Next();
      }
      m_cConnectivityError = Cursor_tbsetsin.ErrorMessage();
      Cursor_tbsetsin.Close();
      // * --- End Select
    } finally {
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
      m_Caller.SetString("SOTGRUP","C",3,0,w_SOTGRUP);
      m_Caller.SetString("RAMOGRUP","C",3,0,w_RAMOGRUP);
      m_Caller.SetString("SETTSINT","C",3,0,w_SETTSINT);
      m_Caller.SetString("OLDSETSIN","C",3,0,w_OLDSETSIN);
      m_Caller.SetString("DESCUIC","C",60,0,w_DESCUIC);
      m_Caller.SetString("ATTIV","C",10,0,w_ATTIV);
      m_Caller.SetString("tipsot","C",1,0,w_tipsot);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_calcolasettR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calcolasettR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_SOTGRUP = m_Caller.GetString("SOTGRUP","C",3,0);
    w_RAMOGRUP = m_Caller.GetString("RAMOGRUP","C",3,0);
    w_SETTSINT = m_Caller.GetString("SETTSINT","C",3,0);
    w_OLDSETSIN = m_Caller.GetString("OLDSETSIN","C",3,0);
    w_DESCUIC = m_Caller.GetString("DESCUIC","C",60,0);
    w_ATTIV = m_Caller.GetString("ATTIV","C",10,0);
    w_tipsot = m_Caller.GetString("tipsot","C",1,0);
    _NewRamo = CPLib.Space(3);
    _ateco = CPLib.Space(3);
    _oksotgru = 0;
    _okramatt = 0;
    _okateco = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
