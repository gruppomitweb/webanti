// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_clsdelegheR implements CallerWithObjs {
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
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aedestor;
  public String m_cServer_aedestor;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
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
  public java.sql.Date w_datarett;
  public String w_oldidbase;
  public String w_oldprog;
  public String w_oldrappo;
  public String w_oldfile;
  public String _coint;
  public String _tipage;
  public String cProg;
  public String cCanc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_clsdelegheR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_clsdeleghe",m_Caller);
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aedestor = p_ContextObject.GetPhName("aedestor");
    if (m_cPhName_aedestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedestor = m_cPhName_aedestor+" "+m_Ctx.GetWritePhName("aedestor");
    }
    m_cServer_aedestor = p_ContextObject.GetServer("aedestor");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
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
      return "arrt_clsdeleghe";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("oldidbase",p_cVarName)) {
      return w_oldidbase;
    }
    if (CPLib.eqr("oldprog",p_cVarName)) {
      return w_oldprog;
    }
    if (CPLib.eqr("oldrappo",p_cVarName)) {
      return w_oldrappo;
    }
    if (CPLib.eqr("oldfile",p_cVarName)) {
      return w_oldfile;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      return _tipage;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      return w_datarett;
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
    if (CPLib.eqr("oldidbase",p_cVarName)) {
      w_oldidbase = value;
      return;
    }
    if (CPLib.eqr("oldprog",p_cVarName)) {
      w_oldprog = value;
      return;
    }
    if (CPLib.eqr("oldrappo",p_cVarName)) {
      w_oldrappo = value;
      return;
    }
    if (CPLib.eqr("oldfile",p_cVarName)) {
      w_oldfile = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      _tipage = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      w_datarett = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aederig=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_datarett Date */
      /* w_oldidbase Char(10) */
      /* w_oldprog Char(15) */
      /* w_oldrappo Char(25) */
      /* w_oldfile Char(15) */
      /* Definizione variabili locali */
      /* _coint Char(1) */
      /* _tipage Char(2) */
      /* cProg Char(10) */
      /* cCanc Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* Verifica se deve modificare qualcosa */
      /* If not(Empty(w_datarett)) */
      if ( ! (CPLib.Empty(w_datarett))) {
        /* _coint := '' */
        _coint = "";
        /* _tipage := '' */
        _tipage = "";
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"C",25,0,m_cServer),m_cServer,w_oldrappo);
        m_cSql = m_cSql+" and IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldidbase,"C",10,0,m_cServer),m_cServer,w_oldidbase);
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipage = Read_Cursor.GetString("TIPOAG");
          _coint = Read_Cursor.GetString("COINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_clsdeleghe returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipage = "";
          _coint = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(w_oldprog)) */
        if ( ! (CPLib.Empty(w_oldprog))) {
          // * --- Select from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          if (Cursor_aederig!=null)
            Cursor_aederig.Close();
          Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldrappo)+"  and  IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldidbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldidbase)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aederig.Eof())) {
            /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aedestor from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aedestor");
            m_cPhName = m_Ctx.GetPhName("aedestor");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedestor",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_clsdeleghe",42,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aedestor",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aedecanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aedecanc");
            m_cPhName = m_Ctx.GetPhName("aedecanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedecanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_clsdeleghe",42,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_datarett,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_datarett,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aedecanc",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            Cursor_aederig.Next();
          }
          m_cConnectivityError = Cursor_aederig.ErrorMessage();
          Cursor_aederig.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
      m_Caller.SetDate("datarett","D",8,0,w_datarett);
      m_Caller.SetString("oldidbase","C",10,0,w_oldidbase);
      m_Caller.SetString("oldprog","C",15,0,w_oldprog);
      m_Caller.SetString("oldrappo","C",25,0,w_oldrappo);
      m_Caller.SetString("oldfile","C",15,0,w_oldfile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_clsdelegheR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_clsdelegheR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_datarett = m_Caller.GetDate("datarett","D",8,0);
    w_oldidbase = m_Caller.GetString("oldidbase","C",10,0);
    w_oldprog = m_Caller.GetString("oldprog","C",15,0);
    w_oldrappo = m_Caller.GetString("oldrappo","C",25,0);
    w_oldfile = m_Caller.GetString("oldfile","C",15,0);
    _coint = CPLib.Space(1);
    _tipage = CPLib.Space(2);
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aedestor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aedecanc",true);
    return p_cSql;
  }
}
