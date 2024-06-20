// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_deletefileR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_aefiles_glob;
  public String m_cServer_aefiles_glob;
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
  public String w_idfile;
  public double _aperte;
  public double _chiuse;
  public double _cancellate;
  public double _rettificate;
  public String _nomefile;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_deletefileR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_deletefile",m_Caller);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_aefiles_glob = p_ContextObject.GetPhName("aefiles_glob");
    if (m_cPhName_aefiles_glob.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles_glob = m_cPhName_aefiles_glob+" "+m_Ctx.GetWritePhName("aefiles_glob");
    }
    m_cServer_aefiles_glob = p_ContextObject.GetServer("aefiles_glob");
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
    if (CPLib.eqr("_rettificate",p_cVarName)) {
      return _rettificate;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_deletefile";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      return w_idfile;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("_rettificate",p_cVarName)) {
      _rettificate = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      w_idfile = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
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
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_aecanc=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_nomefile Char(20) */
      /* w_idfile Char(10) */
      /* Definizione variabili locali */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _rettificate Numeric(10, 0) */
      /* _nomefile Char(20) */
      /* Dichiarazione variabili globali */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* Prima conta poi cancella */
      /* _nomefile := Left(w_nomefile,15) */
      _nomefile = CPLib.Left(w_nomefile,15);
      /* _aperte := 0 */
      _aperte = CPLib.Round(0,0);
      /* If Right(_nomefile,1)='7' */
      if (CPLib.eqr(CPLib.Right(_nomefile,1),"7")) {
        // * --- Delete from aefiles_glob
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles_glob");
        m_cPhName = m_Ctx.GetPhName("aefiles_glob");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_glob",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"00000011")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idfile,"?",0,0,m_cServer),m_cServer,w_idfile)+"";
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
      } else { // Else
        // * --- Select from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
        Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  and  ASPEDITO=1 "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aerighe.Eof())) {
          /* _aperte := _aperte + 1 */
          _aperte = CPLib.Round(_aperte+1,0);
          Cursor_aerighe.Next();
        }
        m_cConnectivityError = Cursor_aerighe.ErrorMessage();
        Cursor_aerighe.Close();
        // * --- End Select
        /* _chiuse := 0 */
        _chiuse = CPLib.Round(0,0);
        // * --- Select from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
        Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  and  CSPEDITO=1 "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aerighe.Eof())) {
          /* _chiuse := _chiuse + 1 */
          _chiuse = CPLib.Round(_chiuse+1,0);
          Cursor_aerighe.Next();
        }
        m_cConnectivityError = Cursor_aerighe.ErrorMessage();
        Cursor_aerighe.Close();
        // * --- End Select
        /* _rettificate := 0 */
        _rettificate = CPLib.Round(0,0);
        // * --- Select from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
        Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  and  RSPEDITO=1 "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aerighe.Eof())) {
          /* _rettificate := _rettificate+1 */
          _rettificate = CPLib.Round(_rettificate+1,0);
          Cursor_aerighe.Next();
        }
        m_cConnectivityError = Cursor_aerighe.ErrorMessage();
        Cursor_aerighe.Close();
        // * --- End Select
        /* _cancellate := 0 */
        _cancellate = CPLib.Round(0,0);
        // * --- Select from aecanc
        m_cServer = m_Ctx.GetServer("aecanc");
        m_cPhName = m_Ctx.GetPhName("aecanc");
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
        Cursor_aecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aecanc.Eof())) {
          /* _cancellate := _cancellate + 1 */
          _cancellate = CPLib.Round(_cancellate+1,0);
          Cursor_aecanc.Next();
        }
        m_cConnectivityError = Cursor_aecanc.ErrorMessage();
        Cursor_aecanc.Close();
        // * --- End Select
        /* If _aperte + _chiuse + _cancellate+_rettificate > 0 */
        if (CPLib.gt(_aperte+_chiuse+_cancellate+_rettificate,0)) {
          /* If _aperte > 0 */
          if (CPLib.gt(_aperte,0)) {
            // * --- Write into aerighe from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"APROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
            /* gMsgImp := "Informazioni Apertura: "+ LRTrim(Str(_aperte,10,0)) // Messaggio Import */
            gMsgImp = "Informazioni Apertura: "+CPLib.LRTrim(CPLib.Str(_aperte,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If _chiuse > 0 */
          if (CPLib.gt(_chiuse,0)) {
            // * --- Write into aerighe from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"00000022")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
            /* gMsgImp := "Informazioni Chiusura: "+ LRTrim(Str(_chiuse,10,0)) // Messaggio Import */
            gMsgImp = "Informazioni Chiusura: "+CPLib.LRTrim(CPLib.Str(_chiuse,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If _rettificate > 0 */
          if (CPLib.gt(_rettificate,0)) {
            // * --- Write into aerighe from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"00000025")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"COLDFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
            /* gMsgImp := "Informazioni Modificata: "+ LRTrim(Str(_rettificate,10,0)) // Messaggio Import */
            gMsgImp = "Informazioni Modificata: "+CPLib.LRTrim(CPLib.Str(_rettificate,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If _cancellate > 0 */
          if (CPLib.gt(_cancellate,0)) {
            // * --- Write into aecanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aecanc");
            m_cPhName = m_Ctx.GetPhName("aecanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aecanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"00000028")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"SPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"IDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aecanc",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
            /* gMsgImp := "Informazioni Cancellazione: "+ LRTrim(Str(_cancellate,10,0)) // Messaggio Import */
            gMsgImp = "Informazioni Cancellazione: "+CPLib.LRTrim(CPLib.Str(_cancellate,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          // * --- Delete from aefiles_glob
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefiles_glob");
          m_cPhName = m_Ctx.GetPhName("aefiles_glob");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_glob",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile",18,"0000002A")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idfile,"?",0,0,m_cServer),m_cServer,w_idfile)+"";
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
        } else { // Else
          /* gMsgImp := "Non sono state trovate informazioni relative al file selezionato" // Messaggio Import */
          gMsgImp = "Non sono state trovate informazioni relative al file selezionato";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
      } // End If
      /* gMsgImp := "Elaborazione Terminata" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
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
      m_Caller.SetString("nomefile","C",20,0,w_nomefile);
      m_Caller.SetString("idfile","C",10,0,w_idfile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_deletefileR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_deletefileR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",20,0);
    w_idfile = m_Caller.GetString("idfile","C",10,0);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _rettificate = 0;
    _nomefile = CPLib.Space(20);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
