// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_save_multi_dl_dcR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_cgo_operazioni_dl_multi_dt;
  public String m_cServer_cgo_operazioni_dl_multi_dt;
  public String m_cPhName_cgo_operazioni_dl_multi_dt_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dt_dc;
  public String m_cPhName_cgo_aams_base;
  public String m_cServer_cgo_aams_base;
  public String m_cPhName_cgo_causali;
  public String m_cServer_cgo_causali;
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cgo_operazioni_dl_multi_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dc;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public String w_SNAINUMOPE;
  public String _gAzienda;
  public String _omulti;
  public double nProgImp;
  public String _tipinter;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String w_tipodest;
  public String cProgImp;
  public String _codana;
  public String _codsin;
  public String _segno;
  public String _tipope;
  public String _mezpagam;
  public String _rapporto;
  public String _tiporap;
  public String cOpeProg1;
  public String cOpeProg2;
  public String xData;
  public String abicab;
  public String xSNAINUMOPE;
  public String gCodDip;
  public String gIntemediario;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_save_multi_dl_dcR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_save_multi_dl_dc",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_cgo_operazioni_dl_multi_dt = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt");
    if (m_cPhName_cgo_operazioni_dl_multi_dt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt = m_cPhName_cgo_operazioni_dl_multi_dt+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt");
    }
    m_cServer_cgo_operazioni_dl_multi_dt = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt");
    m_cPhName_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt_dc");
    if (m_cPhName_cgo_operazioni_dl_multi_dt_dc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt_dc = m_cPhName_cgo_operazioni_dl_multi_dt_dc+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt_dc");
    }
    m_cServer_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt_dc");
    m_cPhName_cgo_aams_base = p_ContextObject.GetPhName("cgo_aams_base");
    if (m_cPhName_cgo_aams_base.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_aams_base = m_cPhName_cgo_aams_base+" "+m_Ctx.GetWritePhName("cgo_aams_base");
    }
    m_cServer_cgo_aams_base = p_ContextObject.GetServer("cgo_aams_base");
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali");
    if (m_cPhName_cgo_causali.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_causali = m_cPhName_cgo_causali+" "+m_Ctx.GetWritePhName("cgo_causali");
    }
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cgo_operazioni_dl_multi_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dc");
    if (m_cPhName_cgo_operazioni_dl_multi_dc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dc = m_cPhName_cgo_operazioni_dl_multi_dc+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dc");
    }
    m_cServer_cgo_operazioni_dl_multi_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dc");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
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
      return "arrt_cgo_save_multi_dl_dc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      return w_SNAINUMOPE;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_omulti",p_cVarName)) {
      return _omulti;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
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
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("cProgImp",p_cVarName)) {
      return cProgImp;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      return _codana;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      return _codsin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_mezpagam",p_cVarName)) {
      return _mezpagam;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("abicab",p_cVarName)) {
      return abicab;
    }
    if (CPLib.eqr("xSNAINUMOPE",p_cVarName)) {
      return xSNAINUMOPE;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      w_SNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_omulti",p_cVarName)) {
      _omulti = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
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
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("cProgImp",p_cVarName)) {
      cProgImp = value;
      return;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      _codana = value;
      return;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      _codsin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_mezpagam",p_cVarName)) {
      _mezpagam = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("abicab",p_cVarName)) {
      abicab = value;
      return;
    }
    if (CPLib.eqr("xSNAINUMOPE",p_cVarName)) {
      xSNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt_dc=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi_dc=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* w_SNAINUMOPE Char(15) */
      /* _gAzienda Char(15) */
      /* _omulti Char(1) */
      /* nProgImp Numeric(15, 0) */
      /* _tipinter Char(2) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* w_tipodest Char(1) */
      /* cProgImp Char(15) */
      /* _codana Char(4) */
      /* _codsin Char(2) */
      /* _segno Char(1) */
      /* _tipope Char(2) */
      /* _mezpagam Char(1) */
      /* _rapporto Char(25) */
      /* _tiporap Char(1) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* xData Char(8) */
      /* abicab Char(11) */
      /* xSNAINUMOPE Char(15) */
      /* gCodDip Char(6) // Dipendenza */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _tipinter := intermbo->TIPINTER */
        _tipinter = Cursor_intermbo.GetString("TIPINTER");
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        /* _citinter := intermbo->DESCCIT */
        _citinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cabinter := intermbo->CODCAB */
        _cabinter = Cursor_intermbo.GetString("CODCAB");
        /* _prvinter := intermbo->PROVINCIA */
        _prvinter = Cursor_intermbo.GetString("PROVINCIA");
        /* w_tipodest := intermbo->FLGTIPIMP */
        w_tipodest = Cursor_intermbo.GetString("FLGTIPIMP");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _omulti := 'S' */
      _omulti = "S";
      // * --- Select from cgo_operazioni_dl_multi_dt_dc
      m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
      if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
        Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      Cursor_cgo_operazioni_dl_multi_dt_dc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt_dc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_dl_multi_dt_dc.Eof())) {
        /* If cgo_operazioni_dl_multi_dt_dc->FLGFULL='N' */
        if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("FLGFULL"),"N")) {
          /* _omulti := 'N' */
          _omulti = "N";
        } // End If
        Cursor_cgo_operazioni_dl_multi_dt_dc.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt_dc.ErrorMessage();
      Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      // * --- End Select
      /* If _omulti='S' */
      if (CPLib.eqr(_omulti,"S")) {
        // * --- Select from cgo_operazioni_dl_multi_dc
        m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dc");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dc");
        if (Cursor_cgo_operazioni_dl_multi_dc!=null)
          Cursor_cgo_operazioni_dl_multi_dc.Close();
        Cursor_cgo_operazioni_dl_multi_dc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_dl_multi_dc.Eof())) {
          /* cProgImp := Utilities.GetAutonumber("PRGNUMOPE\'"+LRTrim(_gAzienda)+"'","",15) */
          cProgImp = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGNUMOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          /* _rapporto := '' */
          _rapporto = "";
          /* _tiporap := '' */
          _tiporap = "";
          /* If not(Empty(LRTrim(cgo_operazioni_dl_multi_dc->CODFISC))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODFISC"))))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODFISC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _rapporto := intestbo->RAPPORTO */
              _rapporto = Cursor_intestbo.GetString("RAPPORTO");
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _tiporap = Read_Cursor.GetString("TIPORAP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_cgo_save_multi_dl_dc returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _tiporap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* If Empty(LRTrim(_rapporto)) */
            if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODFISC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* _rapporto := xntestbo->RAPPORTO */
                _rapporto = Cursor_xntestbo.GetString("RAPPORTO");
                // * --- Read from xnarapbo
                m_cServer = m_Ctx.GetServer("xnarapbo");
                m_cPhName = m_Ctx.GetPhName("xnarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("RAPPORTO"));
                if (m_Ctx.IsSharedTemp("xnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _tiporap = Read_Cursor.GetString("TIPORAP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_cgo_save_multi_dl_dc returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _tiporap = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* _codana := '' */
          _codana = "";
          /* _codsin := '' */
          _codsin = "";
          /* _segno := '' */
          _segno = "";
          /* _tipope := '' */
          _tipope = "";
          /* _mezpagam := iif(LRTrim(cgo_operazioni_dl_multi_dc->MEZPAGAM) <> 'I' and LRTrim(cgo_operazioni_dl_multi_dc->MEZPAGAM) <> 'E' and LRTrim(cgo_operazioni_dl_multi_dc->MEZPAGAM) <> 'P','A',LRTrim(cgo_operazioni_dl_multi_dc->MEZPAGAM)) */
          _mezpagam = (CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dc.GetString("MEZPAGAM")),"I") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dc.GetString("MEZPAGAM")),"E") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dc.GetString("MEZPAGAM")),"P")?"A":CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dc.GetString("MEZPAGAM")));
          // * --- Read from cgo_causali
          m_cServer = m_Ctx.GetServer("cgo_causali");
          m_cPhName = m_Ctx.GetPhName("cgo_causali");
          m_cSql = "";
          m_cSql = m_cSql+"CACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CACODICE"),"N",5,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CACODICE"));
          m_cSql = m_cSql+" and CATIPOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_mezpagam,"C",2,0,m_cServer),m_cServer,_mezpagam);
          if (m_Ctx.IsSharedTemp("cgo_causali")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CACODANA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CACODSIN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CASEGNO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codana = Read_Cursor.GetString("CACODANA");
            _codsin = Read_Cursor.GetString("CACODSIN");
            _segno = Read_Cursor.GetString("CASEGNO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cgo_causali into routine arrt_cgo_save_multi_dl_dc returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codana = "";
            _codsin = "";
            _segno = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _codana <> '26' and _codana <> '48' and _codana <> 'AA' */
          if (CPLib.ne(_codana,"26") && CPLib.ne(_codana,"48") && CPLib.ne(_codana,"AA")) {
            /* _tipope := '10' */
            _tipope = "10";
          } else { // Else
            /* If _segno = 'D' */
            if (CPLib.eqr(_segno,"D")) {
              /* _tipope := '11' */
              _tipope = "11";
            } else { // Else
              /* _tipope := '12' */
              _tipope = "12";
            } // End If
          } // End If
          // * --- Insert into cgo_operazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_multi_dl_dc",47,"00000045")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000045(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("ASSEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CACODICE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDateTime("CADATAORA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CAFLGOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CAPV_COD"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CATIPCON"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CATIPGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CC4CIFRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CCANNSCA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CCDATSCA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CCMESSCA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni_dl_multi_dc.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("CFESTERO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDate("CGODATCON"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CGOESICON"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CGOFLGVLT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CGOFLGVNP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CGONOTCON"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CGOTIPOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("FLGDOCALL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("IBAN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PEP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProgImp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("VLTPLAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PEPDESCRI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("DOMICILIO2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("DESCCIT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PROVINCIA2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PAESE2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("FLGDOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("PROFESSIONE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("FLAGWALLET"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetDouble("IMPWALLET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODWALLET"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dc.GetString("CODTRANSZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni",true);
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
          // * --- Select from cgo_operazioni_dl_multi_dt_dc
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
          if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
            Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
          Cursor_cgo_operazioni_dl_multi_dt_dc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt_dc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl_multi_dt_dc.Eof())) {
            /* If not(Empty(LRTrim(cgo_operazioni_dl_multi_dt_dc->NUMOPEDL))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"))))) {
              /* xSNAINUMOPE := '' */
              xSNAINUMOPE = "";
              // * --- Read from cgo_operazioni
              m_cServer = m_Ctx.GetServer("cgo_operazioni");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
              m_cSql = "";
              m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"),"C",15,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"));
              if (m_Ctx.IsSharedTemp("cgo_operazioni")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SNAINUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xSNAINUMOPE = Read_Cursor.GetString("SNAINUMOPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on cgo_operazioni into routine arrt_cgo_save_multi_dl_dc returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xSNAINUMOPE = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(xSNAINUMOPE)) */
              if ( ! (CPLib.Empty(xSNAINUMOPE))) {
                // * --- Delete from cgo_operazioni
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_multi_dl_dc",47,"0000004B")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"))+"";
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
                // * --- Delete from cgo_operazioni_dl_multi_dt
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_multi_dl_dc",47,"0000004C")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"))+"";
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
                // * --- Delete from cgo_operazioni_dl_multi
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_multi_dl_dc",47,"0000004D")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"))+"";
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
            Cursor_cgo_operazioni_dl_multi_dt_dc.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt_dc.ErrorMessage();
          Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
          // * --- End Select
          Cursor_cgo_operazioni_dl_multi_dc.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dc.ErrorMessage();
        Cursor_cgo_operazioni_dl_multi_dc.Close();
        // * --- End Select
        /* Exec Routine arrt_snai_oper_save(cProgImp,'X',_gAzienda) */
        arrt_snai_oper_saveR.Make(m_Ctx,this).Run(cProgImp,"X",_gAzienda);
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
        if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
          Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl_multi_dc!=null)
          Cursor_cgo_operazioni_dl_multi_dc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_SNAINUMOPE,String p__gAzienda) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
    _gAzienda = p__gAzienda;
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
  public Forward Run(String p_w_SNAINUMOPE,String p__gAzienda) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
    _gAzienda = p__gAzienda;
    return Run();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_save_multi_dl_dcR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_save_multi_dl_dcR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_SNAINUMOPE = CPLib.Space(15);
    _gAzienda = CPLib.Space(15);
    _omulti = CPLib.Space(1);
    nProgImp = 0;
    _tipinter = CPLib.Space(2);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    w_tipodest = CPLib.Space(1);
    cProgImp = CPLib.Space(15);
    _codana = CPLib.Space(4);
    _codsin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _tipope = CPLib.Space(2);
    _mezpagam = CPLib.Space(1);
    _rapporto = CPLib.Space(25);
    _tiporap = CPLib.Space(1);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    xData = CPLib.Space(8);
    abicab = CPLib.Space(11);
    xSNAINUMOPE = CPLib.Space(15);
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_snai_oper_save,
  public static final String i_InvokedRoutines = ",arrt_snai_oper_save,";
  public static String[] m_cRunParameterNames={"w_SNAINUMOPE","_gAzienda"};
  protected static String GetFieldsName_00000045(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAFLGOPE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CC4CIFRE,";
    p_cSql = p_cSql+"CCANNSCA,";
    p_cSql = p_cSql+"CCDATSCA,";
    p_cSql = p_cSql+"CCMESSCA,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CGODATCON,";
    p_cSql = p_cSql+"CGODIPCOM,";
    p_cSql = p_cSql+"CGOESICON,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGONOTCON,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLGDOCALL,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMOPEDL,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOPEDL,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"VLTPLAT,";
    p_cSql = p_cSql+"PEPDESCRI,";
    p_cSql = p_cSql+"DOMICILIO2,";
    p_cSql = p_cSql+"DESCCIT2,";
    p_cSql = p_cSql+"PROVINCIA2,";
    p_cSql = p_cSql+"PAESE2,";
    p_cSql = p_cSql+"CAP2,";
    p_cSql = p_cSql+"FLGDOM,";
    p_cSql = p_cSql+"PROFESSIONE,";
    p_cSql = p_cSql+"FLAGWALLET,";
    p_cSql = p_cSql+"IMPWALLET,";
    p_cSql = p_cSql+"CODWALLET,";
    p_cSql = p_cSql+"CODTRANSZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni",true);
    return p_cSql;
  }
}
