// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_copia51R implements CallerWithObjs {
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
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
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
  public String w_RAPPORTO;
  public String w_flgclose;
  public String w_flgallinea;
  public String gMsgProc;
  public String gMsgImp;
  public String gAzienda;
  public String _rapporto;
  public String cInfProg1;
  public String cInfProg2;
  public double nProgImp;
  public String cResult;
  public String _idinf;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_copia51R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_copia51",m_Caller);
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "arrt_copia51";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("flgclose",p_cVarName)) {
      return w_flgclose;
    }
    if (CPLib.eqr("flgallinea",p_cVarName)) {
      return w_flgallinea;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("cResult",p_cVarName)) {
      return cResult;
    }
    if (CPLib.eqr("_idinf",p_cVarName)) {
      return _idinf;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("flgclose",p_cVarName)) {
      w_flgclose = value;
      return;
    }
    if (CPLib.eqr("flgallinea",p_cVarName)) {
      w_flgallinea = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("cResult",p_cVarName)) {
      cResult = value;
      return;
    }
    if (CPLib.eqr("_idinf",p_cVarName)) {
      _idinf = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    try {
      /* w_RAPPORTO Char(25) */
      /* w_flgclose Char(1) // Non copiare chiusure */
      /* w_flgallinea Char(1) // Allinea i dati eventualmente già esistenti */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gAzienda Char(10) // Azienda */
      /* _rapporto Char(25) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(10) */
      /* nProgImp Numeric(15, 0) */
      /* cResult Char(2) */
      /* _idinf Char(10) */
      /* cResult := 'KO' */
      cResult = "KO";
      /* gMsgProc := 'Ora Inizio Copia Rapporto: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio Copia Rapporto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Verifica Esistenza Rapporto'+NL // Messaggio */
      gMsgProc = gMsgProc+"Verifica Esistenza Rapporto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000015status;
      nTry00000015status = m_Sql.GetTransactionStatus();
      String cTry00000015msg;
      cTry00000015msg = m_Sql.TransactionErrorMessage();
      try {
        /* _rapporto := '' */
        _rapporto = "";
        // * --- Read from jnarapbo
        m_cServer = m_Ctx.GetServer("jnarapbo");
        m_cPhName = m_Ctx.GetPhName("jnarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
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
            Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_copia51 returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) and w_flgallinea='N' */
        if ( ! (CPLib.Empty(_rapporto)) && CPLib.eqr(w_flgallinea,"N")) {
          /* gMsgProc := gMsgProc + 'Rapporto già esistente in 5.1'+NL // Messaggio */
          gMsgProc = gMsgProc+"Rapporto già esistente in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgImp := 'Creazione rapporto in 5.1' // Messaggio Import */
          gMsgImp = "Creazione rapporto in 5.1";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc +'Creazione rapporto in 5.1' +NL // Messaggio */
          gMsgProc = gMsgProc+"Creazione rapporto in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,w_RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            // * --- Merge into jnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "jnarapbo.RAPPORTO = cptmp_1xab23.RAPPORTO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000001D")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jnarapbo USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"jnarapbo.DESCRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.TIPORAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.FLAGLIRE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.VALUTA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.CONTINUA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.TIPOAG = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.IDBASE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.TIPMOD = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.DATAMOD = "+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.DOCFILE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.IDRAPPORTO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RAGIO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.MODSVOL = "+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.AREAGEO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.SCOPO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.NATURA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RTIPO = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RCOMP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RIMP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RFREQ = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RRAGIO = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.RAREA = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.TIPO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.PRGIMPRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("PRGIMPRAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.AMMONT = "+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.DURAT = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.IMPAPE = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.IMPCHIU = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"?",0,0)+" , ";
              m_cSql = m_cSql+"jnarapbo.CODDIP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIP"),"?",0,0)+" , ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_0000001D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000001D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONTINUA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPMOD = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAMOD = "+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"D",8,0)+", ";
              m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDRAPPORTO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"SCOPO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"NATURA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"RTIPO = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"N",3,0)+", ";
              m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RIMP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RFREQ = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"N",3,0)+", ";
              m_cSql = m_cSql+"RRAGIO = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"N",3,0)+", ";
              m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"N",3,0)+", ";
              m_cSql = m_cSql+"TIPO = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"PRGIMPRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("PRGIMPRAP"),"N",15,0)+", ";
              m_cSql = m_cSql+"AMMONT = "+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DURAT = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"N",1,0)+", ";
              m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"N",1,0)+", ";
              m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIP"),"C",6,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000001D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000001D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
                m_cSql = m_cSql+")";
              } else {
                m_cSql = "";
              }
            }
            if ( ! (CPLib.Empty(m_cSql))) {
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            }
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* gMsgImp := 'Inserimento Informazioni rapporto in 5.1' // Messaggio Import */
          gMsgImp = "Inserimento Informazioni rapporto in 5.1";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc +'Inserimento Informazioni rapporto in 5.1'+NL // Messaggio */
          gMsgProc = gMsgProc+"Inserimento Informazioni rapporto in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,w_RAPPORTO)+"  and  TIPOOPRAP<>'31'  and  TIPOOPRAP<>'32'  and  (STATOREG ='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If w_flgallinea='N' */
            if (CPLib.eqr(w_flgallinea,"N")) {
              /* If w_flgclose='N' or (w_flgclose='S' and At(rapopebo->TIPOOPRAP,"|26|28|31|32|36|38|41|46|47")=0) */
              if (CPLib.eqr(w_flgclose,"N") || (CPLib.eqr(w_flgclose,"S") && CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|26|28|31|32|36|38|41|46|47"),0))) {
                /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
                cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into japopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000025")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000025(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
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
              } // End If
            } else { // Else
              /* _idinf := '' */
              _idinf = "";
              // * --- Read from japopebo
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_cSql = "";
              m_cSql = m_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"C",11,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("NUMPROG"));
              if (m_Ctx.IsSharedTemp("japopebo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _idinf = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on japopebo into routine arrt_copia51 returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _idinf = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_idinf) */
              if (CPLib.Empty(_idinf)) {
                /* If w_flgclose='N' or (w_flgclose='S' and At(rapopebo->TIPOOPRAP,"|26|28|31|32|36|38|41|46|47")=0) */
                if (CPLib.eqr(w_flgclose,"N") || (CPLib.eqr(w_flgclose,"S") && CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|26|28|31|32|36|38|41|46|47"),0))) {
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into japopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
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
                } // End If
              } else { // Else
                // * --- Write into japopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG = "+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOINF = "+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGFRAZ = "+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGCONT = "+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOLEG"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"D",8,0)+", ";
                m_cSql = m_cSql+"OPRAP = "+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOOPRAP = "+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"N",15,0)+", ";
                m_cSql = m_cSql+"TOTCONT = "+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"N",15,0)+", ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESOPER"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"COLLEG = "+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"C",12,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAMBIO = "+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"N",9,4)+", ";
                m_cSql = m_cSql+"RAPPORTBEN = "+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"OPERATORE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"AUTOM = "+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"RESPINS = "+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"INFORM = "+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAAGE = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"D",8,0)+", ";
                m_cSql = m_cSql+"UCODE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"C",7,0,m_cServer)+", ";
                m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(Cursor_rapopebo.GetString("CDATOPE"),"C",8,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"japopebo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idinf,"?",0,0,m_cServer),m_cServer,_idinf)+"";
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
              } // End If
            } // End If
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
          /* gMsgImp := 'Inserimento Intestatari rapporto in 5.1' // Messaggio Import */
          gMsgImp = "Inserimento Intestatari rapporto in 5.1";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc +'Inserimento Intestatari rapporto in 5.1'+NL // Messaggio */
          gMsgProc = gMsgProc+"Inserimento Intestatari rapporto in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,w_RAPPORTO)+"  and  ([NOTEMPTYSTR(STATOREG)]=0  or  STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If w_flgclose='N' */
            if (CPLib.eqr(w_flgclose,"N")) {
              // * --- Merge into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0)+" as IDBASE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+" as CPROWNUM";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "jntestbo.IDBASE = cptmp_1xab23.IDBASE";
              m_cWhere = m_cWhere+" and "+"jntestbo.CPROWNUM = cptmp_1xab23.CPROWNUM";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000032")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jntestbo USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"jntestbo.DATAINI = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.TIPOPERS = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.CODINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.NUMPROG1 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.RAPPORTO = "+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.TIPORAP = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.DESCINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.IDEREG = "+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.COLLEGAMEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.UCODE = "+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.ABBINATO = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.PRGIMPSOG = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.NUMPROG2 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.DATAFINE = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+" , ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"D",8,0)+", ";
                m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"COLLEGAMEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"UCODE = "+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"C",7,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"N",1,0)+", ";
                m_cSql = m_cSql+"PRGIMPSOG = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"N",15,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetDouble("CPROWNUM"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } else { // Else
              // * --- Merge into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0)+" as IDBASE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+" as CPROWNUM";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "jntestbo.IDBASE = cptmp_1xab23.IDBASE";
              m_cWhere = m_cWhere+" and "+"jntestbo.CPROWNUM = cptmp_1xab23.CPROWNUM";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000033")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jntestbo USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"jntestbo.DATAINI = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.TIPOPERS = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.CODINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.NUMPROG1 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.RAPPORTO = "+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.TIPORAP = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.DESCINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.IDEREG = "+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.COLLEGAMEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.UCODE = "+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.ABBINATO = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jntestbo.PRGIMPSOG = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+" , ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000033(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000033")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"D",8,0)+", ";
                m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"COLLEGAMEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"UCODE = "+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"C",7,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"N",1,0)+", ";
                m_cSql = m_cSql+"PRGIMPSOG = "+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"N",15,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetDouble("CPROWNUM"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000033")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000033(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("PRGIMPSOG"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* gMsgImp := 'Inserimento Delegati rapporto in 5.1' // Messaggio Import */
          gMsgImp = "Inserimento Delegati rapporto in 5.1";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc +'Inserimento Delegati rapporto in 5.1'+NL // Messaggio */
          gMsgProc = gMsgProc+"Inserimento Delegati rapporto in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,w_RAPPORTO)+"  and  ([NOTEMPTYSTR(STATOREG)]=0  or  STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* If w_flgclose='N' */
            if (CPLib.eqr(w_flgclose,"N")) {
              /* If delegabo->NOAGE='N' or Empty(delegabo->NOAGE) */
              if (CPLib.eqr(Cursor_delegabo.GetString("NOAGE"),"N") || CPLib.Empty(Cursor_delegabo.GetString("NOAGE"))) {
                // * --- Merge into jelegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
                m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+" as CPROWNUM";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "jelegabo.RAPPORTO = cptmp_1xab23.RAPPORTO";
                m_cWhere = m_cWhere+" and "+"jelegabo.CPROWNUM = cptmp_1xab23.CPROWNUM";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000039")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jelegabo USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"jelegabo.CODINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.DESCINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.DATAINI = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.DATAFINE = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.TIPORAP = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.TIPOPERS = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.IDEREG = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.COLLEGAMEN = "+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.NUMPROG1 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.NUMPROG2 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.IDBASE = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.UCODE = "+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.ABBINATO = "+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+" , ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_00000039(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000039")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"D",8,0)+", ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"D",8,0)+", ";
                  m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COLLEGAMEN = "+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"UCODE = "+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"C",7,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"N",1,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetDouble("CPROWNUM"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000039")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000039(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
                    m_cSql = m_cSql+")";
                  } else {
                    m_cSql = "";
                  }
                }
                if ( ! (CPLib.Empty(m_cSql))) {
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                }
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } else { // Else
              /* If delegabo->NOAGE='N' or Empty(delegabo->NOAGE) */
              if (CPLib.eqr(Cursor_delegabo.GetString("NOAGE"),"N") || CPLib.Empty(Cursor_delegabo.GetString("NOAGE"))) {
                // * --- Merge into jelegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
                m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+" as CPROWNUM";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "jelegabo.RAPPORTO = cptmp_1xab23.RAPPORTO";
                m_cWhere = m_cWhere+" and "+"jelegabo.CPROWNUM = cptmp_1xab23.CPROWNUM";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000003B")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jelegabo USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"jelegabo.CODINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.DESCINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.DATAINI = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.TIPORAP = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.TIPOPERS = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.IDEREG = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.COLLEGAMEN = "+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.NUMPROG1 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.IDBASE = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.UCODE = "+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"jelegabo.ABBINATO = "+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+" , ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000003B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"D",8,0)+", ";
                  m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COLLEGAMEN = "+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"UCODE = "+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"C",7,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"N",1,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetDouble("CPROWNUM"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
                    m_cSql = m_cSql+")";
                  } else {
                    m_cSql = "";
                  }
                }
                if ( ! (CPLib.Empty(m_cSql))) {
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                }
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } // End If
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
          /* gMsgImp := 'Inserimento Garantiti rapporto in 5.1' // Messaggio Import */
          gMsgImp = "Inserimento Garantiti rapporto in 5.1";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc +'Inserimento Garantiti rapporto in 5.1'+NL // Messaggio */
          gMsgProc = gMsgProc+"Inserimento Garantiti rapporto in 5.1"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from garantbo
          m_cServer = m_Ctx.GetServer("garantbo");
          m_cPhName = m_Ctx.GetPhName("garantbo");
          if (Cursor_garantbo!=null)
            Cursor_garantbo.Close();
          Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,w_RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_garantbo.Eof())) {
            /* If w_flgclose='N' */
            if (CPLib.eqr(w_flgclose,"N")) {
              // * --- Merge into jarantbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jarantbo");
              m_cPhName = m_Ctx.GetPhName("jarantbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jarantbo",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0)+" as CODINTER";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "jarantbo.RAPPORTO = cptmp_1xab23.RAPPORTO";
              m_cWhere = m_cWhere+" and "+"jarantbo.CODINTER = cptmp_1xab23.CODINTER";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000040")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jarantbo USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"jarantbo.DATAINI = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jarantbo.IDBASE = "+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jarantbo.DATAFINE = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAFINE"),"?",0,0)+" , ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jarantbo",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jarantbo",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"D",8,0)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAFINE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jarantbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_garantbo.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_garantbo.GetString("CODINTER"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000040")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jarantbo",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } else { // Else
              // * --- Merge into jarantbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jarantbo");
              m_cPhName = m_Ctx.GetPhName("jarantbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jarantbo",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0)+" as CODINTER";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "jarantbo.RAPPORTO = cptmp_1xab23.RAPPORTO";
              m_cWhere = m_cWhere+" and "+"jarantbo.CODINTER = cptmp_1xab23.CODINTER";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000041")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" jarantbo USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"jarantbo.DATAINI = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+" , ";
                m_cSql = m_cSql+"jarantbo.IDBASE = "+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0)+" , ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jarantbo",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jarantbo",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"D",8,0)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jarantbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_garantbo.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_garantbo.GetString("CODINTER"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000041")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jarantbo",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
            Cursor_garantbo.Next();
          }
          m_cConnectivityError = Cursor_garantbo.ErrorMessage();
          Cursor_garantbo.Close();
          // * --- End Select
        } // End If
        // * --- Write into anarapbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_copia51",22,"00000042")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(1,"N",1,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer),m_cServer,w_RAPPORTO)+"";
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
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione completata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc +'Copia rapporto in 5.1 completata'+NL // Messaggio */
        gMsgProc = gMsgProc+"Copia rapporto in 5.1 completata"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* cResult := 'OK' */
        cResult = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc +'Copia rapporto in 5.1 fallita'+NL // Messaggio */
        gMsgProc = gMsgProc+"Copia rapporto in 5.1 fallita"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione terminata per presenza di errori!' // Messaggio Import */
        gMsgImp = "Elaborazione terminata per presenza di errori!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000015status,0)) {
          m_Sql.SetTransactionStatus(nTry00000015status,cTry00000015msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Copia Rapporto: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Copia Rapporto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cResult */
      throw new Stop(cResult);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
      try {
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_RAPPORTO,String p_w_flgclose,String p_w_flgallinea) {
    w_RAPPORTO = p_w_RAPPORTO;
    w_flgclose = p_w_flgclose;
    w_flgallinea = p_w_flgallinea;
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
  public String Run(String p_w_RAPPORTO,String p_w_flgclose,String p_w_flgallinea) {
    w_RAPPORTO = p_w_RAPPORTO;
    w_flgclose = p_w_flgclose;
    w_flgallinea = p_w_flgallinea;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arrt_copia51R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_copia51R(p_Ctx, p_Caller);
  }
  public static arrt_copia51R Make(CPContext p_Ctx) {
    return new arrt_copia51R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_RAPPORTO = CPLib.Space(25);
    w_flgclose = CPLib.Space(1);
    w_flgallinea = CPLib.Space(1);
    _rapporto = CPLib.Space(25);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(10);
    nProgImp = 0;
    cResult = CPLib.Space(2);
    _idinf = CPLib.Space(10);
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_copia51,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_copia51,";
  public static String[] m_cRunParameterNames={"w_RAPPORTO","w_flgclose","w_flgallinea"};
  protected static String GetFieldsName_0000001D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000025(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000033(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000039(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jelegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jelegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000040(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jarantbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000041(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jarantbo",true);
    return p_cSql;
  }
}
