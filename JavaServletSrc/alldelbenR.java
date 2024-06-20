// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class alldelbenR implements CallerWithObjs {
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public double _max;
  public double _min;
  public double _tot;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String pippo;
  public String fhand;
  public String _rapporto;
  public double nProgImp;
  public String cInfProg1;
  public String cInfProg2;
  public String gIntemediario;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public alldelbenR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("alldelben",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "alldelben";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pippo",p_cVarName)) {
      return pippo;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pippo",p_cVarName)) {
      pippo = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      cInfProg1 = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_qbe_aui_age_good=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* pippo Char(26) */
      /* fhand Char(10) */
      /* _rapporto Char(25) */
      /* nProgImp Numeric(15, 0) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000012status;
      nTry00000012status = m_Sql.GetTransactionStatus();
      String cTry00000012msg;
      cTry00000012msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_aui_age_good
        if (Cursor_qbe_aui_age_good!=null)
          Cursor_qbe_aui_age_good.Close();
        Cursor_qbe_aui_age_good = new VQRHolder("qbe_aui_age_good",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_aui_age_good.Eof())) {
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_aui_age_good.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine alldelben returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_rapporto)) */
          if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
            /* nProgImp := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into jnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("alldelben",26,"00000018")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000018(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDate("DATAMOD"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("IMPAPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetDouble("IMPCHIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
            // * --- Select from rapopebo
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            if (Cursor_rapopebo!=null)
              Cursor_rapopebo.Close();
            Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapopebo.Eof())) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into japopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("alldelben",26,"0000001D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000001D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"japopebo",true);
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
              /* Case rapopebo->TIPOOPRAP='23' */
              if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"23")) {
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  // * --- Insert into jntestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("jntestbo");
                  m_cPhName = m_Ctx.GetPhName("jntestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("alldelben",26,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
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
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                /* Case rapopebo->TIPOOPRAP='25' */
              } else if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"25")) {
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  // * --- Insert into jelegabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("jelegabo");
                  m_cPhName = m_Ctx.GetPhName("jelegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("alldelben",26,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
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
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } // End Case
              Cursor_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
            Cursor_rapopebo.Close();
            // * --- End Select
          } // End If
          // * --- Write into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("alldelben",26,"00000023")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aui_age_good.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aui_age_good.GetString("RAPPORTO"))+"";
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
          Cursor_qbe_aui_age_good.Next();
        }
        m_cConnectivityError = Cursor_qbe_aui_age_good.ErrorMessage();
        Cursor_qbe_aui_age_good.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000012status,0)) {
          m_Sql.SetTransactionStatus(nTry00000012status,cTry00000012msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_aui_age_good!=null)
          Cursor_qbe_aui_age_good.Close();
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
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static alldelbenR Make(CPContext p_Ctx, Caller p_Caller) {
    return new alldelbenR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _max = 0;
    _min = 0;
    _tot = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    pippo = CPLib.Space(26);
    fhand = CPLib.Space(10);
    _rapporto = CPLib.Space(25);
    nProgImp = 0;
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_aui_age_good,
  public static final String m_cVQRList = ",qbe_aui_age_good,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000018(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"NOPROT,";
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
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jelegabo",true);
    return p_cSql;
  }
}
