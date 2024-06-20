// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calcsaldi_opex_wuR implements CallerWithObjs {
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
  public String gMsgImp;
  public String gMsgProc;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public String _oldmsg;
  public double _conta;
  public double _contaerr;
  public double _contarec;
  public MemoryCursor_mcsaldiopx_mcrdef mcSaldi;
  public String _rapporto;
  public String _annoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calcsaldi_opex_wuR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calcsaldi_opex_wu",m_Caller);
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      return _contaerr;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_calcsaldi_opex_wu";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return w_valuta;
    }
    if (CPLib.eqr("flgazz",p_cVarName)) {
      return w_flgazz;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      _contaerr = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
      return;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
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
    CPResultSet Cursor_qbe_saldi_opex_o_g_wu=null;
    CPResultSet Cursor_opextrbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_annorif Numeric(4, 0) */
      /* w_valuta Char(3) */
      /* w_flgazz Char(1) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _oldmsg Memo */
      /* _conta Numeric(15, 0) */
      /* _contaerr Numeric(10, 0) */
      /* _contarec Numeric(15, 0) */
      /* mcSaldi MemoryCursor(mcSaldiOPX.MCRDef) */
      /* _rapporto Char(50) */
      /* _annoc Char(4) */
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
      /* _ddatini := CharToDate(Str(w_annorif,4,0)+"0101") */
      _ddatini = CPLib.CharToDate(CPLib.Str(w_annorif,4,0)+"0101");
      /* _ddatfin := CharToDate(Str(w_annorif,4,0)+"1231") */
      _ddatfin = CPLib.CharToDate(CPLib.Str(w_annorif,4,0)+"1231");
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000001Bstatus;
      nTry0000001Bstatus = m_Sql.GetTransactionStatus();
      String cTry0000001Bmsg;
      cTry0000001Bmsg = m_Sql.TransactionErrorMessage();
      try {
        /* Azzera Saldi */
        /* If w_flgazz='S' */
        if (CPLib.eqr(w_flgazz,"S")) {
          /* gMsgImp := 'Azzeramento saldi preesistenti ...' */
          gMsgImp = "Azzeramento saldi preesistenti ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_wu",153,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _annoc := Str(w_annorif,4,0) */
        _annoc = CPLib.Str(w_annorif,4,0);
        /* _contaerr := 0 */
        _contaerr = CPLib.Round(0,0);
        /* _contarec := 0 */
        _contarec = CPLib.Round(0,0);
        /* _dataoggi := _ddatini */
        _dataoggi = _ddatini;
        /* _cdataoggi := DateToChar(_ddatini) */
        _cdataoggi = CPLib.DateToChar(_ddatini);
        /* _oldmsg := '' */
        _oldmsg = "";
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi)  // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi);
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi);
          /* mcSaldi.Zap() */
          mcSaldi.Zap();
          // * --- Fill memory cursor mcSaldi on qbe_saldi_opex_o_g_wu
          mcSaldi.Zap();
          SPBridge.HMCaller _h0000002F;
          _h0000002F = new SPBridge.HMCaller();
          _h0000002F.Set("m_cVQRList",m_cVQRList);
          _h0000002F.Set("_datope",_cdataoggi);
          _h0000002F.Set("pANNO",_annoc);
          if (Cursor_qbe_saldi_opex_o_g_wu!=null)
            Cursor_qbe_saldi_opex_o_g_wu.Close();
          Cursor_qbe_saldi_opex_o_g_wu = new VQRHolder("qbe_saldi_opex_o_g_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_saldi_opex_o_g_wu;
            Cursor_qbe_saldi_opex_o_g_wu.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_calcsaldi_opex_wu: query on qbe_saldi_opex_o_g_wu returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_saldi_opex_o_g_wu.Eof())) {
            mcSaldi.AppendBlank();
            mcSaldi.row.CONNESCLI = Cursor_qbe_saldi_opex_o_g_wu.GetString("CONNESCLI");
            mcSaldi.row.IDFILE = Cursor_qbe_saldi_opex_o_g_wu.GetString("IDFILE");
            mcSaldi.row.TOTLIRE = Cursor_qbe_saldi_opex_o_g_wu.GetDouble("TOTLIRE");
            mcSaldi.row.NUMPROG = Cursor_qbe_saldi_opex_o_g_wu.GetString("NUMPROG");
            mcSaldi.row.MACODICE = Cursor_qbe_saldi_opex_o_g_wu.GetString("MACODICE");
            mcSaldi.row.MAFLGNOX = Cursor_qbe_saldi_opex_o_g_wu.GetString("MAFLGNOX");
            mcSaldi.row.COLLEG = Cursor_qbe_saldi_opex_o_g_wu.GetString("COLLEG");
            mcSaldi.row.RAPPORTO = "";
            Cursor_qbe_saldi_opex_o_g_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_saldi_opex_o_g_wu.ErrorMessage();
          Cursor_qbe_saldi_opex_o_g_wu.Close();
          mcSaldi.GoTop();
          for (MemoryCursorRow_mcsaldiopx_mcrdef rowSaldi : mcSaldi._iterable_()) {
            /* If Empty(LRTrim(rowSaldi.MAFLGNOX)) or rowSaldi.MAFLGNOX='N' */
            if (CPLib.Empty(CPLib.LRTrim(rowSaldi.MAFLGNOX)) || CPLib.eqr(rowSaldi.MAFLGNOX,"N")) {
              /* _contarec := _contarec + 1 */
              _contarec = CPLib.Round(_contarec+1,0);
              /* gMsgImp := 'Elaboro operazione n. ' + LRTrim(rowSaldi.NUMPROG) */
              gMsgImp = "Elaboro operazione n. "+CPLib.LRTrim(rowSaldi.NUMPROG);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _rapporto := iif(Empty(rowSaldi.RAPPORTO),Str(w_annorif,4,0)+'_'+LRTrim(rowSaldi.CONNESCLI),rowSaldi.RAPPORTO) */
              _rapporto = (CPLib.Empty(rowSaldi.RAPPORTO)?CPLib.Str(w_annorif,4,0)+"_"+CPLib.LRTrim(rowSaldi.CONNESCLI):rowSaldi.RAPPORTO);
              /* If not(Empty(rowSaldi.COLLEG)) */
              if ( ! (CPLib.Empty(rowSaldi.COLLEG))) {
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_wu",153,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_wu",153,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
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
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        /* If _contarec > 0 */
        if (CPLib.gt(_contarec,0)) {
          /* gMsgProc := gMsgProc + NL + 'Sono state estratte '+ LRTrim(Str(_contarec,10,0)) + " operazioni/frazionate" + NL */
          gMsgProc = gMsgProc+"\n"+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarec,10,0))+" operazioni/frazionate"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc +NL + 'Non ci sono operazioni da elaborare per il periodo.' + NL */
          gMsgProc = gMsgProc+"\n"+"Non ci sono operazioni da elaborare per il periodo."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from opextrbo
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
        Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select COLLEG,ANNO,DATAANNU  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annorif,4,0),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Str(w_annorif,4,0))+"  and  SALDO=0 "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_opextrbo.Eof())) {
          /* If Empty(opextrbo->DATAANNU) */
          if (CPLib.Empty(Cursor_opextrbo.GetDate("DATAANNU"))) {
            // * --- Write into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_wu",153,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_opextrbo.GetString("COLLEG")),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_opextrbo.GetString("COLLEG")))+"";
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
          } // End If
          Cursor_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
        Cursor_opextrbo.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* If _contaerr = 0 */
        if (CPLib.eqr(_contaerr,0)) {
          /* gMsgImp := 'ELABORAZIONE TERMINATA SENZA ERRORI.' */
          gMsgImp = "ELABORAZIONE TERMINATA SENZA ERRORI.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* gMsgImp := 'ELABORAZIONE TERMINATA CON ERRORI. PREMERE IL BOTTONE DI STAMPA PER LA LISTA' */
          gMsgImp = "ELABORAZIONE TERMINATA CON ERRORI. PREMERE IL BOTTONE DI STAMPA PER LA LISTA";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Bstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Bstatus,cTry0000001Bmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_saldi_opex_o_g_wu!=null)
          Cursor_qbe_saldi_opex_o_g_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_w_annorif,String p_w_valuta,String p_w_flgazz) {
    w_annorif = p_w_annorif;
    w_valuta = p_w_valuta;
    w_flgazz = p_w_flgazz;
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
  public String Run(double p_w_annorif,String p_w_valuta,String p_w_flgazz) {
    w_annorif = p_w_annorif;
    w_valuta = p_w_valuta;
    w_flgazz = p_w_flgazz;
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
  public static arrt_calcsaldi_opex_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calcsaldi_opex_wuR(p_Ctx, p_Caller);
  }
  public static arrt_calcsaldi_opex_wuR Make(CPContext p_Ctx) {
    return new arrt_calcsaldi_opex_wuR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_annorif = 0;
    w_valuta = CPLib.Space(3);
    w_flgazz = CPLib.Space(1);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _oldmsg = "";
    _conta = 0;
    _contaerr = 0;
    _contarec = 0;
    mcSaldi = new MemoryCursor_mcsaldiopx_mcrdef();
    _rapporto = CPLib.Space(50);
    _annoc = CPLib.Space(4);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_saldi_opex_o_g_wu,
  public static final String m_cVQRList = ",qbe_saldi_opex_o_g_wu,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_calcsaldi_opex_wu,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_calcsaldi_opex_wu,";
  public static String[] m_cRunParameterNames={"w_annorif","w_valuta","w_flgazz"};
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
}
