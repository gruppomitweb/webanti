// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_operazioni_matchR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
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
  public String _gAzienda;
  public String gMsgImp;
  public String _gMsgProc;
  public double _conta;
  public String cProg;
  public String _errore;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_operazioni_matchR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_cgo_operazioni_match",m_Caller);
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
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
      return "arrt_cgo_operazioni_match";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_qbe_cgo_match_concessionario=null;
    CPResultSet Cursor_cgo_operazioni_dl=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _gAzienda Char(10) // Azienda */
      /* gMsgImp Char(10) // Messaggio Import */
      /* _gMsgProc Memo // Messaggio */
      /* _conta Numeric(10, 0) // Messaggio */
      /* cProg Char(20) */
      /* _errore Memo */
      /* Scorre la query e trasferisce i dati */
      /* Info Msg 'Lancio Match Operazioni' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Lancio Match Operazioni"));
      }
      /* _gMsgProc := 'Ora Inizio Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = "Ora Inizio Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        /* _conta := 0 // Messaggio */
        _conta = CPLib.Round(0,0);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000010status;
        nTry00000010status = m_Sql.GetTransactionStatus();
        String cTry00000010msg;
        cTry00000010msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from qbe_cgo_match_concessionario
          if (Cursor_qbe_cgo_match_concessionario!=null)
            Cursor_qbe_cgo_match_concessionario.Close();
          Cursor_qbe_cgo_match_concessionario = new VQRHolder("qbe_cgo_match_concessionario",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_cgo_match_concessionario.Eof())) {
            /* _conta := _conta + 1 // Messaggio */
            _conta = CPLib.Round(_conta+1,0);
            // * --- Select from cgo_operazioni_dl
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
            if (Cursor_cgo_operazioni_dl!=null)
              Cursor_cgo_operazioni_dl.Close();
            Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_qbe_cgo_match_concessionario.GetString("SNAINUMOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
              // * --- Write into cgo_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_operazioni_match",17,"00000014")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATAVALI"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NOME"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("CFESTERO"),"N",1,0)+", ";
              m_cSql = m_cSql+"MEZPAGAM = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"PEP = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PEP"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGCONT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("FLAGCONT"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TOTCONT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("TOTCONT"),"N",15,2)+", ";
              m_cSql = m_cSql+"IBAN = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("IBAN"),"C",40,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"CGOFLGVLT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CGOFLGVLT"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ASSEGNO = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("ASSEGNO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RDCODAUT"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"RDLOCAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RDLOCAUT"),"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"CC4CIFRE = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CC4CIFRE"),"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMTEL = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NUMTEL"),"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDDOCALL = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("IDDOCALL"),"C",36,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("FLGDOCALL"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CCANNSCA = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("CCANNSCA"),"N",4,0)+", ";
              m_cSql = m_cSql+"CCMESSCA = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("CCMESSCA"),"N",2,0)+", ";
              m_cSql = m_cSql+"NUMOPEDL = "+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOPEDL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_cgo_match_concessionario.GetString("SNAINUMOPE1"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_cgo_match_concessionario.GetString("SNAINUMOPE1"))+"";
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
              Cursor_cgo_operazioni_dl.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
            Cursor_cgo_operazioni_dl.Close();
            // * --- End Select
            /* Exec Routine arrt_snai_oper_save(qbe_cgo_match_concessionario->SNAINUMOPE1,'X',_gAzienda) */
            arrt_snai_oper_saveR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_match_concessionario.GetString("SNAINUMOPE1"),"X",_gAzienda);
            Cursor_qbe_cgo_match_concessionario.Next();
          }
          m_cConnectivityError = Cursor_qbe_cgo_match_concessionario.ErrorMessage();
          Cursor_qbe_cgo_match_concessionario.Close();
          // * --- End Select
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* _gMsgProc := _gMsgProc + 'Collegate '+LRTrim(Str(_conta,10,0))+" operazioni" + NL */
          _gMsgProc = _gMsgProc+"Collegate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni"+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* _errore := l_exeption.toString() */
          _errore = l_exeption.toString();
          /* _gMsgProc := _gMsgProc + _errore + NL */
          _gMsgProc = _gMsgProc+_errore+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000010status,0)) {
            m_Sql.SetTransactionStatus(nTry00000010status,cTry00000010msg);
          }
        }
        /* Exec Routine arrt_writelog('MATCH OPER.','Scheduler','RESULTS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("MATCH OPER.","Scheduler","RESULTS",_gMsgProc,"S");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_match_concessionario!=null)
          Cursor_qbe_cgo_match_concessionario.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
  public static arrt_cgo_operazioni_matchR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_operazioni_matchR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _gAzienda = CPLib.Space(10);
    _gMsgProc = "";
    _conta = 0;
    cProg = CPLib.Space(20);
    _errore = "";
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_match_concessionario,
  public static final String m_cVQRList = ",qbe_cgo_match_concessionario,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_snai_oper_save,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_snai_oper_save,arrt_writelog,";
  public static String[] m_cRunParameterNames={};
}
