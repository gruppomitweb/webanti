// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_riallineaR implements CallerWithObjs {
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
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
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
  public String w_rapage;
  public String w_rapuif;
  public String cProg;
  public String cIDBASE;
  public String cIdReg;
  public String cTipRap;
  public String cFlgRap;
  public double cPrgImp;
  public String gAzienda;
  public double _conta;
  public String gMsgAll;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_riallineaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_riallinea",m_Caller);
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      return cPrgImp;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_riallinea";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("rapage",p_cVarName)) {
      return w_rapage;
    }
    if (CPLib.eqr("rapuif",p_cVarName)) {
      return w_rapuif;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cIDBASE",p_cVarName)) {
      return cIDBASE;
    }
    if (CPLib.eqr("cIdReg",p_cVarName)) {
      return cIdReg;
    }
    if (CPLib.eqr("cTipRap",p_cVarName)) {
      return cTipRap;
    }
    if (CPLib.eqr("cFlgRap",p_cVarName)) {
      return cFlgRap;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      return gMsgAll;
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
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      cPrgImp = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("rapage",p_cVarName)) {
      w_rapage = value;
      return;
    }
    if (CPLib.eqr("rapuif",p_cVarName)) {
      w_rapuif = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cIDBASE",p_cVarName)) {
      cIDBASE = value;
      return;
    }
    if (CPLib.eqr("cIdReg",p_cVarName)) {
      cIdReg = value;
      return;
    }
    if (CPLib.eqr("cTipRap",p_cVarName)) {
      cTipRap = value;
      return;
    }
    if (CPLib.eqr("cFlgRap",p_cVarName)) {
      cFlgRap = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      gMsgAll = value;
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
    /* Dichiarazione variabili del caller */
    /* w_rapage Char(1) */
    /* w_rapuif Char(1) */
    /* Definizione Variabili locali */
    /* cProg Char(11) */
    /* cIDBASE Char(10) */
    /* cIdReg Char(20) */
    /* cTipRap Char(2) */
    /* cFlgRap Char(1) */
    /* cPrgImp Numeric(10, 0) */
    /* gAzienda Char(10) // Azienda */
    /* _conta Numeric(15, 0) */
    /* gMsgAll Char(120) // Messaggio allineamento 1 */
    /* -- */
    /* Crea il file appoggio */
    /* If w_rapuif = 'S' */
    if (CPLib.eqr(w_rapuif,"S")) {
      /* Exec "Rapporti UIC/UIF" Page 2 */
      Page_2();
    } // End If
    /* If w_rapage = 'S' */
    if (CPLib.eqr(w_rapage,"S")) {
      /* Exec "Rapporti AE" Page 3 */
      Page_3();
    } // End If
    /* gMsgAll := 'Riallineamento Rapporti Terminato' // Messaggio allineamento 1 */
    gMsgAll = "Riallineamento Rapporti Terminato";
    m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_rapopebo=null;
    try {
      /* Crea il file appoggio */
      /* gMsgAll := 'Lettura rapporti per riallineamento' // Messaggio allineamento 1 */
      gMsgAll = "Lettura rapporti per riallineamento";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from anarapbo
      m_cServer = m_Ctx.GetServer("anarapbo");
      m_cPhName = m_Ctx.GetPhName("anarapbo");
      if (Cursor_anarapbo!=null)
        Cursor_anarapbo.Close();
      Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_anarapbo.Eof())) {
        // * --- Select from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
        Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1')  and  (TIPOOPRAP='23'  or  TIPOOPRAP='26') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapopebo.Eof())) {
          /* Case rapopebo->TIPOOPRAP='23' */
          if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"23")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riallinea",50,"0000001B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("RAPPORTO"))+"";
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
            /* Case rapopebo->TIPOOPRAP='26' */
          } else if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riallinea",50,"0000001C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("RAPPORTO"))+"";
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
          } // End Case
          Cursor_rapopebo.Next();
        }
        m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
        Cursor_rapopebo.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgAll := 'Sono state riallineati '+LRTrim(Str(_conta,10,0))+' rapporti UIF' // Messaggio allineamento 1 */
        gMsgAll = "Sono state riallineati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" rapporti UIF";
        m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
        Cursor_anarapbo.Next();
      }
      m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
      Cursor_anarapbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_jnarapbo=null;
    CPResultSet Cursor_japopebo=null;
    try {
      /* Crea il file appoggio */
      /* gMsgAll := 'Lettura rapporti per riallineamento' // Messaggio allineamento 1 */
      gMsgAll = "Lettura rapporti per riallineamento";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from jnarapbo
      m_cServer = m_Ctx.GetServer("jnarapbo");
      m_cPhName = m_Ctx.GetPhName("jnarapbo");
      if (Cursor_jnarapbo!=null)
        Cursor_jnarapbo.Close();
      Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("jnarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jnarapbo.Eof())) {
        // * --- Select from japopebo
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
        Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_jnarapbo.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1')  and  (TIPOOPRAP='23'  or  TIPOOPRAP='26') "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_japopebo.Eof())) {
          /* Case japopebo->TIPOOPRAP='23' */
          if (CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"23")) {
            // * --- Write into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riallinea",50,"00000025")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_japopebo.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(Cursor_japopebo.GetString("NUMPROG"),"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_japopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_japopebo.GetString("RAPPORTO"))+"";
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
            /* Case japopebo->TIPOOPRAP='26' */
          } else if (CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"26")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riallinea",50,"00000026")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_japopebo.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(Cursor_japopebo.GetString("NUMPROG"),"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_japopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_japopebo.GetString("RAPPORTO"))+"";
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
          } // End Case
          Cursor_japopebo.Next();
        }
        m_cConnectivityError = Cursor_japopebo.ErrorMessage();
        Cursor_japopebo.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgAll := 'Sono state riallineati '+LRTrim(Str(_conta,10,0))+' rapporti AGE' // Messaggio allineamento 1 */
        gMsgAll = "Sono state riallineati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" rapporti AGE";
        m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
        Cursor_jnarapbo.Next();
      }
      m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
      Cursor_jnarapbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
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
      m_Caller.SetString("rapage","C",1,0,w_rapage);
      m_Caller.SetString("rapuif","C",1,0,w_rapuif);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_riallineaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_riallineaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_rapage = m_Caller.GetString("rapage","C",1,0);
    w_rapuif = m_Caller.GetString("rapuif","C",1,0);
    cProg = CPLib.Space(11);
    cIDBASE = CPLib.Space(10);
    cIdReg = CPLib.Space(20);
    cTipRap = CPLib.Space(2);
    cFlgRap = CPLib.Space(1);
    cPrgImp = 0;
    _conta = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgAll=m_Ctx.GetGlobalString("gMsgAll");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
