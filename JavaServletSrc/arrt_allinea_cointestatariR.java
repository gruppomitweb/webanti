// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_cointestatariR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aedestor;
  public String m_cServer_aedestor;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public MemoryCursor_allineacoint_mcrdef mcValues;
  public String pTipo;
  public String pAgg;
  public String _bRitorno;
  public MemoryCursorRow_allineacoint_mcrdef _row;
  public double _criga;
  public double _gia202;
  public double _gia501;
  public double _old202;
  public double _old501;
  public double _gde501;
  public double _ode501;
  public String _apporap;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_allinea_cointestatariR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_cointestatari",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aedestor = p_ContextObject.GetPhName("aedestor");
    if (m_cPhName_aedestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedestor = m_cPhName_aedestor+" "+m_Ctx.GetWritePhName("aedestor");
    }
    m_cServer_aedestor = p_ContextObject.GetServer("aedestor");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    if (m_cPhName_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aestor = m_cPhName_aestor+" "+m_Ctx.GetWritePhName("aestor");
    }
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
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
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_criga",p_cVarName)) {
      return _criga;
    }
    if (CPLib.eqr("_gia202",p_cVarName)) {
      return _gia202;
    }
    if (CPLib.eqr("_gia501",p_cVarName)) {
      return _gia501;
    }
    if (CPLib.eqr("_old202",p_cVarName)) {
      return _old202;
    }
    if (CPLib.eqr("_old501",p_cVarName)) {
      return _old501;
    }
    if (CPLib.eqr("_gde501",p_cVarName)) {
      return _gde501;
    }
    if (CPLib.eqr("_ode501",p_cVarName)) {
      return _ode501;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_cointestatari";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pAgg",p_cVarName)) {
      return pAgg;
    }
    if (CPLib.eqr("_bRitorno",p_cVarName)) {
      return _bRitorno;
    }
    if (CPLib.eqr("_apporap",p_cVarName)) {
      return _apporap;
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
    if (CPLib.eqr("mcValues",p_cVarName)) {
      return mcValues;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_row",p_cVarName)) {
      return _row;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_criga",p_cVarName)) {
      _criga = value;
      return;
    }
    if (CPLib.eqr("_gia202",p_cVarName)) {
      _gia202 = value;
      return;
    }
    if (CPLib.eqr("_gia501",p_cVarName)) {
      _gia501 = value;
      return;
    }
    if (CPLib.eqr("_old202",p_cVarName)) {
      _old202 = value;
      return;
    }
    if (CPLib.eqr("_old501",p_cVarName)) {
      _old501 = value;
      return;
    }
    if (CPLib.eqr("_gde501",p_cVarName)) {
      _gde501 = value;
      return;
    }
    if (CPLib.eqr("_ode501",p_cVarName)) {
      _ode501 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pAgg",p_cVarName)) {
      pAgg = value;
      return;
    }
    if (CPLib.eqr("_bRitorno",p_cVarName)) {
      _bRitorno = value;
      return;
    }
    if (CPLib.eqr("_apporap",p_cVarName)) {
      _apporap = value;
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
    if (CPLib.eqr("_row",p_cVarName)) {
      _row = (MemoryCursorRow_allineacoint_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcValues",p_cVarName)) {
      mcValues = (MemoryCursor_allineacoint_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_jnarapbo=null;
    CPResultSet Cursor_jelegabo=null;
    try {
      /* mcValues MemoryCursor(AllineaCoint.MCRDef) // Cursore Provienente dalla portlet */
      /* pTipo Char(1) */
      /* pAgg Char(1) */
      /* _bRitorno Char(100) */
      /* _row Row(AllineaCoint.MCRDef) */
      /* _criga Numeric(3, 0) */
      /* _gia202 Numeric(1, 0) */
      /* _gia501 Numeric(1, 0) */
      /* _old202 Numeric(1, 0) */
      /* _old501 Numeric(1, 0) */
      /* _gde501 Numeric(1, 0) */
      /* _ode501 Numeric(1, 0) */
      /* _apporap Char(25) */
      /* _bRitorno := '' */
      _bRitorno = "";
      /* Case pTipo='C' */
      if (CPLib.eqr(pTipo,"C")) {
        for (MemoryCursorRow_allineacoint_mcrdef _row : mcValues._iterable_()) {
          /* If _row.SCELTO_new=1 and Empty(_row.NEWRAPPORTO_new) */
          if (CPLib.eqr(_row.SCELTO_new,1) && CPLib.Empty(_row.NEWRAPPORTO_new)) {
            /* _bRitorno := 'Errore nel rapporto con codice '+LRTrim(_row.RAPPORTO)+". E' stato selezionato ma non è stato inserito il nuovo codice rapporto" */
            _bRitorno = "Errore nel rapporto con codice "+CPLib.LRTrim(_row.RAPPORTO)+". E' stato selezionato ma non è stato inserito il nuovo codice rapporto";
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          /* If _row.SCELTO_new=0 and not(Empty(_row.NEWRAPPORTO_new)) */
          if (CPLib.eqr(_row.SCELTO_new,0) &&  ! (CPLib.Empty(_row.NEWRAPPORTO_new))) {
            /* _bRitorno := 'Errore nel rapporto con codice '+LRTrim(_row.RAPPORTO)+". E' stato inserito il nuovo codice rapporto ma non è stato confermato" */
            _bRitorno = "Errore nel rapporto con codice "+CPLib.LRTrim(_row.RAPPORTO)+". E' stato inserito il nuovo codice rapporto ma non è stato confermato";
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        }
        /* Case pTipo='U' */
      } else if (CPLib.eqr(pTipo,"U")) {
        for (MemoryCursorRow_allineacoint_mcrdef _row : mcValues._iterable_()) {
          /* If _row.SCELTO_new=1 and not(Empty(_row.NEWRAPPORTO_new)) */
          if (CPLib.eqr(_row.SCELTO_new,1) &&  ! (CPLib.Empty(_row.NEWRAPPORTO_new))) {
            /* Case _row.TIPO='R' */
            if (CPLib.eqr(_row.TIPO,"R")) {
              /* _apporap := '' */
              _apporap = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer),m_cServer,_row.NEWRAPPORTO_new);
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _apporap = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_allinea_cointestatari returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _apporap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_apporap)) */
              if (CPLib.Empty(CPLib.LRTrim(_apporap))) {
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("COINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RIFANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetDouble("PROGAET"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("FLGIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("DESCRI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("UNIQUER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
              } // End If
              /* _criga := 0 */
              _criga = CPLib.Round(0,0);
              // * --- Select from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              if (Cursor_aerighe!=null)
                Cursor_aerighe.Close();
              Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.NEWRAPPORTO_new)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_aerighe.Eof())) {
                /* _criga := aerighe->CPROWNUM */
                _criga = CPLib.Round(Cursor_aerighe.GetDouble("CPROWNUM"),0);
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
              /* _criga := _criga + 1 */
              _criga = CPLib.Round(_criga+1,0);
              // * --- Select from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              if (Cursor_aerighe!=null)
                Cursor_aerighe.Close();
              Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aerighe.Eof())) {
                // * --- Insert into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_criga,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("NRIGRIF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADTPRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDTPRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("PROGAER"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("DATESITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("RSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("ANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("PROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("PROG2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("PROGREC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("ESITOANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("FILEANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("ABBSALDI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
              // * --- Write into aestor from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aestor");
              m_cPhName = m_Ctx.GetPhName("aestor");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aestor",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000027")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aestor",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              // * --- Write into aecanc from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aecanc");
              m_cPhName = m_Ctx.GetPhName("aecanc");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aecanc",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000028")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aecanc",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              // * --- Write into aeannora from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeannora");
              m_cPhName = m_Ctx.GetPhName("aeannora");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000029")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              // * --- Delete from aerighe
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000002A")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.IDBASE,"?",0,0,m_cServer),m_cServer,_row.IDBASE)+"";
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
              // * --- Delete from aetesta
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000002B")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              /* Case _row.TIPO='D' */
            } else if (CPLib.eqr(_row.TIPO,"D")) {
              // * --- Write into aederig from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aederig");
              m_cPhName = m_Ctx.GetPhName("aederig");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              // * --- Write into aedestor from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aedestor");
              m_cPhName = m_Ctx.GetPhName("aedestor");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedestor",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aedestor",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              // * --- Write into aedecanc from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aedecanc");
              m_cPhName = m_Ctx.GetPhName("aedecanc");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedecanc",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000002E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aedecanc",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
            /* _gia202 := 0 */
            _gia202 = CPLib.Round(0,0);
            // * --- Select from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            if (Cursor_anarapbo!=null)
              Cursor_anarapbo.Close();
            Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.NEWRAPPORTO_new)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anarapbo.Eof())) {
              /* _gia202 := 1 */
              _gia202 = CPLib.Round(1,0);
              Cursor_anarapbo.Next();
            }
            m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
            Cursor_anarapbo.Close();
            // * --- End Select
            /* _gia501 := 0 */
            _gia501 = CPLib.Round(0,0);
            // * --- Select from jnarapbo
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            if (Cursor_jnarapbo!=null)
              Cursor_jnarapbo.Close();
            Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.NEWRAPPORTO_new)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jnarapbo.Eof())) {
              /* _gia501 := 1 */
              _gia501 = CPLib.Round(1,0);
              Cursor_jnarapbo.Next();
            }
            m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
            Cursor_jnarapbo.Close();
            // * --- End Select
            /* _old202 := 0 */
            _old202 = CPLib.Round(0,0);
            // * --- Select from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            if (Cursor_anarapbo!=null)
              Cursor_anarapbo.Close();
            Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anarapbo.Eof())) {
              /* _old202 := 1 */
              _old202 = CPLib.Round(1,0);
              Cursor_anarapbo.Next();
            }
            m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
            Cursor_anarapbo.Close();
            // * --- End Select
            /* _old501 := 0 */
            _old501 = CPLib.Round(0,0);
            // * --- Select from jnarapbo
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            if (Cursor_jnarapbo!=null)
              Cursor_jnarapbo.Close();
            Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jnarapbo.Eof())) {
              /* _old501 := 1 */
              _old501 = CPLib.Round(1,0);
              Cursor_jnarapbo.Next();
            }
            m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
            Cursor_jnarapbo.Close();
            // * --- End Select
            /* _gde501 := 0 */
            _gde501 = CPLib.Round(0,0);
            // * --- Select from jelegabo
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.NEWRAPPORTO_new)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jelegabo.Eof())) {
              /* _gde501 := 1 */
              _gde501 = CPLib.Round(1,0);
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            // * --- End Select
            /* _ode501 := 0 */
            _ode501 = CPLib.Round(0,0);
            // * --- Select from jelegabo
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jelegabo.Eof())) {
              /* _ode501 := 1 */
              _ode501 = CPLib.Round(1,0);
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            // * --- End Select
            /* If pAgg='X' or pAgg='1' */
            if (CPLib.eqr(pAgg,"X") || CPLib.eqr(pAgg,"1")) {
              /* If _gia202=1 and _old202=1 */
              if (CPLib.eqr(_gia202,1) && CPLib.eqr(_old202,1)) {
                // * --- Delete from anarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000044")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Delete from rapopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000045")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
                m_cSql = m_cSql+" and TIPOOPRAP <> "+CPSql.SQLValueAdapter(CPLib.ToSQLNull("25","?",0,0,m_cServer),m_cServer,"25")+"";
                m_cSql = m_cSql+" and TIPOOPRAP <> "+CPSql.SQLValueAdapter(CPLib.ToSQLNull("28","?",0,0,m_cServer),m_cServer,"28")+"";
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
              /* If _old202=1 */
              if (CPLib.eqr(_old202,1)) {
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  // * --- Insert into anarapbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anarapbo");
                  m_cPhName = m_Ctx.GetPhName("anarapbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000048")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000048(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
                // * --- Delete from anarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000049")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into delegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into rapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000004C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQLNull(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into operazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000004D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000004E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
            } // End If
            /* If pAgg='X' or pAgg='2' */
            if (CPLib.eqr(pAgg,"X") || CPLib.eqr(pAgg,"2")) {
              /* If _gia202=1 and _old202=1 */
              if (CPLib.eqr(_gia202,1) && CPLib.eqr(_old202,1)) {
                // * --- Delete from anarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000051")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Delete from rapopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000052")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
                m_cSql = m_cSql+" and TIPOOPRAP <> "+CPSql.SQLValueAdapter(CPLib.ToSQLNull("25","?",0,0,m_cServer),m_cServer,"25")+"";
                m_cSql = m_cSql+" and TIPOOPRAP <> "+CPSql.SQLValueAdapter(CPLib.ToSQLNull("28","?",0,0,m_cServer),m_cServer,"28")+"";
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
              /* If _old202=1 */
              if (CPLib.eqr(_old202,1)) {
                // * --- Select from jnarapbo
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                if (Cursor_jnarapbo!=null)
                  Cursor_jnarapbo.Close();
                Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,_row.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jnarapbo.Eof())) {
                  // * --- Insert into jnarapbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("jnarapbo");
                  m_cPhName = m_Ctx.GetPhName("jnarapbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000055")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000055(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_row.NEWRAPPORTO_new,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jnarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
                  Cursor_jnarapbo.Next();
                }
                m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
                Cursor_jnarapbo.Close();
                // * --- End Select
                // * --- Delete from jnarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000056")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into jntestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000057")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into jelegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000058")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into japopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"00000059")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQLNull(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"japopebo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
                // * --- Write into jperazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jperazbo");
                m_cPhName = m_Ctx.GetPhName("jperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_cointestatari",46,"0000005A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_row.NEWRAPPORTO_new,"C",25,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_row.RAPPORTO,"?",0,0,m_cServer),m_cServer,_row.RAPPORTO)+"";
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
              /* If _row.TIPO='D' and (_gia501=1 or _old501=1) and _gde501=0 and _ode501=0 */
              if (CPLib.eqr(_row.TIPO,"D") && (CPLib.eqr(_gia501,1) || CPLib.eqr(_old501,1)) && CPLib.eqr(_gde501,0) && CPLib.eqr(_ode501,0)) {
              } // End If
            } // End If
          } // End If
        }
        /* _bRitorno := 'Aggiornamento Completato' */
        _bRitorno = "Aggiornamento Completato";
      } // End Case
      /* Return _bRitorno */
      throw new Stop(_bRitorno);
    } finally {
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
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_allineacoint_mcrdef p_mcValues,String p_pTipo,String p_pAgg) {
    mcValues = p_mcValues;
    pTipo = p_pTipo;
    pAgg = p_pAgg;
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
  public String Run(MemoryCursor_allineacoint_mcrdef p_mcValues,String p_pTipo,String p_pAgg) {
    mcValues = p_mcValues;
    pTipo = p_pTipo;
    pAgg = p_pAgg;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
  public static arrt_allinea_cointestatariR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_cointestatariR(p_Ctx, p_Caller);
  }
  public static arrt_allinea_cointestatariR Make(CPContext p_Ctx) {
    return new arrt_allinea_cointestatariR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcValues = new MemoryCursor_allineacoint_mcrdef();
    pTipo = CPLib.Space(1);
    pAgg = CPLib.Space(1);
    _bRitorno = CPLib.Space(100);
    _row = new MemoryCursorRow_allineacoint_mcrdef();
    _criga = 0;
    _gia202 = 0;
    _gia501 = 0;
    _old202 = 0;
    _old501 = 0;
    _gde501 = 0;
    _ode501 = 0;
    _apporap = CPLib.Space(25);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_allinea_cointestatari,
  public static final String i_InvokedRoutines = ",arrt_allinea_cointestatari,";
  public static String[] m_cRunParameterNames={"mcValues","pTipo","pAgg"};
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"FLGIMP,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"UNIQUER,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"DATESITO,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"RSPEDITO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"ESITOANNO,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ABBSALDI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000048(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000055(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
}
