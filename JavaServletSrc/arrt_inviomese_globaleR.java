// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_inviomese_globaleR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
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
  public java.sql.Date w_dadatag;
  public java.sql.Date w_a_datag;
  public String w_bloccaedit;
  public String w_errore;
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public double _conta;
  public String _idriga;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public double nProgImp;
  public double nProgImp2;
  public String _cfestero;
  public String _cfimport;
  public double _chkimp;
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public String gMsgImp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_inviomese_globaleR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_inviomese_globale",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    if (m_cPhName_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aestor = m_cPhName_aestor+" "+m_Ctx.GetWritePhName("aestor");
    }
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("_chkimp",p_cVarName)) {
      return _chkimp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_inviomese_globale";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("bloccaedit",p_cVarName)) {
      return w_bloccaedit;
    }
    if (CPLib.eqr("errore",p_cVarName)) {
      return w_errore;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      return _idriga;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("_cfimport",p_cVarName)) {
      return _cfimport;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadatag",p_cVarName)) {
      return w_dadatag;
    }
    if (CPLib.eqr("a_datag",p_cVarName)) {
      return w_a_datag;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
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
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      nProgImp2 = value;
      return;
    }
    if (CPLib.eqr("_chkimp",p_cVarName)) {
      _chkimp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("bloccaedit",p_cVarName)) {
      w_bloccaedit = value;
      return;
    }
    if (CPLib.eqr("errore",p_cVarName)) {
      w_errore = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      _idriga = value;
      return;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
      return;
    }
    if (CPLib.eqr("_cfimport",p_cVarName)) {
      _cfimport = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadatag",p_cVarName)) {
      w_dadatag = value;
      return;
    }
    if (CPLib.eqr("a_datag",p_cVarName)) {
      w_a_datag = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
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
    /* w_dadatag Date */
    /* w_a_datag Date */
    /* w_bloccaedit Char(1) */
    /* w_errore Char(120) */
    /* _errlog Memo */
    /* imprec Numeric(10, 0) */
    /* _noprot Numeric(1, 0) */
    /* _rapold Char(25) */
    /* _tipoco Char(1) */
    /* _nriga Numeric(4, 0) */
    /* _newrow Numeric(4, 0) */
    /* _conta Numeric(10, 0) */
    /* _idriga Char(10) */
    /* _idriga Char(10) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* nProgImp Numeric(15, 0) */
    /* nProgImp2 Numeric(15, 0) */
    /* _cfestero Char(1) */
    /* _cfimport Char(16) */
    /* _chkimp Numeric(1, 0) */
    /* w_dadata Date */
    /* w_a_data Date */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gAzienda Char(10) // Azienda */
    /* Ripulisce i dati */
    /* w_dadata := w_dadatag */
    w_dadata = w_dadatag;
    /* w_a_data := w_a_datag */
    w_a_data = w_a_datag;
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000024status;
    nTry00000024status = m_Sql.GetTransactionStatus();
    String cTry00000024msg;
    cTry00000024msg = m_Sql.TransactionErrorMessage();
    try {
      /* gMsgImp := 'Preparazione tabelle di destinazione...' */
      gMsgImp = "Preparazione tabelle di destinazione...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from aeannora
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aeannora");
      m_cPhName = m_Ctx.GetPhName("aeannora");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000027")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aerighe
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000028")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aetesta
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aetesta");
      m_cPhName = m_Ctx.GetPhName("aetesta");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000029")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aecanc
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aecanc");
      m_cPhName = m_Ctx.GetPhName("aecanc");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aecanc",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002A")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aestor
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aestor");
      m_cPhName = m_Ctx.GetPhName("aestor");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aestor",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002B")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aestor
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aestor");
      m_cPhName = m_Ctx.GetPhName("aestor");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aestor",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002C")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Delete from aefiles
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles");
      m_cPhName = m_Ctx.GetPhName("aefiles");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002D")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Write into anarapbo from all
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("anarapbo");
      m_cPhName = m_Ctx.GetPhName("anarapbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Write into jnarapbo from all
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jnarapbo");
      m_cPhName = m_Ctx.GetPhName("jnarapbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000002F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Write into intestbo from all
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      // * --- Write into jntestbo from all
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jntestbo");
      m_cPhName = m_Ctx.GetPhName("jntestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000031")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      /* Exec "Import Dati" Page 2:Page_2 */
      Page_2();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      /* gMsgImp := 'Elaborate ' + LRTrim(Str(imprec,10,0)) + " informazioni" */
      gMsgImp = "Elaborate "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+" informazioni";
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
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000024status,0)) {
        m_Sql.SetTransactionStatus(nTry00000024status,cTry00000024msg);
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_inviomens_9_max_min=null;
    CPResultSet Cursor_qbe_inviomens_9=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_qbe_inviomens_10_max_min=null;
    CPResultSet Cursor_qbe_inviomens_10=null;
    CPResultSet Cursor_qbe_inviomens_11_max_min=null;
    CPResultSet Cursor_qbe_inviomens_11=null;
    CPResultSet Cursor_jnarapbo=null;
    CPResultSet Cursor_qbe_inviomens_12_max_min=null;
    CPResultSet Cursor_qbe_inviomens_12=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae dati per invio periodico */
      /* gMsgImp := 'Inizio importazione dati' // Messaggio Import */
      gMsgImp = "Inizio importazione dati";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      // * --- Select from qbe_inviomens_9_max_min
      if (Cursor_qbe_inviomens_9_max_min!=null)
        Cursor_qbe_inviomens_9_max_min.Close();
      Cursor_qbe_inviomens_9_max_min = new VQRHolder("qbe_inviomens_9_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_9_max_min.Eof())) {
        /* _max := qbe_inviomens_9_max_min->MAXPRGIMPSOG */
        _max = CPLib.Round(Cursor_qbe_inviomens_9_max_min.GetDouble("MAXPRGIMPSOG"),0);
        /* _min := qbe_inviomens_9_max_min->MINPRGIMPSOG */
        _min = CPLib.Round(Cursor_qbe_inviomens_9_max_min.GetDouble("MINPRGIMPSOG"),0);
        Cursor_qbe_inviomens_9_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_9_max_min.ErrorMessage();
      Cursor_qbe_inviomens_9_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 1000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*1000)+1,0);
        /* _top := _conta * 1000 */
        _top = CPLib.Round(_conta*1000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviomens_9
          if (Cursor_qbe_inviomens_9!=null)
            Cursor_qbe_inviomens_9.Close();
          Cursor_qbe_inviomens_9 = new VQRHolder("qbe_inviomens_9",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviomens_9.Eof())) {
            /* _chkimp := 0 */
            _chkimp = CPLib.Round(0,0);
            /* _cfestero := 'N' */
            _cfestero = "N";
            /* _cfimport := '' */
            _cfimport = "";
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODFISC,CFESTERO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _cfestero := iif(personbo->CFESTERO=1,'S','N') */
              _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"S":"N");
              /* _cfimport := personbo->CODFISC */
              _cfimport = Cursor_personbo.GetString("CODFISC");
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* imprec := imprec + 1 */
            imprec = CPLib.Round(imprec+1,0);
            /* gMsgImp := "Import informazioni d'apertura AUI: "+LRTrim(Str(imprec,10,0))+". Operazione 1 di 4" // Messaggio Import */
            gMsgImp = "Import informazioni d'apertura AUI: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+". Operazione 1 di 4";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _chkimp := iif(Len(LRTrim(_cfimport)) > 0,1,0) */
            _chkimp = CPLib.Round((CPLib.gt(CPLib.Len(CPLib.LRTrim(_cfimport)),0)?1:0),0);
            /* If _chkimp = 0 and _cfestero = 'S' */
            if (CPLib.eqr(_chkimp,0) && CPLib.eqr(_cfestero,"S")) {
              /* _chkimp := 1 */
              _chkimp = CPLib.Round(1,0);
            } // End If
            /* If _chkimp = 1 */
            if (CPLib.eqr(_chkimp,1)) {
              /* _rapold := '' */
              _rapold = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapold = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapold = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapold)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapold))) {
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  /* _tipoco := iif(anarapbo->TIPORAP='1','1','2') */
                  _tipoco = (CPLib.eqr(Cursor_anarapbo.GetString("TIPORAP"),"1")?"1":"2");
                  /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000056")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000056(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
              } // End If
              /* _nriga := 0 */
              _nriga = CPLib.Round(0,0);
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"));
              m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nriga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _nriga = 0 */
              if (CPLib.eqr(_nriga,0)) {
                /* _newrow := 1 */
                _newrow = CPLib.Round(1,0);
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* _newrow := _newrow + 1 */
                  _newrow = CPLib.Round(_newrow+1,0);
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
                /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000005E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000005E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_newrow,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_inviomens_9.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
                // * --- Write into anarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000005F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
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
              } else { // Else
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer, m_oParameters),m_cServer,_nriga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* If aerighe->ASPEDITO=0 */
                  if (CPLib.eqr(Cursor_aerighe.GetDouble("ASPEDITO"),0)) {
                    /* If Empty(aerighe->ADATA) */
                    if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000063")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_9.GetDate("DATAINI"),"D",8,0)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into anarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("anarapbo");
                      m_cPhName = m_Ctx.GetPhName("anarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000064")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
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
                    /* If Empty(LRTrim(aerighe->CONNESINT)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_aerighe.GetString("CONNESINT")))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000066")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(Cursor_qbe_inviomens_9.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into anarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("anarapbo");
                      m_cPhName = m_Ctx.GetPhName("anarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000067")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
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
                  } // End If
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
              } // End If
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000068")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(Cursor_qbe_inviomens_9.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("CODINTER"))+"";
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
            Cursor_qbe_inviomens_9.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviomens_9.ErrorMessage();
          Cursor_qbe_inviomens_9.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* Chiusure AUI */
      // * --- Select from qbe_inviomens_10_max_min
      if (Cursor_qbe_inviomens_10_max_min!=null)
        Cursor_qbe_inviomens_10_max_min.Close();
      Cursor_qbe_inviomens_10_max_min = new VQRHolder("qbe_inviomens_10_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_10_max_min.Eof())) {
        /* _max := qbe_inviomens_10_max_min->MAXPRGIMPRAP */
        _max = CPLib.Round(Cursor_qbe_inviomens_10_max_min.GetDouble("MAXPRGIMPRAP"),0);
        /* _min := qbe_inviomens_10_max_min->MINPRGIMPRAP */
        _min = CPLib.Round(Cursor_qbe_inviomens_10_max_min.GetDouble("MINPRGIMPRAP"),0);
        Cursor_qbe_inviomens_10_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_10_max_min.ErrorMessage();
      Cursor_qbe_inviomens_10_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 1000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*1000)+1,0);
        /* _top := _conta * 1000 */
        _top = CPLib.Round(_conta*1000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviomens_10
          if (Cursor_qbe_inviomens_10!=null)
            Cursor_qbe_inviomens_10.Close();
          Cursor_qbe_inviomens_10 = new VQRHolder("qbe_inviomens_10",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviomens_10.Eof())) {
            /* _cfestero := 'N' */
            _cfestero = "N";
            /* _chkimp := 0 */
            _chkimp = CPLib.Round(0,0);
            /* _cfimport := '' */
            _cfimport = "";
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODFISC,CFESTERO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _cfestero := iif(personbo->CFESTERO=1,'S','N') */
              _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"S":"N");
              /* _cfimport := personbo->CODFISC */
              _cfimport = Cursor_personbo.GetString("CODFISC");
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* imprec := imprec + 1 */
            imprec = CPLib.Round(imprec+1,0);
            /* gMsgImp := "Import informazioni di chiusura AUI: "+LRTrim(Str(imprec,10,0))+". Operazione 2 di 4" // Messaggio Import */
            gMsgImp = "Import informazioni di chiusura AUI: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+". Operazione 2 di 4";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _chkimp := iif(Len(LRTrim(_cfimport)) > 0,1,0) */
            _chkimp = CPLib.Round((CPLib.gt(CPLib.Len(CPLib.LRTrim(_cfimport)),0)?1:0),0);
            /* If _chkimp = 0 and _cfestero = 'S' */
            if (CPLib.eqr(_chkimp,0) && CPLib.eqr(_cfestero,"S")) {
              /* _chkimp := 1 */
              _chkimp = CPLib.Round(1,0);
            } // End If
            /* If _chkimp = 1 */
            if (CPLib.eqr(_chkimp,1)) {
              /* _rapold := '' */
              _rapold = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapold = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapold = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapold)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapold))) {
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  /* _tipoco := iif(anarapbo->TIPORAP='1','1','2') */
                  _tipoco = (CPLib.eqr(Cursor_anarapbo.GetString("TIPORAP"),"1")?"1":"2");
                  /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000088")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000088(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
              } // End If
              /* _nriga := 0 */
              _nriga = CPLib.Round(0,0);
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"));
              m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nriga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _nriga = 0 */
              if (CPLib.eqr(_nriga,0)) {
                /* _newrow := 1 */
                _newrow = CPLib.Round(1,0);
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* _newrow := _newrow + 1 */
                  _newrow = CPLib.Round(_newrow+1,0);
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
                /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000090")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000090(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_newrow,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_inviomens_10.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
                // * --- Write into anarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000091")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"))+"";
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
              } else { // Else
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer, m_oParameters),m_cServer,_nriga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* If aerighe->CSPEDITO=0 */
                  if (CPLib.eqr(Cursor_aerighe.GetDouble("CSPEDITO"),0)) {
                    /* If Empty(aerighe->CDATA) */
                    if (CPLib.Empty(Cursor_aerighe.GetDate("CDATA"))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000095")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_10.GetDate("DATAFINE"),"D",8,0)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into anarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("anarapbo");
                      m_cPhName = m_Ctx.GetPhName("anarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000096")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"))+"";
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
                    /* If Empty(LRTrim(aerighe->CONNESINT)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_aerighe.GetString("CONNESINT")))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000098")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(Cursor_qbe_inviomens_9.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_9.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_9.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into anarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("anarapbo");
                      m_cPhName = m_Ctx.GetPhName("anarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"00000099")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"))+"";
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
                  } // End If
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
              } // End If
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"0000009A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_10.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(Cursor_qbe_inviomens_10.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_10.GetString("CODINTER"))+"";
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
            Cursor_qbe_inviomens_10.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviomens_10.ErrorMessage();
          Cursor_qbe_inviomens_10.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      // * --- Select from qbe_inviomens_11_max_min
      if (Cursor_qbe_inviomens_11_max_min!=null)
        Cursor_qbe_inviomens_11_max_min.Close();
      Cursor_qbe_inviomens_11_max_min = new VQRHolder("qbe_inviomens_11_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_11_max_min.Eof())) {
        /* _max := qbe_inviomens_11_max_min->MAXPRGIMPSOG */
        _max = CPLib.Round(Cursor_qbe_inviomens_11_max_min.GetDouble("MAXPRGIMPSOG"),0);
        /* _min := qbe_inviomens_11_max_min->MINPRGIMPSOG */
        _min = CPLib.Round(Cursor_qbe_inviomens_11_max_min.GetDouble("MINPRGIMPSOG"),0);
        Cursor_qbe_inviomens_11_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_11_max_min.ErrorMessage();
      Cursor_qbe_inviomens_11_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta<=_cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 1000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*1000)+1,0);
        /* _top := _conta * 1000 */
        _top = CPLib.Round(_conta*1000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviomens_11
          if (Cursor_qbe_inviomens_11!=null)
            Cursor_qbe_inviomens_11.Close();
          Cursor_qbe_inviomens_11 = new VQRHolder("qbe_inviomens_11",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviomens_11.Eof())) {
            /* _cfestero := 'N' */
            _cfestero = "N";
            /* _chkimp := 0 */
            _chkimp = CPLib.Round(0,0);
            /* _cfimport := '' */
            _cfimport = "";
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODFISC,CFESTERO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _cfestero := iif(personbo->CFESTERO=1,'S','N') */
              _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"S":"N");
              /* _cfimport := personbo->CODFISC */
              _cfimport = Cursor_personbo.GetString("CODFISC");
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* gMsgImp := "Import informazioni d'apertura AGE: "+LRTrim(Str(imprec,10,0))+". Operazione 3 di 4" // Messaggio Import */
            gMsgImp = "Import informazioni d'apertura AGE: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+". Operazione 3 di 4";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* imprec := imprec + 1 */
            imprec = CPLib.Round(imprec+1,0);
            /* _chkimp := iif(Len(LRTrim(_cfimport)) > 0,1,0) */
            _chkimp = CPLib.Round((CPLib.gt(CPLib.Len(CPLib.LRTrim(_cfimport)),0)?1:0),0);
            /* If _chkimp = 0 and _cfestero = 'S' */
            if (CPLib.eqr(_chkimp,0) && CPLib.eqr(_cfestero,"S")) {
              /* _chkimp := 1 */
              _chkimp = CPLib.Round(1,0);
            } // End If
            /* If _chkimp = 1 */
            if (CPLib.eqr(_chkimp,1)) {
              /* _rapold := '' */
              _rapold = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapold = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapold = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapold)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapold))) {
                // * --- Select from jnarapbo
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                if (Cursor_jnarapbo!=null)
                  Cursor_jnarapbo.Close();
                Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jnarapbo.Eof())) {
                  /* _tipoco := iif(jnarapbo->TIPORAP='1','1','2') */
                  _tipoco = (CPLib.eqr(Cursor_jnarapbo.GetString("TIPORAP"),"1")?"1":"2");
                  /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000B9(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
                  Cursor_jnarapbo.Next();
                }
                m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
                Cursor_jnarapbo.Close();
                // * --- End Select
              } // End If
              /* _nriga := 0 */
              _nriga = CPLib.Round(0,0);
              /* _idriga := '' */
              _idriga = "";
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"));
              m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDRIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                _idriga = Read_Cursor.GetString("IDRIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nriga = 0;
                _idriga = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _nriga=0 */
              if (CPLib.eqr(_nriga,0)) {
                /* _newrow := 1 */
                _newrow = CPLib.Round(1,0);
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* _newrow := _newrow + 1 */
                  _newrow = CPLib.Round(_newrow+1,0);
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
                /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_newrow,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_inviomens_11.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
                // * --- Write into jnarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000C3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
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
              } else { // Else
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer, m_oParameters),m_cServer,_nriga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* If aerighe->ASPEDITO=0 */
                  if (CPLib.eqr(Cursor_aerighe.GetDouble("ASPEDITO"),0)) {
                    /* If Empty(aerighe->ADATA) */
                    if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_11.GetDate("DATAINI"),"D",8,0)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into jnarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
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
                    /* If Empty(LRTrim(aerighe->CONNESINT)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_aerighe.GetString("CONNESINT")))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(Cursor_qbe_inviomens_11.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into jnarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000CB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
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
                  } // End If
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
              } // End If
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000CC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_11.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_11.GetString("CODINTER"))+"";
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
            Cursor_qbe_inviomens_11.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviomens_11.ErrorMessage();
          Cursor_qbe_inviomens_11.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      // * --- Select from qbe_inviomens_12_max_min
      if (Cursor_qbe_inviomens_12_max_min!=null)
        Cursor_qbe_inviomens_12_max_min.Close();
      Cursor_qbe_inviomens_12_max_min = new VQRHolder("qbe_inviomens_12_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_12_max_min.Eof())) {
        /* _max := qbe_inviomens_12_max_min->MAXPRGIMPSOG */
        _max = CPLib.Round(Cursor_qbe_inviomens_12_max_min.GetDouble("MAXPRGIMPSOG"),0);
        /* _min := qbe_inviomens_12_max_min->MINPRGIMPSOG */
        _min = CPLib.Round(Cursor_qbe_inviomens_12_max_min.GetDouble("MINPRGIMPSOG"),0);
        Cursor_qbe_inviomens_12_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_12_max_min.ErrorMessage();
      Cursor_qbe_inviomens_12_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta<=_cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 1000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*1000)+1,0);
        /* _top := _conta * 1000 */
        _top = CPLib.Round(_conta*1000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviomens_12
          if (Cursor_qbe_inviomens_12!=null)
            Cursor_qbe_inviomens_12.Close();
          Cursor_qbe_inviomens_12 = new VQRHolder("qbe_inviomens_12",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviomens_12.Eof())) {
            /* _chkimp := 0 */
            _chkimp = CPLib.Round(0,0);
            /* _cfimport := '' */
            _cfimport = "";
            /* _cfestero := 'N' */
            _cfestero = "N";
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODFISC,CFESTERO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _cfestero := iif(personbo->CFESTERO=1,'S','N') */
              _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"S":"N");
              /* _cfimport := personbo->CODFISC */
              _cfimport = Cursor_personbo.GetString("CODFISC");
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* gMsgImp := "Import informazioni di chiusura AGE: "+LRTrim(Str(imprec,10,0))+". Operazione 4 di 4" // Messaggio Import */
            gMsgImp = "Import informazioni di chiusura AGE: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+". Operazione 4 di 4";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* imprec := imprec + 1 */
            imprec = CPLib.Round(imprec+1,0);
            /* _chkimp := iif(Len(LRTrim(_cfimport)) > 0,1,0) */
            _chkimp = CPLib.Round((CPLib.gt(CPLib.Len(CPLib.LRTrim(_cfimport)),0)?1:0),0);
            /* If _chkimp = 0 and _cfestero = 'S' */
            if (CPLib.eqr(_chkimp,0) && CPLib.eqr(_cfestero,"S")) {
              /* _chkimp := 1 */
              _chkimp = CPLib.Round(1,0);
            } // End If
            /* If _chkimp = 1 */
            if (CPLib.eqr(_chkimp,1)) {
              /* _rapold := '' */
              _rapold = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapold = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapold = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapold)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapold))) {
                // * --- Select from jnarapbo
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                if (Cursor_jnarapbo!=null)
                  Cursor_jnarapbo.Close();
                Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jnarapbo.Eof())) {
                  /* _tipoco := iif(jnarapbo->TIPORAP='1','1','2') */
                  _tipoco = (CPLib.eqr(Cursor_jnarapbo.GetString("TIPORAP"),"1")?"1":"2");
                  /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000EB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000EB(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
                  Cursor_jnarapbo.Next();
                }
                m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
                Cursor_jnarapbo.Close();
                // * --- End Select
              } // End If
              /* _nriga := 0 */
              _nriga = CPLib.Round(0,0);
              /* _idriga := '' */
              _idriga = "";
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"));
              m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine arrt_inviomese_globale returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nriga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _nriga = 0 */
              if (CPLib.eqr(_nriga,0)) {
                /* _newrow := 1 */
                _newrow = CPLib.Round(1,0);
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* _newrow := _newrow + 1 */
                  _newrow = CPLib.Round(_newrow+1,0);
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
                /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000F4(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_newrow,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_inviomens_12.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
                // * --- Write into jnarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000F5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
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
              } else { // Else
                // * --- Select from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                if (Cursor_aerighe!=null)
                  Cursor_aerighe.Close();
                Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer, m_oParameters),m_cServer,_nriga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aerighe.Eof())) {
                  /* If aerighe->CSPEDITO=0 */
                  if (CPLib.eqr(Cursor_aerighe.GetDouble("CSPEDITO"),0)) {
                    /* If Empty(aerighe->CDATA) */
                    if (CPLib.Empty(Cursor_aerighe.GetDate("CDATA"))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000F9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_12.GetDate("DATAFINE"),"D",8,0)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into jnarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000FA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
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
                    /* If Empty(LRTrim(aerighe->CONNESINT)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_aerighe.GetString("CONNESINT")))) {
                      // * --- Write into aerighe from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000FC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(Cursor_qbe_inviomens_12.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
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
                      // * --- Write into jnarapbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000FD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
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
                  } // End If
                  Cursor_aerighe.Next();
                }
                m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                Cursor_aerighe.Close();
                // * --- End Select
              } // End If
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_globale",140,"000000FE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ABBINATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_12.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_12.GetString("CODINTER"))+"";
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
            Cursor_qbe_inviomens_12.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviomens_12.ErrorMessage();
          Cursor_qbe_inviomens_12.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Fine importazione dati. Totale Informazioni: '+LRTrim(Str(imprec,10,0)) // Messaggio Import */
      gMsgImp = "Fine importazione dati. Totale Informazioni: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_inviomens_9_max_min!=null)
          Cursor_qbe_inviomens_9_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_9!=null)
          Cursor_qbe_inviomens_9.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
        if (Cursor_qbe_inviomens_10_max_min!=null)
          Cursor_qbe_inviomens_10_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_10!=null)
          Cursor_qbe_inviomens_10.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_11_max_min!=null)
          Cursor_qbe_inviomens_11_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_11!=null)
          Cursor_qbe_inviomens_11.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_12_max_min!=null)
          Cursor_qbe_inviomens_12_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_12!=null)
          Cursor_qbe_inviomens_12.Close();
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
      m_Caller.SetDate("dadatag","D",8,0,w_dadatag);
      m_Caller.SetDate("a_datag","D",8,0,w_a_datag);
      m_Caller.SetString("bloccaedit","C",1,0,w_bloccaedit);
      m_Caller.SetString("errore","C",120,0,w_errore);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_inviomese_globaleR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_inviomese_globaleR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_dadatag = m_Caller.GetDate("dadatag","D",8,0);
    w_a_datag = m_Caller.GetDate("a_datag","D",8,0);
    w_bloccaedit = m_Caller.GetString("bloccaedit","C",1,0);
    w_errore = m_Caller.GetString("errore","C",120,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _conta = 0;
    _idriga = CPLib.Space(10);
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    nProgImp = 0;
    nProgImp2 = 0;
    _cfestero = CPLib.Space(1);
    _cfimport = CPLib.Space(16);
    _chkimp = 0;
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_inviomens_9_max_min,qbe_inviomens_9,qbe_inviomens_10_max_min,qbe_inviomens_10,qbe_inviomens_11_max_min,qbe_inviomens_11,qbe_inviomens_12_max_min,qbe_inviomens_12,
  public static final String m_cVQRList = ",qbe_inviomens_9_max_min,qbe_inviomens_9,qbe_inviomens_10_max_min,qbe_inviomens_10,qbe_inviomens_11_max_min,qbe_inviomens_11,qbe_inviomens_12_max_min,qbe_inviomens_12,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000056(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000088(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000090(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
}
