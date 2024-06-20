// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_annullafileR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aefaminvio;
  public String m_cServer_aefaminvio;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
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
  public String w_CODINVIO;
  public String w_nomefile;
  public String w_idbase;
  public String w_anno;
  public String w_mese;
  public String w_TIPOCOMU;
  public String w_TIPOINVIO;
  public double _aperte;
  public double _chiuse;
  public double _cancellate;
  public String _nomefile;
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
  public String cRisultato;
  public String gAzienda;
  public String gMsgImp;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_annullafileR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_annullafile",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aefaminvio = p_ContextObject.GetPhName("aefaminvio");
    if (m_cPhName_aefaminvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefaminvio = m_cPhName_aefaminvio+" "+m_Ctx.GetWritePhName("aefaminvio");
    }
    m_cServer_aefaminvio = p_ContextObject.GetServer("aefaminvio");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_aperte",p_cVarName)) {
      return _aperte;
    }
    if (CPLib.eqr("_chiuse",p_cVarName)) {
      return _chiuse;
    }
    if (CPLib.eqr("_cancellate",p_cVarName)) {
      return _cancellate;
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
      return "arrt_fam_annullafile";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("CODINVIO",p_cVarName)) {
      return w_CODINVIO;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return w_idbase;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("TIPOCOMU",p_cVarName)) {
      return w_TIPOCOMU;
    }
    if (CPLib.eqr("TIPOINVIO",p_cVarName)) {
      return w_TIPOINVIO;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cRisultato",p_cVarName)) {
      return cRisultato;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("_aperte",p_cVarName)) {
      _aperte = value;
      return;
    }
    if (CPLib.eqr("_chiuse",p_cVarName)) {
      _chiuse = value;
      return;
    }
    if (CPLib.eqr("_cancellate",p_cVarName)) {
      _cancellate = value;
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
    if (CPLib.eqr("CODINVIO",p_cVarName)) {
      w_CODINVIO = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      w_idbase = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("TIPOCOMU",p_cVarName)) {
      w_TIPOCOMU = value;
      return;
    }
    if (CPLib.eqr("TIPOINVIO",p_cVarName)) {
      w_TIPOINVIO = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cRisultato",p_cVarName)) {
      cRisultato = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_aefaminvio_min_max=null;
    CPResultSet Cursor_qbe_aefaminvio_select=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_CODINVIO Char(12) // Codice Invio */
      /* w_nomefile Char(20) */
      /* w_idbase Char(10) */
      /* w_anno Char(4) */
      /* w_mese Char(2) // Mese di riferimento */
      /* w_TIPOCOMU Char(1) // Tipo Comunicazione */
      /* w_TIPOINVIO Char(1) // Tipo Invio */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _nomefile Char(128) */
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
      /* cRisultato Char(2) := 'KO' */
      cRisultato = "KO";
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gPathApp Char(80) // Path Applicazione */
      /* Legge da aesaldi */
      // * --- Read from aesaldi
      m_cServer = m_Ctx.GetServer("aesaldi");
      m_cPhName = m_Ctx.GetPhName("aesaldi");
      m_cSql = "";
      m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"C",10,0,m_cServer),m_cServer,w_idbase);
      if (m_Ctx.IsSharedTemp("aesaldi")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOINVIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOCOMU",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        w_anno = Read_Cursor.GetString("ANNO");
        w_mese = Read_Cursor.GetString("MESE");
        w_TIPOINVIO = Read_Cursor.GetString("TIPOINVIO");
        w_TIPOCOMU = Read_Cursor.GetString("TIPOCOMU");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aesaldi into routine arrt_fam_annullafile returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        w_anno = "";
        w_mese = "";
        w_TIPOINVIO = "";
        w_TIPOCOMU = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* Prima conta poi cancella */
      /* _nomefile := Left(w_nomefile,15) */
      _nomefile = CPLib.Left(w_nomefile,15);
      /* _aperte := 0 */
      _aperte = CPLib.Round(0,0);
      /* gMsgImp := "Attendere. Elaborazione in corso" // Messaggio Import */
      gMsgImp = "Attendere. Elaborazione in corso";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000024status;
      nTry00000024status = m_Sql.GetTransactionStatus();
      String cTry00000024msg;
      cTry00000024msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Delete from aesaldi
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000025")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
        /* If w_TIPOINVIO='1' or w_TIPOINVIO='2' */
        if (CPLib.eqr(w_TIPOINVIO,"1") || CPLib.eqr(w_TIPOINVIO,"2")) {
          /* _max := 0 */
          _max = CPLib.Round(0,0);
          /* _min := 0 */
          _min = CPLib.Round(0,0);
          /* _tot := 0 */
          _tot = CPLib.Round(0,0);
          // * --- Select from qbe_aefaminvio_min_max
          SPBridge.HMCaller _h0000002A;
          _h0000002A = new SPBridge.HMCaller();
          _h0000002A.Set("m_cVQRList",m_cVQRList);
          _h0000002A.Set("pIDIDBASE",w_CODINVIO);
          if (Cursor_qbe_aefaminvio_min_max!=null)
            Cursor_qbe_aefaminvio_min_max.Close();
          Cursor_qbe_aefaminvio_min_max = new VQRHolder("qbe_aefaminvio_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002A,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_aefaminvio_min_max.Eof())) {
            /* _min := qbe_aefaminvio_min_max->MINPROG */
            _min = CPLib.Round(Cursor_qbe_aefaminvio_min_max.GetDouble("MINPROG"),0);
            /* _max := qbe_aefaminvio_min_max->MAXPROG */
            _max = CPLib.Round(Cursor_qbe_aefaminvio_min_max.GetDouble("MAXPROG"),0);
            /* _tot := qbe_aefaminvio_min_max->TOTPROG */
            _tot = CPLib.Round(Cursor_qbe_aefaminvio_min_max.GetDouble("TOTPROG"),0);
            Cursor_qbe_aefaminvio_min_max.Next();
          }
          m_cConnectivityError = Cursor_qbe_aefaminvio_min_max.ErrorMessage();
          Cursor_qbe_aefaminvio_min_max.Close();
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
            /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
          } // End If
          /* _contacicli := 1 */
          _contacicli = CPLib.Round(1,0);
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
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_aefaminvio_select
              SPBridge.HMCaller _h00000043;
              _h00000043 = new SPBridge.HMCaller();
              _h00000043.Set("m_cVQRList",m_cVQRList);
              _h00000043.Set("pIDIDBASE",w_CODINVIO);
              _h00000043.Set("_bottom",_bottom);
              _h00000043.Set("_top",_top);
              if (Cursor_qbe_aefaminvio_select!=null)
                Cursor_qbe_aefaminvio_select.Close();
              Cursor_qbe_aefaminvio_select = new VQRHolder("qbe_aefaminvio_select",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000043,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_aefaminvio_select.Eof())) {
                /* _aperte := _aperte + 1 */
                _aperte = CPLib.Round(_aperte+1,0);
                /* Case w_TIPOCOMU='1' */
                if (CPLib.eqr(w_TIPOCOMU,"1")) {
                  /* If qbe_aefaminvio_select->TIPO='O' or qbe_aefaminvio_select->TIPO='Q' */
                  if (CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"O") || CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"Q")) {
                    /* gMsgImp := "Aggiorno operazione extraconto: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno operazione extraconto: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000048")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                    /* gMsgImp := "Aggiorno Rapporto Continuativo: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno Rapporto Continuativo: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                  /* Case w_TIPOCOMU='2' */
                } else if (CPLib.eqr(w_TIPOCOMU,"2")) {
                  /* If qbe_aefaminvio_select->TIPO='O' or qbe_aefaminvio_select->TIPO='Q' */
                  if (CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"O") || CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"Q")) {
                    /* gMsgImp := "Aggiorno operazione extraconto: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno operazione extraconto: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000004D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetDate("OLDDATA"),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                    /* gMsgImp := "Aggiorno Rapporto Continuativo: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno Rapporto Continuativo: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetDate("OLDDATA"),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                  /* Case w_TIPOCOMU='3' */
                } else if (CPLib.eqr(w_TIPOCOMU,"3")) {
                  /* If qbe_aefaminvio_select->TIPO='O' or qbe_aefaminvio_select->TIPO='Q' */
                  if (CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"O") || CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"Q")) {
                    /* gMsgImp := "Aggiorno operazione extraconto: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno operazione extraconto: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000052")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVSALDO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"DTSALDO = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                    /* gMsgImp := "Aggiorno Rapporto Continuativo: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno Rapporto Continuativo: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into aeannora from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aeannora");
                    m_cPhName = m_Ctx.GetPhName("aeannora");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000054")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("ANNO"))+"";
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
                  /* Case w_TIPOCOMU='4' */
                } else if (CPLib.eqr(w_TIPOCOMU,"4")) {
                  /* If qbe_aefaminvio_select->TIPO='O' or qbe_aefaminvio_select->TIPO='Q' */
                  if (CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"O") || CPLib.eqr(Cursor_qbe_aefaminvio_select.GetString("TIPO"),"Q")) {
                    /* gMsgImp := "Aggiorno operazione extraconto: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno operazione extraconto: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000057")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"ANNULLA = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                    /* gMsgImp := "Aggiorno Rapporto Continuativo: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                    gMsgImp = "Aggiorno Rapporto Continuativo: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000059")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"ANNULLA = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                  /* Case w_TIPOCOMU='5' */
                } else if (CPLib.eqr(w_TIPOCOMU,"5")) {
                  /* gMsgImp := "Aggiorno Rapporto Continuativo: "+LRTrim(qbe_aefaminvio_select->RAPPORTO) // Messaggio Import */
                  gMsgImp = "Aggiorno Rapporto Continuativo: "+CPLib.LRTrim(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  // * --- Write into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000005B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"INVIATOC = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"DATAINVIOC = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aefaminvio_select.GetString("RAPPORTO"))+"";
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
                } // End Case
                Cursor_qbe_aefaminvio_select.Next();
              }
              m_cConnectivityError = Cursor_qbe_aefaminvio_select.ErrorMessage();
              Cursor_qbe_aefaminvio_select.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
              gMsgImp = "Lettura operazioni extraconto in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          // * --- Delete from aefaminvio
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefaminvio");
          m_cPhName = m_Ctx.GetPhName("aefaminvio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefaminvio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000005E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDIDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
          // * --- Delete from sid_invio
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"0000005F")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
          // * --- Delete from sid_invio1
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000060")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
          // * --- Delete from sid_invio2
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio2");
          m_cPhName = m_Ctx.GetPhName("sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000061")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
          // * --- Delete from sid_invio3
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio3");
          m_cPhName = m_Ctx.GetPhName("sid_invio3");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_annullafile",55,"00000062")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINVIO,"?",0,0,m_cServer),m_cServer,w_CODINVIO)+"";
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
        /* gMsgImp := "Elaborazione terminata con successo! Aggiornate "+LRTrim(Str(_aperte,10,0))+" Famiglie" // Messaggio Import */
        gMsgImp = "Elaborazione terminata con successo! Aggiornate "+CPLib.LRTrim(CPLib.Str(_aperte,10,0))+" Famiglie";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cRisultato := 'OK' */
        cRisultato = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Elaborazione terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000024status,0)) {
          m_Sql.SetTransactionStatus(nTry00000024status,cTry00000024msg);
        }
      }
      /* Return cRisultato */
      throw new Stop(cRisultato);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aefaminvio_min_max!=null)
          Cursor_qbe_aefaminvio_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aefaminvio_select!=null)
          Cursor_qbe_aefaminvio_select.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_CODINVIO,String p_w_nomefile,String p_w_idbase) {
    w_CODINVIO = p_w_CODINVIO;
    w_nomefile = p_w_nomefile;
    w_idbase = p_w_idbase;
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
  public String Run(String p_w_CODINVIO,String p_w_nomefile,String p_w_idbase) {
    w_CODINVIO = p_w_CODINVIO;
    w_nomefile = p_w_nomefile;
    w_idbase = p_w_idbase;
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
  public static arrt_fam_annullafileR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_annullafileR(p_Ctx, p_Caller);
  }
  public static arrt_fam_annullafileR Make(CPContext p_Ctx) {
    return new arrt_fam_annullafileR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_CODINVIO = CPLib.Space(12);
    w_nomefile = CPLib.Space(20);
    w_idbase = CPLib.Space(10);
    w_anno = CPLib.Space(4);
    w_mese = CPLib.Space(2);
    w_TIPOCOMU = CPLib.Space(1);
    w_TIPOINVIO = CPLib.Space(1);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _nomefile = CPLib.Space(128);
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
    cRisultato = "KO";
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_aefaminvio_min_max,qbe_aefaminvio_select,
  public static final String m_cVQRList = ",qbe_aefaminvio_min_max,qbe_aefaminvio_select,";
  // ENTITY_BATCHES: ,arrt_fam_annullafile,
  public static final String i_InvokedRoutines = ",arrt_fam_annullafile,";
  public static String[] m_cRunParameterNames={"w_CODINVIO","w_nomefile","w_idbase"};
}
