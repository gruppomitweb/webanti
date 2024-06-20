// * --- Area Manuale = BO - Header
// * --- arfn_scarti_import
import java.io.File; 
import java.lang.Double;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
// * --- Fine Area Manuale
public class arfn_scarti_importR implements CallerWithObjs {
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
  public MemoryCursor_tmp_listafile mcLista;
  public String _nomedir;
  public String gPathDoc;
  public String gAzienda;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_scarti_importR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_scarti_import",m_Caller);
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
      return "arfn_scarti_import";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_nomedir",p_cVarName)) {
      return _nomedir;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
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
    if (CPLib.eqr("mcLista",p_cVarName)) {
      return mcLista;
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
    if (CPLib.eqr("_nomedir",p_cVarName)) {
      _nomedir = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("mcLista",p_cVarName)) {
      mcLista = (MemoryCursor_tmp_listafile)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* mcLista MemoryCursor(tmp_listafile) */
    /* _nomedir Char(128) */
    /* gPathDoc Char(128) // Path Documenti */
    /* gAzienda Char(10) // Azienda */
    /* gUrlApp Char(80) // URL Applicazione */
    /* mcLista.Zap() */
    mcLista.Zap();
    /* _nomedir := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda) */
    _nomedir = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda);
    // Legge la cartella e trova i documenti presenti
    File dir = new File(_nomedir);
    String[] children = dir.list();
    if (children != null) {
       for (int i=0; i < children.length; i++) {
           String filename = children[i];
    /* If At("ERRTRX",Upper(filename)) > 0 or At("ERRPOS",Upper(filename)) > 0 or At("Errori_TRX",Upper(filename)) > 0 or At("Errori_POS",Upper(filename)) > 0 */
    if (CPLib.gt(CPLib.At("ERRTRX",CPLib.Upper(filename)),0) || CPLib.gt(CPLib.At("ERRPOS",CPLib.Upper(filename)),0) || CPLib.gt(CPLib.At("Errori_TRX",CPLib.Upper(filename)),0) || CPLib.gt(CPLib.At("Errori_POS",CPLib.Upper(filename)),0)) {
      /* mcLista.AppendBlank() */
      mcLista.AppendBlank();
      /* mcLista.nomefile := LRTrim(filename) */
      mcLista.row.nomefile = CPLib.LRTrim(filename);
      /* mcLista.hyperlynk := LRTrim(gUrlApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(filename) */
      mcLista.row.hyperlynk = CPLib.LRTrim(gUrlApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(filename);
      /* mcLista.SaveRow() */
      mcLista.SaveRow();
    } // End If
    //Chiude l'area manuale
      }
    }
    /* Return mcLista */
    throw new Stop(mcLista);
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
  public MemoryCursor_tmp_listafile Run() {
    MemoryCursor_tmp_listafile l_result;
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
        l_result = (MemoryCursor_tmp_listafile)stop_value.GetObject();
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
  public static arfn_scarti_importR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_scarti_importR(p_Ctx, p_Caller);
  }
  public static arfn_scarti_importR Make(CPContext p_Ctx) {
    return new arfn_scarti_importR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcLista = new MemoryCursor_tmp_listafile();
    _nomedir = CPLib.Space(128);
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_scarti_import,
  public static final String i_InvokedRoutines = ",arfn_scarti_import,";
  public static String[] m_cRunParameterNames={};
}
