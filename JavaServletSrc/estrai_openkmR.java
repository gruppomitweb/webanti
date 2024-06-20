// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class estrai_openkmR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
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
  public String _pdest;
  public String _porig;
  public String _fileorig;
  public String _filedest;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public estrai_openkmR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("estrai_openkm",m_Caller);
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
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
      return "estrai_openkm";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_pdest",p_cVarName)) {
      return _pdest;
    }
    if (CPLib.eqr("_porig",p_cVarName)) {
      return _porig;
    }
    if (CPLib.eqr("_fileorig",p_cVarName)) {
      return _fileorig;
    }
    if (CPLib.eqr("_filedest",p_cVarName)) {
      return _filedest;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
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
    if (CPLib.eqr("_pdest",p_cVarName)) {
      _pdest = value;
      return;
    }
    if (CPLib.eqr("_porig",p_cVarName)) {
      _porig = value;
      return;
    }
    if (CPLib.eqr("_fileorig",p_cVarName)) {
      _fileorig = value;
      return;
    }
    if (CPLib.eqr("_filedest",p_cVarName)) {
      _filedest = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
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
    CPResultSet Cursor_cgo_operazioni_storico=null;
    CPResultSet Cursor_cgo_docope=null;
    try {
      /* _pdest Char(120) */
      /* _porig Char(0) */
      /* _fileorig Char(0) */
      /* _filedest Char(0) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(128) // Path Documenti */
      // * --- Select from cgo_operazioni_storico
      m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
      if (Cursor_cgo_operazioni_storico!=null)
        Cursor_cgo_operazioni_storico.Close();
      Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNAINUMOPE,CODDIPE,IDDOCALL  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
        /* _porig := LRTrim(gPathApp)+"/appo/"+RTrim(cgo_operazioni_storico->CODDIPE)+"/" */
        _porig = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.RTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))+"/";
        /* _pdest := LRTrim(gPathDoc)+"/DocCGO/"+LRTrim(gAzienda)+"/"+LRTrim(cgo_operazioni_storico->CODDIPE)+"/"+LRTrim(cgo_operazioni_storico->IDDOCALL) */
        _pdest = CPLib.LRTrim(gPathDoc)+"/DocCGO/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))+"/"+CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"));
        /* FileLibMit.CreateDirPath(_pdest) */
        FileLibMit.CreateDirPath(_pdest);
        // * --- Select from cgo_docope
        m_cServer = m_Ctx.GetServer("cgo_docope");
        m_cPhName = m_Ctx.GetPhName("cgo_docope");
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
        Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_docope.Eof())) {
          /* If not(Empty(LRTrim(cgo_docope->DCDOCUNICO))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"))))) {
            /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCUNICO) */
            _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"));
            /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCUNICO) */
            _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"));
            /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCUNICO),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
            System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
            /* If FileLibMit.ExistFile(_fileorig) */
            if (FileLibMit.ExistFile(_fileorig)) {
              /* FileLibMit.MoveFile(_fileorig,_filedest) */
              FileLibMit.MoveFile(_fileorig,_filedest);
            } // End If
          } else { // Else
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM1))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM1) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM1) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM1),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM2))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM2) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM2) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM2),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM3))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM3) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM3) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM3),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM4))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM4) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM4) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM4),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM5))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM5) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM5) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM5),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_docope->DCDOCNOM6))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"))))) {
              /* _fileorig := LRTrim(_porig)+LRTrim(cgo_docope->DCDOCNOM6) */
              _fileorig = CPLib.LRTrim(_porig)+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"));
              /* _filedest := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM6) */
              _filedest = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"));
              /* System.out.println(arfn_catchfile(cgo_operazioni_storico->IDDOCALL,LRTrim(cgo_docope->DCDOCNOM6),"V",LRTrim(cgo_operazioni_storico->CODDIPE))) */
              System.out.println(arfn_catchfileR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6")),"V",CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODDIPE"))));
              /* If FileLibMit.ExistFile(_fileorig) */
              if (FileLibMit.ExistFile(_fileorig)) {
                /* FileLibMit.MoveFile(_fileorig,_filedest) */
                FileLibMit.MoveFile(_fileorig,_filedest);
              } // End If
            } // End If
          } // End If
          Cursor_cgo_docope.Next();
        }
        m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
        Cursor_cgo_docope.Close();
        // * --- End Select
        Cursor_cgo_operazioni_storico.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
      Cursor_cgo_operazioni_storico.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static estrai_openkmR Make(CPContext p_Ctx, Caller p_Caller) {
    return new estrai_openkmR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _pdest = CPLib.Space(120);
    _porig = CPLib.Space(0);
    _fileorig = CPLib.Space(0);
    _filedest = CPLib.Space(0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_catchfile,
  public static final String i_InvokedRoutines = ",arfn_catchfile,";
  public static String[] m_cRunParameterNames={};
}
