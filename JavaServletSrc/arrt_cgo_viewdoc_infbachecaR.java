// * --- Area Manuale = BO - Header
// * --- arrt_cgo_viewdoc_infbacheca
import org.apache.commons.io.FilenameUtils;
// * --- Fine Area Manuale
public class arrt_cgo_viewdoc_infbachecaR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public double pCodice;
  public String pDoc;
  public String gPathApp;
  public String gUrlApp;
  public String _pathdoc;
  public String _nomedoc;
  public String _doctype;
  public String _pathfile;
  public String _urlfinale;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_viewdoc_infbachecaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_viewdoc_infbacheca",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pCodice",p_cVarName)) {
      return pCodice;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_viewdoc_infbacheca";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pDoc",p_cVarName)) {
      return pDoc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      return _pathdoc;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      return _nomedoc;
    }
    if (CPLib.eqr("_doctype",p_cVarName)) {
      return _doctype;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      return _pathfile;
    }
    if (CPLib.eqr("_urlfinale",p_cVarName)) {
      return _urlfinale;
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
    if (CPLib.eqr("pCodice",p_cVarName)) {
      pCodice = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pDoc",p_cVarName)) {
      pDoc = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      _pathdoc = value;
      return;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      _nomedoc = value;
      return;
    }
    if (CPLib.eqr("_doctype",p_cVarName)) {
      _doctype = value;
      return;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      _pathfile = value;
      return;
    }
    if (CPLib.eqr("_urlfinale",p_cVarName)) {
      _urlfinale = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* pCodice Numeric(10, 0) // Numero Avviso */
      /* pDoc Char(128) // Nome Documento */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _pathdoc Char(128) */
      /* _nomedoc Char(128) */
      /* _doctype Char(10) */
      /* _pathfile Char(0) */
      /* _urlfinale Char(0) */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PATHDOCBAC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _pathdoc := intermbo->PATHDOCBAC */
        _pathdoc = Cursor_intermbo.GetString("PATHDOCBAC");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _doctype := Lower(FilenameUtils.getExtension(LRTrim(pDoc))) */
      _doctype = CPLib.Lower(FilenameUtils.getExtension(CPLib.LRTrim(pDoc)));
      /* _pathfile := LRTrim(_pathdoc)+"/"+LRTrim(Str(pCodice,10,0))+"/"+LRTrim(pDoc) */
      _pathfile = CPLib.LRTrim(_pathdoc)+"/"+CPLib.LRTrim(CPLib.Str(pCodice,10,0))+"/"+CPLib.LRTrim(pDoc);
      /* If FileLibMit.ExistFile(_pathfile) and not(FileLibMit.ExistFile(LRTrim(gPathApp)+"/bacheca/"+LRTrim(Str(pCodice,10,0))+"/"+LRTrim(pDoc))) */
      if (FileLibMit.ExistFile(_pathfile) &&  ! (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/bacheca/"+CPLib.LRTrim(CPLib.Str(pCodice,10,0))+"/"+CPLib.LRTrim(pDoc)))) {
        /* FileLibMit.CreateDirPath(LRTrim(gPathApp)+"/bacheca/"+LRTrim(Str(pCodice,10,0))) */
        FileLibMit.CreateDirPath(CPLib.LRTrim(gPathApp)+"/bacheca/"+CPLib.LRTrim(CPLib.Str(pCodice,10,0)));
        /* FileLibMit.FileCopyPath(_pathfile,LRTrim(gPathApp)+"/bacheca/"+LRTrim(Str(pCodice,10,0))+"/"+LRTrim(pDoc)) */
        FileLibMit.FileCopyPath(_pathfile,CPLib.LRTrim(gPathApp)+"/bacheca/"+CPLib.LRTrim(CPLib.Str(pCodice,10,0))+"/"+CPLib.LRTrim(pDoc));
      } // End If
      /* _urlfinale := LRTrim(gUrlApp)+"bacheca/"+LRTrim(Str(pCodice,10,0))+"/"+LibreriaMit.URL_enc(LRTrim(pDoc)) */
      _urlfinale = CPLib.LRTrim(gUrlApp)+"bacheca/"+CPLib.LRTrim(CPLib.Str(pCodice,10,0))+"/"+LibreriaMit.URL_enc(CPLib.LRTrim(pDoc));
      /* Stop _urlfinale */
      Forward f;
      f=new Forward(_urlfinale,false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pCodice,String p_pDoc) {
    pCodice = p_pCodice;
    pDoc = p_pDoc;
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
  public Forward Run(double p_pCodice,String p_pDoc) {
    pCodice = p_pCodice;
    pDoc = p_pDoc;
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
  public static arrt_cgo_viewdoc_infbachecaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_viewdoc_infbachecaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pCodice = 0;
    pDoc = CPLib.Space(128);
    _pathdoc = CPLib.Space(128);
    _nomedoc = CPLib.Space(128);
    _doctype = CPLib.Space(10);
    _pathfile = CPLib.Space(0);
    _urlfinale = CPLib.Space(0);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pCodice","pDoc"};
}
