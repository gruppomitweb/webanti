// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasffra_ageR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String cProg1;
  public String cProg2;
  public String cProg3;
  public String w_idbase;
  public String _agente;
  public double _conta;
  public String _operazmod;
  public String _numprog;
  public String w_cdadata;
  public String w_c_adata;
  public String cPrgLog;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasffra_ageR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasffra_age",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
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
      return "arrt_trasffra_age";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      return cProg3;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return w_idbase;
    }
    if (CPLib.eqr("_agente",p_cVarName)) {
      return _agente;
    }
    if (CPLib.eqr("_operazmod",p_cVarName)) {
      return _operazmod;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cPrgLog",p_cVarName)) {
      return cPrgLog;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      cProg3 = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      w_idbase = value;
      return;
    }
    if (CPLib.eqr("_agente",p_cVarName)) {
      _agente = value;
      return;
    }
    if (CPLib.eqr("_operazmod",p_cVarName)) {
      _operazmod = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cPrgLog",p_cVarName)) {
      cPrgLog = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
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
    CPResultSet Cursor_qbe_trasffra_age_sel=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabile del chiamante */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* Variabili locali */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* cProg3 Char(10) */
      /* w_idbase Char(10) */
      /* _agente Char(1) */
      /* _conta Numeric(10, 0) */
      /* _operazmod Char(20) */
      /* _numprog Char(11) */
      /* w_cdadata Char(8) */
      /* w_c_adata Char(8) */
      /* cPrgLog Char(10) */
      /* Scorre la query e trasferisce i dati */
      /* gMsgProc := 'Ora Inizio Trasferimento Frazionate: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Trasferimento Frazionate: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* w_cdadata := iif((Empty(w_DaDatOpe) or DateToChar(w_DaDatOpe)='01000101'),'',DateToChar(w_DaDatOpe)) */
      w_cdadata = ((CPLib.Empty(w_DaDatOpe) || CPLib.eqr(CPLib.DateToChar(w_DaDatOpe),"01000101"))?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_adata := iif((Empty(w_ADatOpe) or DateToChar(w_ADatOpe)='01000101'),'',DateToChar(w_ADatOpe)) */
      w_c_adata = ((CPLib.Empty(w_ADatOpe) || CPLib.eqr(CPLib.DateToChar(w_ADatOpe),"01000101"))?"":CPLib.DateToChar(w_ADatOpe));
      /* cPrgLog := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(gAzienda)+"'",'',20) */
      cPrgLog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(gAzienda)+"'","",20);
      // * --- Insert into log_app from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("log_app");
      m_cPhName = m_Ctx.GetPhName("log_app");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000018")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000018(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cPrgLog,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Transfer","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Inizio Passaggio Frazionate agenti a Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()),"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Batch","?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cdadata+" - "+w_c_adata,"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000001Astatus;
      nTry0000001Astatus = m_Sql.GetTransactionStatus();
      String cTry0000001Amsg;
      cTry0000001Amsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_trasffra_age_sel
        SPBridge.HMCaller _h0000001B;
        _h0000001B = new SPBridge.HMCaller();
        _h0000001B.Set("m_cVQRList",m_cVQRList);
        _h0000001B.Set("cdadata",w_cdadata);
        _h0000001B.Set("c_adata",w_c_adata);
        if (Cursor_qbe_trasffra_age_sel!=null)
          Cursor_qbe_trasffra_age_sel.Close();
        Cursor_qbe_trasffra_age_sel = new VQRHolder("qbe_trasffra_age_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffra_age_sel.Eof())) {
          /* gMsgImp := 'Lettura frazionate registrate il '+arfn_fdate(qbe_trasffra_age_sel->DATAREG) // Messaggio allineamento 1 */
          gMsgImp = "Lettura frazionate registrate il "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_trasffra_age_sel.GetDate("DATAREG"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          if (Cursor_fraziobo!=null)
            Cursor_fraziobo.Close();
          Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,DATAOPE,CODDIPE,DATAREG,CDATOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG="+CPLib.ToSQL(Cursor_qbe_trasffra_age_sel.GetDate("DATAREG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_fraziobo.Eof())) {
            /* If fraziobo->CDATOPE >= w_cdadata and fraziobo->CDATOPE <= w_c_adata */
            if (CPLib.ge(Cursor_fraziobo.GetString("CDATOPE"),w_cdadata) && CPLib.le(Cursor_fraziobo.GetString("CDATOPE"),w_c_adata)) {
              /* If not(Empty(LRTrim(fraziobo->CODDIPE))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_fraziobo.GetString("CODDIPE"))))) {
                /* _agente := '' */
                _agente = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("CODDIPE"));
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _agente = Read_Cursor.GetString("AGENTE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasffra_age returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _agente = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _agente = 'S' or _agente = '1' */
                if (CPLib.eqr(_agente,"S") || CPLib.eqr(_agente,"1")) {
                  /* Calcol i nuovi progressivi */
                  /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
                  cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
                  /* cProg3 := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                  cProg3 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                  /* _numprog := fraziobo->NUMPROG */
                  _numprog = Cursor_fraziobo.GetString("NUMPROG");
                  /* Exec "Frazionate con modifiche" Page 2: */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  // * --- Delete from fraziobo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000028")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Delete from fraziobo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000029")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("NUMPROG"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                  /* gMsgImp := 'Sono state trasferite '+LRTrim(Str(_conta,10,0))+" frazionate" // Messaggio allineamento 1 */
                  gMsgImp = "Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate";
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                } // End If
              } // End If
            } // End If
            Cursor_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
          Cursor_fraziobo.Close();
          // * --- End Select
          Cursor_qbe_trasffra_age_sel.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffra_age_sel.ErrorMessage();
        Cursor_qbe_trasffra_age_sel.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cPrgLog := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(gAzienda)+"'",'',20) */
        cPrgLog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cPrgLog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Transfer","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Elaborazione Terminata con successo ! Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("batch","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_cdadata+" - "+w_c_adata,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        /* gMsgImp := "Elaborazione Terminata con successo !" // Messaggio allineamento 1 */
        gMsgImp = "Elaborazione Terminata con successo !";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + "Sono state trasferite "+LRTrim(Str(_conta,10,0))+" frazionate" + NL // Messaggio */
        gMsgProc = gMsgProc+"Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Elaborazione Annullata. Controllare i contatori standard per verificare l'errore !" // Messaggio allineamento 1 */
        gMsgImp = "Elaborazione Annullata. Controllare i contatori standard per verificare l'errore !";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* cPrgLog := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(gAzienda)+"'",'',20) */
        cPrgLog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cPrgLog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Transfer","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Elaborazione Annullata. Controllare i contatori standard per verificare l'errore !","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Batch","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_cdadata+" - "+w_c_adata,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Astatus,cTry0000001Amsg);
        }
      }
      /* cPrgLog := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(gAzienda)+"'",'',20) */
      cPrgLog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(gAzienda)+"'","",20);
      // * --- Insert into log_app from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("log_app");
      m_cPhName = m_Ctx.GetPhName("log_app");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000036")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000036(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cPrgLog,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Transfer","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Fine Passaggio Frazionate agenti a Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()),"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Batch","?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cdadata+" - "+w_c_adata,"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      /* gMsgProc := gMsgProc + 'Ora Fine Trasferimento Frazionate: '+ arfn_fdatetime(DateTime()) */
      gMsgProc = gMsgProc+"Ora Fine Trasferimento Frazionate: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_trasffra_age_sel!=null)
          Cursor_qbe_trasffra_age_sel.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
  void Page_2() throws Exception {
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_docfrabo=null;
    try {
      // * --- Select from fraziobo
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      if (Cursor_fraziobo!=null)
        Cursor_fraziobo.Close();
      Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_fraziobo.Eof())) {
        /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
        cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
        /* _operazmod := iif(Empty(LRTrim(fraziobo->OPERAZMOD)),'',Left(fraziobo->OPERAZMOD,8)+cProg2+Substr(fraziobo->OPERAZMOD,20,1)) */
        _operazmod = (CPLib.Empty(CPLib.LRTrim(Cursor_fraziobo.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_fraziobo.GetString("OPERAZMOD"),8)+cProg2+CPLib.Substr(Cursor_fraziobo.GetString("OPERAZMOD"),20,1));
        // * --- Insert into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_operazmod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_fraziobo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
        // * --- Select from sogopefbo
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
        Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopefbo.Eof())) {
          // * --- Insert into sogopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sogopebo");
          m_cPhName = m_Ctx.GetPhName("sogopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"0000003D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000003D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
          // * --- Delete from sogopefbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"0000003E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("IDFILEBO"))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetDouble("CPROWNUM"))+"";
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
          Cursor_sogopefbo.Next();
        }
        m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
        Cursor_sogopefbo.Close();
        // * --- End Select
        // * --- Select from clientifrz
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
        Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientifrz.Eof())) {
          // * --- Insert into clientiope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000040")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
          // * --- Delete from clientifrz
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("clientifrz");
          m_cPhName = m_Ctx.GetPhName("clientifrz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000041")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("IDFILEBO"))+"";
          m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
          Cursor_clientifrz.Next();
        }
        m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
        Cursor_clientifrz.Close();
        // * --- End Select
        // * --- Select from beneficfrz
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
        Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_beneficfrz.Eof())) {
          // * --- Insert into beneficope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("beneficope");
          m_cPhName = m_Ctx.GetPhName("beneficope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
          // * --- Delete from beneficfrz
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("beneficfrz");
          m_cPhName = m_Ctx.GetPhName("beneficfrz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000044")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("IDFILEBO"))+"";
          m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("CODSOG"))+"";
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
          Cursor_beneficfrz.Next();
        }
        m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
        Cursor_beneficfrz.Close();
        // * --- End Select
        // * --- Select from terzistifrz
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
        Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_terzistifrz.Eof())) {
          // * --- Insert into terzistiope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("terzistiope");
          m_cPhName = m_Ctx.GetPhName("terzistiope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000046")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000046(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
          // * --- Delete from terzistifrz
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("terzistifrz");
          m_cPhName = m_Ctx.GetPhName("terzistifrz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000047")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("IDFILEBO"))+"";
          m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
          Cursor_terzistifrz.Next();
        }
        m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
        Cursor_terzistifrz.Close();
        // * --- End Select
        // * --- Select from docfrabo
        m_cServer = m_Ctx.GetServer("docfrabo");
        m_cPhName = m_Ctx.GetPhName("docfrabo");
        if (Cursor_docfrabo!=null)
          Cursor_docfrabo.Close();
        Cursor_docfrabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("docfrabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_docfrabo.Eof())) {
          // * --- Insert into docopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docopebo");
          m_cPhName = m_Ctx.GetPhName("docopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"00000049")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000049(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_docfrabo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docopebo",true);
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
          // * --- Delete from docfrabo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docfrabo");
          m_cPhName = m_Ctx.GetPhName("docfrabo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_age",49,"0000004A")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_docfrabo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_docfrabo.GetString("NUMPROG"))+"";
          m_cSql = m_cSql+" and CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_docfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_docfrabo.GetString("CONNESCLI"))+"";
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
          Cursor_docfrabo.Next();
        }
        m_cConnectivityError = Cursor_docfrabo.ErrorMessage();
        Cursor_docfrabo.Close();
        // * --- End Select
        Cursor_fraziobo.Next();
      }
      m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
      Cursor_fraziobo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_docfrabo!=null)
          Cursor_docfrabo.Close();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_trasffra_ageR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasffra_ageR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    cProg3 = CPLib.Space(10);
    w_idbase = CPLib.Space(10);
    _agente = CPLib.Space(1);
    _conta = 0;
    _operazmod = CPLib.Space(20);
    _numprog = CPLib.Space(11);
    w_cdadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    cPrgLog = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasffra_age_sel,
  public static final String m_cVQRList = ",qbe_trasffra_age_sel,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000018(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000036(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000040(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000046(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000049(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docopebo",true);
    return p_cSql;
  }
}
