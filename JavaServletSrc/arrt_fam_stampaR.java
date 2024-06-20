// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_stampaR implements CallerWithObjs {
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
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
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
  public String w_DaRapporto;
  public String w_ARapporto;
  public String w_flgatt;
  public double _conta;
  public String _errore;
  public MemoryCursor_tmp_stpperiodo mcTemp;
  public MemoryCursorRow_tmp_stpperiodo rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio2 mcSID2;
  public MemoryCursorRow_sid_invio2 rowSID2;
  public MemoryCursor_sid_invio2 mcSID2r;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public double _crea;
  public double _annulla;
  public double _chiusa;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_stampaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_stampa",m_Caller);
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
      m_cPhName_tmp_sid_invio1 = p_ContextObject.GetPhName("tmp_sid_invio1");
      if (m_cPhName_tmp_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio1 = m_cPhName_tmp_sid_invio1+" "+m_Ctx.GetWritePhName("tmp_sid_invio1");
      }
      m_cServer_tmp_sid_invio1 = p_ContextObject.GetServer("tmp_sid_invio1");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
      m_cPhName_tmp_sid_invio2 = p_ContextObject.GetPhName("tmp_sid_invio2");
      if (m_cPhName_tmp_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio2 = m_cPhName_tmp_sid_invio2+" "+m_Ctx.GetWritePhName("tmp_sid_invio2");
      }
      m_cServer_tmp_sid_invio2 = p_ContextObject.GetServer("tmp_sid_invio2");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
      m_cPhName_tmp_sid_invio3 = p_ContextObject.GetPhName("tmp_sid_invio3");
      if (m_cPhName_tmp_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio3 = m_cPhName_tmp_sid_invio3+" "+m_Ctx.GetWritePhName("tmp_sid_invio3");
      }
      m_cServer_tmp_sid_invio3 = p_ContextObject.GetServer("tmp_sid_invio3");
    }
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
    }
    if (CPLib.eqr("_annulla",p_cVarName)) {
      return _annulla;
    }
    if (CPLib.eqr("_chiusa",p_cVarName)) {
      return _chiusa;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_stampa";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("DaRapporto",p_cVarName)) {
      return w_DaRapporto;
    }
    if (CPLib.eqr("ARapporto",p_cVarName)) {
      return w_ARapporto;
    }
    if (CPLib.eqr("flgatt",p_cVarName)) {
      return w_flgatt;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
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
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      return mcSID2;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      return mcSID2r;
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
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      return rowSID2;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
      return;
    }
    if (CPLib.eqr("_annulla",p_cVarName)) {
      _annulla = value;
      return;
    }
    if (CPLib.eqr("_chiusa",p_cVarName)) {
      _chiusa = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("DaRapporto",p_cVarName)) {
      w_DaRapporto = value;
      return;
    }
    if (CPLib.eqr("ARapporto",p_cVarName)) {
      w_ARapporto = value;
      return;
    }
    if (CPLib.eqr("flgatt",p_cVarName)) {
      w_flgatt = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
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
      rowTemp = (MemoryCursorRow_tmp_stpperiodo)value;
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
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      rowSID2 = (MemoryCursorRow_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_tmp_stpperiodo)value;
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
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      mcSID2 = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      mcSID2r = (MemoryCursor_sid_invio2)value;
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
    CPResultSet Cursor_qbe_fam_stampa01=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaRapporto Char(25) */
      /* w_ARapporto Char(25) */
      /* w_flgatt Char(1) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(tmp_stpperiodo) */
      /* rowTemp Row(tmp_stpperiodo) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID2 MemoryCursor(sid_invio2) */
      /* rowSID2 Row(sid_invio2) */
      /* mcSID2r MemoryCursor(sid_invio2) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* _crea Numeric(1, 0) */
      /* _annulla Numeric(1, 0) */
      /* _chiusa Numeric(1, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000001Cstatus;
      nTry0000001Cstatus = m_Sql.GetTransactionStatus();
      String cTry0000001Cmsg;
      cTry0000001Cmsg = m_Sql.TransactionErrorMessage();
      try {
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
        // * --- Create temporary table tmp_sid_invio2
        if (m_Ctx.IsSharedTemp("tmp_sid_invio2")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
            m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
            m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_sid_invio2");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio2");
        if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio2"))) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio2",m_cServer,"proto")),m_cPhName,"tmp_sid_invio2",m_Ctx);
        }
        m_cPhName_tmp_sid_invio2 = m_cPhName;
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgProc := 'Ora Inizio Elaborazione Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = "Ora Inizio Elaborazione Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Estrazione dati per il periodo" + NL // Messaggio */
        gMsgProc = gMsgProc+"Estrazione dati per il periodo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
        gMsgImp = "Attendere. Estrazione dati per il periodo ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Fill memory cursor mcTemp on qbe_fam_stampa01
        mcTemp.Zap();
        SPBridge.HMCaller _h00000027;
        _h00000027 = new SPBridge.HMCaller();
        _h00000027.Set("m_cVQRList",m_cVQRList);
        _h00000027.Set("DaRapporto",w_DaRapporto);
        _h00000027.Set("ARapporto",w_ARapporto);
        if (Cursor_qbe_fam_stampa01!=null)
          Cursor_qbe_fam_stampa01.Close();
        Cursor_qbe_fam_stampa01 = new VQRHolder("qbe_fam_stampa01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000027,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_stampa01;
          Cursor_qbe_fam_stampa01.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_fam_stampa: query on qbe_fam_stampa01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_stampa01.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_stampa01.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_stampa01.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_stampa01.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_stampa01.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_stampa01.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_stampa01.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_stampa01.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_stampa01.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_stampa01.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_stampa01.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_stampa01.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_stampa01.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_stampa01.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_stampa01.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_stampa01.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_stampa01.GetString("ISOAGE");
          Cursor_qbe_fam_stampa01.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_stampa01.ErrorMessage();
        Cursor_qbe_fam_stampa01.Close();
        mcTemp.GoTop();
        /* gMsgProc := gMsgProc + 'Ora Inizio Esame Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Esame Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _crea := 0 */
        _crea = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* _annulla := 0 */
          _annulla = CPLib.Round(0,0);
          /* _chiusa := 0 */
          _chiusa = CPLib.Round(0,0);
          // * --- Read from aetesta
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTemp.RAPPORTO,"C",25,0,m_cServer),m_cServer,rowTemp.RAPPORTO);
          if (m_Ctx.IsSharedTemp("aetesta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNULLA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("INVIATOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _annulla = CPLib.Round(Read_Cursor.GetDouble("ANNULLA"),0);
            _chiusa = CPLib.Round(Read_Cursor.GetDouble("INVIATOC"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aetesta into routine arrt_fam_stampa returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _annulla = 0;
            _chiusa = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If w_flgatt = 'N' or (w_flgatt='S' and _annulla=0 and _chiusa=0) */
          if (CPLib.eqr(w_flgatt,"N") || (CPLib.eqr(w_flgatt,"S") && CPLib.eqr(_annulla,0) && CPLib.eqr(_chiusa,0))) {
            /* If _crea=0 */
            if (CPLib.eqr(_crea,0)) {
              /* rowSID0.CODINVIO := DateToChar(Date())+"11" */
              rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+"11";
              /* rowSID0.TIPINVIO := '0' */
              rowSID0.TIPINVIO = "0";
              /* rowSID0.TPCINVIO := '0' */
              rowSID0.TPCINVIO = "0";
              /* rowSID0.ANNINVIO := '0000' */
              rowSID0.ANNINVIO = "0000";
              /* rowSID0.MESINVIO := '00' */
              rowSID0.MESINVIO = "00";
              /* mcSID0.AppendRow(rowSID0) */
              mcSID0.AppendRow(rowSID0);
              /* _crea := 1 */
              _crea = CPLib.Round(1,0);
            } // End If
            /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(_conta,10,0))+" famiglie" // Messaggio Import */
            gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" famiglie";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* rowSID1.CODINVIO1 := DateToChar(Date())+"11" */
            rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+"11";
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
            rowSID1.FININVIO1 = rowTemp.DATAFINE;
            /* rowSID1.TIPINVIO1 := '0' */
            rowSID1.TIPINVIO1 = "0";
            /* rowSID1.TPCINVIO1 := '0' */
            rowSID1.TPCINVIO1 = "0";
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* mcSID2r := arfn_fam_mesefile02(rowSID1,NullDate(),NullDate(),rowTemp.TIPO) */
            mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,CPLib.NullDate(),CPLib.NullDate(),rowTemp.TIPO);
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
              /* mcSID2.AppendRow(rowSID2) */
              mcSID2.AppendRow(rowSID2);
            }
            /* mcSID3r := arfn_fam_mesefile03(rowSID1,Year(Date()),rowTemp.TIPO,rowTemp.VALUTA) */
            mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,CPLib.Year(CPLib.Date()),rowTemp.TIPO,rowTemp.VALUTA);
            for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
              /* mcSID3.AppendRow(rowSID3) */
              mcSID3.AppendRow(rowSID3);
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End If
        }
        for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
          // * --- Insert into tmp_sid_invio1 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stampa",70,"00000049")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000049(m_Ctx,m_oWrInfo);
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
        for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
          // * --- Insert into tmp_sid_invio2 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stampa",70,"0000004B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio2",true);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stampa",70,"0000004D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004D(m_Ctx,m_oWrInfo);
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
        /* gMsgProc := gMsgProc + 'Ora Fine Esame Famiglie '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Esame Famiglie "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Sono stati elaborate '+LRTrim(Str(_conta,10,0))+" famiglie" +NL // Messaggio */
        gMsgProc = gMsgProc+"Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" famiglie"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Cstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Cstatus,cTry0000001Cmsg);
        }
      }
      /* Stop arrp_fam_stampa.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("hideCover",true);
      f.SetParameter("hideLanguage",true);
      f.SetParameter("hideSettings",true);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("w_ARapporto",w_ARapporto);
      f.SetParameter("w_DaRapporto",w_DaRapporto);
      f.SetParameter("ReportName","arrp_fam_stampa.vrp");
      f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"w_ARapporto"+","+"w_DaRapporto"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_fam_stampa01!=null)
          Cursor_qbe_fam_stampa01.Close();
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
      m_Caller.SetString("DaRapporto","C",25,0,w_DaRapporto);
      m_Caller.SetString("ARapporto","C",25,0,w_ARapporto);
      m_Caller.SetString("flgatt","C",1,0,w_flgatt);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_fam_stampaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_stampaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaRapporto = m_Caller.GetString("DaRapporto","C",25,0);
    w_ARapporto = m_Caller.GetString("ARapporto","C",25,0);
    w_flgatt = m_Caller.GetString("flgatt","C",1,0);
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_tmp_stpperiodo();
    rowTemp = new MemoryCursorRow_tmp_stpperiodo();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID2 = new MemoryCursor_sid_invio2();
    rowSID2 = new MemoryCursorRow_sid_invio2();
    mcSID2r = new MemoryCursor_sid_invio2();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    _crea = 0;
    _annulla = 0;
    _chiusa = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_stampa01,
  public static final String m_cVQRList = ",qbe_fam_stampa01,";
  // ENTITY_BATCHES: ,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000049(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000004B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
