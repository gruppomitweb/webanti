// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_multi_sd_aprichiudi_delopeR implements CallerWithObjs {
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
  public double w_daanno;
  public double w_a_anno;
  public String w_CAFINVIO;
  public String w_CFINVIO;
  public java.sql.Date w_DATAINVIO;
  public String w_FILEINVIO;
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public double w_anno;
  public String w_mese;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_multi_sd_aprichiudi_delopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_multi_sd_aprichiudi_delope",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("daanno",p_cVarName)) {
      return w_daanno;
    }
    if (CPLib.eqr("a_anno",p_cVarName)) {
      return w_a_anno;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_multi_sd_aprichiudi_delope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      return w_CAFINVIO;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      return w_CFINVIO;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      return w_FILEINVIO;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      return w_DATAINVIO;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
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
    if (CPLib.eqr("daanno",p_cVarName)) {
      w_daanno = value;
      return;
    }
    if (CPLib.eqr("a_anno",p_cVarName)) {
      w_a_anno = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      w_CAFINVIO = value;
      return;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      w_CFINVIO = value;
      return;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      w_FILEINVIO = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      w_DATAINVIO = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
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
    /* w_daanno Numeric(4, 0) */
    /* w_a_anno Numeric(4, 0) */
    /* w_CAFINVIO Char(5) // Codice CAF Organo Invio */
    /* w_CFINVIO Char(16) // Codice Fiscale Organo Invio File */
    /* w_DATAINVIO Date // Data Impegno Organo Invio */
    /* w_FILEINVIO Char(1) // Tipo Preparazione FIle */
    /* w_a_data Date */
    /* w_dadata Date */
    /* w_anno Numeric(4, 0) */
    /* w_mese Char(2) */
    /* w_anno := w_daanno */
    w_anno = CPLib.Round(w_daanno,0);
    /* While w_anno<= w_a_anno */
    while (CPLib.le(w_anno,w_a_anno)) {
      /* w_mese := Right('0'+LRTrim(Str(1,2,0)),2) */
      w_mese = CPLib.Right("0"+CPLib.LRTrim(CPLib.Str(1,2,0)),2);
      /* While Val(w_mese)<13 */
      while (CPLib.lt(CPLib.Val(w_mese),13)) {
        /* w_dadata := CharToDate('01/'+w_mese+'/'+Str(w_anno,4,0)) */
        w_dadata = CPLib.CharToDate("01/"+w_mese+"/"+CPLib.Str(w_anno,4,0));
        /* w_a_data := arfn_finemese(w_dadata) */
        w_a_data = arfn_finemeseR.Make(m_Ctx,this).Run(w_dadata);
        /* Exec Routine arrt_sd_aprichiudi_delope(w_a_data,w_dadata,w_FILEINVIO,w_DATAINVIO,w_CFINVIO,w_CAFINVIO,w_anno,w_mese) */
        arrt_sd_aprichiudi_delopeR.Make(m_Ctx,this).Run(w_a_data,w_dadata,w_FILEINVIO,w_DATAINVIO,w_CFINVIO,w_CAFINVIO,w_anno,w_mese);
        /* w_mese := Right('0'+LRTrim(Str(Val(w_mese)+1,2,0)),2) */
        w_mese = CPLib.Right("0"+CPLib.LRTrim(CPLib.Str(CPLib.Val(w_mese)+1,2,0)),2);
      } // End While
      /* w_anno := w_anno+1 */
      w_anno = CPLib.Round(w_anno+1,0);
    } // End While
  }
  void _init_() {
  }
  public String RunAsync(double p_w_daanno,double p_w_a_anno,String p_w_CAFINVIO,String p_w_CFINVIO,java.sql.Date p_w_DATAINVIO,String p_w_FILEINVIO) {
    w_daanno = p_w_daanno;
    w_a_anno = p_w_a_anno;
    w_CAFINVIO = p_w_CAFINVIO;
    w_CFINVIO = p_w_CFINVIO;
    w_DATAINVIO = p_w_DATAINVIO;
    w_FILEINVIO = p_w_FILEINVIO;
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
  public Forward Run(double p_w_daanno,double p_w_a_anno,String p_w_CAFINVIO,String p_w_CFINVIO,java.sql.Date p_w_DATAINVIO,String p_w_FILEINVIO) {
    w_daanno = p_w_daanno;
    w_a_anno = p_w_a_anno;
    w_CAFINVIO = p_w_CAFINVIO;
    w_CFINVIO = p_w_CFINVIO;
    w_DATAINVIO = p_w_DATAINVIO;
    w_FILEINVIO = p_w_FILEINVIO;
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
  public static arrt_multi_sd_aprichiudi_delopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_multi_sd_aprichiudi_delopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daanno = 0;
    w_a_anno = 0;
    w_CAFINVIO = CPLib.Space(5);
    w_CFINVIO = CPLib.Space(16);
    w_DATAINVIO = CPLib.NullDate();
    w_FILEINVIO = CPLib.Space(1);
    w_a_data = CPLib.NullDate();
    w_dadata = CPLib.NullDate();
    w_anno = 0;
    w_mese = CPLib.Space(2);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_finemese,arrt_sd_aprichiudi_delope,
  public static final String i_InvokedRoutines = ",arfn_finemese,arrt_sd_aprichiudi_delope,";
  public static String[] m_cRunParameterNames={"w_daanno","w_a_anno","w_CAFINVIO","w_CFINVIO","w_DATAINVIO","w_FILEINVIO"};
}
