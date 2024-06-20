// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_val_beneficR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public String w_CONNESBEN;
  public String w_C_CAB;
  public String w_C_CAP;
  public String w_C_CTA;
  public String w_C_IND;
  public String w_C_PRV;
  public String w_C_RAG;
  public String w_C_STA;
  public String w_dessta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_val_beneficR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_val_benefic",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
      return "arrt_val_benefic";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNESBEN",p_cVarName)) {
      return w_CONNESBEN;
    }
    if (CPLib.eqr("C_CAB",p_cVarName)) {
      return w_C_CAB;
    }
    if (CPLib.eqr("C_CAP",p_cVarName)) {
      return w_C_CAP;
    }
    if (CPLib.eqr("C_CTA",p_cVarName)) {
      return w_C_CTA;
    }
    if (CPLib.eqr("C_IND",p_cVarName)) {
      return w_C_IND;
    }
    if (CPLib.eqr("C_PRV",p_cVarName)) {
      return w_C_PRV;
    }
    if (CPLib.eqr("C_RAG",p_cVarName)) {
      return w_C_RAG;
    }
    if (CPLib.eqr("C_STA",p_cVarName)) {
      return w_C_STA;
    }
    if (CPLib.eqr("dessta",p_cVarName)) {
      return w_dessta;
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
    if (CPLib.eqr("CONNESBEN",p_cVarName)) {
      w_CONNESBEN = value;
      return;
    }
    if (CPLib.eqr("C_CAB",p_cVarName)) {
      w_C_CAB = value;
      return;
    }
    if (CPLib.eqr("C_CAP",p_cVarName)) {
      w_C_CAP = value;
      return;
    }
    if (CPLib.eqr("C_CTA",p_cVarName)) {
      w_C_CTA = value;
      return;
    }
    if (CPLib.eqr("C_IND",p_cVarName)) {
      w_C_IND = value;
      return;
    }
    if (CPLib.eqr("C_PRV",p_cVarName)) {
      w_C_PRV = value;
      return;
    }
    if (CPLib.eqr("C_RAG",p_cVarName)) {
      w_C_RAG = value;
      return;
    }
    if (CPLib.eqr("C_STA",p_cVarName)) {
      w_C_STA = value;
      return;
    }
    if (CPLib.eqr("dessta",p_cVarName)) {
      w_dessta = value;
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
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* w_CONNESBEN Char(16) // Codice Cliente Occasionale */
      /* w_C_CAB Char(6) */
      /* w_C_CAP Char(5) */
      /* w_C_CTA Char(30) */
      /* w_C_IND Char(35) */
      /* w_C_PRV Char(2) */
      /* w_C_RAG Char(70) */
      /* w_C_STA Char(3) */
      /* w_dessta Char(40) */
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESBEN,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNESBEN)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* w_C_CAB := personbo->CODCAB */
        w_C_CAB = Cursor_personbo.GetString("CODCAB");
        /* w_C_CAP := Left(LRTrim(personbo->CAP),5) */
        w_C_CAP = CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
        /* w_C_CTA := personbo->DESCCIT */
        w_C_CTA = Cursor_personbo.GetString("DESCCIT");
        /* w_C_IND := personbo->DOMICILIO */
        w_C_IND = Cursor_personbo.GetString("DOMICILIO");
        /* w_C_PRV := personbo->PROVINCIA */
        w_C_PRV = Cursor_personbo.GetString("PROVINCIA");
        /* w_C_RAG := personbo->RAGSOC */
        w_C_RAG = Cursor_personbo.GetString("RAGSOC");
        /* w_C_STA := personbo->PAESE */
        w_C_STA = Cursor_personbo.GetString("PAESE");
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          w_dessta = Read_Cursor.GetString("DESCRI");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_val_benefic returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          w_dessta = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
      m_Caller.SetString("CONNESBEN","C",16,0,w_CONNESBEN);
      m_Caller.SetString("C_CAB","C",6,0,w_C_CAB);
      m_Caller.SetString("C_CAP","C",5,0,w_C_CAP);
      m_Caller.SetString("C_CTA","C",30,0,w_C_CTA);
      m_Caller.SetString("C_IND","C",35,0,w_C_IND);
      m_Caller.SetString("C_PRV","C",2,0,w_C_PRV);
      m_Caller.SetString("C_RAG","C",70,0,w_C_RAG);
      m_Caller.SetString("C_STA","C",3,0,w_C_STA);
      m_Caller.SetString("dessta","C",40,0,w_dessta);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_val_beneficR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_val_beneficR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CONNESBEN = m_Caller.GetString("CONNESBEN","C",16,0);
    w_C_CAB = m_Caller.GetString("C_CAB","C",6,0);
    w_C_CAP = m_Caller.GetString("C_CAP","C",5,0);
    w_C_CTA = m_Caller.GetString("C_CTA","C",30,0);
    w_C_IND = m_Caller.GetString("C_IND","C",35,0);
    w_C_PRV = m_Caller.GetString("C_PRV","C",2,0);
    w_C_RAG = m_Caller.GetString("C_RAG","C",70,0);
    w_C_STA = m_Caller.GetString("C_STA","C",3,0);
    w_dessta = m_Caller.GetString("dessta","C",40,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
