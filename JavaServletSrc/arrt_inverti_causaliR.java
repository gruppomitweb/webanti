// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_inverti_causaliR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
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
  public String analitica;
  public String sintetica;
  public String segno;
  public String analitica_new;
  public String sintetica_new;
  public String segno_new;
  public double _cont;
  public double _max;
  public double _cicli;
  public double _bottom;
  public double _top;
  public double _conta;
  public double _contar;
  public boolean scrivi;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_inverti_causaliR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_inverti_causali",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_cont",p_cVarName)) {
      return _cont;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_inverti_causali";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("analitica",p_cVarName)) {
      return analitica;
    }
    if (CPLib.eqr("sintetica",p_cVarName)) {
      return sintetica;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      return segno;
    }
    if (CPLib.eqr("analitica_new",p_cVarName)) {
      return analitica_new;
    }
    if (CPLib.eqr("sintetica_new",p_cVarName)) {
      return sintetica_new;
    }
    if (CPLib.eqr("segno_new",p_cVarName)) {
      return segno_new;
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
    if (CPLib.eqr("scrivi",p_cVarName)) {
      return scrivi;
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
    if (CPLib.eqr("_cont",p_cVarName)) {
      _cont = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("analitica",p_cVarName)) {
      analitica = value;
      return;
    }
    if (CPLib.eqr("sintetica",p_cVarName)) {
      sintetica = value;
      return;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      segno = value;
      return;
    }
    if (CPLib.eqr("analitica_new",p_cVarName)) {
      analitica_new = value;
      return;
    }
    if (CPLib.eqr("sintetica_new",p_cVarName)) {
      sintetica_new = value;
      return;
    }
    if (CPLib.eqr("segno_new",p_cVarName)) {
      segno_new = value;
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
    if (CPLib.eqr("scrivi",p_cVarName)) {
      scrivi = value;
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
    CPResultSet Cursor_qbe_max_cont_numprog_ope=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_qbe_max_cont_numprog_fraz=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_qbe_max_cont_numprog_xpe=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_qbe_max_cont_numprog_xraz=null;
    CPResultSet Cursor_xraziobo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* analitica Char(4) */
      /* sintetica Char(2) */
      /* segno Char(1) */
      /* analitica_new Char(4) */
      /* sintetica_new Char(2) */
      /* segno_new Char(1) */
      /* _cont Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _contar Numeric(15, 0) */
      /* scrivi Bool */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgImp := 'Inizio allineamento operazioni Archivio Unico. Operazione 1 di 4.' // Messaggio Import */
      gMsgImp = "Inizio allineamento operazioni Archivio Unico. Operazione 1 di 4.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_max_cont_numprog_ope
      if (Cursor_qbe_max_cont_numprog_ope!=null)
        Cursor_qbe_max_cont_numprog_ope.Close();
      Cursor_qbe_max_cont_numprog_ope = new VQRHolder("qbe_max_cont_numprog_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_cont_numprog_ope.Eof())) {
        /* _cont := qbe_max_cont_numprog_ope->cont */
        _cont = CPLib.Round(Cursor_qbe_max_cont_numprog_ope.GetDouble("cont"),0);
        /* _max := qbe_max_cont_numprog_ope->max */
        _max = CPLib.Round(Cursor_qbe_max_cont_numprog_ope.GetDouble("max"),0);
        Cursor_qbe_max_cont_numprog_ope.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_cont_numprog_ope.ErrorMessage();
      Cursor_qbe_max_cont_numprog_ope.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        /* scrivi := False  */
        scrivi = false;
        /* gMsgImp := "Allineamento operazioni Archivio Unico al "+LRTrim(Str((_bottom/_max)*100,5,2))+"%. Operazione 1 di 4" // Messaggio Import */
        gMsgImp = "Allineamento operazioni Archivio Unico al "+CPLib.LRTrim(CPLib.Str((_bottom/_max)*100,5,2))+"%. Operazione 1 di 4";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from operazbo
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
        Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,CODANA,CODVOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPOPE>= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  (CODANA='AA'  or  CODANA='26'  or  CODANA='48') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_operazbo.Eof())) {
          /* analitica := LRTrim(operazbo->CODANA) */
          analitica = CPLib.LRTrim(Cursor_operazbo.GetString("CODANA"));
          /* sintetica := LRTrim(operazbo->CODVOC) */
          sintetica = CPLib.LRTrim(Cursor_operazbo.GetString("CODVOC"));
          /* Case analitica='AA' */
          if (CPLib.eqr(analitica,"AA")) {
            /* analitica_new := 'AA' */
            analitica_new = "AA";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='48' */
          } else if (CPLib.eqr(analitica,"48")) {
            /* analitica_new := '26' */
            analitica_new = "26";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='26' */
          } else if (CPLib.eqr(analitica,"26")) {
            /* analitica_new := '48' */
            analitica_new = "48";
            /* scrivi := True */
            scrivi = true;
          } // End Case
          /* Case sintetica='3M' */
          if (CPLib.eqr(sintetica,"3M")) {
            /* sintetica_new := '4M' */
            sintetica_new = "4M";
            /* segno_new := 'A' */
            segno_new = "A";
            /* Case sintetica='4M' */
          } else if (CPLib.eqr(sintetica,"4M")) {
            /* sintetica_new := '3M' */
            sintetica_new = "3M";
            /* segno_new := 'D' */
            segno_new = "D";
          } // End Case
          /* If scrivi */
          if (scrivi) {
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inverti_causali",27,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(analitica_new,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(sintetica_new,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(segno_new,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
          Cursor_operazbo.Next();
        }
        m_cConnectivityError = Cursor_operazbo.ErrorMessage();
        Cursor_operazbo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Inizio allineamento frazionate Archivio Unico. Operazione 2 di 4.' // Messaggio Import */
      gMsgImp = "Inizio allineamento frazionate Archivio Unico. Operazione 2 di 4.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_max_cont_numprog_fraz
      if (Cursor_qbe_max_cont_numprog_fraz!=null)
        Cursor_qbe_max_cont_numprog_fraz.Close();
      Cursor_qbe_max_cont_numprog_fraz = new VQRHolder("qbe_max_cont_numprog_fraz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_cont_numprog_fraz.Eof())) {
        /* _cont := qbe_max_cont_numprog_fraz->cont */
        _cont = CPLib.Round(Cursor_qbe_max_cont_numprog_fraz.GetDouble("cont"),0);
        /* _max := qbe_max_cont_numprog_fraz->max */
        _max = CPLib.Round(Cursor_qbe_max_cont_numprog_fraz.GetDouble("max"),0);
        Cursor_qbe_max_cont_numprog_fraz.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_cont_numprog_fraz.ErrorMessage();
      Cursor_qbe_max_cont_numprog_fraz.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        /* scrivi := False  */
        scrivi = false;
        /* gMsgImp := "Allineamento frazionate Archivio Unico al "+LRTrim(Str((_bottom/_max)*100,5,2))+"%. Operazione 2 di 4" // Messaggio Import */
        gMsgImp = "Allineamento frazionate Archivio Unico al "+CPLib.LRTrim(CPLib.Str((_bottom/_max)*100,5,2))+"%. Operazione 2 di 4";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from fraziobo
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,CODANA,CODVOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPFRZ >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPFRZ <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  (CODANA='AA'  or  CODANA='26'  or  CODANA='48') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fraziobo.Eof())) {
          /* analitica := LRTrim(fraziobo->CODANA) */
          analitica = CPLib.LRTrim(Cursor_fraziobo.GetString("CODANA"));
          /* sintetica := LRTrim(fraziobo->CODVOC) */
          sintetica = CPLib.LRTrim(Cursor_fraziobo.GetString("CODVOC"));
          /* Case analitica='AA' */
          if (CPLib.eqr(analitica,"AA")) {
            /* analitica_new := 'AA' */
            analitica_new = "AA";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='48' */
          } else if (CPLib.eqr(analitica,"48")) {
            /* analitica_new := '26' */
            analitica_new = "26";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='26' */
          } else if (CPLib.eqr(analitica,"26")) {
            /* analitica_new := '48' */
            analitica_new = "48";
            /* scrivi := True */
            scrivi = true;
          } // End Case
          /* Case sintetica='3M' */
          if (CPLib.eqr(sintetica,"3M")) {
            /* sintetica_new := '4M' */
            sintetica_new = "4M";
            /* segno_new := 'A' */
            segno_new = "A";
            /* Case sintetica='4M' */
          } else if (CPLib.eqr(sintetica,"4M")) {
            /* sintetica_new := '3M' */
            sintetica_new = "3M";
            /* segno_new := 'D' */
            segno_new = "D";
          } // End Case
          /* If scrivi */
          if (scrivi) {
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inverti_causali",27,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(analitica_new,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(sintetica_new,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(segno_new,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Inizio allineamento operazioni Provvisorio. Operazione 3 di 4.' // Messaggio Import */
      gMsgImp = "Inizio allineamento operazioni Provvisorio. Operazione 3 di 4.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_max_cont_numprog_xpe
      if (Cursor_qbe_max_cont_numprog_xpe!=null)
        Cursor_qbe_max_cont_numprog_xpe.Close();
      Cursor_qbe_max_cont_numprog_xpe = new VQRHolder("qbe_max_cont_numprog_xpe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_cont_numprog_xpe.Eof())) {
        /* _cont := qbe_max_cont_numprog_xpe->cont */
        _cont = CPLib.Round(Cursor_qbe_max_cont_numprog_xpe.GetDouble("cont"),0);
        /* _max := qbe_max_cont_numprog_xpe->max */
        _max = CPLib.Round(Cursor_qbe_max_cont_numprog_xpe.GetDouble("max"),0);
        Cursor_qbe_max_cont_numprog_xpe.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_cont_numprog_xpe.ErrorMessage();
      Cursor_qbe_max_cont_numprog_xpe.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        /* scrivi := False  */
        scrivi = false;
        /* gMsgImp := "Allineamento operazioni Provvisorio al "+LRTrim(Str((_bottom/_max)*100,5,2))+"%. Operazione 3 di 4." // Messaggio Import */
        gMsgImp = "Allineamento operazioni Provvisorio al "+CPLib.LRTrim(CPLib.Str((_bottom/_max)*100,5,2))+"%. Operazione 3 di 4.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
        Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,CODANA,CODVOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  (CODANA='AA'  or  CODANA='26'  or  CODANA='48') "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xperazbo.Eof())) {
          /* analitica := LRTrim(xperazbo->CODANA) */
          analitica = CPLib.LRTrim(Cursor_xperazbo.GetString("CODANA"));
          /* sintetica := LRTrim(xperazbo->CODVOC) */
          sintetica = CPLib.LRTrim(Cursor_xperazbo.GetString("CODVOC"));
          /* Case analitica='AA' */
          if (CPLib.eqr(analitica,"AA")) {
            /* analitica_new := 'AA' */
            analitica_new = "AA";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='48' */
          } else if (CPLib.eqr(analitica,"48")) {
            /* analitica_new := '26' */
            analitica_new = "26";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='26' */
          } else if (CPLib.eqr(analitica,"26")) {
            /* analitica_new := '48' */
            analitica_new = "48";
            /* scrivi := True */
            scrivi = true;
          } // End Case
          /* Case sintetica='3M' */
          if (CPLib.eqr(sintetica,"3M")) {
            /* sintetica_new := '4M' */
            sintetica_new = "4M";
            /* segno_new := 'A' */
            segno_new = "A";
            /* Case sintetica='4M' */
          } else if (CPLib.eqr(sintetica,"4M")) {
            /* sintetica_new := '3M' */
            sintetica_new = "3M";
            /* segno_new := 'D' */
            segno_new = "D";
          } // End Case
          /* If scrivi */
          if (scrivi) {
            // * --- Write into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inverti_causali",27,"00000069")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(analitica_new,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(sintetica_new,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(segno_new,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xraziobo.GetString("IDBASE"))+"";
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
          Cursor_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
        Cursor_xperazbo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Inizio allineamento frazionate Provvisorio. Operazione 4 di 4.' // Messaggio Import */
      gMsgImp = "Inizio allineamento frazionate Provvisorio. Operazione 4 di 4.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_max_cont_numprog_xraz
      if (Cursor_qbe_max_cont_numprog_xraz!=null)
        Cursor_qbe_max_cont_numprog_xraz.Close();
      Cursor_qbe_max_cont_numprog_xraz = new VQRHolder("qbe_max_cont_numprog_xraz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_cont_numprog_xraz.Eof())) {
        /* _cont := qbe_max_cont_numprog_xraz->cont */
        _cont = CPLib.Round(Cursor_qbe_max_cont_numprog_xraz.GetDouble("cont"),0);
        /* _max := qbe_max_cont_numprog_xraz->max */
        _max = CPLib.Round(Cursor_qbe_max_cont_numprog_xraz.GetDouble("max"),0);
        Cursor_qbe_max_cont_numprog_xraz.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_cont_numprog_xraz.ErrorMessage();
      Cursor_qbe_max_cont_numprog_xraz.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        /* scrivi := False  */
        scrivi = false;
        /* gMsgImp := "Allineamento fazionate Provvisorio al "+LRTrim(Str((_bottom/_max)*100,5,2))+"%. Operazione 4 di 4." // Messaggio Import */
        gMsgImp = "Allineamento fazionate Provvisorio al "+CPLib.LRTrim(CPLib.Str((_bottom/_max)*100,5,2))+"%. Operazione 4 di 4.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from xraziobo
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
        Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,CODANA,CODVOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPFRZ >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPFRZ <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  (CODANA='AA'  or  CODANA='26'  or  CODANA='48') "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xraziobo.Eof())) {
          /* analitica := LRTrim(xraziobo->CODANA) */
          analitica = CPLib.LRTrim(Cursor_xraziobo.GetString("CODANA"));
          /* sintetica := LRTrim(xraziobo->CODVOC) */
          sintetica = CPLib.LRTrim(Cursor_xraziobo.GetString("CODVOC"));
          /* Case analitica='AA' */
          if (CPLib.eqr(analitica,"AA")) {
            /* analitica_new := 'AA' */
            analitica_new = "AA";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='48' */
          } else if (CPLib.eqr(analitica,"48")) {
            /* analitica_new := '26' */
            analitica_new = "26";
            /* scrivi := True */
            scrivi = true;
            /* Case analitica='26' */
          } else if (CPLib.eqr(analitica,"26")) {
            /* analitica_new := '48' */
            analitica_new = "48";
            /* scrivi := True */
            scrivi = true;
          } // End Case
          /* Case sintetica='3M' */
          if (CPLib.eqr(sintetica,"3M")) {
            /* sintetica_new := '4M' */
            sintetica_new = "4M";
            /* segno_new := 'A' */
            segno_new = "A";
            /* Case sintetica='4M' */
          } else if (CPLib.eqr(sintetica,"4M")) {
            /* sintetica_new := '3M' */
            sintetica_new = "3M";
            /* segno_new := 'D' */
            segno_new = "D";
          } // End Case
          /* If scrivi */
          if (scrivi) {
            // * --- Write into xraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inverti_causali",27,"00000087")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(analitica_new,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(sintetica_new,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(segno_new,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xraziobo.GetString("IDBASE"))+"";
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
          Cursor_xraziobo.Next();
        }
        m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
        Cursor_xraziobo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Fine allinemento' // Messaggio Import */
      gMsgImp = "Fine allinemento";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_max_cont_numprog_ope!=null)
          Cursor_qbe_max_cont_numprog_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_max_cont_numprog_fraz!=null)
          Cursor_qbe_max_cont_numprog_fraz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_max_cont_numprog_xpe!=null)
          Cursor_qbe_max_cont_numprog_xpe.Close();
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
        if (Cursor_qbe_max_cont_numprog_xraz!=null)
          Cursor_qbe_max_cont_numprog_xraz.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_inverti_causaliR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_inverti_causaliR(p_Ctx, p_Caller);
  }
  public void Blank() {
    analitica = CPLib.Space(4);
    sintetica = CPLib.Space(2);
    segno = CPLib.Space(1);
    analitica_new = CPLib.Space(4);
    sintetica_new = CPLib.Space(2);
    segno_new = CPLib.Space(1);
    _cont = 0;
    _max = 0;
    _cicli = 0;
    _bottom = 0;
    _top = 0;
    _conta = 0;
    _contar = 0;
    scrivi = false;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_max_cont_numprog_ope,qbe_max_cont_numprog_fraz,qbe_max_cont_numprog_xpe,qbe_max_cont_numprog_xraz,
  public static final String m_cVQRList = ",qbe_max_cont_numprog_ope,qbe_max_cont_numprog_fraz,qbe_max_cont_numprog_xpe,qbe_max_cont_numprog_xraz,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
