// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_residenza_soggettiR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
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
  public double _esiste;
  public String _presenza;
  public String w_CONNES;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _reccount;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _oldmsg;
  public MemoryCursor_tbcitta mcTbcitta;
  public MemoryCursor_decodecitta mcDecodeCitta;
  public double _totrec;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_allinea_residenza_soggettiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_residenza_soggetti",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_esiste",p_cVarName)) {
      return _esiste;
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
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
    if (CPLib.eqr("_totrec",p_cVarName)) {
      return _totrec;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_residenza_soggetti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_presenza",p_cVarName)) {
      return _presenza;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      return mcTbcitta;
    }
    if (CPLib.eqr("mcDecodeCitta",p_cVarName)) {
      return mcDecodeCitta;
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
    if (CPLib.eqr("_esiste",p_cVarName)) {
      _esiste = value;
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_totrec",p_cVarName)) {
      _totrec = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_presenza",p_cVarName)) {
      _presenza = value;
      return;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
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
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      mcTbcitta = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcDecodeCitta",p_cVarName)) {
      mcDecodeCitta = (MemoryCursor_decodecitta)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_decodecitta=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_wu_conta_rec=null;
    CPResultSet Cursor_qbe_wu_conta_dati=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _esiste Numeric(10, 0) */
      /* _presenza Memo */
      /* w_CONNES Char(16) // NDG Soggetto */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _reccount Numeric(0, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _oldmsg Char(100) */
      /* mcTbcitta MemoryCursor(tbcitta) // Tabella città residenza */
      /* mcDecodeCitta MemoryCursor(DecodeCitta) // Tabella città residenza */
      /* _totrec Numeric(10, 0) */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Fill memory cursor mcTbcitta on tbcitta
      mcTbcitta.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_allinea_residenza_soggetti: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTbcitta.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbcitta.GetString("CITTA")));
        mcTbcitta.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTbcitta.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTbcitta.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTbcitta.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTbcitta.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTbcitta.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTbcitta.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTbcitta.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTbcitta.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTbcitta.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTbcitta.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTbcitta.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTbcitta.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTbcitta.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTbcitta.GoTop();
      // * --- Fill memory cursor mcDecodeCitta on DecodeCitta
      mcDecodeCitta.Zap();
      m_cServer = m_Ctx.GetServer("DecodeCitta");
      m_cPhName = m_Ctx.GetPhName("DecodeCitta");
      if (Cursor_decodecitta!=null)
        Cursor_decodecitta.Close();
      Cursor_decodecitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[NOTEMPTYSTR(CITTAMIT)]>0 "+")"+(m_Ctx.IsSharedTemp("DecodeCitta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_decodecitta;
        Cursor_decodecitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_allinea_residenza_soggetti: query on DecodeCitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_decodecitta.Eof())) {
        mcDecodeCitta.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_decodecitta.GetString("CITTA")));
        mcDecodeCitta.row.ID = Cursor_decodecitta.GetDouble("ID");
        mcDecodeCitta.row.IDBASE = Cursor_decodecitta.GetString("IDBASE");
        mcDecodeCitta.row.CITTAMIT = Cursor_decodecitta.GetString("CITTAMIT");
        mcDecodeCitta.row.CAB = Cursor_decodecitta.GetString("CAB");
        mcDecodeCitta.row.PROV = Cursor_decodecitta.GetString("PROV");
        mcDecodeCitta.row.CAPMIT = Cursor_decodecitta.GetString("CAPMIT");
        mcDecodeCitta.row.PKTBSTATI = Cursor_decodecitta.GetString("PKTBSTATI");
        mcDecodeCitta.row.SIGLA = Cursor_decodecitta.GetString("SIGLA");
        mcDecodeCitta.row.PREF = Cursor_decodecitta.GetString("PREF");
        mcDecodeCitta.row.IDTBLS = Cursor_decodecitta.GetString("IDTBLS");
        mcDecodeCitta.row.CITTA = Cursor_decodecitta.GetString("CITTA");
        mcDecodeCitta.row.PR = Cursor_decodecitta.GetString("PR");
        mcDecodeCitta.row.CATASTALE = Cursor_decodecitta.GetString("CATASTALE");
        mcDecodeCitta.row.CAP = Cursor_decodecitta.GetString("CAP");
        mcDecodeCitta.row.REGIONE = Cursor_decodecitta.GetString("REGIONE");
        Cursor_decodecitta.Next();
      }
      m_cConnectivityError = Cursor_decodecitta.ErrorMessage();
      Cursor_decodecitta.Close();
      mcDecodeCitta.GoTop();
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000001C;
      _h0000001C = new SPBridge.HMCaller();
      _h0000001C.Set("m_cVQRList",m_cVQRList);
      _h0000001C.Set("tbname","personbo");
      _h0000001C.Set("fldname","PROGIMPORT");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _min := qbe_tab_mmc->min */
        _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* _max := qbe_tab_mmc->max */
        _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* _tot := qbe_tab_mmc->tot */
        _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If _tot > 0 */
      if (CPLib.gt(_tot,0)) {
        // * --- Select from qbe_wu_conta_rec
        if (Cursor_qbe_wu_conta_rec!=null)
          Cursor_qbe_wu_conta_rec.Close();
        Cursor_qbe_wu_conta_rec = new VQRHolder("qbe_wu_conta_rec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_wu_conta_rec.Eof())) {
          /* _totrec := qbe_wu_conta_rec->TOTREC */
          _totrec = CPLib.Round(Cursor_qbe_wu_conta_rec.GetDouble("TOTREC"),0);
          Cursor_qbe_wu_conta_rec.Next();
        }
        m_cConnectivityError = Cursor_qbe_wu_conta_rec.ErrorMessage();
        Cursor_qbe_wu_conta_rec.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + "Record errati prima dell'elaborazione: "+ LRTrim(Str(_totrec,10,0)) + NL */
        gMsgProc = gMsgProc+"Record errati prima dell'elaborazione: "+CPLib.LRTrim(CPLib.Str(_totrec,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _oldmsg := '' */
        _oldmsg = "";
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
          /* _reccount := _tot */
          _reccount = CPLib.Round(_tot,0);
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000031status;
        nTry00000031status = m_Sql.GetTransactionStatus();
        String cTry00000031msg;
        cTry00000031msg = m_Sql.TransactionErrorMessage();
        try {
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
                /* _top := _min + 999 */
                _top = CPLib.Round(_min+999,0);
                /* ElseIf _contacicli = _cicli */
              } else if (CPLib.eqr(_contacicli,_cicli)) {
                /* _bottom := _top + 1 */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _max */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := _top + 1 */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _bottom + 999 */
                _top = CPLib.Round(_bottom+999,0);
              } // End If
            } // End If
            /* gMsgImp := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
            gMsgImp = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) + NL // Messaggio */
              gMsgProc = gMsgProc+"Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
            _oldmsg = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_wu_conta_dati
              SPBridge.HMCaller _h00000043;
              _h00000043 = new SPBridge.HMCaller();
              _h00000043.Set("m_cVQRList",m_cVQRList);
              _h00000043.Set("_bottom",_bottom);
              _h00000043.Set("_top",_top);
              if (Cursor_qbe_wu_conta_dati!=null)
                Cursor_qbe_wu_conta_dati.Close();
              Cursor_qbe_wu_conta_dati = new VQRHolder("qbe_wu_conta_dati",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000043,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_wu_conta_dati.Eof())) {
                /* gMsgImp := 'Elaborazione soggetto con NDG: '+ w_CONNES // Messaggio Import */
                gMsgImp = "Elaborazione soggetto con NDG: "+w_CONNES;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* w_CONNES := qbe_wu_conta_dati->CONNES // NDG Soggetto */
                w_CONNES = Cursor_qbe_wu_conta_dati.GetString("CONNES");
                /* _esiste := 0 */
                _esiste = CPLib.Round(0,0);
                for (MemoryCursorRow_tbcitta rowCitta : mcTbcitta._iterable_()) {
                  /* If LRTrim(rowCitta.CITTA)=LRTrim(qbe_wu_conta_dati->DESCCIT) */
                  if (CPLib.eqr(CPLib.LRTrim(rowCitta.CITTA),CPLib.LRTrim(Cursor_qbe_wu_conta_dati.GetString("DESCCIT")))) {
                    /* _esiste := 1 */
                    _esiste = CPLib.Round(1,0);
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_residenza_soggetti",29,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL("086","C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(rowCitta.CITTA,30),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(rowCitta.PROV),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.LRTrim(rowCitta.CAP),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.LRTrim(rowCitta.CAB),"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_wu_conta_dati.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_wu_conta_dati.GetString("CONNES"))+"";
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
                }
                /* If _esiste=0 */
                if (CPLib.eqr(_esiste,0)) {
                  for (MemoryCursorRow_decodecitta rowDecode : mcDecodeCitta._iterable_()) {
                    /* If LRTrim(rowDecode.CITTA)=LRTrim(qbe_wu_conta_dati->DESCCIT) */
                    if (CPLib.eqr(CPLib.LRTrim(rowDecode.CITTA),CPLib.LRTrim(Cursor_qbe_wu_conta_dati.GetString("DESCCIT")))) {
                      /* _esiste := 1 */
                      _esiste = CPLib.Round(1,0);
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_residenza_soggetti",29,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL("086","C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(rowDecode.CITTAMIT,30),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(rowDecode.PROV),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.LRTrim(rowDecode.CAPMIT),"C",9,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.LRTrim(rowDecode.CAB),"C",6,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_wu_conta_dati.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_wu_conta_dati.GetString("CONNES"))+"";
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
                  }
                } // End If
                Cursor_qbe_wu_conta_dati.Next();
              }
              m_cConnectivityError = Cursor_qbe_wu_conta_dati.ErrorMessage();
              Cursor_qbe_wu_conta_dati.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura soggetti in corso ...' // Messaggio Import */
              gMsgImp = "Lettura soggetti in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          // * --- Select from qbe_wu_conta_rec
          if (Cursor_qbe_wu_conta_rec!=null)
            Cursor_qbe_wu_conta_rec.Close();
          Cursor_qbe_wu_conta_rec = new VQRHolder("qbe_wu_conta_rec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_wu_conta_rec.Eof())) {
            /* _totrec := qbe_wu_conta_rec->TOTREC */
            _totrec = CPLib.Round(Cursor_qbe_wu_conta_rec.GetDouble("TOTREC"),0);
            Cursor_qbe_wu_conta_rec.Next();
          }
          m_cConnectivityError = Cursor_qbe_wu_conta_rec.ErrorMessage();
          Cursor_qbe_wu_conta_rec.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc + "Record errati dopo l'elaborazione: "+ LRTrim(Str(_totrec,10,0)) + NL */
          gMsgProc = gMsgProc+"Record errati dopo l'elaborazione: "+CPLib.LRTrim(CPLib.Str(_totrec,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione abortita causa errori. Contattare Assistenza!' // Messaggio Import */
          gMsgImp = "Elaborazione abortita causa errori. Contattare Assistenza!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000031status,0)) {
            m_Sql.SetTransactionStatus(nTry00000031status,cTry00000031msg);
          }
        }
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_decodecitta!=null)
          Cursor_decodecitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_wu_conta_rec!=null)
          Cursor_qbe_wu_conta_rec.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_wu_conta_dati!=null)
          Cursor_qbe_wu_conta_dati.Close();
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
  public static arrt_allinea_residenza_soggettiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_residenza_soggettiR(p_Ctx, p_Caller);
  }
  public static arrt_allinea_residenza_soggettiR Make(CPContext p_Ctx) {
    return new arrt_allinea_residenza_soggettiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _esiste = 0;
    _presenza = "";
    w_CONNES = CPLib.Space(16);
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _reccount = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _oldmsg = CPLib.Space(100);
    mcTbcitta = new MemoryCursor_tbcitta();
    mcDecodeCitta = new MemoryCursor_decodecitta();
    _totrec = 0;
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_wu_conta_rec,qbe_wu_conta_dati,qbe_wu_conta_rec,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_wu_conta_rec,qbe_wu_conta_dati,qbe_wu_conta_rec,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_allinea_residenza_soggetti,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_allinea_residenza_soggetti,";
  public static String[] m_cRunParameterNames={};
}
