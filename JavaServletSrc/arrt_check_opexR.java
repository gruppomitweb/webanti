// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_check_opexR implements CallerWithObjs {
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
  public String m_cPhName_appointestbo;
  public String m_cServer_appointestbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public String m_cPhName_tmp_erropxanno;
  public String m_cServer_tmp_erropxanno;
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
  public double _impope;
  public double _impfrz;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public String _anno;
  public String _idb;
  public double _prog;
  public String codage;
  public String _noopex;
  public String w_cdatini;
  public String w_cdatfin;
  public java.sql.Date _dataope;
  public String w_annoc;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_check_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_check_opex",m_Caller);
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
    m_cPhName_appointestbo = p_ContextObject.GetPhName("appointestbo");
    if (m_cPhName_appointestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_appointestbo = m_cPhName_appointestbo+" "+m_Ctx.GetWritePhName("appointestbo");
    }
    m_cServer_appointestbo = p_ContextObject.GetServer("appointestbo");
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
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_erropxanno")) {
      m_cPhName_tmp_erropxanno = p_ContextObject.GetPhName("tmp_erropxanno");
      if (m_cPhName_tmp_erropxanno.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_erropxanno = m_cPhName_tmp_erropxanno+" "+m_Ctx.GetWritePhName("tmp_erropxanno");
      }
      m_cServer_tmp_erropxanno = p_ContextObject.GetServer("tmp_erropxanno");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_impope",p_cVarName)) {
      return _impope;
    }
    if (CPLib.eqr("_impfrz",p_cVarName)) {
      return _impfrz;
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
      return "arrt_check_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return codage;
    }
    if (CPLib.eqr("_noopex",p_cVarName)) {
      return _noopex;
    }
    if (CPLib.eqr("cdatini",p_cVarName)) {
      return w_cdatini;
    }
    if (CPLib.eqr("cdatfin",p_cVarName)) {
      return w_cdatfin;
    }
    if (CPLib.eqr("annoc",p_cVarName)) {
      return w_annoc;
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
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
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
    if (CPLib.eqr("_impope",p_cVarName)) {
      _impope = value;
      return;
    }
    if (CPLib.eqr("_impfrz",p_cVarName)) {
      _impfrz = value;
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
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      codage = value;
      return;
    }
    if (CPLib.eqr("_noopex",p_cVarName)) {
      _noopex = value;
      return;
    }
    if (CPLib.eqr("cdatini",p_cVarName)) {
      w_cdatini = value;
      return;
    }
    if (CPLib.eqr("cdatfin",p_cVarName)) {
      w_cdatfin = value;
      return;
    }
    if (CPLib.eqr("annoc",p_cVarName)) {
      w_annoc = value;
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
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
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
    /* w_DaDatOpe Date */
    /* w_ADatOpe Date */
    /* w_anno Numeric(4, 0) */
    /* _impope Numeric(10, 0) */
    /* _impfrz Numeric(10, 0) */
    /* _conta Numeric(10, 0) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _anno Char(4) */
    /* _idb Char(10) */
    /* _prog Numeric(10, 0) */
    /* codage Char(5) // Codice Agenzia */
    /* _noopex Char(1) // Salta operazione */
    /* w_cdatini Char(8) // Data Inizio in caratteri */
    /* w_cdatfin Char(8) // Data fine in caratteri */
    /* _dataope Date */
    /* w_annoc Char(4) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gAzienda Char(10) // Azienda */
    /* Il controllo su NOPROT della tabella ANARAPBO viene fatto direttamente nelle QUERY */
    /* gMsgProc := '' // Messaggio */
    gMsgProc = "";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000001Estatus;
    nTry0000001Estatus = m_Sql.GetTransactionStatus();
    String cTry0000001Emsg;
    cTry0000001Emsg = m_Sql.TransactionErrorMessage();
    try {
      // * --- Drop temporary table tmp_erropxanno
      if (m_Ctx.IsSharedTemp("tmp_erropxanno")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_erropxanno")) {
          m_cServer = m_Ctx.GetServer("tmp_erropxanno");
          m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_erropxanno");
      }
      // * --- Create temporary table tmp_erropxanno
      if (m_Ctx.IsSharedTemp("tmp_erropxanno")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_erropxanno")) {
          m_cServer = m_Ctx.GetServer("tmp_erropxanno");
          m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_erropxanno");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_erropxanno");
      if ( ! (m_Ctx.IsSharedTemp("tmp_erropxanno"))) {
        m_cServer = m_Ctx.GetServer("tmp_erropxanno");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_erropxanno",m_cServer,"proto")),m_cPhName,"tmp_erropxanno",m_Ctx,new String[]{"CONNES"});
      }
      m_cPhName_tmp_erropxanno = m_cPhName;
      /* w_cdatini := DateToChar(w_DaDatOpe) // Data Inizio in caratteri */
      w_cdatini = CPLib.DateToChar(w_DaDatOpe);
      /* w_cdatfin := DateToChar(w_ADatOpe) // Data fine in caratteri */
      w_cdatfin = CPLib.DateToChar(w_ADatOpe);
      /* w_annoc := iif(w_anno > 0, Str(w_anno,4,0),Left(w_cdatini,4)) */
      w_annoc = (CPLib.gt(w_anno,0)?CPLib.Str(w_anno,4,0):CPLib.Left(w_cdatini,4));
      /* Exec "Operazioni" Page 2:Page_2 */
      Page_2();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      /* Exec "Frazionate" Page 3:Page_3 */
      Page_3();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      /* Exec "Operazioni AGE" Page 4:Page_4 */
      Page_4();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Estatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000001Estatus,cTry0000001Emsg);
      }
    }
    /* Stop arrp_check_opex.vrp */
    Forward f;
    f=new Forward("Report",false,this,Forward.Start,false);
    f.SetParameter("ReportName","arrp_check_opex.vrp");
    f.SetParameter("m_cParameterSequence","ReportName");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_genera_opex_limit_ope=null;
    CPResultSet Cursor_qbe_genera_opex_ope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _impope := 0 */
      _impope = CPLib.Round(0,0);
      // * --- Select from qbe_genera_opex_limit_ope
      SPBridge.HMCaller _h0000002F;
      _h0000002F = new SPBridge.HMCaller();
      _h0000002F.Set("m_cVQRList",m_cVQRList);
      _h0000002F.Set("cdatini",w_cdatini);
      _h0000002F.Set("cdatfin",w_cdatfin);
      if (Cursor_qbe_genera_opex_limit_ope!=null)
        Cursor_qbe_genera_opex_limit_ope.Close();
      Cursor_qbe_genera_opex_limit_ope = new VQRHolder("qbe_genera_opex_limit_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_genera_opex_limit_ope.Eof())) {
        /* _min := qbe_genera_opex_limit_ope->MIN */
        _min = CPLib.Round(Cursor_qbe_genera_opex_limit_ope.GetDouble("MIN"),0);
        /* _max := qbe_genera_opex_limit_ope->MAX */
        _max = CPLib.Round(Cursor_qbe_genera_opex_limit_ope.GetDouble("MAX"),0);
        Cursor_qbe_genera_opex_limit_ope.Next();
      }
      m_cConnectivityError = Cursor_qbe_genera_opex_limit_ope.ErrorMessage();
      Cursor_qbe_genera_opex_limit_ope.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*5000)+1,0);
        /* _top := _conta * 5000 */
        _top = CPLib.Round(_conta*5000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_genera_opex_ope
          SPBridge.HMCaller _h00000038;
          _h00000038 = new SPBridge.HMCaller();
          _h00000038.Set("m_cVQRList",m_cVQRList);
          _h00000038.Set("cdatini",w_cdatini);
          _h00000038.Set("cdatfin",w_cdatfin);
          _h00000038.Set("annoc",w_annoc);
          if (Cursor_qbe_genera_opex_ope!=null)
            Cursor_qbe_genera_opex_ope.Close();
          Cursor_qbe_genera_opex_ope = new VQRHolder("qbe_genera_opex_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000038,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_genera_opex_ope.Eof())) {
            /* _impope := _impope + 1 */
            _impope = CPLib.Round(_impope+1,0);
            /* codage := Left(qbe_genera_opex_ope->IDFILE,5) // Codice Agenzia */
            codage = CPLib.Left(Cursor_qbe_genera_opex_ope.GetString("IDFILE"),5);
            /* _noopex := '' // Salta operazione */
            _noopex = "";
            /* If not(Empty(LRTrim(codage))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(codage)))) {
              // * --- Read from tbmacage
              m_cServer = m_Ctx.GetServer("tbmacage");
              m_cPhName = m_Ctx.GetPhName("tbmacage");
              m_cSql = "";
              m_cSql = m_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(codage,"C",5,0,m_cServer),m_cServer,codage);
              if (m_Ctx.IsSharedTemp("tbmacage")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MAFLGNOX",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _noopex = Read_Cursor.GetString("MAFLGNOX");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _noopex = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(LRTrim(_noopex)) or _noopex='N' */
            if (CPLib.Empty(CPLib.LRTrim(_noopex)) || CPLib.eqr(_noopex,"N")) {
              /* gMsgImp := 'Elaboro il soggetto '+LRTrim(qbe_genera_opex_ope->CONNESCLI) +' per operazione in data '+arfn_fdate(qbe_genera_opex_ope->DATAOPE) // Messaggio Import */
              gMsgImp = "Elaboro il soggetto "+CPLib.LRTrim(Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"))+" per operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_genera_opex_ope.GetDate("DATAOPE"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _anno := Str(Year(qbe_genera_opex_ope->DATAOPE),4,0) */
              _anno = CPLib.Str(CPLib.Year(Cursor_qbe_genera_opex_ope.GetDate("DATAOPE")),4,0);
              /* _idb := '' */
              _idb = "";
              /* _dataope := NullDate() */
              _dataope = CPLib.NullDate();
              // * --- Read from tmp_erropxanno
              m_cServer = m_Ctx.GetServer("tmp_erropxanno");
              m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"));
              if (m_Ctx.IsSharedTemp("tmp_erropxanno")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dataope = Read_Cursor.GetDate("DATAOPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tmp_erropxanno into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dataope = CPLib.NullDate();
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_dataope) */
              if (CPLib.Empty(_dataope)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAGSOC,CODFISC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Insert into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000046")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000046(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erropxanno",true);
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                /* If _dataope > qbe_genera_opex_ope->DATAOPE */
                if (CPLib.gt(_dataope,Cursor_qbe_genera_opex_ope.GetDate("DATAOPE"))) {
                  // * --- Write into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000048")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetDate("DATAOPE"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_erropxanno",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"TIPERR = "+CPSql.SQLValueAdapter(CPLib.ToSQL("A","?",0,0,m_cServer),m_cServer,"A")+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_ope.GetString("CONNESCLI"))+"";
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
            } // End If
            Cursor_qbe_genera_opex_ope.Next();
          }
          m_cConnectivityError = Cursor_qbe_genera_opex_ope.ErrorMessage();
          Cursor_qbe_genera_opex_ope.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Sono stati elaborate n. '+ LRTrim(Str(_impope,10,0)) + ' operazioni' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborate n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_genera_opex_limit_ope!=null)
          Cursor_qbe_genera_opex_limit_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_genera_opex_ope!=null)
          Cursor_qbe_genera_opex_ope.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_genera_opex_limit_frz=null;
    CPResultSet Cursor_qbe_genera_opex_frz=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Frazionate */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_genera_opex_limit_frz
      SPBridge.HMCaller _h0000004E;
      _h0000004E = new SPBridge.HMCaller();
      _h0000004E.Set("m_cVQRList",m_cVQRList);
      _h0000004E.Set("cdatini",w_cdatini);
      _h0000004E.Set("cdatfin",w_cdatfin);
      if (Cursor_qbe_genera_opex_limit_frz!=null)
        Cursor_qbe_genera_opex_limit_frz.Close();
      Cursor_qbe_genera_opex_limit_frz = new VQRHolder("qbe_genera_opex_limit_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_genera_opex_limit_frz.Eof())) {
        /* _min := qbe_genera_opex_limit_frz->MIN */
        _min = CPLib.Round(Cursor_qbe_genera_opex_limit_frz.GetDouble("MIN"),0);
        /* _max := qbe_genera_opex_limit_frz->MAX */
        _max = CPLib.Round(Cursor_qbe_genera_opex_limit_frz.GetDouble("MAX"),0);
        Cursor_qbe_genera_opex_limit_frz.Next();
      }
      m_cConnectivityError = Cursor_qbe_genera_opex_limit_frz.ErrorMessage();
      Cursor_qbe_genera_opex_limit_frz.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _impfrz := 0 */
      _impfrz = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*5000)+1,0);
        /* _top := _conta * 5000 */
        _top = CPLib.Round(_conta*5000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_genera_opex_frz
          SPBridge.HMCaller _h00000058;
          _h00000058 = new SPBridge.HMCaller();
          _h00000058.Set("m_cVQRList",m_cVQRList);
          _h00000058.Set("cdatini",w_cdatini);
          _h00000058.Set("cdatfin",w_cdatfin);
          if (Cursor_qbe_genera_opex_frz!=null)
            Cursor_qbe_genera_opex_frz.Close();
          Cursor_qbe_genera_opex_frz = new VQRHolder("qbe_genera_opex_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000058,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_genera_opex_frz.Eof())) {
            /* _impfrz := _impfrz + 1 */
            _impfrz = CPLib.Round(_impfrz+1,0);
            /* codage := Left(qbe_genera_opex_frz->IDFILE,5) // Codice Agenzia */
            codage = CPLib.Left(Cursor_qbe_genera_opex_frz.GetString("IDFILE"),5);
            /* _noopex := '' // Salta operazione */
            _noopex = "";
            /* If not(Empty(LRTrim(codage))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(codage)))) {
              // * --- Read from tbmacage
              m_cServer = m_Ctx.GetServer("tbmacage");
              m_cPhName = m_Ctx.GetPhName("tbmacage");
              m_cSql = "";
              m_cSql = m_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(codage,"C",5,0,m_cServer),m_cServer,codage);
              if (m_Ctx.IsSharedTemp("tbmacage")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MAFLGNOX",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _noopex = Read_Cursor.GetString("MAFLGNOX");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _noopex = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(LRTrim(_noopex)) or _noopex='N' */
            if (CPLib.Empty(CPLib.LRTrim(_noopex)) || CPLib.eqr(_noopex,"N")) {
              /* gMsgImp := 'Elaboro il soggetto '+LRTrim(qbe_genera_opex_frz->CONNESCLI) +' per operazione in data '+arfn_fdate(qbe_genera_opex_frz->DATAOPE) // Messaggio Import */
              gMsgImp = "Elaboro il soggetto "+CPLib.LRTrim(Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"))+" per operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_genera_opex_frz.GetDate("DATAOPE"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _anno := Str(Year(qbe_genera_opex_frz->DATAOPE),4,0) */
              _anno = CPLib.Str(CPLib.Year(Cursor_qbe_genera_opex_frz.GetDate("DATAOPE")),4,0);
              /* _idb := '' */
              _idb = "";
              /* _dataope := NullDate() */
              _dataope = CPLib.NullDate();
              // * --- Read from tmp_erropxanno
              m_cServer = m_Ctx.GetServer("tmp_erropxanno");
              m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"));
              if (m_Ctx.IsSharedTemp("tmp_erropxanno")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dataope = Read_Cursor.GetDate("DATAOPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tmp_erropxanno into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dataope = CPLib.NullDate();
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_dataope) */
              if (CPLib.Empty(_dataope)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAGSOC,CODFISC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Insert into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000066")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000066(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erropxanno",true);
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                /* If _dataope > qbe_genera_opex_frz->DATAOPE */
                if (CPLib.gt(_dataope,Cursor_qbe_genera_opex_frz.GetDate("DATAOPE"))) {
                  // * --- Write into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000068")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetDate("DATAOPE"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_erropxanno",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"TIPERR = "+CPSql.SQLValueAdapter(CPLib.ToSQL("A","?",0,0,m_cServer),m_cServer,"A")+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_frz.GetString("CONNESCLI"))+"";
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
            } // End If
            Cursor_qbe_genera_opex_frz.Next();
          }
          m_cConnectivityError = Cursor_qbe_genera_opex_frz.ErrorMessage();
          Cursor_qbe_genera_opex_frz.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Sono stati elaborate n. '+ LRTrim(Str(_impfrz,10,0)) + ' frazionate' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborate n. "+CPLib.LRTrim(CPLib.Str(_impfrz,10,0))+" frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_genera_opex_limit_frz!=null)
          Cursor_qbe_genera_opex_limit_frz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_genera_opex_frz!=null)
          Cursor_qbe_genera_opex_frz.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_genera_opex_limit_jpe=null;
    CPResultSet Cursor_qbe_genera_opex_jpe=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni AGE' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _impope := 0 */
      _impope = CPLib.Round(0,0);
      // * --- Select from qbe_genera_opex_limit_jpe
      SPBridge.HMCaller _h0000006F;
      _h0000006F = new SPBridge.HMCaller();
      _h0000006F.Set("m_cVQRList",m_cVQRList);
      _h0000006F.Set("cdatini",w_cdatini);
      _h0000006F.Set("cdatfin",w_cdatfin);
      if (Cursor_qbe_genera_opex_limit_jpe!=null)
        Cursor_qbe_genera_opex_limit_jpe.Close();
      Cursor_qbe_genera_opex_limit_jpe = new VQRHolder("qbe_genera_opex_limit_jpe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_genera_opex_limit_jpe.Eof())) {
        /* _min := qbe_genera_opex_limit_jpe->MIN */
        _min = CPLib.Round(Cursor_qbe_genera_opex_limit_jpe.GetDouble("MIN"),0);
        /* _max := qbe_genera_opex_limit_jpe->MAX */
        _max = CPLib.Round(Cursor_qbe_genera_opex_limit_jpe.GetDouble("MAX"),0);
        Cursor_qbe_genera_opex_limit_jpe.Next();
      }
      m_cConnectivityError = Cursor_qbe_genera_opex_limit_jpe.ErrorMessage();
      Cursor_qbe_genera_opex_limit_jpe.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* gMsgImp := 'Sto eseguendo il ciclo n. '+LRTrim(Str(_conta,10,0))+" su "+LRTrim(Str(_cicli,10,0)) // Messaggio Import */
        gMsgImp = "Sto eseguendo il ciclo n. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _bottom := ((_conta -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*5000)+1,0);
        /* _top := _conta * 5000 */
        _top = CPLib.Round(_conta*5000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_genera_opex_jpe
          SPBridge.HMCaller _h00000079;
          _h00000079 = new SPBridge.HMCaller();
          _h00000079.Set("m_cVQRList",m_cVQRList);
          _h00000079.Set("cdatini",w_cdatini);
          _h00000079.Set("cdatfin",w_cdatfin);
          _h00000079.Set("_bottom",_bottom);
          _h00000079.Set("_top",_top);
          if (Cursor_qbe_genera_opex_jpe!=null)
            Cursor_qbe_genera_opex_jpe.Close();
          Cursor_qbe_genera_opex_jpe = new VQRHolder("qbe_genera_opex_jpe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000079,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_genera_opex_jpe.Eof())) {
            /* codage := Left(qbe_genera_opex_jpe->IDFILE,5) // Codice Agenzia */
            codage = CPLib.Left(Cursor_qbe_genera_opex_jpe.GetString("IDFILE"),5);
            /* _noopex := '' // Salta operazione */
            _noopex = "";
            /* If not(Empty(LRTrim(codage))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(codage)))) {
              // * --- Read from tbmacage
              m_cServer = m_Ctx.GetServer("tbmacage");
              m_cPhName = m_Ctx.GetPhName("tbmacage");
              m_cSql = "";
              m_cSql = m_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(codage,"C",5,0,m_cServer),m_cServer,codage);
              if (m_Ctx.IsSharedTemp("tbmacage")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MAFLGNOX",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _noopex = Read_Cursor.GetString("MAFLGNOX");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _noopex = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(LRTrim(_noopex)) or _noopex='N' */
            if (CPLib.Empty(CPLib.LRTrim(_noopex)) || CPLib.eqr(_noopex,"N")) {
              /* gMsgImp := 'Elaboro il soggetto '+LRTrim(qbe_genera_opex_jpe->CONNESCLI) +' per operazione in data '+arfn_fdate(qbe_genera_opex_jpe->DATAOPE) // Messaggio Import */
              gMsgImp = "Elaboro il soggetto "+CPLib.LRTrim(Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"))+" per operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_genera_opex_jpe.GetDate("DATAOPE"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _anno := Str(Year(qbe_genera_opex_jpe->DATAOPE),4,0) */
              _anno = CPLib.Str(CPLib.Year(Cursor_qbe_genera_opex_jpe.GetDate("DATAOPE")),4,0);
              /* _idb := '' */
              _idb = "";
              /* _dataope := NullDate() */
              _dataope = CPLib.NullDate();
              // * --- Read from tmp_erropxanno
              m_cServer = m_Ctx.GetServer("tmp_erropxanno");
              m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"));
              if (m_Ctx.IsSharedTemp("tmp_erropxanno")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dataope = Read_Cursor.GetDate("DATAOPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tmp_erropxanno into routine arrt_check_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dataope = CPLib.NullDate();
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_dataope) */
              if (CPLib.Empty(_dataope)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAGSOC,CODFISC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Insert into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000086")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000086(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erropxanno",true);
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                /* If _dataope > qbe_genera_opex_jpe->DATAOPE */
                if (CPLib.gt(_dataope,Cursor_qbe_genera_opex_jpe.GetDate("DATAOPE"))) {
                  // * --- Write into tmp_erropxanno from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_erropxanno");
                  m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_check_opex",171,"00000088")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetDate("DATAOPE"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_erropxanno",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"TIPERR = "+CPSql.SQLValueAdapter(CPLib.ToSQL("A","?",0,0,m_cServer),m_cServer,"A")+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_genera_opex_jpe.GetString("CONNESCLI"))+"";
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
            } // End If
            Cursor_qbe_genera_opex_jpe.Next();
          }
          m_cConnectivityError = Cursor_qbe_genera_opex_jpe.ErrorMessage();
          Cursor_qbe_genera_opex_jpe.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Sono stati inseriti n. '+ LRTrim(Str(_impope,10,0)) + ' soggetti dal file delle operazioni AGE' + NL */
      gMsgProc = gMsgProc+"Sono stati inseriti n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" soggetti dal file delle operazioni AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni AGE' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_genera_opex_limit_jpe!=null)
          Cursor_qbe_genera_opex_limit_jpe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_genera_opex_jpe!=null)
          Cursor_qbe_genera_opex_jpe.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  public static arrt_check_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_check_opexR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    _impope = 0;
    _impfrz = 0;
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    _anno = CPLib.Space(4);
    _idb = CPLib.Space(10);
    _prog = 0;
    codage = CPLib.Space(5);
    _noopex = CPLib.Space(1);
    w_cdatini = CPLib.Space(8);
    w_cdatfin = CPLib.Space(8);
    _dataope = CPLib.NullDate();
    w_annoc = CPLib.Space(4);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_genera_opex_limit_ope,qbe_genera_opex_ope,qbe_genera_opex_limit_frz,qbe_genera_opex_frz,qbe_genera_opex_limit_jpe,qbe_genera_opex_jpe,
  public static final String m_cVQRList = ",qbe_genera_opex_limit_ope,qbe_genera_opex_ope,qbe_genera_opex_limit_frz,qbe_genera_opex_frz,qbe_genera_opex_limit_jpe,qbe_genera_opex_jpe,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000046(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPERR,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erropxanno",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000066(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPERR,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erropxanno",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000086(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPERR,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erropxanno",true);
    return p_cSql;
  }
}
