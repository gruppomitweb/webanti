// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpoper_stoR implements CallerWithObjs {
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_tipstp;
  public String w_c_adata;
  public String w_cdadata;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpoper_stoR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_stpoper_sto",m_Caller);
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
      return "arrt_stpoper_sto";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      return w_tipstp;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
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
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      w_tipstp = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
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
    /* Variabili del caller */
    /* w_DaDatOpe Date */
    /* w_ADatOpe Date */
    /* w_daCodCli Char(16) */
    /* w_aCodCli Char(16) */
    /* w_tipstp Char(1) */
    /* w_c_adata Char(8) */
    /* w_cdadata Char(8) */
    /* Lancio la stampa */
    /* If w_tipstp = 'S' */
    if (CPLib.eqr(w_tipstp,"S")) {
      /* Return  */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_stpoper_sto");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("cdadata",w_cdadata);
      f.SetParameter("c_adata",w_c_adata);
      f.SetParameter("daCodCli",w_daCodCli);
      f.SetParameter("aCodCli",w_aCodCli);
      f.SetParameter("rotation","Landscape");
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"cdadata"+","+"c_adata"+","+"daCodCli"+","+"aCodCli"+","+"rotation");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
      /* Return  */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_stpoperana_sto");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("cdadata",w_cdadata);
      f.SetParameter("c_adata",w_c_adata);
      f.SetParameter("daCodCli",w_daCodCli);
      f.SetParameter("aCodCli",w_aCodCli);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"cdadata"+","+"c_adata"+","+"daCodCli"+","+"aCodCli");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("daCodCli","C",16,0,w_daCodCli);
      m_Caller.SetString("aCodCli","C",16,0,w_aCodCli);
      m_Caller.SetString("tipstp","C",1,0,w_tipstp);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("cdadata","C",8,0,w_cdadata);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpoper_stoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpoper_stoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_daCodCli = m_Caller.GetString("daCodCli","C",16,0);
    w_aCodCli = m_Caller.GetString("aCodCli","C",16,0);
    w_tipstp = m_Caller.GetString("tipstp","C",1,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_cdadata = m_Caller.GetString("cdadata","C",8,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
