// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_loadtransR implements CallerWithObjs {
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
  public String m_cPhName_att_ric;
  public String m_cServer_att_ric;
  public String m_cPhName_vocinotaspese;
  public String m_cServer_vocinotaspese;
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
  public String pRapporto;
  public String w_RigheAgg;
  public String w_RAPPORTO;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_loadtransR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_loadtrans",m_Caller);
    m_cPhName_att_ric = p_ContextObject.GetPhName("att_ric");
    if (m_cPhName_att_ric.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_att_ric = m_cPhName_att_ric+" "+m_Ctx.GetWritePhName("att_ric");
    }
    m_cServer_att_ric = p_ContextObject.GetServer("att_ric");
    m_cPhName_vocinotaspese = p_ContextObject.GetPhName("vocinotaspese");
    if (m_cPhName_vocinotaspese.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vocinotaspese = m_cPhName_vocinotaspese+" "+m_Ctx.GetWritePhName("vocinotaspese");
    }
    m_cServer_vocinotaspese = p_ContextObject.GetServer("vocinotaspese");
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
      return "arfn_loadtrans";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("RigheAgg",p_cVarName)) {
      return w_RigheAgg;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
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
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      pRapporto = value;
      return;
    }
    if (CPLib.eqr("RigheAgg",p_cVarName)) {
      w_RigheAgg = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
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
    CPResultSet Cursor_qbe_loadbodyinfo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pRapporto Char(25) // Codice Rapporto */
      /* w_RigheAgg Memo */
      /* w_RAPPORTO Char(25) */
      /* w_RigheAgg := '' */
      w_RigheAgg = "";
      /* w_RAPPORTO := pRapporto */
      w_RAPPORTO = pRapporto;
      // * --- Select from qbe_loadbodyinfo
      if (Cursor_qbe_loadbodyinfo!=null)
        Cursor_qbe_loadbodyinfo.Close();
      Cursor_qbe_loadbodyinfo = new VQRHolder("qbe_loadbodyinfo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_loadbodyinfo.Eof())) {
        /* w_RigheAgg := w_RigheAgg+LRTrim(qbe_loadbodyinfo->CODINTER)+'|'+LRTrim(DateToChar(qbe_loadbodyinfo->DATAINI))+"|"+LRTrim(qbe_loadbodyinfo->TIPOPERS)+"$" */
        w_RigheAgg = w_RigheAgg+CPLib.LRTrim(Cursor_qbe_loadbodyinfo.GetString("CODINTER"))+"|"+CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_loadbodyinfo.GetDate("DATAINI")))+"|"+CPLib.LRTrim(Cursor_qbe_loadbodyinfo.GetString("TIPOPERS"))+"$";
        Cursor_qbe_loadbodyinfo.Next();
      }
      m_cConnectivityError = Cursor_qbe_loadbodyinfo.ErrorMessage();
      Cursor_qbe_loadbodyinfo.Close();
      // * --- End Select
      /* w_RigheAgg := Left(w_RigheAgg,Len(w_RigheAgg) - 1) */
      w_RigheAgg = CPLib.Left(w_RigheAgg,CPLib.Len(w_RigheAgg)-1);
      /* Return w_RigheAgg */
      throw new Stop(w_RigheAgg);
    } finally {
      try {
        if (Cursor_qbe_loadbodyinfo!=null)
          Cursor_qbe_loadbodyinfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pRapporto) {
    pRapporto = p_pRapporto;
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
  public String Run(String p_pRapporto) {
    pRapporto = p_pRapporto;
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
  public static arfn_loadtransR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_loadtransR(p_Ctx, p_Caller);
  }
  public static arfn_loadtransR Make(CPContext p_Ctx) {
    return new arfn_loadtransR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(25);
    w_RigheAgg = "";
    w_RAPPORTO = CPLib.Space(25);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_loadbodyinfo,
  public static final String m_cVQRList = ",qbe_loadbodyinfo,";
  // ENTITY_BATCHES: ,arfn_loadtrans,
  public static final String i_InvokedRoutines = ",arfn_loadtrans,";
  public static String[] m_cRunParameterNames={"pRapporto"};
}
