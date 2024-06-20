// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_edtrapotitR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
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
  public String w_IDBASE;
  public String w_OPERAZMOD;
  public java.sql.Date w_DATARETT;
  public java.sql.Date w_DATAOPE;
  public String w_NUMPROG;
  public String w_IDEREG;
  public String w_IDBASE2;
  public String w_STATOREG;
  public String gSblocco;
  public String gAzienda;
  public java.sql.Date gDataVaria;
  public String cNewProg;
  public String _idreg;
  public String _flagrap2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_edtrapotitR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_edtrapotit",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
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
      return "arrt_edtrapotit";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("OPERAZMOD",p_cVarName)) {
      return w_OPERAZMOD;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("IDEREG",p_cVarName)) {
      return w_IDEREG;
    }
    if (CPLib.eqr("IDBASE2",p_cVarName)) {
      return w_IDBASE2;
    }
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      return w_STATOREG;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
    }
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      return w_DATAOPE;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
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
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("OPERAZMOD",p_cVarName)) {
      w_OPERAZMOD = value;
      return;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("IDEREG",p_cVarName)) {
      w_IDEREG = value;
      return;
    }
    if (CPLib.eqr("IDBASE2",p_cVarName)) {
      w_IDBASE2 = value;
      return;
    }
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      w_STATOREG = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
      return;
    }
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      w_DATAOPE = value;
      return;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
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
    CPResultSet Cursor_rapotit=null;
    try {
      /* Variabili del caller */
      /* w_IDBASE Char(10) // Idbase */
      /* w_OPERAZMOD Char(20) // Operazione Modificata */
      /* w_DATARETT Date */
      /* w_DATAOPE Date */
      /* w_NUMPROG Char(11) */
      /* w_IDEREG Char(20) */
      /* w_IDBASE2 Char(10) // Idbase */
      /* w_STATOREG Char(10) // Idbase */
      /* Nuovo Progressivo */
      /* gSblocco Char(1) // Sblocco controllo */
      /* gAzienda Char(10) // Azienda */
      /* gDataVaria Date // Data Variazione */
      /* cNewProg Char(10) */
      /* _idreg Char(20) */
      /* _flagrap2 Char(1) */
      /* Legge il vecchio record e ne crea uno nuovo */
      /* If gSblocco='N' */
      if (CPLib.eqr(gSblocco,"N")) {
        /* cNewProg := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
        cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
        // * --- Select from rapotit
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
        Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapotit.Eof())) {
          /* _flagrap2 := iif(Empty(rapotit->FLAGRAP2),'5',Str(Val(rapotit->FLAGRAP2)+1,1,0)) */
          _flagrap2 = (CPLib.Empty(Cursor_rapotit.GetString("FLAGRAP2"))?"5":CPLib.Str(CPLib.Val(Cursor_rapotit.GetString("FLAGRAP2"))+1,1,0));
          // * --- Insert into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_edtrapotit",60,"00000016")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000016(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAAGE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
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
          /* w_OPERAZMOD := rapotit->IDEREG // Operazione Modificata */
          w_OPERAZMOD = Cursor_rapotit.GetString("IDEREG");
          /* w_IDBASE2 := LibreriaMit.UniqueId() // Idbase */
          w_IDBASE2 = LibreriaMit.UniqueId();
          /* w_IDEREG := 'T'+Right(w_NUMPROG,9)+w_IDBASE2 */
          w_IDEREG = "T"+CPLib.Right(w_NUMPROG,9)+w_IDBASE2;
          /* w_DATARETT := Date() */
          w_DATARETT = CPLib.Date();
          /* w_STATOREG := '1' // Idbase */
          w_STATOREG = "1";
          Cursor_rapotit.Next();
        }
        m_cConnectivityError = Cursor_rapotit.ErrorMessage();
        Cursor_rapotit.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("OPERAZMOD","C",20,0,w_OPERAZMOD);
      m_Caller.SetDate("DATARETT","D",8,0,w_DATARETT);
      m_Caller.SetDate("DATAOPE","D",8,0,w_DATAOPE);
      m_Caller.SetString("NUMPROG","C",11,0,w_NUMPROG);
      m_Caller.SetString("IDEREG","C",20,0,w_IDEREG);
      m_Caller.SetString("IDBASE2","C",10,0,w_IDBASE2);
      m_Caller.SetString("STATOREG","C",10,0,w_STATOREG);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_edtrapotitR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_edtrapotitR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_OPERAZMOD = m_Caller.GetString("OPERAZMOD","C",20,0);
    w_DATARETT = m_Caller.GetDate("DATARETT","D",8,0);
    w_DATAOPE = m_Caller.GetDate("DATAOPE","D",8,0);
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",11,0);
    w_IDEREG = m_Caller.GetString("IDEREG","C",20,0);
    w_IDBASE2 = m_Caller.GetString("IDBASE2","C",10,0);
    w_STATOREG = m_Caller.GetString("STATOREG","C",10,0);
    cNewProg = CPLib.Space(10);
    _idreg = CPLib.Space(20);
    _flagrap2 = CPLib.Space(1);
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000016(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
}
