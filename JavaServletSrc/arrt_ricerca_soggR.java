// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_ricerca_soggR implements CallerWithObjs {
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
  public String m_cPhName_webaos_soggetti;
  public String m_cServer_webaos_soggetti;
  public String m_cPhName_tmp_seek_sogg;
  public String m_cServer_tmp_seek_sogg;
  public String m_cPhName_webaos_tbspec;
  public String m_cServer_webaos_tbspec;
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
  public String w_criterio;
  public String w_denomin;
  public String w_codfisc;
  public String w_simili;
  public String w_flgnega;
  public String w_flgnote;
  public double _conta;
  public String _denom;
  public String _specseg;
  public java.sql.Date gDatTER;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_ricerca_soggR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_ricerca_sogg",m_Caller);
    m_cPhName_webaos_soggetti = p_ContextObject.GetPhName("webaos_soggetti");
    if (m_cPhName_webaos_soggetti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_soggetti = m_cPhName_webaos_soggetti+" "+m_Ctx.GetWritePhName("webaos_soggetti");
    }
    m_cServer_webaos_soggetti = p_ContextObject.GetServer("webaos_soggetti");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
      m_cPhName_tmp_seek_sogg = p_ContextObject.GetPhName("tmp_seek_sogg");
      if (m_cPhName_tmp_seek_sogg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_seek_sogg = m_cPhName_tmp_seek_sogg+" "+m_Ctx.GetWritePhName("tmp_seek_sogg");
      }
      m_cServer_tmp_seek_sogg = p_ContextObject.GetServer("tmp_seek_sogg");
    }
    m_cPhName_webaos_tbspec = p_ContextObject.GetPhName("webaos_tbspec");
    if (m_cPhName_webaos_tbspec.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_tbspec = m_cPhName_webaos_tbspec+" "+m_Ctx.GetWritePhName("webaos_tbspec");
    }
    m_cServer_webaos_tbspec = p_ContextObject.GetServer("webaos_tbspec");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_ricerca_sogg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("criterio",p_cVarName)) {
      return w_criterio;
    }
    if (CPLib.eqr("denomin",p_cVarName)) {
      return w_denomin;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      return w_codfisc;
    }
    if (CPLib.eqr("simili",p_cVarName)) {
      return w_simili;
    }
    if (CPLib.eqr("flgnega",p_cVarName)) {
      return w_flgnega;
    }
    if (CPLib.eqr("flgnote",p_cVarName)) {
      return w_flgnote;
    }
    if (CPLib.eqr("_denom",p_cVarName)) {
      return _denom;
    }
    if (CPLib.eqr("_specseg",p_cVarName)) {
      return _specseg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      return gDatTER;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("criterio",p_cVarName)) {
      w_criterio = value;
      return;
    }
    if (CPLib.eqr("denomin",p_cVarName)) {
      w_denomin = value;
      return;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      w_codfisc = value;
      return;
    }
    if (CPLib.eqr("simili",p_cVarName)) {
      w_simili = value;
      return;
    }
    if (CPLib.eqr("flgnega",p_cVarName)) {
      w_flgnega = value;
      return;
    }
    if (CPLib.eqr("flgnote",p_cVarName)) {
      w_flgnote = value;
      return;
    }
    if (CPLib.eqr("_denom",p_cVarName)) {
      _denom = value;
      return;
    }
    if (CPLib.eqr("_specseg",p_cVarName)) {
      _specseg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      gDatTER = value;
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
    CPResultSet Cursor_webaos_soggetti=null;
    CPResultSet Read_Cursor=null;
    try {
      /* w_criterio Char(1) */
      /* w_denomin Char(60) */
      /* w_codfisc Char(16) */
      /* w_simili Char(60) */
      /* w_flgnega Char(1) */
      /* w_flgnote Char(1) */
      /* _conta Numeric(10, 0) */
      /* _denom Char(80) */
      /* _specseg Char(100) */
      /* gDatTER Date // Ultimo Aggiornamento TER */
      /* Crea tabella appoggio */
      // * --- Drop temporary table tmp_seek_sogg
      if (m_Ctx.IsSharedTemp("tmp_seek_sogg")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_seek_sogg");
      }
      // * --- Create temporary table tmp_seek_sogg
      if (m_Ctx.IsSharedTemp("tmp_seek_sogg")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_seek_sogg");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_seek_sogg");
      if ( ! (m_Ctx.IsSharedTemp("tmp_seek_sogg"))) {
        m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_seek_sogg",m_cServer,"proto")),m_cPhName,"tmp_seek_sogg",m_Ctx);
      }
      m_cPhName_tmp_seek_sogg = m_cPhName;
      /* Seleziona in base alla tipologia */
      /* Case w_criterio='D' */
      if (CPLib.eqr(w_criterio,"D")) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _denom := '%'+LRTrim(w_denomin)+'%' */
        _denom = "%"+CPLib.LRTrim(w_denomin)+"%";
        // * --- Select from webaos_soggetti
        m_cServer = m_Ctx.GetServer("webaos_soggetti");
        m_cPhName = m_Ctx.GetPhName("webaos_soggetti");
        if (Cursor_webaos_soggetti!=null)
          Cursor_webaos_soggetti.Close();
        Cursor_webaos_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAGSOC like "+CPSql.SQLValueAdapter(CPLib.ToSQL(_denom,"?",0,0,m_cServer, m_oParameters),m_cServer,_denom)+" "+")"+(m_Ctx.IsSharedTemp("webaos_soggetti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webaos_soggetti.Eof())) {
          /* _specseg := '' */
          _specseg = "";
          // * --- Read from webaos_tbspec
          m_cServer = m_Ctx.GetServer("webaos_tbspec");
          m_cPhName = m_Ctx.GetPhName("webaos_tbspec");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"C",1,0,m_cServer),m_cServer,Cursor_webaos_soggetti.GetString("SPEC"));
          if (m_Ctx.IsSharedTemp("webaos_tbspec")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _specseg = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on webaos_tbspec into routine arrt_ricerca_sogg returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _specseg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_seek_sogg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_ricerca_sogg",16,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetDate("DATANAS"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESIND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("FONTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("FLAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_specseg,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_webaos_soggetti.Next();
        }
        m_cConnectivityError = Cursor_webaos_soggetti.ErrorMessage();
        Cursor_webaos_soggetti.Close();
        // * --- End Select
        /* Case w_criterio='C' */
      } else if (CPLib.eqr(w_criterio,"C")) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from webaos_soggetti
        m_cServer = m_Ctx.GetServer("webaos_soggetti");
        m_cPhName = m_Ctx.GetPhName("webaos_soggetti");
        if (Cursor_webaos_soggetti!=null)
          Cursor_webaos_soggetti.Close();
        Cursor_webaos_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codfisc,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codfisc)+" "+")"+(m_Ctx.IsSharedTemp("webaos_soggetti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webaos_soggetti.Eof())) {
          /* _specseg := '' */
          _specseg = "";
          // * --- Read from webaos_tbspec
          m_cServer = m_Ctx.GetServer("webaos_tbspec");
          m_cPhName = m_Ctx.GetPhName("webaos_tbspec");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"C",1,0,m_cServer),m_cServer,Cursor_webaos_soggetti.GetString("SPEC"));
          if (m_Ctx.IsSharedTemp("webaos_tbspec")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _specseg = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on webaos_tbspec into routine arrt_ricerca_sogg returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _specseg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_seek_sogg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_ricerca_sogg",16,"0000001D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000001D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetDate("DATANAS"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESIND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("FONTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("FLAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_specseg,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_webaos_soggetti.Next();
        }
        m_cConnectivityError = Cursor_webaos_soggetti.ErrorMessage();
        Cursor_webaos_soggetti.Close();
        // * --- End Select
        /* Case w_criterio='R' */
      } else if (CPLib.eqr(w_criterio,"R")) {
      } // End Case
      /* If _conta > 0 */
      if (CPLib.gt(_conta,0)) {
        /* Return  */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_ricerca_sogg");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("rotation","LANDSCAPE");
        f.SetParameter("criterio",w_criterio);
        f.SetParameter("denomin",w_denomin);
        f.SetParameter("codfisc",w_codfisc);
        f.SetParameter("simili",w_simili);
        f.SetParameter("flgnote",w_flgnote);
        f.SetParameter("ultaggsog",gDatTER);
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"criterio"+","+"denomin"+","+"codfisc"+","+"simili"+","+"flgnote"+","+"ultaggsog");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* If w_flgnega='S' */
        if (CPLib.eqr(w_flgnega,"S")) {
          // * --- Insert into tmp_seek_sogg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_ricerca_sogg",16,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("NEGATIVA","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
          /* Return  */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("ReportName","arrp_ricerca_sogg_neg");
          f.SetParameter("outputFormat","PDF");
          f.SetParameter("criterio",w_criterio);
          f.SetParameter("denomin",w_denomin);
          f.SetParameter("codfisc",w_codfisc);
          f.SetParameter("simili",w_simili);
          f.SetParameter("flgnote",w_flgnote);
          f.SetParameter("ultaggsog",gDatTER);
          f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"criterio"+","+"denomin"+","+"codfisc"+","+"simili"+","+"flgnote"+","+"ultaggsog");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_webaos_soggetti!=null)
          Cursor_webaos_soggetti.Close();
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
      m_Caller.SetString("criterio","C",1,0,w_criterio);
      m_Caller.SetString("denomin","C",60,0,w_denomin);
      m_Caller.SetString("codfisc","C",16,0,w_codfisc);
      m_Caller.SetString("simili","C",60,0,w_simili);
      m_Caller.SetString("flgnega","C",1,0,w_flgnega);
      m_Caller.SetString("flgnote","C",1,0,w_flgnote);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_ricerca_soggR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_ricerca_soggR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_criterio = m_Caller.GetString("criterio","C",1,0);
    w_denomin = m_Caller.GetString("denomin","C",60,0);
    w_codfisc = m_Caller.GetString("codfisc","C",16,0);
    w_simili = m_Caller.GetString("simili","C",60,0);
    w_flgnega = m_Caller.GetString("flgnega","C",1,0);
    w_flgnote = m_Caller.GetString("flgnote","C",1,0);
    _conta = 0;
    _denom = CPLib.Space(80);
    _specseg = CPLib.Space(100);
    gDatTER=m_Ctx.GetGlobalDate("gDatTER");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"FONTE,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"FLAG,";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"DESCSPEC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"FONTE,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"FLAG,";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"DESCSPEC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
}
