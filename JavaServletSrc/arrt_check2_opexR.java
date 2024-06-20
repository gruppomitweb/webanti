// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_check2_opexR implements CallerWithObjs {
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
  public double _totale;
  public double _mono;
  public double _reccount;
  public String _oldmsg;
  public String w_annoc;
  public MemoryCursor_tmp_erropxanno mcErrori;
  public MemoryCursorRow_tmp_erropxanno rowErrori;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_check2_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_check2_opex",m_Caller);
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_check2_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
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
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrori",p_cVarName)) {
      return rowErrori;
    }
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
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
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
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
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowErrori",p_cVarName)) {
      rowErrori = (MemoryCursorRow_tmp_erropxanno)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_tmp_erropxanno)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
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
    /* _totale Numeric(10, 0) */
    /* _mono Numeric(1, 0) */
    /* _reccount Numeric(10, 0) */
    /* _oldmsg Memo */
    /* w_annoc Char(4) */
    /* mcErrori MemoryCursor(tmp_erropxanno) */
    /* rowErrori Row(tmp_erropxanno) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gAzienda Char(10) // Azienda */
    /* Il controllo su NOPROT della tabella ANARAPBO viene fatto direttamente nelle QUERY */
    /* gMsgProc := '' // Messaggio */
    gMsgProc = "";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000020status;
    nTry00000020status = m_Sql.GetTransactionStatus();
    String cTry00000020msg;
    cTry00000020msg = m_Sql.TransactionErrorMessage();
    try {
      /* w_annoc := Str(w_anno,4,0) */
      w_annoc = CPLib.Str(w_anno,4,0);
      /* Exec "Conteggio" Page 2:Page_2 */
      Page_2();
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000020status,0)) {
        m_Sql.SetTransactionStatus(nTry00000020status,cTry00000020msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Return _impfrz */
    throw new Stop(_impfrz);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_minmax_chk2_opex=null;
    CPResultSet Cursor_qbe_chk2_opex=null;
    CPResultSet Cursor_qbe_chk2_opex_o=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni */
      /* _impope := 0 */
      _impope = CPLib.Round(0,0);
      /* _impfrz := 0 */
      _impfrz = CPLib.Round(0,0);
      // * --- Select from qbe_minmax_chk2_opex
      SPBridge.HMCaller _h0000002D;
      _h0000002D = new SPBridge.HMCaller();
      _h0000002D.Set("m_cVQRList",m_cVQRList);
      _h0000002D.Set("annoc",w_annoc);
      if (Cursor_qbe_minmax_chk2_opex!=null)
        Cursor_qbe_minmax_chk2_opex.Close();
      Cursor_qbe_minmax_chk2_opex = new VQRHolder("qbe_minmax_chk2_opex",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_minmax_chk2_opex.Eof())) {
        /* _min := qbe_minmax_chk2_opex->MINOPEX */
        _min = CPLib.Round(Cursor_qbe_minmax_chk2_opex.GetDouble("MINOPEX"),0);
        /* _max := qbe_minmax_chk2_opex->MAXOPEX */
        _max = CPLib.Round(Cursor_qbe_minmax_chk2_opex.GetDouble("MAXOPEX"),0);
        /* _totale := qbe_minmax_chk2_opex->TOTOPEX */
        _totale = CPLib.Round(Cursor_qbe_minmax_chk2_opex.GetDouble("TOTOPEX"),0);
        Cursor_qbe_minmax_chk2_opex.Next();
      }
      m_cConnectivityError = Cursor_qbe_minmax_chk2_opex.ErrorMessage();
      Cursor_qbe_minmax_chk2_opex.Close();
      // * --- End Select
      /* _mono := iif(_totale > 5000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_totale,5000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _totale = 0 */
        if (CPLib.eqr(_totale,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _reccount := _max - _min */
        _reccount = CPLib.Round(_max-_min,0);
        /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
      } // End If
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _conta=1 */
          if (CPLib.eqr(_conta,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 4999 */
            _top = CPLib.Round(_min+4999,0);
            /* ElseIf _conta = _cicli */
          } else if (CPLib.eqr(_conta,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 4999 */
            _top = CPLib.Round(_bottom+4999,0);
          } // End If
        } // End If
        // * --- Select from qbe_chk2_opex
        SPBridge.HMCaller _h00000045;
        _h00000045 = new SPBridge.HMCaller();
        _h00000045.Set("m_cVQRList",m_cVQRList);
        _h00000045.Set("_bottom",_bottom);
        _h00000045.Set("_top",_top);
        _h00000045.Set("annoc",w_annoc);
        if (Cursor_qbe_chk2_opex!=null)
          Cursor_qbe_chk2_opex.Close();
        Cursor_qbe_chk2_opex = new VQRHolder("qbe_chk2_opex",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000045,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_chk2_opex.Eof())) {
          /* _prog := 0 */
          _prog = CPLib.Round(0,0);
          /* _impope := _impope + 1 */
          _impope = CPLib.Round(_impope+1,0);
          /* gMsgImp := 'Elaboro soggetto con codice: '+ LRTrim(qbe_chk2_opex->COLLEG) +" (soggetto n. "+LRTrim(Str(_impope,10,0))+" su "+LRTrim(Str(_totale,10,0))+")" // Messaggio Import */
          gMsgImp = "Elaboro soggetto con codice: "+CPLib.LRTrim(Cursor_qbe_chk2_opex.GetString("COLLEG"))+" (soggetto n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totale,10,0))+")";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_chk2_opex_o
          SPBridge.HMCaller _h00000049;
          _h00000049 = new SPBridge.HMCaller();
          _h00000049.Set("m_cVQRList",m_cVQRList);
          _h00000049.Set("colleg",Cursor_qbe_chk2_opex.GetString("COLLEG"));
          _h00000049.Set("anno",w_anno);
          if (Cursor_qbe_chk2_opex_o!=null)
            Cursor_qbe_chk2_opex_o.Close();
          Cursor_qbe_chk2_opex_o = new VQRHolder("qbe_chk2_opex_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000049,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_chk2_opex_o.Eof())) {
            /* _prog := _prog + qbe_chk2_opex_o->TOTALE */
            _prog = CPLib.Round(_prog+Cursor_qbe_chk2_opex_o.GetDouble("TOTALE"),0);
            Cursor_qbe_chk2_opex_o.Next();
          }
          m_cConnectivityError = Cursor_qbe_chk2_opex_o.ErrorMessage();
          Cursor_qbe_chk2_opex_o.Close();
          // * --- End Select
          /* If _prog=0 */
          if (CPLib.eqr(_prog,0)) {
            /* _impfrz := _impfrz + 1 */
            _impfrz = CPLib.Round(_impfrz+1,0);
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPERR := 'A' */
            mcErrori.row.TIPERR = "A";
            /* mcErrori.ANNO := w_anno */
            mcErrori.row.ANNO = w_anno;
            /* mcErrori.CONNES := qbe_chk2_opex->COLLEG */
            mcErrori.row.CONNES = Cursor_qbe_chk2_opex.GetString("COLLEG");
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
          Cursor_qbe_chk2_opex.Next();
        }
        m_cConnectivityError = Cursor_qbe_chk2_opex.ErrorMessage();
        Cursor_qbe_chk2_opex.Close();
        // * --- End Select
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sono stati elaborati n. '+ LRTrim(Str(_impope,10,0)) + ' soggetti su ' + LRTrim(Str(_totale,10,0)) + NL */
          gMsgProc = gMsgProc+"Sono stati elaborati n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" soggetti su "+CPLib.LRTrim(CPLib.Str(_totale,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sono stati elaborati n. '+ LRTrim(Str(_impope,10,0)) + ' soggetti su ' + LRTrim(Str(_totale,10,0))) // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sono stati elaborati n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" soggetti su "+CPLib.LRTrim(CPLib.Str(_totale,10,0)));
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sono stati elaborati n. '+ LRTrim(Str(_impope,10,0)) + ' soggetti su ' + LRTrim(Str(_totale,10,0)) */
        _oldmsg = "Sono stati elaborati n. "+CPLib.LRTrim(CPLib.Str(_impope,10,0))+" soggetti su "+CPLib.LRTrim(CPLib.Str(_totale,10,0));
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* If _impfrz > 0 */
      if (CPLib.gt(_impfrz,0)) {
        for (MemoryCursorRow_tmp_erropxanno rowErrori : mcErrori._iterable_()) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAGSOC,CODFISC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowErrori.CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,rowErrori.CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into tmp_erropxanno from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_erropxanno");
            m_cPhName = m_Ctx.GetPhName("tmp_erropxanno");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erropxanno",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_check2_opex",194,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowErrori.TIPERR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowErrori.ANNO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowErrori.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
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
        }
      } // End If
      /* gMsgProc := gMsgProc + 'Soggetti con errori rilevati: '+ LRTrim(Str(_impfrz,10,0)) + NL */
      gMsgProc = gMsgProc+"Soggetti con errori rilevati: "+CPLib.LRTrim(CPLib.Str(_impfrz,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_minmax_chk2_opex!=null)
          Cursor_qbe_minmax_chk2_opex.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_chk2_opex!=null)
          Cursor_qbe_chk2_opex.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_chk2_opex_o!=null)
          Cursor_qbe_chk2_opex_o.Close();
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
  public String RunAsync(double p_w_anno) {
    w_anno = p_w_anno;
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
  public double Run(double p_w_anno) {
    w_anno = p_w_anno;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_check2_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_check2_opexR(p_Ctx, p_Caller);
  }
  public static arrt_check2_opexR Make(CPContext p_Ctx) {
    return new arrt_check2_opexR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_anno = 0;
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
    _totale = 0;
    _mono = 0;
    _reccount = 0;
    _oldmsg = "";
    w_annoc = CPLib.Space(4);
    mcErrori = new MemoryCursor_tmp_erropxanno();
    rowErrori = new MemoryCursorRow_tmp_erropxanno();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_minmax_chk2_opex,qbe_chk2_opex,qbe_chk2_opex_o,
  public static final String m_cVQRList = ",qbe_minmax_chk2_opex,qbe_chk2_opex,qbe_chk2_opex_o,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_check2_opex,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_check2_opex,";
  public static String[] m_cRunParameterNames={"w_anno"};
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPERR,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erropxanno",true);
    return p_cSql;
  }
}
