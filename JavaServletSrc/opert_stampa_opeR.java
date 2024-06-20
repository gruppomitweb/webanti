// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opert_stampa_opeR implements CallerWithObjs {
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
  public String m_cPhName_tmp_titeff;
  public String m_cServer_tmp_titeff;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_zperazbo;
  public String m_cServer_zperazbo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public java.sql.Date w_dadatreg;
  public java.sql.Date w_a_datreg;
  public String w_daSog;
  public String w_aSog;
  public String w_flgtit;
  public String pType;
  public String w_dadest;
  public String w_a_dest;
  public String _codsog;
  public String _codfisc;
  public String _titolare;
  public String _repname;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opert_stampa_opeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_stampa_ope",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_titeff")) {
      m_cPhName_tmp_titeff = p_ContextObject.GetPhName("tmp_titeff");
      if (m_cPhName_tmp_titeff.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_titeff = m_cPhName_tmp_titeff+" "+m_Ctx.GetWritePhName("tmp_titeff");
      }
      m_cServer_tmp_titeff = p_ContextObject.GetServer("tmp_titeff");
    }
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_zperazbo = p_ContextObject.GetPhName("zperazbo");
    if (m_cPhName_zperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_zperazbo = m_cPhName_zperazbo+" "+m_Ctx.GetWritePhName("zperazbo");
    }
    m_cServer_zperazbo = p_ContextObject.GetServer("zperazbo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    if (m_cPhName_titopers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titopers = m_cPhName_titopers+" "+m_Ctx.GetWritePhName("titopers");
    }
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    if (m_cPhName_titolabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titolabo = m_cPhName_titolabo+" "+m_Ctx.GetWritePhName("titolabo");
    }
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "opert_stampa_ope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daSog",p_cVarName)) {
      return w_daSog;
    }
    if (CPLib.eqr("aSog",p_cVarName)) {
      return w_aSog;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      return w_flgtit;
    }
    if (CPLib.eqr("pType",p_cVarName)) {
      return pType;
    }
    if (CPLib.eqr("dadest",p_cVarName)) {
      return w_dadest;
    }
    if (CPLib.eqr("a_dest",p_cVarName)) {
      return w_a_dest;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      return _codsog;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_titolare",p_cVarName)) {
      return _titolare;
    }
    if (CPLib.eqr("_repname",p_cVarName)) {
      return _repname;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadatreg",p_cVarName)) {
      return w_dadatreg;
    }
    if (CPLib.eqr("a_datreg",p_cVarName)) {
      return w_a_datreg;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daSog",p_cVarName)) {
      w_daSog = value;
      return;
    }
    if (CPLib.eqr("aSog",p_cVarName)) {
      w_aSog = value;
      return;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      w_flgtit = value;
      return;
    }
    if (CPLib.eqr("pType",p_cVarName)) {
      pType = value;
      return;
    }
    if (CPLib.eqr("dadest",p_cVarName)) {
      w_dadest = value;
      return;
    }
    if (CPLib.eqr("a_dest",p_cVarName)) {
      w_a_dest = value;
      return;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      _codsog = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_titolare",p_cVarName)) {
      _titolare = value;
      return;
    }
    if (CPLib.eqr("_repname",p_cVarName)) {
      _repname = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadatreg",p_cVarName)) {
      w_dadatreg = value;
      return;
    }
    if (CPLib.eqr("a_datreg",p_cVarName)) {
      w_a_datreg = value;
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
    CPResultSet Cursor_qbe_stpope_s_1_sel=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_stpope_s_3_sel=null;
    CPResultSet Cursor_zperazbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_dadatreg Date */
      /* w_a_datreg Date */
      /* w_daSog Char(16) // Da Soggetto */
      /* w_aSog Char(16) // Da Soggetto */
      /* w_flgtit Char(0) */
      /* pType Char(1) // Provvisorio o Definitivo */
      /* w_dadest Char(16) // Da Controparte */
      /* w_a_dest Char(16) // A Controparte */
      /* _codsog Char(16) */
      /* _codfisc Char(16) */
      /* _titolare Memo */
      /* _repname Char(40) */
      /* Crea la tabella d'appoggio */
      // * --- Drop temporary table tmp_titeff
      if (m_Ctx.IsSharedTemp("tmp_titeff")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_titeff")) {
          m_cServer = m_Ctx.GetServer("tmp_titeff");
          m_cPhName = m_Ctx.GetPhName("tmp_titeff");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_titeff");
      }
      // * --- Create temporary table tmp_titeff
      if (m_Ctx.IsSharedTemp("tmp_titeff")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_titeff")) {
          m_cServer = m_Ctx.GetServer("tmp_titeff");
          m_cPhName = m_Ctx.GetPhName("tmp_titeff");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_titeff");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_titeff");
      if ( ! (m_Ctx.IsSharedTemp("tmp_titeff"))) {
        m_cServer = m_Ctx.GetServer("tmp_titeff");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_titeff",m_cServer,"proto")),m_cPhName,"tmp_titeff",m_Ctx);
      }
      m_cPhName_tmp_titeff = m_cPhName;
      /* Seleziona i record compresi nel periodo */
      /* If w_flgtit ='S' */
      if (CPLib.eqr(w_flgtit,"S")) {
        /* If pType = 'D' */
        if (CPLib.eqr(pType,"D")) {
          // * --- Select from qbe_stpope_s_1_sel
          if (Cursor_qbe_stpope_s_1_sel!=null)
            Cursor_qbe_stpope_s_1_sel.Close();
          Cursor_qbe_stpope_s_1_sel = new VQRHolder("qbe_stpope_s_1_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_stpope_s_1_sel.Eof())) {
            // * --- Select from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            if (Cursor_operazbo!=null)
              Cursor_operazbo.Close();
            Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_stpope_s_1_sel.GetDouble("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_operazbo.Eof())) {
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("CONNESREAL"),"C",16,0,m_cServer),m_cServer,Cursor_operazbo.GetString("CONNESREAL"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_operazbo.GetString("CONNESBEN"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_operazbo.GetString("CONNESCLI"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              Cursor_operazbo.Next();
            }
            m_cConnectivityError = Cursor_operazbo.ErrorMessage();
            Cursor_operazbo.Close();
            // * --- End Select
            Cursor_qbe_stpope_s_1_sel.Next();
          }
          m_cConnectivityError = Cursor_qbe_stpope_s_1_sel.ErrorMessage();
          Cursor_qbe_stpope_s_1_sel.Close();
          // * --- End Select
          /* ElseIf pType = 'P' */
        } else if (CPLib.eqr(pType,"P")) {
          // * --- Select from qbe_stpope_s_3_sel
          if (Cursor_qbe_stpope_s_3_sel!=null)
            Cursor_qbe_stpope_s_3_sel.Close();
          Cursor_qbe_stpope_s_3_sel = new VQRHolder("qbe_stpope_s_3_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_stpope_s_3_sel.Eof())) {
            // * --- Select from zperazbo
            m_cServer = m_Ctx.GetServer("zperazbo");
            m_cPhName = m_Ctx.GetPhName("zperazbo");
            if (Cursor_zperazbo!=null)
              Cursor_zperazbo.Close();
            Cursor_zperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_stpope_s_3_sel.GetDouble("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("zperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_zperazbo.Eof())) {
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESREAL"),"C",16,0,m_cServer),m_cServer,Cursor_zperazbo.GetString("CONNESREAL"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_zperazbo.GetString("CONNESBEN"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _codsog := '' */
              _codsog = "";
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_zperazbo.GetString("CONNESCLI"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine opert_stampa_ope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              Cursor_zperazbo.Next();
            }
            m_cConnectivityError = Cursor_zperazbo.ErrorMessage();
            Cursor_zperazbo.Close();
            // * --- End Select
            Cursor_qbe_stpope_s_3_sel.Next();
          }
          m_cConnectivityError = Cursor_qbe_stpope_s_3_sel.ErrorMessage();
          Cursor_qbe_stpope_s_3_sel.Close();
          // * --- End Select
        } // End If
      } // End If
      /* If pType = 'D' */
      if (CPLib.eqr(pType,"D")) {
        /* _repname := 'operp_stampa_ope_s_1.vrp' */
        _repname = "operp_stampa_ope_s_1.vrp";
        /* ElseIf pType = 'P' */
      } else if (CPLib.eqr(pType,"P")) {
        /* _repname := 'operp_stampa_ope_s_3.vrp' */
        _repname = "operp_stampa_ope_s_3.vrp";
      } // End If
      /* Stop _repname */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("dadatreg",w_dadatreg);
      f.SetParameter("a_datreg",w_a_datreg);
      f.SetParameter("w_daSog",w_daSog);
      f.SetParameter("w_aSog",w_aSog);
      f.SetParameter("w_dadest",w_dadest);
      f.SetParameter("w_a_dest",w_a_dest);
      f.SetParameter("flgtit",w_flgtit);
      f.SetParameter("formatTypes","PDF|XLS|CSVS|CSV2");
      f.SetParameter("hideLanguage",true);
      f.SetParameter("hideSettings",true);
      f.SetParameter("hideExport",true);
      f.SetParameter("ReportName",_repname);
      f.SetParameter("m_cParameterSequence","dadatreg"+","+"a_datreg"+","+"w_daSog"+","+"w_aSog"+","+"w_dadest"+","+"w_a_dest"+","+"flgtit"+","+"formatTypes"+","+"hideLanguage"+","+"hideSettings"+","+"hideExport"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_stpope_s_1_sel!=null)
          Cursor_qbe_stpope_s_1_sel.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        if (Cursor_qbe_stpope_s_3_sel!=null)
          Cursor_qbe_stpope_s_3_sel.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_zperazbo!=null)
          Cursor_zperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_dadatreg,java.sql.Date p_w_a_datreg,String p_w_daSog,String p_w_aSog,String p_w_flgtit,String p_pType,String p_w_dadest,String p_w_a_dest) {
    w_dadatreg = p_w_dadatreg;
    w_a_datreg = p_w_a_datreg;
    w_daSog = p_w_daSog;
    w_aSog = p_w_aSog;
    w_flgtit = p_w_flgtit;
    pType = p_pType;
    w_dadest = p_w_dadest;
    w_a_dest = p_w_a_dest;
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
  public Forward Run(java.sql.Date p_w_dadatreg,java.sql.Date p_w_a_datreg,String p_w_daSog,String p_w_aSog,String p_w_flgtit,String p_pType,String p_w_dadest,String p_w_a_dest) {
    w_dadatreg = p_w_dadatreg;
    w_a_datreg = p_w_a_datreg;
    w_daSog = p_w_daSog;
    w_aSog = p_w_aSog;
    w_flgtit = p_w_flgtit;
    pType = p_pType;
    w_dadest = p_w_dadest;
    w_a_dest = p_w_a_dest;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static opert_stampa_opeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_stampa_opeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_dadatreg = CPLib.NullDate();
    w_a_datreg = CPLib.NullDate();
    w_daSog = CPLib.Space(16);
    w_aSog = CPLib.Space(16);
    w_flgtit = CPLib.Space(0);
    pType = CPLib.Space(1);
    w_dadest = CPLib.Space(16);
    w_a_dest = CPLib.Space(16);
    _codsog = CPLib.Space(16);
    _codfisc = CPLib.Space(16);
    _titolare = "";
    _repname = CPLib.Space(40);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_stpope_s_1_sel,qbe_stpope_s_3_sel,
  public static final String m_cVQRList = ",qbe_stpope_s_1_sel,qbe_stpope_s_3_sel,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"w_dadatreg","w_a_datreg","w_daSog","w_aSog","w_flgtit","pType","w_dadest","w_a_dest"};
}
