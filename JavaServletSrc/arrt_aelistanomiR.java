// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_aelistanomiR implements CallerWithObjs {
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
  public String w_iniz;
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public java.sql.Date w_datpris;
  public java.sql.Date w_datprif;
  public java.sql.Date w_datseci;
  public java.sql.Date w_datsecf;
  public String c_inidat;
  public String c_findat;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_aelistanomiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_aelistanomi",m_Caller);
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
      return "arrt_aelistanomi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("iniz",p_cVarName)) {
      return w_iniz;
    }
    if (CPLib.eqr("c_inidat",p_cVarName)) {
      return c_inidat;
    }
    if (CPLib.eqr("c_findat",p_cVarName)) {
      return c_findat;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("datpris",p_cVarName)) {
      return w_datpris;
    }
    if (CPLib.eqr("datprif",p_cVarName)) {
      return w_datprif;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      return w_datseci;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      return w_datsecf;
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
    if (CPLib.eqr("iniz",p_cVarName)) {
      w_iniz = value;
      return;
    }
    if (CPLib.eqr("c_inidat",p_cVarName)) {
      c_inidat = value;
      return;
    }
    if (CPLib.eqr("c_findat",p_cVarName)) {
      c_findat = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("datpris",p_cVarName)) {
      w_datpris = value;
      return;
    }
    if (CPLib.eqr("datprif",p_cVarName)) {
      w_datprif = value;
      return;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      w_datseci = value;
      return;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      w_datsecf = value;
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
    /* Dichiarazione variabili del caller */
    /* w_iniz Char(1) */
    /* w_dadata Date */
    /* w_a_data Date */
    /* w_datpris Date */
    /* w_datprif Date */
    /* w_datseci Date */
    /* w_datsecf Date */
    /* Definizione variabili locali */
    /* c_inidat Char(10) */
    /* c_findat Char(10) */
    /* lancia la stampa */
    /* c_inidat := arfn_fdate(w_dadata) */
    c_inidat = arfn_fdateR.Make(m_Ctx,this).Run(w_dadata);
    /* c_findat := arfn_fdate(w_a_data) */
    c_findat = arfn_fdateR.Make(m_Ctx,this).Run(w_a_data);
    /* Case w_iniz = 'I' */
    if (CPLib.eqr(w_iniz,"I")) {
      /* Return  */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_aelistarapporti_1");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("datpris",w_datpris);
      f.SetParameter("datprif",w_datprif);
      f.SetParameter("cinidat",c_inidat);
      f.SetParameter("cfindat",c_findat);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"datpris"+","+"datprif"+","+"cinidat"+","+"cfindat");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
      /* Case w_iniz = 'S' */
    } else if (CPLib.eqr(w_iniz,"S")) {
      /* Return  */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_aelistarapporti_2");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("datseci",w_datseci);
      f.SetParameter("datsecf",w_datsecf);
      f.SetParameter("cinidat",c_inidat);
      f.SetParameter("cfindat",c_findat);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"datseci"+","+"datsecf"+","+"cinidat"+","+"cfindat");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
      /* Case w_iniz = 'P' */
    } else if (CPLib.eqr(w_iniz,"P")) {
      /* Return  */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_aelistarapporti_3");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("dadata",w_dadata);
      f.SetParameter("a_data",w_a_data);
      f.SetParameter("cinidat",c_inidat);
      f.SetParameter("cfindat",c_findat);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"dadata"+","+"a_data"+","+"cinidat"+","+"cfindat");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End Case
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
      m_Caller.SetString("iniz","C",1,0,w_iniz);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("datpris","D",8,0,w_datpris);
      m_Caller.SetDate("datprif","D",8,0,w_datprif);
      m_Caller.SetDate("datseci","D",8,0,w_datseci);
      m_Caller.SetDate("datsecf","D",8,0,w_datsecf);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_aelistanomiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_aelistanomiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_datpris = m_Caller.GetDate("datpris","D",8,0);
    w_datprif = m_Caller.GetDate("datprif","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    c_inidat = CPLib.Space(10);
    c_findat = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={};
}
