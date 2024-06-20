// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_esito_dettagliato_reportR implements CallerWithObjs {
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
  public String m_cPhName_tmp_prnesiti;
  public String m_cServer_tmp_prnesiti;
  public String m_cPhName_tmp_prn_impesiti;
  public String m_cServer_tmp_prn_impesiti;
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
  public double totesiti;
  public double Countesito;
  public String _esito;
  public double _contaEsito;
  public double _max;
  public double _min;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public ReportLibrary _report;
  public double _nrep;
  public String _nomerep;
  public double _conta;
  public double totesito;
  public String gPathApp;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_esito_dettagliato_reportR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_esito_dettagliato_report",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
      m_cPhName_tmp_prnesiti = p_ContextObject.GetPhName("tmp_prnesiti");
      if (m_cPhName_tmp_prnesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_prnesiti = m_cPhName_tmp_prnesiti+" "+m_Ctx.GetWritePhName("tmp_prnesiti");
      }
      m_cServer_tmp_prnesiti = p_ContextObject.GetServer("tmp_prnesiti");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_prn_impesiti")) {
      m_cPhName_tmp_prn_impesiti = p_ContextObject.GetPhName("tmp_prn_impesiti");
      if (m_cPhName_tmp_prn_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_prn_impesiti = m_cPhName_tmp_prn_impesiti+" "+m_Ctx.GetWritePhName("tmp_prn_impesiti");
      }
      m_cServer_tmp_prn_impesiti = p_ContextObject.GetServer("tmp_prn_impesiti");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("totesiti",p_cVarName)) {
      return totesiti;
    }
    if (CPLib.eqr("Countesito",p_cVarName)) {
      return Countesito;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      return _contaEsito;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      return _nrep;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("totesito",p_cVarName)) {
      return totesito;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_esito_dettagliato_report";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("totesiti",p_cVarName)) {
      totesiti = value;
      return;
    }
    if (CPLib.eqr("Countesito",p_cVarName)) {
      Countesito = value;
      return;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      _contaEsito = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
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
    if (CPLib.eqr("_nrep",p_cVarName)) {
      _nrep = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("totesito",p_cVarName)) {
      totesito = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    CPResultSet Cursor_qbe_st_impesitis=null;
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_qbe_st_impesitis_dett=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* totesiti Numeric(8, 0) // totale generale degli esiti */
      /* Countesito Numeric(6, 0) // Contatore d'esito */
      /* _esito Char(200) // Descrizione dell'esito */
      /* _contaEsito Numeric(6, 0) // conteggio per esito */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _report Object(ReportLibrary) */
      /* _nrep Numeric(3, 0) */
      /* _nomerep Char(248) // Nome Stampa */
      /* _conta Numeric(15, 0) */
      /* totesito Numeric(6, 0) // totale esiti importati in tmp_prn_impesiti */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Memo // Messaggio Import */
      /* Crea il file per inserire i nomi delle stampe */
      // * --- Drop temporary table tmp_prnesiti
      if (m_Ctx.IsSharedTemp("tmp_prnesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prnesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prnesiti");
      }
      // * --- Create temporary table tmp_prnesiti
      if (m_Ctx.IsSharedTemp("tmp_prnesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prnesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prnesiti");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_prnesiti");
      if ( ! (m_Ctx.IsSharedTemp("tmp_prnesiti"))) {
        m_cServer = m_Ctx.GetServer("tmp_prnesiti");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_prnesiti",m_cServer,"proto")),m_cPhName,"tmp_prnesiti",m_Ctx);
      }
      m_cPhName_tmp_prnesiti = m_cPhName;
      /* Creo la tabella temporania per l'accumolo di 10000 record di ogni esito */
      // * --- Drop temporary table tmp_prn_impesiti
      if (m_Ctx.IsSharedTemp("tmp_prn_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prn_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prn_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prn_impesiti");
      }
      // * --- Create temporary table tmp_prn_impesiti
      if (m_Ctx.IsSharedTemp("tmp_prn_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prn_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prn_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prn_impesiti");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_prn_impesiti");
      if ( ! (m_Ctx.IsSharedTemp("tmp_prn_impesiti"))) {
        m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_prn_impesiti",m_cServer,"proto")),m_cPhName,"tmp_prn_impesiti",m_Ctx);
      }
      m_cPhName_tmp_prn_impesiti = m_cPhName;
      /* _report := ReportLibrary.GetReportLibrary() */
      _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
      /* _nrep := 0 */
      _nrep = CPLib.Round(0,0);
      // * --- Select from qbe_st_impesitis
      if (Cursor_qbe_st_impesitis!=null)
        Cursor_qbe_st_impesitis.Close();
      Cursor_qbe_st_impesitis = new VQRHolder("qbe_st_impesitis",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_st_impesitis.Eof())) {
        /* totesiti := totesiti+qbe_st_impesitis->tot // totale generale degli esiti */
        totesiti = CPLib.Round(totesiti+Cursor_qbe_st_impesitis.GetDouble("tot"),0);
        Cursor_qbe_st_impesitis.Next();
      }
      m_cConnectivityError = Cursor_qbe_st_impesitis.ErrorMessage();
      Cursor_qbe_st_impesitis.Close();
      // * --- End Select
      // * --- Select from qbe_st_impesitis
      if (Cursor_qbe_st_impesitis!=null)
        Cursor_qbe_st_impesitis.Close();
      Cursor_qbe_st_impesitis = new VQRHolder("qbe_st_impesitis",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_st_impesitis.Eof())) {
        /* _esito := qbe_st_impesitis->esito // Descrizione dell'esito */
        _esito = Cursor_qbe_st_impesitis.GetString("esito");
        /* Countesito := qbe_st_impesitis->tot // Contatore d'esito */
        Countesito = CPLib.Round(Cursor_qbe_st_impesitis.GetDouble("tot"),0);
        /* _contaEsito := 0 // conteggio per esito */
        _contaEsito = CPLib.Round(0,0);
        /* totesito := 0 // totale esiti importati in tmp_prn_impesiti */
        totesito = CPLib.Round(0,0);
        // * --- Select from qbe_tmp_impesiti_max_min
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
        Cursor_qbe_tmp_impesiti_max_min = new VQRHolder("qbe_tmp_impesiti_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tmp_impesiti_max_min.Eof())) {
          /* _max := qbe_tmp_impesiti_max_min->MAXPROGIMPESITI */
          _max = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MAXPROGIMPESITI"),0);
          /* _min := qbe_tmp_impesiti_max_min->MINPROGIMPESITI */
          _min = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MINPROGIMPESITI"),0);
          Cursor_qbe_tmp_impesiti_max_min.Next();
        }
        m_cConnectivityError = Cursor_qbe_tmp_impesiti_max_min.ErrorMessage();
        Cursor_qbe_tmp_impesiti_max_min.Close();
        // * --- End Select
        /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* While _contacilci<= _cicli */
        while (CPLib.le(_contacilci,_cicli)) {
          /* _bottom := ((_contacilci -1 ) * 10000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*10000)+1,0);
          /* _top := _contacilci * 10000 */
          _top = CPLib.Round(_contacilci*10000,0);
          /* gMsgImp := 'Elaborazione report al ' + LRTrim(Str((_contacilci/_cicli)*100,5,2)) + "%. Per l'esito: "+_esito // Messaggio allineamento 1 */
          gMsgImp = "Elaborazione report al "+CPLib.LRTrim(CPLib.Str((_contacilci/_cicli)*100,5,2))+"%. Per l'esito: "+_esito;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_st_impesitis_dett
            if (Cursor_qbe_st_impesitis_dett!=null)
              Cursor_qbe_st_impesitis_dett.Close();
            Cursor_qbe_st_impesitis_dett = new VQRHolder("qbe_st_impesitis_dett",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_st_impesitis_dett.Eof())) {
              // * --- Insert into tmp_prn_impesiti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
              m_cPhName = m_Ctx.GetPhName("tmp_prn_impesiti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prn_impesiti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_dettagliato_report",79,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("idbase"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("esito"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("nprog"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("nomefile"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("trueident"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("rapporto"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("tipoac"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("connes"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("ragsoc"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("codfisc"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("persona"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("cognome"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("nome"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("sesso"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetDate("datanasc"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("nascomun"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("tipinter"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("desccit"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("provincia"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetString("codcab"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_st_impesitis_dett.GetDouble("PROGIMPESITI"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_prn_impesiti",true);
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
              /* totesito := totesito+1 // totale esiti importati in tmp_prn_impesiti */
              totesito = CPLib.Round(totesito+1,0);
              /* If totesito=10000 */
              if (CPLib.eqr(totesito,10000)) {
                /* _report.setParameterChar('totesiti',Right('000000'+LRTrim(Str(totesiti,6,0)),10)) */
                _report.setParameterChar("totesiti",CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(totesiti,6,0)),10));
                /* _report.setParameterChar('Countesito',Right('00000000'+LRTrim(Str(Countesito,8,0)),10)) */
                _report.setParameterChar("Countesito",CPLib.Right("00000000"+CPLib.LRTrim(CPLib.Str(Countesito,8,0)),10));
                /* _nomerep := 'arrp_stpesito_dettagliato_'+Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(_esito,' ','_'),':',''),'/',''),'\',''),'<',''),'>',''),'*',''),'"',''),"'",""),'+',''),'!',''),'&',''),'%','')+"_"+LRTrim(Str(_conta,10,0))+Left(DateTimeToChar(DateTime()),12) // Nome Stampa */
                _nomerep = "arrp_stpesito_dettagliato_"+CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(_esito," ","_"),":",""),"/",""),"\\",""),"<",""),">",""),"*",""),"\"",""),"'",""),"+",""),"!",""),"&",""),"%","")+"_"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+CPLib.Left(CPLib.DateTimeToChar(CPLib.DateTime()),12);
                /* If _report.makeReport('arrp_stpesito_dettagliato',LRTrim(gPathApp)+"/stampe_off/"+LRTrim(_nomerep),'A4','PORTRAIT','PDF') */
                if (_report.makeReport("arrp_stpesito_dettagliato",CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(_nomerep),"A4","PORTRAIT","PDF")) {
                  // * --- Insert into tmp_prnesiti from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_prnesiti");
                  m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prnesiti",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_dettagliato_report",79,"00000036")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000036(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_esito,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_nomerep,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_prnesiti",true);
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
                  /* _nrep := _nrep + 1 */
                  _nrep = CPLib.Round(_nrep+1,0);
                } // End If
                /* _report.cleanObj() */
                _report.cleanObj();
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                // * --- Delete from tmp_prn_impesiti
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
                m_cPhName = m_Ctx.GetPhName("tmp_prn_impesiti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prn_impesiti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_dettagliato_report",79,"0000003A")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
                /* totesito := 0 // totale esiti importati in tmp_prn_impesiti */
                totesito = CPLib.Round(0,0);
              } // End If
              Cursor_qbe_st_impesitis_dett.Next();
            }
            m_cConnectivityError = Cursor_qbe_st_impesitis_dett.ErrorMessage();
            Cursor_qbe_st_impesitis_dett.Close();
            // * --- End Select
          } // End If
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
        /* If totesito<>0 */
        if (CPLib.ne(totesito,0)) {
          /* _report.setParameterChar('totesiti',Right('000000'+LRTrim(Str(totesiti,6,0)),10)) */
          _report.setParameterChar("totesiti",CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(totesiti,6,0)),10));
          /* _report.setParameterChar('Countesito',Right('00000000'+LRTrim(Str(Countesito,8,0)),10)) */
          _report.setParameterChar("Countesito",CPLib.Right("00000000"+CPLib.LRTrim(CPLib.Str(Countesito,8,0)),10));
          /* _nomerep := 'arrp_stpesito_dettagliato_'+Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(Strtran(_esito,' ','_'),':',''),'/',''),'\',''),'<',''),'>',''),'*',''),'"',''),"'",""),'+',''),'!',''),'&',''),'%','')+"_"+LRTrim(Str(_conta,10,0))+Left(DateTimeToChar(DateTime()),12) // Nome Stampa */
          _nomerep = "arrp_stpesito_dettagliato_"+CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(CPLib.Strtran(_esito," ","_"),":",""),"/",""),"\\",""),"<",""),">",""),"*",""),"\"",""),"'",""),"+",""),"!",""),"&",""),"%","")+"_"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+CPLib.Left(CPLib.DateTimeToChar(CPLib.DateTime()),12);
          /* If _report.makeReport('arrp_stpesito_dettagliato',LRTrim(gPathApp)+"/stampe_off/"+LRTrim(_nomerep),'A4','PORTRAIT','PDF') */
          if (_report.makeReport("arrp_stpesito_dettagliato",CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(_nomerep),"A4","PORTRAIT","PDF")) {
            // * --- Insert into tmp_prnesiti from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_prnesiti");
            m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prnesiti",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_dettagliato_report",79,"00000042")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000042(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_esito,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomerep,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_prnesiti",true);
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
            /* _nrep := _nrep + 1 */
            _nrep = CPLib.Round(_nrep+1,0);
          } // End If
          /* _report.cleanObj() */
          _report.cleanObj();
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          // * --- Delete from tmp_prn_impesiti
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_prn_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prn_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prn_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_dettagliato_report",79,"00000046")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        Cursor_qbe_st_impesitis.Next();
      }
      m_cConnectivityError = Cursor_qbe_st_impesitis.ErrorMessage();
      Cursor_qbe_st_impesitis.Close();
      // * --- End Select
      /* gMsgImp := 'Fine Elaborazione.' // Messaggio allineamento 1 */
      gMsgImp = "Fine Elaborazione.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If _nrep = 0 */
      if (CPLib.eqr(_nrep,0)) {
        /* Return  */
        Forward f;
        f=new Forward("arpg_allinea_anagrafiche_noreport",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Return  */
        Forward f;
        f=new Forward("arpg_import_esito_dettaglio_report",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_st_impesitis!=null)
          Cursor_qbe_st_impesitis.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_st_impesitis_dett!=null)
          Cursor_qbe_st_impesitis_dett.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_esito_dettagliato_reportR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_esito_dettagliato_reportR(p_Ctx, p_Caller);
  }
  public void Blank() {
    totesiti = 0;
    Countesito = 0;
    _esito = CPLib.Space(200);
    _contaEsito = 0;
    _max = 0;
    _min = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    _report = null;
    _nrep = 0;
    _nomerep = CPLib.Space(248);
    _conta = 0;
    totesito = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_st_impesitis,qbe_st_impesitis,qbe_tmp_impesiti_max_min,qbe_st_impesitis_dett,
  public static final String m_cVQRList = ",qbe_st_impesitis,qbe_st_impesitis,qbe_tmp_impesiti_max_min,qbe_st_impesitis_dett,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"trueident,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"tipoac,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"codfisc,";
    p_cSql = p_cSql+"persona,";
    p_cSql = p_cSql+"cognome,";
    p_cSql = p_cSql+"nome,";
    p_cSql = p_cSql+"sesso,";
    p_cSql = p_cSql+"datanasc,";
    p_cSql = p_cSql+"nascomun,";
    p_cSql = p_cSql+"tipinter,";
    p_cSql = p_cSql+"desccit,";
    p_cSql = p_cSql+"provincia,";
    p_cSql = p_cSql+"codcab,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_prn_impesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000036(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESITO,";
    p_cSql = p_cSql+"NOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_prnesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000042(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESITO,";
    p_cSql = p_cSql+"NOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_prnesiti",true);
    return p_cSql;
  }
}
