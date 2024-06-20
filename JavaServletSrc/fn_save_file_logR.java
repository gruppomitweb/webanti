// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class fn_save_file_logR implements CallerWithObjs {
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
  public String Messaggio;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public fn_save_file_logR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("fn_save_file_log",m_Caller);
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
      return "fn_save_file_log";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("Messaggio",p_cVarName)) {
      return Messaggio;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("Messaggio",p_cVarName)) {
      Messaggio = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    /* Messaggio Memo // Parametro con il contenuto del messaggio da salvare sul file */
    /* gPathApp Char(80) // Path Applicazione */
    /* _datatime Char(0) := LRTrim(DateTimeToChar(DateTime())) // datatime */
    String _datatime;
    _datatime = CPLib.LRTrim(CPLib.DateTimeToChar(CPLib.DateTime()));
    /* cOnlyNomeFile Char(0) := LRTrim('log_'+_datatime+'.txt') // Solo nome del file txt */
    String cOnlyNomeFile;
    cOnlyNomeFile = CPLib.LRTrim("log_"+_datatime+".txt");
    /* cNomeFile Char(0) := LRTrim(gPathApp)+'/appo/'+cOnlyNomeFile // file da inserire nello zip */
    String cNomeFile;
    cNomeFile = CPLib.LRTrim(gPathApp)+"/appo/"+cOnlyNomeFile;
    /* cNomeFileZip Char(0) := Strtran(cNomeFile,'.txt','.zip') // percorso più il nome del file zip */
    String cNomeFileZip;
    cNomeFileZip = CPLib.Strtran(cNomeFile,".txt",".zip");
    /* fhand Char(0) := FileLibMit.OpenWritePath(LRTrim(cNomeFile)) // Creo il file */
    String fhand;
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(cNomeFile));
    /* nrec Numeric(0, 0) := FileLibMit.Write(fhand,Messaggio) // numero di rige scritte */
    double nrec;
    nrec = CPLib.Round(FileLibMit.Write(fhand,Messaggio),0);
    /* close Bool := FileLibMit.Close(fhand) // numero di rige scritte */
    boolean close;
    close = FileLibMit.Close(fhand);
    /* mcCella MemoryCursor(mcCellaExcel.MCRDef) // Lista dei file da zippare */
    MemoryCursor_mccellaexcel_mcrdef mcCella;
    mcCella = new MemoryCursor_mccellaexcel_mcrdef();
    /* mcCella.AppendBlank() // Lista dei file da zippare */
    mcCella.AppendBlank();
    /* mcCella.memo := cNomeFile // Lista dei file da zippare */
    mcCella.row.memo = cNomeFile;
    /* mcCella.SaveRow() // Lista dei file da zippare */
    mcCella.SaveRow();
    /* objzipmit Object(ZipMit) // Oggetto per la creazione dello zip */
    ZipMit objzipmit;
    objzipmit = null;
    /* objzipmit := new ZipMit() // Oggetto per la creazione dello zip */
    objzipmit = new ZipMit();
    /* objzipmit.setMcCelle(mcCella) // Oggetto per la creazione dello zip */
    objzipmit.setMcCelle(mcCella);
    /* objzipmit.zip(cNomeFileZip) // Oggetto per la creazione dello zip */
    objzipmit.zip(cNomeFileZip);
    /* Return iif(FileLibMit.ExistFile(cNomeFileZip),cNomeFileZip,'') // Ritorno il nome del file generato */
    throw new Stop((FileLibMit.ExistFile(cNomeFileZip)?cNomeFileZip:""));
  }
  void _init_() {
  }
  public String RunAsync(String p_Messaggio) {
    Messaggio = p_Messaggio;
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
  public String Run(String p_Messaggio) {
    Messaggio = p_Messaggio;
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
  public static fn_save_file_logR Make(CPContext p_Ctx, Caller p_Caller) {
    return new fn_save_file_logR(p_Ctx, p_Caller);
  }
  public static fn_save_file_logR Make(CPContext p_Ctx) {
    return new fn_save_file_logR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    Messaggio = "";
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,fn_save_file_log,
  public static final String i_InvokedRoutines = ",fn_save_file_log,";
  public static String[] m_cRunParameterNames={"Messaggio"};
}
