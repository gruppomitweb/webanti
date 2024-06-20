// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_riordina_infoR implements CallerWithObjs {
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
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_old_dataindex;
  public String m_cServer_old_dataindex;
  public String m_cPhName_old_praopebo;
  public String m_cServer_old_praopebo;
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
  public String w_frzuif;
  public String w_opeage;
  public String w_opeuif;
  public String w_rapage;
  public String w_rapuif;
  public String cProg;
  public String cIDBASE;
  public String cIdReg;
  public String cTipRap;
  public String cFlgRap;
  public double cPrgImp;
  public double _min;
  public double _max;
  public double _bottom;
  public double _top;
  public java.sql.Date _datareg;
  public double _contacilci;
  public double _cicli;
  public String gAzienda;
  public double _conta;
  public String gMsgAll;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_riordina_infoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_riordina_info",m_Caller);
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
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_old_dataindex = p_ContextObject.GetPhName("old_dataindex");
    if (m_cPhName_old_dataindex.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_old_dataindex = m_cPhName_old_dataindex+" "+m_Ctx.GetWritePhName("old_dataindex");
    }
    m_cServer_old_dataindex = p_ContextObject.GetServer("old_dataindex");
    m_cPhName_old_praopebo = p_ContextObject.GetPhName("old_praopebo");
    if (m_cPhName_old_praopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_old_praopebo = m_cPhName_old_praopebo+" "+m_Ctx.GetWritePhName("old_praopebo");
    }
    m_cServer_old_praopebo = p_ContextObject.GetServer("old_praopebo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      return cPrgImp;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
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
      return "arrt_riordina_info";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("frzuif",p_cVarName)) {
      return w_frzuif;
    }
    if (CPLib.eqr("opeage",p_cVarName)) {
      return w_opeage;
    }
    if (CPLib.eqr("opeuif",p_cVarName)) {
      return w_opeuif;
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
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
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
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      cPrgImp = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
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
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("frzuif",p_cVarName)) {
      w_frzuif = value;
      return;
    }
    if (CPLib.eqr("opeage",p_cVarName)) {
      w_opeage = value;
      return;
    }
    if (CPLib.eqr("opeuif",p_cVarName)) {
      w_opeuif = value;
      return;
    }
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
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
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
    CPResultSet Cursor_old_dataindex=null;
    CPResultSet Cursor_qbe_oldrapope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_frzuif Char(1) */
      /* w_opeage Char(1) */
      /* w_opeuif Char(1) */
      /* w_rapage Char(1) */
      /* w_rapuif Char(1) */
      /* Definizione Variabili locali */
      /* cProg Char(11) */
      /* cIDBASE Char(10) */
      /* cIdReg Char(20) */
      /* cTipRap Char(2) */
      /* cFlgRap Char(1) */
      /* cPrgImp Numeric(10, 0) */
      /* _min Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _datareg Date */
      /* _contacilci Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* gAzienda Char(10) // Azienda */
      /* _conta Numeric(15, 0) */
      /* gMsgAll Char(120) // Messaggio allineamento 1 */
      /* -- */
      /* Crea il file appoggio */
      /* Crea il file appoggio */
      /* gMsgAll := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
      gMsgAll = "Creazione Tabella appoggio per ricostruzione indici";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
      /* Cancella il file intestbo e scrive i record corretti */
      // * --- Write into cpwarn from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"0000001D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
      m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
      // * --- Write into cpwarn from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
      m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
      // * --- Write into cpwarn from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
      m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgAll := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
      gMsgAll = "Lettura Tabella appoggio per creazione indici";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
      // * --- Select from old_dataindex
      m_cServer = m_Ctx.GetServer("old_dataindex");
      m_cPhName = m_Ctx.GetPhName("old_dataindex");
      if (Cursor_old_dataindex!=null)
        Cursor_old_dataindex.Close();
      Cursor_old_dataindex = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("old_dataindex")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_old_dataindex.Eof())) {
        /* _datareg := old_dataindex->datareg */
        _datareg = Cursor_old_dataindex.GetDate("datareg");
        /* _min := old_dataindex->minimo */
        _min = CPLib.Round(Cursor_old_dataindex.GetDouble("minimo"),0);
        /* _max := old_dataindex->massimo */
        _max = CPLib.Round(Cursor_old_dataindex.GetDouble("massimo"),0);
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
        /* While _contacilci<=_cicli */
        while (CPLib.le(_contacilci,_cicli)) {
          /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
          /* _top := _contacilci * 5000 */
          _top = CPLib.Round(_contacilci*5000,0);
          // * --- Select from qbe_oldrapope
          if (Cursor_qbe_oldrapope!=null)
            Cursor_qbe_oldrapope.Close();
          Cursor_qbe_oldrapope = new VQRHolder("qbe_oldrapope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_oldrapope.Eof())) {
            /* cProg := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cIDBASE := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            /* cIdReg := DateToChar(qbe_oldrapope->DATAOPE)+cProg+'0' */
            cIdReg = CPLib.DateToChar(Cursor_qbe_oldrapope.GetDate("DATAOPE"))+cProg+"0";
            /* cFlgRap := '' */
            cFlgRap = "";
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oldrapope.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cFlgRap = Read_Cursor.GetString("TIPORAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_riordina_info returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cFlgRap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIdReg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_oldrapope.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_oldrapope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlgRap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_oldrapope.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_oldrapope.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_qbe_oldrapope.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetDate("DATAAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_oldrapope.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapopebo",true);
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
            /* cTipRap := qbe_oldrapope->TIPOOPRAP */
            cTipRap = Cursor_qbe_oldrapope.GetString("TIPOOPRAP");
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oldrapope.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If cTipRap = '23' or cTipRap = '35' or cTipRap = '45' or cTipRap = '37' */
              if (CPLib.eqr(cTipRap,"23") || CPLib.eqr(cTipRap,"35") || CPLib.eqr(cTipRap,"45") || CPLib.eqr(cTipRap,"37")) {
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetDouble("CPROWNUM"))+"";
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
                /* ElseIf cTipRap='26' or cTipRap='36' or cTipRap='46' or cTipRap = '38' */
              } else if (CPLib.eqr(cTipRap,"26") || CPLib.eqr(cTipRap,"36") || CPLib.eqr(cTipRap,"46") || CPLib.eqr(cTipRap,"38")) {
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina_info",54,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetDouble("CPROWNUM"))+"";
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
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* gMsgAll := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' informazioni su rapporti UIF' // Messaggio allineamento 1 */
            gMsgAll = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni su rapporti UIF";
            m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
            Cursor_qbe_oldrapope.Next();
          }
          m_cConnectivityError = Cursor_qbe_oldrapope.ErrorMessage();
          Cursor_qbe_oldrapope.Close();
          // * --- End Select
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
        Cursor_old_dataindex.Next();
      }
      m_cConnectivityError = Cursor_old_dataindex.ErrorMessage();
      Cursor_old_dataindex.Close();
      // * --- End Select
      /* gMsgAll := 'Ricostruzione Indici Terminata' // Messaggio allineamento 1 */
      gMsgAll = "Ricostruzione Indici Terminata";
      m_Ctx.SetGlobalString("gMsgAll",gMsgAll);
    } finally {
      try {
        if (Cursor_old_dataindex!=null)
          Cursor_old_dataindex.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oldrapope!=null)
          Cursor_qbe_oldrapope.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
      m_Caller.SetString("frzuif","C",1,0,w_frzuif);
      m_Caller.SetString("opeage","C",1,0,w_opeage);
      m_Caller.SetString("opeuif","C",1,0,w_opeuif);
      m_Caller.SetString("rapage","C",1,0,w_rapage);
      m_Caller.SetString("rapuif","C",1,0,w_rapuif);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_riordina_infoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_riordina_infoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_frzuif = m_Caller.GetString("frzuif","C",1,0);
    w_opeage = m_Caller.GetString("opeage","C",1,0);
    w_opeuif = m_Caller.GetString("opeuif","C",1,0);
    w_rapage = m_Caller.GetString("rapage","C",1,0);
    w_rapuif = m_Caller.GetString("rapuif","C",1,0);
    cProg = CPLib.Space(11);
    cIDBASE = CPLib.Space(10);
    cIdReg = CPLib.Space(20);
    cTipRap = CPLib.Space(2);
    cFlgRap = CPLib.Space(1);
    cPrgImp = 0;
    _min = 0;
    _max = 0;
    _bottom = 0;
    _top = 0;
    _datareg = CPLib.NullDate();
    _contacilci = 0;
    _cicli = 0;
    _conta = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgAll=m_Ctx.GetGlobalString("gMsgAll");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oldrapope,
  public static final String m_cVQRList = ",qbe_oldrapope,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
}
