// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_doc_soggR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stpoperazioni_dett_anag;
  public String m_cServer_tmp_stpoperazioni_dett_anag;
  public String m_cPhName_tmp_stp_altri_cli_occ_operazioni;
  public String m_cServer_tmp_stp_altri_cli_occ_operazioni;
  public String m_cPhName_tmp_stp_sogoper_ope;
  public String m_cServer_tmp_stp_sogoper_ope;
  public String m_cPhName_tmp_stp_controparti_operazioni;
  public String m_cServer_tmp_stp_controparti_operazioni;
  public String m_cPhName_tmp_stp_sogg_ter_operazioni;
  public String m_cServer_tmp_stp_sogg_ter_operazioni;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_stpope_dett_anag;
  public String m_cServer_tmp_stpope_dett_anag;
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
  public String connes;
  public java.sql.Date dataope;
  public String idbase;
  public String cursore;
  public boolean find;
  public String pconess;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_doc_soggR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_doc_sogg",m_Caller);
    m_cPhName_tmp_stpoperazioni_dett_anag = p_ContextObject.GetPhName("tmp_stpoperazioni_dett_anag");
    if (m_cPhName_tmp_stpoperazioni_dett_anag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stpoperazioni_dett_anag = m_cPhName_tmp_stpoperazioni_dett_anag+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni_dett_anag");
    }
    m_cServer_tmp_stpoperazioni_dett_anag = p_ContextObject.GetServer("tmp_stpoperazioni_dett_anag");
    m_cPhName_tmp_stp_altri_cli_occ_operazioni = p_ContextObject.GetPhName("tmp_stp_altri_cli_occ_operazioni");
    if (m_cPhName_tmp_stp_altri_cli_occ_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stp_altri_cli_occ_operazioni = m_cPhName_tmp_stp_altri_cli_occ_operazioni+" "+m_Ctx.GetWritePhName("tmp_stp_altri_cli_occ_operazioni");
    }
    m_cServer_tmp_stp_altri_cli_occ_operazioni = p_ContextObject.GetServer("tmp_stp_altri_cli_occ_operazioni");
    m_cPhName_tmp_stp_sogoper_ope = p_ContextObject.GetPhName("tmp_stp_sogoper_ope");
    if (m_cPhName_tmp_stp_sogoper_ope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stp_sogoper_ope = m_cPhName_tmp_stp_sogoper_ope+" "+m_Ctx.GetWritePhName("tmp_stp_sogoper_ope");
    }
    m_cServer_tmp_stp_sogoper_ope = p_ContextObject.GetServer("tmp_stp_sogoper_ope");
    m_cPhName_tmp_stp_controparti_operazioni = p_ContextObject.GetPhName("tmp_stp_controparti_operazioni");
    if (m_cPhName_tmp_stp_controparti_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stp_controparti_operazioni = m_cPhName_tmp_stp_controparti_operazioni+" "+m_Ctx.GetWritePhName("tmp_stp_controparti_operazioni");
    }
    m_cServer_tmp_stp_controparti_operazioni = p_ContextObject.GetServer("tmp_stp_controparti_operazioni");
    m_cPhName_tmp_stp_sogg_ter_operazioni = p_ContextObject.GetPhName("tmp_stp_sogg_ter_operazioni");
    if (m_cPhName_tmp_stp_sogg_ter_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stp_sogg_ter_operazioni = m_cPhName_tmp_stp_sogg_ter_operazioni+" "+m_Ctx.GetWritePhName("tmp_stp_sogg_ter_operazioni");
    }
    m_cServer_tmp_stp_sogg_ter_operazioni = p_ContextObject.GetServer("tmp_stp_sogg_ter_operazioni");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tmp_stpope_dett_anag = p_ContextObject.GetPhName("tmp_stpope_dett_anag");
    if (m_cPhName_tmp_stpope_dett_anag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stpope_dett_anag = m_cPhName_tmp_stpope_dett_anag+" "+m_Ctx.GetWritePhName("tmp_stpope_dett_anag");
    }
    m_cServer_tmp_stpope_dett_anag = p_ContextObject.GetServer("tmp_stpope_dett_anag");
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
      return "arfn_doc_sogg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return connes;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return idbase;
    }
    if (CPLib.eqr("cursore",p_cVarName)) {
      return cursore;
    }
    if (CPLib.eqr("pconess",p_cVarName)) {
      return pconess;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dataope",p_cVarName)) {
      return dataope;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("find",p_cVarName)) {
      return find;
    }
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
    if (CPLib.eqr("connes",p_cVarName)) {
      connes = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      idbase = value;
      return;
    }
    if (CPLib.eqr("cursore",p_cVarName)) {
      cursore = value;
      return;
    }
    if (CPLib.eqr("pconess",p_cVarName)) {
      pconess = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dataope",p_cVarName)) {
      dataope = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("find",p_cVarName)) {
      find = value;
      return;
    }
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
    CPResultSet Cursor_qbe_last_wersonbo=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* connes Char(16) // connes del soggetto */
      /* dataope Date // data dell'operaione per la ricerca della datamodi del soggetto */
      /* idbase Char(10) // idbase dell'operazione */
      /* cursore Char(20) // Identifica il cursore che deve su cui si fa la insert */
      /* find Bool */
      /* pconess Char(16) */
      /* pconess := connes */
      pconess = connes;
      // * --- Select from qbe_last_wersonbo
      if (Cursor_qbe_last_wersonbo!=null)
        Cursor_qbe_last_wersonbo.Close();
      Cursor_qbe_last_wersonbo = new VQRHolder("qbe_last_wersonbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      if ( ! (Cursor_qbe_last_wersonbo.Eof())) {
        while ( ! (Cursor_qbe_last_wersonbo.Eof())) {
          /* Case cursore='dett_anag' */
          if (CPLib.eqr(cursore,"dett_anag")) {
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"0000000A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
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
            /* Case cursore='cli_occ' */
          } else if (CPLib.eqr(cursore,"cli_occ")) {
            // * --- Insert into tmp_stp_altri_cli_occ_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stp_altri_cli_occ_operazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stp_altri_cli_occ_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_altri_cli_occ_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"0000000B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_altri_cli_occ_operazioni",true);
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
            /* Case cursore='sogg_ope' */
          } else if (CPLib.eqr(cursore,"sogg_ope")) {
            // * --- Insert into tmp_stp_sogoper_ope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
            m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"0000000C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
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
            /* Case cursore='benef' */
          } else if (CPLib.eqr(cursore,"benef")) {
            // * --- Insert into tmp_stp_controparti_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stp_controparti_operazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stp_controparti_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_controparti_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"0000000D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_controparti_operazioni",true);
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
            /* Case cursore='sogg_ter' */
          } else if (CPLib.eqr(cursore,"sogg_ter")) {
            // * --- Insert into tmp_stp_sogg_ter_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stp_sogg_ter_operazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stp_sogg_ter_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogg_ter_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"0000000E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_last_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogg_ter_operazioni",true);
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
          } // End Case
          /* find := True */
          find = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_qbe_last_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_last_wersonbo.ErrorMessage();
      } else {
        // No rows selected
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pconess,"?",0,0,m_cServer, m_oParameters),m_cServer,pconess)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        if ( ! (Cursor_personbo.Eof())) {
          while ( ! (Cursor_personbo.Eof())) {
            /* Case cursore='dett_anag' */
            if (CPLib.eqr(cursore,"dett_anag")) {
              // * --- Insert into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"00000013")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000013(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
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
              /* Case cursore='cli_occ' */
            } else if (CPLib.eqr(cursore,"cli_occ")) {
              // * --- Insert into tmp_stp_altri_cli_occ_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_altri_cli_occ_operazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_altri_cli_occ_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_altri_cli_occ_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"00000014")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000014(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_altri_cli_occ_operazioni",true);
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
              /* Case cursore='sogg_ope' */
            } else if (CPLib.eqr(cursore,"sogg_ope")) {
              // * --- Insert into tmp_stp_sogoper_ope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogoper_ope");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogoper_ope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogoper_ope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
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
              /* Case cursore='benef' */
            } else if (CPLib.eqr(cursore,"benef")) {
              // * --- Insert into tmp_stp_controparti_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_controparti_operazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_controparti_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_controparti_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"00000016")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000016(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_controparti_operazioni",true);
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
              /* Case cursore='sogg_ter' */
            } else if (CPLib.eqr(cursore,"sogg_ter")) {
              // * --- Insert into tmp_stp_sogg_ter_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stp_sogg_ter_operazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stp_sogg_ter_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stp_sogg_ter_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_doc_sogg",32,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stp_sogg_ter_operazioni",true);
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
            } // End Case
            /* find := True */
            find = true;
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
        } else {
          // No rows selected
          /* find := False  */
          find = false;
        }
        Cursor_personbo.Close();
        // * --- End Select
      }
      Cursor_qbe_last_wersonbo.Close();
      // * --- End Select
      /* Return find */
      throw new Stop(find);
    } finally {
      try {
        if (Cursor_qbe_last_wersonbo!=null)
          Cursor_qbe_last_wersonbo.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_connes,java.sql.Date p_dataope,String p_idbase,String p_cursore) {
    connes = p_connes;
    dataope = p_dataope;
    idbase = p_idbase;
    cursore = p_cursore;
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
  public boolean Run(String p_connes,java.sql.Date p_dataope,String p_idbase,String p_cursore) {
    connes = p_connes;
    dataope = p_dataope;
    idbase = p_idbase;
    cursore = p_cursore;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
    return l_result;
  }
  public static arfn_doc_soggR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_doc_soggR(p_Ctx, p_Caller);
  }
  public static arfn_doc_soggR Make(CPContext p_Ctx) {
    return new arfn_doc_soggR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    connes = CPLib.Space(16);
    dataope = CPLib.NullDate();
    idbase = CPLib.Space(10);
    cursore = CPLib.Space(20);
    find = false;
    pconess = CPLib.Space(16);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_last_wersonbo,
  public static final String m_cVQRList = ",qbe_last_wersonbo,";
  // ENTITY_BATCHES: ,arfn_doc_sogg,
  public static final String i_InvokedRoutines = ",arfn_doc_sogg,";
  public static String[] m_cRunParameterNames={"connes","dataope","idbase","cursore"};
  protected static String GetFieldsName_0000000A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"OCONNES,";
    p_cSql = p_cSql+"OCODCAB,";
    p_cSql = p_cSql+"ORAGSOC,";
    p_cSql = p_cSql+"ODOMICILIO,";
    p_cSql = p_cSql+"OCODFISC,";
    p_cSql = p_cSql+"ODATANASC,";
    p_cSql = p_cSql+"ONASCOMUN,";
    p_cSql = p_cSql+"OSOTGRUP,";
    p_cSql = p_cSql+"ORAMOGRUP,";
    p_cSql = p_cSql+"OSETTSINT,";
    p_cSql = p_cSql+"OTIPODOC,";
    p_cSql = p_cSql+"ONUMDOCUM,";
    p_cSql = p_cSql+"ODATARILASC,";
    p_cSql = p_cSql+"OAUTRILASC,";
    p_cSql = p_cSql+"ODESCCIT,";
    p_cSql = p_cSql+"OPROVINCIA,";
    p_cSql = p_cSql+"OPAESE,";
    p_cSql = p_cSql+"OCAP,";
    p_cSql = p_cSql+"OCODINTER,";
    p_cSql = p_cSql+"OTIPINTER,";
    p_cSql = p_cSql+"OTIPOPERS,";
    p_cSql = p_cSql+"OCODDIPE,";
    p_cSql = p_cSql+"OPARTIVA,";
    p_cSql = p_cSql+"ONOTE,";
    p_cSql = p_cSql+"OSESSO,";
    p_cSql = p_cSql+"OSOSPMAF,";
    p_cSql = p_cSql+"Oidcitta,";
    p_cSql = p_cSql+"ODATAVALI,";
    p_cSql = p_cSql+"ONASSTATO,";
    p_cSql = p_cSql+"ODOCFILE,";
    p_cSql = p_cSql+"ONOME,";
    p_cSql = p_cSql+"OCOGNOME,";
    p_cSql = p_cSql+"OCFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_altri_cli_occ_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CCONNES,";
    p_cSql = p_cSql+"CCODCAB,";
    p_cSql = p_cSql+"CRAGSOC,";
    p_cSql = p_cSql+"CDOMICILIO,";
    p_cSql = p_cSql+"CCODFISC,";
    p_cSql = p_cSql+"CDATANASC,";
    p_cSql = p_cSql+"CNASCOMUN,";
    p_cSql = p_cSql+"CSOTGRUP,";
    p_cSql = p_cSql+"CRAMOGRUP,";
    p_cSql = p_cSql+"CSETTSINT,";
    p_cSql = p_cSql+"CTIPODOC,";
    p_cSql = p_cSql+"CNUMDOCUM,";
    p_cSql = p_cSql+"CDATARILASC,";
    p_cSql = p_cSql+"CAUTRILASC,";
    p_cSql = p_cSql+"CDESCCIT,";
    p_cSql = p_cSql+"CPROVINCIA,";
    p_cSql = p_cSql+"CPAESE,";
    p_cSql = p_cSql+"CCAP,";
    p_cSql = p_cSql+"CCODINTER,";
    p_cSql = p_cSql+"CTIPINTER,";
    p_cSql = p_cSql+"CTIPOPERS,";
    p_cSql = p_cSql+"CCODDIPE,";
    p_cSql = p_cSql+"CPARTIVA,";
    p_cSql = p_cSql+"CNOTE,";
    p_cSql = p_cSql+"CSESSO,";
    p_cSql = p_cSql+"CSOSPMAF,";
    p_cSql = p_cSql+"Cidcitta,";
    p_cSql = p_cSql+"CDATAVALI,";
    p_cSql = p_cSql+"CNASSTATO,";
    p_cSql = p_cSql+"CDOCFILE,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"CCOGNOME,";
    p_cSql = p_cSql+"CCFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_controparti_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TCONNES,";
    p_cSql = p_cSql+"TCODCAB,";
    p_cSql = p_cSql+"TRAGSOC,";
    p_cSql = p_cSql+"TDOMICILIO,";
    p_cSql = p_cSql+"TCODFISC,";
    p_cSql = p_cSql+"TDATANASC,";
    p_cSql = p_cSql+"TNASCOMUN,";
    p_cSql = p_cSql+"TSOTGRUP,";
    p_cSql = p_cSql+"TRAMOGRUP,";
    p_cSql = p_cSql+"TSETTSINT,";
    p_cSql = p_cSql+"TTIPODOC,";
    p_cSql = p_cSql+"TNUMDOCUM,";
    p_cSql = p_cSql+"TDATARILASC,";
    p_cSql = p_cSql+"TAUTRILASC,";
    p_cSql = p_cSql+"TDESCCIT,";
    p_cSql = p_cSql+"TPROVINCIA,";
    p_cSql = p_cSql+"TPAESE,";
    p_cSql = p_cSql+"TCAP,";
    p_cSql = p_cSql+"TCODINTER,";
    p_cSql = p_cSql+"TTIPINTER,";
    p_cSql = p_cSql+"TTIPOPERS,";
    p_cSql = p_cSql+"TCODDIPE,";
    p_cSql = p_cSql+"TPARTIVA,";
    p_cSql = p_cSql+"TNOTE,";
    p_cSql = p_cSql+"TSESSO,";
    p_cSql = p_cSql+"TSOSPMAF,";
    p_cSql = p_cSql+"Tidcitta,";
    p_cSql = p_cSql+"TDATAVALI,";
    p_cSql = p_cSql+"TNASSTATO,";
    p_cSql = p_cSql+"TDOCFILE,";
    p_cSql = p_cSql+"TNOME,";
    p_cSql = p_cSql+"TCOGNOME,";
    p_cSql = p_cSql+"TCFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogg_ter_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000013(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000014(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"OCONNES,";
    p_cSql = p_cSql+"OCODCAB,";
    p_cSql = p_cSql+"ORAGSOC,";
    p_cSql = p_cSql+"ODOMICILIO,";
    p_cSql = p_cSql+"OCODFISC,";
    p_cSql = p_cSql+"ODATANASC,";
    p_cSql = p_cSql+"ONASCOMUN,";
    p_cSql = p_cSql+"OSOTGRUP,";
    p_cSql = p_cSql+"ORAMOGRUP,";
    p_cSql = p_cSql+"OSETTSINT,";
    p_cSql = p_cSql+"OTIPODOC,";
    p_cSql = p_cSql+"ONUMDOCUM,";
    p_cSql = p_cSql+"ODATARILASC,";
    p_cSql = p_cSql+"OAUTRILASC,";
    p_cSql = p_cSql+"ODESCCIT,";
    p_cSql = p_cSql+"OPROVINCIA,";
    p_cSql = p_cSql+"OPAESE,";
    p_cSql = p_cSql+"OCAP,";
    p_cSql = p_cSql+"OCODINTER,";
    p_cSql = p_cSql+"OTIPINTER,";
    p_cSql = p_cSql+"OTIPOPERS,";
    p_cSql = p_cSql+"OCODDIPE,";
    p_cSql = p_cSql+"OPARTIVA,";
    p_cSql = p_cSql+"ONOTE,";
    p_cSql = p_cSql+"OSESSO,";
    p_cSql = p_cSql+"OSOSPMAF,";
    p_cSql = p_cSql+"Oidcitta,";
    p_cSql = p_cSql+"ODATAVALI,";
    p_cSql = p_cSql+"ONASSTATO,";
    p_cSql = p_cSql+"ODOCFILE,";
    p_cSql = p_cSql+"ONOME,";
    p_cSql = p_cSql+"OCOGNOME,";
    p_cSql = p_cSql+"OCFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_altri_cli_occ_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogoper_ope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000016(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CAUTRILASC,";
    p_cSql = p_cSql+"CCAP,";
    p_cSql = p_cSql+"CCFESTERO,";
    p_cSql = p_cSql+"CCODCAB,";
    p_cSql = p_cSql+"CCODDIPE,";
    p_cSql = p_cSql+"CCODFISC,";
    p_cSql = p_cSql+"CCODINTER,";
    p_cSql = p_cSql+"CCOGNOME,";
    p_cSql = p_cSql+"CCONNES,";
    p_cSql = p_cSql+"CDATANASC,";
    p_cSql = p_cSql+"CDATARILASC,";
    p_cSql = p_cSql+"CDATAVALI,";
    p_cSql = p_cSql+"CDESCCIT,";
    p_cSql = p_cSql+"CDOCFILE,";
    p_cSql = p_cSql+"CDOMICILIO,";
    p_cSql = p_cSql+"Cidcitta,";
    p_cSql = p_cSql+"CNASCOMUN,";
    p_cSql = p_cSql+"CNASSTATO,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"CNOTE,";
    p_cSql = p_cSql+"CNUMDOCUM,";
    p_cSql = p_cSql+"CPAESE,";
    p_cSql = p_cSql+"CPARTIVA,";
    p_cSql = p_cSql+"CPROVINCIA,";
    p_cSql = p_cSql+"CRAGSOC,";
    p_cSql = p_cSql+"CRAMOGRUP,";
    p_cSql = p_cSql+"CSESSO,";
    p_cSql = p_cSql+"CSETTSINT,";
    p_cSql = p_cSql+"CSOSPMAF,";
    p_cSql = p_cSql+"CSOTGRUP,";
    p_cSql = p_cSql+"CTIPINTER,";
    p_cSql = p_cSql+"CTIPODOC,";
    p_cSql = p_cSql+"CTIPOPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_controparti_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TCONNES,";
    p_cSql = p_cSql+"TCODCAB,";
    p_cSql = p_cSql+"TRAGSOC,";
    p_cSql = p_cSql+"TDOMICILIO,";
    p_cSql = p_cSql+"TCODFISC,";
    p_cSql = p_cSql+"TDATANASC,";
    p_cSql = p_cSql+"TNASCOMUN,";
    p_cSql = p_cSql+"TSOTGRUP,";
    p_cSql = p_cSql+"TRAMOGRUP,";
    p_cSql = p_cSql+"TSETTSINT,";
    p_cSql = p_cSql+"TTIPODOC,";
    p_cSql = p_cSql+"TNUMDOCUM,";
    p_cSql = p_cSql+"TDATARILASC,";
    p_cSql = p_cSql+"TAUTRILASC,";
    p_cSql = p_cSql+"TDESCCIT,";
    p_cSql = p_cSql+"TPROVINCIA,";
    p_cSql = p_cSql+"TPAESE,";
    p_cSql = p_cSql+"TCAP,";
    p_cSql = p_cSql+"TCODINTER,";
    p_cSql = p_cSql+"TTIPINTER,";
    p_cSql = p_cSql+"TTIPOPERS,";
    p_cSql = p_cSql+"TCODDIPE,";
    p_cSql = p_cSql+"TPARTIVA,";
    p_cSql = p_cSql+"TNOTE,";
    p_cSql = p_cSql+"TSESSO,";
    p_cSql = p_cSql+"TSOSPMAF,";
    p_cSql = p_cSql+"Tidcitta,";
    p_cSql = p_cSql+"TDATAVALI,";
    p_cSql = p_cSql+"TNASSTATO,";
    p_cSql = p_cSql+"TDOCFILE,";
    p_cSql = p_cSql+"TNOME,";
    p_cSql = p_cSql+"TCOGNOME,";
    p_cSql = p_cSql+"TCFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stp_sogg_ter_operazioni",true);
    return p_cSql;
  }
}
