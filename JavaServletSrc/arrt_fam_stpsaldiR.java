// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_stpsaldiR implements CallerWithObjs {
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
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_sid_invio1;
  public String m_cServer_tmp_sid_invio1;
  public String m_cPhName_tmp_sid_invio2;
  public String m_cServer_tmp_sid_invio2;
  public String m_cPhName_tmp_sid_invio3;
  public String m_cServer_tmp_sid_invio3;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String w_anno;
  public double w_dainviare;
  public double _conta;
  public String _errore;
  public MemoryCursor_mcsaldi_mcrdef mcTemp;
  public MemoryCursorRow_mcsaldi_mcrdef rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public double _crea;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _cicli;
  public double _reccount;
  public double _totrecord;
  public String _oldmsg;
  public String _invio;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_stpsaldiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_stpsaldi",m_Caller);
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio2 = p_ContextObject.GetPhName("sid_invio2");
    if (m_cPhName_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio2 = m_cPhName_sid_invio2+" "+m_Ctx.GetWritePhName("sid_invio2");
    }
    m_cServer_sid_invio2 = p_ContextObject.GetServer("sid_invio2");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
      m_cPhName_tmp_sid_invio1 = p_ContextObject.GetPhName("tmp_sid_invio1");
      if (m_cPhName_tmp_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio1 = m_cPhName_tmp_sid_invio1+" "+m_Ctx.GetWritePhName("tmp_sid_invio1");
      }
      m_cServer_tmp_sid_invio1 = p_ContextObject.GetServer("tmp_sid_invio1");
    }
    m_cPhName_tmp_sid_invio2 = p_ContextObject.GetPhName("tmp_sid_invio2");
    if (m_cPhName_tmp_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_sid_invio2 = m_cPhName_tmp_sid_invio2+" "+m_Ctx.GetWritePhName("tmp_sid_invio2");
    }
    m_cServer_tmp_sid_invio2 = p_ContextObject.GetServer("tmp_sid_invio2");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
      m_cPhName_tmp_sid_invio3 = p_ContextObject.GetPhName("tmp_sid_invio3");
      if (m_cPhName_tmp_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio3 = m_cPhName_tmp_sid_invio3+" "+m_Ctx.GetWritePhName("tmp_sid_invio3");
      }
      m_cServer_tmp_sid_invio3 = p_ContextObject.GetServer("tmp_sid_invio3");
    }
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dainviare",p_cVarName)) {
      return w_dainviare;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      return _totrecord;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_stpsaldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      return _invio;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      return mcSID0;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      return mcSID1;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      return mcSID3;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      return mcSID3r;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      return rowSID0;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      return rowSID1;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      return rowSID3;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("dainviare",p_cVarName)) {
      w_dainviare = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      _totrecord = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      _invio = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_mcsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      rowSID0 = (MemoryCursorRow_sid_invio)value;
      return;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      rowSID1 = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_mcsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      mcSID0 = (MemoryCursor_sid_invio)value;
      return;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      mcSID1 = (MemoryCursor_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      mcSID3 = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      mcSID3r = (MemoryCursor_sid_invio3)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_famsaldi01_count=null;
    CPResultSet Cursor_qbe_famsaldi01=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_anno Char(4) */
      /* w_dainviare Numeric(1, 0) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(mcSaldi.MCRDef) */
      /* rowTemp Row(mcSaldi.MCRDef) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* _crea Numeric(1, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _reccount Numeric(10, 0) */
      /* _totrecord Numeric(10, 0) */
      /* _oldmsg Memo */
      /* _invio Char(10) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgProc := 'Ora Inizio  Stampa Saldi '+w_anno+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio  Stampa Saldi "+w_anno+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Create temporary table tmp_sid_invio1
      if (m_Ctx.IsSharedTemp("tmp_sid_invio1")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio1");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio1");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio1"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio1",m_cServer,"proto")),m_cPhName,"tmp_sid_invio1",m_Ctx);
      }
      m_cPhName_tmp_sid_invio1 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio3
      if (m_Ctx.IsSharedTemp("tmp_sid_invio3")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio3");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio3");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio3"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio3",m_cServer,"proto")),m_cPhName,"tmp_sid_invio3",m_Ctx);
      }
      m_cPhName_tmp_sid_invio3 = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000028status;
      nTry00000028status = m_Sql.GetTransactionStatus();
      String cTry00000028msg;
      cTry00000028msg = m_Sql.TransactionErrorMessage();
      try {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _totrecord := 0 */
        _totrecord = CPLib.Round(0,0);
        // * --- Select from qbe_famsaldi01_count
        SPBridge.HMCaller _h0000002B;
        _h0000002B = new SPBridge.HMCaller();
        _h0000002B.Set("m_cVQRList",m_cVQRList);
        _h0000002B.Set("anno",w_anno);
        _h0000002B.Set("dainviare",w_dainviare);
        if (Cursor_qbe_famsaldi01_count!=null)
          Cursor_qbe_famsaldi01_count.Close();
        Cursor_qbe_famsaldi01_count = new VQRHolder("qbe_famsaldi01_count",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_famsaldi01_count.Eof())) {
          /* _totrecord := _totrecord + qbe_famsaldi01_count->TOTPRG */
          _totrecord = CPLib.Round(_totrecord+Cursor_qbe_famsaldi01_count.GetDouble("TOTPRG"),0);
          Cursor_qbe_famsaldi01_count.Next();
        }
        m_cConnectivityError = Cursor_qbe_famsaldi01_count.ErrorMessage();
        Cursor_qbe_famsaldi01_count.Close();
        // * --- End Select
        /* If _totrecord > 0 */
        if (CPLib.gt(_totrecord,0)) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Lettura Saldi: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio Lettura Saldi: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _invio := w_anno+"00_1_3" */
          _invio = w_anno+"00_1_3";
          /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
          gMsgImp = "Attendere. Estrazione dati per il periodo ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Fill memory cursor mcTemp on qbe_famsaldi01
          mcTemp.Zap();
          SPBridge.HMCaller _h00000032;
          _h00000032 = new SPBridge.HMCaller();
          _h00000032.Set("m_cVQRList",m_cVQRList);
          _h00000032.Set("_anno",w_anno);
          _h00000032.Set("dainviare",w_dainviare);
          if (Cursor_qbe_famsaldi01!=null)
            Cursor_qbe_famsaldi01.Close();
          Cursor_qbe_famsaldi01 = new VQRHolder("qbe_famsaldi01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000032,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_famsaldi01;
            Cursor_qbe_famsaldi01.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,100000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_stpsaldi: query on qbe_famsaldi01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 100000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_famsaldi01.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.RAPPORTO = Cursor_qbe_famsaldi01.GetString("RAPPORTO");
            mcTemp.row.DATAINI = Cursor_qbe_famsaldi01.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_famsaldi01.GetDate("DATAFINE");
            mcTemp.row.TIPOAG = Cursor_qbe_famsaldi01.GetString("TIPOAG");
            mcTemp.row.TIPORAP = Cursor_qbe_famsaldi01.GetString("TIPORAP");
            mcTemp.row.DESCRAP = Cursor_qbe_famsaldi01.GetString("DESCRAP");
            mcTemp.row.VALUTA = Cursor_qbe_famsaldi01.GetString("VALUTA");
            mcTemp.row.INVIATO = Cursor_qbe_famsaldi01.GetDouble("INVIATO");
            mcTemp.row.TIPO = Cursor_qbe_famsaldi01.GetString("TIPO");
            mcTemp.row.CAB = Cursor_qbe_famsaldi01.GetString("CAB");
            mcTemp.row.UNIQUECODE = Cursor_qbe_famsaldi01.GetString("UNIQUECODE");
            mcTemp.row.OLDINTER = Cursor_qbe_famsaldi01.GetString("OLDINTER");
            mcTemp.row.SALDO = Cursor_qbe_famsaldi01.GetDouble("SALDO");
            mcTemp.row.QUANTITA = Cursor_qbe_famsaldi01.GetDouble("QUANTITA");
            mcTemp.row.NATURA = Cursor_qbe_famsaldi01.GetString("NATURA");
            Cursor_qbe_famsaldi01.Next();
          }
          m_cConnectivityError = Cursor_qbe_famsaldi01.ErrorMessage();
          Cursor_qbe_famsaldi01.Close();
          mcTemp.GoTop();
          /* _crea := 0 */
          _crea = CPLib.Round(0,0);
          for (MemoryCursorRow_mcsaldi_mcrdef rowTemp : mcTemp._iterable_()) {
            /* rowSID1.CODINVIO1 := _invio */
            rowSID1.CODINVIO1 = _invio;
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
            rowSID1.FININVIO1 = rowTemp.DATAFINE;
            /* rowSID1.TIPINVIO1 := '1' */
            rowSID1.TIPINVIO1 = "1";
            /* rowSID1.TPCINVIO1 := '3' */
            rowSID1.TPCINVIO1 = "3";
            /* rowSID1.CABINVIO1 := rowTemp.CAB */
            rowSID1.CABINVIO1 = rowTemp.CAB;
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* mcSID3r := arfn_fam_mesefile03(rowSID1,Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA) */
            mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,CPLib.Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA);
            for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
              /* mcSID3.AppendRow(rowSID3) */
              mcSID3.AppendRow(rowSID3);
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* gMsgImp := 'Sono stati lette '+LRTrim(Str(_conta,10,0))+" registrazioni" // Messaggio Import */
            gMsgImp = "Sono stati lette "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          }
          /* Exec "Operazioni ExtraConto" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + "Sono state lette "+LRTrim(Str(_conta,10,0))+" registrazioni"+NL // Messaggio */
          gMsgProc = gMsgProc+"Sono state lette "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Lettura Saldi: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Fine Lettura Saldi: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Inizio Preparazione file di stampa: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio Preparazione file di stampa: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* gMsgImp := "Sto leggendo l'operazione " + LRTrim(Str(_conta,10,0)) + " su " + LRTrim(Str(_totrecord,10,0)) // Messaggio Import */
            gMsgImp = "Sto leggendo l'operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totrecord,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
              gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := "Sto leggendo l'operazione " + LRTrim(Str(_conta,10,0)) + " su " + LRTrim(Str(_totrecord,10,0)) */
            _oldmsg = "Sto leggendo l'operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totrecord,10,0));
            // * --- Insert into tmp_sid_invio1 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
            m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpsaldi",70,"0000004F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000004F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio1",true);
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
          }
          for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
            // * --- Insert into tmp_sid_invio3 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
            m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio3",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpsaldi",70,"00000051")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000051(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio3",true);
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
          }
          /* gMsgProc := gMsgProc + NL + 'Ora Fine Preparazione file di stampa: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"\n"+"Ora Fine Preparazione file di stampa: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc + "Non ci sono saldi da comunicare per l'anno: "+w_anno+NL // Messaggio */
          gMsgProc = gMsgProc+"Non ci sono saldi da comunicare per l'anno: "+w_anno+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Elaborazione Terminata. " // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. ";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000028status,0)) {
          m_Sql.SetTransactionStatus(nTry00000028status,cTry00000028msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Stampa Saldi: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Stampa Saldi: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Stop arrp_fam_stpsaldi.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("w_anno",w_anno);
      f.SetParameter("hideCover",true);
      f.SetParameter("hideLanguage",true);
      f.SetParameter("hideSettings",true);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("w_rapporti",_conta);
      f.SetParameter("ReportName","arrp_fam_stpsaldi.vrp");
      f.SetParameter("m_cParameterSequence","w_anno"+","+"hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"w_rapporti"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_famsaldi01_count!=null)
          Cursor_qbe_famsaldi01_count.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famsaldi01!=null)
          Cursor_qbe_famsaldi01.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_famsaldi_opx_minmax=null;
    CPResultSet Cursor_qbe_famsaldi03=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_famsaldi_opx_minmax
      SPBridge.HMCaller _h0000005F;
      _h0000005F = new SPBridge.HMCaller();
      _h0000005F.Set("m_cVQRList",m_cVQRList);
      _h0000005F.Set("anno",w_anno);
      _h0000005F.Set("dainviare",w_dainviare);
      if (Cursor_qbe_famsaldi_opx_minmax!=null)
        Cursor_qbe_famsaldi_opx_minmax.Close();
      Cursor_qbe_famsaldi_opx_minmax = new VQRHolder("qbe_famsaldi_opx_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000005F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famsaldi_opx_minmax.Eof())) {
        /* _min := qbe_famsaldi_opx_minmax->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("MINPRG"),0);
        /* _max := qbe_famsaldi_opx_minmax->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famsaldi_opx_minmax->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_famsaldi_opx_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_famsaldi_opx_minmax.ErrorMessage();
      Cursor_qbe_famsaldi_opx_minmax.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
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
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* _oldmsg := '' */
      _oldmsg = "";
      /* While _contacicli <= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _contacicli=1 */
          if (CPLib.eqr(_contacicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 4999 */
            _top = CPLib.Round(_min+4999,0);
            /* ElseIf _contacicli = _cicli */
          } else if (CPLib.eqr(_contacicli,_cicli)) {
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
        /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := gMsgImp */
        _oldmsg = gMsgImp;
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Fill memory cursor mcTemp on qbe_famsaldi03
          mcTemp.Zap();
          SPBridge.HMCaller _h0000007F;
          _h0000007F = new SPBridge.HMCaller();
          _h0000007F.Set("m_cVQRList",m_cVQRList);
          _h0000007F.Set("anno",w_anno);
          _h0000007F.Set("_bottom",_bottom);
          _h0000007F.Set("_top",_top);
          _h0000007F.Set("dainviare",w_dainviare);
          if (Cursor_qbe_famsaldi03!=null)
            Cursor_qbe_famsaldi03.Close();
          Cursor_qbe_famsaldi03 = new VQRHolder("qbe_famsaldi03",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007F,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_famsaldi03;
            Cursor_qbe_famsaldi03.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_stpsaldi: query on qbe_famsaldi03 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_famsaldi03.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.RAPPORTO = Cursor_qbe_famsaldi03.GetString("RAPPORTO");
            mcTemp.row.DATAINI = Cursor_qbe_famsaldi03.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_famsaldi03.GetDate("DATAFINE");
            mcTemp.row.TIPOAG = Cursor_qbe_famsaldi03.GetString("TIPOAG");
            mcTemp.row.TIPORAP = Cursor_qbe_famsaldi03.GetString("TIPORAP");
            mcTemp.row.DESCRAP = Cursor_qbe_famsaldi03.GetString("DESCRAP");
            mcTemp.row.VALUTA = Cursor_qbe_famsaldi03.GetString("VALUTA");
            mcTemp.row.INVIATO = Cursor_qbe_famsaldi03.GetDouble("INVIATO");
            mcTemp.row.TIPO = Cursor_qbe_famsaldi03.GetString("TIPO");
            mcTemp.row.CAB = Cursor_qbe_famsaldi03.GetString("CAB");
            mcTemp.row.UNIQUECODE = Cursor_qbe_famsaldi03.GetString("UNIQUECODE");
            mcTemp.row.OLDINTER = Cursor_qbe_famsaldi03.GetString("OLDINTER");
            mcTemp.row.SALDO = Cursor_qbe_famsaldi03.GetDouble("SALDO");
            mcTemp.row.QUANTITA = Cursor_qbe_famsaldi03.GetDouble("QUANTITA");
            mcTemp.row.NATURA = Cursor_qbe_famsaldi03.GetString("NATURA");
            Cursor_qbe_famsaldi03.Next();
          }
          m_cConnectivityError = Cursor_qbe_famsaldi03.ErrorMessage();
          Cursor_qbe_famsaldi03.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_mcsaldi_mcrdef rowTemp : mcTemp._iterable_()) {
            /* rowSID1.CODINVIO1 := _invio */
            rowSID1.CODINVIO1 = _invio;
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
            rowSID1.FININVIO1 = rowTemp.DATAFINE;
            /* rowSID1.TIPINVIO1 := '1' */
            rowSID1.TIPINVIO1 = "1";
            /* rowSID1.TPCINVIO1 := '3' */
            rowSID1.TPCINVIO1 = "3";
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* mcSID3r := arfn_fam_mesefile03(rowSID1,Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA) */
            mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,CPLib.Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA);
            for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
              /* mcSID3.AppendRow(rowSID3) */
              mcSID3.AppendRow(rowSID3);
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* gMsgImp := 'Sono stati lette '+LRTrim(Str(_conta,10,0))+" registrazioni" // Messaggio Import */
            gMsgImp = "Sono stati lette "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          }
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* gMsgProc := gMsgProc + NL // Messaggio */
      gMsgProc = gMsgProc+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_famsaldi_opx_minmax!=null)
          Cursor_qbe_famsaldi_opx_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famsaldi03!=null)
          Cursor_qbe_famsaldi03.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_anno,double p_w_dainviare) {
    w_anno = p_w_anno;
    w_dainviare = p_w_dainviare;
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
  public Forward Run(String p_w_anno,double p_w_dainviare) {
    w_anno = p_w_anno;
    w_dainviare = p_w_dainviare;
    return Run();
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
  public static arrt_fam_stpsaldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_stpsaldiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_anno = CPLib.Space(4);
    w_dainviare = 0;
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_mcsaldi_mcrdef();
    rowTemp = new MemoryCursorRow_mcsaldi_mcrdef();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    _crea = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _reccount = 0;
    _totrecord = 0;
    _oldmsg = "";
    _invio = CPLib.Space(10);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famsaldi01_count,qbe_famsaldi01,qbe_famsaldi_opx_minmax,qbe_famsaldi03,
  public static final String m_cVQRList = ",qbe_famsaldi01_count,qbe_famsaldi01,qbe_famsaldi_opx_minmax,qbe_famsaldi03,";
  // ENTITY_BATCHES: ,arfn_fam_mesefile03,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fam_mesefile03,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"w_anno","w_dainviare"};
  protected static String GetFieldsName_0000004F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000051(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio3",true);
    return p_cSql;
  }
}
