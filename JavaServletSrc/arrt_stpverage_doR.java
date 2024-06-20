// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpverage_doR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tmp_stpverage_do;
  public String m_cServer_tmp_stpverage_do;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
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
  public String w_c_adata;
  public String w_cdadata;
  public String w_chkcfis;
  public String w_noninvio;
  public String _motivo;
  public String _codrap;
  public String _codper;
  public java.sql.Date _datnas;
  public String _provnas;
  public String _comnas;
  public String _naznas;
  public String _mesnas;
  public String _gionas;
  public String _annnas;
  public String _sesso;
  public String _codfisc;
  public String _cmesi;
  public double _pos;
  public String _motivo2;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpverage_doR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpverage_do",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
      m_cPhName_tmp_stpverage_do = p_ContextObject.GetPhName("tmp_stpverage_do");
      if (m_cPhName_tmp_stpverage_do.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpverage_do = m_cPhName_tmp_stpverage_do+" "+m_Ctx.GetWritePhName("tmp_stpverage_do");
      }
      m_cServer_tmp_stpverage_do = p_ContextObject.GetServer("tmp_stpverage_do");
    }
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
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_pos",p_cVarName)) {
      return _pos;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stpverage_do";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("chkcfis",p_cVarName)) {
      return w_chkcfis;
    }
    if (CPLib.eqr("noninvio",p_cVarName)) {
      return w_noninvio;
    }
    if (CPLib.eqr("_motivo",p_cVarName)) {
      return _motivo;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_codper",p_cVarName)) {
      return _codper;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      return _provnas;
    }
    if (CPLib.eqr("_comnas",p_cVarName)) {
      return _comnas;
    }
    if (CPLib.eqr("_naznas",p_cVarName)) {
      return _naznas;
    }
    if (CPLib.eqr("_mesnas",p_cVarName)) {
      return _mesnas;
    }
    if (CPLib.eqr("_gionas",p_cVarName)) {
      return _gionas;
    }
    if (CPLib.eqr("_annnas",p_cVarName)) {
      return _annnas;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_cmesi",p_cVarName)) {
      return _cmesi;
    }
    if (CPLib.eqr("_motivo2",p_cVarName)) {
      return _motivo2;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
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
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
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
    if (CPLib.eqr("_pos",p_cVarName)) {
      _pos = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("chkcfis",p_cVarName)) {
      w_chkcfis = value;
      return;
    }
    if (CPLib.eqr("noninvio",p_cVarName)) {
      w_noninvio = value;
      return;
    }
    if (CPLib.eqr("_motivo",p_cVarName)) {
      _motivo = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("_codper",p_cVarName)) {
      _codper = value;
      return;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      _provnas = value;
      return;
    }
    if (CPLib.eqr("_comnas",p_cVarName)) {
      _comnas = value;
      return;
    }
    if (CPLib.eqr("_naznas",p_cVarName)) {
      _naznas = value;
      return;
    }
    if (CPLib.eqr("_mesnas",p_cVarName)) {
      _mesnas = value;
      return;
    }
    if (CPLib.eqr("_gionas",p_cVarName)) {
      _gionas = value;
      return;
    }
    if (CPLib.eqr("_annnas",p_cVarName)) {
      _annnas = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_cmesi",p_cVarName)) {
      _cmesi = value;
      return;
    }
    if (CPLib.eqr("_motivo2",p_cVarName)) {
      _motivo2 = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
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
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_c_adata Char(8) */
      /* w_cdadata Char(8) */
      /* w_chkcfis Char(1) */
      /* w_noninvio Char(1) */
      /* _motivo Memo */
      /* _codrap Char(25) */
      /* _codper Char(16) */
      /* _datnas Date */
      /* _provnas Char(2) */
      /* _comnas Char(40) */
      /* _naznas Char(40) */
      /* _mesnas Char(2) */
      /* _gionas Char(2) */
      /* _annnas Char(4) */
      /* _sesso Char(1) */
      /* _codfisc Char(16) */
      /* _cmesi Char(12) */
      /* _pos Numeric(2, 0) */
      /* _motivo2 Memo */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* Creazione file di appoggio */
      // * --- Drop temporary table tmp_stpverage_do
      if (m_Ctx.IsSharedTemp("tmp_stpverage_do")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage_do");
      }
      // * --- Create temporary table tmp_stpverage_do
      if (m_Ctx.IsSharedTemp("tmp_stpverage_do")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage_do");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpverage_do");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpverage_do"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpverage_do",m_cServer,"proto")),m_cPhName,"tmp_stpverage_do",m_Ctx);
      }
      m_cPhName_tmp_stpverage_do = m_cPhName;
      /* Veirifica dati intermediario */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* If Empty(intermbo->CODINTER) or Empty(intermbo->DESCCIT) or Empty(intermbo->PROVINCIA) or Empty(intermbo->RAGSOC) */
        if (CPLib.Empty(Cursor_intermbo.GetString("CODINTER")) || CPLib.Empty(Cursor_intermbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_intermbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_intermbo.GetString("RAGSOC"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(intermbo->CODINTER) */
          if (CPLib.Empty(Cursor_intermbo.GetString("CODINTER"))) {
            /* _motivo := _motivo + "-- Codice Fiscale"+NL */
            _motivo = _motivo+"-- Codice Fiscale"+"\n";
          } // End If
          /* If Empty(intermbo->DESCCIT) */
          if (CPLib.Empty(Cursor_intermbo.GetString("DESCCIT"))) {
            /* _motivo := _motivo + "-- Citta' Sede Legale"+NL */
            _motivo = _motivo+"-- Citta' Sede Legale"+"\n";
          } // End If
          /* If Empty(intermbo->PROVINCIA) */
          if (CPLib.Empty(Cursor_intermbo.GetString("PROVINCIA"))) {
            /* _motivo := _motivo + "-- Provincia Sede Legale"+NL */
            _motivo = _motivo+"-- Provincia Sede Legale"+"\n";
          } // End If
          /* If Empty(intermbo->RAGSOC) */
          if (CPLib.Empty(Cursor_intermbo.GetString("RAGSOC"))) {
            /* _motivo := _motivo + "-- Ragione Sociale"+NL */
            _motivo = _motivo+"-- Ragione Sociale"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Mancano in Anagrafica Intermediario alcuni dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 1-01 Anagrafica intermediario dati non congrui","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Valorizzato cod. fisc. intermediario in modo errato","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Cicla su aederig e verifica tutto */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000035status;
      nTry00000035status = m_Sql.GetTransactionStatus();
      String cTry00000035msg;
      cTry00000035msg = m_Sql.TransactionErrorMessage();
      try {
        /* If Empty(w_DaDatOpe) and Empty(w_ADatOpe) */
        if (CPLib.Empty(w_DaDatOpe) && CPLib.Empty(w_ADatOpe)) {
          /* If w_noninvio='N' */
          if (CPLib.eqr(w_noninvio,"N")) {
            /* Exec "Senza Limiti tutte" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } else { // Else
            /* Exec "Senza limiti solo non inviate" Page 4:Page_4 */
            Page_4();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
        } else { // Else
          /* If w_noninvio='N' */
          if (CPLib.eqr(w_noninvio,"N")) {
            /* Exec "Con limiti tutte" Page 5:Page_5 */
            Page_5();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } else { // Else
            /* Exec "Con limiti solo non inviate" Page 6:Page_6 */
            Page_6();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000035status,0)) {
          m_Sql.SetTransactionStatus(nTry00000035status,cTry00000035msg);
        }
      }
      /* Stop arrp_stpverage_do.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("ReportName","arrp_stpverage_do.vrp");
      f.SetParameter("m_cParameterSequence","rotation"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Ricava i dati dal codice fiscale */
      /* If Len(LRTrim(_codfisc)) = 16 */
      if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfisc)),16)) {
        /* _cmesi := "ABCDEHLMPRST" */
        _cmesi = "ABCDEHLMPRST";
        /* _pos := At(Substr(_codfisc,9,1),_cmesi) */
        _pos = CPLib.Round(CPLib.At(CPLib.Substr(_codfisc,9,1),_cmesi),0);
        /* _mesnas := Right('00'+LRTrim(Str(_pos,2,0)),2) */
        _mesnas = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(_pos,2,0)),2);
        /* If Val(Substr(_codfisc,10,2)) >= 40 */
        if (CPLib.ge(CPLib.Val(CPLib.Substr(_codfisc,10,2)),40)) {
          /* _gionas := Right('00'+LRTrim(Str((Val(Substr(_codfisc,10,2)) - 40),2,0)),2) */
          _gionas = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str((CPLib.Val(CPLib.Substr(_codfisc,10,2))-40),2,0)),2);
          /* _sesso := '2' */
          _sesso = "2";
        } else { // Else
          /* _gionas := Substr(_codfisc,10,2) */
          _gionas = CPLib.Substr(_codfisc,10,2);
          /* _sesso := '1' */
          _sesso = "1";
        } // End If
        /* _annnas := "19"+Substr(_codfisc,7,2) */
        _annnas = "19"+CPLib.Substr(_codfisc,7,2);
        /* _datnas := CharToDate(_annnas+_mesnas+_gionas) */
        _datnas = CPLib.CharToDate(_annnas+_mesnas+_gionas);
        /* _naznas := '' */
        _naznas = "";
        /* _provnas := '' */
        _provnas = "";
        /* _comnas := '' */
        _comnas = "";
        // * --- Read from tbcitta
        m_cServer = m_Ctx.GetServer("tbcitta");
        m_cPhName = m_Ctx.GetPhName("tbcitta");
        m_cSql = "";
        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
        if (m_Ctx.IsSharedTemp("tbcitta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _comnas = Read_Cursor.GetString("CITTA");
          _provnas = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _comnas = "";
          _provnas = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_provnas)) */
        if (CPLib.Empty(CPLib.LRTrim(_provnas))) {
          /* _comnas := '' */
          _comnas = "";
          /* _provnas := 'EE' */
          _provnas = "EE";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _naznas = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _naznas = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_aederig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_aeoprig=null;
    try {
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aederig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* If Empty(aederig->ADATA) or Empty(aederig->CONNESINT) or Empty(aederig->RAPPORTO) */
        if (CPLib.Empty(Cursor_aederig.GetDate("ADATA")) || CPLib.Empty(Cursor_aederig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(aederig->CONNESINT) */
          if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
            /* _motivo := _motivo + "-- Codice Delegato"+NL */
            _motivo = _motivo+"-- Codice Delegato"+"\n";
          } // End If
          /* If Empty(aederig->ADATA) */
          if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
            /* _motivo := _motivo + "-- Data Apertura"+NL */
            _motivo = _motivo+"-- Data Apertura"+"\n";
          } // End If
          /* If Empty(aederig->RAPPORTO) */
          if (CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
            /* _motivo := _motivo + "-- Codice Rapporto"+NL */
            _motivo = _motivo+"-- Codice Rapporto"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000005D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000005D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } // End If
        /* If Empty(aederig->TIPOAG) or Empty(aederig->COINT) */
        if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(aederig->TIPOAG) */
          if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
            /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
            _motivo = _motivo+"-- Tipo Rapporto"+"\n";
          } // End If
          /* If Empty(aederig->COINT) */
          if (CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
            /* _motivo := _motivo + "-- Natura"+NL */
            _motivo = _motivo+"-- Natura"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000064")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000064(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati testa","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } // End If
        /* _codper := '' */
        _codper = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codper = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codper = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codper)) */
        if (CPLib.Empty(CPLib.LRTrim(_codper))) {
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000068")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000068(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aederig.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } else { // Else
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* If personbo->CFESTERO=1 */
            if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or Empty(personbo->NASCOMUN) or Empty(personbo->TIPINTER) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000007A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000007A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000082")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000082(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } else { // Else
              /* If Len(LRTrim(personbo->CODFISC)) = 16 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If arfn_chkcodfis(personbo->CODFISC,'086',personbo->CFESTERO) */
                    if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                      /* _codfisc := personbo->CODFISC */
                      _codfisc = Cursor_personbo.GetString("CODFISC");
                      /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                      Page_2();
                      /* _motivo2 := "" */
                      _motivo2 = "";
                      /* If _datnas <> personbo->DATANASC */
                      if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                        /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                        _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                      } // End If
                      /* If _provnas <> personbo->TIPINTER */
                      if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                        /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                        _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                      } // End If
                      /* If _sesso <> personbo->SESSO */
                      if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                        /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                        _motivo2 = _motivo2+"++  Sesso"+"\n";
                      } // End If
                      /* If not(Empty(_comnas)) */
                      if ( ! (CPLib.Empty(_comnas))) {
                        /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                        if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                          /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                          _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If not(Empty(_naznas)) */
                      if ( ! (CPLib.Empty(_naznas))) {
                        /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                        if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                          /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                          _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If Len(LRTrim(_motivo2)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                        /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                        _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                      } // End If
                    } else { // Else
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000A8(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000B2(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } // End If
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aeoprig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"ADATA,CONNESINT ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        /* If Empty(aeoprig->ADATA) or Empty(aeoprig->CONNESINT) or Empty(aeoprig->TIPOAG) or Empty(aeoprig->COINT) */
        if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA")) || CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(aeoprig->CONNESINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT"))) {
            /* _motivo := _motivo + "-- Codice Cliente"+NL */
            _motivo = _motivo+"-- Codice Cliente"+"\n";
          } // End If
          /* If Empty(aeoprig->ADATA) */
          if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA"))) {
            /* _motivo := _motivo + "-- Data Apertura"+NL */
            _motivo = _motivo+"-- Data Apertura"+"\n";
          } // End If
          /* If Empty(aeoprig->TIPOAG) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG"))) {
            /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
            _motivo = _motivo+"-- Tipo Rapporto"+"\n";
          } // End If
          /* If Empty(aeoprig->COINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
            /* _motivo := _motivo + "-- Natura"+NL */
            _motivo = _motivo+"-- Natura"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000BF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000BF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-03 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } // End If
        /* _codper := '' */
        _codper = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codper = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codper = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codper)) */
        if (CPLib.Empty(CPLib.LRTrim(_codper))) {
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000C3(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_aeoprig.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } else { // Else
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* If personbo->CFESTERO=1 */
            if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000D5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000D5(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000000DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000DD(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } else { // Else
              /* If Len(LRTrim(personbo->CODFISC)) = 16 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* _motivo := "Non valorizzato:" */
                  _motivo = "Non valorizzato:";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASSTATO))='ITALIA' or Upper(LRTrim(personbo->NASSTATO))='ITALY') and Empty(LRTrim(personbo->NASCOMUN)) */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                    /* _motivo := _motivo + "--  Comune di nascita"+NL */
                    _motivo = _motivo+"--  Comune di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASCOMUN))='ITALIA' or Upper(LRTrim(personbo->NASCOMUN))='ITALY')  */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALY"))) {
                    /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                    _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                } // End If
                /* If w_chkcfis='S' */
                if (CPLib.eqr(w_chkcfis,"S")) {
                  /* If arfn_chkcodfis(personbo->CODFISC,'086',personbo->CFESTERO) */
                  if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                    /* w_CODFISC := '' // Codice Fiscale */
                    w_CODFISC = "";
                    /* w_DATANASC := NullDate() // Data Nascita */
                    w_DATANASC = CPLib.NullDate();
                    /* w_NASCOMUN := '' // Luogo di Nascita */
                    w_NASCOMUN = "";
                    /* w_NASSTATO := '' // Stato di nascita */
                    w_NASSTATO = "";
                    /* w_COGNOME := '' // Ragione Sociale */
                    w_COGNOME = "";
                    /* w_RAGSOC := '' // Ragione Sociale */
                    w_RAGSOC = "";
                    /* w_NOME := '' // Ragione Sociale */
                    w_NOME = "";
                    /* w_SESSO := '' // Sesso */
                    w_SESSO = "";
                    /* w_DATANASC := personbo->DATANASC // Data Nascita */
                    w_DATANASC = Cursor_personbo.GetDate("DATANASC");
                    /* w_NASCOMUN := personbo->NASCOMUN // Luogo di Nascita */
                    w_NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                    /* w_NASSTATO := personbo->NASSTATO // Stato di nascita */
                    w_NASSTATO = Cursor_personbo.GetString("NASSTATO");
                    /* w_COGNOME := personbo->COGNOME // Ragione Sociale */
                    w_COGNOME = Cursor_personbo.GetString("COGNOME");
                    /* w_RAGSOC := personbo->RAGSOC // Ragione Sociale */
                    w_RAGSOC = Cursor_personbo.GetString("RAGSOC");
                    /* w_NOME := personbo->NOME // Ragione Sociale */
                    w_NOME = Cursor_personbo.GetString("NOME");
                    /* w_SESSO := personbo->SESSO // Sesso */
                    w_SESSO = Cursor_personbo.GetString("SESSO");
                    /* Exec Routine arrt_calccodfis */
                    arrt_calccodfisR.Make(m_Ctx,this).Run();
                    /* _codfisc := personbo->CODFISC */
                    _codfisc = Cursor_personbo.GetString("CODFISC");
                    /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                    Page_2();
                    /* _motivo2 := "" */
                    _motivo2 = "";
                    /* If not(Empty(w_CODFISC)) */
                    if ( ! (CPLib.Empty(w_CODFISC))) {
                      /* If Left(_codfisc,3) <> Left(w_CODFISC,3) */
                      if (CPLib.ne(CPLib.Left(_codfisc,3),CPLib.Left(w_CODFISC,3))) {
                        /* _motivo2 := _motivo2 + "++ Cognome"+NL */
                        _motivo2 = _motivo2+"++ Cognome"+"\n";
                      } // End If
                      /* If Substr(_codfisc,4,3) <> Substr(w_CODFISC,4,3) */
                      if (CPLib.ne(CPLib.Substr(_codfisc,4,3),CPLib.Substr(w_CODFISC,4,3))) {
                        /* _motivo2 := _motivo2 + "++ Nome"+NL */
                        _motivo2 = _motivo2+"++ Nome"+"\n";
                      } // End If
                    } // End If
                    /* If _datnas <> personbo->DATANASC */
                    if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                      _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                    } // End If
                    /* If _provnas <> personbo->TIPINTER */
                    if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                      _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                    } // End If
                    /* If _sesso <> personbo->SESSO */
                    if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                      _motivo2 = _motivo2+"++  Sesso"+"\n";
                    } // End If
                    /* If not(Empty(_comnas)) */
                    if ( ! (CPLib.Empty(_comnas))) {
                      /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                      if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                        /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                        _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                      } // End If
                    } // End If
                    /* If not(Empty(_naznas)) */
                    if ( ! (CPLib.Empty(_naznas))) {
                      /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                      if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                        _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                      } // End If
                    } // End If
                    /* If Len(LRTrim(_motivo2)) > 0 */
                    if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                      /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                      _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                    } // End If
                  } else { // Else
                    /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                    _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                  } // End If
                } // End If
                /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000011F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000011F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000129")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000129(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } // End If
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_aederig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_aeoprig=null;
    try {
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aederig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* If Empty(aederig->AFILE) and Empty(aederig->CFILE) */
        if (CPLib.Empty(Cursor_aederig.GetString("AFILE")) && CPLib.Empty(Cursor_aederig.GetString("CFILE"))) {
          /* If Empty(aederig->ADATA) or Empty(aederig->CONNESINT) or Empty(aederig->RAPPORTO) */
          if (CPLib.Empty(Cursor_aederig.GetDate("ADATA")) || CPLib.Empty(Cursor_aederig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
            /* _motivo := "Non valorizzato:"+NL */
            _motivo = "Non valorizzato:"+"\n";
            /* If Empty(aederig->CONNESINT) */
            if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
              /* _motivo := _motivo + "-- Codice Intestatario"+NL */
              _motivo = _motivo+"-- Codice Intestatario"+"\n";
            } // End If
            /* If Empty(aederig->ADATA) */
            if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
              /* _motivo := _motivo + "-- Data Apertura"+NL */
              _motivo = _motivo+"-- Data Apertura"+"\n";
            } // End If
            /* If Empty(aederig->RAPPORTO) */
            if (CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
              /* _motivo := _motivo + "-- Codice Rapporto"+NL */
              _motivo = _motivo+"-- Codice Rapporto"+"\n";
            } // End If
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000135")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000135(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
          /* _codrap := '' */
          _codrap = "";
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_codrap))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000139")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000139(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia Dati Testa","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            /* If Empty(aederig->TIPOAG) or Empty(aederig->COINT) */
            if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
              /* _motivo := "Non valorizzato:"+NL */
              _motivo = "Non valorizzato:"+"\n";
              /* If Empty(aederig->TIPOAG) */
              if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
                /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                _motivo = _motivo+"-- Tipo Rapporto"+"\n";
              } // End If
              /* If Empty(aederig->COINT) */
              if (CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
                /* _motivo := _motivo + "-- Natura"+NL */
                _motivo = _motivo+"-- Natura"+"\n";
              } // End If
              // * --- Insert into tmp_stpverage_do from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000140")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000140(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati testa","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            } // End If
          } // End If
          /* _codper := '' */
          _codper = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codper = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codper = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codper)) */
          if (CPLib.Empty(CPLib.LRTrim(_codper))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000144")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000144(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aederig.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If personbo->CFESTERO=1 */
              if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
                /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000156")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000156(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000015E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000015E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } else { // Else
                /* If Len(LRTrim(personbo->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or Empty(personbo->NASCOMUN) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If w_chkcfis='S' */
                    if (CPLib.eqr(w_chkcfis,"S")) {
                      /* If arfn_chkcodfis(personbo->CODFISC,'086',personbo->CFESTERO) */
                      if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                        /* _codfisc := personbo->CODFISC */
                        _codfisc = Cursor_personbo.GetString("CODFISC");
                        /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                        Page_2();
                        /* _motivo2 := "" */
                        _motivo2 = "";
                        /* If _datnas <> personbo->DATANASC */
                        if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                          /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                          _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                        } // End If
                        /* If _provnas <> personbo->TIPINTER */
                        if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                          /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                          _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                        } // End If
                        /* If _sesso <> personbo->SESSO */
                        if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                          /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                          _motivo2 = _motivo2+"++  Sesso"+"\n";
                        } // End If
                        /* If not(Empty(_comnas)) */
                        if ( ! (CPLib.Empty(_comnas))) {
                          /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                          if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                            /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                            _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                          } // End If
                        } // End If
                        /* If not(Empty(_naznas)) */
                        if ( ! (CPLib.Empty(_naznas))) {
                          /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                          if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                            /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                            _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                          } // End If
                        } // End If
                        /* If Len(LRTrim(_motivo2)) > 0 */
                        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                          /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                          _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                        } // End If
                      } else { // Else
                        /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                        _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                      } // End If
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000184")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000184(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000018E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000018E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
              /* _motivo := '' */
              _motivo = "";
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aeoprig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"ADATA,CONNESINT ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        /* If Empty(aeoprig->AFILE) */
        if (CPLib.Empty(Cursor_aeoprig.GetString("AFILE"))) {
          /* If Empty(aeoprig->ADATA) or Empty(aeoprig->CONNESINT) or Empty(aeoprig->TIPOAG) or Empty(aeoprig->COINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA")) || CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
            /* _motivo := "Non valorizzato:"+NL */
            _motivo = "Non valorizzato:"+"\n";
            /* If Empty(aeoprig->CONNESINT) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT"))) {
              /* _motivo := _motivo + "-- Codice Cliente"+NL */
              _motivo = _motivo+"-- Codice Cliente"+"\n";
            } // End If
            /* If Empty(aeoprig->ADATA) */
            if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA"))) {
              /* _motivo := _motivo + "-- Data Apertura"+NL */
              _motivo = _motivo+"-- Data Apertura"+"\n";
            } // End If
            /* If Empty(aeoprig->TIPOAG) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG"))) {
              /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
              _motivo = _motivo+"-- Tipo Rapporto"+"\n";
            } // End If
            /* If Empty(aeoprig->COINT) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
              /* _motivo := _motivo + "-- Natura"+NL */
              _motivo = _motivo+"-- Natura"+"\n";
            } // End If
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000019D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000019D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-03 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
          /* _codper := '' */
          _codper = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codper = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codper = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codper)) */
          if (CPLib.Empty(CPLib.LRTrim(_codper))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000001A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001A1(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_aeoprig.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If personbo->CFESTERO=1 */
              if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
                /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000001B3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001B3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000001BB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001BB(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } else { // Else
                /* If Len(LRTrim(personbo->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(personbo->NASSTATO))='ITALIA' or Upper(LRTrim(personbo->NASSTATO))='ITALY') and Empty(LRTrim(personbo->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(personbo->NASCOMUN))='ITALIA' or Upper(LRTrim(personbo->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If arfn_chkcodfis(Upper(personbo->CODFISC),'086',personbo->CFESTERO) */
                    if (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_personbo.GetString("CODFISC")),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                      /* w_CODFISC := '' // Codice Fiscale */
                      w_CODFISC = "";
                      /* w_DATANASC := NullDate() // Data Nascita */
                      w_DATANASC = CPLib.NullDate();
                      /* w_NASCOMUN := '' // Luogo di Nascita */
                      w_NASCOMUN = "";
                      /* w_NASSTATO := '' // Stato di nascita */
                      w_NASSTATO = "";
                      /* w_COGNOME := '' // Ragione Sociale */
                      w_COGNOME = "";
                      /* w_RAGSOC := '' // Ragione Sociale */
                      w_RAGSOC = "";
                      /* w_NOME := '' // Ragione Sociale */
                      w_NOME = "";
                      /* w_SESSO := '' // Sesso */
                      w_SESSO = "";
                      /* w_DATANASC := personbo->DATANASC // Data Nascita */
                      w_DATANASC = Cursor_personbo.GetDate("DATANASC");
                      /* w_NASCOMUN := personbo->NASCOMUN // Luogo di Nascita */
                      w_NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      /* w_NASSTATO := personbo->NASSTATO // Stato di nascita */
                      w_NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      /* w_COGNOME := personbo->COGNOME // Ragione Sociale */
                      w_COGNOME = Cursor_personbo.GetString("COGNOME");
                      /* w_RAGSOC := personbo->RAGSOC // Ragione Sociale */
                      w_RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      /* w_NOME := personbo->NOME // Ragione Sociale */
                      w_NOME = Cursor_personbo.GetString("NOME");
                      /* w_SESSO := personbo->SESSO // Sesso */
                      w_SESSO = Cursor_personbo.GetString("SESSO");
                      /* Exec Routine arrt_calccodfis */
                      arrt_calccodfisR.Make(m_Ctx,this).Run();
                      /* _codfisc := Upper(personbo->CODFISC) */
                      _codfisc = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                      /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                      Page_2();
                      /* _motivo2 := "" */
                      _motivo2 = "";
                      /* If not(Empty(w_CODFISC)) */
                      if ( ! (CPLib.Empty(w_CODFISC))) {
                        /* If Left(_codfisc,3) <> Left(w_CODFISC,3) */
                        if (CPLib.ne(CPLib.Left(_codfisc,3),CPLib.Left(w_CODFISC,3))) {
                          /* _motivo2 := _motivo2 + "++ Cognome"+NL */
                          _motivo2 = _motivo2+"++ Cognome"+"\n";
                        } // End If
                        /* If Substr(_codfisc,4,3) <> Substr(w_CODFISC,4,3) */
                        if (CPLib.ne(CPLib.Substr(_codfisc,4,3),CPLib.Substr(w_CODFISC,4,3))) {
                          /* _motivo2 := _motivo2 + "++ Nome"+NL */
                          _motivo2 = _motivo2+"++ Nome"+"\n";
                        } // End If
                      } // End If
                      /* If _datnas <> personbo->DATANASC */
                      if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                        /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                        _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                      } // End If
                      /* If _provnas <> personbo->TIPINTER */
                      if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                        /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                        _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                      } // End If
                      /* If _sesso <> personbo->SESSO */
                      if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                        /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                        _motivo2 = _motivo2+"++  Sesso"+"\n";
                      } // End If
                      /* If not(Empty(_comnas)) */
                      if ( ! (CPLib.Empty(_comnas))) {
                        /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                        if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                          /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                          _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If not(Empty(_naznas)) */
                      if ( ! (CPLib.Empty(_naznas))) {
                        /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                        if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                          /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                          _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If Len(LRTrim(_motivo2)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                        /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                        _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                      } // End If
                    } else { // Else
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000001FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001FD(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000207")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000207(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_aederig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_aeoprig=null;
    try {
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+")  or  (CDATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  CDATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* If Empty(aederig->ADATA) or Empty(aederig->CONNESINT) or Empty(aederig->RAPPORTO) */
        if (CPLib.Empty(Cursor_aederig.GetDate("ADATA")) || CPLib.Empty(Cursor_aederig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(aederig->CONNESINT) */
          if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
            /* _motivo := _motivo + "-- Codice Intestatario"+NL */
            _motivo = _motivo+"-- Codice Intestatario"+"\n";
          } // End If
          /* If Empty(aederig->ADATA) */
          if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
            /* _motivo := _motivo + "-- Data Apertura"+NL */
            _motivo = _motivo+"-- Data Apertura"+"\n";
          } // End If
          /* If Empty(aederig->RAPPORTO) */
          if (CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
            /* _motivo := _motivo + "-- Codice Rapporto"+NL */
            _motivo = _motivo+"-- Codice Rapporto"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000212")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000212(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } // End If
        /* _codrap := '' */
        _codrap = "";
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codrap = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codrap = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_codrap))) {
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000216")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000216(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } else { // Else
          /* If Empty(aederig->TIPOAG) or Empty(aederig->COINT) */
          if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
            /* _motivo := "Non valorizzato:"+NL */
            _motivo = "Non valorizzato:"+"\n";
            /* If Empty(aederig->TIPOAG) */
            if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
              /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
              _motivo = _motivo+"-- Tipo Rapporto"+"\n";
            } // End If
            /* If Empty(aederig->COINT) */
            if (CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
              /* _motivo := _motivo + "-- Natura"+NL */
              _motivo = _motivo+"-- Natura"+"\n";
            } // End If
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000021D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000021D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Deleghe Agenzia dati testa","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
        } // End If
        /* _codper := '' */
        _codper = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codper = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codper = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codper)) */
        if (CPLib.Empty(CPLib.LRTrim(_codper))) {
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000221")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000221(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aederig.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } else { // Else
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* If personbo->CFESTERO=1 */
            if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000233")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000233(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000023B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000023B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } else { // Else
              /* If Len(LRTrim(personbo->CODFISC)) = 16 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If arfn_chkcodfis(personbo->CODFISC,'086',personbo->CFESTERO) */
                    if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                      /* _codfisc := personbo->CODFISC */
                      _codfisc = Cursor_personbo.GetString("CODFISC");
                      /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                      Page_2();
                      /* _motivo2 := "" */
                      _motivo2 = "";
                      /* If _datnas <> personbo->DATANASC */
                      if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                        /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                        _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                      } // End If
                      /* If _provnas <> personbo->TIPINTER */
                      if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                        /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                        _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                      } // End If
                      /* If _sesso <> personbo->SESSO */
                      if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                        /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                        _motivo2 = _motivo2+"++  Sesso"+"\n";
                      } // End If
                      /* If not(Empty(_comnas)) */
                      if ( ! (CPLib.Empty(_comnas))) {
                        /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                        if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                          /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                          _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If not(Empty(_naznas)) */
                      if ( ! (CPLib.Empty(_naznas))) {
                        /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                        if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                          /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                          _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If Len(LRTrim(_motivo2)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                        /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                        _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                      } // End If
                    } else { // Else
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000261")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000261(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000026B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000026B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } // End If
            } // End If
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"ADATA,CONNESINT ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        /* If Empty(aeoprig->ADATA) or Empty(aeoprig->CONNESINT) or Empty(aeoprig->TIPOAG) or Empty(aeoprig->COINT) */
        if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA")) || CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(aeoprig->CONNESINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT"))) {
            /* _motivo := _motivo + "-- Codice Cliente"+NL */
            _motivo = _motivo+"-- Codice Cliente"+"\n";
          } // End If
          /* If Empty(aeoprig->ADATA) */
          if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA"))) {
            /* _motivo := _motivo + "-- Data Apertura"+NL */
            _motivo = _motivo+"-- Data Apertura"+"\n";
          } // End If
          /* If Empty(aeoprig->TIPOAG) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG"))) {
            /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
            _motivo = _motivo+"-- Tipo Rapporto"+"\n";
          } // End If
          /* If Empty(aeoprig->COINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
            /* _motivo := _motivo + "-- Natura"+NL */
            _motivo = _motivo+"-- Natura"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000278")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000278(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 7-03 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } // End If
        /* _codper := '' */
        _codper = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codper = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codper = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codper)) */
        if (CPLib.Empty(CPLib.LRTrim(_codper))) {
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000027C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000027C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_aeoprig.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        } else { // Else
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _motivo := '' */
            _motivo = "";
            /* If personbo->CFESTERO=1 */
            if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASSTATO))='ITALIA' or Upper(LRTrim(personbo->NASSTATO))='ITALY') and Empty(LRTrim(personbo->NASCOMUN)) */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                    /* _motivo := _motivo + "--  Comune di nascita"+NL */
                    _motivo = _motivo+"--  Comune di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASCOMUN))='ITALIA' or Upper(LRTrim(personbo->NASCOMUN))='ITALY')  */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALY"))) {
                    /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                    _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  /* If not(Empty(LRTrim(_motivo))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo)))) {
                    /* _motivo := "Non valorizzato: "+NL + _motivo */
                    _motivo = "Non valorizzato: "+"\n"+_motivo;
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000294")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000294(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  /* If not(Empty(LRTrim(_motivo))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo)))) {
                    /* _motivo := "Non valorizzato: "+NL + _motivo */
                    _motivo = "Non valorizzato: "+"\n"+_motivo;
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000029E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000029E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
            } else { // Else
              /* If Len(LRTrim(personbo->CODFISC)) = 16 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* If Empty(personbo->COGNOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                    /* _motivo := _motivo + "--  Cognome"+NL */
                    _motivo = _motivo+"--  Cognome"+"\n";
                  } // End If
                  /* If Empty(personbo->NOME) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                    /* _motivo := _motivo + "--  Nome"+NL */
                    _motivo = _motivo+"--  Nome"+"\n";
                  } // End If
                  /* If Empty(personbo->SESSO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                    /* _motivo := _motivo + "--  Sesso"+NL */
                    _motivo = _motivo+"--  Sesso"+"\n";
                  } // End If
                  /* If Empty(personbo->DATANASC) */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                    /* _motivo := _motivo + "--  Data di nascita"+NL */
                    _motivo = _motivo+"--  Data di nascita"+"\n";
                  } // End If
                  /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                  if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                    /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                    _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASSTATO))='ITALIA' or Upper(LRTrim(personbo->NASSTATO))='ITALY') and Empty(LRTrim(personbo->NASCOMUN)) */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                    /* _motivo := _motivo + "--  Comune di nascita"+NL */
                    _motivo = _motivo+"--  Comune di nascita"+"\n";
                  } // End If
                  /* If (Upper(LRTrim(personbo->NASCOMUN))='ITALIA' or Upper(LRTrim(personbo->NASCOMUN))='ITALY')  */
                  if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALY"))) {
                    /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                    _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                  } // End If
                  /* If Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                } // End If
                /* If w_chkcfis='S' */
                if (CPLib.eqr(w_chkcfis,"S")) {
                  /* If arfn_chkcodfis(Upper(personbo->CODFISC),'086',personbo->CFESTERO) */
                  if (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_personbo.GetString("CODFISC")),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                    /* w_CODFISC := '' // Codice Fiscale */
                    w_CODFISC = "";
                    /* w_DATANASC := NullDate() // Data Nascita */
                    w_DATANASC = CPLib.NullDate();
                    /* w_NASCOMUN := '' // Luogo di Nascita */
                    w_NASCOMUN = "";
                    /* w_NASSTATO := '' // Stato di nascita */
                    w_NASSTATO = "";
                    /* w_COGNOME := '' // Ragione Sociale */
                    w_COGNOME = "";
                    /* w_RAGSOC := '' // Ragione Sociale */
                    w_RAGSOC = "";
                    /* w_NOME := '' // Ragione Sociale */
                    w_NOME = "";
                    /* w_SESSO := '' // Sesso */
                    w_SESSO = "";
                    /* w_DATANASC := personbo->DATANASC // Data Nascita */
                    w_DATANASC = Cursor_personbo.GetDate("DATANASC");
                    /* w_NASCOMUN := personbo->NASCOMUN // Luogo di Nascita */
                    w_NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                    /* w_NASSTATO := personbo->NASSTATO // Stato di nascita */
                    w_NASSTATO = Cursor_personbo.GetString("NASSTATO");
                    /* w_COGNOME := personbo->COGNOME // Ragione Sociale */
                    w_COGNOME = Cursor_personbo.GetString("COGNOME");
                    /* w_RAGSOC := personbo->RAGSOC // Ragione Sociale */
                    w_RAGSOC = Cursor_personbo.GetString("RAGSOC");
                    /* w_NOME := personbo->NOME // Ragione Sociale */
                    w_NOME = Cursor_personbo.GetString("NOME");
                    /* w_SESSO := personbo->SESSO // Sesso */
                    w_SESSO = Cursor_personbo.GetString("SESSO");
                    /* Exec Routine arrt_calccodfis */
                    arrt_calccodfisR.Make(m_Ctx,this).Run();
                    /* _codfisc := Upper(personbo->CODFISC) */
                    _codfisc = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                    /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                    Page_2();
                    /* _motivo2 := "" */
                    _motivo2 = "";
                    /* If not(Empty(w_CODFISC)) */
                    if ( ! (CPLib.Empty(w_CODFISC))) {
                      /* If Left(_codfisc,3) <> Left(w_CODFISC,3) */
                      if (CPLib.ne(CPLib.Left(_codfisc,3),CPLib.Left(w_CODFISC,3))) {
                        /* _motivo2 := _motivo2 + "++ Cognome"+NL */
                        _motivo2 = _motivo2+"++ Cognome"+"\n";
                      } // End If
                      /* If Substr(_codfisc,4,3) <> Substr(w_CODFISC,4,3) */
                      if (CPLib.ne(CPLib.Substr(_codfisc,4,3),CPLib.Substr(w_CODFISC,4,3))) {
                        /* _motivo2 := _motivo2 + "++ Nome"+NL */
                        _motivo2 = _motivo2+"++ Nome"+"\n";
                      } // End If
                    } // End If
                    /* If _datnas <> personbo->DATANASC */
                    if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                      _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                    } // End If
                    /* If _provnas <> personbo->TIPINTER */
                    if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                      _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                    } // End If
                    /* If _sesso <> personbo->SESSO */
                    if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                      _motivo2 = _motivo2+"++  Sesso"+"\n";
                    } // End If
                    /* If not(Empty(_comnas)) */
                    if ( ! (CPLib.Empty(_comnas))) {
                      /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                      if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                        /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                        _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                      } // End If
                    } // End If
                    /* If not(Empty(_naznas)) */
                    if ( ! (CPLib.Empty(_naznas))) {
                      /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                      if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                        _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                      } // End If
                    } // End If
                    /* If Len(LRTrim(_motivo2)) > 0 */
                    if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                      /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                      _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                    } // End If
                  } else { // Else
                    /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                    _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                  } // End If
                } // End If
                /* If not(Empty(LRTrim(_motivo))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo)))) {
                  /* _motivo := "Non valorizzato: "+NL + _motivo */
                  _motivo = "Non valorizzato: "+"\n"+_motivo;
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000002E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002E0(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } // End If
              } else { // Else
                /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                  /* If Empty(personbo->RAGSOC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                    /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                    _motivo = _motivo+"--  Ragione Sociale"+"\n";
                  } // End If
                  /* If Empty(personbo->DESCCIT) */
                  if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                    /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                    _motivo = _motivo+"--  Città Sede Legale"+"\n";
                  } // End If
                  /* If Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                    _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                    _motivo = _motivo+"--  Codice Fiscale"+"\n";
                  } // End If
                  /* If not(Empty(LRTrim(_motivo))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo)))) {
                    /* _motivo := "Non valorizzato: "+NL + _motivo */
                    _motivo = "Non valorizzato: "+"\n"+_motivo;
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000002EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002EC(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
            } // End If
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_aederig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_aeoprig=null;
    try {
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+")  or  (CDATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  CDATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* If Empty(aederig->AFILE) and Empty(aederig->CFILE) */
        if (CPLib.Empty(Cursor_aederig.GetString("AFILE")) && CPLib.Empty(Cursor_aederig.GetString("CFILE"))) {
          /* If Empty(aederig->ADATA) or Empty(aederig->CONNESINT) or Empty(aederig->RAPPORTO) */
          if (CPLib.Empty(Cursor_aederig.GetDate("ADATA")) || CPLib.Empty(Cursor_aederig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
            /* _motivo := "Non valorizzato:"+NL */
            _motivo = "Non valorizzato:"+"\n";
            /* If Empty(aederig->CONNESINT) */
            if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
              /* _motivo := _motivo + "-- Codice Intestatario"+NL */
              _motivo = _motivo+"-- Codice Intestatario"+"\n";
            } // End If
            /* If Empty(aederig->ADATA) */
            if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
              /* _motivo := _motivo + "-- Data Apertura"+NL */
              _motivo = _motivo+"-- Data Apertura"+"\n";
            } // End If
            /* If Empty(aederig->RAPPORTO) */
            if (CPLib.Empty(Cursor_aederig.GetString("RAPPORTO"))) {
              /* _motivo := _motivo + "-- Codice Rapporto"+NL */
              _motivo = _motivo+"-- Codice Rapporto"+"\n";
            } // End If
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000002F8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000002F8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
          /* _codrap := '' */
          _codrap = "";
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_codrap))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000002FC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000002FC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            // * --- Select from aederig
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            if (Cursor_aederig!=null)
              Cursor_aederig.Close();
            Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO=RAPPORTO "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aederig.Eof())) {
              /* If Empty(aederig->TIPOAG) or Empty(aederig->COINT) */
              if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
                /* _motivo := "Non valorizzato:"+NL */
                _motivo = "Non valorizzato:"+"\n";
                /* If Empty(aederig->TIPOAG) */
                if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
                  /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                  _motivo = _motivo+"-- Tipo Rapporto"+"\n";
                } // End If
                /* If Empty(aederig->COINT) */
                if (CPLib.Empty(Cursor_aederig.GetString("COINT"))) {
                  /* _motivo := _motivo + "-- Natura"+NL */
                  _motivo = _motivo+"-- Natura"+"\n";
                } // End If
                // * --- Insert into tmp_stpverage_do from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000304")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000304(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati testa","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
              } // End If
              Cursor_aederig.Next();
            }
            m_cConnectivityError = Cursor_aederig.ErrorMessage();
            Cursor_aederig.Close();
            // * --- End Select
          } // End If
          /* _codper := '' */
          _codper = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codper = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codper = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codper)) */
          if (CPLib.Empty(CPLib.LRTrim(_codper))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000308")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000308(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aederig.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If personbo->CFESTERO=1 */
              if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
                /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or Empty(personbo->NASCOMUN) or Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000031A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000031A(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000322")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000322(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } else { // Else
                /* If Len(LRTrim(personbo->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If w_chkcfis='S' */
                    if (CPLib.eqr(w_chkcfis,"S")) {
                      /* If arfn_chkcodfis(personbo->CODFISC,'086',personbo->CFESTERO) */
                      if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                        /* _codfisc := personbo->CODFISC */
                        _codfisc = Cursor_personbo.GetString("CODFISC");
                        /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                        Page_2();
                        /* _motivo2 := "" */
                        _motivo2 = "";
                        /* If _datnas <> personbo->DATANASC */
                        if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                          /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                          _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                        } // End If
                        /* If _provnas <> personbo->TIPINTER */
                        if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                          /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                          _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                        } // End If
                        /* If _sesso <> personbo->SESSO */
                        if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                          /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                          _motivo2 = _motivo2+"++  Sesso"+"\n";
                        } // End If
                        /* If not(Empty(_comnas)) */
                        if ( ! (CPLib.Empty(_comnas))) {
                          /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                          if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                            /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                            _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                          } // End If
                        } // End If
                        /* If not(Empty(_naznas)) */
                        if ( ! (CPLib.Empty(_naznas))) {
                          /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                          if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                            /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                            _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                          } // End If
                        } // End If
                        /* If Len(LRTrim(_motivo2)) > 0 */
                        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                          /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                          _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                        } // End If
                      } else { // Else
                        /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                        _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                      } // End If
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000348")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000348(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000352")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000352(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"ADATA,CONNESINT ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        /* If Empty(aeoprig->AFILE) */
        if (CPLib.Empty(Cursor_aeoprig.GetString("AFILE"))) {
          /* If Empty(aeoprig->ADATA) or Empty(aeoprig->CONNESINT) or Empty(aeoprig->TIPOAG) or Empty(aeoprig->COINT) */
          if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA")) || CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT")) || CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG")) || CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
            /* _motivo := "Non valorizzato:"+NL */
            _motivo = "Non valorizzato:"+"\n";
            /* If Empty(aeoprig->CONNESINT) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT"))) {
              /* _motivo := _motivo + "-- Codice Cliente"+NL */
              _motivo = _motivo+"-- Codice Cliente"+"\n";
            } // End If
            /* If Empty(aeoprig->ADATA) */
            if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA"))) {
              /* _motivo := _motivo + "-- Data Apertura"+NL */
              _motivo = _motivo+"-- Data Apertura"+"\n";
            } // End If
            /* If Empty(aeoprig->TIPOAG) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG"))) {
              /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
              _motivo = _motivo+"-- Tipo Rapporto"+"\n";
            } // End If
            /* If Empty(aeoprig->COINT) */
            if (CPLib.Empty(Cursor_aeoprig.GetString("COINT"))) {
              /* _motivo := _motivo + "-- Natura"+NL */
              _motivo = _motivo+"-- Natura"+"\n";
            } // End If
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000360")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000360(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 7-03 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } // End If
          /* _codper := '' */
          _codper = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codper = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage_do returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codper = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codper)) */
          if (CPLib.Empty(CPLib.LRTrim(_codper))) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000364")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000364(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_aeoprig.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          } else { // Else
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If personbo->CFESTERO=1 */
              if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
                /* If not(Empty(personbo->COGNOME)) or not(Empty(personbo->NOME)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"00000376")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000376(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"0000037E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000037E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } else { // Else
                /* If Len(LRTrim(personbo->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
                  /* If Empty(personbo->COGNOME) or Empty(personbo->NOME) or Empty(personbo->SESSO) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->TIPINTER) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.Empty(Cursor_personbo.GetString("SESSO")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(personbo->COGNOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(personbo->NOME) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(personbo->SESSO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(personbo->DATANASC) */
                    if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO) */
                    if (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(personbo->NASSTATO))='ITALIA' or Upper(LRTrim(personbo->NASSTATO))='ITALY') and Empty(LRTrim(personbo->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(personbo->NASCOMUN))='ITALIA' or Upper(LRTrim(personbo->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(personbo->TIPINTER) */
                    if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If arfn_chkcodfis(Upper(personbo->CODFISC),'086',personbo->CFESTERO) */
                    if (arfn_chkcodfisR.Make(m_Ctx,this).Run(CPLib.Upper(Cursor_personbo.GetString("CODFISC")),"086",Cursor_personbo.GetDouble("CFESTERO"))) {
                      /* w_CODFISC := '' // Codice Fiscale */
                      w_CODFISC = "";
                      /* w_DATANASC := NullDate() // Data Nascita */
                      w_DATANASC = CPLib.NullDate();
                      /* w_NASCOMUN := '' // Luogo di Nascita */
                      w_NASCOMUN = "";
                      /* w_NASSTATO := '' // Stato di nascita */
                      w_NASSTATO = "";
                      /* w_COGNOME := '' // Ragione Sociale */
                      w_COGNOME = "";
                      /* w_RAGSOC := '' // Ragione Sociale */
                      w_RAGSOC = "";
                      /* w_NOME := '' // Ragione Sociale */
                      w_NOME = "";
                      /* w_SESSO := '' // Sesso */
                      w_SESSO = "";
                      /* w_DATANASC := personbo->DATANASC // Data Nascita */
                      w_DATANASC = Cursor_personbo.GetDate("DATANASC");
                      /* w_NASCOMUN := personbo->NASCOMUN // Luogo di Nascita */
                      w_NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      /* w_NASSTATO := personbo->NASSTATO // Stato di nascita */
                      w_NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      /* w_COGNOME := personbo->COGNOME // Ragione Sociale */
                      w_COGNOME = Cursor_personbo.GetString("COGNOME");
                      /* w_RAGSOC := personbo->RAGSOC // Ragione Sociale */
                      w_RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      /* w_NOME := personbo->NOME // Ragione Sociale */
                      w_NOME = Cursor_personbo.GetString("NOME");
                      /* w_SESSO := personbo->SESSO // Sesso */
                      w_SESSO = Cursor_personbo.GetString("SESSO");
                      /* Exec Routine arrt_calccodfis */
                      arrt_calccodfisR.Make(m_Ctx,this).Run();
                      /* _codfisc := Upper(personbo->CODFISC) */
                      _codfisc = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                      /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                      Page_2();
                      /* _motivo2 := "" */
                      _motivo2 = "";
                      /* If not(Empty(w_CODFISC)) */
                      if ( ! (CPLib.Empty(w_CODFISC))) {
                        /* If Left(_codfisc,3) <> Left(w_CODFISC,3) */
                        if (CPLib.ne(CPLib.Left(_codfisc,3),CPLib.Left(w_CODFISC,3))) {
                          /* _motivo2 := _motivo2 + "++ Cognome"+NL */
                          _motivo2 = _motivo2+"++ Cognome"+"\n";
                        } // End If
                        /* If Substr(_codfisc,4,3) <> Substr(w_CODFISC,4,3) */
                        if (CPLib.ne(CPLib.Substr(_codfisc,4,3),CPLib.Substr(w_CODFISC,4,3))) {
                          /* _motivo2 := _motivo2 + "++ Nome"+NL */
                          _motivo2 = _motivo2+"++ Nome"+"\n";
                        } // End If
                      } // End If
                      /* If _datnas <> personbo->DATANASC */
                      if (CPLib.ne(_datnas,Cursor_personbo.GetDate("DATANASC"))) {
                        /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                        _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                      } // End If
                      /* If _provnas <> personbo->TIPINTER */
                      if (CPLib.ne(_provnas,Cursor_personbo.GetString("TIPINTER"))) {
                        /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                        _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                      } // End If
                      /* If _sesso <> personbo->SESSO */
                      if (CPLib.ne(_sesso,Cursor_personbo.GetString("SESSO"))) {
                        /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                        _motivo2 = _motivo2+"++  Sesso"+"\n";
                      } // End If
                      /* If not(Empty(_comnas)) */
                      if ( ! (CPLib.Empty(_comnas))) {
                        /* If LRTrim(_comnas) <> LRTrim(personbo->NASCOMUN) */
                        if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")))) {
                          /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                          _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If not(Empty(_naznas)) */
                      if ( ! (CPLib.Empty(_naznas))) {
                        /* If LRTrim(_naznas) <> LRTrim(personbo->NASSTATO) */
                        if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")))) {
                          /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                          _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If Len(LRTrim(_motivo2)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                        /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                        _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                      } // End If
                    } else { // Else
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000003C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000003C0(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } else { // Else
                  /* If Empty(personbo->RAGSOC) or Empty(personbo->DESCCIT) or Empty(personbo->PROVINCIA) or Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC")) || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* If Empty(personbo->RAGSOC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(personbo->DESCCIT) */
                    if (CPLib.Empty(Cursor_personbo.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(personbo->PROVINCIA) */
                    if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(personbo->CODFISC) */
                    if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage_do from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do",68,"000003CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000003CA(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                  } // End If
                } // End If
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* _motivo := '' */
        _motivo = "";
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("cdadata","C",8,0,w_cdadata);
      m_Caller.SetString("chkcfis","C",1,0,w_chkcfis);
      m_Caller.SetString("noninvio","C",1,0,w_noninvio);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpverage_doR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpverage_doR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_cdadata = m_Caller.GetString("cdadata","C",8,0);
    w_chkcfis = m_Caller.GetString("chkcfis","C",1,0);
    w_noninvio = m_Caller.GetString("noninvio","C",1,0);
    _motivo = "";
    _codrap = CPLib.Space(25);
    _codper = CPLib.Space(16);
    _datnas = CPLib.NullDate();
    _provnas = CPLib.Space(2);
    _comnas = CPLib.Space(40);
    _naznas = CPLib.Space(40);
    _mesnas = CPLib.Space(2);
    _gionas = CPLib.Space(2);
    _annnas = CPLib.Space(4);
    _sesso = CPLib.Space(1);
    _codfisc = CPLib.Space(16);
    _cmesi = CPLib.Space(12);
    _pos = 0;
    _motivo2 = "";
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_fdate,arrt_calccodfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_fdate,arrt_calccodfis,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000064(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000068(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000082(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000129(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000135(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000139(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000140(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000144(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000156(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000184(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001B3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001BB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000207(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000212(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000216(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000221(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000233(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000261(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000278(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000294(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002FC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000304(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000308(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000031A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000322(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000348(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000352(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000360(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000364(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000376(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000037E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
}
