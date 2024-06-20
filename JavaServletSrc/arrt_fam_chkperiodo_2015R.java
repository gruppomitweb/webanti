// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_chkperiodo_2015R implements CallerWithObjs {
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
  public String m_cPhName_tmp_chkperiodo;
  public String m_cServer_tmp_chkperiodo;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
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
  public double _conta;
  public String _errore;
  public double _errori;
  public MemoryCursor_mcchkperiodo_mcrdef mcTemp;
  public MemoryCursorRow_mcchkperiodo_mcrdef rowTemp;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _cicli;
  public double _totrecord;
  public double _reccount;
  public String _oldmsg;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrors;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_chkperiodo_2015R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_chkperiodo_2015",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
      m_cPhName_tmp_chkperiodo = p_ContextObject.GetPhName("tmp_chkperiodo");
      if (m_cPhName_tmp_chkperiodo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_chkperiodo = m_cPhName_tmp_chkperiodo+" "+m_Ctx.GetWritePhName("tmp_chkperiodo");
      }
      m_cServer_tmp_chkperiodo = p_ContextObject.GetServer("tmp_chkperiodo");
    }
    m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
    if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
    }
    m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_errori",p_cVarName)) {
      return _errori;
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
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      return _totrecord;
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
      return "arrt_fam_chkperiodo_2015";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
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
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcErrors",p_cVarName)) {
      return mcErrors;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
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
    if (CPLib.eqr("_errori",p_cVarName)) {
      _errori = value;
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
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      _totrecord = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
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
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_mcchkperiodo_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_mcchkperiodo_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrors",p_cVarName)) {
      mcErrors = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_fam_periodo01_minmax=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_01_2015=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* _errori Numeric(10, 0) */
      /* mcTemp MemoryCursor(mcChkPeriodo.MCRDef) */
      /* rowTemp Row(mcChkPeriodo.MCRDef) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _totrecord Numeric(10, 0) */
      /* _reccount Numeric(0, 0) */
      /* _oldmsg Memo */
      /* mcErrors MemoryCursor(mcErrSaldi.MCRDef) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := 'Ora Inizio  Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio  Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Drop temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      // * --- Create temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_chkperiodo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_chkperiodo"))) {
        m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chkperiodo",m_cServer,"proto")),m_cPhName,"tmp_chkperiodo",m_Ctx);
      }
      m_cPhName_tmp_chkperiodo = m_cPhName;
      /* gMsgProc := gMsgProc + "Estrazione dati per il periodo" + NL // Messaggio */
      gMsgProc = gMsgProc+"Estrazione dati per il periodo"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
      gMsgImp = "Attendere. Estrazione dati per il periodo ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_fam_periodo01_minmax
      SPBridge.HMCaller _h00000021;
      _h00000021 = new SPBridge.HMCaller();
      _h00000021.Set("m_cVQRList",m_cVQRList);
      _h00000021.Set("_dadata",w_DaDatOpe);
      _h00000021.Set("_adata",w_ADatOpe);
      _h00000021.Set("_inviato",1);
      if (Cursor_qbe_fam_periodo01_minmax!=null)
        Cursor_qbe_fam_periodo01_minmax.Close();
      Cursor_qbe_fam_periodo01_minmax = new VQRHolder("qbe_fam_periodo01_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000021,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_fam_periodo01_minmax.Eof())) {
        /* _totrecord := _totrecord + qbe_fam_periodo01_minmax->TOTPRG */
        _totrecord = CPLib.Round(_totrecord+Cursor_qbe_fam_periodo01_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_fam_periodo01_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_periodo01_minmax.ErrorMessage();
      Cursor_qbe_fam_periodo01_minmax.Close();
      // * --- End Select
      /* If _totrecord > 0 */
      if (CPLib.gt(_totrecord,0)) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000025status;
        nTry00000025status = m_Sql.GetTransactionStatus();
        String cTry00000025msg;
        cTry00000025msg = m_Sql.TransactionErrorMessage();
        try {
          /* _errori := 0 */
          _errori = CPLib.Round(0,0);
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_01_2015
          mcTemp.Zap();
          SPBridge.HMCaller _h00000027;
          _h00000027 = new SPBridge.HMCaller();
          _h00000027.Set("m_cVQRList",m_cVQRList);
          _h00000027.Set("dadata",w_DaDatOpe);
          _h00000027.Set("a_data",w_ADatOpe);
          if (Cursor_qbe_fam_chkperiodo_01_2015!=null)
            Cursor_qbe_fam_chkperiodo_01_2015.Close();
          Cursor_qbe_fam_chkperiodo_01_2015 = new VQRHolder("qbe_fam_chkperiodo_01_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000027,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_01_2015;
            Cursor_qbe_fam_chkperiodo_01_2015.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkperiodo_2015: query on qbe_fam_chkperiodo_01_2015 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_01_2015.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_01_2015.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_01_2015.GetString("RAPPORTO");
            mcTemp.row.CODINTER = "";
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_01_2015.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_01_2015.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_01_2015.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_01_2015.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_01_2015.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_01_2015.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_01_2015.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_01_2015.Close();
          mcTemp.GoTop();
          /* gMsgProc := gMsgProc + 'Ora Inizio controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          for (MemoryCursorRow_mcchkperiodo_mcrdef rowTemp : mcTemp._iterable_()) {
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* mcErrors := arfn_anomes_rapp(rowTemp.RAPPORTO,rowTemp.TIPO,'S') */
            mcErrors = arfn_anomes_rappR.Make(m_Ctx,this).Run(rowTemp.RAPPORTO,rowTemp.TIPO,"S");
            /* If mcErrors.RecCount() > 0 */
            if (CPLib.gt(mcErrors.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrors._iterable_()) {
                /* _errori := _errori + 1 */
                _errori = CPLib.Round(_errori+1,0);
                // * --- Insert into tmp_chkperiodo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
                m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkperiodo_2015",50,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAINI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAFINE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.CONNESINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
            } // End If
          }
          /* Exec "Operazioni Extraconto" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" +NL // Messaggio */
          gMsgProc = gMsgProc+"Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Fine Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Elaborazione Terminata. E' possibile effettuare la stampa" // Messaggio Import */
          gMsgImp = "Elaborazione Terminata. E' possibile effettuare la stampa";
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
          /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
          gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000025status,0)) {
            m_Sql.SetTransactionStatus(nTry00000025status,cTry00000025msg);
          }
        }
      } // End If
      /* If _errori > 0 */
      if (CPLib.gt(_errori,0)) {
        /* Stop arrp_fam_chkperiodo.vrp */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("_dadata",w_DaDatOpe);
        f.SetParameter("_adata",w_ADatOpe);
        f.SetParameter("hideCover",true);
        f.SetParameter("hideLanguage",true);
        f.SetParameter("hideSettings",true);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("ReportName","arrp_fam_chkperiodo.vrp");
        f.SetParameter("m_cParameterSequence","_dadata"+","+"_adata"+","+"hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"ReportName");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        // * --- Insert into tmp_chkperiodo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
        m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkperiodo_2015",50,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("XXX","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
        /* Stop arrp_fam_chkperiodo_noerr.vrp */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("_dadata",w_DaDatOpe);
        f.SetParameter("_adata",w_ADatOpe);
        f.SetParameter("hideCover",true);
        f.SetParameter("hideLanguage",true);
        f.SetParameter("hideSettings",true);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("ReportName","arrp_fam_chkperiodo_noerr.vrp");
        f.SetParameter("m_cParameterSequence","_dadata"+","+"_adata"+","+"hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"ReportName");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_fam_periodo01_minmax!=null)
          Cursor_qbe_fam_periodo01_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_01_2015!=null)
          Cursor_qbe_fam_chkperiodo_01_2015.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_famperiodo_opx_min_max=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_opx_2015=null;
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
      // * --- Select from qbe_famperiodo_opx_min_max
      SPBridge.HMCaller _h00000042;
      _h00000042 = new SPBridge.HMCaller();
      _h00000042.Set("m_cVQRList",m_cVQRList);
      _h00000042.Set("_dadata",w_DaDatOpe);
      _h00000042.Set("_adata",w_ADatOpe);
      _h00000042.Set("_inviato",1);
      if (Cursor_qbe_famperiodo_opx_min_max!=null)
        Cursor_qbe_famperiodo_opx_min_max.Close();
      Cursor_qbe_famperiodo_opx_min_max = new VQRHolder("qbe_famperiodo_opx_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000042,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famperiodo_opx_min_max.Eof())) {
        /* _min := qbe_famperiodo_opx_min_max->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MINPRG"),0);
        /* _max := qbe_famperiodo_opx_min_max->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famperiodo_opx_min_max->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("TOTPRG"),0);
        Cursor_qbe_famperiodo_opx_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_famperiodo_opx_min_max.ErrorMessage();
      Cursor_qbe_famperiodo_opx_min_max.Close();
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
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) + NL // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp)+"\n";
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
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_opx_2015
          mcTemp.Zap();
          SPBridge.HMCaller _h00000062;
          _h00000062 = new SPBridge.HMCaller();
          _h00000062.Set("m_cVQRList",m_cVQRList);
          _h00000062.Set("dadata",w_DaDatOpe);
          _h00000062.Set("a_data",w_ADatOpe);
          _h00000062.Set("_bottom",_bottom);
          _h00000062.Set("_top",_top);
          if (Cursor_qbe_fam_chkperiodo_opx_2015!=null)
            Cursor_qbe_fam_chkperiodo_opx_2015.Close();
          Cursor_qbe_fam_chkperiodo_opx_2015 = new VQRHolder("qbe_fam_chkperiodo_opx_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000062,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_opx_2015;
            Cursor_qbe_fam_chkperiodo_opx_2015.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkperiodo_2015: query on qbe_fam_chkperiodo_opx_2015 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_opx_2015.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("RAPPORTO");
            mcTemp.row.CODINTER = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("CODINTER");
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_opx_2015.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_opx_2015.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_opx_2015.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_opx_2015.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_opx_2015.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_mcchkperiodo_mcrdef rowTemp : mcTemp._iterable_()) {
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* mcErrors := arfn_anomes_opex(rowTemp.RAPPORTO,rowTemp.TIPO,'S') */
            mcErrors = arfn_anomes_opexR.Make(m_Ctx,this).Run(rowTemp.RAPPORTO,rowTemp.TIPO,"S");
            /* If mcErrors.RecCount() > 0 */
            if (CPLib.gt(mcErrors.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrors._iterable_()) {
                /* _errori := _errori + 1 */
                _errori = CPLib.Round(_errori+1,0);
                // * --- Insert into tmp_chkperiodo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
                m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkperiodo_2015",50,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAINI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAFINE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.CONNESINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
              }
            } // End If
          }
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_famperiodo_opx_min_max!=null)
          Cursor_qbe_famperiodo_opx_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_opx_2015!=null)
          Cursor_qbe_fam_chkperiodo_opx_2015.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_fam_chkperiodo_2015R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_chkperiodo_2015R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    _conta = 0;
    _errore = "";
    _errori = 0;
    mcTemp = new MemoryCursor_mcchkperiodo_mcrdef();
    rowTemp = new MemoryCursorRow_mcchkperiodo_mcrdef();
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _totrecord = 0;
    _reccount = 0;
    _oldmsg = "";
    mcErrors = new MemoryCursor_mcerrsaldi_mcrdef();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_periodo01_minmax,qbe_fam_chkperiodo_01_2015,qbe_famperiodo_opx_min_max,qbe_fam_chkperiodo_opx_2015,
  public static final String m_cVQRList = ",qbe_fam_periodo01_minmax,qbe_fam_chkperiodo_01_2015,qbe_famperiodo_opx_min_max,qbe_fam_chkperiodo_opx_2015,";
  // ENTITY_BATCHES: ,arfn_anomes_opex,arfn_anomes_rapp,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_anomes_opex,arfn_anomes_rapp,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
}
