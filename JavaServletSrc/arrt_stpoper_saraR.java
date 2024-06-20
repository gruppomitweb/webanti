// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpoper_saraR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_tmp_stpope_dett_anag;
  public String m_cServer_tmp_stpope_dett_anag;
  public String m_cPhName_tmp_stp_sogoper_ope;
  public String m_cServer_tmp_stp_sogoper_ope;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_c_adata;
  public String w_c_dadata;
  public String w_OrderBy;
  public double onlyope;
  public double onlyrap;
  public String statoreg;
  public String gFlgDoc;
  public String gDescAzi;
  public String _connes;
  public java.sql.Date _dataope;
  public java.sql.Date _dataret;
  public String _numsto;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpoper_saraR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpoper_sara",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
      m_cPhName_tmp_stpope_dett_anag = p_ContextObject.GetPhName("tmp_stpope_dett_anag");
      if (m_cPhName_tmp_stpope_dett_anag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpope_dett_anag = m_cPhName_tmp_stpope_dett_anag+" "+m_Ctx.GetWritePhName("tmp_stpope_dett_anag");
      }
      m_cServer_tmp_stpope_dett_anag = p_ContextObject.GetServer("tmp_stpope_dett_anag");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stp_sogoper_ope")) {
      m_cPhName_tmp_stp_sogoper_ope = p_ContextObject.GetPhName("tmp_stp_sogoper_ope");
      if (m_cPhName_tmp_stp_sogoper_ope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stp_sogoper_ope = m_cPhName_tmp_stp_sogoper_ope+" "+m_Ctx.GetWritePhName("tmp_stp_sogoper_ope");
      }
      m_cServer_tmp_stp_sogoper_ope = p_ContextObject.GetServer("tmp_stp_sogoper_ope");
    }
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("onlyope",p_cVarName)) {
      return onlyope;
    }
    if (CPLib.eqr("onlyrap",p_cVarName)) {
      return onlyrap;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stpoper_sara";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      return w_OrderBy;
    }
    if (CPLib.eqr("statoreg",p_cVarName)) {
      return statoreg;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      return gFlgDoc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
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
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      return _dataret;
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
    if (CPLib.eqr("onlyope",p_cVarName)) {
      onlyope = value;
      return;
    }
    if (CPLib.eqr("onlyrap",p_cVarName)) {
      onlyrap = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      w_OrderBy = value;
      return;
    }
    if (CPLib.eqr("statoreg",p_cVarName)) {
      statoreg = value;
      return;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      gFlgDoc = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
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
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      _dataret = value;
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
    CPResultSet Cursor_qbe_alloperazbo_sara=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabili del caller */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_daCodCli Char(16) */
      /* w_aCodCli Char(16) */
      /* w_c_adata Char(8) */
      /* w_c_dadata Char(8) */
      /* w_OrderBy Char(22) */
      /* onlyope Numeric(1, 0) */
      /* onlyrap Numeric(1, 0) */
      /* statoreg Char(1) */
      /* gFlgDoc Char(1) // Collegamento con storico documenti */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* _connes Char(16) // _connes del soggetto */
      /* _dataope Date // data dell'operaione per la ricerca della datamodi del soggetto */
      /* _dataret Date // data rettifica dell'operazione per la ricerca della datamodi del soggetto */
      /* _numsto Char(15) */
      // * --- Drop temporary table tmp_stpope_dett_anag
      if (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpope_dett_anag");
      }
      // * --- Drop temporary table tmp_stp_sogoper_ope
      if (m_Ctx.IsSharedTemp("tmp_stp_sogoper_ope")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stp_sogoper_ope")) {
          m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
          m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stp_sogoper_ope");
      }
      /* Lancio la stampa */
      /* w_c_dadata := iif(w_c_dadata='01000101','',w_c_dadata) */
      w_c_dadata = (CPLib.eqr(w_c_dadata,"01000101")?"":w_c_dadata);
      /* w_c_adata := iif(w_c_adata='01000101','',w_c_adata) */
      w_c_adata = (CPLib.eqr(w_c_adata,"01000101")?"":w_c_adata);
      // * --- Create temporary table tmp_stpope_dett_anag
      if (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpope_dett_anag");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpope_dett_anag");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpope_dett_anag",m_cServer,"proto")),m_cPhName,"tmp_stpope_dett_anag",m_Ctx);
      }
      m_cPhName_tmp_stpope_dett_anag = m_cPhName;
      // * --- Create temporary table tmp_stp_sogoper_ope
      if (m_Ctx.IsSharedTemp("tmp_stp_sogoper_ope")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stp_sogoper_ope")) {
          m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
          m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stp_sogoper_ope");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stp_sogoper_ope");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stp_sogoper_ope"))) {
        m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stp_sogoper_ope",m_cServer,"proto")),m_cPhName,"tmp_stp_sogoper_ope",m_Ctx);
      }
      m_cPhName_tmp_stp_sogoper_ope = m_cPhName;
      // * --- Select from qbe_alloperazbo_sara
      if (Cursor_qbe_alloperazbo_sara!=null)
        Cursor_qbe_alloperazbo_sara.Close();
      Cursor_qbe_alloperazbo_sara = new VQRHolder("qbe_alloperazbo_sara",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo_sara.Eof())) {
        /* _dataope := qbe_alloperazbo_sara->DATAREG // data dell'operaione per la ricerca della datamodi del soggetto */
        _dataope = Cursor_qbe_alloperazbo_sara.GetDate("DATAREG");
        /* _dataret := qbe_alloperazbo_sara->DATARETT // data dell'operaione per la ricerca della datamodi del soggetto */
        _dataret = Cursor_qbe_alloperazbo_sara.GetDate("DATARETT");
        /* _connes := qbe_alloperazbo_sara->CONNESCLI // _connes del soggetto */
        _connes = Cursor_qbe_alloperazbo_sara.GetString("CONNESCLI");
        /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo_sara->STATOREG='1',_dataret,_dataope)) */
        _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
        /* If Empty(LRTrim(_numsto)) */
        if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from wersonbo
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          if (Cursor_wersonbo!=null)
            Cursor_wersonbo.Close();
          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wersonbo.Eof())) {
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000025")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000025(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            Cursor_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
          Cursor_wersonbo.Close();
          // * --- End Select
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo_sara->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_sara.GetString("CONNESOPER")))) {
          /* _connes := qbe_alloperazbo_sara->CONNESOPER // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo_sara.GetString("CONNESOPER");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo_sara->CONNESBEN)) and Empty(LRTrim(qbe_alloperazbo_sara->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_sara.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo_sara.GetString("C_RAG")))) {
          /* _connes := qbe_alloperazbo_sara->CONNESBEN // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo_sara.GetString("CONNESBEN");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000035")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _connes := sogopebo->CODSOG // _connes del soggetto */
          _connes = Cursor_sogopebo.GetString("CODSOG");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000003E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000003E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000040")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        Cursor_qbe_alloperazbo_sara.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo_sara.ErrorMessage();
      Cursor_qbe_alloperazbo_sara.Close();
      // * --- End Select
      /* Exec "Rapporti" Page 2:Page_2 */
      Page_2();
      /* If gFlgDoc='S' */
      if (CPLib.eqr(gFlgDoc,"S")) {
        /* Stop Report */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_stpfraz_sa_doc");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("c_dadata",w_c_dadata);
        f.SetParameter("c_adata",w_c_adata);
        f.SetParameter("daCodCli",w_daCodCli);
        f.SetParameter("aCodCli",w_aCodCli);
        f.SetParameter("OrderBy",w_OrderBy);
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"c_dadata"+","+"c_adata"+","+"daCodCli"+","+"aCodCli"+","+"OrderBy");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Stop Report */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_stpfraz_sa");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("frazio","N");
        f.SetParameter("c_dadata",w_c_dadata);
        f.SetParameter("c_adata",w_c_adata);
        f.SetParameter("daCodCli",w_daCodCli);
        f.SetParameter("aCodCli",w_aCodCli);
        f.SetParameter("OrderBy",w_OrderBy);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("ambito","D");
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"frazio"+","+"c_dadata"+","+"c_adata"+","+"daCodCli"+","+"aCodCli"+","+"OrderBy"+","+"DescAzi"+","+"ambito");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_alloperazbo_sara!=null)
          Cursor_qbe_alloperazbo_sara.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Case Empty(w_daCodCli) and Empty(w_aCodCli) */
    if (CPLib.Empty(w_daCodCli) && CPLib.Empty(w_aCodCli)) {
      /* Exec "No filtro da a cliente" Page 3:Page_3 */
      Page_3();
      /* Case Empty(w_aCodCli) */
    } else if (CPLib.Empty(w_aCodCli)) {
      /* Exec "Solo da cliente" Page 4:Page_4 */
      Page_4();
      /* Case Empty(w_daCodCli) */
    } else if (CPLib.Empty(w_daCodCli)) {
      /* Exec "Solo a cliente" Page 5:Page_5 */
      Page_5();
    } else { // Otherwise
      /* Exec "Filtro da a cliente" Page 6:Page_6 */
      Page_6();
    } // End Case
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_alloperazbo2_sara=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_alloperazbo2_sara
      if (Cursor_qbe_alloperazbo2_sara!=null)
        Cursor_qbe_alloperazbo2_sara.Close();
      Cursor_qbe_alloperazbo2_sara = new VQRHolder("qbe_alloperazbo2_sara",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo2_sara.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _dataope := qbe_alloperazbo2_sara->DATAREG // data dell'operaione per la ricerca della datamodi del soggetto */
          _dataope = Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG");
          /* _connes := intestbo->CODINTER // _connes del soggetto */
          _connes = Cursor_intestbo.GetString("CODINTER");
          /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000054")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000054(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESOPER // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000005C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000005C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESBEN)) and Empty(LRTrim(qbe_alloperazbo2_sara->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESBEN // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000063")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _connes := sogopebo->CODSOG // _connes del soggetto */
          _connes = Cursor_sogopebo.GetString("CODSOG");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000006C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        Cursor_qbe_alloperazbo2_sara.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo2_sara.ErrorMessage();
      Cursor_qbe_alloperazbo2_sara.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_alloperazbo2_sara!=null)
          Cursor_qbe_alloperazbo2_sara.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_alloperazbo2_sara=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_alloperazbo2_sara
      if (Cursor_qbe_alloperazbo2_sara!=null)
        Cursor_qbe_alloperazbo2_sara.Close();
      Cursor_qbe_alloperazbo2_sara = new VQRHolder("qbe_alloperazbo2_sara",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo2_sara.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If intestbo->CODINTER>= w_daCodCli */
          if (CPLib.ge(Cursor_intestbo.GetString("CODINTER"),w_daCodCli)) {
            /* _dataope := qbe_alloperazbo2_sara->DATAREG // data dell'operaione per la ricerca della datamodi del soggetto */
            _dataope = Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG");
            /* _connes := intestbo->CODINTER // _connes del soggetto */
            _connes = Cursor_intestbo.GetString("CODINTER");
            /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
            /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000007A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000007A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESOPER // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000080")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000080(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000082")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000082(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESBEN)) and Empty(LRTrim(qbe_alloperazbo2_sara->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESBEN // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000089")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000008B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _connes := sogopebo->CODSOG // _connes del soggetto */
          _connes = Cursor_sogopebo.GetString("CODSOG");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000092")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000092(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"00000094")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000094(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        Cursor_qbe_alloperazbo2_sara.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo2_sara.ErrorMessage();
      Cursor_qbe_alloperazbo2_sara.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_alloperazbo2_sara!=null)
          Cursor_qbe_alloperazbo2_sara.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_alloperazbo2_sara=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_alloperazbo2_sara
      if (Cursor_qbe_alloperazbo2_sara!=null)
        Cursor_qbe_alloperazbo2_sara.Close();
      Cursor_qbe_alloperazbo2_sara = new VQRHolder("qbe_alloperazbo2_sara",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo2_sara.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If (intestbo->CODINTER>= w_daCodCli and intestbo->CODINTER<=w_aCodCli)  */
          if ((CPLib.ge(Cursor_intestbo.GetString("CODINTER"),w_daCodCli) && CPLib.le(Cursor_intestbo.GetString("CODINTER"),w_aCodCli))) {
            /* _dataope := qbe_alloperazbo2_sara->DATAREG // data dell'operaione per la ricerca della datamodi del soggetto */
            _dataope = Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG");
            /* _connes := intestbo->CODINTER // _connes del soggetto */
            _connes = Cursor_intestbo.GetString("CODINTER");
            /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
            /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"0000009E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000009E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESOPER // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A8(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESBEN)) and Empty(LRTrim(qbe_alloperazbo2_sara->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESBEN // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000AF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000B1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _connes := sogopebo->CODSOG // _connes del soggetto */
          _connes = Cursor_sogopebo.GetString("CODSOG");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000B8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000B8(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000BA(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        Cursor_qbe_alloperazbo2_sara.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo2_sara.ErrorMessage();
      Cursor_qbe_alloperazbo2_sara.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_alloperazbo2_sara!=null)
          Cursor_qbe_alloperazbo2_sara.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_alloperazbo2_sara=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_alloperazbo2_sara
      if (Cursor_qbe_alloperazbo2_sara!=null)
        Cursor_qbe_alloperazbo2_sara.Close();
      Cursor_qbe_alloperazbo2_sara = new VQRHolder("qbe_alloperazbo2_sara",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo2_sara.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If (intestbo->CODINTER>= w_daCodCli and intestbo->CODINTER<=w_aCodCli)  */
          if ((CPLib.ge(Cursor_intestbo.GetString("CODINTER"),w_daCodCli) && CPLib.le(Cursor_intestbo.GetString("CODINTER"),w_aCodCli))) {
            /* _dataope := qbe_alloperazbo2_sara->DATAREG // data dell'operaione per la ricerca della datamodi del soggetto */
            _dataope = Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG");
            /* _connes := intestbo->CODINTER // _connes del soggetto */
            _connes = Cursor_intestbo.GetString("CODINTER");
            /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
            /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C4(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C6(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESOPER // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESOPER");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        /* If not(Empty(qbe_alloperazbo2_sara->CONNESBEN)) and Empty(LRTrim(qbe_alloperazbo2_sara->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo2_sara.GetString("C_RAG")))) {
          /* _connes := qbe_alloperazbo2_sara->CONNESBEN // _connes del soggetto */
          _connes = Cursor_qbe_alloperazbo2_sara.GetString("CONNESBEN");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000D5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000D7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpope_dett_anag",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _connes := sogopebo->CODSOG // _connes del soggetto */
          _connes = Cursor_sogopebo.GetString("CODSOG");
          /* _numsto := arfn_chkspers(_connes,iif(qbe_alloperazbo2_sara->STATOREG='1',_dataret,_dataope)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_connes,(CPLib.eqr(Cursor_qbe_alloperazbo2_sara.GetString("STATOREG"),"1")?_dataret:_dataope));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000DE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000DE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpoper_sara",162,"000000E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000E0(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo2_sara.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogoper_ope",true);
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        Cursor_qbe_alloperazbo2_sara.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo2_sara.ErrorMessage();
      Cursor_qbe_alloperazbo2_sara.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_alloperazbo2_sara!=null)
          Cursor_qbe_alloperazbo2_sara.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
      m_Caller.SetString("daCodCli","C",16,0,w_daCodCli);
      m_Caller.SetString("aCodCli","C",16,0,w_aCodCli);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("c_dadata","C",8,0,w_c_dadata);
      m_Caller.SetString("OrderBy","C",22,0,w_OrderBy);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpoper_saraR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpoper_saraR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_daCodCli = m_Caller.GetString("daCodCli","C",16,0);
    w_aCodCli = m_Caller.GetString("aCodCli","C",16,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_c_dadata = m_Caller.GetString("c_dadata","C",8,0);
    w_OrderBy = m_Caller.GetString("OrderBy","C",22,0);
    onlyope = 0;
    onlyrap = 0;
    statoreg = CPLib.Space(1);
    _connes = CPLib.Space(16);
    _dataope = CPLib.NullDate();
    _dataret = CPLib.NullDate();
    _numsto = CPLib.Space(15);
    gFlgDoc=m_Ctx.GetGlobalString("gFlgDoc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_alloperazbo_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,
  public static final String m_cVQRList = ",qbe_alloperazbo_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,qbe_alloperazbo2_sara,";
  // ENTITY_BATCHES: ,arfn_chkspers,
  public static final String i_InvokedRoutines = ",arfn_chkspers,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000025(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000040(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000054(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000080(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000082(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000092(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000094(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"SCONNES,";
    p_cSql = p_cSql+"SCODCAB,";
    p_cSql = p_cSql+"SRAGSOC,";
    p_cSql = p_cSql+"SDOMICILIO,";
    p_cSql = p_cSql+"SCODFISC,";
    p_cSql = p_cSql+"SDATANASC,";
    p_cSql = p_cSql+"SNASCOMUN,";
    p_cSql = p_cSql+"SSOTGRUP,";
    p_cSql = p_cSql+"SRAMOGRUP,";
    p_cSql = p_cSql+"SSETTSINT,";
    p_cSql = p_cSql+"STIPODOC,";
    p_cSql = p_cSql+"SNUMDOCUM,";
    p_cSql = p_cSql+"SDATARILASC,";
    p_cSql = p_cSql+"SAUTRILASC,";
    p_cSql = p_cSql+"SDESCCIT,";
    p_cSql = p_cSql+"SPROVINCIA,";
    p_cSql = p_cSql+"SPAESE,";
    p_cSql = p_cSql+"SCAP,";
    p_cSql = p_cSql+"SCODINTER,";
    p_cSql = p_cSql+"STIPINTER,";
    p_cSql = p_cSql+"STIPOPERS,";
    p_cSql = p_cSql+"SCODDIPE,";
    p_cSql = p_cSql+"SPARTIVA,";
    p_cSql = p_cSql+"SNOTE,";
    p_cSql = p_cSql+"SSESSO,";
    p_cSql = p_cSql+"SSOSPMAF,";
    p_cSql = p_cSql+"Sidcitta,";
    p_cSql = p_cSql+"SDATAVALI,";
    p_cSql = p_cSql+"SNASSTATO,";
    p_cSql = p_cSql+"SDOCFILE,";
    p_cSql = p_cSql+"SNOME,";
    p_cSql = p_cSql+"SCOGNOME,";
    p_cSql = p_cSql+"SCFESTERO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
}
