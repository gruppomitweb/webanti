// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sistema1R implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_appointestbo;
  public String m_cServer_appointestbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
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
  public java.sql.Date w_datchi;
  public java.sql.Date w_datreg;
  public String w_msgproc;
  public String w_tipoarch;
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public double _conta;
  public String _idriga;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public double nProgImp;
  public String cInfProg1;
  public String cInfProg2;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public String gMsgImp;
  public String gAzienda;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sistema1R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sistema1",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_appointestbo = p_ContextObject.GetPhName("appointestbo");
    if (m_cPhName_appointestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_appointestbo = m_cPhName_appointestbo+" "+m_Ctx.GetWritePhName("appointestbo");
    }
    m_cServer_appointestbo = p_ContextObject.GetServer("appointestbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
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
      return "arrt_sistema1";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      return w_tipoarch;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      return _idriga;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      return w_datchi;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      return w_datreg;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
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
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      w_tipoarch = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      _idriga = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      w_datchi = value;
      return;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      w_datreg = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
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
    CPResultSet Cursor_qbe_sistema1=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_rapopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_datchi Date */
      /* w_datreg Date */
      /* w_msgproc Memo */
      /* w_tipoarch Char(1) // Tipo Archivio */
      /* _errlog Memo */
      /* imprec Numeric(10, 0) */
      /* _noprot Numeric(1, 0) */
      /* _rapold Char(25) */
      /* _tipoco Char(1) */
      /* _nriga Numeric(4, 0) */
      /* _newrow Numeric(4, 0) */
      /* _conta Numeric(10, 0) */
      /* _idriga Char(10) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* nProgImp Numeric(15, 0) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* _datini Date */
      /* _datfin Date */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gAzienda Char(10) // Azienda */
      /* gMsgProc Char(120) // Messaggio */
      /* Estrae dati per invio periodico */
      /* gMsgImp := 'Inizio importazione dati' // Messaggio Import */
      gMsgImp = "Inizio importazione dati";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      /* Apertuture da AUI */
      // * --- Select from qbe_sistema1
      if (Cursor_qbe_sistema1!=null)
        Cursor_qbe_sistema1.Close();
      Cursor_qbe_sistema1 = new VQRHolder("qbe_sistema1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_sistema1.Eof())) {
        /* imprec := imprec + 1 */
        imprec = CPLib.Round(imprec+1,0);
        /* _datini := NullDate() */
        _datini = CPLib.NullDate();
        /* _datfin := NullDate() */
        _datfin = CPLib.NullDate();
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_sistema1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _datini := intestbo->DATAINI */
          _datini = Cursor_intestbo.GetDate("DATAINI");
          /* _datfin := intestbo->DATAFINE */
          _datfin = Cursor_intestbo.GetDate("DATAFINE");
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
        cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* If qbe_sistema1->TIPOOPRAP='23' */
        if (CPLib.eqr(Cursor_qbe_sistema1.GetString("TIPOOPRAP"),"23")) {
          /* gMsgImp := "Creazione Informazione di chiusura n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
          gMsgImp = "Creazione Informazione di chiusura n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_sistema1.GetString("RAPPORTO"),"?",0,0)+"  and  TIPOOPRAP="+CPLib.ToSQL(Cursor_qbe_sistema1.GetString("TIPOOPRAP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_sistema1",139,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datfin,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datfin)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datfin,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datfin),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
          /* ElseIf qbe_sistema1->TIPOOPRAP='26' */
        } else if (CPLib.eqr(Cursor_qbe_sistema1.GetString("TIPOOPRAP"),"26")) {
          /* gMsgImp := "Creazione Informazione di apertura n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
          gMsgImp = "Creazione Informazione di apertura n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_sistema1.GetString("RAPPORTO"),"?",0,0)+"  and  TIPOOPRAP="+CPLib.ToSQL(Cursor_qbe_sistema1.GetString("TIPOOPRAP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_sistema1",139,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datini,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datini)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datini,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datini),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_sistema1.Next();
      }
      m_cConnectivityError = Cursor_qbe_sistema1.ErrorMessage();
      Cursor_qbe_sistema1.Close();
      // * --- End Select
      /* gMsgImp := 'Fine importazione dati. Totale Informazioni: '+LRTrim(Str(imprec,10,0)) // Messaggio Import */
      gMsgImp = "Fine importazione dati. Totale Informazioni: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_sistema1!=null)
          Cursor_qbe_sistema1.Close();
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
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
      m_Caller.SetDate("datchi","D",8,0,w_datchi);
      m_Caller.SetDate("datreg","D",8,0,w_datreg);
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetString("tipoarch","C",1,0,w_tipoarch);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sistema1R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sistema1R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_datchi = m_Caller.GetDate("datchi","D",8,0);
    w_datreg = m_Caller.GetDate("datreg","D",8,0);
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    w_tipoarch = m_Caller.GetString("tipoarch","C",1,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _conta = 0;
    _idriga = CPLib.Space(10);
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    nProgImp = 0;
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_sistema1,
  public static final String m_cVQRList = ",qbe_sistema1,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
