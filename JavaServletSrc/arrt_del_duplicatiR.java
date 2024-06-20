// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_del_duplicatiR implements CallerWithObjs {
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
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
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
  public double w_anno;
  public double _conta;
  public double _cicli;
  public double _prog;
  public String _progrig;
  public String cProg;
  public String cCanc;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_del_duplicatiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_del_duplicati",m_Caller);
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_del_duplicati";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_progrig",p_cVarName)) {
      return _progrig;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_progrig",p_cVarName)) {
      _progrig = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_qbe_del_duplicati=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_anno Numeric(4, 0) */
      /* _conta Numeric(10, 0) */
      /* _cicli Numeric(15, 0) */
      /* _prog Numeric(10, 0) */
      /* _progrig Char(10) */
      /* cProg Char(10) */
      /* cCanc Char(10) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gAzienda Char(10) // Azienda */
      /* Il controllo su NOPROT della tabella ANARAPBO viene fatto direttamente nelle QUERY */
      /* gMsgProc := '' // Messaggio */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000013status;
      nTry00000013status = m_Sql.GetTransactionStatus();
      String cTry00000013msg;
      cTry00000013msg = m_Sql.TransactionErrorMessage();
      try {
        /* Operazioni */
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from qbe_del_duplicati
        SPBridge.HMCaller _h00000016;
        _h00000016 = new SPBridge.HMCaller();
        _h00000016.Set("m_cVQRList",m_cVQRList);
        _h00000016.Set("anno",w_anno);
        if (Cursor_qbe_del_duplicati!=null)
          Cursor_qbe_del_duplicati.Close();
        Cursor_qbe_del_duplicati = new VQRHolder("qbe_del_duplicati",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000016,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_del_duplicati.Eof())) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
          // * --- Select from aeoprig
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          if (Cursor_aeoprig!=null)
            Cursor_aeoprig.Close();
          Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPLib.ToSQL(Cursor_qbe_del_duplicati.GetString("UNIQUECODE"),"?",0,0)+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aeoprig.Eof())) {
            /* gMsgImp := "Elaboro l'operazione con codice univoco "+LRTrim(qbe_del_duplicati->UNIQUECODE) // Messaggio Import */
            gMsgImp = "Elaboro l'operazione con codice univoco "+CPLib.LRTrim(Cursor_qbe_del_duplicati.GetString("UNIQUECODE"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _cicli := _cicli + 1 */
            _cicli = CPLib.Round(_cicli+1,0);
            /* If _cicli > 1 */
            if (CPLib.gt(_cicli,1)) {
              /* _progrig := '' */
              _progrig = "";
              // * --- Read from aeopcanc
              m_cServer = m_Ctx.GetServer("aeopcanc");
              m_cPhName = m_Ctx.GetPhName("aeopcanc");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("AFILE"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("APROG"));
              if (m_Ctx.IsSharedTemp("aeopcanc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _progrig = Read_Cursor.GetString("PROGRES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_del_duplicati returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _progrig = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_progrig) */
              if (CPLib.Empty(_progrig)) {
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeopstor from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeopstor");
                m_cPhName = m_Ctx.GetPhName("aeopstor");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_del_duplicati",164,"00000021")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000021(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADTPRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDTPRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("PROGOPX"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ABBINATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("DATESITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("RSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("SALDO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("QUANTITA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("ANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("PROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("PROG2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("ESITOANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("PROGREC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("PROGBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("FILEANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("ABBSALDI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ANNOOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopstor",true);
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
                /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeopcanc from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeopcanc");
                m_cPhName = m_Ctx.GetPhName("aeopcanc");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_del_duplicati",164,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopcanc",true);
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
            } // End If
            Cursor_aeoprig.Next();
          }
          m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
          Cursor_aeoprig.Close();
          // * --- End Select
          Cursor_qbe_del_duplicati.Next();
        }
        m_cConnectivityError = Cursor_qbe_del_duplicati.ErrorMessage();
        Cursor_qbe_del_duplicati.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Sono state cancellate n. '+ LRTrim(Str(_conta,10,0)) + ' operazioni extraconto doppie' + NL */
        gMsgProc = gMsgProc+"Sono state cancellate n. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni extraconto doppie"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Terminata con successo !' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con successo !";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Terminata con errori!' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000013status,0)) {
          m_Sql.SetTransactionStatus(nTry00000013status,cTry00000013msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_del_duplicati!=null)
          Cursor_qbe_del_duplicati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_del_duplicatiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_del_duplicatiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    _conta = 0;
    _cicli = 0;
    _prog = 0;
    _progrig = CPLib.Space(10);
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_del_duplicati,
  public static final String m_cVQRList = ",qbe_del_duplicati,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000021(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGOPX,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"DATESITO,";
    p_cSql = p_cSql+"RSPEDITO,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"ESITOANNO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"PROGBASE,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ABBSALDI,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopstor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopcanc",true);
    return p_cSql;
  }
}
