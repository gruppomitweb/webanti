// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calcsaldi_opexR implements CallerWithObjs {
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
  public double w_annorif;
  public String w_valuta;
  public String w_flgazz;
  public String w_ndgcli;
  public String w_flgmopx;
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
  public String codage;
  public String _noopex;
  public MemoryCursor_mcsaldiopx_mcrdef mcSaldi;
  public MemoryCursorRow_mcsaldiopx_mcrdef rowSaldi;
  public double _reccount;
  public double _tot;
  public double _mono;
  public String _rapporto;
  public String _annoc;
  public double _totsal;
  public double _numope;
  public String w_flgmod;
  public java.sql.Date _datope;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calcsaldi_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calcsaldi_opex",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annorif",p_cVarName)) {
      return w_annorif;
    }
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      return _totsal;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_calcsaldi_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return w_valuta;
    }
    if (CPLib.eqr("flgazz",p_cVarName)) {
      return w_flgazz;
    }
    if (CPLib.eqr("ndgcli",p_cVarName)) {
      return w_ndgcli;
    }
    if (CPLib.eqr("flgmopx",p_cVarName)) {
      return w_flgmopx;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      return _codcli;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return codage;
    }
    if (CPLib.eqr("_noopex",p_cVarName)) {
      return _noopex;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    if (CPLib.eqr("flgmod",p_cVarName)) {
      return w_flgmod;
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
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
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
    if (CPLib.eqr("mcSaldi",p_cVarName)) {
      return mcSaldi;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowSaldi",p_cVarName)) {
      return rowSaldi;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("annorif",p_cVarName)) {
      w_annorif = value;
      return;
    }
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
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
    if (CPLib.eqr("_totsal",p_cVarName)) {
      _totsal = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("valuta",p_cVarName)) {
      w_valuta = value;
      return;
    }
    if (CPLib.eqr("flgazz",p_cVarName)) {
      w_flgazz = value;
      return;
    }
    if (CPLib.eqr("ndgcli",p_cVarName)) {
      w_ndgcli = value;
      return;
    }
    if (CPLib.eqr("flgmopx",p_cVarName)) {
      w_flgmopx = value;
      return;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      _codcli = value;
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
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      _annoc = value;
      return;
    }
    if (CPLib.eqr("flgmod",p_cVarName)) {
      w_flgmod = value;
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
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowSaldi",p_cVarName)) {
      rowSaldi = (MemoryCursorRow_mcsaldiopx_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcSaldi",p_cVarName)) {
      mcSaldi = (MemoryCursor_mcsaldiopx_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_saldi_opex_o_minmax=null;
    CPResultSet Cursor_qbe_saldi_opex_f_minmax=null;
    CPResultSet Cursor_qbe_saldi_opex_j_minmax=null;
    CPResultSet Cursor_qbe_saldi_opex_o_g=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_saldi_opex_f_g=null;
    CPResultSet Cursor_qbe_saldi_opex_j_g=null;
    CPResultSet Cursor_qbe_saldi_opex_o=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_annorif Numeric(4, 0) */
      /* w_valuta Char(3) */
      /* w_flgazz Char(1) */
      /* w_ndgcli Char(16) */
      /* w_flgmopx Char(1) */
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
      /* codage Char(5) // Codice Agenzia */
      /* _noopex Char(1) // Salta operazione */
      /* mcSaldi MemoryCursor(mcSaldiOPX.MCRDef) */
      /* rowSaldi Row(mcSaldiOPX.MCRDef) */
      /* _reccount Numeric(10, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _rapporto Char(50) */
      /* _annoc Char(4) */
      /* _totsal Numeric(12, 2) */
      /* _numope Numeric(10, 0) */
      /* w_flgmod Char(1) */
      /* _datope Date */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio Import */
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
      double nTry00000027status;
      nTry00000027status = m_Sql.GetTransactionStatus();
      String cTry00000027msg;
      cTry00000027msg = m_Sql.TransactionErrorMessage();
      try {
        /* If Empty(w_ndgcli) */
        if (CPLib.Empty(w_ndgcli)) {
          /* w_ndgcli := '' */
          w_ndgcli = "";
          /* w_flgmopx := 'N' */
          w_flgmopx = "N";
          /* w_flgmod := 'N' */
          w_flgmod = "N";
          /* Azzera Saldi */
          /* gMsgProc := 'Ora inizio elaborazione saldi: '+arfn_fdatetime(DateTime()) + NL // Messaggio Import */
          gMsgProc = "Ora inizio elaborazione saldi: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If w_flgazz='S' */
          if (CPLib.eqr(w_flgazz,"S")) {
            /* gMsgImp := 'Azzeramento saldi preesistenti ...' */
            gMsgImp = "Azzeramento saldi preesistenti ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(w_ndgcli) */
            if (CPLib.Empty(w_ndgcli)) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"00000031")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(0,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(0,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0))+"";
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
            } else { // Else
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(0,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(0,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0))+"";
              m_cSql = m_cSql+" and COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer),m_cServer,w_ndgcli)+"";
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
            } // End If
          } // End If
          /* _contaerr := 0 */
          _contaerr = CPLib.Round(0,0);
          /* _contarec := 0 */
          _contarec = CPLib.Round(0,0);
          /* Seleziona record da elaborare */
          // * --- Select from qbe_saldi_opex_o_minmax
          SPBridge.HMCaller _h00000037;
          _h00000037 = new SPBridge.HMCaller();
          _h00000037.Set("m_cVQRList",m_cVQRList);
          _h00000037.Set("annorif",w_annorif);
          _h00000037.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_o_minmax!=null)
            Cursor_qbe_saldi_opex_o_minmax.Close();
          Cursor_qbe_saldi_opex_o_minmax = new VQRHolder("qbe_saldi_opex_o_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000037,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_o_minmax.Eof())) {
            /* _min := qbe_saldi_opex_o_minmax->MIN */
            _min = CPLib.Round(Cursor_qbe_saldi_opex_o_minmax.GetDouble("MIN"),0);
            /* _max := qbe_saldi_opex_o_minmax->MAX */
            _max = CPLib.Round(Cursor_qbe_saldi_opex_o_minmax.GetDouble("MAX"),0);
            /* _totale := qbe_saldi_opex_o_minmax->COUNT */
            _totale = CPLib.Round(Cursor_qbe_saldi_opex_o_minmax.GetDouble("COUNT"),0);
            /* _tot := qbe_saldi_opex_o_minmax->COUNT */
            _tot = CPLib.Round(Cursor_qbe_saldi_opex_o_minmax.GetDouble("COUNT"),0);
            Cursor_qbe_saldi_opex_o_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_o_minmax.ErrorMessage();
          Cursor_qbe_saldi_opex_o_minmax.Close();
          // * --- End Select
          // * --- Select from qbe_saldi_opex_f_minmax
          SPBridge.HMCaller _h0000003C;
          _h0000003C = new SPBridge.HMCaller();
          _h0000003C.Set("m_cVQRList",m_cVQRList);
          _h0000003C.Set("annorif",w_annorif);
          _h0000003C.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_f_minmax!=null)
            Cursor_qbe_saldi_opex_f_minmax.Close();
          Cursor_qbe_saldi_opex_f_minmax = new VQRHolder("qbe_saldi_opex_f_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003C,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_f_minmax.Eof())) {
            /* _totale := _totale + qbe_saldi_opex_f_minmax->COUNT */
            _totale = CPLib.Round(_totale+Cursor_qbe_saldi_opex_f_minmax.GetDouble("COUNT"),0);
            Cursor_qbe_saldi_opex_f_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_f_minmax.ErrorMessage();
          Cursor_qbe_saldi_opex_f_minmax.Close();
          // * --- End Select
          // * --- Select from qbe_saldi_opex_j_minmax
          SPBridge.HMCaller _h0000003E;
          _h0000003E = new SPBridge.HMCaller();
          _h0000003E.Set("m_cVQRList",m_cVQRList);
          _h0000003E.Set("annorif",w_annorif);
          _h0000003E.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_j_minmax!=null)
            Cursor_qbe_saldi_opex_j_minmax.Close();
          Cursor_qbe_saldi_opex_j_minmax = new VQRHolder("qbe_saldi_opex_j_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_j_minmax.Eof())) {
            /* _totale := _totale + qbe_saldi_opex_j_minmax->COUNT */
            _totale = CPLib.Round(_totale+Cursor_qbe_saldi_opex_j_minmax.GetDouble("COUNT"),0);
            Cursor_qbe_saldi_opex_j_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_j_minmax.ErrorMessage();
          Cursor_qbe_saldi_opex_j_minmax.Close();
          // * --- End Select
          /* _mono := iif(_tot > 5000,0,1) */
          _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              /* gMsgImp := 'Estrazione dati operazioni ...' */
              gMsgImp = "Estrazione dati operazioni ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Fill memory cursor mcSaldi on qbe_saldi_opex_o_g
              mcSaldi.Zap();
              SPBridge.HMCaller _h00000055;
              _h00000055 = new SPBridge.HMCaller();
              _h00000055.Set("m_cVQRList",m_cVQRList);
              _h00000055.Set("annosel",w_annorif);
              _h00000055.Set("_bottom",_bottom);
              _h00000055.Set("_top",_top);
              _h00000055.Set("annoopx",CPLib.Str(w_annorif,4,0));
              _h00000055.Set("ndgcli",w_ndgcli);
              if (Cursor_qbe_saldi_opex_o_g!=null)
                Cursor_qbe_saldi_opex_o_g.Close();
              Cursor_qbe_saldi_opex_o_g = new VQRHolder("qbe_saldi_opex_o_g",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000055,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_saldi_opex_o_g;
                Cursor_qbe_saldi_opex_o_g.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_calcsaldi_opex: query on qbe_saldi_opex_o_g returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_saldi_opex_o_g.Eof())) {
                mcSaldi.AppendBlank();
                mcSaldi.row.CONNESCLI = Cursor_qbe_saldi_opex_o_g.GetString("CONNESCLI");
                mcSaldi.row.IDFILE = Cursor_qbe_saldi_opex_o_g.GetString("IDFILE");
                mcSaldi.row.TOTLIRE = Cursor_qbe_saldi_opex_o_g.GetDouble("TOTLIRE");
                mcSaldi.row.NUMPROG = "";
                mcSaldi.row.MACODICE = Cursor_qbe_saldi_opex_o_g.GetString("MACODICE");
                mcSaldi.row.MAFLGNOX = Cursor_qbe_saldi_opex_o_g.GetString("MAFLGNOX");
                mcSaldi.row.COLLEG = Cursor_qbe_saldi_opex_o_g.GetString("COLLEG");
                mcSaldi.row.RAPPORTO = "";
                Cursor_qbe_saldi_opex_o_g.Next();
              }
              m_cConnectivityError = Cursor_qbe_saldi_opex_o_g.ErrorMessage();
              Cursor_qbe_saldi_opex_o_g.Close();
              mcSaldi.GoTop();
              for (MemoryCursorRow_mcsaldiopx_mcrdef rowSaldi : mcSaldi._iterable_()) {
                /* If Empty(LRTrim(rowSaldi.MAFLGNOX)) or rowSaldi.MAFLGNOX='N' */
                if (CPLib.Empty(CPLib.LRTrim(rowSaldi.MAFLGNOX)) || CPLib.eqr(rowSaldi.MAFLGNOX,"N")) {
                  /* _contarec := _contarec + 1 */
                  _contarec = CPLib.Round(_contarec+1,0);
                  /* gMsgImp := 'Elaboro operazione n. '+LRTrim(Str(_contarec,15,0))+' su '+LRTrim(Str(_totale,15,0)) */
                  gMsgImp = "Elaboro operazione n. "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" su "+CPLib.LRTrim(CPLib.Str(_totale,15,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _rapporto := '' */
                  _rapporto = "";
                  // * --- Read from opextrbo
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSaldi.COLLEG,"C",16,0,m_cServer),m_cServer,rowSaldi.COLLEG);
                  m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0));
                  if (m_Ctx.IsSharedTemp("opextrbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _rapporto = Read_Cursor.GetString("RAPPORTO");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_calcsaldi_opex returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _rapporto = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _rapporto := iif(Empty(_rapporto),Str(w_annorif,4,0)+'_'+LRTrim(rowSaldi.CONNESCLI),_rapporto) */
                  _rapporto = (CPLib.Empty(_rapporto)?CPLib.Str(w_annorif,4,0)+"_"+CPLib.LRTrim(rowSaldi.CONNESCLI):_rapporto);
                  /* If not(Empty(rowSaldi.COLLEG)) */
                  if ( ! (CPLib.Empty(rowSaldi.COLLEG))) {
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"SALDO = SALDO+("+CPLib.ToSQL(rowSaldi.TOTLIRE/100,"N",17,0)+"), ";
                    m_cSql = m_cSql+"QUANTITA = QUANTITA+("+CPLib.ToSQL(1,"N",6,0)+"), ";
                    m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowSaldi.CONNESCLI))+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0))+"";
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
                  } else { // Else
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    // * --- Insert into tmp_newpers from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_newpers");
                    m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Record assente per l'anno "+CPLib.Str(w_annorif,4.0),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
              }
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          // * --- Select from qbe_saldi_opex_f_minmax
          SPBridge.HMCaller _h00000063;
          _h00000063 = new SPBridge.HMCaller();
          _h00000063.Set("m_cVQRList",m_cVQRList);
          _h00000063.Set("annorif",w_annorif);
          _h00000063.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_f_minmax!=null)
            Cursor_qbe_saldi_opex_f_minmax.Close();
          Cursor_qbe_saldi_opex_f_minmax = new VQRHolder("qbe_saldi_opex_f_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000063,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_f_minmax.Eof())) {
            /* _min := qbe_saldi_opex_f_minmax->MIN */
            _min = CPLib.Round(Cursor_qbe_saldi_opex_f_minmax.GetDouble("MIN"),0);
            /* _max := qbe_saldi_opex_f_minmax->MAX */
            _max = CPLib.Round(Cursor_qbe_saldi_opex_f_minmax.GetDouble("MAX"),0);
            /* _tot := qbe_saldi_opex_f_minmax->COUNT */
            _tot = CPLib.Round(Cursor_qbe_saldi_opex_f_minmax.GetDouble("COUNT"),0);
            Cursor_qbe_saldi_opex_f_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_f_minmax.ErrorMessage();
          Cursor_qbe_saldi_opex_f_minmax.Close();
          // * --- End Select
          /* _mono := iif(_tot > 5000,0,1) */
          _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              /* gMsgImp := 'Estrazione dati frazionate ...' */
              gMsgImp = "Estrazione dati frazionate ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Fill memory cursor mcSaldi on qbe_saldi_opex_f_g
              mcSaldi.Zap();
              SPBridge.HMCaller _h0000007C;
              _h0000007C = new SPBridge.HMCaller();
              _h0000007C.Set("m_cVQRList",m_cVQRList);
              _h0000007C.Set("annosel",w_annorif);
              _h0000007C.Set("_bottom",_bottom);
              _h0000007C.Set("_top",_top);
              _h0000007C.Set("annoopx",CPLib.Str(w_annorif,4,0));
              _h0000007C.Set("ndgcli",w_ndgcli);
              if (Cursor_qbe_saldi_opex_f_g!=null)
                Cursor_qbe_saldi_opex_f_g.Close();
              Cursor_qbe_saldi_opex_f_g = new VQRHolder("qbe_saldi_opex_f_g",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007C,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_saldi_opex_f_g;
                Cursor_qbe_saldi_opex_f_g.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_calcsaldi_opex: query on qbe_saldi_opex_f_g returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_saldi_opex_f_g.Eof())) {
                mcSaldi.AppendBlank();
                mcSaldi.row.CONNESCLI = Cursor_qbe_saldi_opex_f_g.GetString("CONNESCLI");
                mcSaldi.row.IDFILE = Cursor_qbe_saldi_opex_f_g.GetString("IDFILE");
                mcSaldi.row.TOTLIRE = Cursor_qbe_saldi_opex_f_g.GetDouble("TOTLIRE");
                mcSaldi.row.NUMPROG = "";
                mcSaldi.row.MACODICE = Cursor_qbe_saldi_opex_f_g.GetString("MACODICE");
                mcSaldi.row.MAFLGNOX = Cursor_qbe_saldi_opex_f_g.GetString("MAFLGNOX");
                mcSaldi.row.COLLEG = Cursor_qbe_saldi_opex_f_g.GetString("COLLEG");
                mcSaldi.row.RAPPORTO = "";
                Cursor_qbe_saldi_opex_f_g.Next();
              }
              m_cConnectivityError = Cursor_qbe_saldi_opex_f_g.ErrorMessage();
              Cursor_qbe_saldi_opex_f_g.Close();
              mcSaldi.GoTop();
              for (MemoryCursorRow_mcsaldiopx_mcrdef rowSaldi : mcSaldi._iterable_()) {
                /* If Empty(LRTrim(rowSaldi.MAFLGNOX)) or rowSaldi.MAFLGNOX='N' */
                if (CPLib.Empty(CPLib.LRTrim(rowSaldi.MAFLGNOX)) || CPLib.eqr(rowSaldi.MAFLGNOX,"N")) {
                  /* _contarec := _contarec + 1 */
                  _contarec = CPLib.Round(_contarec+1,0);
                  /* gMsgImp := 'Elaboro operazione n. '+LRTrim(Str(_contarec,15,0))+' su '+LRTrim(Str(_totale,15,0)) */
                  gMsgImp = "Elaboro operazione n. "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" su "+CPLib.LRTrim(CPLib.Str(_totale,15,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _rapporto := '' */
                  _rapporto = "";
                  // * --- Read from opextrbo
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSaldi.COLLEG,"C",16,0,m_cServer),m_cServer,rowSaldi.COLLEG);
                  m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0));
                  if (m_Ctx.IsSharedTemp("opextrbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _rapporto = Read_Cursor.GetString("RAPPORTO");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_calcsaldi_opex returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _rapporto = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _rapporto := iif(Empty(_rapporto),Str(w_annorif,4,0)+'_'+LRTrim(rowSaldi.CONNESCLI),_rapporto) */
                  _rapporto = (CPLib.Empty(_rapporto)?CPLib.Str(w_annorif,4,0)+"_"+CPLib.LRTrim(rowSaldi.CONNESCLI):_rapporto);
                  /* If not(Empty(rowSaldi.COLLEG)) */
                  if ( ! (CPLib.Empty(rowSaldi.COLLEG))) {
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"00000085")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"SALDO = SALDO+("+CPLib.ToSQL(rowSaldi.TOTLIRE/100,"N",17,0)+"), ";
                    m_cSql = m_cSql+"QUANTITA = QUANTITA+("+CPLib.ToSQL(1,"N",6,0)+"), ";
                    m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowSaldi.CONNESCLI))+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0))+"";
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
                  } else { // Else
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    // * --- Insert into tmp_newpers from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_newpers");
                    m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"00000087")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000087(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Record assente per l'anno "+CPLib.Str(w_annorif,4.0),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
              }
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          // * --- Select from qbe_saldi_opex_j_minmax
          SPBridge.HMCaller _h0000008A;
          _h0000008A = new SPBridge.HMCaller();
          _h0000008A.Set("m_cVQRList",m_cVQRList);
          _h0000008A.Set("annorif",w_annorif);
          _h0000008A.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_j_minmax!=null)
            Cursor_qbe_saldi_opex_j_minmax.Close();
          Cursor_qbe_saldi_opex_j_minmax = new VQRHolder("qbe_saldi_opex_j_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000008A,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_j_minmax.Eof())) {
            /* _min := qbe_saldi_opex_j_minmax->MIN */
            _min = CPLib.Round(Cursor_qbe_saldi_opex_j_minmax.GetDouble("MIN"),0);
            /* _max := qbe_saldi_opex_j_minmax->MAX */
            _max = CPLib.Round(Cursor_qbe_saldi_opex_j_minmax.GetDouble("MAX"),0);
            /* _tot := qbe_saldi_opex_j_minmax->COUNT */
            _tot = CPLib.Round(Cursor_qbe_saldi_opex_j_minmax.GetDouble("COUNT"),0);
            Cursor_qbe_saldi_opex_j_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_j_minmax.ErrorMessage();
          Cursor_qbe_saldi_opex_j_minmax.Close();
          // * --- End Select
          /* _mono := iif(_tot > 5000,0,1) */
          _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              /* gMsgImp := 'Estrazione dati operazioni AGE ...' */
              gMsgImp = "Estrazione dati operazioni AGE ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Fill memory cursor mcSaldi on qbe_saldi_opex_j_g
              mcSaldi.Zap();
              SPBridge.HMCaller _h000000A3;
              _h000000A3 = new SPBridge.HMCaller();
              _h000000A3.Set("m_cVQRList",m_cVQRList);
              _h000000A3.Set("annosel",w_annorif);
              _h000000A3.Set("_bottom",_bottom);
              _h000000A3.Set("_top",_top);
              _h000000A3.Set("annoopx",CPLib.Str(w_annorif,4,0));
              _h000000A3.Set("ndgcli",w_ndgcli);
              if (Cursor_qbe_saldi_opex_j_g!=null)
                Cursor_qbe_saldi_opex_j_g.Close();
              Cursor_qbe_saldi_opex_j_g = new VQRHolder("qbe_saldi_opex_j_g",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A3,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_saldi_opex_j_g;
                Cursor_qbe_saldi_opex_j_g.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_calcsaldi_opex: query on qbe_saldi_opex_j_g returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_saldi_opex_j_g.Eof())) {
                mcSaldi.AppendBlank();
                mcSaldi.row.CONNESCLI = Cursor_qbe_saldi_opex_j_g.GetString("CONNESCLI");
                mcSaldi.row.IDFILE = Cursor_qbe_saldi_opex_j_g.GetString("IDFILE");
                mcSaldi.row.TOTLIRE = Cursor_qbe_saldi_opex_j_g.GetDouble("TOTLIRE");
                mcSaldi.row.NUMPROG = "";
                mcSaldi.row.MACODICE = Cursor_qbe_saldi_opex_j_g.GetString("MACODICE");
                mcSaldi.row.MAFLGNOX = Cursor_qbe_saldi_opex_j_g.GetString("MAFLGNOX");
                mcSaldi.row.COLLEG = Cursor_qbe_saldi_opex_j_g.GetString("COLLEG");
                mcSaldi.row.RAPPORTO = "";
                Cursor_qbe_saldi_opex_j_g.Next();
              }
              m_cConnectivityError = Cursor_qbe_saldi_opex_j_g.ErrorMessage();
              Cursor_qbe_saldi_opex_j_g.Close();
              mcSaldi.GoTop();
              for (MemoryCursorRow_mcsaldiopx_mcrdef rowSaldi : mcSaldi._iterable_()) {
                /* If Empty(LRTrim(rowSaldi.MAFLGNOX)) or rowSaldi.MAFLGNOX='N' */
                if (CPLib.Empty(CPLib.LRTrim(rowSaldi.MAFLGNOX)) || CPLib.eqr(rowSaldi.MAFLGNOX,"N")) {
                  /* _contarec := _contarec + 1 */
                  _contarec = CPLib.Round(_contarec+1,0);
                  /* gMsgImp := 'Elaboro operazione n. '+LRTrim(Str(_contarec,15,0))+' su '+LRTrim(Str(_totale,15,0)) */
                  gMsgImp = "Elaboro operazione n. "+CPLib.LRTrim(CPLib.Str(_contarec,15,0))+" su "+CPLib.LRTrim(CPLib.Str(_totale,15,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _rapporto := '' */
                  _rapporto = "";
                  // * --- Read from opextrbo
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSaldi.COLLEG,"C",16,0,m_cServer),m_cServer,rowSaldi.COLLEG);
                  m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0));
                  if (m_Ctx.IsSharedTemp("opextrbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _rapporto = Read_Cursor.GetString("RAPPORTO");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_calcsaldi_opex returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _rapporto = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _rapporto := iif(Empty(_rapporto),Str(w_annorif,4,0)+'_'+LRTrim(rowSaldi.CONNESCLI),_rapporto) */
                  _rapporto = (CPLib.Empty(_rapporto)?CPLib.Str(w_annorif,4,0)+"_"+CPLib.LRTrim(rowSaldi.CONNESCLI):_rapporto);
                  /* If not(Empty(rowSaldi.COLLEG)) */
                  if ( ! (CPLib.Empty(rowSaldi.COLLEG))) {
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000AC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"SALDO = SALDO+("+CPLib.ToSQL(rowSaldi.TOTLIRE/100,"N",17,0)+"), ";
                    m_cSql = m_cSql+"QUANTITA = QUANTITA+("+CPLib.ToSQL(1,"N",6,0)+"), ";
                    m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowSaldi.CONNESCLI))+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0))+"";
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
                  } else { // Else
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    // * --- Insert into tmp_newpers from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_newpers");
                    m_cPhName = m_Ctx.GetPhName("tmp_newpers");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSaldi.CONNESCLI),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Record assente per l'anno "+CPLib.Str(w_annorif,4.0),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
              }
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          /* If _contaerr = 0 */
          if (CPLib.eqr(_contaerr,0)) {
            /* gMsgImp := 'ELABORAZIONE TERMINATA SENZA ERRORI' */
            gMsgImp = "ELABORAZIONE TERMINATA SENZA ERRORI";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            /* gMsgImp := 'ELABORAZIONE TERMINATA CON ERRORI. PREMERE IL BOTTONE DI STAMPA PER LA LISTA' */
            gMsgImp = "ELABORAZIONE TERMINATA CON ERRORI. PREMERE IL BOTTONE DI STAMPA PER LA LISTA";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
        } else { // Else
          /* _annoc := Str(w_annorif,4,0) */
          _annoc = CPLib.Str(w_annorif,4,0);
          /* _totsal := 0 */
          _totsal = CPLib.Round(0,2);
          /* _numope := 0 */
          _numope = CPLib.Round(0,0);
          /* _datope := NullDate() */
          _datope = CPLib.NullDate();
          // * --- Select from qbe_saldi_opex_o
          SPBridge.HMCaller _h000000B7;
          _h000000B7 = new SPBridge.HMCaller();
          _h000000B7.Set("m_cVQRList",m_cVQRList);
          _h000000B7.Set("annosel",w_annorif);
          _h000000B7.Set("ndgcli",w_ndgcli);
          if (Cursor_qbe_saldi_opex_o!=null)
            Cursor_qbe_saldi_opex_o.Close();
          Cursor_qbe_saldi_opex_o = new VQRHolder("qbe_saldi_opex_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B7,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_saldi_opex_o.Eof())) {
            /* _totsal := _totsal + qbe_saldi_opex_o->TOTLIRE */
            _totsal = CPLib.Round(_totsal+Cursor_qbe_saldi_opex_o.GetDouble("TOTLIRE"),2);
            /* _numope := _numope + qbe_saldi_opex_o->TOTOPER */
            _numope = CPLib.Round(_numope+Cursor_qbe_saldi_opex_o.GetDouble("TOTOPER"),0);
            /* _datope := iif((qbe_saldi_opex_o->DATAOPE < _datope or Empty(_datope)),qbe_saldi_opex_o->DATAOPE,_datope) */
            _datope = ((CPLib.lt(Cursor_qbe_saldi_opex_o.GetDate("DATAOPE"),_datope) || CPLib.Empty(_datope))?Cursor_qbe_saldi_opex_o.GetDate("DATAOPE"):_datope);
            Cursor_qbe_saldi_opex_o.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_o.ErrorMessage();
          Cursor_qbe_saldi_opex_o.Close();
          // * --- End Select
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ndgcli,"C",16,0,m_cServer),m_cServer,w_ndgcli);
          m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(w_annorif,4,0));
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_calcsaldi_opex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _rapporto := iif(Empty(_rapporto),Str(w_annorif,4,0)+'_'+LRTrim(w_ndgcli),_rapporto) */
          _rapporto = (CPLib.Empty(_rapporto)?CPLib.Str(w_annorif,4,0)+"_"+CPLib.LRTrim(w_ndgcli):_rapporto);
          /* If w_flgmopx='S' */
          if (CPLib.eqr(w_flgmopx,"S")) {
            // * --- Merge into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(w_ndgcli,"?",0,0)+" as COLLEG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_annoc,"?",0,0)+" as ANNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "opextrbo.COLLEG = cptmp_1xab23.COLLEG";
            m_cWhere = m_cWhere+" and "+"opextrbo.ANNO = cptmp_1xab23.ANNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000BF")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" opextrbo USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_000000BF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totsal,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer),m_cServer,w_ndgcli)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoc,"?",0,0,m_cServer),m_cServer,_annoc)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000BF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000BF(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_totsal,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_valuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
                m_cSql = m_cSql+")";
              } else {
                m_cSql = "";
              }
            }
            if ( ! (CPLib.Empty(m_cSql))) {
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            }
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
          } else { // Else
            // * --- Merge into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(w_ndgcli,"?",0,0)+" as COLLEG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_annoc,"?",0,0)+" as ANNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "opextrbo.COLLEG = cptmp_1xab23.COLLEG";
            m_cWhere = m_cWhere+" and "+"opextrbo.ANNO = cptmp_1xab23.ANNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000C0")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" opextrbo USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_000000C0(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totsal,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000C0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_rapporto,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer),m_cServer,w_ndgcli)+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoc,"?",0,0,m_cServer),m_cServer,_annoc)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex",135,"000000C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_ndgcli,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_totsal,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_valuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
                m_cSql = m_cSql+")";
              } else {
                m_cSql = "";
              }
            }
            if ( ! (CPLib.Empty(m_cSql))) {
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            }
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000027status,0)) {
          m_Sql.SetTransactionStatus(nTry00000027status,cTry00000027msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora fine elaborazione saldi: '+arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgProc = gMsgProc+"Ora fine elaborazione saldi: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_saldi_opex_o_minmax!=null)
          Cursor_qbe_saldi_opex_o_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_f_minmax!=null)
          Cursor_qbe_saldi_opex_f_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_j_minmax!=null)
          Cursor_qbe_saldi_opex_j_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_o_g!=null)
          Cursor_qbe_saldi_opex_o_g.Close();
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
        if (Cursor_qbe_saldi_opex_f_g!=null)
          Cursor_qbe_saldi_opex_f_g.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_j_g!=null)
          Cursor_qbe_saldi_opex_j_g.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_o!=null)
          Cursor_qbe_saldi_opex_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_w_annorif,String p_w_valuta,String p_w_flgazz,String p_w_ndgcli,String p_w_flgmopx) {
    w_annorif = p_w_annorif;
    w_valuta = p_w_valuta;
    w_flgazz = p_w_flgazz;
    w_ndgcli = p_w_ndgcli;
    w_flgmopx = p_w_flgmopx;
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
  public String Run(double p_w_annorif,String p_w_valuta,String p_w_flgazz,String p_w_ndgcli,String p_w_flgmopx) {
    w_annorif = p_w_annorif;
    w_valuta = p_w_valuta;
    w_flgazz = p_w_flgazz;
    w_ndgcli = p_w_ndgcli;
    w_flgmopx = p_w_flgmopx;
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
  public static arrt_calcsaldi_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calcsaldi_opexR(p_Ctx, p_Caller);
  }
  public static arrt_calcsaldi_opexR Make(CPContext p_Ctx) {
    return new arrt_calcsaldi_opexR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_annorif = 0;
    w_valuta = CPLib.Space(3);
    w_flgazz = CPLib.Space(1);
    w_ndgcli = CPLib.Space(16);
    w_flgmopx = CPLib.Space(1);
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
    codage = CPLib.Space(5);
    _noopex = CPLib.Space(1);
    mcSaldi = new MemoryCursor_mcsaldiopx_mcrdef();
    rowSaldi = new MemoryCursorRow_mcsaldiopx_mcrdef();
    _reccount = 0;
    _tot = 0;
    _mono = 0;
    _rapporto = CPLib.Space(50);
    _annoc = CPLib.Space(4);
    _totsal = 0;
    _numope = 0;
    w_flgmod = CPLib.Space(1);
    _datope = CPLib.NullDate();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_saldi_opex_o_minmax,qbe_saldi_opex_f_minmax,qbe_saldi_opex_j_minmax,qbe_saldi_opex_o_g,qbe_saldi_opex_f_minmax,qbe_saldi_opex_f_g,qbe_saldi_opex_j_minmax,qbe_saldi_opex_j_g,qbe_saldi_opex_o,
  public static final String m_cVQRList = ",qbe_saldi_opex_o_minmax,qbe_saldi_opex_f_minmax,qbe_saldi_opex_j_minmax,qbe_saldi_opex_o_g,qbe_saldi_opex_f_minmax,qbe_saldi_opex_f_g,qbe_saldi_opex_j_minmax,qbe_saldi_opex_j_g,qbe_saldi_opex_o,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_calcsaldi_opex,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_calcsaldi_opex,";
  public static String[] m_cRunParameterNames={"w_annorif","w_valuta","w_flgazz","w_ndgcli","w_flgmopx"};
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000087(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"DATAMODI,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
}
