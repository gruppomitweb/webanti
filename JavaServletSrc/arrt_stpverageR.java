// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpverageR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stpverage;
  public String m_cServer_tmp_stpverage;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpverageR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpverage",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage")) {
      m_cPhName_tmp_stpverage = p_ContextObject.GetPhName("tmp_stpverage");
      if (m_cPhName_tmp_stpverage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpverage = m_cPhName_tmp_stpverage+" "+m_Ctx.GetWritePhName("tmp_stpverage");
      }
      m_cServer_tmp_stpverage = p_ContextObject.GetServer("tmp_stpverage");
    }
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
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
      return "arrt_stpverage";
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
    CPResultSet Cursor_aerighe=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_c_adata Char(8) */
      /* w_cdadata Char(8) */
      /* w_chkcfis Char(1) */
      /* w_noninvio Char(1) */
      /* Definizione variabili locali */
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
      /* Creazione file di appoggio */
      // * --- Drop temporary table tmp_stpverage
      if (m_Ctx.IsSharedTemp("tmp_stpverage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage");
      }
      // * --- Create temporary table tmp_stpverage
      if (m_Ctx.IsSharedTemp("tmp_stpverage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpverage");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpverage"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpverage");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpverage",m_cServer,"proto")),m_cPhName,"tmp_stpverage",m_Ctx);
      }
      m_cPhName_tmp_stpverage = m_cPhName;
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
          // * --- Insert into tmp_stpverage from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000027")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000027(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Mancano in Anagrafica Intermediario alcuni dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            // * --- Insert into tmp_stpverage from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000029")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000029(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 1-01 Anagrafica intermediario dati non congrui","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Valorizzato cod. fisc. intermediario in modo errato","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
      /* Cicla su aerighe e verifica tutto */
      /* If Empty(w_DaDatOpe) and Empty(w_ADatOpe) */
      if (CPLib.Empty(w_DaDatOpe) && CPLib.Empty(w_ADatOpe)) {
        /* If w_noninvio='N' */
        if (CPLib.eqr(w_noninvio,"N")) {
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aerighe")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If Empty(aerighe->ADATA) or Empty(aerighe->CONNESINT) or Empty(aerighe->RAPPORTO) */
            if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")) || CPLib.Empty(Cursor_aerighe.GetString("CONNESINT")) || CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
              /* _motivo := "Non valorizzato:"+NL */
              _motivo = "Non valorizzato:"+"\n";
              /* If Empty(aerighe->CONNESINT) */
              if (CPLib.Empty(Cursor_aerighe.GetString("CONNESINT"))) {
                /* _motivo := _motivo + "-- Codice Intestatario"+NL */
                _motivo = _motivo+"-- Codice Intestatario"+"\n";
              } // End If
              /* If Empty(aerighe->ADATA) */
              if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                /* _motivo := _motivo + "-- Data Apertura"+NL */
                _motivo = _motivo+"-- Data Apertura"+"\n";
              } // End If
              /* If Empty(aerighe->RAPPORTO) */
              if (CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                /* _motivo := _motivo + "-- Codice Rapporto"+NL */
                _motivo = _motivo+"-- Codice Rapporto"+"\n";
              } // End If
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000036")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000036(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            // * --- Read from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000003A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000003A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              // * --- Select from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              if (Cursor_aetesta!=null)
                Cursor_aetesta.Close();
              Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aetesta.Eof())) {
                /* If Empty(aetesta->TIPOAG) or Empty(aetesta->COINT) */
                if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG")) || CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(aetesta->TIPOAG) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG"))) {
                    /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                    _motivo = _motivo+"-- Tipo Rapporto"+"\n";
                  } // End If
                  /* If Empty(aetesta->COINT) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                    /* _motivo := _motivo + "-- Natura"+NL */
                    _motivo = _motivo+"-- Natura"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000042")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000042(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati testa","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                Cursor_aetesta.Next();
              }
              m_cConnectivityError = Cursor_aetesta.ErrorMessage();
              Cursor_aetesta.Close();
              // * --- End Select
            } // End If
            /* _codper := '' */
            _codper = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000046")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000046(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aerighe.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                          /* Exec "Ricava dati da codice fiscale" Page 2 */
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000086")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000086(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000090")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000090(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aerighe")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If Empty(aerighe->AFILE) and Empty(aerighe->CFILE) */
            if (CPLib.Empty(Cursor_aerighe.GetString("AFILE")) && CPLib.Empty(Cursor_aerighe.GetString("CFILE"))) {
              /* If Empty(aerighe->ADATA) or Empty(aerighe->CONNESINT) or Empty(aerighe->RAPPORTO) */
              if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")) || CPLib.Empty(Cursor_aerighe.GetString("CONNESINT")) || CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                /* _motivo := "Non valorizzato:"+NL */
                _motivo = "Non valorizzato:"+"\n";
                /* If Empty(aerighe->CONNESINT) */
                if (CPLib.Empty(Cursor_aerighe.GetString("CONNESINT"))) {
                  /* _motivo := _motivo + "-- Codice Intestatario"+NL */
                  _motivo = _motivo+"-- Codice Intestatario"+"\n";
                } // End If
                /* If Empty(aerighe->ADATA) */
                if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                  /* _motivo := _motivo + "-- Data Apertura"+NL */
                  _motivo = _motivo+"-- Data Apertura"+"\n";
                } // End If
                /* If Empty(aerighe->RAPPORTO) */
                if (CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                  /* _motivo := _motivo + "-- Codice Rapporto"+NL */
                  _motivo = _motivo+"-- Codice Rapporto"+"\n";
                } // End If
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000009C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000009C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codrap = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  /* If Empty(aetesta->TIPOAG) or Empty(aetesta->COINT) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG")) || CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(aetesta->TIPOAG) */
                    if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG"))) {
                      /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                      _motivo = _motivo+"-- Tipo Rapporto"+"\n";
                    } // End If
                    /* If Empty(aetesta->COINT) */
                    if (CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                      /* _motivo := _motivo + "-- Natura"+NL */
                      _motivo = _motivo+"-- Natura"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000A8(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati testa","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
              } // End If
              /* _codper := '' */
              _codper = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000AC(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aerighe.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000BE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000BE(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000C6(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                            /* Exec "Ricava dati da codice fiscale" Page 2 */
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000EC(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000000F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000F6(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
        } // End If
      } else { // Else
        /* If w_noninvio='N' */
        if (CPLib.eqr(w_noninvio,"N")) {
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+")  or  (CDATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  CDATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If Empty(aerighe->ADATA) or Empty(aerighe->CONNESINT) or Empty(aerighe->RAPPORTO) */
            if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")) || CPLib.Empty(Cursor_aerighe.GetString("CONNESINT")) || CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
              /* _motivo := "Non valorizzato:"+NL */
              _motivo = "Non valorizzato:"+"\n";
              /* If Empty(aerighe->CONNESINT) */
              if (CPLib.Empty(Cursor_aerighe.GetString("CONNESINT"))) {
                /* _motivo := _motivo + "-- Codice Intestatario"+NL */
                _motivo = _motivo+"-- Codice Intestatario"+"\n";
              } // End If
              /* If Empty(aerighe->ADATA) */
              if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                /* _motivo := _motivo + "-- Data Apertura"+NL */
                _motivo = _motivo+"-- Data Apertura"+"\n";
              } // End If
              /* If Empty(aerighe->RAPPORTO) */
              if (CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                /* _motivo := _motivo + "-- Codice Rapporto"+NL */
                _motivo = _motivo+"-- Codice Rapporto"+"\n";
              } // End If
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000103")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000103(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            // * --- Read from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000107")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000107(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              // * --- Select from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              if (Cursor_aetesta!=null)
                Cursor_aetesta.Close();
              Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aetesta.Eof())) {
                /* If Empty(aetesta->TIPOAG) or Empty(aetesta->COINT) */
                if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG")) || CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                  /* _motivo := "Non valorizzato:"+NL */
                  _motivo = "Non valorizzato:"+"\n";
                  /* If Empty(aetesta->TIPOAG) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG"))) {
                    /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                    _motivo = _motivo+"-- Tipo Rapporto"+"\n";
                  } // End If
                  /* If Empty(aetesta->COINT) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                    /* _motivo := _motivo + "-- Natura"+NL */
                    _motivo = _motivo+"-- Natura"+"\n";
                  } // End If
                  // * --- Insert into tmp_stpverage from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000010F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000010F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati testa","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                Cursor_aetesta.Next();
              }
              m_cConnectivityError = Cursor_aetesta.ErrorMessage();
              Cursor_aetesta.Close();
              // * --- End Select
            } // End If
            /* _codper := '' */
            _codper = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
              // * --- Insert into tmp_stpverage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpverage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000113")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000113(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aerighe.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000125")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000125(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000012D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000012D(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                          /* Exec "Ricava dati da codice fiscale" Page 2 */
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000153")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000153(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                      // * --- Insert into tmp_stpverage from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000015D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000015D(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+")  or  (CDATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DaDatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DaDatOpe)+"  and  CDATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ADatOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,w_ADatOpe)+") "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If Empty(aerighe->AFILE) and Empty(aerighe->CFILE) */
            if (CPLib.Empty(Cursor_aerighe.GetString("AFILE")) && CPLib.Empty(Cursor_aerighe.GetString("CFILE"))) {
              /* If Empty(aerighe->ADATA) or Empty(aerighe->CONNESINT) or Empty(aerighe->RAPPORTO) */
              if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")) || CPLib.Empty(Cursor_aerighe.GetString("CONNESINT")) || CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                /* _motivo := "Non valorizzato:"+NL */
                _motivo = "Non valorizzato:"+"\n";
                /* If Empty(aerighe->CONNESINT) */
                if (CPLib.Empty(Cursor_aerighe.GetString("CONNESINT"))) {
                  /* _motivo := _motivo + "-- Codice Intestatario"+NL */
                  _motivo = _motivo+"-- Codice Intestatario"+"\n";
                } // End If
                /* If Empty(aerighe->ADATA) */
                if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                  /* _motivo := _motivo + "-- Data Apertura"+NL */
                  _motivo = _motivo+"-- Data Apertura"+"\n";
                } // End If
                /* If Empty(aerighe->RAPPORTO) */
                if (CPLib.Empty(Cursor_aerighe.GetString("RAPPORTO"))) {
                  /* _motivo := _motivo + "-- Codice Rapporto"+NL */
                  _motivo = _motivo+"-- Codice Rapporto"+"\n";
                } // End If
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000169")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000169(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codrap = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000016D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000016D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente testa relativa alla riga","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia Dati Testa","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  /* If Empty(aetesta->TIPOAG) or Empty(aetesta->COINT) */
                  if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG")) || CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(aetesta->TIPOAG) */
                    if (CPLib.Empty(Cursor_aetesta.GetString("TIPOAG"))) {
                      /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                      _motivo = _motivo+"-- Tipo Rapporto"+"\n";
                    } // End If
                    /* If Empty(aetesta->COINT) */
                    if (CPLib.Empty(Cursor_aetesta.GetString("COINT"))) {
                      /* _motivo := _motivo + "-- Natura"+NL */
                      _motivo = _motivo+"-- Natura"+"\n";
                    } // End If
                    // * --- Insert into tmp_stpverage from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpverage");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000175")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000175(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("In 7-02 Anagrafica Rapporti Agenzia dati testa","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
              } // End If
              /* _codper := '' */
              _codper = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
                // * --- Insert into tmp_stpverage from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000179")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000179(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario del rapporto "+CPLib.LRTrim(Cursor_aerighe.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"0000018B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_0000018B(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"00000193")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000193(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                            /* Exec "Ricava dati da codice fiscale" Page 2 */
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000001B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000001B9(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
                        // * --- Insert into tmp_stpverage from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("tmp_stpverage");
                        m_cPhName = m_Ctx.GetPhName("tmp_stpverage");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage",35,"000001C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000001C3(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("In 3-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage",true);
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
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
        } // End If
      } // End If
      /* Stop Report */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_stpverage");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation");
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
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
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
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
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
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stpverage returns two or more records. This item should return only a record.");
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
  public static arrt_stpverageR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpverageR(p_Ctx, p_Caller);
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
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkcodfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000027(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000029(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000036(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000042(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000046(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000086(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000090(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000103(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000107(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000113(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000125(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000153(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000169(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000175(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000179(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000193(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage",true);
    return p_cSql;
  }
}
