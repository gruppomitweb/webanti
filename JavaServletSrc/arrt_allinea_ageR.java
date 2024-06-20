// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_ageR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
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
  public String _codcli;
  public double _contaerr;
  public double _min;
  public double _max;
  public double _cicli;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _totale;
  public double _contarec;
  public String _ucode;
  public double _inviato;
  public double _aspedito;
  public java.sql.Date _adata;
  public double _cspedito;
  public java.sql.Date _cdata;
  public String _idbase;
  public double _spcanc;
  public java.sql.Date _dtcanc;
  public double _contad;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_allinea_ageR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_age",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
      m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
      if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
      }
      m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    }
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
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
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      return _contaerr;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_inviato",p_cVarName)) {
      return _inviato;
    }
    if (CPLib.eqr("_aspedito",p_cVarName)) {
      return _aspedito;
    }
    if (CPLib.eqr("_cspedito",p_cVarName)) {
      return _cspedito;
    }
    if (CPLib.eqr("_spcanc",p_cVarName)) {
      return _spcanc;
    }
    if (CPLib.eqr("_contad",p_cVarName)) {
      return _contad;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_age";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      return _codcli;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      return _ucode;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
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
    if (CPLib.eqr("_adata",p_cVarName)) {
      return _adata;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      return _cdata;
    }
    if (CPLib.eqr("_dtcanc",p_cVarName)) {
      return _dtcanc;
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
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      _contaerr = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_inviato",p_cVarName)) {
      _inviato = value;
      return;
    }
    if (CPLib.eqr("_aspedito",p_cVarName)) {
      _aspedito = value;
      return;
    }
    if (CPLib.eqr("_cspedito",p_cVarName)) {
      _cspedito = value;
      return;
    }
    if (CPLib.eqr("_spcanc",p_cVarName)) {
      _spcanc = value;
      return;
    }
    if (CPLib.eqr("_contad",p_cVarName)) {
      _contad = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      _codcli = value;
      return;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      _ucode = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
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
    if (CPLib.eqr("_adata",p_cVarName)) {
      _adata = value;
      return;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      _cdata = value;
      return;
    }
    if (CPLib.eqr("_dtcanc",p_cVarName)) {
      _dtcanc = value;
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
    CPResultSet Cursor_qbe_minmax_opex=null;
    CPResultSet Cursor_qbe_opextrbo_age=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_aecanc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_anno Char(4) */
      /* _codcli Char(16) */
      /* _contaerr Numeric(10, 0) */
      /* _min Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _totale Numeric(15, 0) */
      /* _contarec Numeric(15, 0) */
      /* _ucode Char(50) // Codice Agenzia */
      /* _inviato Numeric(1, 0) // Salta operazione */
      /* _aspedito Numeric(1, 0) */
      /* _adata Date */
      /* _cspedito Numeric(1, 0) */
      /* _cdata Date */
      /* _idbase Char(10) */
      /* _spcanc Numeric(1, 0) */
      /* _dtcanc Date */
      /* _contad Numeric(15, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      // * --- Drop temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      // * --- Create temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newpers");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newpers"))) {
        m_cServer = m_Ctx.GetServer("tmp_newpers");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newpers",m_cServer,"proto")),m_cPhName,"tmp_newpers",m_Ctx,new String[]{"CONNES"});
      }
      m_cPhName_tmp_newpers = m_cPhName;
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000020status;
      nTry00000020status = m_Sql.GetTransactionStatus();
      String cTry00000020msg;
      cTry00000020msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' delle Operazioni Extraconto' + NL */
        gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" delle Operazioni Extraconto"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from qbe_minmax_opex
        SPBridge.HMCaller _h00000023;
        _h00000023 = new SPBridge.HMCaller();
        _h00000023.Set("m_cVQRList",m_cVQRList);
        _h00000023.Set("anno",w_anno);
        if (Cursor_qbe_minmax_opex!=null)
          Cursor_qbe_minmax_opex.Close();
        Cursor_qbe_minmax_opex = new VQRHolder("qbe_minmax_opex",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000023,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_minmax_opex.Eof())) {
          /* _min := qbe_minmax_opex->MIN */
          _min = CPLib.Round(Cursor_qbe_minmax_opex.GetDouble("MIN"),0);
          /* _max := qbe_minmax_opex->MAX */
          _max = CPLib.Round(Cursor_qbe_minmax_opex.GetDouble("MAX"),0);
          /* _totale := qbe_minmax_opex->TOT */
          _totale = CPLib.Round(Cursor_qbe_minmax_opex.GetDouble("TOT"),0);
          Cursor_qbe_minmax_opex.Next();
        }
        m_cConnectivityError = Cursor_qbe_minmax_opex.ErrorMessage();
        Cursor_qbe_minmax_opex.Close();
        // * --- End Select
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* _contarec := 0 */
        _contarec = CPLib.Round(0,0);
        /* While _conta <= _cicli */
        while (CPLib.le(_conta,_cicli)) {
          /* _bottom := ((_conta -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_conta-1)*5000)+1,0);
          /* _top := _conta * 5000 */
          _top = CPLib.Round(_conta*5000,0);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            /* gMsgImp := 'Estrazione dati operazioni ...' */
            gMsgImp = "Estrazione dati operazioni ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Select from qbe_opextrbo_age
            SPBridge.HMCaller _h0000002F;
            _h0000002F = new SPBridge.HMCaller();
            _h0000002F.Set("m_cVQRList",m_cVQRList);
            _h0000002F.Set("_bottom",_bottom);
            _h0000002F.Set("_top",_top);
            _h0000002F.Set("anno",w_anno);
            if (Cursor_qbe_opextrbo_age!=null)
              Cursor_qbe_opextrbo_age.Close();
            Cursor_qbe_opextrbo_age = new VQRHolder("qbe_opextrbo_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_opextrbo_age.Eof())) {
              /* _contarec := _contarec + 1 */
              _contarec = CPLib.Round(_contarec+1,0);
              /* _aspedito := 0 */
              _aspedito = CPLib.Round(0,0);
              /* _adata := NullDate() */
              _adata = CPLib.NullDate();
              /* _idbase := '' */
              _idbase = "";
              /* _ucode := '' // Codice Agenzia */
              _ucode = "";
              // * --- Select from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              if (Cursor_aeoprig!=null)
                Cursor_aeoprig.Close();
              Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT= "+CPLib.ToSQL(Cursor_qbe_opextrbo_age.GetString("COLLEG"),"?",0,0)+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(Cursor_qbe_opextrbo_age.GetString("ANNO")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Val(Cursor_qbe_opextrbo_age.GetString("ANNO")))+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"IDBASE ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_aeoprig.Eof())) {
                /* _aspedito := aeoprig->ASPEDITO */
                _aspedito = CPLib.Round(Cursor_aeoprig.GetDouble("ASPEDITO"),0);
                /* _adata := aeoprig->ADATA */
                _adata = Cursor_aeoprig.GetDate("ADATA");
                /* _idbase := aeoprig->IDBASE */
                _idbase = Cursor_aeoprig.GetString("IDBASE");
                /* _ucode := aeoprig->UNIQUECODE // Codice Agenzia */
                _ucode = Cursor_aeoprig.GetString("UNIQUECODE");
                /* _spcanc := 0 */
                _spcanc = CPLib.Round(0,0);
                /* _dtcanc := NullDate() */
                _dtcanc = CPLib.NullDate();
                // * --- Read from aeopcanc
                m_cServer = m_Ctx.GetServer("aeopcanc");
                m_cPhName = m_Ctx.GetPhName("aeopcanc");
                m_cSql = "";
                m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"C",10,0,m_cServer),m_cServer,_idbase);
                if (m_Ctx.IsSharedTemp("aeopcanc")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SPEDITO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATARIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _spcanc = CPLib.Round(Read_Cursor.GetDouble("SPEDITO"),0);
                  _dtcanc = Read_Cursor.GetDate("DATARIF");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_allinea_age returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _spcanc = 0;
                  _dtcanc = CPLib.NullDate();
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                Cursor_aeoprig.Next();
              }
              m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
              Cursor_aeoprig.Close();
              // * --- End Select
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_age",108,"0000003D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(_aspedito,"N",1,0)+", ";
              m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(_adata,"D",8,0)+", ";
              m_cSql = m_cSql+"ANNULLA = "+CPLib.ToSQL(_spcanc,"N",1,0)+", ";
              m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(_dtcanc,"D",8,0)+", ";
              m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_ucode,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_opextrbo_age.GetString("ANNO"))+"_"+CPLib.LRTrim(Cursor_qbe_opextrbo_age.GetString("COLLEG")),"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opextrbo_age.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_opextrbo_age.GetString("COLLEG"))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opextrbo_age.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_opextrbo_age.GetString("ANNO"))+"";
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
              /* gMsgImp := 'Sto elaborando il record n. '+LRTrim(Str(_contarec,15,0))+' delle Operazioni ExtraConto ' // Messaggio Import */
              gMsgImp = "Sto elaborando il record n. "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" delle Operazioni ExtraConto ";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_qbe_opextrbo_age.Next();
            }
            m_cConnectivityError = Cursor_qbe_opextrbo_age.ErrorMessage();
            Cursor_qbe_opextrbo_age.Close();
            // * --- End Select
          } // End If
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End While
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(_contarec,15,0))+' record delle Operazioni ExtraConto ' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" record delle Operazioni ExtraConto "+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' delle Operazioni Extraconto' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" delle Operazioni Extraconto"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + " dell'Anagrafe Rapporti" + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dell'Anagrafe Rapporti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
        Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aetesta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aetesta.Eof())) {
          /* gMsgImp := 'Sto elaborando il rapporto '+LRTrim(aetesta->RAPPORTO)+" dell'Anagrafe Rapporti " // Messaggio Import */
          gMsgImp = "Sto elaborando il rapporto "+CPLib.LRTrim(Cursor_aetesta.GetString("RAPPORTO"))+" dell'Anagrafe Rapporti ";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _inviato := 0 // Salta operazione */
          _inviato = CPLib.Round(0,0);
          /* _cspedito := 0 */
          _cspedito = CPLib.Round(0,0);
          /* _cdata := NullDate() */
          _cdata = CPLib.NullDate();
          /* _aspedito := 0 */
          _aspedito = CPLib.Round(0,0);
          /* _adata := NullDate() */
          _adata = CPLib.NullDate();
          /* _spcanc := 0 */
          _spcanc = CPLib.Round(0,0);
          /* _dtcanc := NullDate() */
          _dtcanc = CPLib.NullDate();
          /* _contad := 0 */
          _contad = CPLib.Round(0,0);
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If _inviato=0 */
            if (CPLib.eqr(_inviato,0)) {
              /* If aerighe->ASPEDITO=1 */
              if (CPLib.eqr(Cursor_aerighe.GetDouble("ASPEDITO"),1)) {
                /* _inviato := 1 // Salta operazione */
                _inviato = CPLib.Round(1,0);
                /* _aspedito := aerighe->ASPEDITO */
                _aspedito = CPLib.Round(Cursor_aerighe.GetDouble("ASPEDITO"),0);
                /* _adata := aerighe->ADATA */
                _adata = Cursor_aerighe.GetDate("ADATA");
              } // End If
              /* If aerighe->CSPEDITO=1 */
              if (CPLib.eqr(Cursor_aerighe.GetDouble("CSPEDITO"),1)) {
                /* _cspedito := aerighe->CSPEDITO */
                _cspedito = CPLib.Round(Cursor_aerighe.GetDouble("CSPEDITO"),0);
                /* _cdata := aerighe->CDATA */
                _cdata = Cursor_aerighe.GetDate("CDATA");
              } // End If
            } // End If
            // * --- Select from aecanc
            m_cServer = m_Ctx.GetServer("aecanc");
            m_cPhName = m_Ctx.GetPhName("aecanc");
            if (Cursor_aecanc!=null)
              Cursor_aecanc.Close();
            Cursor_aecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,SPEDITO,DATARIF  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aecanc.Eof())) {
              /* If aecanc->SPEDITO=1 */
              if (CPLib.eqr(Cursor_aecanc.GetDouble("SPEDITO"),1)) {
                /* _contad := _contad + 1 */
                _contad = CPLib.Round(_contad+1,0);
              } // End If
              /* _dtcanc := aecanc->DATARIF */
              _dtcanc = Cursor_aecanc.GetDate("DATARIF");
              Cursor_aecanc.Next();
            }
            m_cConnectivityError = Cursor_aecanc.ErrorMessage();
            Cursor_aecanc.Close();
            // * --- End Select
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
          /* If _contad = _conta */
          if (CPLib.eqr(_contad,_conta)) {
            /* _spcanc := 1 */
            _spcanc = CPLib.Round(1,0);
          } else { // Else
            /* _spcanc := 0 */
            _spcanc = CPLib.Round(0,0);
            /* _dtcanc := NullDate() */
            _dtcanc = CPLib.NullDate();
          } // End If
          // * --- Write into aetesta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_age",108,"00000061")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(_aspedito,"N",1,0)+", ";
          m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(_adata,"D",8,0)+", ";
          m_cSql = m_cSql+"ANNULLA = "+CPLib.ToSQL(_spcanc,"N",1,0)+", ";
          m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(_dtcanc,"D",8,0)+", ";
          m_cSql = m_cSql+"INVIATOC = "+CPLib.ToSQL(_cspedito,"N",1,0)+", ";
          m_cSql = m_cSql+"DATAINVIOC = "+CPLib.ToSQL(_cdata,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"))+"";
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
          /* _contarec := _contarec + 1 */
          _contarec = CPLib.Round(_contarec+1,0);
          Cursor_aetesta.Next();
        }
        m_cConnectivityError = Cursor_aetesta.ErrorMessage();
        Cursor_aetesta.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(_contarec,15,0))+" rapporti dell'Anagrafe Rapporti" + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" rapporti dell'Anagrafe Rapporti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + " dell'Anagrafe Rapporti" */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dell'Anagrafe Rapporti";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into intermbo from all
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_age",108,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"AGGAGE = "+CPLib.ToSQL(1,"N",1,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
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
        /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata!";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000020status,0)) {
          m_Sql.SetTransactionStatus(nTry00000020status,cTry00000020msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_minmax_opex!=null)
          Cursor_qbe_minmax_opex.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_opextrbo_age!=null)
          Cursor_qbe_opextrbo_age.Close();
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
      try {
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
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
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
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
      m_Caller.SetString("anno","C",4,0,w_anno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_allinea_ageR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_ageR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_anno = m_Caller.GetString("anno","C",4,0);
    _codcli = CPLib.Space(16);
    _contaerr = 0;
    _min = 0;
    _max = 0;
    _cicli = 0;
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _totale = 0;
    _contarec = 0;
    _ucode = CPLib.Space(50);
    _inviato = 0;
    _aspedito = 0;
    _adata = CPLib.NullDate();
    _cspedito = 0;
    _cdata = CPLib.NullDate();
    _idbase = CPLib.Space(10);
    _spcanc = 0;
    _dtcanc = CPLib.NullDate();
    _contad = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_minmax_opex,qbe_opextrbo_age,
  public static final String m_cVQRList = ",qbe_minmax_opex,qbe_opextrbo_age,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
