// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_delete_import_numimp_checkR implements CallerWithObjs {
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
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
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
  public java.sql.Timestamp w_NUMIMP;
  public boolean rtn_var;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_delete_import_numimp_checkR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_delete_import_numimp_check",m_Caller);
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
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
      return "arfn_delete_import_numimp_check";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("NUMIMP",p_cVarName)) {
      return w_NUMIMP;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rtn_var",p_cVarName)) {
      return rtn_var;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("NUMIMP",p_cVarName)) {
      w_NUMIMP = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("rtn_var",p_cVarName)) {
      rtn_var = value;
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
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xiduciabo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_xerzistiope=null;
    try {
      /* w_NUMIMP DateTime */
      /* rtn_var Bool := False //  risponde alla domanda: ci sono elementi con tale numimp? */
      rtn_var = false;
      // * --- Select from xapotit
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      if (Cursor_xapotit!=null)
        Cursor_xapotit.Close();
      Cursor_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapotit.Eof())) {
        /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
        rtn_var = CPLib.eqr(rtn_var,true);
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_xapotit.Next();
      }
      m_cConnectivityError = Cursor_xapotit.ErrorMessage();
      Cursor_xapotit.Close();
      // * --- End Select
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xntestit
        m_cServer = m_Ctx.GetServer("xntestit");
        m_cPhName = m_Ctx.GetPhName("xntestit");
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
        Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestit.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xntestit.Next();
        }
        m_cConnectivityError = Cursor_xntestit.ErrorMessage();
        Cursor_xntestit.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xlientifrz
        m_cServer = m_Ctx.GetServer("xlientifrz");
        m_cPhName = m_Ctx.GetPhName("xlientifrz");
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
        Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientifrz.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xlientifrz.Next();
        }
        m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
        Cursor_xlientifrz.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xlientiope
        m_cServer = m_Ctx.GetServer("xlientiope");
        m_cPhName = m_Ctx.GetPhName("xlientiope");
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
        Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientiope.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xlientiope.Next();
        }
        m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
        Cursor_xlientiope.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xnarapbo
        m_cServer = m_Ctx.GetServer("xnarapbo");
        m_cPhName = m_Ctx.GetPhName("xnarapbo");
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
        Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP ="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xnarapbo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xnarapbo.Next();
        }
        m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
        Cursor_xnarapbo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xelegabo
        m_cServer = m_Ctx.GetServer("xelegabo");
        m_cPhName = m_Ctx.GetPhName("xelegabo");
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
        Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xelegabo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xelegabo.Next();
        }
        m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
        Cursor_xelegabo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xiduciabo
        m_cServer = m_Ctx.GetServer("xiduciabo");
        m_cPhName = m_Ctx.GetPhName("xiduciabo");
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
        Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xiduciabo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xiduciabo.Next();
        }
        m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
        Cursor_xiduciabo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xapopebo
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
        Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xapopebo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xapopebo.Next();
        }
        m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
        Cursor_xapopebo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
        Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP ="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xperazbo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
        Cursor_xperazbo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xraziobo
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
        Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xraziobo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xraziobo.Next();
        }
        m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
        Cursor_xraziobo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xelegabo
        m_cServer = m_Ctx.GetServer("xelegabo");
        m_cPhName = m_Ctx.GetPhName("xelegabo");
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
        Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xelegabo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xelegabo.Next();
        }
        m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
        Cursor_xelegabo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xogopebo
        m_cServer = m_Ctx.GetServer("xogopebo");
        m_cPhName = m_Ctx.GetPhName("xogopebo");
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
        Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopebo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xogopebo.Next();
        }
        m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
        Cursor_xogopebo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xoginfo
        m_cServer = m_Ctx.GetServer("xoginfo");
        m_cPhName = m_Ctx.GetPhName("xoginfo");
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
        Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xoginfo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xoginfo.Next();
        }
        m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
        Cursor_xoginfo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xeneficfrz
        m_cServer = m_Ctx.GetServer("xeneficfrz");
        m_cPhName = m_Ctx.GetPhName("xeneficfrz");
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
        Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficfrz.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xeneficfrz.Next();
        }
        m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
        Cursor_xeneficfrz.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xeneficope
        m_cServer = m_Ctx.GetServer("xeneficope");
        m_cPhName = m_Ctx.GetPhName("xeneficope");
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
        Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficope.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xeneficope.Next();
        }
        m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
        Cursor_xeneficope.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xiduciabo
        m_cServer = m_Ctx.GetServer("xiduciabo");
        m_cPhName = m_Ctx.GetPhName("xiduciabo");
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
        Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xiduciabo.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xiduciabo.Next();
        }
        m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
        Cursor_xiduciabo.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xerzistifrz
        m_cServer = m_Ctx.GetServer("xerzistifrz");
        m_cPhName = m_Ctx.GetPhName("xerzistifrz");
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
        Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistifrz.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xerzistifrz.Next();
        }
        m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
        Cursor_xerzistifrz.Close();
        // * --- End Select
      } // End If
      /* If not(rtn_var) */
      if ( ! (rtn_var)) {
        // * --- Select from xerzistiope
        m_cServer = m_Ctx.GetServer("xerzistiope");
        m_cPhName = m_Ctx.GetPhName("xerzistiope");
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
        Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMIMP,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMIMP)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistiope.Eof())) {
          /* rtn_var := rtn_var = True //  risponde alla domanda: ci sono elementi con tale numimp? */
          rtn_var = CPLib.eqr(rtn_var,true);
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_xerzistiope.Next();
        }
        m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
        Cursor_xerzistiope.Close();
        // * --- End Select
      } // End If
      /* Return rtn_var */
      throw new Stop(rtn_var);
    } finally {
      try {
        if (Cursor_xapotit!=null)
          Cursor_xapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Timestamp p_w_NUMIMP) {
    w_NUMIMP = p_w_NUMIMP;
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
  public boolean Run(java.sql.Timestamp p_w_NUMIMP) {
    w_NUMIMP = p_w_NUMIMP;
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
  public static arfn_delete_import_numimp_checkR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_delete_import_numimp_checkR(p_Ctx, p_Caller);
  }
  public static arfn_delete_import_numimp_checkR Make(CPContext p_Ctx) {
    return new arfn_delete_import_numimp_checkR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_NUMIMP = CPLib.NullDateTime();
    rtn_var = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_delete_import_numimp_check,
  public static final String i_InvokedRoutines = ",arfn_delete_import_numimp_check,";
  public static String[] m_cRunParameterNames={"w_NUMIMP"};
}
