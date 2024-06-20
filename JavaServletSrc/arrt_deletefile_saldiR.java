// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_deletefile_saldiR implements CallerWithObjs {
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
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aefile_do_glob;
  public String m_cServer_aefile_do_glob;
  public String m_cPhName_aeinvio;
  public String m_cServer_aeinvio;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
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
  public String w_nomefile;
  public String w_anno;
  public String w_idbase;
  public double _aperte;
  public double _chiuse;
  public double _cancellate;
  public String _nomefile;
  public String NoName;
  public String gAzienda;
  public String gMsgImp;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_deletefile_saldiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_deletefile_saldi",m_Caller);
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    if (m_cPhName_aefiles_do.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles_do = m_cPhName_aefiles_do+" "+m_Ctx.GetWritePhName("aefiles_do");
    }
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aefile_do_glob = p_ContextObject.GetPhName("aefile_do_glob");
    if (m_cPhName_aefile_do_glob.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefile_do_glob = m_cPhName_aefile_do_glob+" "+m_Ctx.GetWritePhName("aefile_do_glob");
    }
    m_cServer_aefile_do_glob = p_ContextObject.GetServer("aefile_do_glob");
    m_cPhName_aeinvio = p_ContextObject.GetPhName("aeinvio");
    if (m_cPhName_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeinvio = m_cPhName_aeinvio+" "+m_Ctx.GetWritePhName("aeinvio");
    }
    m_cServer_aeinvio = p_ContextObject.GetServer("aeinvio");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_deletefile_saldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return w_idbase;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      return NoName;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      w_idbase = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      NoName = value;
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
    CPResultSet Cursor_qbe_tot_aeinvio=null;
    CPResultSet Cursor_aesaldi=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_nomefile Char(50) */
      /* w_anno Char(4) */
      /* w_idbase Char(10) */
      /* Dichiarazione variabili locali */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _nomefile Char(128) */
      /* NoName Char(0) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gPathApp Char(80) // Path Applicazione */
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
      double nTry00000013status;
      nTry00000013status = m_Sql.GetTransactionStatus();
      String cTry00000013msg;
      cTry00000013msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_tot_aeinvio
        SPBridge.HMCaller _h00000014;
        _h00000014 = new SPBridge.HMCaller();
        _h00000014.Set("m_cVQRList",m_cVQRList);
        _h00000014.Set("nomefile",w_nomefile);
        if (Cursor_qbe_tot_aeinvio!=null)
          Cursor_qbe_tot_aeinvio.Close();
        Cursor_qbe_tot_aeinvio = new VQRHolder("qbe_tot_aeinvio",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000014,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tot_aeinvio.Eof())) {
          /* _aperte := qbe_tot_aeinvio->TOTRIGHE */
          _aperte = CPLib.Round(Cursor_qbe_tot_aeinvio.GetDouble("TOTRIGHE"),0);
          Cursor_qbe_tot_aeinvio.Next();
        }
        m_cConnectivityError = Cursor_qbe_tot_aeinvio.ErrorMessage();
        Cursor_qbe_tot_aeinvio.Close();
        // * --- End Select
        // * --- Select from aesaldi
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        if (Cursor_aesaldi!=null)
          Cursor_aesaldi.Close();
        Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NOMEFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,w_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aesaldi.Eof())) {
          /* _nomefile := LRTrim(gPathApp)+"/SID/INVII/PRE/"+LRTrim(gAzienda)+"/"+LRTrim(aesaldi->FILEINV1) */
          _nomefile = CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_aesaldi.GetString("FILEINV1"));
          /* FileLibMit.DeleteFile(_nomefile) */
          FileLibMit.DeleteFile(_nomefile);
          /* _nomefile := LRTrim(gPathApp)+"/SID/INVII/PRE/"+LRTrim(gAzienda)+"/"+LRTrim(aesaldi->FILEINV2) */
          _nomefile = CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_aesaldi.GetString("FILEINV2"));
          /* FileLibMit.DeleteFile(_nomefile) */
          FileLibMit.DeleteFile(_nomefile);
          Cursor_aesaldi.Next();
        }
        m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
        Cursor_aesaldi.Close();
        // * --- End Select
        // * --- Delete from aesaldi
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_saldi",33,"0000001B")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
        /* If _aperte > 0 */
        if (CPLib.gt(_aperte,0)) {
          // * --- Write into aeannora from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeannora");
          m_cPhName = m_Ctx.GetPhName("aeannora");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_saldi",33,"0000001D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL("","C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL("","C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
          // * --- Write into aeoprig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_saldi",33,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL("","C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL("","C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_saldi",33,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL("","C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL("","C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
          // * --- Delete from aeinvio
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeinvio");
          m_cPhName = m_Ctx.GetPhName("aeinvio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_saldi",33,"00000020")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
          /* gMsgImp := "Modificate Informazioni Saldi Anno: "+w_anno+" - "+ LRTrim(Str(_aperte,10,0))+". Elaborazione Terminata" // Messaggio Import */
          gMsgImp = "Modificate Informazioni Saldi Anno: "+w_anno+" - "+CPLib.LRTrim(CPLib.Str(_aperte,10,0))+". Elaborazione Terminata";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* gMsgImp := "Non sono state trovate informazioni sui saldi relative al file selezionato. Elaborazione Terminata" // Messaggio Import */
          gMsgImp = "Non sono state trovate informazioni sui saldi relative al file selezionato. Elaborazione Terminata";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000013status,0)) {
          m_Sql.SetTransactionStatus(nTry00000013status,cTry00000013msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_tot_aeinvio!=null)
          Cursor_qbe_tot_aeinvio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aesaldi!=null)
          Cursor_aesaldi.Close();
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
      m_Caller.SetString("nomefile","C",50,0,w_nomefile);
      m_Caller.SetString("anno","C",4,0,w_anno);
      m_Caller.SetString("idbase","C",10,0,w_idbase);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_deletefile_saldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_deletefile_saldiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",50,0);
    w_anno = m_Caller.GetString("anno","C",4,0);
    w_idbase = m_Caller.GetString("idbase","C",10,0);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _nomefile = CPLib.Space(128);
    NoName = CPLib.Space(0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tot_aeinvio,
  public static final String m_cVQRList = ",qbe_tot_aeinvio,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
