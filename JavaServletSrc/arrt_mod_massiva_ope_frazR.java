// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_mod_massiva_ope_frazR implements CallerWithObjs {
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
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
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
  public String cNewProg;
  public String cMaxOpe;
  public String cDip;
  public String _idreg;
  public String _flagrap2;
  public String stringaflagrap2;
  public MemoryCursor_operazbo MCoperazioni;
  public MemoryCursor_fraziobo MCfrazionate;
  public String _IDBASE2;
  public String gSblocco;
  public String gAzienda;
  public java.sql.Date gDataVaria;
  public double min;
  public double max;
  public double tot;
  public double start;
  public double end;
  public double inc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_mod_massiva_ope_frazR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_mod_massiva_ope_fraz",m_Caller);
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("min",p_cVarName)) {
      return min;
    }
    if (CPLib.eqr("max",p_cVarName)) {
      return max;
    }
    if (CPLib.eqr("tot",p_cVarName)) {
      return tot;
    }
    if (CPLib.eqr("start",p_cVarName)) {
      return start;
    }
    if (CPLib.eqr("end",p_cVarName)) {
      return end;
    }
    if (CPLib.eqr("inc",p_cVarName)) {
      return inc;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_mod_massiva_ope_fraz";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("cMaxOpe",p_cVarName)) {
      return cMaxOpe;
    }
    if (CPLib.eqr("cDip",p_cVarName)) {
      return cDip;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_IDBASE2",p_cVarName)) {
      return _IDBASE2;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
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
    if (CPLib.eqr("MCoperazioni",p_cVarName)) {
      return MCoperazioni;
    }
    if (CPLib.eqr("MCfrazionate",p_cVarName)) {
      return MCfrazionate;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("min",p_cVarName)) {
      min = value;
      return;
    }
    if (CPLib.eqr("max",p_cVarName)) {
      max = value;
      return;
    }
    if (CPLib.eqr("tot",p_cVarName)) {
      tot = value;
      return;
    }
    if (CPLib.eqr("start",p_cVarName)) {
      start = value;
      return;
    }
    if (CPLib.eqr("end",p_cVarName)) {
      end = value;
      return;
    }
    if (CPLib.eqr("inc",p_cVarName)) {
      inc = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("cMaxOpe",p_cVarName)) {
      cMaxOpe = value;
      return;
    }
    if (CPLib.eqr("cDip",p_cVarName)) {
      cDip = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_IDBASE2",p_cVarName)) {
      _IDBASE2 = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
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
    if (CPLib.eqr("MCoperazioni",p_cVarName)) {
      MCoperazioni = (MemoryCursor_operazbo)value;
      return;
    }
    if (CPLib.eqr("MCfrazionate",p_cVarName)) {
      MCfrazionate = (MemoryCursor_fraziobo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* Nuovo Progressivo */
    /* cNewProg Char(10) */
    /* cMaxOpe Char(10) */
    /* cDip Char(6) // Codice Dipendenza */
    /* _idreg Char(20) */
    /* _flagrap2 Char(1) */
    /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
    /* MCoperazioni MemoryCursor(operazbo) // MC delle operazioni */
    /* MCfrazionate MemoryCursor(fraziobo) // MC delle frazionate */
    /* _IDBASE2 Char(10) // IDBASE2 */
    /* gSblocco Char(1) // Sblocco controllo */
    /* gAzienda Char(10) // Azienda */
    /* gDataVaria Date // Data Variazione */
    /* min Numeric(10, 0) */
    /* max Numeric(10, 0) */
    /* tot Numeric(10, 0) */
    /* start Numeric(10, 0) */
    /* end Numeric(10, 0) */
    /* inc Numeric(10, 0) */
    /* inc := 50000 */
    inc = CPLib.Round(50000,0);
    /* Exec "operazioni" Page 2:Page_2 */
    Page_2();
    /* Exec "frazionate" Page 3:Page_3 */
    Page_3();
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000017;
      _h00000017 = new SPBridge.HMCaller();
      _h00000017.Set("m_cVQRList",m_cVQRList);
      _h00000017.Set("tbname","OPERAZBO");
      _h00000017.Set("fldname","PRGIMPOPE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000017,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* min := qbe_tab_mmc->min */
        min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* max := qbe_tab_mmc->max */
        max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* tot := qbe_tab_mmc->tot */
        tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* start := min */
      start = CPLib.Round(min,0);
      /* end := start+inc */
      end = CPLib.Round(start+inc,0);
      /* While end<tot */
      while (CPLib.lt(end,tot)) {
        /* end := start+inc */
        end = CPLib.Round(start+inc,0);
        // * --- Fill memory cursor MCoperazioni on operazbo
        MCoperazioni.Zap();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
        Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(start,"?",0,0,m_cServer, m_oParameters),m_cServer,start)+"  and  PRGIMPOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(end,"?",0,0,m_cServer, m_oParameters),m_cServer,end)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_operazbo;
          Cursor_operazbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_mod_massiva_ope_fraz: query on operazbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_operazbo.Eof())) {
          MCoperazioni.AppendBlank();
          MCoperazioni.row.IDBASE = Cursor_operazbo.GetString("IDBASE");
          MCoperazioni.row.NUMPROG = Cursor_operazbo.GetString("NUMPROG");
          MCoperazioni.row.DATAOPE = Cursor_operazbo.GetDate("DATAOPE");
          MCoperazioni.row.TIPOINTER = Cursor_operazbo.GetString("TIPOINTER");
          MCoperazioni.row.CODINTER = Cursor_operazbo.GetString("CODINTER");
          MCoperazioni.row.TIPOINF = Cursor_operazbo.GetString("TIPOINF");
          MCoperazioni.row.IDEREG = Cursor_operazbo.GetString("IDEREG");
          MCoperazioni.row.CODDIPE = Cursor_operazbo.GetString("CODDIPE");
          MCoperazioni.row.DESCCIT = Cursor_operazbo.GetString("DESCCIT");
          MCoperazioni.row.PROVINCIA = Cursor_operazbo.GetString("PROVINCIA");
          MCoperazioni.row.CODCAB = Cursor_operazbo.GetString("CODCAB");
          MCoperazioni.row.FLAGFRAZ = Cursor_operazbo.GetString("FLAGFRAZ");
          MCoperazioni.row.FLAGCONT = Cursor_operazbo.GetString("FLAGCONT");
          MCoperazioni.row.CODANA = Cursor_operazbo.GetString("CODANA");
          MCoperazioni.row.CODVOC = Cursor_operazbo.GetString("CODVOC");
          MCoperazioni.row.TIPOINT2 = Cursor_operazbo.GetString("TIPOINT2");
          MCoperazioni.row.CODINT2 = Cursor_operazbo.GetString("CODINT2");
          MCoperazioni.row.PAESE = Cursor_operazbo.GetString("PAESE");
          MCoperazioni.row.DESC2 = Cursor_operazbo.GetString("DESC2");
          MCoperazioni.row.PROV2 = Cursor_operazbo.GetString("PROV2");
          MCoperazioni.row.CODCAB2 = Cursor_operazbo.GetString("CODCAB2");
          MCoperazioni.row.DESCINTER = Cursor_operazbo.GetString("DESCINTER");
          MCoperazioni.row.RAPPORTO = Cursor_operazbo.GetString("RAPPORTO");
          MCoperazioni.row.FLAGRAP = Cursor_operazbo.GetString("FLAGRAP");
          MCoperazioni.row.TIPOLEG = Cursor_operazbo.GetString("TIPOLEG");
          MCoperazioni.row.DATAREG = Cursor_operazbo.GetDate("DATAREG");
          MCoperazioni.row.OPRAP = Cursor_operazbo.GetString("OPRAP");
          MCoperazioni.row.TIPOOPRAP = Cursor_operazbo.GetString("TIPOOPRAP");
          MCoperazioni.row.FLAGLIRE = Cursor_operazbo.GetString("FLAGLIRE");
          MCoperazioni.row.VALUTA = Cursor_operazbo.GetString("VALUTA");
          MCoperazioni.row.SEGNO = Cursor_operazbo.GetString("SEGNO");
          MCoperazioni.row.TOTLIRE = Cursor_operazbo.GetDouble("TOTLIRE");
          MCoperazioni.row.TOTCONT = Cursor_operazbo.GetDouble("TOTCONT");
          MCoperazioni.row.STATOREG = Cursor_operazbo.GetString("STATOREG");
          MCoperazioni.row.OPERAZMOD = Cursor_operazbo.GetString("OPERAZMOD");
          MCoperazioni.row.DATARETT = Cursor_operazbo.GetDate("DATARETT");
          MCoperazioni.row.CONNESCLI = Cursor_operazbo.GetString("CONNESCLI");
          MCoperazioni.row.CONNESOPER = Cursor_operazbo.GetString("CONNESOPER");
          MCoperazioni.row.CONNESBEN = Cursor_operazbo.GetString("CONNESBEN");
          MCoperazioni.row.COLLEG = Cursor_operazbo.GetString("COLLEG");
          MCoperazioni.row.CAMBIO = Cursor_operazbo.GetDouble("CAMBIO");
          MCoperazioni.row.RAPPORTBEN = Cursor_operazbo.GetString("RAPPORTBEN");
          MCoperazioni.row.FLAGRAP2 = Cursor_operazbo.GetString("FLAGRAP2");
          MCoperazioni.row.OPERATORE = Cursor_operazbo.GetString("OPERATORE");
          MCoperazioni.row.AUTOM = Cursor_operazbo.GetString("AUTOM");
          MCoperazioni.row.idcauana = Cursor_operazbo.GetString("idcauana");
          MCoperazioni.row.OPERAG = Cursor_operazbo.GetString("OPERAG");
          MCoperazioni.row.DOCFILE = Cursor_operazbo.GetString("DOCFILE");
          MCoperazioni.row.RESPINS = Cursor_operazbo.GetString("RESPINS");
          MCoperazioni.row.INFORM = Cursor_operazbo.GetString("INFORM");
          MCoperazioni.row.CDATOPE = Cursor_operazbo.GetString("CDATOPE");
          MCoperazioni.row.NOPROT = Cursor_operazbo.GetDouble("NOPROT");
          MCoperazioni.row.UCODE = Cursor_operazbo.GetString("UCODE");
          MCoperazioni.row.CDATAOPE = Cursor_operazbo.GetString("CDATAOPE");
          MCoperazioni.row.ZCPARTE = Cursor_operazbo.GetString("ZCPARTE");
          MCoperazioni.row.RAGIO = Cursor_operazbo.GetString("RAGIO");
          MCoperazioni.row.MODSVOL = Cursor_operazbo.GetString("MODSVOL");
          MCoperazioni.row.AREAGEO = Cursor_operazbo.GetString("AREAGEO");
          MCoperazioni.row.RIFIMP = Cursor_operazbo.GetString("RIFIMP");
          MCoperazioni.row.SCOPO = Cursor_operazbo.GetString("SCOPO");
          MCoperazioni.row.NATURA = Cursor_operazbo.GetString("NATURA");
          MCoperazioni.row.RTIPO = Cursor_operazbo.GetDouble("RTIPO");
          MCoperazioni.row.RCOMP = Cursor_operazbo.GetDouble("RCOMP");
          MCoperazioni.row.RIMP = Cursor_operazbo.GetDouble("RIMP");
          MCoperazioni.row.RFREQ = Cursor_operazbo.GetDouble("RFREQ");
          MCoperazioni.row.RRAGIO = Cursor_operazbo.GetDouble("RRAGIO");
          MCoperazioni.row.RAREA = Cursor_operazbo.GetDouble("RAREA");
          MCoperazioni.row.TIPO = Cursor_operazbo.GetString("TIPO");
          MCoperazioni.row.PRGIMPOPE = Cursor_operazbo.GetDouble("PRGIMPOPE");
          MCoperazioni.row.UNIQUECODE = Cursor_operazbo.GetString("UNIQUECODE");
          MCoperazioni.row.AMMONT = Cursor_operazbo.GetString("AMMONT");
          MCoperazioni.row.DURAT = Cursor_operazbo.GetString("DURAT");
          MCoperazioni.row.CONNALTRO = Cursor_operazbo.GetString("CONNALTRO");
          MCoperazioni.row.CONNESDOC = Cursor_operazbo.GetString("CONNESDOC");
          MCoperazioni.row.C_RAG = Cursor_operazbo.GetString("C_RAG");
          MCoperazioni.row.C_STA = Cursor_operazbo.GetString("C_STA");
          MCoperazioni.row.C_CTA = Cursor_operazbo.GetString("C_CTA");
          MCoperazioni.row.C_CAB = Cursor_operazbo.GetString("C_CAB");
          MCoperazioni.row.C_PRV = Cursor_operazbo.GetString("C_PRV");
          MCoperazioni.row.C_IND = Cursor_operazbo.GetString("C_IND");
          MCoperazioni.row.C_CAP = Cursor_operazbo.GetString("C_CAP");
          MCoperazioni.row.DATAIMP = Cursor_operazbo.GetDate("DATAIMP");
          MCoperazioni.row.C_RAPPORTO = Cursor_operazbo.GetString("C_RAPPORTO");
          MCoperazioni.row.PAGASOGOP = Cursor_operazbo.GetString("PAGASOGOP");
          MCoperazioni.row.MTCN = Cursor_operazbo.GetString("MTCN");
          MCoperazioni.row.IDFILE = Cursor_operazbo.GetString("IDFILE");
          MCoperazioni.row.CDATREG = Cursor_operazbo.GetString("CDATREG");
          MCoperazioni.row.IPCOLLEG = Cursor_operazbo.GetString("IPCOLLEG");
          MCoperazioni.row.ORACOLLEG = Cursor_operazbo.GetDateTime("ORACOLLEG");
          MCoperazioni.row.DUCOLLEG = Cursor_operazbo.GetDouble("DUCOLLEG");
          MCoperazioni.row.ANNOOPE = Cursor_operazbo.GetDouble("ANNOOPE");
          MCoperazioni.row.IDBASE2 = Cursor_operazbo.GetString("IDBASE2");
          MCoperazioni.row.IMPIN = Cursor_operazbo.GetDouble("IMPIN");
          MCoperazioni.row.IMPOUT = Cursor_operazbo.GetDouble("IMPOUT");
          MCoperazioni.row.MITIG = Cursor_operazbo.GetDouble("MITIG");
          MCoperazioni.row.MITIGDOC = Cursor_operazbo.GetString("MITIGDOC");
          MCoperazioni.row.RISGLOB = Cursor_operazbo.GetString("RISGLOB");
          MCoperazioni.row.SV58550 = Cursor_operazbo.GetString("SV58550");
          MCoperazioni.row.PROQUOTA = Cursor_operazbo.GetDouble("PROQUOTA");
          MCoperazioni.row.TIPOORO = Cursor_operazbo.GetString("TIPOORO");
          MCoperazioni.row.DAC6 = Cursor_operazbo.GetString("DAC6");
          MCoperazioni.row.FLAGDAC6 = Cursor_operazbo.GetDouble("FLAGDAC6");
          MCoperazioni.row.IMPSARA = Cursor_operazbo.GetDouble("IMPSARA");
          MCoperazioni.row.SV58550MA = Cursor_operazbo.GetString("SV58550MA");
          MCoperazioni.row.NOSARA = Cursor_operazbo.GetString("NOSARA");
          MCoperazioni.row.MEZPAG = Cursor_operazbo.GetString("MEZPAG");
          MCoperazioni.row.PRESTAZ = Cursor_operazbo.GetString("PRESTAZ");
          MCoperazioni.row.CAUSALE = Cursor_operazbo.GetDouble("CAUSALE");
          MCoperazioni.row.NUMIMP = Cursor_operazbo.GetDateTime("NUMIMP");
          MCoperazioni.row.DESPUNTO = Cursor_operazbo.GetString("DESPUNTO");
          MCoperazioni.row.CODCLICON = Cursor_operazbo.GetString("CODCLICON");
          MCoperazioni.row.TIPATT = Cursor_operazbo.GetString("TIPATT");
          MCoperazioni.row.IMPPROG = Cursor_operazbo.GetString("IMPPROG");
          MCoperazioni.row.NOTE = Cursor_operazbo.GetString("NOTE");
          MCoperazioni.row.VASP = Cursor_operazbo.GetString("VASP");
          Cursor_operazbo.Next();
        }
        m_cConnectivityError = Cursor_operazbo.ErrorMessage();
        Cursor_operazbo.Close();
        MCoperazioni.GoTop();
        /* Legge il vecchio record e ne crea uno nuovo */
        for (MemoryCursorRow_operazbo RWoperazioni : MCoperazioni._iterable_()) {
          /* If not(Empty(RWoperazioni.C_STA)) */
          if ( ! (CPLib.Empty(RWoperazioni.C_STA))) {
            /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
            cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
            /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
            stringaflagrap2 = "ABCDEFGHI";
            /* _flagrap2 := iif(Empty(RWoperazioni.FLAGRAP2) or RWoperazioni.FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(RWoperazioni.FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(RWoperazioni.FLAGRAP2) || CPLib.eqr(RWoperazioni.FLAGRAP2,"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(RWoperazioni.FLAGRAP2,stringaflagrap2)+1),1));
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.AMMONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CDATREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CONNALTRO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DATAIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DUCOLLEG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.DURAT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.IDFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.IPCOLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.MTCN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.ORACOLLEG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.PAGASOGOP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.PRGIMPOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWoperazioni.IDBASE2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWoperazioni.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWoperazioni.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              // * --- Insert into mogopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mogopebo");
              m_cPhName = m_Ctx.GetPhName("mogopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000028")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000028(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopebo",true);
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
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWoperazioni.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWoperazioni.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              // * --- Insert into mlientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mlientiope");
              m_cPhName = m_Ctx.GetPhName("mlientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientiope",true);
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
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            // * --- Select from beneficope
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            if (Cursor_beneficope!=null)
              Cursor_beneficope.Close();
            Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWoperazioni.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWoperazioni.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficope.Eof())) {
              // * --- Insert into meneficope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("meneficope");
              m_cPhName = m_Ctx.GetPhName("meneficope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficope",true);
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
              Cursor_beneficope.Next();
            }
            m_cConnectivityError = Cursor_beneficope.ErrorMessage();
            Cursor_beneficope.Close();
            // * --- End Select
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWoperazioni.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWoperazioni.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              // * --- Insert into merzistiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("merzistiope");
              m_cPhName = m_Ctx.GetPhName("merzistiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistiope",true);
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
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
            /* _IDBASE2 := LibreriaMit.UniqueId() // IDBASE2 */
            _IDBASE2 = LibreriaMit.UniqueId();
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(RWoperazioni.IDEREG,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDBASE2 = "+CPLib.ToSQL(_IDBASE2,"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL("O"+CPLib.Right(RWoperazioni.NUMPROG,9)+_IDBASE2,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(RWoperazioni.C_STA,"086")?"26":"AA"),"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL("3M","C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(RWoperazioni.IDBASE,"?",0,0,m_cServer),m_cServer,RWoperazioni.IDBASE)+"";
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
        }
        /* MCoperazioni.Zap() // MC delle operazioni */
        MCoperazioni.Zap();
        /* start := end+1 */
        start = CPLib.Round(end+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000033;
      _h00000033 = new SPBridge.HMCaller();
      _h00000033.Set("m_cVQRList",m_cVQRList);
      _h00000033.Set("tbname","FRAZIOBO");
      _h00000033.Set("fldname","PRGIMPFRZ");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000033,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* min := qbe_tab_mmc->min */
        min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* max := qbe_tab_mmc->max */
        max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* tot := qbe_tab_mmc->tot */
        tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* start := min */
      start = CPLib.Round(min,0);
      /* end := start+inc */
      end = CPLib.Round(start+inc,0);
      /* While end<tot */
      while (CPLib.lt(end,tot)) {
        // * --- Fill memory cursor MCfrazionate on fraziobo
        MCfrazionate.Zap();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(start,"?",0,0,m_cServer, m_oParameters),m_cServer,start)+"  and  PRGIMPOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(end,"?",0,0,m_cServer, m_oParameters),m_cServer,end)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_fraziobo;
          Cursor_fraziobo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_mod_massiva_ope_fraz: query on fraziobo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_fraziobo.Eof())) {
          MCfrazionate.AppendBlank();
          MCfrazionate.row.IDBASE = Cursor_fraziobo.GetString("IDBASE");
          MCfrazionate.row.NUMPROG = Cursor_fraziobo.GetString("NUMPROG");
          MCfrazionate.row.DATAOPE = Cursor_fraziobo.GetDate("DATAOPE");
          MCfrazionate.row.TIPOINTER = Cursor_fraziobo.GetString("TIPOINTER");
          MCfrazionate.row.CODINTER = Cursor_fraziobo.GetString("CODINTER");
          MCfrazionate.row.TIPOINF = Cursor_fraziobo.GetString("TIPOINF");
          MCfrazionate.row.IDEREG = Cursor_fraziobo.GetString("IDEREG");
          MCfrazionate.row.CODDIPE = Cursor_fraziobo.GetString("CODDIPE");
          MCfrazionate.row.DESCCIT = Cursor_fraziobo.GetString("DESCCIT");
          MCfrazionate.row.PROVINCIA = Cursor_fraziobo.GetString("PROVINCIA");
          MCfrazionate.row.CODCAB = Cursor_fraziobo.GetString("CODCAB");
          MCfrazionate.row.FLAGFRAZ = Cursor_fraziobo.GetString("FLAGFRAZ");
          MCfrazionate.row.FLAGCONT = Cursor_fraziobo.GetString("FLAGCONT");
          MCfrazionate.row.CODANA = Cursor_fraziobo.GetString("CODANA");
          MCfrazionate.row.CODVOC = Cursor_fraziobo.GetString("CODVOC");
          MCfrazionate.row.TIPOINT2 = Cursor_fraziobo.GetString("TIPOINT2");
          MCfrazionate.row.CODINT2 = Cursor_fraziobo.GetString("CODINT2");
          MCfrazionate.row.PAESE = Cursor_fraziobo.GetString("PAESE");
          MCfrazionate.row.DESC2 = Cursor_fraziobo.GetString("DESC2");
          MCfrazionate.row.PROV2 = Cursor_fraziobo.GetString("PROV2");
          MCfrazionate.row.CODCAB2 = Cursor_fraziobo.GetString("CODCAB2");
          MCfrazionate.row.DESCINTER = Cursor_fraziobo.GetString("DESCINTER");
          MCfrazionate.row.RAPPORTO = Cursor_fraziobo.GetString("RAPPORTO");
          MCfrazionate.row.FLAGRAP = Cursor_fraziobo.GetString("FLAGRAP");
          MCfrazionate.row.TIPOLEG = Cursor_fraziobo.GetString("TIPOLEG");
          MCfrazionate.row.DATAREG = Cursor_fraziobo.GetDate("DATAREG");
          MCfrazionate.row.OPRAP = Cursor_fraziobo.GetString("OPRAP");
          MCfrazionate.row.TIPOOPRAP = Cursor_fraziobo.GetString("TIPOOPRAP");
          MCfrazionate.row.FLAGLIRE = Cursor_fraziobo.GetString("FLAGLIRE");
          MCfrazionate.row.VALUTA = Cursor_fraziobo.GetString("VALUTA");
          MCfrazionate.row.SEGNO = Cursor_fraziobo.GetString("SEGNO");
          MCfrazionate.row.TOTLIRE = Cursor_fraziobo.GetDouble("TOTLIRE");
          MCfrazionate.row.TOTCONT = Cursor_fraziobo.GetDouble("TOTCONT");
          MCfrazionate.row.STATOREG = Cursor_fraziobo.GetString("STATOREG");
          MCfrazionate.row.OPERAZMOD = Cursor_fraziobo.GetString("OPERAZMOD");
          MCfrazionate.row.DATARETT = Cursor_fraziobo.GetDate("DATARETT");
          MCfrazionate.row.CONNESCLI = Cursor_fraziobo.GetString("CONNESCLI");
          MCfrazionate.row.CONNESOPER = Cursor_fraziobo.GetString("CONNESOPER");
          MCfrazionate.row.CONNESBEN = Cursor_fraziobo.GetString("CONNESBEN");
          MCfrazionate.row.COLLEG = Cursor_fraziobo.GetString("COLLEG");
          MCfrazionate.row.CAMBIO = Cursor_fraziobo.GetDouble("CAMBIO");
          MCfrazionate.row.RAPPORTBEN = Cursor_fraziobo.GetString("RAPPORTBEN");
          MCfrazionate.row.FLAGRAP2 = Cursor_fraziobo.GetString("FLAGRAP2");
          MCfrazionate.row.OPERATORE = Cursor_fraziobo.GetString("OPERATORE");
          MCfrazionate.row.AUTOM = Cursor_fraziobo.GetString("AUTOM");
          MCfrazionate.row.idcauana = Cursor_fraziobo.GetString("idcauana");
          MCfrazionate.row.OPERAG = Cursor_fraziobo.GetString("OPERAG");
          MCfrazionate.row.DOCFILE = Cursor_fraziobo.GetString("DOCFILE");
          MCfrazionate.row.RESPINS = Cursor_fraziobo.GetString("RESPINS");
          MCfrazionate.row.INFORM = Cursor_fraziobo.GetString("INFORM");
          MCfrazionate.row.CDATOPE = Cursor_fraziobo.GetString("CDATOPE");
          MCfrazionate.row.NOPROT = Cursor_fraziobo.GetDouble("NOPROT");
          MCfrazionate.row.UCODE = Cursor_fraziobo.GetString("UCODE");
          MCfrazionate.row.CDATAOPE = Cursor_fraziobo.GetString("CDATAOPE");
          MCfrazionate.row.ZCPARTE = Cursor_fraziobo.GetString("ZCPARTE");
          MCfrazionate.row.RAGIO = Cursor_fraziobo.GetString("RAGIO");
          MCfrazionate.row.MODSVOL = Cursor_fraziobo.GetString("MODSVOL");
          MCfrazionate.row.AREAGEO = Cursor_fraziobo.GetString("AREAGEO");
          MCfrazionate.row.RIFIMP = Cursor_fraziobo.GetString("RIFIMP");
          MCfrazionate.row.SCOPO = Cursor_fraziobo.GetString("SCOPO");
          MCfrazionate.row.NATURA = Cursor_fraziobo.GetString("NATURA");
          MCfrazionate.row.RTIPO = Cursor_fraziobo.GetDouble("RTIPO");
          MCfrazionate.row.RCOMP = Cursor_fraziobo.GetDouble("RCOMP");
          MCfrazionate.row.RIMP = Cursor_fraziobo.GetDouble("RIMP");
          MCfrazionate.row.RFREQ = Cursor_fraziobo.GetDouble("RFREQ");
          MCfrazionate.row.RRAGIO = Cursor_fraziobo.GetDouble("RRAGIO");
          MCfrazionate.row.RAREA = Cursor_fraziobo.GetDouble("RAREA");
          MCfrazionate.row.TIPO = Cursor_fraziobo.GetString("TIPO");
          MCfrazionate.row.PRGIMPFRZ = Cursor_fraziobo.GetDouble("PRGIMPFRZ");
          MCfrazionate.row.UNIQUECODE = Cursor_fraziobo.GetString("UNIQUECODE");
          MCfrazionate.row.AMMONT = Cursor_fraziobo.GetString("AMMONT");
          MCfrazionate.row.DURAT = Cursor_fraziobo.GetString("DURAT");
          MCfrazionate.row.CONNALTRO = Cursor_fraziobo.GetString("CONNALTRO");
          MCfrazionate.row.CONNESDOC = Cursor_fraziobo.GetString("CONNESDOC");
          MCfrazionate.row.C_RAG = Cursor_fraziobo.GetString("C_RAG");
          MCfrazionate.row.C_STA = Cursor_fraziobo.GetString("C_STA");
          MCfrazionate.row.C_CTA = Cursor_fraziobo.GetString("C_CTA");
          MCfrazionate.row.C_CAB = Cursor_fraziobo.GetString("C_CAB");
          MCfrazionate.row.C_PRV = Cursor_fraziobo.GetString("C_PRV");
          MCfrazionate.row.C_IND = Cursor_fraziobo.GetString("C_IND");
          MCfrazionate.row.C_CAP = Cursor_fraziobo.GetString("C_CAP");
          MCfrazionate.row.DATAIMP = Cursor_fraziobo.GetDate("DATAIMP");
          MCfrazionate.row.C_RAPPORTO = Cursor_fraziobo.GetString("C_RAPPORTO");
          MCfrazionate.row.PAGASOGOP = Cursor_fraziobo.GetString("PAGASOGOP");
          MCfrazionate.row.MTCN = Cursor_fraziobo.GetString("MTCN");
          MCfrazionate.row.IDFILE = Cursor_fraziobo.GetString("IDFILE");
          MCfrazionate.row.CDATREG = Cursor_fraziobo.GetString("CDATREG");
          MCfrazionate.row.IPCOLLEG = Cursor_fraziobo.GetString("IPCOLLEG");
          MCfrazionate.row.ORACOLLEG = Cursor_fraziobo.GetDateTime("ORACOLLEG");
          MCfrazionate.row.DUCOLLEG = Cursor_fraziobo.GetDouble("DUCOLLEG");
          MCfrazionate.row.ANNOOPE = Cursor_fraziobo.GetDouble("ANNOOPE");
          MCfrazionate.row.IDBASE2 = Cursor_fraziobo.GetString("IDBASE2");
          MCfrazionate.row.IMPIN = Cursor_fraziobo.GetDouble("IMPIN");
          MCfrazionate.row.IMPOUT = Cursor_fraziobo.GetDouble("IMPOUT");
          MCfrazionate.row.MITIG = Cursor_fraziobo.GetDouble("MITIG");
          MCfrazionate.row.MITIGDOC = Cursor_fraziobo.GetString("MITIGDOC");
          MCfrazionate.row.RISGLOB = Cursor_fraziobo.GetString("RISGLOB");
          MCfrazionate.row.SV58550 = Cursor_fraziobo.GetString("SV58550");
          MCfrazionate.row.PROQUOTA = Cursor_fraziobo.GetDouble("PROQUOTA");
          MCfrazionate.row.TIPOORO = Cursor_fraziobo.GetString("TIPOORO");
          MCfrazionate.row.DAC6 = Cursor_fraziobo.GetString("DAC6");
          MCfrazionate.row.FLAGDAC6 = Cursor_fraziobo.GetDouble("FLAGDAC6");
          MCfrazionate.row.IMPSARA = Cursor_fraziobo.GetDouble("IMPSARA");
          MCfrazionate.row.SV58550MA = Cursor_fraziobo.GetString("SV58550MA");
          MCfrazionate.row.NOSARA = Cursor_fraziobo.GetString("NOSARA");
          MCfrazionate.row.MEZPAG = Cursor_fraziobo.GetString("MEZPAG");
          MCfrazionate.row.PRESTAZ = Cursor_fraziobo.GetString("PRESTAZ");
          MCfrazionate.row.NUMIMP = Cursor_fraziobo.GetDateTime("NUMIMP");
          MCfrazionate.row.CAUSALE = Cursor_fraziobo.GetDouble("CAUSALE");
          MCfrazionate.row.DESPUNTO = Cursor_fraziobo.GetString("DESPUNTO");
          MCfrazionate.row.CODCLICON = Cursor_fraziobo.GetString("CODCLICON");
          MCfrazionate.row.TIPATT = Cursor_fraziobo.GetString("TIPATT");
          MCfrazionate.row.IMPPROG = Cursor_fraziobo.GetString("IMPPROG");
          MCfrazionate.row.NOTE = Cursor_fraziobo.GetString("NOTE");
          MCfrazionate.row.VASP = Cursor_fraziobo.GetString("VASP");
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        MCfrazionate.GoTop();
        /* Legge il vecchio record e ne crea uno nuovo */
        for (MemoryCursorRow_fraziobo RWfrazionate : MCfrazionate._iterable_()) {
          /* If not(Empty(RWfrazionate.C_STA)) */
          if ( ! (CPLib.Empty(RWfrazionate.C_STA))) {
            /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
            stringaflagrap2 = "JLMNOTUV?";
            /* _flagrap2 := iif(Empty(RWfrazionate.FLAGRAP2) or RWfrazionate.FLAGRAP2='Z',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(RWfrazionate.FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(RWfrazionate.FLAGRAP2) || CPLib.eqr(RWfrazionate.FLAGRAP2,"Z")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(RWfrazionate.FLAGRAP2,stringaflagrap2)+1),1));
            // * --- Insert into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000041")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CONNALTRO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DATAIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.C_RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.PAGASOGOP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.MTCN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.IDFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.CDATREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.IPCOLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.ORACOLLEG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.DUCOLLEG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RWfrazionate.IDBASE2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWfrazionate.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWfrazionate.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              // * --- Insert into mogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mogopefbo");
              m_cPhName = m_Ctx.GetPhName("mogopefbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopefbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopefbo",true);
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
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWfrazionate.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWfrazionate.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              // * --- Insert into mlientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mlientifrz");
              m_cPhName = m_Ctx.GetPhName("mlientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000045")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000045(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientifrz",true);
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
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
            // * --- Select from beneficfrz
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            if (Cursor_beneficfrz!=null)
              Cursor_beneficfrz.Close();
            Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWfrazionate.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWfrazionate.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficfrz.Eof())) {
              // * --- Insert into meneficfrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("meneficfrz");
              m_cPhName = m_Ctx.GetPhName("meneficfrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficfrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000047")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000047(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficfrz",true);
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
              Cursor_beneficfrz.Next();
            }
            m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
            Cursor_beneficfrz.Close();
            // * --- End Select
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(RWfrazionate.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,RWfrazionate.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              // * --- Insert into merzistifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("merzistifrz");
              m_cPhName = m_Ctx.GetPhName("merzistifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"00000049")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000049(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistifrz",true);
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
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
            /* _IDBASE2 := LibreriaMit.UniqueId() // IDBASE2 */
            _IDBASE2 = LibreriaMit.UniqueId();
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_mod_massiva_ope_fraz",20,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(RWfrazionate.IDEREG,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDBASE2 = "+CPLib.ToSQL(_IDBASE2,"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL("F"+CPLib.Right(RWfrazionate.NUMPROG,9)+_IDBASE2,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(RWfrazionate.C_STA,"086")?"26":"AA"),"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL("3M","C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(RWfrazionate.IDBASE,"?",0,0,m_cServer),m_cServer,RWfrazionate.IDBASE)+"";
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
        }
        /* MCoperazioni.Zap() // MC delle operazioni */
        MCoperazioni.Zap();
        /* start := end+1 */
        start = CPLib.Round(end+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_mod_massiva_ope_frazR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_mod_massiva_ope_frazR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cNewProg = CPLib.Space(10);
    cMaxOpe = CPLib.Space(10);
    cDip = CPLib.Space(6);
    _idreg = CPLib.Space(20);
    _flagrap2 = CPLib.Space(1);
    stringaflagrap2 = CPLib.Space(9);
    MCoperazioni = new MemoryCursor_operazbo();
    MCfrazionate = new MemoryCursor_fraziobo();
    _IDBASE2 = CPLib.Space(10);
    min = 0;
    max = 0;
    tot = 0;
    start = 0;
    end = 0;
    inc = 0;
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_tab_mmc,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000028(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000041(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000045(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000047(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000049(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistifrz",true);
    return p_cSql;
  }
}
