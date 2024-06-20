// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_downloadxlsx_logR implements CallerWithObjs {
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
  public String pNomeFile;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String nomefile;
  public String filepath;
  public String ritorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_downloadxlsx_logR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_downloadxlsx_log",m_Caller);
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
      return "arrt_downloadxlsx_log";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      return pNomeFile;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("filepath",p_cVarName)) {
      return filepath;
    }
    if (CPLib.eqr("ritorno",p_cVarName)) {
      return ritorno;
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
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      pNomeFile = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("filepath",p_cVarName)) {
      filepath = value;
      return;
    }
    if (CPLib.eqr("ritorno",p_cVarName)) {
      ritorno = value;
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
    /* pNomeFile Char(100) // Nome File */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    /* nomefile Char(100) */
    /* filepath Char(100) */
    /* ritorno Char(256) */
    /* nomefile := "export/"+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile) */
    nomefile = "export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile);
    /* If FileLibMit.ExistFile(LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
    if (FileLibMit.ExistFile(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
      /* If FileLibMit.FileCopy(LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile),LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
      if (FileLibMit.FileCopy(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile),CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
        /* If FileLibMit.ExistFile(LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
        if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
          /* ritorno := LRTrim(gUrlApp)+LRTrim(nomefile) */
          ritorno = CPLib.LRTrim(gUrlApp)+CPLib.LRTrim(nomefile);
        } else { // Else
          /* ritorno := 'Errore. File non trovato nella cartella definitiva in : '+Chr(10)+Chr(13)+LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile) // ritorno della funzione */
          ritorno = "Errore. File non trovato nella cartella definitiva in : "+CPLib.Chr(10)+CPLib.Chr(13)+CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile);
        } // End If
      } else { // Else
        /* ritorno := 'Errore. Impossibile effettuare il trasferimento nella cartella definitiva da: '+Chr(10)+Chr(13)+LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile) // ritorno della funzione */
        ritorno = "Errore. Impossibile effettuare il trasferimento nella cartella definitiva da: "+CPLib.Chr(10)+CPLib.Chr(13)+CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile);
      } // End If
    } else { // Else
      /* If FileLibMit.ExistFile(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
      if (FileLibMit.ExistFile(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
        /* If FileLibMit.FileCopy(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile),LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
        if (FileLibMit.FileCopy(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile),CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
          /* If FileLibMit.ExistFile(LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
          if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile))) {
            /* ritorno := LRTrim(gUrlApp)+LRTrim(nomefile) */
            ritorno = CPLib.LRTrim(gUrlApp)+CPLib.LRTrim(nomefile);
          } else { // Else
            /* ritorno := 'Errore. File non trovato nella cartella definitiva in : '+Chr(10)+Chr(13)+LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile) // ritorno della funzione */
            ritorno = "Errore. File non trovato nella cartella definitiva in : "+CPLib.Chr(10)+CPLib.Chr(13)+CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile);
          } // End If
        } else { // Else
          /* ritorno := 'Errore. Impossibile effettuare il trasferimento nella cartella definitiva da: '+Chr(10)+Chr(13)+LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile) // ritorno della funzione */
          ritorno = "Errore. Impossibile effettuare il trasferimento nella cartella definitiva da: "+CPLib.Chr(10)+CPLib.Chr(13)+CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile);
        } // End If
      } // End If
    } // End If
    /* Return ritorno */
    throw new Stop(ritorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
  public String Run(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
  public static arrt_downloadxlsx_logR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_downloadxlsx_logR(p_Ctx, p_Caller);
  }
  public static arrt_downloadxlsx_logR Make(CPContext p_Ctx) {
    return new arrt_downloadxlsx_logR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNomeFile = CPLib.Space(100);
    nomefile = CPLib.Space(100);
    filepath = CPLib.Space(100);
    ritorno = CPLib.Space(256);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_downloadxlsx_log,
  public static final String i_InvokedRoutines = ",arrt_downloadxlsx_log,";
  public static String[] m_cRunParameterNames={"pNomeFile"};
}
