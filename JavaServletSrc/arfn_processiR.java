// * --- Area Manuale = BO - Header
// * --- arfn_processi
import java.io.*;
// * --- Fine Area Manuale
public class arfn_processiR implements CallerWithObjs {
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
  public String m_cPhName_processi;
  public String m_cServer_processi;
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
  public MemoryCursor_processi mcProcessi;
  public String _directory;
  public String _nomeorig;
  public String _tipo;
  public String _codice;
  public String fhand;
  public String _testo;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_processiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_processi",m_Caller);
    m_cPhName_processi = p_ContextObject.GetPhName("processi");
    if (m_cPhName_processi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_processi = m_cPhName_processi+" "+m_Ctx.GetWritePhName("processi");
    }
    m_cServer_processi = p_ContextObject.GetServer("processi");
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
      return "arfn_processi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_directory",p_cVarName)) {
      return _directory;
    }
    if (CPLib.eqr("_nomeorig",p_cVarName)) {
      return _nomeorig;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_codice",p_cVarName)) {
      return _codice;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
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
    if (CPLib.eqr("mcProcessi",p_cVarName)) {
      return mcProcessi;
    }
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
    if (CPLib.eqr("_directory",p_cVarName)) {
      _directory = value;
      return;
    }
    if (CPLib.eqr("_nomeorig",p_cVarName)) {
      _nomeorig = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_codice",p_cVarName)) {
      _codice = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
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
    if (CPLib.eqr("mcProcessi",p_cVarName)) {
      mcProcessi = (MemoryCursor_processi)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_processi=null;
    try {
      /* mcProcessi MemoryCursor(processi) */
      /* _directory Char(200) */
      /* _nomeorig Char(150) */
      /* _tipo Char(3) */
      /* _codice Char(10) */
      /* fhand Char(10) */
      /* _testo Char(128) */
      /* gPathApp Char(80) // Path Applicazione */
      // * --- Select from processi
      m_cServer = m_Ctx.GetServer("processi");
      m_cPhName = m_Ctx.GetPhName("processi");
      if (Cursor_processi!=null)
        Cursor_processi.Close();
      Cursor_processi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("processi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"PRCODICE desc ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_processi.Eof())) {
        /* mcProcessi.AppendWithKey(processi->PRCODICE) */
        mcProcessi.AppendWithKey(Cursor_processi.GetString("PRCODICE"));
        /* mcProcessi.PR_TIPO := processi->PR_TIPO */
        mcProcessi.row.PR_TIPO = Cursor_processi.GetString("PR_TIPO");
        /* mcProcessi.PRCODICE := processi->PRCODICE */
        mcProcessi.row.PRCODICE = Cursor_processi.GetString("PRCODICE");
        /* mcProcessi.PRDESCRI := processi->PRDESCRI */
        mcProcessi.row.PRDESCRI = Cursor_processi.GetString("PRDESCRI");
        /* mcProcessi.PRDOSTART := processi->PRDOSTART */
        mcProcessi.row.PRDOSTART = Cursor_processi.GetDateTime("PRDOSTART");
        /* mcProcessi.PRDOSTOP := processi->PRDOSTOP */
        mcProcessi.row.PRDOSTOP = Cursor_processi.GetDateTime("PRDOSTOP");
        /* mcProcessi.PRESITO := processi->PRESITO */
        mcProcessi.row.PRESITO = Cursor_processi.GetString("PRESITO");
        /* mcProcessi.PRFILEOUT := processi->PRFILEOUT */
        mcProcessi.row.PRFILEOUT = Cursor_processi.GetString("PRFILEOUT");
        /* mcProcessi.PTRIPOOUT := processi->PTRIPOOUT */
        mcProcessi.row.PTRIPOOUT = Cursor_processi.GetString("PTRIPOOUT");
        /* mcProcessi.PRGMSGSTA := processi->PRGMSGSTA */
        mcProcessi.row.PRGMSGSTA = Cursor_processi.GetString("PRGMSGSTA");
        /* mcProcessi.PRNOMEFILE := processi->PRNOMEFILE */
        mcProcessi.row.PRNOMEFILE = Cursor_processi.GetString("PRNOMEFILE");
        /* mcProcessi.SaveRow() */
        mcProcessi.SaveRow();
        Cursor_processi.Next();
      }
      m_cConnectivityError = Cursor_processi.ErrorMessage();
      Cursor_processi.Close();
      // * --- End Select
      /* _directory := gPathApp+"/processi" */
      _directory = gPathApp+"/processi";
      // Legge la cartella e trova la directory corretta
      File dir = new File(_directory);
          File[] files = dir.listFiles();
          if (files != null) {
            for (File file: files) {
      /* _testo := '' */
      _testo = "";
      /* _nomeorig := file.getName() */
      _nomeorig = file.getName();
      /* _tipo := Left(_nomeorig,3) */
      _tipo = CPLib.Left(_nomeorig,3);
      /* _codice := Substr(_nomeorig,4,10) */
      _codice = CPLib.Substr(_nomeorig,4,10);
      /* fhand := FileLibMit.OpenRead('./processi/'+LRTrim(_nomeorig)) */
      fhand = FileLibMit.OpenRead("./processi/"+CPLib.LRTrim(_nomeorig));
      /* _testo := FileLibMit.ReadLine(fhand) */
      _testo = FileLibMit.ReadLine(fhand);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* If mcProcessi.GoToKey(_codice) */
      if (mcProcessi.GoToKey(_codice)) {
        /* mcProcessi.PRGMSGSTA := LRTrim(_testo) */
        mcProcessi.row.PRGMSGSTA = CPLib.LRTrim(_testo);
        /* mcProcessi.SaveRow() */
        mcProcessi.SaveRow();
      } // End If
      // Legge la cartella e trova la directory corretta
      }
      }
      /* Return mcProcessi */
      throw new Stop(mcProcessi);
    } finally {
      try {
        if (Cursor_processi!=null)
          Cursor_processi.Close();
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
  public MemoryCursor_processi Run() {
    MemoryCursor_processi l_result;
    l_result = null;
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
        l_result = (MemoryCursor_processi)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_processiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_processiR(p_Ctx, p_Caller);
  }
  public static arfn_processiR Make(CPContext p_Ctx) {
    return new arfn_processiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcProcessi = new MemoryCursor_processi();
    _directory = CPLib.Space(200);
    _nomeorig = CPLib.Space(150);
    _tipo = CPLib.Space(3);
    _codice = CPLib.Space(10);
    fhand = CPLib.Space(10);
    _testo = CPLib.Space(128);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_processi,
  public static final String i_InvokedRoutines = ",arfn_processi,";
  public static String[] m_cRunParameterNames={};
}
