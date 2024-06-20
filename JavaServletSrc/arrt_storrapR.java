// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_storrapR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_wapopebo;
  public String m_cServer_wapopebo;
  public String m_cPhName_wnarapbo;
  public String m_cServer_wnarapbo;
  public String m_cPhName_wntestbo;
  public String m_cServer_wntestbo;
  public String m_cPhName_woginfo;
  public String m_cServer_woginfo;
  public String m_cPhName_statorap;
  public String m_cServer_statorap;
  public String m_cPhName_wtatorap;
  public String m_cServer_wtatorap;
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
  public String w_tipoope;
  public String w_codrap;
  public double w_numrec;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_storrapR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_storrap",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_wapopebo = p_ContextObject.GetPhName("wapopebo");
    if (m_cPhName_wapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wapopebo = m_cPhName_wapopebo+" "+m_Ctx.GetWritePhName("wapopebo");
    }
    m_cServer_wapopebo = p_ContextObject.GetServer("wapopebo");
    m_cPhName_wnarapbo = p_ContextObject.GetPhName("wnarapbo");
    if (m_cPhName_wnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wnarapbo = m_cPhName_wnarapbo+" "+m_Ctx.GetWritePhName("wnarapbo");
    }
    m_cServer_wnarapbo = p_ContextObject.GetServer("wnarapbo");
    m_cPhName_wntestbo = p_ContextObject.GetPhName("wntestbo");
    if (m_cPhName_wntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestbo = m_cPhName_wntestbo+" "+m_Ctx.GetWritePhName("wntestbo");
    }
    m_cServer_wntestbo = p_ContextObject.GetServer("wntestbo");
    m_cPhName_woginfo = p_ContextObject.GetPhName("woginfo");
    if (m_cPhName_woginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_woginfo = m_cPhName_woginfo+" "+m_Ctx.GetWritePhName("woginfo");
    }
    m_cServer_woginfo = p_ContextObject.GetServer("woginfo");
    m_cPhName_statorap = p_ContextObject.GetPhName("statorap");
    if (m_cPhName_statorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_statorap = m_cPhName_statorap+" "+m_Ctx.GetWritePhName("statorap");
    }
    m_cServer_statorap = p_ContextObject.GetServer("statorap");
    m_cPhName_wtatorap = p_ContextObject.GetPhName("wtatorap");
    if (m_cPhName_wtatorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wtatorap = m_cPhName_wtatorap+" "+m_Ctx.GetWritePhName("wtatorap");
    }
    m_cServer_wtatorap = p_ContextObject.GetServer("wtatorap");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("numrec",p_cVarName)) {
      return w_numrec;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_storrap";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipoope",p_cVarName)) {
      return w_tipoope;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      return w_codrap;
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
    if (CPLib.eqr("numrec",p_cVarName)) {
      w_numrec = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipoope",p_cVarName)) {
      w_tipoope = value;
      return;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      w_codrap = value;
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
    CPResultSet Cursor_qbe_storrap=null;
    CPResultSet Cursor_qbe_storrap2=null;
    CPResultSet Cursor_qbe_storrap1=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_statorap=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabile del chiamante */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_tipoope Char(1) */
      /* Variabili locali */
      /* w_codrap Char(25) */
      /* w_numrec Numeric(3, 0) */
      /* Scorre la query e trasferisce i dati */
      // * --- Select from qbe_storrap
      if (Cursor_qbe_storrap!=null)
        Cursor_qbe_storrap.Close();
      Cursor_qbe_storrap = new VQRHolder("qbe_storrap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_storrap.Eof())) {
        /* w_codrap := qbe_storrap->RAPPORTO */
        w_codrap = Cursor_qbe_storrap.GetString("RAPPORTO");
        /* w_numrec := 0 */
        w_numrec = CPLib.Round(0,0);
        // * --- Select from qbe_storrap2
        if (Cursor_qbe_storrap2!=null)
          Cursor_qbe_storrap2.Close();
        Cursor_qbe_storrap2 = new VQRHolder("qbe_storrap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_storrap2.Eof())) {
          /* w_numrec := qbe_storrap2->totrec */
          w_numrec = CPLib.Round(Cursor_qbe_storrap2.GetDouble("totrec"),0);
          Cursor_qbe_storrap2.Next();
        }
        m_cConnectivityError = Cursor_qbe_storrap2.ErrorMessage();
        Cursor_qbe_storrap2.Close();
        // * --- End Select
        /* If w_numrec = 0 */
        if (CPLib.eqr(w_numrec,0)) {
          /* If w_tipoope = 'T' */
          if (CPLib.eqr(w_tipoope,"T")) {
            // * --- Insert into wnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wnarapbo");
            m_cPhName = m_Ctx.GetPhName("wnarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wnarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"00000010")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000010(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDate("DATAMOD"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("IMPAPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("IMPCHIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("STATORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("CASTATOC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("CASTATOM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wnarapbo",true);
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
          // * --- Select from qbe_storrap1
          if (Cursor_qbe_storrap1!=null)
            Cursor_qbe_storrap1.Close();
          Cursor_qbe_storrap1 = new VQRHolder("qbe_storrap1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_storrap1.Eof())) {
            /* If w_tipoope = 'T' */
            if (CPLib.eqr(w_tipoope,"T")) {
              // * --- Insert into wapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wapopebo");
              m_cPhName = m_Ctx.GetPhName("wapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"00000013")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000013(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("PRGIMPINF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wapopebo",true);
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
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                // * --- Insert into wntestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wntestbo");
                m_cPhName = m_Ctx.GetPhName("wntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wntestbo",true);
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
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              // * --- Select from soginfo
              m_cServer = m_Ctx.GetServer("soginfo");
              m_cPhName = m_Ctx.GetPhName("soginfo");
              if (Cursor_soginfo!=null)
                Cursor_soginfo.Close();
              Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_soginfo.Eof())) {
                // * --- Insert into woginfo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("woginfo");
                m_cPhName = m_Ctx.GetPhName("woginfo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"woginfo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"woginfo",true);
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
                Cursor_soginfo.Next();
              }
              m_cConnectivityError = Cursor_soginfo.ErrorMessage();
              Cursor_soginfo.Close();
              // * --- End Select
              // * --- Select from statorap
              m_cServer = m_Ctx.GetServer("statorap");
              m_cPhName = m_Ctx.GetPhName("statorap");
              if (Cursor_statorap!=null)
                Cursor_statorap.Close();
              Cursor_statorap = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("statorap")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_statorap.Eof())) {
                // * --- Insert into wtatorap from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wtatorap");
                m_cPhName = m_Ctx.GetPhName("wtatorap");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wtatorap",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"00000019")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000019(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_statorap.GetString("STATORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wtatorap",true);
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
                Cursor_statorap.Next();
              }
              m_cConnectivityError = Cursor_statorap.ErrorMessage();
              Cursor_statorap.Close();
              // * --- End Select
            } // End If
            // * --- Delete from soginfo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("soginfo");
            m_cPhName = m_Ctx.GetPhName("soginfo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"soginfo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"0000001A")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("IDBASE"))+"";
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
            // * --- Delete from intestbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"0000001B")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("RAPPORTO"))+"";
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
            // * --- Delete from statorap
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("statorap");
            m_cPhName = m_Ctx.GetPhName("statorap");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"statorap",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"0000001C")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
            // * --- Delete from rapopebo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"0000001D")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("IDBASE"))+"";
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
            Cursor_qbe_storrap1.Next();
          }
          m_cConnectivityError = Cursor_qbe_storrap1.ErrorMessage();
          Cursor_qbe_storrap1.Close();
          // * --- End Select
          // * --- Delete from anarapbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_storrap",36,"0000001E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
        Cursor_qbe_storrap.Next();
      }
      m_cConnectivityError = Cursor_qbe_storrap.ErrorMessage();
      Cursor_qbe_storrap.Close();
      // * --- End Select
      /* Stop arpg_storrap */
      Forward f;
      f=new Forward("arpg_storrap",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_storrap!=null)
          Cursor_qbe_storrap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storrap2!=null)
          Cursor_qbe_storrap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storrap1!=null)
          Cursor_qbe_storrap1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_statorap!=null)
          Cursor_statorap.Close();
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
      m_Caller.SetString("tipoope","C",1,0,w_tipoope);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_storrapR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_storrapR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_tipoope = m_Caller.GetString("tipoope","C",1,0);
    w_codrap = CPLib.Space(25);
    w_numrec = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_storrap,qbe_storrap2,qbe_storrap1,
  public static final String m_cVQRList = ",qbe_storrap,qbe_storrap2,qbe_storrap1,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000010(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000013(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"woginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000019(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wtatorap",true);
    return p_cSql;
  }
}
