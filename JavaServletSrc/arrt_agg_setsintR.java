// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_agg_setsintR implements CallerWithObjs {
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
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
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
  public String _code3;
  public String _ocode3;
  public double _cerr;
  public double _cnew;
  public double _ctot;
  public String _tiposot;
  public String _codstg;
  public double w_nTOT;
  public double w_nTOTm;
  public double w_nTOTe;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_agg_setsintR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_agg_setsint",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
      m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
      if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
      }
      m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    }
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nTOT",p_cVarName)) {
      return w_nTOT;
    }
    if (CPLib.eqr("nTOTm",p_cVarName)) {
      return w_nTOTm;
    }
    if (CPLib.eqr("nTOTe",p_cVarName)) {
      return w_nTOTe;
    }
    if (CPLib.eqr("_cerr",p_cVarName)) {
      return _cerr;
    }
    if (CPLib.eqr("_cnew",p_cVarName)) {
      return _cnew;
    }
    if (CPLib.eqr("_ctot",p_cVarName)) {
      return _ctot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_agg_setsint";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      return _code3;
    }
    if (CPLib.eqr("_ocode3",p_cVarName)) {
      return _ocode3;
    }
    if (CPLib.eqr("_tiposot",p_cVarName)) {
      return _tiposot;
    }
    if (CPLib.eqr("_codstg",p_cVarName)) {
      return _codstg;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("nTOT",p_cVarName)) {
      w_nTOT = value;
      return;
    }
    if (CPLib.eqr("nTOTm",p_cVarName)) {
      w_nTOTm = value;
      return;
    }
    if (CPLib.eqr("nTOTe",p_cVarName)) {
      w_nTOTe = value;
      return;
    }
    if (CPLib.eqr("_cerr",p_cVarName)) {
      _cerr = value;
      return;
    }
    if (CPLib.eqr("_cnew",p_cVarName)) {
      _cnew = value;
      return;
    }
    if (CPLib.eqr("_ctot",p_cVarName)) {
      _ctot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_code3",p_cVarName)) {
      _code3 = value;
      return;
    }
    if (CPLib.eqr("_ocode3",p_cVarName)) {
      _ocode3 = value;
      return;
    }
    if (CPLib.eqr("_tiposot",p_cVarName)) {
      _tiposot = value;
      return;
    }
    if (CPLib.eqr("_codstg",p_cVarName)) {
      _codstg = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
      /* Definizione Variabili Locali */
      /* _code3 Char(3) */
      /* _ocode3 Char(3) */
      /* _cerr Numeric(10, 0) */
      /* _cnew Numeric(10, 0) */
      /* _ctot Numeric(10, 0) */
      /* _tiposot Char(1) */
      /* _codstg Char(3) */
      /* Dichiarazione variabili globali */
      /* w_nTOT Numeric(10, 0) */
      /* w_nTOTm Numeric(10, 0) */
      /* w_nTOTe Numeric(10, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* Lettura Tabelle */
      /* gMsgImp := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgImp = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Drop temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      // * --- Create temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newpers");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newpers"))) {
        m_cServer = m_Ctx.GetServer("tmp_newpers");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newpers",m_cServer,"proto")),m_cPhName,"tmp_newpers",m_Ctx);
      }
      m_cPhName_tmp_newpers = m_cPhName;
      /* _cerr := 0 */
      _cerr = CPLib.Round(0,0);
      /* _cnew := 0 */
      _cnew = CPLib.Round(0,0);
      /* _ctot := 0 */
      _ctot = CPLib.Round(0,0);
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* If Empty(LRTrim(personbo->OLDSETSIN)) and not(Empty(LRTrim(personbo->SETTSINT))) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("OLDSETSIN"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))))) {
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000018")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"OLDSETSIN = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* If not(Empty(LRTrim(personbo->COGNOME))) and not(Empty(LRTrim(personbo->NOME))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("COGNOME")))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NOME"))))) {
          /* If Empty(LRTrim(personbo->SOTGRUP)) and Empty(LRTrim(personbo->SETTSINT)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT")))) {
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"0000001B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            // * --- Insert into tmp_newpers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_newpers");
            m_cPhName = m_Ctx.GetPhName("tmp_newpers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"0000001C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti Sottogruppo e Settore Sintetico = 600","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
          } // End If
        } // End If
        /* If Empty(LRTrim(personbo->SOTGRUP)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP")))) {
          // * --- Insert into tmp_newpers from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"0000001E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000001E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Sottogruppo non inserito","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
          /* _cerr := _cerr + 1 */
          _cerr = CPLib.Round(_cerr+1,0);
        } else { // Else
          /* _tiposot := '' */
          _tiposot = "";
          /* _codstg := '' */
          _codstg = "";
          // * --- Read from tbstgru
          m_cServer = m_Ctx.GetServer("tbstgru");
          m_cPhName = m_Ctx.GetPhName("tbstgru");
          m_cSql = "";
          m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
          if (m_Ctx.IsSharedTemp("tbstgru")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SOTGRU",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tiposot = Read_Cursor.GetString("TIPOSOT");
            _codstg = Read_Cursor.GetString("SOTGRU");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_agg_setsint returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tiposot = "";
            _codstg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codstg)) */
          if (CPLib.Empty(CPLib.LRTrim(_codstg))) {
            // * --- Insert into tmp_newpers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_newpers");
            m_cPhName = m_Ctx.GetPhName("tmp_newpers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000024")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000024(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Sottogruppo INESISTENTE","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
            /* _cerr := _cerr + 1 */
            _cerr = CPLib.Round(_cerr+1,0);
          } else { // Else
            /* If _tiposot = '1' */
            if (CPLib.eqr(_tiposot,"1")) {
              /* If Empty(LRTrim(personbo->ATTIV)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")))) {
                // * --- Insert into tmp_newpers from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_newpers");
                m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000028")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000028(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("CODICE ATECO ASSENTE","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
                /* _cerr := _cerr + 1 */
                _cerr = CPLib.Round(_cerr+1,0);
              } else { // Else
                /* _code3 := arfn_calcolasett(personbo->SOTGRUP,'',personbo->ATTIV) */
                _code3 = arfn_calcolasettR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("SOTGRUP"),"",Cursor_personbo.GetString("ATTIV"));
                /* If Empty(LRTrim(_code3)) */
                if (CPLib.Empty(CPLib.LRTrim(_code3))) {
                  // * --- Insert into tmp_newpers from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_newpers");
                  m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Impossibile ricavare Settore Sintetico","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
                  /* _cerr := _cerr + 1 */
                  _cerr = CPLib.Round(_cerr+1,0);
                } else { // Else
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"0000002E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_code3,"C",3,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  /* If _code3 = '712' or _code3 = '713' */
                  if (CPLib.eqr(_code3,"712") || CPLib.eqr(_code3,"713")) {
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"OLDSETSIN = "+CPLib.ToSQL("710","C",3,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  // * --- Insert into tmp_newpers from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_newpers");
                  m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000031")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000031(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Settore Sintetico da "+Cursor_personbo.GetString("SETTSINT")+" a "+_code3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
                  /* _cnew := _cnew + 1 */
                  _cnew = CPLib.Round(_cnew+1,0);
                } // End If
              } // End If
            } else { // Else
              /* _code3 := arfn_calcolasett(personbo->SOTGRUP,'???',personbo->ATTIV) */
              _code3 = arfn_calcolasettR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("SOTGRUP"),"???",Cursor_personbo.GetString("ATTIV"));
              /* If Empty(LRTrim(_code3)) */
              if (CPLib.Empty(CPLib.LRTrim(_code3))) {
                // * --- Insert into tmp_newpers from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_newpers");
                m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000035")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000035(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Impossibile ricavare Settore Sintetico","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
                /* _cerr := _cerr + 1 */
                _cerr = CPLib.Round(_cerr+1,0);
              } else { // Else
                // * --- Write into personbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_code3,"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                // * --- Insert into tmp_newpers from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_newpers");
                m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_setsint",48,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Settore Sintetico da "+Cursor_personbo.GetString("SETTSINT")+" a "+_code3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
                /* _cnew := _cnew + 1 */
                _cnew = CPLib.Round(_cnew+1,0);
              } // End If
            } // End If
          } // End If
        } // End If
        /* _ctot := _ctot + 1 */
        _ctot = CPLib.Round(_ctot+1,0);
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* w_nTOT := _ctot */
      w_nTOT = CPLib.Round(_ctot,0);
      /* w_nTOTm := _cnew */
      w_nTOTm = CPLib.Round(_cnew,0);
      /* w_nTOTe := _cerr */
      w_nTOTe = CPLib.Round(_cerr,0);
      /* gMsgImp := 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgImp = "Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgImp := 'ELABORAZIONE TERMINATA' */
      gMsgImp = "ELABORAZIONE TERMINATA";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      m_Caller.SetNumber("nTOT","N",10,0,w_nTOT);
      m_Caller.SetNumber("nTOTm","N",10,0,w_nTOTm);
      m_Caller.SetNumber("nTOTe","N",10,0,w_nTOTe);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_agg_setsintR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_agg_setsintR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _code3 = CPLib.Space(3);
    _ocode3 = CPLib.Space(3);
    _cerr = 0;
    _cnew = 0;
    _ctot = 0;
    _tiposot = CPLib.Space(1);
    _codstg = CPLib.Space(3);
    w_nTOT = m_Caller.GetNumber("nTOT","N",10,0);
    w_nTOTm = m_Caller.GetNumber("nTOTm","N",10,0);
    w_nTOTe = m_Caller.GetNumber("nTOTe","N",10,0);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calcolasett,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_calcolasett,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000001C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000024(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000028(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000031(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000035(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
}
