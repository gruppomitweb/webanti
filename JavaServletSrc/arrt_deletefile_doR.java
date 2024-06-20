// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_deletefile_doR implements CallerWithObjs {
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
  public String w_logoperaz;
  public String w_idfile;
  public double _aperte;
  public double _chiuse;
  public double _cancellate;
  public double _rettifiche;
  public String _nomefile;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_deletefile_doR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_deletefile_do",m_Caller);
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
    if (CPLib.eqr("_rettifiche",p_cVarName)) {
      return _rettifiche;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_deletefile_do";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("logoperaz",p_cVarName)) {
      return w_logoperaz;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("_rettifiche",p_cVarName)) {
      _rettifiche = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("logoperaz",p_cVarName)) {
      w_logoperaz = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
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
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_aedecanc=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Cursor_aeopcanc=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_nomefile Char(20) */
      /* w_logoperaz Memo */
      /* w_idfile Char(10) */
      /* Dichiarazione variabili locali */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _rettifiche Numeric(10, 0) */
      /* _nomefile Char(20) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* Prima conta poi cancella */
      /* _nomefile := Left(w_nomefile,15) */
      _nomefile = CPLib.Left(w_nomefile,15);
      /* _aperte := 0 */
      _aperte = CPLib.Round(0,0);
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())+NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Elaborazione in corso" // Messaggio Import */
      gMsgImp = "Attendere. Elaborazione in corso";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If Right(_nomefile,1)='7' */
      if (CPLib.eqr(CPLib.Right(_nomefile,1),"7")) {
        // * --- Delete from aefile_do_glob
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefile_do_glob");
        m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefile_do_glob",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000014")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        /* gMsgImp := "Verifica presenza aperture deleghe" // Messaggio Import */
        gMsgImp = "Verifica presenza aperture deleghe";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  and  ASPEDITO=1 "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _aperte := _aperte + 1 */
          _aperte = CPLib.Round(_aperte+1,0);
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        /* _chiuse := 0 */
        _chiuse = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza chiusura deleghe" // Messaggio Import */
        gMsgImp = "Verifica presenza chiusura deleghe";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  and  CSPEDITO=1 "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _chiuse := _chiuse + 1 */
          _chiuse = CPLib.Round(_chiuse+1,0);
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        /* _rettifiche := 0 */
        _rettifiche = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza rettifica deleghe" // Messaggio Import */
        gMsgImp = "Verifica presenza rettifica deleghe";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _rettifiche := _rettifiche + 1 */
          _rettifiche = CPLib.Round(_rettifiche+1,0);
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        /* _cancellate := 0 */
        _cancellate = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza cancellazioni deleghe" // Messaggio Import */
        gMsgImp = "Verifica presenza cancellazioni deleghe";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aedecanc
        m_cServer = m_Ctx.GetServer("aedecanc");
        m_cPhName = m_Ctx.GetPhName("aedecanc");
        if (Cursor_aedecanc!=null)
          Cursor_aedecanc.Close();
        Cursor_aedecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aedecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aedecanc.Eof())) {
          /* _cancellate := _cancellate + 1 */
          _cancellate = CPLib.Round(_cancellate+1,0);
          Cursor_aedecanc.Next();
        }
        m_cConnectivityError = Cursor_aedecanc.ErrorMessage();
        Cursor_aedecanc.Close();
        // * --- End Select
        /* If _aperte + _chiuse + _rettifiche + _cancellate > 0 */
        if (CPLib.gt(_aperte+_chiuse+_rettifiche+_cancellate,0)) {
          /* If _aperte > 0 */
          if (CPLib.gt(_aperte,0)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000026")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"APROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
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
            /* gMsgProc := gMsgProc + "Modificate Informazioni Apertura Deleghe: "+ LRTrim(Str(_aperte,10,0)) + NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Apertura Deleghe: "+CPLib.LRTrim(CPLib.Str(_aperte,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If _chiuse > 0 */
          if (CPLib.gt(_chiuse,0)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000029")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
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
            /* gMsgProc := gMsgProc + "Modificate Informazioni Chiusura Deleghe: "+ LRTrim(Str(_chiuse,10,0)) + NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Chiusura Deleghe: "+CPLib.LRTrim(CPLib.Str(_chiuse,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If _rettifiche > 0 */
          if (CPLib.gt(_rettifiche,0)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
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
            /* gMsgProc := gMsgProc +"Modificate Informazioni Rettifiche Deleghe: "+ LRTrim(Str(_chiuse,10,0))+NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Rettifiche Deleghe: "+CPLib.LRTrim(CPLib.Str(_chiuse,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If _cancellate > 0 */
          if (CPLib.gt(_cancellate,0)) {
            // * --- Write into aedecanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aedecanc");
            m_cPhName = m_Ctx.GetPhName("aedecanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedecanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"0000002F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"SPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"IDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aedecanc",false,true);
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
            /* gMsgProc := gMsgProc +"Modificate Informazioni Cancellazione Deleghe: "+ LRTrim(Str(_cancellate,10,0))+NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Cancellazione Deleghe: "+CPLib.LRTrim(CPLib.Str(_cancellate,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } else { // Else
          /* gMsgProc := gMsgProc +"Non sono state trovate informazioni su deleghe relative al file selezionato"+NL // Messaggio */
          gMsgProc = gMsgProc+"Non sono state trovate informazioni su deleghe relative al file selezionato"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _aperte := 0 */
        _aperte = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza aperture operazioni extraconto" // Messaggio Import */
        gMsgImp = "Verifica presenza aperture operazioni extraconto";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
        Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeoprig.Eof())) {
          /* _aperte := _aperte + 1 */
          _aperte = CPLib.Round(_aperte+1,0);
          Cursor_aeoprig.Next();
        }
        m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
        Cursor_aeoprig.Close();
        // * --- End Select
        /* _chiuse := 0 */
        _chiuse = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza rettifiche operazioni extraconto" // Messaggio Import */
        gMsgImp = "Verifica presenza rettifiche operazioni extraconto";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
        Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeoprig.Eof())) {
          /* _chiuse := _chiuse + 1 */
          _chiuse = CPLib.Round(_chiuse+1,0);
          Cursor_aeoprig.Next();
        }
        m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
        Cursor_aeoprig.Close();
        // * --- End Select
        /* _cancellate := 0 */
        _cancellate = CPLib.Round(0,0);
        /* gMsgImp := "Verifica presenza cancellazioni operazioni extraconto" // Messaggio Import */
        gMsgImp = "Verifica presenza cancellazioni operazioni extraconto";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from aeopcanc
        m_cServer = m_Ctx.GetServer("aeopcanc");
        m_cPhName = m_Ctx.GetPhName("aeopcanc");
        if (Cursor_aeopcanc!=null)
          Cursor_aeopcanc.Close();
        Cursor_aeopcanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aeopcanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeopcanc.Eof())) {
          /* _cancellate := _cancellate + 1 */
          _cancellate = CPLib.Round(_cancellate+1,0);
          Cursor_aeopcanc.Next();
        }
        m_cConnectivityError = Cursor_aeopcanc.ErrorMessage();
        Cursor_aeopcanc.Close();
        // * --- End Select
        /* If _aperte + _chiuse + _cancellate > 0 */
        if (CPLib.gt(_aperte+_chiuse+_cancellate,0)) {
          /* If _aperte > 0 */
          if (CPLib.gt(_aperte,0)) {
            // * --- Write into aeoprig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeoprig");
            m_cPhName = m_Ctx.GetPhName("aeoprig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"APROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
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
            /* gMsgProc := gMsgProc + "Modificate Informazioni Apertura Op. Extraconto: "+ LRTrim(Str(_aperte,10,0)) +NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Apertura Op. Extraconto: "+CPLib.LRTrim(CPLib.Str(_aperte,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If _chiuse > 0 */
          if (CPLib.gt(_chiuse,0)) {
            // * --- Write into aeoprig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeoprig");
            m_cPhName = m_Ctx.GetPhName("aeoprig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000043")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
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
            /* gMsgImp := gMsgProc + "Modificate Informazioni Rettifica Op. Extraconto: "+ LRTrim(Str(_aperte,10,0)) +NL // Messaggio Import */
            gMsgImp = gMsgProc+"Modificate Informazioni Rettifica Op. Extraconto: "+CPLib.LRTrim(CPLib.Str(_aperte,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If _cancellate > 0 */
          if (CPLib.gt(_cancellate,0)) {
            // * --- Write into aeopcanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeopcanc");
            m_cPhName = m_Ctx.GetPhName("aeopcanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000046")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"SPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
            m_cSql = m_cSql+"IDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeopcanc",false,true);
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
            /* gMsgProc := gMsgProc + "Modificate Informazioni Cancellazione Op. Extraconto: "+ LRTrim(Str(_cancellate,10,0))+NL // Messaggio */
            gMsgProc = gMsgProc+"Modificate Informazioni Cancellazione Op. Extraconto: "+CPLib.LRTrim(CPLib.Str(_cancellate,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } else { // Else
          /* gMsgProc := gMsgProc +  "Non sono state trovate informazioni su operazioni extraconto relative al file selezionato"+NL // Messaggio */
          gMsgProc = gMsgProc+"Non sono state trovate informazioni su operazioni extraconto relative al file selezionato"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // * --- Delete from aefile_do_glob
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefile_do_glob");
        m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefile_do_glob",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_deletefile_do",26,"00000049")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      } // End If
      /* gMsgImp := "Elaborazione completata" // Messaggio Import */
      gMsgImp = "Elaborazione completata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())+NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aedecanc!=null)
          Cursor_aedecanc.Close();
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
      try {
        if (Cursor_aeopcanc!=null)
          Cursor_aeopcanc.Close();
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
      m_Caller.SetString("logoperaz","M",10,0,w_logoperaz);
      m_Caller.SetString("idfile","C",10,0,w_idfile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_deletefile_doR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_deletefile_doR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",20,0);
    w_logoperaz = m_Caller.GetString("logoperaz","M",10,0);
    w_idfile = m_Caller.GetString("idfile","C",10,0);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _rettifiche = 0;
    _nomefile = CPLib.Space(20);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
