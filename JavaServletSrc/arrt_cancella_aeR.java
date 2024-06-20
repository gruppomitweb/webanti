// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cancella_aeR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
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
  public java.sql.Date w_datchi;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String _coint;
  public String _tipage;
  public String _rifana;
  public String cProg;
  public String cCanc;
  public double _conta;
  public double _cicli;
  public double _bottom;
  public double _top;
  public double _max;
  public double _min;
  public double _tot;
  public double _totgen;
  public String _oldint;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cancella_aeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cancella_ae",m_Caller);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    if (m_cPhName_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aestor = m_cPhName_aestor+" "+m_Ctx.GetWritePhName("aestor");
    }
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_totgen",p_cVarName)) {
      return _totgen;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cancella_ae";
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
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      return _tipage;
    }
    if (CPLib.eqr("_rifana",p_cVarName)) {
      return _rifana;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("_oldint",p_cVarName)) {
      return _oldint;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      return w_datchi;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_totgen",p_cVarName)) {
      _totgen = value;
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
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      _tipage = value;
      return;
    }
    if (CPLib.eqr("_rifana",p_cVarName)) {
      _rifana = value;
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
    if (CPLib.eqr("_oldint",p_cVarName)) {
      _oldint = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      w_datchi = value;
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
    CPResultSet Cursor_qbe_minmax_aerighe=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_datchi Date */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _coint Char(1) */
      /* _tipage Char(2) */
      /* _rifana Char(1) */
      /* cProg Char(10) */
      /* cCanc Char(10) */
      /* _conta Numeric(10, 0) */
      /* _cicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _totgen Numeric(15, 0) */
      /* _oldint Char(16) */
      /* Verifica se deve modificare qualcosa */
      /* If not(Empty(w_datchi)) */
      if ( ! (CPLib.Empty(w_datchi))) {
        /* gMsgImp := 'Inizio cancellazione dati' // Messaggio Import */
        gMsgImp = "Inizio cancellazione dati";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000001Bstatus;
        nTry0000001Bstatus = m_Sql.GetTransactionStatus();
        String cTry0000001Bmsg;
        cTry0000001Bmsg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from qbe_minmax_aerighe
          if (Cursor_qbe_minmax_aerighe!=null)
            Cursor_qbe_minmax_aerighe.Close();
          Cursor_qbe_minmax_aerighe = new VQRHolder("qbe_minmax_aerighe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_minmax_aerighe.Eof())) {
            /* _min := qbe_minmax_aerighe->MINRIG */
            _min = CPLib.Round(Cursor_qbe_minmax_aerighe.GetDouble("MINRIG"),0);
            /* _max := qbe_minmax_aerighe->MAXRIG */
            _max = CPLib.Round(Cursor_qbe_minmax_aerighe.GetDouble("MAXRIG"),0);
            /* _totgen := qbe_minmax_aerighe->TOTRIG */
            _totgen = CPLib.Round(Cursor_qbe_minmax_aerighe.GetDouble("TOTRIG"),0);
            Cursor_qbe_minmax_aerighe.Next();
          }
          m_cConnectivityError = Cursor_qbe_minmax_aerighe.ErrorMessage();
          Cursor_qbe_minmax_aerighe.Close();
          // * --- End Select
          /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* _tot := 0 */
          _tot = CPLib.Round(0,0);
          /* While _conta <= _cicli */
          while (CPLib.le(_conta,_cicli)) {
            /* _bottom := ((_conta -1 ) * 10000) + 1 */
            _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
            /* _top := _conta * 10000 */
            _top = CPLib.Round(_conta*10000,0);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              if (Cursor_aerighe!=null)
                Cursor_aerighe.Close();
              Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGAER >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGAER <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aerighe.Eof())) {
                /* _tot := _tot + 1 */
                _tot = CPLib.Round(_tot+1,0);
                /* gMsgImp := 'Elaboro Informazione N. '+LRTrim(Str(_tot,15,0)) + " di "+ LRTrim(Str(_totgen,15,0)) // Messaggio Import */
                gMsgImp = "Elaboro Informazione N. "+CPLib.LRTrim(CPLib.Str(_tot,15,0))+" di "+CPLib.LRTrim(CPLib.Str(_totgen,15,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* _coint := '' */
                _coint = "";
                /* _tipage := '' */
                _tipage = "";
                /* _rifana := '' */
                _rifana = "";
                /* _oldint := '' */
                _oldint = "";
                // * --- Read from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
                if (m_Ctx.IsSharedTemp("aetesta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RIFANA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("OLDINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _tipage = Read_Cursor.GetString("TIPOAG");
                  _coint = Read_Cursor.GetString("COINT");
                  _rifana = Read_Cursor.GetString("RIFANA");
                  _oldint = Read_Cursor.GetString("OLDINTER");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aetesta into routine arrt_cancella_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _tipage = "";
                  _coint = "";
                  _rifana = "";
                  _oldint = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aestor from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aestor");
                m_cPhName = m_Ctx.GetPhName("aestor");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aestor",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cancella_ae",35,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aestor",true);
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
                // * --- Insert into aecanc from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aecanc");
                m_cPhName = m_Ctx.GetPhName("aecanc");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aecanc",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cancella_ae",35,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_oldint,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aecanc",true);
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
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgProc := gMsgProc + 'Sono state cancellate ' +LRTrim(Str(_tot,15,0)) + " informazioni su "+ LRTrim(Str(_totgen,15,0))+ NL */
          gMsgProc = gMsgProc+"Sono state cancellate "+CPLib.LRTrim(CPLib.Str(_tot,15,0))+" informazioni su "+CPLib.LRTrim(CPLib.Str(_totgen,15,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgProc := gMsgProc + 'Elaborazione abortita a causa di errori!'+NL */
          gMsgProc = gMsgProc+"Elaborazione abortita a causa di errori!"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Bstatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000001Bstatus,cTry0000001Bmsg);
          }
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_minmax_aerighe!=null)
          Cursor_qbe_minmax_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
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
      m_Caller.SetDate("datchi","D",8,0,w_datchi);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cancella_aeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cancella_aeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_datchi = m_Caller.GetDate("datchi","D",8,0);
    _coint = CPLib.Space(1);
    _tipage = CPLib.Space(2);
    _rifana = CPLib.Space(1);
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    _conta = 0;
    _cicli = 0;
    _bottom = 0;
    _top = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _totgen = 0;
    _oldint = CPLib.Space(16);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_minmax_aerighe,
  public static final String m_cVQRList = ",qbe_minmax_aerighe,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aestor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aecanc",true);
    return p_cSql;
  }
}
