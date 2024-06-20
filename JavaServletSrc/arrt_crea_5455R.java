// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_crea_5455R implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public String w_NUMPROG;
  public String w_CONNESCLI;
  public String w_CONNESOPER;
  public String _noinf;
  public String cInfProg1;
  public String cInfProg2;
  public double nProgImp;
  public String cColleg;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _tipinter;
  public String _desinter;
  public String _idb2;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_crea_5455R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_crea_5455",m_Caller);
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_crea_5455";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      return w_CONNESCLI;
    }
    if (CPLib.eqr("CONNESOPER",p_cVarName)) {
      return w_CONNESOPER;
    }
    if (CPLib.eqr("_noinf",p_cVarName)) {
      return _noinf;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      return cColleg;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      return _citinter;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      return _prvinter;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
    }
    if (CPLib.eqr("_desinter",p_cVarName)) {
      return _desinter;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      w_CONNESCLI = value;
      return;
    }
    if (CPLib.eqr("CONNESOPER",p_cVarName)) {
      w_CONNESOPER = value;
      return;
    }
    if (CPLib.eqr("_noinf",p_cVarName)) {
      _noinf = value;
      return;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      cInfProg1 = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      cColleg = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      _citinter = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      _prvinter = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
      return;
    }
    if (CPLib.eqr("_desinter",p_cVarName)) {
      _desinter = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_rapotit=null;
    try {
      /* w_NUMPROG Char(11) */
      /* w_CONNESCLI Char(16) */
      /* w_CONNESOPER Char(16) */
      /* _noinf Char(1) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* cColleg Char(12) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _tipinter Char(2) */
      /* _desinter Char(70) */
      /* _idb2 Char(10) */
      /* gAzienda Char(10) // Azienda */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        /* _citinter := intermbo->DESCCIT */
        _citinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cabinter := intermbo->CODCAB */
        _cabinter = Cursor_intermbo.GetString("CODCAB");
        /* _prvinter := intermbo->PROVINCIA */
        _prvinter = Cursor_intermbo.GetString("PROVINCIA");
        /* _tipinter := intermbo->TIPINTER */
        _tipinter = Cursor_intermbo.GetString("TIPINTER");
        /* _desinter := intermbo->RAGSOC */
        _desinter = Cursor_intermbo.GetString("RAGSOC");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _noinf := 'S' */
      _noinf = "S";
      // * --- Select from rapotit
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      if (Cursor_rapotit!=null)
        Cursor_rapotit.Close();
      Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNESCLI)+"  and  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESOPER,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNESOPER)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapotit.Eof())) {
        /* If rapotit->TIPOOPRAP='51' or rapotit->TIPOOPRAP='53' */
        if (CPLib.eqr(Cursor_rapotit.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_rapotit.GetString("TIPOOPRAP"),"53")) {
          /* _noinf := 'N' */
          _noinf = "N";
        } // End If
        Cursor_rapotit.Next();
      }
      m_cConnectivityError = Cursor_rapotit.ErrorMessage();
      Cursor_rapotit.Close();
      // * --- End Select
      /* If _noinf='S' */
      if (CPLib.eqr(_noinf,"S")) {
        // * --- Select from rapotit
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
        Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMPROG)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapotit.Eof())) {
          /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* _idb2 := LibreriaMit.UniqueId() */
          _idb2 = LibreriaMit.UniqueId();
          /* cColleg := 'T'+cInfProg2 */
          cColleg = "T"+cInfProg2;
          // * --- Insert into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_5455",21,"00000027")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000027(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T"+CPLib.Right(cInfProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("54","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
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
          /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* _idb2 := LibreriaMit.UniqueId() */
          _idb2 = LibreriaMit.UniqueId();
          // * --- Insert into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_5455",21,"0000002D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000002D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T"+CPLib.Right(cInfProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("55","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
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
          Cursor_rapotit.Next();
        }
        m_cConnectivityError = Cursor_rapotit.ErrorMessage();
        Cursor_rapotit.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
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
      m_Caller.SetString("NUMPROG","C",11,0,w_NUMPROG);
      m_Caller.SetString("CONNESCLI","C",16,0,w_CONNESCLI);
      m_Caller.SetString("CONNESOPER","C",16,0,w_CONNESOPER);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_crea_5455R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_crea_5455R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",11,0);
    w_CONNESCLI = m_Caller.GetString("CONNESCLI","C",16,0);
    w_CONNESOPER = m_Caller.GetString("CONNESOPER","C",16,0);
    _noinf = CPLib.Space(1);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    nProgImp = 0;
    cColleg = CPLib.Space(12);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _tipinter = CPLib.Space(2);
    _desinter = CPLib.Space(70);
    _idb2 = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000027(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
}
