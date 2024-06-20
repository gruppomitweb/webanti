// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_verifica_cf_nome_cognome_numericR implements CallerWithObjs {
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
  public String CF;
  public String NOME;
  public String COGNOME;
  public double lcnome;
  public double lnome;
  public double ncf;
  public boolean chknome;
  public String BufferNome;
  public double i;
  public boolean _loop;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_verifica_cf_nome_cognome_numericR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_verifica_cf_nome_cognome_numeric",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("lcnome",p_cVarName)) {
      return lcnome;
    }
    if (CPLib.eqr("lnome",p_cVarName)) {
      return lnome;
    }
    if (CPLib.eqr("ncf",p_cVarName)) {
      return ncf;
    }
    if (CPLib.eqr("i",p_cVarName)) {
      return i;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_verifica_cf_nome_cognome_numeric";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("CF",p_cVarName)) {
      return CF;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return NOME;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return COGNOME;
    }
    if (CPLib.eqr("BufferNome",p_cVarName)) {
      return BufferNome;
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
    if (CPLib.eqr("chknome",p_cVarName)) {
      return chknome;
    }
    if (CPLib.eqr("_loop",p_cVarName)) {
      return _loop;
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
    if (CPLib.eqr("lcnome",p_cVarName)) {
      lcnome = value;
      return;
    }
    if (CPLib.eqr("lnome",p_cVarName)) {
      lnome = value;
      return;
    }
    if (CPLib.eqr("ncf",p_cVarName)) {
      ncf = value;
      return;
    }
    if (CPLib.eqr("i",p_cVarName)) {
      i = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CF",p_cVarName)) {
      CF = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      NOME = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      COGNOME = value;
      return;
    }
    if (CPLib.eqr("BufferNome",p_cVarName)) {
      BufferNome = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("chknome",p_cVarName)) {
      chknome = value;
      return;
    }
    if (CPLib.eqr("_loop",p_cVarName)) {
      _loop = value;
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
    /* CF Char(16) */
    /* NOME Char(25) */
    /* COGNOME Char(26) */
    /* lcnome Numeric(2, 0) */
    /* lnome Numeric(2, 0) */
    /* ncf Numeric(1, 0) */
    /* chknome Bool */
    /* BufferNome Char(25) */
    /* i Numeric(100, 0) */
    /* _loop Bool */
    /* ncf := 1 */
    ncf = CPLib.Round(1,0);
    /* chknome := False  */
    chknome = false;
    /* BufferNome := '' */
    BufferNome = "";
    /* lcnome := Len(COGNOME) */
    lcnome = CPLib.Round(CPLib.Len(COGNOME),0);
    /* Exec "Verifica cognome" Page 2 */
    Page_2();
    /* If ncf=4 */
    if (CPLib.eqr(ncf,4)) {
      /* lnome := Len(NOME) */
      lnome = CPLib.Round(CPLib.Len(NOME),0);
      /* Exec "Verifica nome" Page 3 */
      Page_3();
    } else { // Else
      /* Return 0 */
      throw new Stop(0);
    } // End If
    /* If ncf=7 */
    if (CPLib.eqr(ncf,7)) {
      /* Return 1  */
      throw new Stop(1);
    } else { // Else
      /* Return 0  */
      throw new Stop(0);
    } // End If
  }
  void Page_2() throws Exception {
    /* i := 1 */
    i = CPLib.Round(1,0);
    /* While i<=lcnome */
    while (CPLib.le(i,lcnome)) {
      /* If (At((Substr(COGNOME,i,1)+'/'),'A/E/I/O/U/')=0) and (Asc(Substr(COGNOME,i,1))>64 and Asc(Substr(COGNOME,i,1))<91) */
      if ((CPLib.eqr(CPLib.At((CPLib.Substr(COGNOME,i,1)+"/"),"A/E/I/O/U/"),0)) && (CPLib.gt(CPLib.Asc(CPLib.Substr(COGNOME,i,1)),64) && CPLib.lt(CPLib.Asc(CPLib.Substr(COGNOME,i,1)),91))) {
        /* If Substr(CF,ncf,1)=Substr(COGNOME,i,1) */
        if (CPLib.eqr(CPLib.Substr(CF,ncf,1),CPLib.Substr(COGNOME,i,1))) {
          /* ncf := ncf+1 */
          ncf = CPLib.Round(ncf+1,0);
          /* If ncf=4 */
          if (CPLib.eqr(ncf,4)) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } else { // Else
          /* Return 0  */
          throw new Stop(0);
        } // End If
      } // End If
      /* i := i+1 */
      i = CPLib.Round(i+1,0);
    } // End While
    /* If ncf<4 */
    if (CPLib.lt(ncf,4)) {
      /* i := 1 */
      i = CPLib.Round(1,0);
      /* While i<=lcnome */
      while (CPLib.le(i,lcnome)) {
        /* If (not(At((Substr(COGNOME,i,1)+'/'),'A/E/I/O/U/')=0)) and (Asc(Substr(COGNOME,i,1))>64 and Asc(Substr(COGNOME,i,1))<91) */
        if (( ! (CPLib.eqr(CPLib.At((CPLib.Substr(COGNOME,i,1)+"/"),"A/E/I/O/U/"),0))) && (CPLib.gt(CPLib.Asc(CPLib.Substr(COGNOME,i,1)),64) && CPLib.lt(CPLib.Asc(CPLib.Substr(COGNOME,i,1)),91))) {
          /* If Substr(CF,ncf,1)=Substr(COGNOME,i,1) */
          if (CPLib.eqr(CPLib.Substr(CF,ncf,1),CPLib.Substr(COGNOME,i,1))) {
            /* ncf := ncf+1 */
            ncf = CPLib.Round(ncf+1,0);
            /* If ncf=4 */
            if (CPLib.eqr(ncf,4)) {
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } else { // Else
            /* Return 0  */
            throw new Stop(0);
          } // End If
        } // End If
        /* i := i+1 */
        i = CPLib.Round(i+1,0);
      } // End While
    } // End If
    /* While True  */
    while (true) {
      /* If ncf<4 */
      if (CPLib.lt(ncf,4)) {
        /* If Substr(CF,ncf,1)='X' */
        if (CPLib.eqr(CPLib.Substr(CF,ncf,1),"X")) {
          /* ncf := ncf+1 */
          ncf = CPLib.Round(ncf+1,0);
        } else { // Else
          /* Return 0  */
          throw new Stop(0);
        } // End If
      } else { // Else
        // Exit Loop
        if (true) {
          break;
        }
      } // End If
    } // End While
  }
  void Page_3() throws Exception {
    /* i := 1 */
    i = CPLib.Round(1,0);
    /* While i<=lnome */
    while (CPLib.le(i,lnome)) {
      /* _loop := True  */
      _loop = true;
      /* If (At((Substr(NOME,i,1)+'/'),'A/E/I/O/U/')=0) and (Asc(Substr(NOME,i,1))>64 and Asc(Substr(NOME,i,1))<91) */
      if ((CPLib.eqr(CPLib.At((CPLib.Substr(NOME,i,1)+"/"),"A/E/I/O/U/"),0)) && (CPLib.gt(CPLib.Asc(CPLib.Substr(NOME,i,1)),64) && CPLib.lt(CPLib.Asc(CPLib.Substr(NOME,i,1)),91))) {
        /* If ncf=5 and chknome=False  */
        if (CPLib.eqr(ncf,5) && CPLib.eqr(chknome,false)) {
          /* chknome := True  */
          chknome = true;
          /* BufferNome := Substr(NOME,i,1) */
          BufferNome = CPLib.Substr(NOME,i,1);
          /* _loop := False  */
          _loop = false;
        } // End If
        /* If _loop */
        if (_loop) {
          /* If chknome */
          if (chknome) {
            /* BufferNome := BufferNome+Substr(NOME,i,1) */
            BufferNome = BufferNome+CPLib.Substr(NOME,i,1);
          } // End If
          /* If Substr(CF,ncf,1)=Substr(NOME,i,1) */
          if (CPLib.eqr(CPLib.Substr(CF,ncf,1),CPLib.Substr(NOME,i,1))) {
            /* ncf := ncf+1 */
            ncf = CPLib.Round(ncf+1,0);
            /* If ncf=7 */
            if (CPLib.eqr(ncf,7)) {
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } else { // Else
            /* If not(chknome) */
            if ( ! (chknome)) {
              /* Return 0  */
              throw new Stop(0);
            } else { // Else
              /* If Len(BufferNome)>2 */
              if (CPLib.gt(CPLib.Len(BufferNome),2)) {
                /* Return 0  */
                throw new Stop(0);
              } // End If
            } // End If
          } // End If
        } // End If
      } // End If
      /* i := i+1 */
      i = CPLib.Round(i+1,0);
    } // End While
    /* If Len(BufferNome)=2 and Substr(CF,5,2)=BufferNome */
    if (CPLib.eqr(CPLib.Len(BufferNome),2) && CPLib.eqr(CPLib.Substr(CF,5,2),BufferNome)) {
      /* ncf := 7 */
      ncf = CPLib.Round(7,0);
    } // End If
    /* If ncf<7 */
    if (CPLib.lt(ncf,7)) {
      /* If Len(BufferNome)=1 and Substr(CF,5,1)=BufferNome */
      if (CPLib.eqr(CPLib.Len(BufferNome),1) && CPLib.eqr(CPLib.Substr(CF,5,1),BufferNome)) {
        /* ncf := 6 */
        ncf = CPLib.Round(6,0);
      } // End If
      /* i := 1 */
      i = CPLib.Round(1,0);
      /* While i<=lnome */
      while (CPLib.le(i,lnome)) {
        /* If (not(At((Substr(NOME,i,1)+'/'),'A/E/I/O/U/')=0)) and (Asc(Substr(NOME,i,1))>64 and Asc(Substr(NOME,i,1))<91) */
        if (( ! (CPLib.eqr(CPLib.At((CPLib.Substr(NOME,i,1)+"/"),"A/E/I/O/U/"),0))) && (CPLib.gt(CPLib.Asc(CPLib.Substr(NOME,i,1)),64) && CPLib.lt(CPLib.Asc(CPLib.Substr(NOME,i,1)),91))) {
          /* If Substr(CF,ncf,1)=Substr(NOME,i,1) */
          if (CPLib.eqr(CPLib.Substr(CF,ncf,1),CPLib.Substr(NOME,i,1))) {
            /* ncf := ncf+1 */
            ncf = CPLib.Round(ncf+1,0);
            /* If ncf=7 */
            if (CPLib.eqr(ncf,7)) {
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } else { // Else
            /* Return 0 */
            throw new Stop(0);
          } // End If
        } // End If
        /* i := i+1 */
        i = CPLib.Round(i+1,0);
      } // End While
    } // End If
    /* While True  */
    while (true) {
      /* If ncf<7 */
      if (CPLib.lt(ncf,7)) {
        /* If Substr(CF,ncf,1)='X' */
        if (CPLib.eqr(CPLib.Substr(CF,ncf,1),"X")) {
          /* ncf := ncf+1 */
          ncf = CPLib.Round(ncf+1,0);
        } else { // Else
          /* Return 0 */
          throw new Stop(0);
        } // End If
      } else { // Else
        // Exit Loop
        if (true) {
          break;
        }
      } // End If
    } // End While
  }
  void _init_() {
  }
  public String RunAsync(String p_CF,String p_NOME,String p_COGNOME) {
    CF = p_CF;
    NOME = p_NOME;
    COGNOME = p_COGNOME;
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
  public double Run(String p_CF,String p_NOME,String p_COGNOME) {
    CF = p_CF;
    NOME = p_NOME;
    COGNOME = p_COGNOME;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arfn_verifica_cf_nome_cognome_numericR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_verifica_cf_nome_cognome_numericR(p_Ctx, p_Caller);
  }
  public static arfn_verifica_cf_nome_cognome_numericR Make(CPContext p_Ctx) {
    return new arfn_verifica_cf_nome_cognome_numericR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    CF = CPLib.Space(16);
    NOME = CPLib.Space(25);
    COGNOME = CPLib.Space(26);
    lcnome = 0;
    lnome = 0;
    ncf = 0;
    chknome = false;
    BufferNome = CPLib.Space(25);
    i = 0;
    _loop = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_verifica_cf_nome_cognome_numeric,
  public static final String i_InvokedRoutines = ",arfn_verifica_cf_nome_cognome_numeric,";
  public static String[] m_cRunParameterNames={"CF","NOME","COGNOME"};
}
