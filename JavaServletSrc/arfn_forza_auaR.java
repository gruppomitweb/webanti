// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_forza_auaR implements CallerWithObjs {
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
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_wutrxchk_checked;
  public String m_cServer_wutrxchk_checked;
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
  public java.sql.Date pDatIni;
  public java.sql.Date pDatFin;
  public String pMotivo;
  public double _conta;
  public String gMsgImp;
  public String gMsgProc;
  public double gUserCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_forza_auaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_forza_aua",m_Caller);
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_wutrxchk_checked = p_ContextObject.GetPhName("wutrxchk_checked");
    if (m_cPhName_wutrxchk_checked.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_checked = m_cPhName_wutrxchk_checked+" "+m_Ctx.GetWritePhName("wutrxchk_checked");
    }
    m_cServer_wutrxchk_checked = p_ContextObject.GetServer("wutrxchk_checked");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_forza_aua";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pMotivo",p_cVarName)) {
      return pMotivo;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      return pDatFin;
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pMotivo",p_cVarName)) {
      pMotivo = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      pDatFin = value;
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
    CPResultSet Cursor_wutrxchk=null;
    try {
      /* pDatIni Date */
      /* pDatFin Date */
      /* pMotivo Char(3) */
      /* _conta Numeric(10, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* Scorre la query e trasferisce i dati */
      /* gMsgProc := 'Ora Inizio Forzatura: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Forzatura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Selezione record da elaborare..." // Messaggio Import */
      gMsgImp = "Selezione record da elaborare...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Fstatus;
      nTry0000000Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000000Fmsg;
      cTry0000000Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from wutrxchk
        m_cServer = m_Ctx.GetServer("wutrxchk");
        m_cPhName = m_Ctx.GetPhName("wutrxchk");
        if (Cursor_wutrxchk!=null)
          Cursor_wutrxchk.Close();
        Cursor_wutrxchk = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TRXDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pDatIni,"?",0,0,m_cServer, m_oParameters),m_cServer,pDatIni)+"  and  TRXDATOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pDatFin,"?",0,0,m_cServer, m_oParameters),m_cServer,pDatFin)+"  and  TRXFLGAUI='S'  and  TRXFLGAUA='N' "+")"+(m_Ctx.IsSharedTemp("wutrxchk")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wutrxchk.Eof())) {
          /* gMsgImp := "Sto forzando l'operazione con codice: "+LRTrim(Str(wutrxchk->TRXCODPRG,15,0)) // Messaggio Import */
          gMsgImp = "Sto forzando l'operazione con codice: "+CPLib.LRTrim(CPLib.Str(Cursor_wutrxchk.GetDouble("TRXCODPRG"),15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into wutrxchk from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wutrxchk");
          m_cPhName = m_Ctx.GetPhName("wutrxchk");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_forza_aua",79,"00000013")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TRXFLGAUA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"TRXTINILAV = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
          m_cSql = m_cSql+"TRXTFINLAV = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
          m_cSql = m_cSql+"TRXDINILAV = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"TRDFINLAV = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"TRFLGINLAV = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"TRXUTENTE = "+CPLib.ToSQL(gUserCode,"N",10,0)+", ";
          m_cSql = m_cSql+"TRXESITO = "+CPLib.ToSQL("F","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"TRXFORCE = "+CPLib.ToSQL(pMotivo,"C",3,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wutrxchk",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"TRXCODPRG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wutrxchk.GetDouble("TRXCODPRG"),"?",0,0,m_cServer),m_cServer,Cursor_wutrxchk.GetDouble("TRXCODPRG"))+"";
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
          // * --- Insert into wutrxchk_checked from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wutrxchk_checked");
          m_cPhName = m_Ctx.GetPhName("wutrxchk_checked");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk_checked",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_forza_aua",79,"00000014")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000014(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("F","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gUserCode,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRSSEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXAUACHK"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXAUICHK"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXAUTRIL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCITRES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODCAS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODFIS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODMAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDouble("TRXCODPRG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODUNI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCOGCON"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCOGNOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDouble("TRXCONTAN"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATNAS"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATRICERCA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATRIL"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATSCA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXDESTIN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXDOMICI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA01"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA02"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA03"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA04"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA05"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA06"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA07"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA08"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA09"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERRAUA10"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR01"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR02"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR03"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR04"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR05"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR06"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR07"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR08"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR09"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR10"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR11"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR12"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR13"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR14"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR15"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR16"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR17"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR18"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR19"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR20"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR21"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR22"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR23"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR24"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR25"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR26"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR27"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR28"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR29"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR30"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR31"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR32"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR33"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR34"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR35"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR36"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR37"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR38"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR39"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR40"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR41"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR42"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR43"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR44"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR45"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR46"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR47"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR48"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR49"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXERROR50"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUAQ1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUAQ2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUAQ3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUAQ4"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUAQ5"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGAUI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGCF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGCON"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFLGFOR"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXFORCE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDouble("TRXIMPORTO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXLUONAS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXMTCN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNAZRES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNOMCON"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNOTEOPER"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNUMDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDouble("TRXNUMRIL"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXRECTYPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXSCAEDT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXSESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXTIPDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXUNIQUE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXDERIVATA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXGALACTIC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNAZRIL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wutrxchk_checked",true);
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_wutrxchk.Next();
        }
        m_cConnectivityError = Cursor_wutrxchk.ErrorMessage();
        Cursor_wutrxchk.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Forzate '+LRTrim(Str(_conta,10,0))+" operazioni" + NL */
        gMsgProc = gMsgProc+"Forzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Terminata con successo." // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con successo.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        /* gMsgImp := "Elaborazione Terminata con errori. Non è stata forzata alcuna operazione" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Non è stata forzata alcuna operazione";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Fstatus,cTry0000000Fmsg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Forzatura: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Forzatura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_wutrxchk!=null)
          Cursor_wutrxchk.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pMotivo) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pMotivo = p_pMotivo;
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
  public String Run(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pMotivo) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pMotivo = p_pMotivo;
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
  public static arfn_forza_auaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_forza_auaR(p_Ctx, p_Caller);
  }
  public static arfn_forza_auaR Make(CPContext p_Ctx) {
    return new arfn_forza_auaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    pMotivo = CPLib.Space(3);
    _conta = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_forza_aua,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_forza_aua,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin","pMotivo"};
  protected static String GetFieldsName_00000014(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRXESITO,";
    p_cSql = p_cSql+"TRFLGINLAV,";
    p_cSql = p_cSql+"TRXFLGAUA,";
    p_cSql = p_cSql+"TRDFINLAV,";
    p_cSql = p_cSql+"TRXDINILAV,";
    p_cSql = p_cSql+"TRXTFINLAV,";
    p_cSql = p_cSql+"TRXTINILAV,";
    p_cSql = p_cSql+"TRXUTENTE,";
    p_cSql = p_cSql+"TRSSEGNO,";
    p_cSql = p_cSql+"TRXAUACHK,";
    p_cSql = p_cSql+"TRXAUICHK,";
    p_cSql = p_cSql+"TRXAUTRIL,";
    p_cSql = p_cSql+"TRXCITRES,";
    p_cSql = p_cSql+"TRXCODCAS,";
    p_cSql = p_cSql+"TRXCODDIP,";
    p_cSql = p_cSql+"TRXCODFIS,";
    p_cSql = p_cSql+"TRXCODMAG,";
    p_cSql = p_cSql+"TRXCODPRG,";
    p_cSql = p_cSql+"TRXCODUNI,";
    p_cSql = p_cSql+"TRXCOGCON,";
    p_cSql = p_cSql+"TRXCOGNOM,";
    p_cSql = p_cSql+"TRXCONTAN,";
    p_cSql = p_cSql+"TRXDATNAS,";
    p_cSql = p_cSql+"TRXDATOPE,";
    p_cSql = p_cSql+"TRXDATRICERCA,";
    p_cSql = p_cSql+"TRXDATRIL,";
    p_cSql = p_cSql+"TRXDATSCA,";
    p_cSql = p_cSql+"TRXDESTIN,";
    p_cSql = p_cSql+"TRXDOMICI,";
    p_cSql = p_cSql+"TRXERRAUA01,";
    p_cSql = p_cSql+"TRXERRAUA02,";
    p_cSql = p_cSql+"TRXERRAUA03,";
    p_cSql = p_cSql+"TRXERRAUA04,";
    p_cSql = p_cSql+"TRXERRAUA05,";
    p_cSql = p_cSql+"TRXERRAUA06,";
    p_cSql = p_cSql+"TRXERRAUA07,";
    p_cSql = p_cSql+"TRXERRAUA08,";
    p_cSql = p_cSql+"TRXERRAUA09,";
    p_cSql = p_cSql+"TRXERRAUA10,";
    p_cSql = p_cSql+"TRXERROR01,";
    p_cSql = p_cSql+"TRXERROR02,";
    p_cSql = p_cSql+"TRXERROR03,";
    p_cSql = p_cSql+"TRXERROR04,";
    p_cSql = p_cSql+"TRXERROR05,";
    p_cSql = p_cSql+"TRXERROR06,";
    p_cSql = p_cSql+"TRXERROR07,";
    p_cSql = p_cSql+"TRXERROR08,";
    p_cSql = p_cSql+"TRXERROR09,";
    p_cSql = p_cSql+"TRXERROR10,";
    p_cSql = p_cSql+"TRXERROR11,";
    p_cSql = p_cSql+"TRXERROR12,";
    p_cSql = p_cSql+"TRXERROR13,";
    p_cSql = p_cSql+"TRXERROR14,";
    p_cSql = p_cSql+"TRXERROR15,";
    p_cSql = p_cSql+"TRXERROR16,";
    p_cSql = p_cSql+"TRXERROR17,";
    p_cSql = p_cSql+"TRXERROR18,";
    p_cSql = p_cSql+"TRXERROR19,";
    p_cSql = p_cSql+"TRXERROR20,";
    p_cSql = p_cSql+"TRXERROR21,";
    p_cSql = p_cSql+"TRXERROR22,";
    p_cSql = p_cSql+"TRXERROR23,";
    p_cSql = p_cSql+"TRXERROR24,";
    p_cSql = p_cSql+"TRXERROR25,";
    p_cSql = p_cSql+"TRXERROR26,";
    p_cSql = p_cSql+"TRXERROR27,";
    p_cSql = p_cSql+"TRXERROR28,";
    p_cSql = p_cSql+"TRXERROR29,";
    p_cSql = p_cSql+"TRXERROR30,";
    p_cSql = p_cSql+"TRXERROR31,";
    p_cSql = p_cSql+"TRXERROR32,";
    p_cSql = p_cSql+"TRXERROR33,";
    p_cSql = p_cSql+"TRXERROR34,";
    p_cSql = p_cSql+"TRXERROR35,";
    p_cSql = p_cSql+"TRXERROR36,";
    p_cSql = p_cSql+"TRXERROR37,";
    p_cSql = p_cSql+"TRXERROR38,";
    p_cSql = p_cSql+"TRXERROR39,";
    p_cSql = p_cSql+"TRXERROR40,";
    p_cSql = p_cSql+"TRXERROR41,";
    p_cSql = p_cSql+"TRXERROR42,";
    p_cSql = p_cSql+"TRXERROR43,";
    p_cSql = p_cSql+"TRXERROR44,";
    p_cSql = p_cSql+"TRXERROR45,";
    p_cSql = p_cSql+"TRXERROR46,";
    p_cSql = p_cSql+"TRXERROR47,";
    p_cSql = p_cSql+"TRXERROR48,";
    p_cSql = p_cSql+"TRXERROR49,";
    p_cSql = p_cSql+"TRXERROR50,";
    p_cSql = p_cSql+"TRXFLGAUAQ1,";
    p_cSql = p_cSql+"TRXFLGAUAQ2,";
    p_cSql = p_cSql+"TRXFLGAUAQ3,";
    p_cSql = p_cSql+"TRXFLGAUAQ4,";
    p_cSql = p_cSql+"TRXFLGAUAQ5,";
    p_cSql = p_cSql+"TRXFLGAUI,";
    p_cSql = p_cSql+"TRXFLGCF,";
    p_cSql = p_cSql+"TRXFLGCON,";
    p_cSql = p_cSql+"TRXFLGFOR,";
    p_cSql = p_cSql+"TRXFORCE,";
    p_cSql = p_cSql+"TRXIMPORTO,";
    p_cSql = p_cSql+"TRXLUONAS,";
    p_cSql = p_cSql+"TRXMTCN,";
    p_cSql = p_cSql+"TRXNASCOMUN,";
    p_cSql = p_cSql+"TRXNASSTATO,";
    p_cSql = p_cSql+"TRXNAZRES,";
    p_cSql = p_cSql+"TRXNOMCON,";
    p_cSql = p_cSql+"TRXNOME,";
    p_cSql = p_cSql+"TRXNOTEOPER,";
    p_cSql = p_cSql+"TRXNUMDOC,";
    p_cSql = p_cSql+"TRXNUMRIL,";
    p_cSql = p_cSql+"TRXRECTYPE,";
    p_cSql = p_cSql+"TRXSCAEDT,";
    p_cSql = p_cSql+"TRXSESSO,";
    p_cSql = p_cSql+"TRXTIPDOC,";
    p_cSql = p_cSql+"TRXUNIQUE,";
    p_cSql = p_cSql+"TRXDERIVATA,";
    p_cSql = p_cSql+"TRXGALACTIC,";
    p_cSql = p_cSql+"TRXNAZRIL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wutrxchk_checked",true);
    return p_cSql;
  }
}
