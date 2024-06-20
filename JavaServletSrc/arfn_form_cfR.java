// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_form_cfR implements CallerWithObjs {
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
  public String pCF;
  public String pCognome;
  public String pNome;
  public java.sql.Date pDatNas;
  public String pCitta;
  public String pStato;
  public String pSesso;
  public double pCFE;
  public String pPNas;
  public boolean bRitorno;
  public String _cf;
  public String _oldcf;
  public String _oldch;
  public String _newch;
  public double _conta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_form_cfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_form_cf",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pCFE",p_cVarName)) {
      return pCFE;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_form_cf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCF",p_cVarName)) {
      return pCF;
    }
    if (CPLib.eqr("pCognome",p_cVarName)) {
      return pCognome;
    }
    if (CPLib.eqr("pNome",p_cVarName)) {
      return pNome;
    }
    if (CPLib.eqr("pCitta",p_cVarName)) {
      return pCitta;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      return pStato;
    }
    if (CPLib.eqr("pSesso",p_cVarName)) {
      return pSesso;
    }
    if (CPLib.eqr("pPNas",p_cVarName)) {
      return pPNas;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      return _cf;
    }
    if (CPLib.eqr("_oldcf",p_cVarName)) {
      return _oldcf;
    }
    if (CPLib.eqr("_oldch",p_cVarName)) {
      return _oldch;
    }
    if (CPLib.eqr("_newch",p_cVarName)) {
      return _newch;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatNas",p_cVarName)) {
      return pDatNas;
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
    if (CPLib.eqr("pCFE",p_cVarName)) {
      pCFE = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCF",p_cVarName)) {
      pCF = value;
      return;
    }
    if (CPLib.eqr("pCognome",p_cVarName)) {
      pCognome = value;
      return;
    }
    if (CPLib.eqr("pNome",p_cVarName)) {
      pNome = value;
      return;
    }
    if (CPLib.eqr("pCitta",p_cVarName)) {
      pCitta = value;
      return;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      pStato = value;
      return;
    }
    if (CPLib.eqr("pSesso",p_cVarName)) {
      pSesso = value;
      return;
    }
    if (CPLib.eqr("pPNas",p_cVarName)) {
      pPNas = value;
      return;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      _cf = value;
      return;
    }
    if (CPLib.eqr("_oldcf",p_cVarName)) {
      _oldcf = value;
      return;
    }
    if (CPLib.eqr("_oldch",p_cVarName)) {
      _oldch = value;
      return;
    }
    if (CPLib.eqr("_newch",p_cVarName)) {
      _newch = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatNas",p_cVarName)) {
      pDatNas = value;
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
    /* Parametri */
    /* pCF Char(16) */
    /* pCognome Char(30) */
    /* pNome Char(30) */
    /* pDatNas Date */
    /* pCitta Char(40) */
    /* pStato Char(3) */
    /* pSesso Char(1) */
    /* pCFE Numeric(1, 0) */
    /* pPNas Char(2) */
    /* Vaiabili locali */
    /* bRitorno Bool */
    /* _cf Char(16) */
    /* _oldcf Char(16) */
    /* _oldch Char(1) */
    /* _newch Char(1) */
    /* _conta Numeric(2, 0) */
    /* Esegue solo se codice fiscale italiano */
    /* bRitorno := True */
    bRitorno = true;
    /* If pCFE=0 */
    if (CPLib.eqr(pCFE,0)) {
      /* Calcola il codice fiscale */
      /* _cf := arfn_calccodfis(Upper(pCognome),Upper(pNome),pDatNas,Upper(pCitta),Upper(pStato),pSesso,pPNas) */
      _cf = arfn_calccodfisR.Make(m_Ctx,this).Run(CPLib.Upper(pCognome),CPLib.Upper(pNome),pDatNas,CPLib.Upper(pCitta),CPLib.Upper(pStato),pSesso,pPNas);
      /* Verifica se un carattere numerico è lettera e lo trasforma */
      /* _oldcf := Upper(pCF) */
      _oldcf = CPLib.Upper(pCF);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= 16 */
      while (CPLib.le(_conta,16)) {
        /* If _conta = 7 or _conta = 8 or _conta= 10 or _conta= 11 or _conta= 13 or _conta= 14 or _conta= 15 */
        if (CPLib.eqr(_conta,7) || CPLib.eqr(_conta,8) || CPLib.eqr(_conta,10) || CPLib.eqr(_conta,11) || CPLib.eqr(_conta,13) || CPLib.eqr(_conta,14) || CPLib.eqr(_conta,15)) {
          /* _oldch := Substr(_oldcf,_conta,1) */
          _oldch = CPLib.Substr(_oldcf,_conta,1);
          /* If Asc(_oldch) < 48 or Asc(_oldch) > 57 */
          if (CPLib.lt(CPLib.Asc(_oldch),48) || CPLib.gt(CPLib.Asc(_oldch),57)) {
            /* Case _oldch = 'L' */
            if (CPLib.eqr(_oldch,"L")) {
              /* _newch := '0' */
              _newch = "0";
              /* Case _oldch = 'M' */
            } else if (CPLib.eqr(_oldch,"M")) {
              /* _newch := '1' */
              _newch = "1";
              /* Case _oldch = 'N' */
            } else if (CPLib.eqr(_oldch,"N")) {
              /* _newch := '2' */
              _newch = "2";
              /* Case _oldch = 'P' */
            } else if (CPLib.eqr(_oldch,"P")) {
              /* _newch := '3' */
              _newch = "3";
              /* Case _oldch = 'Q' */
            } else if (CPLib.eqr(_oldch,"Q")) {
              /* _newch := '4' */
              _newch = "4";
              /* Case _oldch = 'R' */
            } else if (CPLib.eqr(_oldch,"R")) {
              /* _newch := '5' */
              _newch = "5";
              /* Case _oldch = 'S' */
            } else if (CPLib.eqr(_oldch,"S")) {
              /* _newch := '6' */
              _newch = "6";
              /* Case _oldch = 'T' */
            } else if (CPLib.eqr(_oldch,"T")) {
              /* _newch := '7' */
              _newch = "7";
              /* Case _oldch = 'U' */
            } else if (CPLib.eqr(_oldch,"U")) {
              /* _newch := '8' */
              _newch = "8";
              /* Case _oldch = 'V' */
            } else if (CPLib.eqr(_oldch,"V")) {
              /* _newch := '9' */
              _newch = "9";
            } // End Case
            /* _oldcf := Substr(_oldcf,1,_conta - 1)+ _newch + Substr(_oldcf,_conta + 1,16 - (_conta+1)) */
            _oldcf = CPLib.Substr(_oldcf,1,_conta-1)+_newch+CPLib.Substr(_oldcf,_conta+1,16-(_conta+1));
          } // End If
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* If Empty(_cf) or (Left(_cf,15) <> Left(_oldcf,15)) */
      if (CPLib.Empty(_cf) || (CPLib.ne(CPLib.Left(_cf,15),CPLib.Left(_oldcf,15)))) {
        /* bRitorno := False */
        bRitorno = false;
      } // End If
    } // End If
    /* If not(bRitorno) */
    if ( ! (bRitorno)) {
      /* Error Msg "Codice Fiscale non congruente con dati anagrafici" */
      m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Codice Fiscale non congruente con dati anagrafici");
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pCF,String p_pCognome,String p_pNome,java.sql.Date p_pDatNas,String p_pCitta,String p_pStato,String p_pSesso,double p_pCFE,String p_pPNas) {
    pCF = p_pCF;
    pCognome = p_pCognome;
    pNome = p_pNome;
    pDatNas = p_pDatNas;
    pCitta = p_pCitta;
    pStato = p_pStato;
    pSesso = p_pSesso;
    pCFE = p_pCFE;
    pPNas = p_pPNas;
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
  public boolean Run(String p_pCF,String p_pCognome,String p_pNome,java.sql.Date p_pDatNas,String p_pCitta,String p_pStato,String p_pSesso,double p_pCFE,String p_pPNas) {
    pCF = p_pCF;
    pCognome = p_pCognome;
    pNome = p_pNome;
    pDatNas = p_pDatNas;
    pCitta = p_pCitta;
    pStato = p_pStato;
    pSesso = p_pSesso;
    pCFE = p_pCFE;
    pPNas = p_pPNas;
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
  public static arfn_form_cfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_form_cfR(p_Ctx, p_Caller);
  }
  public static arfn_form_cfR Make(CPContext p_Ctx) {
    return new arfn_form_cfR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCF = CPLib.Space(16);
    pCognome = CPLib.Space(30);
    pNome = CPLib.Space(30);
    pDatNas = CPLib.NullDate();
    pCitta = CPLib.Space(40);
    pStato = CPLib.Space(3);
    pSesso = CPLib.Space(1);
    pCFE = 0;
    pPNas = CPLib.Space(2);
    bRitorno = false;
    _cf = CPLib.Space(16);
    _oldcf = CPLib.Space(16);
    _oldch = CPLib.Space(1);
    _newch = CPLib.Space(1);
    _conta = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calccodfis,arfn_form_cf,
  public static final String i_InvokedRoutines = ",arfn_calccodfis,arfn_form_cf,";
  public static String[] m_cRunParameterNames={"pCF","pCognome","pNome","pDatNas","pCitta","pStato","pSesso","pCFE","pPNas"};
}
